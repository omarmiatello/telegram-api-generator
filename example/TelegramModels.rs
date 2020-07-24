
/// --- Parameters & Responses ---


/// Getting updates

/**
 * <p>This <a href="#available-types">object</a> represents an incoming update.<br>At most <strong>one</strong> of the optional parameters can be present in any given update.</p>
 *
 * @property update_id The update's unique identifier. Update identifiers start from a certain positive number and increase sequentially. This ID becomes especially handy if you're using <a href="#setwebhook">Webhooks</a>, since it allows you to ignore repeated updates or to restore the correct update sequence, should they get out of order. If there are no new updates for at least a week, then identifier of the next update will be chosen randomly instead of sequentially.
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
 * @property poll_answer <em>Optional</em>. A user changed their answer in a non-anonymous poll. Bots receive new votes only in polls that were sent by the bot itself.
 *
 * @constructor Creates a [Update].
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct Update {
    /// The update's unique identifier. Update identifiers start from a certain positive number and increase sequentially. This ID becomes especially handy if you're using <a href="#setwebhook">Webhooks</a>, since it allows you to ignore repeated updates or to restore the correct update sequence, should they get out of order. If there are no new updates for at least a week, then identifier of the next update will be chosen randomly instead of sequentially.
    pub update_id: Integer,
    /// <em>Optional</em>. New incoming message of any kind — text, photo, sticker, etc.
    #[serde(skip_serializing_if = "Option::is_none")]
    pub message: Option<Message>,
    /// <em>Optional</em>. New version of a message that is known to the bot and was edited
    #[serde(skip_serializing_if = "Option::is_none")]
    pub edited_message: Option<Message>,
    /// <em>Optional</em>. New incoming channel post of any kind — text, photo, sticker, etc.
    #[serde(skip_serializing_if = "Option::is_none")]
    pub channel_post: Option<Message>,
    /// <em>Optional</em>. New version of a channel post that is known to the bot and was edited
    #[serde(skip_serializing_if = "Option::is_none")]
    pub edited_channel_post: Option<Message>,
    /// <em>Optional</em>. New incoming <a href="#inline-mode">inline</a> query
    #[serde(skip_serializing_if = "Option::is_none")]
    pub inline_query: Option<InlineQuery>,
    /// <em>Optional</em>. The result of an <a href="#inline-mode">inline</a> query that was chosen by a user and sent to their chat partner. Please see our documentation on the <a href="/bots/inline#collecting-feedback">feedback collecting</a> for details on how to enable these updates for your bot.
    #[serde(skip_serializing_if = "Option::is_none")]
    pub chosen_inline_result: Option<ChosenInlineResult>,
    /// <em>Optional</em>. New incoming callback query
    #[serde(skip_serializing_if = "Option::is_none")]
    pub callback_query: Option<CallbackQuery>,
    /// <em>Optional</em>. New incoming shipping query. Only for invoices with flexible price
    #[serde(skip_serializing_if = "Option::is_none")]
    pub shipping_query: Option<ShippingQuery>,
    /// <em>Optional</em>. New incoming pre-checkout query. Contains full information about checkout
    #[serde(skip_serializing_if = "Option::is_none")]
    pub pre_checkout_query: Option<PreCheckoutQuery>,
    /// <em>Optional</em>. New poll state. Bots receive only updates about stopped polls and polls, which are sent by the bot
    #[serde(skip_serializing_if = "Option::is_none")]
    pub poll: Option<Poll>,
    /// <em>Optional</em>. A user changed their answer in a non-anonymous poll. Bots receive new votes only in polls that were sent by the bot itself.
    #[serde(skip_serializing_if = "Option::is_none")]
    pub poll_answer: Option<PollAnswer>
}

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
 * @constructor Creates a [WebhookInfo].
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct WebhookInfo {
    /// Webhook URL, may be empty if webhook is not set up
    pub url: String,
    /// True, if a custom certificate was provided for webhook certificate checks
    pub has_custom_certificate: bool,
    /// Number of updates awaiting delivery
    pub pending_update_count: Integer,
    /// <em>Optional</em>. Unix time for the most recent error that happened when trying to deliver an update via webhook
    #[serde(skip_serializing_if = "Option::is_none")]
    pub last_error_date: Option<Integer>,
    /// <em>Optional</em>. Error message in human-readable format for the most recent error that happened when trying to deliver an update via webhook
    #[serde(skip_serializing_if = "Option::is_none")]
    pub last_error_message: Option<String>,
    /// <em>Optional</em>. Maximum allowed number of simultaneous HTTPS connections to the webhook for update delivery
    #[serde(skip_serializing_if = "Option::is_none")]
    pub max_connections: Option<Integer>,
    /// <em>Optional</em>. A list of update types the bot is subscribed to. Defaults to all update types
    #[serde(skip_serializing_if = "Option::is_none")]
    pub allowed_updates: Option<Vec<String>>
}


/// Available types

/**
 * <p>This object represents a Telegram user or bot.</p>
 *
 * @property id Unique identifier for this user or bot
 * @property is_bot True, if this user is a bot
 * @property first_name User's or bot's first name
 * @property last_name <em>Optional</em>. User's or bot's last name
 * @property username <em>Optional</em>. User's or bot's username
 * @property language_code <em>Optional</em>. <a href="https://en.wikipedia.org/wiki/IETF_language_tag">IETF language tag</a> of the user's language
 * @property can_join_groups <em>Optional</em>. True, if the bot can be invited to groups. Returned only in <a href="#getme">getMe</a>.
 * @property can_read_all_group_messages <em>Optional</em>. True, if <a href="https://core.telegram.org/bots#privacy-mode">privacy mode</a> is disabled for the bot. Returned only in <a href="#getme">getMe</a>.
 * @property supports_inline_queries <em>Optional</em>. True, if the bot supports inline queries. Returned only in <a href="#getme">getMe</a>.
 *
 * @constructor Creates a [User].
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct User {
    /// Unique identifier for this user or bot
    pub id: Integer,
    /// True, if this user is a bot
    pub is_bot: bool,
    /// User's or bot's first name
    pub first_name: String,
    /// <em>Optional</em>. User's or bot's last name
    #[serde(skip_serializing_if = "Option::is_none")]
    pub last_name: Option<String>,
    /// <em>Optional</em>. User's or bot's username
    #[serde(skip_serializing_if = "Option::is_none")]
    pub username: Option<String>,
    /// <em>Optional</em>. <a href="https://en.wikipedia.org/wiki/IETF_language_tag">IETF language tag</a> of the user's language
    #[serde(skip_serializing_if = "Option::is_none")]
    pub language_code: Option<String>,
    /// <em>Optional</em>. True, if the bot can be invited to groups. Returned only in <a href="#getme">getMe</a>.
    #[serde(skip_serializing_if = "Option::is_none")]
    pub can_join_groups: Option<bool>,
    /// <em>Optional</em>. True, if <a href="https://core.telegram.org/bots#privacy-mode">privacy mode</a> is disabled for the bot. Returned only in <a href="#getme">getMe</a>.
    #[serde(skip_serializing_if = "Option::is_none")]
    pub can_read_all_group_messages: Option<bool>,
    /// <em>Optional</em>. True, if the bot supports inline queries. Returned only in <a href="#getme">getMe</a>.
    #[serde(skip_serializing_if = "Option::is_none")]
    pub supports_inline_queries: Option<bool>
}

/**
 * <p>This object represents a chat.</p>
 *
 * @property id Unique identifier for this chat. This number may be greater than 32 bits and some programming languages may have difficulty/silent defects in interpreting it. But it is smaller than 52 bits, so a signed 64 bit integer or double-precision float type are safe for storing this identifier.
 * @property type Type of chat, can be either “private”, “group”, “supergroup” or “channel”
 * @property title <em>Optional</em>. Title, for supergroups, channels and group chats
 * @property username <em>Optional</em>. Username, for private chats, supergroups and channels if available
 * @property first_name <em>Optional</em>. First name of the other party in a private chat
 * @property last_name <em>Optional</em>. Last name of the other party in a private chat
 * @property photo <em>Optional</em>. Chat photo. Returned only in <a href="#getchat">getChat</a>.
 * @property description <em>Optional</em>. Description, for groups, supergroups and channel chats. Returned only in <a href="#getchat">getChat</a>.
 * @property invite_link <em>Optional</em>. Chat invite link, for groups, supergroups and channel chats. Each administrator in a chat generates their own invite links, so the bot must first generate the link using <a href="#exportchatinvitelink">exportChatInviteLink</a>. Returned only in <a href="#getchat">getChat</a>.
 * @property pinned_message <em>Optional</em>. Pinned message, for groups, supergroups and channels. Returned only in <a href="#getchat">getChat</a>.
 * @property permissions <em>Optional</em>. Default chat member permissions, for groups and supergroups. Returned only in <a href="#getchat">getChat</a>.
 * @property slow_mode_delay <em>Optional</em>. For supergroups, the minimum allowed delay between consecutive messages sent by each unpriviledged user. Returned only in <a href="#getchat">getChat</a>.
 * @property sticker_set_name <em>Optional</em>. For supergroups, name of group sticker set. Returned only in <a href="#getchat">getChat</a>.
 * @property can_set_sticker_set <em>Optional</em>. True, if the bot can change the group sticker set. Returned only in <a href="#getchat">getChat</a>.
 *
 * @constructor Creates a [Chat].
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct Chat {
    /// Unique identifier for this chat. This number may be greater than 32 bits and some programming languages may have difficulty/silent defects in interpreting it. But it is smaller than 52 bits, so a signed 64 bit integer or double-precision float type are safe for storing this identifier.
    pub id: Integer,
    /// Type of chat, can be either “private”, “group”, “supergroup” or “channel”
    #[serde(rename = "type")]
    pub type_: String,
    /// <em>Optional</em>. Title, for supergroups, channels and group chats
    #[serde(skip_serializing_if = "Option::is_none")]
    pub title: Option<String>,
    /// <em>Optional</em>. Username, for private chats, supergroups and channels if available
    #[serde(skip_serializing_if = "Option::is_none")]
    pub username: Option<String>,
    /// <em>Optional</em>. First name of the other party in a private chat
    #[serde(skip_serializing_if = "Option::is_none")]
    pub first_name: Option<String>,
    /// <em>Optional</em>. Last name of the other party in a private chat
    #[serde(skip_serializing_if = "Option::is_none")]
    pub last_name: Option<String>,
    /// <em>Optional</em>. Chat photo. Returned only in <a href="#getchat">getChat</a>.
    #[serde(skip_serializing_if = "Option::is_none")]
    pub photo: Option<ChatPhoto>,
    /// <em>Optional</em>. Description, for groups, supergroups and channel chats. Returned only in <a href="#getchat">getChat</a>.
    #[serde(skip_serializing_if = "Option::is_none")]
    pub description: Option<String>,
    /// <em>Optional</em>. Chat invite link, for groups, supergroups and channel chats. Each administrator in a chat generates their own invite links, so the bot must first generate the link using <a href="#exportchatinvitelink">exportChatInviteLink</a>. Returned only in <a href="#getchat">getChat</a>.
    #[serde(skip_serializing_if = "Option::is_none")]
    pub invite_link: Option<String>,
    /// <em>Optional</em>. Pinned message, for groups, supergroups and channels. Returned only in <a href="#getchat">getChat</a>.
    #[serde(skip_serializing_if = "Option::is_none")]
    pub pinned_message: Option<Message>,
    /// <em>Optional</em>. Default chat member permissions, for groups and supergroups. Returned only in <a href="#getchat">getChat</a>.
    #[serde(skip_serializing_if = "Option::is_none")]
    pub permissions: Option<ChatPermissions>,
    /// <em>Optional</em>. For supergroups, the minimum allowed delay between consecutive messages sent by each unpriviledged user. Returned only in <a href="#getchat">getChat</a>.
    #[serde(skip_serializing_if = "Option::is_none")]
    pub slow_mode_delay: Option<Integer>,
    /// <em>Optional</em>. For supergroups, name of group sticker set. Returned only in <a href="#getchat">getChat</a>.
    #[serde(skip_serializing_if = "Option::is_none")]
    pub sticker_set_name: Option<String>,
    /// <em>Optional</em>. True, if the bot can change the group sticker set. Returned only in <a href="#getchat">getChat</a>.
    #[serde(skip_serializing_if = "Option::is_none")]
    pub can_set_sticker_set: Option<bool>
}

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
 * @property via_bot <em>Optional</em>. Bot through which the message was sent
 * @property edit_date <em>Optional</em>. Date the message was last edited in Unix time
 * @property media_group_id <em>Optional</em>. The unique identifier of a media message group this message belongs to
 * @property author_signature <em>Optional</em>. Signature of the post author for messages in channels
 * @property text <em>Optional</em>. For text messages, the actual UTF-8 text of the message, 0-4096 characters
 * @property entities <em>Optional</em>. For text messages, special entities like usernames, URLs, bot commands, etc. that appear in the text
 * @property animation <em>Optional</em>. Message is an animation, information about the animation. For backward compatibility, when this field is set, the <em>document</em> field will also be set
 * @property audio <em>Optional</em>. Message is an audio file, information about the file
 * @property document <em>Optional</em>. Message is a general file, information about the file
 * @property photo <em>Optional</em>. Message is a photo, available sizes of the photo
 * @property sticker <em>Optional</em>. Message is a sticker, information about the sticker
 * @property video <em>Optional</em>. Message is a video, information about the video
 * @property video_note <em>Optional</em>. Message is a <a href="https://telegram.org/blog/video-messages-and-telescope">video note</a>, information about the video message
 * @property voice <em>Optional</em>. Message is a voice message, information about the file
 * @property caption <em>Optional</em>. Caption for the animation, audio, document, photo, video or voice, 0-1024 characters
 * @property caption_entities <em>Optional</em>. For messages with a caption, special entities like usernames, URLs, bot commands, etc. that appear in the caption
 * @property contact <em>Optional</em>. Message is a shared contact, information about the contact
 * @property dice <em>Optional</em>. Message is a dice with random value from 1 to 6
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
 * @property migrate_to_chat_id <em>Optional</em>. The group has been migrated to a supergroup with the specified identifier. This number may be greater than 32 bits and some programming languages may have difficulty/silent defects in interpreting it. But it is smaller than 52 bits, so a signed 64 bit integer or double-precision float type are safe for storing this identifier.
 * @property migrate_from_chat_id <em>Optional</em>. The supergroup has been migrated from a group with the specified identifier. This number may be greater than 32 bits and some programming languages may have difficulty/silent defects in interpreting it. But it is smaller than 52 bits, so a signed 64 bit integer or double-precision float type are safe for storing this identifier.
 * @property pinned_message <em>Optional</em>. Specified message was pinned. Note that the Message object in this field will not contain further <em>reply_to_message</em> fields even if it is itself a reply.
 * @property invoice <em>Optional</em>. Message is an invoice for a <a href="#payments">payment</a>, information about the invoice. <a href="#payments">More about payments »</a>
 * @property successful_payment <em>Optional</em>. Message is a service message about a successful payment, information about the payment. <a href="#payments">More about payments »</a>
 * @property connected_website <em>Optional</em>. The domain name of the website on which the user has logged in. <a href="/widgets/login">More about Telegram Login »</a>
 * @property passport_data <em>Optional</em>. Telegram Passport data
 * @property reply_markup <em>Optional</em>. Inline keyboard attached to the message. <code>login_url</code> buttons are represented as ordinary <code>url</code> buttons.
 *
 * @constructor Creates a [Message].
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct Message {
    /// Unique message identifier inside this chat
    pub message_id: Integer,
    /// <em>Optional</em>. Sender, empty for messages sent to channels
    #[serde(skip_serializing_if = "Option::is_none")]
    pub from: Option<User>,
    /// Date the message was sent in Unix time
    pub date: Integer,
    /// Conversation the message belongs to
    pub chat: Chat,
    /// <em>Optional</em>. For forwarded messages, sender of the original message
    #[serde(skip_serializing_if = "Option::is_none")]
    pub forward_from: Option<User>,
    /// <em>Optional</em>. For messages forwarded from channels, information about the original channel
    #[serde(skip_serializing_if = "Option::is_none")]
    pub forward_from_chat: Option<Chat>,
    /// <em>Optional</em>. For messages forwarded from channels, identifier of the original message in the channel
    #[serde(skip_serializing_if = "Option::is_none")]
    pub forward_from_message_id: Option<Integer>,
    /// <em>Optional</em>. For messages forwarded from channels, signature of the post author if present
    #[serde(skip_serializing_if = "Option::is_none")]
    pub forward_signature: Option<String>,
    /// <em>Optional</em>. Sender's name for messages forwarded from users who disallow adding a link to their account in forwarded messages
    #[serde(skip_serializing_if = "Option::is_none")]
    pub forward_sender_name: Option<String>,
    /// <em>Optional</em>. For forwarded messages, date the original message was sent in Unix time
    #[serde(skip_serializing_if = "Option::is_none")]
    pub forward_date: Option<Integer>,
    /// <em>Optional</em>. For replies, the original message. Note that the Message object in this field will not contain further <em>reply_to_message</em> fields even if it itself is a reply.
    #[serde(skip_serializing_if = "Option::is_none")]
    pub reply_to_message: Option<Message>,
    /// <em>Optional</em>. Bot through which the message was sent
    #[serde(skip_serializing_if = "Option::is_none")]
    pub via_bot: Option<User>,
    /// <em>Optional</em>. Date the message was last edited in Unix time
    #[serde(skip_serializing_if = "Option::is_none")]
    pub edit_date: Option<Integer>,
    /// <em>Optional</em>. The unique identifier of a media message group this message belongs to
    #[serde(skip_serializing_if = "Option::is_none")]
    pub media_group_id: Option<String>,
    /// <em>Optional</em>. Signature of the post author for messages in channels
    #[serde(skip_serializing_if = "Option::is_none")]
    pub author_signature: Option<String>,
    /// <em>Optional</em>. For text messages, the actual UTF-8 text of the message, 0-4096 characters
    #[serde(skip_serializing_if = "Option::is_none")]
    pub text: Option<String>,
    /// <em>Optional</em>. For text messages, special entities like usernames, URLs, bot commands, etc. that appear in the text
    #[serde(skip_serializing_if = "Option::is_none")]
    pub entities: Option<Vec<MessageEntity>>,
    /// <em>Optional</em>. Message is an animation, information about the animation. For backward compatibility, when this field is set, the <em>document</em> field will also be set
    #[serde(skip_serializing_if = "Option::is_none")]
    pub animation: Option<Animation>,
    /// <em>Optional</em>. Message is an audio file, information about the file
    #[serde(skip_serializing_if = "Option::is_none")]
    pub audio: Option<Audio>,
    /// <em>Optional</em>. Message is a general file, information about the file
    #[serde(skip_serializing_if = "Option::is_none")]
    pub document: Option<Document>,
    /// <em>Optional</em>. Message is a photo, available sizes of the photo
    #[serde(skip_serializing_if = "Option::is_none")]
    pub photo: Option<Vec<PhotoSize>>,
    /// <em>Optional</em>. Message is a sticker, information about the sticker
    #[serde(skip_serializing_if = "Option::is_none")]
    pub sticker: Option<Sticker>,
    /// <em>Optional</em>. Message is a video, information about the video
    #[serde(skip_serializing_if = "Option::is_none")]
    pub video: Option<Video>,
    /// <em>Optional</em>. Message is a <a href="https://telegram.org/blog/video-messages-and-telescope">video note</a>, information about the video message
    #[serde(skip_serializing_if = "Option::is_none")]
    pub video_note: Option<VideoNote>,
    /// <em>Optional</em>. Message is a voice message, information about the file
    #[serde(skip_serializing_if = "Option::is_none")]
    pub voice: Option<Voice>,
    /// <em>Optional</em>. Caption for the animation, audio, document, photo, video or voice, 0-1024 characters
    #[serde(skip_serializing_if = "Option::is_none")]
    pub caption: Option<String>,
    /// <em>Optional</em>. For messages with a caption, special entities like usernames, URLs, bot commands, etc. that appear in the caption
    #[serde(skip_serializing_if = "Option::is_none")]
    pub caption_entities: Option<Vec<MessageEntity>>,
    /// <em>Optional</em>. Message is a shared contact, information about the contact
    #[serde(skip_serializing_if = "Option::is_none")]
    pub contact: Option<Contact>,
    /// <em>Optional</em>. Message is a dice with random value from 1 to 6
    #[serde(skip_serializing_if = "Option::is_none")]
    pub dice: Option<Dice>,
    /// <em>Optional</em>. Message is a game, information about the game. <a href="#games">More about games »</a>
    #[serde(skip_serializing_if = "Option::is_none")]
    pub game: Option<Game>,
    /// <em>Optional</em>. Message is a native poll, information about the poll
    #[serde(skip_serializing_if = "Option::is_none")]
    pub poll: Option<Poll>,
    /// <em>Optional</em>. Message is a venue, information about the venue. For backward compatibility, when this field is set, the <em>location</em> field will also be set
    #[serde(skip_serializing_if = "Option::is_none")]
    pub venue: Option<Venue>,
    /// <em>Optional</em>. Message is a shared location, information about the location
    #[serde(skip_serializing_if = "Option::is_none")]
    pub location: Option<Location>,
    /// <em>Optional</em>. New members that were added to the group or supergroup and information about them (the bot itself may be one of these members)
    #[serde(skip_serializing_if = "Option::is_none")]
    pub new_chat_members: Option<Vec<User>>,
    /// <em>Optional</em>. A member was removed from the group, information about them (this member may be the bot itself)
    #[serde(skip_serializing_if = "Option::is_none")]
    pub left_chat_member: Option<User>,
    /// <em>Optional</em>. A chat title was changed to this value
    #[serde(skip_serializing_if = "Option::is_none")]
    pub new_chat_title: Option<String>,
    /// <em>Optional</em>. A chat photo was change to this value
    #[serde(skip_serializing_if = "Option::is_none")]
    pub new_chat_photo: Option<Vec<PhotoSize>>,
    /// <em>Optional</em>. Service message: the chat photo was deleted
    #[serde(skip_serializing_if = "Option::is_none")]
    pub delete_chat_photo: Option<bool>,
    /// <em>Optional</em>. Service message: the group has been created
    #[serde(skip_serializing_if = "Option::is_none")]
    pub group_chat_created: Option<bool>,
    /// <em>Optional</em>. Service message: the supergroup has been created. This field can't be received in a message coming through updates, because bot can't be a member of a supergroup when it is created. It can only be found in reply_to_message if someone replies to a very first message in a directly created supergroup.
    #[serde(skip_serializing_if = "Option::is_none")]
    pub supergroup_chat_created: Option<bool>,
    /// <em>Optional</em>. Service message: the channel has been created. This field can't be received in a message coming through updates, because bot can't be a member of a channel when it is created. It can only be found in reply_to_message if someone replies to a very first message in a channel.
    #[serde(skip_serializing_if = "Option::is_none")]
    pub channel_chat_created: Option<bool>,
    /// <em>Optional</em>. The group has been migrated to a supergroup with the specified identifier. This number may be greater than 32 bits and some programming languages may have difficulty/silent defects in interpreting it. But it is smaller than 52 bits, so a signed 64 bit integer or double-precision float type are safe for storing this identifier.
    #[serde(skip_serializing_if = "Option::is_none")]
    pub migrate_to_chat_id: Option<Integer>,
    /// <em>Optional</em>. The supergroup has been migrated from a group with the specified identifier. This number may be greater than 32 bits and some programming languages may have difficulty/silent defects in interpreting it. But it is smaller than 52 bits, so a signed 64 bit integer or double-precision float type are safe for storing this identifier.
    #[serde(skip_serializing_if = "Option::is_none")]
    pub migrate_from_chat_id: Option<Integer>,
    /// <em>Optional</em>. Specified message was pinned. Note that the Message object in this field will not contain further <em>reply_to_message</em> fields even if it is itself a reply.
    #[serde(skip_serializing_if = "Option::is_none")]
    pub pinned_message: Option<Message>,
    /// <em>Optional</em>. Message is an invoice for a <a href="#payments">payment</a>, information about the invoice. <a href="#payments">More about payments »</a>
    #[serde(skip_serializing_if = "Option::is_none")]
    pub invoice: Option<Invoice>,
    /// <em>Optional</em>. Message is a service message about a successful payment, information about the payment. <a href="#payments">More about payments »</a>
    #[serde(skip_serializing_if = "Option::is_none")]
    pub successful_payment: Option<SuccessfulPayment>,
    /// <em>Optional</em>. The domain name of the website on which the user has logged in. <a href="/widgets/login">More about Telegram Login »</a>
    #[serde(skip_serializing_if = "Option::is_none")]
    pub connected_website: Option<String>,
    /// <em>Optional</em>. Telegram Passport data
    #[serde(skip_serializing_if = "Option::is_none")]
    pub passport_data: Option<PassportData>,
    /// <em>Optional</em>. Inline keyboard attached to the message. <code>login_url</code> buttons are represented as ordinary <code>url</code> buttons.
    #[serde(skip_serializing_if = "Option::is_none")]
    pub reply_markup: Option<InlineKeyboardMarkup>
}

/**
 * <p>This object represents one special entity in a text message. For example, hashtags, usernames, URLs, etc.</p>
 *
 * @property type Type of the entity. Can be “mention” (<code>@username</code>), “hashtag” (<code>#hashtag</code>), “cashtag” (<code>$USD</code>), “bot_command” (<code>/start@jobs_bot</code>), “url” (<code>https://telegram.org</code>), “email” (<code>do-not-reply@telegram.org</code>), “phone_number” (<code>+1-212-555-0123</code>), “bold” (<strong>bold text</strong>), “italic” (<em>italic text</em>), “underline” (underlined text), “strikethrough” (strikethrough text), “code” (monowidth string), “pre” (monowidth block), “text_link” (for clickable text URLs), “text_mention” (for users <a href="https://telegram.org/blog/edit#new-mentions">without usernames</a>)
 * @property offset Offset in UTF-16 code units to the start of the entity
 * @property length Length of the entity in UTF-16 code units
 * @property url <em>Optional</em>. For “text_link” only, url that will be opened after user taps on the text
 * @property user <em>Optional</em>. For “text_mention” only, the mentioned user
 * @property language <em>Optional</em>. For “pre” only, the programming language of the entity text
 *
 * @constructor Creates a [MessageEntity].
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct MessageEntity {
    /// Type of the entity. Can be “mention” (<code>@username</code>), “hashtag” (<code>#hashtag</code>), “cashtag” (<code>$USD</code>), “bot_command” (<code>/start@jobs_bot</code>), “url” (<code>https://telegram.org</code>), “email” (<code>do-not-reply@telegram.org</code>), “phone_number” (<code>+1-212-555-0123</code>), “bold” (<strong>bold text</strong>), “italic” (<em>italic text</em>), “underline” (underlined text), “strikethrough” (strikethrough text), “code” (monowidth string), “pre” (monowidth block), “text_link” (for clickable text URLs), “text_mention” (for users <a href="https://telegram.org/blog/edit#new-mentions">without usernames</a>)
    #[serde(rename = "type")]
    pub type_: String,
    /// Offset in UTF-16 code units to the start of the entity
    pub offset: Integer,
    /// Length of the entity in UTF-16 code units
    pub length: Integer,
    /// <em>Optional</em>. For “text_link” only, url that will be opened after user taps on the text
    #[serde(skip_serializing_if = "Option::is_none")]
    pub url: Option<String>,
    /// <em>Optional</em>. For “text_mention” only, the mentioned user
    #[serde(skip_serializing_if = "Option::is_none")]
    pub user: Option<User>,
    /// <em>Optional</em>. For “pre” only, the programming language of the entity text
    #[serde(skip_serializing_if = "Option::is_none")]
    pub language: Option<String>
}

/**
 * <p>This object represents one size of a photo or a <a href="#document">file</a> / <a href="#sticker">sticker</a> thumbnail.</p>
 *
 * @property file_id Identifier for this file, which can be used to download or reuse the file
 * @property file_unique_id Unique identifier for this file, which is supposed to be the same over time and for different bots. Can't be used to download or reuse the file.
 * @property width Photo width
 * @property height Photo height
 * @property file_size <em>Optional</em>. File size
 *
 * @constructor Creates a [PhotoSize].
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct PhotoSize {
    /// Identifier for this file, which can be used to download or reuse the file
    pub file_id: String,
    /// Unique identifier for this file, which is supposed to be the same over time and for different bots. Can't be used to download or reuse the file.
    pub file_unique_id: String,
    /// Photo width
    pub width: Integer,
    /// Photo height
    pub height: Integer,
    /// <em>Optional</em>. File size
    #[serde(skip_serializing_if = "Option::is_none")]
    pub file_size: Option<Integer>
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
 * @property file_size <em>Optional</em>. File size
 *
 * @constructor Creates a [Animation].
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct Animation {
    /// Identifier for this file, which can be used to download or reuse the file
    pub file_id: String,
    /// Unique identifier for this file, which is supposed to be the same over time and for different bots. Can't be used to download or reuse the file.
    pub file_unique_id: String,
    /// Video width as defined by sender
    pub width: Integer,
    /// Video height as defined by sender
    pub height: Integer,
    /// Duration of the video in seconds as defined by sender
    pub duration: Integer,
    /// <em>Optional</em>. Animation thumbnail as defined by sender
    #[serde(skip_serializing_if = "Option::is_none")]
    pub thumb: Option<PhotoSize>,
    /// <em>Optional</em>. Original animation filename as defined by sender
    #[serde(skip_serializing_if = "Option::is_none")]
    pub file_name: Option<String>,
    /// <em>Optional</em>. MIME type of the file as defined by sender
    #[serde(skip_serializing_if = "Option::is_none")]
    pub mime_type: Option<String>,
    /// <em>Optional</em>. File size
    #[serde(skip_serializing_if = "Option::is_none")]
    pub file_size: Option<Integer>
}

/**
 * <p>This object represents an audio file to be treated as music by the Telegram clients.</p>
 *
 * @property file_id Identifier for this file, which can be used to download or reuse the file
 * @property file_unique_id Unique identifier for this file, which is supposed to be the same over time and for different bots. Can't be used to download or reuse the file.
 * @property duration Duration of the audio in seconds as defined by sender
 * @property performer <em>Optional</em>. Performer of the audio as defined by sender or by audio tags
 * @property title <em>Optional</em>. Title of the audio as defined by sender or by audio tags
 * @property mime_type <em>Optional</em>. MIME type of the file as defined by sender
 * @property file_size <em>Optional</em>. File size
 * @property thumb <em>Optional</em>. Thumbnail of the album cover to which the music file belongs
 *
 * @constructor Creates a [Audio].
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct Audio {
    /// Identifier for this file, which can be used to download or reuse the file
    pub file_id: String,
    /// Unique identifier for this file, which is supposed to be the same over time and for different bots. Can't be used to download or reuse the file.
    pub file_unique_id: String,
    /// Duration of the audio in seconds as defined by sender
    pub duration: Integer,
    /// <em>Optional</em>. Performer of the audio as defined by sender or by audio tags
    #[serde(skip_serializing_if = "Option::is_none")]
    pub performer: Option<String>,
    /// <em>Optional</em>. Title of the audio as defined by sender or by audio tags
    #[serde(skip_serializing_if = "Option::is_none")]
    pub title: Option<String>,
    /// <em>Optional</em>. MIME type of the file as defined by sender
    #[serde(skip_serializing_if = "Option::is_none")]
    pub mime_type: Option<String>,
    /// <em>Optional</em>. File size
    #[serde(skip_serializing_if = "Option::is_none")]
    pub file_size: Option<Integer>,
    /// <em>Optional</em>. Thumbnail of the album cover to which the music file belongs
    #[serde(skip_serializing_if = "Option::is_none")]
    pub thumb: Option<PhotoSize>
}

/**
 * <p>This object represents a general file (as opposed to <a href="#photosize">photos</a>, <a href="#voice">voice messages</a> and <a href="#audio">audio files</a>).</p>
 *
 * @property file_id Identifier for this file, which can be used to download or reuse the file
 * @property file_unique_id Unique identifier for this file, which is supposed to be the same over time and for different bots. Can't be used to download or reuse the file.
 * @property thumb <em>Optional</em>. Document thumbnail as defined by sender
 * @property file_name <em>Optional</em>. Original filename as defined by sender
 * @property mime_type <em>Optional</em>. MIME type of the file as defined by sender
 * @property file_size <em>Optional</em>. File size
 *
 * @constructor Creates a [Document].
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct Document {
    /// Identifier for this file, which can be used to download or reuse the file
    pub file_id: String,
    /// Unique identifier for this file, which is supposed to be the same over time and for different bots. Can't be used to download or reuse the file.
    pub file_unique_id: String,
    /// <em>Optional</em>. Document thumbnail as defined by sender
    #[serde(skip_serializing_if = "Option::is_none")]
    pub thumb: Option<PhotoSize>,
    /// <em>Optional</em>. Original filename as defined by sender
    #[serde(skip_serializing_if = "Option::is_none")]
    pub file_name: Option<String>,
    /// <em>Optional</em>. MIME type of the file as defined by sender
    #[serde(skip_serializing_if = "Option::is_none")]
    pub mime_type: Option<String>,
    /// <em>Optional</em>. File size
    #[serde(skip_serializing_if = "Option::is_none")]
    pub file_size: Option<Integer>
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
 * @property mime_type <em>Optional</em>. Mime type of a file as defined by sender
 * @property file_size <em>Optional</em>. File size
 *
 * @constructor Creates a [Video].
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct Video {
    /// Identifier for this file, which can be used to download or reuse the file
    pub file_id: String,
    /// Unique identifier for this file, which is supposed to be the same over time and for different bots. Can't be used to download or reuse the file.
    pub file_unique_id: String,
    /// Video width as defined by sender
    pub width: Integer,
    /// Video height as defined by sender
    pub height: Integer,
    /// Duration of the video in seconds as defined by sender
    pub duration: Integer,
    /// <em>Optional</em>. Video thumbnail
    #[serde(skip_serializing_if = "Option::is_none")]
    pub thumb: Option<PhotoSize>,
    /// <em>Optional</em>. Mime type of a file as defined by sender
    #[serde(skip_serializing_if = "Option::is_none")]
    pub mime_type: Option<String>,
    /// <em>Optional</em>. File size
    #[serde(skip_serializing_if = "Option::is_none")]
    pub file_size: Option<Integer>
}

/**
 * <p>This object represents a <a href="https://telegram.org/blog/video-messages-and-telescope">video message</a> (available in Telegram apps as of <a href="https://telegram.org/blog/video-messages-and-telescope">v.4.0</a>).</p>
 *
 * @property file_id Identifier for this file, which can be used to download or reuse the file
 * @property file_unique_id Unique identifier for this file, which is supposed to be the same over time and for different bots. Can't be used to download or reuse the file.
 * @property length Video width and height (diameter of the video message) as defined by sender
 * @property duration Duration of the video in seconds as defined by sender
 * @property thumb <em>Optional</em>. Video thumbnail
 * @property file_size <em>Optional</em>. File size
 *
 * @constructor Creates a [VideoNote].
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct VideoNote {
    /// Identifier for this file, which can be used to download or reuse the file
    pub file_id: String,
    /// Unique identifier for this file, which is supposed to be the same over time and for different bots. Can't be used to download or reuse the file.
    pub file_unique_id: String,
    /// Video width and height (diameter of the video message) as defined by sender
    pub length: Integer,
    /// Duration of the video in seconds as defined by sender
    pub duration: Integer,
    /// <em>Optional</em>. Video thumbnail
    #[serde(skip_serializing_if = "Option::is_none")]
    pub thumb: Option<PhotoSize>,
    /// <em>Optional</em>. File size
    #[serde(skip_serializing_if = "Option::is_none")]
    pub file_size: Option<Integer>
}

/**
 * <p>This object represents a voice note.</p>
 *
 * @property file_id Identifier for this file, which can be used to download or reuse the file
 * @property file_unique_id Unique identifier for this file, which is supposed to be the same over time and for different bots. Can't be used to download or reuse the file.
 * @property duration Duration of the audio in seconds as defined by sender
 * @property mime_type <em>Optional</em>. MIME type of the file as defined by sender
 * @property file_size <em>Optional</em>. File size
 *
 * @constructor Creates a [Voice].
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct Voice {
    /// Identifier for this file, which can be used to download or reuse the file
    pub file_id: String,
    /// Unique identifier for this file, which is supposed to be the same over time and for different bots. Can't be used to download or reuse the file.
    pub file_unique_id: String,
    /// Duration of the audio in seconds as defined by sender
    pub duration: Integer,
    /// <em>Optional</em>. MIME type of the file as defined by sender
    #[serde(skip_serializing_if = "Option::is_none")]
    pub mime_type: Option<String>,
    /// <em>Optional</em>. File size
    #[serde(skip_serializing_if = "Option::is_none")]
    pub file_size: Option<Integer>
}

/**
 * <p>This object represents a phone contact.</p>
 *
 * @property phone_number Contact's phone number
 * @property first_name Contact's first name
 * @property last_name <em>Optional</em>. Contact's last name
 * @property user_id <em>Optional</em>. Contact's user identifier in Telegram
 * @property vcard <em>Optional</em>. Additional data about the contact in the form of a <a href="https://en.wikipedia.org/wiki/VCard">vCard</a>
 *
 * @constructor Creates a [Contact].
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct Contact {
    /// Contact's phone number
    pub phone_number: String,
    /// Contact's first name
    pub first_name: String,
    /// <em>Optional</em>. Contact's last name
    #[serde(skip_serializing_if = "Option::is_none")]
    pub last_name: Option<String>,
    /// <em>Optional</em>. Contact's user identifier in Telegram
    #[serde(skip_serializing_if = "Option::is_none")]
    pub user_id: Option<Integer>,
    /// <em>Optional</em>. Additional data about the contact in the form of a <a href="https://en.wikipedia.org/wiki/VCard">vCard</a>
    #[serde(skip_serializing_if = "Option::is_none")]
    pub vcard: Option<String>
}

/**
 * <p>This object represents an animated emoji that displays a random value.</p>
 *
 * @property emoji Emoji on which the dice throw animation is based
 * @property value Value of the dice, 1-6 for “<img class="emoji" src="//telegram.org/img/emoji/40/F09F8EB2.png" width="20" height="20" alt="🎲">” and “<img class="emoji" src="//telegram.org/img/emoji/40/F09F8EAF.png" width="20" height="20" alt="🎯">” base emoji, 1-5 for “<img class="emoji" src="//telegram.org/img/emoji/40/F09F8F80.png" width="20" height="20" alt="🏀">” base emoji
 *
 * @constructor Creates a [Dice].
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct Dice {
    /// Emoji on which the dice throw animation is based
    pub emoji: String,
    /// Value of the dice, 1-6 for “<img class="emoji" src="//telegram.org/img/emoji/40/F09F8EB2.png" width="20" height="20" alt="🎲">” and “<img class="emoji" src="//telegram.org/img/emoji/40/F09F8EAF.png" width="20" height="20" alt="🎯">” base emoji, 1-5 for “<img class="emoji" src="//telegram.org/img/emoji/40/F09F8F80.png" width="20" height="20" alt="🏀">” base emoji
    pub value: Integer
}

/**
 * <p>This object contains information about one answer option in a poll.</p>
 *
 * @property text Option text, 1-100 characters
 * @property voter_count Number of users that voted for this option
 *
 * @constructor Creates a [PollOption].
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct PollOption {
    /// Option text, 1-100 characters
    pub text: String,
    /// Number of users that voted for this option
    pub voter_count: Integer
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
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct PollAnswer {
    /// Unique poll identifier
    pub poll_id: String,
    /// The user, who changed the answer to the poll
    pub user: User,
    /// 0-based identifiers of answer options, chosen by the user. May be empty if the user retracted their vote.
    pub option_ids: Vec<Integer>
}

/**
 * <p>This object contains information about a poll.</p>
 *
 * @property id Unique poll identifier
 * @property question Poll question, 1-255 characters
 * @property options List of poll options
 * @property total_voter_count Total number of users that voted in the poll
 * @property is_closed True, if the poll is closed
 * @property is_anonymous True, if the poll is anonymous
 * @property type Poll type, currently can be “regular” or “quiz”
 * @property allows_multiple_answers True, if the poll allows multiple answers
 * @property correct_option_id <em>Optional</em>. 0-based identifier of the correct answer option. Available only for polls in the quiz mode, which are closed, or was sent (not forwarded) by the bot or to the private chat with the bot.
 * @property explanation <em>Optional</em>. Text that is shown when a user chooses an incorrect answer or taps on the lamp icon in a quiz-style poll, 0-200 characters
 * @property explanation_entities <em>Optional</em>. Special entities like usernames, URLs, bot commands, etc. that appear in the <em>explanation</em>
 * @property open_period <em>Optional</em>. Amount of time in seconds the poll will be active after creation
 * @property close_date <em>Optional</em>. Point in time (Unix timestamp) when the poll will be automatically closed
 *
 * @constructor Creates a [Poll].
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct Poll {
    /// Unique poll identifier
    pub id: String,
    /// Poll question, 1-255 characters
    pub question: String,
    /// List of poll options
    pub options: Vec<PollOption>,
    /// Total number of users that voted in the poll
    pub total_voter_count: Integer,
    /// True, if the poll is closed
    pub is_closed: bool,
    /// True, if the poll is anonymous
    pub is_anonymous: bool,
    /// Poll type, currently can be “regular” or “quiz”
    #[serde(rename = "type")]
    pub type_: String,
    /// True, if the poll allows multiple answers
    pub allows_multiple_answers: bool,
    /// <em>Optional</em>. 0-based identifier of the correct answer option. Available only for polls in the quiz mode, which are closed, or was sent (not forwarded) by the bot or to the private chat with the bot.
    #[serde(skip_serializing_if = "Option::is_none")]
    pub correct_option_id: Option<Integer>,
    /// <em>Optional</em>. Text that is shown when a user chooses an incorrect answer or taps on the lamp icon in a quiz-style poll, 0-200 characters
    #[serde(skip_serializing_if = "Option::is_none")]
    pub explanation: Option<String>,
    /// <em>Optional</em>. Special entities like usernames, URLs, bot commands, etc. that appear in the <em>explanation</em>
    #[serde(skip_serializing_if = "Option::is_none")]
    pub explanation_entities: Option<Vec<MessageEntity>>,
    /// <em>Optional</em>. Amount of time in seconds the poll will be active after creation
    #[serde(skip_serializing_if = "Option::is_none")]
    pub open_period: Option<Integer>,
    /// <em>Optional</em>. Point in time (Unix timestamp) when the poll will be automatically closed
    #[serde(skip_serializing_if = "Option::is_none")]
    pub close_date: Option<Integer>
}

/**
 * <p>This object represents a point on the map.</p>
 *
 * @property longitude Longitude as defined by sender
 * @property latitude Latitude as defined by sender
 *
 * @constructor Creates a [Location].
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct Location {
    /// Longitude as defined by sender
    pub longitude: Float,
    /// Latitude as defined by sender
    pub latitude: Float
}

/**
 * <p>This object represents a venue.</p>
 *
 * @property location Venue location
 * @property title Name of the venue
 * @property address Address of the venue
 * @property foursquare_id <em>Optional</em>. Foursquare identifier of the venue
 * @property foursquare_type <em>Optional</em>. Foursquare type of the venue. (For example, “arts_entertainment/default”, “arts_entertainment/aquarium” or “food/icecream”.)
 *
 * @constructor Creates a [Venue].
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct Venue {
    /// Venue location
    pub location: Location,
    /// Name of the venue
    pub title: String,
    /// Address of the venue
    pub address: String,
    /// <em>Optional</em>. Foursquare identifier of the venue
    #[serde(skip_serializing_if = "Option::is_none")]
    pub foursquare_id: Option<String>,
    /// <em>Optional</em>. Foursquare type of the venue. (For example, “arts_entertainment/default”, “arts_entertainment/aquarium” or “food/icecream”.)
    #[serde(skip_serializing_if = "Option::is_none")]
    pub foursquare_type: Option<String>
}

/**
 * <p>This object represent a user's profile pictures.</p>
 *
 * @property total_count Total number of profile pictures the target user has
 * @property photos Requested profile pictures (in up to 4 sizes each)
 *
 * @constructor Creates a [UserProfilePhotos].
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct UserProfilePhotos {
    /// Total number of profile pictures the target user has
    pub total_count: Integer,
    /// Requested profile pictures (in up to 4 sizes each)
    pub photos: Vec<Vec<PhotoSize>>
}

/**
 * <p>This object represents a file ready to be downloaded. The file can be downloaded via the link <code>https://api.telegram.org/file/bot&lt;token&gt;/&lt;file_path&gt;</code>. It is guaranteed that the link will be valid for at least 1 hour. When the link expires, a new one can be requested by calling <a href="#getfile">getFile</a>.</p><blockquote> 
 *  <p>Maximum file size to download is 20 MB</p> 
 * </blockquote>
 *
 * @property file_id Identifier for this file, which can be used to download or reuse the file
 * @property file_unique_id Unique identifier for this file, which is supposed to be the same over time and for different bots. Can't be used to download or reuse the file.
 * @property file_size <em>Optional</em>. File size, if known
 * @property file_path <em>Optional</em>. File path. Use <code>https://api.telegram.org/file/bot&lt;token&gt;/&lt;file_path&gt;</code> to get the file.
 *
 * @constructor Creates a [File].
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct File {
    /// Identifier for this file, which can be used to download or reuse the file
    pub file_id: String,
    /// Unique identifier for this file, which is supposed to be the same over time and for different bots. Can't be used to download or reuse the file.
    pub file_unique_id: String,
    /// <em>Optional</em>. File size, if known
    #[serde(skip_serializing_if = "Option::is_none")]
    pub file_size: Option<Integer>,
    /// <em>Optional</em>. File path. Use <code>https://api.telegram.org/file/bot&lt;token&gt;/&lt;file_path&gt;</code> to get the file.
    #[serde(skip_serializing_if = "Option::is_none")]
    pub file_path: Option<String>
}

/**
 * <p>This object represents a <a href="https://core.telegram.org/bots#keyboards">custom keyboard</a> with reply options (see <a href="https://core.telegram.org/bots#keyboards">Introduction to bots</a> for details and examples).</p>
 *
 * @property keyboard Array of button rows, each represented by an Array of <a href="#keyboardbutton">KeyboardButton</a> objects
 * @property resize_keyboard <em>Optional</em>. Requests clients to resize the keyboard vertically for optimal fit (e.g., make the keyboard smaller if there are just two rows of buttons). Defaults to <em>false</em>, in which case the custom keyboard is always of the same height as the app's standard keyboard.
 * @property one_time_keyboard <em>Optional</em>. Requests clients to hide the keyboard as soon as it's been used. The keyboard will still be available, but clients will automatically display the usual letter-keyboard in the chat – the user can press a special button in the input field to see the custom keyboard again. Defaults to <em>false</em>.
 * @property selective <em>Optional</em>. Use this parameter if you want to show the keyboard to specific users only. Targets: 1) users that are @mentioned in the <em>text</em> of the <a href="#message">Message</a> object; 2) if the bot's message is a reply (has <em>reply_to_message_id</em>), sender of the original message.<br><br><em>Example:</em> A user requests to change the bot's language, bot replies to the request with a keyboard to select the new language. Other users in the group don't see the keyboard.
 *
 * @constructor Creates a [ReplyKeyboardMarkup].
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct ReplyKeyboardMarkup {
    /// Array of button rows, each represented by an Array of <a href="#keyboardbutton">KeyboardButton</a> objects
    pub keyboard: Vec<Vec<KeyboardButton>>,
    /// <em>Optional</em>. Requests clients to resize the keyboard vertically for optimal fit (e.g., make the keyboard smaller if there are just two rows of buttons). Defaults to <em>false</em>, in which case the custom keyboard is always of the same height as the app's standard keyboard.
    #[serde(skip_serializing_if = "Option::is_none")]
    pub resize_keyboard: Option<bool>,
    /// <em>Optional</em>. Requests clients to hide the keyboard as soon as it's been used. The keyboard will still be available, but clients will automatically display the usual letter-keyboard in the chat – the user can press a special button in the input field to see the custom keyboard again. Defaults to <em>false</em>.
    #[serde(skip_serializing_if = "Option::is_none")]
    pub one_time_keyboard: Option<bool>,
    /// <em>Optional</em>. Use this parameter if you want to show the keyboard to specific users only. Targets: 1) users that are @mentioned in the <em>text</em> of the <a href="#message">Message</a> object; 2) if the bot's message is a reply (has <em>reply_to_message_id</em>), sender of the original message.<br><br><em>Example:</em> A user requests to change the bot's language, bot replies to the request with a keyboard to select the new language. Other users in the group don't see the keyboard.
    #[serde(skip_serializing_if = "Option::is_none")]
    pub selective: Option<bool>
}

/**
 * <p>This object represents one button of the reply keyboard. For simple text buttons <em>String</em> can be used instead of this object to specify text of the button. Optional fields <em>request_contact</em>, <em>request_location</em>, and <em>request_poll</em> are mutually exclusive.</p><p><strong>Note:</strong> <em>request_contact</em> and <em>request_location</em> options will only work in Telegram versions released after 9 April, 2016. Older clients will display <em>unsupported message</em>.<br><strong>Note:</strong> <em>request_poll</em> option will only work in Telegram versions released after 23 January, 2020. Older clients will display <em>unsupported message</em>.</p>
 *
 * @property text Text of the button. If none of the optional fields are used, it will be sent as a message when the button is pressed
 * @property request_contact <em>Optional</em>. If <em>True</em>, the user's phone number will be sent as a contact when the button is pressed. Available in private chats only
 * @property request_location <em>Optional</em>. If <em>True</em>, the user's current location will be sent when the button is pressed. Available in private chats only
 * @property request_poll <em>Optional</em>. If specified, the user will be asked to create a poll and send it to the bot when the button is pressed. Available in private chats only
 *
 * @constructor Creates a [KeyboardButton].
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct KeyboardButton {
    /// Text of the button. If none of the optional fields are used, it will be sent as a message when the button is pressed
    pub text: String,
    /// <em>Optional</em>. If <em>True</em>, the user's phone number will be sent as a contact when the button is pressed. Available in private chats only
    #[serde(skip_serializing_if = "Option::is_none")]
    pub request_contact: Option<bool>,
    /// <em>Optional</em>. If <em>True</em>, the user's current location will be sent when the button is pressed. Available in private chats only
    #[serde(skip_serializing_if = "Option::is_none")]
    pub request_location: Option<bool>,
    /// <em>Optional</em>. If specified, the user will be asked to create a poll and send it to the bot when the button is pressed. Available in private chats only
    #[serde(skip_serializing_if = "Option::is_none")]
    pub request_poll: Option<KeyboardButtonPollType>
}

/**
 * <p>This object represents type of a poll, which is allowed to be created and sent when the corresponding button is pressed.</p>
 *
 * @property type <em>Optional</em>. If <em>quiz</em> is passed, the user will be allowed to create only polls in the quiz mode. If <em>regular</em> is passed, only regular polls will be allowed. Otherwise, the user will be allowed to create a poll of any type.
 *
 * @constructor Creates a [KeyboardButtonPollType].
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct KeyboardButtonPollType {
    /// <em>Optional</em>. If <em>quiz</em> is passed, the user will be allowed to create only polls in the quiz mode. If <em>regular</em> is passed, only regular polls will be allowed. Otherwise, the user will be allowed to create a poll of any type.
    #[serde(skip_serializing_if = "Option::is_none")]
    #[serde(rename = "type")]
    pub type_: Option<String>
}

/**
 * <p>Upon receiving a message with this object, Telegram clients will remove the current custom keyboard and display the default letter-keyboard. By default, custom keyboards are displayed until a new keyboard is sent by a bot. An exception is made for one-time keyboards that are hidden immediately after the user presses a button (see <a href="#replykeyboardmarkup">ReplyKeyboardMarkup</a>).</p>
 *
 * @property remove_keyboard Requests clients to remove the custom keyboard (user will not be able to summon this keyboard; if you want to hide the keyboard from sight but keep it accessible, use <em>one_time_keyboard</em> in <a href="#replykeyboardmarkup">ReplyKeyboardMarkup</a>)
 * @property selective <em>Optional</em>. Use this parameter if you want to remove the keyboard for specific users only. Targets: 1) users that are @mentioned in the <em>text</em> of the <a href="#message">Message</a> object; 2) if the bot's message is a reply (has <em>reply_to_message_id</em>), sender of the original message.<br><br><em>Example:</em> A user votes in a poll, bot returns confirmation message in reply to the vote and removes the keyboard for that user, while still showing the keyboard with poll options to users who haven't voted yet.
 *
 * @constructor Creates a [ReplyKeyboardRemove].
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct ReplyKeyboardRemove {
    /// Requests clients to remove the custom keyboard (user will not be able to summon this keyboard; if you want to hide the keyboard from sight but keep it accessible, use <em>one_time_keyboard</em> in <a href="#replykeyboardmarkup">ReplyKeyboardMarkup</a>)
    pub remove_keyboard: bool,
    /// <em>Optional</em>. Use this parameter if you want to remove the keyboard for specific users only. Targets: 1) users that are @mentioned in the <em>text</em> of the <a href="#message">Message</a> object; 2) if the bot's message is a reply (has <em>reply_to_message_id</em>), sender of the original message.<br><br><em>Example:</em> A user votes in a poll, bot returns confirmation message in reply to the vote and removes the keyboard for that user, while still showing the keyboard with poll options to users who haven't voted yet.
    #[serde(skip_serializing_if = "Option::is_none")]
    pub selective: Option<bool>
}

/**
 * <p>This object represents an <a href="https://core.telegram.org/bots#inline-keyboards-and-on-the-fly-updating">inline keyboard</a> that appears right next to the message it belongs to.</p><p><strong>Note:</strong> This will only work in Telegram versions released after 9 April, 2016. Older clients will display <em>unsupported message</em>.</p>
 *
 * @property inline_keyboard Array of button rows, each represented by an Array of <a href="#inlinekeyboardbutton">InlineKeyboardButton</a> objects
 *
 * @constructor Creates a [InlineKeyboardMarkup].
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct InlineKeyboardMarkup {
    /// Array of button rows, each represented by an Array of <a href="#inlinekeyboardbutton">InlineKeyboardButton</a> objects
    pub inline_keyboard: Vec<Vec<InlineKeyboardButton>>
}

/**
 * <p>This object represents one button of an inline keyboard. You <strong>must</strong> use exactly one of the optional fields.</p>
 *
 * @property text Label text on the button
 * @property url <em>Optional</em>. HTTP or tg:// url to be opened when button is pressed
 * @property login_url <em>Optional</em>. An HTTP URL used to automatically authorize the user. Can be used as a replacement for the <a href="https://core.telegram.org/widgets/login">Telegram Login Widget</a>.
 * @property callback_data <em>Optional</em>. Data to be sent in a <a href="#callbackquery">callback query</a> to the bot when button is pressed, 1-64 bytes
 * @property switch_inline_query <em>Optional</em>. If set, pressing the button will prompt the user to select one of their chats, open that chat and insert the bot's username and the specified inline query in the input field. Can be empty, in which case just the bot's username will be inserted.<br><br><strong>Note:</strong> This offers an easy way for users to start using your bot in <a href="/bots/inline">inline mode</a> when they are currently in a private chat with it. Especially useful when combined with <a href="#answerinlinequery"><em>switch_pm…</em></a> actions – in this case the user will be automatically returned to the chat they switched from, skipping the chat selection screen.
 * @property switch_inline_query_current_chat <em>Optional</em>. If set, pressing the button will insert the bot's username and the specified inline query in the current chat's input field. Can be empty, in which case only the bot's username will be inserted.<br><br>This offers a quick way for the user to open your bot in inline mode in the same chat – good for selecting something from multiple options.
 * @property callback_game <em>Optional</em>. Description of the game that will be launched when the user presses the button.<br><br><strong>NOTE:</strong> This type of button <strong>must</strong> always be the first button in the first row.
 * @property pay <em>Optional</em>. Specify True, to send a <a href="#payments">Pay button</a>.<br><br><strong>NOTE:</strong> This type of button <strong>must</strong> always be the first button in the first row.
 *
 * @constructor Creates a [InlineKeyboardButton].
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct InlineKeyboardButton {
    /// Label text on the button
    pub text: String,
    /// <em>Optional</em>. HTTP or tg:// url to be opened when button is pressed
    #[serde(skip_serializing_if = "Option::is_none")]
    pub url: Option<String>,
    /// <em>Optional</em>. An HTTP URL used to automatically authorize the user. Can be used as a replacement for the <a href="https://core.telegram.org/widgets/login">Telegram Login Widget</a>.
    #[serde(skip_serializing_if = "Option::is_none")]
    pub login_url: Option<LoginUrl>,
    /// <em>Optional</em>. Data to be sent in a <a href="#callbackquery">callback query</a> to the bot when button is pressed, 1-64 bytes
    #[serde(skip_serializing_if = "Option::is_none")]
    pub callback_data: Option<String>,
    /// <em>Optional</em>. If set, pressing the button will prompt the user to select one of their chats, open that chat and insert the bot's username and the specified inline query in the input field. Can be empty, in which case just the bot's username will be inserted.<br><br><strong>Note:</strong> This offers an easy way for users to start using your bot in <a href="/bots/inline">inline mode</a> when they are currently in a private chat with it. Especially useful when combined with <a href="#answerinlinequery"><em>switch_pm…</em></a> actions – in this case the user will be automatically returned to the chat they switched from, skipping the chat selection screen.
    #[serde(skip_serializing_if = "Option::is_none")]
    pub switch_inline_query: Option<String>,
    /// <em>Optional</em>. If set, pressing the button will insert the bot's username and the specified inline query in the current chat's input field. Can be empty, in which case only the bot's username will be inserted.<br><br>This offers a quick way for the user to open your bot in inline mode in the same chat – good for selecting something from multiple options.
    #[serde(skip_serializing_if = "Option::is_none")]
    pub switch_inline_query_current_chat: Option<String>,
    /// <em>Optional</em>. Description of the game that will be launched when the user presses the button.<br><br><strong>NOTE:</strong> This type of button <strong>must</strong> always be the first button in the first row.
    #[serde(skip_serializing_if = "Option::is_none")]
    pub callback_game: Option<CallbackGame>,
    /// <em>Optional</em>. Specify True, to send a <a href="#payments">Pay button</a>.<br><br><strong>NOTE:</strong> This type of button <strong>must</strong> always be the first button in the first row.
    #[serde(skip_serializing_if = "Option::is_none")]
    pub pay: Option<bool>
}

/**
 * <p>This object represents a parameter of the inline keyboard button used to automatically authorize a user. Serves as a great replacement for the <a href="https://core.telegram.org/widgets/login">Telegram Login Widget</a> when the user is coming from Telegram. All the user needs to do is tap/click a button and confirm that they want to log in:</p><p>Telegram apps support these buttons as of <a href="https://telegram.org/blog/privacy-discussions-web-bots#meet-seamless-web-bots">version 5.7</a>.</p><blockquote> 
 *  <p>Sample bot: <a href="https://t.me/discussbot">@discussbot</a></p> 
 * </blockquote>
 *
 * @property url An HTTP URL to be opened with user authorization data added to the query string when the button is pressed. If the user refuses to provide authorization data, the original URL without information about the user will be opened. The data added is the same as described in <a href="https://core.telegram.org/widgets/login#receiving-authorization-data">Receiving authorization data</a>.<br><br><strong>NOTE:</strong> You <strong>must</strong> always check the hash of the received data to verify the authentication and the integrity of the data as described in <a href="https://core.telegram.org/widgets/login#checking-authorization">Checking authorization</a>.
 * @property forward_text <em>Optional</em>. New text of the button in forwarded messages.
 * @property bot_username <em>Optional</em>. Username of a bot, which will be used for user authorization. See <a href="https://core.telegram.org/widgets/login#setting-up-a-bot">Setting up a bot</a> for more details. If not specified, the current bot's username will be assumed. The <em>url</em>'s domain must be the same as the domain linked with the bot. See <a href="https://core.telegram.org/widgets/login#linking-your-domain-to-the-bot">Linking your domain to the bot</a> for more details.
 * @property request_write_access <em>Optional</em>. Pass True to request the permission for your bot to send messages to the user.
 *
 * @constructor Creates a [LoginUrl].
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct LoginUrl {
    /// An HTTP URL to be opened with user authorization data added to the query string when the button is pressed. If the user refuses to provide authorization data, the original URL without information about the user will be opened. The data added is the same as described in <a href="https://core.telegram.org/widgets/login#receiving-authorization-data">Receiving authorization data</a>.<br><br><strong>NOTE:</strong> You <strong>must</strong> always check the hash of the received data to verify the authentication and the integrity of the data as described in <a href="https://core.telegram.org/widgets/login#checking-authorization">Checking authorization</a>.
    pub url: String,
    /// <em>Optional</em>. New text of the button in forwarded messages.
    #[serde(skip_serializing_if = "Option::is_none")]
    pub forward_text: Option<String>,
    /// <em>Optional</em>. Username of a bot, which will be used for user authorization. See <a href="https://core.telegram.org/widgets/login#setting-up-a-bot">Setting up a bot</a> for more details. If not specified, the current bot's username will be assumed. The <em>url</em>'s domain must be the same as the domain linked with the bot. See <a href="https://core.telegram.org/widgets/login#linking-your-domain-to-the-bot">Linking your domain to the bot</a> for more details.
    #[serde(skip_serializing_if = "Option::is_none")]
    pub bot_username: Option<String>,
    /// <em>Optional</em>. Pass True to request the permission for your bot to send messages to the user.
    #[serde(skip_serializing_if = "Option::is_none")]
    pub request_write_access: Option<bool>
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
 * @property data <em>Optional</em>. Data associated with the callback button. Be aware that a bad client can send arbitrary data in this field.
 * @property game_short_name <em>Optional</em>. Short name of a <a href="#games">Game</a> to be returned, serves as the unique identifier for the game
 *
 * @constructor Creates a [CallbackQuery].
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct CallbackQuery {
    /// Unique identifier for this query
    pub id: String,
    /// Sender
    pub from: User,
    /// <em>Optional</em>. Message with the callback button that originated the query. Note that message content and message date will not be available if the message is too old
    #[serde(skip_serializing_if = "Option::is_none")]
    pub message: Option<Message>,
    /// <em>Optional</em>. Identifier of the message sent via the bot in inline mode, that originated the query.
    #[serde(skip_serializing_if = "Option::is_none")]
    pub inline_message_id: Option<String>,
    /// Global identifier, uniquely corresponding to the chat to which the message with the callback button was sent. Useful for high scores in <a href="#games">games</a>.
    pub chat_instance: String,
    /// <em>Optional</em>. Data associated with the callback button. Be aware that a bad client can send arbitrary data in this field.
    #[serde(skip_serializing_if = "Option::is_none")]
    pub data: Option<String>,
    /// <em>Optional</em>. Short name of a <a href="#games">Game</a> to be returned, serves as the unique identifier for the game
    #[serde(skip_serializing_if = "Option::is_none")]
    pub game_short_name: Option<String>
}

/**
 * <p>Upon receiving a message with this object, Telegram clients will display a reply interface to the user (act as if the user has selected the bot's message and tapped 'Reply'). This can be extremely useful if you want to create user-friendly step-by-step interfaces without having to sacrifice <a href="/bots#privacy-mode">privacy mode</a>.</p><blockquote> 
 *  <p><strong>Example:</strong> A <a href="https://t.me/PollBot">poll bot</a> for groups runs in privacy mode (only receives commands, replies to its messages and mentions). There could be two ways to create a new poll:</p> 
 *  <ul> 
 *   <li>Explain the user how to send a command with parameters (e.g. /newpoll question answer1 answer2). May be appealing for hardcore users but lacks modern day polish.</li> 
 *   <li>Guide the user through a step-by-step process. 'Please send me your question', 'Cool, now let's add the first answer option', 'Great. Keep adding answer options, then send /done when you're ready'.</li> 
 *  </ul> 
 *  <p>The last option is definitely more attractive. And if you use <a href="#forcereply">ForceReply</a> in your bot's questions, it will receive the user's answers even if it only receives replies, commands and mentions — without any extra work for the user.</p> 
 * </blockquote>
 *
 * @property force_reply Shows reply interface to the user, as if they manually selected the bot's message and tapped 'Reply'
 * @property selective <em>Optional</em>. Use this parameter if you want to force reply from specific users only. Targets: 1) users that are @mentioned in the <em>text</em> of the <a href="#message">Message</a> object; 2) if the bot's message is a reply (has <em>reply_to_message_id</em>), sender of the original message.
 *
 * @constructor Creates a [ForceReply].
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct ForceReply {
    /// Shows reply interface to the user, as if they manually selected the bot's message and tapped 'Reply'
    pub force_reply: bool,
    /// <em>Optional</em>. Use this parameter if you want to force reply from specific users only. Targets: 1) users that are @mentioned in the <em>text</em> of the <a href="#message">Message</a> object; 2) if the bot's message is a reply (has <em>reply_to_message_id</em>), sender of the original message.
    #[serde(skip_serializing_if = "Option::is_none")]
    pub selective: Option<bool>
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
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct ChatPhoto {
    /// File identifier of small (160x160) chat photo. This file_id can be used only for photo download and only for as long as the photo is not changed.
    pub small_file_id: String,
    /// Unique file identifier of small (160x160) chat photo, which is supposed to be the same over time and for different bots. Can't be used to download or reuse the file.
    pub small_file_unique_id: String,
    /// File identifier of big (640x640) chat photo. This file_id can be used only for photo download and only for as long as the photo is not changed.
    pub big_file_id: String,
    /// Unique file identifier of big (640x640) chat photo, which is supposed to be the same over time and for different bots. Can't be used to download or reuse the file.
    pub big_file_unique_id: String
}

/**
 * <p>This object contains information about one member of a chat.</p>
 *
 * @property user Information about the user
 * @property status The member's status in the chat. Can be “creator”, “administrator”, “member”, “restricted”, “left” or “kicked”
 * @property custom_title <em>Optional</em>. Owner and administrators only. Custom title for this user
 * @property until_date <em>Optional</em>. Restricted and kicked only. Date when restrictions will be lifted for this user; unix time
 * @property can_be_edited <em>Optional</em>. Administrators only. True, if the bot is allowed to edit administrator privileges of that user
 * @property can_post_messages <em>Optional</em>. Administrators only. True, if the administrator can post in the channel; channels only
 * @property can_edit_messages <em>Optional</em>. Administrators only. True, if the administrator can edit messages of other users and can pin messages; channels only
 * @property can_delete_messages <em>Optional</em>. Administrators only. True, if the administrator can delete messages of other users
 * @property can_restrict_members <em>Optional</em>. Administrators only. True, if the administrator can restrict, ban or unban chat members
 * @property can_promote_members <em>Optional</em>. Administrators only. True, if the administrator can add new administrators with a subset of their own privileges or demote administrators that he has promoted, directly or indirectly (promoted by administrators that were appointed by the user)
 * @property can_change_info <em>Optional</em>. Administrators and restricted only. True, if the user is allowed to change the chat title, photo and other settings
 * @property can_invite_users <em>Optional</em>. Administrators and restricted only. True, if the user is allowed to invite new users to the chat
 * @property can_pin_messages <em>Optional</em>. Administrators and restricted only. True, if the user is allowed to pin messages; groups and supergroups only
 * @property is_member <em>Optional</em>. Restricted only. True, if the user is a member of the chat at the moment of the request
 * @property can_send_messages <em>Optional</em>. Restricted only. True, if the user is allowed to send text messages, contacts, locations and venues
 * @property can_send_media_messages <em>Optional</em>. Restricted only. True, if the user is allowed to send audios, documents, photos, videos, video notes and voice notes
 * @property can_send_polls <em>Optional</em>. Restricted only. True, if the user is allowed to send polls
 * @property can_send_other_messages <em>Optional</em>. Restricted only. True, if the user is allowed to send animations, games, stickers and use inline bots
 * @property can_add_web_page_previews <em>Optional</em>. Restricted only. True, if the user is allowed to add web page previews to their messages
 *
 * @constructor Creates a [ChatMember].
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct ChatMember {
    /// Information about the user
    pub user: User,
    /// The member's status in the chat. Can be “creator”, “administrator”, “member”, “restricted”, “left” or “kicked”
    pub status: String,
    /// <em>Optional</em>. Owner and administrators only. Custom title for this user
    #[serde(skip_serializing_if = "Option::is_none")]
    pub custom_title: Option<String>,
    /// <em>Optional</em>. Restricted and kicked only. Date when restrictions will be lifted for this user; unix time
    #[serde(skip_serializing_if = "Option::is_none")]
    pub until_date: Option<Integer>,
    /// <em>Optional</em>. Administrators only. True, if the bot is allowed to edit administrator privileges of that user
    #[serde(skip_serializing_if = "Option::is_none")]
    pub can_be_edited: Option<bool>,
    /// <em>Optional</em>. Administrators only. True, if the administrator can post in the channel; channels only
    #[serde(skip_serializing_if = "Option::is_none")]
    pub can_post_messages: Option<bool>,
    /// <em>Optional</em>. Administrators only. True, if the administrator can edit messages of other users and can pin messages; channels only
    #[serde(skip_serializing_if = "Option::is_none")]
    pub can_edit_messages: Option<bool>,
    /// <em>Optional</em>. Administrators only. True, if the administrator can delete messages of other users
    #[serde(skip_serializing_if = "Option::is_none")]
    pub can_delete_messages: Option<bool>,
    /// <em>Optional</em>. Administrators only. True, if the administrator can restrict, ban or unban chat members
    #[serde(skip_serializing_if = "Option::is_none")]
    pub can_restrict_members: Option<bool>,
    /// <em>Optional</em>. Administrators only. True, if the administrator can add new administrators with a subset of their own privileges or demote administrators that he has promoted, directly or indirectly (promoted by administrators that were appointed by the user)
    #[serde(skip_serializing_if = "Option::is_none")]
    pub can_promote_members: Option<bool>,
    /// <em>Optional</em>. Administrators and restricted only. True, if the user is allowed to change the chat title, photo and other settings
    #[serde(skip_serializing_if = "Option::is_none")]
    pub can_change_info: Option<bool>,
    /// <em>Optional</em>. Administrators and restricted only. True, if the user is allowed to invite new users to the chat
    #[serde(skip_serializing_if = "Option::is_none")]
    pub can_invite_users: Option<bool>,
    /// <em>Optional</em>. Administrators and restricted only. True, if the user is allowed to pin messages; groups and supergroups only
    #[serde(skip_serializing_if = "Option::is_none")]
    pub can_pin_messages: Option<bool>,
    /// <em>Optional</em>. Restricted only. True, if the user is a member of the chat at the moment of the request
    #[serde(skip_serializing_if = "Option::is_none")]
    pub is_member: Option<bool>,
    /// <em>Optional</em>. Restricted only. True, if the user is allowed to send text messages, contacts, locations and venues
    #[serde(skip_serializing_if = "Option::is_none")]
    pub can_send_messages: Option<bool>,
    /// <em>Optional</em>. Restricted only. True, if the user is allowed to send audios, documents, photos, videos, video notes and voice notes
    #[serde(skip_serializing_if = "Option::is_none")]
    pub can_send_media_messages: Option<bool>,
    /// <em>Optional</em>. Restricted only. True, if the user is allowed to send polls
    #[serde(skip_serializing_if = "Option::is_none")]
    pub can_send_polls: Option<bool>,
    /// <em>Optional</em>. Restricted only. True, if the user is allowed to send animations, games, stickers and use inline bots
    #[serde(skip_serializing_if = "Option::is_none")]
    pub can_send_other_messages: Option<bool>,
    /// <em>Optional</em>. Restricted only. True, if the user is allowed to add web page previews to their messages
    #[serde(skip_serializing_if = "Option::is_none")]
    pub can_add_web_page_previews: Option<bool>
}

/**
 * <p>Describes actions that a non-administrator user is allowed to take in a chat.</p>
 *
 * @property can_send_messages <em>Optional</em>. True, if the user is allowed to send text messages, contacts, locations and venues
 * @property can_send_media_messages <em>Optional</em>. True, if the user is allowed to send audios, documents, photos, videos, video notes and voice notes, implies can_send_messages
 * @property can_send_polls <em>Optional</em>. True, if the user is allowed to send polls, implies can_send_messages
 * @property can_send_other_messages <em>Optional</em>. True, if the user is allowed to send animations, games, stickers and use inline bots, implies can_send_media_messages
 * @property can_add_web_page_previews <em>Optional</em>. True, if the user is allowed to add web page previews to their messages, implies can_send_media_messages
 * @property can_change_info <em>Optional</em>. True, if the user is allowed to change the chat title, photo and other settings. Ignored in public supergroups
 * @property can_invite_users <em>Optional</em>. True, if the user is allowed to invite new users to the chat
 * @property can_pin_messages <em>Optional</em>. True, if the user is allowed to pin messages. Ignored in public supergroups
 *
 * @constructor Creates a [ChatPermissions].
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct ChatPermissions {
    /// <em>Optional</em>. True, if the user is allowed to send text messages, contacts, locations and venues
    #[serde(skip_serializing_if = "Option::is_none")]
    pub can_send_messages: Option<bool>,
    /// <em>Optional</em>. True, if the user is allowed to send audios, documents, photos, videos, video notes and voice notes, implies can_send_messages
    #[serde(skip_serializing_if = "Option::is_none")]
    pub can_send_media_messages: Option<bool>,
    /// <em>Optional</em>. True, if the user is allowed to send polls, implies can_send_messages
    #[serde(skip_serializing_if = "Option::is_none")]
    pub can_send_polls: Option<bool>,
    /// <em>Optional</em>. True, if the user is allowed to send animations, games, stickers and use inline bots, implies can_send_media_messages
    #[serde(skip_serializing_if = "Option::is_none")]
    pub can_send_other_messages: Option<bool>,
    /// <em>Optional</em>. True, if the user is allowed to add web page previews to their messages, implies can_send_media_messages
    #[serde(skip_serializing_if = "Option::is_none")]
    pub can_add_web_page_previews: Option<bool>,
    /// <em>Optional</em>. True, if the user is allowed to change the chat title, photo and other settings. Ignored in public supergroups
    #[serde(skip_serializing_if = "Option::is_none")]
    pub can_change_info: Option<bool>,
    /// <em>Optional</em>. True, if the user is allowed to invite new users to the chat
    #[serde(skip_serializing_if = "Option::is_none")]
    pub can_invite_users: Option<bool>,
    /// <em>Optional</em>. True, if the user is allowed to pin messages. Ignored in public supergroups
    #[serde(skip_serializing_if = "Option::is_none")]
    pub can_pin_messages: Option<bool>
}

/**
 * <p>This object represents a bot command.</p>
 *
 * @property command Text of the command, 1-32 characters. Can contain only lowercase English letters, digits and underscores.
 * @property description Description of the command, 3-256 characters.
 *
 * @constructor Creates a [BotCommand].
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct BotCommand {
    /// Text of the command, 1-32 characters. Can contain only lowercase English letters, digits and underscores.
    pub command: String,
    /// Description of the command, 3-256 characters.
    pub description: String
}

/**
 * <p>Contains information about why a request was unsuccessful.</p>
 *
 * @property migrate_to_chat_id <em>Optional</em>. The group has been migrated to a supergroup with the specified identifier. This number may be greater than 32 bits and some programming languages may have difficulty/silent defects in interpreting it. But it is smaller than 52 bits, so a signed 64 bit integer or double-precision float type are safe for storing this identifier.
 * @property retry_after <em>Optional</em>. In case of exceeding flood control, the number of seconds left to wait before the request can be repeated
 *
 * @constructor Creates a [ResponseParameters].
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct ResponseParameters {
    /// <em>Optional</em>. The group has been migrated to a supergroup with the specified identifier. This number may be greater than 32 bits and some programming languages may have difficulty/silent defects in interpreting it. But it is smaller than 52 bits, so a signed 64 bit integer or double-precision float type are safe for storing this identifier.
    #[serde(skip_serializing_if = "Option::is_none")]
    pub migrate_to_chat_id: Option<Integer>,
    /// <em>Optional</em>. In case of exceeding flood control, the number of seconds left to wait before the request can be repeated
    #[serde(skip_serializing_if = "Option::is_none")]
    pub retry_after: Option<Integer>
}

/**
 * <p>Represents a photo to be sent.</p>
 *
 * @property type Type of the result, must be <em>photo</em>
 * @property media File to send. Pass a file_id to send a file that exists on the Telegram servers (recommended), pass an HTTP URL for Telegram to get a file from the Internet, or pass “attach://&lt;file_attach_name&gt;” to upload a new one using multipart/form-data under &lt;file_attach_name&gt; name. <a href="#sending-files">More info on Sending Files »</a>
 * @property caption <em>Optional</em>. Caption of the photo to be sent, 0-1024 characters after entities parsing
 * @property parse_mode <em>Optional</em>. Mode for parsing entities in the photo caption. See <a href="#formatting-options">formatting options</a> for more details.
 *
 * @constructor Creates a [InputMediaPhoto].
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct InputMediaPhoto {
    /// Type of the result, must be <em>photo</em>
    #[serde(rename = "type")]
    pub type_: String,
    /// File to send. Pass a file_id to send a file that exists on the Telegram servers (recommended), pass an HTTP URL for Telegram to get a file from the Internet, or pass “attach://&lt;file_attach_name&gt;” to upload a new one using multipart/form-data under &lt;file_attach_name&gt; name. <a href="#sending-files">More info on Sending Files »</a>
    pub media: String,
    /// <em>Optional</em>. Caption of the photo to be sent, 0-1024 characters after entities parsing
    #[serde(skip_serializing_if = "Option::is_none")]
    pub caption: Option<String>,
    /// <em>Optional</em>. Mode for parsing entities in the photo caption. See <a href="#formatting-options">formatting options</a> for more details.
    #[serde(skip_serializing_if = "Option::is_none")]
    pub parse_mode: Option<ParseMode>
}

/**
 * <p>Represents a video to be sent.</p>
 *
 * @property type Type of the result, must be <em>video</em>
 * @property media File to send. Pass a file_id to send a file that exists on the Telegram servers (recommended), pass an HTTP URL for Telegram to get a file from the Internet, or pass “attach://&lt;file_attach_name&gt;” to upload a new one using multipart/form-data under &lt;file_attach_name&gt; name. <a href="#sending-files">More info on Sending Files »</a>
 * @property thumb <em>Optional</em>. Thumbnail of the file sent; can be ignored if thumbnail generation for the file is supported server-side. The thumbnail should be in JPEG format and less than 200 kB in size. A thumbnail's width and height should not exceed 320. Ignored if the file is not uploaded using multipart/form-data. Thumbnails can't be reused and can be only uploaded as a new file, so you can pass “attach://&lt;file_attach_name&gt;” if the thumbnail was uploaded using multipart/form-data under &lt;file_attach_name&gt;. <a href="#sending-files">More info on Sending Files »</a>
 * @property caption <em>Optional</em>. Caption of the video to be sent, 0-1024 characters after entities parsing
 * @property parse_mode <em>Optional</em>. Mode for parsing entities in the video caption. See <a href="#formatting-options">formatting options</a> for more details.
 * @property width <em>Optional</em>. Video width
 * @property height <em>Optional</em>. Video height
 * @property duration <em>Optional</em>. Video duration
 * @property supports_streaming <em>Optional</em>. Pass <em>True</em>, if the uploaded video is suitable for streaming
 *
 * @constructor Creates a [InputMediaVideo].
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct InputMediaVideo {
    /// Type of the result, must be <em>video</em>
    #[serde(rename = "type")]
    pub type_: String,
    /// File to send. Pass a file_id to send a file that exists on the Telegram servers (recommended), pass an HTTP URL for Telegram to get a file from the Internet, or pass “attach://&lt;file_attach_name&gt;” to upload a new one using multipart/form-data under &lt;file_attach_name&gt; name. <a href="#sending-files">More info on Sending Files »</a>
    pub media: String,
    /// <em>Optional</em>. Thumbnail of the file sent; can be ignored if thumbnail generation for the file is supported server-side. The thumbnail should be in JPEG format and less than 200 kB in size. A thumbnail's width and height should not exceed 320. Ignored if the file is not uploaded using multipart/form-data. Thumbnails can't be reused and can be only uploaded as a new file, so you can pass “attach://&lt;file_attach_name&gt;” if the thumbnail was uploaded using multipart/form-data under &lt;file_attach_name&gt;. <a href="#sending-files">More info on Sending Files »</a>
    #[serde(skip_serializing_if = "Option::is_none")]
    pub thumb: Option<String>,
    /// <em>Optional</em>. Caption of the video to be sent, 0-1024 characters after entities parsing
    #[serde(skip_serializing_if = "Option::is_none")]
    pub caption: Option<String>,
    /// <em>Optional</em>. Mode for parsing entities in the video caption. See <a href="#formatting-options">formatting options</a> for more details.
    #[serde(skip_serializing_if = "Option::is_none")]
    pub parse_mode: Option<ParseMode>,
    /// <em>Optional</em>. Video width
    #[serde(skip_serializing_if = "Option::is_none")]
    pub width: Option<Integer>,
    /// <em>Optional</em>. Video height
    #[serde(skip_serializing_if = "Option::is_none")]
    pub height: Option<Integer>,
    /// <em>Optional</em>. Video duration
    #[serde(skip_serializing_if = "Option::is_none")]
    pub duration: Option<Integer>,
    /// <em>Optional</em>. Pass <em>True</em>, if the uploaded video is suitable for streaming
    #[serde(skip_serializing_if = "Option::is_none")]
    pub supports_streaming: Option<bool>
}

/**
 * <p>Represents an animation file (GIF or H.264/MPEG-4 AVC video without sound) to be sent.</p>
 *
 * @property type Type of the result, must be <em>animation</em>
 * @property media File to send. Pass a file_id to send a file that exists on the Telegram servers (recommended), pass an HTTP URL for Telegram to get a file from the Internet, or pass “attach://&lt;file_attach_name&gt;” to upload a new one using multipart/form-data under &lt;file_attach_name&gt; name. <a href="#sending-files">More info on Sending Files »</a>
 * @property thumb <em>Optional</em>. Thumbnail of the file sent; can be ignored if thumbnail generation for the file is supported server-side. The thumbnail should be in JPEG format and less than 200 kB in size. A thumbnail's width and height should not exceed 320. Ignored if the file is not uploaded using multipart/form-data. Thumbnails can't be reused and can be only uploaded as a new file, so you can pass “attach://&lt;file_attach_name&gt;” if the thumbnail was uploaded using multipart/form-data under &lt;file_attach_name&gt;. <a href="#sending-files">More info on Sending Files »</a>
 * @property caption <em>Optional</em>. Caption of the animation to be sent, 0-1024 characters after entities parsing
 * @property parse_mode <em>Optional</em>. Mode for parsing entities in the animation caption. See <a href="#formatting-options">formatting options</a> for more details.
 * @property width <em>Optional</em>. Animation width
 * @property height <em>Optional</em>. Animation height
 * @property duration <em>Optional</em>. Animation duration
 *
 * @constructor Creates a [InputMediaAnimation].
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct InputMediaAnimation {
    /// Type of the result, must be <em>animation</em>
    #[serde(rename = "type")]
    pub type_: String,
    /// File to send. Pass a file_id to send a file that exists on the Telegram servers (recommended), pass an HTTP URL for Telegram to get a file from the Internet, or pass “attach://&lt;file_attach_name&gt;” to upload a new one using multipart/form-data under &lt;file_attach_name&gt; name. <a href="#sending-files">More info on Sending Files »</a>
    pub media: String,
    /// <em>Optional</em>. Thumbnail of the file sent; can be ignored if thumbnail generation for the file is supported server-side. The thumbnail should be in JPEG format and less than 200 kB in size. A thumbnail's width and height should not exceed 320. Ignored if the file is not uploaded using multipart/form-data. Thumbnails can't be reused and can be only uploaded as a new file, so you can pass “attach://&lt;file_attach_name&gt;” if the thumbnail was uploaded using multipart/form-data under &lt;file_attach_name&gt;. <a href="#sending-files">More info on Sending Files »</a>
    #[serde(skip_serializing_if = "Option::is_none")]
    pub thumb: Option<String>,
    /// <em>Optional</em>. Caption of the animation to be sent, 0-1024 characters after entities parsing
    #[serde(skip_serializing_if = "Option::is_none")]
    pub caption: Option<String>,
    /// <em>Optional</em>. Mode for parsing entities in the animation caption. See <a href="#formatting-options">formatting options</a> for more details.
    #[serde(skip_serializing_if = "Option::is_none")]
    pub parse_mode: Option<ParseMode>,
    /// <em>Optional</em>. Animation width
    #[serde(skip_serializing_if = "Option::is_none")]
    pub width: Option<Integer>,
    /// <em>Optional</em>. Animation height
    #[serde(skip_serializing_if = "Option::is_none")]
    pub height: Option<Integer>,
    /// <em>Optional</em>. Animation duration
    #[serde(skip_serializing_if = "Option::is_none")]
    pub duration: Option<Integer>
}

/**
 * <p>Represents an audio file to be treated as music to be sent.</p>
 *
 * @property type Type of the result, must be <em>audio</em>
 * @property media File to send. Pass a file_id to send a file that exists on the Telegram servers (recommended), pass an HTTP URL for Telegram to get a file from the Internet, or pass “attach://&lt;file_attach_name&gt;” to upload a new one using multipart/form-data under &lt;file_attach_name&gt; name. <a href="#sending-files">More info on Sending Files »</a>
 * @property thumb <em>Optional</em>. Thumbnail of the file sent; can be ignored if thumbnail generation for the file is supported server-side. The thumbnail should be in JPEG format and less than 200 kB in size. A thumbnail's width and height should not exceed 320. Ignored if the file is not uploaded using multipart/form-data. Thumbnails can't be reused and can be only uploaded as a new file, so you can pass “attach://&lt;file_attach_name&gt;” if the thumbnail was uploaded using multipart/form-data under &lt;file_attach_name&gt;. <a href="#sending-files">More info on Sending Files »</a>
 * @property caption <em>Optional</em>. Caption of the audio to be sent, 0-1024 characters after entities parsing
 * @property parse_mode <em>Optional</em>. Mode for parsing entities in the audio caption. See <a href="#formatting-options">formatting options</a> for more details.
 * @property duration <em>Optional</em>. Duration of the audio in seconds
 * @property performer <em>Optional</em>. Performer of the audio
 * @property title <em>Optional</em>. Title of the audio
 *
 * @constructor Creates a [InputMediaAudio].
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct InputMediaAudio {
    /// Type of the result, must be <em>audio</em>
    #[serde(rename = "type")]
    pub type_: String,
    /// File to send. Pass a file_id to send a file that exists on the Telegram servers (recommended), pass an HTTP URL for Telegram to get a file from the Internet, or pass “attach://&lt;file_attach_name&gt;” to upload a new one using multipart/form-data under &lt;file_attach_name&gt; name. <a href="#sending-files">More info on Sending Files »</a>
    pub media: String,
    /// <em>Optional</em>. Thumbnail of the file sent; can be ignored if thumbnail generation for the file is supported server-side. The thumbnail should be in JPEG format and less than 200 kB in size. A thumbnail's width and height should not exceed 320. Ignored if the file is not uploaded using multipart/form-data. Thumbnails can't be reused and can be only uploaded as a new file, so you can pass “attach://&lt;file_attach_name&gt;” if the thumbnail was uploaded using multipart/form-data under &lt;file_attach_name&gt;. <a href="#sending-files">More info on Sending Files »</a>
    #[serde(skip_serializing_if = "Option::is_none")]
    pub thumb: Option<String>,
    /// <em>Optional</em>. Caption of the audio to be sent, 0-1024 characters after entities parsing
    #[serde(skip_serializing_if = "Option::is_none")]
    pub caption: Option<String>,
    /// <em>Optional</em>. Mode for parsing entities in the audio caption. See <a href="#formatting-options">formatting options</a> for more details.
    #[serde(skip_serializing_if = "Option::is_none")]
    pub parse_mode: Option<ParseMode>,
    /// <em>Optional</em>. Duration of the audio in seconds
    #[serde(skip_serializing_if = "Option::is_none")]
    pub duration: Option<Integer>,
    /// <em>Optional</em>. Performer of the audio
    #[serde(skip_serializing_if = "Option::is_none")]
    pub performer: Option<String>,
    /// <em>Optional</em>. Title of the audio
    #[serde(skip_serializing_if = "Option::is_none")]
    pub title: Option<String>
}

/**
 * <p>Represents a general file to be sent.</p>
 *
 * @property type Type of the result, must be <em>document</em>
 * @property media File to send. Pass a file_id to send a file that exists on the Telegram servers (recommended), pass an HTTP URL for Telegram to get a file from the Internet, or pass “attach://&lt;file_attach_name&gt;” to upload a new one using multipart/form-data under &lt;file_attach_name&gt; name. <a href="#sending-files">More info on Sending Files »</a>
 * @property thumb <em>Optional</em>. Thumbnail of the file sent; can be ignored if thumbnail generation for the file is supported server-side. The thumbnail should be in JPEG format and less than 200 kB in size. A thumbnail's width and height should not exceed 320. Ignored if the file is not uploaded using multipart/form-data. Thumbnails can't be reused and can be only uploaded as a new file, so you can pass “attach://&lt;file_attach_name&gt;” if the thumbnail was uploaded using multipart/form-data under &lt;file_attach_name&gt;. <a href="#sending-files">More info on Sending Files »</a>
 * @property caption <em>Optional</em>. Caption of the document to be sent, 0-1024 characters after entities parsing
 * @property parse_mode <em>Optional</em>. Mode for parsing entities in the document caption. See <a href="#formatting-options">formatting options</a> for more details.
 *
 * @constructor Creates a [InputMediaDocument].
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct InputMediaDocument {
    /// Type of the result, must be <em>document</em>
    #[serde(rename = "type")]
    pub type_: String,
    /// File to send. Pass a file_id to send a file that exists on the Telegram servers (recommended), pass an HTTP URL for Telegram to get a file from the Internet, or pass “attach://&lt;file_attach_name&gt;” to upload a new one using multipart/form-data under &lt;file_attach_name&gt; name. <a href="#sending-files">More info on Sending Files »</a>
    pub media: String,
    /// <em>Optional</em>. Thumbnail of the file sent; can be ignored if thumbnail generation for the file is supported server-side. The thumbnail should be in JPEG format and less than 200 kB in size. A thumbnail's width and height should not exceed 320. Ignored if the file is not uploaded using multipart/form-data. Thumbnails can't be reused and can be only uploaded as a new file, so you can pass “attach://&lt;file_attach_name&gt;” if the thumbnail was uploaded using multipart/form-data under &lt;file_attach_name&gt;. <a href="#sending-files">More info on Sending Files »</a>
    #[serde(skip_serializing_if = "Option::is_none")]
    pub thumb: Option<String>,
    /// <em>Optional</em>. Caption of the document to be sent, 0-1024 characters after entities parsing
    #[serde(skip_serializing_if = "Option::is_none")]
    pub caption: Option<String>,
    /// <em>Optional</em>. Mode for parsing entities in the document caption. See <a href="#formatting-options">formatting options</a> for more details.
    #[serde(skip_serializing_if = "Option::is_none")]
    pub parse_mode: Option<ParseMode>
}


/// Stickers

/**
 * <p>This object represents a sticker.</p>
 *
 * @property file_id Identifier for this file, which can be used to download or reuse the file
 * @property file_unique_id Unique identifier for this file, which is supposed to be the same over time and for different bots. Can't be used to download or reuse the file.
 * @property width Sticker width
 * @property height Sticker height
 * @property is_animated <em>True</em>, if the sticker is <a href="https://telegram.org/blog/animated-stickers">animated</a>
 * @property thumb <em>Optional</em>. Sticker thumbnail in the .WEBP or .JPG format
 * @property emoji <em>Optional</em>. Emoji associated with the sticker
 * @property set_name <em>Optional</em>. Name of the sticker set to which the sticker belongs
 * @property mask_position <em>Optional</em>. For mask stickers, the position where the mask should be placed
 * @property file_size <em>Optional</em>. File size
 *
 * @constructor Creates a [Sticker].
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct Sticker {
    /// Identifier for this file, which can be used to download or reuse the file
    pub file_id: String,
    /// Unique identifier for this file, which is supposed to be the same over time and for different bots. Can't be used to download or reuse the file.
    pub file_unique_id: String,
    /// Sticker width
    pub width: Integer,
    /// Sticker height
    pub height: Integer,
    /// <em>True</em>, if the sticker is <a href="https://telegram.org/blog/animated-stickers">animated</a>
    pub is_animated: bool,
    /// <em>Optional</em>. Sticker thumbnail in the .WEBP or .JPG format
    #[serde(skip_serializing_if = "Option::is_none")]
    pub thumb: Option<PhotoSize>,
    /// <em>Optional</em>. Emoji associated with the sticker
    #[serde(skip_serializing_if = "Option::is_none")]
    pub emoji: Option<String>,
    /// <em>Optional</em>. Name of the sticker set to which the sticker belongs
    #[serde(skip_serializing_if = "Option::is_none")]
    pub set_name: Option<String>,
    /// <em>Optional</em>. For mask stickers, the position where the mask should be placed
    #[serde(skip_serializing_if = "Option::is_none")]
    pub mask_position: Option<MaskPosition>,
    /// <em>Optional</em>. File size
    #[serde(skip_serializing_if = "Option::is_none")]
    pub file_size: Option<Integer>
}

/**
 * <p>This object represents a sticker set.</p>
 *
 * @property name Sticker set name
 * @property title Sticker set title
 * @property is_animated <em>True</em>, if the sticker set contains <a href="https://telegram.org/blog/animated-stickers">animated stickers</a>
 * @property contains_masks <em>True</em>, if the sticker set contains masks
 * @property stickers List of all set stickers
 * @property thumb <em>Optional</em>. Sticker set thumbnail in the .WEBP or .TGS format
 *
 * @constructor Creates a [StickerSet].
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct StickerSet {
    /// Sticker set name
    pub name: String,
    /// Sticker set title
    pub title: String,
    /// <em>True</em>, if the sticker set contains <a href="https://telegram.org/blog/animated-stickers">animated stickers</a>
    pub is_animated: bool,
    /// <em>True</em>, if the sticker set contains masks
    pub contains_masks: bool,
    /// List of all set stickers
    pub stickers: Vec<Sticker>,
    /// <em>Optional</em>. Sticker set thumbnail in the .WEBP or .TGS format
    #[serde(skip_serializing_if = "Option::is_none")]
    pub thumb: Option<PhotoSize>
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
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct MaskPosition {
    /// The part of the face relative to which the mask should be placed. One of “forehead”, “eyes”, “mouth”, or “chin”.
    pub point: String,
    /// Shift by X-axis measured in widths of the mask scaled to the face size, from left to right. For example, choosing -1.0 will place mask just to the left of the default mask position.
    pub x_shift: Float,
    /// Shift by Y-axis measured in heights of the mask scaled to the face size, from top to bottom. For example, 1.0 will place the mask just below the default mask position.
    pub y_shift: Float,
    /// Mask scaling coefficient. For example, 2.0 means double size.
    pub scale: Float
}


/// Inline mode

/**
 * <p>This object represents an incoming inline query. When the user sends an empty query, your bot could return some default or trending results.</p>
 *
 * @property id Unique identifier for this query
 * @property from Sender
 * @property location <em>Optional</em>. Sender location, only for bots that request user location
 * @property query Text of the query (up to 256 characters)
 * @property offset Offset of the results to be returned, can be controlled by the bot
 *
 * @constructor Creates a [InlineQuery].
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct InlineQuery {
    /// Unique identifier for this query
    pub id: String,
    /// Sender
    pub from: User,
    /// <em>Optional</em>. Sender location, only for bots that request user location
    #[serde(skip_serializing_if = "Option::is_none")]
    pub location: Option<Location>,
    /// Text of the query (up to 256 characters)
    pub query: String,
    /// Offset of the results to be returned, can be controlled by the bot
    pub offset: String
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
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct InlineQueryResultArticle {
    /// Type of the result, must be <em>article</em>
    #[serde(rename = "type")]
    pub type_: String,
    /// Unique identifier for this result, 1-64 Bytes
    pub id: String,
    /// Title of the result
    pub title: String,
    /// Content of the message to be sent
    pub input_message_content: InputMessageContent,
    /// <em>Optional</em>. <a href="/bots#inline-keyboards-and-on-the-fly-updating">Inline keyboard</a> attached to the message
    #[serde(skip_serializing_if = "Option::is_none")]
    pub reply_markup: Option<InlineKeyboardMarkup>,
    /// <em>Optional</em>. URL of the result
    #[serde(skip_serializing_if = "Option::is_none")]
    pub url: Option<String>,
    /// <em>Optional</em>. Pass <em>True</em>, if you don't want the URL to be shown in the message
    #[serde(skip_serializing_if = "Option::is_none")]
    pub hide_url: Option<bool>,
    /// <em>Optional</em>. Short description of the result
    #[serde(skip_serializing_if = "Option::is_none")]
    pub description: Option<String>,
    /// <em>Optional</em>. Url of the thumbnail for the result
    #[serde(skip_serializing_if = "Option::is_none")]
    pub thumb_url: Option<String>,
    /// <em>Optional</em>. Thumbnail width
    #[serde(skip_serializing_if = "Option::is_none")]
    pub thumb_width: Option<Integer>,
    /// <em>Optional</em>. Thumbnail height
    #[serde(skip_serializing_if = "Option::is_none")]
    pub thumb_height: Option<Integer>
}

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
 * @property caption <em>Optional</em>. Caption of the photo to be sent, 0-1024 characters after entities parsing
 * @property parse_mode <em>Optional</em>. Mode for parsing entities in the photo caption. See <a href="#formatting-options">formatting options</a> for more details.
 * @property reply_markup <em>Optional</em>. <a href="/bots#inline-keyboards-and-on-the-fly-updating">Inline keyboard</a> attached to the message
 * @property input_message_content <em>Optional</em>. Content of the message to be sent instead of the photo
 *
 * @constructor Creates a [InlineQueryResultPhoto].
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct InlineQueryResultPhoto {
    /// Type of the result, must be <em>photo</em>
    #[serde(rename = "type")]
    pub type_: String,
    /// Unique identifier for this result, 1-64 bytes
    pub id: String,
    /// A valid URL of the photo. Photo must be in <strong>jpeg</strong> format. Photo size must not exceed 5MB
    pub photo_url: String,
    /// URL of the thumbnail for the photo
    pub thumb_url: String,
    /// <em>Optional</em>. Width of the photo
    #[serde(skip_serializing_if = "Option::is_none")]
    pub photo_width: Option<Integer>,
    /// <em>Optional</em>. Height of the photo
    #[serde(skip_serializing_if = "Option::is_none")]
    pub photo_height: Option<Integer>,
    /// <em>Optional</em>. Title for the result
    #[serde(skip_serializing_if = "Option::is_none")]
    pub title: Option<String>,
    /// <em>Optional</em>. Short description of the result
    #[serde(skip_serializing_if = "Option::is_none")]
    pub description: Option<String>,
    /// <em>Optional</em>. Caption of the photo to be sent, 0-1024 characters after entities parsing
    #[serde(skip_serializing_if = "Option::is_none")]
    pub caption: Option<String>,
    /// <em>Optional</em>. Mode for parsing entities in the photo caption. See <a href="#formatting-options">formatting options</a> for more details.
    #[serde(skip_serializing_if = "Option::is_none")]
    pub parse_mode: Option<ParseMode>,
    /// <em>Optional</em>. <a href="/bots#inline-keyboards-and-on-the-fly-updating">Inline keyboard</a> attached to the message
    #[serde(skip_serializing_if = "Option::is_none")]
    pub reply_markup: Option<InlineKeyboardMarkup>,
    /// <em>Optional</em>. Content of the message to be sent instead of the photo
    #[serde(skip_serializing_if = "Option::is_none")]
    pub input_message_content: Option<InputMessageContent>
}

/**
 * <p>Represents a link to an animated GIF file. By default, this animated GIF file will be sent by the user with optional caption. Alternatively, you can use <em>input_message_content</em> to send a message with the specified content instead of the animation.</p>
 *
 * @property type Type of the result, must be <em>gif</em>
 * @property id Unique identifier for this result, 1-64 bytes
 * @property gif_url A valid URL for the GIF file. File size must not exceed 1MB
 * @property gif_width <em>Optional</em>. Width of the GIF
 * @property gif_height <em>Optional</em>. Height of the GIF
 * @property gif_duration <em>Optional</em>. Duration of the GIF
 * @property thumb_url URL of the static (JPEG or GIF) or animated (MPEG4) thumbnail for the result
 * @property thumb_mime_type <em>Optional</em>. MIME type of the thumbnail, must be one of “image/jpeg”, “image/gif”, or “video/mp4”. Defaults to “image/jpeg”
 * @property title <em>Optional</em>. Title for the result
 * @property caption <em>Optional</em>. Caption of the GIF file to be sent, 0-1024 characters after entities parsing
 * @property parse_mode <em>Optional</em>. Mode for parsing entities in the caption. See <a href="#formatting-options">formatting options</a> for more details.
 * @property reply_markup <em>Optional</em>. <a href="/bots#inline-keyboards-and-on-the-fly-updating">Inline keyboard</a> attached to the message
 * @property input_message_content <em>Optional</em>. Content of the message to be sent instead of the GIF animation
 *
 * @constructor Creates a [InlineQueryResultGif].
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct InlineQueryResultGif {
    /// Type of the result, must be <em>gif</em>
    #[serde(rename = "type")]
    pub type_: String,
    /// Unique identifier for this result, 1-64 bytes
    pub id: String,
    /// A valid URL for the GIF file. File size must not exceed 1MB
    pub gif_url: String,
    /// <em>Optional</em>. Width of the GIF
    #[serde(skip_serializing_if = "Option::is_none")]
    pub gif_width: Option<Integer>,
    /// <em>Optional</em>. Height of the GIF
    #[serde(skip_serializing_if = "Option::is_none")]
    pub gif_height: Option<Integer>,
    /// <em>Optional</em>. Duration of the GIF
    #[serde(skip_serializing_if = "Option::is_none")]
    pub gif_duration: Option<Integer>,
    /// URL of the static (JPEG or GIF) or animated (MPEG4) thumbnail for the result
    pub thumb_url: String,
    /// <em>Optional</em>. MIME type of the thumbnail, must be one of “image/jpeg”, “image/gif”, or “video/mp4”. Defaults to “image/jpeg”
    #[serde(skip_serializing_if = "Option::is_none")]
    pub thumb_mime_type: Option<String>,
    /// <em>Optional</em>. Title for the result
    #[serde(skip_serializing_if = "Option::is_none")]
    pub title: Option<String>,
    /// <em>Optional</em>. Caption of the GIF file to be sent, 0-1024 characters after entities parsing
    #[serde(skip_serializing_if = "Option::is_none")]
    pub caption: Option<String>,
    /// <em>Optional</em>. Mode for parsing entities in the caption. See <a href="#formatting-options">formatting options</a> for more details.
    #[serde(skip_serializing_if = "Option::is_none")]
    pub parse_mode: Option<ParseMode>,
    /// <em>Optional</em>. <a href="/bots#inline-keyboards-and-on-the-fly-updating">Inline keyboard</a> attached to the message
    #[serde(skip_serializing_if = "Option::is_none")]
    pub reply_markup: Option<InlineKeyboardMarkup>,
    /// <em>Optional</em>. Content of the message to be sent instead of the GIF animation
    #[serde(skip_serializing_if = "Option::is_none")]
    pub input_message_content: Option<InputMessageContent>
}

/**
 * <p>Represents a link to a video animation (H.264/MPEG-4 AVC video without sound). By default, this animated MPEG-4 file will be sent by the user with optional caption. Alternatively, you can use <em>input_message_content</em> to send a message with the specified content instead of the animation.</p>
 *
 * @property type Type of the result, must be <em>mpeg4_gif</em>
 * @property id Unique identifier for this result, 1-64 bytes
 * @property mpeg4_url A valid URL for the MP4 file. File size must not exceed 1MB
 * @property mpeg4_width <em>Optional</em>. Video width
 * @property mpeg4_height <em>Optional</em>. Video height
 * @property mpeg4_duration <em>Optional</em>. Video duration
 * @property thumb_url URL of the static (JPEG or GIF) or animated (MPEG4) thumbnail for the result
 * @property thumb_mime_type <em>Optional</em>. MIME type of the thumbnail, must be one of “image/jpeg”, “image/gif”, or “video/mp4”. Defaults to “image/jpeg”
 * @property title <em>Optional</em>. Title for the result
 * @property caption <em>Optional</em>. Caption of the MPEG-4 file to be sent, 0-1024 characters after entities parsing
 * @property parse_mode <em>Optional</em>. Mode for parsing entities in the caption. See <a href="#formatting-options">formatting options</a> for more details.
 * @property reply_markup <em>Optional</em>. <a href="/bots#inline-keyboards-and-on-the-fly-updating">Inline keyboard</a> attached to the message
 * @property input_message_content <em>Optional</em>. Content of the message to be sent instead of the video animation
 *
 * @constructor Creates a [InlineQueryResultMpeg4Gif].
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct InlineQueryResultMpeg4Gif {
    /// Type of the result, must be <em>mpeg4_gif</em>
    #[serde(rename = "type")]
    pub type_: String,
    /// Unique identifier for this result, 1-64 bytes
    pub id: String,
    /// A valid URL for the MP4 file. File size must not exceed 1MB
    pub mpeg4_url: String,
    /// <em>Optional</em>. Video width
    #[serde(skip_serializing_if = "Option::is_none")]
    pub mpeg4_width: Option<Integer>,
    /// <em>Optional</em>. Video height
    #[serde(skip_serializing_if = "Option::is_none")]
    pub mpeg4_height: Option<Integer>,
    /// <em>Optional</em>. Video duration
    #[serde(skip_serializing_if = "Option::is_none")]
    pub mpeg4_duration: Option<Integer>,
    /// URL of the static (JPEG or GIF) or animated (MPEG4) thumbnail for the result
    pub thumb_url: String,
    /// <em>Optional</em>. MIME type of the thumbnail, must be one of “image/jpeg”, “image/gif”, or “video/mp4”. Defaults to “image/jpeg”
    #[serde(skip_serializing_if = "Option::is_none")]
    pub thumb_mime_type: Option<String>,
    /// <em>Optional</em>. Title for the result
    #[serde(skip_serializing_if = "Option::is_none")]
    pub title: Option<String>,
    /// <em>Optional</em>. Caption of the MPEG-4 file to be sent, 0-1024 characters after entities parsing
    #[serde(skip_serializing_if = "Option::is_none")]
    pub caption: Option<String>,
    /// <em>Optional</em>. Mode for parsing entities in the caption. See <a href="#formatting-options">formatting options</a> for more details.
    #[serde(skip_serializing_if = "Option::is_none")]
    pub parse_mode: Option<ParseMode>,
    /// <em>Optional</em>. <a href="/bots#inline-keyboards-and-on-the-fly-updating">Inline keyboard</a> attached to the message
    #[serde(skip_serializing_if = "Option::is_none")]
    pub reply_markup: Option<InlineKeyboardMarkup>,
    /// <em>Optional</em>. Content of the message to be sent instead of the video animation
    #[serde(skip_serializing_if = "Option::is_none")]
    pub input_message_content: Option<InputMessageContent>
}

/**
 * <p>Represents a link to a page containing an embedded video player or a video file. By default, this video file will be sent by the user with an optional caption. Alternatively, you can use <em>input_message_content</em> to send a message with the specified content instead of the video.</p><blockquote> 
 *  <p>If an InlineQueryResultVideo message contains an embedded video (e.g., YouTube), you <strong>must</strong> replace its content using <em>input_message_content</em>.</p> 
 * </blockquote>
 *
 * @property type Type of the result, must be <em>video</em>
 * @property id Unique identifier for this result, 1-64 bytes
 * @property video_url A valid URL for the embedded video player or video file
 * @property mime_type Mime type of the content of video url, “text/html” or “video/mp4”
 * @property thumb_url URL of the thumbnail (jpeg only) for the video
 * @property title Title for the result
 * @property caption <em>Optional</em>. Caption of the video to be sent, 0-1024 characters after entities parsing
 * @property parse_mode <em>Optional</em>. Mode for parsing entities in the video caption. See <a href="#formatting-options">formatting options</a> for more details.
 * @property video_width <em>Optional</em>. Video width
 * @property video_height <em>Optional</em>. Video height
 * @property video_duration <em>Optional</em>. Video duration in seconds
 * @property description <em>Optional</em>. Short description of the result
 * @property reply_markup <em>Optional</em>. <a href="/bots#inline-keyboards-and-on-the-fly-updating">Inline keyboard</a> attached to the message
 * @property input_message_content <em>Optional</em>. Content of the message to be sent instead of the video. This field is <strong>required</strong> if InlineQueryResultVideo is used to send an HTML-page as a result (e.g., a YouTube video).
 *
 * @constructor Creates a [InlineQueryResultVideo].
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct InlineQueryResultVideo {
    /// Type of the result, must be <em>video</em>
    #[serde(rename = "type")]
    pub type_: String,
    /// Unique identifier for this result, 1-64 bytes
    pub id: String,
    /// A valid URL for the embedded video player or video file
    pub video_url: String,
    /// Mime type of the content of video url, “text/html” or “video/mp4”
    pub mime_type: String,
    /// URL of the thumbnail (jpeg only) for the video
    pub thumb_url: String,
    /// Title for the result
    pub title: String,
    /// <em>Optional</em>. Caption of the video to be sent, 0-1024 characters after entities parsing
    #[serde(skip_serializing_if = "Option::is_none")]
    pub caption: Option<String>,
    /// <em>Optional</em>. Mode for parsing entities in the video caption. See <a href="#formatting-options">formatting options</a> for more details.
    #[serde(skip_serializing_if = "Option::is_none")]
    pub parse_mode: Option<ParseMode>,
    /// <em>Optional</em>. Video width
    #[serde(skip_serializing_if = "Option::is_none")]
    pub video_width: Option<Integer>,
    /// <em>Optional</em>. Video height
    #[serde(skip_serializing_if = "Option::is_none")]
    pub video_height: Option<Integer>,
    /// <em>Optional</em>. Video duration in seconds
    #[serde(skip_serializing_if = "Option::is_none")]
    pub video_duration: Option<Integer>,
    /// <em>Optional</em>. Short description of the result
    #[serde(skip_serializing_if = "Option::is_none")]
    pub description: Option<String>,
    /// <em>Optional</em>. <a href="/bots#inline-keyboards-and-on-the-fly-updating">Inline keyboard</a> attached to the message
    #[serde(skip_serializing_if = "Option::is_none")]
    pub reply_markup: Option<InlineKeyboardMarkup>,
    /// <em>Optional</em>. Content of the message to be sent instead of the video. This field is <strong>required</strong> if InlineQueryResultVideo is used to send an HTML-page as a result (e.g., a YouTube video).
    #[serde(skip_serializing_if = "Option::is_none")]
    pub input_message_content: Option<InputMessageContent>
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
 * @property performer <em>Optional</em>. Performer
 * @property audio_duration <em>Optional</em>. Audio duration in seconds
 * @property reply_markup <em>Optional</em>. <a href="/bots#inline-keyboards-and-on-the-fly-updating">Inline keyboard</a> attached to the message
 * @property input_message_content <em>Optional</em>. Content of the message to be sent instead of the audio
 *
 * @constructor Creates a [InlineQueryResultAudio].
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct InlineQueryResultAudio {
    /// Type of the result, must be <em>audio</em>
    #[serde(rename = "type")]
    pub type_: String,
    /// Unique identifier for this result, 1-64 bytes
    pub id: String,
    /// A valid URL for the audio file
    pub audio_url: String,
    /// Title
    pub title: String,
    /// <em>Optional</em>. Caption, 0-1024 characters after entities parsing
    #[serde(skip_serializing_if = "Option::is_none")]
    pub caption: Option<String>,
    /// <em>Optional</em>. Mode for parsing entities in the audio caption. See <a href="#formatting-options">formatting options</a> for more details.
    #[serde(skip_serializing_if = "Option::is_none")]
    pub parse_mode: Option<ParseMode>,
    /// <em>Optional</em>. Performer
    #[serde(skip_serializing_if = "Option::is_none")]
    pub performer: Option<String>,
    /// <em>Optional</em>. Audio duration in seconds
    #[serde(skip_serializing_if = "Option::is_none")]
    pub audio_duration: Option<Integer>,
    /// <em>Optional</em>. <a href="/bots#inline-keyboards-and-on-the-fly-updating">Inline keyboard</a> attached to the message
    #[serde(skip_serializing_if = "Option::is_none")]
    pub reply_markup: Option<InlineKeyboardMarkup>,
    /// <em>Optional</em>. Content of the message to be sent instead of the audio
    #[serde(skip_serializing_if = "Option::is_none")]
    pub input_message_content: Option<InputMessageContent>
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
 * @property voice_duration <em>Optional</em>. Recording duration in seconds
 * @property reply_markup <em>Optional</em>. <a href="/bots#inline-keyboards-and-on-the-fly-updating">Inline keyboard</a> attached to the message
 * @property input_message_content <em>Optional</em>. Content of the message to be sent instead of the voice recording
 *
 * @constructor Creates a [InlineQueryResultVoice].
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct InlineQueryResultVoice {
    /// Type of the result, must be <em>voice</em>
    #[serde(rename = "type")]
    pub type_: String,
    /// Unique identifier for this result, 1-64 bytes
    pub id: String,
    /// A valid URL for the voice recording
    pub voice_url: String,
    /// Recording title
    pub title: String,
    /// <em>Optional</em>. Caption, 0-1024 characters after entities parsing
    #[serde(skip_serializing_if = "Option::is_none")]
    pub caption: Option<String>,
    /// <em>Optional</em>. Mode for parsing entities in the voice message caption. See <a href="#formatting-options">formatting options</a> for more details.
    #[serde(skip_serializing_if = "Option::is_none")]
    pub parse_mode: Option<ParseMode>,
    /// <em>Optional</em>. Recording duration in seconds
    #[serde(skip_serializing_if = "Option::is_none")]
    pub voice_duration: Option<Integer>,
    /// <em>Optional</em>. <a href="/bots#inline-keyboards-and-on-the-fly-updating">Inline keyboard</a> attached to the message
    #[serde(skip_serializing_if = "Option::is_none")]
    pub reply_markup: Option<InlineKeyboardMarkup>,
    /// <em>Optional</em>. Content of the message to be sent instead of the voice recording
    #[serde(skip_serializing_if = "Option::is_none")]
    pub input_message_content: Option<InputMessageContent>
}

/**
 * <p>Represents a link to a file. By default, this file will be sent by the user with an optional caption. Alternatively, you can use <em>input_message_content</em> to send a message with the specified content instead of the file. Currently, only <strong>.PDF</strong> and <strong>.ZIP</strong> files can be sent using this method.</p><p><strong>Note:</strong> This will only work in Telegram versions released after 9 April, 2016. Older clients will ignore them.</p>
 *
 * @property type Type of the result, must be <em>document</em>
 * @property id Unique identifier for this result, 1-64 bytes
 * @property title Title for the result
 * @property caption <em>Optional</em>. Caption of the document to be sent, 0-1024 characters after entities parsing
 * @property parse_mode <em>Optional</em>. Mode for parsing entities in the document caption. See <a href="#formatting-options">formatting options</a> for more details.
 * @property document_url A valid URL for the file
 * @property mime_type Mime type of the content of the file, either “application/pdf” or “application/zip”
 * @property description <em>Optional</em>. Short description of the result
 * @property reply_markup <em>Optional</em>. Inline keyboard attached to the message
 * @property input_message_content <em>Optional</em>. Content of the message to be sent instead of the file
 * @property thumb_url <em>Optional</em>. URL of the thumbnail (jpeg only) for the file
 * @property thumb_width <em>Optional</em>. Thumbnail width
 * @property thumb_height <em>Optional</em>. Thumbnail height
 *
 * @constructor Creates a [InlineQueryResultDocument].
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct InlineQueryResultDocument {
    /// Type of the result, must be <em>document</em>
    #[serde(rename = "type")]
    pub type_: String,
    /// Unique identifier for this result, 1-64 bytes
    pub id: String,
    /// Title for the result
    pub title: String,
    /// <em>Optional</em>. Caption of the document to be sent, 0-1024 characters after entities parsing
    #[serde(skip_serializing_if = "Option::is_none")]
    pub caption: Option<String>,
    /// <em>Optional</em>. Mode for parsing entities in the document caption. See <a href="#formatting-options">formatting options</a> for more details.
    #[serde(skip_serializing_if = "Option::is_none")]
    pub parse_mode: Option<ParseMode>,
    /// A valid URL for the file
    pub document_url: String,
    /// Mime type of the content of the file, either “application/pdf” or “application/zip”
    pub mime_type: String,
    /// <em>Optional</em>. Short description of the result
    #[serde(skip_serializing_if = "Option::is_none")]
    pub description: Option<String>,
    /// <em>Optional</em>. Inline keyboard attached to the message
    #[serde(skip_serializing_if = "Option::is_none")]
    pub reply_markup: Option<InlineKeyboardMarkup>,
    /// <em>Optional</em>. Content of the message to be sent instead of the file
    #[serde(skip_serializing_if = "Option::is_none")]
    pub input_message_content: Option<InputMessageContent>,
    /// <em>Optional</em>. URL of the thumbnail (jpeg only) for the file
    #[serde(skip_serializing_if = "Option::is_none")]
    pub thumb_url: Option<String>,
    /// <em>Optional</em>. Thumbnail width
    #[serde(skip_serializing_if = "Option::is_none")]
    pub thumb_width: Option<Integer>,
    /// <em>Optional</em>. Thumbnail height
    #[serde(skip_serializing_if = "Option::is_none")]
    pub thumb_height: Option<Integer>
}

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
 * @constructor Creates a [InlineQueryResultLocation].
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct InlineQueryResultLocation {
    /// Type of the result, must be <em>location</em>
    #[serde(rename = "type")]
    pub type_: String,
    /// Unique identifier for this result, 1-64 Bytes
    pub id: String,
    /// Location latitude in degrees
    pub latitude: Float,
    /// Location longitude in degrees
    pub longitude: Float,
    /// Location title
    pub title: String,
    /// <em>Optional</em>. Period in seconds for which the location can be updated, should be between 60 and 86400.
    #[serde(skip_serializing_if = "Option::is_none")]
    pub live_period: Option<Integer>,
    /// <em>Optional</em>. <a href="/bots#inline-keyboards-and-on-the-fly-updating">Inline keyboard</a> attached to the message
    #[serde(skip_serializing_if = "Option::is_none")]
    pub reply_markup: Option<InlineKeyboardMarkup>,
    /// <em>Optional</em>. Content of the message to be sent instead of the location
    #[serde(skip_serializing_if = "Option::is_none")]
    pub input_message_content: Option<InputMessageContent>,
    /// <em>Optional</em>. Url of the thumbnail for the result
    #[serde(skip_serializing_if = "Option::is_none")]
    pub thumb_url: Option<String>,
    /// <em>Optional</em>. Thumbnail width
    #[serde(skip_serializing_if = "Option::is_none")]
    pub thumb_width: Option<Integer>,
    /// <em>Optional</em>. Thumbnail height
    #[serde(skip_serializing_if = "Option::is_none")]
    pub thumb_height: Option<Integer>
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
 * @property reply_markup <em>Optional</em>. <a href="/bots#inline-keyboards-and-on-the-fly-updating">Inline keyboard</a> attached to the message
 * @property input_message_content <em>Optional</em>. Content of the message to be sent instead of the venue
 * @property thumb_url <em>Optional</em>. Url of the thumbnail for the result
 * @property thumb_width <em>Optional</em>. Thumbnail width
 * @property thumb_height <em>Optional</em>. Thumbnail height
 *
 * @constructor Creates a [InlineQueryResultVenue].
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct InlineQueryResultVenue {
    /// Type of the result, must be <em>venue</em>
    #[serde(rename = "type")]
    pub type_: String,
    /// Unique identifier for this result, 1-64 Bytes
    pub id: String,
    /// Latitude of the venue location in degrees
    pub latitude: Float,
    /// Longitude of the venue location in degrees
    pub longitude: Float,
    /// Title of the venue
    pub title: String,
    /// Address of the venue
    pub address: String,
    /// <em>Optional</em>. Foursquare identifier of the venue if known
    #[serde(skip_serializing_if = "Option::is_none")]
    pub foursquare_id: Option<String>,
    /// <em>Optional</em>. Foursquare type of the venue, if known. (For example, “arts_entertainment/default”, “arts_entertainment/aquarium” or “food/icecream”.)
    #[serde(skip_serializing_if = "Option::is_none")]
    pub foursquare_type: Option<String>,
    /// <em>Optional</em>. <a href="/bots#inline-keyboards-and-on-the-fly-updating">Inline keyboard</a> attached to the message
    #[serde(skip_serializing_if = "Option::is_none")]
    pub reply_markup: Option<InlineKeyboardMarkup>,
    /// <em>Optional</em>. Content of the message to be sent instead of the venue
    #[serde(skip_serializing_if = "Option::is_none")]
    pub input_message_content: Option<InputMessageContent>,
    /// <em>Optional</em>. Url of the thumbnail for the result
    #[serde(skip_serializing_if = "Option::is_none")]
    pub thumb_url: Option<String>,
    /// <em>Optional</em>. Thumbnail width
    #[serde(skip_serializing_if = "Option::is_none")]
    pub thumb_width: Option<Integer>,
    /// <em>Optional</em>. Thumbnail height
    #[serde(skip_serializing_if = "Option::is_none")]
    pub thumb_height: Option<Integer>
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
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct InlineQueryResultContact {
    /// Type of the result, must be <em>contact</em>
    #[serde(rename = "type")]
    pub type_: String,
    /// Unique identifier for this result, 1-64 Bytes
    pub id: String,
    /// Contact's phone number
    pub phone_number: String,
    /// Contact's first name
    pub first_name: String,
    /// <em>Optional</em>. Contact's last name
    #[serde(skip_serializing_if = "Option::is_none")]
    pub last_name: Option<String>,
    /// <em>Optional</em>. Additional data about the contact in the form of a <a href="https://en.wikipedia.org/wiki/VCard">vCard</a>, 0-2048 bytes
    #[serde(skip_serializing_if = "Option::is_none")]
    pub vcard: Option<String>,
    /// <em>Optional</em>. <a href="/bots#inline-keyboards-and-on-the-fly-updating">Inline keyboard</a> attached to the message
    #[serde(skip_serializing_if = "Option::is_none")]
    pub reply_markup: Option<InlineKeyboardMarkup>,
    /// <em>Optional</em>. Content of the message to be sent instead of the contact
    #[serde(skip_serializing_if = "Option::is_none")]
    pub input_message_content: Option<InputMessageContent>,
    /// <em>Optional</em>. Url of the thumbnail for the result
    #[serde(skip_serializing_if = "Option::is_none")]
    pub thumb_url: Option<String>,
    /// <em>Optional</em>. Thumbnail width
    #[serde(skip_serializing_if = "Option::is_none")]
    pub thumb_width: Option<Integer>,
    /// <em>Optional</em>. Thumbnail height
    #[serde(skip_serializing_if = "Option::is_none")]
    pub thumb_height: Option<Integer>
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
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct InlineQueryResultGame {
    /// Type of the result, must be <em>game</em>
    #[serde(rename = "type")]
    pub type_: String,
    /// Unique identifier for this result, 1-64 bytes
    pub id: String,
    /// Short name of the game
    pub game_short_name: String,
    /// <em>Optional</em>. <a href="/bots#inline-keyboards-and-on-the-fly-updating">Inline keyboard</a> attached to the message
    #[serde(skip_serializing_if = "Option::is_none")]
    pub reply_markup: Option<InlineKeyboardMarkup>
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
 * @property reply_markup <em>Optional</em>. <a href="/bots#inline-keyboards-and-on-the-fly-updating">Inline keyboard</a> attached to the message
 * @property input_message_content <em>Optional</em>. Content of the message to be sent instead of the photo
 *
 * @constructor Creates a [InlineQueryResultCachedPhoto].
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct InlineQueryResultCachedPhoto {
    /// Type of the result, must be <em>photo</em>
    #[serde(rename = "type")]
    pub type_: String,
    /// Unique identifier for this result, 1-64 bytes
    pub id: String,
    /// A valid file identifier of the photo
    pub photo_file_id: String,
    /// <em>Optional</em>. Title for the result
    #[serde(skip_serializing_if = "Option::is_none")]
    pub title: Option<String>,
    /// <em>Optional</em>. Short description of the result
    #[serde(skip_serializing_if = "Option::is_none")]
    pub description: Option<String>,
    /// <em>Optional</em>. Caption of the photo to be sent, 0-1024 characters after entities parsing
    #[serde(skip_serializing_if = "Option::is_none")]
    pub caption: Option<String>,
    /// <em>Optional</em>. Mode for parsing entities in the photo caption. See <a href="#formatting-options">formatting options</a> for more details.
    #[serde(skip_serializing_if = "Option::is_none")]
    pub parse_mode: Option<ParseMode>,
    /// <em>Optional</em>. <a href="/bots#inline-keyboards-and-on-the-fly-updating">Inline keyboard</a> attached to the message
    #[serde(skip_serializing_if = "Option::is_none")]
    pub reply_markup: Option<InlineKeyboardMarkup>,
    /// <em>Optional</em>. Content of the message to be sent instead of the photo
    #[serde(skip_serializing_if = "Option::is_none")]
    pub input_message_content: Option<InputMessageContent>
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
 * @property reply_markup <em>Optional</em>. <a href="/bots#inline-keyboards-and-on-the-fly-updating">Inline keyboard</a> attached to the message
 * @property input_message_content <em>Optional</em>. Content of the message to be sent instead of the GIF animation
 *
 * @constructor Creates a [InlineQueryResultCachedGif].
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct InlineQueryResultCachedGif {
    /// Type of the result, must be <em>gif</em>
    #[serde(rename = "type")]
    pub type_: String,
    /// Unique identifier for this result, 1-64 bytes
    pub id: String,
    /// A valid file identifier for the GIF file
    pub gif_file_id: String,
    /// <em>Optional</em>. Title for the result
    #[serde(skip_serializing_if = "Option::is_none")]
    pub title: Option<String>,
    /// <em>Optional</em>. Caption of the GIF file to be sent, 0-1024 characters after entities parsing
    #[serde(skip_serializing_if = "Option::is_none")]
    pub caption: Option<String>,
    /// <em>Optional</em>. Mode for parsing entities in the caption. See <a href="#formatting-options">formatting options</a> for more details.
    #[serde(skip_serializing_if = "Option::is_none")]
    pub parse_mode: Option<ParseMode>,
    /// <em>Optional</em>. <a href="/bots#inline-keyboards-and-on-the-fly-updating">Inline keyboard</a> attached to the message
    #[serde(skip_serializing_if = "Option::is_none")]
    pub reply_markup: Option<InlineKeyboardMarkup>,
    /// <em>Optional</em>. Content of the message to be sent instead of the GIF animation
    #[serde(skip_serializing_if = "Option::is_none")]
    pub input_message_content: Option<InputMessageContent>
}

/**
 * <p>Represents a link to a video animation (H.264/MPEG-4 AVC video without sound) stored on the Telegram servers. By default, this animated MPEG-4 file will be sent by the user with an optional caption. Alternatively, you can use <em>input_message_content</em> to send a message with the specified content instead of the animation.</p>
 *
 * @property type Type of the result, must be <em>mpeg4_gif</em>
 * @property id Unique identifier for this result, 1-64 bytes
 * @property mpeg4_file_id A valid file identifier for the MP4 file
 * @property title <em>Optional</em>. Title for the result
 * @property caption <em>Optional</em>. Caption of the MPEG-4 file to be sent, 0-1024 characters after entities parsing
 * @property parse_mode <em>Optional</em>. Mode for parsing entities in the caption. See <a href="#formatting-options">formatting options</a> for more details.
 * @property reply_markup <em>Optional</em>. <a href="/bots#inline-keyboards-and-on-the-fly-updating">Inline keyboard</a> attached to the message
 * @property input_message_content <em>Optional</em>. Content of the message to be sent instead of the video animation
 *
 * @constructor Creates a [InlineQueryResultCachedMpeg4Gif].
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct InlineQueryResultCachedMpeg4Gif {
    /// Type of the result, must be <em>mpeg4_gif</em>
    #[serde(rename = "type")]
    pub type_: String,
    /// Unique identifier for this result, 1-64 bytes
    pub id: String,
    /// A valid file identifier for the MP4 file
    pub mpeg4_file_id: String,
    /// <em>Optional</em>. Title for the result
    #[serde(skip_serializing_if = "Option::is_none")]
    pub title: Option<String>,
    /// <em>Optional</em>. Caption of the MPEG-4 file to be sent, 0-1024 characters after entities parsing
    #[serde(skip_serializing_if = "Option::is_none")]
    pub caption: Option<String>,
    /// <em>Optional</em>. Mode for parsing entities in the caption. See <a href="#formatting-options">formatting options</a> for more details.
    #[serde(skip_serializing_if = "Option::is_none")]
    pub parse_mode: Option<ParseMode>,
    /// <em>Optional</em>. <a href="/bots#inline-keyboards-and-on-the-fly-updating">Inline keyboard</a> attached to the message
    #[serde(skip_serializing_if = "Option::is_none")]
    pub reply_markup: Option<InlineKeyboardMarkup>,
    /// <em>Optional</em>. Content of the message to be sent instead of the video animation
    #[serde(skip_serializing_if = "Option::is_none")]
    pub input_message_content: Option<InputMessageContent>
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
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct InlineQueryResultCachedSticker {
    /// Type of the result, must be <em>sticker</em>
    #[serde(rename = "type")]
    pub type_: String,
    /// Unique identifier for this result, 1-64 bytes
    pub id: String,
    /// A valid file identifier of the sticker
    pub sticker_file_id: String,
    /// <em>Optional</em>. <a href="/bots#inline-keyboards-and-on-the-fly-updating">Inline keyboard</a> attached to the message
    #[serde(skip_serializing_if = "Option::is_none")]
    pub reply_markup: Option<InlineKeyboardMarkup>,
    /// <em>Optional</em>. Content of the message to be sent instead of the sticker
    #[serde(skip_serializing_if = "Option::is_none")]
    pub input_message_content: Option<InputMessageContent>
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
 * @property reply_markup <em>Optional</em>. <a href="/bots#inline-keyboards-and-on-the-fly-updating">Inline keyboard</a> attached to the message
 * @property input_message_content <em>Optional</em>. Content of the message to be sent instead of the file
 *
 * @constructor Creates a [InlineQueryResultCachedDocument].
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct InlineQueryResultCachedDocument {
    /// Type of the result, must be <em>document</em>
    #[serde(rename = "type")]
    pub type_: String,
    /// Unique identifier for this result, 1-64 bytes
    pub id: String,
    /// Title for the result
    pub title: String,
    /// A valid file identifier for the file
    pub document_file_id: String,
    /// <em>Optional</em>. Short description of the result
    #[serde(skip_serializing_if = "Option::is_none")]
    pub description: Option<String>,
    /// <em>Optional</em>. Caption of the document to be sent, 0-1024 characters after entities parsing
    #[serde(skip_serializing_if = "Option::is_none")]
    pub caption: Option<String>,
    /// <em>Optional</em>. Mode for parsing entities in the document caption. See <a href="#formatting-options">formatting options</a> for more details.
    #[serde(skip_serializing_if = "Option::is_none")]
    pub parse_mode: Option<ParseMode>,
    /// <em>Optional</em>. <a href="/bots#inline-keyboards-and-on-the-fly-updating">Inline keyboard</a> attached to the message
    #[serde(skip_serializing_if = "Option::is_none")]
    pub reply_markup: Option<InlineKeyboardMarkup>,
    /// <em>Optional</em>. Content of the message to be sent instead of the file
    #[serde(skip_serializing_if = "Option::is_none")]
    pub input_message_content: Option<InputMessageContent>
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
 * @property reply_markup <em>Optional</em>. <a href="/bots#inline-keyboards-and-on-the-fly-updating">Inline keyboard</a> attached to the message
 * @property input_message_content <em>Optional</em>. Content of the message to be sent instead of the video
 *
 * @constructor Creates a [InlineQueryResultCachedVideo].
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct InlineQueryResultCachedVideo {
    /// Type of the result, must be <em>video</em>
    #[serde(rename = "type")]
    pub type_: String,
    /// Unique identifier for this result, 1-64 bytes
    pub id: String,
    /// A valid file identifier for the video file
    pub video_file_id: String,
    /// Title for the result
    pub title: String,
    /// <em>Optional</em>. Short description of the result
    #[serde(skip_serializing_if = "Option::is_none")]
    pub description: Option<String>,
    /// <em>Optional</em>. Caption of the video to be sent, 0-1024 characters after entities parsing
    #[serde(skip_serializing_if = "Option::is_none")]
    pub caption: Option<String>,
    /// <em>Optional</em>. Mode for parsing entities in the video caption. See <a href="#formatting-options">formatting options</a> for more details.
    #[serde(skip_serializing_if = "Option::is_none")]
    pub parse_mode: Option<ParseMode>,
    /// <em>Optional</em>. <a href="/bots#inline-keyboards-and-on-the-fly-updating">Inline keyboard</a> attached to the message
    #[serde(skip_serializing_if = "Option::is_none")]
    pub reply_markup: Option<InlineKeyboardMarkup>,
    /// <em>Optional</em>. Content of the message to be sent instead of the video
    #[serde(skip_serializing_if = "Option::is_none")]
    pub input_message_content: Option<InputMessageContent>
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
 * @property reply_markup <em>Optional</em>. <a href="/bots#inline-keyboards-and-on-the-fly-updating">Inline keyboard</a> attached to the message
 * @property input_message_content <em>Optional</em>. Content of the message to be sent instead of the voice message
 *
 * @constructor Creates a [InlineQueryResultCachedVoice].
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct InlineQueryResultCachedVoice {
    /// Type of the result, must be <em>voice</em>
    #[serde(rename = "type")]
    pub type_: String,
    /// Unique identifier for this result, 1-64 bytes
    pub id: String,
    /// A valid file identifier for the voice message
    pub voice_file_id: String,
    /// Voice message title
    pub title: String,
    /// <em>Optional</em>. Caption, 0-1024 characters after entities parsing
    #[serde(skip_serializing_if = "Option::is_none")]
    pub caption: Option<String>,
    /// <em>Optional</em>. Mode for parsing entities in the voice message caption. See <a href="#formatting-options">formatting options</a> for more details.
    #[serde(skip_serializing_if = "Option::is_none")]
    pub parse_mode: Option<ParseMode>,
    /// <em>Optional</em>. <a href="/bots#inline-keyboards-and-on-the-fly-updating">Inline keyboard</a> attached to the message
    #[serde(skip_serializing_if = "Option::is_none")]
    pub reply_markup: Option<InlineKeyboardMarkup>,
    /// <em>Optional</em>. Content of the message to be sent instead of the voice message
    #[serde(skip_serializing_if = "Option::is_none")]
    pub input_message_content: Option<InputMessageContent>
}

/**
 * <p>Represents a link to an MP3 audio file stored on the Telegram servers. By default, this audio file will be sent by the user. Alternatively, you can use <em>input_message_content</em> to send a message with the specified content instead of the audio.</p><p><strong>Note:</strong> This will only work in Telegram versions released after 9 April, 2016. Older clients will ignore them.</p>
 *
 * @property type Type of the result, must be <em>audio</em>
 * @property id Unique identifier for this result, 1-64 bytes
 * @property audio_file_id A valid file identifier for the audio file
 * @property caption <em>Optional</em>. Caption, 0-1024 characters after entities parsing
 * @property parse_mode <em>Optional</em>. Mode for parsing entities in the audio caption. See <a href="#formatting-options">formatting options</a> for more details.
 * @property reply_markup <em>Optional</em>. <a href="/bots#inline-keyboards-and-on-the-fly-updating">Inline keyboard</a> attached to the message
 * @property input_message_content <em>Optional</em>. Content of the message to be sent instead of the audio
 *
 * @constructor Creates a [InlineQueryResultCachedAudio].
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct InlineQueryResultCachedAudio {
    /// Type of the result, must be <em>audio</em>
    #[serde(rename = "type")]
    pub type_: String,
    /// Unique identifier for this result, 1-64 bytes
    pub id: String,
    /// A valid file identifier for the audio file
    pub audio_file_id: String,
    /// <em>Optional</em>. Caption, 0-1024 characters after entities parsing
    #[serde(skip_serializing_if = "Option::is_none")]
    pub caption: Option<String>,
    /// <em>Optional</em>. Mode for parsing entities in the audio caption. See <a href="#formatting-options">formatting options</a> for more details.
    #[serde(skip_serializing_if = "Option::is_none")]
    pub parse_mode: Option<ParseMode>,
    /// <em>Optional</em>. <a href="/bots#inline-keyboards-and-on-the-fly-updating">Inline keyboard</a> attached to the message
    #[serde(skip_serializing_if = "Option::is_none")]
    pub reply_markup: Option<InlineKeyboardMarkup>,
    /// <em>Optional</em>. Content of the message to be sent instead of the audio
    #[serde(skip_serializing_if = "Option::is_none")]
    pub input_message_content: Option<InputMessageContent>
}

/**
 * <p>Represents the <a href="#inputmessagecontent">content</a> of a text message to be sent as the result of an inline query.</p>
 *
 * @property message_text Text of the message to be sent, 1-4096 characters
 * @property parse_mode <em>Optional</em>. Mode for parsing entities in the message text. See <a href="#formatting-options">formatting options</a> for more details.
 * @property disable_web_page_preview <em>Optional</em>. Disables link previews for links in the sent message
 *
 * @constructor Creates a [InputTextMessageContent].
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct InputTextMessageContent {
    /// Text of the message to be sent, 1-4096 characters
    pub message_text: String,
    /// <em>Optional</em>. Mode for parsing entities in the message text. See <a href="#formatting-options">formatting options</a> for more details.
    #[serde(skip_serializing_if = "Option::is_none")]
    pub parse_mode: Option<ParseMode>,
    /// <em>Optional</em>. Disables link previews for links in the sent message
    #[serde(skip_serializing_if = "Option::is_none")]
    pub disable_web_page_preview: Option<bool>
}

/**
 * <p>Represents the <a href="#inputmessagecontent">content</a> of a location message to be sent as the result of an inline query.</p>
 *
 * @property latitude Latitude of the location in degrees
 * @property longitude Longitude of the location in degrees
 * @property live_period <em>Optional</em>. Period in seconds for which the location can be updated, should be between 60 and 86400.
 *
 * @constructor Creates a [InputLocationMessageContent].
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct InputLocationMessageContent {
    /// Latitude of the location in degrees
    pub latitude: Float,
    /// Longitude of the location in degrees
    pub longitude: Float,
    /// <em>Optional</em>. Period in seconds for which the location can be updated, should be between 60 and 86400.
    #[serde(skip_serializing_if = "Option::is_none")]
    pub live_period: Option<Integer>
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
 *
 * @constructor Creates a [InputVenueMessageContent].
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct InputVenueMessageContent {
    /// Latitude of the venue in degrees
    pub latitude: Float,
    /// Longitude of the venue in degrees
    pub longitude: Float,
    /// Name of the venue
    pub title: String,
    /// Address of the venue
    pub address: String,
    /// <em>Optional</em>. Foursquare identifier of the venue, if known
    #[serde(skip_serializing_if = "Option::is_none")]
    pub foursquare_id: Option<String>,
    /// <em>Optional</em>. Foursquare type of the venue, if known. (For example, “arts_entertainment/default”, “arts_entertainment/aquarium” or “food/icecream”.)
    #[serde(skip_serializing_if = "Option::is_none")]
    pub foursquare_type: Option<String>
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
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct InputContactMessageContent {
    /// Contact's phone number
    pub phone_number: String,
    /// Contact's first name
    pub first_name: String,
    /// <em>Optional</em>. Contact's last name
    #[serde(skip_serializing_if = "Option::is_none")]
    pub last_name: Option<String>,
    /// <em>Optional</em>. Additional data about the contact in the form of a <a href="https://en.wikipedia.org/wiki/VCard">vCard</a>, 0-2048 bytes
    #[serde(skip_serializing_if = "Option::is_none")]
    pub vcard: Option<String>
}

/**
 * <p>Represents a <a href="#inlinequeryresult">result</a> of an inline query that was chosen by the user and sent to their chat partner.</p><p><strong>Note:</strong> It is necessary to enable <a href="/bots/inline#collecting-feedback">inline feedback</a> via <a href="https://t.me/botfather">@Botfather</a> in order to receive these objects in updates.</p>
 *
 * @property result_id The unique identifier for the result that was chosen
 * @property from The user that chose the result
 * @property location <em>Optional</em>. Sender location, only for bots that require user location
 * @property inline_message_id <em>Optional</em>. Identifier of the sent inline message. Available only if there is an <a href="#inlinekeyboardmarkup">inline keyboard</a> attached to the message. Will be also received in <a href="#callbackquery">callback queries</a> and can be used to <a href="#updating-messages">edit</a> the message.
 * @property query The query that was used to obtain the result
 *
 * @constructor Creates a [ChosenInlineResult].
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct ChosenInlineResult {
    /// The unique identifier for the result that was chosen
    pub result_id: String,
    /// The user that chose the result
    pub from: User,
    /// <em>Optional</em>. Sender location, only for bots that require user location
    #[serde(skip_serializing_if = "Option::is_none")]
    pub location: Option<Location>,
    /// <em>Optional</em>. Identifier of the sent inline message. Available only if there is an <a href="#inlinekeyboardmarkup">inline keyboard</a> attached to the message. Will be also received in <a href="#callbackquery">callback queries</a> and can be used to <a href="#updating-messages">edit</a> the message.
    #[serde(skip_serializing_if = "Option::is_none")]
    pub inline_message_id: Option<String>,
    /// The query that was used to obtain the result
    pub query: String
}


/// Payments

/**
 * <p>This object represents a portion of the price for goods or services.</p>
 *
 * @property label Portion label
 * @property amount Price of the product in the <em>smallest units</em> of the <a href="/bots/payments#supported-currencies">currency</a> (integer, <strong>not</strong> float/double). For example, for a price of <code>US$ 1.45</code> pass <code>amount = 145</code>. See the <em>exp</em> parameter in <a href="https://core.telegram.org/bots/payments/currencies.json">currencies.json</a>, it shows the number of digits past the decimal point for each currency (2 for the majority of currencies).
 *
 * @constructor Creates a [LabeledPrice].
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct LabeledPrice {
    /// Portion label
    pub label: String,
    /// Price of the product in the <em>smallest units</em> of the <a href="/bots/payments#supported-currencies">currency</a> (integer, <strong>not</strong> float/double). For example, for a price of <code>US$ 1.45</code> pass <code>amount = 145</code>. See the <em>exp</em> parameter in <a href="https://core.telegram.org/bots/payments/currencies.json">currencies.json</a>, it shows the number of digits past the decimal point for each currency (2 for the majority of currencies).
    pub amount: Integer
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
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct Invoice {
    /// Product name
    pub title: String,
    /// Product description
    pub description: String,
    /// Unique bot deep-linking parameter that can be used to generate this invoice
    pub start_parameter: String,
    /// Three-letter ISO 4217 <a href="/bots/payments#supported-currencies">currency</a> code
    pub currency: String,
    /// Total price in the <em>smallest units</em> of the currency (integer, <strong>not</strong> float/double). For example, for a price of <code>US$ 1.45</code> pass <code>amount = 145</code>. See the <em>exp</em> parameter in <a href="https://core.telegram.org/bots/payments/currencies.json">currencies.json</a>, it shows the number of digits past the decimal point for each currency (2 for the majority of currencies).
    pub total_amount: Integer
}

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
 * @constructor Creates a [ShippingAddress].
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct ShippingAddress {
    /// ISO 3166-1 alpha-2 country code
    pub country_code: String,
    /// State, if applicable
    pub state: String,
    /// City
    pub city: String,
    /// First line for the address
    pub street_line1: String,
    /// Second line for the address
    pub street_line2: String,
    /// Address post code
    pub post_code: String
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
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct OrderInfo {
    /// <em>Optional</em>. User name
    #[serde(skip_serializing_if = "Option::is_none")]
    pub name: Option<String>,
    /// <em>Optional</em>. User's phone number
    #[serde(skip_serializing_if = "Option::is_none")]
    pub phone_number: Option<String>,
    /// <em>Optional</em>. User email
    #[serde(skip_serializing_if = "Option::is_none")]
    pub email: Option<String>,
    /// <em>Optional</em>. User shipping address
    #[serde(skip_serializing_if = "Option::is_none")]
    pub shipping_address: Option<ShippingAddress>
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
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct ShippingOption {
    /// Shipping option identifier
    pub id: String,
    /// Option title
    pub title: String,
    /// List of price portions
    pub prices: Vec<LabeledPrice>
}

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
 * @constructor Creates a [SuccessfulPayment].
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct SuccessfulPayment {
    /// Three-letter ISO 4217 <a href="/bots/payments#supported-currencies">currency</a> code
    pub currency: String,
    /// Total price in the <em>smallest units</em> of the currency (integer, <strong>not</strong> float/double). For example, for a price of <code>US$ 1.45</code> pass <code>amount = 145</code>. See the <em>exp</em> parameter in <a href="https://core.telegram.org/bots/payments/currencies.json">currencies.json</a>, it shows the number of digits past the decimal point for each currency (2 for the majority of currencies).
    pub total_amount: Integer,
    /// Bot specified invoice payload
    pub invoice_payload: String,
    /// <em>Optional</em>. Identifier of the shipping option chosen by the user
    #[serde(skip_serializing_if = "Option::is_none")]
    pub shipping_option_id: Option<String>,
    /// <em>Optional</em>. Order info provided by the user
    #[serde(skip_serializing_if = "Option::is_none")]
    pub order_info: Option<OrderInfo>,
    /// Telegram payment identifier
    pub telegram_payment_charge_id: String,
    /// Provider payment identifier
    pub provider_payment_charge_id: String
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
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct ShippingQuery {
    /// Unique query identifier
    pub id: String,
    /// User who sent the query
    pub from: User,
    /// Bot specified invoice payload
    pub invoice_payload: String,
    /// User specified shipping address
    pub shipping_address: ShippingAddress
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
 * @property order_info <em>Optional</em>. Order info provided by the user
 *
 * @constructor Creates a [PreCheckoutQuery].
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct PreCheckoutQuery {
    /// Unique query identifier
    pub id: String,
    /// User who sent the query
    pub from: User,
    /// Three-letter ISO 4217 <a href="/bots/payments#supported-currencies">currency</a> code
    pub currency: String,
    /// Total price in the <em>smallest units</em> of the currency (integer, <strong>not</strong> float/double). For example, for a price of <code>US$ 1.45</code> pass <code>amount = 145</code>. See the <em>exp</em> parameter in <a href="https://core.telegram.org/bots/payments/currencies.json">currencies.json</a>, it shows the number of digits past the decimal point for each currency (2 for the majority of currencies).
    pub total_amount: Integer,
    /// Bot specified invoice payload
    pub invoice_payload: String,
    /// <em>Optional</em>. Identifier of the shipping option chosen by the user
    #[serde(skip_serializing_if = "Option::is_none")]
    pub shipping_option_id: Option<String>,
    /// <em>Optional</em>. Order info provided by the user
    #[serde(skip_serializing_if = "Option::is_none")]
    pub order_info: Option<OrderInfo>
}


/// Telegram Passport

/**
 * <p>Contains information about Telegram Passport data shared with the bot by the user.</p>
 *
 * @property data Array with information about documents and other Telegram Passport elements that was shared with the bot
 * @property credentials Encrypted credentials required to decrypt the data
 *
 * @constructor Creates a [PassportData].
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct PassportData {
    /// Array with information about documents and other Telegram Passport elements that was shared with the bot
    pub data: Vec<EncryptedPassportElement>,
    /// Encrypted credentials required to decrypt the data
    pub credentials: EncryptedCredentials
}

/**
 * <p>This object represents a file uploaded to Telegram Passport. Currently all Telegram Passport files are in JPEG format when decrypted and don't exceed 10MB.</p>
 *
 * @property file_id Identifier for this file, which can be used to download or reuse the file
 * @property file_unique_id Unique identifier for this file, which is supposed to be the same over time and for different bots. Can't be used to download or reuse the file.
 * @property file_size File size
 * @property file_date Unix time when the file was uploaded
 *
 * @constructor Creates a [PassportFile].
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct PassportFile {
    /// Identifier for this file, which can be used to download or reuse the file
    pub file_id: String,
    /// Unique identifier for this file, which is supposed to be the same over time and for different bots. Can't be used to download or reuse the file.
    pub file_unique_id: String,
    /// File size
    pub file_size: Integer,
    /// Unix time when the file was uploaded
    pub file_date: Integer
}

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
 * @constructor Creates a [EncryptedPassportElement].
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct EncryptedPassportElement {
    /// Element type. One of “personal_details”, “passport”, “driver_license”, “identity_card”, “internal_passport”, “address”, “utility_bill”, “bank_statement”, “rental_agreement”, “passport_registration”, “temporary_registration”, “phone_number”, “email”.
    #[serde(rename = "type")]
    pub type_: String,
    /// <em>Optional</em>. Base64-encoded encrypted Telegram Passport element data provided by the user, available for “personal_details”, “passport”, “driver_license”, “identity_card”, “internal_passport” and “address” types. Can be decrypted and verified using the accompanying <a href="#encryptedcredentials">EncryptedCredentials</a>.
    #[serde(skip_serializing_if = "Option::is_none")]
    pub data: Option<String>,
    /// <em>Optional</em>. User's verified phone number, available only for “phone_number” type
    #[serde(skip_serializing_if = "Option::is_none")]
    pub phone_number: Option<String>,
    /// <em>Optional</em>. User's verified email address, available only for “email” type
    #[serde(skip_serializing_if = "Option::is_none")]
    pub email: Option<String>,
    /// <em>Optional</em>. Array of encrypted files with documents provided by the user, available for “utility_bill”, “bank_statement”, “rental_agreement”, “passport_registration” and “temporary_registration” types. Files can be decrypted and verified using the accompanying <a href="#encryptedcredentials">EncryptedCredentials</a>.
    #[serde(skip_serializing_if = "Option::is_none")]
    pub files: Option<Vec<PassportFile>>,
    /// <em>Optional</em>. Encrypted file with the front side of the document, provided by the user. Available for “passport”, “driver_license”, “identity_card” and “internal_passport”. The file can be decrypted and verified using the accompanying <a href="#encryptedcredentials">EncryptedCredentials</a>.
    #[serde(skip_serializing_if = "Option::is_none")]
    pub front_side: Option<PassportFile>,
    /// <em>Optional</em>. Encrypted file with the reverse side of the document, provided by the user. Available for “driver_license” and “identity_card”. The file can be decrypted and verified using the accompanying <a href="#encryptedcredentials">EncryptedCredentials</a>.
    #[serde(skip_serializing_if = "Option::is_none")]
    pub reverse_side: Option<PassportFile>,
    /// <em>Optional</em>. Encrypted file with the selfie of the user holding a document, provided by the user; available for “passport”, “driver_license”, “identity_card” and “internal_passport”. The file can be decrypted and verified using the accompanying <a href="#encryptedcredentials">EncryptedCredentials</a>.
    #[serde(skip_serializing_if = "Option::is_none")]
    pub selfie: Option<PassportFile>,
    /// <em>Optional</em>. Array of encrypted files with translated versions of documents provided by the user. Available if requested for “passport”, “driver_license”, “identity_card”, “internal_passport”, “utility_bill”, “bank_statement”, “rental_agreement”, “passport_registration” and “temporary_registration” types. Files can be decrypted and verified using the accompanying <a href="#encryptedcredentials">EncryptedCredentials</a>.
    #[serde(skip_serializing_if = "Option::is_none")]
    pub translation: Option<Vec<PassportFile>>,
    /// Base64-encoded element hash for using in <a href="#passportelementerrorunspecified">PassportElementErrorUnspecified</a>
    pub hash: String
}

/**
 * <p>Contains data required for decrypting and authenticating <a href="#encryptedpassportelement">EncryptedPassportElement</a>. See the <a href="https://core.telegram.org/passport#receiving-information">Telegram Passport Documentation</a> for a complete description of the data decryption and authentication processes.</p>
 *
 * @property data Base64-encoded encrypted JSON-serialized data with unique user's payload, data hashes and secrets required for <a href="#encryptedpassportelement">EncryptedPassportElement</a> decryption and authentication
 * @property hash Base64-encoded data hash for data authentication
 * @property secret Base64-encoded secret, encrypted with the bot's public RSA key, required for data decryption
 *
 * @constructor Creates a [EncryptedCredentials].
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct EncryptedCredentials {
    /// Base64-encoded encrypted JSON-serialized data with unique user's payload, data hashes and secrets required for <a href="#encryptedpassportelement">EncryptedPassportElement</a> decryption and authentication
    pub data: String,
    /// Base64-encoded data hash for data authentication
    pub hash: String,
    /// Base64-encoded secret, encrypted with the bot's public RSA key, required for data decryption
    pub secret: String
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
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct PassportElementErrorDataField {
    /// Error source, must be <em>data</em>
    pub source: String,
    /// The section of the user's Telegram Passport which has the error, one of “personal_details”, “passport”, “driver_license”, “identity_card”, “internal_passport”, “address”
    #[serde(rename = "type")]
    pub type_: String,
    /// Name of the data field which has the error
    pub field_name: String,
    /// Base64-encoded data hash
    pub data_hash: String,
    /// Error message
    pub message: String
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
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct PassportElementErrorFrontSide {
    /// Error source, must be <em>front_side</em>
    pub source: String,
    /// The section of the user's Telegram Passport which has the issue, one of “passport”, “driver_license”, “identity_card”, “internal_passport”
    #[serde(rename = "type")]
    pub type_: String,
    /// Base64-encoded hash of the file with the front side of the document
    pub file_hash: String,
    /// Error message
    pub message: String
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
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct PassportElementErrorReverseSide {
    /// Error source, must be <em>reverse_side</em>
    pub source: String,
    /// The section of the user's Telegram Passport which has the issue, one of “driver_license”, “identity_card”
    #[serde(rename = "type")]
    pub type_: String,
    /// Base64-encoded hash of the file with the reverse side of the document
    pub file_hash: String,
    /// Error message
    pub message: String
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
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct PassportElementErrorSelfie {
    /// Error source, must be <em>selfie</em>
    pub source: String,
    /// The section of the user's Telegram Passport which has the issue, one of “passport”, “driver_license”, “identity_card”, “internal_passport”
    #[serde(rename = "type")]
    pub type_: String,
    /// Base64-encoded hash of the file with the selfie
    pub file_hash: String,
    /// Error message
    pub message: String
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
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct PassportElementErrorFile {
    /// Error source, must be <em>file</em>
    pub source: String,
    /// The section of the user's Telegram Passport which has the issue, one of “utility_bill”, “bank_statement”, “rental_agreement”, “passport_registration”, “temporary_registration”
    #[serde(rename = "type")]
    pub type_: String,
    /// Base64-encoded file hash
    pub file_hash: String,
    /// Error message
    pub message: String
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
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct PassportElementErrorFiles {
    /// Error source, must be <em>files</em>
    pub source: String,
    /// The section of the user's Telegram Passport which has the issue, one of “utility_bill”, “bank_statement”, “rental_agreement”, “passport_registration”, “temporary_registration”
    #[serde(rename = "type")]
    pub type_: String,
    /// List of base64-encoded file hashes
    pub file_hashes: Vec<String>,
    /// Error message
    pub message: String
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
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct PassportElementErrorTranslationFile {
    /// Error source, must be <em>translation_file</em>
    pub source: String,
    /// Type of element of the user's Telegram Passport which has the issue, one of “passport”, “driver_license”, “identity_card”, “internal_passport”, “utility_bill”, “bank_statement”, “rental_agreement”, “passport_registration”, “temporary_registration”
    #[serde(rename = "type")]
    pub type_: String,
    /// Base64-encoded file hash
    pub file_hash: String,
    /// Error message
    pub message: String
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
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct PassportElementErrorTranslationFiles {
    /// Error source, must be <em>translation_files</em>
    pub source: String,
    /// Type of element of the user's Telegram Passport which has the issue, one of “passport”, “driver_license”, “identity_card”, “internal_passport”, “utility_bill”, “bank_statement”, “rental_agreement”, “passport_registration”, “temporary_registration”
    #[serde(rename = "type")]
    pub type_: String,
    /// List of base64-encoded file hashes
    pub file_hashes: Vec<String>,
    /// Error message
    pub message: String
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
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct PassportElementErrorUnspecified {
    /// Error source, must be <em>unspecified</em>
    pub source: String,
    /// Type of element of the user's Telegram Passport which has the issue
    #[serde(rename = "type")]
    pub type_: String,
    /// Base64-encoded element hash
    pub element_hash: String,
    /// Error message
    pub message: String
}


/// Games

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
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct Game {
    /// Title of the game
    pub title: String,
    /// Description of the game
    pub description: String,
    /// Photo that will be displayed in the game message in chats.
    pub photo: Vec<PhotoSize>,
    /// <em>Optional</em>. Brief description of the game or high scores included in the game message. Can be automatically edited to include current high scores for the game when the bot calls <a href="#setgamescore">setGameScore</a>, or manually edited using <a href="#editmessagetext">editMessageText</a>. 0-4096 characters.
    #[serde(skip_serializing_if = "Option::is_none")]
    pub text: Option<String>,
    /// <em>Optional</em>. Special entities that appear in <em>text</em>, such as usernames, URLs, bot commands, etc.
    #[serde(skip_serializing_if = "Option::is_none")]
    pub text_entities: Option<Vec<MessageEntity>>,
    /// <em>Optional</em>. Animation that will be displayed in the game message in chats. Upload via <a href="https://t.me/botfather">BotFather</a>
    #[serde(skip_serializing_if = "Option::is_none")]
    pub animation: Option<Animation>
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
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct GameHighScore {
    /// Position in high score table for the game
    pub position: Integer,
    /// User
    pub user: User,
    /// Score
    pub score: Integer
}


/// --- Requests ---


/// Getting updates

/**
 * <p>Use this method to receive incoming updates using long polling (<a href="https://en.wikipedia.org/wiki/Push_technology#Long_polling">wiki</a>). An Array of <a href="#update">Update</a> objects is returned.</p><blockquote> 
 *  <p><strong>Notes</strong><br><strong>1.</strong> This method will not work if an outgoing webhook is set up.<br><strong>2.</strong> In order to avoid getting duplicate updates, recalculate <em>offset</em> after each server response.</p> 
 * </blockquote>
 *
 * @property offset Identifier of the first update to be returned. Must be greater by one than the highest among the identifiers of previously received updates. By default, updates starting with the earliest unconfirmed update are returned. An update is considered confirmed as soon as <a href="#getupdates">getUpdates</a> is called with an <em>offset</em> higher than its <em>update_id</em>. The negative offset can be specified to retrieve updates starting from <em>-offset</em> update from the end of the updates queue. All previous updates will forgotten.
 * @property limit Limits the number of updates to be retrieved. Values between 1-100 are accepted. Defaults to 100.
 * @property timeout Timeout in seconds for long polling. Defaults to 0, i.e. usual short polling. Should be positive, short polling should be used for testing purposes only.
 * @property allowed_updates A JSON-serialized list of the update types you want your bot to receive. For example, specify [“message”, “edited_channel_post”, “callback_query”] to only receive updates of these types. See <a href="#update">Update</a> for a complete list of available update types. Specify an empty list to receive all updates regardless of type (default). If not specified, the previous setting will be used.<br><br>Please note that this parameter doesn't affect updates created before the call to the getUpdates, so unwanted updates may be received for a short period of time.
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct GetUpdatesRequest {
    /// Identifier of the first update to be returned. Must be greater by one than the highest among the identifiers of previously received updates. By default, updates starting with the earliest unconfirmed update are returned. An update is considered confirmed as soon as <a href="#getupdates">getUpdates</a> is called with an <em>offset</em> higher than its <em>update_id</em>. The negative offset can be specified to retrieve updates starting from <em>-offset</em> update from the end of the updates queue. All previous updates will forgotten.
    pub offset: Option<Integer>,
    /// Limits the number of updates to be retrieved. Values between 1-100 are accepted. Defaults to 100.
    pub limit: Option<Integer>,
    /// Timeout in seconds for long polling. Defaults to 0, i.e. usual short polling. Should be positive, short polling should be used for testing purposes only.
    pub timeout: Option<Integer>,
    /// A JSON-serialized list of the update types you want your bot to receive. For example, specify [“message”, “edited_channel_post”, “callback_query”] to only receive updates of these types. See <a href="#update">Update</a> for a complete list of available update types. Specify an empty list to receive all updates regardless of type (default). If not specified, the previous setting will be used.<br><br>Please note that this parameter doesn't affect updates created before the call to the getUpdates, so unwanted updates may be received for a short period of time.
    pub allowed_updates: Option<Vec<String>>
}

/**
 * <p>Use this method to specify a url and receive incoming updates via an outgoing webhook. Whenever there is an update for the bot, we will send an HTTPS POST request to the specified url, containing a JSON-serialized <a href="#update">Update</a>. In case of an unsuccessful request, we will give up after a reasonable amount of attempts. Returns <em>True</em> on success.</p><p>If you'd like to make sure that the Webhook request comes from Telegram, we recommend using a secret path in the URL, e.g. <code>https://www.example.com/&lt;token&gt;</code>. Since nobody else knows your bot's token, you can be pretty sure it's us.</p><blockquote> 
 *  <p><strong>Notes</strong><br><strong>1.</strong> You will not be able to receive updates using <a href="#getupdates">getUpdates</a> for as long as an outgoing webhook is set up.<br><strong>2.</strong> To use a self-signed certificate, you need to upload your <a href="/bots/self-signed">public key certificate</a> using <em>certificate</em> parameter. Please upload as InputFile, sending a String will not work.<br><strong>3.</strong> Ports currently supported <em>for Webhooks</em>: <strong>443, 80, 88, 8443</strong>.</p> 
 *  <p><strong>NEW!</strong> If you're having any trouble setting up webhooks, please check out this <a href="/bots/webhooks">amazing guide to Webhooks</a>.</p> 
 * </blockquote>
 *
 * @property url HTTPS url to send updates to. Use an empty string to remove webhook integration
 * @property certificate Upload your public key certificate so that the root certificate in use can be checked. See our <a href="/bots/self-signed">self-signed guide</a> for details.
 * @property max_connections Maximum allowed number of simultaneous HTTPS connections to the webhook for update delivery, 1-100. Defaults to <em>40</em>. Use lower values to limit the load on your bot's server, and higher values to increase your bot's throughput.
 * @property allowed_updates A JSON-serialized list of the update types you want your bot to receive. For example, specify [“message”, “edited_channel_post”, “callback_query”] to only receive updates of these types. See <a href="#update">Update</a> for a complete list of available update types. Specify an empty list to receive all updates regardless of type (default). If not specified, the previous setting will be used.<br><br>Please note that this parameter doesn't affect updates created before the call to the setWebhook, so unwanted updates may be received for a short period of time.
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct SetWebhookRequest {
    /// HTTPS url to send updates to. Use an empty string to remove webhook integration
    pub url: String,
    /// Upload your public key certificate so that the root certificate in use can be checked. See our <a href="/bots/self-signed">self-signed guide</a> for details.
    pub certificate: Option<InputFile>,
    /// Maximum allowed number of simultaneous HTTPS connections to the webhook for update delivery, 1-100. Defaults to <em>40</em>. Use lower values to limit the load on your bot's server, and higher values to increase your bot's throughput.
    pub max_connections: Option<Integer>,
    /// A JSON-serialized list of the update types you want your bot to receive. For example, specify [“message”, “edited_channel_post”, “callback_query”] to only receive updates of these types. See <a href="#update">Update</a> for a complete list of available update types. Specify an empty list to receive all updates regardless of type (default). If not specified, the previous setting will be used.<br><br>Please note that this parameter doesn't affect updates created before the call to the setWebhook, so unwanted updates may be received for a short period of time.
    pub allowed_updates: Option<Vec<String>>
}


/// Available methods

/**
 * <p>Use this method to send text messages. On success, the sent <a href="#message">Message</a> is returned.</p>
 *
 * @property chat_id Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>)
 * @property text Text of the message to be sent, 1-4096 characters after entities parsing
 * @property parse_mode Mode for parsing entities in the message text. See <a href="#formatting-options">formatting options</a> for more details.
 * @property disable_web_page_preview Disables link previews for links in this message
 * @property disable_notification Sends the message <a href="https://telegram.org/blog/channels-2-0#silent-messages">silently</a>. Users will receive a notification with no sound.
 * @property reply_to_message_id If the message is a reply, ID of the original message
 * @property reply_markup Additional interface options. A JSON-serialized object for an <a href="https://core.telegram.org/bots#inline-keyboards-and-on-the-fly-updating">inline keyboard</a>, <a href="https://core.telegram.org/bots#keyboards">custom reply keyboard</a>, instructions to remove reply keyboard or to force a reply from the user.
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct SendMessageRequest {
    /// Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>)
    pub chat_id: String,
    /// Text of the message to be sent, 1-4096 characters after entities parsing
    pub text: String,
    /// Mode for parsing entities in the message text. See <a href="#formatting-options">formatting options</a> for more details.
    pub parse_mode: Option<ParseMode>,
    /// Disables link previews for links in this message
    pub disable_web_page_preview: Option<bool>,
    /// Sends the message <a href="https://telegram.org/blog/channels-2-0#silent-messages">silently</a>. Users will receive a notification with no sound.
    pub disable_notification: Option<bool>,
    /// If the message is a reply, ID of the original message
    pub reply_to_message_id: Option<Integer>,
    /// Additional interface options. A JSON-serialized object for an <a href="https://core.telegram.org/bots#inline-keyboards-and-on-the-fly-updating">inline keyboard</a>, <a href="https://core.telegram.org/bots#keyboards">custom reply keyboard</a>, instructions to remove reply keyboard or to force a reply from the user.
    pub reply_markup: Option<KeyboardOption>
}

/**
 * <p>Use this method to forward messages of any kind. On success, the sent <a href="#message">Message</a> is returned.</p>
 *
 * @property chat_id Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>)
 * @property from_chat_id Unique identifier for the chat where the original message was sent (or channel username in the format <code>@channelusername</code>)
 * @property disable_notification Sends the message <a href="https://telegram.org/blog/channels-2-0#silent-messages">silently</a>. Users will receive a notification with no sound.
 * @property message_id Message identifier in the chat specified in <em>from_chat_id</em>
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct ForwardMessageRequest {
    /// Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>)
    pub chat_id: String,
    /// Unique identifier for the chat where the original message was sent (or channel username in the format <code>@channelusername</code>)
    pub from_chat_id: String,
    /// Sends the message <a href="https://telegram.org/blog/channels-2-0#silent-messages">silently</a>. Users will receive a notification with no sound.
    pub disable_notification: Option<bool>,
    /// Message identifier in the chat specified in <em>from_chat_id</em>
    pub message_id: Integer
}

/**
 * <p>Use this method to send photos. On success, the sent <a href="#message">Message</a> is returned.</p>
 *
 * @property chat_id Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>)
 * @property photo Photo to send. Pass a file_id as String to send a photo that exists on the Telegram servers (recommended), pass an HTTP URL as a String for Telegram to get a photo from the Internet, or upload a new photo using multipart/form-data. <a href="#sending-files">More info on Sending Files »</a>
 * @property caption Photo caption (may also be used when resending photos by <em>file_id</em>), 0-1024 characters after entities parsing
 * @property parse_mode Mode for parsing entities in the photo caption. See <a href="#formatting-options">formatting options</a> for more details.
 * @property disable_notification Sends the message <a href="https://telegram.org/blog/channels-2-0#silent-messages">silently</a>. Users will receive a notification with no sound.
 * @property reply_to_message_id If the message is a reply, ID of the original message
 * @property reply_markup Additional interface options. A JSON-serialized object for an <a href="https://core.telegram.org/bots#inline-keyboards-and-on-the-fly-updating">inline keyboard</a>, <a href="https://core.telegram.org/bots#keyboards">custom reply keyboard</a>, instructions to remove reply keyboard or to force a reply from the user.
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct SendPhotoRequest {
    /// Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>)
    pub chat_id: String,
    /// Photo to send. Pass a file_id as String to send a photo that exists on the Telegram servers (recommended), pass an HTTP URL as a String for Telegram to get a photo from the Internet, or upload a new photo using multipart/form-data. <a href="#sending-files">More info on Sending Files »</a>
    pub photo: String,
    /// Photo caption (may also be used when resending photos by <em>file_id</em>), 0-1024 characters after entities parsing
    pub caption: Option<String>,
    /// Mode for parsing entities in the photo caption. See <a href="#formatting-options">formatting options</a> for more details.
    pub parse_mode: Option<ParseMode>,
    /// Sends the message <a href="https://telegram.org/blog/channels-2-0#silent-messages">silently</a>. Users will receive a notification with no sound.
    pub disable_notification: Option<bool>,
    /// If the message is a reply, ID of the original message
    pub reply_to_message_id: Option<Integer>,
    /// Additional interface options. A JSON-serialized object for an <a href="https://core.telegram.org/bots#inline-keyboards-and-on-the-fly-updating">inline keyboard</a>, <a href="https://core.telegram.org/bots#keyboards">custom reply keyboard</a>, instructions to remove reply keyboard or to force a reply from the user.
    pub reply_markup: Option<KeyboardOption>
}

/**
 * <p>Use this method to send audio files, if you want Telegram clients to display them in the music player. Your audio must be in the .MP3 or .M4A format. On success, the sent <a href="#message">Message</a> is returned. Bots can currently send audio files of up to 50 MB in size, this limit may be changed in the future.</p><p>For sending voice messages, use the <a href="#sendvoice">sendVoice</a> method instead.</p>
 *
 * @property chat_id Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>)
 * @property audio Audio file to send. Pass a file_id as String to send an audio file that exists on the Telegram servers (recommended), pass an HTTP URL as a String for Telegram to get an audio file from the Internet, or upload a new one using multipart/form-data. <a href="#sending-files">More info on Sending Files »</a>
 * @property caption Audio caption, 0-1024 characters after entities parsing
 * @property parse_mode Mode for parsing entities in the audio caption. See <a href="#formatting-options">formatting options</a> for more details.
 * @property duration Duration of the audio in seconds
 * @property performer Performer
 * @property title Track name
 * @property thumb Thumbnail of the file sent; can be ignored if thumbnail generation for the file is supported server-side. The thumbnail should be in JPEG format and less than 200 kB in size. A thumbnail's width and height should not exceed 320. Ignored if the file is not uploaded using multipart/form-data. Thumbnails can't be reused and can be only uploaded as a new file, so you can pass “attach://&lt;file_attach_name&gt;” if the thumbnail was uploaded using multipart/form-data under &lt;file_attach_name&gt;. <a href="#sending-files">More info on Sending Files »</a>
 * @property disable_notification Sends the message <a href="https://telegram.org/blog/channels-2-0#silent-messages">silently</a>. Users will receive a notification with no sound.
 * @property reply_to_message_id If the message is a reply, ID of the original message
 * @property reply_markup Additional interface options. A JSON-serialized object for an <a href="https://core.telegram.org/bots#inline-keyboards-and-on-the-fly-updating">inline keyboard</a>, <a href="https://core.telegram.org/bots#keyboards">custom reply keyboard</a>, instructions to remove reply keyboard or to force a reply from the user.
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct SendAudioRequest {
    /// Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>)
    pub chat_id: String,
    /// Audio file to send. Pass a file_id as String to send an audio file that exists on the Telegram servers (recommended), pass an HTTP URL as a String for Telegram to get an audio file from the Internet, or upload a new one using multipart/form-data. <a href="#sending-files">More info on Sending Files »</a>
    pub audio: String,
    /// Audio caption, 0-1024 characters after entities parsing
    pub caption: Option<String>,
    /// Mode for parsing entities in the audio caption. See <a href="#formatting-options">formatting options</a> for more details.
    pub parse_mode: Option<ParseMode>,
    /// Duration of the audio in seconds
    pub duration: Option<Integer>,
    /// Performer
    pub performer: Option<String>,
    /// Track name
    pub title: Option<String>,
    /// Thumbnail of the file sent; can be ignored if thumbnail generation for the file is supported server-side. The thumbnail should be in JPEG format and less than 200 kB in size. A thumbnail's width and height should not exceed 320. Ignored if the file is not uploaded using multipart/form-data. Thumbnails can't be reused and can be only uploaded as a new file, so you can pass “attach://&lt;file_attach_name&gt;” if the thumbnail was uploaded using multipart/form-data under &lt;file_attach_name&gt;. <a href="#sending-files">More info on Sending Files »</a>
    pub thumb: Option<String>,
    /// Sends the message <a href="https://telegram.org/blog/channels-2-0#silent-messages">silently</a>. Users will receive a notification with no sound.
    pub disable_notification: Option<bool>,
    /// If the message is a reply, ID of the original message
    pub reply_to_message_id: Option<Integer>,
    /// Additional interface options. A JSON-serialized object for an <a href="https://core.telegram.org/bots#inline-keyboards-and-on-the-fly-updating">inline keyboard</a>, <a href="https://core.telegram.org/bots#keyboards">custom reply keyboard</a>, instructions to remove reply keyboard or to force a reply from the user.
    pub reply_markup: Option<KeyboardOption>
}

/**
 * <p>Use this method to send general files. On success, the sent <a href="#message">Message</a> is returned. Bots can currently send files of any type of up to 50 MB in size, this limit may be changed in the future.</p>
 *
 * @property chat_id Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>)
 * @property document File to send. Pass a file_id as String to send a file that exists on the Telegram servers (recommended), pass an HTTP URL as a String for Telegram to get a file from the Internet, or upload a new one using multipart/form-data. <a href="#sending-files">More info on Sending Files »</a>
 * @property thumb Thumbnail of the file sent; can be ignored if thumbnail generation for the file is supported server-side. The thumbnail should be in JPEG format and less than 200 kB in size. A thumbnail's width and height should not exceed 320. Ignored if the file is not uploaded using multipart/form-data. Thumbnails can't be reused and can be only uploaded as a new file, so you can pass “attach://&lt;file_attach_name&gt;” if the thumbnail was uploaded using multipart/form-data under &lt;file_attach_name&gt;. <a href="#sending-files">More info on Sending Files »</a>
 * @property caption Document caption (may also be used when resending documents by <em>file_id</em>), 0-1024 characters after entities parsing
 * @property parse_mode Mode for parsing entities in the document caption. See <a href="#formatting-options">formatting options</a> for more details.
 * @property disable_notification Sends the message <a href="https://telegram.org/blog/channels-2-0#silent-messages">silently</a>. Users will receive a notification with no sound.
 * @property reply_to_message_id If the message is a reply, ID of the original message
 * @property reply_markup Additional interface options. A JSON-serialized object for an <a href="https://core.telegram.org/bots#inline-keyboards-and-on-the-fly-updating">inline keyboard</a>, <a href="https://core.telegram.org/bots#keyboards">custom reply keyboard</a>, instructions to remove reply keyboard or to force a reply from the user.
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct SendDocumentRequest {
    /// Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>)
    pub chat_id: String,
    /// File to send. Pass a file_id as String to send a file that exists on the Telegram servers (recommended), pass an HTTP URL as a String for Telegram to get a file from the Internet, or upload a new one using multipart/form-data. <a href="#sending-files">More info on Sending Files »</a>
    pub document: String,
    /// Thumbnail of the file sent; can be ignored if thumbnail generation for the file is supported server-side. The thumbnail should be in JPEG format and less than 200 kB in size. A thumbnail's width and height should not exceed 320. Ignored if the file is not uploaded using multipart/form-data. Thumbnails can't be reused and can be only uploaded as a new file, so you can pass “attach://&lt;file_attach_name&gt;” if the thumbnail was uploaded using multipart/form-data under &lt;file_attach_name&gt;. <a href="#sending-files">More info on Sending Files »</a>
    pub thumb: Option<String>,
    /// Document caption (may also be used when resending documents by <em>file_id</em>), 0-1024 characters after entities parsing
    pub caption: Option<String>,
    /// Mode for parsing entities in the document caption. See <a href="#formatting-options">formatting options</a> for more details.
    pub parse_mode: Option<ParseMode>,
    /// Sends the message <a href="https://telegram.org/blog/channels-2-0#silent-messages">silently</a>. Users will receive a notification with no sound.
    pub disable_notification: Option<bool>,
    /// If the message is a reply, ID of the original message
    pub reply_to_message_id: Option<Integer>,
    /// Additional interface options. A JSON-serialized object for an <a href="https://core.telegram.org/bots#inline-keyboards-and-on-the-fly-updating">inline keyboard</a>, <a href="https://core.telegram.org/bots#keyboards">custom reply keyboard</a>, instructions to remove reply keyboard or to force a reply from the user.
    pub reply_markup: Option<KeyboardOption>
}

/**
 * <p>Use this method to send video files, Telegram clients support mp4 videos (other formats may be sent as <a href="#document">Document</a>). On success, the sent <a href="#message">Message</a> is returned. Bots can currently send video files of up to 50 MB in size, this limit may be changed in the future.</p>
 *
 * @property chat_id Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>)
 * @property video Video to send. Pass a file_id as String to send a video that exists on the Telegram servers (recommended), pass an HTTP URL as a String for Telegram to get a video from the Internet, or upload a new video using multipart/form-data. <a href="#sending-files">More info on Sending Files »</a>
 * @property duration Duration of sent video in seconds
 * @property width Video width
 * @property height Video height
 * @property thumb Thumbnail of the file sent; can be ignored if thumbnail generation for the file is supported server-side. The thumbnail should be in JPEG format and less than 200 kB in size. A thumbnail's width and height should not exceed 320. Ignored if the file is not uploaded using multipart/form-data. Thumbnails can't be reused and can be only uploaded as a new file, so you can pass “attach://&lt;file_attach_name&gt;” if the thumbnail was uploaded using multipart/form-data under &lt;file_attach_name&gt;. <a href="#sending-files">More info on Sending Files »</a>
 * @property caption Video caption (may also be used when resending videos by <em>file_id</em>), 0-1024 characters after entities parsing
 * @property parse_mode Mode for parsing entities in the video caption. See <a href="#formatting-options">formatting options</a> for more details.
 * @property supports_streaming Pass <em>True</em>, if the uploaded video is suitable for streaming
 * @property disable_notification Sends the message <a href="https://telegram.org/blog/channels-2-0#silent-messages">silently</a>. Users will receive a notification with no sound.
 * @property reply_to_message_id If the message is a reply, ID of the original message
 * @property reply_markup Additional interface options. A JSON-serialized object for an <a href="https://core.telegram.org/bots#inline-keyboards-and-on-the-fly-updating">inline keyboard</a>, <a href="https://core.telegram.org/bots#keyboards">custom reply keyboard</a>, instructions to remove reply keyboard or to force a reply from the user.
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct SendVideoRequest {
    /// Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>)
    pub chat_id: String,
    /// Video to send. Pass a file_id as String to send a video that exists on the Telegram servers (recommended), pass an HTTP URL as a String for Telegram to get a video from the Internet, or upload a new video using multipart/form-data. <a href="#sending-files">More info on Sending Files »</a>
    pub video: String,
    /// Duration of sent video in seconds
    pub duration: Option<Integer>,
    /// Video width
    pub width: Option<Integer>,
    /// Video height
    pub height: Option<Integer>,
    /// Thumbnail of the file sent; can be ignored if thumbnail generation for the file is supported server-side. The thumbnail should be in JPEG format and less than 200 kB in size. A thumbnail's width and height should not exceed 320. Ignored if the file is not uploaded using multipart/form-data. Thumbnails can't be reused and can be only uploaded as a new file, so you can pass “attach://&lt;file_attach_name&gt;” if the thumbnail was uploaded using multipart/form-data under &lt;file_attach_name&gt;. <a href="#sending-files">More info on Sending Files »</a>
    pub thumb: Option<String>,
    /// Video caption (may also be used when resending videos by <em>file_id</em>), 0-1024 characters after entities parsing
    pub caption: Option<String>,
    /// Mode for parsing entities in the video caption. See <a href="#formatting-options">formatting options</a> for more details.
    pub parse_mode: Option<ParseMode>,
    /// Pass <em>True</em>, if the uploaded video is suitable for streaming
    pub supports_streaming: Option<bool>,
    /// Sends the message <a href="https://telegram.org/blog/channels-2-0#silent-messages">silently</a>. Users will receive a notification with no sound.
    pub disable_notification: Option<bool>,
    /// If the message is a reply, ID of the original message
    pub reply_to_message_id: Option<Integer>,
    /// Additional interface options. A JSON-serialized object for an <a href="https://core.telegram.org/bots#inline-keyboards-and-on-the-fly-updating">inline keyboard</a>, <a href="https://core.telegram.org/bots#keyboards">custom reply keyboard</a>, instructions to remove reply keyboard or to force a reply from the user.
    pub reply_markup: Option<KeyboardOption>
}

/**
 * <p>Use this method to send animation files (GIF or H.264/MPEG-4 AVC video without sound). On success, the sent <a href="#message">Message</a> is returned. Bots can currently send animation files of up to 50 MB in size, this limit may be changed in the future.</p>
 *
 * @property chat_id Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>)
 * @property animation Animation to send. Pass a file_id as String to send an animation that exists on the Telegram servers (recommended), pass an HTTP URL as a String for Telegram to get an animation from the Internet, or upload a new animation using multipart/form-data. <a href="#sending-files">More info on Sending Files »</a>
 * @property duration Duration of sent animation in seconds
 * @property width Animation width
 * @property height Animation height
 * @property thumb Thumbnail of the file sent; can be ignored if thumbnail generation for the file is supported server-side. The thumbnail should be in JPEG format and less than 200 kB in size. A thumbnail's width and height should not exceed 320. Ignored if the file is not uploaded using multipart/form-data. Thumbnails can't be reused and can be only uploaded as a new file, so you can pass “attach://&lt;file_attach_name&gt;” if the thumbnail was uploaded using multipart/form-data under &lt;file_attach_name&gt;. <a href="#sending-files">More info on Sending Files »</a>
 * @property caption Animation caption (may also be used when resending animation by <em>file_id</em>), 0-1024 characters after entities parsing
 * @property parse_mode Mode for parsing entities in the animation caption. See <a href="#formatting-options">formatting options</a> for more details.
 * @property disable_notification Sends the message <a href="https://telegram.org/blog/channels-2-0#silent-messages">silently</a>. Users will receive a notification with no sound.
 * @property reply_to_message_id If the message is a reply, ID of the original message
 * @property reply_markup Additional interface options. A JSON-serialized object for an <a href="https://core.telegram.org/bots#inline-keyboards-and-on-the-fly-updating">inline keyboard</a>, <a href="https://core.telegram.org/bots#keyboards">custom reply keyboard</a>, instructions to remove reply keyboard or to force a reply from the user.
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct SendAnimationRequest {
    /// Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>)
    pub chat_id: String,
    /// Animation to send. Pass a file_id as String to send an animation that exists on the Telegram servers (recommended), pass an HTTP URL as a String for Telegram to get an animation from the Internet, or upload a new animation using multipart/form-data. <a href="#sending-files">More info on Sending Files »</a>
    pub animation: String,
    /// Duration of sent animation in seconds
    pub duration: Option<Integer>,
    /// Animation width
    pub width: Option<Integer>,
    /// Animation height
    pub height: Option<Integer>,
    /// Thumbnail of the file sent; can be ignored if thumbnail generation for the file is supported server-side. The thumbnail should be in JPEG format and less than 200 kB in size. A thumbnail's width and height should not exceed 320. Ignored if the file is not uploaded using multipart/form-data. Thumbnails can't be reused and can be only uploaded as a new file, so you can pass “attach://&lt;file_attach_name&gt;” if the thumbnail was uploaded using multipart/form-data under &lt;file_attach_name&gt;. <a href="#sending-files">More info on Sending Files »</a>
    pub thumb: Option<String>,
    /// Animation caption (may also be used when resending animation by <em>file_id</em>), 0-1024 characters after entities parsing
    pub caption: Option<String>,
    /// Mode for parsing entities in the animation caption. See <a href="#formatting-options">formatting options</a> for more details.
    pub parse_mode: Option<ParseMode>,
    /// Sends the message <a href="https://telegram.org/blog/channels-2-0#silent-messages">silently</a>. Users will receive a notification with no sound.
    pub disable_notification: Option<bool>,
    /// If the message is a reply, ID of the original message
    pub reply_to_message_id: Option<Integer>,
    /// Additional interface options. A JSON-serialized object for an <a href="https://core.telegram.org/bots#inline-keyboards-and-on-the-fly-updating">inline keyboard</a>, <a href="https://core.telegram.org/bots#keyboards">custom reply keyboard</a>, instructions to remove reply keyboard or to force a reply from the user.
    pub reply_markup: Option<KeyboardOption>
}

/**
 * <p>Use this method to send audio files, if you want Telegram clients to display the file as a playable voice message. For this to work, your audio must be in an .OGG file encoded with OPUS (other formats may be sent as <a href="#audio">Audio</a> or <a href="#document">Document</a>). On success, the sent <a href="#message">Message</a> is returned. Bots can currently send voice messages of up to 50 MB in size, this limit may be changed in the future.</p>
 *
 * @property chat_id Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>)
 * @property voice Audio file to send. Pass a file_id as String to send a file that exists on the Telegram servers (recommended), pass an HTTP URL as a String for Telegram to get a file from the Internet, or upload a new one using multipart/form-data. <a href="#sending-files">More info on Sending Files »</a>
 * @property caption Voice message caption, 0-1024 characters after entities parsing
 * @property parse_mode Mode for parsing entities in the voice message caption. See <a href="#formatting-options">formatting options</a> for more details.
 * @property duration Duration of the voice message in seconds
 * @property disable_notification Sends the message <a href="https://telegram.org/blog/channels-2-0#silent-messages">silently</a>. Users will receive a notification with no sound.
 * @property reply_to_message_id If the message is a reply, ID of the original message
 * @property reply_markup Additional interface options. A JSON-serialized object for an <a href="https://core.telegram.org/bots#inline-keyboards-and-on-the-fly-updating">inline keyboard</a>, <a href="https://core.telegram.org/bots#keyboards">custom reply keyboard</a>, instructions to remove reply keyboard or to force a reply from the user.
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct SendVoiceRequest {
    /// Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>)
    pub chat_id: String,
    /// Audio file to send. Pass a file_id as String to send a file that exists on the Telegram servers (recommended), pass an HTTP URL as a String for Telegram to get a file from the Internet, or upload a new one using multipart/form-data. <a href="#sending-files">More info on Sending Files »</a>
    pub voice: String,
    /// Voice message caption, 0-1024 characters after entities parsing
    pub caption: Option<String>,
    /// Mode for parsing entities in the voice message caption. See <a href="#formatting-options">formatting options</a> for more details.
    pub parse_mode: Option<ParseMode>,
    /// Duration of the voice message in seconds
    pub duration: Option<Integer>,
    /// Sends the message <a href="https://telegram.org/blog/channels-2-0#silent-messages">silently</a>. Users will receive a notification with no sound.
    pub disable_notification: Option<bool>,
    /// If the message is a reply, ID of the original message
    pub reply_to_message_id: Option<Integer>,
    /// Additional interface options. A JSON-serialized object for an <a href="https://core.telegram.org/bots#inline-keyboards-and-on-the-fly-updating">inline keyboard</a>, <a href="https://core.telegram.org/bots#keyboards">custom reply keyboard</a>, instructions to remove reply keyboard or to force a reply from the user.
    pub reply_markup: Option<KeyboardOption>
}

/**
 * <p>As of <a href="https://telegram.org/blog/video-messages-and-telescope">v.4.0</a>, Telegram clients support rounded square mp4 videos of up to 1 minute long. Use this method to send video messages. On success, the sent <a href="#message">Message</a> is returned.</p>
 *
 * @property chat_id Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>)
 * @property video_note Video note to send. Pass a file_id as String to send a video note that exists on the Telegram servers (recommended) or upload a new video using multipart/form-data. <a href="#sending-files">More info on Sending Files »</a>. Sending video notes by a URL is currently unsupported
 * @property duration Duration of sent video in seconds
 * @property length Video width and height, i.e. diameter of the video message
 * @property thumb Thumbnail of the file sent; can be ignored if thumbnail generation for the file is supported server-side. The thumbnail should be in JPEG format and less than 200 kB in size. A thumbnail's width and height should not exceed 320. Ignored if the file is not uploaded using multipart/form-data. Thumbnails can't be reused and can be only uploaded as a new file, so you can pass “attach://&lt;file_attach_name&gt;” if the thumbnail was uploaded using multipart/form-data under &lt;file_attach_name&gt;. <a href="#sending-files">More info on Sending Files »</a>
 * @property disable_notification Sends the message <a href="https://telegram.org/blog/channels-2-0#silent-messages">silently</a>. Users will receive a notification with no sound.
 * @property reply_to_message_id If the message is a reply, ID of the original message
 * @property reply_markup Additional interface options. A JSON-serialized object for an <a href="https://core.telegram.org/bots#inline-keyboards-and-on-the-fly-updating">inline keyboard</a>, <a href="https://core.telegram.org/bots#keyboards">custom reply keyboard</a>, instructions to remove reply keyboard or to force a reply from the user.
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct SendVideoNoteRequest {
    /// Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>)
    pub chat_id: String,
    /// Video note to send. Pass a file_id as String to send a video note that exists on the Telegram servers (recommended) or upload a new video using multipart/form-data. <a href="#sending-files">More info on Sending Files »</a>. Sending video notes by a URL is currently unsupported
    pub video_note: String,
    /// Duration of sent video in seconds
    pub duration: Option<Integer>,
    /// Video width and height, i.e. diameter of the video message
    pub length: Option<Integer>,
    /// Thumbnail of the file sent; can be ignored if thumbnail generation for the file is supported server-side. The thumbnail should be in JPEG format and less than 200 kB in size. A thumbnail's width and height should not exceed 320. Ignored if the file is not uploaded using multipart/form-data. Thumbnails can't be reused and can be only uploaded as a new file, so you can pass “attach://&lt;file_attach_name&gt;” if the thumbnail was uploaded using multipart/form-data under &lt;file_attach_name&gt;. <a href="#sending-files">More info on Sending Files »</a>
    pub thumb: Option<String>,
    /// Sends the message <a href="https://telegram.org/blog/channels-2-0#silent-messages">silently</a>. Users will receive a notification with no sound.
    pub disable_notification: Option<bool>,
    /// If the message is a reply, ID of the original message
    pub reply_to_message_id: Option<Integer>,
    /// Additional interface options. A JSON-serialized object for an <a href="https://core.telegram.org/bots#inline-keyboards-and-on-the-fly-updating">inline keyboard</a>, <a href="https://core.telegram.org/bots#keyboards">custom reply keyboard</a>, instructions to remove reply keyboard or to force a reply from the user.
    pub reply_markup: Option<KeyboardOption>
}

/**
 * <p>Use this method to send a group of photos or videos as an album. On success, an array of the sent <a href="#message">Messages</a> is returned.</p>
 *
 * @property chat_id Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>)
 * @property media A JSON-serialized array describing photos and videos to be sent, must include 2-10 items
 * @property disable_notification Sends the messages <a href="https://telegram.org/blog/channels-2-0#silent-messages">silently</a>. Users will receive a notification with no sound.
 * @property reply_to_message_id If the messages are a reply, ID of the original message
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct SendMediaGroupRequest {
    /// Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>)
    pub chat_id: String,
    /// A JSON-serialized array describing photos and videos to be sent, must include 2-10 items
    pub media: Vec<InputMediaPhotoOrVideo>,
    /// Sends the messages <a href="https://telegram.org/blog/channels-2-0#silent-messages">silently</a>. Users will receive a notification with no sound.
    pub disable_notification: Option<bool>,
    /// If the messages are a reply, ID of the original message
    pub reply_to_message_id: Option<Integer>
}

/**
 * <p>Use this method to send point on the map. On success, the sent <a href="#message">Message</a> is returned.</p>
 *
 * @property chat_id Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>)
 * @property latitude Latitude of the location
 * @property longitude Longitude of the location
 * @property live_period Period in seconds for which the location will be updated (see <a href="https://telegram.org/blog/live-locations">Live Locations</a>, should be between 60 and 86400.
 * @property disable_notification Sends the message <a href="https://telegram.org/blog/channels-2-0#silent-messages">silently</a>. Users will receive a notification with no sound.
 * @property reply_to_message_id If the message is a reply, ID of the original message
 * @property reply_markup Additional interface options. A JSON-serialized object for an <a href="https://core.telegram.org/bots#inline-keyboards-and-on-the-fly-updating">inline keyboard</a>, <a href="https://core.telegram.org/bots#keyboards">custom reply keyboard</a>, instructions to remove reply keyboard or to force a reply from the user.
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct SendLocationRequest {
    /// Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>)
    pub chat_id: String,
    /// Latitude of the location
    pub latitude: Float,
    /// Longitude of the location
    pub longitude: Float,
    /// Period in seconds for which the location will be updated (see <a href="https://telegram.org/blog/live-locations">Live Locations</a>, should be between 60 and 86400.
    pub live_period: Option<Integer>,
    /// Sends the message <a href="https://telegram.org/blog/channels-2-0#silent-messages">silently</a>. Users will receive a notification with no sound.
    pub disable_notification: Option<bool>,
    /// If the message is a reply, ID of the original message
    pub reply_to_message_id: Option<Integer>,
    /// Additional interface options. A JSON-serialized object for an <a href="https://core.telegram.org/bots#inline-keyboards-and-on-the-fly-updating">inline keyboard</a>, <a href="https://core.telegram.org/bots#keyboards">custom reply keyboard</a>, instructions to remove reply keyboard or to force a reply from the user.
    pub reply_markup: Option<KeyboardOption>
}

/**
 * <p>Use this method to edit live location messages. A location can be edited until its <em>live_period</em> expires or editing is explicitly disabled by a call to <a href="#stopmessagelivelocation">stopMessageLiveLocation</a>. On success, if the edited message was sent by the bot, the edited <a href="#message">Message</a> is returned, otherwise <em>True</em> is returned.</p>
 *
 * @property chat_id Required if <em>inline_message_id</em> is not specified. Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>)
 * @property message_id Required if <em>inline_message_id</em> is not specified. Identifier of the message to edit
 * @property inline_message_id Required if <em>chat_id</em> and <em>message_id</em> are not specified. Identifier of the inline message
 * @property latitude Latitude of new location
 * @property longitude Longitude of new location
 * @property reply_markup A JSON-serialized object for a new <a href="https://core.telegram.org/bots#inline-keyboards-and-on-the-fly-updating">inline keyboard</a>.
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct EditMessageLiveLocationRequest {
    /// Required if <em>inline_message_id</em> is not specified. Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>)
    pub chat_id: Option<String>,
    /// Required if <em>inline_message_id</em> is not specified. Identifier of the message to edit
    pub message_id: Option<Integer>,
    /// Required if <em>chat_id</em> and <em>message_id</em> are not specified. Identifier of the inline message
    pub inline_message_id: Option<String>,
    /// Latitude of new location
    pub latitude: Float,
    /// Longitude of new location
    pub longitude: Float,
    /// A JSON-serialized object for a new <a href="https://core.telegram.org/bots#inline-keyboards-and-on-the-fly-updating">inline keyboard</a>.
    pub reply_markup: Option<InlineKeyboardMarkup>
}

/**
 * <p>Use this method to stop updating a live location message before <em>live_period</em> expires. On success, if the message was sent by the bot, the sent <a href="#message">Message</a> is returned, otherwise <em>True</em> is returned.</p>
 *
 * @property chat_id Required if <em>inline_message_id</em> is not specified. Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>)
 * @property message_id Required if <em>inline_message_id</em> is not specified. Identifier of the message with live location to stop
 * @property inline_message_id Required if <em>chat_id</em> and <em>message_id</em> are not specified. Identifier of the inline message
 * @property reply_markup A JSON-serialized object for a new <a href="https://core.telegram.org/bots#inline-keyboards-and-on-the-fly-updating">inline keyboard</a>.
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct StopMessageLiveLocationRequest {
    /// Required if <em>inline_message_id</em> is not specified. Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>)
    pub chat_id: Option<String>,
    /// Required if <em>inline_message_id</em> is not specified. Identifier of the message with live location to stop
    pub message_id: Option<Integer>,
    /// Required if <em>chat_id</em> and <em>message_id</em> are not specified. Identifier of the inline message
    pub inline_message_id: Option<String>,
    /// A JSON-serialized object for a new <a href="https://core.telegram.org/bots#inline-keyboards-and-on-the-fly-updating">inline keyboard</a>.
    pub reply_markup: Option<InlineKeyboardMarkup>
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
 * @property disable_notification Sends the message <a href="https://telegram.org/blog/channels-2-0#silent-messages">silently</a>. Users will receive a notification with no sound.
 * @property reply_to_message_id If the message is a reply, ID of the original message
 * @property reply_markup Additional interface options. A JSON-serialized object for an <a href="https://core.telegram.org/bots#inline-keyboards-and-on-the-fly-updating">inline keyboard</a>, <a href="https://core.telegram.org/bots#keyboards">custom reply keyboard</a>, instructions to remove reply keyboard or to force a reply from the user.
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct SendVenueRequest {
    /// Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>)
    pub chat_id: String,
    /// Latitude of the venue
    pub latitude: Float,
    /// Longitude of the venue
    pub longitude: Float,
    /// Name of the venue
    pub title: String,
    /// Address of the venue
    pub address: String,
    /// Foursquare identifier of the venue
    pub foursquare_id: Option<String>,
    /// Foursquare type of the venue, if known. (For example, “arts_entertainment/default”, “arts_entertainment/aquarium” or “food/icecream”.)
    pub foursquare_type: Option<String>,
    /// Sends the message <a href="https://telegram.org/blog/channels-2-0#silent-messages">silently</a>. Users will receive a notification with no sound.
    pub disable_notification: Option<bool>,
    /// If the message is a reply, ID of the original message
    pub reply_to_message_id: Option<Integer>,
    /// Additional interface options. A JSON-serialized object for an <a href="https://core.telegram.org/bots#inline-keyboards-and-on-the-fly-updating">inline keyboard</a>, <a href="https://core.telegram.org/bots#keyboards">custom reply keyboard</a>, instructions to remove reply keyboard or to force a reply from the user.
    pub reply_markup: Option<KeyboardOption>
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
 * @property reply_to_message_id If the message is a reply, ID of the original message
 * @property reply_markup Additional interface options. A JSON-serialized object for an <a href="https://core.telegram.org/bots#inline-keyboards-and-on-the-fly-updating">inline keyboard</a>, <a href="https://core.telegram.org/bots#keyboards">custom reply keyboard</a>, instructions to remove keyboard or to force a reply from the user.
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct SendContactRequest {
    /// Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>)
    pub chat_id: String,
    /// Contact's phone number
    pub phone_number: String,
    /// Contact's first name
    pub first_name: String,
    /// Contact's last name
    pub last_name: Option<String>,
    /// Additional data about the contact in the form of a <a href="https://en.wikipedia.org/wiki/VCard">vCard</a>, 0-2048 bytes
    pub vcard: Option<String>,
    /// Sends the message <a href="https://telegram.org/blog/channels-2-0#silent-messages">silently</a>. Users will receive a notification with no sound.
    pub disable_notification: Option<bool>,
    /// If the message is a reply, ID of the original message
    pub reply_to_message_id: Option<Integer>,
    /// Additional interface options. A JSON-serialized object for an <a href="https://core.telegram.org/bots#inline-keyboards-and-on-the-fly-updating">inline keyboard</a>, <a href="https://core.telegram.org/bots#keyboards">custom reply keyboard</a>, instructions to remove keyboard or to force a reply from the user.
    pub reply_markup: Option<KeyboardOption>
}

/**
 * <p>Use this method to send a native poll. On success, the sent <a href="#message">Message</a> is returned.</p>
 *
 * @property chat_id Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>)
 * @property question Poll question, 1-255 characters
 * @property options A JSON-serialized list of answer options, 2-10 strings 1-100 characters each
 * @property is_anonymous True, if the poll needs to be anonymous, defaults to <em>True</em>
 * @property type Poll type, “quiz” or “regular”, defaults to “regular”
 * @property allows_multiple_answers True, if the poll allows multiple answers, ignored for polls in quiz mode, defaults to <em>False</em>
 * @property correct_option_id 0-based identifier of the correct answer option, required for polls in quiz mode
 * @property explanation Text that is shown when a user chooses an incorrect answer or taps on the lamp icon in a quiz-style poll, 0-200 characters with at most 2 line feeds after entities parsing
 * @property explanation_parse_mode Mode for parsing entities in the explanation. See <a href="#formatting-options">formatting options</a> for more details.
 * @property open_period Amount of time in seconds the poll will be active after creation, 5-600. Can't be used together with <em>close_date</em>.
 * @property close_date Point in time (Unix timestamp) when the poll will be automatically closed. Must be at least 5 and no more than 600 seconds in the future. Can't be used together with <em>open_period</em>.
 * @property is_closed Pass <em>True</em>, if the poll needs to be immediately closed. This can be useful for poll preview.
 * @property disable_notification Sends the message <a href="https://telegram.org/blog/channels-2-0#silent-messages">silently</a>. Users will receive a notification with no sound.
 * @property reply_to_message_id If the message is a reply, ID of the original message
 * @property reply_markup Additional interface options. A JSON-serialized object for an <a href="https://core.telegram.org/bots#inline-keyboards-and-on-the-fly-updating">inline keyboard</a>, <a href="https://core.telegram.org/bots#keyboards">custom reply keyboard</a>, instructions to remove reply keyboard or to force a reply from the user.
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct SendPollRequest {
    /// Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>)
    pub chat_id: String,
    /// Poll question, 1-255 characters
    pub question: String,
    /// A JSON-serialized list of answer options, 2-10 strings 1-100 characters each
    pub options: Vec<String>,
    /// True, if the poll needs to be anonymous, defaults to <em>True</em>
    pub is_anonymous: Option<bool>,
    /// Poll type, “quiz” or “regular”, defaults to “regular”
    #[serde(rename = "type")]
    pub type_: Option<String>,
    /// True, if the poll allows multiple answers, ignored for polls in quiz mode, defaults to <em>False</em>
    pub allows_multiple_answers: Option<bool>,
    /// 0-based identifier of the correct answer option, required for polls in quiz mode
    pub correct_option_id: Option<Integer>,
    /// Text that is shown when a user chooses an incorrect answer or taps on the lamp icon in a quiz-style poll, 0-200 characters with at most 2 line feeds after entities parsing
    pub explanation: Option<String>,
    /// Mode for parsing entities in the explanation. See <a href="#formatting-options">formatting options</a> for more details.
    pub explanation_parse_mode: Option<String>,
    /// Amount of time in seconds the poll will be active after creation, 5-600. Can't be used together with <em>close_date</em>.
    pub open_period: Option<Integer>,
    /// Point in time (Unix timestamp) when the poll will be automatically closed. Must be at least 5 and no more than 600 seconds in the future. Can't be used together with <em>open_period</em>.
    pub close_date: Option<Integer>,
    /// Pass <em>True</em>, if the poll needs to be immediately closed. This can be useful for poll preview.
    pub is_closed: Option<bool>,
    /// Sends the message <a href="https://telegram.org/blog/channels-2-0#silent-messages">silently</a>. Users will receive a notification with no sound.
    pub disable_notification: Option<bool>,
    /// If the message is a reply, ID of the original message
    pub reply_to_message_id: Option<Integer>,
    /// Additional interface options. A JSON-serialized object for an <a href="https://core.telegram.org/bots#inline-keyboards-and-on-the-fly-updating">inline keyboard</a>, <a href="https://core.telegram.org/bots#keyboards">custom reply keyboard</a>, instructions to remove reply keyboard or to force a reply from the user.
    pub reply_markup: Option<KeyboardOption>
}

/**
 * <p>Use this method to send an animated emoji that will display a random value. On success, the sent <a href="#message">Message</a> is returned.</p>
 *
 * @property chat_id Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>)
 * @property emoji Emoji on which the dice throw animation is based. Currently, must be one of “<img class="emoji" src="//telegram.org/img/emoji/40/F09F8EB2.png" width="20" height="20" alt="🎲">”, “<img class="emoji" src="//telegram.org/img/emoji/40/F09F8EAF.png" width="20" height="20" alt="🎯">”, or “<img class="emoji" src="//telegram.org/img/emoji/40/F09F8F80.png" width="20" height="20" alt="🏀">”. Dice can have values 1-6 for “<img class="emoji" src="//telegram.org/img/emoji/40/F09F8EB2.png" width="20" height="20" alt="🎲">” and “<img class="emoji" src="//telegram.org/img/emoji/40/F09F8EAF.png" width="20" height="20" alt="🎯">”, and values 1-5 for “<img class="emoji" src="//telegram.org/img/emoji/40/F09F8F80.png" width="20" height="20" alt="🏀">”. Defaults to “<img class="emoji" src="//telegram.org/img/emoji/40/F09F8EB2.png" width="20" height="20" alt="🎲">”
 * @property disable_notification Sends the message <a href="https://telegram.org/blog/channels-2-0#silent-messages">silently</a>. Users will receive a notification with no sound.
 * @property reply_to_message_id If the message is a reply, ID of the original message
 * @property reply_markup Additional interface options. A JSON-serialized object for an <a href="https://core.telegram.org/bots#inline-keyboards-and-on-the-fly-updating">inline keyboard</a>, <a href="https://core.telegram.org/bots#keyboards">custom reply keyboard</a>, instructions to remove reply keyboard or to force a reply from the user.
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct SendDiceRequest {
    /// Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>)
    pub chat_id: String,
    /// Emoji on which the dice throw animation is based. Currently, must be one of “<img class="emoji" src="//telegram.org/img/emoji/40/F09F8EB2.png" width="20" height="20" alt="🎲">”, “<img class="emoji" src="//telegram.org/img/emoji/40/F09F8EAF.png" width="20" height="20" alt="🎯">”, or “<img class="emoji" src="//telegram.org/img/emoji/40/F09F8F80.png" width="20" height="20" alt="🏀">”. Dice can have values 1-6 for “<img class="emoji" src="//telegram.org/img/emoji/40/F09F8EB2.png" width="20" height="20" alt="🎲">” and “<img class="emoji" src="//telegram.org/img/emoji/40/F09F8EAF.png" width="20" height="20" alt="🎯">”, and values 1-5 for “<img class="emoji" src="//telegram.org/img/emoji/40/F09F8F80.png" width="20" height="20" alt="🏀">”. Defaults to “<img class="emoji" src="//telegram.org/img/emoji/40/F09F8EB2.png" width="20" height="20" alt="🎲">”
    pub emoji: Option<String>,
    /// Sends the message <a href="https://telegram.org/blog/channels-2-0#silent-messages">silently</a>. Users will receive a notification with no sound.
    pub disable_notification: Option<bool>,
    /// If the message is a reply, ID of the original message
    pub reply_to_message_id: Option<Integer>,
    /// Additional interface options. A JSON-serialized object for an <a href="https://core.telegram.org/bots#inline-keyboards-and-on-the-fly-updating">inline keyboard</a>, <a href="https://core.telegram.org/bots#keyboards">custom reply keyboard</a>, instructions to remove reply keyboard or to force a reply from the user.
    pub reply_markup: Option<KeyboardOption>
}

/**
 * <p>Use this method when you need to tell the user that something is happening on the bot's side. The status is set for 5 seconds or less (when a message arrives from your bot, Telegram clients clear its typing status). Returns <em>True</em> on success.</p><blockquote> 
 *  <p>Example: The <a href="https://t.me/imagebot">ImageBot</a> needs some time to process a request and upload the image. Instead of sending a text message along the lines of “Retrieving image, please wait…”, the bot may use <a href="#sendchataction">sendChatAction</a> with <em>action</em> = <em>upload_photo</em>. The user will see a “sending photo” status for the bot.</p> 
 * </blockquote><p>We only recommend using this method when a response from the bot will take a <strong>noticeable</strong> amount of time to arrive.</p>
 *
 * @property chat_id Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>)
 * @property action Type of action to broadcast. Choose one, depending on what the user is about to receive: <em>typing</em> for <a href="#sendmessage">text messages</a>, <em>upload_photo</em> for <a href="#sendphoto">photos</a>, <em>record_video</em> or <em>upload_video</em> for <a href="#sendvideo">videos</a>, <em>record_audio</em> or <em>upload_audio</em> for <a href="#sendaudio">audio files</a>, <em>upload_document</em> for <a href="#senddocument">general files</a>, <em>find_location</em> for <a href="#sendlocation">location data</a>, <em>record_video_note</em> or <em>upload_video_note</em> for <a href="#sendvideonote">video notes</a>.
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct SendChatActionRequest {
    /// Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>)
    pub chat_id: String,
    /// Type of action to broadcast. Choose one, depending on what the user is about to receive: <em>typing</em> for <a href="#sendmessage">text messages</a>, <em>upload_photo</em> for <a href="#sendphoto">photos</a>, <em>record_video</em> or <em>upload_video</em> for <a href="#sendvideo">videos</a>, <em>record_audio</em> or <em>upload_audio</em> for <a href="#sendaudio">audio files</a>, <em>upload_document</em> for <a href="#senddocument">general files</a>, <em>find_location</em> for <a href="#sendlocation">location data</a>, <em>record_video_note</em> or <em>upload_video_note</em> for <a href="#sendvideonote">video notes</a>.
    pub action: String
}

/**
 * <p>Use this method to get a list of profile pictures for a user. Returns a <a href="#userprofilephotos">UserProfilePhotos</a> object.</p>
 *
 * @property user_id Unique identifier of the target user
 * @property offset Sequential number of the first photo to be returned. By default, all photos are returned.
 * @property limit Limits the number of photos to be retrieved. Values between 1-100 are accepted. Defaults to 100.
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct GetUserProfilePhotosRequest {
    /// Unique identifier of the target user
    pub user_id: Integer,
    /// Sequential number of the first photo to be returned. By default, all photos are returned.
    pub offset: Option<Integer>,
    /// Limits the number of photos to be retrieved. Values between 1-100 are accepted. Defaults to 100.
    pub limit: Option<Integer>
}

/**
 * <p>Use this method to get basic info about a file and prepare it for downloading. For the moment, bots can download files of up to 20MB in size. On success, a <a href="#file">File</a> object is returned. The file can then be downloaded via the link <code>https://api.telegram.org/file/bot&lt;token&gt;/&lt;file_path&gt;</code>, where <code>&lt;file_path&gt;</code> is taken from the response. It is guaranteed that the link will be valid for at least 1 hour. When the link expires, a new one can be requested by calling <a href="#getfile">getFile</a> again.</p><p><strong>Note:</strong> This function may not preserve the original file name and MIME type. You should save the file's MIME type and name (if available) when the File object is received.</p>
 *
 * @property file_id File identifier to get info about
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct GetFileRequest {
    /// File identifier to get info about
    pub file_id: String
}

/**
 * <p>Use this method to kick a user from a group, a supergroup or a channel. In the case of supergroups and channels, the user will not be able to return to the group on their own using invite links, etc., unless <a href="#unbanchatmember">unbanned</a> first. The bot must be an administrator in the chat for this to work and must have the appropriate admin rights. Returns <em>True</em> on success.</p>
 *
 * @property chat_id Unique identifier for the target group or username of the target supergroup or channel (in the format <code>@channelusername</code>)
 * @property user_id Unique identifier of the target user
 * @property until_date Date when the user will be unbanned, unix time. If user is banned for more than 366 days or less than 30 seconds from the current time they are considered to be banned forever
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct KickChatMemberRequest {
    /// Unique identifier for the target group or username of the target supergroup or channel (in the format <code>@channelusername</code>)
    pub chat_id: String,
    /// Unique identifier of the target user
    pub user_id: Integer,
    /// Date when the user will be unbanned, unix time. If user is banned for more than 366 days or less than 30 seconds from the current time they are considered to be banned forever
    pub until_date: Option<Integer>
}

/**
 * <p>Use this method to unban a previously kicked user in a supergroup or channel. The user will <strong>not</strong> return to the group or channel automatically, but will be able to join via link, etc. The bot must be an administrator for this to work. Returns <em>True</em> on success.</p>
 *
 * @property chat_id Unique identifier for the target group or username of the target supergroup or channel (in the format <code>@username</code>)
 * @property user_id Unique identifier of the target user
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct UnbanChatMemberRequest {
    /// Unique identifier for the target group or username of the target supergroup or channel (in the format <code>@username</code>)
    pub chat_id: String,
    /// Unique identifier of the target user
    pub user_id: Integer
}

/**
 * <p>Use this method to restrict a user in a supergroup. The bot must be an administrator in the supergroup for this to work and must have the appropriate admin rights. Pass <em>True</em> for all permissions to lift restrictions from a user. Returns <em>True</em> on success.</p>
 *
 * @property chat_id Unique identifier for the target chat or username of the target supergroup (in the format <code>@supergroupusername</code>)
 * @property user_id Unique identifier of the target user
 * @property permissions A JSON-serialized object for new user permissions
 * @property until_date Date when restrictions will be lifted for the user, unix time. If user is restricted for more than 366 days or less than 30 seconds from the current time, they are considered to be restricted forever
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct RestrictChatMemberRequest {
    /// Unique identifier for the target chat or username of the target supergroup (in the format <code>@supergroupusername</code>)
    pub chat_id: String,
    /// Unique identifier of the target user
    pub user_id: Integer,
    /// A JSON-serialized object for new user permissions
    pub permissions: ChatPermissions,
    /// Date when restrictions will be lifted for the user, unix time. If user is restricted for more than 366 days or less than 30 seconds from the current time, they are considered to be restricted forever
    pub until_date: Option<Integer>
}

/**
 * <p>Use this method to promote or demote a user in a supergroup or a channel. The bot must be an administrator in the chat for this to work and must have the appropriate admin rights. Pass <em>False</em> for all boolean parameters to demote a user. Returns <em>True</em> on success.</p>
 *
 * @property chat_id Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>)
 * @property user_id Unique identifier of the target user
 * @property can_change_info Pass True, if the administrator can change chat title, photo and other settings
 * @property can_post_messages Pass True, if the administrator can create channel posts, channels only
 * @property can_edit_messages Pass True, if the administrator can edit messages of other users and can pin messages, channels only
 * @property can_delete_messages Pass True, if the administrator can delete messages of other users
 * @property can_invite_users Pass True, if the administrator can invite new users to the chat
 * @property can_restrict_members Pass True, if the administrator can restrict, ban or unban chat members
 * @property can_pin_messages Pass True, if the administrator can pin messages, supergroups only
 * @property can_promote_members Pass True, if the administrator can add new administrators with a subset of their own privileges or demote administrators that he has promoted, directly or indirectly (promoted by administrators that were appointed by him)
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct PromoteChatMemberRequest {
    /// Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>)
    pub chat_id: String,
    /// Unique identifier of the target user
    pub user_id: Integer,
    /// Pass True, if the administrator can change chat title, photo and other settings
    pub can_change_info: Option<bool>,
    /// Pass True, if the administrator can create channel posts, channels only
    pub can_post_messages: Option<bool>,
    /// Pass True, if the administrator can edit messages of other users and can pin messages, channels only
    pub can_edit_messages: Option<bool>,
    /// Pass True, if the administrator can delete messages of other users
    pub can_delete_messages: Option<bool>,
    /// Pass True, if the administrator can invite new users to the chat
    pub can_invite_users: Option<bool>,
    /// Pass True, if the administrator can restrict, ban or unban chat members
    pub can_restrict_members: Option<bool>,
    /// Pass True, if the administrator can pin messages, supergroups only
    pub can_pin_messages: Option<bool>,
    /// Pass True, if the administrator can add new administrators with a subset of their own privileges or demote administrators that he has promoted, directly or indirectly (promoted by administrators that were appointed by him)
    pub can_promote_members: Option<bool>
}

/**
 * <p>Use this method to set a custom title for an administrator in a supergroup promoted by the bot. Returns <em>True</em> on success.</p>
 *
 * @property chat_id Unique identifier for the target chat or username of the target supergroup (in the format <code>@supergroupusername</code>)
 * @property user_id Unique identifier of the target user
 * @property custom_title New custom title for the administrator; 0-16 characters, emoji are not allowed
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct SetChatAdministratorCustomTitleRequest {
    /// Unique identifier for the target chat or username of the target supergroup (in the format <code>@supergroupusername</code>)
    pub chat_id: String,
    /// Unique identifier of the target user
    pub user_id: Integer,
    /// New custom title for the administrator; 0-16 characters, emoji are not allowed
    pub custom_title: String
}

/**
 * <p>Use this method to set default chat permissions for all members. The bot must be an administrator in the group or a supergroup for this to work and must have the <em>can_restrict_members</em> admin rights. Returns <em>True</em> on success.</p>
 *
 * @property chat_id Unique identifier for the target chat or username of the target supergroup (in the format <code>@supergroupusername</code>)
 * @property permissions New default chat permissions
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct SetChatPermissionsRequest {
    /// Unique identifier for the target chat or username of the target supergroup (in the format <code>@supergroupusername</code>)
    pub chat_id: String,
    /// New default chat permissions
    pub permissions: ChatPermissions
}

/**
 * <p>Use this method to generate a new invite link for a chat; any previously generated link is revoked. The bot must be an administrator in the chat for this to work and must have the appropriate admin rights. Returns the new invite link as <em>String</em> on success.</p><blockquote> 
 *  <p>Note: Each administrator in a chat generates their own invite links. Bots can't use invite links generated by other administrators. If you want your bot to work with invite links, it will need to generate its own link using <a href="#exportchatinvitelink">exportChatInviteLink</a> — after this the link will become available to the bot via the <a href="#getchat">getChat</a> method. If your bot needs to generate a new invite link replacing its previous one, use <a href="#exportchatinvitelink">exportChatInviteLink</a> again.</p> 
 * </blockquote>
 *
 * @property chat_id Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>)
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct ExportChatInviteLinkRequest {
    /// Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>)
    pub chat_id: String
}

/**
 * <p>Use this method to set a new profile photo for the chat. Photos can't be changed for private chats. The bot must be an administrator in the chat for this to work and must have the appropriate admin rights. Returns <em>True</em> on success.</p>
 *
 * @property chat_id Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>)
 * @property photo New chat photo, uploaded using multipart/form-data
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct SetChatPhotoRequest {
    /// Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>)
    pub chat_id: String,
    /// New chat photo, uploaded using multipart/form-data
    pub photo: InputFile
}

/**
 * <p>Use this method to delete a chat photo. Photos can't be changed for private chats. The bot must be an administrator in the chat for this to work and must have the appropriate admin rights. Returns <em>True</em> on success.</p>
 *
 * @property chat_id Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>)
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct DeleteChatPhotoRequest {
    /// Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>)
    pub chat_id: String
}

/**
 * <p>Use this method to change the title of a chat. Titles can't be changed for private chats. The bot must be an administrator in the chat for this to work and must have the appropriate admin rights. Returns <em>True</em> on success.</p>
 *
 * @property chat_id Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>)
 * @property title New chat title, 1-255 characters
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct SetChatTitleRequest {
    /// Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>)
    pub chat_id: String,
    /// New chat title, 1-255 characters
    pub title: String
}

/**
 * <p>Use this method to change the description of a group, a supergroup or a channel. The bot must be an administrator in the chat for this to work and must have the appropriate admin rights. Returns <em>True</em> on success.</p>
 *
 * @property chat_id Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>)
 * @property description New chat description, 0-255 characters
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct SetChatDescriptionRequest {
    /// Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>)
    pub chat_id: String,
    /// New chat description, 0-255 characters
    pub description: Option<String>
}

/**
 * <p>Use this method to pin a message in a group, a supergroup, or a channel. The bot must be an administrator in the chat for this to work and must have the 'can_pin_messages' admin right in the supergroup or 'can_edit_messages' admin right in the channel. Returns <em>True</em> on success.</p>
 *
 * @property chat_id Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>)
 * @property message_id Identifier of a message to pin
 * @property disable_notification Pass <em>True</em>, if it is not necessary to send a notification to all chat members about the new pinned message. Notifications are always disabled in channels.
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct PinChatMessageRequest {
    /// Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>)
    pub chat_id: String,
    /// Identifier of a message to pin
    pub message_id: Integer,
    /// Pass <em>True</em>, if it is not necessary to send a notification to all chat members about the new pinned message. Notifications are always disabled in channels.
    pub disable_notification: Option<bool>
}

/**
 * <p>Use this method to unpin a message in a group, a supergroup, or a channel. The bot must be an administrator in the chat for this to work and must have the 'can_pin_messages' admin right in the supergroup or 'can_edit_messages' admin right in the channel. Returns <em>True</em> on success.</p>
 *
 * @property chat_id Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>)
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct UnpinChatMessageRequest {
    /// Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>)
    pub chat_id: String
}

/**
 * <p>Use this method for your bot to leave a group, supergroup or channel. Returns <em>True</em> on success.</p>
 *
 * @property chat_id Unique identifier for the target chat or username of the target supergroup or channel (in the format <code>@channelusername</code>)
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct LeaveChatRequest {
    /// Unique identifier for the target chat or username of the target supergroup or channel (in the format <code>@channelusername</code>)
    pub chat_id: String
}

/**
 * <p>Use this method to get up to date information about the chat (current name of the user for one-on-one conversations, current username of a user, group or channel, etc.). Returns a <a href="#chat">Chat</a> object on success.</p>
 *
 * @property chat_id Unique identifier for the target chat or username of the target supergroup or channel (in the format <code>@channelusername</code>)
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct GetChatRequest {
    /// Unique identifier for the target chat or username of the target supergroup or channel (in the format <code>@channelusername</code>)
    pub chat_id: String
}

/**
 * <p>Use this method to get a list of administrators in a chat. On success, returns an Array of <a href="#chatmember">ChatMember</a> objects that contains information about all chat administrators except other bots. If the chat is a group or a supergroup and no administrators were appointed, only the creator will be returned.</p>
 *
 * @property chat_id Unique identifier for the target chat or username of the target supergroup or channel (in the format <code>@channelusername</code>)
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct GetChatAdministratorsRequest {
    /// Unique identifier for the target chat or username of the target supergroup or channel (in the format <code>@channelusername</code>)
    pub chat_id: String
}

/**
 * <p>Use this method to get the number of members in a chat. Returns <em>Int</em> on success.</p>
 *
 * @property chat_id Unique identifier for the target chat or username of the target supergroup or channel (in the format <code>@channelusername</code>)
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct GetChatMembersCountRequest {
    /// Unique identifier for the target chat or username of the target supergroup or channel (in the format <code>@channelusername</code>)
    pub chat_id: String
}

/**
 * <p>Use this method to get information about a member of a chat. Returns a <a href="#chatmember">ChatMember</a> object on success.</p>
 *
 * @property chat_id Unique identifier for the target chat or username of the target supergroup or channel (in the format <code>@channelusername</code>)
 * @property user_id Unique identifier of the target user
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct GetChatMemberRequest {
    /// Unique identifier for the target chat or username of the target supergroup or channel (in the format <code>@channelusername</code>)
    pub chat_id: String,
    /// Unique identifier of the target user
    pub user_id: Integer
}

/**
 * <p>Use this method to set a new group sticker set for a supergroup. The bot must be an administrator in the chat for this to work and must have the appropriate admin rights. Use the field <em>can_set_sticker_set</em> optionally returned in <a href="#getchat">getChat</a> requests to check if the bot can use this method. Returns <em>True</em> on success.</p>
 *
 * @property chat_id Unique identifier for the target chat or username of the target supergroup (in the format <code>@supergroupusername</code>)
 * @property sticker_set_name Name of the sticker set to be set as the group sticker set
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct SetChatStickerSetRequest {
    /// Unique identifier for the target chat or username of the target supergroup (in the format <code>@supergroupusername</code>)
    pub chat_id: String,
    /// Name of the sticker set to be set as the group sticker set
    pub sticker_set_name: String
}

/**
 * <p>Use this method to delete a group sticker set from a supergroup. The bot must be an administrator in the chat for this to work and must have the appropriate admin rights. Use the field <em>can_set_sticker_set</em> optionally returned in <a href="#getchat">getChat</a> requests to check if the bot can use this method. Returns <em>True</em> on success.</p>
 *
 * @property chat_id Unique identifier for the target chat or username of the target supergroup (in the format <code>@supergroupusername</code>)
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct DeleteChatStickerSetRequest {
    /// Unique identifier for the target chat or username of the target supergroup (in the format <code>@supergroupusername</code>)
    pub chat_id: String
}

/**
 * <p>Use this method to send answers to callback queries sent from <a href="/bots#inline-keyboards-and-on-the-fly-updating">inline keyboards</a>. The answer will be displayed to the user as a notification at the top of the chat screen or as an alert. On success, <em>True</em> is returned.</p><blockquote> 
 *  <p>Alternatively, the user can be redirected to the specified Game URL. For this option to work, you must first create a game for your bot via <a href="https://t.me/botfather">@Botfather</a> and accept the terms. Otherwise, you may use links like <code>t.me/your_bot?start=XXXX</code> that open your bot with a parameter.</p> 
 * </blockquote>
 *
 * @property callback_query_id Unique identifier for the query to be answered
 * @property text Text of the notification. If not specified, nothing will be shown to the user, 0-200 characters
 * @property show_alert If <em>true</em>, an alert will be shown by the client instead of a notification at the top of the chat screen. Defaults to <em>false</em>.
 * @property url URL that will be opened by the user's client. If you have created a <a href="#game">Game</a> and accepted the conditions via <a href="https://t.me/botfather">@Botfather</a>, specify the URL that opens your game — note that this will only work if the query comes from a <a href="#inlinekeyboardbutton"><em>callback_game</em></a> button.<br><br>Otherwise, you may use links like <code>t.me/your_bot?start=XXXX</code> that open your bot with a parameter.
 * @property cache_time The maximum amount of time in seconds that the result of the callback query may be cached client-side. Telegram apps will support caching starting in version 3.14. Defaults to 0.
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct AnswerCallbackQueryRequest {
    /// Unique identifier for the query to be answered
    pub callback_query_id: String,
    /// Text of the notification. If not specified, nothing will be shown to the user, 0-200 characters
    pub text: Option<String>,
    /// If <em>true</em>, an alert will be shown by the client instead of a notification at the top of the chat screen. Defaults to <em>false</em>.
    pub show_alert: Option<bool>,
    /// URL that will be opened by the user's client. If you have created a <a href="#game">Game</a> and accepted the conditions via <a href="https://t.me/botfather">@Botfather</a>, specify the URL that opens your game — note that this will only work if the query comes from a <a href="#inlinekeyboardbutton"><em>callback_game</em></a> button.<br><br>Otherwise, you may use links like <code>t.me/your_bot?start=XXXX</code> that open your bot with a parameter.
    pub url: Option<String>,
    /// The maximum amount of time in seconds that the result of the callback query may be cached client-side. Telegram apps will support caching starting in version 3.14. Defaults to 0.
    pub cache_time: Option<Integer>
}

/**
 * <p>Use this method to change the list of the bot's commands. Returns <em>True</em> on success.</p>
 *
 * @property commands A JSON-serialized list of bot commands to be set as the list of the bot's commands. At most 100 commands can be specified.
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct SetMyCommandsRequest {
    /// A JSON-serialized list of bot commands to be set as the list of the bot's commands. At most 100 commands can be specified.
    pub commands: Vec<BotCommand>
}


/// Updating messages

/**
 * <p>Use this method to edit text and <a href="#games">game</a> messages. On success, if edited message is sent by the bot, the edited <a href="#message">Message</a> is returned, otherwise <em>True</em> is returned.</p>
 *
 * @property chat_id Required if <em>inline_message_id</em> is not specified. Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>)
 * @property message_id Required if <em>inline_message_id</em> is not specified. Identifier of the message to edit
 * @property inline_message_id Required if <em>chat_id</em> and <em>message_id</em> are not specified. Identifier of the inline message
 * @property text New text of the message, 1-4096 characters after entities parsing
 * @property parse_mode Mode for parsing entities in the message text. See <a href="#formatting-options">formatting options</a> for more details.
 * @property disable_web_page_preview Disables link previews for links in this message
 * @property reply_markup A JSON-serialized object for an <a href="https://core.telegram.org/bots#inline-keyboards-and-on-the-fly-updating">inline keyboard</a>.
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct EditMessageTextRequest {
    /// Required if <em>inline_message_id</em> is not specified. Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>)
    pub chat_id: Option<String>,
    /// Required if <em>inline_message_id</em> is not specified. Identifier of the message to edit
    pub message_id: Option<Integer>,
    /// Required if <em>chat_id</em> and <em>message_id</em> are not specified. Identifier of the inline message
    pub inline_message_id: Option<String>,
    /// New text of the message, 1-4096 characters after entities parsing
    pub text: String,
    /// Mode for parsing entities in the message text. See <a href="#formatting-options">formatting options</a> for more details.
    pub parse_mode: Option<ParseMode>,
    /// Disables link previews for links in this message
    pub disable_web_page_preview: Option<bool>,
    /// A JSON-serialized object for an <a href="https://core.telegram.org/bots#inline-keyboards-and-on-the-fly-updating">inline keyboard</a>.
    pub reply_markup: Option<InlineKeyboardMarkup>
}

/**
 * <p>Use this method to edit captions of messages. On success, if edited message is sent by the bot, the edited <a href="#message">Message</a> is returned, otherwise <em>True</em> is returned.</p>
 *
 * @property chat_id Required if <em>inline_message_id</em> is not specified. Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>)
 * @property message_id Required if <em>inline_message_id</em> is not specified. Identifier of the message to edit
 * @property inline_message_id Required if <em>chat_id</em> and <em>message_id</em> are not specified. Identifier of the inline message
 * @property caption New caption of the message, 0-1024 characters after entities parsing
 * @property parse_mode Mode for parsing entities in the message caption. See <a href="#formatting-options">formatting options</a> for more details.
 * @property reply_markup A JSON-serialized object for an <a href="https://core.telegram.org/bots#inline-keyboards-and-on-the-fly-updating">inline keyboard</a>.
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct EditMessageCaptionRequest {
    /// Required if <em>inline_message_id</em> is not specified. Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>)
    pub chat_id: Option<String>,
    /// Required if <em>inline_message_id</em> is not specified. Identifier of the message to edit
    pub message_id: Option<Integer>,
    /// Required if <em>chat_id</em> and <em>message_id</em> are not specified. Identifier of the inline message
    pub inline_message_id: Option<String>,
    /// New caption of the message, 0-1024 characters after entities parsing
    pub caption: Option<String>,
    /// Mode for parsing entities in the message caption. See <a href="#formatting-options">formatting options</a> for more details.
    pub parse_mode: Option<ParseMode>,
    /// A JSON-serialized object for an <a href="https://core.telegram.org/bots#inline-keyboards-and-on-the-fly-updating">inline keyboard</a>.
    pub reply_markup: Option<InlineKeyboardMarkup>
}

/**
 * <p>Use this method to edit animation, audio, document, photo, or video messages. If a message is a part of a message album, then it can be edited only to a photo or a video. Otherwise, message type can be changed arbitrarily. When inline message is edited, new file can't be uploaded. Use previously uploaded file via its file_id or specify a URL. On success, if the edited message was sent by the bot, the edited <a href="#message">Message</a> is returned, otherwise <em>True</em> is returned.</p>
 *
 * @property chat_id Required if <em>inline_message_id</em> is not specified. Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>)
 * @property message_id Required if <em>inline_message_id</em> is not specified. Identifier of the message to edit
 * @property inline_message_id Required if <em>chat_id</em> and <em>message_id</em> are not specified. Identifier of the inline message
 * @property media A JSON-serialized object for a new media content of the message
 * @property reply_markup A JSON-serialized object for a new <a href="https://core.telegram.org/bots#inline-keyboards-and-on-the-fly-updating">inline keyboard</a>.
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct EditMessageMediaRequest {
    /// Required if <em>inline_message_id</em> is not specified. Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>)
    pub chat_id: Option<String>,
    /// Required if <em>inline_message_id</em> is not specified. Identifier of the message to edit
    pub message_id: Option<Integer>,
    /// Required if <em>chat_id</em> and <em>message_id</em> are not specified. Identifier of the inline message
    pub inline_message_id: Option<String>,
    /// A JSON-serialized object for a new media content of the message
    pub media: InputMedia,
    /// A JSON-serialized object for a new <a href="https://core.telegram.org/bots#inline-keyboards-and-on-the-fly-updating">inline keyboard</a>.
    pub reply_markup: Option<InlineKeyboardMarkup>
}

/**
 * <p>Use this method to edit only the reply markup of messages. On success, if edited message is sent by the bot, the edited <a href="#message">Message</a> is returned, otherwise <em>True</em> is returned.</p>
 *
 * @property chat_id Required if <em>inline_message_id</em> is not specified. Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>)
 * @property message_id Required if <em>inline_message_id</em> is not specified. Identifier of the message to edit
 * @property inline_message_id Required if <em>chat_id</em> and <em>message_id</em> are not specified. Identifier of the inline message
 * @property reply_markup A JSON-serialized object for an <a href="https://core.telegram.org/bots#inline-keyboards-and-on-the-fly-updating">inline keyboard</a>.
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct EditMessageReplyMarkupRequest {
    /// Required if <em>inline_message_id</em> is not specified. Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>)
    pub chat_id: Option<String>,
    /// Required if <em>inline_message_id</em> is not specified. Identifier of the message to edit
    pub message_id: Option<Integer>,
    /// Required if <em>chat_id</em> and <em>message_id</em> are not specified. Identifier of the inline message
    pub inline_message_id: Option<String>,
    /// A JSON-serialized object for an <a href="https://core.telegram.org/bots#inline-keyboards-and-on-the-fly-updating">inline keyboard</a>.
    pub reply_markup: Option<InlineKeyboardMarkup>
}

/**
 * <p>Use this method to stop a poll which was sent by the bot. On success, the stopped <a href="#poll">Poll</a> with the final results is returned.</p>
 *
 * @property chat_id Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>)
 * @property message_id Identifier of the original message with the poll
 * @property reply_markup A JSON-serialized object for a new message <a href="https://core.telegram.org/bots#inline-keyboards-and-on-the-fly-updating">inline keyboard</a>.
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct StopPollRequest {
    /// Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>)
    pub chat_id: String,
    /// Identifier of the original message with the poll
    pub message_id: Integer,
    /// A JSON-serialized object for a new message <a href="https://core.telegram.org/bots#inline-keyboards-and-on-the-fly-updating">inline keyboard</a>.
    pub reply_markup: Option<InlineKeyboardMarkup>
}

/**
 * <p>Use this method to delete a message, including service messages, with the following limitations:<br>- A message can only be deleted if it was sent less than 48 hours ago.<br>- A dice message in a private chat can only be deleted if it was sent more than 24 hours ago.<br>- Bots can delete outgoing messages in private chats, groups, and supergroups.<br>- Bots can delete incoming messages in private chats.<br>- Bots granted <em>can_post_messages</em> permissions can delete outgoing messages in channels.<br>- If the bot is an administrator of a group, it can delete any message there.<br>- If the bot has <em>can_delete_messages</em> permission in a supergroup or a channel, it can delete any message there.<br>Returns <em>True</em> on success.</p>
 *
 * @property chat_id Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>)
 * @property message_id Identifier of the message to delete
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct DeleteMessageRequest {
    /// Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>)
    pub chat_id: String,
    /// Identifier of the message to delete
    pub message_id: Integer
}


/// Stickers

/**
 * <p>Use this method to send static .WEBP or <a href="https://telegram.org/blog/animated-stickers">animated</a> .TGS stickers. On success, the sent <a href="#message">Message</a> is returned.</p>
 *
 * @property chat_id Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>)
 * @property sticker Sticker to send. Pass a file_id as String to send a file that exists on the Telegram servers (recommended), pass an HTTP URL as a String for Telegram to get a .WEBP file from the Internet, or upload a new one using multipart/form-data. <a href="#sending-files">More info on Sending Files »</a>
 * @property disable_notification Sends the message <a href="https://telegram.org/blog/channels-2-0#silent-messages">silently</a>. Users will receive a notification with no sound.
 * @property reply_to_message_id If the message is a reply, ID of the original message
 * @property reply_markup Additional interface options. A JSON-serialized object for an <a href="https://core.telegram.org/bots#inline-keyboards-and-on-the-fly-updating">inline keyboard</a>, <a href="https://core.telegram.org/bots#keyboards">custom reply keyboard</a>, instructions to remove reply keyboard or to force a reply from the user.
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct SendStickerRequest {
    /// Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>)
    pub chat_id: String,
    /// Sticker to send. Pass a file_id as String to send a file that exists on the Telegram servers (recommended), pass an HTTP URL as a String for Telegram to get a .WEBP file from the Internet, or upload a new one using multipart/form-data. <a href="#sending-files">More info on Sending Files »</a>
    pub sticker: String,
    /// Sends the message <a href="https://telegram.org/blog/channels-2-0#silent-messages">silently</a>. Users will receive a notification with no sound.
    pub disable_notification: Option<bool>,
    /// If the message is a reply, ID of the original message
    pub reply_to_message_id: Option<Integer>,
    /// Additional interface options. A JSON-serialized object for an <a href="https://core.telegram.org/bots#inline-keyboards-and-on-the-fly-updating">inline keyboard</a>, <a href="https://core.telegram.org/bots#keyboards">custom reply keyboard</a>, instructions to remove reply keyboard or to force a reply from the user.
    pub reply_markup: Option<KeyboardOption>
}

/**
 * <p>Use this method to get a sticker set. On success, a <a href="#stickerset">StickerSet</a> object is returned.</p>
 *
 * @property name Name of the sticker set
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct GetStickerSetRequest {
    /// Name of the sticker set
    pub name: String
}

/**
 * <p>Use this method to upload a .PNG file with a sticker for later use in <em>createNewStickerSet</em> and <em>addStickerToSet</em> methods (can be used multiple times). Returns the uploaded <a href="#file">File</a> on success.</p>
 *
 * @property user_id User identifier of sticker file owner
 * @property png_sticker <strong>PNG</strong> image with the sticker, must be up to 512 kilobytes in size, dimensions must not exceed 512px, and either width or height must be exactly 512px. <a href="#sending-files">More info on Sending Files »</a>
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct UploadStickerFileRequest {
    /// User identifier of sticker file owner
    pub user_id: Integer,
    /// <strong>PNG</strong> image with the sticker, must be up to 512 kilobytes in size, dimensions must not exceed 512px, and either width or height must be exactly 512px. <a href="#sending-files">More info on Sending Files »</a>
    pub png_sticker: InputFile
}

/**
 * <p>Use this method to create a new sticker set owned by a user. The bot will be able to edit the sticker set thus created. You <strong>must</strong> use exactly one of the fields <em>png_sticker</em> or <em>tgs_sticker</em>. Returns <em>True</em> on success.</p>
 *
 * @property user_id User identifier of created sticker set owner
 * @property name Short name of sticker set, to be used in <code>t.me/addstickers/</code> URLs (e.g., <em>animals</em>). Can contain only english letters, digits and underscores. Must begin with a letter, can't contain consecutive underscores and must end in <em>“_by_&lt;bot username&gt;”</em>. <em>&lt;bot_username&gt;</em> is case insensitive. 1-64 characters.
 * @property title Sticker set title, 1-64 characters
 * @property png_sticker <strong>PNG</strong> image with the sticker, must be up to 512 kilobytes in size, dimensions must not exceed 512px, and either width or height must be exactly 512px. Pass a <em>file_id</em> as a String to send a file that already exists on the Telegram servers, pass an HTTP URL as a String for Telegram to get a file from the Internet, or upload a new one using multipart/form-data. <a href="#sending-files">More info on Sending Files »</a>
 * @property tgs_sticker <strong>TGS</strong> animation with the sticker, uploaded using multipart/form-data. See <a href="https://core.telegram.org/animated_stickers#technical-requirements"></a><a href="https://core.telegram.org/animated_stickers#technical-requirements">https://core.telegram.org/animated_stickers#technical-requirements</a> for technical requirements
 * @property emojis One or more emoji corresponding to the sticker
 * @property contains_masks Pass <em>True</em>, if a set of mask stickers should be created
 * @property mask_position A JSON-serialized object for position where the mask should be placed on faces
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct CreateNewStickerSetRequest {
    /// User identifier of created sticker set owner
    pub user_id: Integer,
    /// Short name of sticker set, to be used in <code>t.me/addstickers/</code> URLs (e.g., <em>animals</em>). Can contain only english letters, digits and underscores. Must begin with a letter, can't contain consecutive underscores and must end in <em>“_by_&lt;bot username&gt;”</em>. <em>&lt;bot_username&gt;</em> is case insensitive. 1-64 characters.
    pub name: String,
    /// Sticker set title, 1-64 characters
    pub title: String,
    /// <strong>PNG</strong> image with the sticker, must be up to 512 kilobytes in size, dimensions must not exceed 512px, and either width or height must be exactly 512px. Pass a <em>file_id</em> as a String to send a file that already exists on the Telegram servers, pass an HTTP URL as a String for Telegram to get a file from the Internet, or upload a new one using multipart/form-data. <a href="#sending-files">More info on Sending Files »</a>
    pub png_sticker: Option<String>,
    /// <strong>TGS</strong> animation with the sticker, uploaded using multipart/form-data. See <a href="https://core.telegram.org/animated_stickers#technical-requirements"></a><a href="https://core.telegram.org/animated_stickers#technical-requirements">https://core.telegram.org/animated_stickers#technical-requirements</a> for technical requirements
    pub tgs_sticker: Option<InputFile>,
    /// One or more emoji corresponding to the sticker
    pub emojis: String,
    /// Pass <em>True</em>, if a set of mask stickers should be created
    pub contains_masks: Option<bool>,
    /// A JSON-serialized object for position where the mask should be placed on faces
    pub mask_position: Option<MaskPosition>
}

/**
 * <p>Use this method to add a new sticker to a set created by the bot. You <strong>must</strong> use exactly one of the fields <em>png_sticker</em> or <em>tgs_sticker</em>. Animated stickers can be added to animated sticker sets and only to them. Animated sticker sets can have up to 50 stickers. Static sticker sets can have up to 120 stickers. Returns <em>True</em> on success.</p>
 *
 * @property user_id User identifier of sticker set owner
 * @property name Sticker set name
 * @property png_sticker <strong>PNG</strong> image with the sticker, must be up to 512 kilobytes in size, dimensions must not exceed 512px, and either width or height must be exactly 512px. Pass a <em>file_id</em> as a String to send a file that already exists on the Telegram servers, pass an HTTP URL as a String for Telegram to get a file from the Internet, or upload a new one using multipart/form-data. <a href="#sending-files">More info on Sending Files »</a>
 * @property tgs_sticker <strong>TGS</strong> animation with the sticker, uploaded using multipart/form-data. See <a href="https://core.telegram.org/animated_stickers#technical-requirements"></a><a href="https://core.telegram.org/animated_stickers#technical-requirements">https://core.telegram.org/animated_stickers#technical-requirements</a> for technical requirements
 * @property emojis One or more emoji corresponding to the sticker
 * @property mask_position A JSON-serialized object for position where the mask should be placed on faces
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct AddStickerToSetRequest {
    /// User identifier of sticker set owner
    pub user_id: Integer,
    /// Sticker set name
    pub name: String,
    /// <strong>PNG</strong> image with the sticker, must be up to 512 kilobytes in size, dimensions must not exceed 512px, and either width or height must be exactly 512px. Pass a <em>file_id</em> as a String to send a file that already exists on the Telegram servers, pass an HTTP URL as a String for Telegram to get a file from the Internet, or upload a new one using multipart/form-data. <a href="#sending-files">More info on Sending Files »</a>
    pub png_sticker: Option<String>,
    /// <strong>TGS</strong> animation with the sticker, uploaded using multipart/form-data. See <a href="https://core.telegram.org/animated_stickers#technical-requirements"></a><a href="https://core.telegram.org/animated_stickers#technical-requirements">https://core.telegram.org/animated_stickers#technical-requirements</a> for technical requirements
    pub tgs_sticker: Option<InputFile>,
    /// One or more emoji corresponding to the sticker
    pub emojis: String,
    /// A JSON-serialized object for position where the mask should be placed on faces
    pub mask_position: Option<MaskPosition>
}

/**
 * <p>Use this method to move a sticker in a set created by the bot to a specific position. Returns <em>True</em> on success.</p>
 *
 * @property sticker File identifier of the sticker
 * @property position New sticker position in the set, zero-based
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct SetStickerPositionInSetRequest {
    /// File identifier of the sticker
    pub sticker: String,
    /// New sticker position in the set, zero-based
    pub position: Integer
}

/**
 * <p>Use this method to delete a sticker from a set created by the bot. Returns <em>True</em> on success.</p>
 *
 * @property sticker File identifier of the sticker
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct DeleteStickerFromSetRequest {
    /// File identifier of the sticker
    pub sticker: String
}

/**
 * <p>Use this method to set the thumbnail of a sticker set. Animated thumbnails can be set for animated sticker sets only. Returns <em>True</em> on success.</p>
 *
 * @property name Sticker set name
 * @property user_id User identifier of the sticker set owner
 * @property thumb A <strong>PNG</strong> image with the thumbnail, must be up to 128 kilobytes in size and have width and height exactly 100px, or a <strong>TGS</strong> animation with the thumbnail up to 32 kilobytes in size; see <a href="https://core.telegram.org/animated_stickers#technical-requirements"></a><a href="https://core.telegram.org/animated_stickers#technical-requirements">https://core.telegram.org/animated_stickers#technical-requirements</a> for animated sticker technical requirements. Pass a <em>file_id</em> as a String to send a file that already exists on the Telegram servers, pass an HTTP URL as a String for Telegram to get a file from the Internet, or upload a new one using multipart/form-data. <a href="#sending-files">More info on Sending Files »</a>. Animated sticker set thumbnail can't be uploaded via HTTP URL.
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct SetStickerSetThumbRequest {
    /// Sticker set name
    pub name: String,
    /// User identifier of the sticker set owner
    pub user_id: Integer,
    /// A <strong>PNG</strong> image with the thumbnail, must be up to 128 kilobytes in size and have width and height exactly 100px, or a <strong>TGS</strong> animation with the thumbnail up to 32 kilobytes in size; see <a href="https://core.telegram.org/animated_stickers#technical-requirements"></a><a href="https://core.telegram.org/animated_stickers#technical-requirements">https://core.telegram.org/animated_stickers#technical-requirements</a> for animated sticker technical requirements. Pass a <em>file_id</em> as a String to send a file that already exists on the Telegram servers, pass an HTTP URL as a String for Telegram to get a file from the Internet, or upload a new one using multipart/form-data. <a href="#sending-files">More info on Sending Files »</a>. Animated sticker set thumbnail can't be uploaded via HTTP URL.
    pub thumb: Option<String>
}


/// Inline mode

/**
 * <p>Use this method to send answers to an inline query. On success, <em>True</em> is returned.<br>No more than <strong>50</strong> results per query are allowed.</p>
 *
 * @property inline_query_id Unique identifier for the answered query
 * @property results A JSON-serialized array of results for the inline query
 * @property cache_time The maximum amount of time in seconds that the result of the inline query may be cached on the server. Defaults to 300.
 * @property is_personal Pass <em>True</em>, if results may be cached on the server side only for the user that sent the query. By default, results may be returned to any user who sends the same query
 * @property next_offset Pass the offset that a client should send in the next query with the same text to receive more results. Pass an empty string if there are no more results or if you don't support pagination. Offset length can't exceed 64 bytes.
 * @property switch_pm_text If passed, clients will display a button with specified text that switches the user to a private chat with the bot and sends the bot a start message with the parameter <em>switch_pm_parameter</em>
 * @property switch_pm_parameter <a href="/bots#deep-linking">Deep-linking</a> parameter for the /start message sent to the bot when user presses the switch button. 1-64 characters, only <code>A-Z</code>, <code>a-z</code>, <code>0-9</code>, <code>_</code> and <code>-</code> are allowed.<br><br><em>Example:</em> An inline bot that sends YouTube videos can ask the user to connect the bot to their YouTube account to adapt search results accordingly. To do this, it displays a 'Connect your YouTube account' button above the results, or even before showing any. The user presses the button, switches to a private chat with the bot and, in doing so, passes a start parameter that instructs the bot to return an oauth link. Once done, the bot can offer a <a href="#inlinekeyboardmarkup"><em>switch_inline</em></a> button so that the user can easily return to the chat where they wanted to use the bot's inline capabilities.
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct AnswerInlineQueryRequest {
    /// Unique identifier for the answered query
    pub inline_query_id: String,
    /// A JSON-serialized array of results for the inline query
    pub results: Vec<InlineQueryResult>,
    /// The maximum amount of time in seconds that the result of the inline query may be cached on the server. Defaults to 300.
    pub cache_time: Option<Integer>,
    /// Pass <em>True</em>, if results may be cached on the server side only for the user that sent the query. By default, results may be returned to any user who sends the same query
    pub is_personal: Option<bool>,
    /// Pass the offset that a client should send in the next query with the same text to receive more results. Pass an empty string if there are no more results or if you don't support pagination. Offset length can't exceed 64 bytes.
    pub next_offset: Option<String>,
    /// If passed, clients will display a button with specified text that switches the user to a private chat with the bot and sends the bot a start message with the parameter <em>switch_pm_parameter</em>
    pub switch_pm_text: Option<String>,
    /// <a href="/bots#deep-linking">Deep-linking</a> parameter for the /start message sent to the bot when user presses the switch button. 1-64 characters, only <code>A-Z</code>, <code>a-z</code>, <code>0-9</code>, <code>_</code> and <code>-</code> are allowed.<br><br><em>Example:</em> An inline bot that sends YouTube videos can ask the user to connect the bot to their YouTube account to adapt search results accordingly. To do this, it displays a 'Connect your YouTube account' button above the results, or even before showing any. The user presses the button, switches to a private chat with the bot and, in doing so, passes a start parameter that instructs the bot to return an oauth link. Once done, the bot can offer a <a href="#inlinekeyboardmarkup"><em>switch_inline</em></a> button so that the user can easily return to the chat where they wanted to use the bot's inline capabilities.
    pub switch_pm_parameter: Option<String>
}


/// Payments

/**
 * <p>Use this method to send invoices. On success, the sent <a href="#message">Message</a> is returned.</p>
 *
 * @property chat_id Unique identifier for the target private chat
 * @property title Product name, 1-32 characters
 * @property description Product description, 1-255 characters
 * @property payload Bot-defined invoice payload, 1-128 bytes. This will not be displayed to the user, use for your internal processes.
 * @property provider_token Payments provider token, obtained via <a href="https://t.me/botfather">Botfather</a>
 * @property start_parameter Unique deep-linking parameter that can be used to generate this invoice when used as a start parameter
 * @property currency Three-letter ISO 4217 currency code, see <a href="/bots/payments#supported-currencies">more on currencies</a>
 * @property prices Price breakdown, a JSON-serialized list of components (e.g. product price, tax, discount, delivery cost, delivery tax, bonus, etc.)
 * @property provider_data A JSON-serialized data about the invoice, which will be shared with the payment provider. A detailed description of required fields should be provided by the payment provider.
 * @property photo_url URL of the product photo for the invoice. Can be a photo of the goods or a marketing image for a service. People like it better when they see what they are paying for.
 * @property photo_size Photo size
 * @property photo_width Photo width
 * @property photo_height Photo height
 * @property need_name Pass <em>True</em>, if you require the user's full name to complete the order
 * @property need_phone_number Pass <em>True</em>, if you require the user's phone number to complete the order
 * @property need_email Pass <em>True</em>, if you require the user's email address to complete the order
 * @property need_shipping_address Pass <em>True</em>, if you require the user's shipping address to complete the order
 * @property send_phone_number_to_provider Pass <em>True</em>, if user's phone number should be sent to provider
 * @property send_email_to_provider Pass <em>True</em>, if user's email address should be sent to provider
 * @property is_flexible Pass <em>True</em>, if the final price depends on the shipping method
 * @property disable_notification Sends the message <a href="https://telegram.org/blog/channels-2-0#silent-messages">silently</a>. Users will receive a notification with no sound.
 * @property reply_to_message_id If the message is a reply, ID of the original message
 * @property reply_markup A JSON-serialized object for an <a href="https://core.telegram.org/bots#inline-keyboards-and-on-the-fly-updating">inline keyboard</a>. If empty, one 'Pay <code>total price</code>' button will be shown. If not empty, the first button must be a Pay button.
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct SendInvoiceRequest {
    /// Unique identifier for the target private chat
    pub chat_id: Integer,
    /// Product name, 1-32 characters
    pub title: String,
    /// Product description, 1-255 characters
    pub description: String,
    /// Bot-defined invoice payload, 1-128 bytes. This will not be displayed to the user, use for your internal processes.
    pub payload: String,
    /// Payments provider token, obtained via <a href="https://t.me/botfather">Botfather</a>
    pub provider_token: String,
    /// Unique deep-linking parameter that can be used to generate this invoice when used as a start parameter
    pub start_parameter: String,
    /// Three-letter ISO 4217 currency code, see <a href="/bots/payments#supported-currencies">more on currencies</a>
    pub currency: String,
    /// Price breakdown, a JSON-serialized list of components (e.g. product price, tax, discount, delivery cost, delivery tax, bonus, etc.)
    pub prices: Vec<LabeledPrice>,
    /// A JSON-serialized data about the invoice, which will be shared with the payment provider. A detailed description of required fields should be provided by the payment provider.
    pub provider_data: Option<String>,
    /// URL of the product photo for the invoice. Can be a photo of the goods or a marketing image for a service. People like it better when they see what they are paying for.
    pub photo_url: Option<String>,
    /// Photo size
    pub photo_size: Option<Integer>,
    /// Photo width
    pub photo_width: Option<Integer>,
    /// Photo height
    pub photo_height: Option<Integer>,
    /// Pass <em>True</em>, if you require the user's full name to complete the order
    pub need_name: Option<bool>,
    /// Pass <em>True</em>, if you require the user's phone number to complete the order
    pub need_phone_number: Option<bool>,
    /// Pass <em>True</em>, if you require the user's email address to complete the order
    pub need_email: Option<bool>,
    /// Pass <em>True</em>, if you require the user's shipping address to complete the order
    pub need_shipping_address: Option<bool>,
    /// Pass <em>True</em>, if user's phone number should be sent to provider
    pub send_phone_number_to_provider: Option<bool>,
    /// Pass <em>True</em>, if user's email address should be sent to provider
    pub send_email_to_provider: Option<bool>,
    /// Pass <em>True</em>, if the final price depends on the shipping method
    pub is_flexible: Option<bool>,
    /// Sends the message <a href="https://telegram.org/blog/channels-2-0#silent-messages">silently</a>. Users will receive a notification with no sound.
    pub disable_notification: Option<bool>,
    /// If the message is a reply, ID of the original message
    pub reply_to_message_id: Option<Integer>,
    /// A JSON-serialized object for an <a href="https://core.telegram.org/bots#inline-keyboards-and-on-the-fly-updating">inline keyboard</a>. If empty, one 'Pay <code>total price</code>' button will be shown. If not empty, the first button must be a Pay button.
    pub reply_markup: Option<InlineKeyboardMarkup>
}

/**
 * <p>If you sent an invoice requesting a shipping address and the parameter <em>is_flexible</em> was specified, the Bot API will send an <a href="#update">Update</a> with a <em>shipping_query</em> field to the bot. Use this method to reply to shipping queries. On success, True is returned.</p>
 *
 * @property shipping_query_id Unique identifier for the query to be answered
 * @property ok Specify True if delivery to the specified address is possible and False if there are any problems (for example, if delivery to the specified address is not possible)
 * @property shipping_options Required if <em>ok</em> is True. A JSON-serialized array of available shipping options.
 * @property error_message Required if <em>ok</em> is False. Error message in human readable form that explains why it is impossible to complete the order (e.g. "Sorry, delivery to your desired address is unavailable'). Telegram will display this message to the user.
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct AnswerShippingQueryRequest {
    /// Unique identifier for the query to be answered
    pub shipping_query_id: String,
    /// Specify True if delivery to the specified address is possible and False if there are any problems (for example, if delivery to the specified address is not possible)
    pub ok: bool,
    /// Required if <em>ok</em> is True. A JSON-serialized array of available shipping options.
    pub shipping_options: Option<Vec<ShippingOption>>,
    /// Required if <em>ok</em> is False. Error message in human readable form that explains why it is impossible to complete the order (e.g. "Sorry, delivery to your desired address is unavailable'). Telegram will display this message to the user.
    pub error_message: Option<String>
}

/**
 * <p>Once the user has confirmed their payment and shipping details, the Bot API sends the final confirmation in the form of an <a href="#update">Update</a> with the field <em>pre_checkout_query</em>. Use this method to respond to such pre-checkout queries. On success, True is returned. <strong>Note:</strong> The Bot API must receive an answer within 10 seconds after the pre-checkout query was sent.</p>
 *
 * @property pre_checkout_query_id Unique identifier for the query to be answered
 * @property ok Specify <em>True</em> if everything is alright (goods are available, etc.) and the bot is ready to proceed with the order. Use <em>False</em> if there are any problems.
 * @property error_message Required if <em>ok</em> is <em>False</em>. Error message in human readable form that explains the reason for failure to proceed with the checkout (e.g. "Sorry, somebody just bought the last of our amazing black T-shirts while you were busy filling out your payment details. Please choose a different color or garment!"). Telegram will display this message to the user.
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct AnswerPreCheckoutQueryRequest {
    /// Unique identifier for the query to be answered
    pub pre_checkout_query_id: String,
    /// Specify <em>True</em> if everything is alright (goods are available, etc.) and the bot is ready to proceed with the order. Use <em>False</em> if there are any problems.
    pub ok: bool,
    /// Required if <em>ok</em> is <em>False</em>. Error message in human readable form that explains the reason for failure to proceed with the checkout (e.g. "Sorry, somebody just bought the last of our amazing black T-shirts while you were busy filling out your payment details. Please choose a different color or garment!"). Telegram will display this message to the user.
    pub error_message: Option<String>
}


/// Telegram Passport

/**
 * <p>Informs a user that some of the Telegram Passport elements they provided contains errors. The user will not be able to re-submit their Passport to you until the errors are fixed (the contents of the field for which you returned the error must change). Returns <em>True</em> on success.</p><p>Use this if the data submitted by the user doesn't satisfy the standards your service requires for any reason. For example, if a birthday date seems invalid, a submitted document is blurry, a scan shows evidence of tampering, etc. Supply some details in the error message to make sure the user knows how to correct the issues.</p>
 *
 * @property user_id User identifier
 * @property errors A JSON-serialized array describing the errors
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct SetPassportDataErrorsRequest {
    /// User identifier
    pub user_id: Integer,
    /// A JSON-serialized array describing the errors
    pub errors: Vec<PassportElementError>
}


/// Games

/**
 * <p>Use this method to send a game. On success, the sent <a href="#message">Message</a> is returned.</p>
 *
 * @property chat_id Unique identifier for the target chat
 * @property game_short_name Short name of the game, serves as the unique identifier for the game. Set up your games via <a href="https://t.me/botfather">Botfather</a>.
 * @property disable_notification Sends the message <a href="https://telegram.org/blog/channels-2-0#silent-messages">silently</a>. Users will receive a notification with no sound.
 * @property reply_to_message_id If the message is a reply, ID of the original message
 * @property reply_markup A JSON-serialized object for an <a href="https://core.telegram.org/bots#inline-keyboards-and-on-the-fly-updating">inline keyboard</a>. If empty, one 'Play game_title' button will be shown. If not empty, the first button must launch the game.
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct SendGameRequest {
    /// Unique identifier for the target chat
    pub chat_id: Integer,
    /// Short name of the game, serves as the unique identifier for the game. Set up your games via <a href="https://t.me/botfather">Botfather</a>.
    pub game_short_name: String,
    /// Sends the message <a href="https://telegram.org/blog/channels-2-0#silent-messages">silently</a>. Users will receive a notification with no sound.
    pub disable_notification: Option<bool>,
    /// If the message is a reply, ID of the original message
    pub reply_to_message_id: Option<Integer>,
    /// A JSON-serialized object for an <a href="https://core.telegram.org/bots#inline-keyboards-and-on-the-fly-updating">inline keyboard</a>. If empty, one 'Play game_title' button will be shown. If not empty, the first button must launch the game.
    pub reply_markup: Option<InlineKeyboardMarkup>
}

/**
 * <p>Use this method to set the score of the specified user in a game. On success, if the message was sent by the bot, returns the edited <a href="#message">Message</a>, otherwise returns <em>True</em>. Returns an error, if the new score is not greater than the user's current score in the chat and <em>force</em> is <em>False</em>.</p>
 *
 * @property user_id User identifier
 * @property score New score, must be non-negative
 * @property force Pass True, if the high score is allowed to decrease. This can be useful when fixing mistakes or banning cheaters
 * @property disable_edit_message Pass True, if the game message should not be automatically edited to include the current scoreboard
 * @property chat_id Required if <em>inline_message_id</em> is not specified. Unique identifier for the target chat
 * @property message_id Required if <em>inline_message_id</em> is not specified. Identifier of the sent message
 * @property inline_message_id Required if <em>chat_id</em> and <em>message_id</em> are not specified. Identifier of the inline message
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct SetGameScoreRequest {
    /// User identifier
    pub user_id: Integer,
    /// New score, must be non-negative
    pub score: Integer,
    /// Pass True, if the high score is allowed to decrease. This can be useful when fixing mistakes or banning cheaters
    pub force: Option<bool>,
    /// Pass True, if the game message should not be automatically edited to include the current scoreboard
    pub disable_edit_message: Option<bool>,
    /// Required if <em>inline_message_id</em> is not specified. Unique identifier for the target chat
    pub chat_id: Option<Integer>,
    /// Required if <em>inline_message_id</em> is not specified. Identifier of the sent message
    pub message_id: Option<Integer>,
    /// Required if <em>chat_id</em> and <em>message_id</em> are not specified. Identifier of the inline message
    pub inline_message_id: Option<String>
}

/**
 * <p>Use this method to get data for high score tables. Will return the score of the specified user and several of their neighbors in a game. On success, returns an <em>Array</em> of <a href="#gamehighscore">GameHighScore</a> objects.</p><blockquote> 
 *  <p>This method will currently return scores for the target user, plus two of their closest neighbors on each side. Will also return the top three users if the user and his neighbors are not among them. Please note that this behavior is subject to change.</p> 
 * </blockquote>
 *
 * @property user_id Target user id
 * @property chat_id Required if <em>inline_message_id</em> is not specified. Unique identifier for the target chat
 * @property message_id Required if <em>inline_message_id</em> is not specified. Identifier of the sent message
 * @property inline_message_id Required if <em>chat_id</em> and <em>message_id</em> are not specified. Identifier of the inline message
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct GetGameHighScoresRequest {
    /// Target user id
    pub user_id: Integer,
    /// Required if <em>inline_message_id</em> is not specified. Unique identifier for the target chat
    pub chat_id: Option<Integer>,
    /// Required if <em>inline_message_id</em> is not specified. Identifier of the sent message
    pub message_id: Option<Integer>,
    /// Required if <em>chat_id</em> and <em>message_id</em> are not specified. Identifier of the inline message
    pub inline_message_id: Option<String>
}

