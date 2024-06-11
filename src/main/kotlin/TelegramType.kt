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

    sealed class Super(
        name: String,
        val subclasses: (String) -> kotlin.Boolean,
        val deserializer: String,
    ) : TelegramType(name, superType = null) {

        object InputMessageContent : Super(
            name = "InputMessageContent",
            subclasses = { it.startsWith("Input") && it.endsWith("MessageContent") },
            deserializer = ""

        )

        object InlineQueryResult : Super(
            name = "InlineQueryResult",
            subclasses = { it.startsWith("InlineQueryResult") && "Results" !in it },
            deserializer = ""
        )

        object PassportElementError : Super(
            name = "PassportElementError",
            subclasses = { it.startsWith("PassportElementError") },
            deserializer = ""
        )

        object InputMedia : Super(
            name = "InputMedia",
            subclasses = { it.startsWith("InputMedia") },
            deserializer = """
            when (val type = jsonElement.jsonObject.getValue("type").jsonPrimitive.content) {
                "photo" -> InputMediaPhoto.serializer()
                "video" -> InputMediaVideo.serializer()
                "animation" -> InputMediaAnimation.serializer()
                "audio" -> InputMediaAudio.serializer()
                "document" -> InputMediaDocument.serializer()
               else -> error("unknown type: " + type)
            }
            """
        )

        object ChatMember : Super(
            name = "ChatMember",
            subclasses = { it.startsWith("ChatMember") },
            deserializer = ""
        )

        object BotCommandScope : Super(
            name = "BotCommandScope",
            subclasses = { it.startsWith("BotCommandScope") },
            deserializer = ""
        )

        object ReactionType : Super(
            name = "ReactionType",
            subclasses = { it.startsWith("ReactionType") },
            deserializer = ""
        )

        object MessageOrigin : Super(
            name = "MessageOrigin",
            subclasses = { it.startsWith("MessageOrigin") },
            deserializer = ""
        )

        object ChatBoostSource : Super(
            name = "ChatBoostSource",
            subclasses = { it.startsWith("ChatBoostSource") },
            deserializer = ""
        )

        object MenuButton : Super(
            name = "MenuButton",
            subclasses = { it.startsWith("MenuButton") },
            deserializer = ""
        )

        object BackgroundFill : Super(
            name = "BackgroundFill",
            subclasses = { it.startsWith("BackgroundFill") },
            deserializer = ""
        )

        object BackgroundType : Super(
            name = "BackgroundType",
            subclasses = { it.startsWith("BackgroundType") },
            deserializer = ""
        )

        object KeyboardOption : Super(
            name = "KeyboardOption",
            subclasses = { it in listOf("InlineKeyboardMarkup", "ReplyKeyboardMarkup", "ReplyKeyboardRemove", "ForceReply") },
            deserializer = ""
        )

        object MaybeInaccessibleMessage : Super(
            name = "MaybeInaccessibleMessage",
            subclasses = { it in listOf("Message", "InaccessibleMessage") },
            deserializer = """if (jsonElement.jsonObject.getValue("date").jsonPrimitive.long == 0L) {
                                    InaccessibleMessage.serializer()
                                } else {
                                    Message.serializer()
                                }"""
        )
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
            Super.BackgroundFill,
            Super.BackgroundType,
            Super.KeyboardOption,
            Super.MaybeInaccessibleMessage,
            WithAlternative.InputFileOrString,
            WithAlternative.IntegerOrString,
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
            "BackgroundFill" -> Super.BackgroundFill
            "BackgroundType" -> Super.BackgroundType
            "BotCommandScope" -> Super.BotCommandScope
            "KeyboardOption" -> Super.KeyboardOption
            "MaybeInaccessibleMessage" -> Super.MaybeInaccessibleMessage
            "InputFileOrString" -> WithAlternative.InputFileOrString
            "IntegerOrString" -> WithAlternative.IntegerOrString
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

