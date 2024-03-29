@file:UseSerializers(
    InputMediaSerializer::class,
    InlineQueryResultSerializer::class,
    PassportElementErrorSerializer::class,
    ChatMemberSerializer::class,
    BotCommandScopeSerializer::class,
    KeyboardOptionSerializer::class,
    InputMessageContentSerializer::class,
    VoiceChatStartedSerializer::class,
    VideoChatStartedSerializer::class,
    MenuButtonSerializer::class,
)

package com.github.omarmiatello.telegram

import kotlinx.serialization.Contextual
import kotlinx.serialization.KSerializer
import kotlinx.serialization.Serializable
import kotlinx.serialization.UseSerializers
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.JsonPrimitive
import kotlinx.serialization.json.jsonObject
import kotlinx.serialization.serializer

private val json = Json {
    ignoreUnknownKeys = true
    prettyPrint = true
    encodeDefaults = false
}

sealed class TelegramModel { abstract fun toJson(): String }
@Serializable
sealed class InputMedia : TelegramModel()
object InputMediaSerializer : KSerializer<InputMedia> {
    override val descriptor: SerialDescriptor = InputMedia.serializer().descriptor
    override fun serialize(encoder: Encoder, value: InputMedia) = when (value) {
        is InputMediaPhoto -> encoder.encodeSerializableValue(serializer(), value)
        is InputMediaVideo -> encoder.encodeSerializableValue(serializer(), value)
        is InputMediaAnimation -> encoder.encodeSerializableValue(serializer(), value)
        is InputMediaAudio -> encoder.encodeSerializableValue(serializer(), value)
        is InputMediaDocument -> encoder.encodeSerializableValue(serializer(), value)
    }

    override fun deserialize(decoder: Decoder): InputMedia = TODO()
}
@Serializable
sealed class InlineQueryResult : TelegramModel()
object InlineQueryResultSerializer : KSerializer<InlineQueryResult> {
    override val descriptor: SerialDescriptor = InlineQueryResult.serializer().descriptor
    override fun serialize(encoder: Encoder, value: InlineQueryResult) = when (value) {
        is InlineQueryResultArticle -> encoder.encodeSerializableValue(serializer(), value)
        is InlineQueryResultPhoto -> encoder.encodeSerializableValue(serializer(), value)
        is InlineQueryResultGif -> encoder.encodeSerializableValue(serializer(), value)
        is InlineQueryResultMpeg4Gif -> encoder.encodeSerializableValue(serializer(), value)
        is InlineQueryResultVideo -> encoder.encodeSerializableValue(serializer(), value)
        is InlineQueryResultAudio -> encoder.encodeSerializableValue(serializer(), value)
        is InlineQueryResultVoice -> encoder.encodeSerializableValue(serializer(), value)
        is InlineQueryResultDocument -> encoder.encodeSerializableValue(serializer(), value)
        is InlineQueryResultLocation -> encoder.encodeSerializableValue(serializer(), value)
        is InlineQueryResultVenue -> encoder.encodeSerializableValue(serializer(), value)
        is InlineQueryResultContact -> encoder.encodeSerializableValue(serializer(), value)
        is InlineQueryResultGame -> encoder.encodeSerializableValue(serializer(), value)
        is InlineQueryResultCachedPhoto -> encoder.encodeSerializableValue(serializer(), value)
        is InlineQueryResultCachedGif -> encoder.encodeSerializableValue(serializer(), value)
        is InlineQueryResultCachedMpeg4Gif -> encoder.encodeSerializableValue(serializer(), value)
        is InlineQueryResultCachedSticker -> encoder.encodeSerializableValue(serializer(), value)
        is InlineQueryResultCachedDocument -> encoder.encodeSerializableValue(serializer(), value)
        is InlineQueryResultCachedVideo -> encoder.encodeSerializableValue(serializer(), value)
        is InlineQueryResultCachedVoice -> encoder.encodeSerializableValue(serializer(), value)
        is InlineQueryResultCachedAudio -> encoder.encodeSerializableValue(serializer(), value)
    }

    override fun deserialize(decoder: Decoder): InlineQueryResult = TODO()
}
@Serializable
sealed class PassportElementError : TelegramModel()
object PassportElementErrorSerializer : KSerializer<PassportElementError> {
    override val descriptor: SerialDescriptor = PassportElementError.serializer().descriptor
    override fun serialize(encoder: Encoder, value: PassportElementError) = when (value) {
        is PassportElementErrorDataField -> encoder.encodeSerializableValue(serializer(), value)
        is PassportElementErrorFrontSide -> encoder.encodeSerializableValue(serializer(), value)
        is PassportElementErrorReverseSide -> encoder.encodeSerializableValue(serializer(), value)
        is PassportElementErrorSelfie -> encoder.encodeSerializableValue(serializer(), value)
        is PassportElementErrorFile -> encoder.encodeSerializableValue(serializer(), value)
        is PassportElementErrorFiles -> encoder.encodeSerializableValue(serializer(), value)
        is PassportElementErrorTranslationFile -> encoder.encodeSerializableValue(serializer(), value)
        is PassportElementErrorTranslationFiles -> encoder.encodeSerializableValue(serializer(), value)
        is PassportElementErrorUnspecified -> encoder.encodeSerializableValue(serializer(), value)
    }

    override fun deserialize(decoder: Decoder): PassportElementError = TODO()
}
@Serializable
sealed class ChatMember : TelegramModel()
object ChatMemberSerializer : KSerializer<ChatMember> {
    override val descriptor: SerialDescriptor = ChatMember.serializer().descriptor
    override fun serialize(encoder: Encoder, value: ChatMember) = when (value) {
        is ChatMemberOwner -> encoder.encodeSerializableValue(serializer(), value)
        is ChatMemberAdministrator -> encoder.encodeSerializableValue(serializer(), value)
        is ChatMemberMember -> encoder.encodeSerializableValue(serializer(), value)
        is ChatMemberRestricted -> encoder.encodeSerializableValue(serializer(), value)
        is ChatMemberLeft -> encoder.encodeSerializableValue(serializer(), value)
        is ChatMemberBanned -> encoder.encodeSerializableValue(serializer(), value)
        is ChatMemberUpdated -> encoder.encodeSerializableValue(serializer(), value)
    }

    override fun deserialize(decoder: Decoder): ChatMember = TODO()
}
@Serializable
sealed class BotCommandScope : TelegramModel()
object BotCommandScopeSerializer : KSerializer<BotCommandScope> {
    override val descriptor: SerialDescriptor = BotCommandScope.serializer().descriptor
    override fun serialize(encoder: Encoder, value: BotCommandScope) = when (value) {
        is BotCommandScopeDefault -> encoder.encodeSerializableValue(serializer(), value)
        is BotCommandScopeAllPrivateChats -> encoder.encodeSerializableValue(serializer(), value)
        is BotCommandScopeAllGroupChats -> encoder.encodeSerializableValue(serializer(), value)
        is BotCommandScopeAllChatAdministrators -> encoder.encodeSerializableValue(serializer(), value)
        is BotCommandScopeChat -> encoder.encodeSerializableValue(serializer(), value)
        is BotCommandScopeChatAdministrators -> encoder.encodeSerializableValue(serializer(), value)
        is BotCommandScopeChatMember -> encoder.encodeSerializableValue(serializer(), value)
    }

    override fun deserialize(decoder: Decoder): BotCommandScope = TODO()
}
@Serializable
sealed class KeyboardOption : TelegramModel()
object KeyboardOptionSerializer : KSerializer<KeyboardOption> {
    override val descriptor: SerialDescriptor = KeyboardOption.serializer().descriptor
    override fun serialize(encoder: Encoder, value: KeyboardOption) = when (value) {
        is ReplyKeyboardMarkup -> encoder.encodeSerializableValue(serializer(), value)
        is ReplyKeyboardRemove -> encoder.encodeSerializableValue(serializer(), value)
        is InlineKeyboardMarkup -> encoder.encodeSerializableValue(serializer(), value)
        is ForceReply -> encoder.encodeSerializableValue(serializer(), value)
    }

    override fun deserialize(decoder: Decoder): KeyboardOption = TODO()
}
@Serializable
sealed class InputMessageContent : TelegramModel()
object InputMessageContentSerializer : KSerializer<InputMessageContent> {
    override val descriptor: SerialDescriptor = InputMessageContent.serializer().descriptor
    override fun serialize(encoder: Encoder, value: InputMessageContent) = when (value) {
        is InputTextMessageContent -> encoder.encodeSerializableValue(serializer(), value)
    }

    override fun deserialize(decoder: Decoder): InputMessageContent = TODO()
}
@Serializable
sealed class VoiceChatStarted : TelegramModel()
object VoiceChatStartedSerializer : KSerializer<VoiceChatStarted> {
    override val descriptor: SerialDescriptor = VoiceChatStarted.serializer().descriptor
    override fun serialize(encoder: Encoder, value: VoiceChatStarted) = TODO()
    override fun deserialize(decoder: Decoder): VoiceChatStarted = TODO()
}
@Serializable
sealed class VideoChatStarted : TelegramModel()
object VideoChatStartedSerializer : KSerializer<VideoChatStarted> {
    override val descriptor: SerialDescriptor = VideoChatStarted.serializer().descriptor
    override fun serialize(encoder: Encoder, value: VideoChatStarted) = TODO()
    override fun deserialize(decoder: Decoder): VideoChatStarted = TODO()
}
@Serializable
sealed class MenuButton : TelegramModel()
object MenuButtonSerializer : KSerializer<MenuButton> {
    override val descriptor: SerialDescriptor = MenuButton.serializer().descriptor
    override fun serialize(encoder: Encoder, value: MenuButton) = when (value) {
        is MenuButtonCommands -> encoder.encodeSerializableValue(serializer(), value)
        is MenuButtonWebApp -> encoder.encodeSerializableValue(serializer(), value)
        is MenuButtonDefault -> encoder.encodeSerializableValue(serializer(), value)
    }

    override fun deserialize(decoder: Decoder): MenuButton = TODO()
}
@Serializable
data class TelegramResponse<T>(val ok: Boolean, val result: T)

// --- Utility ---

enum class ParseMode { MarkdownV2, Markdown, HTML }
fun String.parseTelegramRequest() = Update.fromJson(this)

// --- Parameters & Responses ---


// Getting updates

/**
 * <p>This <a href="#available-types">object</a> represents an incoming update.<br>At most <strong>one</strong> of the optional parameters can be present in any given update.</p>
 *
 * @property update_id The update's unique identifier. Update identifiers start from a certain positive number and increase sequentially. This ID becomes especially handy if you're using <a href="#setwebhook">webhooks</a>, since it allows you to ignore repeated updates or to restore the correct update sequence, should they get out of order. If there are no new updates for at least a week, then identifier of the next update will be chosen randomly instead of sequentially.
 * @property message <em>Optional</em>. New incoming message of any kind - text, photo, sticker, etc.
 * @property edited_message <em>Optional</em>. New version of a message that is known to the bot and was edited
 * @property channel_post <em>Optional</em>. New incoming channel post of any kind - text, photo, sticker, etc.
 * @property edited_channel_post <em>Optional</em>. New version of a channel post that is known to the bot and was edited
 * @property inline_query <em>Optional</em>. New incoming <a href="#inline-mode">inline</a> query
 * @property chosen_inline_result <em>Optional</em>. The result of an <a href="#inline-mode">inline</a> query that was chosen by a user and sent to their chat partner. Please see our documentation on the <a href="/bots/inline#collecting-feedback">feedback collecting</a> for details on how to enable these updates for your bot.
 * @property callback_query <em>Optional</em>. New incoming callback query
 * @property shipping_query <em>Optional</em>. New incoming shipping query. Only for invoices with flexible price
 * @property pre_checkout_query <em>Optional</em>. New incoming pre-checkout query. Contains full information about checkout
 * @property poll <em>Optional</em>. New poll state. Bots receive only updates about stopped polls and polls, which are sent by the bot
 * @property poll_answer <em>Optional</em>. A user changed their answer in a non-anonymous poll. Bots receive new votes only in polls that were sent by the bot itself.
 * @property my_chat_member <em>Optional</em>. The bot's chat member status was updated in a chat. For private chats, this update is received only when the bot is blocked or unblocked by the user.
 * @property chat_member <em>Optional</em>. A chat member's status was updated in a chat. The bot must be an administrator in the chat and must explicitly specify “chat_member” in the list of <em>allowed_updates</em> to receive these updates.
 * @property chat_join_request <em>Optional</em>. A request to join the chat has been sent. The bot must have the <em>can_invite_users</em> administrator right in the chat to receive these updates.
 *
 * @constructor Creates a [Update].
 * */
@Serializable
data class Update(
    val update_id: Long,
    val message: Message? = null,
    val edited_message: Message? = null,
    val channel_post: Message? = null,
    val edited_channel_post: Message? = null,
    val inline_query: InlineQuery? = null,
    val chosen_inline_result: ChosenInlineResult? = null,
    val callback_query: CallbackQuery? = null,
    val shipping_query: ShippingQuery? = null,
    val pre_checkout_query: PreCheckoutQuery? = null,
    val poll: Poll? = null,
    val poll_answer: PollAnswer? = null,
    val my_chat_member: ChatMemberUpdated? = null,
    val chat_member: ChatMemberUpdated? = null,
    val chat_join_request: ChatJoinRequest? = null,
) : TelegramModel() {
    override fun toJson() = json.encodeToString(serializer(), this)
    companion object {
        fun fromJson(string: String) = json.decodeFromString(serializer(), string)
    }
}

/**
 * <p>Describes the current status of a webhook.</p>
 *
 * @property url Webhook URL, may be empty if webhook is not set up
 * @property has_custom_certificate <em>True</em>, if a custom certificate was provided for webhook certificate checks
 * @property pending_update_count Number of updates awaiting delivery
 * @property ip_address <em>Optional</em>. Currently used webhook IP address
 * @property last_error_date <em>Optional</em>. Unix time for the most recent error that happened when trying to deliver an update via webhook
 * @property last_error_message <em>Optional</em>. Error message in human-readable format for the most recent error that happened when trying to deliver an update via webhook
 * @property last_synchronization_error_date <em>Optional</em>. Unix time of the most recent error that happened when trying to synchronize available updates with Telegram datacenters
 * @property max_connections <em>Optional</em>. The maximum allowed number of simultaneous HTTPS connections to the webhook for update delivery
 * @property allowed_updates <em>Optional</em>. A list of update types the bot is subscribed to. Defaults to all update types except <em>chat_member</em>
 *
 * @constructor Creates a [WebhookInfo].
 * */
@Serializable
data class WebhookInfo(
    val url: String,
    val has_custom_certificate: Boolean,
    val pending_update_count: Long,
    val ip_address: String? = null,
    val last_error_date: Long? = null,
    val last_error_message: String? = null,
    val last_synchronization_error_date: Long? = null,
    val max_connections: Long? = null,
    val allowed_updates: List<String>? = null,
) : TelegramModel() {
    override fun toJson() = json.encodeToString(serializer(), this)
    companion object {
        fun fromJson(string: String) = json.decodeFromString(serializer(), string)
    }
}


// Available types

/**
 * <p>This object represents a Telegram user or bot.</p>
 *
 * @property id Unique identifier for this user or bot. This number may have more than 32 significant bits and some programming languages may have difficulty/silent defects in interpreting it. But it has at most 52 significant bits, so a 64-bit integer or double-precision float type are safe for storing this identifier.
 * @property is_bot <em>True</em>, if this user is a bot
 * @property first_name User's or bot's first name
 * @property last_name <em>Optional</em>. User's or bot's last name
 * @property username <em>Optional</em>. User's or bot's username
 * @property language_code <em>Optional</em>. <a href="https://en.wikipedia.org/wiki/IETF_language_tag">IETF language tag</a> of the user's language
 * @property is_premium <em>Optional</em>. <em>True</em>, if this user is a Telegram Premium user
 * @property added_to_attachment_menu <em>Optional</em>. <em>True</em>, if this user added the bot to the attachment menu
 * @property can_join_groups <em>Optional</em>. <em>True</em>, if the bot can be invited to groups. Returned only in <a href="#getme">getMe</a>.
 * @property can_read_all_group_messages <em>Optional</em>. <em>True</em>, if <a href="https://core.telegram.org/bots#privacy-mode">privacy mode</a> is disabled for the bot. Returned only in <a href="#getme">getMe</a>.
 * @property supports_inline_queries <em>Optional</em>. <em>True</em>, if the bot supports inline queries. Returned only in <a href="#getme">getMe</a>.
 *
 * @constructor Creates a [User].
 * */
@Serializable
data class User(
    val id: Long,
    val is_bot: Boolean,
    val first_name: String,
    val last_name: String? = null,
    val username: String? = null,
    val language_code: String? = null,
    val is_premium: Boolean? = null,
    val added_to_attachment_menu: Boolean? = null,
    val can_join_groups: Boolean? = null,
    val can_read_all_group_messages: Boolean? = null,
    val supports_inline_queries: Boolean? = null,
) : TelegramModel() {
    override fun toJson() = json.encodeToString(serializer(), this)
    companion object {
        fun fromJson(string: String) = json.decodeFromString(serializer(), string)
    }
}

/**
 * <p>This object represents a chat.</p>
 *
 * @property id Unique identifier for this chat. This number may have more than 32 significant bits and some programming languages may have difficulty/silent defects in interpreting it. But it has at most 52 significant bits, so a signed 64-bit integer or double-precision float type are safe for storing this identifier.
 * @property type Type of chat, can be either “private”, “group”, “supergroup” or “channel”
 * @property title <em>Optional</em>. Title, for supergroups, channels and group chats
 * @property username <em>Optional</em>. Username, for private chats, supergroups and channels if available
 * @property first_name <em>Optional</em>. First name of the other party in a private chat
 * @property last_name <em>Optional</em>. Last name of the other party in a private chat
 * @property photo <em>Optional</em>. Chat photo. Returned only in <a href="#getchat">getChat</a>.
 * @property bio <em>Optional</em>. Bio of the other party in a private chat. Returned only in <a href="#getchat">getChat</a>.
 * @property has_private_forwards <em>Optional</em>. <em>True</em>, if privacy settings of the other party in the private chat allows to use <code>tg://user?id=&lt;user_id&gt;</code> links only in chats with the user. Returned only in <a href="#getchat">getChat</a>.
 * @property join_to_send_messages <em>Optional</em>. <em>True</em>, if users need to join the supergroup before they can send messages. Returned only in <a href="#getchat">getChat</a>.
 * @property join_by_request <em>Optional</em>. <em>True</em>, if all users directly joining the supergroup need to be approved by supergroup administrators. Returned only in <a href="#getchat">getChat</a>.
 * @property description <em>Optional</em>. Description, for groups, supergroups and channel chats. Returned only in <a href="#getchat">getChat</a>.
 * @property invite_link <em>Optional</em>. Primary invite link, for groups, supergroups and channel chats. Returned only in <a href="#getchat">getChat</a>.
 * @property pinned_message <em>Optional</em>. The most recent pinned message (by sending date). Returned only in <a href="#getchat">getChat</a>.
 * @property permissions <em>Optional</em>. Default chat member permissions, for groups and supergroups. Returned only in <a href="#getchat">getChat</a>.
 * @property slow_mode_delay <em>Optional</em>. For supergroups, the minimum allowed delay between consecutive messages sent by each unpriviledged user; in seconds. Returned only in <a href="#getchat">getChat</a>.
 * @property message_auto_delete_time <em>Optional</em>. The time after which all messages sent to the chat will be automatically deleted; in seconds. Returned only in <a href="#getchat">getChat</a>.
 * @property has_protected_content <em>Optional</em>. <em>True</em>, if messages from the chat can't be forwarded to other chats. Returned only in <a href="#getchat">getChat</a>.
 * @property sticker_set_name <em>Optional</em>. For supergroups, name of group sticker set. Returned only in <a href="#getchat">getChat</a>.
 * @property can_set_sticker_set <em>Optional</em>. <em>True</em>, if the bot can change the group sticker set. Returned only in <a href="#getchat">getChat</a>.
 * @property linked_chat_id <em>Optional</em>. Unique identifier for the linked chat, i.e. the discussion group identifier for a channel and vice versa; for supergroups and channel chats. This identifier may be greater than 32 bits and some programming languages may have difficulty/silent defects in interpreting it. But it is smaller than 52 bits, so a signed 64 bit integer or double-precision float type are safe for storing this identifier. Returned only in <a href="#getchat">getChat</a>.
 * @property location <em>Optional</em>. For supergroups, the location to which the supergroup is connected. Returned only in <a href="#getchat">getChat</a>.
 *
 * @constructor Creates a [Chat].
 * */
@Serializable
data class Chat(
    val id: Long,
    val type: String,
    val title: String? = null,
    val username: String? = null,
    val first_name: String? = null,
    val last_name: String? = null,
    val photo: ChatPhoto? = null,
    val bio: String? = null,
    val has_private_forwards: Boolean? = null,
    val join_to_send_messages: Boolean? = null,
    val join_by_request: Boolean? = null,
    val description: String? = null,
    val invite_link: String? = null,
    val pinned_message: Message? = null,
    val permissions: ChatPermissions? = null,
    val slow_mode_delay: Long? = null,
    val message_auto_delete_time: Long? = null,
    val has_protected_content: Boolean? = null,
    val sticker_set_name: String? = null,
    val can_set_sticker_set: Boolean? = null,
    val linked_chat_id: Long? = null,
    val location: ChatLocation? = null,
) : TelegramModel() {
    override fun toJson() = json.encodeToString(serializer(), this)
    companion object {
        fun fromJson(string: String) = json.decodeFromString(serializer(), string)
    }
}

/**
 * <p>This object represents a message.</p>
 *
 * @property message_id Unique message identifier inside this chat
 * @property from <em>Optional</em>. Sender of the message; empty for messages sent to channels. For backward compatibility, the field contains a fake sender user in non-channel chats, if the message was sent on behalf of a chat.
 * @property sender_chat <em>Optional</em>. Sender of the message, sent on behalf of a chat. For example, the channel itself for channel posts, the supergroup itself for messages from anonymous group administrators, the linked channel for messages automatically forwarded to the discussion group. For backward compatibility, the field <em>from</em> contains a fake sender user in non-channel chats, if the message was sent on behalf of a chat.
 * @property date Date the message was sent in Unix time
 * @property chat Conversation the message belongs to
 * @property forward_from <em>Optional</em>. For forwarded messages, sender of the original message
 * @property forward_from_chat <em>Optional</em>. For messages forwarded from channels or from anonymous administrators, information about the original sender chat
 * @property forward_from_message_id <em>Optional</em>. For messages forwarded from channels, identifier of the original message in the channel
 * @property forward_signature <em>Optional</em>. For forwarded messages that were originally sent in channels or by an anonymous chat administrator, signature of the message sender if present
 * @property forward_sender_name <em>Optional</em>. Sender's name for messages forwarded from users who disallow adding a link to their account in forwarded messages
 * @property forward_date <em>Optional</em>. For forwarded messages, date the original message was sent in Unix time
 * @property is_automatic_forward <em>Optional</em>. <em>True</em>, if the message is a channel post that was automatically forwarded to the connected discussion group
 * @property reply_to_message <em>Optional</em>. For replies, the original message. Note that the Message object in this field will not contain further <em>reply_to_message</em> fields even if it itself is a reply.
 * @property via_bot <em>Optional</em>. Bot through which the message was sent
 * @property edit_date <em>Optional</em>. Date the message was last edited in Unix time
 * @property has_protected_content <em>Optional</em>. <em>True</em>, if the message can't be forwarded
 * @property media_group_id <em>Optional</em>. The unique identifier of a media message group this message belongs to
 * @property author_signature <em>Optional</em>. Signature of the post author for messages in channels, or the custom title of an anonymous group administrator
 * @property text <em>Optional</em>. For text messages, the actual UTF-8 text of the message
 * @property entities <em>Optional</em>. For text messages, special entities like usernames, URLs, bot commands, etc. that appear in the text
 * @property animation <em>Optional</em>. Message is an animation, information about the animation. For backward compatibility, when this field is set, the <em>document</em> field will also be set
 * @property audio <em>Optional</em>. Message is an audio file, information about the file
 * @property document <em>Optional</em>. Message is a general file, information about the file
 * @property photo <em>Optional</em>. Message is a photo, available sizes of the photo
 * @property sticker <em>Optional</em>. Message is a sticker, information about the sticker
 * @property video <em>Optional</em>. Message is a video, information about the video
 * @property video_note <em>Optional</em>. Message is a <a href="https://telegram.org/blog/video-messages-and-telescope">video note</a>, information about the video message
 * @property voice <em>Optional</em>. Message is a voice message, information about the file
 * @property caption <em>Optional</em>. Caption for the animation, audio, document, photo, video or voice
 * @property caption_entities <em>Optional</em>. For messages with a caption, special entities like usernames, URLs, bot commands, etc. that appear in the caption
 * @property contact <em>Optional</em>. Message is a shared contact, information about the contact
 * @property dice <em>Optional</em>. Message is a dice with random value
 * @property game <em>Optional</em>. Message is a game, information about the game. <a href="#games">More about games »</a>
 * @property poll <em>Optional</em>. Message is a native poll, information about the poll
 * @property venue <em>Optional</em>. Message is a venue, information about the venue. For backward compatibility, when this field is set, the <em>location</em> field will also be set
 * @property location <em>Optional</em>. Message is a shared location, information about the location
 * @property new_chat_members <em>Optional</em>. New members that were added to the group or supergroup and information about them (the bot itself may be one of these members)
 * @property left_chat_member <em>Optional</em>. A member was removed from the group, information about them (this member may be the bot itself)
 * @property new_chat_title <em>Optional</em>. A chat title was changed to this value
 * @property new_chat_photo <em>Optional</em>. A chat photo was change to this value
 * @property delete_chat_photo <em>Optional</em>. Service message: the chat photo was deleted
 * @property group_chat_created <em>Optional</em>. Service message: the group has been created
 * @property supergroup_chat_created <em>Optional</em>. Service message: the supergroup has been created. This field can't be received in a message coming through updates, because bot can't be a member of a supergroup when it is created. It can only be found in reply_to_message if someone replies to a very first message in a directly created supergroup.
 * @property channel_chat_created <em>Optional</em>. Service message: the channel has been created. This field can't be received in a message coming through updates, because bot can't be a member of a channel when it is created. It can only be found in reply_to_message if someone replies to a very first message in a channel.
 * @property message_auto_delete_timer_changed <em>Optional</em>. Service message: auto-delete timer settings changed in the chat
 * @property migrate_to_chat_id <em>Optional</em>. The group has been migrated to a supergroup with the specified identifier. This number may have more than 32 significant bits and some programming languages may have difficulty/silent defects in interpreting it. But it has at most 52 significant bits, so a signed 64-bit integer or double-precision float type are safe for storing this identifier.
 * @property migrate_from_chat_id <em>Optional</em>. The supergroup has been migrated from a group with the specified identifier. This number may have more than 32 significant bits and some programming languages may have difficulty/silent defects in interpreting it. But it has at most 52 significant bits, so a signed 64-bit integer or double-precision float type are safe for storing this identifier.
 * @property pinned_message <em>Optional</em>. Specified message was pinned. Note that the Message object in this field will not contain further <em>reply_to_message</em> fields even if it is itself a reply.
 * @property invoice <em>Optional</em>. Message is an invoice for a <a href="#payments">payment</a>, information about the invoice. <a href="#payments">More about payments »</a>
 * @property successful_payment <em>Optional</em>. Message is a service message about a successful payment, information about the payment. <a href="#payments">More about payments »</a>
 * @property connected_website <em>Optional</em>. The domain name of the website on which the user has logged in. <a href="/widgets/login">More about Telegram Login »</a>
 * @property passport_data <em>Optional</em>. Telegram Passport data
 * @property proximity_alert_triggered <em>Optional</em>. Service message. A user in the chat triggered another user's proximity alert while sharing Live Location.
 * @property video_chat_scheduled <em>Optional</em>. Service message: video chat scheduled
 * @property video_chat_started <em>Optional</em>. Service message: video chat started
 * @property video_chat_ended <em>Optional</em>. Service message: video chat ended
 * @property video_chat_participants_invited <em>Optional</em>. Service message: new participants invited to a video chat
 * @property web_app_data <em>Optional</em>. Service message: data sent by a Web App
 * @property reply_markup <em>Optional</em>. Inline keyboard attached to the message. <code>login_url</code> buttons are represented as ordinary <code>url</code> buttons.
 *
 * @constructor Creates a [Message].
 * */
@Serializable
data class Message(
    val message_id: Long,
    val from: User? = null,
    val sender_chat: Chat? = null,
    val date: Long,
    val chat: Chat,
    val forward_from: User? = null,
    val forward_from_chat: Chat? = null,
    val forward_from_message_id: Long? = null,
    val forward_signature: String? = null,
    val forward_sender_name: String? = null,
    val forward_date: Long? = null,
    val is_automatic_forward: Boolean? = null,
    val reply_to_message: Message? = null,
    val via_bot: User? = null,
    val edit_date: Long? = null,
    val has_protected_content: Boolean? = null,
    val media_group_id: String? = null,
    val author_signature: String? = null,
    val text: String? = null,
    val entities: List<MessageEntity>? = null,
    val animation: Animation? = null,
    val audio: Audio? = null,
    val document: Document? = null,
    val photo: List<PhotoSize>? = null,
    val sticker: Sticker? = null,
    val video: Video? = null,
    val video_note: VideoNote? = null,
    val voice: Voice? = null,
    val caption: String? = null,
    val caption_entities: List<MessageEntity>? = null,
    val contact: Contact? = null,
    val dice: Dice? = null,
    val game: Game? = null,
    val poll: Poll? = null,
    val venue: Venue? = null,
    val location: Location? = null,
    val new_chat_members: List<User>? = null,
    val left_chat_member: User? = null,
    val new_chat_title: String? = null,
    val new_chat_photo: List<PhotoSize>? = null,
    val delete_chat_photo: Boolean? = null,
    val group_chat_created: Boolean? = null,
    val supergroup_chat_created: Boolean? = null,
    val channel_chat_created: Boolean? = null,
    val message_auto_delete_timer_changed: MessageAutoDeleteTimerChanged? = null,
    val migrate_to_chat_id: Long? = null,
    val migrate_from_chat_id: Long? = null,
    val pinned_message: Message? = null,
    val invoice: Invoice? = null,
    val successful_payment: SuccessfulPayment? = null,
    val connected_website: String? = null,
    val passport_data: PassportData? = null,
    val proximity_alert_triggered: ProximityAlertTriggered? = null,
    val video_chat_scheduled: VideoChatScheduled? = null,
    val video_chat_started: @Contextual VideoChatStarted? = null,
    val video_chat_ended: VideoChatEnded? = null,
    val video_chat_participants_invited: VideoChatParticipantsInvited? = null,
    val web_app_data: WebAppData? = null,
    val reply_markup: InlineKeyboardMarkup? = null,
) : TelegramModel() {
    override fun toJson() = json.encodeToString(serializer(), this)
    companion object {
        fun fromJson(string: String) = json.decodeFromString(serializer(), string)
    }
}

/**
 * <p>This object represents a unique message identifier.</p>
 *
 * @property message_id Unique message identifier
 *
 * @constructor Creates a [MessageId].
 * */
@Serializable
data class MessageId(
    val message_id: Long,
) : TelegramModel() {
    override fun toJson() = json.encodeToString(serializer(), this)
    companion object {
        fun fromJson(string: String) = json.decodeFromString(serializer(), string)
    }
}

/**
 * <p>This object represents one special entity in a text message. For example, hashtags, usernames, URLs, etc.</p>
 *
 * @property type Type of the entity. Currently, can be “mention” (<code>@username</code>), “hashtag” (<code>#hashtag</code>), “cashtag” (<code>$USD</code>), “bot_command” (<code>/start@jobs_bot</code>), “url” (<code>https://telegram.org</code>), “email” (<code>do-not-reply@telegram.org</code>), “phone_number” (<code>+1-212-555-0123</code>), “bold” (<strong>bold text</strong>), “italic” (<em>italic text</em>), “underline” (underlined text), “strikethrough” (strikethrough text), “spoiler” (spoiler message), “code” (monowidth string), “pre” (monowidth block), “text_link” (for clickable text URLs), “text_mention” (for users <a href="https://telegram.org/blog/edit#new-mentions">without usernames</a>)
 * @property offset Offset in UTF-16 code units to the start of the entity
 * @property length Length of the entity in UTF-16 code units
 * @property url <em>Optional</em>. For “text_link” only, URL that will be opened after user taps on the text
 * @property user <em>Optional</em>. For “text_mention” only, the mentioned user
 * @property language <em>Optional</em>. For “pre” only, the programming language of the entity text
 *
 * @constructor Creates a [MessageEntity].
 * */
@Serializable
data class MessageEntity(
    val type: String,
    val offset: Long,
    val length: Long,
    val url: String? = null,
    val user: User? = null,
    val language: String? = null,
) : TelegramModel() {
    override fun toJson() = json.encodeToString(serializer(), this)
    companion object {
        fun fromJson(string: String) = json.decodeFromString(serializer(), string)
    }
}

/**
 * <p>This object represents one size of a photo or a <a href="#document">file</a> / <a href="#sticker">sticker</a> thumbnail.</p>
 *
 * @property file_id Identifier for this file, which can be used to download or reuse the file
 * @property file_unique_id Unique identifier for this file, which is supposed to be the same over time and for different bots. Can't be used to download or reuse the file.
 * @property width Photo width
 * @property height Photo height
 * @property file_size <em>Optional</em>. File size in bytes
 *
 * @constructor Creates a [PhotoSize].
 * */
@Serializable
data class PhotoSize(
    val file_id: String,
    val file_unique_id: String,
    val width: Long,
    val height: Long,
    val file_size: Long? = null,
) : TelegramModel() {
    override fun toJson() = json.encodeToString(serializer(), this)
    companion object {
        fun fromJson(string: String) = json.decodeFromString(serializer(), string)
    }
}

/**
 * <p>This object represents an animation file (GIF or H.264/MPEG-4 AVC video without sound).</p>
 *
 * @property file_id Identifier for this file, which can be used to download or reuse the file
 * @property file_unique_id Unique identifier for this file, which is supposed to be the same over time and for different bots. Can't be used to download or reuse the file.
 * @property width Video width as defined by sender
 * @property height Video height as defined by sender
 * @property duration Duration of the video in seconds as defined by sender
 * @property thumb <em>Optional</em>. Animation thumbnail as defined by sender
 * @property file_name <em>Optional</em>. Original animation filename as defined by sender
 * @property mime_type <em>Optional</em>. MIME type of the file as defined by sender
 * @property file_size <em>Optional</em>. File size in bytes. It can be bigger than 2^31 and some programming languages may have difficulty/silent defects in interpreting it. But it has at most 52 significant bits, so a signed 64-bit integer or double-precision float type are safe for storing this value.
 *
 * @constructor Creates a [Animation].
 * */
@Serializable
data class Animation(
    val file_id: String,
    val file_unique_id: String,
    val width: Long,
    val height: Long,
    val duration: Long,
    val thumb: PhotoSize? = null,
    val file_name: String? = null,
    val mime_type: String? = null,
    val file_size: Long? = null,
) : TelegramModel() {
    override fun toJson() = json.encodeToString(serializer(), this)
    companion object {
        fun fromJson(string: String) = json.decodeFromString(serializer(), string)
    }
}

/**
 * <p>This object represents an audio file to be treated as music by the Telegram clients.</p>
 *
 * @property file_id Identifier for this file, which can be used to download or reuse the file
 * @property file_unique_id Unique identifier for this file, which is supposed to be the same over time and for different bots. Can't be used to download or reuse the file.
 * @property duration Duration of the audio in seconds as defined by sender
 * @property performer <em>Optional</em>. Performer of the audio as defined by sender or by audio tags
 * @property title <em>Optional</em>. Title of the audio as defined by sender or by audio tags
 * @property file_name <em>Optional</em>. Original filename as defined by sender
 * @property mime_type <em>Optional</em>. MIME type of the file as defined by sender
 * @property file_size <em>Optional</em>. File size in bytes. It can be bigger than 2^31 and some programming languages may have difficulty/silent defects in interpreting it. But it has at most 52 significant bits, so a signed 64-bit integer or double-precision float type are safe for storing this value.
 * @property thumb <em>Optional</em>. Thumbnail of the album cover to which the music file belongs
 *
 * @constructor Creates a [Audio].
 * */
@Serializable
data class Audio(
    val file_id: String,
    val file_unique_id: String,
    val duration: Long,
    val performer: String? = null,
    val title: String? = null,
    val file_name: String? = null,
    val mime_type: String? = null,
    val file_size: Long? = null,
    val thumb: PhotoSize? = null,
) : TelegramModel() {
    override fun toJson() = json.encodeToString(serializer(), this)
    companion object {
        fun fromJson(string: String) = json.decodeFromString(serializer(), string)
    }
}

/**
 * <p>This object represents a general file (as opposed to <a href="#photosize">photos</a>, <a href="#voice">voice messages</a> and <a href="#audio">audio files</a>).</p>
 *
 * @property file_id Identifier for this file, which can be used to download or reuse the file
 * @property file_unique_id Unique identifier for this file, which is supposed to be the same over time and for different bots. Can't be used to download or reuse the file.
 * @property thumb <em>Optional</em>. Document thumbnail as defined by sender
 * @property file_name <em>Optional</em>. Original filename as defined by sender
 * @property mime_type <em>Optional</em>. MIME type of the file as defined by sender
 * @property file_size <em>Optional</em>. File size in bytes. It can be bigger than 2^31 and some programming languages may have difficulty/silent defects in interpreting it. But it has at most 52 significant bits, so a signed 64-bit integer or double-precision float type are safe for storing this value.
 *
 * @constructor Creates a [Document].
 * */
@Serializable
data class Document(
    val file_id: String,
    val file_unique_id: String,
    val thumb: PhotoSize? = null,
    val file_name: String? = null,
    val mime_type: String? = null,
    val file_size: Long? = null,
) : TelegramModel() {
    override fun toJson() = json.encodeToString(serializer(), this)
    companion object {
        fun fromJson(string: String) = json.decodeFromString(serializer(), string)
    }
}

/**
 * <p>This object represents a video file.</p>
 *
 * @property file_id Identifier for this file, which can be used to download or reuse the file
 * @property file_unique_id Unique identifier for this file, which is supposed to be the same over time and for different bots. Can't be used to download or reuse the file.
 * @property width Video width as defined by sender
 * @property height Video height as defined by sender
 * @property duration Duration of the video in seconds as defined by sender
 * @property thumb <em>Optional</em>. Video thumbnail
 * @property file_name <em>Optional</em>. Original filename as defined by sender
 * @property mime_type <em>Optional</em>. MIME type of the file as defined by sender
 * @property file_size <em>Optional</em>. File size in bytes. It can be bigger than 2^31 and some programming languages may have difficulty/silent defects in interpreting it. But it has at most 52 significant bits, so a signed 64-bit integer or double-precision float type are safe for storing this value.
 *
 * @constructor Creates a [Video].
 * */
@Serializable
data class Video(
    val file_id: String,
    val file_unique_id: String,
    val width: Long,
    val height: Long,
    val duration: Long,
    val thumb: PhotoSize? = null,
    val file_name: String? = null,
    val mime_type: String? = null,
    val file_size: Long? = null,
) : TelegramModel() {
    override fun toJson() = json.encodeToString(serializer(), this)
    companion object {
        fun fromJson(string: String) = json.decodeFromString(serializer(), string)
    }
}

/**
 * <p>This object represents a <a href="https://telegram.org/blog/video-messages-and-telescope">video message</a> (available in Telegram apps as of <a href="https://telegram.org/blog/video-messages-and-telescope">v.4.0</a>).</p>
 *
 * @property file_id Identifier for this file, which can be used to download or reuse the file
 * @property file_unique_id Unique identifier for this file, which is supposed to be the same over time and for different bots. Can't be used to download or reuse the file.
 * @property length Video width and height (diameter of the video message) as defined by sender
 * @property duration Duration of the video in seconds as defined by sender
 * @property thumb <em>Optional</em>. Video thumbnail
 * @property file_size <em>Optional</em>. File size in bytes
 *
 * @constructor Creates a [VideoNote].
 * */
@Serializable
data class VideoNote(
    val file_id: String,
    val file_unique_id: String,
    val length: Long,
    val duration: Long,
    val thumb: PhotoSize? = null,
    val file_size: Long? = null,
) : TelegramModel() {
    override fun toJson() = json.encodeToString(serializer(), this)
    companion object {
        fun fromJson(string: String) = json.decodeFromString(serializer(), string)
    }
}

/**
 * <p>This object represents a voice note.</p>
 *
 * @property file_id Identifier for this file, which can be used to download or reuse the file
 * @property file_unique_id Unique identifier for this file, which is supposed to be the same over time and for different bots. Can't be used to download or reuse the file.
 * @property duration Duration of the audio in seconds as defined by sender
 * @property mime_type <em>Optional</em>. MIME type of the file as defined by sender
 * @property file_size <em>Optional</em>. File size in bytes. It can be bigger than 2^31 and some programming languages may have difficulty/silent defects in interpreting it. But it has at most 52 significant bits, so a signed 64-bit integer or double-precision float type are safe for storing this value.
 *
 * @constructor Creates a [Voice].
 * */
@Serializable
data class Voice(
    val file_id: String,
    val file_unique_id: String,
    val duration: Long,
    val mime_type: String? = null,
    val file_size: Long? = null,
) : TelegramModel() {
    override fun toJson() = json.encodeToString(serializer(), this)
    companion object {
        fun fromJson(string: String) = json.decodeFromString(serializer(), string)
    }
}

/**
 * <p>This object represents a phone contact.</p>
 *
 * @property phone_number Contact's phone number
 * @property first_name Contact's first name
 * @property last_name <em>Optional</em>. Contact's last name
 * @property user_id <em>Optional</em>. Contact's user identifier in Telegram. This number may have more than 32 significant bits and some programming languages may have difficulty/silent defects in interpreting it. But it has at most 52 significant bits, so a 64-bit integer or double-precision float type are safe for storing this identifier.
 * @property vcard <em>Optional</em>. Additional data about the contact in the form of a <a href="https://en.wikipedia.org/wiki/VCard">vCard</a>
 *
 * @constructor Creates a [Contact].
 * */
@Serializable
data class Contact(
    val phone_number: String,
    val first_name: String,
    val last_name: String? = null,
    val user_id: Long? = null,
    val vcard: String? = null,
) : TelegramModel() {
    override fun toJson() = json.encodeToString(serializer(), this)
    companion object {
        fun fromJson(string: String) = json.decodeFromString(serializer(), string)
    }
}

/**
 * <p>This object represents an animated emoji that displays a random value.</p>
 *
 * @property emoji Emoji on which the dice throw animation is based
 * @property value Value of the dice, 1-6 for “<img class="emoji" src="//telegram.org/img/emoji/40/F09F8EB2.png" width="20" height="20" alt="🎲">”, “<img class="emoji" src="//telegram.org/img/emoji/40/F09F8EAF.png" width="20" height="20" alt="🎯">” and “<img class="emoji" src="//telegram.org/img/emoji/40/F09F8EB3.png" width="20" height="20" alt="🎳">” base emoji, 1-5 for “<img class="emoji" src="//telegram.org/img/emoji/40/F09F8F80.png" width="20" height="20" alt="🏀">” and “<img class="emoji" src="//telegram.org/img/emoji/40/E29ABD.png" width="20" height="20" alt="⚽">” base emoji, 1-64 for “<img class="emoji" src="//telegram.org/img/emoji/40/F09F8EB0.png" width="20" height="20" alt="🎰">” base emoji
 *
 * @constructor Creates a [Dice].
 * */
@Serializable
data class Dice(
    val emoji: String,
    val value: Long,
) : TelegramModel() {
    override fun toJson() = json.encodeToString(serializer(), this)
    companion object {
        fun fromJson(string: String) = json.decodeFromString(serializer(), string)
    }
}

/**
 * <p>This object contains information about one answer option in a poll.</p>
 *
 * @property text Option text, 1-100 characters
 * @property voter_count Number of users that voted for this option
 *
 * @constructor Creates a [PollOption].
 * */
@Serializable
data class PollOption(
    val text: String,
    val voter_count: Long,
) : TelegramModel() {
    override fun toJson() = json.encodeToString(serializer(), this)
    companion object {
        fun fromJson(string: String) = json.decodeFromString(serializer(), string)
    }
}

/**
 * <p>This object represents an answer of a user in a non-anonymous poll.</p>
 *
 * @property poll_id Unique poll identifier
 * @property user The user, who changed the answer to the poll
 * @property option_ids 0-based identifiers of answer options, chosen by the user. May be empty if the user retracted their vote.
 *
 * @constructor Creates a [PollAnswer].
 * */
@Serializable
data class PollAnswer(
    val poll_id: String,
    val user: User,
    val option_ids: List<Long>,
) : TelegramModel() {
    override fun toJson() = json.encodeToString(serializer(), this)
    companion object {
        fun fromJson(string: String) = json.decodeFromString(serializer(), string)
    }
}

/**
 * <p>This object contains information about a poll.</p>
 *
 * @property id Unique poll identifier
 * @property question Poll question, 1-300 characters
 * @property options List of poll options
 * @property total_voter_count Total number of users that voted in the poll
 * @property is_closed <em>True</em>, if the poll is closed
 * @property is_anonymous <em>True</em>, if the poll is anonymous
 * @property type Poll type, currently can be “regular” or “quiz”
 * @property allows_multiple_answers <em>True</em>, if the poll allows multiple answers
 * @property correct_option_id <em>Optional</em>. 0-based identifier of the correct answer option. Available only for polls in the quiz mode, which are closed, or was sent (not forwarded) by the bot or to the private chat with the bot.
 * @property explanation <em>Optional</em>. Text that is shown when a user chooses an incorrect answer or taps on the lamp icon in a quiz-style poll, 0-200 characters
 * @property explanation_entities <em>Optional</em>. Special entities like usernames, URLs, bot commands, etc. that appear in the <em>explanation</em>
 * @property open_period <em>Optional</em>. Amount of time in seconds the poll will be active after creation
 * @property close_date <em>Optional</em>. Point in time (Unix timestamp) when the poll will be automatically closed
 *
 * @constructor Creates a [Poll].
 * */
@Serializable
data class Poll(
    val id: String,
    val question: String,
    val options: List<PollOption>,
    val total_voter_count: Long,
    val is_closed: Boolean,
    val is_anonymous: Boolean,
    val type: String,
    val allows_multiple_answers: Boolean,
    val correct_option_id: Long? = null,
    val explanation: String? = null,
    val explanation_entities: List<MessageEntity>? = null,
    val open_period: Long? = null,
    val close_date: Long? = null,
) : TelegramModel() {
    override fun toJson() = json.encodeToString(serializer(), this)
    companion object {
        fun fromJson(string: String) = json.decodeFromString(serializer(), string)
    }
}

/**
 * <p>This object represents a point on the map.</p>
 *
 * @property longitude Longitude as defined by sender
 * @property latitude Latitude as defined by sender
 * @property horizontal_accuracy <em>Optional</em>. The radius of uncertainty for the location, measured in meters; 0-1500
 * @property live_period <em>Optional</em>. Time relative to the message sending date, during which the location can be updated; in seconds. For active live locations only.
 * @property heading <em>Optional</em>. The direction in which user is moving, in degrees; 1-360. For active live locations only.
 * @property proximity_alert_radius <em>Optional</em>. The maximum distance for proximity alerts about approaching another chat member, in meters. For sent live locations only.
 *
 * @constructor Creates a [Location].
 * */
@Serializable
data class Location(
    val longitude: Float,
    val latitude: Float,
    val horizontal_accuracy: Float? = null,
    val live_period: Long? = null,
    val heading: Long? = null,
    val proximity_alert_radius: Long? = null,
) : TelegramModel() {
    override fun toJson() = json.encodeToString(serializer(), this)
    companion object {
        fun fromJson(string: String) = json.decodeFromString(serializer(), string)
    }
}

/**
 * <p>This object represents a venue.</p>
 *
 * @property location Venue location. Can't be a live location
 * @property title Name of the venue
 * @property address Address of the venue
 * @property foursquare_id <em>Optional</em>. Foursquare identifier of the venue
 * @property foursquare_type <em>Optional</em>. Foursquare type of the venue. (For example, “arts_entertainment/default”, “arts_entertainment/aquarium” or “food/icecream”.)
 * @property google_place_id <em>Optional</em>. Google Places identifier of the venue
 * @property google_place_type <em>Optional</em>. Google Places type of the venue. (See <a href="https://developers.google.com/places/web-service/supported_types">supported types</a>.)
 *
 * @constructor Creates a [Venue].
 * */
@Serializable
data class Venue(
    val location: Location,
    val title: String,
    val address: String,
    val foursquare_id: String? = null,
    val foursquare_type: String? = null,
    val google_place_id: String? = null,
    val google_place_type: String? = null,
) : TelegramModel() {
    override fun toJson() = json.encodeToString(serializer(), this)
    companion object {
        fun fromJson(string: String) = json.decodeFromString(serializer(), string)
    }
}

/**
 * <p>Describes data sent from a <a href="/bots/webapps">Web App</a> to the bot.</p>
 *
 * @property data The data. Be aware that a bad client can send arbitrary data in this field.
 * @property button_text Text of the <em>web_app</em> keyboard button from which the Web App was opened. Be aware that a bad client can send arbitrary data in this field.
 *
 * @constructor Creates a [WebAppData].
 * */
@Serializable
data class WebAppData(
    val data: String,
    val button_text: String,
) : TelegramModel() {
    override fun toJson() = json.encodeToString(serializer(), this)
    companion object {
        fun fromJson(string: String) = json.decodeFromString(serializer(), string)
    }
}

/**
 * <p>This object represents the content of a service message, sent whenever a user in the chat triggers a proximity alert set by another user.</p>
 *
 * @property traveler User that triggered the alert
 * @property watcher User that set the alert
 * @property distance The distance between the users
 *
 * @constructor Creates a [ProximityAlertTriggered].
 * */
@Serializable
data class ProximityAlertTriggered(
    val traveler: User,
    val watcher: User,
    val distance: Long,
) : TelegramModel() {
    override fun toJson() = json.encodeToString(serializer(), this)
    companion object {
        fun fromJson(string: String) = json.decodeFromString(serializer(), string)
    }
}

/**
 * <p>This object represents a service message about a change in auto-delete timer settings.</p>
 *
 * @property message_auto_delete_time New auto-delete time for messages in the chat; in seconds
 *
 * @constructor Creates a [MessageAutoDeleteTimerChanged].
 * */
@Serializable
data class MessageAutoDeleteTimerChanged(
    val message_auto_delete_time: Long,
) : TelegramModel() {
    override fun toJson() = json.encodeToString(serializer(), this)
    companion object {
        fun fromJson(string: String) = json.decodeFromString(serializer(), string)
    }
}

/**
 * <p>This object represents a service message about a video chat scheduled in the chat.</p>
 *
 * @property start_date Point in time (Unix timestamp) when the video chat is supposed to be started by a chat administrator
 *
 * @constructor Creates a [VideoChatScheduled].
 * */
@Serializable
data class VideoChatScheduled(
    val start_date: Long,
) : TelegramModel() {
    override fun toJson() = json.encodeToString(serializer(), this)
    companion object {
        fun fromJson(string: String) = json.decodeFromString(serializer(), string)
    }
}

/**
 * <p>This object represents a service message about a video chat ended in the chat.</p>
 *
 * @property duration Video chat duration in seconds
 *
 * @constructor Creates a [VideoChatEnded].
 * */
@Serializable
data class VideoChatEnded(
    val duration: Long,
) : TelegramModel() {
    override fun toJson() = json.encodeToString(serializer(), this)
    companion object {
        fun fromJson(string: String) = json.decodeFromString(serializer(), string)
    }
}

/**
 * <p>This object represents a service message about new members invited to a video chat.</p>
 *
 * @property users New members that were invited to the video chat
 *
 * @constructor Creates a [VideoChatParticipantsInvited].
 * */
@Serializable
data class VideoChatParticipantsInvited(
    val users: List<User>,
) : TelegramModel() {
    override fun toJson() = json.encodeToString(serializer(), this)
    companion object {
        fun fromJson(string: String) = json.decodeFromString(serializer(), string)
    }
}

/**
 * <p>This object represent a user's profile pictures.</p>
 *
 * @property total_count Total number of profile pictures the target user has
 * @property photos Requested profile pictures (in up to 4 sizes each)
 *
 * @constructor Creates a [UserProfilePhotos].
 * */
@Serializable
data class UserProfilePhotos(
    val total_count: Long,
    val photos: List<List<PhotoSize>>,
) : TelegramModel() {
    override fun toJson() = json.encodeToString(serializer(), this)
    companion object {
        fun fromJson(string: String) = json.decodeFromString(serializer(), string)
    }
}

/**
 * <p>This object represents a file ready to be downloaded. The file can be downloaded via the link <code>https://api.telegram.org/file/bot&lt;token&gt;/&lt;file_path&gt;</code>. It is guaranteed that the link will be valid for at least 1 hour. When the link expires, a new one can be requested by calling <a href="#getfile">getFile</a>.</p><blockquote> 
 *  <p>The maximum file size to download is 20 MB</p> 
 * </blockquote>
 *
 * @property file_id Identifier for this file, which can be used to download or reuse the file
 * @property file_unique_id Unique identifier for this file, which is supposed to be the same over time and for different bots. Can't be used to download or reuse the file.
 * @property file_size <em>Optional</em>. File size in bytes. It can be bigger than 2^31 and some programming languages may have difficulty/silent defects in interpreting it. But it has at most 52 significant bits, so a signed 64-bit integer or double-precision float type are safe for storing this value.
 * @property file_path <em>Optional</em>. File path. Use <code>https://api.telegram.org/file/bot&lt;token&gt;/&lt;file_path&gt;</code> to get the file.
 *
 * @constructor Creates a [File].
 * */
@Serializable
data class File(
    val file_id: String,
    val file_unique_id: String,
    val file_size: Long? = null,
    val file_path: String? = null,
) : TelegramModel() {
    override fun toJson() = json.encodeToString(serializer(), this)
    companion object {
        fun fromJson(string: String) = json.decodeFromString(serializer(), string)
    }
}

/**
 * <p>Describes a <a href="/bots/webapps">Web App</a>.</p>
 *
 * @property url An HTTPS URL of a Web App to be opened with additional data as specified in <a href="/bots/webapps#initializing-web-apps">Initializing Web Apps</a>
 *
 * @constructor Creates a [WebAppInfo].
 * */
@Serializable
data class WebAppInfo(
    val url: String,
) : TelegramModel() {
    override fun toJson() = json.encodeToString(serializer(), this)
    companion object {
        fun fromJson(string: String) = json.decodeFromString(serializer(), string)
    }
}

/**
 * <p>This object represents a <a href="https://core.telegram.org/bots#keyboards">custom keyboard</a> with reply options (see <a href="https://core.telegram.org/bots#keyboards">Introduction to bots</a> for details and examples).</p>
 *
 * @property keyboard Array of button rows, each represented by an Array of <a href="#keyboardbutton">KeyboardButton</a> objects
 * @property resize_keyboard <em>Optional</em>. Requests clients to resize the keyboard vertically for optimal fit (e.g., make the keyboard smaller if there are just two rows of buttons). Defaults to <em>false</em>, in which case the custom keyboard is always of the same height as the app's standard keyboard.
 * @property one_time_keyboard <em>Optional</em>. Requests clients to hide the keyboard as soon as it's been used. The keyboard will still be available, but clients will automatically display the usual letter-keyboard in the chat - the user can press a special button in the input field to see the custom keyboard again. Defaults to <em>false</em>.
 * @property input_field_placeholder <em>Optional</em>. The placeholder to be shown in the input field when the keyboard is active; 1-64 characters
 * @property selective <em>Optional</em>. Use this parameter if you want to show the keyboard to specific users only. Targets: 1) users that are @mentioned in the <em>text</em> of the <a href="#message">Message</a> object; 2) if the bot's message is a reply (has <em>reply_to_message_id</em>), sender of the original message.<br><br><em>Example:</em> A user requests to change the bot's language, bot replies to the request with a keyboard to select the new language. Other users in the group don't see the keyboard.
 *
 * @constructor Creates a [ReplyKeyboardMarkup].
 * */
@Serializable
data class ReplyKeyboardMarkup(
    val keyboard: List<List<KeyboardButton>>,
    val resize_keyboard: Boolean? = null,
    val one_time_keyboard: Boolean? = null,
    val input_field_placeholder: String? = null,
    val selective: Boolean? = null,
) : KeyboardOption() {
    override fun toJson() = json.encodeToString(serializer(), this)
    companion object {
        fun fromJson(string: String) = json.decodeFromString(serializer(), string)
    }
}

/**
 * <p>This object represents one button of the reply keyboard. For simple text buttons <em>String</em> can be used instead of this object to specify text of the button. Optional fields <em>web_app</em>, <em>request_contact</em>, <em>request_location</em>, and <em>request_poll</em> are mutually exclusive.</p><p><strong>Note:</strong> <em>request_contact</em> and <em>request_location</em> options will only work in Telegram versions released after 9 April, 2016. Older clients will display <em>unsupported message</em>.<br><strong>Note:</strong> <em>request_poll</em> option will only work in Telegram versions released after 23 January, 2020. Older clients will display <em>unsupported message</em>.<br><strong>Note:</strong> <em>web_app</em> option will only work in Telegram versions released after 16 April, 2022. Older clients will display <em>unsupported message</em>.</p>
 *
 * @property text Text of the button. If none of the optional fields are used, it will be sent as a message when the button is pressed
 * @property request_contact <em>Optional</em>. If <em>True</em>, the user's phone number will be sent as a contact when the button is pressed. Available in private chats only.
 * @property request_location <em>Optional</em>. If <em>True</em>, the user's current location will be sent when the button is pressed. Available in private chats only.
 * @property request_poll <em>Optional</em>. If specified, the user will be asked to create a poll and send it to the bot when the button is pressed. Available in private chats only.
 * @property web_app <em>Optional</em>. If specified, the described <a href="/bots/webapps">Web App</a> will be launched when the button is pressed. The Web App will be able to send a “web_app_data” service message. Available in private chats only.
 *
 * @constructor Creates a [KeyboardButton].
 * */
@Serializable
data class KeyboardButton(
    val text: String,
    val request_contact: Boolean? = null,
    val request_location: Boolean? = null,
    val request_poll: KeyboardButtonPollType? = null,
    val web_app: WebAppInfo? = null,
) : TelegramModel() {
    override fun toJson() = json.encodeToString(serializer(), this)
    companion object {
        fun fromJson(string: String) = json.decodeFromString(serializer(), string)
    }
}

/**
 * <p>This object represents type of a poll, which is allowed to be created and sent when the corresponding button is pressed.</p>
 *
 * @property type <em>Optional</em>. If <em>quiz</em> is passed, the user will be allowed to create only polls in the quiz mode. If <em>regular</em> is passed, only regular polls will be allowed. Otherwise, the user will be allowed to create a poll of any type.
 *
 * @constructor Creates a [KeyboardButtonPollType].
 * */
@Serializable
data class KeyboardButtonPollType(
    val type: String? = null,
) : TelegramModel() {
    override fun toJson() = json.encodeToString(serializer(), this)
    companion object {
        fun fromJson(string: String) = json.decodeFromString(serializer(), string)
    }
}

/**
 * <p>Upon receiving a message with this object, Telegram clients will remove the current custom keyboard and display the default letter-keyboard. By default, custom keyboards are displayed until a new keyboard is sent by a bot. An exception is made for one-time keyboards that are hidden immediately after the user presses a button (see <a href="#replykeyboardmarkup">ReplyKeyboardMarkup</a>).</p>
 *
 * @property remove_keyboard Requests clients to remove the custom keyboard (user will not be able to summon this keyboard; if you want to hide the keyboard from sight but keep it accessible, use <em>one_time_keyboard</em> in <a href="#replykeyboardmarkup">ReplyKeyboardMarkup</a>)
 * @property selective <em>Optional</em>. Use this parameter if you want to remove the keyboard for specific users only. Targets: 1) users that are @mentioned in the <em>text</em> of the <a href="#message">Message</a> object; 2) if the bot's message is a reply (has <em>reply_to_message_id</em>), sender of the original message.<br><br><em>Example:</em> A user votes in a poll, bot returns confirmation message in reply to the vote and removes the keyboard for that user, while still showing the keyboard with poll options to users who haven't voted yet.
 *
 * @constructor Creates a [ReplyKeyboardRemove].
 * */
@Serializable
data class ReplyKeyboardRemove(
    val remove_keyboard: Boolean,
    val selective: Boolean? = null,
) : KeyboardOption() {
    override fun toJson() = json.encodeToString(serializer(), this)
    companion object {
        fun fromJson(string: String) = json.decodeFromString(serializer(), string)
    }
}

/**
 * <p>This object represents an <a href="https://core.telegram.org/bots#inline-keyboards-and-on-the-fly-updating">inline keyboard</a> that appears right next to the message it belongs to.</p><p><strong>Note:</strong> This will only work in Telegram versions released after 9 April, 2016. Older clients will display <em>unsupported message</em>.</p>
 *
 * @property inline_keyboard Array of button rows, each represented by an Array of <a href="#inlinekeyboardbutton">InlineKeyboardButton</a> objects
 *
 * @constructor Creates a [InlineKeyboardMarkup].
 * */
@Serializable
data class InlineKeyboardMarkup(
    val inline_keyboard: List<List<InlineKeyboardButton>>,
) : KeyboardOption() {
    override fun toJson() = json.encodeToString(serializer(), this)
    companion object {
        fun fromJson(string: String) = json.decodeFromString(serializer(), string)
    }
}

/**
 * <p>This object represents one button of an inline keyboard. You <strong>must</strong> use exactly one of the optional fields.</p>
 *
 * @property text Label text on the button
 * @property url <em>Optional</em>. HTTP or tg:// URL to be opened when the button is pressed. Links <code>tg://user?id=&lt;user_id&gt;</code> can be used to mention a user by their ID without using a username, if this is allowed by their privacy settings.
 * @property callback_data <em>Optional</em>. Data to be sent in a <a href="#callbackquery">callback query</a> to the bot when button is pressed, 1-64 bytes
 * @property web_app <em>Optional</em>. Description of the <a href="/bots/webapps">Web App</a> that will be launched when the user presses the button. The Web App will be able to send an arbitrary message on behalf of the user using the method <a href="#answerwebappquery">answerWebAppQuery</a>. Available only in private chats between a user and the bot.
 * @property login_url <em>Optional</em>. An HTTPS URL used to automatically authorize the user. Can be used as a replacement for the <a href="https://core.telegram.org/widgets/login">Telegram Login Widget</a>.
 * @property switch_inline_query <em>Optional</em>. If set, pressing the button will prompt the user to select one of their chats, open that chat and insert the bot's username and the specified inline query in the input field. May be empty, in which case just the bot's username will be inserted.<br><br><strong>Note:</strong> This offers an easy way for users to start using your bot in <a href="/bots/inline">inline mode</a> when they are currently in a private chat with it. Especially useful when combined with <a href="#answerinlinequery"><em>switch_pm…</em></a> actions - in this case the user will be automatically returned to the chat they switched from, skipping the chat selection screen.
 * @property switch_inline_query_current_chat <em>Optional</em>. If set, pressing the button will insert the bot's username and the specified inline query in the current chat's input field. May be empty, in which case only the bot's username will be inserted.<br><br>This offers a quick way for the user to open your bot in inline mode in the same chat - good for selecting something from multiple options.
 * @property callback_game <em>Optional</em>. Description of the game that will be launched when the user presses the button.<br><br><strong>NOTE:</strong> This type of button <strong>must</strong> always be the first button in the first row.
 * @property pay <em>Optional</em>. Specify <em>True</em>, to send a <a href="#payments">Pay button</a>.<br><br><strong>NOTE:</strong> This type of button <strong>must</strong> always be the first button in the first row and can only be used in invoice messages.
 *
 * @constructor Creates a [InlineKeyboardButton].
 * */
@Serializable
data class InlineKeyboardButton(
    val text: String,
    val url: String? = null,
    val callback_data: String? = null,
    val web_app: WebAppInfo? = null,
    val login_url: LoginUrl? = null,
    val switch_inline_query: String? = null,
    val switch_inline_query_current_chat: String? = null,
    val callback_game: @Contextual Any? = null,
    val pay: Boolean? = null,
) : TelegramModel() {
    override fun toJson() = json.encodeToString(serializer(), this)
    companion object {
        fun fromJson(string: String) = json.decodeFromString(serializer(), string)
    }
}

/**
 * <p>This object represents a parameter of the inline keyboard button used to automatically authorize a user. Serves as a great replacement for the <a href="https://core.telegram.org/widgets/login">Telegram Login Widget</a> when the user is coming from Telegram. All the user needs to do is tap/click a button and confirm that they want to log in:</p><p>Telegram apps support these buttons as of <a href="https://telegram.org/blog/privacy-discussions-web-bots#meet-seamless-web-bots">version 5.7</a>.</p><blockquote> 
 *  <p>Sample bot: <a href="https://t.me/discussbot">@discussbot</a></p> 
 * </blockquote>
 *
 * @property url An HTTP URL to be opened with user authorization data added to the query string when the button is pressed. If the user refuses to provide authorization data, the original URL without information about the user will be opened. The data added is the same as described in <a href="https://core.telegram.org/widgets/login#receiving-authorization-data">Receiving authorization data</a>.<br><br><strong>NOTE:</strong> You <strong>must</strong> always check the hash of the received data to verify the authentication and the integrity of the data as described in <a href="https://core.telegram.org/widgets/login#checking-authorization">Checking authorization</a>.
 * @property forward_text <em>Optional</em>. New text of the button in forwarded messages.
 * @property bot_username <em>Optional</em>. Username of a bot, which will be used for user authorization. See <a href="https://core.telegram.org/widgets/login#setting-up-a-bot">Setting up a bot</a> for more details. If not specified, the current bot's username will be assumed. The <em>url</em>'s domain must be the same as the domain linked with the bot. See <a href="https://core.telegram.org/widgets/login#linking-your-domain-to-the-bot">Linking your domain to the bot</a> for more details.
 * @property request_write_access <em>Optional</em>. Pass <em>True</em> to request the permission for your bot to send messages to the user.
 *
 * @constructor Creates a [LoginUrl].
 * */
@Serializable
data class LoginUrl(
    val url: String,
    val forward_text: String? = null,
    val bot_username: String? = null,
    val request_write_access: Boolean? = null,
) : TelegramModel() {
    override fun toJson() = json.encodeToString(serializer(), this)
    companion object {
        fun fromJson(string: String) = json.decodeFromString(serializer(), string)
    }
}

/**
 * <p>This object represents an incoming callback query from a callback button in an <a href="/bots#inline-keyboards-and-on-the-fly-updating">inline keyboard</a>. If the button that originated the query was attached to a message sent by the bot, the field <em>message</em> will be present. If the button was attached to a message sent via the bot (in <a href="#inline-mode">inline mode</a>), the field <em>inline_message_id</em> will be present. Exactly one of the fields <em>data</em> or <em>game_short_name</em> will be present.</p><blockquote> 
 *  <p><strong>NOTE:</strong> After the user presses a callback button, Telegram clients will display a progress bar until you call <a href="#answercallbackquery">answerCallbackQuery</a>. It is, therefore, necessary to react by calling <a href="#answercallbackquery">answerCallbackQuery</a> even if no notification to the user is needed (e.g., without specifying any of the optional parameters).</p> 
 * </blockquote>
 *
 * @property id Unique identifier for this query
 * @property from Sender
 * @property message <em>Optional</em>. Message with the callback button that originated the query. Note that message content and message date will not be available if the message is too old
 * @property inline_message_id <em>Optional</em>. Identifier of the message sent via the bot in inline mode, that originated the query.
 * @property chat_instance Global identifier, uniquely corresponding to the chat to which the message with the callback button was sent. Useful for high scores in <a href="#games">games</a>.
 * @property data <em>Optional</em>. Data associated with the callback button. Be aware that the message originated the query can contain no callback buttons with this data.
 * @property game_short_name <em>Optional</em>. Short name of a <a href="#games">Game</a> to be returned, serves as the unique identifier for the game
 *
 * @constructor Creates a [CallbackQuery].
 * */
@Serializable
data class CallbackQuery(
    val id: String,
    val from: User,
    val message: Message? = null,
    val inline_message_id: String? = null,
    val chat_instance: String,
    val data: String? = null,
    val game_short_name: String? = null,
) : TelegramModel() {
    override fun toJson() = json.encodeToString(serializer(), this)
    companion object {
        fun fromJson(string: String) = json.decodeFromString(serializer(), string)
    }
}

/**
 * <p>Upon receiving a message with this object, Telegram clients will display a reply interface to the user (act as if the user has selected the bot's message and tapped 'Reply'). This can be extremely useful if you want to create user-friendly step-by-step interfaces without having to sacrifice <a href="/bots#privacy-mode">privacy mode</a>.</p><blockquote> 
 *  <p><strong>Example:</strong> A <a href="https://t.me/PollBot">poll bot</a> for groups runs in privacy mode (only receives commands, replies to its messages and mentions). There could be two ways to create a new poll:</p> 
 *  <ul> 
 *   <li>Explain the user how to send a command with parameters (e.g. /newpoll question answer1 answer2). May be appealing for hardcore users but lacks modern day polish.</li> 
 *   <li>Guide the user through a step-by-step process. 'Please send me your question', 'Cool, now let's add the first answer option', 'Great. Keep adding answer options, then send /done when you're ready'.</li> 
 *  </ul> 
 *  <p>The last option is definitely more attractive. And if you use <a href="#forcereply">ForceReply</a> in your bot's questions, it will receive the user's answers even if it only receives replies, commands and mentions - without any extra work for the user.</p> 
 * </blockquote>
 *
 * @property force_reply Shows reply interface to the user, as if they manually selected the bot's message and tapped 'Reply'
 * @property input_field_placeholder <em>Optional</em>. The placeholder to be shown in the input field when the reply is active; 1-64 characters
 * @property selective <em>Optional</em>. Use this parameter if you want to force reply from specific users only. Targets: 1) users that are @mentioned in the <em>text</em> of the <a href="#message">Message</a> object; 2) if the bot's message is a reply (has <em>reply_to_message_id</em>), sender of the original message.
 *
 * @constructor Creates a [ForceReply].
 * */
@Serializable
data class ForceReply(
    val force_reply: Boolean,
    val input_field_placeholder: String? = null,
    val selective: Boolean? = null,
) : KeyboardOption() {
    override fun toJson() = json.encodeToString(serializer(), this)
    companion object {
        fun fromJson(string: String) = json.decodeFromString(serializer(), string)
    }
}

/**
 * <p>This object represents a chat photo.</p>
 *
 * @property small_file_id File identifier of small (160x160) chat photo. This file_id can be used only for photo download and only for as long as the photo is not changed.
 * @property small_file_unique_id Unique file identifier of small (160x160) chat photo, which is supposed to be the same over time and for different bots. Can't be used to download or reuse the file.
 * @property big_file_id File identifier of big (640x640) chat photo. This file_id can be used only for photo download and only for as long as the photo is not changed.
 * @property big_file_unique_id Unique file identifier of big (640x640) chat photo, which is supposed to be the same over time and for different bots. Can't be used to download or reuse the file.
 *
 * @constructor Creates a [ChatPhoto].
 * */
@Serializable
data class ChatPhoto(
    val small_file_id: String,
    val small_file_unique_id: String,
    val big_file_id: String,
    val big_file_unique_id: String,
) : TelegramModel() {
    override fun toJson() = json.encodeToString(serializer(), this)
    companion object {
        fun fromJson(string: String) = json.decodeFromString(serializer(), string)
    }
}

/**
 * <p>Represents an invite link for a chat.</p>
 *
 * @property invite_link The invite link. If the link was created by another chat administrator, then the second part of the link will be replaced with “…”.
 * @property creator Creator of the link
 * @property creates_join_request <em>True</em>, if users joining the chat via the link need to be approved by chat administrators
 * @property is_primary <em>True</em>, if the link is primary
 * @property is_revoked <em>True</em>, if the link is revoked
 * @property name <em>Optional</em>. Invite link name
 * @property expire_date <em>Optional</em>. Point in time (Unix timestamp) when the link will expire or has been expired
 * @property member_limit <em>Optional</em>. The maximum number of users that can be members of the chat simultaneously after joining the chat via this invite link; 1-99999
 * @property pending_join_request_count <em>Optional</em>. Number of pending join requests created using this link
 *
 * @constructor Creates a [ChatInviteLink].
 * */
@Serializable
data class ChatInviteLink(
    val invite_link: String,
    val creator: User,
    val creates_join_request: Boolean,
    val is_primary: Boolean,
    val is_revoked: Boolean,
    val name: String? = null,
    val expire_date: Long? = null,
    val member_limit: Long? = null,
    val pending_join_request_count: Long? = null,
) : TelegramModel() {
    override fun toJson() = json.encodeToString(serializer(), this)
    companion object {
        fun fromJson(string: String) = json.decodeFromString(serializer(), string)
    }
}

/**
 * <p>Represents the rights of an administrator in a chat.</p>
 *
 * @property is_anonymous <em>True</em>, if the user's presence in the chat is hidden
 * @property can_manage_chat <em>True</em>, if the administrator can access the chat event log, chat statistics, message statistics in channels, see channel members, see anonymous administrators in supergroups and ignore slow mode. Implied by any other administrator privilege
 * @property can_delete_messages <em>True</em>, if the administrator can delete messages of other users
 * @property can_manage_video_chats <em>True</em>, if the administrator can manage video chats
 * @property can_restrict_members <em>True</em>, if the administrator can restrict, ban or unban chat members
 * @property can_promote_members <em>True</em>, if the administrator can add new administrators with a subset of their own privileges or demote administrators that he has promoted, directly or indirectly (promoted by administrators that were appointed by the user)
 * @property can_change_info <em>True</em>, if the user is allowed to change the chat title, photo and other settings
 * @property can_invite_users <em>True</em>, if the user is allowed to invite new users to the chat
 * @property can_post_messages <em>Optional</em>. <em>True</em>, if the administrator can post in the channel; channels only
 * @property can_edit_messages <em>Optional</em>. <em>True</em>, if the administrator can edit messages of other users and can pin messages; channels only
 * @property can_pin_messages <em>Optional</em>. <em>True</em>, if the user is allowed to pin messages; groups and supergroups only
 *
 * @constructor Creates a [ChatAdministratorRights].
 * */
@Serializable
data class ChatAdministratorRights(
    val is_anonymous: Boolean,
    val can_manage_chat: Boolean,
    val can_delete_messages: Boolean,
    val can_manage_video_chats: Boolean,
    val can_restrict_members: Boolean,
    val can_promote_members: Boolean,
    val can_change_info: Boolean,
    val can_invite_users: Boolean,
    val can_post_messages: Boolean? = null,
    val can_edit_messages: Boolean? = null,
    val can_pin_messages: Boolean? = null,
) : TelegramModel() {
    override fun toJson() = json.encodeToString(serializer(), this)
    companion object {
        fun fromJson(string: String) = json.decodeFromString(serializer(), string)
    }
}

/**
 * <p>Represents a <a href="#chatmember">chat member</a> that owns the chat and has all administrator privileges.</p>
 *
 * @property status The member's status in the chat, always “creator”
 * @property user Information about the user
 * @property is_anonymous <em>True</em>, if the user's presence in the chat is hidden
 * @property custom_title <em>Optional</em>. Custom title for this user
 *
 * @constructor Creates a [ChatMemberOwner].
 * */
@Serializable
data class ChatMemberOwner(
    val status: String,
    val user: User,
    val is_anonymous: Boolean,
    val custom_title: String? = null,
) : ChatMember() {
    override fun toJson() = json.encodeToString(serializer(), this)
    companion object {
        fun fromJson(string: String) = json.decodeFromString(serializer(), string)
    }
}

/**
 * <p>Represents a <a href="#chatmember">chat member</a> that has some additional privileges.</p>
 *
 * @property status The member's status in the chat, always “administrator”
 * @property user Information about the user
 * @property can_be_edited <em>True</em>, if the bot is allowed to edit administrator privileges of that user
 * @property is_anonymous <em>True</em>, if the user's presence in the chat is hidden
 * @property can_manage_chat <em>True</em>, if the administrator can access the chat event log, chat statistics, message statistics in channels, see channel members, see anonymous administrators in supergroups and ignore slow mode. Implied by any other administrator privilege
 * @property can_delete_messages <em>True</em>, if the administrator can delete messages of other users
 * @property can_manage_video_chats <em>True</em>, if the administrator can manage video chats
 * @property can_restrict_members <em>True</em>, if the administrator can restrict, ban or unban chat members
 * @property can_promote_members <em>True</em>, if the administrator can add new administrators with a subset of their own privileges or demote administrators that he has promoted, directly or indirectly (promoted by administrators that were appointed by the user)
 * @property can_change_info <em>True</em>, if the user is allowed to change the chat title, photo and other settings
 * @property can_invite_users <em>True</em>, if the user is allowed to invite new users to the chat
 * @property can_post_messages <em>Optional</em>. <em>True</em>, if the administrator can post in the channel; channels only
 * @property can_edit_messages <em>Optional</em>. <em>True</em>, if the administrator can edit messages of other users and can pin messages; channels only
 * @property can_pin_messages <em>Optional</em>. <em>True</em>, if the user is allowed to pin messages; groups and supergroups only
 * @property custom_title <em>Optional</em>. Custom title for this user
 *
 * @constructor Creates a [ChatMemberAdministrator].
 * */
@Serializable
data class ChatMemberAdministrator(
    val status: String,
    val user: User,
    val can_be_edited: Boolean,
    val is_anonymous: Boolean,
    val can_manage_chat: Boolean,
    val can_delete_messages: Boolean,
    val can_manage_video_chats: Boolean,
    val can_restrict_members: Boolean,
    val can_promote_members: Boolean,
    val can_change_info: Boolean,
    val can_invite_users: Boolean,
    val can_post_messages: Boolean? = null,
    val can_edit_messages: Boolean? = null,
    val can_pin_messages: Boolean? = null,
    val custom_title: String? = null,
) : ChatMember() {
    override fun toJson() = json.encodeToString(serializer(), this)
    companion object {
        fun fromJson(string: String) = json.decodeFromString(serializer(), string)
    }
}

/**
 * <p>Represents a <a href="#chatmember">chat member</a> that has no additional privileges or restrictions.</p>
 *
 * @property status The member's status in the chat, always “member”
 * @property user Information about the user
 *
 * @constructor Creates a [ChatMemberMember].
 * */
@Serializable
data class ChatMemberMember(
    val status: String,
    val user: User,
) : ChatMember() {
    override fun toJson() = json.encodeToString(serializer(), this)
    companion object {
        fun fromJson(string: String) = json.decodeFromString(serializer(), string)
    }
}

/**
 * <p>Represents a <a href="#chatmember">chat member</a> that is under certain restrictions in the chat. Supergroups only.</p>
 *
 * @property status The member's status in the chat, always “restricted”
 * @property user Information about the user
 * @property is_member <em>True</em>, if the user is a member of the chat at the moment of the request
 * @property can_change_info <em>True</em>, if the user is allowed to change the chat title, photo and other settings
 * @property can_invite_users <em>True</em>, if the user is allowed to invite new users to the chat
 * @property can_pin_messages <em>True</em>, if the user is allowed to pin messages
 * @property can_send_messages <em>True</em>, if the user is allowed to send text messages, contacts, locations and venues
 * @property can_send_media_messages <em>True</em>, if the user is allowed to send audios, documents, photos, videos, video notes and voice notes
 * @property can_send_polls <em>True</em>, if the user is allowed to send polls
 * @property can_send_other_messages <em>True</em>, if the user is allowed to send animations, games, stickers and use inline bots
 * @property can_add_web_page_previews <em>True</em>, if the user is allowed to add web page previews to their messages
 * @property until_date Date when restrictions will be lifted for this user; unix time. If 0, then the user is restricted forever
 *
 * @constructor Creates a [ChatMemberRestricted].
 * */
@Serializable
data class ChatMemberRestricted(
    val status: String,
    val user: User,
    val is_member: Boolean,
    val can_change_info: Boolean,
    val can_invite_users: Boolean,
    val can_pin_messages: Boolean,
    val can_send_messages: Boolean,
    val can_send_media_messages: Boolean,
    val can_send_polls: Boolean,
    val can_send_other_messages: Boolean,
    val can_add_web_page_previews: Boolean,
    val until_date: Long,
) : ChatMember() {
    override fun toJson() = json.encodeToString(serializer(), this)
    companion object {
        fun fromJson(string: String) = json.decodeFromString(serializer(), string)
    }
}

/**
 * <p>Represents a <a href="#chatmember">chat member</a> that isn't currently a member of the chat, but may join it themselves.</p>
 *
 * @property status The member's status in the chat, always “left”
 * @property user Information about the user
 *
 * @constructor Creates a [ChatMemberLeft].
 * */
@Serializable
data class ChatMemberLeft(
    val status: String,
    val user: User,
) : ChatMember() {
    override fun toJson() = json.encodeToString(serializer(), this)
    companion object {
        fun fromJson(string: String) = json.decodeFromString(serializer(), string)
    }
}

/**
 * <p>Represents a <a href="#chatmember">chat member</a> that was banned in the chat and can't return to the chat or view chat messages.</p>
 *
 * @property status The member's status in the chat, always “kicked”
 * @property user Information about the user
 * @property until_date Date when restrictions will be lifted for this user; unix time. If 0, then the user is banned forever
 *
 * @constructor Creates a [ChatMemberBanned].
 * */
@Serializable
data class ChatMemberBanned(
    val status: String,
    val user: User,
    val until_date: Long,
) : ChatMember() {
    override fun toJson() = json.encodeToString(serializer(), this)
    companion object {
        fun fromJson(string: String) = json.decodeFromString(serializer(), string)
    }
}

/**
 * <p>This object represents changes in the status of a chat member.</p>
 *
 * @property chat Chat the user belongs to
 * @property from Performer of the action, which resulted in the change
 * @property date Date the change was done in Unix time
 * @property old_chat_member Previous information about the chat member
 * @property new_chat_member New information about the chat member
 * @property invite_link <em>Optional</em>. Chat invite link, which was used by the user to join the chat; for joining by invite link events only.
 *
 * @constructor Creates a [ChatMemberUpdated].
 * */
@Serializable
data class ChatMemberUpdated(
    val chat: Chat,
    val from: User,
    val date: Long,
    val old_chat_member: @Contextual ChatMember,
    val new_chat_member: @Contextual ChatMember,
    val invite_link: ChatInviteLink? = null,
) : ChatMember() {
    override fun toJson() = json.encodeToString(serializer(), this)
    companion object {
        fun fromJson(string: String) = json.decodeFromString(serializer(), string)
    }
}

/**
 * <p>Represents a join request sent to a chat.</p>
 *
 * @property chat Chat to which the request was sent
 * @property from User that sent the join request
 * @property date Date the request was sent in Unix time
 * @property bio <em>Optional</em>. Bio of the user.
 * @property invite_link <em>Optional</em>. Chat invite link that was used by the user to send the join request
 *
 * @constructor Creates a [ChatJoinRequest].
 * */
@Serializable
data class ChatJoinRequest(
    val chat: Chat,
    val from: User,
    val date: Long,
    val bio: String? = null,
    val invite_link: ChatInviteLink? = null,
) : TelegramModel() {
    override fun toJson() = json.encodeToString(serializer(), this)
    companion object {
        fun fromJson(string: String) = json.decodeFromString(serializer(), string)
    }
}

/**
 * <p>Describes actions that a non-administrator user is allowed to take in a chat.</p>
 *
 * @property can_send_messages <em>Optional</em>. <em>True</em>, if the user is allowed to send text messages, contacts, locations and venues
 * @property can_send_media_messages <em>Optional</em>. <em>True</em>, if the user is allowed to send audios, documents, photos, videos, video notes and voice notes, implies can_send_messages
 * @property can_send_polls <em>Optional</em>. <em>True</em>, if the user is allowed to send polls, implies can_send_messages
 * @property can_send_other_messages <em>Optional</em>. <em>True</em>, if the user is allowed to send animations, games, stickers and use inline bots, implies can_send_media_messages
 * @property can_add_web_page_previews <em>Optional</em>. <em>True</em>, if the user is allowed to add web page previews to their messages, implies can_send_media_messages
 * @property can_change_info <em>Optional</em>. <em>True</em>, if the user is allowed to change the chat title, photo and other settings. Ignored in public supergroups
 * @property can_invite_users <em>Optional</em>. <em>True</em>, if the user is allowed to invite new users to the chat
 * @property can_pin_messages <em>Optional</em>. <em>True</em>, if the user is allowed to pin messages. Ignored in public supergroups
 *
 * @constructor Creates a [ChatPermissions].
 * */
@Serializable
data class ChatPermissions(
    val can_send_messages: Boolean? = null,
    val can_send_media_messages: Boolean? = null,
    val can_send_polls: Boolean? = null,
    val can_send_other_messages: Boolean? = null,
    val can_add_web_page_previews: Boolean? = null,
    val can_change_info: Boolean? = null,
    val can_invite_users: Boolean? = null,
    val can_pin_messages: Boolean? = null,
) : TelegramModel() {
    override fun toJson() = json.encodeToString(serializer(), this)
    companion object {
        fun fromJson(string: String) = json.decodeFromString(serializer(), string)
    }
}

/**
 * <p>Represents a location to which a chat is connected.</p>
 *
 * @property location The location to which the supergroup is connected. Can't be a live location.
 * @property address Location address; 1-64 characters, as defined by the chat owner
 *
 * @constructor Creates a [ChatLocation].
 * */
@Serializable
data class ChatLocation(
    val location: Location,
    val address: String,
) : TelegramModel() {
    override fun toJson() = json.encodeToString(serializer(), this)
    companion object {
        fun fromJson(string: String) = json.decodeFromString(serializer(), string)
    }
}

/**
 * <p>This object represents a bot command.</p>
 *
 * @property command Text of the command; 1-32 characters. Can contain only lowercase English letters, digits and underscores.
 * @property description Description of the command; 1-256 characters.
 *
 * @constructor Creates a [BotCommand].
 * */
@Serializable
data class BotCommand(
    val command: String,
    val description: String,
) : TelegramModel() {
    override fun toJson() = json.encodeToString(serializer(), this)
    companion object {
        fun fromJson(string: String) = json.decodeFromString(serializer(), string)
    }
}

/**
 * <p>Represents the default <a href="#botcommandscope">scope</a> of bot commands. Default commands are used if no commands with a <a href="#determining-list-of-commands">narrower scope</a> are specified for the user.</p>
 *
 * @property type Scope type, must be <em>default</em>
 *
 * @constructor Creates a [BotCommandScopeDefault].
 * */
@Serializable
data class BotCommandScopeDefault(
    val type: String,
) : BotCommandScope() {
    override fun toJson() = json.encodeToString(serializer(), this)
    companion object {
        fun fromJson(string: String) = json.decodeFromString(serializer(), string)
    }
}

/**
 * <p>Represents the <a href="#botcommandscope">scope</a> of bot commands, covering all private chats.</p>
 *
 * @property type Scope type, must be <em>all_private_chats</em>
 *
 * @constructor Creates a [BotCommandScopeAllPrivateChats].
 * */
@Serializable
data class BotCommandScopeAllPrivateChats(
    val type: String,
) : BotCommandScope() {
    override fun toJson() = json.encodeToString(serializer(), this)
    companion object {
        fun fromJson(string: String) = json.decodeFromString(serializer(), string)
    }
}

/**
 * <p>Represents the <a href="#botcommandscope">scope</a> of bot commands, covering all group and supergroup chats.</p>
 *
 * @property type Scope type, must be <em>all_group_chats</em>
 *
 * @constructor Creates a [BotCommandScopeAllGroupChats].
 * */
@Serializable
data class BotCommandScopeAllGroupChats(
    val type: String,
) : BotCommandScope() {
    override fun toJson() = json.encodeToString(serializer(), this)
    companion object {
        fun fromJson(string: String) = json.decodeFromString(serializer(), string)
    }
}

/**
 * <p>Represents the <a href="#botcommandscope">scope</a> of bot commands, covering all group and supergroup chat administrators.</p>
 *
 * @property type Scope type, must be <em>all_chat_administrators</em>
 *
 * @constructor Creates a [BotCommandScopeAllChatAdministrators].
 * */
@Serializable
data class BotCommandScopeAllChatAdministrators(
    val type: String,
) : BotCommandScope() {
    override fun toJson() = json.encodeToString(serializer(), this)
    companion object {
        fun fromJson(string: String) = json.decodeFromString(serializer(), string)
    }
}

/**
 * <p>Represents the <a href="#botcommandscope">scope</a> of bot commands, covering a specific chat.</p>
 *
 * @property type Scope type, must be <em>chat</em>
 * @property chat_id Unique identifier for the target chat or username of the target supergroup (in the format <code>@supergroupusername</code>)
 *
 * @constructor Creates a [BotCommandScopeChat].
 * */
@Serializable
data class BotCommandScopeChat(
    val type: String,
    val chat_id: String,
) : BotCommandScope() {
    override fun toJson() = json.encodeToString(serializer(), this)
    companion object {
        fun fromJson(string: String) = json.decodeFromString(serializer(), string)
    }
}

/**
 * <p>Represents the <a href="#botcommandscope">scope</a> of bot commands, covering all administrators of a specific group or supergroup chat.</p>
 *
 * @property type Scope type, must be <em>chat_administrators</em>
 * @property chat_id Unique identifier for the target chat or username of the target supergroup (in the format <code>@supergroupusername</code>)
 *
 * @constructor Creates a [BotCommandScopeChatAdministrators].
 * */
@Serializable
data class BotCommandScopeChatAdministrators(
    val type: String,
    val chat_id: String,
) : BotCommandScope() {
    override fun toJson() = json.encodeToString(serializer(), this)
    companion object {
        fun fromJson(string: String) = json.decodeFromString(serializer(), string)
    }
}

/**
 * <p>Represents the <a href="#botcommandscope">scope</a> of bot commands, covering a specific member of a group or supergroup chat.</p>
 *
 * @property type Scope type, must be <em>chat_member</em>
 * @property chat_id Unique identifier for the target chat or username of the target supergroup (in the format <code>@supergroupusername</code>)
 * @property user_id Unique identifier of the target user
 *
 * @constructor Creates a [BotCommandScopeChatMember].
 * */
@Serializable
data class BotCommandScopeChatMember(
    val type: String,
    val chat_id: String,
    val user_id: Long,
) : BotCommandScope() {
    override fun toJson() = json.encodeToString(serializer(), this)
    companion object {
        fun fromJson(string: String) = json.decodeFromString(serializer(), string)
    }
}

/**
 * <p>Represents a menu button, which opens the bot's list of commands.</p>
 *
 * @property type Type of the button, must be <em>commands</em>
 *
 * @constructor Creates a [MenuButtonCommands].
 * */
@Serializable
data class MenuButtonCommands(
    val type: String,
) : MenuButton() {
    override fun toJson() = json.encodeToString(serializer(), this)
    companion object {
        fun fromJson(string: String) = json.decodeFromString(serializer(), string)
    }
}

/**
 * <p>Represents a menu button, which launches a <a href="/bots/webapps">Web App</a>.</p>
 *
 * @property type Type of the button, must be <em>web_app</em>
 * @property text Text on the button
 * @property web_app Description of the Web App that will be launched when the user presses the button. The Web App will be able to send an arbitrary message on behalf of the user using the method <a href="#answerwebappquery">answerWebAppQuery</a>.
 *
 * @constructor Creates a [MenuButtonWebApp].
 * */
@Serializable
data class MenuButtonWebApp(
    val type: String,
    val text: String,
    val web_app: WebAppInfo,
) : MenuButton() {
    override fun toJson() = json.encodeToString(serializer(), this)
    companion object {
        fun fromJson(string: String) = json.decodeFromString(serializer(), string)
    }
}

/**
 * <p>Describes that no specific value for the menu button was set.</p>
 *
 * @property type Type of the button, must be <em>default</em>
 *
 * @constructor Creates a [MenuButtonDefault].
 * */
@Serializable
data class MenuButtonDefault(
    val type: String,
) : MenuButton() {
    override fun toJson() = json.encodeToString(serializer(), this)
    companion object {
        fun fromJson(string: String) = json.decodeFromString(serializer(), string)
    }
}

/**
 * <p>Describes why a request was unsuccessful.</p>
 *
 * @property migrate_to_chat_id <em>Optional</em>. The group has been migrated to a supergroup with the specified identifier. This number may have more than 32 significant bits and some programming languages may have difficulty/silent defects in interpreting it. But it has at most 52 significant bits, so a signed 64-bit integer or double-precision float type are safe for storing this identifier.
 * @property retry_after <em>Optional</em>. In case of exceeding flood control, the number of seconds left to wait before the request can be repeated
 *
 * @constructor Creates a [ResponseParameters].
 * */
@Serializable
data class ResponseParameters(
    val migrate_to_chat_id: Long? = null,
    val retry_after: Long? = null,
) : TelegramModel() {
    override fun toJson() = json.encodeToString(serializer(), this)
    companion object {
        fun fromJson(string: String) = json.decodeFromString(serializer(), string)
    }
}

/**
 * <p>Represents a photo to be sent.</p>
 *
 * @property type Type of the result, must be <em>photo</em>
 * @property media File to send. Pass a file_id to send a file that exists on the Telegram servers (recommended), pass an HTTP URL for Telegram to get a file from the Internet, or pass “attach://&lt;file_attach_name&gt;” to upload a new one using multipart/form-data under &lt;file_attach_name&gt; name. <a href="#sending-files">More information on Sending Files »</a>
 * @property caption <em>Optional</em>. Caption of the photo to be sent, 0-1024 characters after entities parsing
 * @property parse_mode <em>Optional</em>. Mode for parsing entities in the photo caption. See <a href="#formatting-options">formatting options</a> for more details.
 * @property caption_entities <em>Optional</em>. List of special entities that appear in the caption, which can be specified instead of <em>parse_mode</em>
 *
 * @constructor Creates a [InputMediaPhoto].
 * */
@Serializable
data class InputMediaPhoto(
    val type: String,
    val media: String,
    val caption: String? = null,
    val parse_mode: ParseMode? = null,
    val caption_entities: List<MessageEntity>? = null,
) : InputMedia() {
    override fun toJson() = json.encodeToString(serializer(), this)
    companion object {
        fun fromJson(string: String) = json.decodeFromString(serializer(), string)
    }
}

/**
 * <p>Represents a video to be sent.</p>
 *
 * @property type Type of the result, must be <em>video</em>
 * @property media File to send. Pass a file_id to send a file that exists on the Telegram servers (recommended), pass an HTTP URL for Telegram to get a file from the Internet, or pass “attach://&lt;file_attach_name&gt;” to upload a new one using multipart/form-data under &lt;file_attach_name&gt; name. <a href="#sending-files">More information on Sending Files »</a>
 * @property thumb <em>Optional</em>. Thumbnail of the file sent; can be ignored if thumbnail generation for the file is supported server-side. The thumbnail should be in JPEG format and less than 200 kB in size. A thumbnail's width and height should not exceed 320. Ignored if the file is not uploaded using multipart/form-data. Thumbnails can't be reused and can be only uploaded as a new file, so you can pass “attach://&lt;file_attach_name&gt;” if the thumbnail was uploaded using multipart/form-data under &lt;file_attach_name&gt;. <a href="#sending-files">More information on Sending Files »</a>
 * @property caption <em>Optional</em>. Caption of the video to be sent, 0-1024 characters after entities parsing
 * @property parse_mode <em>Optional</em>. Mode for parsing entities in the video caption. See <a href="#formatting-options">formatting options</a> for more details.
 * @property caption_entities <em>Optional</em>. List of special entities that appear in the caption, which can be specified instead of <em>parse_mode</em>
 * @property width <em>Optional</em>. Video width
 * @property height <em>Optional</em>. Video height
 * @property duration <em>Optional</em>. Video duration in seconds
 * @property supports_streaming <em>Optional</em>. Pass <em>True</em>, if the uploaded video is suitable for streaming
 *
 * @constructor Creates a [InputMediaVideo].
 * */
@Serializable
data class InputMediaVideo(
    val type: String,
    val media: String,
    val thumb: String? = null,
    val caption: String? = null,
    val parse_mode: ParseMode? = null,
    val caption_entities: List<MessageEntity>? = null,
    val width: Long? = null,
    val height: Long? = null,
    val duration: Long? = null,
    val supports_streaming: Boolean? = null,
) : InputMedia() {
    override fun toJson() = json.encodeToString(serializer(), this)
    companion object {
        fun fromJson(string: String) = json.decodeFromString(serializer(), string)
    }
}

/**
 * <p>Represents an animation file (GIF or H.264/MPEG-4 AVC video without sound) to be sent.</p>
 *
 * @property type Type of the result, must be <em>animation</em>
 * @property media File to send. Pass a file_id to send a file that exists on the Telegram servers (recommended), pass an HTTP URL for Telegram to get a file from the Internet, or pass “attach://&lt;file_attach_name&gt;” to upload a new one using multipart/form-data under &lt;file_attach_name&gt; name. <a href="#sending-files">More information on Sending Files »</a>
 * @property thumb <em>Optional</em>. Thumbnail of the file sent; can be ignored if thumbnail generation for the file is supported server-side. The thumbnail should be in JPEG format and less than 200 kB in size. A thumbnail's width and height should not exceed 320. Ignored if the file is not uploaded using multipart/form-data. Thumbnails can't be reused and can be only uploaded as a new file, so you can pass “attach://&lt;file_attach_name&gt;” if the thumbnail was uploaded using multipart/form-data under &lt;file_attach_name&gt;. <a href="#sending-files">More information on Sending Files »</a>
 * @property caption <em>Optional</em>. Caption of the animation to be sent, 0-1024 characters after entities parsing
 * @property parse_mode <em>Optional</em>. Mode for parsing entities in the animation caption. See <a href="#formatting-options">formatting options</a> for more details.
 * @property caption_entities <em>Optional</em>. List of special entities that appear in the caption, which can be specified instead of <em>parse_mode</em>
 * @property width <em>Optional</em>. Animation width
 * @property height <em>Optional</em>. Animation height
 * @property duration <em>Optional</em>. Animation duration in seconds
 *
 * @constructor Creates a [InputMediaAnimation].
 * */
@Serializable
data class InputMediaAnimation(
    val type: String,
    val media: String,
    val thumb: String? = null,
    val caption: String? = null,
    val parse_mode: ParseMode? = null,
    val caption_entities: List<MessageEntity>? = null,
    val width: Long? = null,
    val height: Long? = null,
    val duration: Long? = null,
) : InputMedia() {
    override fun toJson() = json.encodeToString(serializer(), this)
    companion object {
        fun fromJson(string: String) = json.decodeFromString(serializer(), string)
    }
}

/**
 * <p>Represents an audio file to be treated as music to be sent.</p>
 *
 * @property type Type of the result, must be <em>audio</em>
 * @property media File to send. Pass a file_id to send a file that exists on the Telegram servers (recommended), pass an HTTP URL for Telegram to get a file from the Internet, or pass “attach://&lt;file_attach_name&gt;” to upload a new one using multipart/form-data under &lt;file_attach_name&gt; name. <a href="#sending-files">More information on Sending Files »</a>
 * @property thumb <em>Optional</em>. Thumbnail of the file sent; can be ignored if thumbnail generation for the file is supported server-side. The thumbnail should be in JPEG format and less than 200 kB in size. A thumbnail's width and height should not exceed 320. Ignored if the file is not uploaded using multipart/form-data. Thumbnails can't be reused and can be only uploaded as a new file, so you can pass “attach://&lt;file_attach_name&gt;” if the thumbnail was uploaded using multipart/form-data under &lt;file_attach_name&gt;. <a href="#sending-files">More information on Sending Files »</a>
 * @property caption <em>Optional</em>. Caption of the audio to be sent, 0-1024 characters after entities parsing
 * @property parse_mode <em>Optional</em>. Mode for parsing entities in the audio caption. See <a href="#formatting-options">formatting options</a> for more details.
 * @property caption_entities <em>Optional</em>. List of special entities that appear in the caption, which can be specified instead of <em>parse_mode</em>
 * @property duration <em>Optional</em>. Duration of the audio in seconds
 * @property performer <em>Optional</em>. Performer of the audio
 * @property title <em>Optional</em>. Title of the audio
 *
 * @constructor Creates a [InputMediaAudio].
 * */
@Serializable
data class InputMediaAudio(
    val type: String,
    val media: String,
    val thumb: String? = null,
    val caption: String? = null,
    val parse_mode: ParseMode? = null,
    val caption_entities: List<MessageEntity>? = null,
    val duration: Long? = null,
    val performer: String? = null,
    val title: String? = null,
) : InputMedia() {
    override fun toJson() = json.encodeToString(serializer(), this)
    companion object {
        fun fromJson(string: String) = json.decodeFromString(serializer(), string)
    }
}

/**
 * <p>Represents a general file to be sent.</p>
 *
 * @property type Type of the result, must be <em>document</em>
 * @property media File to send. Pass a file_id to send a file that exists on the Telegram servers (recommended), pass an HTTP URL for Telegram to get a file from the Internet, or pass “attach://&lt;file_attach_name&gt;” to upload a new one using multipart/form-data under &lt;file_attach_name&gt; name. <a href="#sending-files">More information on Sending Files »</a>
 * @property thumb <em>Optional</em>. Thumbnail of the file sent; can be ignored if thumbnail generation for the file is supported server-side. The thumbnail should be in JPEG format and less than 200 kB in size. A thumbnail's width and height should not exceed 320. Ignored if the file is not uploaded using multipart/form-data. Thumbnails can't be reused and can be only uploaded as a new file, so you can pass “attach://&lt;file_attach_name&gt;” if the thumbnail was uploaded using multipart/form-data under &lt;file_attach_name&gt;. <a href="#sending-files">More information on Sending Files »</a>
 * @property caption <em>Optional</em>. Caption of the document to be sent, 0-1024 characters after entities parsing
 * @property parse_mode <em>Optional</em>. Mode for parsing entities in the document caption. See <a href="#formatting-options">formatting options</a> for more details.
 * @property caption_entities <em>Optional</em>. List of special entities that appear in the caption, which can be specified instead of <em>parse_mode</em>
 * @property disable_content_type_detection <em>Optional</em>. Disables automatic server-side content type detection for files uploaded using multipart/form-data. Always <em>True</em>, if the document is sent as part of an album.
 *
 * @constructor Creates a [InputMediaDocument].
 * */
@Serializable
data class InputMediaDocument(
    val type: String,
    val media: String,
    val thumb: String? = null,
    val caption: String? = null,
    val parse_mode: ParseMode? = null,
    val caption_entities: List<MessageEntity>? = null,
    val disable_content_type_detection: Boolean? = null,
) : InputMedia() {
    override fun toJson() = json.encodeToString(serializer(), this)
    companion object {
        fun fromJson(string: String) = json.decodeFromString(serializer(), string)
    }
}


// Stickers

/**
 * <p>This object represents a sticker.</p>
 *
 * @property file_id Identifier for this file, which can be used to download or reuse the file
 * @property file_unique_id Unique identifier for this file, which is supposed to be the same over time and for different bots. Can't be used to download or reuse the file.
 * @property width Sticker width
 * @property height Sticker height
 * @property is_animated <em>True</em>, if the sticker is <a href="https://telegram.org/blog/animated-stickers">animated</a>
 * @property is_video <em>True</em>, if the sticker is a <a href="https://telegram.org/blog/video-stickers-better-reactions">video sticker</a>
 * @property thumb <em>Optional</em>. Sticker thumbnail in the .WEBP or .JPG format
 * @property emoji <em>Optional</em>. Emoji associated with the sticker
 * @property set_name <em>Optional</em>. Name of the sticker set to which the sticker belongs
 * @property premium_animation <em>Optional</em>. Premium animation for the sticker, if the sticker is premium
 * @property mask_position <em>Optional</em>. For mask stickers, the position where the mask should be placed
 * @property file_size <em>Optional</em>. File size in bytes
 *
 * @constructor Creates a [Sticker].
 * */
@Serializable
data class Sticker(
    val file_id: String,
    val file_unique_id: String,
    val width: Long,
    val height: Long,
    val is_animated: Boolean,
    val is_video: Boolean,
    val thumb: PhotoSize? = null,
    val emoji: String? = null,
    val set_name: String? = null,
    val premium_animation: File? = null,
    val mask_position: MaskPosition? = null,
    val file_size: Long? = null,
) : TelegramModel() {
    override fun toJson() = json.encodeToString(serializer(), this)
    companion object {
        fun fromJson(string: String) = json.decodeFromString(serializer(), string)
    }
}

/**
 * <p>This object represents a sticker set.</p>
 *
 * @property name Sticker set name
 * @property title Sticker set title
 * @property is_animated <em>True</em>, if the sticker set contains <a href="https://telegram.org/blog/animated-stickers">animated stickers</a>
 * @property is_video <em>True</em>, if the sticker set contains <a href="https://telegram.org/blog/video-stickers-better-reactions">video stickers</a>
 * @property contains_masks <em>True</em>, if the sticker set contains masks
 * @property stickers List of all set stickers
 * @property thumb <em>Optional</em>. Sticker set thumbnail in the .WEBP, .TGS, or .WEBM format
 *
 * @constructor Creates a [StickerSet].
 * */
@Serializable
data class StickerSet(
    val name: String,
    val title: String,
    val is_animated: Boolean,
    val is_video: Boolean,
    val contains_masks: Boolean,
    val stickers: List<Sticker>,
    val thumb: PhotoSize? = null,
) : TelegramModel() {
    override fun toJson() = json.encodeToString(serializer(), this)
    companion object {
        fun fromJson(string: String) = json.decodeFromString(serializer(), string)
    }
}

/**
 * <p>This object describes the position on faces where a mask should be placed by default.</p>
 *
 * @property point The part of the face relative to which the mask should be placed. One of “forehead”, “eyes”, “mouth”, or “chin”.
 * @property x_shift Shift by X-axis measured in widths of the mask scaled to the face size, from left to right. For example, choosing -1.0 will place mask just to the left of the default mask position.
 * @property y_shift Shift by Y-axis measured in heights of the mask scaled to the face size, from top to bottom. For example, 1.0 will place the mask just below the default mask position.
 * @property scale Mask scaling coefficient. For example, 2.0 means double size.
 *
 * @constructor Creates a [MaskPosition].
 * */
@Serializable
data class MaskPosition(
    val point: String,
    val x_shift: Float,
    val y_shift: Float,
    val scale: Float,
) : TelegramModel() {
    override fun toJson() = json.encodeToString(serializer(), this)
    companion object {
        fun fromJson(string: String) = json.decodeFromString(serializer(), string)
    }
}


// Inline mode

/**
 * <p>This object represents an incoming inline query. When the user sends an empty query, your bot could return some default or trending results.</p>
 *
 * @property id Unique identifier for this query
 * @property from Sender
 * @property query Text of the query (up to 256 characters)
 * @property offset Offset of the results to be returned, can be controlled by the bot
 * @property chat_type <em>Optional</em>. Type of the chat from which the inline query was sent. Can be either “sender” for a private chat with the inline query sender, “private”, “group”, “supergroup”, or “channel”. The chat type should be always known for requests sent from official clients and most third-party clients, unless the request was sent from a secret chat
 * @property location <em>Optional</em>. Sender location, only for bots that request user location
 *
 * @constructor Creates a [InlineQuery].
 * */
@Serializable
data class InlineQuery(
    val id: String,
    val from: User,
    val query: String,
    val offset: String,
    val chat_type: String? = null,
    val location: Location? = null,
) : TelegramModel() {
    override fun toJson() = json.encodeToString(serializer(), this)
    companion object {
        fun fromJson(string: String) = json.decodeFromString(serializer(), string)
    }
}

/**
 * <p>Represents a link to an article or web page.</p>
 *
 * @property type Type of the result, must be <em>article</em>
 * @property id Unique identifier for this result, 1-64 Bytes
 * @property title Title of the result
 * @property input_message_content Content of the message to be sent
 * @property reply_markup <em>Optional</em>. <a href="/bots#inline-keyboards-and-on-the-fly-updating">Inline keyboard</a> attached to the message
 * @property url <em>Optional</em>. URL of the result
 * @property hide_url <em>Optional</em>. Pass <em>True</em>, if you don't want the URL to be shown in the message
 * @property description <em>Optional</em>. Short description of the result
 * @property thumb_url <em>Optional</em>. Url of the thumbnail for the result
 * @property thumb_width <em>Optional</em>. Thumbnail width
 * @property thumb_height <em>Optional</em>. Thumbnail height
 *
 * @constructor Creates a [InlineQueryResultArticle].
 * */
@Serializable
data class InlineQueryResultArticle(
    val type: String,
    val id: String,
    val title: String,
    val input_message_content: @Contextual InputMessageContent,
    val reply_markup: InlineKeyboardMarkup? = null,
    val url: String? = null,
    val hide_url: Boolean? = null,
    val description: String? = null,
    val thumb_url: String? = null,
    val thumb_width: Long? = null,
    val thumb_height: Long? = null,
) : InlineQueryResult() {
    override fun toJson() = json.encodeToString(serializer(), this)
    companion object {
        fun fromJson(string: String) = json.decodeFromString(serializer(), string)
    }
}

/**
 * <p>Represents a link to a photo. By default, this photo will be sent by the user with optional caption. Alternatively, you can use <em>input_message_content</em> to send a message with the specified content instead of the photo.</p>
 *
 * @property type Type of the result, must be <em>photo</em>
 * @property id Unique identifier for this result, 1-64 bytes
 * @property photo_url A valid URL of the photo. Photo must be in <strong>JPEG</strong> format. Photo size must not exceed 5MB
 * @property thumb_url URL of the thumbnail for the photo
 * @property photo_width <em>Optional</em>. Width of the photo
 * @property photo_height <em>Optional</em>. Height of the photo
 * @property title <em>Optional</em>. Title for the result
 * @property description <em>Optional</em>. Short description of the result
 * @property caption <em>Optional</em>. Caption of the photo to be sent, 0-1024 characters after entities parsing
 * @property parse_mode <em>Optional</em>. Mode for parsing entities in the photo caption. See <a href="#formatting-options">formatting options</a> for more details.
 * @property caption_entities <em>Optional</em>. List of special entities that appear in the caption, which can be specified instead of <em>parse_mode</em>
 * @property reply_markup <em>Optional</em>. <a href="/bots#inline-keyboards-and-on-the-fly-updating">Inline keyboard</a> attached to the message
 * @property input_message_content <em>Optional</em>. Content of the message to be sent instead of the photo
 *
 * @constructor Creates a [InlineQueryResultPhoto].
 * */
@Serializable
data class InlineQueryResultPhoto(
    val type: String,
    val id: String,
    val photo_url: String,
    val thumb_url: String,
    val photo_width: Long? = null,
    val photo_height: Long? = null,
    val title: String? = null,
    val description: String? = null,
    val caption: String? = null,
    val parse_mode: ParseMode? = null,
    val caption_entities: List<MessageEntity>? = null,
    val reply_markup: InlineKeyboardMarkup? = null,
    val input_message_content: @Contextual InputMessageContent? = null,
) : InlineQueryResult() {
    override fun toJson() = json.encodeToString(serializer(), this)
    companion object {
        fun fromJson(string: String) = json.decodeFromString(serializer(), string)
    }
}

/**
 * <p>Represents a link to an animated GIF file. By default, this animated GIF file will be sent by the user with optional caption. Alternatively, you can use <em>input_message_content</em> to send a message with the specified content instead of the animation.</p>
 *
 * @property type Type of the result, must be <em>gif</em>
 * @property id Unique identifier for this result, 1-64 bytes
 * @property gif_url A valid URL for the GIF file. File size must not exceed 1MB
 * @property gif_width <em>Optional</em>. Width of the GIF
 * @property gif_height <em>Optional</em>. Height of the GIF
 * @property gif_duration <em>Optional</em>. Duration of the GIF in seconds
 * @property thumb_url URL of the static (JPEG or GIF) or animated (MPEG4) thumbnail for the result
 * @property thumb_mime_type <em>Optional</em>. MIME type of the thumbnail, must be one of “image/jpeg”, “image/gif”, or “video/mp4”. Defaults to “image/jpeg”
 * @property title <em>Optional</em>. Title for the result
 * @property caption <em>Optional</em>. Caption of the GIF file to be sent, 0-1024 characters after entities parsing
 * @property parse_mode <em>Optional</em>. Mode for parsing entities in the caption. See <a href="#formatting-options">formatting options</a> for more details.
 * @property caption_entities <em>Optional</em>. List of special entities that appear in the caption, which can be specified instead of <em>parse_mode</em>
 * @property reply_markup <em>Optional</em>. <a href="/bots#inline-keyboards-and-on-the-fly-updating">Inline keyboard</a> attached to the message
 * @property input_message_content <em>Optional</em>. Content of the message to be sent instead of the GIF animation
 *
 * @constructor Creates a [InlineQueryResultGif].
 * */
@Serializable
data class InlineQueryResultGif(
    val type: String,
    val id: String,
    val gif_url: String,
    val gif_width: Long? = null,
    val gif_height: Long? = null,
    val gif_duration: Long? = null,
    val thumb_url: String,
    val thumb_mime_type: String? = null,
    val title: String? = null,
    val caption: String? = null,
    val parse_mode: ParseMode? = null,
    val caption_entities: List<MessageEntity>? = null,
    val reply_markup: InlineKeyboardMarkup? = null,
    val input_message_content: @Contextual InputMessageContent? = null,
) : InlineQueryResult() {
    override fun toJson() = json.encodeToString(serializer(), this)
    companion object {
        fun fromJson(string: String) = json.decodeFromString(serializer(), string)
    }
}

/**
 * <p>Represents a link to a video animation (H.264/MPEG-4 AVC video without sound). By default, this animated MPEG-4 file will be sent by the user with optional caption. Alternatively, you can use <em>input_message_content</em> to send a message with the specified content instead of the animation.</p>
 *
 * @property type Type of the result, must be <em>mpeg4_gif</em>
 * @property id Unique identifier for this result, 1-64 bytes
 * @property mpeg4_url A valid URL for the MPEG4 file. File size must not exceed 1MB
 * @property mpeg4_width <em>Optional</em>. Video width
 * @property mpeg4_height <em>Optional</em>. Video height
 * @property mpeg4_duration <em>Optional</em>. Video duration in seconds
 * @property thumb_url URL of the static (JPEG or GIF) or animated (MPEG4) thumbnail for the result
 * @property thumb_mime_type <em>Optional</em>. MIME type of the thumbnail, must be one of “image/jpeg”, “image/gif”, or “video/mp4”. Defaults to “image/jpeg”
 * @property title <em>Optional</em>. Title for the result
 * @property caption <em>Optional</em>. Caption of the MPEG-4 file to be sent, 0-1024 characters after entities parsing
 * @property parse_mode <em>Optional</em>. Mode for parsing entities in the caption. See <a href="#formatting-options">formatting options</a> for more details.
 * @property caption_entities <em>Optional</em>. List of special entities that appear in the caption, which can be specified instead of <em>parse_mode</em>
 * @property reply_markup <em>Optional</em>. <a href="/bots#inline-keyboards-and-on-the-fly-updating">Inline keyboard</a> attached to the message
 * @property input_message_content <em>Optional</em>. Content of the message to be sent instead of the video animation
 *
 * @constructor Creates a [InlineQueryResultMpeg4Gif].
 * */
@Serializable
data class InlineQueryResultMpeg4Gif(
    val type: String,
    val id: String,
    val mpeg4_url: String,
    val mpeg4_width: Long? = null,
    val mpeg4_height: Long? = null,
    val mpeg4_duration: Long? = null,
    val thumb_url: String,
    val thumb_mime_type: String? = null,
    val title: String? = null,
    val caption: String? = null,
    val parse_mode: ParseMode? = null,
    val caption_entities: List<MessageEntity>? = null,
    val reply_markup: InlineKeyboardMarkup? = null,
    val input_message_content: @Contextual InputMessageContent? = null,
) : InlineQueryResult() {
    override fun toJson() = json.encodeToString(serializer(), this)
    companion object {
        fun fromJson(string: String) = json.decodeFromString(serializer(), string)
    }
}

/**
 * <p>Represents a link to a page containing an embedded video player or a video file. By default, this video file will be sent by the user with an optional caption. Alternatively, you can use <em>input_message_content</em> to send a message with the specified content instead of the video.</p><blockquote> 
 *  <p>If an InlineQueryResultVideo message contains an embedded video (e.g., YouTube), you <strong>must</strong> replace its content using <em>input_message_content</em>.</p> 
 * </blockquote>
 *
 * @property type Type of the result, must be <em>video</em>
 * @property id Unique identifier for this result, 1-64 bytes
 * @property video_url A valid URL for the embedded video player or video file
 * @property mime_type MIME type of the content of the video URL, “text/html” or “video/mp4”
 * @property thumb_url URL of the thumbnail (JPEG only) for the video
 * @property title Title for the result
 * @property caption <em>Optional</em>. Caption of the video to be sent, 0-1024 characters after entities parsing
 * @property parse_mode <em>Optional</em>. Mode for parsing entities in the video caption. See <a href="#formatting-options">formatting options</a> for more details.
 * @property caption_entities <em>Optional</em>. List of special entities that appear in the caption, which can be specified instead of <em>parse_mode</em>
 * @property video_width <em>Optional</em>. Video width
 * @property video_height <em>Optional</em>. Video height
 * @property video_duration <em>Optional</em>. Video duration in seconds
 * @property description <em>Optional</em>. Short description of the result
 * @property reply_markup <em>Optional</em>. <a href="/bots#inline-keyboards-and-on-the-fly-updating">Inline keyboard</a> attached to the message
 * @property input_message_content <em>Optional</em>. Content of the message to be sent instead of the video. This field is <strong>required</strong> if InlineQueryResultVideo is used to send an HTML-page as a result (e.g., a YouTube video).
 *
 * @constructor Creates a [InlineQueryResultVideo].
 * */
@Serializable
data class InlineQueryResultVideo(
    val type: String,
    val id: String,
    val video_url: String,
    val mime_type: String,
    val thumb_url: String,
    val title: String,
    val caption: String? = null,
    val parse_mode: ParseMode? = null,
    val caption_entities: List<MessageEntity>? = null,
    val video_width: Long? = null,
    val video_height: Long? = null,
    val video_duration: Long? = null,
    val description: String? = null,
    val reply_markup: InlineKeyboardMarkup? = null,
    val input_message_content: @Contextual InputMessageContent? = null,
) : InlineQueryResult() {
    override fun toJson() = json.encodeToString(serializer(), this)
    companion object {
        fun fromJson(string: String) = json.decodeFromString(serializer(), string)
    }
}

/**
 * <p>Represents a link to an MP3 audio file. By default, this audio file will be sent by the user. Alternatively, you can use <em>input_message_content</em> to send a message with the specified content instead of the audio.</p><p><strong>Note:</strong> This will only work in Telegram versions released after 9 April, 2016. Older clients will ignore them.</p>
 *
 * @property type Type of the result, must be <em>audio</em>
 * @property id Unique identifier for this result, 1-64 bytes
 * @property audio_url A valid URL for the audio file
 * @property title Title
 * @property caption <em>Optional</em>. Caption, 0-1024 characters after entities parsing
 * @property parse_mode <em>Optional</em>. Mode for parsing entities in the audio caption. See <a href="#formatting-options">formatting options</a> for more details.
 * @property caption_entities <em>Optional</em>. List of special entities that appear in the caption, which can be specified instead of <em>parse_mode</em>
 * @property performer <em>Optional</em>. Performer
 * @property audio_duration <em>Optional</em>. Audio duration in seconds
 * @property reply_markup <em>Optional</em>. <a href="/bots#inline-keyboards-and-on-the-fly-updating">Inline keyboard</a> attached to the message
 * @property input_message_content <em>Optional</em>. Content of the message to be sent instead of the audio
 *
 * @constructor Creates a [InlineQueryResultAudio].
 * */
@Serializable
data class InlineQueryResultAudio(
    val type: String,
    val id: String,
    val audio_url: String,
    val title: String,
    val caption: String? = null,
    val parse_mode: ParseMode? = null,
    val caption_entities: List<MessageEntity>? = null,
    val performer: String? = null,
    val audio_duration: Long? = null,
    val reply_markup: InlineKeyboardMarkup? = null,
    val input_message_content: @Contextual InputMessageContent? = null,
) : InlineQueryResult() {
    override fun toJson() = json.encodeToString(serializer(), this)
    companion object {
        fun fromJson(string: String) = json.decodeFromString(serializer(), string)
    }
}

/**
 * <p>Represents a link to a voice recording in an .OGG container encoded with OPUS. By default, this voice recording will be sent by the user. Alternatively, you can use <em>input_message_content</em> to send a message with the specified content instead of the the voice message.</p><p><strong>Note:</strong> This will only work in Telegram versions released after 9 April, 2016. Older clients will ignore them.</p>
 *
 * @property type Type of the result, must be <em>voice</em>
 * @property id Unique identifier for this result, 1-64 bytes
 * @property voice_url A valid URL for the voice recording
 * @property title Recording title
 * @property caption <em>Optional</em>. Caption, 0-1024 characters after entities parsing
 * @property parse_mode <em>Optional</em>. Mode for parsing entities in the voice message caption. See <a href="#formatting-options">formatting options</a> for more details.
 * @property caption_entities <em>Optional</em>. List of special entities that appear in the caption, which can be specified instead of <em>parse_mode</em>
 * @property voice_duration <em>Optional</em>. Recording duration in seconds
 * @property reply_markup <em>Optional</em>. <a href="/bots#inline-keyboards-and-on-the-fly-updating">Inline keyboard</a> attached to the message
 * @property input_message_content <em>Optional</em>. Content of the message to be sent instead of the voice recording
 *
 * @constructor Creates a [InlineQueryResultVoice].
 * */
@Serializable
data class InlineQueryResultVoice(
    val type: String,
    val id: String,
    val voice_url: String,
    val title: String,
    val caption: String? = null,
    val parse_mode: ParseMode? = null,
    val caption_entities: List<MessageEntity>? = null,
    val voice_duration: Long? = null,
    val reply_markup: InlineKeyboardMarkup? = null,
    val input_message_content: @Contextual InputMessageContent? = null,
) : InlineQueryResult() {
    override fun toJson() = json.encodeToString(serializer(), this)
    companion object {
        fun fromJson(string: String) = json.decodeFromString(serializer(), string)
    }
}

/**
 * <p>Represents a link to a file. By default, this file will be sent by the user with an optional caption. Alternatively, you can use <em>input_message_content</em> to send a message with the specified content instead of the file. Currently, only <strong>.PDF</strong> and <strong>.ZIP</strong> files can be sent using this method.</p><p><strong>Note:</strong> This will only work in Telegram versions released after 9 April, 2016. Older clients will ignore them.</p>
 *
 * @property type Type of the result, must be <em>document</em>
 * @property id Unique identifier for this result, 1-64 bytes
 * @property title Title for the result
 * @property caption <em>Optional</em>. Caption of the document to be sent, 0-1024 characters after entities parsing
 * @property parse_mode <em>Optional</em>. Mode for parsing entities in the document caption. See <a href="#formatting-options">formatting options</a> for more details.
 * @property caption_entities <em>Optional</em>. List of special entities that appear in the caption, which can be specified instead of <em>parse_mode</em>
 * @property document_url A valid URL for the file
 * @property mime_type MIME type of the content of the file, either “application/pdf” or “application/zip”
 * @property description <em>Optional</em>. Short description of the result
 * @property reply_markup <em>Optional</em>. Inline keyboard attached to the message
 * @property input_message_content <em>Optional</em>. Content of the message to be sent instead of the file
 * @property thumb_url <em>Optional</em>. URL of the thumbnail (JPEG only) for the file
 * @property thumb_width <em>Optional</em>. Thumbnail width
 * @property thumb_height <em>Optional</em>. Thumbnail height
 *
 * @constructor Creates a [InlineQueryResultDocument].
 * */
@Serializable
data class InlineQueryResultDocument(
    val type: String,
    val id: String,
    val title: String,
    val caption: String? = null,
    val parse_mode: ParseMode? = null,
    val caption_entities: List<MessageEntity>? = null,
    val document_url: String,
    val mime_type: String,
    val description: String? = null,
    val reply_markup: InlineKeyboardMarkup? = null,
    val input_message_content: @Contextual InputMessageContent? = null,
    val thumb_url: String? = null,
    val thumb_width: Long? = null,
    val thumb_height: Long? = null,
) : InlineQueryResult() {
    override fun toJson() = json.encodeToString(serializer(), this)
    companion object {
        fun fromJson(string: String) = json.decodeFromString(serializer(), string)
    }
}

/**
 * <p>Represents a location on a map. By default, the location will be sent by the user. Alternatively, you can use <em>input_message_content</em> to send a message with the specified content instead of the location.</p><p><strong>Note:</strong> This will only work in Telegram versions released after 9 April, 2016. Older clients will ignore them.</p>
 *
 * @property type Type of the result, must be <em>location</em>
 * @property id Unique identifier for this result, 1-64 Bytes
 * @property latitude Location latitude in degrees
 * @property longitude Location longitude in degrees
 * @property title Location title
 * @property horizontal_accuracy <em>Optional</em>. The radius of uncertainty for the location, measured in meters; 0-1500
 * @property live_period <em>Optional</em>. Period in seconds for which the location can be updated, should be between 60 and 86400.
 * @property heading <em>Optional</em>. For live locations, a direction in which the user is moving, in degrees. Must be between 1 and 360 if specified.
 * @property proximity_alert_radius <em>Optional</em>. For live locations, a maximum distance for proximity alerts about approaching another chat member, in meters. Must be between 1 and 100000 if specified.
 * @property reply_markup <em>Optional</em>. <a href="/bots#inline-keyboards-and-on-the-fly-updating">Inline keyboard</a> attached to the message
 * @property input_message_content <em>Optional</em>. Content of the message to be sent instead of the location
 * @property thumb_url <em>Optional</em>. Url of the thumbnail for the result
 * @property thumb_width <em>Optional</em>. Thumbnail width
 * @property thumb_height <em>Optional</em>. Thumbnail height
 *
 * @constructor Creates a [InlineQueryResultLocation].
 * */
@Serializable
data class InlineQueryResultLocation(
    val type: String,
    val id: String,
    val latitude: Float,
    val longitude: Float,
    val title: String,
    val horizontal_accuracy: Float? = null,
    val live_period: Long? = null,
    val heading: Long? = null,
    val proximity_alert_radius: Long? = null,
    val reply_markup: InlineKeyboardMarkup? = null,
    val input_message_content: @Contextual InputMessageContent? = null,
    val thumb_url: String? = null,
    val thumb_width: Long? = null,
    val thumb_height: Long? = null,
) : InlineQueryResult() {
    override fun toJson() = json.encodeToString(serializer(), this)
    companion object {
        fun fromJson(string: String) = json.decodeFromString(serializer(), string)
    }
}

/**
 * <p>Represents a venue. By default, the venue will be sent by the user. Alternatively, you can use <em>input_message_content</em> to send a message with the specified content instead of the venue.</p><p><strong>Note:</strong> This will only work in Telegram versions released after 9 April, 2016. Older clients will ignore them.</p>
 *
 * @property type Type of the result, must be <em>venue</em>
 * @property id Unique identifier for this result, 1-64 Bytes
 * @property latitude Latitude of the venue location in degrees
 * @property longitude Longitude of the venue location in degrees
 * @property title Title of the venue
 * @property address Address of the venue
 * @property foursquare_id <em>Optional</em>. Foursquare identifier of the venue if known
 * @property foursquare_type <em>Optional</em>. Foursquare type of the venue, if known. (For example, “arts_entertainment/default”, “arts_entertainment/aquarium” or “food/icecream”.)
 * @property google_place_id <em>Optional</em>. Google Places identifier of the venue
 * @property google_place_type <em>Optional</em>. Google Places type of the venue. (See <a href="https://developers.google.com/places/web-service/supported_types">supported types</a>.)
 * @property reply_markup <em>Optional</em>. <a href="/bots#inline-keyboards-and-on-the-fly-updating">Inline keyboard</a> attached to the message
 * @property input_message_content <em>Optional</em>. Content of the message to be sent instead of the venue
 * @property thumb_url <em>Optional</em>. Url of the thumbnail for the result
 * @property thumb_width <em>Optional</em>. Thumbnail width
 * @property thumb_height <em>Optional</em>. Thumbnail height
 *
 * @constructor Creates a [InlineQueryResultVenue].
 * */
@Serializable
data class InlineQueryResultVenue(
    val type: String,
    val id: String,
    val latitude: Float,
    val longitude: Float,
    val title: String,
    val address: String,
    val foursquare_id: String? = null,
    val foursquare_type: String? = null,
    val google_place_id: String? = null,
    val google_place_type: String? = null,
    val reply_markup: InlineKeyboardMarkup? = null,
    val input_message_content: @Contextual InputMessageContent? = null,
    val thumb_url: String? = null,
    val thumb_width: Long? = null,
    val thumb_height: Long? = null,
) : InlineQueryResult() {
    override fun toJson() = json.encodeToString(serializer(), this)
    companion object {
        fun fromJson(string: String) = json.decodeFromString(serializer(), string)
    }
}

/**
 * <p>Represents a contact with a phone number. By default, this contact will be sent by the user. Alternatively, you can use <em>input_message_content</em> to send a message with the specified content instead of the contact.</p><p><strong>Note:</strong> This will only work in Telegram versions released after 9 April, 2016. Older clients will ignore them.</p>
 *
 * @property type Type of the result, must be <em>contact</em>
 * @property id Unique identifier for this result, 1-64 Bytes
 * @property phone_number Contact's phone number
 * @property first_name Contact's first name
 * @property last_name <em>Optional</em>. Contact's last name
 * @property vcard <em>Optional</em>. Additional data about the contact in the form of a <a href="https://en.wikipedia.org/wiki/VCard">vCard</a>, 0-2048 bytes
 * @property reply_markup <em>Optional</em>. <a href="/bots#inline-keyboards-and-on-the-fly-updating">Inline keyboard</a> attached to the message
 * @property input_message_content <em>Optional</em>. Content of the message to be sent instead of the contact
 * @property thumb_url <em>Optional</em>. Url of the thumbnail for the result
 * @property thumb_width <em>Optional</em>. Thumbnail width
 * @property thumb_height <em>Optional</em>. Thumbnail height
 *
 * @constructor Creates a [InlineQueryResultContact].
 * */
@Serializable
data class InlineQueryResultContact(
    val type: String,
    val id: String,
    val phone_number: String,
    val first_name: String,
    val last_name: String? = null,
    val vcard: String? = null,
    val reply_markup: InlineKeyboardMarkup? = null,
    val input_message_content: @Contextual InputMessageContent? = null,
    val thumb_url: String? = null,
    val thumb_width: Long? = null,
    val thumb_height: Long? = null,
) : InlineQueryResult() {
    override fun toJson() = json.encodeToString(serializer(), this)
    companion object {
        fun fromJson(string: String) = json.decodeFromString(serializer(), string)
    }
}

/**
 * <p>Represents a <a href="#games">Game</a>.</p><p><strong>Note:</strong> This will only work in Telegram versions released after October 1, 2016. Older clients will not display any inline results if a game result is among them.</p>
 *
 * @property type Type of the result, must be <em>game</em>
 * @property id Unique identifier for this result, 1-64 bytes
 * @property game_short_name Short name of the game
 * @property reply_markup <em>Optional</em>. <a href="/bots#inline-keyboards-and-on-the-fly-updating">Inline keyboard</a> attached to the message
 *
 * @constructor Creates a [InlineQueryResultGame].
 * */
@Serializable
data class InlineQueryResultGame(
    val type: String,
    val id: String,
    val game_short_name: String,
    val reply_markup: InlineKeyboardMarkup? = null,
) : InlineQueryResult() {
    override fun toJson() = json.encodeToString(serializer(), this)
    companion object {
        fun fromJson(string: String) = json.decodeFromString(serializer(), string)
    }
}

/**
 * <p>Represents a link to a photo stored on the Telegram servers. By default, this photo will be sent by the user with an optional caption. Alternatively, you can use <em>input_message_content</em> to send a message with the specified content instead of the photo.</p>
 *
 * @property type Type of the result, must be <em>photo</em>
 * @property id Unique identifier for this result, 1-64 bytes
 * @property photo_file_id A valid file identifier of the photo
 * @property title <em>Optional</em>. Title for the result
 * @property description <em>Optional</em>. Short description of the result
 * @property caption <em>Optional</em>. Caption of the photo to be sent, 0-1024 characters after entities parsing
 * @property parse_mode <em>Optional</em>. Mode for parsing entities in the photo caption. See <a href="#formatting-options">formatting options</a> for more details.
 * @property caption_entities <em>Optional</em>. List of special entities that appear in the caption, which can be specified instead of <em>parse_mode</em>
 * @property reply_markup <em>Optional</em>. <a href="/bots#inline-keyboards-and-on-the-fly-updating">Inline keyboard</a> attached to the message
 * @property input_message_content <em>Optional</em>. Content of the message to be sent instead of the photo
 *
 * @constructor Creates a [InlineQueryResultCachedPhoto].
 * */
@Serializable
data class InlineQueryResultCachedPhoto(
    val type: String,
    val id: String,
    val photo_file_id: String,
    val title: String? = null,
    val description: String? = null,
    val caption: String? = null,
    val parse_mode: ParseMode? = null,
    val caption_entities: List<MessageEntity>? = null,
    val reply_markup: InlineKeyboardMarkup? = null,
    val input_message_content: @Contextual InputMessageContent? = null,
) : InlineQueryResult() {
    override fun toJson() = json.encodeToString(serializer(), this)
    companion object {
        fun fromJson(string: String) = json.decodeFromString(serializer(), string)
    }
}

/**
 * <p>Represents a link to an animated GIF file stored on the Telegram servers. By default, this animated GIF file will be sent by the user with an optional caption. Alternatively, you can use <em>input_message_content</em> to send a message with specified content instead of the animation.</p>
 *
 * @property type Type of the result, must be <em>gif</em>
 * @property id Unique identifier for this result, 1-64 bytes
 * @property gif_file_id A valid file identifier for the GIF file
 * @property title <em>Optional</em>. Title for the result
 * @property caption <em>Optional</em>. Caption of the GIF file to be sent, 0-1024 characters after entities parsing
 * @property parse_mode <em>Optional</em>. Mode for parsing entities in the caption. See <a href="#formatting-options">formatting options</a> for more details.
 * @property caption_entities <em>Optional</em>. List of special entities that appear in the caption, which can be specified instead of <em>parse_mode</em>
 * @property reply_markup <em>Optional</em>. <a href="/bots#inline-keyboards-and-on-the-fly-updating">Inline keyboard</a> attached to the message
 * @property input_message_content <em>Optional</em>. Content of the message to be sent instead of the GIF animation
 *
 * @constructor Creates a [InlineQueryResultCachedGif].
 * */
@Serializable
data class InlineQueryResultCachedGif(
    val type: String,
    val id: String,
    val gif_file_id: String,
    val title: String? = null,
    val caption: String? = null,
    val parse_mode: ParseMode? = null,
    val caption_entities: List<MessageEntity>? = null,
    val reply_markup: InlineKeyboardMarkup? = null,
    val input_message_content: @Contextual InputMessageContent? = null,
) : InlineQueryResult() {
    override fun toJson() = json.encodeToString(serializer(), this)
    companion object {
        fun fromJson(string: String) = json.decodeFromString(serializer(), string)
    }
}

/**
 * <p>Represents a link to a video animation (H.264/MPEG-4 AVC video without sound) stored on the Telegram servers. By default, this animated MPEG-4 file will be sent by the user with an optional caption. Alternatively, you can use <em>input_message_content</em> to send a message with the specified content instead of the animation.</p>
 *
 * @property type Type of the result, must be <em>mpeg4_gif</em>
 * @property id Unique identifier for this result, 1-64 bytes
 * @property mpeg4_file_id A valid file identifier for the MPEG4 file
 * @property title <em>Optional</em>. Title for the result
 * @property caption <em>Optional</em>. Caption of the MPEG-4 file to be sent, 0-1024 characters after entities parsing
 * @property parse_mode <em>Optional</em>. Mode for parsing entities in the caption. See <a href="#formatting-options">formatting options</a> for more details.
 * @property caption_entities <em>Optional</em>. List of special entities that appear in the caption, which can be specified instead of <em>parse_mode</em>
 * @property reply_markup <em>Optional</em>. <a href="/bots#inline-keyboards-and-on-the-fly-updating">Inline keyboard</a> attached to the message
 * @property input_message_content <em>Optional</em>. Content of the message to be sent instead of the video animation
 *
 * @constructor Creates a [InlineQueryResultCachedMpeg4Gif].
 * */
@Serializable
data class InlineQueryResultCachedMpeg4Gif(
    val type: String,
    val id: String,
    val mpeg4_file_id: String,
    val title: String? = null,
    val caption: String? = null,
    val parse_mode: ParseMode? = null,
    val caption_entities: List<MessageEntity>? = null,
    val reply_markup: InlineKeyboardMarkup? = null,
    val input_message_content: @Contextual InputMessageContent? = null,
) : InlineQueryResult() {
    override fun toJson() = json.encodeToString(serializer(), this)
    companion object {
        fun fromJson(string: String) = json.decodeFromString(serializer(), string)
    }
}

/**
 * <p>Represents a link to a sticker stored on the Telegram servers. By default, this sticker will be sent by the user. Alternatively, you can use <em>input_message_content</em> to send a message with the specified content instead of the sticker.</p><p><strong>Note:</strong> This will only work in Telegram versions released after 9 April, 2016 for static stickers and after 06 July, 2019 for <a href="https://telegram.org/blog/animated-stickers">animated stickers</a>. Older clients will ignore them.</p>
 *
 * @property type Type of the result, must be <em>sticker</em>
 * @property id Unique identifier for this result, 1-64 bytes
 * @property sticker_file_id A valid file identifier of the sticker
 * @property reply_markup <em>Optional</em>. <a href="/bots#inline-keyboards-and-on-the-fly-updating">Inline keyboard</a> attached to the message
 * @property input_message_content <em>Optional</em>. Content of the message to be sent instead of the sticker
 *
 * @constructor Creates a [InlineQueryResultCachedSticker].
 * */
@Serializable
data class InlineQueryResultCachedSticker(
    val type: String,
    val id: String,
    val sticker_file_id: String,
    val reply_markup: InlineKeyboardMarkup? = null,
    val input_message_content: @Contextual InputMessageContent? = null,
) : InlineQueryResult() {
    override fun toJson() = json.encodeToString(serializer(), this)
    companion object {
        fun fromJson(string: String) = json.decodeFromString(serializer(), string)
    }
}

/**
 * <p>Represents a link to a file stored on the Telegram servers. By default, this file will be sent by the user with an optional caption. Alternatively, you can use <em>input_message_content</em> to send a message with the specified content instead of the file.</p><p><strong>Note:</strong> This will only work in Telegram versions released after 9 April, 2016. Older clients will ignore them.</p>
 *
 * @property type Type of the result, must be <em>document</em>
 * @property id Unique identifier for this result, 1-64 bytes
 * @property title Title for the result
 * @property document_file_id A valid file identifier for the file
 * @property description <em>Optional</em>. Short description of the result
 * @property caption <em>Optional</em>. Caption of the document to be sent, 0-1024 characters after entities parsing
 * @property parse_mode <em>Optional</em>. Mode for parsing entities in the document caption. See <a href="#formatting-options">formatting options</a> for more details.
 * @property caption_entities <em>Optional</em>. List of special entities that appear in the caption, which can be specified instead of <em>parse_mode</em>
 * @property reply_markup <em>Optional</em>. <a href="/bots#inline-keyboards-and-on-the-fly-updating">Inline keyboard</a> attached to the message
 * @property input_message_content <em>Optional</em>. Content of the message to be sent instead of the file
 *
 * @constructor Creates a [InlineQueryResultCachedDocument].
 * */
@Serializable
data class InlineQueryResultCachedDocument(
    val type: String,
    val id: String,
    val title: String,
    val document_file_id: String,
    val description: String? = null,
    val caption: String? = null,
    val parse_mode: ParseMode? = null,
    val caption_entities: List<MessageEntity>? = null,
    val reply_markup: InlineKeyboardMarkup? = null,
    val input_message_content: @Contextual InputMessageContent? = null,
) : InlineQueryResult() {
    override fun toJson() = json.encodeToString(serializer(), this)
    companion object {
        fun fromJson(string: String) = json.decodeFromString(serializer(), string)
    }
}

/**
 * <p>Represents a link to a video file stored on the Telegram servers. By default, this video file will be sent by the user with an optional caption. Alternatively, you can use <em>input_message_content</em> to send a message with the specified content instead of the video.</p>
 *
 * @property type Type of the result, must be <em>video</em>
 * @property id Unique identifier for this result, 1-64 bytes
 * @property video_file_id A valid file identifier for the video file
 * @property title Title for the result
 * @property description <em>Optional</em>. Short description of the result
 * @property caption <em>Optional</em>. Caption of the video to be sent, 0-1024 characters after entities parsing
 * @property parse_mode <em>Optional</em>. Mode for parsing entities in the video caption. See <a href="#formatting-options">formatting options</a> for more details.
 * @property caption_entities <em>Optional</em>. List of special entities that appear in the caption, which can be specified instead of <em>parse_mode</em>
 * @property reply_markup <em>Optional</em>. <a href="/bots#inline-keyboards-and-on-the-fly-updating">Inline keyboard</a> attached to the message
 * @property input_message_content <em>Optional</em>. Content of the message to be sent instead of the video
 *
 * @constructor Creates a [InlineQueryResultCachedVideo].
 * */
@Serializable
data class InlineQueryResultCachedVideo(
    val type: String,
    val id: String,
    val video_file_id: String,
    val title: String,
    val description: String? = null,
    val caption: String? = null,
    val parse_mode: ParseMode? = null,
    val caption_entities: List<MessageEntity>? = null,
    val reply_markup: InlineKeyboardMarkup? = null,
    val input_message_content: @Contextual InputMessageContent? = null,
) : InlineQueryResult() {
    override fun toJson() = json.encodeToString(serializer(), this)
    companion object {
        fun fromJson(string: String) = json.decodeFromString(serializer(), string)
    }
}

/**
 * <p>Represents a link to a voice message stored on the Telegram servers. By default, this voice message will be sent by the user. Alternatively, you can use <em>input_message_content</em> to send a message with the specified content instead of the voice message.</p><p><strong>Note:</strong> This will only work in Telegram versions released after 9 April, 2016. Older clients will ignore them.</p>
 *
 * @property type Type of the result, must be <em>voice</em>
 * @property id Unique identifier for this result, 1-64 bytes
 * @property voice_file_id A valid file identifier for the voice message
 * @property title Voice message title
 * @property caption <em>Optional</em>. Caption, 0-1024 characters after entities parsing
 * @property parse_mode <em>Optional</em>. Mode for parsing entities in the voice message caption. See <a href="#formatting-options">formatting options</a> for more details.
 * @property caption_entities <em>Optional</em>. List of special entities that appear in the caption, which can be specified instead of <em>parse_mode</em>
 * @property reply_markup <em>Optional</em>. <a href="/bots#inline-keyboards-and-on-the-fly-updating">Inline keyboard</a> attached to the message
 * @property input_message_content <em>Optional</em>. Content of the message to be sent instead of the voice message
 *
 * @constructor Creates a [InlineQueryResultCachedVoice].
 * */
@Serializable
data class InlineQueryResultCachedVoice(
    val type: String,
    val id: String,
    val voice_file_id: String,
    val title: String,
    val caption: String? = null,
    val parse_mode: ParseMode? = null,
    val caption_entities: List<MessageEntity>? = null,
    val reply_markup: InlineKeyboardMarkup? = null,
    val input_message_content: @Contextual InputMessageContent? = null,
) : InlineQueryResult() {
    override fun toJson() = json.encodeToString(serializer(), this)
    companion object {
        fun fromJson(string: String) = json.decodeFromString(serializer(), string)
    }
}

/**
 * <p>Represents a link to an MP3 audio file stored on the Telegram servers. By default, this audio file will be sent by the user. Alternatively, you can use <em>input_message_content</em> to send a message with the specified content instead of the audio.</p><p><strong>Note:</strong> This will only work in Telegram versions released after 9 April, 2016. Older clients will ignore them.</p>
 *
 * @property type Type of the result, must be <em>audio</em>
 * @property id Unique identifier for this result, 1-64 bytes
 * @property audio_file_id A valid file identifier for the audio file
 * @property caption <em>Optional</em>. Caption, 0-1024 characters after entities parsing
 * @property parse_mode <em>Optional</em>. Mode for parsing entities in the audio caption. See <a href="#formatting-options">formatting options</a> for more details.
 * @property caption_entities <em>Optional</em>. List of special entities that appear in the caption, which can be specified instead of <em>parse_mode</em>
 * @property reply_markup <em>Optional</em>. <a href="/bots#inline-keyboards-and-on-the-fly-updating">Inline keyboard</a> attached to the message
 * @property input_message_content <em>Optional</em>. Content of the message to be sent instead of the audio
 *
 * @constructor Creates a [InlineQueryResultCachedAudio].
 * */
@Serializable
data class InlineQueryResultCachedAudio(
    val type: String,
    val id: String,
    val audio_file_id: String,
    val caption: String? = null,
    val parse_mode: ParseMode? = null,
    val caption_entities: List<MessageEntity>? = null,
    val reply_markup: InlineKeyboardMarkup? = null,
    val input_message_content: @Contextual InputMessageContent? = null,
) : InlineQueryResult() {
    override fun toJson() = json.encodeToString(serializer(), this)
    companion object {
        fun fromJson(string: String) = json.decodeFromString(serializer(), string)
    }
}

/**
 * <p>Represents the <a href="#inputmessagecontent">content</a> of a text message to be sent as the result of an inline query.</p>
 *
 * @property message_text Text of the message to be sent, 1-4096 characters
 * @property parse_mode <em>Optional</em>. Mode for parsing entities in the message text. See <a href="#formatting-options">formatting options</a> for more details.
 * @property entities <em>Optional</em>. List of special entities that appear in message text, which can be specified instead of <em>parse_mode</em>
 * @property disable_web_page_preview <em>Optional</em>. Disables link previews for links in the sent message
 *
 * @constructor Creates a [InputTextMessageContent].
 * */
@Serializable
data class InputTextMessageContent(
    val message_text: String,
    val parse_mode: ParseMode? = null,
    val entities: List<MessageEntity>? = null,
    val disable_web_page_preview: Boolean? = null,
) : InputMessageContent() {
    override fun toJson() = json.encodeToString(serializer(), this)
    companion object {
        fun fromJson(string: String) = json.decodeFromString(serializer(), string)
    }
}

/**
 * <p>Represents the <a href="#inputmessagecontent">content</a> of a location message to be sent as the result of an inline query.</p>
 *
 * @property latitude Latitude of the location in degrees
 * @property longitude Longitude of the location in degrees
 * @property horizontal_accuracy <em>Optional</em>. The radius of uncertainty for the location, measured in meters; 0-1500
 * @property live_period <em>Optional</em>. Period in seconds for which the location can be updated, should be between 60 and 86400.
 * @property heading <em>Optional</em>. For live locations, a direction in which the user is moving, in degrees. Must be between 1 and 360 if specified.
 * @property proximity_alert_radius <em>Optional</em>. For live locations, a maximum distance for proximity alerts about approaching another chat member, in meters. Must be between 1 and 100000 if specified.
 *
 * @constructor Creates a [InputLocationMessageContent].
 * */
@Serializable
data class InputLocationMessageContent(
    val latitude: Float,
    val longitude: Float,
    val horizontal_accuracy: Float? = null,
    val live_period: Long? = null,
    val heading: Long? = null,
    val proximity_alert_radius: Long? = null,
) : TelegramModel() {
    override fun toJson() = json.encodeToString(serializer(), this)
    companion object {
        fun fromJson(string: String) = json.decodeFromString(serializer(), string)
    }
}

/**
 * <p>Represents the <a href="#inputmessagecontent">content</a> of a venue message to be sent as the result of an inline query.</p>
 *
 * @property latitude Latitude of the venue in degrees
 * @property longitude Longitude of the venue in degrees
 * @property title Name of the venue
 * @property address Address of the venue
 * @property foursquare_id <em>Optional</em>. Foursquare identifier of the venue, if known
 * @property foursquare_type <em>Optional</em>. Foursquare type of the venue, if known. (For example, “arts_entertainment/default”, “arts_entertainment/aquarium” or “food/icecream”.)
 * @property google_place_id <em>Optional</em>. Google Places identifier of the venue
 * @property google_place_type <em>Optional</em>. Google Places type of the venue. (See <a href="https://developers.google.com/places/web-service/supported_types">supported types</a>.)
 *
 * @constructor Creates a [InputVenueMessageContent].
 * */
@Serializable
data class InputVenueMessageContent(
    val latitude: Float,
    val longitude: Float,
    val title: String,
    val address: String,
    val foursquare_id: String? = null,
    val foursquare_type: String? = null,
    val google_place_id: String? = null,
    val google_place_type: String? = null,
) : TelegramModel() {
    override fun toJson() = json.encodeToString(serializer(), this)
    companion object {
        fun fromJson(string: String) = json.decodeFromString(serializer(), string)
    }
}

/**
 * <p>Represents the <a href="#inputmessagecontent">content</a> of a contact message to be sent as the result of an inline query.</p>
 *
 * @property phone_number Contact's phone number
 * @property first_name Contact's first name
 * @property last_name <em>Optional</em>. Contact's last name
 * @property vcard <em>Optional</em>. Additional data about the contact in the form of a <a href="https://en.wikipedia.org/wiki/VCard">vCard</a>, 0-2048 bytes
 *
 * @constructor Creates a [InputContactMessageContent].
 * */
@Serializable
data class InputContactMessageContent(
    val phone_number: String,
    val first_name: String,
    val last_name: String? = null,
    val vcard: String? = null,
) : TelegramModel() {
    override fun toJson() = json.encodeToString(serializer(), this)
    companion object {
        fun fromJson(string: String) = json.decodeFromString(serializer(), string)
    }
}

/**
 * <p>Represents the <a href="#inputmessagecontent">content</a> of an invoice message to be sent as the result of an inline query.</p>
 *
 * @property title Product name, 1-32 characters
 * @property description Product description, 1-255 characters
 * @property payload Bot-defined invoice payload, 1-128 bytes. This will not be displayed to the user, use for your internal processes.
 * @property provider_token Payment provider token, obtained via <a href="https://t.me/botfather">@BotFather</a>
 * @property currency Three-letter ISO 4217 currency code, see <a href="/bots/payments#supported-currencies">more on currencies</a>
 * @property prices Price breakdown, a JSON-serialized list of components (e.g. product price, tax, discount, delivery cost, delivery tax, bonus, etc.)
 * @property max_tip_amount <em>Optional</em>. The maximum accepted amount for tips in the <em>smallest units</em> of the currency (integer, <strong>not</strong> float/double). For example, for a maximum tip of <code>US$ 1.45</code> pass <code>max_tip_amount = 145</code>. See the <em>exp</em> parameter in <a href="https://core.telegram.org/bots/payments/currencies.json">currencies.json</a>, it shows the number of digits past the decimal point for each currency (2 for the majority of currencies). Defaults to 0
 * @property suggested_tip_amounts <em>Optional</em>. A JSON-serialized array of suggested amounts of tip in the <em>smallest units</em> of the currency (integer, <strong>not</strong> float/double). At most 4 suggested tip amounts can be specified. The suggested tip amounts must be positive, passed in a strictly increased order and must not exceed <em>max_tip_amount</em>.
 * @property provider_data <em>Optional</em>. A JSON-serialized object for data about the invoice, which will be shared with the payment provider. A detailed description of the required fields should be provided by the payment provider.
 * @property photo_url <em>Optional</em>. URL of the product photo for the invoice. Can be a photo of the goods or a marketing image for a service.
 * @property photo_size <em>Optional</em>. Photo size in bytes
 * @property photo_width <em>Optional</em>. Photo width
 * @property photo_height <em>Optional</em>. Photo height
 * @property need_name <em>Optional</em>. Pass <em>True</em>, if you require the user's full name to complete the order
 * @property need_phone_number <em>Optional</em>. Pass <em>True</em>, if you require the user's phone number to complete the order
 * @property need_email <em>Optional</em>. Pass <em>True</em>, if you require the user's email address to complete the order
 * @property need_shipping_address <em>Optional</em>. Pass <em>True</em>, if you require the user's shipping address to complete the order
 * @property send_phone_number_to_provider <em>Optional</em>. Pass <em>True</em>, if the user's phone number should be sent to provider
 * @property send_email_to_provider <em>Optional</em>. Pass <em>True</em>, if the user's email address should be sent to provider
 * @property is_flexible <em>Optional</em>. Pass <em>True</em>, if the final price depends on the shipping method
 *
 * @constructor Creates a [InputInvoiceMessageContent].
 * */
@Serializable
data class InputInvoiceMessageContent(
    val title: String,
    val description: String,
    val payload: String,
    val provider_token: String,
    val currency: String,
    val prices: List<LabeledPrice>,
    val max_tip_amount: Long? = null,
    val suggested_tip_amounts: List<Long>? = null,
    val provider_data: String? = null,
    val photo_url: String? = null,
    val photo_size: Long? = null,
    val photo_width: Long? = null,
    val photo_height: Long? = null,
    val need_name: Boolean? = null,
    val need_phone_number: Boolean? = null,
    val need_email: Boolean? = null,
    val need_shipping_address: Boolean? = null,
    val send_phone_number_to_provider: Boolean? = null,
    val send_email_to_provider: Boolean? = null,
    val is_flexible: Boolean? = null,
) : TelegramModel() {
    override fun toJson() = json.encodeToString(serializer(), this)
    companion object {
        fun fromJson(string: String) = json.decodeFromString(serializer(), string)
    }
}

/**
 * <p>Represents a <a href="#inlinequeryresult">result</a> of an inline query that was chosen by the user and sent to their chat partner.</p><p><strong>Note:</strong> It is necessary to enable <a href="/bots/inline#collecting-feedback">inline feedback</a> via <a href="https://t.me/botfather">@BotFather</a> in order to receive these objects in updates.</p>
 *
 * @property result_id The unique identifier for the result that was chosen
 * @property from The user that chose the result
 * @property location <em>Optional</em>. Sender location, only for bots that require user location
 * @property inline_message_id <em>Optional</em>. Identifier of the sent inline message. Available only if there is an <a href="#inlinekeyboardmarkup">inline keyboard</a> attached to the message. Will be also received in <a href="#callbackquery">callback queries</a> and can be used to <a href="#updating-messages">edit</a> the message.
 * @property query The query that was used to obtain the result
 *
 * @constructor Creates a [ChosenInlineResult].
 * */
@Serializable
data class ChosenInlineResult(
    val result_id: String,
    val from: User,
    val location: Location? = null,
    val inline_message_id: String? = null,
    val query: String,
) : TelegramModel() {
    override fun toJson() = json.encodeToString(serializer(), this)
    companion object {
        fun fromJson(string: String) = json.decodeFromString(serializer(), string)
    }
}

/**
 * <p>Describes an inline message sent by a <a href="/bots/webapps">Web App</a> on behalf of a user.</p>
 *
 * @property inline_message_id <em>Optional</em>. Identifier of the sent inline message. Available only if there is an <a href="#inlinekeyboardmarkup">inline keyboard</a> attached to the message.
 *
 * @constructor Creates a [SentWebAppMessage].
 * */
@Serializable
data class SentWebAppMessage(
    val inline_message_id: String? = null,
) : TelegramModel() {
    override fun toJson() = json.encodeToString(serializer(), this)
    companion object {
        fun fromJson(string: String) = json.decodeFromString(serializer(), string)
    }
}


// Payments

/**
 * <p>This object represents a portion of the price for goods or services.</p>
 *
 * @property label Portion label
 * @property amount Price of the product in the <em>smallest units</em> of the <a href="/bots/payments#supported-currencies">currency</a> (integer, <strong>not</strong> float/double). For example, for a price of <code>US$ 1.45</code> pass <code>amount = 145</code>. See the <em>exp</em> parameter in <a href="https://core.telegram.org/bots/payments/currencies.json">currencies.json</a>, it shows the number of digits past the decimal point for each currency (2 for the majority of currencies).
 *
 * @constructor Creates a [LabeledPrice].
 * */
@Serializable
data class LabeledPrice(
    val label: String,
    val amount: Long,
) : TelegramModel() {
    override fun toJson() = json.encodeToString(serializer(), this)
    companion object {
        fun fromJson(string: String) = json.decodeFromString(serializer(), string)
    }
}

/**
 * <p>This object contains basic information about an invoice.</p>
 *
 * @property title Product name
 * @property description Product description
 * @property start_parameter Unique bot deep-linking parameter that can be used to generate this invoice
 * @property currency Three-letter ISO 4217 <a href="/bots/payments#supported-currencies">currency</a> code
 * @property total_amount Total price in the <em>smallest units</em> of the currency (integer, <strong>not</strong> float/double). For example, for a price of <code>US$ 1.45</code> pass <code>amount = 145</code>. See the <em>exp</em> parameter in <a href="https://core.telegram.org/bots/payments/currencies.json">currencies.json</a>, it shows the number of digits past the decimal point for each currency (2 for the majority of currencies).
 *
 * @constructor Creates a [Invoice].
 * */
@Serializable
data class Invoice(
    val title: String,
    val description: String,
    val start_parameter: String,
    val currency: String,
    val total_amount: Long,
) : TelegramModel() {
    override fun toJson() = json.encodeToString(serializer(), this)
    companion object {
        fun fromJson(string: String) = json.decodeFromString(serializer(), string)
    }
}

/**
 * <p>This object represents a shipping address.</p>
 *
 * @property country_code Two-letter ISO 3166-1 alpha-2 country code
 * @property state State, if applicable
 * @property city City
 * @property street_line1 First line for the address
 * @property street_line2 Second line for the address
 * @property post_code Address post code
 *
 * @constructor Creates a [ShippingAddress].
 * */
@Serializable
data class ShippingAddress(
    val country_code: String,
    val state: String,
    val city: String,
    val street_line1: String,
    val street_line2: String,
    val post_code: String,
) : TelegramModel() {
    override fun toJson() = json.encodeToString(serializer(), this)
    companion object {
        fun fromJson(string: String) = json.decodeFromString(serializer(), string)
    }
}

/**
 * <p>This object represents information about an order.</p>
 *
 * @property name <em>Optional</em>. User name
 * @property phone_number <em>Optional</em>. User's phone number
 * @property email <em>Optional</em>. User email
 * @property shipping_address <em>Optional</em>. User shipping address
 *
 * @constructor Creates a [OrderInfo].
 * */
@Serializable
data class OrderInfo(
    val name: String? = null,
    val phone_number: String? = null,
    val email: String? = null,
    val shipping_address: ShippingAddress? = null,
) : TelegramModel() {
    override fun toJson() = json.encodeToString(serializer(), this)
    companion object {
        fun fromJson(string: String) = json.decodeFromString(serializer(), string)
    }
}

/**
 * <p>This object represents one shipping option.</p>
 *
 * @property id Shipping option identifier
 * @property title Option title
 * @property prices List of price portions
 *
 * @constructor Creates a [ShippingOption].
 * */
@Serializable
data class ShippingOption(
    val id: String,
    val title: String,
    val prices: List<LabeledPrice>,
) : TelegramModel() {
    override fun toJson() = json.encodeToString(serializer(), this)
    companion object {
        fun fromJson(string: String) = json.decodeFromString(serializer(), string)
    }
}

/**
 * <p>This object contains basic information about a successful payment.</p>
 *
 * @property currency Three-letter ISO 4217 <a href="/bots/payments#supported-currencies">currency</a> code
 * @property total_amount Total price in the <em>smallest units</em> of the currency (integer, <strong>not</strong> float/double). For example, for a price of <code>US$ 1.45</code> pass <code>amount = 145</code>. See the <em>exp</em> parameter in <a href="https://core.telegram.org/bots/payments/currencies.json">currencies.json</a>, it shows the number of digits past the decimal point for each currency (2 for the majority of currencies).
 * @property invoice_payload Bot specified invoice payload
 * @property shipping_option_id <em>Optional</em>. Identifier of the shipping option chosen by the user
 * @property order_info <em>Optional</em>. Order information provided by the user
 * @property telegram_payment_charge_id Telegram payment identifier
 * @property provider_payment_charge_id Provider payment identifier
 *
 * @constructor Creates a [SuccessfulPayment].
 * */
@Serializable
data class SuccessfulPayment(
    val currency: String,
    val total_amount: Long,
    val invoice_payload: String,
    val shipping_option_id: String? = null,
    val order_info: OrderInfo? = null,
    val telegram_payment_charge_id: String,
    val provider_payment_charge_id: String,
) : TelegramModel() {
    override fun toJson() = json.encodeToString(serializer(), this)
    companion object {
        fun fromJson(string: String) = json.decodeFromString(serializer(), string)
    }
}

/**
 * <p>This object contains information about an incoming shipping query.</p>
 *
 * @property id Unique query identifier
 * @property from User who sent the query
 * @property invoice_payload Bot specified invoice payload
 * @property shipping_address User specified shipping address
 *
 * @constructor Creates a [ShippingQuery].
 * */
@Serializable
data class ShippingQuery(
    val id: String,
    val from: User,
    val invoice_payload: String,
    val shipping_address: ShippingAddress,
) : TelegramModel() {
    override fun toJson() = json.encodeToString(serializer(), this)
    companion object {
        fun fromJson(string: String) = json.decodeFromString(serializer(), string)
    }
}

/**
 * <p>This object contains information about an incoming pre-checkout query.</p>
 *
 * @property id Unique query identifier
 * @property from User who sent the query
 * @property currency Three-letter ISO 4217 <a href="/bots/payments#supported-currencies">currency</a> code
 * @property total_amount Total price in the <em>smallest units</em> of the currency (integer, <strong>not</strong> float/double). For example, for a price of <code>US$ 1.45</code> pass <code>amount = 145</code>. See the <em>exp</em> parameter in <a href="https://core.telegram.org/bots/payments/currencies.json">currencies.json</a>, it shows the number of digits past the decimal point for each currency (2 for the majority of currencies).
 * @property invoice_payload Bot specified invoice payload
 * @property shipping_option_id <em>Optional</em>. Identifier of the shipping option chosen by the user
 * @property order_info <em>Optional</em>. Order information provided by the user
 *
 * @constructor Creates a [PreCheckoutQuery].
 * */
@Serializable
data class PreCheckoutQuery(
    val id: String,
    val from: User,
    val currency: String,
    val total_amount: Long,
    val invoice_payload: String,
    val shipping_option_id: String? = null,
    val order_info: OrderInfo? = null,
) : TelegramModel() {
    override fun toJson() = json.encodeToString(serializer(), this)
    companion object {
        fun fromJson(string: String) = json.decodeFromString(serializer(), string)
    }
}


// Telegram Passport

/**
 * <p>Describes Telegram Passport data shared with the bot by the user.</p>
 *
 * @property data Array with information about documents and other Telegram Passport elements that was shared with the bot
 * @property credentials Encrypted credentials required to decrypt the data
 *
 * @constructor Creates a [PassportData].
 * */
@Serializable
data class PassportData(
    val data: List<EncryptedPassportElement>,
    val credentials: EncryptedCredentials,
) : TelegramModel() {
    override fun toJson() = json.encodeToString(serializer(), this)
    companion object {
        fun fromJson(string: String) = json.decodeFromString(serializer(), string)
    }
}

/**
 * <p>This object represents a file uploaded to Telegram Passport. Currently all Telegram Passport files are in JPEG format when decrypted and don't exceed 10MB.</p>
 *
 * @property file_id Identifier for this file, which can be used to download or reuse the file
 * @property file_unique_id Unique identifier for this file, which is supposed to be the same over time and for different bots. Can't be used to download or reuse the file.
 * @property file_size File size in bytes
 * @property file_date Unix time when the file was uploaded
 *
 * @constructor Creates a [PassportFile].
 * */
@Serializable
data class PassportFile(
    val file_id: String,
    val file_unique_id: String,
    val file_size: Long,
    val file_date: Long,
) : TelegramModel() {
    override fun toJson() = json.encodeToString(serializer(), this)
    companion object {
        fun fromJson(string: String) = json.decodeFromString(serializer(), string)
    }
}

/**
 * <p>Describes documents or other Telegram Passport elements shared with the bot by the user.</p>
 *
 * @property type Element type. One of “personal_details”, “passport”, “driver_license”, “identity_card”, “internal_passport”, “address”, “utility_bill”, “bank_statement”, “rental_agreement”, “passport_registration”, “temporary_registration”, “phone_number”, “email”.
 * @property data <em>Optional</em>. Base64-encoded encrypted Telegram Passport element data provided by the user, available for “personal_details”, “passport”, “driver_license”, “identity_card”, “internal_passport” and “address” types. Can be decrypted and verified using the accompanying <a href="#encryptedcredentials">EncryptedCredentials</a>.
 * @property phone_number <em>Optional</em>. User's verified phone number, available only for “phone_number” type
 * @property email <em>Optional</em>. User's verified email address, available only for “email” type
 * @property files <em>Optional</em>. Array of encrypted files with documents provided by the user, available for “utility_bill”, “bank_statement”, “rental_agreement”, “passport_registration” and “temporary_registration” types. Files can be decrypted and verified using the accompanying <a href="#encryptedcredentials">EncryptedCredentials</a>.
 * @property front_side <em>Optional</em>. Encrypted file with the front side of the document, provided by the user. Available for “passport”, “driver_license”, “identity_card” and “internal_passport”. The file can be decrypted and verified using the accompanying <a href="#encryptedcredentials">EncryptedCredentials</a>.
 * @property reverse_side <em>Optional</em>. Encrypted file with the reverse side of the document, provided by the user. Available for “driver_license” and “identity_card”. The file can be decrypted and verified using the accompanying <a href="#encryptedcredentials">EncryptedCredentials</a>.
 * @property selfie <em>Optional</em>. Encrypted file with the selfie of the user holding a document, provided by the user; available for “passport”, “driver_license”, “identity_card” and “internal_passport”. The file can be decrypted and verified using the accompanying <a href="#encryptedcredentials">EncryptedCredentials</a>.
 * @property translation <em>Optional</em>. Array of encrypted files with translated versions of documents provided by the user. Available if requested for “passport”, “driver_license”, “identity_card”, “internal_passport”, “utility_bill”, “bank_statement”, “rental_agreement”, “passport_registration” and “temporary_registration” types. Files can be decrypted and verified using the accompanying <a href="#encryptedcredentials">EncryptedCredentials</a>.
 * @property hash Base64-encoded element hash for using in <a href="#passportelementerrorunspecified">PassportElementErrorUnspecified</a>
 *
 * @constructor Creates a [EncryptedPassportElement].
 * */
@Serializable
data class EncryptedPassportElement(
    val type: String,
    val data: String? = null,
    val phone_number: String? = null,
    val email: String? = null,
    val files: List<PassportFile>? = null,
    val front_side: PassportFile? = null,
    val reverse_side: PassportFile? = null,
    val selfie: PassportFile? = null,
    val translation: List<PassportFile>? = null,
    val hash: String,
) : TelegramModel() {
    override fun toJson() = json.encodeToString(serializer(), this)
    companion object {
        fun fromJson(string: String) = json.decodeFromString(serializer(), string)
    }
}

/**
 * <p>Describes data required for decrypting and authenticating <a href="#encryptedpassportelement">EncryptedPassportElement</a>. See the <a href="https://core.telegram.org/passport#receiving-information">Telegram Passport Documentation</a> for a complete description of the data decryption and authentication processes.</p>
 *
 * @property data Base64-encoded encrypted JSON-serialized data with unique user's payload, data hashes and secrets required for <a href="#encryptedpassportelement">EncryptedPassportElement</a> decryption and authentication
 * @property hash Base64-encoded data hash for data authentication
 * @property secret Base64-encoded secret, encrypted with the bot's public RSA key, required for data decryption
 *
 * @constructor Creates a [EncryptedCredentials].
 * */
@Serializable
data class EncryptedCredentials(
    val data: String,
    val hash: String,
    val secret: String,
) : TelegramModel() {
    override fun toJson() = json.encodeToString(serializer(), this)
    companion object {
        fun fromJson(string: String) = json.decodeFromString(serializer(), string)
    }
}

/**
 * <p>Represents an issue in one of the data fields that was provided by the user. The error is considered resolved when the field's value changes.</p>
 *
 * @property source Error source, must be <em>data</em>
 * @property type The section of the user's Telegram Passport which has the error, one of “personal_details”, “passport”, “driver_license”, “identity_card”, “internal_passport”, “address”
 * @property field_name Name of the data field which has the error
 * @property data_hash Base64-encoded data hash
 * @property message Error message
 *
 * @constructor Creates a [PassportElementErrorDataField].
 * */
@Serializable
data class PassportElementErrorDataField(
    val source: String,
    val type: String,
    val field_name: String,
    val data_hash: String,
    val message: String,
) : PassportElementError() {
    override fun toJson() = json.encodeToString(serializer(), this)
    companion object {
        fun fromJson(string: String) = json.decodeFromString(serializer(), string)
    }
}

/**
 * <p>Represents an issue with the front side of a document. The error is considered resolved when the file with the front side of the document changes.</p>
 *
 * @property source Error source, must be <em>front_side</em>
 * @property type The section of the user's Telegram Passport which has the issue, one of “passport”, “driver_license”, “identity_card”, “internal_passport”
 * @property file_hash Base64-encoded hash of the file with the front side of the document
 * @property message Error message
 *
 * @constructor Creates a [PassportElementErrorFrontSide].
 * */
@Serializable
data class PassportElementErrorFrontSide(
    val source: String,
    val type: String,
    val file_hash: String,
    val message: String,
) : PassportElementError() {
    override fun toJson() = json.encodeToString(serializer(), this)
    companion object {
        fun fromJson(string: String) = json.decodeFromString(serializer(), string)
    }
}

/**
 * <p>Represents an issue with the reverse side of a document. The error is considered resolved when the file with reverse side of the document changes.</p>
 *
 * @property source Error source, must be <em>reverse_side</em>
 * @property type The section of the user's Telegram Passport which has the issue, one of “driver_license”, “identity_card”
 * @property file_hash Base64-encoded hash of the file with the reverse side of the document
 * @property message Error message
 *
 * @constructor Creates a [PassportElementErrorReverseSide].
 * */
@Serializable
data class PassportElementErrorReverseSide(
    val source: String,
    val type: String,
    val file_hash: String,
    val message: String,
) : PassportElementError() {
    override fun toJson() = json.encodeToString(serializer(), this)
    companion object {
        fun fromJson(string: String) = json.decodeFromString(serializer(), string)
    }
}

/**
 * <p>Represents an issue with the selfie with a document. The error is considered resolved when the file with the selfie changes.</p>
 *
 * @property source Error source, must be <em>selfie</em>
 * @property type The section of the user's Telegram Passport which has the issue, one of “passport”, “driver_license”, “identity_card”, “internal_passport”
 * @property file_hash Base64-encoded hash of the file with the selfie
 * @property message Error message
 *
 * @constructor Creates a [PassportElementErrorSelfie].
 * */
@Serializable
data class PassportElementErrorSelfie(
    val source: String,
    val type: String,
    val file_hash: String,
    val message: String,
) : PassportElementError() {
    override fun toJson() = json.encodeToString(serializer(), this)
    companion object {
        fun fromJson(string: String) = json.decodeFromString(serializer(), string)
    }
}

/**
 * <p>Represents an issue with a document scan. The error is considered resolved when the file with the document scan changes.</p>
 *
 * @property source Error source, must be <em>file</em>
 * @property type The section of the user's Telegram Passport which has the issue, one of “utility_bill”, “bank_statement”, “rental_agreement”, “passport_registration”, “temporary_registration”
 * @property file_hash Base64-encoded file hash
 * @property message Error message
 *
 * @constructor Creates a [PassportElementErrorFile].
 * */
@Serializable
data class PassportElementErrorFile(
    val source: String,
    val type: String,
    val file_hash: String,
    val message: String,
) : PassportElementError() {
    override fun toJson() = json.encodeToString(serializer(), this)
    companion object {
        fun fromJson(string: String) = json.decodeFromString(serializer(), string)
    }
}

/**
 * <p>Represents an issue with a list of scans. The error is considered resolved when the list of files containing the scans changes.</p>
 *
 * @property source Error source, must be <em>files</em>
 * @property type The section of the user's Telegram Passport which has the issue, one of “utility_bill”, “bank_statement”, “rental_agreement”, “passport_registration”, “temporary_registration”
 * @property file_hashes List of base64-encoded file hashes
 * @property message Error message
 *
 * @constructor Creates a [PassportElementErrorFiles].
 * */
@Serializable
data class PassportElementErrorFiles(
    val source: String,
    val type: String,
    val file_hashes: List<String>,
    val message: String,
) : PassportElementError() {
    override fun toJson() = json.encodeToString(serializer(), this)
    companion object {
        fun fromJson(string: String) = json.decodeFromString(serializer(), string)
    }
}

/**
 * <p>Represents an issue with one of the files that constitute the translation of a document. The error is considered resolved when the file changes.</p>
 *
 * @property source Error source, must be <em>translation_file</em>
 * @property type Type of element of the user's Telegram Passport which has the issue, one of “passport”, “driver_license”, “identity_card”, “internal_passport”, “utility_bill”, “bank_statement”, “rental_agreement”, “passport_registration”, “temporary_registration”
 * @property file_hash Base64-encoded file hash
 * @property message Error message
 *
 * @constructor Creates a [PassportElementErrorTranslationFile].
 * */
@Serializable
data class PassportElementErrorTranslationFile(
    val source: String,
    val type: String,
    val file_hash: String,
    val message: String,
) : PassportElementError() {
    override fun toJson() = json.encodeToString(serializer(), this)
    companion object {
        fun fromJson(string: String) = json.decodeFromString(serializer(), string)
    }
}

/**
 * <p>Represents an issue with the translated version of a document. The error is considered resolved when a file with the document translation change.</p>
 *
 * @property source Error source, must be <em>translation_files</em>
 * @property type Type of element of the user's Telegram Passport which has the issue, one of “passport”, “driver_license”, “identity_card”, “internal_passport”, “utility_bill”, “bank_statement”, “rental_agreement”, “passport_registration”, “temporary_registration”
 * @property file_hashes List of base64-encoded file hashes
 * @property message Error message
 *
 * @constructor Creates a [PassportElementErrorTranslationFiles].
 * */
@Serializable
data class PassportElementErrorTranslationFiles(
    val source: String,
    val type: String,
    val file_hashes: List<String>,
    val message: String,
) : PassportElementError() {
    override fun toJson() = json.encodeToString(serializer(), this)
    companion object {
        fun fromJson(string: String) = json.decodeFromString(serializer(), string)
    }
}

/**
 * <p>Represents an issue in an unspecified place. The error is considered resolved when new data is added.</p>
 *
 * @property source Error source, must be <em>unspecified</em>
 * @property type Type of element of the user's Telegram Passport which has the issue
 * @property element_hash Base64-encoded element hash
 * @property message Error message
 *
 * @constructor Creates a [PassportElementErrorUnspecified].
 * */
@Serializable
data class PassportElementErrorUnspecified(
    val source: String,
    val type: String,
    val element_hash: String,
    val message: String,
) : PassportElementError() {
    override fun toJson() = json.encodeToString(serializer(), this)
    companion object {
        fun fromJson(string: String) = json.decodeFromString(serializer(), string)
    }
}


// Games

/**
 * <p>This object represents a game. Use BotFather to create and edit games, their short names will act as unique identifiers.</p>
 *
 * @property title Title of the game
 * @property description Description of the game
 * @property photo Photo that will be displayed in the game message in chats.
 * @property text <em>Optional</em>. Brief description of the game or high scores included in the game message. Can be automatically edited to include current high scores for the game when the bot calls <a href="#setgamescore">setGameScore</a>, or manually edited using <a href="#editmessagetext">editMessageText</a>. 0-4096 characters.
 * @property text_entities <em>Optional</em>. Special entities that appear in <em>text</em>, such as usernames, URLs, bot commands, etc.
 * @property animation <em>Optional</em>. Animation that will be displayed in the game message in chats. Upload via <a href="https://t.me/botfather">BotFather</a>
 *
 * @constructor Creates a [Game].
 * */
@Serializable
data class Game(
    val title: String,
    val description: String,
    val photo: List<PhotoSize>,
    val text: String? = null,
    val text_entities: List<MessageEntity>? = null,
    val animation: Animation? = null,
) : TelegramModel() {
    override fun toJson() = json.encodeToString(serializer(), this)
    companion object {
        fun fromJson(string: String) = json.decodeFromString(serializer(), string)
    }
}

/**
 * <p>This object represents one row of the high scores table for a game.</p><p>And that's about all we've got for now.<br>If you've got any questions, please check out our <a href="/bots/faq"><strong>Bot FAQ »</strong></a></p>
 *
 * @property position Position in high score table for the game
 * @property user User
 * @property score Score
 *
 * @constructor Creates a [GameHighScore].
 * */
@Serializable
data class GameHighScore(
    val position: Long,
    val user: User,
    val score: Long,
) : TelegramModel() {
    override fun toJson() = json.encodeToString(serializer(), this)
    companion object {
        fun fromJson(string: String) = json.decodeFromString(serializer(), string)
    }
}


// --- Requests ---

sealed class TelegramRequest {
abstract fun toJsonForRequest(): String
abstract fun toJsonForResponse(): String

// Getting updates

/**
 * <p>Use this method to receive incoming updates using long polling (<a href="https://en.wikipedia.org/wiki/Push_technology#Long_polling">wiki</a>). An Array of <a href="#update">Update</a> objects is returned.</p><blockquote> 
 *  <p><strong>Notes</strong><br><strong>1.</strong> This method will not work if an outgoing webhook is set up.<br><strong>2.</strong> In order to avoid getting duplicate updates, recalculate <em>offset</em> after each server response.</p> 
 * </blockquote>
 *
 * @property offset Identifier of the first update to be returned. Must be greater by one than the highest among the identifiers of previously received updates. By default, updates starting with the earliest unconfirmed update are returned. An update is considered confirmed as soon as <a href="#getupdates">getUpdates</a> is called with an <em>offset</em> higher than its <em>update_id</em>. The negative offset can be specified to retrieve updates starting from <em>-offset</em> update from the end of the updates queue. All previous updates will forgotten.
 * @property limit Limits the number of updates to be retrieved. Values between 1-100 are accepted. Defaults to 100.
 * @property timeout Timeout in seconds for long polling. Defaults to 0, i.e. usual short polling. Should be positive, short polling should be used for testing purposes only.
 * @property allowed_updates A JSON-serialized list of the update types you want your bot to receive. For example, specify [“message”, “edited_channel_post”, “callback_query”] to only receive updates of these types. See <a href="#update">Update</a> for a complete list of available update types. Specify an empty list to receive all update types except <em>chat_member</em> (default). If not specified, the previous setting will be used.<br><br>Please note that this parameter doesn't affect updates created before the call to the getUpdates, so unwanted updates may be received for a short period of time.
 * */
@Serializable
data class GetUpdatesRequest(
    val offset: Long? = null,
    val limit: Long? = null,
    val timeout: Long? = null,
    val allowed_updates: List<String>? = null,
) : TelegramRequest() {
    override fun toJsonForRequest() = json.encodeToString(serializer(), this)
    override fun toJsonForResponse() = JsonObject(
        json.encodeToJsonElement(serializer(), this).jsonObject + ("method" to JsonPrimitive("getUpdates"))
    ).toString()
    companion object {
        fun fromJson(string: String) = json.decodeFromString(serializer(), string)
    }
}

/**
 * <p>Use this method to specify a URL and receive incoming updates via an outgoing webhook. Whenever there is an update for the bot, we will send an HTTPS POST request to the specified URL, containing a JSON-serialized <a href="#update">Update</a>. In case of an unsuccessful request, we will give up after a reasonable amount of attempts. Returns <em>True</em> on success.</p><p>If you'd like to make sure that the webhook was set by you, you can specify secret data in the parameter <em>secret_token</em>. If specified, the request will contain a header “X-Telegram-Bot-Api-Secret-Token” with the secret token as content.</p><blockquote> 
 *  <p><strong>Notes</strong><br><strong>1.</strong> You will not be able to receive updates using <a href="#getupdates">getUpdates</a> for as long as an outgoing webhook is set up.<br><strong>2.</strong> To use a self-signed certificate, you need to upload your <a href="/bots/self-signed">public key certificate</a> using <em>certificate</em> parameter. Please upload as InputFile, sending a String will not work.<br><strong>3.</strong> Ports currently supported <em>for webhooks</em>: <strong>443, 80, 88, 8443</strong>.</p> 
 *  <p>If you're having any trouble setting up webhooks, please check out this <a href="/bots/webhooks">amazing guide to webhooks</a>.</p> 
 * </blockquote>
 *
 * @property url HTTPS URL to send updates to. Use an empty string to remove webhook integration
 * @property certificate Upload your public key certificate so that the root certificate in use can be checked. See our <a href="/bots/self-signed">self-signed guide</a> for details.
 * @property ip_address The fixed IP address which will be used to send webhook requests instead of the IP address resolved through DNS
 * @property max_connections The maximum allowed number of simultaneous HTTPS connections to the webhook for update delivery, 1-100. Defaults to <em>40</em>. Use lower values to limit the load on your bot's server, and higher values to increase your bot's throughput.
 * @property allowed_updates A JSON-serialized list of the update types you want your bot to receive. For example, specify [“message”, “edited_channel_post”, “callback_query”] to only receive updates of these types. See <a href="#update">Update</a> for a complete list of available update types. Specify an empty list to receive all update types except <em>chat_member</em> (default). If not specified, the previous setting will be used.<br>Please note that this parameter doesn't affect updates created before the call to the setWebhook, so unwanted updates may be received for a short period of time.
 * @property drop_pending_updates Pass <em>True</em> to drop all pending updates
 * @property secret_token A secret token to be sent in a header “X-Telegram-Bot-Api-Secret-Token” in every webhook request, 1-256 characters. Only characters <code>A-Z</code>, <code>a-z</code>, <code>0-9</code>, <code>_</code> and <code>-</code> are allowed. The header is useful to ensure that the request comes from a webhook set by you.
 * */
@Serializable
data class SetWebhookRequest(
    val url: String,
    val certificate: @Contextual Any? = null,
    val ip_address: String? = null,
    val max_connections: Long? = null,
    val allowed_updates: List<String>? = null,
    val drop_pending_updates: Boolean? = null,
    val secret_token: String? = null,
) : TelegramRequest() {
    override fun toJsonForRequest() = json.encodeToString(serializer(), this)
    override fun toJsonForResponse() = JsonObject(
        json.encodeToJsonElement(serializer(), this).jsonObject + ("method" to JsonPrimitive("setWebhook"))
    ).toString()
    companion object {
        fun fromJson(string: String) = json.decodeFromString(serializer(), string)
    }
}

/**
 * <p>Use this method to remove webhook integration if you decide to switch back to <a href="#getupdates">getUpdates</a>. Returns <em>True</em> on success.</p>
 *
 * @property drop_pending_updates Pass <em>True</em> to drop all pending updates
 * */
@Serializable
data class DeleteWebhookRequest(
    val drop_pending_updates: Boolean? = null,
) : TelegramRequest() {
    override fun toJsonForRequest() = json.encodeToString(serializer(), this)
    override fun toJsonForResponse() = JsonObject(
        json.encodeToJsonElement(serializer(), this).jsonObject + ("method" to JsonPrimitive("deleteWebhook"))
    ).toString()
    companion object {
        fun fromJson(string: String) = json.decodeFromString(serializer(), string)
    }
}


// Available methods

/**
 * <p>Use this method to send text messages. On success, the sent <a href="#message">Message</a> is returned.</p>
 *
 * @property chat_id Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>)
 * @property text Text of the message to be sent, 1-4096 characters after entities parsing
 * @property parse_mode Mode for parsing entities in the message text. See <a href="#formatting-options">formatting options</a> for more details.
 * @property entities A JSON-serialized list of special entities that appear in message text, which can be specified instead of <em>parse_mode</em>
 * @property disable_web_page_preview Disables link previews for links in this message
 * @property disable_notification Sends the message <a href="https://telegram.org/blog/channels-2-0#silent-messages">silently</a>. Users will receive a notification with no sound.
 * @property protect_content Protects the contents of the sent message from forwarding and saving
 * @property reply_to_message_id If the message is a reply, ID of the original message
 * @property allow_sending_without_reply Pass <em>True</em>, if the message should be sent even if the specified replied-to message is not found
 * @property reply_markup Additional interface options. A JSON-serialized object for an <a href="https://core.telegram.org/bots#inline-keyboards-and-on-the-fly-updating">inline keyboard</a>, <a href="https://core.telegram.org/bots#keyboards">custom reply keyboard</a>, instructions to remove reply keyboard or to force a reply from the user.
 * */
@Serializable
data class SendMessageRequest(
    val chat_id: String,
    val text: String,
    val parse_mode: ParseMode? = null,
    val entities: List<MessageEntity>? = null,
    val disable_web_page_preview: Boolean? = null,
    val disable_notification: Boolean? = null,
    val protect_content: Boolean? = null,
    val reply_to_message_id: Long? = null,
    val allow_sending_without_reply: Boolean? = null,
    val reply_markup: @Contextual KeyboardOption? = null,
) : TelegramRequest() {
    override fun toJsonForRequest() = json.encodeToString(serializer(), this)
    override fun toJsonForResponse() = JsonObject(
        json.encodeToJsonElement(serializer(), this).jsonObject + ("method" to JsonPrimitive("sendMessage"))
    ).toString()
    companion object {
        fun fromJson(string: String) = json.decodeFromString(serializer(), string)
    }
}

/**
 * <p>Use this method to forward messages of any kind. Service messages can't be forwarded. On success, the sent <a href="#message">Message</a> is returned.</p>
 *
 * @property chat_id Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>)
 * @property from_chat_id Unique identifier for the chat where the original message was sent (or channel username in the format <code>@channelusername</code>)
 * @property disable_notification Sends the message <a href="https://telegram.org/blog/channels-2-0#silent-messages">silently</a>. Users will receive a notification with no sound.
 * @property protect_content Protects the contents of the forwarded message from forwarding and saving
 * @property message_id Message identifier in the chat specified in <em>from_chat_id</em>
 * */
@Serializable
data class ForwardMessageRequest(
    val chat_id: String,
    val from_chat_id: String,
    val disable_notification: Boolean? = null,
    val protect_content: Boolean? = null,
    val message_id: Long,
) : TelegramRequest() {
    override fun toJsonForRequest() = json.encodeToString(serializer(), this)
    override fun toJsonForResponse() = JsonObject(
        json.encodeToJsonElement(serializer(), this).jsonObject + ("method" to JsonPrimitive("forwardMessage"))
    ).toString()
    companion object {
        fun fromJson(string: String) = json.decodeFromString(serializer(), string)
    }
}

/**
 * <p>Use this method to copy messages of any kind. Service messages and invoice messages can't be copied. The method is analogous to the method <a href="#forwardmessage">forwardMessage</a>, but the copied message doesn't have a link to the original message. Returns the <a href="#messageid">MessageId</a> of the sent message on success.</p>
 *
 * @property chat_id Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>)
 * @property from_chat_id Unique identifier for the chat where the original message was sent (or channel username in the format <code>@channelusername</code>)
 * @property message_id Message identifier in the chat specified in <em>from_chat_id</em>
 * @property caption New caption for media, 0-1024 characters after entities parsing. If not specified, the original caption is kept
 * @property parse_mode Mode for parsing entities in the new caption. See <a href="#formatting-options">formatting options</a> for more details.
 * @property caption_entities A JSON-serialized list of special entities that appear in the new caption, which can be specified instead of <em>parse_mode</em>
 * @property disable_notification Sends the message <a href="https://telegram.org/blog/channels-2-0#silent-messages">silently</a>. Users will receive a notification with no sound.
 * @property protect_content Protects the contents of the sent message from forwarding and saving
 * @property reply_to_message_id If the message is a reply, ID of the original message
 * @property allow_sending_without_reply Pass <em>True</em>, if the message should be sent even if the specified replied-to message is not found
 * @property reply_markup Additional interface options. A JSON-serialized object for an <a href="https://core.telegram.org/bots#inline-keyboards-and-on-the-fly-updating">inline keyboard</a>, <a href="https://core.telegram.org/bots#keyboards">custom reply keyboard</a>, instructions to remove reply keyboard or to force a reply from the user.
 * */
@Serializable
data class CopyMessageRequest(
    val chat_id: String,
    val from_chat_id: String,
    val message_id: Long,
    val caption: String? = null,
    val parse_mode: ParseMode? = null,
    val caption_entities: List<MessageEntity>? = null,
    val disable_notification: Boolean? = null,
    val protect_content: Boolean? = null,
    val reply_to_message_id: Long? = null,
    val allow_sending_without_reply: Boolean? = null,
    val reply_markup: @Contextual KeyboardOption? = null,
) : TelegramRequest() {
    override fun toJsonForRequest() = json.encodeToString(serializer(), this)
    override fun toJsonForResponse() = JsonObject(
        json.encodeToJsonElement(serializer(), this).jsonObject + ("method" to JsonPrimitive("copyMessage"))
    ).toString()
    companion object {
        fun fromJson(string: String) = json.decodeFromString(serializer(), string)
    }
}

/**
 * <p>Use this method to send photos. On success, the sent <a href="#message">Message</a> is returned.</p>
 *
 * @property chat_id Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>)
 * @property photo Photo to send. Pass a file_id as String to send a photo that exists on the Telegram servers (recommended), pass an HTTP URL as a String for Telegram to get a photo from the Internet, or upload a new photo using multipart/form-data. The photo must be at most 10 MB in size. The photo's width and height must not exceed 10000 in total. Width and height ratio must be at most 20. <a href="#sending-files">More information on Sending Files »</a>
 * @property caption Photo caption (may also be used when resending photos by <em>file_id</em>), 0-1024 characters after entities parsing
 * @property parse_mode Mode for parsing entities in the photo caption. See <a href="#formatting-options">formatting options</a> for more details.
 * @property caption_entities A JSON-serialized list of special entities that appear in the caption, which can be specified instead of <em>parse_mode</em>
 * @property disable_notification Sends the message <a href="https://telegram.org/blog/channels-2-0#silent-messages">silently</a>. Users will receive a notification with no sound.
 * @property protect_content Protects the contents of the sent message from forwarding and saving
 * @property reply_to_message_id If the message is a reply, ID of the original message
 * @property allow_sending_without_reply Pass <em>True</em>, if the message should be sent even if the specified replied-to message is not found
 * @property reply_markup Additional interface options. A JSON-serialized object for an <a href="https://core.telegram.org/bots#inline-keyboards-and-on-the-fly-updating">inline keyboard</a>, <a href="https://core.telegram.org/bots#keyboards">custom reply keyboard</a>, instructions to remove reply keyboard or to force a reply from the user.
 * */
@Serializable
data class SendPhotoRequest(
    val chat_id: String,
    val photo: String,
    val caption: String? = null,
    val parse_mode: ParseMode? = null,
    val caption_entities: List<MessageEntity>? = null,
    val disable_notification: Boolean? = null,
    val protect_content: Boolean? = null,
    val reply_to_message_id: Long? = null,
    val allow_sending_without_reply: Boolean? = null,
    val reply_markup: @Contextual KeyboardOption? = null,
) : TelegramRequest() {
    override fun toJsonForRequest() = json.encodeToString(serializer(), this)
    override fun toJsonForResponse() = JsonObject(
        json.encodeToJsonElement(serializer(), this).jsonObject + ("method" to JsonPrimitive("sendPhoto"))
    ).toString()
    companion object {
        fun fromJson(string: String) = json.decodeFromString(serializer(), string)
    }
}

/**
 * <p>Use this method to send audio files, if you want Telegram clients to display them in the music player. Your audio must be in the .MP3 or .M4A format. On success, the sent <a href="#message">Message</a> is returned. Bots can currently send audio files of up to 50 MB in size, this limit may be changed in the future.</p><p>For sending voice messages, use the <a href="#sendvoice">sendVoice</a> method instead.</p>
 *
 * @property chat_id Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>)
 * @property audio Audio file to send. Pass a file_id as String to send an audio file that exists on the Telegram servers (recommended), pass an HTTP URL as a String for Telegram to get an audio file from the Internet, or upload a new one using multipart/form-data. <a href="#sending-files">More information on Sending Files »</a>
 * @property caption Audio caption, 0-1024 characters after entities parsing
 * @property parse_mode Mode for parsing entities in the audio caption. See <a href="#formatting-options">formatting options</a> for more details.
 * @property caption_entities A JSON-serialized list of special entities that appear in the caption, which can be specified instead of <em>parse_mode</em>
 * @property duration Duration of the audio in seconds
 * @property performer Performer
 * @property title Track name
 * @property thumb Thumbnail of the file sent; can be ignored if thumbnail generation for the file is supported server-side. The thumbnail should be in JPEG format and less than 200 kB in size. A thumbnail's width and height should not exceed 320. Ignored if the file is not uploaded using multipart/form-data. Thumbnails can't be reused and can be only uploaded as a new file, so you can pass “attach://&lt;file_attach_name&gt;” if the thumbnail was uploaded using multipart/form-data under &lt;file_attach_name&gt;. <a href="#sending-files">More information on Sending Files »</a>
 * @property disable_notification Sends the message <a href="https://telegram.org/blog/channels-2-0#silent-messages">silently</a>. Users will receive a notification with no sound.
 * @property protect_content Protects the contents of the sent message from forwarding and saving
 * @property reply_to_message_id If the message is a reply, ID of the original message
 * @property allow_sending_without_reply Pass <em>True</em>, if the message should be sent even if the specified replied-to message is not found
 * @property reply_markup Additional interface options. A JSON-serialized object for an <a href="https://core.telegram.org/bots#inline-keyboards-and-on-the-fly-updating">inline keyboard</a>, <a href="https://core.telegram.org/bots#keyboards">custom reply keyboard</a>, instructions to remove reply keyboard or to force a reply from the user.
 * */
@Serializable
data class SendAudioRequest(
    val chat_id: String,
    val audio: String,
    val caption: String? = null,
    val parse_mode: ParseMode? = null,
    val caption_entities: List<MessageEntity>? = null,
    val duration: Long? = null,
    val performer: String? = null,
    val title: String? = null,
    val thumb: String? = null,
    val disable_notification: Boolean? = null,
    val protect_content: Boolean? = null,
    val reply_to_message_id: Long? = null,
    val allow_sending_without_reply: Boolean? = null,
    val reply_markup: @Contextual KeyboardOption? = null,
) : TelegramRequest() {
    override fun toJsonForRequest() = json.encodeToString(serializer(), this)
    override fun toJsonForResponse() = JsonObject(
        json.encodeToJsonElement(serializer(), this).jsonObject + ("method" to JsonPrimitive("sendAudio"))
    ).toString()
    companion object {
        fun fromJson(string: String) = json.decodeFromString(serializer(), string)
    }
}

/**
 * <p>Use this method to send general files. On success, the sent <a href="#message">Message</a> is returned. Bots can currently send files of any type of up to 50 MB in size, this limit may be changed in the future.</p>
 *
 * @property chat_id Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>)
 * @property document File to send. Pass a file_id as String to send a file that exists on the Telegram servers (recommended), pass an HTTP URL as a String for Telegram to get a file from the Internet, or upload a new one using multipart/form-data. <a href="#sending-files">More information on Sending Files »</a>
 * @property thumb Thumbnail of the file sent; can be ignored if thumbnail generation for the file is supported server-side. The thumbnail should be in JPEG format and less than 200 kB in size. A thumbnail's width and height should not exceed 320. Ignored if the file is not uploaded using multipart/form-data. Thumbnails can't be reused and can be only uploaded as a new file, so you can pass “attach://&lt;file_attach_name&gt;” if the thumbnail was uploaded using multipart/form-data under &lt;file_attach_name&gt;. <a href="#sending-files">More information on Sending Files »</a>
 * @property caption Document caption (may also be used when resending documents by <em>file_id</em>), 0-1024 characters after entities parsing
 * @property parse_mode Mode for parsing entities in the document caption. See <a href="#formatting-options">formatting options</a> for more details.
 * @property caption_entities A JSON-serialized list of special entities that appear in the caption, which can be specified instead of <em>parse_mode</em>
 * @property disable_content_type_detection Disables automatic server-side content type detection for files uploaded using multipart/form-data
 * @property disable_notification Sends the message <a href="https://telegram.org/blog/channels-2-0#silent-messages">silently</a>. Users will receive a notification with no sound.
 * @property protect_content Protects the contents of the sent message from forwarding and saving
 * @property reply_to_message_id If the message is a reply, ID of the original message
 * @property allow_sending_without_reply Pass <em>True</em>, if the message should be sent even if the specified replied-to message is not found
 * @property reply_markup Additional interface options. A JSON-serialized object for an <a href="https://core.telegram.org/bots#inline-keyboards-and-on-the-fly-updating">inline keyboard</a>, <a href="https://core.telegram.org/bots#keyboards">custom reply keyboard</a>, instructions to remove reply keyboard or to force a reply from the user.
 * */
@Serializable
data class SendDocumentRequest(
    val chat_id: String,
    val document: String,
    val thumb: String? = null,
    val caption: String? = null,
    val parse_mode: ParseMode? = null,
    val caption_entities: List<MessageEntity>? = null,
    val disable_content_type_detection: Boolean? = null,
    val disable_notification: Boolean? = null,
    val protect_content: Boolean? = null,
    val reply_to_message_id: Long? = null,
    val allow_sending_without_reply: Boolean? = null,
    val reply_markup: @Contextual KeyboardOption? = null,
) : TelegramRequest() {
    override fun toJsonForRequest() = json.encodeToString(serializer(), this)
    override fun toJsonForResponse() = JsonObject(
        json.encodeToJsonElement(serializer(), this).jsonObject + ("method" to JsonPrimitive("sendDocument"))
    ).toString()
    companion object {
        fun fromJson(string: String) = json.decodeFromString(serializer(), string)
    }
}

/**
 * <p>Use this method to send video files, Telegram clients support MPEG4 videos (other formats may be sent as <a href="#document">Document</a>). On success, the sent <a href="#message">Message</a> is returned. Bots can currently send video files of up to 50 MB in size, this limit may be changed in the future.</p>
 *
 * @property chat_id Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>)
 * @property video Video to send. Pass a file_id as String to send a video that exists on the Telegram servers (recommended), pass an HTTP URL as a String for Telegram to get a video from the Internet, or upload a new video using multipart/form-data. <a href="#sending-files">More information on Sending Files »</a>
 * @property duration Duration of sent video in seconds
 * @property width Video width
 * @property height Video height
 * @property thumb Thumbnail of the file sent; can be ignored if thumbnail generation for the file is supported server-side. The thumbnail should be in JPEG format and less than 200 kB in size. A thumbnail's width and height should not exceed 320. Ignored if the file is not uploaded using multipart/form-data. Thumbnails can't be reused and can be only uploaded as a new file, so you can pass “attach://&lt;file_attach_name&gt;” if the thumbnail was uploaded using multipart/form-data under &lt;file_attach_name&gt;. <a href="#sending-files">More information on Sending Files »</a>
 * @property caption Video caption (may also be used when resending videos by <em>file_id</em>), 0-1024 characters after entities parsing
 * @property parse_mode Mode for parsing entities in the video caption. See <a href="#formatting-options">formatting options</a> for more details.
 * @property caption_entities A JSON-serialized list of special entities that appear in the caption, which can be specified instead of <em>parse_mode</em>
 * @property supports_streaming Pass <em>True</em>, if the uploaded video is suitable for streaming
 * @property disable_notification Sends the message <a href="https://telegram.org/blog/channels-2-0#silent-messages">silently</a>. Users will receive a notification with no sound.
 * @property protect_content Protects the contents of the sent message from forwarding and saving
 * @property reply_to_message_id If the message is a reply, ID of the original message
 * @property allow_sending_without_reply Pass <em>True</em>, if the message should be sent even if the specified replied-to message is not found
 * @property reply_markup Additional interface options. A JSON-serialized object for an <a href="https://core.telegram.org/bots#inline-keyboards-and-on-the-fly-updating">inline keyboard</a>, <a href="https://core.telegram.org/bots#keyboards">custom reply keyboard</a>, instructions to remove reply keyboard or to force a reply from the user.
 * */
@Serializable
data class SendVideoRequest(
    val chat_id: String,
    val video: String,
    val duration: Long? = null,
    val width: Long? = null,
    val height: Long? = null,
    val thumb: String? = null,
    val caption: String? = null,
    val parse_mode: ParseMode? = null,
    val caption_entities: List<MessageEntity>? = null,
    val supports_streaming: Boolean? = null,
    val disable_notification: Boolean? = null,
    val protect_content: Boolean? = null,
    val reply_to_message_id: Long? = null,
    val allow_sending_without_reply: Boolean? = null,
    val reply_markup: @Contextual KeyboardOption? = null,
) : TelegramRequest() {
    override fun toJsonForRequest() = json.encodeToString(serializer(), this)
    override fun toJsonForResponse() = JsonObject(
        json.encodeToJsonElement(serializer(), this).jsonObject + ("method" to JsonPrimitive("sendVideo"))
    ).toString()
    companion object {
        fun fromJson(string: String) = json.decodeFromString(serializer(), string)
    }
}

/**
 * <p>Use this method to send animation files (GIF or H.264/MPEG-4 AVC video without sound). On success, the sent <a href="#message">Message</a> is returned. Bots can currently send animation files of up to 50 MB in size, this limit may be changed in the future.</p>
 *
 * @property chat_id Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>)
 * @property animation Animation to send. Pass a file_id as String to send an animation that exists on the Telegram servers (recommended), pass an HTTP URL as a String for Telegram to get an animation from the Internet, or upload a new animation using multipart/form-data. <a href="#sending-files">More information on Sending Files »</a>
 * @property duration Duration of sent animation in seconds
 * @property width Animation width
 * @property height Animation height
 * @property thumb Thumbnail of the file sent; can be ignored if thumbnail generation for the file is supported server-side. The thumbnail should be in JPEG format and less than 200 kB in size. A thumbnail's width and height should not exceed 320. Ignored if the file is not uploaded using multipart/form-data. Thumbnails can't be reused and can be only uploaded as a new file, so you can pass “attach://&lt;file_attach_name&gt;” if the thumbnail was uploaded using multipart/form-data under &lt;file_attach_name&gt;. <a href="#sending-files">More information on Sending Files »</a>
 * @property caption Animation caption (may also be used when resending animation by <em>file_id</em>), 0-1024 characters after entities parsing
 * @property parse_mode Mode for parsing entities in the animation caption. See <a href="#formatting-options">formatting options</a> for more details.
 * @property caption_entities A JSON-serialized list of special entities that appear in the caption, which can be specified instead of <em>parse_mode</em>
 * @property disable_notification Sends the message <a href="https://telegram.org/blog/channels-2-0#silent-messages">silently</a>. Users will receive a notification with no sound.
 * @property protect_content Protects the contents of the sent message from forwarding and saving
 * @property reply_to_message_id If the message is a reply, ID of the original message
 * @property allow_sending_without_reply Pass <em>True</em>, if the message should be sent even if the specified replied-to message is not found
 * @property reply_markup Additional interface options. A JSON-serialized object for an <a href="https://core.telegram.org/bots#inline-keyboards-and-on-the-fly-updating">inline keyboard</a>, <a href="https://core.telegram.org/bots#keyboards">custom reply keyboard</a>, instructions to remove reply keyboard or to force a reply from the user.
 * */
@Serializable
data class SendAnimationRequest(
    val chat_id: String,
    val animation: String,
    val duration: Long? = null,
    val width: Long? = null,
    val height: Long? = null,
    val thumb: String? = null,
    val caption: String? = null,
    val parse_mode: ParseMode? = null,
    val caption_entities: List<MessageEntity>? = null,
    val disable_notification: Boolean? = null,
    val protect_content: Boolean? = null,
    val reply_to_message_id: Long? = null,
    val allow_sending_without_reply: Boolean? = null,
    val reply_markup: @Contextual KeyboardOption? = null,
) : TelegramRequest() {
    override fun toJsonForRequest() = json.encodeToString(serializer(), this)
    override fun toJsonForResponse() = JsonObject(
        json.encodeToJsonElement(serializer(), this).jsonObject + ("method" to JsonPrimitive("sendAnimation"))
    ).toString()
    companion object {
        fun fromJson(string: String) = json.decodeFromString(serializer(), string)
    }
}

/**
 * <p>Use this method to send audio files, if you want Telegram clients to display the file as a playable voice message. For this to work, your audio must be in an .OGG file encoded with OPUS (other formats may be sent as <a href="#audio">Audio</a> or <a href="#document">Document</a>). On success, the sent <a href="#message">Message</a> is returned. Bots can currently send voice messages of up to 50 MB in size, this limit may be changed in the future.</p>
 *
 * @property chat_id Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>)
 * @property voice Audio file to send. Pass a file_id as String to send a file that exists on the Telegram servers (recommended), pass an HTTP URL as a String for Telegram to get a file from the Internet, or upload a new one using multipart/form-data. <a href="#sending-files">More information on Sending Files »</a>
 * @property caption Voice message caption, 0-1024 characters after entities parsing
 * @property parse_mode Mode for parsing entities in the voice message caption. See <a href="#formatting-options">formatting options</a> for more details.
 * @property caption_entities A JSON-serialized list of special entities that appear in the caption, which can be specified instead of <em>parse_mode</em>
 * @property duration Duration of the voice message in seconds
 * @property disable_notification Sends the message <a href="https://telegram.org/blog/channels-2-0#silent-messages">silently</a>. Users will receive a notification with no sound.
 * @property protect_content Protects the contents of the sent message from forwarding and saving
 * @property reply_to_message_id If the message is a reply, ID of the original message
 * @property allow_sending_without_reply Pass <em>True</em>, if the message should be sent even if the specified replied-to message is not found
 * @property reply_markup Additional interface options. A JSON-serialized object for an <a href="https://core.telegram.org/bots#inline-keyboards-and-on-the-fly-updating">inline keyboard</a>, <a href="https://core.telegram.org/bots#keyboards">custom reply keyboard</a>, instructions to remove reply keyboard or to force a reply from the user.
 * */
@Serializable
data class SendVoiceRequest(
    val chat_id: String,
    val voice: String,
    val caption: String? = null,
    val parse_mode: ParseMode? = null,
    val caption_entities: List<MessageEntity>? = null,
    val duration: Long? = null,
    val disable_notification: Boolean? = null,
    val protect_content: Boolean? = null,
    val reply_to_message_id: Long? = null,
    val allow_sending_without_reply: Boolean? = null,
    val reply_markup: @Contextual KeyboardOption? = null,
) : TelegramRequest() {
    override fun toJsonForRequest() = json.encodeToString(serializer(), this)
    override fun toJsonForResponse() = JsonObject(
        json.encodeToJsonElement(serializer(), this).jsonObject + ("method" to JsonPrimitive("sendVoice"))
    ).toString()
    companion object {
        fun fromJson(string: String) = json.decodeFromString(serializer(), string)
    }
}

/**
 * <p>As of <a href="https://telegram.org/blog/video-messages-and-telescope">v.4.0</a>, Telegram clients support rounded square MPEG4 videos of up to 1 minute long. Use this method to send video messages. On success, the sent <a href="#message">Message</a> is returned.</p>
 *
 * @property chat_id Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>)
 * @property video_note Video note to send. Pass a file_id as String to send a video note that exists on the Telegram servers (recommended) or upload a new video using multipart/form-data. <a href="#sending-files">More information on Sending Files »</a>. Sending video notes by a URL is currently unsupported
 * @property duration Duration of sent video in seconds
 * @property length Video width and height, i.e. diameter of the video message
 * @property thumb Thumbnail of the file sent; can be ignored if thumbnail generation for the file is supported server-side. The thumbnail should be in JPEG format and less than 200 kB in size. A thumbnail's width and height should not exceed 320. Ignored if the file is not uploaded using multipart/form-data. Thumbnails can't be reused and can be only uploaded as a new file, so you can pass “attach://&lt;file_attach_name&gt;” if the thumbnail was uploaded using multipart/form-data under &lt;file_attach_name&gt;. <a href="#sending-files">More information on Sending Files »</a>
 * @property disable_notification Sends the message <a href="https://telegram.org/blog/channels-2-0#silent-messages">silently</a>. Users will receive a notification with no sound.
 * @property protect_content Protects the contents of the sent message from forwarding and saving
 * @property reply_to_message_id If the message is a reply, ID of the original message
 * @property allow_sending_without_reply Pass <em>True</em>, if the message should be sent even if the specified replied-to message is not found
 * @property reply_markup Additional interface options. A JSON-serialized object for an <a href="https://core.telegram.org/bots#inline-keyboards-and-on-the-fly-updating">inline keyboard</a>, <a href="https://core.telegram.org/bots#keyboards">custom reply keyboard</a>, instructions to remove reply keyboard or to force a reply from the user.
 * */
@Serializable
data class SendVideoNoteRequest(
    val chat_id: String,
    val video_note: String,
    val duration: Long? = null,
    val length: Long? = null,
    val thumb: String? = null,
    val disable_notification: Boolean? = null,
    val protect_content: Boolean? = null,
    val reply_to_message_id: Long? = null,
    val allow_sending_without_reply: Boolean? = null,
    val reply_markup: @Contextual KeyboardOption? = null,
) : TelegramRequest() {
    override fun toJsonForRequest() = json.encodeToString(serializer(), this)
    override fun toJsonForResponse() = JsonObject(
        json.encodeToJsonElement(serializer(), this).jsonObject + ("method" to JsonPrimitive("sendVideoNote"))
    ).toString()
    companion object {
        fun fromJson(string: String) = json.decodeFromString(serializer(), string)
    }
}

/**
 * <p>Use this method to send a group of photos, videos, documents or audios as an album. Documents and audio files can be only grouped in an album with messages of the same type. On success, an array of <a href="#message">Messages</a> that were sent is returned.</p>
 *
 * @property chat_id Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>)
 * @property media A JSON-serialized array describing messages to be sent, must include 2-10 items
 * @property disable_notification Sends messages <a href="https://telegram.org/blog/channels-2-0#silent-messages">silently</a>. Users will receive a notification with no sound.
 * @property protect_content Protects the contents of the sent messages from forwarding and saving
 * @property reply_to_message_id If the messages are a reply, ID of the original message
 * @property allow_sending_without_reply Pass <em>True</em>, if the message should be sent even if the specified replied-to message is not found
 * */
@Serializable
data class SendMediaGroupRequest(
    val chat_id: String,
    val media: List<@Contextual InputMedia>,
    val disable_notification: Boolean? = null,
    val protect_content: Boolean? = null,
    val reply_to_message_id: Long? = null,
    val allow_sending_without_reply: Boolean? = null,
) : TelegramRequest() {
    override fun toJsonForRequest() = json.encodeToString(serializer(), this)
    override fun toJsonForResponse() = JsonObject(
        json.encodeToJsonElement(serializer(), this).jsonObject + ("method" to JsonPrimitive("sendMediaGroup"))
    ).toString()
    companion object {
        fun fromJson(string: String) = json.decodeFromString(serializer(), string)
    }
}

/**
 * <p>Use this method to send point on the map. On success, the sent <a href="#message">Message</a> is returned.</p>
 *
 * @property chat_id Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>)
 * @property latitude Latitude of the location
 * @property longitude Longitude of the location
 * @property horizontal_accuracy The radius of uncertainty for the location, measured in meters; 0-1500
 * @property live_period Period in seconds for which the location will be updated (see <a href="https://telegram.org/blog/live-locations">Live Locations</a>, should be between 60 and 86400.
 * @property heading For live locations, a direction in which the user is moving, in degrees. Must be between 1 and 360 if specified.
 * @property proximity_alert_radius For live locations, a maximum distance for proximity alerts about approaching another chat member, in meters. Must be between 1 and 100000 if specified.
 * @property disable_notification Sends the message <a href="https://telegram.org/blog/channels-2-0#silent-messages">silently</a>. Users will receive a notification with no sound.
 * @property protect_content Protects the contents of the sent message from forwarding and saving
 * @property reply_to_message_id If the message is a reply, ID of the original message
 * @property allow_sending_without_reply Pass <em>True</em>, if the message should be sent even if the specified replied-to message is not found
 * @property reply_markup Additional interface options. A JSON-serialized object for an <a href="https://core.telegram.org/bots#inline-keyboards-and-on-the-fly-updating">inline keyboard</a>, <a href="https://core.telegram.org/bots#keyboards">custom reply keyboard</a>, instructions to remove reply keyboard or to force a reply from the user.
 * */
@Serializable
data class SendLocationRequest(
    val chat_id: String,
    val latitude: Float,
    val longitude: Float,
    val horizontal_accuracy: Float? = null,
    val live_period: Long? = null,
    val heading: Long? = null,
    val proximity_alert_radius: Long? = null,
    val disable_notification: Boolean? = null,
    val protect_content: Boolean? = null,
    val reply_to_message_id: Long? = null,
    val allow_sending_without_reply: Boolean? = null,
    val reply_markup: @Contextual KeyboardOption? = null,
) : TelegramRequest() {
    override fun toJsonForRequest() = json.encodeToString(serializer(), this)
    override fun toJsonForResponse() = JsonObject(
        json.encodeToJsonElement(serializer(), this).jsonObject + ("method" to JsonPrimitive("sendLocation"))
    ).toString()
    companion object {
        fun fromJson(string: String) = json.decodeFromString(serializer(), string)
    }
}

/**
 * <p>Use this method to edit live location messages. A location can be edited until its <em>live_period</em> expires or editing is explicitly disabled by a call to <a href="#stopmessagelivelocation">stopMessageLiveLocation</a>. On success, if the edited message is not an inline message, the edited <a href="#message">Message</a> is returned, otherwise <em>True</em> is returned.</p>
 *
 * @property chat_id Required if <em>inline_message_id</em> is not specified. Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>)
 * @property message_id Required if <em>inline_message_id</em> is not specified. Identifier of the message to edit
 * @property inline_message_id Required if <em>chat_id</em> and <em>message_id</em> are not specified. Identifier of the inline message
 * @property latitude Latitude of new location
 * @property longitude Longitude of new location
 * @property horizontal_accuracy The radius of uncertainty for the location, measured in meters; 0-1500
 * @property heading Direction in which the user is moving, in degrees. Must be between 1 and 360 if specified.
 * @property proximity_alert_radius The maximum distance for proximity alerts about approaching another chat member, in meters. Must be between 1 and 100000 if specified.
 * @property reply_markup A JSON-serialized object for a new <a href="https://core.telegram.org/bots#inline-keyboards-and-on-the-fly-updating">inline keyboard</a>.
 * */
@Serializable
data class EditMessageLiveLocationRequest(
    val chat_id: String? = null,
    val message_id: Long? = null,
    val inline_message_id: String? = null,
    val latitude: Float,
    val longitude: Float,
    val horizontal_accuracy: Float? = null,
    val heading: Long? = null,
    val proximity_alert_radius: Long? = null,
    val reply_markup: InlineKeyboardMarkup? = null,
) : TelegramRequest() {
    override fun toJsonForRequest() = json.encodeToString(serializer(), this)
    override fun toJsonForResponse() = JsonObject(
        json.encodeToJsonElement(serializer(), this).jsonObject + ("method" to JsonPrimitive("editMessageLiveLocation"))
    ).toString()
    companion object {
        fun fromJson(string: String) = json.decodeFromString(serializer(), string)
    }
}

/**
 * <p>Use this method to stop updating a live location message before <em>live_period</em> expires. On success, if the message is not an inline message, the edited <a href="#message">Message</a> is returned, otherwise <em>True</em> is returned.</p>
 *
 * @property chat_id Required if <em>inline_message_id</em> is not specified. Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>)
 * @property message_id Required if <em>inline_message_id</em> is not specified. Identifier of the message with live location to stop
 * @property inline_message_id Required if <em>chat_id</em> and <em>message_id</em> are not specified. Identifier of the inline message
 * @property reply_markup A JSON-serialized object for a new <a href="https://core.telegram.org/bots#inline-keyboards-and-on-the-fly-updating">inline keyboard</a>.
 * */
@Serializable
data class StopMessageLiveLocationRequest(
    val chat_id: String? = null,
    val message_id: Long? = null,
    val inline_message_id: String? = null,
    val reply_markup: InlineKeyboardMarkup? = null,
) : TelegramRequest() {
    override fun toJsonForRequest() = json.encodeToString(serializer(), this)
    override fun toJsonForResponse() = JsonObject(
        json.encodeToJsonElement(serializer(), this).jsonObject + ("method" to JsonPrimitive("stopMessageLiveLocation"))
    ).toString()
    companion object {
        fun fromJson(string: String) = json.decodeFromString(serializer(), string)
    }
}

/**
 * <p>Use this method to send information about a venue. On success, the sent <a href="#message">Message</a> is returned.</p>
 *
 * @property chat_id Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>)
 * @property latitude Latitude of the venue
 * @property longitude Longitude of the venue
 * @property title Name of the venue
 * @property address Address of the venue
 * @property foursquare_id Foursquare identifier of the venue
 * @property foursquare_type Foursquare type of the venue, if known. (For example, “arts_entertainment/default”, “arts_entertainment/aquarium” or “food/icecream”.)
 * @property google_place_id Google Places identifier of the venue
 * @property google_place_type Google Places type of the venue. (See <a href="https://developers.google.com/places/web-service/supported_types">supported types</a>.)
 * @property disable_notification Sends the message <a href="https://telegram.org/blog/channels-2-0#silent-messages">silently</a>. Users will receive a notification with no sound.
 * @property protect_content Protects the contents of the sent message from forwarding and saving
 * @property reply_to_message_id If the message is a reply, ID of the original message
 * @property allow_sending_without_reply Pass <em>True</em>, if the message should be sent even if the specified replied-to message is not found
 * @property reply_markup Additional interface options. A JSON-serialized object for an <a href="https://core.telegram.org/bots#inline-keyboards-and-on-the-fly-updating">inline keyboard</a>, <a href="https://core.telegram.org/bots#keyboards">custom reply keyboard</a>, instructions to remove reply keyboard or to force a reply from the user.
 * */
@Serializable
data class SendVenueRequest(
    val chat_id: String,
    val latitude: Float,
    val longitude: Float,
    val title: String,
    val address: String,
    val foursquare_id: String? = null,
    val foursquare_type: String? = null,
    val google_place_id: String? = null,
    val google_place_type: String? = null,
    val disable_notification: Boolean? = null,
    val protect_content: Boolean? = null,
    val reply_to_message_id: Long? = null,
    val allow_sending_without_reply: Boolean? = null,
    val reply_markup: @Contextual KeyboardOption? = null,
) : TelegramRequest() {
    override fun toJsonForRequest() = json.encodeToString(serializer(), this)
    override fun toJsonForResponse() = JsonObject(
        json.encodeToJsonElement(serializer(), this).jsonObject + ("method" to JsonPrimitive("sendVenue"))
    ).toString()
    companion object {
        fun fromJson(string: String) = json.decodeFromString(serializer(), string)
    }
}

/**
 * <p>Use this method to send phone contacts. On success, the sent <a href="#message">Message</a> is returned.</p>
 *
 * @property chat_id Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>)
 * @property phone_number Contact's phone number
 * @property first_name Contact's first name
 * @property last_name Contact's last name
 * @property vcard Additional data about the contact in the form of a <a href="https://en.wikipedia.org/wiki/VCard">vCard</a>, 0-2048 bytes
 * @property disable_notification Sends the message <a href="https://telegram.org/blog/channels-2-0#silent-messages">silently</a>. Users will receive a notification with no sound.
 * @property protect_content Protects the contents of the sent message from forwarding and saving
 * @property reply_to_message_id If the message is a reply, ID of the original message
 * @property allow_sending_without_reply Pass <em>True</em>, if the message should be sent even if the specified replied-to message is not found
 * @property reply_markup Additional interface options. A JSON-serialized object for an <a href="https://core.telegram.org/bots#inline-keyboards-and-on-the-fly-updating">inline keyboard</a>, <a href="https://core.telegram.org/bots#keyboards">custom reply keyboard</a>, instructions to remove keyboard or to force a reply from the user.
 * */
@Serializable
data class SendContactRequest(
    val chat_id: String,
    val phone_number: String,
    val first_name: String,
    val last_name: String? = null,
    val vcard: String? = null,
    val disable_notification: Boolean? = null,
    val protect_content: Boolean? = null,
    val reply_to_message_id: Long? = null,
    val allow_sending_without_reply: Boolean? = null,
    val reply_markup: @Contextual KeyboardOption? = null,
) : TelegramRequest() {
    override fun toJsonForRequest() = json.encodeToString(serializer(), this)
    override fun toJsonForResponse() = JsonObject(
        json.encodeToJsonElement(serializer(), this).jsonObject + ("method" to JsonPrimitive("sendContact"))
    ).toString()
    companion object {
        fun fromJson(string: String) = json.decodeFromString(serializer(), string)
    }
}

/**
 * <p>Use this method to send a native poll. On success, the sent <a href="#message">Message</a> is returned.</p>
 *
 * @property chat_id Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>)
 * @property question Poll question, 1-300 characters
 * @property options A JSON-serialized list of answer options, 2-10 strings 1-100 characters each
 * @property is_anonymous <em>True</em>, if the poll needs to be anonymous, defaults to <em>True</em>
 * @property type Poll type, “quiz” or “regular”, defaults to “regular”
 * @property allows_multiple_answers <em>True</em>, if the poll allows multiple answers, ignored for polls in quiz mode, defaults to <em>False</em>
 * @property correct_option_id 0-based identifier of the correct answer option, required for polls in quiz mode
 * @property explanation Text that is shown when a user chooses an incorrect answer or taps on the lamp icon in a quiz-style poll, 0-200 characters with at most 2 line feeds after entities parsing
 * @property explanation_parse_mode Mode for parsing entities in the explanation. See <a href="#formatting-options">formatting options</a> for more details.
 * @property explanation_entities A JSON-serialized list of special entities that appear in the poll explanation, which can be specified instead of <em>parse_mode</em>
 * @property open_period Amount of time in seconds the poll will be active after creation, 5-600. Can't be used together with <em>close_date</em>.
 * @property close_date Point in time (Unix timestamp) when the poll will be automatically closed. Must be at least 5 and no more than 600 seconds in the future. Can't be used together with <em>open_period</em>.
 * @property is_closed Pass <em>True</em>, if the poll needs to be immediately closed. This can be useful for poll preview.
 * @property disable_notification Sends the message <a href="https://telegram.org/blog/channels-2-0#silent-messages">silently</a>. Users will receive a notification with no sound.
 * @property protect_content Protects the contents of the sent message from forwarding and saving
 * @property reply_to_message_id If the message is a reply, ID of the original message
 * @property allow_sending_without_reply Pass <em>True</em>, if the message should be sent even if the specified replied-to message is not found
 * @property reply_markup Additional interface options. A JSON-serialized object for an <a href="https://core.telegram.org/bots#inline-keyboards-and-on-the-fly-updating">inline keyboard</a>, <a href="https://core.telegram.org/bots#keyboards">custom reply keyboard</a>, instructions to remove reply keyboard or to force a reply from the user.
 * */
@Serializable
data class SendPollRequest(
    val chat_id: String,
    val question: String,
    val options: List<String>,
    val is_anonymous: Boolean? = null,
    val type: String? = null,
    val allows_multiple_answers: Boolean? = null,
    val correct_option_id: Long? = null,
    val explanation: String? = null,
    val explanation_parse_mode: String? = null,
    val explanation_entities: List<MessageEntity>? = null,
    val open_period: Long? = null,
    val close_date: Long? = null,
    val is_closed: Boolean? = null,
    val disable_notification: Boolean? = null,
    val protect_content: Boolean? = null,
    val reply_to_message_id: Long? = null,
    val allow_sending_without_reply: Boolean? = null,
    val reply_markup: @Contextual KeyboardOption? = null,
) : TelegramRequest() {
    override fun toJsonForRequest() = json.encodeToString(serializer(), this)
    override fun toJsonForResponse() = JsonObject(
        json.encodeToJsonElement(serializer(), this).jsonObject + ("method" to JsonPrimitive("sendPoll"))
    ).toString()
    companion object {
        fun fromJson(string: String) = json.decodeFromString(serializer(), string)
    }
}

/**
 * <p>Use this method to send an animated emoji that will display a random value. On success, the sent <a href="#message">Message</a> is returned.</p>
 *
 * @property chat_id Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>)
 * @property emoji Emoji on which the dice throw animation is based. Currently, must be one of “<img class="emoji" src="//telegram.org/img/emoji/40/F09F8EB2.png" width="20" height="20" alt="🎲">”, “<img class="emoji" src="//telegram.org/img/emoji/40/F09F8EAF.png" width="20" height="20" alt="🎯">”, “<img class="emoji" src="//telegram.org/img/emoji/40/F09F8F80.png" width="20" height="20" alt="🏀">”, “<img class="emoji" src="//telegram.org/img/emoji/40/E29ABD.png" width="20" height="20" alt="⚽">”, “<img class="emoji" src="//telegram.org/img/emoji/40/F09F8EB3.png" width="20" height="20" alt="🎳">”, or “<img class="emoji" src="//telegram.org/img/emoji/40/F09F8EB0.png" width="20" height="20" alt="🎰">”. Dice can have values 1-6 for “<img class="emoji" src="//telegram.org/img/emoji/40/F09F8EB2.png" width="20" height="20" alt="🎲">”, “<img class="emoji" src="//telegram.org/img/emoji/40/F09F8EAF.png" width="20" height="20" alt="🎯">” and “<img class="emoji" src="//telegram.org/img/emoji/40/F09F8EB3.png" width="20" height="20" alt="🎳">”, values 1-5 for “<img class="emoji" src="//telegram.org/img/emoji/40/F09F8F80.png" width="20" height="20" alt="🏀">” and “<img class="emoji" src="//telegram.org/img/emoji/40/E29ABD.png" width="20" height="20" alt="⚽">”, and values 1-64 for “<img class="emoji" src="//telegram.org/img/emoji/40/F09F8EB0.png" width="20" height="20" alt="🎰">”. Defaults to “<img class="emoji" src="//telegram.org/img/emoji/40/F09F8EB2.png" width="20" height="20" alt="🎲">”
 * @property disable_notification Sends the message <a href="https://telegram.org/blog/channels-2-0#silent-messages">silently</a>. Users will receive a notification with no sound.
 * @property protect_content Protects the contents of the sent message from forwarding
 * @property reply_to_message_id If the message is a reply, ID of the original message
 * @property allow_sending_without_reply Pass <em>True</em>, if the message should be sent even if the specified replied-to message is not found
 * @property reply_markup Additional interface options. A JSON-serialized object for an <a href="https://core.telegram.org/bots#inline-keyboards-and-on-the-fly-updating">inline keyboard</a>, <a href="https://core.telegram.org/bots#keyboards">custom reply keyboard</a>, instructions to remove reply keyboard or to force a reply from the user.
 * */
@Serializable
data class SendDiceRequest(
    val chat_id: String,
    val emoji: String? = null,
    val disable_notification: Boolean? = null,
    val protect_content: Boolean? = null,
    val reply_to_message_id: Long? = null,
    val allow_sending_without_reply: Boolean? = null,
    val reply_markup: @Contextual KeyboardOption? = null,
) : TelegramRequest() {
    override fun toJsonForRequest() = json.encodeToString(serializer(), this)
    override fun toJsonForResponse() = JsonObject(
        json.encodeToJsonElement(serializer(), this).jsonObject + ("method" to JsonPrimitive("sendDice"))
    ).toString()
    companion object {
        fun fromJson(string: String) = json.decodeFromString(serializer(), string)
    }
}

/**
 * <p>Use this method when you need to tell the user that something is happening on the bot's side. The status is set for 5 seconds or less (when a message arrives from your bot, Telegram clients clear its typing status). Returns <em>True</em> on success.</p><blockquote> 
 *  <p>Example: The <a href="https://t.me/imagebot">ImageBot</a> needs some time to process a request and upload the image. Instead of sending a text message along the lines of “Retrieving image, please wait…”, the bot may use <a href="#sendchataction">sendChatAction</a> with <em>action</em> = <em>upload_photo</em>. The user will see a “sending photo” status for the bot.</p> 
 * </blockquote><p>We only recommend using this method when a response from the bot will take a <strong>noticeable</strong> amount of time to arrive.</p>
 *
 * @property chat_id Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>)
 * @property action Type of action to broadcast. Choose one, depending on what the user is about to receive: <em>typing</em> for <a href="#sendmessage">text messages</a>, <em>upload_photo</em> for <a href="#sendphoto">photos</a>, <em>record_video</em> or <em>upload_video</em> for <a href="#sendvideo">videos</a>, <em>record_voice</em> or <em>upload_voice</em> for <a href="#sendvoice">voice notes</a>, <em>upload_document</em> for <a href="#senddocument">general files</a>, <em>choose_sticker</em> for <a href="#sendsticker">stickers</a>, <em>find_location</em> for <a href="#sendlocation">location data</a>, <em>record_video_note</em> or <em>upload_video_note</em> for <a href="#sendvideonote">video notes</a>.
 * */
@Serializable
data class SendChatActionRequest(
    val chat_id: String,
    val action: String,
) : TelegramRequest() {
    override fun toJsonForRequest() = json.encodeToString(serializer(), this)
    override fun toJsonForResponse() = JsonObject(
        json.encodeToJsonElement(serializer(), this).jsonObject + ("method" to JsonPrimitive("sendChatAction"))
    ).toString()
    companion object {
        fun fromJson(string: String) = json.decodeFromString(serializer(), string)
    }
}

/**
 * <p>Use this method to get a list of profile pictures for a user. Returns a <a href="#userprofilephotos">UserProfilePhotos</a> object.</p>
 *
 * @property user_id Unique identifier of the target user
 * @property offset Sequential number of the first photo to be returned. By default, all photos are returned.
 * @property limit Limits the number of photos to be retrieved. Values between 1-100 are accepted. Defaults to 100.
 * */
@Serializable
data class GetUserProfilePhotosRequest(
    val user_id: Long,
    val offset: Long? = null,
    val limit: Long? = null,
) : TelegramRequest() {
    override fun toJsonForRequest() = json.encodeToString(serializer(), this)
    override fun toJsonForResponse() = JsonObject(
        json.encodeToJsonElement(serializer(), this).jsonObject + ("method" to JsonPrimitive("getUserProfilePhotos"))
    ).toString()
    companion object {
        fun fromJson(string: String) = json.decodeFromString(serializer(), string)
    }
}

/**
 * <p>Use this method to get basic information about a file and prepare it for downloading. For the moment, bots can download files of up to 20MB in size. On success, a <a href="#file">File</a> object is returned. The file can then be downloaded via the link <code>https://api.telegram.org/file/bot&lt;token&gt;/&lt;file_path&gt;</code>, where <code>&lt;file_path&gt;</code> is taken from the response. It is guaranteed that the link will be valid for at least 1 hour. When the link expires, a new one can be requested by calling <a href="#getfile">getFile</a> again.</p><p><strong>Note:</strong> This function may not preserve the original file name and MIME type. You should save the file's MIME type and name (if available) when the File object is received.</p>
 *
 * @property file_id File identifier to get information about
 * */
@Serializable
data class GetFileRequest(
    val file_id: String,
) : TelegramRequest() {
    override fun toJsonForRequest() = json.encodeToString(serializer(), this)
    override fun toJsonForResponse() = JsonObject(
        json.encodeToJsonElement(serializer(), this).jsonObject + ("method" to JsonPrimitive("getFile"))
    ).toString()
    companion object {
        fun fromJson(string: String) = json.decodeFromString(serializer(), string)
    }
}

/**
 * <p>Use this method to ban a user in a group, a supergroup or a channel. In the case of supergroups and channels, the user will not be able to return to the chat on their own using invite links, etc., unless <a href="#unbanchatmember">unbanned</a> first. The bot must be an administrator in the chat for this to work and must have the appropriate administrator rights. Returns <em>True</em> on success.</p>
 *
 * @property chat_id Unique identifier for the target group or username of the target supergroup or channel (in the format <code>@channelusername</code>)
 * @property user_id Unique identifier of the target user
 * @property until_date Date when the user will be unbanned, unix time. If user is banned for more than 366 days or less than 30 seconds from the current time they are considered to be banned forever. Applied for supergroups and channels only.
 * @property revoke_messages Pass <em>True</em> to delete all messages from the chat for the user that is being removed. If <em>False</em>, the user will be able to see messages in the group that were sent before the user was removed. Always <em>True</em> for supergroups and channels.
 * */
@Serializable
data class BanChatMemberRequest(
    val chat_id: String,
    val user_id: Long,
    val until_date: Long? = null,
    val revoke_messages: Boolean? = null,
) : TelegramRequest() {
    override fun toJsonForRequest() = json.encodeToString(serializer(), this)
    override fun toJsonForResponse() = JsonObject(
        json.encodeToJsonElement(serializer(), this).jsonObject + ("method" to JsonPrimitive("banChatMember"))
    ).toString()
    companion object {
        fun fromJson(string: String) = json.decodeFromString(serializer(), string)
    }
}

/**
 * <p>Use this method to unban a previously banned user in a supergroup or channel. The user will <strong>not</strong> return to the group or channel automatically, but will be able to join via link, etc. The bot must be an administrator for this to work. By default, this method guarantees that after the call the user is not a member of the chat, but will be able to join it. So if the user is a member of the chat they will also be <strong>removed</strong> from the chat. If you don't want this, use the parameter <em>only_if_banned</em>. Returns <em>True</em> on success.</p>
 *
 * @property chat_id Unique identifier for the target group or username of the target supergroup or channel (in the format <code>@channelusername</code>)
 * @property user_id Unique identifier of the target user
 * @property only_if_banned Do nothing if the user is not banned
 * */
@Serializable
data class UnbanChatMemberRequest(
    val chat_id: String,
    val user_id: Long,
    val only_if_banned: Boolean? = null,
) : TelegramRequest() {
    override fun toJsonForRequest() = json.encodeToString(serializer(), this)
    override fun toJsonForResponse() = JsonObject(
        json.encodeToJsonElement(serializer(), this).jsonObject + ("method" to JsonPrimitive("unbanChatMember"))
    ).toString()
    companion object {
        fun fromJson(string: String) = json.decodeFromString(serializer(), string)
    }
}

/**
 * <p>Use this method to restrict a user in a supergroup. The bot must be an administrator in the supergroup for this to work and must have the appropriate administrator rights. Pass <em>True</em> for all permissions to lift restrictions from a user. Returns <em>True</em> on success.</p>
 *
 * @property chat_id Unique identifier for the target chat or username of the target supergroup (in the format <code>@supergroupusername</code>)
 * @property user_id Unique identifier of the target user
 * @property permissions A JSON-serialized object for new user permissions
 * @property until_date Date when restrictions will be lifted for the user, unix time. If user is restricted for more than 366 days or less than 30 seconds from the current time, they are considered to be restricted forever
 * */
@Serializable
data class RestrictChatMemberRequest(
    val chat_id: String,
    val user_id: Long,
    val permissions: ChatPermissions,
    val until_date: Long? = null,
) : TelegramRequest() {
    override fun toJsonForRequest() = json.encodeToString(serializer(), this)
    override fun toJsonForResponse() = JsonObject(
        json.encodeToJsonElement(serializer(), this).jsonObject + ("method" to JsonPrimitive("restrictChatMember"))
    ).toString()
    companion object {
        fun fromJson(string: String) = json.decodeFromString(serializer(), string)
    }
}

/**
 * <p>Use this method to promote or demote a user in a supergroup or a channel. The bot must be an administrator in the chat for this to work and must have the appropriate administrator rights. Pass <em>False</em> for all boolean parameters to demote a user. Returns <em>True</em> on success.</p>
 *
 * @property chat_id Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>)
 * @property user_id Unique identifier of the target user
 * @property is_anonymous Pass <em>True</em>, if the administrator's presence in the chat is hidden
 * @property can_manage_chat Pass <em>True</em>, if the administrator can access the chat event log, chat statistics, message statistics in channels, see channel members, see anonymous administrators in supergroups and ignore slow mode. Implied by any other administrator privilege
 * @property can_post_messages Pass <em>True</em>, if the administrator can create channel posts, channels only
 * @property can_edit_messages Pass <em>True</em>, if the administrator can edit messages of other users and can pin messages, channels only
 * @property can_delete_messages Pass <em>True</em>, if the administrator can delete messages of other users
 * @property can_manage_video_chats Pass <em>True</em>, if the administrator can manage video chats
 * @property can_restrict_members Pass <em>True</em>, if the administrator can restrict, ban or unban chat members
 * @property can_promote_members Pass <em>True</em>, if the administrator can add new administrators with a subset of their own privileges or demote administrators that he has promoted, directly or indirectly (promoted by administrators that were appointed by him)
 * @property can_change_info Pass <em>True</em>, if the administrator can change chat title, photo and other settings
 * @property can_invite_users Pass <em>True</em>, if the administrator can invite new users to the chat
 * @property can_pin_messages Pass <em>True</em>, if the administrator can pin messages, supergroups only
 * */
@Serializable
data class PromoteChatMemberRequest(
    val chat_id: String,
    val user_id: Long,
    val is_anonymous: Boolean? = null,
    val can_manage_chat: Boolean? = null,
    val can_post_messages: Boolean? = null,
    val can_edit_messages: Boolean? = null,
    val can_delete_messages: Boolean? = null,
    val can_manage_video_chats: Boolean? = null,
    val can_restrict_members: Boolean? = null,
    val can_promote_members: Boolean? = null,
    val can_change_info: Boolean? = null,
    val can_invite_users: Boolean? = null,
    val can_pin_messages: Boolean? = null,
) : TelegramRequest() {
    override fun toJsonForRequest() = json.encodeToString(serializer(), this)
    override fun toJsonForResponse() = JsonObject(
        json.encodeToJsonElement(serializer(), this).jsonObject + ("method" to JsonPrimitive("promoteChatMember"))
    ).toString()
    companion object {
        fun fromJson(string: String) = json.decodeFromString(serializer(), string)
    }
}

/**
 * <p>Use this method to set a custom title for an administrator in a supergroup promoted by the bot. Returns <em>True</em> on success.</p>
 *
 * @property chat_id Unique identifier for the target chat or username of the target supergroup (in the format <code>@supergroupusername</code>)
 * @property user_id Unique identifier of the target user
 * @property custom_title New custom title for the administrator; 0-16 characters, emoji are not allowed
 * */
@Serializable
data class SetChatAdministratorCustomTitleRequest(
    val chat_id: String,
    val user_id: Long,
    val custom_title: String,
) : TelegramRequest() {
    override fun toJsonForRequest() = json.encodeToString(serializer(), this)
    override fun toJsonForResponse() = JsonObject(
        json.encodeToJsonElement(serializer(), this).jsonObject + ("method" to JsonPrimitive("setChatAdministratorCustomTitle"))
    ).toString()
    companion object {
        fun fromJson(string: String) = json.decodeFromString(serializer(), string)
    }
}

/**
 * <p>Use this method to ban a channel chat in a supergroup or a channel. Until the chat is <a href="#unbanchatsenderchat">unbanned</a>, the owner of the banned chat won't be able to send messages on behalf of <strong>any of their channels</strong>. The bot must be an administrator in the supergroup or channel for this to work and must have the appropriate administrator rights. Returns <em>True</em> on success.</p>
 *
 * @property chat_id Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>)
 * @property sender_chat_id Unique identifier of the target sender chat
 * */
@Serializable
data class BanChatSenderChatRequest(
    val chat_id: String,
    val sender_chat_id: Long,
) : TelegramRequest() {
    override fun toJsonForRequest() = json.encodeToString(serializer(), this)
    override fun toJsonForResponse() = JsonObject(
        json.encodeToJsonElement(serializer(), this).jsonObject + ("method" to JsonPrimitive("banChatSenderChat"))
    ).toString()
    companion object {
        fun fromJson(string: String) = json.decodeFromString(serializer(), string)
    }
}

/**
 * <p>Use this method to unban a previously banned channel chat in a supergroup or channel. The bot must be an administrator for this to work and must have the appropriate administrator rights. Returns <em>True</em> on success.</p>
 *
 * @property chat_id Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>)
 * @property sender_chat_id Unique identifier of the target sender chat
 * */
@Serializable
data class UnbanChatSenderChatRequest(
    val chat_id: String,
    val sender_chat_id: Long,
) : TelegramRequest() {
    override fun toJsonForRequest() = json.encodeToString(serializer(), this)
    override fun toJsonForResponse() = JsonObject(
        json.encodeToJsonElement(serializer(), this).jsonObject + ("method" to JsonPrimitive("unbanChatSenderChat"))
    ).toString()
    companion object {
        fun fromJson(string: String) = json.decodeFromString(serializer(), string)
    }
}

/**
 * <p>Use this method to set default chat permissions for all members. The bot must be an administrator in the group or a supergroup for this to work and must have the <em>can_restrict_members</em> administrator rights. Returns <em>True</em> on success.</p>
 *
 * @property chat_id Unique identifier for the target chat or username of the target supergroup (in the format <code>@supergroupusername</code>)
 * @property permissions A JSON-serialized object for new default chat permissions
 * */
@Serializable
data class SetChatPermissionsRequest(
    val chat_id: String,
    val permissions: ChatPermissions,
) : TelegramRequest() {
    override fun toJsonForRequest() = json.encodeToString(serializer(), this)
    override fun toJsonForResponse() = JsonObject(
        json.encodeToJsonElement(serializer(), this).jsonObject + ("method" to JsonPrimitive("setChatPermissions"))
    ).toString()
    companion object {
        fun fromJson(string: String) = json.decodeFromString(serializer(), string)
    }
}

/**
 * <p>Use this method to generate a new primary invite link for a chat; any previously generated primary link is revoked. The bot must be an administrator in the chat for this to work and must have the appropriate administrator rights. Returns the new invite link as <em>String</em> on success.</p><blockquote> 
 *  <p>Note: Each administrator in a chat generates their own invite links. Bots can't use invite links generated by other administrators. If you want your bot to work with invite links, it will need to generate its own link using <a href="#exportchatinvitelink">exportChatInviteLink</a> or by calling the <a href="#getchat">getChat</a> method. If your bot needs to generate a new primary invite link replacing its previous one, use <a href="#exportchatinvitelink">exportChatInviteLink</a> again.</p> 
 * </blockquote>
 *
 * @property chat_id Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>)
 * */
@Serializable
data class ExportChatInviteLinkRequest(
    val chat_id: String,
) : TelegramRequest() {
    override fun toJsonForRequest() = json.encodeToString(serializer(), this)
    override fun toJsonForResponse() = JsonObject(
        json.encodeToJsonElement(serializer(), this).jsonObject + ("method" to JsonPrimitive("exportChatInviteLink"))
    ).toString()
    companion object {
        fun fromJson(string: String) = json.decodeFromString(serializer(), string)
    }
}

/**
 * <p>Use this method to create an additional invite link for a chat. The bot must be an administrator in the chat for this to work and must have the appropriate administrator rights. The link can be revoked using the method <a href="#revokechatinvitelink">revokeChatInviteLink</a>. Returns the new invite link as <a href="#chatinvitelink">ChatInviteLink</a> object.</p>
 *
 * @property chat_id Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>)
 * @property name Invite link name; 0-32 characters
 * @property expire_date Point in time (Unix timestamp) when the link will expire
 * @property member_limit The maximum number of users that can be members of the chat simultaneously after joining the chat via this invite link; 1-99999
 * @property creates_join_request <em>True</em>, if users joining the chat via the link need to be approved by chat administrators. If <em>True</em>, <em>member_limit</em> can't be specified
 * */
@Serializable
data class CreateChatInviteLinkRequest(
    val chat_id: String,
    val name: String? = null,
    val expire_date: Long? = null,
    val member_limit: Long? = null,
    val creates_join_request: Boolean? = null,
) : TelegramRequest() {
    override fun toJsonForRequest() = json.encodeToString(serializer(), this)
    override fun toJsonForResponse() = JsonObject(
        json.encodeToJsonElement(serializer(), this).jsonObject + ("method" to JsonPrimitive("createChatInviteLink"))
    ).toString()
    companion object {
        fun fromJson(string: String) = json.decodeFromString(serializer(), string)
    }
}

/**
 * <p>Use this method to edit a non-primary invite link created by the bot. The bot must be an administrator in the chat for this to work and must have the appropriate administrator rights. Returns the edited invite link as a <a href="#chatinvitelink">ChatInviteLink</a> object.</p>
 *
 * @property chat_id Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>)
 * @property invite_link The invite link to edit
 * @property name Invite link name; 0-32 characters
 * @property expire_date Point in time (Unix timestamp) when the link will expire
 * @property member_limit The maximum number of users that can be members of the chat simultaneously after joining the chat via this invite link; 1-99999
 * @property creates_join_request <em>True</em>, if users joining the chat via the link need to be approved by chat administrators. If <em>True</em>, <em>member_limit</em> can't be specified
 * */
@Serializable
data class EditChatInviteLinkRequest(
    val chat_id: String,
    val invite_link: String,
    val name: String? = null,
    val expire_date: Long? = null,
    val member_limit: Long? = null,
    val creates_join_request: Boolean? = null,
) : TelegramRequest() {
    override fun toJsonForRequest() = json.encodeToString(serializer(), this)
    override fun toJsonForResponse() = JsonObject(
        json.encodeToJsonElement(serializer(), this).jsonObject + ("method" to JsonPrimitive("editChatInviteLink"))
    ).toString()
    companion object {
        fun fromJson(string: String) = json.decodeFromString(serializer(), string)
    }
}

/**
 * <p>Use this method to revoke an invite link created by the bot. If the primary link is revoked, a new link is automatically generated. The bot must be an administrator in the chat for this to work and must have the appropriate administrator rights. Returns the revoked invite link as <a href="#chatinvitelink">ChatInviteLink</a> object.</p>
 *
 * @property chat_id Unique identifier of the target chat or username of the target channel (in the format <code>@channelusername</code>)
 * @property invite_link The invite link to revoke
 * */
@Serializable
data class RevokeChatInviteLinkRequest(
    val chat_id: String,
    val invite_link: String,
) : TelegramRequest() {
    override fun toJsonForRequest() = json.encodeToString(serializer(), this)
    override fun toJsonForResponse() = JsonObject(
        json.encodeToJsonElement(serializer(), this).jsonObject + ("method" to JsonPrimitive("revokeChatInviteLink"))
    ).toString()
    companion object {
        fun fromJson(string: String) = json.decodeFromString(serializer(), string)
    }
}

/**
 * <p>Use this method to approve a chat join request. The bot must be an administrator in the chat for this to work and must have the <em>can_invite_users</em> administrator right. Returns <em>True</em> on success.</p>
 *
 * @property chat_id Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>)
 * @property user_id Unique identifier of the target user
 * */
@Serializable
data class ApproveChatJoinRequestRequest(
    val chat_id: String,
    val user_id: Long,
) : TelegramRequest() {
    override fun toJsonForRequest() = json.encodeToString(serializer(), this)
    override fun toJsonForResponse() = JsonObject(
        json.encodeToJsonElement(serializer(), this).jsonObject + ("method" to JsonPrimitive("approveChatJoinRequest"))
    ).toString()
    companion object {
        fun fromJson(string: String) = json.decodeFromString(serializer(), string)
    }
}

/**
 * <p>Use this method to decline a chat join request. The bot must be an administrator in the chat for this to work and must have the <em>can_invite_users</em> administrator right. Returns <em>True</em> on success.</p>
 *
 * @property chat_id Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>)
 * @property user_id Unique identifier of the target user
 * */
@Serializable
data class DeclineChatJoinRequestRequest(
    val chat_id: String,
    val user_id: Long,
) : TelegramRequest() {
    override fun toJsonForRequest() = json.encodeToString(serializer(), this)
    override fun toJsonForResponse() = JsonObject(
        json.encodeToJsonElement(serializer(), this).jsonObject + ("method" to JsonPrimitive("declineChatJoinRequest"))
    ).toString()
    companion object {
        fun fromJson(string: String) = json.decodeFromString(serializer(), string)
    }
}

/**
 * <p>Use this method to set a new profile photo for the chat. Photos can't be changed for private chats. The bot must be an administrator in the chat for this to work and must have the appropriate administrator rights. Returns <em>True</em> on success.</p>
 *
 * @property chat_id Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>)
 * @property photo New chat photo, uploaded using multipart/form-data
 * */
@Serializable
data class SetChatPhotoRequest(
    val chat_id: String,
    val photo: @Contextual Any,
) : TelegramRequest() {
    override fun toJsonForRequest() = json.encodeToString(serializer(), this)
    override fun toJsonForResponse() = JsonObject(
        json.encodeToJsonElement(serializer(), this).jsonObject + ("method" to JsonPrimitive("setChatPhoto"))
    ).toString()
    companion object {
        fun fromJson(string: String) = json.decodeFromString(serializer(), string)
    }
}

/**
 * <p>Use this method to delete a chat photo. Photos can't be changed for private chats. The bot must be an administrator in the chat for this to work and must have the appropriate administrator rights. Returns <em>True</em> on success.</p>
 *
 * @property chat_id Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>)
 * */
@Serializable
data class DeleteChatPhotoRequest(
    val chat_id: String,
) : TelegramRequest() {
    override fun toJsonForRequest() = json.encodeToString(serializer(), this)
    override fun toJsonForResponse() = JsonObject(
        json.encodeToJsonElement(serializer(), this).jsonObject + ("method" to JsonPrimitive("deleteChatPhoto"))
    ).toString()
    companion object {
        fun fromJson(string: String) = json.decodeFromString(serializer(), string)
    }
}

/**
 * <p>Use this method to change the title of a chat. Titles can't be changed for private chats. The bot must be an administrator in the chat for this to work and must have the appropriate administrator rights. Returns <em>True</em> on success.</p>
 *
 * @property chat_id Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>)
 * @property title New chat title, 1-255 characters
 * */
@Serializable
data class SetChatTitleRequest(
    val chat_id: String,
    val title: String,
) : TelegramRequest() {
    override fun toJsonForRequest() = json.encodeToString(serializer(), this)
    override fun toJsonForResponse() = JsonObject(
        json.encodeToJsonElement(serializer(), this).jsonObject + ("method" to JsonPrimitive("setChatTitle"))
    ).toString()
    companion object {
        fun fromJson(string: String) = json.decodeFromString(serializer(), string)
    }
}

/**
 * <p>Use this method to change the description of a group, a supergroup or a channel. The bot must be an administrator in the chat for this to work and must have the appropriate administrator rights. Returns <em>True</em> on success.</p>
 *
 * @property chat_id Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>)
 * @property description New chat description, 0-255 characters
 * */
@Serializable
data class SetChatDescriptionRequest(
    val chat_id: String,
    val description: String? = null,
) : TelegramRequest() {
    override fun toJsonForRequest() = json.encodeToString(serializer(), this)
    override fun toJsonForResponse() = JsonObject(
        json.encodeToJsonElement(serializer(), this).jsonObject + ("method" to JsonPrimitive("setChatDescription"))
    ).toString()
    companion object {
        fun fromJson(string: String) = json.decodeFromString(serializer(), string)
    }
}

/**
 * <p>Use this method to add a message to the list of pinned messages in a chat. If the chat is not a private chat, the bot must be an administrator in the chat for this to work and must have the 'can_pin_messages' administrator right in a supergroup or 'can_edit_messages' administrator right in a channel. Returns <em>True</em> on success.</p>
 *
 * @property chat_id Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>)
 * @property message_id Identifier of a message to pin
 * @property disable_notification Pass <em>True</em>, if it is not necessary to send a notification to all chat members about the new pinned message. Notifications are always disabled in channels and private chats.
 * */
@Serializable
data class PinChatMessageRequest(
    val chat_id: String,
    val message_id: Long,
    val disable_notification: Boolean? = null,
) : TelegramRequest() {
    override fun toJsonForRequest() = json.encodeToString(serializer(), this)
    override fun toJsonForResponse() = JsonObject(
        json.encodeToJsonElement(serializer(), this).jsonObject + ("method" to JsonPrimitive("pinChatMessage"))
    ).toString()
    companion object {
        fun fromJson(string: String) = json.decodeFromString(serializer(), string)
    }
}

/**
 * <p>Use this method to remove a message from the list of pinned messages in a chat. If the chat is not a private chat, the bot must be an administrator in the chat for this to work and must have the 'can_pin_messages' administrator right in a supergroup or 'can_edit_messages' administrator right in a channel. Returns <em>True</em> on success.</p>
 *
 * @property chat_id Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>)
 * @property message_id Identifier of a message to unpin. If not specified, the most recent pinned message (by sending date) will be unpinned.
 * */
@Serializable
data class UnpinChatMessageRequest(
    val chat_id: String,
    val message_id: Long? = null,
) : TelegramRequest() {
    override fun toJsonForRequest() = json.encodeToString(serializer(), this)
    override fun toJsonForResponse() = JsonObject(
        json.encodeToJsonElement(serializer(), this).jsonObject + ("method" to JsonPrimitive("unpinChatMessage"))
    ).toString()
    companion object {
        fun fromJson(string: String) = json.decodeFromString(serializer(), string)
    }
}

/**
 * <p>Use this method to clear the list of pinned messages in a chat. If the chat is not a private chat, the bot must be an administrator in the chat for this to work and must have the 'can_pin_messages' administrator right in a supergroup or 'can_edit_messages' administrator right in a channel. Returns <em>True</em> on success.</p>
 *
 * @property chat_id Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>)
 * */
@Serializable
data class UnpinAllChatMessagesRequest(
    val chat_id: String,
) : TelegramRequest() {
    override fun toJsonForRequest() = json.encodeToString(serializer(), this)
    override fun toJsonForResponse() = JsonObject(
        json.encodeToJsonElement(serializer(), this).jsonObject + ("method" to JsonPrimitive("unpinAllChatMessages"))
    ).toString()
    companion object {
        fun fromJson(string: String) = json.decodeFromString(serializer(), string)
    }
}

/**
 * <p>Use this method for your bot to leave a group, supergroup or channel. Returns <em>True</em> on success.</p>
 *
 * @property chat_id Unique identifier for the target chat or username of the target supergroup or channel (in the format <code>@channelusername</code>)
 * */
@Serializable
data class LeaveChatRequest(
    val chat_id: String,
) : TelegramRequest() {
    override fun toJsonForRequest() = json.encodeToString(serializer(), this)
    override fun toJsonForResponse() = JsonObject(
        json.encodeToJsonElement(serializer(), this).jsonObject + ("method" to JsonPrimitive("leaveChat"))
    ).toString()
    companion object {
        fun fromJson(string: String) = json.decodeFromString(serializer(), string)
    }
}

/**
 * <p>Use this method to get up to date information about the chat (current name of the user for one-on-one conversations, current username of a user, group or channel, etc.). Returns a <a href="#chat">Chat</a> object on success.</p>
 *
 * @property chat_id Unique identifier for the target chat or username of the target supergroup or channel (in the format <code>@channelusername</code>)
 * */
@Serializable
data class GetChatRequest(
    val chat_id: String,
) : TelegramRequest() {
    override fun toJsonForRequest() = json.encodeToString(serializer(), this)
    override fun toJsonForResponse() = JsonObject(
        json.encodeToJsonElement(serializer(), this).jsonObject + ("method" to JsonPrimitive("getChat"))
    ).toString()
    companion object {
        fun fromJson(string: String) = json.decodeFromString(serializer(), string)
    }
}

/**
 * <p>Use this method to get a list of administrators in a chat. On success, returns an Array of <a href="#chatmember">ChatMember</a> objects that contains information about all chat administrators except other bots. If the chat is a group or a supergroup and no administrators were appointed, only the creator will be returned.</p>
 *
 * @property chat_id Unique identifier for the target chat or username of the target supergroup or channel (in the format <code>@channelusername</code>)
 * */
@Serializable
data class GetChatAdministratorsRequest(
    val chat_id: String,
) : TelegramRequest() {
    override fun toJsonForRequest() = json.encodeToString(serializer(), this)
    override fun toJsonForResponse() = JsonObject(
        json.encodeToJsonElement(serializer(), this).jsonObject + ("method" to JsonPrimitive("getChatAdministrators"))
    ).toString()
    companion object {
        fun fromJson(string: String) = json.decodeFromString(serializer(), string)
    }
}

/**
 * <p>Use this method to get the number of members in a chat. Returns <em>Int</em> on success.</p>
 *
 * @property chat_id Unique identifier for the target chat or username of the target supergroup or channel (in the format <code>@channelusername</code>)
 * */
@Serializable
data class GetChatMemberCountRequest(
    val chat_id: String,
) : TelegramRequest() {
    override fun toJsonForRequest() = json.encodeToString(serializer(), this)
    override fun toJsonForResponse() = JsonObject(
        json.encodeToJsonElement(serializer(), this).jsonObject + ("method" to JsonPrimitive("getChatMemberCount"))
    ).toString()
    companion object {
        fun fromJson(string: String) = json.decodeFromString(serializer(), string)
    }
}

/**
 * <p>Use this method to get information about a member of a chat. Returns a <a href="#chatmember">ChatMember</a> object on success.</p>
 *
 * @property chat_id Unique identifier for the target chat or username of the target supergroup or channel (in the format <code>@channelusername</code>)
 * @property user_id Unique identifier of the target user
 * */
@Serializable
data class GetChatMemberRequest(
    val chat_id: String,
    val user_id: Long,
) : TelegramRequest() {
    override fun toJsonForRequest() = json.encodeToString(serializer(), this)
    override fun toJsonForResponse() = JsonObject(
        json.encodeToJsonElement(serializer(), this).jsonObject + ("method" to JsonPrimitive("getChatMember"))
    ).toString()
    companion object {
        fun fromJson(string: String) = json.decodeFromString(serializer(), string)
    }
}

/**
 * <p>Use this method to set a new group sticker set for a supergroup. The bot must be an administrator in the chat for this to work and must have the appropriate administrator rights. Use the field <em>can_set_sticker_set</em> optionally returned in <a href="#getchat">getChat</a> requests to check if the bot can use this method. Returns <em>True</em> on success.</p>
 *
 * @property chat_id Unique identifier for the target chat or username of the target supergroup (in the format <code>@supergroupusername</code>)
 * @property sticker_set_name Name of the sticker set to be set as the group sticker set
 * */
@Serializable
data class SetChatStickerSetRequest(
    val chat_id: String,
    val sticker_set_name: String,
) : TelegramRequest() {
    override fun toJsonForRequest() = json.encodeToString(serializer(), this)
    override fun toJsonForResponse() = JsonObject(
        json.encodeToJsonElement(serializer(), this).jsonObject + ("method" to JsonPrimitive("setChatStickerSet"))
    ).toString()
    companion object {
        fun fromJson(string: String) = json.decodeFromString(serializer(), string)
    }
}

/**
 * <p>Use this method to delete a group sticker set from a supergroup. The bot must be an administrator in the chat for this to work and must have the appropriate administrator rights. Use the field <em>can_set_sticker_set</em> optionally returned in <a href="#getchat">getChat</a> requests to check if the bot can use this method. Returns <em>True</em> on success.</p>
 *
 * @property chat_id Unique identifier for the target chat or username of the target supergroup (in the format <code>@supergroupusername</code>)
 * */
@Serializable
data class DeleteChatStickerSetRequest(
    val chat_id: String,
) : TelegramRequest() {
    override fun toJsonForRequest() = json.encodeToString(serializer(), this)
    override fun toJsonForResponse() = JsonObject(
        json.encodeToJsonElement(serializer(), this).jsonObject + ("method" to JsonPrimitive("deleteChatStickerSet"))
    ).toString()
    companion object {
        fun fromJson(string: String) = json.decodeFromString(serializer(), string)
    }
}

/**
 * <p>Use this method to send answers to callback queries sent from <a href="/bots#inline-keyboards-and-on-the-fly-updating">inline keyboards</a>. The answer will be displayed to the user as a notification at the top of the chat screen or as an alert. On success, <em>True</em> is returned.</p><blockquote> 
 *  <p>Alternatively, the user can be redirected to the specified Game URL. For this option to work, you must first create a game for your bot via <a href="https://t.me/botfather">@BotFather</a> and accept the terms. Otherwise, you may use links like <code>t.me/your_bot?start=XXXX</code> that open your bot with a parameter.</p> 
 * </blockquote>
 *
 * @property callback_query_id Unique identifier for the query to be answered
 * @property text Text of the notification. If not specified, nothing will be shown to the user, 0-200 characters
 * @property show_alert If <em>True</em>, an alert will be shown by the client instead of a notification at the top of the chat screen. Defaults to <em>false</em>.
 * @property url URL that will be opened by the user's client. If you have created a <a href="#game">Game</a> and accepted the conditions via <a href="https://t.me/botfather">@BotFather</a>, specify the URL that opens your game - note that this will only work if the query comes from a <a href="#inlinekeyboardbutton"><em>callback_game</em></a> button.<br><br>Otherwise, you may use links like <code>t.me/your_bot?start=XXXX</code> that open your bot with a parameter.
 * @property cache_time The maximum amount of time in seconds that the result of the callback query may be cached client-side. Telegram apps will support caching starting in version 3.14. Defaults to 0.
 * */
@Serializable
data class AnswerCallbackQueryRequest(
    val callback_query_id: String,
    val text: String? = null,
    val show_alert: Boolean? = null,
    val url: String? = null,
    val cache_time: Long? = null,
) : TelegramRequest() {
    override fun toJsonForRequest() = json.encodeToString(serializer(), this)
    override fun toJsonForResponse() = JsonObject(
        json.encodeToJsonElement(serializer(), this).jsonObject + ("method" to JsonPrimitive("answerCallbackQuery"))
    ).toString()
    companion object {
        fun fromJson(string: String) = json.decodeFromString(serializer(), string)
    }
}

/**
 * <p>Use this method to change the list of the bot's commands. See <a href="https://core.telegram.org/bots#commands"></a><a href="https://core.telegram.org/bots#commands">https://core.telegram.org/bots#commands</a> for more details about bot commands. Returns <em>True</em> on success.</p>
 *
 * @property commands A JSON-serialized list of bot commands to be set as the list of the bot's commands. At most 100 commands can be specified.
 * @property scope A JSON-serialized object, describing scope of users for which the commands are relevant. Defaults to <a href="#botcommandscopedefault">BotCommandScopeDefault</a>.
 * @property language_code A two-letter ISO 639-1 language code. If empty, commands will be applied to all users from the given scope, for whose language there are no dedicated commands
 * */
@Serializable
data class SetMyCommandsRequest(
    val commands: List<BotCommand>,
    val scope: @Contextual BotCommandScope? = null,
    val language_code: String? = null,
) : TelegramRequest() {
    override fun toJsonForRequest() = json.encodeToString(serializer(), this)
    override fun toJsonForResponse() = JsonObject(
        json.encodeToJsonElement(serializer(), this).jsonObject + ("method" to JsonPrimitive("setMyCommands"))
    ).toString()
    companion object {
        fun fromJson(string: String) = json.decodeFromString(serializer(), string)
    }
}

/**
 * <p>Use this method to delete the list of the bot's commands for the given scope and user language. After deletion, <a href="#determining-list-of-commands">higher level commands</a> will be shown to affected users. Returns <em>True</em> on success.</p>
 *
 * @property scope A JSON-serialized object, describing scope of users for which the commands are relevant. Defaults to <a href="#botcommandscopedefault">BotCommandScopeDefault</a>.
 * @property language_code A two-letter ISO 639-1 language code. If empty, commands will be applied to all users from the given scope, for whose language there are no dedicated commands
 * */
@Serializable
data class DeleteMyCommandsRequest(
    val scope: @Contextual BotCommandScope? = null,
    val language_code: String? = null,
) : TelegramRequest() {
    override fun toJsonForRequest() = json.encodeToString(serializer(), this)
    override fun toJsonForResponse() = JsonObject(
        json.encodeToJsonElement(serializer(), this).jsonObject + ("method" to JsonPrimitive("deleteMyCommands"))
    ).toString()
    companion object {
        fun fromJson(string: String) = json.decodeFromString(serializer(), string)
    }
}

/**
 * <p>Use this method to get the current list of the bot's commands for the given scope and user language. Returns Array of <a href="#botcommand">BotCommand</a> on success. If commands aren't set, an empty list is returned.</p>
 *
 * @property scope A JSON-serialized object, describing scope of users. Defaults to <a href="#botcommandscopedefault">BotCommandScopeDefault</a>.
 * @property language_code A two-letter ISO 639-1 language code or an empty string
 * */
@Serializable
data class GetMyCommandsRequest(
    val scope: @Contextual BotCommandScope? = null,
    val language_code: String? = null,
) : TelegramRequest() {
    override fun toJsonForRequest() = json.encodeToString(serializer(), this)
    override fun toJsonForResponse() = JsonObject(
        json.encodeToJsonElement(serializer(), this).jsonObject + ("method" to JsonPrimitive("getMyCommands"))
    ).toString()
    companion object {
        fun fromJson(string: String) = json.decodeFromString(serializer(), string)
    }
}

/**
 * <p>Use this method to change the bot's menu button in a private chat, or the default menu button. Returns <em>True</em> on success.</p>
 *
 * @property chat_id Unique identifier for the target private chat. If not specified, default bot's menu button will be changed
 * @property menu_button A JSON-serialized object for the bot's new menu button. Defaults to <a href="#menubuttondefault">MenuButtonDefault</a>
 * */
@Serializable
data class SetChatMenuButtonRequest(
    val chat_id: Long? = null,
    val menu_button: @Contextual MenuButton? = null,
) : TelegramRequest() {
    override fun toJsonForRequest() = json.encodeToString(serializer(), this)
    override fun toJsonForResponse() = JsonObject(
        json.encodeToJsonElement(serializer(), this).jsonObject + ("method" to JsonPrimitive("setChatMenuButton"))
    ).toString()
    companion object {
        fun fromJson(string: String) = json.decodeFromString(serializer(), string)
    }
}

/**
 * <p>Use this method to get the current value of the bot's menu button in a private chat, or the default menu button. Returns <a href="#menubutton">MenuButton</a> on success.</p>
 *
 * @property chat_id Unique identifier for the target private chat. If not specified, default bot's menu button will be returned
 * */
@Serializable
data class GetChatMenuButtonRequest(
    val chat_id: Long? = null,
) : TelegramRequest() {
    override fun toJsonForRequest() = json.encodeToString(serializer(), this)
    override fun toJsonForResponse() = JsonObject(
        json.encodeToJsonElement(serializer(), this).jsonObject + ("method" to JsonPrimitive("getChatMenuButton"))
    ).toString()
    companion object {
        fun fromJson(string: String) = json.decodeFromString(serializer(), string)
    }
}

/**
 * <p>Use this method to change the default administrator rights requested by the bot when it's added as an administrator to groups or channels. These rights will be suggested to users, but they are are free to modify the list before adding the bot. Returns <em>True</em> on success.</p>
 *
 * @property rights A JSON-serialized object describing new default administrator rights. If not specified, the default administrator rights will be cleared.
 * @property for_channels Pass <em>True</em> to change the default administrator rights of the bot in channels. Otherwise, the default administrator rights of the bot for groups and supergroups will be changed.
 * */
@Serializable
data class SetMyDefaultAdministratorRightsRequest(
    val rights: ChatAdministratorRights? = null,
    val for_channels: Boolean? = null,
) : TelegramRequest() {
    override fun toJsonForRequest() = json.encodeToString(serializer(), this)
    override fun toJsonForResponse() = JsonObject(
        json.encodeToJsonElement(serializer(), this).jsonObject + ("method" to JsonPrimitive("setMyDefaultAdministratorRights"))
    ).toString()
    companion object {
        fun fromJson(string: String) = json.decodeFromString(serializer(), string)
    }
}

/**
 * <p>Use this method to get the current default administrator rights of the bot. Returns <a href="#chatadministratorrights">ChatAdministratorRights</a> on success.</p>
 *
 * @property for_channels Pass <em>True</em> to get default administrator rights of the bot in channels. Otherwise, default administrator rights of the bot for groups and supergroups will be returned.
 * */
@Serializable
data class GetMyDefaultAdministratorRightsRequest(
    val for_channels: Boolean? = null,
) : TelegramRequest() {
    override fun toJsonForRequest() = json.encodeToString(serializer(), this)
    override fun toJsonForResponse() = JsonObject(
        json.encodeToJsonElement(serializer(), this).jsonObject + ("method" to JsonPrimitive("getMyDefaultAdministratorRights"))
    ).toString()
    companion object {
        fun fromJson(string: String) = json.decodeFromString(serializer(), string)
    }
}


// Updating messages

/**
 * <p>Use this method to edit text and <a href="#games">game</a> messages. On success, if the edited message is not an inline message, the edited <a href="#message">Message</a> is returned, otherwise <em>True</em> is returned.</p>
 *
 * @property chat_id Required if <em>inline_message_id</em> is not specified. Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>)
 * @property message_id Required if <em>inline_message_id</em> is not specified. Identifier of the message to edit
 * @property inline_message_id Required if <em>chat_id</em> and <em>message_id</em> are not specified. Identifier of the inline message
 * @property text New text of the message, 1-4096 characters after entities parsing
 * @property parse_mode Mode for parsing entities in the message text. See <a href="#formatting-options">formatting options</a> for more details.
 * @property entities A JSON-serialized list of special entities that appear in message text, which can be specified instead of <em>parse_mode</em>
 * @property disable_web_page_preview Disables link previews for links in this message
 * @property reply_markup A JSON-serialized object for an <a href="https://core.telegram.org/bots#inline-keyboards-and-on-the-fly-updating">inline keyboard</a>.
 * */
@Serializable
data class EditMessageTextRequest(
    val chat_id: String? = null,
    val message_id: Long? = null,
    val inline_message_id: String? = null,
    val text: String,
    val parse_mode: ParseMode? = null,
    val entities: List<MessageEntity>? = null,
    val disable_web_page_preview: Boolean? = null,
    val reply_markup: InlineKeyboardMarkup? = null,
) : TelegramRequest() {
    override fun toJsonForRequest() = json.encodeToString(serializer(), this)
    override fun toJsonForResponse() = JsonObject(
        json.encodeToJsonElement(serializer(), this).jsonObject + ("method" to JsonPrimitive("editMessageText"))
    ).toString()
    companion object {
        fun fromJson(string: String) = json.decodeFromString(serializer(), string)
    }
}

/**
 * <p>Use this method to edit captions of messages. On success, if the edited message is not an inline message, the edited <a href="#message">Message</a> is returned, otherwise <em>True</em> is returned.</p>
 *
 * @property chat_id Required if <em>inline_message_id</em> is not specified. Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>)
 * @property message_id Required if <em>inline_message_id</em> is not specified. Identifier of the message to edit
 * @property inline_message_id Required if <em>chat_id</em> and <em>message_id</em> are not specified. Identifier of the inline message
 * @property caption New caption of the message, 0-1024 characters after entities parsing
 * @property parse_mode Mode for parsing entities in the message caption. See <a href="#formatting-options">formatting options</a> for more details.
 * @property caption_entities A JSON-serialized list of special entities that appear in the caption, which can be specified instead of <em>parse_mode</em>
 * @property reply_markup A JSON-serialized object for an <a href="https://core.telegram.org/bots#inline-keyboards-and-on-the-fly-updating">inline keyboard</a>.
 * */
@Serializable
data class EditMessageCaptionRequest(
    val chat_id: String? = null,
    val message_id: Long? = null,
    val inline_message_id: String? = null,
    val caption: String? = null,
    val parse_mode: ParseMode? = null,
    val caption_entities: List<MessageEntity>? = null,
    val reply_markup: InlineKeyboardMarkup? = null,
) : TelegramRequest() {
    override fun toJsonForRequest() = json.encodeToString(serializer(), this)
    override fun toJsonForResponse() = JsonObject(
        json.encodeToJsonElement(serializer(), this).jsonObject + ("method" to JsonPrimitive("editMessageCaption"))
    ).toString()
    companion object {
        fun fromJson(string: String) = json.decodeFromString(serializer(), string)
    }
}

/**
 * <p>Use this method to edit animation, audio, document, photo, or video messages. If a message is part of a message album, then it can be edited only to an audio for audio albums, only to a document for document albums and to a photo or a video otherwise. When an inline message is edited, a new file can't be uploaded; use a previously uploaded file via its file_id or specify a URL. On success, if the edited message is not an inline message, the edited <a href="#message">Message</a> is returned, otherwise <em>True</em> is returned.</p>
 *
 * @property chat_id Required if <em>inline_message_id</em> is not specified. Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>)
 * @property message_id Required if <em>inline_message_id</em> is not specified. Identifier of the message to edit
 * @property inline_message_id Required if <em>chat_id</em> and <em>message_id</em> are not specified. Identifier of the inline message
 * @property media A JSON-serialized object for a new media content of the message
 * @property reply_markup A JSON-serialized object for a new <a href="https://core.telegram.org/bots#inline-keyboards-and-on-the-fly-updating">inline keyboard</a>.
 * */
@Serializable
data class EditMessageMediaRequest(
    val chat_id: String? = null,
    val message_id: Long? = null,
    val inline_message_id: String? = null,
    val media: @Contextual InputMedia,
    val reply_markup: InlineKeyboardMarkup? = null,
) : TelegramRequest() {
    override fun toJsonForRequest() = json.encodeToString(serializer(), this)
    override fun toJsonForResponse() = JsonObject(
        json.encodeToJsonElement(serializer(), this).jsonObject + ("method" to JsonPrimitive("editMessageMedia"))
    ).toString()
    companion object {
        fun fromJson(string: String) = json.decodeFromString(serializer(), string)
    }
}

/**
 * <p>Use this method to edit only the reply markup of messages. On success, if the edited message is not an inline message, the edited <a href="#message">Message</a> is returned, otherwise <em>True</em> is returned.</p>
 *
 * @property chat_id Required if <em>inline_message_id</em> is not specified. Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>)
 * @property message_id Required if <em>inline_message_id</em> is not specified. Identifier of the message to edit
 * @property inline_message_id Required if <em>chat_id</em> and <em>message_id</em> are not specified. Identifier of the inline message
 * @property reply_markup A JSON-serialized object for an <a href="https://core.telegram.org/bots#inline-keyboards-and-on-the-fly-updating">inline keyboard</a>.
 * */
@Serializable
data class EditMessageReplyMarkupRequest(
    val chat_id: String? = null,
    val message_id: Long? = null,
    val inline_message_id: String? = null,
    val reply_markup: InlineKeyboardMarkup? = null,
) : TelegramRequest() {
    override fun toJsonForRequest() = json.encodeToString(serializer(), this)
    override fun toJsonForResponse() = JsonObject(
        json.encodeToJsonElement(serializer(), this).jsonObject + ("method" to JsonPrimitive("editMessageReplyMarkup"))
    ).toString()
    companion object {
        fun fromJson(string: String) = json.decodeFromString(serializer(), string)
    }
}

/**
 * <p>Use this method to stop a poll which was sent by the bot. On success, the stopped <a href="#poll">Poll</a> is returned.</p>
 *
 * @property chat_id Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>)
 * @property message_id Identifier of the original message with the poll
 * @property reply_markup A JSON-serialized object for a new message <a href="https://core.telegram.org/bots#inline-keyboards-and-on-the-fly-updating">inline keyboard</a>.
 * */
@Serializable
data class StopPollRequest(
    val chat_id: String,
    val message_id: Long,
    val reply_markup: InlineKeyboardMarkup? = null,
) : TelegramRequest() {
    override fun toJsonForRequest() = json.encodeToString(serializer(), this)
    override fun toJsonForResponse() = JsonObject(
        json.encodeToJsonElement(serializer(), this).jsonObject + ("method" to JsonPrimitive("stopPoll"))
    ).toString()
    companion object {
        fun fromJson(string: String) = json.decodeFromString(serializer(), string)
    }
}

/**
 * <p>Use this method to delete a message, including service messages, with the following limitations:<br>- A message can only be deleted if it was sent less than 48 hours ago.<br>- A dice message in a private chat can only be deleted if it was sent more than 24 hours ago.<br>- Bots can delete outgoing messages in private chats, groups, and supergroups.<br>- Bots can delete incoming messages in private chats.<br>- Bots granted <em>can_post_messages</em> permissions can delete outgoing messages in channels.<br>- If the bot is an administrator of a group, it can delete any message there.<br>- If the bot has <em>can_delete_messages</em> permission in a supergroup or a channel, it can delete any message there.<br>Returns <em>True</em> on success.</p>
 *
 * @property chat_id Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>)
 * @property message_id Identifier of the message to delete
 * */
@Serializable
data class DeleteMessageRequest(
    val chat_id: String,
    val message_id: Long,
) : TelegramRequest() {
    override fun toJsonForRequest() = json.encodeToString(serializer(), this)
    override fun toJsonForResponse() = JsonObject(
        json.encodeToJsonElement(serializer(), this).jsonObject + ("method" to JsonPrimitive("deleteMessage"))
    ).toString()
    companion object {
        fun fromJson(string: String) = json.decodeFromString(serializer(), string)
    }
}


// Stickers

/**
 * <p>Use this method to send static .WEBP, <a href="https://telegram.org/blog/animated-stickers">animated</a> .TGS, or <a href="https://telegram.org/blog/video-stickers-better-reactions">video</a> .WEBM stickers. On success, the sent <a href="#message">Message</a> is returned.</p>
 *
 * @property chat_id Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>)
 * @property sticker Sticker to send. Pass a file_id as String to send a file that exists on the Telegram servers (recommended), pass an HTTP URL as a String for Telegram to get a .WEBP file from the Internet, or upload a new one using multipart/form-data. <a href="#sending-files">More information on Sending Files »</a>
 * @property disable_notification Sends the message <a href="https://telegram.org/blog/channels-2-0#silent-messages">silently</a>. Users will receive a notification with no sound.
 * @property protect_content Protects the contents of the sent message from forwarding and saving
 * @property reply_to_message_id If the message is a reply, ID of the original message
 * @property allow_sending_without_reply Pass <em>True</em>, if the message should be sent even if the specified replied-to message is not found
 * @property reply_markup Additional interface options. A JSON-serialized object for an <a href="https://core.telegram.org/bots#inline-keyboards-and-on-the-fly-updating">inline keyboard</a>, <a href="https://core.telegram.org/bots#keyboards">custom reply keyboard</a>, instructions to remove reply keyboard or to force a reply from the user.
 * */
@Serializable
data class SendStickerRequest(
    val chat_id: String,
    val sticker: String,
    val disable_notification: Boolean? = null,
    val protect_content: Boolean? = null,
    val reply_to_message_id: Long? = null,
    val allow_sending_without_reply: Boolean? = null,
    val reply_markup: @Contextual KeyboardOption? = null,
) : TelegramRequest() {
    override fun toJsonForRequest() = json.encodeToString(serializer(), this)
    override fun toJsonForResponse() = JsonObject(
        json.encodeToJsonElement(serializer(), this).jsonObject + ("method" to JsonPrimitive("sendSticker"))
    ).toString()
    companion object {
        fun fromJson(string: String) = json.decodeFromString(serializer(), string)
    }
}

/**
 * <p>Use this method to get a sticker set. On success, a <a href="#stickerset">StickerSet</a> object is returned.</p>
 *
 * @property name Name of the sticker set
 * */
@Serializable
data class GetStickerSetRequest(
    val name: String,
) : TelegramRequest() {
    override fun toJsonForRequest() = json.encodeToString(serializer(), this)
    override fun toJsonForResponse() = JsonObject(
        json.encodeToJsonElement(serializer(), this).jsonObject + ("method" to JsonPrimitive("getStickerSet"))
    ).toString()
    companion object {
        fun fromJson(string: String) = json.decodeFromString(serializer(), string)
    }
}

/**
 * <p>Use this method to upload a .PNG file with a sticker for later use in <em>createNewStickerSet</em> and <em>addStickerToSet</em> methods (can be used multiple times). Returns the uploaded <a href="#file">File</a> on success.</p>
 *
 * @property user_id User identifier of sticker file owner
 * @property png_sticker <strong>PNG</strong> image with the sticker, must be up to 512 kilobytes in size, dimensions must not exceed 512px, and either width or height must be exactly 512px. <a href="#sending-files">More information on Sending Files »</a>
 * */
@Serializable
data class UploadStickerFileRequest(
    val user_id: Long,
    val png_sticker: @Contextual Any,
) : TelegramRequest() {
    override fun toJsonForRequest() = json.encodeToString(serializer(), this)
    override fun toJsonForResponse() = JsonObject(
        json.encodeToJsonElement(serializer(), this).jsonObject + ("method" to JsonPrimitive("uploadStickerFile"))
    ).toString()
    companion object {
        fun fromJson(string: String) = json.decodeFromString(serializer(), string)
    }
}

/**
 * <p>Use this method to create a new sticker set owned by a user. The bot will be able to edit the sticker set thus created. You <strong>must</strong> use exactly one of the fields <em>png_sticker</em>, <em>tgs_sticker</em>, or <em>webm_sticker</em>. Returns <em>True</em> on success.</p>
 *
 * @property user_id User identifier of created sticker set owner
 * @property name Short name of sticker set, to be used in <code>t.me/addstickers/</code> URLs (e.g., <em>animals</em>). Can contain only English letters, digits and underscores. Must begin with a letter, can't contain consecutive underscores and must end in <code>"_by_&lt;bot_username&gt;"</code>. <code>&lt;bot_username&gt;</code> is case insensitive. 1-64 characters.
 * @property title Sticker set title, 1-64 characters
 * @property png_sticker <strong>PNG</strong> image with the sticker, must be up to 512 kilobytes in size, dimensions must not exceed 512px, and either width or height must be exactly 512px. Pass a <em>file_id</em> as a String to send a file that already exists on the Telegram servers, pass an HTTP URL as a String for Telegram to get a file from the Internet, or upload a new one using multipart/form-data. <a href="#sending-files">More information on Sending Files »</a>
 * @property tgs_sticker <strong>TGS</strong> animation with the sticker, uploaded using multipart/form-data. See <a href="https://core.telegram.org/stickers#animated-sticker-requirements"></a><a href="https://core.telegram.org/stickers#animated-sticker-requirements">https://core.telegram.org/stickers#animated-sticker-requirements</a> for technical requirements
 * @property webm_sticker <strong>WEBM</strong> video with the sticker, uploaded using multipart/form-data. See <a href="https://core.telegram.org/stickers#video-sticker-requirements"></a><a href="https://core.telegram.org/stickers#video-sticker-requirements">https://core.telegram.org/stickers#video-sticker-requirements</a> for technical requirements
 * @property emojis One or more emoji corresponding to the sticker
 * @property contains_masks Pass <em>True</em>, if a set of mask stickers should be created
 * @property mask_position A JSON-serialized object for position where the mask should be placed on faces
 * */
@Serializable
data class CreateNewStickerSetRequest(
    val user_id: Long,
    val name: String,
    val title: String,
    val png_sticker: String? = null,
    val tgs_sticker: @Contextual Any? = null,
    val webm_sticker: @Contextual Any? = null,
    val emojis: String,
    val contains_masks: Boolean? = null,
    val mask_position: MaskPosition? = null,
) : TelegramRequest() {
    override fun toJsonForRequest() = json.encodeToString(serializer(), this)
    override fun toJsonForResponse() = JsonObject(
        json.encodeToJsonElement(serializer(), this).jsonObject + ("method" to JsonPrimitive("createNewStickerSet"))
    ).toString()
    companion object {
        fun fromJson(string: String) = json.decodeFromString(serializer(), string)
    }
}

/**
 * <p>Use this method to add a new sticker to a set created by the bot. You <strong>must</strong> use exactly one of the fields <em>png_sticker</em>, <em>tgs_sticker</em>, or <em>webm_sticker</em>. Animated stickers can be added to animated sticker sets and only to them. Animated sticker sets can have up to 50 stickers. Static sticker sets can have up to 120 stickers. Returns <em>True</em> on success.</p>
 *
 * @property user_id User identifier of sticker set owner
 * @property name Sticker set name
 * @property png_sticker <strong>PNG</strong> image with the sticker, must be up to 512 kilobytes in size, dimensions must not exceed 512px, and either width or height must be exactly 512px. Pass a <em>file_id</em> as a String to send a file that already exists on the Telegram servers, pass an HTTP URL as a String for Telegram to get a file from the Internet, or upload a new one using multipart/form-data. <a href="#sending-files">More information on Sending Files »</a>
 * @property tgs_sticker <strong>TGS</strong> animation with the sticker, uploaded using multipart/form-data. See <a href="https://core.telegram.org/stickers#animated-sticker-requirements"></a><a href="https://core.telegram.org/stickers#animated-sticker-requirements">https://core.telegram.org/stickers#animated-sticker-requirements</a> for technical requirements
 * @property webm_sticker <strong>WEBM</strong> video with the sticker, uploaded using multipart/form-data. See <a href="https://core.telegram.org/stickers#video-sticker-requirements"></a><a href="https://core.telegram.org/stickers#video-sticker-requirements">https://core.telegram.org/stickers#video-sticker-requirements</a> for technical requirements
 * @property emojis One or more emoji corresponding to the sticker
 * @property mask_position A JSON-serialized object for position where the mask should be placed on faces
 * */
@Serializable
data class AddStickerToSetRequest(
    val user_id: Long,
    val name: String,
    val png_sticker: String? = null,
    val tgs_sticker: @Contextual Any? = null,
    val webm_sticker: @Contextual Any? = null,
    val emojis: String,
    val mask_position: MaskPosition? = null,
) : TelegramRequest() {
    override fun toJsonForRequest() = json.encodeToString(serializer(), this)
    override fun toJsonForResponse() = JsonObject(
        json.encodeToJsonElement(serializer(), this).jsonObject + ("method" to JsonPrimitive("addStickerToSet"))
    ).toString()
    companion object {
        fun fromJson(string: String) = json.decodeFromString(serializer(), string)
    }
}

/**
 * <p>Use this method to move a sticker in a set created by the bot to a specific position. Returns <em>True</em> on success.</p>
 *
 * @property sticker File identifier of the sticker
 * @property position New sticker position in the set, zero-based
 * */
@Serializable
data class SetStickerPositionInSetRequest(
    val sticker: String,
    val position: Long,
) : TelegramRequest() {
    override fun toJsonForRequest() = json.encodeToString(serializer(), this)
    override fun toJsonForResponse() = JsonObject(
        json.encodeToJsonElement(serializer(), this).jsonObject + ("method" to JsonPrimitive("setStickerPositionInSet"))
    ).toString()
    companion object {
        fun fromJson(string: String) = json.decodeFromString(serializer(), string)
    }
}

/**
 * <p>Use this method to delete a sticker from a set created by the bot. Returns <em>True</em> on success.</p>
 *
 * @property sticker File identifier of the sticker
 * */
@Serializable
data class DeleteStickerFromSetRequest(
    val sticker: String,
) : TelegramRequest() {
    override fun toJsonForRequest() = json.encodeToString(serializer(), this)
    override fun toJsonForResponse() = JsonObject(
        json.encodeToJsonElement(serializer(), this).jsonObject + ("method" to JsonPrimitive("deleteStickerFromSet"))
    ).toString()
    companion object {
        fun fromJson(string: String) = json.decodeFromString(serializer(), string)
    }
}

/**
 * <p>Use this method to set the thumbnail of a sticker set. Animated thumbnails can be set for animated sticker sets only. Video thumbnails can be set only for video sticker sets only. Returns <em>True</em> on success.</p>
 *
 * @property name Sticker set name
 * @property user_id User identifier of the sticker set owner
 * @property thumb A <strong>PNG</strong> image with the thumbnail, must be up to 128 kilobytes in size and have width and height exactly 100px, or a <strong>TGS</strong> animation with the thumbnail up to 32 kilobytes in size; see <a href="https://core.telegram.org/stickers#animated-sticker-requirements"></a><a href="https://core.telegram.org/stickers#animated-sticker-requirements">https://core.telegram.org/stickers#animated-sticker-requirements</a> for animated sticker technical requirements, or a <strong>WEBM</strong> video with the thumbnail up to 32 kilobytes in size; see <a href="https://core.telegram.org/stickers#video-sticker-requirements"></a><a href="https://core.telegram.org/stickers#video-sticker-requirements">https://core.telegram.org/stickers#video-sticker-requirements</a> for video sticker technical requirements. Pass a <em>file_id</em> as a String to send a file that already exists on the Telegram servers, pass an HTTP URL as a String for Telegram to get a file from the Internet, or upload a new one using multipart/form-data. <a href="#sending-files">More information on Sending Files »</a>. Animated sticker set thumbnails can't be uploaded via HTTP URL.
 * */
@Serializable
data class SetStickerSetThumbRequest(
    val name: String,
    val user_id: Long,
    val thumb: String? = null,
) : TelegramRequest() {
    override fun toJsonForRequest() = json.encodeToString(serializer(), this)
    override fun toJsonForResponse() = JsonObject(
        json.encodeToJsonElement(serializer(), this).jsonObject + ("method" to JsonPrimitive("setStickerSetThumb"))
    ).toString()
    companion object {
        fun fromJson(string: String) = json.decodeFromString(serializer(), string)
    }
}


// Inline mode

/**
 * <p>Use this method to send answers to an inline query. On success, <em>True</em> is returned.<br>No more than <strong>50</strong> results per query are allowed.</p>
 *
 * @property inline_query_id Unique identifier for the answered query
 * @property results A JSON-serialized array of results for the inline query
 * @property cache_time The maximum amount of time in seconds that the result of the inline query may be cached on the server. Defaults to 300.
 * @property is_personal Pass <em>True</em>, if results may be cached on the server side only for the user that sent the query. By default, results may be returned to any user who sends the same query
 * @property next_offset Pass the offset that a client should send in the next query with the same text to receive more results. Pass an empty string if there are no more results or if you don't support pagination. Offset length can't exceed 64 bytes.
 * @property switch_pm_text If passed, clients will display a button with specified text that switches the user to a private chat with the bot and sends the bot a start message with the parameter <em>switch_pm_parameter</em>
 * @property switch_pm_parameter <a href="/bots#deep-linking">Deep-linking</a> parameter for the /start message sent to the bot when user presses the switch button. 1-64 characters, only <code>A-Z</code>, <code>a-z</code>, <code>0-9</code>, <code>_</code> and <code>-</code> are allowed.<br><br><em>Example:</em> An inline bot that sends YouTube videos can ask the user to connect the bot to their YouTube account to adapt search results accordingly. To do this, it displays a 'Connect your YouTube account' button above the results, or even before showing any. The user presses the button, switches to a private chat with the bot and, in doing so, passes a start parameter that instructs the bot to return an OAuth link. Once done, the bot can offer a <a href="#inlinekeyboardmarkup"><em>switch_inline</em></a> button so that the user can easily return to the chat where they wanted to use the bot's inline capabilities.
 * */
@Serializable
data class AnswerInlineQueryRequest(
    val inline_query_id: String,
    val results: List<@Contextual InlineQueryResult>,
    val cache_time: Long? = null,
    val is_personal: Boolean? = null,
    val next_offset: String? = null,
    val switch_pm_text: String? = null,
    val switch_pm_parameter: String? = null,
) : TelegramRequest() {
    override fun toJsonForRequest() = json.encodeToString(serializer(), this)
    override fun toJsonForResponse() = JsonObject(
        json.encodeToJsonElement(serializer(), this).jsonObject + ("method" to JsonPrimitive("answerInlineQuery"))
    ).toString()
    companion object {
        fun fromJson(string: String) = json.decodeFromString(serializer(), string)
    }
}

/**
 * <p>Use this method to set the result of an interaction with a <a href="/bots/webapps">Web App</a> and send a corresponding message on behalf of the user to the chat from which the query originated. On success, a <a href="#sentwebappmessage">SentWebAppMessage</a> object is returned.</p>
 *
 * @property web_app_query_id Unique identifier for the query to be answered
 * @property result A JSON-serialized object describing the message to be sent
 * */
@Serializable
data class AnswerWebAppQueryRequest(
    val web_app_query_id: String,
    val result: @Contextual InlineQueryResult,
) : TelegramRequest() {
    override fun toJsonForRequest() = json.encodeToString(serializer(), this)
    override fun toJsonForResponse() = JsonObject(
        json.encodeToJsonElement(serializer(), this).jsonObject + ("method" to JsonPrimitive("answerWebAppQuery"))
    ).toString()
    companion object {
        fun fromJson(string: String) = json.decodeFromString(serializer(), string)
    }
}


// Payments

/**
 * <p>Use this method to send invoices. On success, the sent <a href="#message">Message</a> is returned.</p>
 *
 * @property chat_id Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>)
 * @property title Product name, 1-32 characters
 * @property description Product description, 1-255 characters
 * @property payload Bot-defined invoice payload, 1-128 bytes. This will not be displayed to the user, use for your internal processes.
 * @property provider_token Payment provider token, obtained via <a href="https://t.me/botfather">@BotFather</a>
 * @property currency Three-letter ISO 4217 currency code, see <a href="/bots/payments#supported-currencies">more on currencies</a>
 * @property prices Price breakdown, a JSON-serialized list of components (e.g. product price, tax, discount, delivery cost, delivery tax, bonus, etc.)
 * @property max_tip_amount The maximum accepted amount for tips in the <em>smallest units</em> of the currency (integer, <strong>not</strong> float/double). For example, for a maximum tip of <code>US$ 1.45</code> pass <code>max_tip_amount = 145</code>. See the <em>exp</em> parameter in <a href="https://core.telegram.org/bots/payments/currencies.json">currencies.json</a>, it shows the number of digits past the decimal point for each currency (2 for the majority of currencies). Defaults to 0
 * @property suggested_tip_amounts A JSON-serialized array of suggested amounts of tips in the <em>smallest units</em> of the currency (integer, <strong>not</strong> float/double). At most 4 suggested tip amounts can be specified. The suggested tip amounts must be positive, passed in a strictly increased order and must not exceed <em>max_tip_amount</em>.
 * @property start_parameter Unique deep-linking parameter. If left empty, <strong>forwarded copies</strong> of the sent message will have a <em>Pay</em> button, allowing multiple users to pay directly from the forwarded message, using the same invoice. If non-empty, forwarded copies of the sent message will have a <em>URL</em> button with a deep link to the bot (instead of a <em>Pay</em> button), with the value used as the start parameter
 * @property provider_data JSON-serialized data about the invoice, which will be shared with the payment provider. A detailed description of required fields should be provided by the payment provider.
 * @property photo_url URL of the product photo for the invoice. Can be a photo of the goods or a marketing image for a service. People like it better when they see what they are paying for.
 * @property photo_size Photo size in bytes
 * @property photo_width Photo width
 * @property photo_height Photo height
 * @property need_name Pass <em>True</em>, if you require the user's full name to complete the order
 * @property need_phone_number Pass <em>True</em>, if you require the user's phone number to complete the order
 * @property need_email Pass <em>True</em>, if you require the user's email address to complete the order
 * @property need_shipping_address Pass <em>True</em>, if you require the user's shipping address to complete the order
 * @property send_phone_number_to_provider Pass <em>True</em>, if the user's phone number should be sent to provider
 * @property send_email_to_provider Pass <em>True</em>, if the user's email address should be sent to provider
 * @property is_flexible Pass <em>True</em>, if the final price depends on the shipping method
 * @property disable_notification Sends the message <a href="https://telegram.org/blog/channels-2-0#silent-messages">silently</a>. Users will receive a notification with no sound.
 * @property protect_content Protects the contents of the sent message from forwarding and saving
 * @property reply_to_message_id If the message is a reply, ID of the original message
 * @property allow_sending_without_reply Pass <em>True</em>, if the message should be sent even if the specified replied-to message is not found
 * @property reply_markup A JSON-serialized object for an <a href="https://core.telegram.org/bots#inline-keyboards-and-on-the-fly-updating">inline keyboard</a>. If empty, one 'Pay <code>total price</code>' button will be shown. If not empty, the first button must be a Pay button.
 * */
@Serializable
data class SendInvoiceRequest(
    val chat_id: String,
    val title: String,
    val description: String,
    val payload: String,
    val provider_token: String,
    val currency: String,
    val prices: List<LabeledPrice>,
    val max_tip_amount: Long? = null,
    val suggested_tip_amounts: List<Long>? = null,
    val start_parameter: String? = null,
    val provider_data: String? = null,
    val photo_url: String? = null,
    val photo_size: Long? = null,
    val photo_width: Long? = null,
    val photo_height: Long? = null,
    val need_name: Boolean? = null,
    val need_phone_number: Boolean? = null,
    val need_email: Boolean? = null,
    val need_shipping_address: Boolean? = null,
    val send_phone_number_to_provider: Boolean? = null,
    val send_email_to_provider: Boolean? = null,
    val is_flexible: Boolean? = null,
    val disable_notification: Boolean? = null,
    val protect_content: Boolean? = null,
    val reply_to_message_id: Long? = null,
    val allow_sending_without_reply: Boolean? = null,
    val reply_markup: InlineKeyboardMarkup? = null,
) : TelegramRequest() {
    override fun toJsonForRequest() = json.encodeToString(serializer(), this)
    override fun toJsonForResponse() = JsonObject(
        json.encodeToJsonElement(serializer(), this).jsonObject + ("method" to JsonPrimitive("sendInvoice"))
    ).toString()
    companion object {
        fun fromJson(string: String) = json.decodeFromString(serializer(), string)
    }
}

/**
 * <p>Use this method to create a link for an invoice. Returns the created invoice link as <em>String</em> on success.</p>
 *
 * @property title Product name, 1-32 characters
 * @property description Product description, 1-255 characters
 * @property payload Bot-defined invoice payload, 1-128 bytes. This will not be displayed to the user, use for your internal processes.
 * @property provider_token Payment provider token, obtained via <a href="https://t.me/botfather">BotFather</a>
 * @property currency Three-letter ISO 4217 currency code, see <a href="/bots/payments#supported-currencies">more on currencies</a>
 * @property prices Price breakdown, a JSON-serialized list of components (e.g. product price, tax, discount, delivery cost, delivery tax, bonus, etc.)
 * @property max_tip_amount The maximum accepted amount for tips in the <em>smallest units</em> of the currency (integer, <strong>not</strong> float/double). For example, for a maximum tip of <code>US$ 1.45</code> pass <code>max_tip_amount = 145</code>. See the <em>exp</em> parameter in <a href="https://core.telegram.org/bots/payments/currencies.json">currencies.json</a>, it shows the number of digits past the decimal point for each currency (2 for the majority of currencies). Defaults to 0
 * @property suggested_tip_amounts A JSON-serialized array of suggested amounts of tips in the <em>smallest units</em> of the currency (integer, <strong>not</strong> float/double). At most 4 suggested tip amounts can be specified. The suggested tip amounts must be positive, passed in a strictly increased order and must not exceed <em>max_tip_amount</em>.
 * @property provider_data JSON-serialized data about the invoice, which will be shared with the payment provider. A detailed description of required fields should be provided by the payment provider.
 * @property photo_url URL of the product photo for the invoice. Can be a photo of the goods or a marketing image for a service.
 * @property photo_size Photo size in bytes
 * @property photo_width Photo width
 * @property photo_height Photo height
 * @property need_name Pass <em>True</em>, if you require the user's full name to complete the order
 * @property need_phone_number Pass <em>True</em>, if you require the user's phone number to complete the order
 * @property need_email Pass <em>True</em>, if you require the user's email address to complete the order
 * @property need_shipping_address Pass <em>True</em>, if you require the user's shipping address to complete the order
 * @property send_phone_number_to_provider Pass <em>True</em>, if the user's phone number should be sent to the provider
 * @property send_email_to_provider Pass <em>True</em>, if the user's email address should be sent to the provider
 * @property is_flexible Pass <em>True</em>, if the final price depends on the shipping method
 * */
@Serializable
data class CreateInvoiceLinkRequest(
    val title: String,
    val description: String,
    val payload: String,
    val provider_token: String,
    val currency: String,
    val prices: List<LabeledPrice>,
    val max_tip_amount: Long? = null,
    val suggested_tip_amounts: List<Long>? = null,
    val provider_data: String? = null,
    val photo_url: String? = null,
    val photo_size: Long? = null,
    val photo_width: Long? = null,
    val photo_height: Long? = null,
    val need_name: Boolean? = null,
    val need_phone_number: Boolean? = null,
    val need_email: Boolean? = null,
    val need_shipping_address: Boolean? = null,
    val send_phone_number_to_provider: Boolean? = null,
    val send_email_to_provider: Boolean? = null,
    val is_flexible: Boolean? = null,
) : TelegramRequest() {
    override fun toJsonForRequest() = json.encodeToString(serializer(), this)
    override fun toJsonForResponse() = JsonObject(
        json.encodeToJsonElement(serializer(), this).jsonObject + ("method" to JsonPrimitive("createInvoiceLink"))
    ).toString()
    companion object {
        fun fromJson(string: String) = json.decodeFromString(serializer(), string)
    }
}

/**
 * <p>If you sent an invoice requesting a shipping address and the parameter <em>is_flexible</em> was specified, the Bot API will send an <a href="#update">Update</a> with a <em>shipping_query</em> field to the bot. Use this method to reply to shipping queries. On success, <em>True</em> is returned.</p>
 *
 * @property shipping_query_id Unique identifier for the query to be answered
 * @property ok Specify <em>True</em> if delivery to the specified address is possible and False if there are any problems (for example, if delivery to the specified address is not possible)
 * @property shipping_options Required if <em>ok</em> is <em>True</em>. A JSON-serialized array of available shipping options.
 * @property error_message Required if <em>ok</em> is False. Error message in human readable form that explains why it is impossible to complete the order (e.g. "Sorry, delivery to your desired address is unavailable'). Telegram will display this message to the user.
 * */
@Serializable
data class AnswerShippingQueryRequest(
    val shipping_query_id: String,
    val ok: Boolean,
    val shipping_options: List<ShippingOption>? = null,
    val error_message: String? = null,
) : TelegramRequest() {
    override fun toJsonForRequest() = json.encodeToString(serializer(), this)
    override fun toJsonForResponse() = JsonObject(
        json.encodeToJsonElement(serializer(), this).jsonObject + ("method" to JsonPrimitive("answerShippingQuery"))
    ).toString()
    companion object {
        fun fromJson(string: String) = json.decodeFromString(serializer(), string)
    }
}

/**
 * <p>Once the user has confirmed their payment and shipping details, the Bot API sends the final confirmation in the form of an <a href="#update">Update</a> with the field <em>pre_checkout_query</em>. Use this method to respond to such pre-checkout queries. On success, <em>True</em> is returned. <strong>Note:</strong> The Bot API must receive an answer within 10 seconds after the pre-checkout query was sent.</p>
 *
 * @property pre_checkout_query_id Unique identifier for the query to be answered
 * @property ok Specify <em>True</em> if everything is alright (goods are available, etc.) and the bot is ready to proceed with the order. Use <em>False</em> if there are any problems.
 * @property error_message Required if <em>ok</em> is <em>False</em>. Error message in human readable form that explains the reason for failure to proceed with the checkout (e.g. "Sorry, somebody just bought the last of our amazing black T-shirts while you were busy filling out your payment details. Please choose a different color or garment!"). Telegram will display this message to the user.
 * */
@Serializable
data class AnswerPreCheckoutQueryRequest(
    val pre_checkout_query_id: String,
    val ok: Boolean,
    val error_message: String? = null,
) : TelegramRequest() {
    override fun toJsonForRequest() = json.encodeToString(serializer(), this)
    override fun toJsonForResponse() = JsonObject(
        json.encodeToJsonElement(serializer(), this).jsonObject + ("method" to JsonPrimitive("answerPreCheckoutQuery"))
    ).toString()
    companion object {
        fun fromJson(string: String) = json.decodeFromString(serializer(), string)
    }
}


// Telegram Passport

/**
 * <p>Informs a user that some of the Telegram Passport elements they provided contains errors. The user will not be able to re-submit their Passport to you until the errors are fixed (the contents of the field for which you returned the error must change). Returns <em>True</em> on success.</p><p>Use this if the data submitted by the user doesn't satisfy the standards your service requires for any reason. For example, if a birthday date seems invalid, a submitted document is blurry, a scan shows evidence of tampering, etc. Supply some details in the error message to make sure the user knows how to correct the issues.</p>
 *
 * @property user_id User identifier
 * @property errors A JSON-serialized array describing the errors
 * */
@Serializable
data class SetPassportDataErrorsRequest(
    val user_id: Long,
    val errors: List<@Contextual PassportElementError>,
) : TelegramRequest() {
    override fun toJsonForRequest() = json.encodeToString(serializer(), this)
    override fun toJsonForResponse() = JsonObject(
        json.encodeToJsonElement(serializer(), this).jsonObject + ("method" to JsonPrimitive("setPassportDataErrors"))
    ).toString()
    companion object {
        fun fromJson(string: String) = json.decodeFromString(serializer(), string)
    }
}


// Games

/**
 * <p>Use this method to send a game. On success, the sent <a href="#message">Message</a> is returned.</p>
 *
 * @property chat_id Unique identifier for the target chat
 * @property game_short_name Short name of the game, serves as the unique identifier for the game. Set up your games via <a href="https://t.me/botfather">@BotFather</a>.
 * @property disable_notification Sends the message <a href="https://telegram.org/blog/channels-2-0#silent-messages">silently</a>. Users will receive a notification with no sound.
 * @property protect_content Protects the contents of the sent message from forwarding and saving
 * @property reply_to_message_id If the message is a reply, ID of the original message
 * @property allow_sending_without_reply Pass <em>True</em>, if the message should be sent even if the specified replied-to message is not found
 * @property reply_markup A JSON-serialized object for an <a href="https://core.telegram.org/bots#inline-keyboards-and-on-the-fly-updating">inline keyboard</a>. If empty, one 'Play game_title' button will be shown. If not empty, the first button must launch the game.
 * */
@Serializable
data class SendGameRequest(
    val chat_id: Long,
    val game_short_name: String,
    val disable_notification: Boolean? = null,
    val protect_content: Boolean? = null,
    val reply_to_message_id: Long? = null,
    val allow_sending_without_reply: Boolean? = null,
    val reply_markup: InlineKeyboardMarkup? = null,
) : TelegramRequest() {
    override fun toJsonForRequest() = json.encodeToString(serializer(), this)
    override fun toJsonForResponse() = JsonObject(
        json.encodeToJsonElement(serializer(), this).jsonObject + ("method" to JsonPrimitive("sendGame"))
    ).toString()
    companion object {
        fun fromJson(string: String) = json.decodeFromString(serializer(), string)
    }
}

/**
 * <p>Use this method to set the score of the specified user in a game message. On success, if the message is not an inline message, the <a href="#message">Message</a> is returned, otherwise <em>True</em> is returned. Returns an error, if the new score is not greater than the user's current score in the chat and <em>force</em> is <em>False</em>.</p>
 *
 * @property user_id User identifier
 * @property score New score, must be non-negative
 * @property force Pass <em>True</em>, if the high score is allowed to decrease. This can be useful when fixing mistakes or banning cheaters
 * @property disable_edit_message Pass <em>True</em>, if the game message should not be automatically edited to include the current scoreboard
 * @property chat_id Required if <em>inline_message_id</em> is not specified. Unique identifier for the target chat
 * @property message_id Required if <em>inline_message_id</em> is not specified. Identifier of the sent message
 * @property inline_message_id Required if <em>chat_id</em> and <em>message_id</em> are not specified. Identifier of the inline message
 * */
@Serializable
data class SetGameScoreRequest(
    val user_id: Long,
    val score: Long,
    val force: Boolean? = null,
    val disable_edit_message: Boolean? = null,
    val chat_id: Long? = null,
    val message_id: Long? = null,
    val inline_message_id: String? = null,
) : TelegramRequest() {
    override fun toJsonForRequest() = json.encodeToString(serializer(), this)
    override fun toJsonForResponse() = JsonObject(
        json.encodeToJsonElement(serializer(), this).jsonObject + ("method" to JsonPrimitive("setGameScore"))
    ).toString()
    companion object {
        fun fromJson(string: String) = json.decodeFromString(serializer(), string)
    }
}

/**
 * <p>Use this method to get data for high score tables. Will return the score of the specified user and several of their neighbors in a game. On success, returns an <em>Array</em> of <a href="#gamehighscore">GameHighScore</a> objects.</p><blockquote> 
 *  <p>This method will currently return scores for the target user, plus two of their closest neighbors on each side. Will also return the top three users if the user and their neighbors are not among them. Please note that this behavior is subject to change.</p> 
 * </blockquote>
 *
 * @property user_id Target user id
 * @property chat_id Required if <em>inline_message_id</em> is not specified. Unique identifier for the target chat
 * @property message_id Required if <em>inline_message_id</em> is not specified. Identifier of the sent message
 * @property inline_message_id Required if <em>chat_id</em> and <em>message_id</em> are not specified. Identifier of the inline message
 * */
@Serializable
data class GetGameHighScoresRequest(
    val user_id: Long,
    val chat_id: Long? = null,
    val message_id: Long? = null,
    val inline_message_id: String? = null,
) : TelegramRequest() {
    override fun toJsonForRequest() = json.encodeToString(serializer(), this)
    override fun toJsonForResponse() = JsonObject(
        json.encodeToJsonElement(serializer(), this).jsonObject + ("method" to JsonPrimitive("getGameHighScores"))
    ).toString()
    companion object {
        fun fromJson(string: String) = json.decodeFromString(serializer(), string)
    }
}

}
