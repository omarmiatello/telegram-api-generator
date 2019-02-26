fun List<DocSection>.toKotlinModels() = buildString {
    appendln(
        """import kotlinx.serialization.Optional
import kotlinx.serialization.Serializable

sealed class TelegramModel"""
    )
    allSuper.forEach { dataType ->
        appendln("sealed class ${dataType.name} : TelegramModel()")
    }

    this@toKotlinModels.forEach { section ->
        if (section.docTypes.isNotEmpty()) {
            appendln("\n\n// ${section.name}\n")

            section.docTypes.forEach { dataType ->
                val telegramType = TelegramType.from(dataType.name) as TelegramType.Declared
                val superType = telegramType.superType ?: "TelegramModel"
                appendln("@Serializable\ndata class ${dataType.name}(\n${dataType.docFields.map { f ->
                    "${if (f.required) "" else "@Optional "}val ${f.name}: ${f.toKotlinType()}"
                }.joinToString(",\n")}\n) : $superType()")
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
