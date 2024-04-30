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
    object VideoChatStarted : TelegramType("VideoChatStarted", superType = null)
    object ForumTopicClosed : TelegramType("ForumTopicClosed", superType = null)
    object ForumTopicReopened : TelegramType("ForumTopicReopened", superType = null)
    object GeneralForumTopicHidden : TelegramType("GeneralForumTopicHidden", superType = null)
    object GeneralForumTopicUnhidden : TelegramType("GeneralForumTopicUnhidden", superType = null)
    object GiveawayCreated : TelegramType("GiveawayCreated", superType = null)

    sealed class Super(name: String, val subclasses: (String) -> kotlin.Boolean) :
        TelegramType(name, superType = null) {
        object InputMessageContent :
            Super("InputMessageContent", subclasses = { it.startsWith("Input") && it.endsWith("MessageContent") })

        object InlineQueryResult :
            Super("InlineQueryResult", subclasses = { it.startsWith("InlineQueryResult") && "Results" !in it })

        object PassportElementError :
            Super("PassportElementError", subclasses = { it.startsWith("PassportElementError") })

        object InputMedia : Super("InputMedia", subclasses = { it.startsWith("InputMedia") })
        object ChatMember : Super("ChatMember", subclasses = { it.startsWith("ChatMember") })
        object BotCommandScope : Super("BotCommandScope", subclasses = { it.startsWith("BotCommandScope") })
        object ReactionType : Super("ReactionType", subclasses = { it.startsWith("ReactionType") })
        object MessageOrigin : Super("MessageOrigin", subclasses = { it.startsWith("MessageOrigin") })
        object ChatBoostSource : Super("ChatBoostSource", subclasses = { it.startsWith("ChatBoostSource") })
        object MenuButton : Super("MenuButton", subclasses = { it.startsWith("MenuButton") })
    }

    sealed class WithAlternative(name: String, val validTypes: List<TelegramType>, superType: TelegramType?) :
        TelegramType(name, superType) {
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

        object MaybeInaccessibleMessage : WithAlternative(
            name = "MaybeInaccessibleMessage",
            validTypes = listOf(
                Declared("Message", MaybeInaccessibleMessage),
                Declared("InaccessibleMessage", MaybeInaccessibleMessage),
            ),
            superType = null
        )
    }

    override fun toString() = name

    fun getTypeWithoutGenerics(): TelegramType = if (this is ListType<*>) elementType.getTypeWithoutGenerics() else this

    companion object {
        val allSuper = listOf(
            Super.InputMedia,
            Super.InputMessageContent,
            Super.InlineQueryResult,
            Super.PassportElementError,
            Super.ChatMember,
            Super.BotCommandScope,
            Super.ReactionType,
            Super.MessageOrigin,
            Super.ChatBoostSource,
            Super.MenuButton,
            WithAlternative.InputFileOrString,
            WithAlternative.IntegerOrString,
            WithAlternative.KeyboardOption,
            WithAlternative.MaybeInaccessibleMessage,
            VoiceChatStarted,
            VideoChatStarted,
        )

        private fun findSuper(docName: String) = allSuper.filterIsInstance(WithAlternative::class.java)
            .firstOrNull { docName in it.validTypes.map { it.name } }
            ?: allSuper.filterIsInstance(Super::class.java)
                .firstOrNull { it.subclasses(docName) }

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
            "VideoChatStarted" -> VideoChatStarted
            "ForumTopicClosed" -> ForumTopicClosed
            "ForumTopicReopened" -> ForumTopicReopened
            "GeneralForumTopicHidden" -> GeneralForumTopicHidden
            "GeneralForumTopicUnhidden" -> GeneralForumTopicUnhidden
            "GiveawayCreated" -> GiveawayCreated
            "InputMessageContent" -> Super.InputMessageContent
            "InlineQueryResult" -> Super.InlineQueryResult
            "ReactionType" -> Super.ReactionType
            "MessageOrigin" -> Super.MessageOrigin
            "ChatBoostSource" -> Super.ChatBoostSource
            "PassportElementError" -> Super.PassportElementError
            "ChatMember" -> Super.ChatMember
            "MenuButton" -> Super.MenuButton
            "BotCommandScope" -> Super.BotCommandScope
            "InputFileOrString" -> WithAlternative.InputFileOrString
            "IntegerOrString" -> WithAlternative.IntegerOrString
            "KeyboardOption" -> WithAlternative.KeyboardOption
            "MaybeInaccessibleMessage" -> WithAlternative.MaybeInaccessibleMessage
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

