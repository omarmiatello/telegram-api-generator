import java.io.File

fun List<DocSection>.toKotlin() {
    File("out/models.kt").writer().apply {
        write("""import kotlinx.serialization.Optional
import kotlinx.serialization.Serializable

sealed class TelegramModel
""")
        forEach { section ->
            if (section.docTypes.isNotEmpty()) {
                write("\n\n// ${section.name}\n\n")
                section.docTypes.forEach { dataType ->
                    write("@Serializable\ndata class ${dataType.name}(\n${dataType.docFields.map { f ->
                        "${if (f.required) "" else "@Optional "}val ${f.name}: ${f.toKotlinType()}"
                    }.joinToString(",\n")}\n) : TelegramModel()\n\n")
                }
            }
        }
        close()
    }

    File("out/api.kt").writer().apply {
        forEach { section ->
            if (section.docMethods.isNotEmpty()) {
                write("\n\n// ${section.name}\n\n")
                section.docMethods.forEach { method ->
                    write("fun ${method.name}(\n${method.docParameters.map { p ->
                        "${p.name}: ${p.toKotlinType()}"
                    }.joinToString(",\n")}\n) = telegram()\n")
                }
            }
        }
        close()
    }
}

private fun DocField.toKotlinType() =  type.toKotlinType() + if (required) "" else "? = null"

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