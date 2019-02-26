val allSuper = listOf(
    TelegramType.Super.InputMedia,
    TelegramType.Super.InputMessageContent,
    TelegramType.Super.InlineQueryResult,
    TelegramType.Super.PassportElementError
)

sealed class TelegramType(val name: String) {

    class Declared(docName: String) : TelegramType(docName) {
        val superType = allSuper.firstOrNull { docName.startsWith(it.name) }
    }

    class ListType<T : TelegramType>(val elementType: T) : TelegramType("List<$elementType>")

    object Integer : TelegramType("Integer")
    object StringType : TelegramType("String")
    object Boolean : TelegramType("Boolean")
    object Float : TelegramType("Float")
    object CallbackGame : TelegramType("CallbackGame")
    object InputFile : TelegramType("InputFile")

    sealed class Super(name: String) : TelegramType(name) {
        object InputMedia : Super("InputMedia")
        object InputMessageContent : Super("InputMessageContent")
        object InlineQueryResult : Super("InlineQueryResult")
        object PassportElementError : Super("PassportElementError")
    }

    sealed class WithAlternative(name: String, val validTypes: List<TelegramType>) : TelegramType(name) {
        object InputFileOrString : WithAlternative(
            "InputFile or String",
            listOf(
                TelegramType.InputFile,
                TelegramType.StringType
            )
        )

        object IntegerOrString : WithAlternative(
            "Integer or String",
            listOf(
                TelegramType.Integer,
                TelegramType.StringType
            )
        )

        object KeyboardOption : WithAlternative(
            "InlineKeyboardMarkup or ReplyKeyboardMarkup or ReplyKeyboardRemove or ForceReply",
            listOf(
                Declared("InlineKeyboardMarkup"),
                Declared("ReplyKeyboardMarkup"),
                Declared("ReplyKeyboardRemove"),
                Declared("ForceReply")
            )
        )

        object InputMediaPhotoOrVideo : WithAlternative(
            "InputMediaPhoto and InputMediaVideo",
            listOf(
                Declared("InputMediaPhoto"),
                Declared("InputMediaVideo")
            )
        )
    }

    override fun toString() = name

    fun getTypeWithoutGenerics(): TelegramType = if (this is ListType<*>) elementType.getTypeWithoutGenerics() else this

    companion object {
        fun from(type: String): TelegramType = when (type) {
            "Integer" -> TelegramType.Integer
            "String" -> TelegramType.StringType
            "Boolean" -> TelegramType.Boolean
            "Float" -> TelegramType.Float
            "CallbackGame" -> TelegramType.CallbackGame
            "InputMedia" -> TelegramType.Super.InputMedia
            "InputFile" -> TelegramType.InputFile
            "InputMessageContent" -> TelegramType.Super.InputMessageContent
            "InlineQueryResult" -> TelegramType.Super.InlineQueryResult
            "PassportElementError" -> TelegramType.Super.PassportElementError
            "InputFile or String" -> TelegramType.WithAlternative.InputFileOrString
            "Integer or String" -> TelegramType.WithAlternative.IntegerOrString
            "InlineKeyboardMarkup or ReplyKeyboardMarkup or ReplyKeyboardRemove or ForceReply" -> TelegramType.WithAlternative.KeyboardOption
            "InputMediaPhoto and InputMediaVideo" -> TelegramType.WithAlternative.InputMediaPhotoOrVideo
            else -> {
                if (type.startsWith("Array of ")) {
                    TelegramType.ListType(from(type.removePrefix("Array of ")))
                } else {
                    Declared(type)
                }
            }
        }
    }
}

