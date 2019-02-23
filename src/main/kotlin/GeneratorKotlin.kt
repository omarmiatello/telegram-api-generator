import java.io.File

fun List<Section>.toKotlin() {
    File("out/models.kt").writer().apply {
        write("""import kotlinx.serialization.Optional
import kotlinx.serialization.Serializable

sealed class TelegramModel
""")
        forEach { section ->
            if (section.types.isNotEmpty()) {
                write("\n\n// ${section.name}\n\n")
                section.types.forEach { dataType ->
                    write("@Serializable\ndata class ${dataType.name}(\n${dataType.fields.map { f ->
                        "${if (f.required) "" else "@Optional "}val ${f.name}: ${f.toKotlinType()}"
                    }.joinToString(",\n")}\n) : TelegramModel()\n\n")
                }
            }
        }
        close()
    }

    File("out/api.kt").writer().apply {
        forEach { section ->
            if (section.methods.isNotEmpty()) {
                write("\n\n// ${section.name}\n\n")
                section.methods.forEach { method ->
                    write("fun ${method.name}(\n${method.parameter.map { p ->
                        "${p.name}: ${p.toKotlinType()}"
                    }.joinToString(",\n")}\n) = telegram()\n")
                }
            }
        }
        close()
    }
}

private fun Field.toKotlinType() =  type.toKotlinType() + if (required) "" else "? = null"

private fun Parameter.toKotlinType() = type.toKotlinType() + if (required) "" else "?"

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