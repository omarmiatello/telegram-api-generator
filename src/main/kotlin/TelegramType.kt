sealed class TelegramType(val name: String) {
    override fun toString() = name

    class Declared(docName: String) : TelegramType(docName)
    class ListType<T : TelegramType>(val elementType: T) : TelegramType("List<$elementType>")

    object Integer : TelegramType("Integer")
    object StringType : TelegramType("String")
    object Boolean : TelegramType("Boolean")
    object Float : TelegramType("Float")
    object CallbackGame : TelegramType("CallbackGame")
    object InputMedia : TelegramType("InputMedia")
    object InputFile : TelegramType("InputFile")
    object InputMessageContent : TelegramType("InputMessageContent")
    object InlineQueryResult : TelegramType("InlineQueryResult")
    object PassportElementError : TelegramType("PassportElementError")

    sealed class WithAlternative(name: String, val alternative: List<TelegramType>) : TelegramType(name) {
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

    fun getTypeWithoutGenerics(): TelegramType = if (this is ListType<*>) elementType.getTypeWithoutGenerics() else this

    companion object {
        fun from(type: String): TelegramType = when (type) {
            "Integer" -> TelegramType.Integer
            "String" -> TelegramType.StringType
            "Boolean" -> TelegramType.Boolean
            "Float" -> TelegramType.Float
            "CallbackGame" -> TelegramType.CallbackGame
            "InputMedia" -> TelegramType.InputMedia
            "InputFile" -> TelegramType.InputFile
            "InputMessageContent" -> TelegramType.InputMessageContent
            "InlineQueryResult" -> TelegramType.InlineQueryResult
            "PassportElementError" -> TelegramType.PassportElementError
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

