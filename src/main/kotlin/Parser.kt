import org.jsoup.nodes.Document
import org.jsoup.nodes.Element

data class DocSection(
    val name: String,
    val description: String,
    val docTypes: List<DocType>,
    val docMethods: List<DocMethod>
)

data class DocType(
    val name: String,
    val description: String,
    val docFields: List<DocField>
)

data class DocField(
    val name: String,
    val description: String,
    val type: TelegramType,
    val required: Boolean
)

data class DocMethod(
    val name: String,
    val description: String,
    val docParameters: List<DocParameter>,
    val returns: TelegramType
) {
    val docParametersSorded: List<DocParameter> = docParameters.sortedBy { !it.required }
}

data class DocParameter(
    val name: String,
    val description: String,
    val type: TelegramType,
    val required: Boolean
)

fun Document.toSection(): List<DocSection> {
    val returnsRegex = listOf(
        "((?:Array of )?\\S+) (?:objects? )?is returned".toRegex(),
        "[Rr]eturns .*?((?:Array of )?[A-Z]\\w+)".toRegex()
    )
    val content = select("#dev_page_content").first()!!
    var splitBy = ""
    return content.children()
        .groupBy {
            if (it.tag().name == "h3") splitBy = it.text()
            splitBy
        }
        .mapValues<String, List<Element>, Map<String, List<Element>>> { (_, value) ->
            splitBy = ""
            value.groupBy {
                if (it.tag().name == "h4") splitBy = it.text()
                splitBy
            }
        }
        .map { (h3, h3content) ->
            val validData = h3content.mapNotNull { (h4, h4content) ->
                var h4Desc = ""
                var docFields: List<DocField>? = null
                var docParameters: List<DocParameter>? = null
                var docReturns: TelegramType? = null
                h4content.forEach {
                    when (it.tag().name) {
                        "p" -> {
                            h4Desc += it.toString()
                            val text = it.text()
                            if ("Use this method" in text) docParameters = emptyList()
                            returnsRegex.firstOrNull { regex ->
                                val find = regex.find(text)
                                if (find != null) {
                                    docReturns = TelegramType.from(find.groups[1]!!.value.fixTypeString())
                                }
                                find != null
                            }
                        }
                        "table" -> {
                            val tableHead = it.child(0).text()
                            val tableData = it.child(1)
                            when {
                                "Field" in tableHead -> {
                                    // Field Type Description
                                    docFields = tableData.children().map { tableElement ->
                                        tableElement.getElementsByTag("td").let { tdElements ->
                                            val fieldDesc = tdElements[2].html()
                                            val name = tdElements[0].text()
                                            var type = tdElements[1].text().fixTypeString()
                                            if (name == "parse_mode" && type == "String") {
                                                type = "ParseMode"
                                            }
                                            DocField(
                                                name = name,
                                                description = fieldDesc.fixDescription(),
                                                type = TelegramType.from(type),
                                                required = "Optional" !in fieldDesc
                                            )
                                        }
                                    }
                                }
                                "Parameter" in tableHead -> {
                                    // Parameter Type Required Description
                                    docParameters = tableData.children().map { tableElement ->
                                        tableElement.getElementsByTag("td").let { tdElement ->
                                            val fieldDesc = tdElement[3].html()
                                            val name = tdElement[0].text()
                                            var type = tdElement[1].text().fixTypeString()
                                            if (name == "parse_mode" && type == "String") {
                                                type = "ParseMode"
                                            }
                                            DocParameter(
                                                name = name,
                                                description = fieldDesc.fixDescription(),
                                                type = TelegramType.from(type),
                                                required = "Yes" == tdElement[2].text()
                                            )
                                        }
                                    }
                                }
                            }
                        }
                        "blockquote" -> h4Desc += it.toString()
                        "ul" -> h4Desc += it.toString()
                    }
                }

                val docType = docFields?.let { DocType(h4, h4Desc, it) }
                val docMethod =
                    docParameters?.let { DocMethod(h4, h4Desc, it, docReturns ?: error("Missing returns for $h4")) }
                if (docType != null && docMethod != null) error("hasTypes and hasMethods: $h4")
                docType ?: docMethod
            }
            DocSection(
                name = h3,
                description = h3content.getValue("").drop<Element?>(1).joinToString("\n").fixDescription(),
                docTypes = validData.filterIsInstance(DocType::class.java),
                docMethods = validData.filterIsInstance(DocMethod::class.java)
            )
        }
        .filterNot { section ->
            val hasTypes = section.docTypes.isNotEmpty()
            val hasMethods = section.docMethods.isNotEmpty()
            !hasTypes && !hasMethods
        }
        .also { sections ->
            // validate result
            val unknownTypes = sections.findUnknownTypes()
            if (unknownTypes.isNotEmpty()) error("found unknownTypes: $unknownTypes")
        }
}

private fun String.fixTypeString() = when (this) {
    "InlineKeyboardMarkup or ReplyKeyboardMarkup or ReplyKeyboardRemove or ForceReply" -> "KeyboardOption"
    "Array of InputMediaAudio, InputMediaDocument, InputMediaPhoto and InputMediaVideo" -> "Array of InputMedia"
    "InputFile or String" -> "InputFileOrString"
    "Integer or String" -> "IntegerOrString"
    "Messages" -> "Array of Message"
    "sent" -> "Array of Message"
    "messages" -> "Array of MessageId"
    "list" -> "Array of BotCommand"
    "Float number" -> "Float"
    "results" -> "Poll"
    "True" -> "Boolean"
    else -> this
}

private fun String.fixDescription() = replace('‘' ,'\'')


private fun List<DocSection>.findUnknownTypes(): List<String> {
    val declaredTypeMap = flatMap { section -> section.docTypes }.associateBy { type -> type.name }
    val unknownTypeInDocFields = declaredTypeMap.values.flatMap { type ->
        type.docFields.mapNotNull { field ->
            field.type.getTypeWithoutGenerics().name.takeIf { typeName ->
                typeName !in declaredTypeMap && TelegramType.from(typeName) is TelegramType.Declared
            }
        }
    }
    val unknownTypeInDocMethods = flatMap { section ->
        section.docMethods.flatMap { method ->
            method.docParameters.mapNotNull { parameter ->
                parameter.type.getTypeWithoutGenerics().name.takeIf { typeName ->
                    typeName !in declaredTypeMap && TelegramType.from(typeName) is TelegramType.Declared
                }
            }
        }
    }
    return (unknownTypeInDocFields + unknownTypeInDocMethods).distinct()
}
