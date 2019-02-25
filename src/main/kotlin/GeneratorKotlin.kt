fun List<DocSection>.toKotlinModels() = buildString {
    appendln(
        """import kotlinx.serialization.Optional
import kotlinx.serialization.Serializable

sealed class TelegramModel"""
    )
    this@toKotlinModels.forEach { section ->
        if (section.docTypes.isNotEmpty()) {
            appendln("\n\n// ${section.name}\n")
            section.docTypes.forEach { dataType ->
                appendln("@Serializable\ndata class ${dataType.name}(\n${dataType.docFields.map { f ->
                    "${if (f.required) "" else "@Optional "}val ${f.name}: ${f.toKotlinType()}"
                }.joinToString(",\n")}\n) : TelegramModel()")
            }
        }
    }
}

fun List<DocSection>.toKotlinApi() = buildString {
    this@toKotlinApi.forEach { section ->
        if (section.docMethods.isNotEmpty()) {
            appendln("\n\n// ${section.name}\n")
            section.docMethods.forEach { method ->
                appendln("fun ${method.name}(\n${method.docParameters.map { p ->
                    "${p.name}: ${p.toKotlinType()}"
                }.joinToString(",\n")}\n) = telegram()")
            }
        }
    }
}

private fun DocField.toKotlinType() = type.toKotlinType() + if (required) "" else "? = null"

private fun DocParameter.toKotlinType() = type.toKotlinType() + if (required) "" else "?"

private fun TelegramType.toKotlinType(): String = when (this) {
    is TelegramType.Declared -> name
    is TelegramType.ListType<*> -> "List<${elementType.toKotlinType()}>"
    TelegramType.Integer -> "Int"
    TelegramType.StringType -> "String"
    TelegramType.Boolean -> "Boolean"
    TelegramType.Float -> "Float"
    TelegramType.CallbackGame -> "Any"
    TelegramType.InputMedia -> "Any"
    TelegramType.InputFile -> "Any"
    TelegramType.InputMessageContent -> "Any"
    TelegramType.InlineQueryResult -> "Any"
    TelegramType.PassportElementError -> "Any"
    is TelegramType.WithAlternative -> {
        when (this) {
            // Example: TelegramType.WithAlternative.InputFileOrString -> if (alternative.isEmpty()) "v1" else "v2"
            TelegramType.WithAlternative.InputFileOrString -> "Any"
            TelegramType.WithAlternative.IntegerOrString -> "Any"
            TelegramType.WithAlternative.KeyboardOption -> "Any"
            TelegramType.WithAlternative.InputMediaPhotoOrVideo -> "Any"
        }
    }
}
