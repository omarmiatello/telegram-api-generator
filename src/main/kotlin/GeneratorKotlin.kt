fun List<DocSection>.toKotlinModels() = buildString {
    appendln(
        """import kotlinx.serialization.Optional
import kotlinx.serialization.Serializable

sealed class TelegramModel"""
    )
    TelegramType.allSuper.forEach { dataType ->
        appendln("sealed class ${dataType.name} : TelegramModel()")
    }

    this@toKotlinModels.forEach { section ->
        if (section.docTypes.isNotEmpty()) {
            appendln("\n\n// ${section.name}\n")

            section.docTypes.forEach { dataType ->
                val telegramType = TelegramType.from(dataType.name) as TelegramType.Declared
                val superType = telegramType.superType ?: "TelegramModel"
                val docsParam =
                    "\n *\n" + dataType.docFields.joinToString("\n") { " * @property ${it.name} ${it.description}" }
                val docs = """/**
 * ${dataType.description}$docsParam
 *
 * @constructor Creates a: ${dataType.name}.
 * */"""
                val parameters = dataType.docFields.joinToString(",\n") { f ->
                    val type = f.toKotlinType()
                    val needContextualSerialization = type == "Any" || type == "Any?"
                    if (needContextualSerialization) "@ContextualSerialization val ${f.name}: $type" else "val ${f.name}: $type"
                }
                appendln("$docs\n@Serializable\ndata class ${dataType.name}(\n$parameters\n) : $superType()")
            }
        }
    }
}

fun List<DocSection>.toKotlinMethods() = buildString {
    appendln(
        """import kotlinx.serialization.Optional
import kotlinx.serialization.Serializable

sealed class TelegramRequest {"""
    )
    this@toKotlinMethods.forEach { section ->
        if (section.docMethods.isNotEmpty()) {
            appendln("\n\n    // ${section.name}\n")
            section.docMethods.forEach methods@{ method ->
                if (method.docParameters.isEmpty()) return@methods
                val parameters = method.docParameters.joinToString(",\n") { f ->
                    val type = f.toKotlinType()
                    val needContextualSerialization = type == "Any" || type == "Any? = null"
                    if (needContextualSerialization) "@ContextualSerialization val ${f.name}: $type" else "val ${f.name}: $type"
                }
                appendln("@Serializable\ndata class ${method.name.capitalize()}Request(\n$parameters\n) : TelegramRequest()")

            }
        }
    }
    appendln("}\n")
    appendln("object TelegramMethod {")
    this@toKotlinMethods.forEach { section ->
        if (section.docMethods.isNotEmpty()) {
            appendln("\n\n    // ${section.name}\n")
            section.docMethods.forEach { method ->
                val docsParam =
                    "\n *\n" + method.docParameters.map { " * @property ${it.name} ${it.description}" }.joinToString("\n")
                val docs = """/**
 * ${method.description}$docsParam
 *
 * @return [${method.returns.toKotlinType()}]
 * */"""
                val parameters = method.docParameters.map { f -> f.name }.joinToString(",\n")
                if (parameters.isEmpty()) {
                    appendln(
                        "fun ${method.name}() = telegram(\n" +
                                "\"\$basePath/${method.name}\",\n" +
                                "${method.returns.toKotlinType()}.serializer()\n)"
                    )
                } else {
                    appendln(
                        """$docs
    fun ${method.name}(
${method.docParameters.joinToString(",\n") { p ->
                            "${p.name}: ${p.toKotlinType()}"
                        }}
    ) = telegram(
        "${"$"}basePath/${method.name}",
        TelegramRequest.${method.name.capitalize()}Request($parameters).toJsonContent(TelegramRequest.${method.name.capitalize()}Request.serializer()),
        ${method.returns.toKotlinType()}.serializer()
    )"""
                    )
                }
            }
        }
    }
    appendln("}")
}

private fun DocField.toKotlinType() = type.toKotlinType() + if (required) "" else "? = null"

private fun DocParameter.toKotlinType() = type.toKotlinType() + if (required) "" else "? = null"

private fun TelegramType.toKotlinType(): String = when (this) {
    is TelegramType.Declared -> name
    is TelegramType.ListType<*> -> "List<${elementType.toKotlinType()}>"
    TelegramType.Integer -> "Int"
    TelegramType.StringType -> "String"
    TelegramType.Boolean -> "Boolean"
    TelegramType.Float -> "Float"
    TelegramType.CallbackGame,
    TelegramType.InputFile -> "Any"
    is TelegramType.Super -> {
        when (this) {
            TelegramType.Super.InputMedia,
            TelegramType.Super.InputMessageContent,
            TelegramType.Super.InlineQueryResult,
            TelegramType.Super.PassportElementError -> name
        }
    }
    is TelegramType.WithAlternative -> {
        when (this) {
            // Example: TelegramType.WithAlternative.InputFileOrString -> if (validTypes.isEmpty()) "v1" else "v2"
            TelegramType.WithAlternative.InputFileOrString,
            TelegramType.WithAlternative.IntegerOrString,
            TelegramType.WithAlternative.KeyboardOption,
            TelegramType.WithAlternative.InputMediaPhotoOrVideo -> "Any"
        }
    }
}
