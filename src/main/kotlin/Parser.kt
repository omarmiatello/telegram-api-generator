import org.jsoup.nodes.Document
import org.jsoup.nodes.Element

data class DocSection(
    val name: String,
    val description: String,
    val docTypes: List<DocType>,
    val docMethods: List<DocMethod>
)

data class DocType(val name: String, val description: String, val docFields: List<DocField>)
data class DocField(val name: String, val description: String, val type: TelegramType, val required: Boolean)
data class DocMethod(val name: String, val description: String, val docParameters: List<DocParameter>)
data class DocParameter(val name: String, val description: String, val type: TelegramType, val required: Boolean)

fun Document.toSection(): List<DocSection> {
    val content = select("#dev_page_content").first()
    var splitBy = ""
    return content.children()
        .groupBy {
            if (it.tag().name == "h3") splitBy = it.text()
            splitBy
        }
        .mapValues<String, List<Element>, Map<String, List<Element>>> {
            splitBy = ""
            it.value.groupBy {
                if (it.tag().name == "h4") splitBy = it.text()
                splitBy
            }
        }
        .map { (h3, h3content) ->
            val validData = h3content.mapNotNull { (h4, h4content) ->
                var h4Desc = ""
                var docFields: List<DocField>? = null
                var docParameters: List<DocParameter>? = null
                h4content.forEach {
                    when (it.tag().name) {
                        "p" -> {
                            h4Desc += it.toString()
                            val text = it.text()
                            if ("Use this method" in text) docParameters = emptyList()
                        }
                        "table" -> {
                            val tableHead = it.child(0).text()
                            val tableData = it.child(1)
                            when {
                                "Field" in tableHead -> {
                                    // Field Type Description
                                    docFields = tableData.children().map {
                                        it.getElementsByTag("td").let {
                                            val fieldDesc = it[2].html()
                                            val type = it[1].text().fixTypeStrig()
                                            DocField(
                                                it[0].text(),
                                                fieldDesc,
                                                TelegramType.from(type),
                                                "Optional" !in fieldDesc
                                            )
                                        }
                                    }
                                }
                                "Parameter" in tableHead -> {
                                    // Parameter Type Required Description
                                    docParameters = tableData.children().map {
                                        it.getElementsByTag("td").let {
                                            val fieldDesc = it[3].html()
                                            val type = it[1].text().fixTypeStrig()
                                            DocParameter(
                                                it[0].text(),
                                                fieldDesc,
                                                TelegramType.from(type),
                                                "Yes" == it[2].text()
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
                val docMethod = docParameters?.let { DocMethod(h4, h4Desc, it) }
                if (docType != null && docMethod != null) error("hasTypes and hasMethods: $h4")
                docType ?: docMethod
            }
            DocSection(
                name = h3,
                description = h3content.getValue("").drop<Element?>(1).joinToString("\n"),
                docTypes = validData.filterIsInstance(DocType::class.java),
                docMethods = validData.filterIsInstance(DocMethod::class.java)
            )
        }
        .filterNot {
            val hasTypes = it.docTypes.isNotEmpty()
            val hasMethods = it.docMethods.isNotEmpty()
            !hasTypes && !hasMethods
        }
        .also { docSections ->
            // validate result
            val unknownTypes = docSections.findUnknownTypes()
            if (unknownTypes.isNotEmpty()) error("found unknownTypes: $unknownTypes")
        }
}

private fun String.fixTypeStrig() = when (this) {
    "Float number" -> "Float"
    "True" -> "Boolean"
    else -> this
}

private fun List<DocSection>.findUnknownTypes(): List<String> {
    val declaredTypeMap = this@findUnknownTypes.flatMap { it.docTypes }.associateBy { it.name }
    val unknownTypeInDocFields = declaredTypeMap.values.flatMap { type ->
        type.docFields.mapNotNull {
            it.type.getTypeWithoutGenerics().name.takeIf {
                it !in declaredTypeMap && TelegramType.from(it) is TelegramType.Declared
            }
        }
    }
    val unknownTypeInDocMethods = this@findUnknownTypes.flatMap {
        it.docMethods.flatMap {
            it.docParameters.mapNotNull {
                it.type.getTypeWithoutGenerics().name.takeIf {
                    it !in declaredTypeMap && TelegramType.from(it) is TelegramType.Declared
                }
            }
        }
    }
    return (unknownTypeInDocFields + unknownTypeInDocMethods).distinct()
}
