import kotlinx.serialization.Optional
import kotlinx.serialization.Serializable

sealed class TelegramModel
sealed class InputMedia : TelegramModel()
sealed class InputMessageContent : TelegramModel()
sealed class InlineQueryResult : TelegramModel()
sealed class PassportElementError : TelegramModel()


// Getting updates

/**
 * <p>This <a href="#available-types">object</a> represents an incoming update.<br>At most <strong>one</strong> of the optional parameters can be present in any given update.</p>
 *
 * @property update_id The update‘s unique identifier. Update identifiers start from a certain positive number and increase sequentially. This ID becomes especially handy if you’re using <a href="#setwebhook">Webhooks</a>, since it allows you to ignore repeated updates or to restore the correct update sequence, should they get out of order. If there are no new updates for at least a week, then identifier of the next update will be chosen randomly instead of sequentially.
 * @property message <em>Optional</em>. New incoming message of any kind — text, photo, sticker, etc.
 * @property edited_message <em>Optional</em>. New version of a message that is known to the bot and was edited
 * @property channel_post <em>Optional</em>. New incoming channel post of any kind — text, photo, sticker, etc.
 * @property edited_channel_post <em>Optional</em>. New version of a channel post that is known to the bot and was edited
 * @property inline_query <em>Optional</em>. New incoming <a href="#inline-mode">inline</a> query
 * @property chosen_inline_result <em>Optional</em>. The result of an <a href="#inline-mode">inline</a> query that was chosen by a user and sent to their chat partner. Please see our documentation on the <a href="/bots/inline#collecting-feedback">feedback collecting</a> for details on how to enable these updates for your bot.
 * @property callback_query <em>Optional</em>. New incoming callback query
 * @property shipping_query <em>Optional</em>. New incoming shipping query. Only for invoices with flexible price
 * @property pre_checkout_query <em>Optional</em>. New incoming pre-checkout query. Contains full information about checkout
 * @property poll <em>Optional</em>. New poll state. Bots receive only updates about stopped polls and polls, which are sent by the bot
 *
 * @constructor Creates a: Update.
 * */
@Serializable
data class Update(
    val update_id: Int,
    val message: Message? = null,
    val edited_message: Message? = null,
    val channel_post: Message? = null,
    val edited_channel_post: Message? = null,
    val inline_query: InlineQuery? = null,
    val chosen_inline_result: ChosenInlineResult? = null,
    val callback_query: CallbackQuery? = null,
    val shipping_query: ShippingQuery? = null,
    val pre_checkout_query: PreCheckoutQuery? = null,
    val poll: Poll? = null
) : TelegramModel()

/**
 * <p>Contains information about the current status of a webhook.</p>
 *
 * @property url Webhook URL, may be empty if webhook is not set up
 * @property has_custom_certificate True, if a custom certificate was provided for webhook certificate checks
 * @property pending_update_count Number of updates awaiting delivery
 * @property last_error_date <em>Optional</em>. Unix time for the most recent error that happened when trying to deliver an update via webhook
 * @property last_error_message <em>Optional</em>. Error message in human-readable format for the most recent error that happened when trying to deliver an update via webhook
 * @property max_connections <em>Optional</em>. Maximum allowed number of simultaneous HTTPS connections to the webhook for update delivery
 * @property allowed_updates <em>Optional</em>. A list of update types the bot is subscribed to. Defaults to all update types
 *
 * @constructor Creates a: WebhookInfo.
 * */
@Serializable
data class WebhookInfo(
    val url: String,
    val has_custom_certificate: Boolean,
    val pending_update_count: Int,
    val last_error_date: Int? = null,
    val last_error_message: String? = null,
    val max_connections: Int? = null,
    val allowed_updates: List<String>? = null
) : TelegramModel()


// Available types

/**
 * <p>This object represents a Telegram user or bot.</p>
 *
 * @property id Unique identifier for this user or bot
 * @property is_bot True, if this user is a bot
 * @property first_name User‘s or bot’s first name
 * @property last_name <em>Optional</em>. User‘s or bot’s last name
 * @property username <em>Optional</em>. User‘s or bot’s username
 * @property language_code <em>Optional</em>. <a href="https://en.wikipedia.org/wiki/IETF_language_tag">IETF language tag</a> of the user's language
 *
 * @constructor Creates a: User.
 * */
@Serializable
data class User(
    val id: Int,
    val is_bot: Boolean,
    val first_name: String,
    val last_name: String? = null,
    val username: String? = null,
    val language_code: String? = null
) : TelegramModel()

/**
 * <p>This object represents a chat.</p>
 *
 * @property id Unique identifier for this chat. This number may be greater than 32 bits and some programming languages may have difficulty/silent defects in interpreting it. But it is smaller than 52 bits, so a signed 64 bit integer or double-precision float type are safe for storing this identifier.
 * @property type Type of chat, can be either “private”, “group”, “supergroup” or “channel”
 * @property title <em>Optional</em>. Title, for supergroups, channels and group chats
 * @property username <em>Optional</em>. Username, for private chats, supergroups and channels if available
 * @property first_name <em>Optional</em>. First name of the other party in a private chat
 * @property last_name <em>Optional</em>. Last name of the other party in a private chat
 * @property all_members_are_administrators <em>Optional</em>. True if a group has ‘All Members Are Admins’ enabled.
 * @property photo <em>Optional</em>. Chat photo. Returned only in <a href="#getchat">getChat</a>.
 * @property description <em>Optional</em>. Description, for supergroups and channel chats. Returned only in <a href="#getchat">getChat</a>.
 * @property invite_link <em>Optional</em>. Chat invite link, for supergroups and channel chats. Each administrator in a chat generates their own invite links, so the bot must first generate the link using <a href="#exportchatinvitelink">exportChatInviteLink</a>. Returned only in <a href="#getchat">getChat</a>.
 * @property pinned_message <em>Optional</em>. Pinned message, for groups, supergroups and channels. Returned only in <a href="#getchat">getChat</a>.
 * @property sticker_set_name <em>Optional</em>. For supergroups, name of group sticker set. Returned only in <a href="#getchat">getChat</a>.
 * @property can_set_sticker_set <em>Optional</em>. True, if the bot can change the group sticker set. Returned only in <a href="#getchat">getChat</a>.
 *
 * @constructor Creates a: Chat.
 * */
@Serializable
data class Chat(
    val id: Int,
    val type: String,
    val title: String? = null,
    val username: String? = null,
    val first_name: String? = null,
    val last_name: String? = null,
    val all_members_are_administrators: Boolean? = null,
    val photo: ChatPhoto? = null,
    val description: String? = null,
    val invite_link: String? = null,
    val pinned_message: Message? = null,
    val sticker_set_name: String? = null,
    val can_set_sticker_set: Boolean? = null
) : TelegramModel()

/**
 * <p>This object represents a message.</p>
 *
 * @property message_id Unique message identifier inside this chat
 * @property from <em>Optional</em>. Sender, empty for messages sent to channels
 * @property date Date the message was sent in Unix time
 * @property chat Conversation the message belongs to
 * @property forward_from <em>Optional</em>. For forwarded messages, sender of the original message
 * @property forward_from_chat <em>Optional</em>. For messages forwarded from channels, information about the original channel
 * @property forward_from_message_id <em>Optional</em>. For messages forwarded from channels, identifier of the original message in the channel
 * @property forward_signature <em>Optional</em>. For messages forwarded from channels, signature of the post author if present
 * @property forward_sender_name <em>Optional</em>. Sender's name for messages forwarded from users who disallow adding a link to their account in forwarded messages
 * @property forward_date <em>Optional</em>. For forwarded messages, date the original message was sent in Unix time
 * @property reply_to_message <em>Optional</em>. For replies, the original message. Note that the Message object in this field will not contain further <em>reply_to_message</em> fields even if it itself is a reply.
 * @property edit_date <em>Optional</em>. Date the message was last edited in Unix time
 * @property media_group_id <em>Optional</em>. The unique identifier of a media message group this message belongs to
 * @property author_signature <em>Optional</em>. Signature of the post author for messages in channels
 * @property text <em>Optional</em>. For text messages, the actual UTF-8 text of the message, 0-4096 characters.
 * @property entities <em>Optional</em>. For text messages, special entities like usernames, URLs, bot commands, etc. that appear in the text
 * @property caption_entities <em>Optional</em>. For messages with a caption, special entities like usernames, URLs, bot commands, etc. that appear in the caption
 * @property audio <em>Optional</em>. Message is an audio file, information about the file
 * @property document <em>Optional</em>. Message is a general file, information about the file
 * @property animation <em>Optional</em>. Message is an animation, information about the animation. For backward compatibility, when this field is set, the <em>document</em> field will also be set
 * @property game <em>Optional</em>. Message is a game, information about the game. <a href="#games">More about games »</a>
 * @property photo <em>Optional</em>. Message is a photo, available sizes of the photo
 * @property sticker <em>Optional</em>. Message is a sticker, information about the sticker
 * @property video <em>Optional</em>. Message is a video, information about the video
 * @property voice <em>Optional</em>. Message is a voice message, information about the file
 * @property video_note <em>Optional</em>. Message is a <a href="https://telegram.org/blog/video-messages-and-telescope">video note</a>, information about the video message
 * @property caption <em>Optional</em>. Caption for the animation, audio, document, photo, video or voice, 0-1024 characters
 * @property contact <em>Optional</em>. Message is a shared contact, information about the contact
 * @property location <em>Optional</em>. Message is a shared location, information about the location
 * @property venue <em>Optional</em>. Message is a venue, information about the venue
 * @property poll <em>Optional</em>. Message is a native poll, information about the poll
 * @property new_chat_members <em>Optional</em>. New members that were added to the group or supergroup and information about them (the bot itself may be one of these members)
 * @property left_chat_member <em>Optional</em>. A member was removed from the group, information about them (this member may be the bot itself)
 * @property new_chat_title <em>Optional</em>. A chat title was changed to this value
 * @property new_chat_photo <em>Optional</em>. A chat photo was change to this value
 * @property delete_chat_photo <em>Optional</em>. Service message: the chat photo was deleted
 * @property group_chat_created <em>Optional</em>. Service message: the group has been created
 * @property supergroup_chat_created <em>Optional</em>. Service message: the supergroup has been created. This field can‘t be received in a message coming through updates, because bot can’t be a member of a supergroup when it is created. It can only be found in reply_to_message if someone replies to a very first message in a directly created supergroup.
 * @property channel_chat_created <em>Optional</em>. Service message: the channel has been created. This field can‘t be received in a message coming through updates, because bot can’t be a member of a channel when it is created. It can only be found in reply_to_message if someone replies to a very first message in a channel.
 * @property migrate_to_chat_id <em>Optional</em>. The group has been migrated to a supergroup with the specified identifier. This number may be greater than 32 bits and some programming languages may have difficulty/silent defects in interpreting it. But it is smaller than 52 bits, so a signed 64 bit integer or double-precision float type are safe for storing this identifier.
 * @property migrate_from_chat_id <em>Optional</em>. The supergroup has been migrated from a group with the specified identifier. This number may be greater than 32 bits and some programming languages may have difficulty/silent defects in interpreting it. But it is smaller than 52 bits, so a signed 64 bit integer or double-precision float type are safe for storing this identifier.
 * @property pinned_message <em>Optional</em>. Specified message was pinned. Note that the Message object in this field will not contain further <em>reply_to_message</em> fields even if it is itself a reply.
 * @property invoice <em>Optional</em>. Message is an invoice for a <a href="#payments">payment</a>, information about the invoice. <a href="#payments">More about payments »</a>
 * @property successful_payment <em>Optional</em>. Message is a service message about a successful payment, information about the payment. <a href="#payments">More about payments »</a>
 * @property connected_website <em>Optional</em>. The domain name of the website on which the user has logged in. <a href="/widgets/login">More about Telegram Login »</a>
 * @property passport_data <em>Optional</em>. Telegram Passport data
 * @property reply_markup <em>Optional</em>. Inline keyboard attached to the message. <code>login_url</code> buttons are represented as ordinary <code>url</code> buttons.
 *
 * @constructor Creates a: Message.
 * */
@Serializable
data class Message(
    val message_id: Int,
    val from: User? = null,
    val date: Int,
    val chat: Chat,
    val forward_from: User? = null,
    val forward_from_chat: Chat? = null,
    val forward_from_message_id: Int? = null,
    val forward_signature: String? = null,
    val forward_sender_name: String? = null,
    val forward_date: Int? = null,
    val reply_to_message: Message? = null,
    val edit_date: Int? = null,
    val media_group_id: String? = null,
    val author_signature: String? = null,
    val text: String? = null,
    val entities: List<MessageEntity>? = null,
    val caption_entities: List<MessageEntity>? = null,
    val audio: Audio? = null,
    val document: Document? = null,
    val animation: Animation? = null,
    val game: Game? = null,
    val photo: List<PhotoSize>? = null,
    val sticker: Sticker? = null,
    val video: Video? = null,
    val voice: Voice? = null,
    val video_note: VideoNote? = null,
    val caption: String? = null,
    val contact: Contact? = null,
    val location: Location? = null,
    val venue: Venue? = null,
    val poll: Poll? = null,
    val new_chat_members: List<User>? = null,
    val left_chat_member: User? = null,
    val new_chat_title: String? = null,
    val new_chat_photo: List<PhotoSize>? = null,
    val delete_chat_photo: Boolean? = null,
    val group_chat_created: Boolean? = null,
    val supergroup_chat_created: Boolean? = null,
    val channel_chat_created: Boolean? = null,
    val migrate_to_chat_id: Int? = null,
    val migrate_from_chat_id: Int? = null,
    val pinned_message: Message? = null,
    val invoice: Invoice? = null,
    val successful_payment: SuccessfulPayment? = null,
    val connected_website: String? = null,
    val passport_data: PassportData? = null,
    val reply_markup: InlineKeyboardMarkup? = null
) : TelegramModel()

/**
 * <p>This object represents one special entity in a text message. For example, hashtags, usernames, URLs, etc.</p>
 *
 * @property type Type of the entity. Can be <em>mention</em> (<code>@username</code>), <em>hashtag</em>, <em>cashtag</em>, <em>bot_command</em>, <em>url</em>, <em>email</em>, <em>phone_number</em>, <em>bold</em> (bold text), <em>italic</em> (italic text), <em>code</em> (monowidth string), <em>pre</em> (monowidth block), <em>text_link</em> (for clickable text URLs), <em>text_mention</em> (for users <a href="https://telegram.org/blog/edit#new-mentions">without usernames</a>)
 * @property offset Offset in UTF-16 code units to the start of the entity
 * @property length Length of the entity in UTF-16 code units
 * @property url <em>Optional</em>. For “text_link” only, url that will be opened after user taps on the text
 * @property user <em>Optional</em>. For “text_mention” only, the mentioned user
 *
 * @constructor Creates a: MessageEntity.
 * */
@Serializable
data class MessageEntity(
    val type: String,
    val offset: Int,
    val length: Int,
    val url: String? = null,
    val user: User? = null
) : TelegramModel()

/**
 * <p>This object represents one size of a photo or a <a href="#document">file</a> / <a href="#sticker">sticker</a> thumbnail.</p>
 *
 * @property file_id Unique identifier for this file
 * @property width Photo width
 * @property height Photo height
 * @property file_size <em>Optional</em>. File size
 *
 * @constructor Creates a: PhotoSize.
 * */
@Serializable
data class PhotoSize(
    val file_id: String,
    val width: Int,
    val height: Int,
    val file_size: Int? = null
) : TelegramModel()

/**
 * <p>This object represents an audio file to be treated as music by the Telegram clients.</p>
 *
 * @property file_id Unique identifier for this file
 * @property duration Duration of the audio in seconds as defined by sender
 * @property performer <em>Optional</em>. Performer of the audio as defined by sender or by audio tags
 * @property title <em>Optional</em>. Title of the audio as defined by sender or by audio tags
 * @property mime_type <em>Optional</em>. MIME type of the file as defined by sender
 * @property file_size <em>Optional</em>. File size
 * @property thumb <em>Optional</em>. Thumbnail of the album cover to which the music file belongs
 *
 * @constructor Creates a: Audio.
 * */
@Serializable
data class Audio(
    val file_id: String,
    val duration: Int,
    val performer: String? = null,
    val title: String? = null,
    val mime_type: String? = null,
    val file_size: Int? = null,
    val thumb: PhotoSize? = null
) : TelegramModel()

/**
 * <p>This object represents a general file (as opposed to <a href="#photosize">photos</a>, <a href="#voice">voice messages</a> and <a href="#audio">audio files</a>).</p>
 *
 * @property file_id Unique file identifier
 * @property thumb <em>Optional</em>. Document thumbnail as defined by sender
 * @property file_name <em>Optional</em>. Original filename as defined by sender
 * @property mime_type <em>Optional</em>. MIME type of the file as defined by sender
 * @property file_size <em>Optional</em>. File size
 *
 * @constructor Creates a: Document.
 * */
@Serializable
data class Document(
    val file_id: String,
    val thumb: PhotoSize? = null,
    val file_name: String? = null,
    val mime_type: String? = null,
    val file_size: Int? = null
) : TelegramModel()

/**
 * <p>This object represents a video file.</p>
 *
 * @property file_id Unique identifier for this file
 * @property width Video width as defined by sender
 * @property height Video height as defined by sender
 * @property duration Duration of the video in seconds as defined by sender
 * @property thumb <em>Optional</em>. Video thumbnail
 * @property mime_type <em>Optional</em>. Mime type of a file as defined by sender
 * @property file_size <em>Optional</em>. File size
 *
 * @constructor Creates a: Video.
 * */
@Serializable
data class Video(
    val file_id: String,
    val width: Int,
    val height: Int,
    val duration: Int,
    val thumb: PhotoSize? = null,
    val mime_type: String? = null,
    val file_size: Int? = null
) : TelegramModel()

/**
 * <p>This object represents an animation file (GIF or H.264/MPEG-4 AVC video without sound).</p>
 *
 * @property file_id Unique file identifier
 * @property width Video width as defined by sender
 * @property height Video height as defined by sender
 * @property duration Duration of the video in seconds as defined by sender
 * @property thumb <em>Optional</em>. Animation thumbnail as defined by sender
 * @property file_name <em>Optional</em>. Original animation filename as defined by sender
 * @property mime_type <em>Optional</em>. MIME type of the file as defined by sender
 * @property file_size <em>Optional</em>. File size
 *
 * @constructor Creates a: Animation.
 * */
@Serializable
data class Animation(
    val file_id: String,
    val width: Int,
    val height: Int,
    val duration: Int,
    val thumb: PhotoSize? = null,
    val file_name: String? = null,
    val mime_type: String? = null,
    val file_size: Int? = null
) : TelegramModel()

/**
 * <p>This object represents a voice note.</p>
 *
 * @property file_id Unique identifier for this file
 * @property duration Duration of the audio in seconds as defined by sender
 * @property mime_type <em>Optional</em>. MIME type of the file as defined by sender
 * @property file_size <em>Optional</em>. File size
 *
 * @constructor Creates a: Voice.
 * */
@Serializable
data class Voice(
    val file_id: String,
    val duration: Int,
    val mime_type: String? = null,
    val file_size: Int? = null
) : TelegramModel()

/**
 * <p>This object represents a <a href="https://telegram.org/blog/video-messages-and-telescope">video message</a> (available in Telegram apps as of <a href="https://telegram.org/blog/video-messages-and-telescope">v.4.0</a>).</p>
 *
 * @property file_id Unique identifier for this file
 * @property length Video width and height (diameter of the video message) as defined by sender
 * @property duration Duration of the video in seconds as defined by sender
 * @property thumb <em>Optional</em>. Video thumbnail
 * @property file_size <em>Optional</em>. File size
 *
 * @constructor Creates a: VideoNote.
 * */
@Serializable
data class VideoNote(
    val file_id: String,
    val length: Int,
    val duration: Int,
    val thumb: PhotoSize? = null,
    val file_size: Int? = null
) : TelegramModel()

/**
 * <p>This object represents a phone contact.</p>
 *
 * @property phone_number Contact's phone number
 * @property first_name Contact's first name
 * @property last_name <em>Optional</em>. Contact's last name
 * @property user_id <em>Optional</em>. Contact's user identifier in Telegram
 * @property vcard <em>Optional</em>. Additional data about the contact in the form of a <a href="https://en.wikipedia.org/wiki/VCard">vCard</a>
 *
 * @constructor Creates a: Contact.
 * */
@Serializable
data class Contact(
    val phone_number: String,
    val first_name: String,
    val last_name: String? = null,
    val user_id: Int? = null,
    val vcard: String? = null
) : TelegramModel()

/**
 * <p>This object represents a point on the map.</p>
 *
 * @property longitude Longitude as defined by sender
 * @property latitude Latitude as defined by sender
 *
 * @constructor Creates a: Location.
 * */
@Serializable
data class Location(
    val longitude: Float,
    val latitude: Float
) : TelegramModel()

/**
 * <p>This object represents a venue.</p>
 *
 * @property location Venue location
 * @property title Name of the venue
 * @property address Address of the venue
 * @property foursquare_id <em>Optional</em>. Foursquare identifier of the venue
 * @property foursquare_type <em>Optional</em>. Foursquare type of the venue. (For example, “arts_entertainment/default”, “arts_entertainment/aquarium” or “food/icecream”.)
 *
 * @constructor Creates a: Venue.
 * */
@Serializable
data class Venue(
    val location: Location,
    val title: String,
    val address: String,
    val foursquare_id: String? = null,
    val foursquare_type: String? = null
) : TelegramModel()

/**
 * <p>This object contains information about one answer option in a poll.</p>
 *
 * @property text Option text, 1-100 characters
 * @property voter_count Number of users that voted for this option
 *
 * @constructor Creates a: PollOption.
 * */
@Serializable
data class PollOption(
    val text: String,
    val voter_count: Int
) : TelegramModel()

/**
 * <p>This object contains information about a poll.</p>
 *
 * @property id Unique poll identifier
 * @property question Poll question, 1-255 characters
 * @property options List of poll options
 * @property is_closed True, if the poll is closed
 *
 * @constructor Creates a: Poll.
 * */
@Serializable
data class Poll(
    val id: String,
    val question: String,
    val options: List<PollOption>,
    val is_closed: Boolean
) : TelegramModel()

/**
 * <p>This object represent a user's profile pictures.</p>
 *
 * @property total_count Total number of profile pictures the target user has
 * @property photos Requested profile pictures (in up to 4 sizes each)
 *
 * @constructor Creates a: UserProfilePhotos.
 * */
@Serializable
data class UserProfilePhotos(
    val total_count: Int,
    val photos: List<List<PhotoSize>>
) : TelegramModel()

/**
 * <p>This object represents a file ready to be downloaded. The file can be downloaded via the link <code>https://api.telegram.org/file/bot&lt;token&gt;/&lt;file_path&gt;</code>. It is guaranteed that the link will be valid for at least 1 hour. When the link expires, a new one can be requested by calling <a href="#getfile">getFile</a>.</p><blockquote>
<p>Maximum file size to download is 20 MB</p>
</blockquote>
 *
 * @property file_id Unique identifier for this file
 * @property file_size <em>Optional</em>. File size, if known
 * @property file_path <em>Optional</em>. File path. Use <code>https://api.telegram.org/file/bot&lt;token&gt;/&lt;file_path&gt;</code> to get the file.
 *
 * @constructor Creates a: File.
 * */
@Serializable
data class File(
    val file_id: String,
    val file_size: Int? = null,
    val file_path: String? = null
) : TelegramModel()

/**
 * <p>This object represents a <a href="https://core.telegram.org/bots#keyboards">custom keyboard</a> with reply options (see <a href="https://core.telegram.org/bots#keyboards">Introduction to bots</a> for details and examples).</p>
 *
 * @property keyboard Array of button rows, each represented by an Array of <a href="#keyboardbutton">KeyboardButton</a> objects
 * @property resize_keyboard <em>Optional</em>. Requests clients to resize the keyboard vertically for optimal fit (e.g., make the keyboard smaller if there are just two rows of buttons). Defaults to <em>false</em>, in which case the custom keyboard is always of the same height as the app's standard keyboard.
 * @property one_time_keyboard <em>Optional</em>. Requests clients to hide the keyboard as soon as it's been used. The keyboard will still be available, but clients will automatically display the usual letter-keyboard in the chat – the user can press a special button in the input field to see the custom keyboard again. Defaults to <em>false</em>.
 * @property selective <em>Optional</em>. Use this parameter if you want to show the keyboard to specific users only. Targets: 1) users that are @mentioned in the <em>text</em> of the <a href="#message">Message</a> object; 2) if the bot's message is a reply (has <em>reply_to_message_id</em>), sender of the original message.<br><br><em>Example:</em> A user requests to change the bot‘s language, bot replies to the request with a keyboard to select the new language. Other users in the group don’t see the keyboard.
 *
 * @constructor Creates a: ReplyKeyboardMarkup.
 * */
@Serializable
data class ReplyKeyboardMarkup(
    val keyboard: List<List<KeyboardButton>>,
    val resize_keyboard: Boolean? = null,
    val one_time_keyboard: Boolean? = null,
    val selective: Boolean? = null
) : TelegramModel()

/**
 * <p>This object represents one button of the reply keyboard. For simple text buttons <em>String</em> can be used instead of this object to specify text of the button. Optional fields are mutually exclusive.</p><p><strong>Note:</strong> <em>request_contact</em> and <em>request_location</em> options will only work in Telegram versions released after 9 April, 2016. Older clients will ignore them.</p>
 *
 * @property text Text of the button. If none of the optional fields are used, it will be sent as a message when the button is pressed
 * @property request_contact <em>Optional</em>. If <em>True</em>, the user's phone number will be sent as a contact when the button is pressed. Available in private chats only
 * @property request_location <em>Optional</em>. If <em>True</em>, the user's current location will be sent when the button is pressed. Available in private chats only
 *
 * @constructor Creates a: KeyboardButton.
 * */
@Serializable
data class KeyboardButton(
    val text: String,
    val request_contact: Boolean? = null,
    val request_location: Boolean? = null
) : TelegramModel()

/**
 * <p>Upon receiving a message with this object, Telegram clients will remove the current custom keyboard and display the default letter-keyboard. By default, custom keyboards are displayed until a new keyboard is sent by a bot. An exception is made for one-time keyboards that are hidden immediately after the user presses a button (see <a href="#replykeyboardmarkup">ReplyKeyboardMarkup</a>). </p>
 *
 * @property remove_keyboard Requests clients to remove the custom keyboard (user will not be able to summon this keyboard; if you want to hide the keyboard from sight but keep it accessible, use <em>one_time_keyboard</em> in <a href="#replykeyboardmarkup">ReplyKeyboardMarkup</a>)
 * @property selective <em>Optional</em>. Use this parameter if you want to remove the keyboard for specific users only. Targets: 1) users that are @mentioned in the <em>text</em> of the <a href="#message">Message</a> object; 2) if the bot's message is a reply (has <em>reply_to_message_id</em>), sender of the original message.<br><br><em>Example:</em> A user votes in a poll, bot returns confirmation message in reply to the vote and removes the keyboard for that user, while still showing the keyboard with poll options to users who haven't voted yet.
 *
 * @constructor Creates a: ReplyKeyboardRemove.
 * */
@Serializable
data class ReplyKeyboardRemove(
    val remove_keyboard: Boolean,
    val selective: Boolean? = null
) : TelegramModel()

/**
 * <p>This object represents an <a href="https://core.telegram.org/bots#inline-keyboards-and-on-the-fly-updating">inline keyboard</a> that appears right next to the message it belongs to.</p><p><strong>Note:</strong> This will only work in Telegram versions released after 9 April, 2016. Older clients will display <em>unsupported message</em>.</p>
 *
 * @property inline_keyboard Array of button rows, each represented by an Array of <a href="#inlinekeyboardbutton">InlineKeyboardButton</a> objects
 *
 * @constructor Creates a: InlineKeyboardMarkup.
 * */
@Serializable
data class InlineKeyboardMarkup(
    val inline_keyboard: List<List<InlineKeyboardButton>>
) : TelegramModel()

/**
 * <p>This object represents one button of an inline keyboard. You <strong>must</strong> use exactly one of the optional fields.</p>
 *
 * @property text Label text on the button
 * @property url <em>Optional</em>. HTTP or tg:// url to be opened when button is pressed
 * @property login_url <em>Optional</em>. An HTTP URL used to automatically authorize the user. Can be used as a replacement for the <a href="https://core.telegram.org/widgets/login">Telegram Login Widget</a>.
 * @property callback_data <em>Optional</em>. Data to be sent in a <a href="#callbackquery">callback query</a> to the bot when button is pressed, 1-64 bytes
 * @property switch_inline_query <em>Optional</em>. If set, pressing the button will prompt the user to select one of their chats, open that chat and insert the bot‘s username and the specified inline query in the input field. Can be empty, in which case just the bot’s username will be inserted.<br><br><strong>Note:</strong> This offers an easy way for users to start using your bot in <a href="/bots/inline">inline mode</a> when they are currently in a private chat with it. Especially useful when combined with <a href="#answerinlinequery"><em>switch_pm…</em></a> actions – in this case the user will be automatically returned to the chat they switched from, skipping the chat selection screen.
 * @property switch_inline_query_current_chat <em>Optional</em>. If set, pressing the button will insert the bot‘s username and the specified inline query in the current chat's input field. Can be empty, in which case only the bot’s username will be inserted.<br><br>This offers a quick way for the user to open your bot in inline mode in the same chat – good for selecting something from multiple options.
 * @property callback_game <em>Optional</em>. Description of the game that will be launched when the user presses the button.<br><br><strong>NOTE:</strong> This type of button <strong>must</strong> always be the first button in the first row.
 * @property pay <em>Optional</em>. Specify True, to send a <a href="#payments">Pay button</a>.<br><br><strong>NOTE:</strong> This type of button <strong>must</strong> always be the first button in the first row.
 *
 * @constructor Creates a: InlineKeyboardButton.
 * */
@Serializable
data class InlineKeyboardButton(
    val text: String,
    val url: String? = null,
    val login_url: LoginUrl? = null,
    val callback_data: String? = null,
    val switch_inline_query: String? = null,
    val switch_inline_query_current_chat: String? = null,
    val callback_game: Any? = null,
    val pay: Boolean? = null
) : TelegramModel()

/**
 * <p>This object represents a parameter of the inline keyboard button used to automatically authorize a user. Serves as a great replacement for the <a href="https://core.telegram.org/widgets/login">Telegram Login Widget</a> when the user is coming from Telegram. All the user needs to do is tap/click a button and confirm that they want to log in:</p><p>Telegram apps support these buttons as of <a href="https://telegram.org/blog/privacy-discussions-web-bots#meet-seamless-web-bots">version 5.7</a>.</p><blockquote>
<p>Sample bot: <a href="https://t.me/discussbot">@discussbot</a></p>
</blockquote>
 *
 * @property url An HTTP URL to be opened with user authorization data added to the query string when the button is pressed. If the user refuses to provide authorization data, the original URL without information about the user will be opened. The data added is the same as described in <a href="https://core.telegram.org/widgets/login#receiving-authorization-data">Receiving authorization data</a>.<br><br><strong>NOTE:</strong> You <strong>must</strong> always check the hash of the received data to verify the authentication and the integrity of the data as described in <a href="https://core.telegram.org/widgets/login#checking-authorization">Checking authorization</a>.
 * @property forward_text <em>Optional</em>. New text of the button in forwarded messages.
 * @property bot_username <em>Optional</em>. Username of a bot, which will be used for user authorization. See <a href="https://core.telegram.org/widgets/login#setting-up-a-bot">Setting up a bot</a> for more details. If not specified, the current bot's username will be assumed. The <em>url</em>'s domain must be the same as the domain linked with the bot. See <a href="https://core.telegram.org/widgets/login#linking-your-domain-to-the-bot">Linking your domain to the bot</a> for more details.
 * @property request_write_access <em>Optional</em>. Pass True to request the permission for your bot to send messages to the user.
 *
 * @constructor Creates a: LoginUrl.
 * */
@Serializable
data class LoginUrl(
    val url: String,
    val forward_text: String? = null,
    val bot_username: String? = null,
    val request_write_access: Boolean? = null
) : TelegramModel()

/**
 * <p>This object represents an incoming callback query from a callback button in an <a href="/bots#inline-keyboards-and-on-the-fly-updating">inline keyboard</a>. If the button that originated the query was attached to a message sent by the bot, the field <em>message</em> will be present. If the button was attached to a message sent via the bot (in <a href="#inline-mode">inline mode</a>), the field <em>inline_message_id</em> will be present. Exactly one of the fields <em>data</em> or <em>game_short_name</em> will be present. </p><blockquote>
<p><strong>NOTE:</strong> After the user presses a callback button, Telegram clients will display a progress bar until you call <a href="#answercallbackquery">answerCallbackQuery</a>. It is, therefore, necessary to react by calling <a href="#answercallbackquery">answerCallbackQuery</a> even if no notification to the user is needed (e.g., without specifying any of the optional parameters).</p>
</blockquote>
 *
 * @property id Unique identifier for this query
 * @property from Sender
 * @property message <em>Optional</em>. Message with the callback button that originated the query. Note that message content and message date will not be available if the message is too old
 * @property inline_message_id <em>Optional</em>. Identifier of the message sent via the bot in inline mode, that originated the query.
 * @property chat_instance Global identifier, uniquely corresponding to the chat to which the message with the callback button was sent. Useful for high scores in <a href="#games">games</a>.
 * @property data <em>Optional</em>. Data associated with the callback button. Be aware that a bad client can send arbitrary data in this field.
 * @property game_short_name <em>Optional</em>. Short name of a <a href="#games">Game</a> to be returned, serves as the unique identifier for the game
 *
 * @constructor Creates a: CallbackQuery.
 * */
@Serializable
data class CallbackQuery(
    val id: String,
    val from: User,
    val message: Message? = null,
    val inline_message_id: String? = null,
    val chat_instance: String,
    val data: String? = null,
    val game_short_name: String? = null
) : TelegramModel()

/**
 * <p>Upon receiving a message with this object, Telegram clients will display a reply interface to the user (act as if the user has selected the bot‘s message and tapped ’Reply'). This can be extremely useful if you want to create user-friendly step-by-step interfaces without having to sacrifice <a href="/bots#privacy-mode">privacy mode</a>.</p><blockquote>
<p><strong>Example:</strong> A <a href="https://t.me/PollBot">poll bot</a> for groups runs in privacy mode (only receives commands, replies to its messages and mentions). There could be two ways to create a new poll:</p>
</blockquote><ul>
<li>Explain the user how to send a command with parameters (e.g. /newpoll question answer1 answer2). May be appealing for hardcore users but lacks modern day polish. </li>
<li>Guide the user through a step-by-step process. ‘Please send me your question’, ‘Cool, now let’s add the first answer option‘, ’Great. Keep adding answer options, then send /done when you‘re ready’. </li>
</ul><p>The last option is definitely more attractive. And if you use <a href="#forcereply">ForceReply</a> in your bot‘s questions, it will receive the user’s answers even if it only receives replies, commands and mentions — without any extra work for the user.</p>
 *
 * @property force_reply Shows reply interface to the user, as if they manually selected the bot‘s message and tapped ’Reply'
 * @property selective <em>Optional</em>. Use this parameter if you want to force reply from specific users only. Targets: 1) users that are @mentioned in the <em>text</em> of the <a href="#message">Message</a> object; 2) if the bot's message is a reply (has <em>reply_to_message_id</em>), sender of the original message.
 *
 * @constructor Creates a: ForceReply.
 * */
@Serializable
data class ForceReply(
    val force_reply: Boolean,
    val selective: Boolean? = null
) : TelegramModel()

/**
 * <p>This object represents a chat photo.</p>
 *
 * @property small_file_id Unique file identifier of small (160x160) chat photo. This file_id can be used only for photo download.
 * @property big_file_id Unique file identifier of big (640x640) chat photo. This file_id can be used only for photo download.
 *
 * @constructor Creates a: ChatPhoto.
 * */
@Serializable
data class ChatPhoto(
    val small_file_id: String,
    val big_file_id: String
) : TelegramModel()

/**
 * <p>This object contains information about one member of a chat.</p>
 *
 * @property user Information about the user
 * @property status The member's status in the chat. Can be “creator”, “administrator”, “member”, “restricted”, “left” or “kicked”
 * @property until_date <em>Optional</em>. Restricted and kicked only. Date when restrictions will be lifted for this user, unix time
 * @property can_be_edited <em>Optional</em>. Administrators only. True, if the bot is allowed to edit administrator privileges of that user
 * @property can_change_info <em>Optional</em>. Administrators only. True, if the administrator can change the chat title, photo and other settings
 * @property can_post_messages <em>Optional</em>. Administrators only. True, if the administrator can post in the channel, channels only
 * @property can_edit_messages <em>Optional</em>. Administrators only. True, if the administrator can edit messages of other users and can pin messages, channels only
 * @property can_delete_messages <em>Optional</em>. Administrators only. True, if the administrator can delete messages of other users
 * @property can_invite_users <em>Optional</em>. Administrators only. True, if the administrator can invite new users to the chat
 * @property can_restrict_members <em>Optional</em>. Administrators only. True, if the administrator can restrict, ban or unban chat members
 * @property can_pin_messages <em>Optional</em>. Administrators only. True, if the administrator can pin messages, groups and supergroups only
 * @property can_promote_members <em>Optional</em>. Administrators only. True, if the administrator can add new administrators with a subset of his own privileges or demote administrators that he has promoted, directly or indirectly (promoted by administrators that were appointed by the user)
 * @property is_member <em>Optional</em>. Restricted only. True, if the user is a member of the chat at the moment of the request
 * @property can_send_messages <em>Optional</em>. Restricted only. True, if the user can send text messages, contacts, locations and venues
 * @property can_send_media_messages <em>Optional</em>. Restricted only. True, if the user can send audios, documents, photos, videos, video notes and voice notes, implies can_send_messages
 * @property can_send_other_messages <em>Optional</em>. Restricted only. True, if the user can send animations, games, stickers and use inline bots, implies can_send_media_messages
 * @property can_add_web_page_previews <em>Optional</em>. Restricted only. True, if user may add web page previews to his messages, implies can_send_media_messages
 *
 * @constructor Creates a: ChatMember.
 * */
@Serializable
data class ChatMember(
    val user: User,
    val status: String,
    val until_date: Int? = null,
    val can_be_edited: Boolean? = null,
    val can_change_info: Boolean? = null,
    val can_post_messages: Boolean? = null,
    val can_edit_messages: Boolean? = null,
    val can_delete_messages: Boolean? = null,
    val can_invite_users: Boolean? = null,
    val can_restrict_members: Boolean? = null,
    val can_pin_messages: Boolean? = null,
    val can_promote_members: Boolean? = null,
    val is_member: Boolean? = null,
    val can_send_messages: Boolean? = null,
    val can_send_media_messages: Boolean? = null,
    val can_send_other_messages: Boolean? = null,
    val can_add_web_page_previews: Boolean? = null
) : TelegramModel()

/**
 * <p>Contains information about why a request was unsuccessful.</p>
 *
 * @property migrate_to_chat_id <em>Optional</em>. The group has been migrated to a supergroup with the specified identifier. This number may be greater than 32 bits and some programming languages may have difficulty/silent defects in interpreting it. But it is smaller than 52 bits, so a signed 64 bit integer or double-precision float type are safe for storing this identifier.
 * @property retry_after <em>Optional</em>. In case of exceeding flood control, the number of seconds left to wait before the request can be repeated
 *
 * @constructor Creates a: ResponseParameters.
 * */
@Serializable
data class ResponseParameters(
    val migrate_to_chat_id: Int? = null,
    val retry_after: Int? = null
) : TelegramModel()

/**
 * <p>Represents a photo to be sent.</p>
 *
 * @property type Type of the result, must be <em>photo</em>
 * @property media File to send. Pass a file_id to send a file that exists on the Telegram servers (recommended), pass an HTTP URL for Telegram to get a file from the Internet, or pass “attach://&lt;file_attach_name&gt;” to upload a new one using multipart/form-data under &lt;file_attach_name&gt; name. <a href="#sending-files">More info on Sending Files »</a>
 * @property caption <em>Optional</em>. Caption of the photo to be sent, 0-1024 characters
 * @property parse_mode <em>Optional</em>. Send <a href="#markdown-style"><em>Markdown</em></a> or <a href="#html-style"><em>HTML</em></a>, if you want Telegram apps to show <a href="#formatting-options">bold, italic, fixed-width text or inline URLs</a> in the media caption.
 *
 * @constructor Creates a: InputMediaPhoto.
 * */
@Serializable
data class InputMediaPhoto(
    val type: String,
    val media: String,
    val caption: String? = null,
    val parse_mode: String? = null
) : InputMedia()

/**
 * <p>Represents a video to be sent.</p>
 *
 * @property type Type of the result, must be <em>video</em>
 * @property media File to send. Pass a file_id to send a file that exists on the Telegram servers (recommended), pass an HTTP URL for Telegram to get a file from the Internet, or pass “attach://&lt;file_attach_name&gt;” to upload a new one using multipart/form-data under &lt;file_attach_name&gt; name. <a href="#sending-files">More info on Sending Files »</a>
 * @property thumb <em>Optional</em>. Thumbnail of the file sent; can be ignored if thumbnail generation for the file is supported server-side. The thumbnail should be in JPEG format and less than 200 kB in size. A thumbnail‘s width and height should not exceed 320. Ignored if the file is not uploaded using multipart/form-data. Thumbnails can’t be reused and can be only uploaded as a new file, so you can pass “attach://&lt;file_attach_name&gt;” if the thumbnail was uploaded using multipart/form-data under &lt;file_attach_name&gt;. <a href="#sending-files">More info on Sending Files »</a>
 * @property caption <em>Optional</em>. Caption of the video to be sent, 0-1024 characters
 * @property parse_mode <em>Optional</em>. Send <a href="#markdown-style"><em>Markdown</em></a> or <a href="#html-style"><em>HTML</em></a>, if you want Telegram apps to show <a href="#formatting-options">bold, italic, fixed-width text or inline URLs</a> in the media caption.
 * @property width <em>Optional</em>. Video width
 * @property height <em>Optional</em>. Video height
 * @property duration <em>Optional</em>. Video duration
 * @property supports_streaming <em>Optional</em>. Pass <em>True</em>, if the uploaded video is suitable for streaming
 *
 * @constructor Creates a: InputMediaVideo.
 * */
@Serializable
data class InputMediaVideo(
    val type: String,
    val media: String,
    val thumb: Any? = null,
    val caption: String? = null,
    val parse_mode: String? = null,
    val width: Int? = null,
    val height: Int? = null,
    val duration: Int? = null,
    val supports_streaming: Boolean? = null
) : InputMedia()

/**
 * <p>Represents an animation file (GIF or H.264/MPEG-4 AVC video without sound) to be sent.</p>
 *
 * @property type Type of the result, must be <em>animation</em>
 * @property media File to send. Pass a file_id to send a file that exists on the Telegram servers (recommended), pass an HTTP URL for Telegram to get a file from the Internet, or pass “attach://&lt;file_attach_name&gt;” to upload a new one using multipart/form-data under &lt;file_attach_name&gt; name. <a href="#sending-files">More info on Sending Files »</a>
 * @property thumb <em>Optional</em>. Thumbnail of the file sent; can be ignored if thumbnail generation for the file is supported server-side. The thumbnail should be in JPEG format and less than 200 kB in size. A thumbnail‘s width and height should not exceed 320. Ignored if the file is not uploaded using multipart/form-data. Thumbnails can’t be reused and can be only uploaded as a new file, so you can pass “attach://&lt;file_attach_name&gt;” if the thumbnail was uploaded using multipart/form-data under &lt;file_attach_name&gt;. <a href="#sending-files">More info on Sending Files »</a>
 * @property caption <em>Optional</em>. Caption of the animation to be sent, 0-1024 characters
 * @property parse_mode <em>Optional</em>. Send <a href="#markdown-style"><em>Markdown</em></a> or <a href="#html-style"><em>HTML</em></a>, if you want Telegram apps to show <a href="#formatting-options">bold, italic, fixed-width text or inline URLs</a> in the media caption.
 * @property width <em>Optional</em>. Animation width
 * @property height <em>Optional</em>. Animation height
 * @property duration <em>Optional</em>. Animation duration
 *
 * @constructor Creates a: InputMediaAnimation.
 * */
@Serializable
data class InputMediaAnimation(
    val type: String,
    val media: String,
    val thumb: Any? = null,
    val caption: String? = null,
    val parse_mode: String? = null,
    val width: Int? = null,
    val height: Int? = null,
    val duration: Int? = null
) : InputMedia()

/**
 * <p>Represents an audio file to be treated as music to be sent.</p>
 *
 * @property type Type of the result, must be <em>audio</em>
 * @property media File to send. Pass a file_id to send a file that exists on the Telegram servers (recommended), pass an HTTP URL for Telegram to get a file from the Internet, or pass “attach://&lt;file_attach_name&gt;” to upload a new one using multipart/form-data under &lt;file_attach_name&gt; name. <a href="#sending-files">More info on Sending Files »</a>
 * @property thumb <em>Optional</em>. Thumbnail of the file sent; can be ignored if thumbnail generation for the file is supported server-side. The thumbnail should be in JPEG format and less than 200 kB in size. A thumbnail‘s width and height should not exceed 320. Ignored if the file is not uploaded using multipart/form-data. Thumbnails can’t be reused and can be only uploaded as a new file, so you can pass “attach://&lt;file_attach_name&gt;” if the thumbnail was uploaded using multipart/form-data under &lt;file_attach_name&gt;. <a href="#sending-files">More info on Sending Files »</a>
 * @property caption <em>Optional</em>. Caption of the audio to be sent, 0-1024 characters
 * @property parse_mode <em>Optional</em>. Send <a href="#markdown-style"><em>Markdown</em></a> or <a href="#html-style"><em>HTML</em></a>, if you want Telegram apps to show <a href="#formatting-options">bold, italic, fixed-width text or inline URLs</a> in the media caption.
 * @property duration <em>Optional</em>. Duration of the audio in seconds
 * @property performer <em>Optional</em>. Performer of the audio
 * @property title <em>Optional</em>. Title of the audio
 *
 * @constructor Creates a: InputMediaAudio.
 * */
@Serializable
data class InputMediaAudio(
    val type: String,
    val media: String,
    val thumb: Any? = null,
    val caption: String? = null,
    val parse_mode: String? = null,
    val duration: Int? = null,
    val performer: String? = null,
    val title: String? = null
) : InputMedia()

/**
 * <p>Represents a general file to be sent.</p>
 *
 * @property type Type of the result, must be <em>document</em>
 * @property media File to send. Pass a file_id to send a file that exists on the Telegram servers (recommended), pass an HTTP URL for Telegram to get a file from the Internet, or pass “attach://&lt;file_attach_name&gt;” to upload a new one using multipart/form-data under &lt;file_attach_name&gt; name. <a href="#sending-files">More info on Sending Files »</a>
 * @property thumb <em>Optional</em>. Thumbnail of the file sent; can be ignored if thumbnail generation for the file is supported server-side. The thumbnail should be in JPEG format and less than 200 kB in size. A thumbnail‘s width and height should not exceed 320. Ignored if the file is not uploaded using multipart/form-data. Thumbnails can’t be reused and can be only uploaded as a new file, so you can pass “attach://&lt;file_attach_name&gt;” if the thumbnail was uploaded using multipart/form-data under &lt;file_attach_name&gt;. <a href="#sending-files">More info on Sending Files »</a>
 * @property caption <em>Optional</em>. Caption of the document to be sent, 0-1024 characters
 * @property parse_mode <em>Optional</em>. Send <a href="#markdown-style"><em>Markdown</em></a> or <a href="#html-style"><em>HTML</em></a>, if you want Telegram apps to show <a href="#formatting-options">bold, italic, fixed-width text or inline URLs</a> in the media caption.
 *
 * @constructor Creates a: InputMediaDocument.
 * */
@Serializable
data class InputMediaDocument(
    val type: String,
    val media: String,
    val thumb: Any? = null,
    val caption: String? = null,
    val parse_mode: String? = null
) : InputMedia()


// Stickers

/**
 * <p>This object represents a sticker.</p>
 *
 * @property file_id Unique identifier for this file
 * @property width Sticker width
 * @property height Sticker height
 * @property thumb <em>Optional</em>. Sticker thumbnail in the .webp or .jpg format
 * @property emoji <em>Optional</em>. Emoji associated with the sticker
 * @property set_name <em>Optional</em>. Name of the sticker set to which the sticker belongs
 * @property mask_position <em>Optional</em>. For mask stickers, the position where the mask should be placed
 * @property file_size <em>Optional</em>. File size
 *
 * @constructor Creates a: Sticker.
 * */
@Serializable
data class Sticker(
    val file_id: String,
    val width: Int,
    val height: Int,
    val thumb: PhotoSize? = null,
    val emoji: String? = null,
    val set_name: String? = null,
    val mask_position: MaskPosition? = null,
    val file_size: Int? = null
) : TelegramModel()

/**
 * <p>This object represents a sticker set.</p>
 *
 * @property name Sticker set name
 * @property title Sticker set title
 * @property contains_masks <em>True</em>, if the sticker set contains masks
 * @property stickers List of all set stickers
 *
 * @constructor Creates a: StickerSet.
 * */
@Serializable
data class StickerSet(
    val name: String,
    val title: String,
    val contains_masks: Boolean,
    val stickers: List<Sticker>
) : TelegramModel()

/**
 * <p>This object describes the position on faces where a mask should be placed by default.</p>
 *
 * @property point The part of the face relative to which the mask should be placed. One of “forehead”, “eyes”, “mouth”, or “chin”.
 * @property x_shift Shift by X-axis measured in widths of the mask scaled to the face size, from left to right. For example, choosing -1.0 will place mask just to the left of the default mask position.
 * @property y_shift Shift by Y-axis measured in heights of the mask scaled to the face size, from top to bottom. For example, 1.0 will place the mask just below the default mask position.
 * @property scale Mask scaling coefficient. For example, 2.0 means double size.
 *
 * @constructor Creates a: MaskPosition.
 * */
@Serializable
data class MaskPosition(
    val point: String,
    val x_shift: Float,
    val y_shift: Float,
    val scale: Float
) : TelegramModel()


// Inline mode

/**
 * <p>This object represents an incoming inline query. When the user sends an empty query, your bot could return some default or trending results.</p>
 *
 * @property id Unique identifier for this query
 * @property from Sender
 * @property location <em>Optional</em>. Sender location, only for bots that request user location
 * @property query Text of the query (up to 512 characters)
 * @property offset Offset of the results to be returned, can be controlled by the bot
 *
 * @constructor Creates a: InlineQuery.
 * */
@Serializable
data class InlineQuery(
    val id: String,
    val from: User,
    val location: Location? = null,
    val query: String,
    val offset: String
) : TelegramModel()

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
 * @constructor Creates a: InlineQueryResultArticle.
 * */
@Serializable
data class InlineQueryResultArticle(
    val type: String,
    val id: String,
    val title: String,
    val input_message_content: InputMessageContent,
    val reply_markup: InlineKeyboardMarkup? = null,
    val url: String? = null,
    val hide_url: Boolean? = null,
    val description: String? = null,
    val thumb_url: String? = null,
    val thumb_width: Int? = null,
    val thumb_height: Int? = null
) : InlineQueryResult()

/**
 * <p>Represents a link to a photo. By default, this photo will be sent by the user with optional caption. Alternatively, you can use <em>input_message_content</em> to send a message with the specified content instead of the photo.</p>
 *
 * @property type Type of the result, must be <em>photo</em>
 * @property id Unique identifier for this result, 1-64 bytes
 * @property photo_url A valid URL of the photo. Photo must be in <strong>jpeg</strong> format. Photo size must not exceed 5MB
 * @property thumb_url URL of the thumbnail for the photo
 * @property photo_width <em>Optional</em>. Width of the photo
 * @property photo_height <em>Optional</em>. Height of the photo
 * @property title <em>Optional</em>. Title for the result
 * @property description <em>Optional</em>. Short description of the result
 * @property caption <em>Optional</em>. Caption of the photo to be sent, 0-1024 characters
 * @property parse_mode <em>Optional</em>. Send <a href="#markdown-style"><em>Markdown</em></a> or <a href="#html-style"><em>HTML</em></a>, if you want Telegram apps to show <a href="#formatting-options">bold, italic, fixed-width text or inline URLs</a> in the media caption.
 * @property reply_markup <em>Optional</em>. <a href="/bots#inline-keyboards-and-on-the-fly-updating">Inline keyboard</a> attached to the message
 * @property input_message_content <em>Optional</em>. Content of the message to be sent instead of the photo
 *
 * @constructor Creates a: InlineQueryResultPhoto.
 * */
@Serializable
data class InlineQueryResultPhoto(
    val type: String,
    val id: String,
    val photo_url: String,
    val thumb_url: String,
    val photo_width: Int? = null,
    val photo_height: Int? = null,
    val title: String? = null,
    val description: String? = null,
    val caption: String? = null,
    val parse_mode: String? = null,
    val reply_markup: InlineKeyboardMarkup? = null,
    val input_message_content: InputMessageContent? = null
) : InlineQueryResult()

/**
 * <p>Represents a link to an animated GIF file. By default, this animated GIF file will be sent by the user with optional caption. Alternatively, you can use <em>input_message_content</em> to send a message with the specified content instead of the animation.</p>
 *
 * @property type Type of the result, must be <em>gif</em>
 * @property id Unique identifier for this result, 1-64 bytes
 * @property gif_url A valid URL for the GIF file. File size must not exceed 1MB
 * @property gif_width <em>Optional</em>. Width of the GIF
 * @property gif_height <em>Optional</em>. Height of the GIF
 * @property gif_duration <em>Optional</em>. Duration of the GIF
 * @property thumb_url URL of the static thumbnail for the result (jpeg or gif)
 * @property title <em>Optional</em>. Title for the result
 * @property caption <em>Optional</em>. Caption of the GIF file to be sent, 0-1024 characters
 * @property parse_mode <em>Optional</em>. Send <a href="#markdown-style"><em>Markdown</em></a> or <a href="#html-style"><em>HTML</em></a>, if you want Telegram apps to show <a href="#formatting-options">bold, italic, fixed-width text or inline URLs</a> in the media caption.
 * @property reply_markup <em>Optional</em>. <a href="/bots#inline-keyboards-and-on-the-fly-updating">Inline keyboard</a> attached to the message
 * @property input_message_content <em>Optional</em>. Content of the message to be sent instead of the GIF animation
 *
 * @constructor Creates a: InlineQueryResultGif.
 * */
@Serializable
data class InlineQueryResultGif(
    val type: String,
    val id: String,
    val gif_url: String,
    val gif_width: Int? = null,
    val gif_height: Int? = null,
    val gif_duration: Int? = null,
    val thumb_url: String,
    val title: String? = null,
    val caption: String? = null,
    val parse_mode: String? = null,
    val reply_markup: InlineKeyboardMarkup? = null,
    val input_message_content: InputMessageContent? = null
) : InlineQueryResult()

/**
 * <p>Represents a link to a video animation (H.264/MPEG-4 AVC video without sound). By default, this animated MPEG-4 file will be sent by the user with optional caption. Alternatively, you can use <em>input_message_content</em> to send a message with the specified content instead of the animation.</p>
 *
 * @property type Type of the result, must be <em>mpeg4_gif</em>
 * @property id Unique identifier for this result, 1-64 bytes
 * @property mpeg4_url A valid URL for the MP4 file. File size must not exceed 1MB
 * @property mpeg4_width <em>Optional</em>. Video width
 * @property mpeg4_height <em>Optional</em>. Video height
 * @property mpeg4_duration <em>Optional</em>. Video duration
 * @property thumb_url URL of the static thumbnail (jpeg or gif) for the result
 * @property title <em>Optional</em>. Title for the result
 * @property caption <em>Optional</em>. Caption of the MPEG-4 file to be sent, 0-1024 characters
 * @property parse_mode <em>Optional</em>. Send <a href="#markdown-style"><em>Markdown</em></a> or <a href="#html-style"><em>HTML</em></a>, if you want Telegram apps to show <a href="#formatting-options">bold, italic, fixed-width text or inline URLs</a> in the media caption.
 * @property reply_markup <em>Optional</em>. <a href="/bots#inline-keyboards-and-on-the-fly-updating">Inline keyboard</a> attached to the message
 * @property input_message_content <em>Optional</em>. Content of the message to be sent instead of the video animation
 *
 * @constructor Creates a: InlineQueryResultMpeg4Gif.
 * */
@Serializable
data class InlineQueryResultMpeg4Gif(
    val type: String,
    val id: String,
    val mpeg4_url: String,
    val mpeg4_width: Int? = null,
    val mpeg4_height: Int? = null,
    val mpeg4_duration: Int? = null,
    val thumb_url: String,
    val title: String? = null,
    val caption: String? = null,
    val parse_mode: String? = null,
    val reply_markup: InlineKeyboardMarkup? = null,
    val input_message_content: InputMessageContent? = null
) : InlineQueryResult()

/**
 * <p>Represents a link to a page containing an embedded video player or a video file. By default, this video file will be sent by the user with an optional caption. Alternatively, you can use <em>input_message_content</em> to send a message with the specified content instead of the video.</p><blockquote>
<p>If an InlineQueryResultVideo message contains an embedded video (e.g., YouTube), you <strong>must</strong> replace its content using <em>input_message_content</em>.</p>
</blockquote>
 *
 * @property type Type of the result, must be <em>video</em>
 * @property id Unique identifier for this result, 1-64 bytes
 * @property video_url A valid URL for the embedded video player or video file
 * @property mime_type Mime type of the content of video url, “text/html” or “video/mp4”
 * @property thumb_url URL of the thumbnail (jpeg only) for the video
 * @property title Title for the result
 * @property caption <em>Optional</em>. Caption of the video to be sent, 0-1024 characters
 * @property parse_mode <em>Optional</em>. Send <a href="#markdown-style"><em>Markdown</em></a> or <a href="#html-style"><em>HTML</em></a>, if you want Telegram apps to show <a href="#formatting-options">bold, italic, fixed-width text or inline URLs</a> in the media caption.
 * @property video_width <em>Optional</em>. Video width
 * @property video_height <em>Optional</em>. Video height
 * @property video_duration <em>Optional</em>. Video duration in seconds
 * @property description <em>Optional</em>. Short description of the result
 * @property reply_markup <em>Optional</em>. <a href="/bots#inline-keyboards-and-on-the-fly-updating">Inline keyboard</a> attached to the message
 * @property input_message_content <em>Optional</em>. Content of the message to be sent instead of the video. This field is <strong>required</strong> if InlineQueryResultVideo is used to send an HTML-page as a result (e.g., a YouTube video).
 *
 * @constructor Creates a: InlineQueryResultVideo.
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
    val parse_mode: String? = null,
    val video_width: Int? = null,
    val video_height: Int? = null,
    val video_duration: Int? = null,
    val description: String? = null,
    val reply_markup: InlineKeyboardMarkup? = null,
    val input_message_content: InputMessageContent? = null
) : InlineQueryResult()

/**
 * <p>Represents a link to an mp3 audio file. By default, this audio file will be sent by the user. Alternatively, you can use <em>input_message_content</em> to send a message with the specified content instead of the audio.</p><p><strong>Note:</strong> This will only work in Telegram versions released after 9 April, 2016. Older clients will ignore them.</p>
 *
 * @property type Type of the result, must be <em>audio</em>
 * @property id Unique identifier for this result, 1-64 bytes
 * @property audio_url A valid URL for the audio file
 * @property title Title
 * @property caption <em>Optional</em>. Caption, 0-1024 characters
 * @property parse_mode <em>Optional</em>. Send <a href="#markdown-style"><em>Markdown</em></a> or <a href="#html-style"><em>HTML</em></a>, if you want Telegram apps to show <a href="#formatting-options">bold, italic, fixed-width text or inline URLs</a> in the media caption.
 * @property performer <em>Optional</em>. Performer
 * @property audio_duration <em>Optional</em>. Audio duration in seconds
 * @property reply_markup <em>Optional</em>. <a href="/bots#inline-keyboards-and-on-the-fly-updating">Inline keyboard</a> attached to the message
 * @property input_message_content <em>Optional</em>. Content of the message to be sent instead of the audio
 *
 * @constructor Creates a: InlineQueryResultAudio.
 * */
@Serializable
data class InlineQueryResultAudio(
    val type: String,
    val id: String,
    val audio_url: String,
    val title: String,
    val caption: String? = null,
    val parse_mode: String? = null,
    val performer: String? = null,
    val audio_duration: Int? = null,
    val reply_markup: InlineKeyboardMarkup? = null,
    val input_message_content: InputMessageContent? = null
) : InlineQueryResult()

/**
 * <p>Represents a link to a voice recording in an .ogg container encoded with OPUS. By default, this voice recording will be sent by the user. Alternatively, you can use <em>input_message_content</em> to send a message with the specified content instead of the the voice message.</p><p><strong>Note:</strong> This will only work in Telegram versions released after 9 April, 2016. Older clients will ignore them.</p>
 *
 * @property type Type of the result, must be <em>voice</em>
 * @property id Unique identifier for this result, 1-64 bytes
 * @property voice_url A valid URL for the voice recording
 * @property title Recording title
 * @property caption <em>Optional</em>. Caption, 0-1024 characters
 * @property parse_mode <em>Optional</em>. Send <a href="#markdown-style"><em>Markdown</em></a> or <a href="#html-style"><em>HTML</em></a>, if you want Telegram apps to show <a href="#formatting-options">bold, italic, fixed-width text or inline URLs</a> in the media caption.
 * @property voice_duration <em>Optional</em>. Recording duration in seconds
 * @property reply_markup <em>Optional</em>. <a href="/bots#inline-keyboards-and-on-the-fly-updating">Inline keyboard</a> attached to the message
 * @property input_message_content <em>Optional</em>. Content of the message to be sent instead of the voice recording
 *
 * @constructor Creates a: InlineQueryResultVoice.
 * */
@Serializable
data class InlineQueryResultVoice(
    val type: String,
    val id: String,
    val voice_url: String,
    val title: String,
    val caption: String? = null,
    val parse_mode: String? = null,
    val voice_duration: Int? = null,
    val reply_markup: InlineKeyboardMarkup? = null,
    val input_message_content: InputMessageContent? = null
) : InlineQueryResult()

/**
 * <p>Represents a link to a file. By default, this file will be sent by the user with an optional caption. Alternatively, you can use <em>input_message_content</em> to send a message with the specified content instead of the file. Currently, only <strong>.PDF</strong> and <strong>.ZIP</strong> files can be sent using this method.</p><p><strong>Note:</strong> This will only work in Telegram versions released after 9 April, 2016. Older clients will ignore them.</p>
 *
 * @property type Type of the result, must be <em>document</em>
 * @property id Unique identifier for this result, 1-64 bytes
 * @property title Title for the result
 * @property caption <em>Optional</em>. Caption of the document to be sent, 0-1024 characters
 * @property parse_mode <em>Optional</em>. Send <a href="#markdown-style"><em>Markdown</em></a> or <a href="#html-style"><em>HTML</em></a>, if you want Telegram apps to show <a href="#formatting-options">bold, italic, fixed-width text or inline URLs</a> in the media caption.
 * @property document_url A valid URL for the file
 * @property mime_type Mime type of the content of the file, either “application/pdf” or “application/zip”
 * @property description <em>Optional</em>. Short description of the result
 * @property reply_markup <em>Optional</em>. Inline keyboard attached to the message
 * @property input_message_content <em>Optional</em>. Content of the message to be sent instead of the file
 * @property thumb_url <em>Optional</em>. URL of the thumbnail (jpeg only) for the file
 * @property thumb_width <em>Optional</em>. Thumbnail width
 * @property thumb_height <em>Optional</em>. Thumbnail height
 *
 * @constructor Creates a: InlineQueryResultDocument.
 * */
@Serializable
data class InlineQueryResultDocument(
    val type: String,
    val id: String,
    val title: String,
    val caption: String? = null,
    val parse_mode: String? = null,
    val document_url: String,
    val mime_type: String,
    val description: String? = null,
    val reply_markup: InlineKeyboardMarkup? = null,
    val input_message_content: InputMessageContent? = null,
    val thumb_url: String? = null,
    val thumb_width: Int? = null,
    val thumb_height: Int? = null
) : InlineQueryResult()

/**
 * <p>Represents a location on a map. By default, the location will be sent by the user. Alternatively, you can use <em>input_message_content</em> to send a message with the specified content instead of the location.</p><p><strong>Note:</strong> This will only work in Telegram versions released after 9 April, 2016. Older clients will ignore them.</p>
 *
 * @property type Type of the result, must be <em>location</em>
 * @property id Unique identifier for this result, 1-64 Bytes
 * @property latitude Location latitude in degrees
 * @property longitude Location longitude in degrees
 * @property title Location title
 * @property live_period <em>Optional</em>. Period in seconds for which the location can be updated, should be between 60 and 86400.
 * @property reply_markup <em>Optional</em>. <a href="/bots#inline-keyboards-and-on-the-fly-updating">Inline keyboard</a> attached to the message
 * @property input_message_content <em>Optional</em>. Content of the message to be sent instead of the location
 * @property thumb_url <em>Optional</em>. Url of the thumbnail for the result
 * @property thumb_width <em>Optional</em>. Thumbnail width
 * @property thumb_height <em>Optional</em>. Thumbnail height
 *
 * @constructor Creates a: InlineQueryResultLocation.
 * */
@Serializable
data class InlineQueryResultLocation(
    val type: String,
    val id: String,
    val latitude: Float,
    val longitude: Float,
    val title: String,
    val live_period: Int? = null,
    val reply_markup: InlineKeyboardMarkup? = null,
    val input_message_content: InputMessageContent? = null,
    val thumb_url: String? = null,
    val thumb_width: Int? = null,
    val thumb_height: Int? = null
) : InlineQueryResult()

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
 * @property reply_markup <em>Optional</em>. <a href="/bots#inline-keyboards-and-on-the-fly-updating">Inline keyboard</a> attached to the message
 * @property input_message_content <em>Optional</em>. Content of the message to be sent instead of the venue
 * @property thumb_url <em>Optional</em>. Url of the thumbnail for the result
 * @property thumb_width <em>Optional</em>. Thumbnail width
 * @property thumb_height <em>Optional</em>. Thumbnail height
 *
 * @constructor Creates a: InlineQueryResultVenue.
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
    val reply_markup: InlineKeyboardMarkup? = null,
    val input_message_content: InputMessageContent? = null,
    val thumb_url: String? = null,
    val thumb_width: Int? = null,
    val thumb_height: Int? = null
) : InlineQueryResult()

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
 * @constructor Creates a: InlineQueryResultContact.
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
    val input_message_content: InputMessageContent? = null,
    val thumb_url: String? = null,
    val thumb_width: Int? = null,
    val thumb_height: Int? = null
) : InlineQueryResult()

/**
 * <p>Represents a <a href="#games">Game</a>.</p><p><strong>Note:</strong> This will only work in Telegram versions released after October 1, 2016. Older clients will not display any inline results if a game result is among them.</p>
 *
 * @property type Type of the result, must be <em>game</em>
 * @property id Unique identifier for this result, 1-64 bytes
 * @property game_short_name Short name of the game
 * @property reply_markup <em>Optional</em>. <a href="/bots#inline-keyboards-and-on-the-fly-updating">Inline keyboard</a> attached to the message
 *
 * @constructor Creates a: InlineQueryResultGame.
 * */
@Serializable
data class InlineQueryResultGame(
    val type: String,
    val id: String,
    val game_short_name: String,
    val reply_markup: InlineKeyboardMarkup? = null
) : InlineQueryResult()

/**
 * <p>Represents a link to a photo stored on the Telegram servers. By default, this photo will be sent by the user with an optional caption. Alternatively, you can use <em>input_message_content</em> to send a message with the specified content instead of the photo.</p>
 *
 * @property type Type of the result, must be <em>photo</em>
 * @property id Unique identifier for this result, 1-64 bytes
 * @property photo_file_id A valid file identifier of the photo
 * @property title <em>Optional</em>. Title for the result
 * @property description <em>Optional</em>. Short description of the result
 * @property caption <em>Optional</em>. Caption of the photo to be sent, 0-1024 characters
 * @property parse_mode <em>Optional</em>. Send <a href="#markdown-style"><em>Markdown</em></a> or <a href="#html-style"><em>HTML</em></a>, if you want Telegram apps to show <a href="#formatting-options">bold, italic, fixed-width text or inline URLs</a> in the media caption.
 * @property reply_markup <em>Optional</em>. <a href="/bots#inline-keyboards-and-on-the-fly-updating">Inline keyboard</a> attached to the message
 * @property input_message_content <em>Optional</em>. Content of the message to be sent instead of the photo
 *
 * @constructor Creates a: InlineQueryResultCachedPhoto.
 * */
@Serializable
data class InlineQueryResultCachedPhoto(
    val type: String,
    val id: String,
    val photo_file_id: String,
    val title: String? = null,
    val description: String? = null,
    val caption: String? = null,
    val parse_mode: String? = null,
    val reply_markup: InlineKeyboardMarkup? = null,
    val input_message_content: InputMessageContent? = null
) : InlineQueryResult()

/**
 * <p>Represents a link to an animated GIF file stored on the Telegram servers. By default, this animated GIF file will be sent by the user with an optional caption. Alternatively, you can use <em>input_message_content</em> to send a message with specified content instead of the animation.</p>
 *
 * @property type Type of the result, must be <em>gif</em>
 * @property id Unique identifier for this result, 1-64 bytes
 * @property gif_file_id A valid file identifier for the GIF file
 * @property title <em>Optional</em>. Title for the result
 * @property caption <em>Optional</em>. Caption of the GIF file to be sent, 0-1024 characters
 * @property parse_mode <em>Optional</em>. Send <a href="#markdown-style"><em>Markdown</em></a> or <a href="#html-style"><em>HTML</em></a>, if you want Telegram apps to show <a href="#formatting-options">bold, italic, fixed-width text or inline URLs</a> in the media caption.
 * @property reply_markup <em>Optional</em>. <a href="/bots#inline-keyboards-and-on-the-fly-updating">Inline keyboard</a> attached to the message
 * @property input_message_content <em>Optional</em>. Content of the message to be sent instead of the GIF animation
 *
 * @constructor Creates a: InlineQueryResultCachedGif.
 * */
@Serializable
data class InlineQueryResultCachedGif(
    val type: String,
    val id: String,
    val gif_file_id: String,
    val title: String? = null,
    val caption: String? = null,
    val parse_mode: String? = null,
    val reply_markup: InlineKeyboardMarkup? = null,
    val input_message_content: InputMessageContent? = null
) : InlineQueryResult()

/**
 * <p>Represents a link to a video animation (H.264/MPEG-4 AVC video without sound) stored on the Telegram servers. By default, this animated MPEG-4 file will be sent by the user with an optional caption. Alternatively, you can use <em>input_message_content</em> to send a message with the specified content instead of the animation.</p>
 *
 * @property type Type of the result, must be <em>mpeg4_gif</em>
 * @property id Unique identifier for this result, 1-64 bytes
 * @property mpeg4_file_id A valid file identifier for the MP4 file
 * @property title <em>Optional</em>. Title for the result
 * @property caption <em>Optional</em>. Caption of the MPEG-4 file to be sent, 0-1024 characters
 * @property parse_mode <em>Optional</em>. Send <a href="#markdown-style"><em>Markdown</em></a> or <a href="#html-style"><em>HTML</em></a>, if you want Telegram apps to show <a href="#formatting-options">bold, italic, fixed-width text or inline URLs</a> in the media caption.
 * @property reply_markup <em>Optional</em>. <a href="/bots#inline-keyboards-and-on-the-fly-updating">Inline keyboard</a> attached to the message
 * @property input_message_content <em>Optional</em>. Content of the message to be sent instead of the video animation
 *
 * @constructor Creates a: InlineQueryResultCachedMpeg4Gif.
 * */
@Serializable
data class InlineQueryResultCachedMpeg4Gif(
    val type: String,
    val id: String,
    val mpeg4_file_id: String,
    val title: String? = null,
    val caption: String? = null,
    val parse_mode: String? = null,
    val reply_markup: InlineKeyboardMarkup? = null,
    val input_message_content: InputMessageContent? = null
) : InlineQueryResult()

/**
 * <p>Represents a link to a sticker stored on the Telegram servers. By default, this sticker will be sent by the user. Alternatively, you can use <em>input_message_content</em> to send a message with the specified content instead of the sticker.</p><p><strong>Note:</strong> This will only work in Telegram versions released after 9 April, 2016. Older clients will ignore them.</p>
 *
 * @property type Type of the result, must be <em>sticker</em>
 * @property id Unique identifier for this result, 1-64 bytes
 * @property sticker_file_id A valid file identifier of the sticker
 * @property reply_markup <em>Optional</em>. <a href="/bots#inline-keyboards-and-on-the-fly-updating">Inline keyboard</a> attached to the message
 * @property input_message_content <em>Optional</em>. Content of the message to be sent instead of the sticker
 *
 * @constructor Creates a: InlineQueryResultCachedSticker.
 * */
@Serializable
data class InlineQueryResultCachedSticker(
    val type: String,
    val id: String,
    val sticker_file_id: String,
    val reply_markup: InlineKeyboardMarkup? = null,
    val input_message_content: InputMessageContent? = null
) : InlineQueryResult()

/**
 * <p>Represents a link to a file stored on the Telegram servers. By default, this file will be sent by the user with an optional caption. Alternatively, you can use <em>input_message_content</em> to send a message with the specified content instead of the file.</p><p><strong>Note:</strong> This will only work in Telegram versions released after 9 April, 2016. Older clients will ignore them.</p>
 *
 * @property type Type of the result, must be <em>document</em>
 * @property id Unique identifier for this result, 1-64 bytes
 * @property title Title for the result
 * @property document_file_id A valid file identifier for the file
 * @property description <em>Optional</em>. Short description of the result
 * @property caption <em>Optional</em>. Caption of the document to be sent, 0-1024 characters
 * @property parse_mode <em>Optional</em>. Send <a href="#markdown-style"><em>Markdown</em></a> or <a href="#html-style"><em>HTML</em></a>, if you want Telegram apps to show <a href="#formatting-options">bold, italic, fixed-width text or inline URLs</a> in the media caption.
 * @property reply_markup <em>Optional</em>. <a href="/bots#inline-keyboards-and-on-the-fly-updating">Inline keyboard</a> attached to the message
 * @property input_message_content <em>Optional</em>. Content of the message to be sent instead of the file
 *
 * @constructor Creates a: InlineQueryResultCachedDocument.
 * */
@Serializable
data class InlineQueryResultCachedDocument(
    val type: String,
    val id: String,
    val title: String,
    val document_file_id: String,
    val description: String? = null,
    val caption: String? = null,
    val parse_mode: String? = null,
    val reply_markup: InlineKeyboardMarkup? = null,
    val input_message_content: InputMessageContent? = null
) : InlineQueryResult()

/**
 * <p>Represents a link to a video file stored on the Telegram servers. By default, this video file will be sent by the user with an optional caption. Alternatively, you can use <em>input_message_content</em> to send a message with the specified content instead of the video.</p>
 *
 * @property type Type of the result, must be <em>video</em>
 * @property id Unique identifier for this result, 1-64 bytes
 * @property video_file_id A valid file identifier for the video file
 * @property title Title for the result
 * @property description <em>Optional</em>. Short description of the result
 * @property caption <em>Optional</em>. Caption of the video to be sent, 0-1024 characters
 * @property parse_mode <em>Optional</em>. Send <a href="#markdown-style"><em>Markdown</em></a> or <a href="#html-style"><em>HTML</em></a>, if you want Telegram apps to show <a href="#formatting-options">bold, italic, fixed-width text or inline URLs</a> in the media caption.
 * @property reply_markup <em>Optional</em>. <a href="/bots#inline-keyboards-and-on-the-fly-updating">Inline keyboard</a> attached to the message
 * @property input_message_content <em>Optional</em>. Content of the message to be sent instead of the video
 *
 * @constructor Creates a: InlineQueryResultCachedVideo.
 * */
@Serializable
data class InlineQueryResultCachedVideo(
    val type: String,
    val id: String,
    val video_file_id: String,
    val title: String,
    val description: String? = null,
    val caption: String? = null,
    val parse_mode: String? = null,
    val reply_markup: InlineKeyboardMarkup? = null,
    val input_message_content: InputMessageContent? = null
) : InlineQueryResult()

/**
 * <p>Represents a link to a voice message stored on the Telegram servers. By default, this voice message will be sent by the user. Alternatively, you can use <em>input_message_content</em> to send a message with the specified content instead of the voice message.</p><p><strong>Note:</strong> This will only work in Telegram versions released after 9 April, 2016. Older clients will ignore them.</p>
 *
 * @property type Type of the result, must be <em>voice</em>
 * @property id Unique identifier for this result, 1-64 bytes
 * @property voice_file_id A valid file identifier for the voice message
 * @property title Voice message title
 * @property caption <em>Optional</em>. Caption, 0-1024 characters
 * @property parse_mode <em>Optional</em>. Send <a href="#markdown-style"><em>Markdown</em></a> or <a href="#html-style"><em>HTML</em></a>, if you want Telegram apps to show <a href="#formatting-options">bold, italic, fixed-width text or inline URLs</a> in the media caption.
 * @property reply_markup <em>Optional</em>. <a href="/bots#inline-keyboards-and-on-the-fly-updating">Inline keyboard</a> attached to the message
 * @property input_message_content <em>Optional</em>. Content of the message to be sent instead of the voice message
 *
 * @constructor Creates a: InlineQueryResultCachedVoice.
 * */
@Serializable
data class InlineQueryResultCachedVoice(
    val type: String,
    val id: String,
    val voice_file_id: String,
    val title: String,
    val caption: String? = null,
    val parse_mode: String? = null,
    val reply_markup: InlineKeyboardMarkup? = null,
    val input_message_content: InputMessageContent? = null
) : InlineQueryResult()

/**
 * <p>Represents a link to an mp3 audio file stored on the Telegram servers. By default, this audio file will be sent by the user. Alternatively, you can use <em>input_message_content</em> to send a message with the specified content instead of the audio.</p><p><strong>Note:</strong> This will only work in Telegram versions released after 9 April, 2016. Older clients will ignore them.</p>
 *
 * @property type Type of the result, must be <em>audio</em>
 * @property id Unique identifier for this result, 1-64 bytes
 * @property audio_file_id A valid file identifier for the audio file
 * @property caption <em>Optional</em>. Caption, 0-1024 characters
 * @property parse_mode <em>Optional</em>. Send <a href="#markdown-style"><em>Markdown</em></a> or <a href="#html-style"><em>HTML</em></a>, if you want Telegram apps to show <a href="#formatting-options">bold, italic, fixed-width text or inline URLs</a> in the media caption.
 * @property reply_markup <em>Optional</em>. <a href="/bots#inline-keyboards-and-on-the-fly-updating">Inline keyboard</a> attached to the message
 * @property input_message_content <em>Optional</em>. Content of the message to be sent instead of the audio
 *
 * @constructor Creates a: InlineQueryResultCachedAudio.
 * */
@Serializable
data class InlineQueryResultCachedAudio(
    val type: String,
    val id: String,
    val audio_file_id: String,
    val caption: String? = null,
    val parse_mode: String? = null,
    val reply_markup: InlineKeyboardMarkup? = null,
    val input_message_content: InputMessageContent? = null
) : InlineQueryResult()

/**
 * <p>Represents the <a href="#inputmessagecontent">content</a> of a text message to be sent as the result of an inline query.</p>
 *
 * @property message_text Text of the message to be sent, 1-4096 characters
 * @property parse_mode <em>Optional</em>. Send <a href="#markdown-style"><em>Markdown</em></a> or <a href="#html-style"><em>HTML</em></a>, if you want Telegram apps to show <a href="#formatting-options">bold, italic, fixed-width text or inline URLs</a> in your bot's message.
 * @property disable_web_page_preview <em>Optional</em>. Disables link previews for links in the sent message
 *
 * @constructor Creates a: InputTextMessageContent.
 * */
@Serializable
data class InputTextMessageContent(
    val message_text: String,
    val parse_mode: String? = null,
    val disable_web_page_preview: Boolean? = null
) : TelegramModel()

/**
 * <p>Represents the <a href="#inputmessagecontent">content</a> of a location message to be sent as the result of an inline query.</p>
 *
 * @property latitude Latitude of the location in degrees
 * @property longitude Longitude of the location in degrees
 * @property live_period <em>Optional</em>. Period in seconds for which the location can be updated, should be between 60 and 86400.
 *
 * @constructor Creates a: InputLocationMessageContent.
 * */
@Serializable
data class InputLocationMessageContent(
    val latitude: Float,
    val longitude: Float,
    val live_period: Int? = null
) : TelegramModel()

/**
 * <p>Represents the <a href="#inputmessagecontent">content</a> of a venue message to be sent as the result of an inline query.</p>
 *
 * @property latitude Latitude of the venue in degrees
 * @property longitude Longitude of the venue in degrees
 * @property title Name of the venue
 * @property address Address of the venue
 * @property foursquare_id <em>Optional</em>. Foursquare identifier of the venue, if known
 * @property foursquare_type <em>Optional</em>. Foursquare type of the venue, if known. (For example, “arts_entertainment/default”, “arts_entertainment/aquarium” or “food/icecream”.)
 *
 * @constructor Creates a: InputVenueMessageContent.
 * */
@Serializable
data class InputVenueMessageContent(
    val latitude: Float,
    val longitude: Float,
    val title: String,
    val address: String,
    val foursquare_id: String? = null,
    val foursquare_type: String? = null
) : TelegramModel()

/**
 * <p>Represents the <a href="#inputmessagecontent">content</a> of a contact message to be sent as the result of an inline query.</p>
 *
 * @property phone_number Contact's phone number
 * @property first_name Contact's first name
 * @property last_name <em>Optional</em>. Contact's last name
 * @property vcard <em>Optional</em>. Additional data about the contact in the form of a <a href="https://en.wikipedia.org/wiki/VCard">vCard</a>, 0-2048 bytes
 *
 * @constructor Creates a: InputContactMessageContent.
 * */
@Serializable
data class InputContactMessageContent(
    val phone_number: String,
    val first_name: String,
    val last_name: String? = null,
    val vcard: String? = null
) : TelegramModel()

/**
 * <p>Represents a <a href="#inlinequeryresult">result</a> of an inline query that was chosen by the user and sent to their chat partner.</p><p><strong>Note:</strong> It is necessary to enable <a href="/bots/inline#collecting-feedback">inline feedback</a> via <a href="https://t.me/botfather">@Botfather</a> in order to receive these objects in updates.</p>
 *
 * @property result_id The unique identifier for the result that was chosen
 * @property from The user that chose the result
 * @property location <em>Optional</em>. Sender location, only for bots that require user location
 * @property inline_message_id <em>Optional</em>. Identifier of the sent inline message. Available only if there is an <a href="#inlinekeyboardmarkup">inline keyboard</a> attached to the message. Will be also received in <a href="#callbackquery">callback queries</a> and can be used to <a href="#updating-messages">edit</a> the message.
 * @property query The query that was used to obtain the result
 *
 * @constructor Creates a: ChosenInlineResult.
 * */
@Serializable
data class ChosenInlineResult(
    val result_id: String,
    val from: User,
    val location: Location? = null,
    val inline_message_id: String? = null,
    val query: String
) : TelegramModel()


// Payments

/**
 * <p>This object represents a portion of the price for goods or services.</p>
 *
 * @property label Portion label
 * @property amount Price of the product in the <em>smallest units</em> of the <a href="/bots/payments#supported-currencies">currency</a> (integer, <strong>not</strong> float/double). For example, for a price of <code>US$ 1.45</code> pass <code>amount = 145</code>. See the <em>exp</em> parameter in <a href="https://core.telegram.org/bots/payments/currencies.json">currencies.json</a>, it shows the number of digits past the decimal point for each currency (2 for the majority of currencies).
 *
 * @constructor Creates a: LabeledPrice.
 * */
@Serializable
data class LabeledPrice(
    val label: String,
    val amount: Int
) : TelegramModel()

/**
 * <p>This object contains basic information about an invoice.</p>
 *
 * @property title Product name
 * @property description Product description
 * @property start_parameter Unique bot deep-linking parameter that can be used to generate this invoice
 * @property currency Three-letter ISO 4217 <a href="/bots/payments#supported-currencies">currency</a> code
 * @property total_amount Total price in the <em>smallest units</em> of the currency (integer, <strong>not</strong> float/double). For example, for a price of <code>US$ 1.45</code> pass <code>amount = 145</code>. See the <em>exp</em> parameter in <a href="https://core.telegram.org/bots/payments/currencies.json">currencies.json</a>, it shows the number of digits past the decimal point for each currency (2 for the majority of currencies).
 *
 * @constructor Creates a: Invoice.
 * */
@Serializable
data class Invoice(
    val title: String,
    val description: String,
    val start_parameter: String,
    val currency: String,
    val total_amount: Int
) : TelegramModel()

/**
 * <p>This object represents a shipping address.</p>
 *
 * @property country_code ISO 3166-1 alpha-2 country code
 * @property state State, if applicable
 * @property city City
 * @property street_line1 First line for the address
 * @property street_line2 Second line for the address
 * @property post_code Address post code
 *
 * @constructor Creates a: ShippingAddress.
 * */
@Serializable
data class ShippingAddress(
    val country_code: String,
    val state: String,
    val city: String,
    val street_line1: String,
    val street_line2: String,
    val post_code: String
) : TelegramModel()

/**
 * <p>This object represents information about an order.</p>
 *
 * @property name <em>Optional</em>. User name
 * @property phone_number <em>Optional</em>. User's phone number
 * @property email <em>Optional</em>. User email
 * @property shipping_address <em>Optional</em>. User shipping address
 *
 * @constructor Creates a: OrderInfo.
 * */
@Serializable
data class OrderInfo(
    val name: String? = null,
    val phone_number: String? = null,
    val email: String? = null,
    val shipping_address: ShippingAddress? = null
) : TelegramModel()

/**
 * <p>This object represents one shipping option.</p>
 *
 * @property id Shipping option identifier
 * @property title Option title
 * @property prices List of price portions
 *
 * @constructor Creates a: ShippingOption.
 * */
@Serializable
data class ShippingOption(
    val id: String,
    val title: String,
    val prices: List<LabeledPrice>
) : TelegramModel()

/**
 * <p>This object contains basic information about a successful payment.</p>
 *
 * @property currency Three-letter ISO 4217 <a href="/bots/payments#supported-currencies">currency</a> code
 * @property total_amount Total price in the <em>smallest units</em> of the currency (integer, <strong>not</strong> float/double). For example, for a price of <code>US$ 1.45</code> pass <code>amount = 145</code>. See the <em>exp</em> parameter in <a href="https://core.telegram.org/bots/payments/currencies.json">currencies.json</a>, it shows the number of digits past the decimal point for each currency (2 for the majority of currencies).
 * @property invoice_payload Bot specified invoice payload
 * @property shipping_option_id <em>Optional</em>. Identifier of the shipping option chosen by the user
 * @property order_info <em>Optional</em>. Order info provided by the user
 * @property telegram_payment_charge_id Telegram payment identifier
 * @property provider_payment_charge_id Provider payment identifier
 *
 * @constructor Creates a: SuccessfulPayment.
 * */
@Serializable
data class SuccessfulPayment(
    val currency: String,
    val total_amount: Int,
    val invoice_payload: String,
    val shipping_option_id: String? = null,
    val order_info: OrderInfo? = null,
    val telegram_payment_charge_id: String,
    val provider_payment_charge_id: String
) : TelegramModel()

/**
 * <p>This object contains information about an incoming shipping query.</p>
 *
 * @property id Unique query identifier
 * @property from User who sent the query
 * @property invoice_payload Bot specified invoice payload
 * @property shipping_address User specified shipping address
 *
 * @constructor Creates a: ShippingQuery.
 * */
@Serializable
data class ShippingQuery(
    val id: String,
    val from: User,
    val invoice_payload: String,
    val shipping_address: ShippingAddress
) : TelegramModel()

/**
 * <p>This object contains information about an incoming pre-checkout query.</p>
 *
 * @property id Unique query identifier
 * @property from User who sent the query
 * @property currency Three-letter ISO 4217 <a href="/bots/payments#supported-currencies">currency</a> code
 * @property total_amount Total price in the <em>smallest units</em> of the currency (integer, <strong>not</strong> float/double). For example, for a price of <code>US$ 1.45</code> pass <code>amount = 145</code>. See the <em>exp</em> parameter in <a href="https://core.telegram.org/bots/payments/currencies.json">currencies.json</a>, it shows the number of digits past the decimal point for each currency (2 for the majority of currencies).
 * @property invoice_payload Bot specified invoice payload
 * @property shipping_option_id <em>Optional</em>. Identifier of the shipping option chosen by the user
 * @property order_info <em>Optional</em>. Order info provided by the user
 *
 * @constructor Creates a: PreCheckoutQuery.
 * */
@Serializable
data class PreCheckoutQuery(
    val id: String,
    val from: User,
    val currency: String,
    val total_amount: Int,
    val invoice_payload: String,
    val shipping_option_id: String? = null,
    val order_info: OrderInfo? = null
) : TelegramModel()


// Telegram Passport

/**
 * <p>Contains information about Telegram Passport data shared with the bot by the user.</p>
 *
 * @property data Array with information about documents and other Telegram Passport elements that was shared with the bot
 * @property credentials Encrypted credentials required to decrypt the data
 *
 * @constructor Creates a: PassportData.
 * */
@Serializable
data class PassportData(
    val data: List<EncryptedPassportElement>,
    val credentials: EncryptedCredentials
) : TelegramModel()

/**
 * <p>This object represents a file uploaded to Telegram Passport. Currently all Telegram Passport files are in JPEG format when decrypted and don't exceed 10MB.</p>
 *
 * @property file_id Unique identifier for this file
 * @property file_size File size
 * @property file_date Unix time when the file was uploaded
 *
 * @constructor Creates a: PassportFile.
 * */
@Serializable
data class PassportFile(
    val file_id: String,
    val file_size: Int,
    val file_date: Int
) : TelegramModel()

/**
 * <p>Contains information about documents or other Telegram Passport elements shared with the bot by the user.</p>
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
 * @constructor Creates a: EncryptedPassportElement.
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
    val hash: String
) : TelegramModel()

/**
 * <p>Contains data required for decrypting and authenticating <a href="#encryptedpassportelement">EncryptedPassportElement</a>. See the <a href="https://core.telegram.org/passport#receiving-information">Telegram Passport Documentation</a> for a complete description of the data decryption and authentication processes.</p>
 *
 * @property data Base64-encoded encrypted JSON-serialized data with unique user's payload, data hashes and secrets required for <a href="#encryptedpassportelement">EncryptedPassportElement</a> decryption and authentication
 * @property hash Base64-encoded data hash for data authentication
 * @property secret Base64-encoded secret, encrypted with the bot's public RSA key, required for data decryption
 *
 * @constructor Creates a: EncryptedCredentials.
 * */
@Serializable
data class EncryptedCredentials(
    val data: String,
    val hash: String,
    val secret: String
) : TelegramModel()

/**
 * <p>Represents an issue in one of the data fields that was provided by the user. The error is considered resolved when the field's value changes.</p>
 *
 * @property source Error source, must be <em>data</em>
 * @property type The section of the user's Telegram Passport which has the error, one of “personal_details”, “passport”, “driver_license”, “identity_card”, “internal_passport”, “address”
 * @property field_name Name of the data field which has the error
 * @property data_hash Base64-encoded data hash
 * @property message Error message
 *
 * @constructor Creates a: PassportElementErrorDataField.
 * */
@Serializable
data class PassportElementErrorDataField(
    val source: String,
    val type: String,
    val field_name: String,
    val data_hash: String,
    val message: String
) : PassportElementError()

/**
 * <p>Represents an issue with the front side of a document. The error is considered resolved when the file with the front side of the document changes.</p>
 *
 * @property source Error source, must be <em>front_side</em>
 * @property type The section of the user's Telegram Passport which has the issue, one of “passport”, “driver_license”, “identity_card”, “internal_passport”
 * @property file_hash Base64-encoded hash of the file with the front side of the document
 * @property message Error message
 *
 * @constructor Creates a: PassportElementErrorFrontSide.
 * */
@Serializable
data class PassportElementErrorFrontSide(
    val source: String,
    val type: String,
    val file_hash: String,
    val message: String
) : PassportElementError()

/**
 * <p>Represents an issue with the reverse side of a document. The error is considered resolved when the file with reverse side of the document changes.</p>
 *
 * @property source Error source, must be <em>reverse_side</em>
 * @property type The section of the user's Telegram Passport which has the issue, one of “driver_license”, “identity_card”
 * @property file_hash Base64-encoded hash of the file with the reverse side of the document
 * @property message Error message
 *
 * @constructor Creates a: PassportElementErrorReverseSide.
 * */
@Serializable
data class PassportElementErrorReverseSide(
    val source: String,
    val type: String,
    val file_hash: String,
    val message: String
) : PassportElementError()

/**
 * <p>Represents an issue with the selfie with a document. The error is considered resolved when the file with the selfie changes.</p>
 *
 * @property source Error source, must be <em>selfie</em>
 * @property type The section of the user's Telegram Passport which has the issue, one of “passport”, “driver_license”, “identity_card”, “internal_passport”
 * @property file_hash Base64-encoded hash of the file with the selfie
 * @property message Error message
 *
 * @constructor Creates a: PassportElementErrorSelfie.
 * */
@Serializable
data class PassportElementErrorSelfie(
    val source: String,
    val type: String,
    val file_hash: String,
    val message: String
) : PassportElementError()

/**
 * <p>Represents an issue with a document scan. The error is considered resolved when the file with the document scan changes.</p>
 *
 * @property source Error source, must be <em>file</em>
 * @property type The section of the user's Telegram Passport which has the issue, one of “utility_bill”, “bank_statement”, “rental_agreement”, “passport_registration”, “temporary_registration”
 * @property file_hash Base64-encoded file hash
 * @property message Error message
 *
 * @constructor Creates a: PassportElementErrorFile.
 * */
@Serializable
data class PassportElementErrorFile(
    val source: String,
    val type: String,
    val file_hash: String,
    val message: String
) : PassportElementError()

/**
 * <p>Represents an issue with a list of scans. The error is considered resolved when the list of files containing the scans changes.</p>
 *
 * @property source Error source, must be <em>files</em>
 * @property type The section of the user's Telegram Passport which has the issue, one of “utility_bill”, “bank_statement”, “rental_agreement”, “passport_registration”, “temporary_registration”
 * @property file_hashes List of base64-encoded file hashes
 * @property message Error message
 *
 * @constructor Creates a: PassportElementErrorFiles.
 * */
@Serializable
data class PassportElementErrorFiles(
    val source: String,
    val type: String,
    val file_hashes: List<String>,
    val message: String
) : PassportElementError()

/**
 * <p>Represents an issue with one of the files that constitute the translation of a document. The error is considered resolved when the file changes.</p>
 *
 * @property source Error source, must be <em>translation_file</em>
 * @property type Type of element of the user's Telegram Passport which has the issue, one of “passport”, “driver_license”, “identity_card”, “internal_passport”, “utility_bill”, “bank_statement”, “rental_agreement”, “passport_registration”, “temporary_registration”
 * @property file_hash Base64-encoded file hash
 * @property message Error message
 *
 * @constructor Creates a: PassportElementErrorTranslationFile.
 * */
@Serializable
data class PassportElementErrorTranslationFile(
    val source: String,
    val type: String,
    val file_hash: String,
    val message: String
) : PassportElementError()

/**
 * <p>Represents an issue with the translated version of a document. The error is considered resolved when a file with the document translation change.</p>
 *
 * @property source Error source, must be <em>translation_files</em>
 * @property type Type of element of the user's Telegram Passport which has the issue, one of “passport”, “driver_license”, “identity_card”, “internal_passport”, “utility_bill”, “bank_statement”, “rental_agreement”, “passport_registration”, “temporary_registration”
 * @property file_hashes List of base64-encoded file hashes
 * @property message Error message
 *
 * @constructor Creates a: PassportElementErrorTranslationFiles.
 * */
@Serializable
data class PassportElementErrorTranslationFiles(
    val source: String,
    val type: String,
    val file_hashes: List<String>,
    val message: String
) : PassportElementError()

/**
 * <p>Represents an issue in an unspecified place. The error is considered resolved when new data is added.</p>
 *
 * @property source Error source, must be <em>unspecified</em>
 * @property type Type of element of the user's Telegram Passport which has the issue
 * @property element_hash Base64-encoded element hash
 * @property message Error message
 *
 * @constructor Creates a: PassportElementErrorUnspecified.
 * */
@Serializable
data class PassportElementErrorUnspecified(
    val source: String,
    val type: String,
    val element_hash: String,
    val message: String
) : PassportElementError()


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
 * @constructor Creates a: Game.
 * */
@Serializable
data class Game(
    val title: String,
    val description: String,
    val photo: List<PhotoSize>,
    val text: String? = null,
    val text_entities: List<MessageEntity>? = null,
    val animation: Animation? = null
) : TelegramModel()

/**
 * <p>This object represents one row of the high scores table for a game.</p><p>And that‘s about all we’ve got for now.<br>If you've got any questions, please check out our <a href="/bots/faq"><strong>Bot FAQ »</strong></a></p>
 *
 * @property position Position in high score table for the game
 * @property user User
 * @property score Score
 *
 * @constructor Creates a: GameHighScore.
 * */
@Serializable
data class GameHighScore(
    val position: Int,
    val user: User,
    val score: Int
) : TelegramModel()
