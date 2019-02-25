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
                }.joinToString(",\n")}\n) : TelegramModel()\n")
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

private fun String.toKotlinType(): String = when (this) {
    "Integer" -> "Int"
    "String" -> "String"
    "Boolean" -> "Boolean"
    "Float" -> "Float"
    "CallbackGame" -> "Any"
    "InputFile or String" -> "Any"
    "InputMessageContent" -> "Any"
    "InputFile" -> "Any"
    "Integer or String" -> "Any"
    "InlineKeyboardMarkup or ReplyKeyboardMarkup or ReplyKeyboardRemove or ForceReply" -> "Any"
    "InputMediaPhoto and InputMediaVideo" -> "Any"
    "InputMedia" -> "Any"
    "InlineQueryResult" -> "Any"
    "PassportElementError" -> "Any"
    else -> {
        if ("List<" in this) {
            val type = replace("List<", "")
            replace(type, type.toKotlinType())
        } else this
    }
}