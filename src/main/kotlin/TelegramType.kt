sealed class TelegramType(val name: String, val superType: TelegramType? = findSuper(name)) {

    class Declared(docName: String, superType: TelegramType? = findSuper(docName)) : TelegramType(docName, superType)

    class ListType<T : TelegramType>(val elementType: T) : TelegramType("List<$elementType>", superType = null)

    object Integer : TelegramType("Integer", superType = null)
    object StringType : TelegramType("String", superType = null)
    object Boolean : TelegramType("Boolean", superType = null)
    object Float : TelegramType("Float", superType = null)
    object CallbackGame : TelegramType("CallbackGame", superType = null)
    object InputFile : TelegramType("InputFile", superType = null)
    object ParseMode : TelegramType("ParseMode", superType = null)
    object VoiceChatStarted : TelegramType("VoiceChatStarted", superType = null)

    sealed class Super(name: String) : TelegramType(name, superType = null) {
        object InputMedia : Super("InputMedia")
        object InputMessageContent : Super("InputMessageContent")
        object InlineQueryResult : Super("InlineQueryResult")
        object PassportElementError : Super("PassportElementError")
        object ChatMember : Super("ChatMember")
        object BotCommandScope : Super("BotCommandScope")
    }

    sealed class WithAlternative(name: String, val validTypes: List<TelegramType>, superType: TelegramType?) : TelegramType(name, superType) {
        object InputFileOrString : WithAlternative(
            name = "InputFileOrString",
            validTypes = listOf(
                InputFile,
                StringType
            ),
            superType = null
        )

        object IntegerOrString : WithAlternative(
            name = "IntegerOrString",
            validTypes = listOf(
                Integer,
                StringType
            ),
            superType = null
        )

        object KeyboardOption : WithAlternative(
            name = "KeyboardOption",
            validTypes = listOf(
                Declared("InlineKeyboardMarkup", KeyboardOption),
                Declared("ReplyKeyboardMarkup", KeyboardOption),
                Declared("ReplyKeyboardRemove", KeyboardOption),
                Declared("ForceReply", KeyboardOption),
            ),
            superType = null
        )

        object InputMessageContent : WithAlternative(
            name = "InputMessageContent",
            validTypes = listOf(
                Declared("InputTextMessageContent", InputMessageContent),
            ),
            superType = null
        )
    }

    override fun toString() = name

    fun getTypeWithoutGenerics(): TelegramType = if (this is ListType<*>) elementType.getTypeWithoutGenerics() else this

    companion object {
        val allSuper = listOf(
            Super.InputMedia,
            Super.InlineQueryResult,
            Super.PassportElementError,
            Super.ChatMember,
            Super.BotCommandScope,
            WithAlternative.KeyboardOption,
            WithAlternative.InputMessageContent,
            VoiceChatStarted,
        )

        private fun findSuper(docName: String) = allSuper.filterIsInstance(WithAlternative::class.java)
            .firstOrNull { docName in it.validTypes.map { it.name } }
            ?: allSuper.firstOrNull { docName.startsWith(it.name) }

        fun from(type: String): TelegramType = when (type) {
            "Integer" -> Integer
            "String" -> StringType
            "Boolean" -> Boolean
            "Float" -> Float
            "CallbackGame" -> CallbackGame
            "InputMedia" -> Super.InputMedia
            "InputFile" -> InputFile
            "ParseMode" -> ParseMode
            "VoiceChatStarted" -> VoiceChatStarted
            "InputMessageContent" -> Super.InputMessageContent
            "InlineQueryResult" -> Super.InlineQueryResult
            "PassportElementError" -> Super.PassportElementError
            "ChatMember" -> Super.ChatMember
            "BotCommandScope" -> Super.BotCommandScope
            "InputFileOrString" -> WithAlternative.InputFileOrString
            "IntegerOrString" -> WithAlternative.IntegerOrString
            "KeyboardOption" -> WithAlternative.KeyboardOption
            else -> {
                if (type.startsWith("Array of ")) {
                    ListType(from(type.removePrefix("Array of ")))
                } else {
                    Declared(type)
                }
            }
        }
    }
}

