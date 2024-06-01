
/// --- Parameters & Responses ---


/// Getting updates

/**
 * <p>This <a href="#available-types">object</a> represents an incoming update.<br>At most <strong>one</strong> of the optional parameters can be present in any given update.</p>
 *
 * @property update_id The update's unique identifier. Update identifiers start from a certain positive number and increase sequentially. This identifier becomes especially handy if you're using <a href="#setwebhook">webhooks</a>, since it allows you to ignore repeated updates or to restore the correct update sequence, should they get out of order. If there are no new updates for at least a week, then identifier of the next update will be chosen randomly instead of sequentially.
 * @property message <em>Optional</em>. New incoming message of any kind - text, photo, sticker, etc.
 * @property edited_message <em>Optional</em>. New version of a message that is known to the bot and was edited. This update may at times be triggered by changes to message fields that are either unavailable or not actively used by your bot.
 * @property channel_post <em>Optional</em>. New incoming channel post of any kind - text, photo, sticker, etc.
 * @property edited_channel_post <em>Optional</em>. New version of a channel post that is known to the bot and was edited. This update may at times be triggered by changes to message fields that are either unavailable or not actively used by your bot.
 * @property business_connection <em>Optional</em>. The bot was connected to or disconnected from a business account, or a user edited an existing connection with the bot
 * @property business_message <em>Optional</em>. New message from a connected business account
 * @property edited_business_message <em>Optional</em>. New version of a message from a connected business account
 * @property deleted_business_messages <em>Optional</em>. Messages were deleted from a connected business account
 * @property message_reaction <em>Optional</em>. A reaction to a message was changed by a user. The bot must be an administrator in the chat and must explicitly specify <code>"message_reaction"</code> in the list of <em>allowed_updates</em> to receive these updates. The update isn't received for reactions set by bots.
 * @property message_reaction_count <em>Optional</em>. Reactions to a message with anonymous reactions were changed. The bot must be an administrator in the chat and must explicitly specify <code>"message_reaction_count"</code> in the list of <em>allowed_updates</em> to receive these updates. The updates are grouped and can be sent with delay up to a few minutes.
 * @property inline_query <em>Optional</em>. New incoming <a href="#inline-mode">inline</a> query
 * @property chosen_inline_result <em>Optional</em>. The result of an <a href="#inline-mode">inline</a> query that was chosen by a user and sent to their chat partner. Please see our documentation on the <a href="/bots/inline#collecting-feedback">feedback collecting</a> for details on how to enable these updates for your bot.
 * @property callback_query <em>Optional</em>. New incoming callback query
 * @property shipping_query <em>Optional</em>. New incoming shipping query. Only for invoices with flexible price
 * @property pre_checkout_query <em>Optional</em>. New incoming pre-checkout query. Contains full information about checkout
 * @property poll <em>Optional</em>. New poll state. Bots receive only updates about manually stopped polls and polls, which are sent by the bot
 * @property poll_answer <em>Optional</em>. A user changed their answer in a non-anonymous poll. Bots receive new votes only in polls that were sent by the bot itself.
 * @property my_chat_member <em>Optional</em>. The bot's chat member status was updated in a chat. For private chats, this update is received only when the bot is blocked or unblocked by the user.
 * @property chat_member <em>Optional</em>. A chat member's status was updated in a chat. The bot must be an administrator in the chat and must explicitly specify <code>"chat_member"</code> in the list of <em>allowed_updates</em> to receive these updates.
 * @property chat_join_request <em>Optional</em>. A request to join the chat has been sent. The bot must have the <em>can_invite_users</em> administrator right in the chat to receive these updates.
 * @property chat_boost <em>Optional</em>. A chat boost was added or changed. The bot must be an administrator in the chat to receive these updates.
 * @property removed_chat_boost <em>Optional</em>. A boost was removed from a chat. The bot must be an administrator in the chat to receive these updates.
 *
 * @constructor Creates a [Update].
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct Update {
    /// The update's unique identifier. Update identifiers start from a certain positive number and increase sequentially. This identifier becomes especially handy if you're using <a href="#setwebhook">webhooks</a>, since it allows you to ignore repeated updates or to restore the correct update sequence, should they get out of order. If there are no new updates for at least a week, then identifier of the next update will be chosen randomly instead of sequentially.
    pub update_id: Integer,
    /// <em>Optional</em>. New incoming message of any kind - text, photo, sticker, etc.
    #[serde(skip_serializing_if = "Option::is_none")]
    pub message: Option<Message>,
    /// <em>Optional</em>. New version of a message that is known to the bot and was edited. This update may at times be triggered by changes to message fields that are either unavailable or not actively used by your bot.
    #[serde(skip_serializing_if = "Option::is_none")]
    pub edited_message: Option<Message>,
    /// <em>Optional</em>. New incoming channel post of any kind - text, photo, sticker, etc.
    #[serde(skip_serializing_if = "Option::is_none")]
    pub channel_post: Option<Message>,
    /// <em>Optional</em>. New version of a channel post that is known to the bot and was edited. This update may at times be triggered by changes to message fields that are either unavailable or not actively used by your bot.
    #[serde(skip_serializing_if = "Option::is_none")]
    pub edited_channel_post: Option<Message>,
    /// <em>Optional</em>. The bot was connected to or disconnected from a business account, or a user edited an existing connection with the bot
    #[serde(skip_serializing_if = "Option::is_none")]
    pub business_connection: Option<BusinessConnection>,
    /// <em>Optional</em>. New message from a connected business account
    #[serde(skip_serializing_if = "Option::is_none")]
    pub business_message: Option<Message>,
    /// <em>Optional</em>. New version of a message from a connected business account
    #[serde(skip_serializing_if = "Option::is_none")]
    pub edited_business_message: Option<Message>,
    /// <em>Optional</em>. Messages were deleted from a connected business account
    #[serde(skip_serializing_if = "Option::is_none")]
    pub deleted_business_messages: Option<BusinessMessagesDeleted>,
    /// <em>Optional</em>. A reaction to a message was changed by a user. The bot must be an administrator in the chat and must explicitly specify <code>"message_reaction"</code> in the list of <em>allowed_updates</em> to receive these updates. The update isn't received for reactions set by bots.
    #[serde(skip_serializing_if = "Option::is_none")]
    pub message_reaction: Option<MessageReactionUpdated>,
    /// <em>Optional</em>. Reactions to a message with anonymous reactions were changed. The bot must be an administrator in the chat and must explicitly specify <code>"message_reaction_count"</code> in the list of <em>allowed_updates</em> to receive these updates. The updates are grouped and can be sent with delay up to a few minutes.
    #[serde(skip_serializing_if = "Option::is_none")]
    pub message_reaction_count: Option<MessageReactionCountUpdated>,
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
    /// <em>Optional</em>. New poll state. Bots receive only updates about manually stopped polls and polls, which are sent by the bot
    #[serde(skip_serializing_if = "Option::is_none")]
    pub poll: Option<Poll>,
    /// <em>Optional</em>. A user changed their answer in a non-anonymous poll. Bots receive new votes only in polls that were sent by the bot itself.
    #[serde(skip_serializing_if = "Option::is_none")]
    pub poll_answer: Option<PollAnswer>,
    /// <em>Optional</em>. The bot's chat member status was updated in a chat. For private chats, this update is received only when the bot is blocked or unblocked by the user.
    #[serde(skip_serializing_if = "Option::is_none")]
    pub my_chat_member: Option<ChatMemberUpdated>,
    /// <em>Optional</em>. A chat member's status was updated in a chat. The bot must be an administrator in the chat and must explicitly specify <code>"chat_member"</code> in the list of <em>allowed_updates</em> to receive these updates.
    #[serde(skip_serializing_if = "Option::is_none")]
    pub chat_member: Option<ChatMemberUpdated>,
    /// <em>Optional</em>. A request to join the chat has been sent. The bot must have the <em>can_invite_users</em> administrator right in the chat to receive these updates.
    #[serde(skip_serializing_if = "Option::is_none")]
    pub chat_join_request: Option<ChatJoinRequest>,
    /// <em>Optional</em>. A chat boost was added or changed. The bot must be an administrator in the chat to receive these updates.
    #[serde(skip_serializing_if = "Option::is_none")]
    pub chat_boost: Option<ChatBoostUpdated>,
    /// <em>Optional</em>. A boost was removed from a chat. The bot must be an administrator in the chat to receive these updates.
    #[serde(skip_serializing_if = "Option::is_none")]
    pub removed_chat_boost: Option<ChatBoostRemoved>
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
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct WebhookInfo {
    /// Webhook URL, may be empty if webhook is not set up
    pub url: String,
    /// <em>True</em>, if a custom certificate was provided for webhook certificate checks
    pub has_custom_certificate: bool,
    /// Number of updates awaiting delivery
    pub pending_update_count: Integer,
    /// <em>Optional</em>. Currently used webhook IP address
    #[serde(skip_serializing_if = "Option::is_none")]
    pub ip_address: Option<String>,
    /// <em>Optional</em>. Unix time for the most recent error that happened when trying to deliver an update via webhook
    #[serde(skip_serializing_if = "Option::is_none")]
    pub last_error_date: Option<Integer>,
    /// <em>Optional</em>. Error message in human-readable format for the most recent error that happened when trying to deliver an update via webhook
    #[serde(skip_serializing_if = "Option::is_none")]
    pub last_error_message: Option<String>,
    /// <em>Optional</em>. Unix time of the most recent error that happened when trying to synchronize available updates with Telegram datacenters
    #[serde(skip_serializing_if = "Option::is_none")]
    pub last_synchronization_error_date: Option<Integer>,
    /// <em>Optional</em>. The maximum allowed number of simultaneous HTTPS connections to the webhook for update delivery
    #[serde(skip_serializing_if = "Option::is_none")]
    pub max_connections: Option<Integer>,
    /// <em>Optional</em>. A list of update types the bot is subscribed to. Defaults to all update types except <em>chat_member</em>
    #[serde(skip_serializing_if = "Option::is_none")]
    pub allowed_updates: Option<Vec<String>>
}


/// Available types

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
 * @property can_read_all_group_messages <em>Optional</em>. <em>True</em>, if <a href="/bots/features#privacy-mode">privacy mode</a> is disabled for the bot. Returned only in <a href="#getme">getMe</a>.
 * @property supports_inline_queries <em>Optional</em>. <em>True</em>, if the bot supports inline queries. Returned only in <a href="#getme">getMe</a>.
 * @property can_connect_to_business <em>Optional</em>. <em>True</em>, if the bot can be connected to a Telegram Business account to receive its messages. Returned only in <a href="#getme">getMe</a>.
 *
 * @constructor Creates a [User].
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct User {
    /// Unique identifier for this user or bot. This number may have more than 32 significant bits and some programming languages may have difficulty/silent defects in interpreting it. But it has at most 52 significant bits, so a 64-bit integer or double-precision float type are safe for storing this identifier.
    pub id: Integer,
    /// <em>True</em>, if this user is a bot
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
    /// <em>Optional</em>. <em>True</em>, if this user is a Telegram Premium user
    #[serde(skip_serializing_if = "Option::is_none")]
    pub is_premium: Option<bool>,
    /// <em>Optional</em>. <em>True</em>, if this user added the bot to the attachment menu
    #[serde(skip_serializing_if = "Option::is_none")]
    pub added_to_attachment_menu: Option<bool>,
    /// <em>Optional</em>. <em>True</em>, if the bot can be invited to groups. Returned only in <a href="#getme">getMe</a>.
    #[serde(skip_serializing_if = "Option::is_none")]
    pub can_join_groups: Option<bool>,
    /// <em>Optional</em>. <em>True</em>, if <a href="/bots/features#privacy-mode">privacy mode</a> is disabled for the bot. Returned only in <a href="#getme">getMe</a>.
    #[serde(skip_serializing_if = "Option::is_none")]
    pub can_read_all_group_messages: Option<bool>,
    /// <em>Optional</em>. <em>True</em>, if the bot supports inline queries. Returned only in <a href="#getme">getMe</a>.
    #[serde(skip_serializing_if = "Option::is_none")]
    pub supports_inline_queries: Option<bool>,
    /// <em>Optional</em>. <em>True</em>, if the bot can be connected to a Telegram Business account to receive its messages. Returned only in <a href="#getme">getMe</a>.
    #[serde(skip_serializing_if = "Option::is_none")]
    pub can_connect_to_business: Option<bool>
}

/**
 * <p>This object represents a chat.</p>
 *
 * @property id Unique identifier for this chat. This number may have more than 32 significant bits and some programming languages may have difficulty/silent defects in interpreting it. But it has at most 52 significant bits, so a signed 64-bit integer or double-precision float type are safe for storing this identifier.
 * @property type Type of the chat, can be either “private”, “group”, “supergroup” or “channel”
 * @property title <em>Optional</em>. Title, for supergroups, channels and group chats
 * @property username <em>Optional</em>. Username, for private chats, supergroups and channels if available
 * @property first_name <em>Optional</em>. First name of the other party in a private chat
 * @property last_name <em>Optional</em>. Last name of the other party in a private chat
 * @property is_forum <em>Optional</em>. <em>True</em>, if the supergroup chat is a forum (has <a href="https://telegram.org/blog/topics-in-groups-collectible-usernames#topics-in-groups">topics</a> enabled)
 *
 * @constructor Creates a [Chat].
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct Chat {
    /// Unique identifier for this chat. This number may have more than 32 significant bits and some programming languages may have difficulty/silent defects in interpreting it. But it has at most 52 significant bits, so a signed 64-bit integer or double-precision float type are safe for storing this identifier.
    pub id: Integer,
    /// Type of the chat, can be either “private”, “group”, “supergroup” or “channel”
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
    /// <em>Optional</em>. <em>True</em>, if the supergroup chat is a forum (has <a href="https://telegram.org/blog/topics-in-groups-collectible-usernames#topics-in-groups">topics</a> enabled)
    #[serde(skip_serializing_if = "Option::is_none")]
    pub is_forum: Option<bool>
}

/**
 * <p>This object contains full information about a chat.</p>
 *
 * @property id Unique identifier for this chat. This number may have more than 32 significant bits and some programming languages may have difficulty/silent defects in interpreting it. But it has at most 52 significant bits, so a signed 64-bit integer or double-precision float type are safe for storing this identifier.
 * @property type Type of the chat, can be either “private”, “group”, “supergroup” or “channel”
 * @property title <em>Optional</em>. Title, for supergroups, channels and group chats
 * @property username <em>Optional</em>. Username, for private chats, supergroups and channels if available
 * @property first_name <em>Optional</em>. First name of the other party in a private chat
 * @property last_name <em>Optional</em>. Last name of the other party in a private chat
 * @property is_forum <em>Optional</em>. <em>True</em>, if the supergroup chat is a forum (has <a href="https://telegram.org/blog/topics-in-groups-collectible-usernames#topics-in-groups">topics</a> enabled)
 * @property accent_color_id Identifier of the accent color for the chat name and backgrounds of the chat photo, reply header, and link preview. See <a href="#accent-colors">accent colors</a> for more details.
 * @property max_reaction_count The maximum number of reactions that can be set on a message in the chat
 * @property photo <em>Optional</em>. Chat photo
 * @property active_usernames <em>Optional</em>. If non-empty, the list of all <a href="https://telegram.org/blog/topics-in-groups-collectible-usernames#collectible-usernames">active chat usernames</a>; for private chats, supergroups and channels
 * @property birthdate <em>Optional</em>. For private chats, the date of birth of the user
 * @property business_intro <em>Optional</em>. For private chats with business accounts, the intro of the business
 * @property business_location <em>Optional</em>. For private chats with business accounts, the location of the business
 * @property business_opening_hours <em>Optional</em>. For private chats with business accounts, the opening hours of the business
 * @property personal_chat <em>Optional</em>. For private chats, the personal channel of the user
 * @property available_reactions <em>Optional</em>. List of available reactions allowed in the chat. If omitted, then all <a href="#reactiontypeemoji">emoji reactions</a> are allowed.
 * @property background_custom_emoji_id <em>Optional</em>. Custom emoji identifier of the emoji chosen by the chat for the reply header and link preview background
 * @property profile_accent_color_id <em>Optional</em>. Identifier of the accent color for the chat's profile background. See <a href="#profile-accent-colors">profile accent colors</a> for more details.
 * @property profile_background_custom_emoji_id <em>Optional</em>. Custom emoji identifier of the emoji chosen by the chat for its profile background
 * @property emoji_status_custom_emoji_id <em>Optional</em>. Custom emoji identifier of the emoji status of the chat or the other party in a private chat
 * @property emoji_status_expiration_date <em>Optional</em>. Expiration date of the emoji status of the chat or the other party in a private chat, in Unix time, if any
 * @property bio <em>Optional</em>. Bio of the other party in a private chat
 * @property has_private_forwards <em>Optional</em>. <em>True</em>, if privacy settings of the other party in the private chat allows to use <code>tg://user?id=&lt;user_id&gt;</code> links only in chats with the user
 * @property has_restricted_voice_and_video_messages <em>Optional</em>. <em>True</em>, if the privacy settings of the other party restrict sending voice and video note messages in the private chat
 * @property join_to_send_messages <em>Optional</em>. <em>True</em>, if users need to join the supergroup before they can send messages
 * @property join_by_request <em>Optional</em>. <em>True</em>, if all users directly joining the supergroup without using an invite link need to be approved by supergroup administrators
 * @property description <em>Optional</em>. Description, for groups, supergroups and channel chats
 * @property invite_link <em>Optional</em>. Primary invite link, for groups, supergroups and channel chats
 * @property pinned_message <em>Optional</em>. The most recent pinned message (by sending date)
 * @property permissions <em>Optional</em>. Default chat member permissions, for groups and supergroups
 * @property slow_mode_delay <em>Optional</em>. For supergroups, the minimum allowed delay between consecutive messages sent by each unprivileged user; in seconds
 * @property unrestrict_boost_count <em>Optional</em>. For supergroups, the minimum number of boosts that a non-administrator user needs to add in order to ignore slow mode and chat permissions
 * @property message_auto_delete_time <em>Optional</em>. The time after which all messages sent to the chat will be automatically deleted; in seconds
 * @property has_aggressive_anti_spam_enabled <em>Optional</em>. <em>True</em>, if aggressive anti-spam checks are enabled in the supergroup. The field is only available to chat administrators.
 * @property has_hidden_members <em>Optional</em>. <em>True</em>, if non-administrators can only get the list of bots and administrators in the chat
 * @property has_protected_content <em>Optional</em>. <em>True</em>, if messages from the chat can't be forwarded to other chats
 * @property has_visible_history <em>Optional</em>. <em>True</em>, if new chat members will have access to old messages; available only to chat administrators
 * @property sticker_set_name <em>Optional</em>. For supergroups, name of the group sticker set
 * @property can_set_sticker_set <em>Optional</em>. <em>True</em>, if the bot can change the group sticker set
 * @property custom_emoji_sticker_set_name <em>Optional</em>. For supergroups, the name of the group's custom emoji sticker set. Custom emoji from this set can be used by all users and bots in the group.
 * @property linked_chat_id <em>Optional</em>. Unique identifier for the linked chat, i.e. the discussion group identifier for a channel and vice versa; for supergroups and channel chats. This identifier may be greater than 32 bits and some programming languages may have difficulty/silent defects in interpreting it. But it is smaller than 52 bits, so a signed 64 bit integer or double-precision float type are safe for storing this identifier.
 * @property location <em>Optional</em>. For supergroups, the location to which the supergroup is connected
 *
 * @constructor Creates a [ChatFullInfo].
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct ChatFullInfo {
    /// Unique identifier for this chat. This number may have more than 32 significant bits and some programming languages may have difficulty/silent defects in interpreting it. But it has at most 52 significant bits, so a signed 64-bit integer or double-precision float type are safe for storing this identifier.
    pub id: Integer,
    /// Type of the chat, can be either “private”, “group”, “supergroup” or “channel”
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
    /// <em>Optional</em>. <em>True</em>, if the supergroup chat is a forum (has <a href="https://telegram.org/blog/topics-in-groups-collectible-usernames#topics-in-groups">topics</a> enabled)
    #[serde(skip_serializing_if = "Option::is_none")]
    pub is_forum: Option<bool>,
    /// Identifier of the accent color for the chat name and backgrounds of the chat photo, reply header, and link preview. See <a href="#accent-colors">accent colors</a> for more details.
    pub accent_color_id: Integer,
    /// The maximum number of reactions that can be set on a message in the chat
    pub max_reaction_count: Integer,
    /// <em>Optional</em>. Chat photo
    #[serde(skip_serializing_if = "Option::is_none")]
    pub photo: Option<ChatPhoto>,
    /// <em>Optional</em>. If non-empty, the list of all <a href="https://telegram.org/blog/topics-in-groups-collectible-usernames#collectible-usernames">active chat usernames</a>; for private chats, supergroups and channels
    #[serde(skip_serializing_if = "Option::is_none")]
    pub active_usernames: Option<Vec<String>>,
    /// <em>Optional</em>. For private chats, the date of birth of the user
    #[serde(skip_serializing_if = "Option::is_none")]
    pub birthdate: Option<Birthdate>,
    /// <em>Optional</em>. For private chats with business accounts, the intro of the business
    #[serde(skip_serializing_if = "Option::is_none")]
    pub business_intro: Option<BusinessIntro>,
    /// <em>Optional</em>. For private chats with business accounts, the location of the business
    #[serde(skip_serializing_if = "Option::is_none")]
    pub business_location: Option<BusinessLocation>,
    /// <em>Optional</em>. For private chats with business accounts, the opening hours of the business
    #[serde(skip_serializing_if = "Option::is_none")]
    pub business_opening_hours: Option<BusinessOpeningHours>,
    /// <em>Optional</em>. For private chats, the personal channel of the user
    #[serde(skip_serializing_if = "Option::is_none")]
    pub personal_chat: Option<Chat>,
    /// <em>Optional</em>. List of available reactions allowed in the chat. If omitted, then all <a href="#reactiontypeemoji">emoji reactions</a> are allowed.
    #[serde(skip_serializing_if = "Option::is_none")]
    pub available_reactions: Option<Vec<ReactionType>>,
    /// <em>Optional</em>. Custom emoji identifier of the emoji chosen by the chat for the reply header and link preview background
    #[serde(skip_serializing_if = "Option::is_none")]
    pub background_custom_emoji_id: Option<String>,
    /// <em>Optional</em>. Identifier of the accent color for the chat's profile background. See <a href="#profile-accent-colors">profile accent colors</a> for more details.
    #[serde(skip_serializing_if = "Option::is_none")]
    pub profile_accent_color_id: Option<Integer>,
    /// <em>Optional</em>. Custom emoji identifier of the emoji chosen by the chat for its profile background
    #[serde(skip_serializing_if = "Option::is_none")]
    pub profile_background_custom_emoji_id: Option<String>,
    /// <em>Optional</em>. Custom emoji identifier of the emoji status of the chat or the other party in a private chat
    #[serde(skip_serializing_if = "Option::is_none")]
    pub emoji_status_custom_emoji_id: Option<String>,
    /// <em>Optional</em>. Expiration date of the emoji status of the chat or the other party in a private chat, in Unix time, if any
    #[serde(skip_serializing_if = "Option::is_none")]
    pub emoji_status_expiration_date: Option<Integer>,
    /// <em>Optional</em>. Bio of the other party in a private chat
    #[serde(skip_serializing_if = "Option::is_none")]
    pub bio: Option<String>,
    /// <em>Optional</em>. <em>True</em>, if privacy settings of the other party in the private chat allows to use <code>tg://user?id=&lt;user_id&gt;</code> links only in chats with the user
    #[serde(skip_serializing_if = "Option::is_none")]
    pub has_private_forwards: Option<bool>,
    /// <em>Optional</em>. <em>True</em>, if the privacy settings of the other party restrict sending voice and video note messages in the private chat
    #[serde(skip_serializing_if = "Option::is_none")]
    pub has_restricted_voice_and_video_messages: Option<bool>,
    /// <em>Optional</em>. <em>True</em>, if users need to join the supergroup before they can send messages
    #[serde(skip_serializing_if = "Option::is_none")]
    pub join_to_send_messages: Option<bool>,
    /// <em>Optional</em>. <em>True</em>, if all users directly joining the supergroup without using an invite link need to be approved by supergroup administrators
    #[serde(skip_serializing_if = "Option::is_none")]
    pub join_by_request: Option<bool>,
    /// <em>Optional</em>. Description, for groups, supergroups and channel chats
    #[serde(skip_serializing_if = "Option::is_none")]
    pub description: Option<String>,
    /// <em>Optional</em>. Primary invite link, for groups, supergroups and channel chats
    #[serde(skip_serializing_if = "Option::is_none")]
    pub invite_link: Option<String>,
    /// <em>Optional</em>. The most recent pinned message (by sending date)
    #[serde(skip_serializing_if = "Option::is_none")]
    pub pinned_message: Option<Message>,
    /// <em>Optional</em>. Default chat member permissions, for groups and supergroups
    #[serde(skip_serializing_if = "Option::is_none")]
    pub permissions: Option<ChatPermissions>,
    /// <em>Optional</em>. For supergroups, the minimum allowed delay between consecutive messages sent by each unprivileged user; in seconds
    #[serde(skip_serializing_if = "Option::is_none")]
    pub slow_mode_delay: Option<Integer>,
    /// <em>Optional</em>. For supergroups, the minimum number of boosts that a non-administrator user needs to add in order to ignore slow mode and chat permissions
    #[serde(skip_serializing_if = "Option::is_none")]
    pub unrestrict_boost_count: Option<Integer>,
    /// <em>Optional</em>. The time after which all messages sent to the chat will be automatically deleted; in seconds
    #[serde(skip_serializing_if = "Option::is_none")]
    pub message_auto_delete_time: Option<Integer>,
    /// <em>Optional</em>. <em>True</em>, if aggressive anti-spam checks are enabled in the supergroup. The field is only available to chat administrators.
    #[serde(skip_serializing_if = "Option::is_none")]
    pub has_aggressive_anti_spam_enabled: Option<bool>,
    /// <em>Optional</em>. <em>True</em>, if non-administrators can only get the list of bots and administrators in the chat
    #[serde(skip_serializing_if = "Option::is_none")]
    pub has_hidden_members: Option<bool>,
    /// <em>Optional</em>. <em>True</em>, if messages from the chat can't be forwarded to other chats
    #[serde(skip_serializing_if = "Option::is_none")]
    pub has_protected_content: Option<bool>,
    /// <em>Optional</em>. <em>True</em>, if new chat members will have access to old messages; available only to chat administrators
    #[serde(skip_serializing_if = "Option::is_none")]
    pub has_visible_history: Option<bool>,
    /// <em>Optional</em>. For supergroups, name of the group sticker set
    #[serde(skip_serializing_if = "Option::is_none")]
    pub sticker_set_name: Option<String>,
    /// <em>Optional</em>. <em>True</em>, if the bot can change the group sticker set
    #[serde(skip_serializing_if = "Option::is_none")]
    pub can_set_sticker_set: Option<bool>,
    /// <em>Optional</em>. For supergroups, the name of the group's custom emoji sticker set. Custom emoji from this set can be used by all users and bots in the group.
    #[serde(skip_serializing_if = "Option::is_none")]
    pub custom_emoji_sticker_set_name: Option<String>,
    /// <em>Optional</em>. Unique identifier for the linked chat, i.e. the discussion group identifier for a channel and vice versa; for supergroups and channel chats. This identifier may be greater than 32 bits and some programming languages may have difficulty/silent defects in interpreting it. But it is smaller than 52 bits, so a signed 64 bit integer or double-precision float type are safe for storing this identifier.
    #[serde(skip_serializing_if = "Option::is_none")]
    pub linked_chat_id: Option<Integer>,
    /// <em>Optional</em>. For supergroups, the location to which the supergroup is connected
    #[serde(skip_serializing_if = "Option::is_none")]
    pub location: Option<ChatLocation>
}

/**
 * <p>This object represents a message.</p>
 *
 * @property message_id Unique message identifier inside this chat
 * @property message_thread_id <em>Optional</em>. Unique identifier of a message thread to which the message belongs; for supergroups only
 * @property from <em>Optional</em>. Sender of the message; empty for messages sent to channels. For backward compatibility, the field contains a fake sender user in non-channel chats, if the message was sent on behalf of a chat.
 * @property sender_chat <em>Optional</em>. Sender of the message, sent on behalf of a chat. For example, the channel itself for channel posts, the supergroup itself for messages from anonymous group administrators, the linked channel for messages automatically forwarded to the discussion group. For backward compatibility, the field <em>from</em> contains a fake sender user in non-channel chats, if the message was sent on behalf of a chat.
 * @property sender_boost_count <em>Optional</em>. If the sender of the message boosted the chat, the number of boosts added by the user
 * @property sender_business_bot <em>Optional</em>. The bot that actually sent the message on behalf of the business account. Available only for outgoing messages sent on behalf of the connected business account.
 * @property date Date the message was sent in Unix time. It is always a positive number, representing a valid date.
 * @property business_connection_id <em>Optional</em>. Unique identifier of the business connection from which the message was received. If non-empty, the message belongs to a chat of the corresponding business account that is independent from any potential bot chat which might share the same identifier.
 * @property chat Chat the message belongs to
 * @property forward_origin <em>Optional</em>. Information about the original message for forwarded messages
 * @property is_topic_message <em>Optional</em>. <em>True</em>, if the message is sent to a forum topic
 * @property is_automatic_forward <em>Optional</em>. <em>True</em>, if the message is a channel post that was automatically forwarded to the connected discussion group
 * @property reply_to_message <em>Optional</em>. For replies in the same chat and message thread, the original message. Note that the Message object in this field will not contain further <em>reply_to_message</em> fields even if it itself is a reply.
 * @property external_reply <em>Optional</em>. Information about the message that is being replied to, which may come from another chat or forum topic
 * @property quote <em>Optional</em>. For replies that quote part of the original message, the quoted part of the message
 * @property reply_to_story <em>Optional</em>. For replies to a story, the original story
 * @property via_bot <em>Optional</em>. Bot through which the message was sent
 * @property edit_date <em>Optional</em>. Date the message was last edited in Unix time
 * @property has_protected_content <em>Optional</em>. <em>True</em>, if the message can't be forwarded
 * @property is_from_offline <em>Optional</em>. True, if the message was sent by an implicit action, for example, as an away or a greeting business message, or as a scheduled message
 * @property media_group_id <em>Optional</em>. The unique identifier of a media message group this message belongs to
 * @property author_signature <em>Optional</em>. Signature of the post author for messages in channels, or the custom title of an anonymous group administrator
 * @property text <em>Optional</em>. For text messages, the actual UTF-8 text of the message
 * @property entities <em>Optional</em>. For text messages, special entities like usernames, URLs, bot commands, etc. that appear in the text
 * @property link_preview_options <em>Optional</em>. Options used for link preview generation for the message, if it is a text message and link preview options were changed
 * @property effect_id <em>Optional</em>. Unique identifier of the message effect added to the message
 * @property animation <em>Optional</em>. Message is an animation, information about the animation. For backward compatibility, when this field is set, the <em>document</em> field will also be set
 * @property audio <em>Optional</em>. Message is an audio file, information about the file
 * @property document <em>Optional</em>. Message is a general file, information about the file
 * @property photo <em>Optional</em>. Message is a photo, available sizes of the photo
 * @property sticker <em>Optional</em>. Message is a sticker, information about the sticker
 * @property story <em>Optional</em>. Message is a forwarded story
 * @property video <em>Optional</em>. Message is a video, information about the video
 * @property video_note <em>Optional</em>. Message is a <a href="https://telegram.org/blog/video-messages-and-telescope">video note</a>, information about the video message
 * @property voice <em>Optional</em>. Message is a voice message, information about the file
 * @property caption <em>Optional</em>. Caption for the animation, audio, document, photo, video or voice
 * @property caption_entities <em>Optional</em>. For messages with a caption, special entities like usernames, URLs, bot commands, etc. that appear in the caption
 * @property show_caption_above_media <em>Optional</em>. True, if the caption must be shown above the message media
 * @property has_media_spoiler <em>Optional</em>. <em>True</em>, if the message media is covered by a spoiler animation
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
 * @property pinned_message <em>Optional</em>. Specified message was pinned. Note that the Message object in this field will not contain further <em>reply_to_message</em> fields even if it itself is a reply.
 * @property invoice <em>Optional</em>. Message is an invoice for a <a href="#payments">payment</a>, information about the invoice. <a href="#payments">More about payments »</a>
 * @property successful_payment <em>Optional</em>. Message is a service message about a successful payment, information about the payment. <a href="#payments">More about payments »</a>
 * @property users_shared <em>Optional</em>. Service message: users were shared with the bot
 * @property chat_shared <em>Optional</em>. Service message: a chat was shared with the bot
 * @property connected_website <em>Optional</em>. The domain name of the website on which the user has logged in. <a href="/widgets/login">More about Telegram Login »</a>
 * @property write_access_allowed <em>Optional</em>. Service message: the user allowed the bot to write messages after adding it to the attachment or side menu, launching a Web App from a link, or accepting an explicit request from a Web App sent by the method <a href="/bots/webapps#initializing-mini-apps">requestWriteAccess</a>
 * @property passport_data <em>Optional</em>. Telegram Passport data
 * @property proximity_alert_triggered <em>Optional</em>. Service message. A user in the chat triggered another user's proximity alert while sharing Live Location.
 * @property boost_added <em>Optional</em>. Service message: user boosted the chat
 * @property chat_background_set <em>Optional</em>. Service message: chat background set
 * @property forum_topic_created <em>Optional</em>. Service message: forum topic created
 * @property forum_topic_edited <em>Optional</em>. Service message: forum topic edited
 * @property forum_topic_closed <em>Optional</em>. Service message: forum topic closed
 * @property forum_topic_reopened <em>Optional</em>. Service message: forum topic reopened
 * @property general_forum_topic_hidden <em>Optional</em>. Service message: the 'General' forum topic hidden
 * @property general_forum_topic_unhidden <em>Optional</em>. Service message: the 'General' forum topic unhidden
 * @property giveaway_created <em>Optional</em>. Service message: a scheduled giveaway was created
 * @property giveaway <em>Optional</em>. The message is a scheduled giveaway message
 * @property giveaway_winners <em>Optional</em>. A giveaway with public winners was completed
 * @property giveaway_completed <em>Optional</em>. Service message: a giveaway without public winners was completed
 * @property video_chat_scheduled <em>Optional</em>. Service message: video chat scheduled
 * @property video_chat_started <em>Optional</em>. Service message: video chat started
 * @property video_chat_ended <em>Optional</em>. Service message: video chat ended
 * @property video_chat_participants_invited <em>Optional</em>. Service message: new participants invited to a video chat
 * @property web_app_data <em>Optional</em>. Service message: data sent by a Web App
 * @property reply_markup <em>Optional</em>. Inline keyboard attached to the message. <code>login_url</code> buttons are represented as ordinary <code>url</code> buttons.
 *
 * @constructor Creates a [Message].
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct Message {
    /// Unique message identifier inside this chat
    pub message_id: Integer,
    /// <em>Optional</em>. Unique identifier of a message thread to which the message belongs; for supergroups only
    #[serde(skip_serializing_if = "Option::is_none")]
    pub message_thread_id: Option<Integer>,
    /// <em>Optional</em>. Sender of the message; empty for messages sent to channels. For backward compatibility, the field contains a fake sender user in non-channel chats, if the message was sent on behalf of a chat.
    #[serde(skip_serializing_if = "Option::is_none")]
    pub from: Option<User>,
    /// <em>Optional</em>. Sender of the message, sent on behalf of a chat. For example, the channel itself for channel posts, the supergroup itself for messages from anonymous group administrators, the linked channel for messages automatically forwarded to the discussion group. For backward compatibility, the field <em>from</em> contains a fake sender user in non-channel chats, if the message was sent on behalf of a chat.
    #[serde(skip_serializing_if = "Option::is_none")]
    pub sender_chat: Option<Chat>,
    /// <em>Optional</em>. If the sender of the message boosted the chat, the number of boosts added by the user
    #[serde(skip_serializing_if = "Option::is_none")]
    pub sender_boost_count: Option<Integer>,
    /// <em>Optional</em>. The bot that actually sent the message on behalf of the business account. Available only for outgoing messages sent on behalf of the connected business account.
    #[serde(skip_serializing_if = "Option::is_none")]
    pub sender_business_bot: Option<User>,
    /// Date the message was sent in Unix time. It is always a positive number, representing a valid date.
    pub date: Integer,
    /// <em>Optional</em>. Unique identifier of the business connection from which the message was received. If non-empty, the message belongs to a chat of the corresponding business account that is independent from any potential bot chat which might share the same identifier.
    #[serde(skip_serializing_if = "Option::is_none")]
    pub business_connection_id: Option<String>,
    /// Chat the message belongs to
    pub chat: Chat,
    /// <em>Optional</em>. Information about the original message for forwarded messages
    #[serde(skip_serializing_if = "Option::is_none")]
    pub forward_origin: Option<MessageOrigin>,
    /// <em>Optional</em>. <em>True</em>, if the message is sent to a forum topic
    #[serde(skip_serializing_if = "Option::is_none")]
    pub is_topic_message: Option<bool>,
    /// <em>Optional</em>. <em>True</em>, if the message is a channel post that was automatically forwarded to the connected discussion group
    #[serde(skip_serializing_if = "Option::is_none")]
    pub is_automatic_forward: Option<bool>,
    /// <em>Optional</em>. For replies in the same chat and message thread, the original message. Note that the Message object in this field will not contain further <em>reply_to_message</em> fields even if it itself is a reply.
    #[serde(skip_serializing_if = "Option::is_none")]
    pub reply_to_message: Option<Message>,
    /// <em>Optional</em>. Information about the message that is being replied to, which may come from another chat or forum topic
    #[serde(skip_serializing_if = "Option::is_none")]
    pub external_reply: Option<ExternalReplyInfo>,
    /// <em>Optional</em>. For replies that quote part of the original message, the quoted part of the message
    #[serde(skip_serializing_if = "Option::is_none")]
    pub quote: Option<TextQuote>,
    /// <em>Optional</em>. For replies to a story, the original story
    #[serde(skip_serializing_if = "Option::is_none")]
    pub reply_to_story: Option<Story>,
    /// <em>Optional</em>. Bot through which the message was sent
    #[serde(skip_serializing_if = "Option::is_none")]
    pub via_bot: Option<User>,
    /// <em>Optional</em>. Date the message was last edited in Unix time
    #[serde(skip_serializing_if = "Option::is_none")]
    pub edit_date: Option<Integer>,
    /// <em>Optional</em>. <em>True</em>, if the message can't be forwarded
    #[serde(skip_serializing_if = "Option::is_none")]
    pub has_protected_content: Option<bool>,
    /// <em>Optional</em>. True, if the message was sent by an implicit action, for example, as an away or a greeting business message, or as a scheduled message
    #[serde(skip_serializing_if = "Option::is_none")]
    pub is_from_offline: Option<bool>,
    /// <em>Optional</em>. The unique identifier of a media message group this message belongs to
    #[serde(skip_serializing_if = "Option::is_none")]
    pub media_group_id: Option<String>,
    /// <em>Optional</em>. Signature of the post author for messages in channels, or the custom title of an anonymous group administrator
    #[serde(skip_serializing_if = "Option::is_none")]
    pub author_signature: Option<String>,
    /// <em>Optional</em>. For text messages, the actual UTF-8 text of the message
    #[serde(skip_serializing_if = "Option::is_none")]
    pub text: Option<String>,
    /// <em>Optional</em>. For text messages, special entities like usernames, URLs, bot commands, etc. that appear in the text
    #[serde(skip_serializing_if = "Option::is_none")]
    pub entities: Option<Vec<MessageEntity>>,
    /// <em>Optional</em>. Options used for link preview generation for the message, if it is a text message and link preview options were changed
    #[serde(skip_serializing_if = "Option::is_none")]
    pub link_preview_options: Option<LinkPreviewOptions>,
    /// <em>Optional</em>. Unique identifier of the message effect added to the message
    #[serde(skip_serializing_if = "Option::is_none")]
    pub effect_id: Option<String>,
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
    /// <em>Optional</em>. Message is a forwarded story
    #[serde(skip_serializing_if = "Option::is_none")]
    pub story: Option<Story>,
    /// <em>Optional</em>. Message is a video, information about the video
    #[serde(skip_serializing_if = "Option::is_none")]
    pub video: Option<Video>,
    /// <em>Optional</em>. Message is a <a href="https://telegram.org/blog/video-messages-and-telescope">video note</a>, information about the video message
    #[serde(skip_serializing_if = "Option::is_none")]
    pub video_note: Option<VideoNote>,
    /// <em>Optional</em>. Message is a voice message, information about the file
    #[serde(skip_serializing_if = "Option::is_none")]
    pub voice: Option<Voice>,
    /// <em>Optional</em>. Caption for the animation, audio, document, photo, video or voice
    #[serde(skip_serializing_if = "Option::is_none")]
    pub caption: Option<String>,
    /// <em>Optional</em>. For messages with a caption, special entities like usernames, URLs, bot commands, etc. that appear in the caption
    #[serde(skip_serializing_if = "Option::is_none")]
    pub caption_entities: Option<Vec<MessageEntity>>,
    /// <em>Optional</em>. True, if the caption must be shown above the message media
    #[serde(skip_serializing_if = "Option::is_none")]
    pub show_caption_above_media: Option<bool>,
    /// <em>Optional</em>. <em>True</em>, if the message media is covered by a spoiler animation
    #[serde(skip_serializing_if = "Option::is_none")]
    pub has_media_spoiler: Option<bool>,
    /// <em>Optional</em>. Message is a shared contact, information about the contact
    #[serde(skip_serializing_if = "Option::is_none")]
    pub contact: Option<Contact>,
    /// <em>Optional</em>. Message is a dice with random value
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
    /// <em>Optional</em>. Service message: auto-delete timer settings changed in the chat
    #[serde(skip_serializing_if = "Option::is_none")]
    pub message_auto_delete_timer_changed: Option<MessageAutoDeleteTimerChanged>,
    /// <em>Optional</em>. The group has been migrated to a supergroup with the specified identifier. This number may have more than 32 significant bits and some programming languages may have difficulty/silent defects in interpreting it. But it has at most 52 significant bits, so a signed 64-bit integer or double-precision float type are safe for storing this identifier.
    #[serde(skip_serializing_if = "Option::is_none")]
    pub migrate_to_chat_id: Option<Integer>,
    /// <em>Optional</em>. The supergroup has been migrated from a group with the specified identifier. This number may have more than 32 significant bits and some programming languages may have difficulty/silent defects in interpreting it. But it has at most 52 significant bits, so a signed 64-bit integer or double-precision float type are safe for storing this identifier.
    #[serde(skip_serializing_if = "Option::is_none")]
    pub migrate_from_chat_id: Option<Integer>,
    /// <em>Optional</em>. Specified message was pinned. Note that the Message object in this field will not contain further <em>reply_to_message</em> fields even if it itself is a reply.
    #[serde(skip_serializing_if = "Option::is_none")]
    pub pinned_message: Option<MaybeInaccessibleMessage>,
    /// <em>Optional</em>. Message is an invoice for a <a href="#payments">payment</a>, information about the invoice. <a href="#payments">More about payments »</a>
    #[serde(skip_serializing_if = "Option::is_none")]
    pub invoice: Option<Invoice>,
    /// <em>Optional</em>. Message is a service message about a successful payment, information about the payment. <a href="#payments">More about payments »</a>
    #[serde(skip_serializing_if = "Option::is_none")]
    pub successful_payment: Option<SuccessfulPayment>,
    /// <em>Optional</em>. Service message: users were shared with the bot
    #[serde(skip_serializing_if = "Option::is_none")]
    pub users_shared: Option<UsersShared>,
    /// <em>Optional</em>. Service message: a chat was shared with the bot
    #[serde(skip_serializing_if = "Option::is_none")]
    pub chat_shared: Option<ChatShared>,
    /// <em>Optional</em>. The domain name of the website on which the user has logged in. <a href="/widgets/login">More about Telegram Login »</a>
    #[serde(skip_serializing_if = "Option::is_none")]
    pub connected_website: Option<String>,
    /// <em>Optional</em>. Service message: the user allowed the bot to write messages after adding it to the attachment or side menu, launching a Web App from a link, or accepting an explicit request from a Web App sent by the method <a href="/bots/webapps#initializing-mini-apps">requestWriteAccess</a>
    #[serde(skip_serializing_if = "Option::is_none")]
    pub write_access_allowed: Option<WriteAccessAllowed>,
    /// <em>Optional</em>. Telegram Passport data
    #[serde(skip_serializing_if = "Option::is_none")]
    pub passport_data: Option<PassportData>,
    /// <em>Optional</em>. Service message. A user in the chat triggered another user's proximity alert while sharing Live Location.
    #[serde(skip_serializing_if = "Option::is_none")]
    pub proximity_alert_triggered: Option<ProximityAlertTriggered>,
    /// <em>Optional</em>. Service message: user boosted the chat
    #[serde(skip_serializing_if = "Option::is_none")]
    pub boost_added: Option<ChatBoostAdded>,
    /// <em>Optional</em>. Service message: chat background set
    #[serde(skip_serializing_if = "Option::is_none")]
    pub chat_background_set: Option<ChatBackground>,
    /// <em>Optional</em>. Service message: forum topic created
    #[serde(skip_serializing_if = "Option::is_none")]
    pub forum_topic_created: Option<ForumTopicCreated>,
    /// <em>Optional</em>. Service message: forum topic edited
    #[serde(skip_serializing_if = "Option::is_none")]
    pub forum_topic_edited: Option<ForumTopicEdited>,
    /// <em>Optional</em>. Service message: forum topic closed
    #[serde(skip_serializing_if = "Option::is_none")]
    pub forum_topic_closed: Option<ForumTopicClosed>,
    /// <em>Optional</em>. Service message: forum topic reopened
    #[serde(skip_serializing_if = "Option::is_none")]
    pub forum_topic_reopened: Option<ForumTopicReopened>,
    /// <em>Optional</em>. Service message: the 'General' forum topic hidden
    #[serde(skip_serializing_if = "Option::is_none")]
    pub general_forum_topic_hidden: Option<GeneralForumTopicHidden>,
    /// <em>Optional</em>. Service message: the 'General' forum topic unhidden
    #[serde(skip_serializing_if = "Option::is_none")]
    pub general_forum_topic_unhidden: Option<GeneralForumTopicUnhidden>,
    /// <em>Optional</em>. Service message: a scheduled giveaway was created
    #[serde(skip_serializing_if = "Option::is_none")]
    pub giveaway_created: Option<GiveawayCreated>,
    /// <em>Optional</em>. The message is a scheduled giveaway message
    #[serde(skip_serializing_if = "Option::is_none")]
    pub giveaway: Option<Giveaway>,
    /// <em>Optional</em>. A giveaway with public winners was completed
    #[serde(skip_serializing_if = "Option::is_none")]
    pub giveaway_winners: Option<GiveawayWinners>,
    /// <em>Optional</em>. Service message: a giveaway without public winners was completed
    #[serde(skip_serializing_if = "Option::is_none")]
    pub giveaway_completed: Option<GiveawayCompleted>,
    /// <em>Optional</em>. Service message: video chat scheduled
    #[serde(skip_serializing_if = "Option::is_none")]
    pub video_chat_scheduled: Option<VideoChatScheduled>,
    /// <em>Optional</em>. Service message: video chat started
    #[serde(skip_serializing_if = "Option::is_none")]
    pub video_chat_started: Option<VideoChatStarted>,
    /// <em>Optional</em>. Service message: video chat ended
    #[serde(skip_serializing_if = "Option::is_none")]
    pub video_chat_ended: Option<VideoChatEnded>,
    /// <em>Optional</em>. Service message: new participants invited to a video chat
    #[serde(skip_serializing_if = "Option::is_none")]
    pub video_chat_participants_invited: Option<VideoChatParticipantsInvited>,
    /// <em>Optional</em>. Service message: data sent by a Web App
    #[serde(skip_serializing_if = "Option::is_none")]
    pub web_app_data: Option<WebAppData>,
    /// <em>Optional</em>. Inline keyboard attached to the message. <code>login_url</code> buttons are represented as ordinary <code>url</code> buttons.
    #[serde(skip_serializing_if = "Option::is_none")]
    pub reply_markup: Option<InlineKeyboardMarkup>
}

/**
 * <p>This object represents a unique message identifier.</p>
 *
 * @property message_id Unique message identifier
 *
 * @constructor Creates a [MessageId].
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct MessageId {
    /// Unique message identifier
    pub message_id: Integer
}

/**
 * <p>This object describes a message that was deleted or is otherwise inaccessible to the bot.</p>
 *
 * @property chat Chat the message belonged to
 * @property message_id Unique message identifier inside the chat
 * @property date Always 0. The field can be used to differentiate regular and inaccessible messages.
 *
 * @constructor Creates a [InaccessibleMessage].
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct InaccessibleMessage {
    /// Chat the message belonged to
    pub chat: Chat,
    /// Unique message identifier inside the chat
    pub message_id: Integer,
    /// Always 0. The field can be used to differentiate regular and inaccessible messages.
    pub date: Integer
}

/**
 * <p>This object represents one special entity in a text message. For example, hashtags, usernames, URLs, etc.</p>
 *
 * @property type Type of the entity. Currently, can be “mention” (<code>@username</code>), “hashtag” (<code>#hashtag</code>), “cashtag” (<code>$USD</code>), “bot_command” (<code>/start@jobs_bot</code>), “url” (<code>https://telegram.org</code>), “email” (<code>do-not-reply@telegram.org</code>), “phone_number” (<code>+1-212-555-0123</code>), “bold” (<strong>bold text</strong>), “italic” (<em>italic text</em>), “underline” (underlined text), “strikethrough” (strikethrough text), “spoiler” (spoiler message), “blockquote” (block quotation), “expandable_blockquote” (collapsed-by-default block quotation), “code” (monowidth string), “pre” (monowidth block), “text_link” (for clickable text URLs), “text_mention” (for users <a href="https://telegram.org/blog/edit#new-mentions">without usernames</a>), “custom_emoji” (for inline custom emoji stickers)
 * @property offset Offset in <a href="/api/entities#entity-length">UTF-16 code units</a> to the start of the entity
 * @property length Length of the entity in <a href="/api/entities#entity-length">UTF-16 code units</a>
 * @property url <em>Optional</em>. For “text_link” only, URL that will be opened after user taps on the text
 * @property user <em>Optional</em>. For “text_mention” only, the mentioned user
 * @property language <em>Optional</em>. For “pre” only, the programming language of the entity text
 * @property custom_emoji_id <em>Optional</em>. For “custom_emoji” only, unique identifier of the custom emoji. Use <a href="#getcustomemojistickers">getCustomEmojiStickers</a> to get full information about the sticker
 *
 * @constructor Creates a [MessageEntity].
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct MessageEntity {
    /// Type of the entity. Currently, can be “mention” (<code>@username</code>), “hashtag” (<code>#hashtag</code>), “cashtag” (<code>$USD</code>), “bot_command” (<code>/start@jobs_bot</code>), “url” (<code>https://telegram.org</code>), “email” (<code>do-not-reply@telegram.org</code>), “phone_number” (<code>+1-212-555-0123</code>), “bold” (<strong>bold text</strong>), “italic” (<em>italic text</em>), “underline” (underlined text), “strikethrough” (strikethrough text), “spoiler” (spoiler message), “blockquote” (block quotation), “expandable_blockquote” (collapsed-by-default block quotation), “code” (monowidth string), “pre” (monowidth block), “text_link” (for clickable text URLs), “text_mention” (for users <a href="https://telegram.org/blog/edit#new-mentions">without usernames</a>), “custom_emoji” (for inline custom emoji stickers)
    #[serde(rename = "type")]
    pub type_: String,
    /// Offset in <a href="/api/entities#entity-length">UTF-16 code units</a> to the start of the entity
    pub offset: Integer,
    /// Length of the entity in <a href="/api/entities#entity-length">UTF-16 code units</a>
    pub length: Integer,
    /// <em>Optional</em>. For “text_link” only, URL that will be opened after user taps on the text
    #[serde(skip_serializing_if = "Option::is_none")]
    pub url: Option<String>,
    /// <em>Optional</em>. For “text_mention” only, the mentioned user
    #[serde(skip_serializing_if = "Option::is_none")]
    pub user: Option<User>,
    /// <em>Optional</em>. For “pre” only, the programming language of the entity text
    #[serde(skip_serializing_if = "Option::is_none")]
    pub language: Option<String>,
    /// <em>Optional</em>. For “custom_emoji” only, unique identifier of the custom emoji. Use <a href="#getcustomemojistickers">getCustomEmojiStickers</a> to get full information about the sticker
    #[serde(skip_serializing_if = "Option::is_none")]
    pub custom_emoji_id: Option<String>
}

/**
 * <p>This object contains information about the quoted part of a message that is replied to by the given message.</p>
 *
 * @property text Text of the quoted part of a message that is replied to by the given message
 * @property entities <em>Optional</em>. Special entities that appear in the quote. Currently, only <em>bold</em>, <em>italic</em>, <em>underline</em>, <em>strikethrough</em>, <em>spoiler</em>, and <em>custom_emoji</em> entities are kept in quotes.
 * @property position Approximate quote position in the original message in UTF-16 code units as specified by the sender
 * @property is_manual <em>Optional</em>. True, if the quote was chosen manually by the message sender. Otherwise, the quote was added automatically by the server.
 *
 * @constructor Creates a [TextQuote].
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct TextQuote {
    /// Text of the quoted part of a message that is replied to by the given message
    pub text: String,
    /// <em>Optional</em>. Special entities that appear in the quote. Currently, only <em>bold</em>, <em>italic</em>, <em>underline</em>, <em>strikethrough</em>, <em>spoiler</em>, and <em>custom_emoji</em> entities are kept in quotes.
    #[serde(skip_serializing_if = "Option::is_none")]
    pub entities: Option<Vec<MessageEntity>>,
    /// Approximate quote position in the original message in UTF-16 code units as specified by the sender
    pub position: Integer,
    /// <em>Optional</em>. True, if the quote was chosen manually by the message sender. Otherwise, the quote was added automatically by the server.
    #[serde(skip_serializing_if = "Option::is_none")]
    pub is_manual: Option<bool>
}

/**
 * <p>This object contains information about a message that is being replied to, which may come from another chat or forum topic.</p>
 *
 * @property origin Origin of the message replied to by the given message
 * @property chat <em>Optional</em>. Chat the original message belongs to. Available only if the chat is a supergroup or a channel.
 * @property message_id <em>Optional</em>. Unique message identifier inside the original chat. Available only if the original chat is a supergroup or a channel.
 * @property link_preview_options <em>Optional</em>. Options used for link preview generation for the original message, if it is a text message
 * @property animation <em>Optional</em>. Message is an animation, information about the animation
 * @property audio <em>Optional</em>. Message is an audio file, information about the file
 * @property document <em>Optional</em>. Message is a general file, information about the file
 * @property photo <em>Optional</em>. Message is a photo, available sizes of the photo
 * @property sticker <em>Optional</em>. Message is a sticker, information about the sticker
 * @property story <em>Optional</em>. Message is a forwarded story
 * @property video <em>Optional</em>. Message is a video, information about the video
 * @property video_note <em>Optional</em>. Message is a <a href="https://telegram.org/blog/video-messages-and-telescope">video note</a>, information about the video message
 * @property voice <em>Optional</em>. Message is a voice message, information about the file
 * @property has_media_spoiler <em>Optional</em>. <em>True</em>, if the message media is covered by a spoiler animation
 * @property contact <em>Optional</em>. Message is a shared contact, information about the contact
 * @property dice <em>Optional</em>. Message is a dice with random value
 * @property game <em>Optional</em>. Message is a game, information about the game. <a href="#games">More about games »</a>
 * @property giveaway <em>Optional</em>. Message is a scheduled giveaway, information about the giveaway
 * @property giveaway_winners <em>Optional</em>. A giveaway with public winners was completed
 * @property invoice <em>Optional</em>. Message is an invoice for a <a href="#payments">payment</a>, information about the invoice. <a href="#payments">More about payments »</a>
 * @property location <em>Optional</em>. Message is a shared location, information about the location
 * @property poll <em>Optional</em>. Message is a native poll, information about the poll
 * @property venue <em>Optional</em>. Message is a venue, information about the venue
 *
 * @constructor Creates a [ExternalReplyInfo].
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct ExternalReplyInfo {
    /// Origin of the message replied to by the given message
    pub origin: MessageOrigin,
    /// <em>Optional</em>. Chat the original message belongs to. Available only if the chat is a supergroup or a channel.
    #[serde(skip_serializing_if = "Option::is_none")]
    pub chat: Option<Chat>,
    /// <em>Optional</em>. Unique message identifier inside the original chat. Available only if the original chat is a supergroup or a channel.
    #[serde(skip_serializing_if = "Option::is_none")]
    pub message_id: Option<Integer>,
    /// <em>Optional</em>. Options used for link preview generation for the original message, if it is a text message
    #[serde(skip_serializing_if = "Option::is_none")]
    pub link_preview_options: Option<LinkPreviewOptions>,
    /// <em>Optional</em>. Message is an animation, information about the animation
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
    /// <em>Optional</em>. Message is a forwarded story
    #[serde(skip_serializing_if = "Option::is_none")]
    pub story: Option<Story>,
    /// <em>Optional</em>. Message is a video, information about the video
    #[serde(skip_serializing_if = "Option::is_none")]
    pub video: Option<Video>,
    /// <em>Optional</em>. Message is a <a href="https://telegram.org/blog/video-messages-and-telescope">video note</a>, information about the video message
    #[serde(skip_serializing_if = "Option::is_none")]
    pub video_note: Option<VideoNote>,
    /// <em>Optional</em>. Message is a voice message, information about the file
    #[serde(skip_serializing_if = "Option::is_none")]
    pub voice: Option<Voice>,
    /// <em>Optional</em>. <em>True</em>, if the message media is covered by a spoiler animation
    #[serde(skip_serializing_if = "Option::is_none")]
    pub has_media_spoiler: Option<bool>,
    /// <em>Optional</em>. Message is a shared contact, information about the contact
    #[serde(skip_serializing_if = "Option::is_none")]
    pub contact: Option<Contact>,
    /// <em>Optional</em>. Message is a dice with random value
    #[serde(skip_serializing_if = "Option::is_none")]
    pub dice: Option<Dice>,
    /// <em>Optional</em>. Message is a game, information about the game. <a href="#games">More about games »</a>
    #[serde(skip_serializing_if = "Option::is_none")]
    pub game: Option<Game>,
    /// <em>Optional</em>. Message is a scheduled giveaway, information about the giveaway
    #[serde(skip_serializing_if = "Option::is_none")]
    pub giveaway: Option<Giveaway>,
    /// <em>Optional</em>. A giveaway with public winners was completed
    #[serde(skip_serializing_if = "Option::is_none")]
    pub giveaway_winners: Option<GiveawayWinners>,
    /// <em>Optional</em>. Message is an invoice for a <a href="#payments">payment</a>, information about the invoice. <a href="#payments">More about payments »</a>
    #[serde(skip_serializing_if = "Option::is_none")]
    pub invoice: Option<Invoice>,
    /// <em>Optional</em>. Message is a shared location, information about the location
    #[serde(skip_serializing_if = "Option::is_none")]
    pub location: Option<Location>,
    /// <em>Optional</em>. Message is a native poll, information about the poll
    #[serde(skip_serializing_if = "Option::is_none")]
    pub poll: Option<Poll>,
    /// <em>Optional</em>. Message is a venue, information about the venue
    #[serde(skip_serializing_if = "Option::is_none")]
    pub venue: Option<Venue>
}

/**
 * <p>Describes reply parameters for the message that is being sent.</p>
 *
 * @property message_id Identifier of the message that will be replied to in the current chat, or in the chat <em>chat_id</em> if it is specified
 * @property chat_id <em>Optional</em>. If the message to be replied to is from a different chat, unique identifier for the chat or username of the channel (in the format <code>@channelusername</code>). Not supported for messages sent on behalf of a business account.
 * @property allow_sending_without_reply <em>Optional</em>. Pass <em>True</em> if the message should be sent even if the specified message to be replied to is not found. Always <em>False</em> for replies in another chat or forum topic. Always <em>True</em> for messages sent on behalf of a business account.
 * @property quote <em>Optional</em>. Quoted part of the message to be replied to; 0-1024 characters after entities parsing. The quote must be an exact substring of the message to be replied to, including <em>bold</em>, <em>italic</em>, <em>underline</em>, <em>strikethrough</em>, <em>spoiler</em>, and <em>custom_emoji</em> entities. The message will fail to send if the quote isn't found in the original message.
 * @property quote_parse_mode <em>Optional</em>. Mode for parsing entities in the quote. See <a href="#formatting-options">formatting options</a> for more details.
 * @property quote_entities <em>Optional</em>. A JSON-serialized list of special entities that appear in the quote. It can be specified instead of <em>quote_parse_mode</em>.
 * @property quote_position <em>Optional</em>. Position of the quote in the original message in UTF-16 code units
 *
 * @constructor Creates a [ReplyParameters].
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct ReplyParameters {
    /// Identifier of the message that will be replied to in the current chat, or in the chat <em>chat_id</em> if it is specified
    pub message_id: Integer,
    /// <em>Optional</em>. If the message to be replied to is from a different chat, unique identifier for the chat or username of the channel (in the format <code>@channelusername</code>). Not supported for messages sent on behalf of a business account.
    #[serde(skip_serializing_if = "Option::is_none")]
    pub chat_id: Option<String>,
    /// <em>Optional</em>. Pass <em>True</em> if the message should be sent even if the specified message to be replied to is not found. Always <em>False</em> for replies in another chat or forum topic. Always <em>True</em> for messages sent on behalf of a business account.
    #[serde(skip_serializing_if = "Option::is_none")]
    pub allow_sending_without_reply: Option<bool>,
    /// <em>Optional</em>. Quoted part of the message to be replied to; 0-1024 characters after entities parsing. The quote must be an exact substring of the message to be replied to, including <em>bold</em>, <em>italic</em>, <em>underline</em>, <em>strikethrough</em>, <em>spoiler</em>, and <em>custom_emoji</em> entities. The message will fail to send if the quote isn't found in the original message.
    #[serde(skip_serializing_if = "Option::is_none")]
    pub quote: Option<String>,
    /// <em>Optional</em>. Mode for parsing entities in the quote. See <a href="#formatting-options">formatting options</a> for more details.
    #[serde(skip_serializing_if = "Option::is_none")]
    pub quote_parse_mode: Option<String>,
    /// <em>Optional</em>. A JSON-serialized list of special entities that appear in the quote. It can be specified instead of <em>quote_parse_mode</em>.
    #[serde(skip_serializing_if = "Option::is_none")]
    pub quote_entities: Option<Vec<MessageEntity>>,
    /// <em>Optional</em>. Position of the quote in the original message in UTF-16 code units
    #[serde(skip_serializing_if = "Option::is_none")]
    pub quote_position: Option<Integer>
}

/**
 * <p>The message was originally sent by a known user.</p>
 *
 * @property type Type of the message origin, always “user”
 * @property date Date the message was sent originally in Unix time
 * @property sender_user User that sent the message originally
 *
 * @constructor Creates a [MessageOriginUser].
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct MessageOriginUser {
    /// Type of the message origin, always “user”
    #[serde(rename = "type")]
    pub type_: String,
    /// Date the message was sent originally in Unix time
    pub date: Integer,
    /// User that sent the message originally
    pub sender_user: User
}

/**
 * <p>The message was originally sent by an unknown user.</p>
 *
 * @property type Type of the message origin, always “hidden_user”
 * @property date Date the message was sent originally in Unix time
 * @property sender_user_name Name of the user that sent the message originally
 *
 * @constructor Creates a [MessageOriginHiddenUser].
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct MessageOriginHiddenUser {
    /// Type of the message origin, always “hidden_user”
    #[serde(rename = "type")]
    pub type_: String,
    /// Date the message was sent originally in Unix time
    pub date: Integer,
    /// Name of the user that sent the message originally
    pub sender_user_name: String
}

/**
 * <p>The message was originally sent on behalf of a chat to a group chat.</p>
 *
 * @property type Type of the message origin, always “chat”
 * @property date Date the message was sent originally in Unix time
 * @property sender_chat Chat that sent the message originally
 * @property author_signature <em>Optional</em>. For messages originally sent by an anonymous chat administrator, original message author signature
 *
 * @constructor Creates a [MessageOriginChat].
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct MessageOriginChat {
    /// Type of the message origin, always “chat”
    #[serde(rename = "type")]
    pub type_: String,
    /// Date the message was sent originally in Unix time
    pub date: Integer,
    /// Chat that sent the message originally
    pub sender_chat: Chat,
    /// <em>Optional</em>. For messages originally sent by an anonymous chat administrator, original message author signature
    #[serde(skip_serializing_if = "Option::is_none")]
    pub author_signature: Option<String>
}

/**
 * <p>The message was originally sent to a channel chat.</p>
 *
 * @property type Type of the message origin, always “channel”
 * @property date Date the message was sent originally in Unix time
 * @property chat Channel chat to which the message was originally sent
 * @property message_id Unique message identifier inside the chat
 * @property author_signature <em>Optional</em>. Signature of the original post author
 *
 * @constructor Creates a [MessageOriginChannel].
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct MessageOriginChannel {
    /// Type of the message origin, always “channel”
    #[serde(rename = "type")]
    pub type_: String,
    /// Date the message was sent originally in Unix time
    pub date: Integer,
    /// Channel chat to which the message was originally sent
    pub chat: Chat,
    /// Unique message identifier inside the chat
    pub message_id: Integer,
    /// <em>Optional</em>. Signature of the original post author
    #[serde(skip_serializing_if = "Option::is_none")]
    pub author_signature: Option<String>
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
    /// <em>Optional</em>. File size in bytes
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
 * @property thumbnail <em>Optional</em>. Animation thumbnail as defined by sender
 * @property file_name <em>Optional</em>. Original animation filename as defined by sender
 * @property mime_type <em>Optional</em>. MIME type of the file as defined by sender
 * @property file_size <em>Optional</em>. File size in bytes. It can be bigger than 2^31 and some programming languages may have difficulty/silent defects in interpreting it. But it has at most 52 significant bits, so a signed 64-bit integer or double-precision float type are safe for storing this value.
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
    pub thumbnail: Option<PhotoSize>,
    /// <em>Optional</em>. Original animation filename as defined by sender
    #[serde(skip_serializing_if = "Option::is_none")]
    pub file_name: Option<String>,
    /// <em>Optional</em>. MIME type of the file as defined by sender
    #[serde(skip_serializing_if = "Option::is_none")]
    pub mime_type: Option<String>,
    /// <em>Optional</em>. File size in bytes. It can be bigger than 2^31 and some programming languages may have difficulty/silent defects in interpreting it. But it has at most 52 significant bits, so a signed 64-bit integer or double-precision float type are safe for storing this value.
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
 * @property file_name <em>Optional</em>. Original filename as defined by sender
 * @property mime_type <em>Optional</em>. MIME type of the file as defined by sender
 * @property file_size <em>Optional</em>. File size in bytes. It can be bigger than 2^31 and some programming languages may have difficulty/silent defects in interpreting it. But it has at most 52 significant bits, so a signed 64-bit integer or double-precision float type are safe for storing this value.
 * @property thumbnail <em>Optional</em>. Thumbnail of the album cover to which the music file belongs
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
    /// <em>Optional</em>. Original filename as defined by sender
    #[serde(skip_serializing_if = "Option::is_none")]
    pub file_name: Option<String>,
    /// <em>Optional</em>. MIME type of the file as defined by sender
    #[serde(skip_serializing_if = "Option::is_none")]
    pub mime_type: Option<String>,
    /// <em>Optional</em>. File size in bytes. It can be bigger than 2^31 and some programming languages may have difficulty/silent defects in interpreting it. But it has at most 52 significant bits, so a signed 64-bit integer or double-precision float type are safe for storing this value.
    #[serde(skip_serializing_if = "Option::is_none")]
    pub file_size: Option<Integer>,
    /// <em>Optional</em>. Thumbnail of the album cover to which the music file belongs
    #[serde(skip_serializing_if = "Option::is_none")]
    pub thumbnail: Option<PhotoSize>
}

/**
 * <p>This object represents a general file (as opposed to <a href="#photosize">photos</a>, <a href="#voice">voice messages</a> and <a href="#audio">audio files</a>).</p>
 *
 * @property file_id Identifier for this file, which can be used to download or reuse the file
 * @property file_unique_id Unique identifier for this file, which is supposed to be the same over time and for different bots. Can't be used to download or reuse the file.
 * @property thumbnail <em>Optional</em>. Document thumbnail as defined by sender
 * @property file_name <em>Optional</em>. Original filename as defined by sender
 * @property mime_type <em>Optional</em>. MIME type of the file as defined by sender
 * @property file_size <em>Optional</em>. File size in bytes. It can be bigger than 2^31 and some programming languages may have difficulty/silent defects in interpreting it. But it has at most 52 significant bits, so a signed 64-bit integer or double-precision float type are safe for storing this value.
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
    pub thumbnail: Option<PhotoSize>,
    /// <em>Optional</em>. Original filename as defined by sender
    #[serde(skip_serializing_if = "Option::is_none")]
    pub file_name: Option<String>,
    /// <em>Optional</em>. MIME type of the file as defined by sender
    #[serde(skip_serializing_if = "Option::is_none")]
    pub mime_type: Option<String>,
    /// <em>Optional</em>. File size in bytes. It can be bigger than 2^31 and some programming languages may have difficulty/silent defects in interpreting it. But it has at most 52 significant bits, so a signed 64-bit integer or double-precision float type are safe for storing this value.
    #[serde(skip_serializing_if = "Option::is_none")]
    pub file_size: Option<Integer>
}

/**
 * <p>This object represents a story.</p>
 *
 * @property chat Chat that posted the story
 * @property id Unique identifier for the story in the chat
 *
 * @constructor Creates a [Story].
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct Story {
    /// Chat that posted the story
    pub chat: Chat,
    /// Unique identifier for the story in the chat
    pub id: Integer
}

/**
 * <p>This object represents a video file.</p>
 *
 * @property file_id Identifier for this file, which can be used to download or reuse the file
 * @property file_unique_id Unique identifier for this file, which is supposed to be the same over time and for different bots. Can't be used to download or reuse the file.
 * @property width Video width as defined by sender
 * @property height Video height as defined by sender
 * @property duration Duration of the video in seconds as defined by sender
 * @property thumbnail <em>Optional</em>. Video thumbnail
 * @property file_name <em>Optional</em>. Original filename as defined by sender
 * @property mime_type <em>Optional</em>. MIME type of the file as defined by sender
 * @property file_size <em>Optional</em>. File size in bytes. It can be bigger than 2^31 and some programming languages may have difficulty/silent defects in interpreting it. But it has at most 52 significant bits, so a signed 64-bit integer or double-precision float type are safe for storing this value.
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
    pub thumbnail: Option<PhotoSize>,
    /// <em>Optional</em>. Original filename as defined by sender
    #[serde(skip_serializing_if = "Option::is_none")]
    pub file_name: Option<String>,
    /// <em>Optional</em>. MIME type of the file as defined by sender
    #[serde(skip_serializing_if = "Option::is_none")]
    pub mime_type: Option<String>,
    /// <em>Optional</em>. File size in bytes. It can be bigger than 2^31 and some programming languages may have difficulty/silent defects in interpreting it. But it has at most 52 significant bits, so a signed 64-bit integer or double-precision float type are safe for storing this value.
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
 * @property thumbnail <em>Optional</em>. Video thumbnail
 * @property file_size <em>Optional</em>. File size in bytes
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
    pub thumbnail: Option<PhotoSize>,
    /// <em>Optional</em>. File size in bytes
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
 * @property file_size <em>Optional</em>. File size in bytes. It can be bigger than 2^31 and some programming languages may have difficulty/silent defects in interpreting it. But it has at most 52 significant bits, so a signed 64-bit integer or double-precision float type are safe for storing this value.
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
    /// <em>Optional</em>. File size in bytes. It can be bigger than 2^31 and some programming languages may have difficulty/silent defects in interpreting it. But it has at most 52 significant bits, so a signed 64-bit integer or double-precision float type are safe for storing this value.
    #[serde(skip_serializing_if = "Option::is_none")]
    pub file_size: Option<Integer>
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
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct Contact {
    /// Contact's phone number
    pub phone_number: String,
    /// Contact's first name
    pub first_name: String,
    /// <em>Optional</em>. Contact's last name
    #[serde(skip_serializing_if = "Option::is_none")]
    pub last_name: Option<String>,
    /// <em>Optional</em>. Contact's user identifier in Telegram. This number may have more than 32 significant bits and some programming languages may have difficulty/silent defects in interpreting it. But it has at most 52 significant bits, so a 64-bit integer or double-precision float type are safe for storing this identifier.
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
 * @property value Value of the dice, 1-6 for “<img class="emoji" src="//telegram.org/img/emoji/40/F09F8EB2.png" width="20" height="20" alt="🎲">”, “<img class="emoji" src="//telegram.org/img/emoji/40/F09F8EAF.png" width="20" height="20" alt="🎯">” and “<img class="emoji" src="//telegram.org/img/emoji/40/F09F8EB3.png" width="20" height="20" alt="🎳">” base emoji, 1-5 for “<img class="emoji" src="//telegram.org/img/emoji/40/F09F8F80.png" width="20" height="20" alt="🏀">” and “<img class="emoji" src="//telegram.org/img/emoji/40/E29ABD.png" width="20" height="20" alt="⚽">” base emoji, 1-64 for “<img class="emoji" src="//telegram.org/img/emoji/40/F09F8EB0.png" width="20" height="20" alt="🎰">” base emoji
 *
 * @constructor Creates a [Dice].
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct Dice {
    /// Emoji on which the dice throw animation is based
    pub emoji: String,
    /// Value of the dice, 1-6 for “<img class="emoji" src="//telegram.org/img/emoji/40/F09F8EB2.png" width="20" height="20" alt="🎲">”, “<img class="emoji" src="//telegram.org/img/emoji/40/F09F8EAF.png" width="20" height="20" alt="🎯">” and “<img class="emoji" src="//telegram.org/img/emoji/40/F09F8EB3.png" width="20" height="20" alt="🎳">” base emoji, 1-5 for “<img class="emoji" src="//telegram.org/img/emoji/40/F09F8F80.png" width="20" height="20" alt="🏀">” and “<img class="emoji" src="//telegram.org/img/emoji/40/E29ABD.png" width="20" height="20" alt="⚽">” base emoji, 1-64 for “<img class="emoji" src="//telegram.org/img/emoji/40/F09F8EB0.png" width="20" height="20" alt="🎰">” base emoji
    pub value: Integer
}

/**
 * <p>This object contains information about one answer option in a poll.</p>
 *
 * @property text Option text, 1-100 characters
 * @property text_entities <em>Optional</em>. Special entities that appear in the option <em>text</em>. Currently, only custom emoji entities are allowed in poll option texts
 * @property voter_count Number of users that voted for this option
 *
 * @constructor Creates a [PollOption].
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct PollOption {
    /// Option text, 1-100 characters
    pub text: String,
    /// <em>Optional</em>. Special entities that appear in the option <em>text</em>. Currently, only custom emoji entities are allowed in poll option texts
    #[serde(skip_serializing_if = "Option::is_none")]
    pub text_entities: Option<Vec<MessageEntity>>,
    /// Number of users that voted for this option
    pub voter_count: Integer
}

/**
 * <p>This object contains information about one answer option in a poll to send.</p>
 *
 * @property text Option text, 1-100 characters
 * @property text_parse_mode <em>Optional</em>. Mode for parsing entities in the text. See <a href="#formatting-options">formatting options</a> for more details. Currently, only custom emoji entities are allowed
 * @property text_entities <em>Optional</em>. A JSON-serialized list of special entities that appear in the poll option text. It can be specified instead of <em>text_parse_mode</em>
 *
 * @constructor Creates a [InputPollOption].
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct InputPollOption {
    /// Option text, 1-100 characters
    pub text: String,
    /// <em>Optional</em>. Mode for parsing entities in the text. See <a href="#formatting-options">formatting options</a> for more details. Currently, only custom emoji entities are allowed
    #[serde(skip_serializing_if = "Option::is_none")]
    pub text_parse_mode: Option<String>,
    /// <em>Optional</em>. A JSON-serialized list of special entities that appear in the poll option text. It can be specified instead of <em>text_parse_mode</em>
    #[serde(skip_serializing_if = "Option::is_none")]
    pub text_entities: Option<Vec<MessageEntity>>
}

/**
 * <p>This object represents an answer of a user in a non-anonymous poll.</p>
 *
 * @property poll_id Unique poll identifier
 * @property voter_chat <em>Optional</em>. The chat that changed the answer to the poll, if the voter is anonymous
 * @property user <em>Optional</em>. The user that changed the answer to the poll, if the voter isn't anonymous
 * @property option_ids 0-based identifiers of chosen answer options. May be empty if the vote was retracted.
 *
 * @constructor Creates a [PollAnswer].
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct PollAnswer {
    /// Unique poll identifier
    pub poll_id: String,
    /// <em>Optional</em>. The chat that changed the answer to the poll, if the voter is anonymous
    #[serde(skip_serializing_if = "Option::is_none")]
    pub voter_chat: Option<Chat>,
    /// <em>Optional</em>. The user that changed the answer to the poll, if the voter isn't anonymous
    #[serde(skip_serializing_if = "Option::is_none")]
    pub user: Option<User>,
    /// 0-based identifiers of chosen answer options. May be empty if the vote was retracted.
    pub option_ids: Vec<Integer>
}

/**
 * <p>This object contains information about a poll.</p>
 *
 * @property id Unique poll identifier
 * @property question Poll question, 1-300 characters
 * @property question_entities <em>Optional</em>. Special entities that appear in the <em>question</em>. Currently, only custom emoji entities are allowed in poll questions
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
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct Poll {
    /// Unique poll identifier
    pub id: String,
    /// Poll question, 1-300 characters
    pub question: String,
    /// <em>Optional</em>. Special entities that appear in the <em>question</em>. Currently, only custom emoji entities are allowed in poll questions
    #[serde(skip_serializing_if = "Option::is_none")]
    pub question_entities: Option<Vec<MessageEntity>>,
    /// List of poll options
    pub options: Vec<PollOption>,
    /// Total number of users that voted in the poll
    pub total_voter_count: Integer,
    /// <em>True</em>, if the poll is closed
    pub is_closed: bool,
    /// <em>True</em>, if the poll is anonymous
    pub is_anonymous: bool,
    /// Poll type, currently can be “regular” or “quiz”
    #[serde(rename = "type")]
    pub type_: String,
    /// <em>True</em>, if the poll allows multiple answers
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
 * @property latitude Latitude as defined by sender
 * @property longitude Longitude as defined by sender
 * @property horizontal_accuracy <em>Optional</em>. The radius of uncertainty for the location, measured in meters; 0-1500
 * @property live_period <em>Optional</em>. Time relative to the message sending date, during which the location can be updated; in seconds. For active live locations only.
 * @property heading <em>Optional</em>. The direction in which user is moving, in degrees; 1-360. For active live locations only.
 * @property proximity_alert_radius <em>Optional</em>. The maximum distance for proximity alerts about approaching another chat member, in meters. For sent live locations only.
 *
 * @constructor Creates a [Location].
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct Location {
    /// Latitude as defined by sender
    pub latitude: Float,
    /// Longitude as defined by sender
    pub longitude: Float,
    /// <em>Optional</em>. The radius of uncertainty for the location, measured in meters; 0-1500
    #[serde(skip_serializing_if = "Option::is_none")]
    pub horizontal_accuracy: Option<Float>,
    /// <em>Optional</em>. Time relative to the message sending date, during which the location can be updated; in seconds. For active live locations only.
    #[serde(skip_serializing_if = "Option::is_none")]
    pub live_period: Option<Integer>,
    /// <em>Optional</em>. The direction in which user is moving, in degrees; 1-360. For active live locations only.
    #[serde(skip_serializing_if = "Option::is_none")]
    pub heading: Option<Integer>,
    /// <em>Optional</em>. The maximum distance for proximity alerts about approaching another chat member, in meters. For sent live locations only.
    #[serde(skip_serializing_if = "Option::is_none")]
    pub proximity_alert_radius: Option<Integer>
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
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct Venue {
    /// Venue location. Can't be a live location
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
    pub foursquare_type: Option<String>,
    /// <em>Optional</em>. Google Places identifier of the venue
    #[serde(skip_serializing_if = "Option::is_none")]
    pub google_place_id: Option<String>,
    /// <em>Optional</em>. Google Places type of the venue. (See <a href="https://developers.google.com/places/web-service/supported_types">supported types</a>.)
    #[serde(skip_serializing_if = "Option::is_none")]
    pub google_place_type: Option<String>
}

/**
 * <p>Describes data sent from a <a href="/bots/webapps">Web App</a> to the bot.</p>
 *
 * @property data The data. Be aware that a bad client can send arbitrary data in this field.
 * @property button_text Text of the <em>web_app</em> keyboard button from which the Web App was opened. Be aware that a bad client can send arbitrary data in this field.
 *
 * @constructor Creates a [WebAppData].
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct WebAppData {
    /// The data. Be aware that a bad client can send arbitrary data in this field.
    pub data: String,
    /// Text of the <em>web_app</em> keyboard button from which the Web App was opened. Be aware that a bad client can send arbitrary data in this field.
    pub button_text: String
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
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct ProximityAlertTriggered {
    /// User that triggered the alert
    pub traveler: User,
    /// User that set the alert
    pub watcher: User,
    /// The distance between the users
    pub distance: Integer
}

/**
 * <p>This object represents a service message about a change in auto-delete timer settings.</p>
 *
 * @property message_auto_delete_time New auto-delete time for messages in the chat; in seconds
 *
 * @constructor Creates a [MessageAutoDeleteTimerChanged].
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct MessageAutoDeleteTimerChanged {
    /// New auto-delete time for messages in the chat; in seconds
    pub message_auto_delete_time: Integer
}

/**
 * <p>This object represents a service message about a user boosting a chat.</p>
 *
 * @property boost_count Number of boosts added by the user
 *
 * @constructor Creates a [ChatBoostAdded].
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct ChatBoostAdded {
    /// Number of boosts added by the user
    pub boost_count: Integer
}

/**
 * <p>The background is filled using the selected color.</p>
 *
 * @property type Type of the background fill, always “solid”
 * @property color The color of the background fill in the RGB24 format
 *
 * @constructor Creates a [BackgroundFillSolid].
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct BackgroundFillSolid {
    /// Type of the background fill, always “solid”
    #[serde(rename = "type")]
    pub type_: String,
    /// The color of the background fill in the RGB24 format
    pub color: Integer
}

/**
 * <p>The background is a gradient fill.</p>
 *
 * @property type Type of the background fill, always “gradient”
 * @property top_color Top color of the gradient in the RGB24 format
 * @property bottom_color Bottom color of the gradient in the RGB24 format
 * @property rotation_angle Clockwise rotation angle of the background fill in degrees; 0-359
 *
 * @constructor Creates a [BackgroundFillGradient].
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct BackgroundFillGradient {
    /// Type of the background fill, always “gradient”
    #[serde(rename = "type")]
    pub type_: String,
    /// Top color of the gradient in the RGB24 format
    pub top_color: Integer,
    /// Bottom color of the gradient in the RGB24 format
    pub bottom_color: Integer,
    /// Clockwise rotation angle of the background fill in degrees; 0-359
    pub rotation_angle: Integer
}

/**
 * <p>The background is a freeform gradient that rotates after every message in the chat.</p>
 *
 * @property type Type of the background fill, always “freeform_gradient”
 * @property colors A list of the 3 or 4 base colors that are used to generate the freeform gradient in the RGB24 format
 *
 * @constructor Creates a [BackgroundFillFreeformGradient].
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct BackgroundFillFreeformGradient {
    /// Type of the background fill, always “freeform_gradient”
    #[serde(rename = "type")]
    pub type_: String,
    /// A list of the 3 or 4 base colors that are used to generate the freeform gradient in the RGB24 format
    pub colors: Vec<Integer>
}

/**
 * <p>The background is automatically filled based on the selected colors.</p>
 *
 * @property type Type of the background, always “fill”
 * @property fill The background fill
 * @property dark_theme_dimming Dimming of the background in dark themes, as a percentage; 0-100
 *
 * @constructor Creates a [BackgroundTypeFill].
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct BackgroundTypeFill {
    /// Type of the background, always “fill”
    #[serde(rename = "type")]
    pub type_: String,
    /// The background fill
    pub fill: BackgroundFill,
    /// Dimming of the background in dark themes, as a percentage; 0-100
    pub dark_theme_dimming: Integer
}

/**
 * <p>The background is a wallpaper in the JPEG format.</p>
 *
 * @property type Type of the background, always “wallpaper”
 * @property document Document with the wallpaper
 * @property dark_theme_dimming Dimming of the background in dark themes, as a percentage; 0-100
 * @property is_blurred <em>Optional</em>. <em>True</em>, if the wallpaper is downscaled to fit in a 450x450 square and then box-blurred with radius 12
 * @property is_moving <em>Optional</em>. <em>True</em>, if the background moves slightly when the device is tilted
 *
 * @constructor Creates a [BackgroundTypeWallpaper].
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct BackgroundTypeWallpaper {
    /// Type of the background, always “wallpaper”
    #[serde(rename = "type")]
    pub type_: String,
    /// Document with the wallpaper
    pub document: Document,
    /// Dimming of the background in dark themes, as a percentage; 0-100
    pub dark_theme_dimming: Integer,
    /// <em>Optional</em>. <em>True</em>, if the wallpaper is downscaled to fit in a 450x450 square and then box-blurred with radius 12
    #[serde(skip_serializing_if = "Option::is_none")]
    pub is_blurred: Option<bool>,
    /// <em>Optional</em>. <em>True</em>, if the background moves slightly when the device is tilted
    #[serde(skip_serializing_if = "Option::is_none")]
    pub is_moving: Option<bool>
}

/**
 * <p>The background is a PNG or TGV (gzipped subset of SVG with MIME type “application/x-tgwallpattern”) pattern to be combined with the background fill chosen by the user.</p>
 *
 * @property type Type of the background, always “pattern”
 * @property document Document with the pattern
 * @property fill The background fill that is combined with the pattern
 * @property intensity Intensity of the pattern when it is shown above the filled background; 0-100
 * @property is_inverted <em>Optional</em>. <em>True</em>, if the background fill must be applied only to the pattern itself. All other pixels are black in this case. For dark themes only
 * @property is_moving <em>Optional</em>. <em>True</em>, if the background moves slightly when the device is tilted
 *
 * @constructor Creates a [BackgroundTypePattern].
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct BackgroundTypePattern {
    /// Type of the background, always “pattern”
    #[serde(rename = "type")]
    pub type_: String,
    /// Document with the pattern
    pub document: Document,
    /// The background fill that is combined with the pattern
    pub fill: BackgroundFill,
    /// Intensity of the pattern when it is shown above the filled background; 0-100
    pub intensity: Integer,
    /// <em>Optional</em>. <em>True</em>, if the background fill must be applied only to the pattern itself. All other pixels are black in this case. For dark themes only
    #[serde(skip_serializing_if = "Option::is_none")]
    pub is_inverted: Option<bool>,
    /// <em>Optional</em>. <em>True</em>, if the background moves slightly when the device is tilted
    #[serde(skip_serializing_if = "Option::is_none")]
    pub is_moving: Option<bool>
}

/**
 * <p>The background is taken directly from a built-in chat theme.</p>
 *
 * @property type Type of the background, always “chat_theme”
 * @property theme_name Name of the chat theme, which is usually an emoji
 *
 * @constructor Creates a [BackgroundTypeChatTheme].
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct BackgroundTypeChatTheme {
    /// Type of the background, always “chat_theme”
    #[serde(rename = "type")]
    pub type_: String,
    /// Name of the chat theme, which is usually an emoji
    pub theme_name: String
}

/**
 * <p>This object represents a chat background.</p>
 *
 * @property type Type of the background
 *
 * @constructor Creates a [ChatBackground].
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct ChatBackground {
    /// Type of the background
    #[serde(rename = "type")]
    pub type_: BackgroundType
}

/**
 * <p>This object represents a service message about a new forum topic created in the chat.</p>
 *
 * @property name Name of the topic
 * @property icon_color Color of the topic icon in RGB format
 * @property icon_custom_emoji_id <em>Optional</em>. Unique identifier of the custom emoji shown as the topic icon
 *
 * @constructor Creates a [ForumTopicCreated].
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct ForumTopicCreated {
    /// Name of the topic
    pub name: String,
    /// Color of the topic icon in RGB format
    pub icon_color: Integer,
    /// <em>Optional</em>. Unique identifier of the custom emoji shown as the topic icon
    #[serde(skip_serializing_if = "Option::is_none")]
    pub icon_custom_emoji_id: Option<String>
}

/**
 * <p>This object represents a service message about an edited forum topic.</p>
 *
 * @property name <em>Optional</em>. New name of the topic, if it was edited
 * @property icon_custom_emoji_id <em>Optional</em>. New identifier of the custom emoji shown as the topic icon, if it was edited; an empty string if the icon was removed
 *
 * @constructor Creates a [ForumTopicEdited].
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct ForumTopicEdited {
    /// <em>Optional</em>. New name of the topic, if it was edited
    #[serde(skip_serializing_if = "Option::is_none")]
    pub name: Option<String>,
    /// <em>Optional</em>. New identifier of the custom emoji shown as the topic icon, if it was edited; an empty string if the icon was removed
    #[serde(skip_serializing_if = "Option::is_none")]
    pub icon_custom_emoji_id: Option<String>
}

/**
 * <p>This object contains information about a user that was shared with the bot using a <a href="#keyboardbuttonrequestusers">KeyboardButtonRequestUsers</a> button.</p>
 *
 * @property user_id Identifier of the shared user. This number may have more than 32 significant bits and some programming languages may have difficulty/silent defects in interpreting it. But it has at most 52 significant bits, so 64-bit integers or double-precision float types are safe for storing these identifiers. The bot may not have access to the user and could be unable to use this identifier, unless the user is already known to the bot by some other means.
 * @property first_name <em>Optional</em>. First name of the user, if the name was requested by the bot
 * @property last_name <em>Optional</em>. Last name of the user, if the name was requested by the bot
 * @property username <em>Optional</em>. Username of the user, if the username was requested by the bot
 * @property photo <em>Optional</em>. Available sizes of the chat photo, if the photo was requested by the bot
 *
 * @constructor Creates a [SharedUser].
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct SharedUser {
    /// Identifier of the shared user. This number may have more than 32 significant bits and some programming languages may have difficulty/silent defects in interpreting it. But it has at most 52 significant bits, so 64-bit integers or double-precision float types are safe for storing these identifiers. The bot may not have access to the user and could be unable to use this identifier, unless the user is already known to the bot by some other means.
    pub user_id: Integer,
    /// <em>Optional</em>. First name of the user, if the name was requested by the bot
    #[serde(skip_serializing_if = "Option::is_none")]
    pub first_name: Option<String>,
    /// <em>Optional</em>. Last name of the user, if the name was requested by the bot
    #[serde(skip_serializing_if = "Option::is_none")]
    pub last_name: Option<String>,
    /// <em>Optional</em>. Username of the user, if the username was requested by the bot
    #[serde(skip_serializing_if = "Option::is_none")]
    pub username: Option<String>,
    /// <em>Optional</em>. Available sizes of the chat photo, if the photo was requested by the bot
    #[serde(skip_serializing_if = "Option::is_none")]
    pub photo: Option<Vec<PhotoSize>>
}

/**
 * <p>This object contains information about the users whose identifiers were shared with the bot using a <a href="#keyboardbuttonrequestusers">KeyboardButtonRequestUsers</a> button.</p>
 *
 * @property request_id Identifier of the request
 * @property users Information about users shared with the bot.
 *
 * @constructor Creates a [UsersShared].
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct UsersShared {
    /// Identifier of the request
    pub request_id: Integer,
    /// Information about users shared with the bot.
    pub users: Vec<SharedUser>
}

/**
 * <p>This object contains information about a chat that was shared with the bot using a <a href="#keyboardbuttonrequestchat">KeyboardButtonRequestChat</a> button.</p>
 *
 * @property request_id Identifier of the request
 * @property chat_id Identifier of the shared chat. This number may have more than 32 significant bits and some programming languages may have difficulty/silent defects in interpreting it. But it has at most 52 significant bits, so a 64-bit integer or double-precision float type are safe for storing this identifier. The bot may not have access to the chat and could be unable to use this identifier, unless the chat is already known to the bot by some other means.
 * @property title <em>Optional</em>. Title of the chat, if the title was requested by the bot.
 * @property username <em>Optional</em>. Username of the chat, if the username was requested by the bot and available.
 * @property photo <em>Optional</em>. Available sizes of the chat photo, if the photo was requested by the bot
 *
 * @constructor Creates a [ChatShared].
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct ChatShared {
    /// Identifier of the request
    pub request_id: Integer,
    /// Identifier of the shared chat. This number may have more than 32 significant bits and some programming languages may have difficulty/silent defects in interpreting it. But it has at most 52 significant bits, so a 64-bit integer or double-precision float type are safe for storing this identifier. The bot may not have access to the chat and could be unable to use this identifier, unless the chat is already known to the bot by some other means.
    pub chat_id: Integer,
    /// <em>Optional</em>. Title of the chat, if the title was requested by the bot.
    #[serde(skip_serializing_if = "Option::is_none")]
    pub title: Option<String>,
    /// <em>Optional</em>. Username of the chat, if the username was requested by the bot and available.
    #[serde(skip_serializing_if = "Option::is_none")]
    pub username: Option<String>,
    /// <em>Optional</em>. Available sizes of the chat photo, if the photo was requested by the bot
    #[serde(skip_serializing_if = "Option::is_none")]
    pub photo: Option<Vec<PhotoSize>>
}

/**
 * <p>This object represents a service message about a user allowing a bot to write messages after adding it to the attachment menu, launching a Web App from a link, or accepting an explicit request from a Web App sent by the method <a href="/bots/webapps#initializing-mini-apps">requestWriteAccess</a>.</p>
 *
 * @property from_request <em>Optional</em>. True, if the access was granted after the user accepted an explicit request from a Web App sent by the method <a href="/bots/webapps#initializing-mini-apps">requestWriteAccess</a>
 * @property web_app_name <em>Optional</em>. Name of the Web App, if the access was granted when the Web App was launched from a link
 * @property from_attachment_menu <em>Optional</em>. True, if the access was granted when the bot was added to the attachment or side menu
 *
 * @constructor Creates a [WriteAccessAllowed].
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct WriteAccessAllowed {
    /// <em>Optional</em>. True, if the access was granted after the user accepted an explicit request from a Web App sent by the method <a href="/bots/webapps#initializing-mini-apps">requestWriteAccess</a>
    #[serde(skip_serializing_if = "Option::is_none")]
    pub from_request: Option<bool>,
    /// <em>Optional</em>. Name of the Web App, if the access was granted when the Web App was launched from a link
    #[serde(skip_serializing_if = "Option::is_none")]
    pub web_app_name: Option<String>,
    /// <em>Optional</em>. True, if the access was granted when the bot was added to the attachment or side menu
    #[serde(skip_serializing_if = "Option::is_none")]
    pub from_attachment_menu: Option<bool>
}

/**
 * <p>This object represents a service message about a video chat scheduled in the chat.</p>
 *
 * @property start_date Point in time (Unix timestamp) when the video chat is supposed to be started by a chat administrator
 *
 * @constructor Creates a [VideoChatScheduled].
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct VideoChatScheduled {
    /// Point in time (Unix timestamp) when the video chat is supposed to be started by a chat administrator
    pub start_date: Integer
}

/**
 * <p>This object represents a service message about a video chat ended in the chat.</p>
 *
 * @property duration Video chat duration in seconds
 *
 * @constructor Creates a [VideoChatEnded].
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct VideoChatEnded {
    /// Video chat duration in seconds
    pub duration: Integer
}

/**
 * <p>This object represents a service message about new members invited to a video chat.</p>
 *
 * @property users New members that were invited to the video chat
 *
 * @constructor Creates a [VideoChatParticipantsInvited].
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct VideoChatParticipantsInvited {
    /// New members that were invited to the video chat
    pub users: Vec<User>
}

/**
 * <p>This object represents a message about a scheduled giveaway.</p>
 *
 * @property chats The list of chats which the user must join to participate in the giveaway
 * @property winners_selection_date Point in time (Unix timestamp) when winners of the giveaway will be selected
 * @property winner_count The number of users which are supposed to be selected as winners of the giveaway
 * @property only_new_members <em>Optional</em>. <em>True</em>, if only users who join the chats after the giveaway started should be eligible to win
 * @property has_public_winners <em>Optional</em>. <em>True</em>, if the list of giveaway winners will be visible to everyone
 * @property prize_description <em>Optional</em>. Description of additional giveaway prize
 * @property country_codes <em>Optional</em>. A list of two-letter <a href="https://en.wikipedia.org/wiki/ISO_3166-1_alpha-2">ISO 3166-1 alpha-2</a> country codes indicating the countries from which eligible users for the giveaway must come. If empty, then all users can participate in the giveaway. Users with a phone number that was bought on Fragment can always participate in giveaways.
 * @property premium_subscription_month_count <em>Optional</em>. The number of months the Telegram Premium subscription won from the giveaway will be active for
 *
 * @constructor Creates a [Giveaway].
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct Giveaway {
    /// The list of chats which the user must join to participate in the giveaway
    pub chats: Vec<Chat>,
    /// Point in time (Unix timestamp) when winners of the giveaway will be selected
    pub winners_selection_date: Integer,
    /// The number of users which are supposed to be selected as winners of the giveaway
    pub winner_count: Integer,
    /// <em>Optional</em>. <em>True</em>, if only users who join the chats after the giveaway started should be eligible to win
    #[serde(skip_serializing_if = "Option::is_none")]
    pub only_new_members: Option<bool>,
    /// <em>Optional</em>. <em>True</em>, if the list of giveaway winners will be visible to everyone
    #[serde(skip_serializing_if = "Option::is_none")]
    pub has_public_winners: Option<bool>,
    /// <em>Optional</em>. Description of additional giveaway prize
    #[serde(skip_serializing_if = "Option::is_none")]
    pub prize_description: Option<String>,
    /// <em>Optional</em>. A list of two-letter <a href="https://en.wikipedia.org/wiki/ISO_3166-1_alpha-2">ISO 3166-1 alpha-2</a> country codes indicating the countries from which eligible users for the giveaway must come. If empty, then all users can participate in the giveaway. Users with a phone number that was bought on Fragment can always participate in giveaways.
    #[serde(skip_serializing_if = "Option::is_none")]
    pub country_codes: Option<Vec<String>>,
    /// <em>Optional</em>. The number of months the Telegram Premium subscription won from the giveaway will be active for
    #[serde(skip_serializing_if = "Option::is_none")]
    pub premium_subscription_month_count: Option<Integer>
}

/**
 * <p>This object represents a message about the completion of a giveaway with public winners.</p>
 *
 * @property chat The chat that created the giveaway
 * @property giveaway_message_id Identifier of the message with the giveaway in the chat
 * @property winners_selection_date Point in time (Unix timestamp) when winners of the giveaway were selected
 * @property winner_count Total number of winners in the giveaway
 * @property winners List of up to 100 winners of the giveaway
 * @property additional_chat_count <em>Optional</em>. The number of other chats the user had to join in order to be eligible for the giveaway
 * @property premium_subscription_month_count <em>Optional</em>. The number of months the Telegram Premium subscription won from the giveaway will be active for
 * @property unclaimed_prize_count <em>Optional</em>. Number of undistributed prizes
 * @property only_new_members <em>Optional</em>. <em>True</em>, if only users who had joined the chats after the giveaway started were eligible to win
 * @property was_refunded <em>Optional</em>. <em>True</em>, if the giveaway was canceled because the payment for it was refunded
 * @property prize_description <em>Optional</em>. Description of additional giveaway prize
 *
 * @constructor Creates a [GiveawayWinners].
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct GiveawayWinners {
    /// The chat that created the giveaway
    pub chat: Chat,
    /// Identifier of the message with the giveaway in the chat
    pub giveaway_message_id: Integer,
    /// Point in time (Unix timestamp) when winners of the giveaway were selected
    pub winners_selection_date: Integer,
    /// Total number of winners in the giveaway
    pub winner_count: Integer,
    /// List of up to 100 winners of the giveaway
    pub winners: Vec<User>,
    /// <em>Optional</em>. The number of other chats the user had to join in order to be eligible for the giveaway
    #[serde(skip_serializing_if = "Option::is_none")]
    pub additional_chat_count: Option<Integer>,
    /// <em>Optional</em>. The number of months the Telegram Premium subscription won from the giveaway will be active for
    #[serde(skip_serializing_if = "Option::is_none")]
    pub premium_subscription_month_count: Option<Integer>,
    /// <em>Optional</em>. Number of undistributed prizes
    #[serde(skip_serializing_if = "Option::is_none")]
    pub unclaimed_prize_count: Option<Integer>,
    /// <em>Optional</em>. <em>True</em>, if only users who had joined the chats after the giveaway started were eligible to win
    #[serde(skip_serializing_if = "Option::is_none")]
    pub only_new_members: Option<bool>,
    /// <em>Optional</em>. <em>True</em>, if the giveaway was canceled because the payment for it was refunded
    #[serde(skip_serializing_if = "Option::is_none")]
    pub was_refunded: Option<bool>,
    /// <em>Optional</em>. Description of additional giveaway prize
    #[serde(skip_serializing_if = "Option::is_none")]
    pub prize_description: Option<String>
}

/**
 * <p>This object represents a service message about the completion of a giveaway without public winners.</p>
 *
 * @property winner_count Number of winners in the giveaway
 * @property unclaimed_prize_count <em>Optional</em>. Number of undistributed prizes
 * @property giveaway_message <em>Optional</em>. Message with the giveaway that was completed, if it wasn't deleted
 *
 * @constructor Creates a [GiveawayCompleted].
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct GiveawayCompleted {
    /// Number of winners in the giveaway
    pub winner_count: Integer,
    /// <em>Optional</em>. Number of undistributed prizes
    #[serde(skip_serializing_if = "Option::is_none")]
    pub unclaimed_prize_count: Option<Integer>,
    /// <em>Optional</em>. Message with the giveaway that was completed, if it wasn't deleted
    #[serde(skip_serializing_if = "Option::is_none")]
    pub giveaway_message: Option<Message>
}

/**
 * <p>Describes the options used for link preview generation.</p>
 *
 * @property is_disabled <em>Optional</em>. <em>True</em>, if the link preview is disabled
 * @property url <em>Optional</em>. URL to use for the link preview. If empty, then the first URL found in the message text will be used
 * @property prefer_small_media <em>Optional</em>. <em>True</em>, if the media in the link preview is supposed to be shrunk; ignored if the URL isn't explicitly specified or media size change isn't supported for the preview
 * @property prefer_large_media <em>Optional</em>. <em>True</em>, if the media in the link preview is supposed to be enlarged; ignored if the URL isn't explicitly specified or media size change isn't supported for the preview
 * @property show_above_text <em>Optional</em>. <em>True</em>, if the link preview must be shown above the message text; otherwise, the link preview will be shown below the message text
 *
 * @constructor Creates a [LinkPreviewOptions].
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct LinkPreviewOptions {
    /// <em>Optional</em>. <em>True</em>, if the link preview is disabled
    #[serde(skip_serializing_if = "Option::is_none")]
    pub is_disabled: Option<bool>,
    /// <em>Optional</em>. URL to use for the link preview. If empty, then the first URL found in the message text will be used
    #[serde(skip_serializing_if = "Option::is_none")]
    pub url: Option<String>,
    /// <em>Optional</em>. <em>True</em>, if the media in the link preview is supposed to be shrunk; ignored if the URL isn't explicitly specified or media size change isn't supported for the preview
    #[serde(skip_serializing_if = "Option::is_none")]
    pub prefer_small_media: Option<bool>,
    /// <em>Optional</em>. <em>True</em>, if the media in the link preview is supposed to be enlarged; ignored if the URL isn't explicitly specified or media size change isn't supported for the preview
    #[serde(skip_serializing_if = "Option::is_none")]
    pub prefer_large_media: Option<bool>,
    /// <em>Optional</em>. <em>True</em>, if the link preview must be shown above the message text; otherwise, the link preview will be shown below the message text
    #[serde(skip_serializing_if = "Option::is_none")]
    pub show_above_text: Option<bool>
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
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct File {
    /// Identifier for this file, which can be used to download or reuse the file
    pub file_id: String,
    /// Unique identifier for this file, which is supposed to be the same over time and for different bots. Can't be used to download or reuse the file.
    pub file_unique_id: String,
    /// <em>Optional</em>. File size in bytes. It can be bigger than 2^31 and some programming languages may have difficulty/silent defects in interpreting it. But it has at most 52 significant bits, so a signed 64-bit integer or double-precision float type are safe for storing this value.
    #[serde(skip_serializing_if = "Option::is_none")]
    pub file_size: Option<Integer>,
    /// <em>Optional</em>. File path. Use <code>https://api.telegram.org/file/bot&lt;token&gt;/&lt;file_path&gt;</code> to get the file.
    #[serde(skip_serializing_if = "Option::is_none")]
    pub file_path: Option<String>
}

/**
 * <p>Describes a <a href="/bots/webapps">Web App</a>.</p>
 *
 * @property url An HTTPS URL of a Web App to be opened with additional data as specified in <a href="/bots/webapps#initializing-mini-apps">Initializing Web Apps</a>
 *
 * @constructor Creates a [WebAppInfo].
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct WebAppInfo {
    /// An HTTPS URL of a Web App to be opened with additional data as specified in <a href="/bots/webapps#initializing-mini-apps">Initializing Web Apps</a>
    pub url: String
}

/**
 * <p>This object represents a <a href="/bots/features#keyboards">custom keyboard</a> with reply options (see <a href="/bots/features#keyboards">Introduction to bots</a> for details and examples). Not supported in channels and for messages sent on behalf of a Telegram Business account.</p>
 *
 * @property keyboard Array of button rows, each represented by an Array of <a href="#keyboardbutton">KeyboardButton</a> objects
 * @property is_persistent <em>Optional</em>. Requests clients to always show the keyboard when the regular keyboard is hidden. Defaults to <em>false</em>, in which case the custom keyboard can be hidden and opened with a keyboard icon.
 * @property resize_keyboard <em>Optional</em>. Requests clients to resize the keyboard vertically for optimal fit (e.g., make the keyboard smaller if there are just two rows of buttons). Defaults to <em>false</em>, in which case the custom keyboard is always of the same height as the app's standard keyboard.
 * @property one_time_keyboard <em>Optional</em>. Requests clients to hide the keyboard as soon as it's been used. The keyboard will still be available, but clients will automatically display the usual letter-keyboard in the chat - the user can press a special button in the input field to see the custom keyboard again. Defaults to <em>false</em>.
 * @property input_field_placeholder <em>Optional</em>. The placeholder to be shown in the input field when the keyboard is active; 1-64 characters
 * @property selective <em>Optional</em>. Use this parameter if you want to show the keyboard to specific users only. Targets: 1) users that are @mentioned in the <em>text</em> of the <a href="#message">Message</a> object; 2) if the bot's message is a reply to a message in the same chat and forum topic, sender of the original message.<br><br><em>Example:</em> A user requests to change the bot's language, bot replies to the request with a keyboard to select the new language. Other users in the group don't see the keyboard.
 *
 * @constructor Creates a [ReplyKeyboardMarkup].
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct ReplyKeyboardMarkup {
    /// Array of button rows, each represented by an Array of <a href="#keyboardbutton">KeyboardButton</a> objects
    pub keyboard: Vec<Vec<KeyboardButton>>,
    /// <em>Optional</em>. Requests clients to always show the keyboard when the regular keyboard is hidden. Defaults to <em>false</em>, in which case the custom keyboard can be hidden and opened with a keyboard icon.
    #[serde(skip_serializing_if = "Option::is_none")]
    pub is_persistent: Option<bool>,
    /// <em>Optional</em>. Requests clients to resize the keyboard vertically for optimal fit (e.g., make the keyboard smaller if there are just two rows of buttons). Defaults to <em>false</em>, in which case the custom keyboard is always of the same height as the app's standard keyboard.
    #[serde(skip_serializing_if = "Option::is_none")]
    pub resize_keyboard: Option<bool>,
    /// <em>Optional</em>. Requests clients to hide the keyboard as soon as it's been used. The keyboard will still be available, but clients will automatically display the usual letter-keyboard in the chat - the user can press a special button in the input field to see the custom keyboard again. Defaults to <em>false</em>.
    #[serde(skip_serializing_if = "Option::is_none")]
    pub one_time_keyboard: Option<bool>,
    /// <em>Optional</em>. The placeholder to be shown in the input field when the keyboard is active; 1-64 characters
    #[serde(skip_serializing_if = "Option::is_none")]
    pub input_field_placeholder: Option<String>,
    /// <em>Optional</em>. Use this parameter if you want to show the keyboard to specific users only. Targets: 1) users that are @mentioned in the <em>text</em> of the <a href="#message">Message</a> object; 2) if the bot's message is a reply to a message in the same chat and forum topic, sender of the original message.<br><br><em>Example:</em> A user requests to change the bot's language, bot replies to the request with a keyboard to select the new language. Other users in the group don't see the keyboard.
    #[serde(skip_serializing_if = "Option::is_none")]
    pub selective: Option<bool>
}

/**
 * <p>This object represents one button of the reply keyboard. At most one of the optional fields must be used to specify type of the button. For simple text buttons, <em>String</em> can be used instead of this object to specify the button text.</p><p><strong>Note:</strong> <em>request_users</em> and <em>request_chat</em> options will only work in Telegram versions released after 3 February, 2023. Older clients will display <em>unsupported message</em>.</p>
 *
 * @property text Text of the button. If none of the optional fields are used, it will be sent as a message when the button is pressed
 * @property request_users <em>Optional.</em> If specified, pressing the button will open a list of suitable users. Identifiers of selected users will be sent to the bot in a “users_shared” service message. Available in private chats only.
 * @property request_chat <em>Optional.</em> If specified, pressing the button will open a list of suitable chats. Tapping on a chat will send its identifier to the bot in a “chat_shared” service message. Available in private chats only.
 * @property request_contact <em>Optional</em>. If <em>True</em>, the user's phone number will be sent as a contact when the button is pressed. Available in private chats only.
 * @property request_location <em>Optional</em>. If <em>True</em>, the user's current location will be sent when the button is pressed. Available in private chats only.
 * @property request_poll <em>Optional</em>. If specified, the user will be asked to create a poll and send it to the bot when the button is pressed. Available in private chats only.
 * @property web_app <em>Optional</em>. If specified, the described <a href="/bots/webapps">Web App</a> will be launched when the button is pressed. The Web App will be able to send a “web_app_data” service message. Available in private chats only.
 *
 * @constructor Creates a [KeyboardButton].
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct KeyboardButton {
    /// Text of the button. If none of the optional fields are used, it will be sent as a message when the button is pressed
    pub text: String,
    /// <em>Optional.</em> If specified, pressing the button will open a list of suitable users. Identifiers of selected users will be sent to the bot in a “users_shared” service message. Available in private chats only.
    #[serde(skip_serializing_if = "Option::is_none")]
    pub request_users: Option<KeyboardButtonRequestUsers>,
    /// <em>Optional.</em> If specified, pressing the button will open a list of suitable chats. Tapping on a chat will send its identifier to the bot in a “chat_shared” service message. Available in private chats only.
    #[serde(skip_serializing_if = "Option::is_none")]
    pub request_chat: Option<KeyboardButtonRequestChat>,
    /// <em>Optional</em>. If <em>True</em>, the user's phone number will be sent as a contact when the button is pressed. Available in private chats only.
    #[serde(skip_serializing_if = "Option::is_none")]
    pub request_contact: Option<bool>,
    /// <em>Optional</em>. If <em>True</em>, the user's current location will be sent when the button is pressed. Available in private chats only.
    #[serde(skip_serializing_if = "Option::is_none")]
    pub request_location: Option<bool>,
    /// <em>Optional</em>. If specified, the user will be asked to create a poll and send it to the bot when the button is pressed. Available in private chats only.
    #[serde(skip_serializing_if = "Option::is_none")]
    pub request_poll: Option<KeyboardButtonPollType>,
    /// <em>Optional</em>. If specified, the described <a href="/bots/webapps">Web App</a> will be launched when the button is pressed. The Web App will be able to send a “web_app_data” service message. Available in private chats only.
    #[serde(skip_serializing_if = "Option::is_none")]
    pub web_app: Option<WebAppInfo>
}

/**
 * <p>This object defines the criteria used to request suitable users. Information about the selected users will be shared with the bot when the corresponding button is pressed. <a href="/bots/features#chat-and-user-selection">More about requesting users »</a></p>
 *
 * @property request_id Signed 32-bit identifier of the request that will be received back in the <a href="#usersshared">UsersShared</a> object. Must be unique within the message
 * @property user_is_bot <em>Optional</em>. Pass <em>True</em> to request bots, pass <em>False</em> to request regular users. If not specified, no additional restrictions are applied.
 * @property user_is_premium <em>Optional</em>. Pass <em>True</em> to request premium users, pass <em>False</em> to request non-premium users. If not specified, no additional restrictions are applied.
 * @property max_quantity <em>Optional</em>. The maximum number of users to be selected; 1-10. Defaults to 1.
 * @property request_name <em>Optional</em>. Pass <em>True</em> to request the users' first and last names
 * @property request_username <em>Optional</em>. Pass <em>True</em> to request the users' usernames
 * @property request_photo <em>Optional</em>. Pass <em>True</em> to request the users' photos
 *
 * @constructor Creates a [KeyboardButtonRequestUsers].
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct KeyboardButtonRequestUsers {
    /// Signed 32-bit identifier of the request that will be received back in the <a href="#usersshared">UsersShared</a> object. Must be unique within the message
    pub request_id: Integer,
    /// <em>Optional</em>. Pass <em>True</em> to request bots, pass <em>False</em> to request regular users. If not specified, no additional restrictions are applied.
    #[serde(skip_serializing_if = "Option::is_none")]
    pub user_is_bot: Option<bool>,
    /// <em>Optional</em>. Pass <em>True</em> to request premium users, pass <em>False</em> to request non-premium users. If not specified, no additional restrictions are applied.
    #[serde(skip_serializing_if = "Option::is_none")]
    pub user_is_premium: Option<bool>,
    /// <em>Optional</em>. The maximum number of users to be selected; 1-10. Defaults to 1.
    #[serde(skip_serializing_if = "Option::is_none")]
    pub max_quantity: Option<Integer>,
    /// <em>Optional</em>. Pass <em>True</em> to request the users' first and last names
    #[serde(skip_serializing_if = "Option::is_none")]
    pub request_name: Option<bool>,
    /// <em>Optional</em>. Pass <em>True</em> to request the users' usernames
    #[serde(skip_serializing_if = "Option::is_none")]
    pub request_username: Option<bool>,
    /// <em>Optional</em>. Pass <em>True</em> to request the users' photos
    #[serde(skip_serializing_if = "Option::is_none")]
    pub request_photo: Option<bool>
}

/**
 * <p>This object defines the criteria used to request a suitable chat. Information about the selected chat will be shared with the bot when the corresponding button is pressed. The bot will be granted requested rights in the chat if appropriate. <a href="/bots/features#chat-and-user-selection">More about requesting chats »</a>.</p>
 *
 * @property request_id Signed 32-bit identifier of the request, which will be received back in the <a href="#chatshared">ChatShared</a> object. Must be unique within the message
 * @property chat_is_channel Pass <em>True</em> to request a channel chat, pass <em>False</em> to request a group or a supergroup chat.
 * @property chat_is_forum <em>Optional</em>. Pass <em>True</em> to request a forum supergroup, pass <em>False</em> to request a non-forum chat. If not specified, no additional restrictions are applied.
 * @property chat_has_username <em>Optional</em>. Pass <em>True</em> to request a supergroup or a channel with a username, pass <em>False</em> to request a chat without a username. If not specified, no additional restrictions are applied.
 * @property chat_is_created <em>Optional</em>. Pass <em>True</em> to request a chat owned by the user. Otherwise, no additional restrictions are applied.
 * @property user_administrator_rights <em>Optional</em>. A JSON-serialized object listing the required administrator rights of the user in the chat. The rights must be a superset of <em>bot_administrator_rights</em>. If not specified, no additional restrictions are applied.
 * @property bot_administrator_rights <em>Optional</em>. A JSON-serialized object listing the required administrator rights of the bot in the chat. The rights must be a subset of <em>user_administrator_rights</em>. If not specified, no additional restrictions are applied.
 * @property bot_is_member <em>Optional</em>. Pass <em>True</em> to request a chat with the bot as a member. Otherwise, no additional restrictions are applied.
 * @property request_title <em>Optional</em>. Pass <em>True</em> to request the chat's title
 * @property request_username <em>Optional</em>. Pass <em>True</em> to request the chat's username
 * @property request_photo <em>Optional</em>. Pass <em>True</em> to request the chat's photo
 *
 * @constructor Creates a [KeyboardButtonRequestChat].
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct KeyboardButtonRequestChat {
    /// Signed 32-bit identifier of the request, which will be received back in the <a href="#chatshared">ChatShared</a> object. Must be unique within the message
    pub request_id: Integer,
    /// Pass <em>True</em> to request a channel chat, pass <em>False</em> to request a group or a supergroup chat.
    pub chat_is_channel: bool,
    /// <em>Optional</em>. Pass <em>True</em> to request a forum supergroup, pass <em>False</em> to request a non-forum chat. If not specified, no additional restrictions are applied.
    #[serde(skip_serializing_if = "Option::is_none")]
    pub chat_is_forum: Option<bool>,
    /// <em>Optional</em>. Pass <em>True</em> to request a supergroup or a channel with a username, pass <em>False</em> to request a chat without a username. If not specified, no additional restrictions are applied.
    #[serde(skip_serializing_if = "Option::is_none")]
    pub chat_has_username: Option<bool>,
    /// <em>Optional</em>. Pass <em>True</em> to request a chat owned by the user. Otherwise, no additional restrictions are applied.
    #[serde(skip_serializing_if = "Option::is_none")]
    pub chat_is_created: Option<bool>,
    /// <em>Optional</em>. A JSON-serialized object listing the required administrator rights of the user in the chat. The rights must be a superset of <em>bot_administrator_rights</em>. If not specified, no additional restrictions are applied.
    #[serde(skip_serializing_if = "Option::is_none")]
    pub user_administrator_rights: Option<ChatAdministratorRights>,
    /// <em>Optional</em>. A JSON-serialized object listing the required administrator rights of the bot in the chat. The rights must be a subset of <em>user_administrator_rights</em>. If not specified, no additional restrictions are applied.
    #[serde(skip_serializing_if = "Option::is_none")]
    pub bot_administrator_rights: Option<ChatAdministratorRights>,
    /// <em>Optional</em>. Pass <em>True</em> to request a chat with the bot as a member. Otherwise, no additional restrictions are applied.
    #[serde(skip_serializing_if = "Option::is_none")]
    pub bot_is_member: Option<bool>,
    /// <em>Optional</em>. Pass <em>True</em> to request the chat's title
    #[serde(skip_serializing_if = "Option::is_none")]
    pub request_title: Option<bool>,
    /// <em>Optional</em>. Pass <em>True</em> to request the chat's username
    #[serde(skip_serializing_if = "Option::is_none")]
    pub request_username: Option<bool>,
    /// <em>Optional</em>. Pass <em>True</em> to request the chat's photo
    #[serde(skip_serializing_if = "Option::is_none")]
    pub request_photo: Option<bool>
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
 * <p>Upon receiving a message with this object, Telegram clients will remove the current custom keyboard and display the default letter-keyboard. By default, custom keyboards are displayed until a new keyboard is sent by a bot. An exception is made for one-time keyboards that are hidden immediately after the user presses a button (see <a href="#replykeyboardmarkup">ReplyKeyboardMarkup</a>). Not supported in channels and for messages sent on behalf of a Telegram Business account.</p>
 *
 * @property remove_keyboard Requests clients to remove the custom keyboard (user will not be able to summon this keyboard; if you want to hide the keyboard from sight but keep it accessible, use <em>one_time_keyboard</em> in <a href="#replykeyboardmarkup">ReplyKeyboardMarkup</a>)
 * @property selective <em>Optional</em>. Use this parameter if you want to remove the keyboard for specific users only. Targets: 1) users that are @mentioned in the <em>text</em> of the <a href="#message">Message</a> object; 2) if the bot's message is a reply to a message in the same chat and forum topic, sender of the original message.<br><br><em>Example:</em> A user votes in a poll, bot returns confirmation message in reply to the vote and removes the keyboard for that user, while still showing the keyboard with poll options to users who haven't voted yet.
 *
 * @constructor Creates a [ReplyKeyboardRemove].
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct ReplyKeyboardRemove {
    /// Requests clients to remove the custom keyboard (user will not be able to summon this keyboard; if you want to hide the keyboard from sight but keep it accessible, use <em>one_time_keyboard</em> in <a href="#replykeyboardmarkup">ReplyKeyboardMarkup</a>)
    pub remove_keyboard: bool,
    /// <em>Optional</em>. Use this parameter if you want to remove the keyboard for specific users only. Targets: 1) users that are @mentioned in the <em>text</em> of the <a href="#message">Message</a> object; 2) if the bot's message is a reply to a message in the same chat and forum topic, sender of the original message.<br><br><em>Example:</em> A user votes in a poll, bot returns confirmation message in reply to the vote and removes the keyboard for that user, while still showing the keyboard with poll options to users who haven't voted yet.
    #[serde(skip_serializing_if = "Option::is_none")]
    pub selective: Option<bool>
}

/**
 * <p>This object represents an <a href="/bots/features#inline-keyboards">inline keyboard</a> that appears right next to the message it belongs to.</p>
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
 * <p>This object represents one button of an inline keyboard. Exactly one of the optional fields must be used to specify type of the button.</p>
 *
 * @property text Label text on the button
 * @property url <em>Optional</em>. HTTP or tg:// URL to be opened when the button is pressed. Links <code>tg://user?id=&lt;user_id&gt;</code> can be used to mention a user by their identifier without using a username, if this is allowed by their privacy settings.
 * @property callback_data <em>Optional</em>. Data to be sent in a <a href="#callbackquery">callback query</a> to the bot when button is pressed, 1-64 bytes. Not supported for messages sent on behalf of a Telegram Business account.
 * @property web_app <em>Optional</em>. Description of the <a href="/bots/webapps">Web App</a> that will be launched when the user presses the button. The Web App will be able to send an arbitrary message on behalf of the user using the method <a href="#answerwebappquery">answerWebAppQuery</a>. Available only in private chats between a user and the bot. Not supported for messages sent on behalf of a Telegram Business account.
 * @property login_url <em>Optional</em>. An HTTPS URL used to automatically authorize the user. Can be used as a replacement for the <a href="/widgets/login">Telegram Login Widget</a>.
 * @property switch_inline_query <em>Optional</em>. If set, pressing the button will prompt the user to select one of their chats, open that chat and insert the bot's username and the specified inline query in the input field. May be empty, in which case just the bot's username will be inserted. Not supported for messages sent on behalf of a Telegram Business account.
 * @property switch_inline_query_current_chat <em>Optional</em>. If set, pressing the button will insert the bot's username and the specified inline query in the current chat's input field. May be empty, in which case only the bot's username will be inserted.<br><br>This offers a quick way for the user to open your bot in inline mode in the same chat - good for selecting something from multiple options. Not supported in channels and for messages sent on behalf of a Telegram Business account.
 * @property switch_inline_query_chosen_chat <em>Optional</em>. If set, pressing the button will prompt the user to select one of their chats of the specified type, open that chat and insert the bot's username and the specified inline query in the input field. Not supported for messages sent on behalf of a Telegram Business account.
 * @property callback_game <em>Optional</em>. Description of the game that will be launched when the user presses the button.<br><br><strong>NOTE:</strong> This type of button <strong>must</strong> always be the first button in the first row.
 * @property pay <em>Optional</em>. Specify <em>True</em>, to send a <a href="#payments">Pay button</a>. Substrings “<img class="emoji" src="//telegram.org/img/emoji/40/E2AD90.png" width="20" height="20" alt="⭐">” and “XTR” in the buttons's text will be replaced with a Telegram Star icon.<br><br><strong>NOTE:</strong> This type of button <strong>must</strong> always be the first button in the first row and can only be used in invoice messages.
 *
 * @constructor Creates a [InlineKeyboardButton].
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct InlineKeyboardButton {
    /// Label text on the button
    pub text: String,
    /// <em>Optional</em>. HTTP or tg:// URL to be opened when the button is pressed. Links <code>tg://user?id=&lt;user_id&gt;</code> can be used to mention a user by their identifier without using a username, if this is allowed by their privacy settings.
    #[serde(skip_serializing_if = "Option::is_none")]
    pub url: Option<String>,
    /// <em>Optional</em>. Data to be sent in a <a href="#callbackquery">callback query</a> to the bot when button is pressed, 1-64 bytes. Not supported for messages sent on behalf of a Telegram Business account.
    #[serde(skip_serializing_if = "Option::is_none")]
    pub callback_data: Option<String>,
    /// <em>Optional</em>. Description of the <a href="/bots/webapps">Web App</a> that will be launched when the user presses the button. The Web App will be able to send an arbitrary message on behalf of the user using the method <a href="#answerwebappquery">answerWebAppQuery</a>. Available only in private chats between a user and the bot. Not supported for messages sent on behalf of a Telegram Business account.
    #[serde(skip_serializing_if = "Option::is_none")]
    pub web_app: Option<WebAppInfo>,
    /// <em>Optional</em>. An HTTPS URL used to automatically authorize the user. Can be used as a replacement for the <a href="/widgets/login">Telegram Login Widget</a>.
    #[serde(skip_serializing_if = "Option::is_none")]
    pub login_url: Option<LoginUrl>,
    /// <em>Optional</em>. If set, pressing the button will prompt the user to select one of their chats, open that chat and insert the bot's username and the specified inline query in the input field. May be empty, in which case just the bot's username will be inserted. Not supported for messages sent on behalf of a Telegram Business account.
    #[serde(skip_serializing_if = "Option::is_none")]
    pub switch_inline_query: Option<String>,
    /// <em>Optional</em>. If set, pressing the button will insert the bot's username and the specified inline query in the current chat's input field. May be empty, in which case only the bot's username will be inserted.<br><br>This offers a quick way for the user to open your bot in inline mode in the same chat - good for selecting something from multiple options. Not supported in channels and for messages sent on behalf of a Telegram Business account.
    #[serde(skip_serializing_if = "Option::is_none")]
    pub switch_inline_query_current_chat: Option<String>,
    /// <em>Optional</em>. If set, pressing the button will prompt the user to select one of their chats of the specified type, open that chat and insert the bot's username and the specified inline query in the input field. Not supported for messages sent on behalf of a Telegram Business account.
    #[serde(skip_serializing_if = "Option::is_none")]
    pub switch_inline_query_chosen_chat: Option<SwitchInlineQueryChosenChat>,
    /// <em>Optional</em>. Description of the game that will be launched when the user presses the button.<br><br><strong>NOTE:</strong> This type of button <strong>must</strong> always be the first button in the first row.
    #[serde(skip_serializing_if = "Option::is_none")]
    pub callback_game: Option<CallbackGame>,
    /// <em>Optional</em>. Specify <em>True</em>, to send a <a href="#payments">Pay button</a>. Substrings “<img class="emoji" src="//telegram.org/img/emoji/40/E2AD90.png" width="20" height="20" alt="⭐">” and “XTR” in the buttons's text will be replaced with a Telegram Star icon.<br><br><strong>NOTE:</strong> This type of button <strong>must</strong> always be the first button in the first row and can only be used in invoice messages.
    #[serde(skip_serializing_if = "Option::is_none")]
    pub pay: Option<bool>
}

/**
 * <p>This object represents a parameter of the inline keyboard button used to automatically authorize a user. Serves as a great replacement for the <a href="/widgets/login">Telegram Login Widget</a> when the user is coming from Telegram. All the user needs to do is tap/click a button and confirm that they want to log in:</p><p>Telegram apps support these buttons as of <a href="https://telegram.org/blog/privacy-discussions-web-bots#meet-seamless-web-bots">version 5.7</a>.</p><blockquote>
 *  <p>Sample bot: <a href="https://t.me/discussbot">@discussbot</a></p>
 * </blockquote>
 *
 * @property url An HTTPS URL to be opened with user authorization data added to the query string when the button is pressed. If the user refuses to provide authorization data, the original URL without information about the user will be opened. The data added is the same as described in <a href="/widgets/login#receiving-authorization-data">Receiving authorization data</a>.<br><br><strong>NOTE:</strong> You <strong>must</strong> always check the hash of the received data to verify the authentication and the integrity of the data as described in <a href="/widgets/login#checking-authorization">Checking authorization</a>.
 * @property forward_text <em>Optional</em>. New text of the button in forwarded messages.
 * @property bot_username <em>Optional</em>. Username of a bot, which will be used for user authorization. See <a href="/widgets/login#setting-up-a-bot">Setting up a bot</a> for more details. If not specified, the current bot's username will be assumed. The <em>url</em>'s domain must be the same as the domain linked with the bot. See <a href="/widgets/login#linking-your-domain-to-the-bot">Linking your domain to the bot</a> for more details.
 * @property request_write_access <em>Optional</em>. Pass <em>True</em> to request the permission for your bot to send messages to the user.
 *
 * @constructor Creates a [LoginUrl].
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct LoginUrl {
    /// An HTTPS URL to be opened with user authorization data added to the query string when the button is pressed. If the user refuses to provide authorization data, the original URL without information about the user will be opened. The data added is the same as described in <a href="/widgets/login#receiving-authorization-data">Receiving authorization data</a>.<br><br><strong>NOTE:</strong> You <strong>must</strong> always check the hash of the received data to verify the authentication and the integrity of the data as described in <a href="/widgets/login#checking-authorization">Checking authorization</a>.
    pub url: String,
    /// <em>Optional</em>. New text of the button in forwarded messages.
    #[serde(skip_serializing_if = "Option::is_none")]
    pub forward_text: Option<String>,
    /// <em>Optional</em>. Username of a bot, which will be used for user authorization. See <a href="/widgets/login#setting-up-a-bot">Setting up a bot</a> for more details. If not specified, the current bot's username will be assumed. The <em>url</em>'s domain must be the same as the domain linked with the bot. See <a href="/widgets/login#linking-your-domain-to-the-bot">Linking your domain to the bot</a> for more details.
    #[serde(skip_serializing_if = "Option::is_none")]
    pub bot_username: Option<String>,
    /// <em>Optional</em>. Pass <em>True</em> to request the permission for your bot to send messages to the user.
    #[serde(skip_serializing_if = "Option::is_none")]
    pub request_write_access: Option<bool>
}

/**
 * <p>This object represents an inline button that switches the current user to inline mode in a chosen chat, with an optional default inline query.</p>
 *
 * @property query <em>Optional</em>. The default inline query to be inserted in the input field. If left empty, only the bot's username will be inserted
 * @property allow_user_chats <em>Optional</em>. True, if private chats with users can be chosen
 * @property allow_bot_chats <em>Optional</em>. True, if private chats with bots can be chosen
 * @property allow_group_chats <em>Optional</em>. True, if group and supergroup chats can be chosen
 * @property allow_channel_chats <em>Optional</em>. True, if channel chats can be chosen
 *
 * @constructor Creates a [SwitchInlineQueryChosenChat].
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct SwitchInlineQueryChosenChat {
    /// <em>Optional</em>. The default inline query to be inserted in the input field. If left empty, only the bot's username will be inserted
    #[serde(skip_serializing_if = "Option::is_none")]
    pub query: Option<String>,
    /// <em>Optional</em>. True, if private chats with users can be chosen
    #[serde(skip_serializing_if = "Option::is_none")]
    pub allow_user_chats: Option<bool>,
    /// <em>Optional</em>. True, if private chats with bots can be chosen
    #[serde(skip_serializing_if = "Option::is_none")]
    pub allow_bot_chats: Option<bool>,
    /// <em>Optional</em>. True, if group and supergroup chats can be chosen
    #[serde(skip_serializing_if = "Option::is_none")]
    pub allow_group_chats: Option<bool>,
    /// <em>Optional</em>. True, if channel chats can be chosen
    #[serde(skip_serializing_if = "Option::is_none")]
    pub allow_channel_chats: Option<bool>
}

/**
 * <p>This object represents an incoming callback query from a callback button in an <a href="/bots/features#inline-keyboards">inline keyboard</a>. If the button that originated the query was attached to a message sent by the bot, the field <em>message</em> will be present. If the button was attached to a message sent via the bot (in <a href="#inline-mode">inline mode</a>), the field <em>inline_message_id</em> will be present. Exactly one of the fields <em>data</em> or <em>game_short_name</em> will be present.</p><blockquote>
 *  <p><strong>NOTE:</strong> After the user presses a callback button, Telegram clients will display a progress bar until you call <a href="#answercallbackquery">answerCallbackQuery</a>. It is, therefore, necessary to react by calling <a href="#answercallbackquery">answerCallbackQuery</a> even if no notification to the user is needed (e.g., without specifying any of the optional parameters).</p>
 * </blockquote>
 *
 * @property id Unique identifier for this query
 * @property from Sender
 * @property message <em>Optional</em>. Message sent by the bot with the callback button that originated the query
 * @property inline_message_id <em>Optional</em>. Identifier of the message sent via the bot in inline mode, that originated the query.
 * @property chat_instance Global identifier, uniquely corresponding to the chat to which the message with the callback button was sent. Useful for high scores in <a href="#games">games</a>.
 * @property data <em>Optional</em>. Data associated with the callback button. Be aware that the message originated the query can contain no callback buttons with this data.
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
    /// <em>Optional</em>. Message sent by the bot with the callback button that originated the query
    #[serde(skip_serializing_if = "Option::is_none")]
    pub message: Option<MaybeInaccessibleMessage>,
    /// <em>Optional</em>. Identifier of the message sent via the bot in inline mode, that originated the query.
    #[serde(skip_serializing_if = "Option::is_none")]
    pub inline_message_id: Option<String>,
    /// Global identifier, uniquely corresponding to the chat to which the message with the callback button was sent. Useful for high scores in <a href="#games">games</a>.
    pub chat_instance: String,
    /// <em>Optional</em>. Data associated with the callback button. Be aware that the message originated the query can contain no callback buttons with this data.
    #[serde(skip_serializing_if = "Option::is_none")]
    pub data: Option<String>,
    /// <em>Optional</em>. Short name of a <a href="#games">Game</a> to be returned, serves as the unique identifier for the game
    #[serde(skip_serializing_if = "Option::is_none")]
    pub game_short_name: Option<String>
}

/**
 * <p>Upon receiving a message with this object, Telegram clients will display a reply interface to the user (act as if the user has selected the bot's message and tapped 'Reply'). This can be extremely useful if you want to create user-friendly step-by-step interfaces without having to sacrifice <a href="/bots/features#privacy-mode">privacy mode</a>. Not supported in channels and for messages sent on behalf of a Telegram Business account.</p><blockquote>
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
 * @property selective <em>Optional</em>. Use this parameter if you want to force reply from specific users only. Targets: 1) users that are @mentioned in the <em>text</em> of the <a href="#message">Message</a> object; 2) if the bot's message is a reply to a message in the same chat and forum topic, sender of the original message.
 *
 * @constructor Creates a [ForceReply].
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct ForceReply {
    /// Shows reply interface to the user, as if they manually selected the bot's message and tapped 'Reply'
    pub force_reply: bool,
    /// <em>Optional</em>. The placeholder to be shown in the input field when the reply is active; 1-64 characters
    #[serde(skip_serializing_if = "Option::is_none")]
    pub input_field_placeholder: Option<String>,
    /// <em>Optional</em>. Use this parameter if you want to force reply from specific users only. Targets: 1) users that are @mentioned in the <em>text</em> of the <a href="#message">Message</a> object; 2) if the bot's message is a reply to a message in the same chat and forum topic, sender of the original message.
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
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct ChatInviteLink {
    /// The invite link. If the link was created by another chat administrator, then the second part of the link will be replaced with “…”.
    pub invite_link: String,
    /// Creator of the link
    pub creator: User,
    /// <em>True</em>, if users joining the chat via the link need to be approved by chat administrators
    pub creates_join_request: bool,
    /// <em>True</em>, if the link is primary
    pub is_primary: bool,
    /// <em>True</em>, if the link is revoked
    pub is_revoked: bool,
    /// <em>Optional</em>. Invite link name
    #[serde(skip_serializing_if = "Option::is_none")]
    pub name: Option<String>,
    /// <em>Optional</em>. Point in time (Unix timestamp) when the link will expire or has been expired
    #[serde(skip_serializing_if = "Option::is_none")]
    pub expire_date: Option<Integer>,
    /// <em>Optional</em>. The maximum number of users that can be members of the chat simultaneously after joining the chat via this invite link; 1-99999
    #[serde(skip_serializing_if = "Option::is_none")]
    pub member_limit: Option<Integer>,
    /// <em>Optional</em>. Number of pending join requests created using this link
    #[serde(skip_serializing_if = "Option::is_none")]
    pub pending_join_request_count: Option<Integer>
}

/**
 * <p>Represents the rights of an administrator in a chat.</p>
 *
 * @property is_anonymous <em>True</em>, if the user's presence in the chat is hidden
 * @property can_manage_chat <em>True</em>, if the administrator can access the chat event log, get boost list, see hidden supergroup and channel members, report spam messages and ignore slow mode. Implied by any other administrator privilege.
 * @property can_delete_messages <em>True</em>, if the administrator can delete messages of other users
 * @property can_manage_video_chats <em>True</em>, if the administrator can manage video chats
 * @property can_restrict_members <em>True</em>, if the administrator can restrict, ban or unban chat members, or access supergroup statistics
 * @property can_promote_members <em>True</em>, if the administrator can add new administrators with a subset of their own privileges or demote administrators that they have promoted, directly or indirectly (promoted by administrators that were appointed by the user)
 * @property can_change_info <em>True</em>, if the user is allowed to change the chat title, photo and other settings
 * @property can_invite_users <em>True</em>, if the user is allowed to invite new users to the chat
 * @property can_post_stories <em>True</em>, if the administrator can post stories to the chat
 * @property can_edit_stories <em>True</em>, if the administrator can edit stories posted by other users, post stories to the chat page, pin chat stories, and access the chat's story archive
 * @property can_delete_stories <em>True</em>, if the administrator can delete stories posted by other users
 * @property can_post_messages <em>Optional</em>. <em>True</em>, if the administrator can post messages in the channel, or access channel statistics; for channels only
 * @property can_edit_messages <em>Optional</em>. <em>True</em>, if the administrator can edit messages of other users and can pin messages; for channels only
 * @property can_pin_messages <em>Optional</em>. <em>True</em>, if the user is allowed to pin messages; for groups and supergroups only
 * @property can_manage_topics <em>Optional</em>. <em>True</em>, if the user is allowed to create, rename, close, and reopen forum topics; for supergroups only
 *
 * @constructor Creates a [ChatAdministratorRights].
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct ChatAdministratorRights {
    /// <em>True</em>, if the user's presence in the chat is hidden
    pub is_anonymous: bool,
    /// <em>True</em>, if the administrator can access the chat event log, get boost list, see hidden supergroup and channel members, report spam messages and ignore slow mode. Implied by any other administrator privilege.
    pub can_manage_chat: bool,
    /// <em>True</em>, if the administrator can delete messages of other users
    pub can_delete_messages: bool,
    /// <em>True</em>, if the administrator can manage video chats
    pub can_manage_video_chats: bool,
    /// <em>True</em>, if the administrator can restrict, ban or unban chat members, or access supergroup statistics
    pub can_restrict_members: bool,
    /// <em>True</em>, if the administrator can add new administrators with a subset of their own privileges or demote administrators that they have promoted, directly or indirectly (promoted by administrators that were appointed by the user)
    pub can_promote_members: bool,
    /// <em>True</em>, if the user is allowed to change the chat title, photo and other settings
    pub can_change_info: bool,
    /// <em>True</em>, if the user is allowed to invite new users to the chat
    pub can_invite_users: bool,
    /// <em>True</em>, if the administrator can post stories to the chat
    pub can_post_stories: bool,
    /// <em>True</em>, if the administrator can edit stories posted by other users, post stories to the chat page, pin chat stories, and access the chat's story archive
    pub can_edit_stories: bool,
    /// <em>True</em>, if the administrator can delete stories posted by other users
    pub can_delete_stories: bool,
    /// <em>Optional</em>. <em>True</em>, if the administrator can post messages in the channel, or access channel statistics; for channels only
    #[serde(skip_serializing_if = "Option::is_none")]
    pub can_post_messages: Option<bool>,
    /// <em>Optional</em>. <em>True</em>, if the administrator can edit messages of other users and can pin messages; for channels only
    #[serde(skip_serializing_if = "Option::is_none")]
    pub can_edit_messages: Option<bool>,
    /// <em>Optional</em>. <em>True</em>, if the user is allowed to pin messages; for groups and supergroups only
    #[serde(skip_serializing_if = "Option::is_none")]
    pub can_pin_messages: Option<bool>,
    /// <em>Optional</em>. <em>True</em>, if the user is allowed to create, rename, close, and reopen forum topics; for supergroups only
    #[serde(skip_serializing_if = "Option::is_none")]
    pub can_manage_topics: Option<bool>
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
 * @property via_join_request <em>Optional</em>. True, if the user joined the chat after sending a direct join request without using an invite link and being approved by an administrator
 * @property via_chat_folder_invite_link <em>Optional</em>. True, if the user joined the chat via a chat folder invite link
 *
 * @constructor Creates a [ChatMemberUpdated].
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct ChatMemberUpdated {
    /// Chat the user belongs to
    pub chat: Chat,
    /// Performer of the action, which resulted in the change
    pub from: User,
    /// Date the change was done in Unix time
    pub date: Integer,
    /// Previous information about the chat member
    pub old_chat_member: ChatMember,
    /// New information about the chat member
    pub new_chat_member: ChatMember,
    /// <em>Optional</em>. Chat invite link, which was used by the user to join the chat; for joining by invite link events only.
    #[serde(skip_serializing_if = "Option::is_none")]
    pub invite_link: Option<ChatInviteLink>,
    /// <em>Optional</em>. True, if the user joined the chat after sending a direct join request without using an invite link and being approved by an administrator
    #[serde(skip_serializing_if = "Option::is_none")]
    pub via_join_request: Option<bool>,
    /// <em>Optional</em>. True, if the user joined the chat via a chat folder invite link
    #[serde(skip_serializing_if = "Option::is_none")]
    pub via_chat_folder_invite_link: Option<bool>
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
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct ChatMemberOwner {
    /// The member's status in the chat, always “creator”
    pub status: String,
    /// Information about the user
    pub user: User,
    /// <em>True</em>, if the user's presence in the chat is hidden
    pub is_anonymous: bool,
    /// <em>Optional</em>. Custom title for this user
    #[serde(skip_serializing_if = "Option::is_none")]
    pub custom_title: Option<String>
}

/**
 * <p>Represents a <a href="#chatmember">chat member</a> that has some additional privileges.</p>
 *
 * @property status The member's status in the chat, always “administrator”
 * @property user Information about the user
 * @property can_be_edited <em>True</em>, if the bot is allowed to edit administrator privileges of that user
 * @property is_anonymous <em>True</em>, if the user's presence in the chat is hidden
 * @property can_manage_chat <em>True</em>, if the administrator can access the chat event log, get boost list, see hidden supergroup and channel members, report spam messages and ignore slow mode. Implied by any other administrator privilege.
 * @property can_delete_messages <em>True</em>, if the administrator can delete messages of other users
 * @property can_manage_video_chats <em>True</em>, if the administrator can manage video chats
 * @property can_restrict_members <em>True</em>, if the administrator can restrict, ban or unban chat members, or access supergroup statistics
 * @property can_promote_members <em>True</em>, if the administrator can add new administrators with a subset of their own privileges or demote administrators that they have promoted, directly or indirectly (promoted by administrators that were appointed by the user)
 * @property can_change_info <em>True</em>, if the user is allowed to change the chat title, photo and other settings
 * @property can_invite_users <em>True</em>, if the user is allowed to invite new users to the chat
 * @property can_post_stories <em>True</em>, if the administrator can post stories to the chat
 * @property can_edit_stories <em>True</em>, if the administrator can edit stories posted by other users, post stories to the chat page, pin chat stories, and access the chat's story archive
 * @property can_delete_stories <em>True</em>, if the administrator can delete stories posted by other users
 * @property can_post_messages <em>Optional</em>. <em>True</em>, if the administrator can post messages in the channel, or access channel statistics; for channels only
 * @property can_edit_messages <em>Optional</em>. <em>True</em>, if the administrator can edit messages of other users and can pin messages; for channels only
 * @property can_pin_messages <em>Optional</em>. <em>True</em>, if the user is allowed to pin messages; for groups and supergroups only
 * @property can_manage_topics <em>Optional</em>. <em>True</em>, if the user is allowed to create, rename, close, and reopen forum topics; for supergroups only
 * @property custom_title <em>Optional</em>. Custom title for this user
 *
 * @constructor Creates a [ChatMemberAdministrator].
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct ChatMemberAdministrator {
    /// The member's status in the chat, always “administrator”
    pub status: String,
    /// Information about the user
    pub user: User,
    /// <em>True</em>, if the bot is allowed to edit administrator privileges of that user
    pub can_be_edited: bool,
    /// <em>True</em>, if the user's presence in the chat is hidden
    pub is_anonymous: bool,
    /// <em>True</em>, if the administrator can access the chat event log, get boost list, see hidden supergroup and channel members, report spam messages and ignore slow mode. Implied by any other administrator privilege.
    pub can_manage_chat: bool,
    /// <em>True</em>, if the administrator can delete messages of other users
    pub can_delete_messages: bool,
    /// <em>True</em>, if the administrator can manage video chats
    pub can_manage_video_chats: bool,
    /// <em>True</em>, if the administrator can restrict, ban or unban chat members, or access supergroup statistics
    pub can_restrict_members: bool,
    /// <em>True</em>, if the administrator can add new administrators with a subset of their own privileges or demote administrators that they have promoted, directly or indirectly (promoted by administrators that were appointed by the user)
    pub can_promote_members: bool,
    /// <em>True</em>, if the user is allowed to change the chat title, photo and other settings
    pub can_change_info: bool,
    /// <em>True</em>, if the user is allowed to invite new users to the chat
    pub can_invite_users: bool,
    /// <em>True</em>, if the administrator can post stories to the chat
    pub can_post_stories: bool,
    /// <em>True</em>, if the administrator can edit stories posted by other users, post stories to the chat page, pin chat stories, and access the chat's story archive
    pub can_edit_stories: bool,
    /// <em>True</em>, if the administrator can delete stories posted by other users
    pub can_delete_stories: bool,
    /// <em>Optional</em>. <em>True</em>, if the administrator can post messages in the channel, or access channel statistics; for channels only
    #[serde(skip_serializing_if = "Option::is_none")]
    pub can_post_messages: Option<bool>,
    /// <em>Optional</em>. <em>True</em>, if the administrator can edit messages of other users and can pin messages; for channels only
    #[serde(skip_serializing_if = "Option::is_none")]
    pub can_edit_messages: Option<bool>,
    /// <em>Optional</em>. <em>True</em>, if the user is allowed to pin messages; for groups and supergroups only
    #[serde(skip_serializing_if = "Option::is_none")]
    pub can_pin_messages: Option<bool>,
    /// <em>Optional</em>. <em>True</em>, if the user is allowed to create, rename, close, and reopen forum topics; for supergroups only
    #[serde(skip_serializing_if = "Option::is_none")]
    pub can_manage_topics: Option<bool>,
    /// <em>Optional</em>. Custom title for this user
    #[serde(skip_serializing_if = "Option::is_none")]
    pub custom_title: Option<String>
}

/**
 * <p>Represents a <a href="#chatmember">chat member</a> that has no additional privileges or restrictions.</p>
 *
 * @property status The member's status in the chat, always “member”
 * @property user Information about the user
 *
 * @constructor Creates a [ChatMemberMember].
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct ChatMemberMember {
    /// The member's status in the chat, always “member”
    pub status: String,
    /// Information about the user
    pub user: User
}

/**
 * <p>Represents a <a href="#chatmember">chat member</a> that is under certain restrictions in the chat. Supergroups only.</p>
 *
 * @property status The member's status in the chat, always “restricted”
 * @property user Information about the user
 * @property is_member <em>True</em>, if the user is a member of the chat at the moment of the request
 * @property can_send_messages <em>True</em>, if the user is allowed to send text messages, contacts, giveaways, giveaway winners, invoices, locations and venues
 * @property can_send_audios <em>True</em>, if the user is allowed to send audios
 * @property can_send_documents <em>True</em>, if the user is allowed to send documents
 * @property can_send_photos <em>True</em>, if the user is allowed to send photos
 * @property can_send_videos <em>True</em>, if the user is allowed to send videos
 * @property can_send_video_notes <em>True</em>, if the user is allowed to send video notes
 * @property can_send_voice_notes <em>True</em>, if the user is allowed to send voice notes
 * @property can_send_polls <em>True</em>, if the user is allowed to send polls
 * @property can_send_other_messages <em>True</em>, if the user is allowed to send animations, games, stickers and use inline bots
 * @property can_add_web_page_previews <em>True</em>, if the user is allowed to add web page previews to their messages
 * @property can_change_info <em>True</em>, if the user is allowed to change the chat title, photo and other settings
 * @property can_invite_users <em>True</em>, if the user is allowed to invite new users to the chat
 * @property can_pin_messages <em>True</em>, if the user is allowed to pin messages
 * @property can_manage_topics <em>True</em>, if the user is allowed to create forum topics
 * @property until_date Date when restrictions will be lifted for this user; Unix time. If 0, then the user is restricted forever
 *
 * @constructor Creates a [ChatMemberRestricted].
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct ChatMemberRestricted {
    /// The member's status in the chat, always “restricted”
    pub status: String,
    /// Information about the user
    pub user: User,
    /// <em>True</em>, if the user is a member of the chat at the moment of the request
    pub is_member: bool,
    /// <em>True</em>, if the user is allowed to send text messages, contacts, giveaways, giveaway winners, invoices, locations and venues
    pub can_send_messages: bool,
    /// <em>True</em>, if the user is allowed to send audios
    pub can_send_audios: bool,
    /// <em>True</em>, if the user is allowed to send documents
    pub can_send_documents: bool,
    /// <em>True</em>, if the user is allowed to send photos
    pub can_send_photos: bool,
    /// <em>True</em>, if the user is allowed to send videos
    pub can_send_videos: bool,
    /// <em>True</em>, if the user is allowed to send video notes
    pub can_send_video_notes: bool,
    /// <em>True</em>, if the user is allowed to send voice notes
    pub can_send_voice_notes: bool,
    /// <em>True</em>, if the user is allowed to send polls
    pub can_send_polls: bool,
    /// <em>True</em>, if the user is allowed to send animations, games, stickers and use inline bots
    pub can_send_other_messages: bool,
    /// <em>True</em>, if the user is allowed to add web page previews to their messages
    pub can_add_web_page_previews: bool,
    /// <em>True</em>, if the user is allowed to change the chat title, photo and other settings
    pub can_change_info: bool,
    /// <em>True</em>, if the user is allowed to invite new users to the chat
    pub can_invite_users: bool,
    /// <em>True</em>, if the user is allowed to pin messages
    pub can_pin_messages: bool,
    /// <em>True</em>, if the user is allowed to create forum topics
    pub can_manage_topics: bool,
    /// Date when restrictions will be lifted for this user; Unix time. If 0, then the user is restricted forever
    pub until_date: Integer
}

/**
 * <p>Represents a <a href="#chatmember">chat member</a> that isn't currently a member of the chat, but may join it themselves.</p>
 *
 * @property status The member's status in the chat, always “left”
 * @property user Information about the user
 *
 * @constructor Creates a [ChatMemberLeft].
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct ChatMemberLeft {
    /// The member's status in the chat, always “left”
    pub status: String,
    /// Information about the user
    pub user: User
}

/**
 * <p>Represents a <a href="#chatmember">chat member</a> that was banned in the chat and can't return to the chat or view chat messages.</p>
 *
 * @property status The member's status in the chat, always “kicked”
 * @property user Information about the user
 * @property until_date Date when restrictions will be lifted for this user; Unix time. If 0, then the user is banned forever
 *
 * @constructor Creates a [ChatMemberBanned].
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct ChatMemberBanned {
    /// The member's status in the chat, always “kicked”
    pub status: String,
    /// Information about the user
    pub user: User,
    /// Date when restrictions will be lifted for this user; Unix time. If 0, then the user is banned forever
    pub until_date: Integer
}

/**
 * <p>Represents a join request sent to a chat.</p>
 *
 * @property chat Chat to which the request was sent
 * @property from User that sent the join request
 * @property user_chat_id Identifier of a private chat with the user who sent the join request. This number may have more than 32 significant bits and some programming languages may have difficulty/silent defects in interpreting it. But it has at most 52 significant bits, so a 64-bit integer or double-precision float type are safe for storing this identifier. The bot can use this identifier for 5 minutes to send messages until the join request is processed, assuming no other administrator contacted the user.
 * @property date Date the request was sent in Unix time
 * @property bio <em>Optional</em>. Bio of the user.
 * @property invite_link <em>Optional</em>. Chat invite link that was used by the user to send the join request
 *
 * @constructor Creates a [ChatJoinRequest].
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct ChatJoinRequest {
    /// Chat to which the request was sent
    pub chat: Chat,
    /// User that sent the join request
    pub from: User,
    /// Identifier of a private chat with the user who sent the join request. This number may have more than 32 significant bits and some programming languages may have difficulty/silent defects in interpreting it. But it has at most 52 significant bits, so a 64-bit integer or double-precision float type are safe for storing this identifier. The bot can use this identifier for 5 minutes to send messages until the join request is processed, assuming no other administrator contacted the user.
    pub user_chat_id: Integer,
    /// Date the request was sent in Unix time
    pub date: Integer,
    /// <em>Optional</em>. Bio of the user.
    #[serde(skip_serializing_if = "Option::is_none")]
    pub bio: Option<String>,
    /// <em>Optional</em>. Chat invite link that was used by the user to send the join request
    #[serde(skip_serializing_if = "Option::is_none")]
    pub invite_link: Option<ChatInviteLink>
}

/**
 * <p>Describes actions that a non-administrator user is allowed to take in a chat.</p>
 *
 * @property can_send_messages <em>Optional</em>. <em>True</em>, if the user is allowed to send text messages, contacts, giveaways, giveaway winners, invoices, locations and venues
 * @property can_send_audios <em>Optional</em>. <em>True</em>, if the user is allowed to send audios
 * @property can_send_documents <em>Optional</em>. <em>True</em>, if the user is allowed to send documents
 * @property can_send_photos <em>Optional</em>. <em>True</em>, if the user is allowed to send photos
 * @property can_send_videos <em>Optional</em>. <em>True</em>, if the user is allowed to send videos
 * @property can_send_video_notes <em>Optional</em>. <em>True</em>, if the user is allowed to send video notes
 * @property can_send_voice_notes <em>Optional</em>. <em>True</em>, if the user is allowed to send voice notes
 * @property can_send_polls <em>Optional</em>. <em>True</em>, if the user is allowed to send polls
 * @property can_send_other_messages <em>Optional</em>. <em>True</em>, if the user is allowed to send animations, games, stickers and use inline bots
 * @property can_add_web_page_previews <em>Optional</em>. <em>True</em>, if the user is allowed to add web page previews to their messages
 * @property can_change_info <em>Optional</em>. <em>True</em>, if the user is allowed to change the chat title, photo and other settings. Ignored in public supergroups
 * @property can_invite_users <em>Optional</em>. <em>True</em>, if the user is allowed to invite new users to the chat
 * @property can_pin_messages <em>Optional</em>. <em>True</em>, if the user is allowed to pin messages. Ignored in public supergroups
 * @property can_manage_topics <em>Optional</em>. <em>True</em>, if the user is allowed to create forum topics. If omitted defaults to the value of can_pin_messages
 *
 * @constructor Creates a [ChatPermissions].
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct ChatPermissions {
    /// <em>Optional</em>. <em>True</em>, if the user is allowed to send text messages, contacts, giveaways, giveaway winners, invoices, locations and venues
    #[serde(skip_serializing_if = "Option::is_none")]
    pub can_send_messages: Option<bool>,
    /// <em>Optional</em>. <em>True</em>, if the user is allowed to send audios
    #[serde(skip_serializing_if = "Option::is_none")]
    pub can_send_audios: Option<bool>,
    /// <em>Optional</em>. <em>True</em>, if the user is allowed to send documents
    #[serde(skip_serializing_if = "Option::is_none")]
    pub can_send_documents: Option<bool>,
    /// <em>Optional</em>. <em>True</em>, if the user is allowed to send photos
    #[serde(skip_serializing_if = "Option::is_none")]
    pub can_send_photos: Option<bool>,
    /// <em>Optional</em>. <em>True</em>, if the user is allowed to send videos
    #[serde(skip_serializing_if = "Option::is_none")]
    pub can_send_videos: Option<bool>,
    /// <em>Optional</em>. <em>True</em>, if the user is allowed to send video notes
    #[serde(skip_serializing_if = "Option::is_none")]
    pub can_send_video_notes: Option<bool>,
    /// <em>Optional</em>. <em>True</em>, if the user is allowed to send voice notes
    #[serde(skip_serializing_if = "Option::is_none")]
    pub can_send_voice_notes: Option<bool>,
    /// <em>Optional</em>. <em>True</em>, if the user is allowed to send polls
    #[serde(skip_serializing_if = "Option::is_none")]
    pub can_send_polls: Option<bool>,
    /// <em>Optional</em>. <em>True</em>, if the user is allowed to send animations, games, stickers and use inline bots
    #[serde(skip_serializing_if = "Option::is_none")]
    pub can_send_other_messages: Option<bool>,
    /// <em>Optional</em>. <em>True</em>, if the user is allowed to add web page previews to their messages
    #[serde(skip_serializing_if = "Option::is_none")]
    pub can_add_web_page_previews: Option<bool>,
    /// <em>Optional</em>. <em>True</em>, if the user is allowed to change the chat title, photo and other settings. Ignored in public supergroups
    #[serde(skip_serializing_if = "Option::is_none")]
    pub can_change_info: Option<bool>,
    /// <em>Optional</em>. <em>True</em>, if the user is allowed to invite new users to the chat
    #[serde(skip_serializing_if = "Option::is_none")]
    pub can_invite_users: Option<bool>,
    /// <em>Optional</em>. <em>True</em>, if the user is allowed to pin messages. Ignored in public supergroups
    #[serde(skip_serializing_if = "Option::is_none")]
    pub can_pin_messages: Option<bool>,
    /// <em>Optional</em>. <em>True</em>, if the user is allowed to create forum topics. If omitted defaults to the value of can_pin_messages
    #[serde(skip_serializing_if = "Option::is_none")]
    pub can_manage_topics: Option<bool>
}

/**
 * <p>Describes the birthdate of a user.</p>
 *
 * @property day Day of the user's birth; 1-31
 * @property month Month of the user's birth; 1-12
 * @property year <em>Optional</em>. Year of the user's birth
 *
 * @constructor Creates a [Birthdate].
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct Birthdate {
    /// Day of the user's birth; 1-31
    pub day: Integer,
    /// Month of the user's birth; 1-12
    pub month: Integer,
    /// <em>Optional</em>. Year of the user's birth
    #[serde(skip_serializing_if = "Option::is_none")]
    pub year: Option<Integer>
}

/**
 * <p>Contains information about the start page settings of a Telegram Business account.</p>
 *
 * @property title <em>Optional</em>. Title text of the business intro
 * @property message <em>Optional</em>. Message text of the business intro
 * @property sticker <em>Optional</em>. Sticker of the business intro
 *
 * @constructor Creates a [BusinessIntro].
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct BusinessIntro {
    /// <em>Optional</em>. Title text of the business intro
    #[serde(skip_serializing_if = "Option::is_none")]
    pub title: Option<String>,
    /// <em>Optional</em>. Message text of the business intro
    #[serde(skip_serializing_if = "Option::is_none")]
    pub message: Option<String>,
    /// <em>Optional</em>. Sticker of the business intro
    #[serde(skip_serializing_if = "Option::is_none")]
    pub sticker: Option<Sticker>
}

/**
 * <p>Contains information about the location of a Telegram Business account.</p>
 *
 * @property address Address of the business
 * @property location <em>Optional</em>. Location of the business
 *
 * @constructor Creates a [BusinessLocation].
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct BusinessLocation {
    /// Address of the business
    pub address: String,
    /// <em>Optional</em>. Location of the business
    #[serde(skip_serializing_if = "Option::is_none")]
    pub location: Option<Location>
}

/**
 * <p>Describes an interval of time during which a business is open.</p>
 *
 * @property opening_minute The minute's sequence number in a week, starting on Monday, marking the start of the time interval during which the business is open; 0 - 7 * 24 * 60
 * @property closing_minute The minute's sequence number in a week, starting on Monday, marking the end of the time interval during which the business is open; 0 - 8 * 24 * 60
 *
 * @constructor Creates a [BusinessOpeningHoursInterval].
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct BusinessOpeningHoursInterval {
    /// The minute's sequence number in a week, starting on Monday, marking the start of the time interval during which the business is open; 0 - 7 * 24 * 60
    pub opening_minute: Integer,
    /// The minute's sequence number in a week, starting on Monday, marking the end of the time interval during which the business is open; 0 - 8 * 24 * 60
    pub closing_minute: Integer
}

/**
 * <p>Describes the opening hours of a business.</p>
 *
 * @property time_zone_name Unique name of the time zone for which the opening hours are defined
 * @property opening_hours List of time intervals describing business opening hours
 *
 * @constructor Creates a [BusinessOpeningHours].
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct BusinessOpeningHours {
    /// Unique name of the time zone for which the opening hours are defined
    pub time_zone_name: String,
    /// List of time intervals describing business opening hours
    pub opening_hours: Vec<BusinessOpeningHoursInterval>
}

/**
 * <p>Represents a location to which a chat is connected.</p>
 *
 * @property location The location to which the supergroup is connected. Can't be a live location.
 * @property address Location address; 1-64 characters, as defined by the chat owner
 *
 * @constructor Creates a [ChatLocation].
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct ChatLocation {
    /// The location to which the supergroup is connected. Can't be a live location.
    pub location: Location,
    /// Location address; 1-64 characters, as defined by the chat owner
    pub address: String
}

/**
 * <p>The reaction is based on an emoji.</p>
 *
 * @property type Type of the reaction, always “emoji”
 * @property emoji Reaction emoji. Currently, it can be one of "<img class="emoji" src="//telegram.org/img/emoji/40/F09F918D.png" width="20" height="20" alt="👍">", "<img class="emoji" src="//telegram.org/img/emoji/40/F09F918E.png" width="20" height="20" alt="👎">", "<img class="emoji" src="//telegram.org/img/emoji/40/E29DA4.png" width="20" height="20" alt="❤">", "<img class="emoji" src="//telegram.org/img/emoji/40/F09F94A5.png" width="20" height="20" alt="🔥">", "<img class="emoji" src="//telegram.org/img/emoji/40/F09FA5B0.png" width="20" height="20" alt="🥰">", "<img class="emoji" src="//telegram.org/img/emoji/40/F09F918F.png" width="20" height="20" alt="👏">", "<img class="emoji" src="//telegram.org/img/emoji/40/F09F9881.png" width="20" height="20" alt="😁">", "<img class="emoji" src="//telegram.org/img/emoji/40/F09FA494.png" width="20" height="20" alt="🤔">", "<img class="emoji" src="//telegram.org/img/emoji/40/F09FA4AF.png" width="20" height="20" alt="🤯">", "<img class="emoji" src="//telegram.org/img/emoji/40/F09F98B1.png" width="20" height="20" alt="😱">", "<img class="emoji" src="//telegram.org/img/emoji/40/F09FA4AC.png" width="20" height="20" alt="🤬">", "<img class="emoji" src="//telegram.org/img/emoji/40/F09F98A2.png" width="20" height="20" alt="😢">", "<img class="emoji" src="//telegram.org/img/emoji/40/F09F8E89.png" width="20" height="20" alt="🎉">", "<img class="emoji" src="//telegram.org/img/emoji/40/F09FA4A9.png" width="20" height="20" alt="🤩">", "<img class="emoji" src="//telegram.org/img/emoji/40/F09FA4AE.png" width="20" height="20" alt="🤮">", "<img class="emoji" src="//telegram.org/img/emoji/40/F09F92A9.png" width="20" height="20" alt="💩">", "<img class="emoji" src="//telegram.org/img/emoji/40/F09F998F.png" width="20" height="20" alt="🙏">", "<img class="emoji" src="//telegram.org/img/emoji/40/F09F918C.png" width="20" height="20" alt="👌">", "<img class="emoji" src="//telegram.org/img/emoji/40/F09F958A.png" width="20" height="20" alt="🕊">", "<img class="emoji" src="//telegram.org/img/emoji/40/F09FA4A1.png" width="20" height="20" alt="🤡">", "<img class="emoji" src="//telegram.org/img/emoji/40/F09FA5B1.png" width="20" height="20" alt="🥱">", "<img class="emoji" src="//telegram.org/img/emoji/40/F09FA5B4.png" width="20" height="20" alt="🥴">", "<img class="emoji" src="//telegram.org/img/emoji/40/F09F988D.png" width="20" height="20" alt="😍">", "<img class="emoji" src="//telegram.org/img/emoji/40/F09F90B3.png" width="20" height="20" alt="🐳">", "<img class="emoji" src="//telegram.org/img/emoji/40/E29DA4E2808DF09F94A5.png" width="20" height="20" alt="❤‍🔥">", "<img class="emoji" src="//telegram.org/img/emoji/40/F09F8C9A.png" width="20" height="20" alt="🌚">", "<img class="emoji" src="//telegram.org/img/emoji/40/F09F8CAD.png" width="20" height="20" alt="🌭">", "<img class="emoji" src="//telegram.org/img/emoji/40/F09F92AF.png" width="20" height="20" alt="💯">", "<img class="emoji" src="//telegram.org/img/emoji/40/F09FA4A3.png" width="20" height="20" alt="🤣">", "<img class="emoji" src="//telegram.org/img/emoji/40/E29AA1.png" width="20" height="20" alt="⚡">", "<img class="emoji" src="//telegram.org/img/emoji/40/F09F8D8C.png" width="20" height="20" alt="🍌">", "<img class="emoji" src="//telegram.org/img/emoji/40/F09F8F86.png" width="20" height="20" alt="🏆">", "<img class="emoji" src="//telegram.org/img/emoji/40/F09F9294.png" width="20" height="20" alt="💔">", "<img class="emoji" src="//telegram.org/img/emoji/40/F09FA4A8.png" width="20" height="20" alt="🤨">", "<img class="emoji" src="//telegram.org/img/emoji/40/F09F9890.png" width="20" height="20" alt="😐">", "<img class="emoji" src="//telegram.org/img/emoji/40/F09F8D93.png" width="20" height="20" alt="🍓">", "<img class="emoji" src="//telegram.org/img/emoji/40/F09F8DBE.png" width="20" height="20" alt="🍾">", "<img class="emoji" src="//telegram.org/img/emoji/40/F09F928B.png" width="20" height="20" alt="💋">", "<img class="emoji" src="//telegram.org/img/emoji/40/F09F9695.png" width="20" height="20" alt="🖕">", "<img class="emoji" src="//telegram.org/img/emoji/40/F09F9888.png" width="20" height="20" alt="😈">", "<img class="emoji" src="//telegram.org/img/emoji/40/F09F98B4.png" width="20" height="20" alt="😴">", "<img class="emoji" src="//telegram.org/img/emoji/40/F09F98AD.png" width="20" height="20" alt="😭">", "<img class="emoji" src="//telegram.org/img/emoji/40/F09FA493.png" width="20" height="20" alt="🤓">", "<img class="emoji" src="//telegram.org/img/emoji/40/F09F91BB.png" width="20" height="20" alt="👻">", "<img class="emoji" src="//telegram.org/img/emoji/40/F09F91A8E2808DF09F92BB.png" width="20" height="20" alt="👨‍💻">", "<img class="emoji" src="//telegram.org/img/emoji/40/F09F9180.png" width="20" height="20" alt="👀">", "<img class="emoji" src="//telegram.org/img/emoji/40/F09F8E83.png" width="20" height="20" alt="🎃">", "<img class="emoji" src="//telegram.org/img/emoji/40/F09F9988.png" width="20" height="20" alt="🙈">", "<img class="emoji" src="//telegram.org/img/emoji/40/F09F9887.png" width="20" height="20" alt="😇">", "<img class="emoji" src="//telegram.org/img/emoji/40/F09F98A8.png" width="20" height="20" alt="😨">", "<img class="emoji" src="//telegram.org/img/emoji/40/F09FA49D.png" width="20" height="20" alt="🤝">", "<img class="emoji" src="//telegram.org/img/emoji/40/E29C8D.png" width="20" height="20" alt="✍">", "<img class="emoji" src="//telegram.org/img/emoji/40/F09FA497.png" width="20" height="20" alt="🤗">", "<img class="emoji" src="//telegram.org/img/emoji/40/F09FABA1.png" width="20" height="20" alt="🫡">", "<img class="emoji" src="//telegram.org/img/emoji/40/F09F8E85.png" width="20" height="20" alt="🎅">", "<img class="emoji" src="//telegram.org/img/emoji/40/F09F8E84.png" width="20" height="20" alt="🎄">", "<img class="emoji" src="//telegram.org/img/emoji/40/E29883.png" width="20" height="20" alt="☃">", "<img class="emoji" src="//telegram.org/img/emoji/40/F09F9285.png" width="20" height="20" alt="💅">", "<img class="emoji" src="//telegram.org/img/emoji/40/F09FA4AA.png" width="20" height="20" alt="🤪">", "<img class="emoji" src="//telegram.org/img/emoji/40/F09F97BF.png" width="20" height="20" alt="🗿">", "<img class="emoji" src="//telegram.org/img/emoji/40/F09F8692.png" width="20" height="20" alt="🆒">", "<img class="emoji" src="//telegram.org/img/emoji/40/F09F9298.png" width="20" height="20" alt="💘">", "<img class="emoji" src="//telegram.org/img/emoji/40/F09F9989.png" width="20" height="20" alt="🙉">", "<img class="emoji" src="//telegram.org/img/emoji/40/F09FA684.png" width="20" height="20" alt="🦄">", "<img class="emoji" src="//telegram.org/img/emoji/40/F09F9898.png" width="20" height="20" alt="😘">", "<img class="emoji" src="//telegram.org/img/emoji/40/F09F928A.png" width="20" height="20" alt="💊">", "<img class="emoji" src="//telegram.org/img/emoji/40/F09F998A.png" width="20" height="20" alt="🙊">", "<img class="emoji" src="//telegram.org/img/emoji/40/F09F988E.png" width="20" height="20" alt="😎">", "<img class="emoji" src="//telegram.org/img/emoji/40/F09F91BE.png" width="20" height="20" alt="👾">", "<img class="emoji" src="//telegram.org/img/emoji/40/F09FA4B7E2808DE29982.png" width="20" height="20" alt="🤷‍♂">", "<img class="emoji" src="//telegram.org/img/emoji/40/F09FA4B7.png" width="20" height="20" alt="🤷">", "<img class="emoji" src="//telegram.org/img/emoji/40/F09FA4B7E2808DE29980.png" width="20" height="20" alt="🤷‍♀">", "<img class="emoji" src="//telegram.org/img/emoji/40/F09F98A1.png" width="20" height="20" alt="😡">"
 *
 * @constructor Creates a [ReactionTypeEmoji].
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct ReactionTypeEmoji {
    /// Type of the reaction, always “emoji”
    #[serde(rename = "type")]
    pub type_: String,
    /// Reaction emoji. Currently, it can be one of "<img class="emoji" src="//telegram.org/img/emoji/40/F09F918D.png" width="20" height="20" alt="👍">", "<img class="emoji" src="//telegram.org/img/emoji/40/F09F918E.png" width="20" height="20" alt="👎">", "<img class="emoji" src="//telegram.org/img/emoji/40/E29DA4.png" width="20" height="20" alt="❤">", "<img class="emoji" src="//telegram.org/img/emoji/40/F09F94A5.png" width="20" height="20" alt="🔥">", "<img class="emoji" src="//telegram.org/img/emoji/40/F09FA5B0.png" width="20" height="20" alt="🥰">", "<img class="emoji" src="//telegram.org/img/emoji/40/F09F918F.png" width="20" height="20" alt="👏">", "<img class="emoji" src="//telegram.org/img/emoji/40/F09F9881.png" width="20" height="20" alt="😁">", "<img class="emoji" src="//telegram.org/img/emoji/40/F09FA494.png" width="20" height="20" alt="🤔">", "<img class="emoji" src="//telegram.org/img/emoji/40/F09FA4AF.png" width="20" height="20" alt="🤯">", "<img class="emoji" src="//telegram.org/img/emoji/40/F09F98B1.png" width="20" height="20" alt="😱">", "<img class="emoji" src="//telegram.org/img/emoji/40/F09FA4AC.png" width="20" height="20" alt="🤬">", "<img class="emoji" src="//telegram.org/img/emoji/40/F09F98A2.png" width="20" height="20" alt="😢">", "<img class="emoji" src="//telegram.org/img/emoji/40/F09F8E89.png" width="20" height="20" alt="🎉">", "<img class="emoji" src="//telegram.org/img/emoji/40/F09FA4A9.png" width="20" height="20" alt="🤩">", "<img class="emoji" src="//telegram.org/img/emoji/40/F09FA4AE.png" width="20" height="20" alt="🤮">", "<img class="emoji" src="//telegram.org/img/emoji/40/F09F92A9.png" width="20" height="20" alt="💩">", "<img class="emoji" src="//telegram.org/img/emoji/40/F09F998F.png" width="20" height="20" alt="🙏">", "<img class="emoji" src="//telegram.org/img/emoji/40/F09F918C.png" width="20" height="20" alt="👌">", "<img class="emoji" src="//telegram.org/img/emoji/40/F09F958A.png" width="20" height="20" alt="🕊">", "<img class="emoji" src="//telegram.org/img/emoji/40/F09FA4A1.png" width="20" height="20" alt="🤡">", "<img class="emoji" src="//telegram.org/img/emoji/40/F09FA5B1.png" width="20" height="20" alt="🥱">", "<img class="emoji" src="//telegram.org/img/emoji/40/F09FA5B4.png" width="20" height="20" alt="🥴">", "<img class="emoji" src="//telegram.org/img/emoji/40/F09F988D.png" width="20" height="20" alt="😍">", "<img class="emoji" src="//telegram.org/img/emoji/40/F09F90B3.png" width="20" height="20" alt="🐳">", "<img class="emoji" src="//telegram.org/img/emoji/40/E29DA4E2808DF09F94A5.png" width="20" height="20" alt="❤‍🔥">", "<img class="emoji" src="//telegram.org/img/emoji/40/F09F8C9A.png" width="20" height="20" alt="🌚">", "<img class="emoji" src="//telegram.org/img/emoji/40/F09F8CAD.png" width="20" height="20" alt="🌭">", "<img class="emoji" src="//telegram.org/img/emoji/40/F09F92AF.png" width="20" height="20" alt="💯">", "<img class="emoji" src="//telegram.org/img/emoji/40/F09FA4A3.png" width="20" height="20" alt="🤣">", "<img class="emoji" src="//telegram.org/img/emoji/40/E29AA1.png" width="20" height="20" alt="⚡">", "<img class="emoji" src="//telegram.org/img/emoji/40/F09F8D8C.png" width="20" height="20" alt="🍌">", "<img class="emoji" src="//telegram.org/img/emoji/40/F09F8F86.png" width="20" height="20" alt="🏆">", "<img class="emoji" src="//telegram.org/img/emoji/40/F09F9294.png" width="20" height="20" alt="💔">", "<img class="emoji" src="//telegram.org/img/emoji/40/F09FA4A8.png" width="20" height="20" alt="🤨">", "<img class="emoji" src="//telegram.org/img/emoji/40/F09F9890.png" width="20" height="20" alt="😐">", "<img class="emoji" src="//telegram.org/img/emoji/40/F09F8D93.png" width="20" height="20" alt="🍓">", "<img class="emoji" src="//telegram.org/img/emoji/40/F09F8DBE.png" width="20" height="20" alt="🍾">", "<img class="emoji" src="//telegram.org/img/emoji/40/F09F928B.png" width="20" height="20" alt="💋">", "<img class="emoji" src="//telegram.org/img/emoji/40/F09F9695.png" width="20" height="20" alt="🖕">", "<img class="emoji" src="//telegram.org/img/emoji/40/F09F9888.png" width="20" height="20" alt="😈">", "<img class="emoji" src="//telegram.org/img/emoji/40/F09F98B4.png" width="20" height="20" alt="😴">", "<img class="emoji" src="//telegram.org/img/emoji/40/F09F98AD.png" width="20" height="20" alt="😭">", "<img class="emoji" src="//telegram.org/img/emoji/40/F09FA493.png" width="20" height="20" alt="🤓">", "<img class="emoji" src="//telegram.org/img/emoji/40/F09F91BB.png" width="20" height="20" alt="👻">", "<img class="emoji" src="//telegram.org/img/emoji/40/F09F91A8E2808DF09F92BB.png" width="20" height="20" alt="👨‍💻">", "<img class="emoji" src="//telegram.org/img/emoji/40/F09F9180.png" width="20" height="20" alt="👀">", "<img class="emoji" src="//telegram.org/img/emoji/40/F09F8E83.png" width="20" height="20" alt="🎃">", "<img class="emoji" src="//telegram.org/img/emoji/40/F09F9988.png" width="20" height="20" alt="🙈">", "<img class="emoji" src="//telegram.org/img/emoji/40/F09F9887.png" width="20" height="20" alt="😇">", "<img class="emoji" src="//telegram.org/img/emoji/40/F09F98A8.png" width="20" height="20" alt="😨">", "<img class="emoji" src="//telegram.org/img/emoji/40/F09FA49D.png" width="20" height="20" alt="🤝">", "<img class="emoji" src="//telegram.org/img/emoji/40/E29C8D.png" width="20" height="20" alt="✍">", "<img class="emoji" src="//telegram.org/img/emoji/40/F09FA497.png" width="20" height="20" alt="🤗">", "<img class="emoji" src="//telegram.org/img/emoji/40/F09FABA1.png" width="20" height="20" alt="🫡">", "<img class="emoji" src="//telegram.org/img/emoji/40/F09F8E85.png" width="20" height="20" alt="🎅">", "<img class="emoji" src="//telegram.org/img/emoji/40/F09F8E84.png" width="20" height="20" alt="🎄">", "<img class="emoji" src="//telegram.org/img/emoji/40/E29883.png" width="20" height="20" alt="☃">", "<img class="emoji" src="//telegram.org/img/emoji/40/F09F9285.png" width="20" height="20" alt="💅">", "<img class="emoji" src="//telegram.org/img/emoji/40/F09FA4AA.png" width="20" height="20" alt="🤪">", "<img class="emoji" src="//telegram.org/img/emoji/40/F09F97BF.png" width="20" height="20" alt="🗿">", "<img class="emoji" src="//telegram.org/img/emoji/40/F09F8692.png" width="20" height="20" alt="🆒">", "<img class="emoji" src="//telegram.org/img/emoji/40/F09F9298.png" width="20" height="20" alt="💘">", "<img class="emoji" src="//telegram.org/img/emoji/40/F09F9989.png" width="20" height="20" alt="🙉">", "<img class="emoji" src="//telegram.org/img/emoji/40/F09FA684.png" width="20" height="20" alt="🦄">", "<img class="emoji" src="//telegram.org/img/emoji/40/F09F9898.png" width="20" height="20" alt="😘">", "<img class="emoji" src="//telegram.org/img/emoji/40/F09F928A.png" width="20" height="20" alt="💊">", "<img class="emoji" src="//telegram.org/img/emoji/40/F09F998A.png" width="20" height="20" alt="🙊">", "<img class="emoji" src="//telegram.org/img/emoji/40/F09F988E.png" width="20" height="20" alt="😎">", "<img class="emoji" src="//telegram.org/img/emoji/40/F09F91BE.png" width="20" height="20" alt="👾">", "<img class="emoji" src="//telegram.org/img/emoji/40/F09FA4B7E2808DE29982.png" width="20" height="20" alt="🤷‍♂">", "<img class="emoji" src="//telegram.org/img/emoji/40/F09FA4B7.png" width="20" height="20" alt="🤷">", "<img class="emoji" src="//telegram.org/img/emoji/40/F09FA4B7E2808DE29980.png" width="20" height="20" alt="🤷‍♀">", "<img class="emoji" src="//telegram.org/img/emoji/40/F09F98A1.png" width="20" height="20" alt="😡">"
    pub emoji: String
}

/**
 * <p>The reaction is based on a custom emoji.</p>
 *
 * @property type Type of the reaction, always “custom_emoji”
 * @property custom_emoji_id Custom emoji identifier
 *
 * @constructor Creates a [ReactionTypeCustomEmoji].
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct ReactionTypeCustomEmoji {
    /// Type of the reaction, always “custom_emoji”
    #[serde(rename = "type")]
    pub type_: String,
    /// Custom emoji identifier
    pub custom_emoji_id: String
}

/**
 * <p>Represents a reaction added to a message along with the number of times it was added.</p>
 *
 * @property type Type of the reaction
 * @property total_count Number of times the reaction was added
 *
 * @constructor Creates a [ReactionCount].
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct ReactionCount {
    /// Type of the reaction
    #[serde(rename = "type")]
    pub type_: ReactionType,
    /// Number of times the reaction was added
    pub total_count: Integer
}

/**
 * <p>This object represents a change of a reaction on a message performed by a user.</p>
 *
 * @property chat The chat containing the message the user reacted to
 * @property message_id Unique identifier of the message inside the chat
 * @property user <em>Optional</em>. The user that changed the reaction, if the user isn't anonymous
 * @property actor_chat <em>Optional</em>. The chat on behalf of which the reaction was changed, if the user is anonymous
 * @property date Date of the change in Unix time
 * @property old_reaction Previous list of reaction types that were set by the user
 * @property new_reaction New list of reaction types that have been set by the user
 *
 * @constructor Creates a [MessageReactionUpdated].
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct MessageReactionUpdated {
    /// The chat containing the message the user reacted to
    pub chat: Chat,
    /// Unique identifier of the message inside the chat
    pub message_id: Integer,
    /// <em>Optional</em>. The user that changed the reaction, if the user isn't anonymous
    #[serde(skip_serializing_if = "Option::is_none")]
    pub user: Option<User>,
    /// <em>Optional</em>. The chat on behalf of which the reaction was changed, if the user is anonymous
    #[serde(skip_serializing_if = "Option::is_none")]
    pub actor_chat: Option<Chat>,
    /// Date of the change in Unix time
    pub date: Integer,
    /// Previous list of reaction types that were set by the user
    pub old_reaction: Vec<ReactionType>,
    /// New list of reaction types that have been set by the user
    pub new_reaction: Vec<ReactionType>
}

/**
 * <p>This object represents reaction changes on a message with anonymous reactions.</p>
 *
 * @property chat The chat containing the message
 * @property message_id Unique message identifier inside the chat
 * @property date Date of the change in Unix time
 * @property reactions List of reactions that are present on the message
 *
 * @constructor Creates a [MessageReactionCountUpdated].
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct MessageReactionCountUpdated {
    /// The chat containing the message
    pub chat: Chat,
    /// Unique message identifier inside the chat
    pub message_id: Integer,
    /// Date of the change in Unix time
    pub date: Integer,
    /// List of reactions that are present on the message
    pub reactions: Vec<ReactionCount>
}

/**
 * <p>This object represents a forum topic.</p>
 *
 * @property message_thread_id Unique identifier of the forum topic
 * @property name Name of the topic
 * @property icon_color Color of the topic icon in RGB format
 * @property icon_custom_emoji_id <em>Optional</em>. Unique identifier of the custom emoji shown as the topic icon
 *
 * @constructor Creates a [ForumTopic].
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct ForumTopic {
    /// Unique identifier of the forum topic
    pub message_thread_id: Integer,
    /// Name of the topic
    pub name: String,
    /// Color of the topic icon in RGB format
    pub icon_color: Integer,
    /// <em>Optional</em>. Unique identifier of the custom emoji shown as the topic icon
    #[serde(skip_serializing_if = "Option::is_none")]
    pub icon_custom_emoji_id: Option<String>
}

/**
 * <p>This object represents a bot command.</p>
 *
 * @property command Text of the command; 1-32 characters. Can contain only lowercase English letters, digits and underscores.
 * @property description Description of the command; 1-256 characters.
 *
 * @constructor Creates a [BotCommand].
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct BotCommand {
    /// Text of the command; 1-32 characters. Can contain only lowercase English letters, digits and underscores.
    pub command: String,
    /// Description of the command; 1-256 characters.
    pub description: String
}

/**
 * <p>Represents the default <a href="#botcommandscope">scope</a> of bot commands. Default commands are used if no commands with a <a href="#determining-list-of-commands">narrower scope</a> are specified for the user.</p>
 *
 * @property type Scope type, must be <em>default</em>
 *
 * @constructor Creates a [BotCommandScopeDefault].
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct BotCommandScopeDefault {
    /// Scope type, must be <em>default</em>
    #[serde(rename = "type")]
    pub type_: String
}

/**
 * <p>Represents the <a href="#botcommandscope">scope</a> of bot commands, covering all private chats.</p>
 *
 * @property type Scope type, must be <em>all_private_chats</em>
 *
 * @constructor Creates a [BotCommandScopeAllPrivateChats].
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct BotCommandScopeAllPrivateChats {
    /// Scope type, must be <em>all_private_chats</em>
    #[serde(rename = "type")]
    pub type_: String
}

/**
 * <p>Represents the <a href="#botcommandscope">scope</a> of bot commands, covering all group and supergroup chats.</p>
 *
 * @property type Scope type, must be <em>all_group_chats</em>
 *
 * @constructor Creates a [BotCommandScopeAllGroupChats].
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct BotCommandScopeAllGroupChats {
    /// Scope type, must be <em>all_group_chats</em>
    #[serde(rename = "type")]
    pub type_: String
}

/**
 * <p>Represents the <a href="#botcommandscope">scope</a> of bot commands, covering all group and supergroup chat administrators.</p>
 *
 * @property type Scope type, must be <em>all_chat_administrators</em>
 *
 * @constructor Creates a [BotCommandScopeAllChatAdministrators].
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct BotCommandScopeAllChatAdministrators {
    /// Scope type, must be <em>all_chat_administrators</em>
    #[serde(rename = "type")]
    pub type_: String
}

/**
 * <p>Represents the <a href="#botcommandscope">scope</a> of bot commands, covering a specific chat.</p>
 *
 * @property type Scope type, must be <em>chat</em>
 * @property chat_id Unique identifier for the target chat or username of the target supergroup (in the format <code>@supergroupusername</code>)
 *
 * @constructor Creates a [BotCommandScopeChat].
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct BotCommandScopeChat {
    /// Scope type, must be <em>chat</em>
    #[serde(rename = "type")]
    pub type_: String,
    /// Unique identifier for the target chat or username of the target supergroup (in the format <code>@supergroupusername</code>)
    pub chat_id: String
}

/**
 * <p>Represents the <a href="#botcommandscope">scope</a> of bot commands, covering all administrators of a specific group or supergroup chat.</p>
 *
 * @property type Scope type, must be <em>chat_administrators</em>
 * @property chat_id Unique identifier for the target chat or username of the target supergroup (in the format <code>@supergroupusername</code>)
 *
 * @constructor Creates a [BotCommandScopeChatAdministrators].
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct BotCommandScopeChatAdministrators {
    /// Scope type, must be <em>chat_administrators</em>
    #[serde(rename = "type")]
    pub type_: String,
    /// Unique identifier for the target chat or username of the target supergroup (in the format <code>@supergroupusername</code>)
    pub chat_id: String
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
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct BotCommandScopeChatMember {
    /// Scope type, must be <em>chat_member</em>
    #[serde(rename = "type")]
    pub type_: String,
    /// Unique identifier for the target chat or username of the target supergroup (in the format <code>@supergroupusername</code>)
    pub chat_id: String,
    /// Unique identifier of the target user
    pub user_id: Integer
}

/**
 * <p>This object represents the bot's name.</p>
 *
 * @property name The bot's name
 *
 * @constructor Creates a [BotName].
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct BotName {
    /// The bot's name
    pub name: String
}

/**
 * <p>This object represents the bot's description.</p>
 *
 * @property description The bot's description
 *
 * @constructor Creates a [BotDescription].
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct BotDescription {
    /// The bot's description
    pub description: String
}

/**
 * <p>This object represents the bot's short description.</p>
 *
 * @property short_description The bot's short description
 *
 * @constructor Creates a [BotShortDescription].
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct BotShortDescription {
    /// The bot's short description
    pub short_description: String
}

/**
 * <p>Represents a menu button, which opens the bot's list of commands.</p>
 *
 * @property type Type of the button, must be <em>commands</em>
 *
 * @constructor Creates a [MenuButtonCommands].
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct MenuButtonCommands {
    /// Type of the button, must be <em>commands</em>
    #[serde(rename = "type")]
    pub type_: String
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
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct MenuButtonWebApp {
    /// Type of the button, must be <em>web_app</em>
    #[serde(rename = "type")]
    pub type_: String,
    /// Text on the button
    pub text: String,
    /// Description of the Web App that will be launched when the user presses the button. The Web App will be able to send an arbitrary message on behalf of the user using the method <a href="#answerwebappquery">answerWebAppQuery</a>.
    pub web_app: WebAppInfo
}

/**
 * <p>Describes that no specific value for the menu button was set.</p>
 *
 * @property type Type of the button, must be <em>default</em>
 *
 * @constructor Creates a [MenuButtonDefault].
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct MenuButtonDefault {
    /// Type of the button, must be <em>default</em>
    #[serde(rename = "type")]
    pub type_: String
}

/**
 * <p>The boost was obtained by subscribing to Telegram Premium or by gifting a Telegram Premium subscription to another user.</p>
 *
 * @property source Source of the boost, always “premium”
 * @property user User that boosted the chat
 *
 * @constructor Creates a [ChatBoostSourcePremium].
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct ChatBoostSourcePremium {
    /// Source of the boost, always “premium”
    pub source: String,
    /// User that boosted the chat
    pub user: User
}

/**
 * <p>The boost was obtained by the creation of Telegram Premium gift codes to boost a chat. Each such code boosts the chat 4 times for the duration of the corresponding Telegram Premium subscription.</p>
 *
 * @property source Source of the boost, always “gift_code”
 * @property user User for which the gift code was created
 *
 * @constructor Creates a [ChatBoostSourceGiftCode].
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct ChatBoostSourceGiftCode {
    /// Source of the boost, always “gift_code”
    pub source: String,
    /// User for which the gift code was created
    pub user: User
}

/**
 * <p>The boost was obtained by the creation of a Telegram Premium giveaway. This boosts the chat 4 times for the duration of the corresponding Telegram Premium subscription.</p>
 *
 * @property source Source of the boost, always “giveaway”
 * @property giveaway_message_id Identifier of a message in the chat with the giveaway; the message could have been deleted already. May be 0 if the message isn't sent yet.
 * @property user <em>Optional</em>. User that won the prize in the giveaway if any
 * @property is_unclaimed <em>Optional</em>. True, if the giveaway was completed, but there was no user to win the prize
 *
 * @constructor Creates a [ChatBoostSourceGiveaway].
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct ChatBoostSourceGiveaway {
    /// Source of the boost, always “giveaway”
    pub source: String,
    /// Identifier of a message in the chat with the giveaway; the message could have been deleted already. May be 0 if the message isn't sent yet.
    pub giveaway_message_id: Integer,
    /// <em>Optional</em>. User that won the prize in the giveaway if any
    #[serde(skip_serializing_if = "Option::is_none")]
    pub user: Option<User>,
    /// <em>Optional</em>. True, if the giveaway was completed, but there was no user to win the prize
    #[serde(skip_serializing_if = "Option::is_none")]
    pub is_unclaimed: Option<bool>
}

/**
 * <p>This object contains information about a chat boost.</p>
 *
 * @property boost_id Unique identifier of the boost
 * @property add_date Point in time (Unix timestamp) when the chat was boosted
 * @property expiration_date Point in time (Unix timestamp) when the boost will automatically expire, unless the booster's Telegram Premium subscription is prolonged
 * @property source Source of the added boost
 *
 * @constructor Creates a [ChatBoost].
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct ChatBoost {
    /// Unique identifier of the boost
    pub boost_id: String,
    /// Point in time (Unix timestamp) when the chat was boosted
    pub add_date: Integer,
    /// Point in time (Unix timestamp) when the boost will automatically expire, unless the booster's Telegram Premium subscription is prolonged
    pub expiration_date: Integer,
    /// Source of the added boost
    pub source: ChatBoostSource
}

/**
 * <p>This object represents a boost added to a chat or changed.</p>
 *
 * @property chat Chat which was boosted
 * @property boost Information about the chat boost
 *
 * @constructor Creates a [ChatBoostUpdated].
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct ChatBoostUpdated {
    /// Chat which was boosted
    pub chat: Chat,
    /// Information about the chat boost
    pub boost: ChatBoost
}

/**
 * <p>This object represents a boost removed from a chat.</p>
 *
 * @property chat Chat which was boosted
 * @property boost_id Unique identifier of the boost
 * @property remove_date Point in time (Unix timestamp) when the boost was removed
 * @property source Source of the removed boost
 *
 * @constructor Creates a [ChatBoostRemoved].
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct ChatBoostRemoved {
    /// Chat which was boosted
    pub chat: Chat,
    /// Unique identifier of the boost
    pub boost_id: String,
    /// Point in time (Unix timestamp) when the boost was removed
    pub remove_date: Integer,
    /// Source of the removed boost
    pub source: ChatBoostSource
}

/**
 * <p>This object represents a list of boosts added to a chat by a user.</p>
 *
 * @property boosts The list of boosts added to the chat by the user
 *
 * @constructor Creates a [UserChatBoosts].
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct UserChatBoosts {
    /// The list of boosts added to the chat by the user
    pub boosts: Vec<ChatBoost>
}

/**
 * <p>Describes the connection of the bot with a business account.</p>
 *
 * @property id Unique identifier of the business connection
 * @property user Business account user that created the business connection
 * @property user_chat_id Identifier of a private chat with the user who created the business connection. This number may have more than 32 significant bits and some programming languages may have difficulty/silent defects in interpreting it. But it has at most 52 significant bits, so a 64-bit integer or double-precision float type are safe for storing this identifier.
 * @property date Date the connection was established in Unix time
 * @property can_reply True, if the bot can act on behalf of the business account in chats that were active in the last 24 hours
 * @property is_enabled True, if the connection is active
 *
 * @constructor Creates a [BusinessConnection].
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct BusinessConnection {
    /// Unique identifier of the business connection
    pub id: String,
    /// Business account user that created the business connection
    pub user: User,
    /// Identifier of a private chat with the user who created the business connection. This number may have more than 32 significant bits and some programming languages may have difficulty/silent defects in interpreting it. But it has at most 52 significant bits, so a 64-bit integer or double-precision float type are safe for storing this identifier.
    pub user_chat_id: Integer,
    /// Date the connection was established in Unix time
    pub date: Integer,
    /// True, if the bot can act on behalf of the business account in chats that were active in the last 24 hours
    pub can_reply: bool,
    /// True, if the connection is active
    pub is_enabled: bool
}

/**
 * <p>This object is received when messages are deleted from a connected business account.</p>
 *
 * @property business_connection_id Unique identifier of the business connection
 * @property chat Information about a chat in the business account. The bot may not have access to the chat or the corresponding user.
 * @property message_ids The list of identifiers of deleted messages in the chat of the business account
 *
 * @constructor Creates a [BusinessMessagesDeleted].
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct BusinessMessagesDeleted {
    /// Unique identifier of the business connection
    pub business_connection_id: String,
    /// Information about a chat in the business account. The bot may not have access to the chat or the corresponding user.
    pub chat: Chat,
    /// The list of identifiers of deleted messages in the chat of the business account
    pub message_ids: Vec<Integer>
}

/**
 * <p>Describes why a request was unsuccessful.</p>
 *
 * @property migrate_to_chat_id <em>Optional</em>. The group has been migrated to a supergroup with the specified identifier. This number may have more than 32 significant bits and some programming languages may have difficulty/silent defects in interpreting it. But it has at most 52 significant bits, so a signed 64-bit integer or double-precision float type are safe for storing this identifier.
 * @property retry_after <em>Optional</em>. In case of exceeding flood control, the number of seconds left to wait before the request can be repeated
 *
 * @constructor Creates a [ResponseParameters].
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct ResponseParameters {
    /// <em>Optional</em>. The group has been migrated to a supergroup with the specified identifier. This number may have more than 32 significant bits and some programming languages may have difficulty/silent defects in interpreting it. But it has at most 52 significant bits, so a signed 64-bit integer or double-precision float type are safe for storing this identifier.
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
 * @property media File to send. Pass a file_id to send a file that exists on the Telegram servers (recommended), pass an HTTP URL for Telegram to get a file from the Internet, or pass “attach://&lt;file_attach_name&gt;” to upload a new one using multipart/form-data under &lt;file_attach_name&gt; name. <a href="#sending-files">More information on Sending Files »</a>
 * @property caption <em>Optional</em>. Caption of the photo to be sent, 0-1024 characters after entities parsing
 * @property parse_mode <em>Optional</em>. Mode for parsing entities in the photo caption. See <a href="#formatting-options">formatting options</a> for more details.
 * @property caption_entities <em>Optional</em>. List of special entities that appear in the caption, which can be specified instead of <em>parse_mode</em>
 * @property show_caption_above_media <em>Optional</em>. Pass <em>True</em>, if the caption must be shown above the message media
 * @property has_spoiler <em>Optional</em>. Pass <em>True</em> if the photo needs to be covered with a spoiler animation
 *
 * @constructor Creates a [InputMediaPhoto].
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct InputMediaPhoto {
    /// Type of the result, must be <em>photo</em>
    #[serde(rename = "type")]
    pub type_: String,
    /// File to send. Pass a file_id to send a file that exists on the Telegram servers (recommended), pass an HTTP URL for Telegram to get a file from the Internet, or pass “attach://&lt;file_attach_name&gt;” to upload a new one using multipart/form-data under &lt;file_attach_name&gt; name. <a href="#sending-files">More information on Sending Files »</a>
    pub media: String,
    /// <em>Optional</em>. Caption of the photo to be sent, 0-1024 characters after entities parsing
    #[serde(skip_serializing_if = "Option::is_none")]
    pub caption: Option<String>,
    /// <em>Optional</em>. Mode for parsing entities in the photo caption. See <a href="#formatting-options">formatting options</a> for more details.
    #[serde(skip_serializing_if = "Option::is_none")]
    pub parse_mode: Option<ParseMode>,
    /// <em>Optional</em>. List of special entities that appear in the caption, which can be specified instead of <em>parse_mode</em>
    #[serde(skip_serializing_if = "Option::is_none")]
    pub caption_entities: Option<Vec<MessageEntity>>,
    /// <em>Optional</em>. Pass <em>True</em>, if the caption must be shown above the message media
    #[serde(skip_serializing_if = "Option::is_none")]
    pub show_caption_above_media: Option<bool>,
    /// <em>Optional</em>. Pass <em>True</em> if the photo needs to be covered with a spoiler animation
    #[serde(skip_serializing_if = "Option::is_none")]
    pub has_spoiler: Option<bool>
}

/**
 * <p>Represents a video to be sent.</p>
 *
 * @property type Type of the result, must be <em>video</em>
 * @property media File to send. Pass a file_id to send a file that exists on the Telegram servers (recommended), pass an HTTP URL for Telegram to get a file from the Internet, or pass “attach://&lt;file_attach_name&gt;” to upload a new one using multipart/form-data under &lt;file_attach_name&gt; name. <a href="#sending-files">More information on Sending Files »</a>
 * @property thumbnail <em>Optional</em>. Thumbnail of the file sent; can be ignored if thumbnail generation for the file is supported server-side. The thumbnail should be in JPEG format and less than 200 kB in size. A thumbnail's width and height should not exceed 320. Ignored if the file is not uploaded using multipart/form-data. Thumbnails can't be reused and can be only uploaded as a new file, so you can pass “attach://&lt;file_attach_name&gt;” if the thumbnail was uploaded using multipart/form-data under &lt;file_attach_name&gt;. <a href="#sending-files">More information on Sending Files »</a>
 * @property caption <em>Optional</em>. Caption of the video to be sent, 0-1024 characters after entities parsing
 * @property parse_mode <em>Optional</em>. Mode for parsing entities in the video caption. See <a href="#formatting-options">formatting options</a> for more details.
 * @property caption_entities <em>Optional</em>. List of special entities that appear in the caption, which can be specified instead of <em>parse_mode</em>
 * @property show_caption_above_media <em>Optional</em>. Pass <em>True</em>, if the caption must be shown above the message media
 * @property width <em>Optional</em>. Video width
 * @property height <em>Optional</em>. Video height
 * @property duration <em>Optional</em>. Video duration in seconds
 * @property supports_streaming <em>Optional</em>. Pass <em>True</em> if the uploaded video is suitable for streaming
 * @property has_spoiler <em>Optional</em>. Pass <em>True</em> if the video needs to be covered with a spoiler animation
 *
 * @constructor Creates a [InputMediaVideo].
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct InputMediaVideo {
    /// Type of the result, must be <em>video</em>
    #[serde(rename = "type")]
    pub type_: String,
    /// File to send. Pass a file_id to send a file that exists on the Telegram servers (recommended), pass an HTTP URL for Telegram to get a file from the Internet, or pass “attach://&lt;file_attach_name&gt;” to upload a new one using multipart/form-data under &lt;file_attach_name&gt; name. <a href="#sending-files">More information on Sending Files »</a>
    pub media: String,
    /// <em>Optional</em>. Thumbnail of the file sent; can be ignored if thumbnail generation for the file is supported server-side. The thumbnail should be in JPEG format and less than 200 kB in size. A thumbnail's width and height should not exceed 320. Ignored if the file is not uploaded using multipart/form-data. Thumbnails can't be reused and can be only uploaded as a new file, so you can pass “attach://&lt;file_attach_name&gt;” if the thumbnail was uploaded using multipart/form-data under &lt;file_attach_name&gt;. <a href="#sending-files">More information on Sending Files »</a>
    #[serde(skip_serializing_if = "Option::is_none")]
    pub thumbnail: Option<String>,
    /// <em>Optional</em>. Caption of the video to be sent, 0-1024 characters after entities parsing
    #[serde(skip_serializing_if = "Option::is_none")]
    pub caption: Option<String>,
    /// <em>Optional</em>. Mode for parsing entities in the video caption. See <a href="#formatting-options">formatting options</a> for more details.
    #[serde(skip_serializing_if = "Option::is_none")]
    pub parse_mode: Option<ParseMode>,
    /// <em>Optional</em>. List of special entities that appear in the caption, which can be specified instead of <em>parse_mode</em>
    #[serde(skip_serializing_if = "Option::is_none")]
    pub caption_entities: Option<Vec<MessageEntity>>,
    /// <em>Optional</em>. Pass <em>True</em>, if the caption must be shown above the message media
    #[serde(skip_serializing_if = "Option::is_none")]
    pub show_caption_above_media: Option<bool>,
    /// <em>Optional</em>. Video width
    #[serde(skip_serializing_if = "Option::is_none")]
    pub width: Option<Integer>,
    /// <em>Optional</em>. Video height
    #[serde(skip_serializing_if = "Option::is_none")]
    pub height: Option<Integer>,
    /// <em>Optional</em>. Video duration in seconds
    #[serde(skip_serializing_if = "Option::is_none")]
    pub duration: Option<Integer>,
    /// <em>Optional</em>. Pass <em>True</em> if the uploaded video is suitable for streaming
    #[serde(skip_serializing_if = "Option::is_none")]
    pub supports_streaming: Option<bool>,
    /// <em>Optional</em>. Pass <em>True</em> if the video needs to be covered with a spoiler animation
    #[serde(skip_serializing_if = "Option::is_none")]
    pub has_spoiler: Option<bool>
}

/**
 * <p>Represents an animation file (GIF or H.264/MPEG-4 AVC video without sound) to be sent.</p>
 *
 * @property type Type of the result, must be <em>animation</em>
 * @property media File to send. Pass a file_id to send a file that exists on the Telegram servers (recommended), pass an HTTP URL for Telegram to get a file from the Internet, or pass “attach://&lt;file_attach_name&gt;” to upload a new one using multipart/form-data under &lt;file_attach_name&gt; name. <a href="#sending-files">More information on Sending Files »</a>
 * @property thumbnail <em>Optional</em>. Thumbnail of the file sent; can be ignored if thumbnail generation for the file is supported server-side. The thumbnail should be in JPEG format and less than 200 kB in size. A thumbnail's width and height should not exceed 320. Ignored if the file is not uploaded using multipart/form-data. Thumbnails can't be reused and can be only uploaded as a new file, so you can pass “attach://&lt;file_attach_name&gt;” if the thumbnail was uploaded using multipart/form-data under &lt;file_attach_name&gt;. <a href="#sending-files">More information on Sending Files »</a>
 * @property caption <em>Optional</em>. Caption of the animation to be sent, 0-1024 characters after entities parsing
 * @property parse_mode <em>Optional</em>. Mode for parsing entities in the animation caption. See <a href="#formatting-options">formatting options</a> for more details.
 * @property caption_entities <em>Optional</em>. List of special entities that appear in the caption, which can be specified instead of <em>parse_mode</em>
 * @property show_caption_above_media <em>Optional</em>. Pass <em>True</em>, if the caption must be shown above the message media
 * @property width <em>Optional</em>. Animation width
 * @property height <em>Optional</em>. Animation height
 * @property duration <em>Optional</em>. Animation duration in seconds
 * @property has_spoiler <em>Optional</em>. Pass <em>True</em> if the animation needs to be covered with a spoiler animation
 *
 * @constructor Creates a [InputMediaAnimation].
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct InputMediaAnimation {
    /// Type of the result, must be <em>animation</em>
    #[serde(rename = "type")]
    pub type_: String,
    /// File to send. Pass a file_id to send a file that exists on the Telegram servers (recommended), pass an HTTP URL for Telegram to get a file from the Internet, or pass “attach://&lt;file_attach_name&gt;” to upload a new one using multipart/form-data under &lt;file_attach_name&gt; name. <a href="#sending-files">More information on Sending Files »</a>
    pub media: String,
    /// <em>Optional</em>. Thumbnail of the file sent; can be ignored if thumbnail generation for the file is supported server-side. The thumbnail should be in JPEG format and less than 200 kB in size. A thumbnail's width and height should not exceed 320. Ignored if the file is not uploaded using multipart/form-data. Thumbnails can't be reused and can be only uploaded as a new file, so you can pass “attach://&lt;file_attach_name&gt;” if the thumbnail was uploaded using multipart/form-data under &lt;file_attach_name&gt;. <a href="#sending-files">More information on Sending Files »</a>
    #[serde(skip_serializing_if = "Option::is_none")]
    pub thumbnail: Option<String>,
    /// <em>Optional</em>. Caption of the animation to be sent, 0-1024 characters after entities parsing
    #[serde(skip_serializing_if = "Option::is_none")]
    pub caption: Option<String>,
    /// <em>Optional</em>. Mode for parsing entities in the animation caption. See <a href="#formatting-options">formatting options</a> for more details.
    #[serde(skip_serializing_if = "Option::is_none")]
    pub parse_mode: Option<ParseMode>,
    /// <em>Optional</em>. List of special entities that appear in the caption, which can be specified instead of <em>parse_mode</em>
    #[serde(skip_serializing_if = "Option::is_none")]
    pub caption_entities: Option<Vec<MessageEntity>>,
    /// <em>Optional</em>. Pass <em>True</em>, if the caption must be shown above the message media
    #[serde(skip_serializing_if = "Option::is_none")]
    pub show_caption_above_media: Option<bool>,
    /// <em>Optional</em>. Animation width
    #[serde(skip_serializing_if = "Option::is_none")]
    pub width: Option<Integer>,
    /// <em>Optional</em>. Animation height
    #[serde(skip_serializing_if = "Option::is_none")]
    pub height: Option<Integer>,
    /// <em>Optional</em>. Animation duration in seconds
    #[serde(skip_serializing_if = "Option::is_none")]
    pub duration: Option<Integer>,
    /// <em>Optional</em>. Pass <em>True</em> if the animation needs to be covered with a spoiler animation
    #[serde(skip_serializing_if = "Option::is_none")]
    pub has_spoiler: Option<bool>
}

/**
 * <p>Represents an audio file to be treated as music to be sent.</p>
 *
 * @property type Type of the result, must be <em>audio</em>
 * @property media File to send. Pass a file_id to send a file that exists on the Telegram servers (recommended), pass an HTTP URL for Telegram to get a file from the Internet, or pass “attach://&lt;file_attach_name&gt;” to upload a new one using multipart/form-data under &lt;file_attach_name&gt; name. <a href="#sending-files">More information on Sending Files »</a>
 * @property thumbnail <em>Optional</em>. Thumbnail of the file sent; can be ignored if thumbnail generation for the file is supported server-side. The thumbnail should be in JPEG format and less than 200 kB in size. A thumbnail's width and height should not exceed 320. Ignored if the file is not uploaded using multipart/form-data. Thumbnails can't be reused and can be only uploaded as a new file, so you can pass “attach://&lt;file_attach_name&gt;” if the thumbnail was uploaded using multipart/form-data under &lt;file_attach_name&gt;. <a href="#sending-files">More information on Sending Files »</a>
 * @property caption <em>Optional</em>. Caption of the audio to be sent, 0-1024 characters after entities parsing
 * @property parse_mode <em>Optional</em>. Mode for parsing entities in the audio caption. See <a href="#formatting-options">formatting options</a> for more details.
 * @property caption_entities <em>Optional</em>. List of special entities that appear in the caption, which can be specified instead of <em>parse_mode</em>
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
    /// File to send. Pass a file_id to send a file that exists on the Telegram servers (recommended), pass an HTTP URL for Telegram to get a file from the Internet, or pass “attach://&lt;file_attach_name&gt;” to upload a new one using multipart/form-data under &lt;file_attach_name&gt; name. <a href="#sending-files">More information on Sending Files »</a>
    pub media: String,
    /// <em>Optional</em>. Thumbnail of the file sent; can be ignored if thumbnail generation for the file is supported server-side. The thumbnail should be in JPEG format and less than 200 kB in size. A thumbnail's width and height should not exceed 320. Ignored if the file is not uploaded using multipart/form-data. Thumbnails can't be reused and can be only uploaded as a new file, so you can pass “attach://&lt;file_attach_name&gt;” if the thumbnail was uploaded using multipart/form-data under &lt;file_attach_name&gt;. <a href="#sending-files">More information on Sending Files »</a>
    #[serde(skip_serializing_if = "Option::is_none")]
    pub thumbnail: Option<String>,
    /// <em>Optional</em>. Caption of the audio to be sent, 0-1024 characters after entities parsing
    #[serde(skip_serializing_if = "Option::is_none")]
    pub caption: Option<String>,
    /// <em>Optional</em>. Mode for parsing entities in the audio caption. See <a href="#formatting-options">formatting options</a> for more details.
    #[serde(skip_serializing_if = "Option::is_none")]
    pub parse_mode: Option<ParseMode>,
    /// <em>Optional</em>. List of special entities that appear in the caption, which can be specified instead of <em>parse_mode</em>
    #[serde(skip_serializing_if = "Option::is_none")]
    pub caption_entities: Option<Vec<MessageEntity>>,
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
 * @property media File to send. Pass a file_id to send a file that exists on the Telegram servers (recommended), pass an HTTP URL for Telegram to get a file from the Internet, or pass “attach://&lt;file_attach_name&gt;” to upload a new one using multipart/form-data under &lt;file_attach_name&gt; name. <a href="#sending-files">More information on Sending Files »</a>
 * @property thumbnail <em>Optional</em>. Thumbnail of the file sent; can be ignored if thumbnail generation for the file is supported server-side. The thumbnail should be in JPEG format and less than 200 kB in size. A thumbnail's width and height should not exceed 320. Ignored if the file is not uploaded using multipart/form-data. Thumbnails can't be reused and can be only uploaded as a new file, so you can pass “attach://&lt;file_attach_name&gt;” if the thumbnail was uploaded using multipart/form-data under &lt;file_attach_name&gt;. <a href="#sending-files">More information on Sending Files »</a>
 * @property caption <em>Optional</em>. Caption of the document to be sent, 0-1024 characters after entities parsing
 * @property parse_mode <em>Optional</em>. Mode for parsing entities in the document caption. See <a href="#formatting-options">formatting options</a> for more details.
 * @property caption_entities <em>Optional</em>. List of special entities that appear in the caption, which can be specified instead of <em>parse_mode</em>
 * @property disable_content_type_detection <em>Optional</em>. Disables automatic server-side content type detection for files uploaded using multipart/form-data. Always <em>True</em>, if the document is sent as part of an album.
 *
 * @constructor Creates a [InputMediaDocument].
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct InputMediaDocument {
    /// Type of the result, must be <em>document</em>
    #[serde(rename = "type")]
    pub type_: String,
    /// File to send. Pass a file_id to send a file that exists on the Telegram servers (recommended), pass an HTTP URL for Telegram to get a file from the Internet, or pass “attach://&lt;file_attach_name&gt;” to upload a new one using multipart/form-data under &lt;file_attach_name&gt; name. <a href="#sending-files">More information on Sending Files »</a>
    pub media: String,
    /// <em>Optional</em>. Thumbnail of the file sent; can be ignored if thumbnail generation for the file is supported server-side. The thumbnail should be in JPEG format and less than 200 kB in size. A thumbnail's width and height should not exceed 320. Ignored if the file is not uploaded using multipart/form-data. Thumbnails can't be reused and can be only uploaded as a new file, so you can pass “attach://&lt;file_attach_name&gt;” if the thumbnail was uploaded using multipart/form-data under &lt;file_attach_name&gt;. <a href="#sending-files">More information on Sending Files »</a>
    #[serde(skip_serializing_if = "Option::is_none")]
    pub thumbnail: Option<String>,
    /// <em>Optional</em>. Caption of the document to be sent, 0-1024 characters after entities parsing
    #[serde(skip_serializing_if = "Option::is_none")]
    pub caption: Option<String>,
    /// <em>Optional</em>. Mode for parsing entities in the document caption. See <a href="#formatting-options">formatting options</a> for more details.
    #[serde(skip_serializing_if = "Option::is_none")]
    pub parse_mode: Option<ParseMode>,
    /// <em>Optional</em>. List of special entities that appear in the caption, which can be specified instead of <em>parse_mode</em>
    #[serde(skip_serializing_if = "Option::is_none")]
    pub caption_entities: Option<Vec<MessageEntity>>,
    /// <em>Optional</em>. Disables automatic server-side content type detection for files uploaded using multipart/form-data. Always <em>True</em>, if the document is sent as part of an album.
    #[serde(skip_serializing_if = "Option::is_none")]
    pub disable_content_type_detection: Option<bool>
}


/// Stickers

/**
 * <p>This object represents a sticker.</p>
 *
 * @property file_id Identifier for this file, which can be used to download or reuse the file
 * @property file_unique_id Unique identifier for this file, which is supposed to be the same over time and for different bots. Can't be used to download or reuse the file.
 * @property type Type of the sticker, currently one of “regular”, “mask”, “custom_emoji”. The type of the sticker is independent from its format, which is determined by the fields <em>is_animated</em> and <em>is_video</em>.
 * @property width Sticker width
 * @property height Sticker height
 * @property is_animated <em>True</em>, if the sticker is <a href="https://telegram.org/blog/animated-stickers">animated</a>
 * @property is_video <em>True</em>, if the sticker is a <a href="https://telegram.org/blog/video-stickers-better-reactions">video sticker</a>
 * @property thumbnail <em>Optional</em>. Sticker thumbnail in the .WEBP or .JPG format
 * @property emoji <em>Optional</em>. Emoji associated with the sticker
 * @property set_name <em>Optional</em>. Name of the sticker set to which the sticker belongs
 * @property premium_animation <em>Optional</em>. For premium regular stickers, premium animation for the sticker
 * @property mask_position <em>Optional</em>. For mask stickers, the position where the mask should be placed
 * @property custom_emoji_id <em>Optional</em>. For custom emoji stickers, unique identifier of the custom emoji
 * @property needs_repainting <em>Optional</em>. <em>True</em>, if the sticker must be repainted to a text color in messages, the color of the Telegram Premium badge in emoji status, white color on chat photos, or another appropriate color in other places
 * @property file_size <em>Optional</em>. File size in bytes
 *
 * @constructor Creates a [Sticker].
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct Sticker {
    /// Identifier for this file, which can be used to download or reuse the file
    pub file_id: String,
    /// Unique identifier for this file, which is supposed to be the same over time and for different bots. Can't be used to download or reuse the file.
    pub file_unique_id: String,
    /// Type of the sticker, currently one of “regular”, “mask”, “custom_emoji”. The type of the sticker is independent from its format, which is determined by the fields <em>is_animated</em> and <em>is_video</em>.
    #[serde(rename = "type")]
    pub type_: String,
    /// Sticker width
    pub width: Integer,
    /// Sticker height
    pub height: Integer,
    /// <em>True</em>, if the sticker is <a href="https://telegram.org/blog/animated-stickers">animated</a>
    pub is_animated: bool,
    /// <em>True</em>, if the sticker is a <a href="https://telegram.org/blog/video-stickers-better-reactions">video sticker</a>
    pub is_video: bool,
    /// <em>Optional</em>. Sticker thumbnail in the .WEBP or .JPG format
    #[serde(skip_serializing_if = "Option::is_none")]
    pub thumbnail: Option<PhotoSize>,
    /// <em>Optional</em>. Emoji associated with the sticker
    #[serde(skip_serializing_if = "Option::is_none")]
    pub emoji: Option<String>,
    /// <em>Optional</em>. Name of the sticker set to which the sticker belongs
    #[serde(skip_serializing_if = "Option::is_none")]
    pub set_name: Option<String>,
    /// <em>Optional</em>. For premium regular stickers, premium animation for the sticker
    #[serde(skip_serializing_if = "Option::is_none")]
    pub premium_animation: Option<File>,
    /// <em>Optional</em>. For mask stickers, the position where the mask should be placed
    #[serde(skip_serializing_if = "Option::is_none")]
    pub mask_position: Option<MaskPosition>,
    /// <em>Optional</em>. For custom emoji stickers, unique identifier of the custom emoji
    #[serde(skip_serializing_if = "Option::is_none")]
    pub custom_emoji_id: Option<String>,
    /// <em>Optional</em>. <em>True</em>, if the sticker must be repainted to a text color in messages, the color of the Telegram Premium badge in emoji status, white color on chat photos, or another appropriate color in other places
    #[serde(skip_serializing_if = "Option::is_none")]
    pub needs_repainting: Option<bool>,
    /// <em>Optional</em>. File size in bytes
    #[serde(skip_serializing_if = "Option::is_none")]
    pub file_size: Option<Integer>
}

/**
 * <p>This object represents a sticker set.</p>
 *
 * @property name Sticker set name
 * @property title Sticker set title
 * @property sticker_type Type of stickers in the set, currently one of “regular”, “mask”, “custom_emoji”
 * @property stickers List of all set stickers
 * @property thumbnail <em>Optional</em>. Sticker set thumbnail in the .WEBP, .TGS, or .WEBM format
 *
 * @constructor Creates a [StickerSet].
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct StickerSet {
    /// Sticker set name
    pub name: String,
    /// Sticker set title
    pub title: String,
    /// Type of stickers in the set, currently one of “regular”, “mask”, “custom_emoji”
    pub sticker_type: String,
    /// List of all set stickers
    pub stickers: Vec<Sticker>,
    /// <em>Optional</em>. Sticker set thumbnail in the .WEBP, .TGS, or .WEBM format
    #[serde(skip_serializing_if = "Option::is_none")]
    pub thumbnail: Option<PhotoSize>
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

/**
 * <p>This object describes a sticker to be added to a sticker set.</p>
 *
 * @property sticker The added sticker. Pass a <em>file_id</em> as a String to send a file that already exists on the Telegram servers, pass an HTTP URL as a String for Telegram to get a file from the Internet, upload a new one using multipart/form-data, or pass “attach://&lt;file_attach_name&gt;” to upload a new one using multipart/form-data under &lt;file_attach_name&gt; name. Animated and video stickers can't be uploaded via HTTP URL. <a href="#sending-files">More information on Sending Files »</a>
 * @property format Format of the added sticker, must be one of “static” for a <strong>.WEBP</strong> or <strong>.PNG</strong> image, “animated” for a <strong>.TGS</strong> animation, “video” for a <strong>WEBM</strong> video
 * @property emoji_list List of 1-20 emoji associated with the sticker
 * @property mask_position <em>Optional</em>. Position where the mask should be placed on faces. For “mask” stickers only.
 * @property keywords <em>Optional</em>. List of 0-20 search keywords for the sticker with total length of up to 64 characters. For “regular” and “custom_emoji” stickers only.
 *
 * @constructor Creates a [InputSticker].
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct InputSticker {
    /// The added sticker. Pass a <em>file_id</em> as a String to send a file that already exists on the Telegram servers, pass an HTTP URL as a String for Telegram to get a file from the Internet, upload a new one using multipart/form-data, or pass “attach://&lt;file_attach_name&gt;” to upload a new one using multipart/form-data under &lt;file_attach_name&gt; name. Animated and video stickers can't be uploaded via HTTP URL. <a href="#sending-files">More information on Sending Files »</a>
    pub sticker: String,
    /// Format of the added sticker, must be one of “static” for a <strong>.WEBP</strong> or <strong>.PNG</strong> image, “animated” for a <strong>.TGS</strong> animation, “video” for a <strong>WEBM</strong> video
    pub format: String,
    /// List of 1-20 emoji associated with the sticker
    pub emoji_list: Vec<String>,
    /// <em>Optional</em>. Position where the mask should be placed on faces. For “mask” stickers only.
    #[serde(skip_serializing_if = "Option::is_none")]
    pub mask_position: Option<MaskPosition>,
    /// <em>Optional</em>. List of 0-20 search keywords for the sticker with total length of up to 64 characters. For “regular” and “custom_emoji” stickers only.
    #[serde(skip_serializing_if = "Option::is_none")]
    pub keywords: Option<Vec<String>>
}


/// Inline mode

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
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct InlineQuery {
    /// Unique identifier for this query
    pub id: String,
    /// Sender
    pub from: User,
    /// Text of the query (up to 256 characters)
    pub query: String,
    /// Offset of the results to be returned, can be controlled by the bot
    pub offset: String,
    /// <em>Optional</em>. Type of the chat from which the inline query was sent. Can be either “sender” for a private chat with the inline query sender, “private”, “group”, “supergroup”, or “channel”. The chat type should be always known for requests sent from official clients and most third-party clients, unless the request was sent from a secret chat
    #[serde(skip_serializing_if = "Option::is_none")]
    pub chat_type: Option<String>,
    /// <em>Optional</em>. Sender location, only for bots that request user location
    #[serde(skip_serializing_if = "Option::is_none")]
    pub location: Option<Location>
}

/**
 * <p>This object represents a button to be shown above inline query results. You <strong>must</strong> use exactly one of the optional fields.</p>
 *
 * @property text Label text on the button
 * @property web_app <em>Optional</em>. Description of the <a href="/bots/webapps">Web App</a> that will be launched when the user presses the button. The Web App will be able to switch back to the inline mode using the method <a href="/bots/webapps#initializing-mini-apps">switchInlineQuery</a> inside the Web App.
 * @property start_parameter <em>Optional</em>. <a href="/bots/features#deep-linking">Deep-linking</a> parameter for the /start message sent to the bot when a user presses the button. 1-64 characters, only <code>A-Z</code>, <code>a-z</code>, <code>0-9</code>, <code>_</code> and <code>-</code> are allowed.<br><br><em>Example:</em> An inline bot that sends YouTube videos can ask the user to connect the bot to their YouTube account to adapt search results accordingly. To do this, it displays a 'Connect your YouTube account' button above the results, or even before showing any. The user presses the button, switches to a private chat with the bot and, in doing so, passes a start parameter that instructs the bot to return an OAuth link. Once done, the bot can offer a <a href="#inlinekeyboardmarkup"><em>switch_inline</em></a> button so that the user can easily return to the chat where they wanted to use the bot's inline capabilities.
 *
 * @constructor Creates a [InlineQueryResultsButton].
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct InlineQueryResultsButton {
    /// Label text on the button
    pub text: String,
    /// <em>Optional</em>. Description of the <a href="/bots/webapps">Web App</a> that will be launched when the user presses the button. The Web App will be able to switch back to the inline mode using the method <a href="/bots/webapps#initializing-mini-apps">switchInlineQuery</a> inside the Web App.
    #[serde(skip_serializing_if = "Option::is_none")]
    pub web_app: Option<WebAppInfo>,
    /// <em>Optional</em>. <a href="/bots/features#deep-linking">Deep-linking</a> parameter for the /start message sent to the bot when a user presses the button. 1-64 characters, only <code>A-Z</code>, <code>a-z</code>, <code>0-9</code>, <code>_</code> and <code>-</code> are allowed.<br><br><em>Example:</em> An inline bot that sends YouTube videos can ask the user to connect the bot to their YouTube account to adapt search results accordingly. To do this, it displays a 'Connect your YouTube account' button above the results, or even before showing any. The user presses the button, switches to a private chat with the bot and, in doing so, passes a start parameter that instructs the bot to return an OAuth link. Once done, the bot can offer a <a href="#inlinekeyboardmarkup"><em>switch_inline</em></a> button so that the user can easily return to the chat where they wanted to use the bot's inline capabilities.
    #[serde(skip_serializing_if = "Option::is_none")]
    pub start_parameter: Option<String>
}

/**
 * <p>Represents a link to an article or web page.</p>
 *
 * @property type Type of the result, must be <em>article</em>
 * @property id Unique identifier for this result, 1-64 Bytes
 * @property title Title of the result
 * @property input_message_content Content of the message to be sent
 * @property reply_markup <em>Optional</em>. <a href="/bots/features#inline-keyboards">Inline keyboard</a> attached to the message
 * @property url <em>Optional</em>. URL of the result
 * @property hide_url <em>Optional</em>. Pass <em>True</em> if you don't want the URL to be shown in the message
 * @property description <em>Optional</em>. Short description of the result
 * @property thumbnail_url <em>Optional</em>. Url of the thumbnail for the result
 * @property thumbnail_width <em>Optional</em>. Thumbnail width
 * @property thumbnail_height <em>Optional</em>. Thumbnail height
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
    /// <em>Optional</em>. <a href="/bots/features#inline-keyboards">Inline keyboard</a> attached to the message
    #[serde(skip_serializing_if = "Option::is_none")]
    pub reply_markup: Option<InlineKeyboardMarkup>,
    /// <em>Optional</em>. URL of the result
    #[serde(skip_serializing_if = "Option::is_none")]
    pub url: Option<String>,
    /// <em>Optional</em>. Pass <em>True</em> if you don't want the URL to be shown in the message
    #[serde(skip_serializing_if = "Option::is_none")]
    pub hide_url: Option<bool>,
    /// <em>Optional</em>. Short description of the result
    #[serde(skip_serializing_if = "Option::is_none")]
    pub description: Option<String>,
    /// <em>Optional</em>. Url of the thumbnail for the result
    #[serde(skip_serializing_if = "Option::is_none")]
    pub thumbnail_url: Option<String>,
    /// <em>Optional</em>. Thumbnail width
    #[serde(skip_serializing_if = "Option::is_none")]
    pub thumbnail_width: Option<Integer>,
    /// <em>Optional</em>. Thumbnail height
    #[serde(skip_serializing_if = "Option::is_none")]
    pub thumbnail_height: Option<Integer>
}

/**
 * <p>Represents a link to a photo. By default, this photo will be sent by the user with optional caption. Alternatively, you can use <em>input_message_content</em> to send a message with the specified content instead of the photo.</p>
 *
 * @property type Type of the result, must be <em>photo</em>
 * @property id Unique identifier for this result, 1-64 bytes
 * @property photo_url A valid URL of the photo. Photo must be in <strong>JPEG</strong> format. Photo size must not exceed 5MB
 * @property thumbnail_url URL of the thumbnail for the photo
 * @property photo_width <em>Optional</em>. Width of the photo
 * @property photo_height <em>Optional</em>. Height of the photo
 * @property title <em>Optional</em>. Title for the result
 * @property description <em>Optional</em>. Short description of the result
 * @property caption <em>Optional</em>. Caption of the photo to be sent, 0-1024 characters after entities parsing
 * @property parse_mode <em>Optional</em>. Mode for parsing entities in the photo caption. See <a href="#formatting-options">formatting options</a> for more details.
 * @property caption_entities <em>Optional</em>. List of special entities that appear in the caption, which can be specified instead of <em>parse_mode</em>
 * @property show_caption_above_media <em>Optional</em>. Pass <em>True</em>, if the caption must be shown above the message media
 * @property reply_markup <em>Optional</em>. <a href="/bots/features#inline-keyboards">Inline keyboard</a> attached to the message
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
    /// A valid URL of the photo. Photo must be in <strong>JPEG</strong> format. Photo size must not exceed 5MB
    pub photo_url: String,
    /// URL of the thumbnail for the photo
    pub thumbnail_url: String,
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
    /// <em>Optional</em>. List of special entities that appear in the caption, which can be specified instead of <em>parse_mode</em>
    #[serde(skip_serializing_if = "Option::is_none")]
    pub caption_entities: Option<Vec<MessageEntity>>,
    /// <em>Optional</em>. Pass <em>True</em>, if the caption must be shown above the message media
    #[serde(skip_serializing_if = "Option::is_none")]
    pub show_caption_above_media: Option<bool>,
    /// <em>Optional</em>. <a href="/bots/features#inline-keyboards">Inline keyboard</a> attached to the message
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
 * @property gif_duration <em>Optional</em>. Duration of the GIF in seconds
 * @property thumbnail_url URL of the static (JPEG or GIF) or animated (MPEG4) thumbnail for the result
 * @property thumbnail_mime_type <em>Optional</em>. MIME type of the thumbnail, must be one of “image/jpeg”, “image/gif”, or “video/mp4”. Defaults to “image/jpeg”
 * @property title <em>Optional</em>. Title for the result
 * @property caption <em>Optional</em>. Caption of the GIF file to be sent, 0-1024 characters after entities parsing
 * @property parse_mode <em>Optional</em>. Mode for parsing entities in the caption. See <a href="#formatting-options">formatting options</a> for more details.
 * @property caption_entities <em>Optional</em>. List of special entities that appear in the caption, which can be specified instead of <em>parse_mode</em>
 * @property show_caption_above_media <em>Optional</em>. Pass <em>True</em>, if the caption must be shown above the message media
 * @property reply_markup <em>Optional</em>. <a href="/bots/features#inline-keyboards">Inline keyboard</a> attached to the message
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
    /// <em>Optional</em>. Duration of the GIF in seconds
    #[serde(skip_serializing_if = "Option::is_none")]
    pub gif_duration: Option<Integer>,
    /// URL of the static (JPEG or GIF) or animated (MPEG4) thumbnail for the result
    pub thumbnail_url: String,
    /// <em>Optional</em>. MIME type of the thumbnail, must be one of “image/jpeg”, “image/gif”, or “video/mp4”. Defaults to “image/jpeg”
    #[serde(skip_serializing_if = "Option::is_none")]
    pub thumbnail_mime_type: Option<String>,
    /// <em>Optional</em>. Title for the result
    #[serde(skip_serializing_if = "Option::is_none")]
    pub title: Option<String>,
    /// <em>Optional</em>. Caption of the GIF file to be sent, 0-1024 characters after entities parsing
    #[serde(skip_serializing_if = "Option::is_none")]
    pub caption: Option<String>,
    /// <em>Optional</em>. Mode for parsing entities in the caption. See <a href="#formatting-options">formatting options</a> for more details.
    #[serde(skip_serializing_if = "Option::is_none")]
    pub parse_mode: Option<ParseMode>,
    /// <em>Optional</em>. List of special entities that appear in the caption, which can be specified instead of <em>parse_mode</em>
    #[serde(skip_serializing_if = "Option::is_none")]
    pub caption_entities: Option<Vec<MessageEntity>>,
    /// <em>Optional</em>. Pass <em>True</em>, if the caption must be shown above the message media
    #[serde(skip_serializing_if = "Option::is_none")]
    pub show_caption_above_media: Option<bool>,
    /// <em>Optional</em>. <a href="/bots/features#inline-keyboards">Inline keyboard</a> attached to the message
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
 * @property mpeg4_url A valid URL for the MPEG4 file. File size must not exceed 1MB
 * @property mpeg4_width <em>Optional</em>. Video width
 * @property mpeg4_height <em>Optional</em>. Video height
 * @property mpeg4_duration <em>Optional</em>. Video duration in seconds
 * @property thumbnail_url URL of the static (JPEG or GIF) or animated (MPEG4) thumbnail for the result
 * @property thumbnail_mime_type <em>Optional</em>. MIME type of the thumbnail, must be one of “image/jpeg”, “image/gif”, or “video/mp4”. Defaults to “image/jpeg”
 * @property title <em>Optional</em>. Title for the result
 * @property caption <em>Optional</em>. Caption of the MPEG-4 file to be sent, 0-1024 characters after entities parsing
 * @property parse_mode <em>Optional</em>. Mode for parsing entities in the caption. See <a href="#formatting-options">formatting options</a> for more details.
 * @property caption_entities <em>Optional</em>. List of special entities that appear in the caption, which can be specified instead of <em>parse_mode</em>
 * @property show_caption_above_media <em>Optional</em>. Pass <em>True</em>, if the caption must be shown above the message media
 * @property reply_markup <em>Optional</em>. <a href="/bots/features#inline-keyboards">Inline keyboard</a> attached to the message
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
    /// A valid URL for the MPEG4 file. File size must not exceed 1MB
    pub mpeg4_url: String,
    /// <em>Optional</em>. Video width
    #[serde(skip_serializing_if = "Option::is_none")]
    pub mpeg4_width: Option<Integer>,
    /// <em>Optional</em>. Video height
    #[serde(skip_serializing_if = "Option::is_none")]
    pub mpeg4_height: Option<Integer>,
    /// <em>Optional</em>. Video duration in seconds
    #[serde(skip_serializing_if = "Option::is_none")]
    pub mpeg4_duration: Option<Integer>,
    /// URL of the static (JPEG or GIF) or animated (MPEG4) thumbnail for the result
    pub thumbnail_url: String,
    /// <em>Optional</em>. MIME type of the thumbnail, must be one of “image/jpeg”, “image/gif”, or “video/mp4”. Defaults to “image/jpeg”
    #[serde(skip_serializing_if = "Option::is_none")]
    pub thumbnail_mime_type: Option<String>,
    /// <em>Optional</em>. Title for the result
    #[serde(skip_serializing_if = "Option::is_none")]
    pub title: Option<String>,
    /// <em>Optional</em>. Caption of the MPEG-4 file to be sent, 0-1024 characters after entities parsing
    #[serde(skip_serializing_if = "Option::is_none")]
    pub caption: Option<String>,
    /// <em>Optional</em>. Mode for parsing entities in the caption. See <a href="#formatting-options">formatting options</a> for more details.
    #[serde(skip_serializing_if = "Option::is_none")]
    pub parse_mode: Option<ParseMode>,
    /// <em>Optional</em>. List of special entities that appear in the caption, which can be specified instead of <em>parse_mode</em>
    #[serde(skip_serializing_if = "Option::is_none")]
    pub caption_entities: Option<Vec<MessageEntity>>,
    /// <em>Optional</em>. Pass <em>True</em>, if the caption must be shown above the message media
    #[serde(skip_serializing_if = "Option::is_none")]
    pub show_caption_above_media: Option<bool>,
    /// <em>Optional</em>. <a href="/bots/features#inline-keyboards">Inline keyboard</a> attached to the message
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
 * @property mime_type MIME type of the content of the video URL, “text/html” or “video/mp4”
 * @property thumbnail_url URL of the thumbnail (JPEG only) for the video
 * @property title Title for the result
 * @property caption <em>Optional</em>. Caption of the video to be sent, 0-1024 characters after entities parsing
 * @property parse_mode <em>Optional</em>. Mode for parsing entities in the video caption. See <a href="#formatting-options">formatting options</a> for more details.
 * @property caption_entities <em>Optional</em>. List of special entities that appear in the caption, which can be specified instead of <em>parse_mode</em>
 * @property show_caption_above_media <em>Optional</em>. Pass <em>True</em>, if the caption must be shown above the message media
 * @property video_width <em>Optional</em>. Video width
 * @property video_height <em>Optional</em>. Video height
 * @property video_duration <em>Optional</em>. Video duration in seconds
 * @property description <em>Optional</em>. Short description of the result
 * @property reply_markup <em>Optional</em>. <a href="/bots/features#inline-keyboards">Inline keyboard</a> attached to the message
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
    /// MIME type of the content of the video URL, “text/html” or “video/mp4”
    pub mime_type: String,
    /// URL of the thumbnail (JPEG only) for the video
    pub thumbnail_url: String,
    /// Title for the result
    pub title: String,
    /// <em>Optional</em>. Caption of the video to be sent, 0-1024 characters after entities parsing
    #[serde(skip_serializing_if = "Option::is_none")]
    pub caption: Option<String>,
    /// <em>Optional</em>. Mode for parsing entities in the video caption. See <a href="#formatting-options">formatting options</a> for more details.
    #[serde(skip_serializing_if = "Option::is_none")]
    pub parse_mode: Option<ParseMode>,
    /// <em>Optional</em>. List of special entities that appear in the caption, which can be specified instead of <em>parse_mode</em>
    #[serde(skip_serializing_if = "Option::is_none")]
    pub caption_entities: Option<Vec<MessageEntity>>,
    /// <em>Optional</em>. Pass <em>True</em>, if the caption must be shown above the message media
    #[serde(skip_serializing_if = "Option::is_none")]
    pub show_caption_above_media: Option<bool>,
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
    /// <em>Optional</em>. <a href="/bots/features#inline-keyboards">Inline keyboard</a> attached to the message
    #[serde(skip_serializing_if = "Option::is_none")]
    pub reply_markup: Option<InlineKeyboardMarkup>,
    /// <em>Optional</em>. Content of the message to be sent instead of the video. This field is <strong>required</strong> if InlineQueryResultVideo is used to send an HTML-page as a result (e.g., a YouTube video).
    #[serde(skip_serializing_if = "Option::is_none")]
    pub input_message_content: Option<InputMessageContent>
}

/**
 * <p>Represents a link to an MP3 audio file. By default, this audio file will be sent by the user. Alternatively, you can use <em>input_message_content</em> to send a message with the specified content instead of the audio.</p>
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
 * @property reply_markup <em>Optional</em>. <a href="/bots/features#inline-keyboards">Inline keyboard</a> attached to the message
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
    /// <em>Optional</em>. List of special entities that appear in the caption, which can be specified instead of <em>parse_mode</em>
    #[serde(skip_serializing_if = "Option::is_none")]
    pub caption_entities: Option<Vec<MessageEntity>>,
    /// <em>Optional</em>. Performer
    #[serde(skip_serializing_if = "Option::is_none")]
    pub performer: Option<String>,
    /// <em>Optional</em>. Audio duration in seconds
    #[serde(skip_serializing_if = "Option::is_none")]
    pub audio_duration: Option<Integer>,
    /// <em>Optional</em>. <a href="/bots/features#inline-keyboards">Inline keyboard</a> attached to the message
    #[serde(skip_serializing_if = "Option::is_none")]
    pub reply_markup: Option<InlineKeyboardMarkup>,
    /// <em>Optional</em>. Content of the message to be sent instead of the audio
    #[serde(skip_serializing_if = "Option::is_none")]
    pub input_message_content: Option<InputMessageContent>
}

/**
 * <p>Represents a link to a voice recording in an .OGG container encoded with OPUS. By default, this voice recording will be sent by the user. Alternatively, you can use <em>input_message_content</em> to send a message with the specified content instead of the the voice message.</p>
 *
 * @property type Type of the result, must be <em>voice</em>
 * @property id Unique identifier for this result, 1-64 bytes
 * @property voice_url A valid URL for the voice recording
 * @property title Recording title
 * @property caption <em>Optional</em>. Caption, 0-1024 characters after entities parsing
 * @property parse_mode <em>Optional</em>. Mode for parsing entities in the voice message caption. See <a href="#formatting-options">formatting options</a> for more details.
 * @property caption_entities <em>Optional</em>. List of special entities that appear in the caption, which can be specified instead of <em>parse_mode</em>
 * @property voice_duration <em>Optional</em>. Recording duration in seconds
 * @property reply_markup <em>Optional</em>. <a href="/bots/features#inline-keyboards">Inline keyboard</a> attached to the message
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
    /// <em>Optional</em>. List of special entities that appear in the caption, which can be specified instead of <em>parse_mode</em>
    #[serde(skip_serializing_if = "Option::is_none")]
    pub caption_entities: Option<Vec<MessageEntity>>,
    /// <em>Optional</em>. Recording duration in seconds
    #[serde(skip_serializing_if = "Option::is_none")]
    pub voice_duration: Option<Integer>,
    /// <em>Optional</em>. <a href="/bots/features#inline-keyboards">Inline keyboard</a> attached to the message
    #[serde(skip_serializing_if = "Option::is_none")]
    pub reply_markup: Option<InlineKeyboardMarkup>,
    /// <em>Optional</em>. Content of the message to be sent instead of the voice recording
    #[serde(skip_serializing_if = "Option::is_none")]
    pub input_message_content: Option<InputMessageContent>
}

/**
 * <p>Represents a link to a file. By default, this file will be sent by the user with an optional caption. Alternatively, you can use <em>input_message_content</em> to send a message with the specified content instead of the file. Currently, only <strong>.PDF</strong> and <strong>.ZIP</strong> files can be sent using this method.</p>
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
 * @property thumbnail_url <em>Optional</em>. URL of the thumbnail (JPEG only) for the file
 * @property thumbnail_width <em>Optional</em>. Thumbnail width
 * @property thumbnail_height <em>Optional</em>. Thumbnail height
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
    /// <em>Optional</em>. List of special entities that appear in the caption, which can be specified instead of <em>parse_mode</em>
    #[serde(skip_serializing_if = "Option::is_none")]
    pub caption_entities: Option<Vec<MessageEntity>>,
    /// A valid URL for the file
    pub document_url: String,
    /// MIME type of the content of the file, either “application/pdf” or “application/zip”
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
    /// <em>Optional</em>. URL of the thumbnail (JPEG only) for the file
    #[serde(skip_serializing_if = "Option::is_none")]
    pub thumbnail_url: Option<String>,
    /// <em>Optional</em>. Thumbnail width
    #[serde(skip_serializing_if = "Option::is_none")]
    pub thumbnail_width: Option<Integer>,
    /// <em>Optional</em>. Thumbnail height
    #[serde(skip_serializing_if = "Option::is_none")]
    pub thumbnail_height: Option<Integer>
}

/**
 * <p>Represents a location on a map. By default, the location will be sent by the user. Alternatively, you can use <em>input_message_content</em> to send a message with the specified content instead of the location.</p>
 *
 * @property type Type of the result, must be <em>location</em>
 * @property id Unique identifier for this result, 1-64 Bytes
 * @property latitude Location latitude in degrees
 * @property longitude Location longitude in degrees
 * @property title Location title
 * @property horizontal_accuracy <em>Optional</em>. The radius of uncertainty for the location, measured in meters; 0-1500
 * @property live_period <em>Optional</em>. Period in seconds during which the location can be updated, should be between 60 and 86400, or 0x7FFFFFFF for live locations that can be edited indefinitely.
 * @property heading <em>Optional</em>. For live locations, a direction in which the user is moving, in degrees. Must be between 1 and 360 if specified.
 * @property proximity_alert_radius <em>Optional</em>. For live locations, a maximum distance for proximity alerts about approaching another chat member, in meters. Must be between 1 and 100000 if specified.
 * @property reply_markup <em>Optional</em>. <a href="/bots/features#inline-keyboards">Inline keyboard</a> attached to the message
 * @property input_message_content <em>Optional</em>. Content of the message to be sent instead of the location
 * @property thumbnail_url <em>Optional</em>. Url of the thumbnail for the result
 * @property thumbnail_width <em>Optional</em>. Thumbnail width
 * @property thumbnail_height <em>Optional</em>. Thumbnail height
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
    /// <em>Optional</em>. The radius of uncertainty for the location, measured in meters; 0-1500
    #[serde(skip_serializing_if = "Option::is_none")]
    pub horizontal_accuracy: Option<Float>,
    /// <em>Optional</em>. Period in seconds during which the location can be updated, should be between 60 and 86400, or 0x7FFFFFFF for live locations that can be edited indefinitely.
    #[serde(skip_serializing_if = "Option::is_none")]
    pub live_period: Option<Integer>,
    /// <em>Optional</em>. For live locations, a direction in which the user is moving, in degrees. Must be between 1 and 360 if specified.
    #[serde(skip_serializing_if = "Option::is_none")]
    pub heading: Option<Integer>,
    /// <em>Optional</em>. For live locations, a maximum distance for proximity alerts about approaching another chat member, in meters. Must be between 1 and 100000 if specified.
    #[serde(skip_serializing_if = "Option::is_none")]
    pub proximity_alert_radius: Option<Integer>,
    /// <em>Optional</em>. <a href="/bots/features#inline-keyboards">Inline keyboard</a> attached to the message
    #[serde(skip_serializing_if = "Option::is_none")]
    pub reply_markup: Option<InlineKeyboardMarkup>,
    /// <em>Optional</em>. Content of the message to be sent instead of the location
    #[serde(skip_serializing_if = "Option::is_none")]
    pub input_message_content: Option<InputMessageContent>,
    /// <em>Optional</em>. Url of the thumbnail for the result
    #[serde(skip_serializing_if = "Option::is_none")]
    pub thumbnail_url: Option<String>,
    /// <em>Optional</em>. Thumbnail width
    #[serde(skip_serializing_if = "Option::is_none")]
    pub thumbnail_width: Option<Integer>,
    /// <em>Optional</em>. Thumbnail height
    #[serde(skip_serializing_if = "Option::is_none")]
    pub thumbnail_height: Option<Integer>
}

/**
 * <p>Represents a venue. By default, the venue will be sent by the user. Alternatively, you can use <em>input_message_content</em> to send a message with the specified content instead of the venue.</p>
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
 * @property reply_markup <em>Optional</em>. <a href="/bots/features#inline-keyboards">Inline keyboard</a> attached to the message
 * @property input_message_content <em>Optional</em>. Content of the message to be sent instead of the venue
 * @property thumbnail_url <em>Optional</em>. Url of the thumbnail for the result
 * @property thumbnail_width <em>Optional</em>. Thumbnail width
 * @property thumbnail_height <em>Optional</em>. Thumbnail height
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
    /// <em>Optional</em>. Google Places identifier of the venue
    #[serde(skip_serializing_if = "Option::is_none")]
    pub google_place_id: Option<String>,
    /// <em>Optional</em>. Google Places type of the venue. (See <a href="https://developers.google.com/places/web-service/supported_types">supported types</a>.)
    #[serde(skip_serializing_if = "Option::is_none")]
    pub google_place_type: Option<String>,
    /// <em>Optional</em>. <a href="/bots/features#inline-keyboards">Inline keyboard</a> attached to the message
    #[serde(skip_serializing_if = "Option::is_none")]
    pub reply_markup: Option<InlineKeyboardMarkup>,
    /// <em>Optional</em>. Content of the message to be sent instead of the venue
    #[serde(skip_serializing_if = "Option::is_none")]
    pub input_message_content: Option<InputMessageContent>,
    /// <em>Optional</em>. Url of the thumbnail for the result
    #[serde(skip_serializing_if = "Option::is_none")]
    pub thumbnail_url: Option<String>,
    /// <em>Optional</em>. Thumbnail width
    #[serde(skip_serializing_if = "Option::is_none")]
    pub thumbnail_width: Option<Integer>,
    /// <em>Optional</em>. Thumbnail height
    #[serde(skip_serializing_if = "Option::is_none")]
    pub thumbnail_height: Option<Integer>
}

/**
 * <p>Represents a contact with a phone number. By default, this contact will be sent by the user. Alternatively, you can use <em>input_message_content</em> to send a message with the specified content instead of the contact.</p>
 *
 * @property type Type of the result, must be <em>contact</em>
 * @property id Unique identifier for this result, 1-64 Bytes
 * @property phone_number Contact's phone number
 * @property first_name Contact's first name
 * @property last_name <em>Optional</em>. Contact's last name
 * @property vcard <em>Optional</em>. Additional data about the contact in the form of a <a href="https://en.wikipedia.org/wiki/VCard">vCard</a>, 0-2048 bytes
 * @property reply_markup <em>Optional</em>. <a href="/bots/features#inline-keyboards">Inline keyboard</a> attached to the message
 * @property input_message_content <em>Optional</em>. Content of the message to be sent instead of the contact
 * @property thumbnail_url <em>Optional</em>. Url of the thumbnail for the result
 * @property thumbnail_width <em>Optional</em>. Thumbnail width
 * @property thumbnail_height <em>Optional</em>. Thumbnail height
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
    /// <em>Optional</em>. <a href="/bots/features#inline-keyboards">Inline keyboard</a> attached to the message
    #[serde(skip_serializing_if = "Option::is_none")]
    pub reply_markup: Option<InlineKeyboardMarkup>,
    /// <em>Optional</em>. Content of the message to be sent instead of the contact
    #[serde(skip_serializing_if = "Option::is_none")]
    pub input_message_content: Option<InputMessageContent>,
    /// <em>Optional</em>. Url of the thumbnail for the result
    #[serde(skip_serializing_if = "Option::is_none")]
    pub thumbnail_url: Option<String>,
    /// <em>Optional</em>. Thumbnail width
    #[serde(skip_serializing_if = "Option::is_none")]
    pub thumbnail_width: Option<Integer>,
    /// <em>Optional</em>. Thumbnail height
    #[serde(skip_serializing_if = "Option::is_none")]
    pub thumbnail_height: Option<Integer>
}

/**
 * <p>Represents a <a href="#games">Game</a>.</p>
 *
 * @property type Type of the result, must be <em>game</em>
 * @property id Unique identifier for this result, 1-64 bytes
 * @property game_short_name Short name of the game
 * @property reply_markup <em>Optional</em>. <a href="/bots/features#inline-keyboards">Inline keyboard</a> attached to the message
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
    /// <em>Optional</em>. <a href="/bots/features#inline-keyboards">Inline keyboard</a> attached to the message
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
 * @property caption_entities <em>Optional</em>. List of special entities that appear in the caption, which can be specified instead of <em>parse_mode</em>
 * @property show_caption_above_media <em>Optional</em>. Pass <em>True</em>, if the caption must be shown above the message media
 * @property reply_markup <em>Optional</em>. <a href="/bots/features#inline-keyboards">Inline keyboard</a> attached to the message
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
    /// <em>Optional</em>. List of special entities that appear in the caption, which can be specified instead of <em>parse_mode</em>
    #[serde(skip_serializing_if = "Option::is_none")]
    pub caption_entities: Option<Vec<MessageEntity>>,
    /// <em>Optional</em>. Pass <em>True</em>, if the caption must be shown above the message media
    #[serde(skip_serializing_if = "Option::is_none")]
    pub show_caption_above_media: Option<bool>,
    /// <em>Optional</em>. <a href="/bots/features#inline-keyboards">Inline keyboard</a> attached to the message
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
 * @property caption_entities <em>Optional</em>. List of special entities that appear in the caption, which can be specified instead of <em>parse_mode</em>
 * @property show_caption_above_media <em>Optional</em>. Pass <em>True</em>, if the caption must be shown above the message media
 * @property reply_markup <em>Optional</em>. <a href="/bots/features#inline-keyboards">Inline keyboard</a> attached to the message
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
    /// <em>Optional</em>. List of special entities that appear in the caption, which can be specified instead of <em>parse_mode</em>
    #[serde(skip_serializing_if = "Option::is_none")]
    pub caption_entities: Option<Vec<MessageEntity>>,
    /// <em>Optional</em>. Pass <em>True</em>, if the caption must be shown above the message media
    #[serde(skip_serializing_if = "Option::is_none")]
    pub show_caption_above_media: Option<bool>,
    /// <em>Optional</em>. <a href="/bots/features#inline-keyboards">Inline keyboard</a> attached to the message
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
 * @property mpeg4_file_id A valid file identifier for the MPEG4 file
 * @property title <em>Optional</em>. Title for the result
 * @property caption <em>Optional</em>. Caption of the MPEG-4 file to be sent, 0-1024 characters after entities parsing
 * @property parse_mode <em>Optional</em>. Mode for parsing entities in the caption. See <a href="#formatting-options">formatting options</a> for more details.
 * @property caption_entities <em>Optional</em>. List of special entities that appear in the caption, which can be specified instead of <em>parse_mode</em>
 * @property show_caption_above_media <em>Optional</em>. Pass <em>True</em>, if the caption must be shown above the message media
 * @property reply_markup <em>Optional</em>. <a href="/bots/features#inline-keyboards">Inline keyboard</a> attached to the message
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
    /// A valid file identifier for the MPEG4 file
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
    /// <em>Optional</em>. List of special entities that appear in the caption, which can be specified instead of <em>parse_mode</em>
    #[serde(skip_serializing_if = "Option::is_none")]
    pub caption_entities: Option<Vec<MessageEntity>>,
    /// <em>Optional</em>. Pass <em>True</em>, if the caption must be shown above the message media
    #[serde(skip_serializing_if = "Option::is_none")]
    pub show_caption_above_media: Option<bool>,
    /// <em>Optional</em>. <a href="/bots/features#inline-keyboards">Inline keyboard</a> attached to the message
    #[serde(skip_serializing_if = "Option::is_none")]
    pub reply_markup: Option<InlineKeyboardMarkup>,
    /// <em>Optional</em>. Content of the message to be sent instead of the video animation
    #[serde(skip_serializing_if = "Option::is_none")]
    pub input_message_content: Option<InputMessageContent>
}

/**
 * <p>Represents a link to a sticker stored on the Telegram servers. By default, this sticker will be sent by the user. Alternatively, you can use <em>input_message_content</em> to send a message with the specified content instead of the sticker.</p>
 *
 * @property type Type of the result, must be <em>sticker</em>
 * @property id Unique identifier for this result, 1-64 bytes
 * @property sticker_file_id A valid file identifier of the sticker
 * @property reply_markup <em>Optional</em>. <a href="/bots/features#inline-keyboards">Inline keyboard</a> attached to the message
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
    /// <em>Optional</em>. <a href="/bots/features#inline-keyboards">Inline keyboard</a> attached to the message
    #[serde(skip_serializing_if = "Option::is_none")]
    pub reply_markup: Option<InlineKeyboardMarkup>,
    /// <em>Optional</em>. Content of the message to be sent instead of the sticker
    #[serde(skip_serializing_if = "Option::is_none")]
    pub input_message_content: Option<InputMessageContent>
}

/**
 * <p>Represents a link to a file stored on the Telegram servers. By default, this file will be sent by the user with an optional caption. Alternatively, you can use <em>input_message_content</em> to send a message with the specified content instead of the file.</p>
 *
 * @property type Type of the result, must be <em>document</em>
 * @property id Unique identifier for this result, 1-64 bytes
 * @property title Title for the result
 * @property document_file_id A valid file identifier for the file
 * @property description <em>Optional</em>. Short description of the result
 * @property caption <em>Optional</em>. Caption of the document to be sent, 0-1024 characters after entities parsing
 * @property parse_mode <em>Optional</em>. Mode for parsing entities in the document caption. See <a href="#formatting-options">formatting options</a> for more details.
 * @property caption_entities <em>Optional</em>. List of special entities that appear in the caption, which can be specified instead of <em>parse_mode</em>
 * @property reply_markup <em>Optional</em>. <a href="/bots/features#inline-keyboards">Inline keyboard</a> attached to the message
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
    /// <em>Optional</em>. List of special entities that appear in the caption, which can be specified instead of <em>parse_mode</em>
    #[serde(skip_serializing_if = "Option::is_none")]
    pub caption_entities: Option<Vec<MessageEntity>>,
    /// <em>Optional</em>. <a href="/bots/features#inline-keyboards">Inline keyboard</a> attached to the message
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
 * @property caption_entities <em>Optional</em>. List of special entities that appear in the caption, which can be specified instead of <em>parse_mode</em>
 * @property show_caption_above_media <em>Optional</em>. Pass <em>True</em>, if the caption must be shown above the message media
 * @property reply_markup <em>Optional</em>. <a href="/bots/features#inline-keyboards">Inline keyboard</a> attached to the message
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
    /// <em>Optional</em>. List of special entities that appear in the caption, which can be specified instead of <em>parse_mode</em>
    #[serde(skip_serializing_if = "Option::is_none")]
    pub caption_entities: Option<Vec<MessageEntity>>,
    /// <em>Optional</em>. Pass <em>True</em>, if the caption must be shown above the message media
    #[serde(skip_serializing_if = "Option::is_none")]
    pub show_caption_above_media: Option<bool>,
    /// <em>Optional</em>. <a href="/bots/features#inline-keyboards">Inline keyboard</a> attached to the message
    #[serde(skip_serializing_if = "Option::is_none")]
    pub reply_markup: Option<InlineKeyboardMarkup>,
    /// <em>Optional</em>. Content of the message to be sent instead of the video
    #[serde(skip_serializing_if = "Option::is_none")]
    pub input_message_content: Option<InputMessageContent>
}

/**
 * <p>Represents a link to a voice message stored on the Telegram servers. By default, this voice message will be sent by the user. Alternatively, you can use <em>input_message_content</em> to send a message with the specified content instead of the voice message.</p>
 *
 * @property type Type of the result, must be <em>voice</em>
 * @property id Unique identifier for this result, 1-64 bytes
 * @property voice_file_id A valid file identifier for the voice message
 * @property title Voice message title
 * @property caption <em>Optional</em>. Caption, 0-1024 characters after entities parsing
 * @property parse_mode <em>Optional</em>. Mode for parsing entities in the voice message caption. See <a href="#formatting-options">formatting options</a> for more details.
 * @property caption_entities <em>Optional</em>. List of special entities that appear in the caption, which can be specified instead of <em>parse_mode</em>
 * @property reply_markup <em>Optional</em>. <a href="/bots/features#inline-keyboards">Inline keyboard</a> attached to the message
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
    /// <em>Optional</em>. List of special entities that appear in the caption, which can be specified instead of <em>parse_mode</em>
    #[serde(skip_serializing_if = "Option::is_none")]
    pub caption_entities: Option<Vec<MessageEntity>>,
    /// <em>Optional</em>. <a href="/bots/features#inline-keyboards">Inline keyboard</a> attached to the message
    #[serde(skip_serializing_if = "Option::is_none")]
    pub reply_markup: Option<InlineKeyboardMarkup>,
    /// <em>Optional</em>. Content of the message to be sent instead of the voice message
    #[serde(skip_serializing_if = "Option::is_none")]
    pub input_message_content: Option<InputMessageContent>
}

/**
 * <p>Represents a link to an MP3 audio file stored on the Telegram servers. By default, this audio file will be sent by the user. Alternatively, you can use <em>input_message_content</em> to send a message with the specified content instead of the audio.</p>
 *
 * @property type Type of the result, must be <em>audio</em>
 * @property id Unique identifier for this result, 1-64 bytes
 * @property audio_file_id A valid file identifier for the audio file
 * @property caption <em>Optional</em>. Caption, 0-1024 characters after entities parsing
 * @property parse_mode <em>Optional</em>. Mode for parsing entities in the audio caption. See <a href="#formatting-options">formatting options</a> for more details.
 * @property caption_entities <em>Optional</em>. List of special entities that appear in the caption, which can be specified instead of <em>parse_mode</em>
 * @property reply_markup <em>Optional</em>. <a href="/bots/features#inline-keyboards">Inline keyboard</a> attached to the message
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
    /// <em>Optional</em>. List of special entities that appear in the caption, which can be specified instead of <em>parse_mode</em>
    #[serde(skip_serializing_if = "Option::is_none")]
    pub caption_entities: Option<Vec<MessageEntity>>,
    /// <em>Optional</em>. <a href="/bots/features#inline-keyboards">Inline keyboard</a> attached to the message
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
 * @property entities <em>Optional</em>. List of special entities that appear in message text, which can be specified instead of <em>parse_mode</em>
 * @property link_preview_options <em>Optional</em>. Link preview generation options for the message
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
    /// <em>Optional</em>. List of special entities that appear in message text, which can be specified instead of <em>parse_mode</em>
    #[serde(skip_serializing_if = "Option::is_none")]
    pub entities: Option<Vec<MessageEntity>>,
    /// <em>Optional</em>. Link preview generation options for the message
    #[serde(skip_serializing_if = "Option::is_none")]
    pub link_preview_options: Option<LinkPreviewOptions>
}

/**
 * <p>Represents the <a href="#inputmessagecontent">content</a> of a location message to be sent as the result of an inline query.</p>
 *
 * @property latitude Latitude of the location in degrees
 * @property longitude Longitude of the location in degrees
 * @property horizontal_accuracy <em>Optional</em>. The radius of uncertainty for the location, measured in meters; 0-1500
 * @property live_period <em>Optional</em>. Period in seconds during which the location can be updated, should be between 60 and 86400, or 0x7FFFFFFF for live locations that can be edited indefinitely.
 * @property heading <em>Optional</em>. For live locations, a direction in which the user is moving, in degrees. Must be between 1 and 360 if specified.
 * @property proximity_alert_radius <em>Optional</em>. For live locations, a maximum distance for proximity alerts about approaching another chat member, in meters. Must be between 1 and 100000 if specified.
 *
 * @constructor Creates a [InputLocationMessageContent].
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct InputLocationMessageContent {
    /// Latitude of the location in degrees
    pub latitude: Float,
    /// Longitude of the location in degrees
    pub longitude: Float,
    /// <em>Optional</em>. The radius of uncertainty for the location, measured in meters; 0-1500
    #[serde(skip_serializing_if = "Option::is_none")]
    pub horizontal_accuracy: Option<Float>,
    /// <em>Optional</em>. Period in seconds during which the location can be updated, should be between 60 and 86400, or 0x7FFFFFFF for live locations that can be edited indefinitely.
    #[serde(skip_serializing_if = "Option::is_none")]
    pub live_period: Option<Integer>,
    /// <em>Optional</em>. For live locations, a direction in which the user is moving, in degrees. Must be between 1 and 360 if specified.
    #[serde(skip_serializing_if = "Option::is_none")]
    pub heading: Option<Integer>,
    /// <em>Optional</em>. For live locations, a maximum distance for proximity alerts about approaching another chat member, in meters. Must be between 1 and 100000 if specified.
    #[serde(skip_serializing_if = "Option::is_none")]
    pub proximity_alert_radius: Option<Integer>
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
    pub foursquare_type: Option<String>,
    /// <em>Optional</em>. Google Places identifier of the venue
    #[serde(skip_serializing_if = "Option::is_none")]
    pub google_place_id: Option<String>,
    /// <em>Optional</em>. Google Places type of the venue. (See <a href="https://developers.google.com/places/web-service/supported_types">supported types</a>.)
    #[serde(skip_serializing_if = "Option::is_none")]
    pub google_place_type: Option<String>
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
 * <p>Represents the <a href="#inputmessagecontent">content</a> of an invoice message to be sent as the result of an inline query.</p>
 *
 * @property title Product name, 1-32 characters
 * @property description Product description, 1-255 characters
 * @property payload Bot-defined invoice payload, 1-128 bytes. This will not be displayed to the user, use for your internal processes.
 * @property provider_token <em>Optional</em>. Payment provider token, obtained via <a href="https://t.me/botfather">@BotFather</a>. Pass an empty string for payments in <a href="https://t.me/BotNews/90">Telegram Stars</a>.
 * @property currency Three-letter ISO 4217 currency code, see <a href="/bots/payments#supported-currencies">more on currencies</a>. Pass “XTR” for payments in <a href="https://t.me/BotNews/90">Telegram Stars</a>.
 * @property prices Price breakdown, a JSON-serialized list of components (e.g. product price, tax, discount, delivery cost, delivery tax, bonus, etc.). Must contain exactly one item for payments in <a href="https://t.me/BotNews/90">Telegram Stars</a>.
 * @property max_tip_amount <em>Optional</em>. The maximum accepted amount for tips in the <em>smallest units</em> of the currency (integer, <strong>not</strong> float/double). For example, for a maximum tip of <code>US$ 1.45</code> pass <code>max_tip_amount = 145</code>. See the <em>exp</em> parameter in <a href="/bots/payments/currencies.json">currencies.json</a>, it shows the number of digits past the decimal point for each currency (2 for the majority of currencies). Defaults to 0. Not supported for payments in <a href="https://t.me/BotNews/90">Telegram Stars</a>.
 * @property suggested_tip_amounts <em>Optional</em>. A JSON-serialized array of suggested amounts of tip in the <em>smallest units</em> of the currency (integer, <strong>not</strong> float/double). At most 4 suggested tip amounts can be specified. The suggested tip amounts must be positive, passed in a strictly increased order and must not exceed <em>max_tip_amount</em>.
 * @property provider_data <em>Optional</em>. A JSON-serialized object for data about the invoice, which will be shared with the payment provider. A detailed description of the required fields should be provided by the payment provider.
 * @property photo_url <em>Optional</em>. URL of the product photo for the invoice. Can be a photo of the goods or a marketing image for a service.
 * @property photo_size <em>Optional</em>. Photo size in bytes
 * @property photo_width <em>Optional</em>. Photo width
 * @property photo_height <em>Optional</em>. Photo height
 * @property need_name <em>Optional</em>. Pass <em>True</em> if you require the user's full name to complete the order. Ignored for payments in <a href="https://t.me/BotNews/90">Telegram Stars</a>.
 * @property need_phone_number <em>Optional</em>. Pass <em>True</em> if you require the user's phone number to complete the order. Ignored for payments in <a href="https://t.me/BotNews/90">Telegram Stars</a>.
 * @property need_email <em>Optional</em>. Pass <em>True</em> if you require the user's email address to complete the order. Ignored for payments in <a href="https://t.me/BotNews/90">Telegram Stars</a>.
 * @property need_shipping_address <em>Optional</em>. Pass <em>True</em> if you require the user's shipping address to complete the order. Ignored for payments in <a href="https://t.me/BotNews/90">Telegram Stars</a>.
 * @property send_phone_number_to_provider <em>Optional</em>. Pass <em>True</em> if the user's phone number should be sent to the provider. Ignored for payments in <a href="https://t.me/BotNews/90">Telegram Stars</a>.
 * @property send_email_to_provider <em>Optional</em>. Pass <em>True</em> if the user's email address should be sent to the provider. Ignored for payments in <a href="https://t.me/BotNews/90">Telegram Stars</a>.
 * @property is_flexible <em>Optional</em>. Pass <em>True</em> if the final price depends on the shipping method. Ignored for payments in <a href="https://t.me/BotNews/90">Telegram Stars</a>.
 *
 * @constructor Creates a [InputInvoiceMessageContent].
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct InputInvoiceMessageContent {
    /// Product name, 1-32 characters
    pub title: String,
    /// Product description, 1-255 characters
    pub description: String,
    /// Bot-defined invoice payload, 1-128 bytes. This will not be displayed to the user, use for your internal processes.
    pub payload: String,
    /// <em>Optional</em>. Payment provider token, obtained via <a href="https://t.me/botfather">@BotFather</a>. Pass an empty string for payments in <a href="https://t.me/BotNews/90">Telegram Stars</a>.
    #[serde(skip_serializing_if = "Option::is_none")]
    pub provider_token: Option<String>,
    /// Three-letter ISO 4217 currency code, see <a href="/bots/payments#supported-currencies">more on currencies</a>. Pass “XTR” for payments in <a href="https://t.me/BotNews/90">Telegram Stars</a>.
    pub currency: String,
    /// Price breakdown, a JSON-serialized list of components (e.g. product price, tax, discount, delivery cost, delivery tax, bonus, etc.). Must contain exactly one item for payments in <a href="https://t.me/BotNews/90">Telegram Stars</a>.
    pub prices: Vec<LabeledPrice>,
    /// <em>Optional</em>. The maximum accepted amount for tips in the <em>smallest units</em> of the currency (integer, <strong>not</strong> float/double). For example, for a maximum tip of <code>US$ 1.45</code> pass <code>max_tip_amount = 145</code>. See the <em>exp</em> parameter in <a href="/bots/payments/currencies.json">currencies.json</a>, it shows the number of digits past the decimal point for each currency (2 for the majority of currencies). Defaults to 0. Not supported for payments in <a href="https://t.me/BotNews/90">Telegram Stars</a>.
    #[serde(skip_serializing_if = "Option::is_none")]
    pub max_tip_amount: Option<Integer>,
    /// <em>Optional</em>. A JSON-serialized array of suggested amounts of tip in the <em>smallest units</em> of the currency (integer, <strong>not</strong> float/double). At most 4 suggested tip amounts can be specified. The suggested tip amounts must be positive, passed in a strictly increased order and must not exceed <em>max_tip_amount</em>.
    #[serde(skip_serializing_if = "Option::is_none")]
    pub suggested_tip_amounts: Option<Vec<Integer>>,
    /// <em>Optional</em>. A JSON-serialized object for data about the invoice, which will be shared with the payment provider. A detailed description of the required fields should be provided by the payment provider.
    #[serde(skip_serializing_if = "Option::is_none")]
    pub provider_data: Option<String>,
    /// <em>Optional</em>. URL of the product photo for the invoice. Can be a photo of the goods or a marketing image for a service.
    #[serde(skip_serializing_if = "Option::is_none")]
    pub photo_url: Option<String>,
    /// <em>Optional</em>. Photo size in bytes
    #[serde(skip_serializing_if = "Option::is_none")]
    pub photo_size: Option<Integer>,
    /// <em>Optional</em>. Photo width
    #[serde(skip_serializing_if = "Option::is_none")]
    pub photo_width: Option<Integer>,
    /// <em>Optional</em>. Photo height
    #[serde(skip_serializing_if = "Option::is_none")]
    pub photo_height: Option<Integer>,
    /// <em>Optional</em>. Pass <em>True</em> if you require the user's full name to complete the order. Ignored for payments in <a href="https://t.me/BotNews/90">Telegram Stars</a>.
    #[serde(skip_serializing_if = "Option::is_none")]
    pub need_name: Option<bool>,
    /// <em>Optional</em>. Pass <em>True</em> if you require the user's phone number to complete the order. Ignored for payments in <a href="https://t.me/BotNews/90">Telegram Stars</a>.
    #[serde(skip_serializing_if = "Option::is_none")]
    pub need_phone_number: Option<bool>,
    /// <em>Optional</em>. Pass <em>True</em> if you require the user's email address to complete the order. Ignored for payments in <a href="https://t.me/BotNews/90">Telegram Stars</a>.
    #[serde(skip_serializing_if = "Option::is_none")]
    pub need_email: Option<bool>,
    /// <em>Optional</em>. Pass <em>True</em> if you require the user's shipping address to complete the order. Ignored for payments in <a href="https://t.me/BotNews/90">Telegram Stars</a>.
    #[serde(skip_serializing_if = "Option::is_none")]
    pub need_shipping_address: Option<bool>,
    /// <em>Optional</em>. Pass <em>True</em> if the user's phone number should be sent to the provider. Ignored for payments in <a href="https://t.me/BotNews/90">Telegram Stars</a>.
    #[serde(skip_serializing_if = "Option::is_none")]
    pub send_phone_number_to_provider: Option<bool>,
    /// <em>Optional</em>. Pass <em>True</em> if the user's email address should be sent to the provider. Ignored for payments in <a href="https://t.me/BotNews/90">Telegram Stars</a>.
    #[serde(skip_serializing_if = "Option::is_none")]
    pub send_email_to_provider: Option<bool>,
    /// <em>Optional</em>. Pass <em>True</em> if the final price depends on the shipping method. Ignored for payments in <a href="https://t.me/BotNews/90">Telegram Stars</a>.
    #[serde(skip_serializing_if = "Option::is_none")]
    pub is_flexible: Option<bool>
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

/**
 * <p>Describes an inline message sent by a <a href="/bots/webapps">Web App</a> on behalf of a user.</p>
 *
 * @property inline_message_id <em>Optional</em>. Identifier of the sent inline message. Available only if there is an <a href="#inlinekeyboardmarkup">inline keyboard</a> attached to the message.
 *
 * @constructor Creates a [SentWebAppMessage].
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct SentWebAppMessage {
    /// <em>Optional</em>. Identifier of the sent inline message. Available only if there is an <a href="#inlinekeyboardmarkup">inline keyboard</a> attached to the message.
    #[serde(skip_serializing_if = "Option::is_none")]
    pub inline_message_id: Option<String>
}


/// Payments

/**
 * <p>This object represents a portion of the price for goods or services.</p>
 *
 * @property label Portion label
 * @property amount Price of the product in the <em>smallest units</em> of the <a href="/bots/payments#supported-currencies">currency</a> (integer, <strong>not</strong> float/double). For example, for a price of <code>US$ 1.45</code> pass <code>amount = 145</code>. See the <em>exp</em> parameter in <a href="/bots/payments/currencies.json">currencies.json</a>, it shows the number of digits past the decimal point for each currency (2 for the majority of currencies).
 *
 * @constructor Creates a [LabeledPrice].
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct LabeledPrice {
    /// Portion label
    pub label: String,
    /// Price of the product in the <em>smallest units</em> of the <a href="/bots/payments#supported-currencies">currency</a> (integer, <strong>not</strong> float/double). For example, for a price of <code>US$ 1.45</code> pass <code>amount = 145</code>. See the <em>exp</em> parameter in <a href="/bots/payments/currencies.json">currencies.json</a>, it shows the number of digits past the decimal point for each currency (2 for the majority of currencies).
    pub amount: Integer
}

/**
 * <p>This object contains basic information about an invoice.</p>
 *
 * @property title Product name
 * @property description Product description
 * @property start_parameter Unique bot deep-linking parameter that can be used to generate this invoice
 * @property currency Three-letter ISO 4217 <a href="/bots/payments#supported-currencies">currency</a> code, or “XTR” for payments in <a href="https://t.me/BotNews/90">Telegram Stars</a>
 * @property total_amount Total price in the <em>smallest units</em> of the currency (integer, <strong>not</strong> float/double). For example, for a price of <code>US$ 1.45</code> pass <code>amount = 145</code>. See the <em>exp</em> parameter in <a href="/bots/payments/currencies.json">currencies.json</a>, it shows the number of digits past the decimal point for each currency (2 for the majority of currencies).
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
    /// Three-letter ISO 4217 <a href="/bots/payments#supported-currencies">currency</a> code, or “XTR” for payments in <a href="https://t.me/BotNews/90">Telegram Stars</a>
    pub currency: String,
    /// Total price in the <em>smallest units</em> of the currency (integer, <strong>not</strong> float/double). For example, for a price of <code>US$ 1.45</code> pass <code>amount = 145</code>. See the <em>exp</em> parameter in <a href="/bots/payments/currencies.json">currencies.json</a>, it shows the number of digits past the decimal point for each currency (2 for the majority of currencies).
    pub total_amount: Integer
}

/**
 * <p>This object represents a shipping address.</p>
 *
 * @property country_code Two-letter <a href="https://en.wikipedia.org/wiki/ISO_3166-1_alpha-2">ISO 3166-1 alpha-2</a> country code
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
    /// Two-letter <a href="https://en.wikipedia.org/wiki/ISO_3166-1_alpha-2">ISO 3166-1 alpha-2</a> country code
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
 * @property currency Three-letter ISO 4217 <a href="/bots/payments#supported-currencies">currency</a> code, or “XTR” for payments in <a href="https://t.me/BotNews/90">Telegram Stars</a>
 * @property total_amount Total price in the <em>smallest units</em> of the currency (integer, <strong>not</strong> float/double). For example, for a price of <code>US$ 1.45</code> pass <code>amount = 145</code>. See the <em>exp</em> parameter in <a href="/bots/payments/currencies.json">currencies.json</a>, it shows the number of digits past the decimal point for each currency (2 for the majority of currencies).
 * @property invoice_payload Bot specified invoice payload
 * @property shipping_option_id <em>Optional</em>. Identifier of the shipping option chosen by the user
 * @property order_info <em>Optional</em>. Order information provided by the user
 * @property telegram_payment_charge_id Telegram payment identifier
 * @property provider_payment_charge_id Provider payment identifier
 *
 * @constructor Creates a [SuccessfulPayment].
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct SuccessfulPayment {
    /// Three-letter ISO 4217 <a href="/bots/payments#supported-currencies">currency</a> code, or “XTR” for payments in <a href="https://t.me/BotNews/90">Telegram Stars</a>
    pub currency: String,
    /// Total price in the <em>smallest units</em> of the currency (integer, <strong>not</strong> float/double). For example, for a price of <code>US$ 1.45</code> pass <code>amount = 145</code>. See the <em>exp</em> parameter in <a href="/bots/payments/currencies.json">currencies.json</a>, it shows the number of digits past the decimal point for each currency (2 for the majority of currencies).
    pub total_amount: Integer,
    /// Bot specified invoice payload
    pub invoice_payload: String,
    /// <em>Optional</em>. Identifier of the shipping option chosen by the user
    #[serde(skip_serializing_if = "Option::is_none")]
    pub shipping_option_id: Option<String>,
    /// <em>Optional</em>. Order information provided by the user
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
 * @property currency Three-letter ISO 4217 <a href="/bots/payments#supported-currencies">currency</a> code, or “XTR” for payments in <a href="https://t.me/BotNews/90">Telegram Stars</a>
 * @property total_amount Total price in the <em>smallest units</em> of the currency (integer, <strong>not</strong> float/double). For example, for a price of <code>US$ 1.45</code> pass <code>amount = 145</code>. See the <em>exp</em> parameter in <a href="/bots/payments/currencies.json">currencies.json</a>, it shows the number of digits past the decimal point for each currency (2 for the majority of currencies).
 * @property invoice_payload Bot specified invoice payload
 * @property shipping_option_id <em>Optional</em>. Identifier of the shipping option chosen by the user
 * @property order_info <em>Optional</em>. Order information provided by the user
 *
 * @constructor Creates a [PreCheckoutQuery].
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct PreCheckoutQuery {
    /// Unique query identifier
    pub id: String,
    /// User who sent the query
    pub from: User,
    /// Three-letter ISO 4217 <a href="/bots/payments#supported-currencies">currency</a> code, or “XTR” for payments in <a href="https://t.me/BotNews/90">Telegram Stars</a>
    pub currency: String,
    /// Total price in the <em>smallest units</em> of the currency (integer, <strong>not</strong> float/double). For example, for a price of <code>US$ 1.45</code> pass <code>amount = 145</code>. See the <em>exp</em> parameter in <a href="/bots/payments/currencies.json">currencies.json</a>, it shows the number of digits past the decimal point for each currency (2 for the majority of currencies).
    pub total_amount: Integer,
    /// Bot specified invoice payload
    pub invoice_payload: String,
    /// <em>Optional</em>. Identifier of the shipping option chosen by the user
    #[serde(skip_serializing_if = "Option::is_none")]
    pub shipping_option_id: Option<String>,
    /// <em>Optional</em>. Order information provided by the user
    #[serde(skip_serializing_if = "Option::is_none")]
    pub order_info: Option<OrderInfo>
}


/// Telegram Passport

/**
 * <p>Describes Telegram Passport data shared with the bot by the user.</p>
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
 * @property file_size File size in bytes
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
    /// File size in bytes
    pub file_size: Integer,
    /// Unix time when the file was uploaded
    pub file_date: Integer
}

/**
 * <p>Describes documents or other Telegram Passport elements shared with the bot by the user.</p>
 *
 * @property type Element type. One of “personal_details”, “passport”, “driver_license”, “identity_card”, “internal_passport”, “address”, “utility_bill”, “bank_statement”, “rental_agreement”, “passport_registration”, “temporary_registration”, “phone_number”, “email”.
 * @property data <em>Optional</em>. Base64-encoded encrypted Telegram Passport element data provided by the user; available only for “personal_details”, “passport”, “driver_license”, “identity_card”, “internal_passport” and “address” types. Can be decrypted and verified using the accompanying <a href="#encryptedcredentials">EncryptedCredentials</a>.
 * @property phone_number <em>Optional</em>. User's verified phone number; available only for “phone_number” type
 * @property email <em>Optional</em>. User's verified email address; available only for “email” type
 * @property files <em>Optional</em>. Array of encrypted files with documents provided by the user; available only for “utility_bill”, “bank_statement”, “rental_agreement”, “passport_registration” and “temporary_registration” types. Files can be decrypted and verified using the accompanying <a href="#encryptedcredentials">EncryptedCredentials</a>.
 * @property front_side <em>Optional</em>. Encrypted file with the front side of the document, provided by the user; available only for “passport”, “driver_license”, “identity_card” and “internal_passport”. The file can be decrypted and verified using the accompanying <a href="#encryptedcredentials">EncryptedCredentials</a>.
 * @property reverse_side <em>Optional</em>. Encrypted file with the reverse side of the document, provided by the user; available only for “driver_license” and “identity_card”. The file can be decrypted and verified using the accompanying <a href="#encryptedcredentials">EncryptedCredentials</a>.
 * @property selfie <em>Optional</em>. Encrypted file with the selfie of the user holding a document, provided by the user; available if requested for “passport”, “driver_license”, “identity_card” and “internal_passport”. The file can be decrypted and verified using the accompanying <a href="#encryptedcredentials">EncryptedCredentials</a>.
 * @property translation <em>Optional</em>. Array of encrypted files with translated versions of documents provided by the user; available if requested for “passport”, “driver_license”, “identity_card”, “internal_passport”, “utility_bill”, “bank_statement”, “rental_agreement”, “passport_registration” and “temporary_registration” types. Files can be decrypted and verified using the accompanying <a href="#encryptedcredentials">EncryptedCredentials</a>.
 * @property hash Base64-encoded element hash for using in <a href="#passportelementerrorunspecified">PassportElementErrorUnspecified</a>
 *
 * @constructor Creates a [EncryptedPassportElement].
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct EncryptedPassportElement {
    /// Element type. One of “personal_details”, “passport”, “driver_license”, “identity_card”, “internal_passport”, “address”, “utility_bill”, “bank_statement”, “rental_agreement”, “passport_registration”, “temporary_registration”, “phone_number”, “email”.
    #[serde(rename = "type")]
    pub type_: String,
    /// <em>Optional</em>. Base64-encoded encrypted Telegram Passport element data provided by the user; available only for “personal_details”, “passport”, “driver_license”, “identity_card”, “internal_passport” and “address” types. Can be decrypted and verified using the accompanying <a href="#encryptedcredentials">EncryptedCredentials</a>.
    #[serde(skip_serializing_if = "Option::is_none")]
    pub data: Option<String>,
    /// <em>Optional</em>. User's verified phone number; available only for “phone_number” type
    #[serde(skip_serializing_if = "Option::is_none")]
    pub phone_number: Option<String>,
    /// <em>Optional</em>. User's verified email address; available only for “email” type
    #[serde(skip_serializing_if = "Option::is_none")]
    pub email: Option<String>,
    /// <em>Optional</em>. Array of encrypted files with documents provided by the user; available only for “utility_bill”, “bank_statement”, “rental_agreement”, “passport_registration” and “temporary_registration” types. Files can be decrypted and verified using the accompanying <a href="#encryptedcredentials">EncryptedCredentials</a>.
    #[serde(skip_serializing_if = "Option::is_none")]
    pub files: Option<Vec<PassportFile>>,
    /// <em>Optional</em>. Encrypted file with the front side of the document, provided by the user; available only for “passport”, “driver_license”, “identity_card” and “internal_passport”. The file can be decrypted and verified using the accompanying <a href="#encryptedcredentials">EncryptedCredentials</a>.
    #[serde(skip_serializing_if = "Option::is_none")]
    pub front_side: Option<PassportFile>,
    /// <em>Optional</em>. Encrypted file with the reverse side of the document, provided by the user; available only for “driver_license” and “identity_card”. The file can be decrypted and verified using the accompanying <a href="#encryptedcredentials">EncryptedCredentials</a>.
    #[serde(skip_serializing_if = "Option::is_none")]
    pub reverse_side: Option<PassportFile>,
    /// <em>Optional</em>. Encrypted file with the selfie of the user holding a document, provided by the user; available if requested for “passport”, “driver_license”, “identity_card” and “internal_passport”. The file can be decrypted and verified using the accompanying <a href="#encryptedcredentials">EncryptedCredentials</a>.
    #[serde(skip_serializing_if = "Option::is_none")]
    pub selfie: Option<PassportFile>,
    /// <em>Optional</em>. Array of encrypted files with translated versions of documents provided by the user; available if requested for “passport”, “driver_license”, “identity_card”, “internal_passport”, “utility_bill”, “bank_statement”, “rental_agreement”, “passport_registration” and “temporary_registration” types. Files can be decrypted and verified using the accompanying <a href="#encryptedcredentials">EncryptedCredentials</a>.
    #[serde(skip_serializing_if = "Option::is_none")]
    pub translation: Option<Vec<PassportFile>>,
    /// Base64-encoded element hash for using in <a href="#passportelementerrorunspecified">PassportElementErrorUnspecified</a>
    pub hash: String
}

/**
 * <p>Describes data required for decrypting and authenticating <a href="#encryptedpassportelement">EncryptedPassportElement</a>. See the <a href="/passport#receiving-information">Telegram Passport Documentation</a> for a complete description of the data decryption and authentication processes.</p>
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
 * <p>Use this method to receive incoming updates using long polling (<a href="https://en.wikipedia.org/wiki/Push_technology#Long_polling">wiki</a>). Returns an Array of <a href="#update">Update</a> objects.</p><blockquote>
 *  <p><strong>Notes</strong><br><strong>1.</strong> This method will not work if an outgoing webhook is set up.<br><strong>2.</strong> In order to avoid getting duplicate updates, recalculate <em>offset</em> after each server response.</p>
 * </blockquote>
 *
 * @property offset Identifier of the first update to be returned. Must be greater by one than the highest among the identifiers of previously received updates. By default, updates starting with the earliest unconfirmed update are returned. An update is considered confirmed as soon as <a href="#getupdates">getUpdates</a> is called with an <em>offset</em> higher than its <em>update_id</em>. The negative offset can be specified to retrieve updates starting from <em>-offset</em> update from the end of the updates queue. All previous updates will be forgotten.
 * @property limit Limits the number of updates to be retrieved. Values between 1-100 are accepted. Defaults to 100.
 * @property timeout Timeout in seconds for long polling. Defaults to 0, i.e. usual short polling. Should be positive, short polling should be used for testing purposes only.
 * @property allowed_updates A JSON-serialized list of the update types you want your bot to receive. For example, specify <code>["message", "edited_channel_post", "callback_query"]</code> to only receive updates of these types. See <a href="#update">Update</a> for a complete list of available update types. Specify an empty list to receive all update types except <em>chat_member</em>, <em>message_reaction</em>, and <em>message_reaction_count</em> (default). If not specified, the previous setting will be used.<br><br>Please note that this parameter doesn't affect updates created before the call to the getUpdates, so unwanted updates may be received for a short period of time.
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct GetUpdatesRequest {
    /// Identifier of the first update to be returned. Must be greater by one than the highest among the identifiers of previously received updates. By default, updates starting with the earliest unconfirmed update are returned. An update is considered confirmed as soon as <a href="#getupdates">getUpdates</a> is called with an <em>offset</em> higher than its <em>update_id</em>. The negative offset can be specified to retrieve updates starting from <em>-offset</em> update from the end of the updates queue. All previous updates will be forgotten.
    pub offset: Option<Integer>,
    /// Limits the number of updates to be retrieved. Values between 1-100 are accepted. Defaults to 100.
    pub limit: Option<Integer>,
    /// Timeout in seconds for long polling. Defaults to 0, i.e. usual short polling. Should be positive, short polling should be used for testing purposes only.
    pub timeout: Option<Integer>,
    /// A JSON-serialized list of the update types you want your bot to receive. For example, specify <code>["message", "edited_channel_post", "callback_query"]</code> to only receive updates of these types. See <a href="#update">Update</a> for a complete list of available update types. Specify an empty list to receive all update types except <em>chat_member</em>, <em>message_reaction</em>, and <em>message_reaction_count</em> (default). If not specified, the previous setting will be used.<br><br>Please note that this parameter doesn't affect updates created before the call to the getUpdates, so unwanted updates may be received for a short period of time.
    pub allowed_updates: Option<Vec<String>>
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
 * @property allowed_updates A JSON-serialized list of the update types you want your bot to receive. For example, specify <code>["message", "edited_channel_post", "callback_query"]</code> to only receive updates of these types. See <a href="#update">Update</a> for a complete list of available update types. Specify an empty list to receive all update types except <em>chat_member</em>, <em>message_reaction</em>, and <em>message_reaction_count</em> (default). If not specified, the previous setting will be used.<br>Please note that this parameter doesn't affect updates created before the call to the setWebhook, so unwanted updates may be received for a short period of time.
 * @property drop_pending_updates Pass <em>True</em> to drop all pending updates
 * @property secret_token A secret token to be sent in a header “X-Telegram-Bot-Api-Secret-Token” in every webhook request, 1-256 characters. Only characters <code>A-Z</code>, <code>a-z</code>, <code>0-9</code>, <code>_</code> and <code>-</code> are allowed. The header is useful to ensure that the request comes from a webhook set by you.
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct SetWebhookRequest {
    /// HTTPS URL to send updates to. Use an empty string to remove webhook integration
    pub url: String,
    /// Upload your public key certificate so that the root certificate in use can be checked. See our <a href="/bots/self-signed">self-signed guide</a> for details.
    pub certificate: Option<InputFile>,
    /// The fixed IP address which will be used to send webhook requests instead of the IP address resolved through DNS
    pub ip_address: Option<String>,
    /// The maximum allowed number of simultaneous HTTPS connections to the webhook for update delivery, 1-100. Defaults to <em>40</em>. Use lower values to limit the load on your bot's server, and higher values to increase your bot's throughput.
    pub max_connections: Option<Integer>,
    /// A JSON-serialized list of the update types you want your bot to receive. For example, specify <code>["message", "edited_channel_post", "callback_query"]</code> to only receive updates of these types. See <a href="#update">Update</a> for a complete list of available update types. Specify an empty list to receive all update types except <em>chat_member</em>, <em>message_reaction</em>, and <em>message_reaction_count</em> (default). If not specified, the previous setting will be used.<br>Please note that this parameter doesn't affect updates created before the call to the setWebhook, so unwanted updates may be received for a short period of time.
    pub allowed_updates: Option<Vec<String>>,
    /// Pass <em>True</em> to drop all pending updates
    pub drop_pending_updates: Option<bool>,
    /// A secret token to be sent in a header “X-Telegram-Bot-Api-Secret-Token” in every webhook request, 1-256 characters. Only characters <code>A-Z</code>, <code>a-z</code>, <code>0-9</code>, <code>_</code> and <code>-</code> are allowed. The header is useful to ensure that the request comes from a webhook set by you.
    pub secret_token: Option<String>
}

/**
 * <p>Use this method to remove webhook integration if you decide to switch back to <a href="#getupdates">getUpdates</a>. Returns <em>True</em> on success.</p>
 *
 * @property drop_pending_updates Pass <em>True</em> to drop all pending updates
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct DeleteWebhookRequest {
    /// Pass <em>True</em> to drop all pending updates
    pub drop_pending_updates: Option<bool>
}


/// Available methods

/**
 * <p>Use this method to send text messages. On success, the sent <a href="#message">Message</a> is returned.</p>
 *
 * @property business_connection_id Unique identifier of the business connection on behalf of which the message will be sent
 * @property chat_id Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>)
 * @property message_thread_id Unique identifier for the target message thread (topic) of the forum; for forum supergroups only
 * @property text Text of the message to be sent, 1-4096 characters after entities parsing
 * @property parse_mode Mode for parsing entities in the message text. See <a href="#formatting-options">formatting options</a> for more details.
 * @property entities A JSON-serialized list of special entities that appear in message text, which can be specified instead of <em>parse_mode</em>
 * @property link_preview_options Link preview generation options for the message
 * @property disable_notification Sends the message <a href="https://telegram.org/blog/channels-2-0#silent-messages">silently</a>. Users will receive a notification with no sound.
 * @property protect_content Protects the contents of the sent message from forwarding and saving
 * @property message_effect_id Unique identifier of the message effect to be added to the message; for private chats only
 * @property reply_parameters Description of the message to reply to
 * @property reply_markup Additional interface options. A JSON-serialized object for an <a href="/bots/features#inline-keyboards">inline keyboard</a>, <a href="/bots/features#keyboards">custom reply keyboard</a>, instructions to remove a reply keyboard or to force a reply from the user
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct SendMessageRequest {
    /// Unique identifier of the business connection on behalf of which the message will be sent
    pub business_connection_id: Option<String>,
    /// Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>)
    pub chat_id: String,
    /// Unique identifier for the target message thread (topic) of the forum; for forum supergroups only
    pub message_thread_id: Option<Integer>,
    /// Text of the message to be sent, 1-4096 characters after entities parsing
    pub text: String,
    /// Mode for parsing entities in the message text. See <a href="#formatting-options">formatting options</a> for more details.
    pub parse_mode: Option<ParseMode>,
    /// A JSON-serialized list of special entities that appear in message text, which can be specified instead of <em>parse_mode</em>
    pub entities: Option<Vec<MessageEntity>>,
    /// Link preview generation options for the message
    pub link_preview_options: Option<LinkPreviewOptions>,
    /// Sends the message <a href="https://telegram.org/blog/channels-2-0#silent-messages">silently</a>. Users will receive a notification with no sound.
    pub disable_notification: Option<bool>,
    /// Protects the contents of the sent message from forwarding and saving
    pub protect_content: Option<bool>,
    /// Unique identifier of the message effect to be added to the message; for private chats only
    pub message_effect_id: Option<String>,
    /// Description of the message to reply to
    pub reply_parameters: Option<ReplyParameters>,
    /// Additional interface options. A JSON-serialized object for an <a href="/bots/features#inline-keyboards">inline keyboard</a>, <a href="/bots/features#keyboards">custom reply keyboard</a>, instructions to remove a reply keyboard or to force a reply from the user
    pub reply_markup: Option<KeyboardOption>
}

/**
 * <p>Use this method to forward messages of any kind. Service messages and messages with protected content can't be forwarded. On success, the sent <a href="#message">Message</a> is returned.</p>
 *
 * @property chat_id Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>)
 * @property message_thread_id Unique identifier for the target message thread (topic) of the forum; for forum supergroups only
 * @property from_chat_id Unique identifier for the chat where the original message was sent (or channel username in the format <code>@channelusername</code>)
 * @property disable_notification Sends the message <a href="https://telegram.org/blog/channels-2-0#silent-messages">silently</a>. Users will receive a notification with no sound.
 * @property protect_content Protects the contents of the forwarded message from forwarding and saving
 * @property message_id Message identifier in the chat specified in <em>from_chat_id</em>
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct ForwardMessageRequest {
    /// Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>)
    pub chat_id: String,
    /// Unique identifier for the target message thread (topic) of the forum; for forum supergroups only
    pub message_thread_id: Option<Integer>,
    /// Unique identifier for the chat where the original message was sent (or channel username in the format <code>@channelusername</code>)
    pub from_chat_id: String,
    /// Sends the message <a href="https://telegram.org/blog/channels-2-0#silent-messages">silently</a>. Users will receive a notification with no sound.
    pub disable_notification: Option<bool>,
    /// Protects the contents of the forwarded message from forwarding and saving
    pub protect_content: Option<bool>,
    /// Message identifier in the chat specified in <em>from_chat_id</em>
    pub message_id: Integer
}

/**
 * <p>Use this method to forward multiple messages of any kind. If some of the specified messages can't be found or forwarded, they are skipped. Service messages and messages with protected content can't be forwarded. Album grouping is kept for forwarded messages. On success, an array of <a href="#messageid">MessageId</a> of the sent messages is returned.</p>
 *
 * @property chat_id Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>)
 * @property message_thread_id Unique identifier for the target message thread (topic) of the forum; for forum supergroups only
 * @property from_chat_id Unique identifier for the chat where the original messages were sent (or channel username in the format <code>@channelusername</code>)
 * @property message_ids A JSON-serialized list of 1-100 identifiers of messages in the chat <em>from_chat_id</em> to forward. The identifiers must be specified in a strictly increasing order.
 * @property disable_notification Sends the messages <a href="https://telegram.org/blog/channels-2-0#silent-messages">silently</a>. Users will receive a notification with no sound.
 * @property protect_content Protects the contents of the forwarded messages from forwarding and saving
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct ForwardMessagesRequest {
    /// Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>)
    pub chat_id: String,
    /// Unique identifier for the target message thread (topic) of the forum; for forum supergroups only
    pub message_thread_id: Option<Integer>,
    /// Unique identifier for the chat where the original messages were sent (or channel username in the format <code>@channelusername</code>)
    pub from_chat_id: String,
    /// A JSON-serialized list of 1-100 identifiers of messages in the chat <em>from_chat_id</em> to forward. The identifiers must be specified in a strictly increasing order.
    pub message_ids: Vec<Integer>,
    /// Sends the messages <a href="https://telegram.org/blog/channels-2-0#silent-messages">silently</a>. Users will receive a notification with no sound.
    pub disable_notification: Option<bool>,
    /// Protects the contents of the forwarded messages from forwarding and saving
    pub protect_content: Option<bool>
}

/**
 * <p>Use this method to copy messages of any kind. Service messages, giveaway messages, giveaway winners messages, and invoice messages can't be copied. A quiz <a href="#poll">poll</a> can be copied only if the value of the field <em>correct_option_id</em> is known to the bot. The method is analogous to the method <a href="#forwardmessage">forwardMessage</a>, but the copied message doesn't have a link to the original message. Returns the <a href="#messageid">MessageId</a> of the sent message on success.</p>
 *
 * @property chat_id Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>)
 * @property message_thread_id Unique identifier for the target message thread (topic) of the forum; for forum supergroups only
 * @property from_chat_id Unique identifier for the chat where the original message was sent (or channel username in the format <code>@channelusername</code>)
 * @property message_id Message identifier in the chat specified in <em>from_chat_id</em>
 * @property caption New caption for media, 0-1024 characters after entities parsing. If not specified, the original caption is kept
 * @property parse_mode Mode for parsing entities in the new caption. See <a href="#formatting-options">formatting options</a> for more details.
 * @property caption_entities A JSON-serialized list of special entities that appear in the new caption, which can be specified instead of <em>parse_mode</em>
 * @property show_caption_above_media Pass <em>True</em>, if the caption must be shown above the message media. Ignored if a new caption isn't specified.
 * @property disable_notification Sends the message <a href="https://telegram.org/blog/channels-2-0#silent-messages">silently</a>. Users will receive a notification with no sound.
 * @property protect_content Protects the contents of the sent message from forwarding and saving
 * @property reply_parameters Description of the message to reply to
 * @property reply_markup Additional interface options. A JSON-serialized object for an <a href="/bots/features#inline-keyboards">inline keyboard</a>, <a href="/bots/features#keyboards">custom reply keyboard</a>, instructions to remove a reply keyboard or to force a reply from the user
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct CopyMessageRequest {
    /// Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>)
    pub chat_id: String,
    /// Unique identifier for the target message thread (topic) of the forum; for forum supergroups only
    pub message_thread_id: Option<Integer>,
    /// Unique identifier for the chat where the original message was sent (or channel username in the format <code>@channelusername</code>)
    pub from_chat_id: String,
    /// Message identifier in the chat specified in <em>from_chat_id</em>
    pub message_id: Integer,
    /// New caption for media, 0-1024 characters after entities parsing. If not specified, the original caption is kept
    pub caption: Option<String>,
    /// Mode for parsing entities in the new caption. See <a href="#formatting-options">formatting options</a> for more details.
    pub parse_mode: Option<ParseMode>,
    /// A JSON-serialized list of special entities that appear in the new caption, which can be specified instead of <em>parse_mode</em>
    pub caption_entities: Option<Vec<MessageEntity>>,
    /// Pass <em>True</em>, if the caption must be shown above the message media. Ignored if a new caption isn't specified.
    pub show_caption_above_media: Option<bool>,
    /// Sends the message <a href="https://telegram.org/blog/channels-2-0#silent-messages">silently</a>. Users will receive a notification with no sound.
    pub disable_notification: Option<bool>,
    /// Protects the contents of the sent message from forwarding and saving
    pub protect_content: Option<bool>,
    /// Description of the message to reply to
    pub reply_parameters: Option<ReplyParameters>,
    /// Additional interface options. A JSON-serialized object for an <a href="/bots/features#inline-keyboards">inline keyboard</a>, <a href="/bots/features#keyboards">custom reply keyboard</a>, instructions to remove a reply keyboard or to force a reply from the user
    pub reply_markup: Option<KeyboardOption>
}

/**
 * <p>Use this method to copy messages of any kind. If some of the specified messages can't be found or copied, they are skipped. Service messages, giveaway messages, giveaway winners messages, and invoice messages can't be copied. A quiz <a href="#poll">poll</a> can be copied only if the value of the field <em>correct_option_id</em> is known to the bot. The method is analogous to the method <a href="#forwardmessages">forwardMessages</a>, but the copied messages don't have a link to the original message. Album grouping is kept for copied messages. On success, an array of <a href="#messageid">MessageId</a> of the sent messages is returned.</p>
 *
 * @property chat_id Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>)
 * @property message_thread_id Unique identifier for the target message thread (topic) of the forum; for forum supergroups only
 * @property from_chat_id Unique identifier for the chat where the original messages were sent (or channel username in the format <code>@channelusername</code>)
 * @property message_ids A JSON-serialized list of 1-100 identifiers of messages in the chat <em>from_chat_id</em> to copy. The identifiers must be specified in a strictly increasing order.
 * @property disable_notification Sends the messages <a href="https://telegram.org/blog/channels-2-0#silent-messages">silently</a>. Users will receive a notification with no sound.
 * @property protect_content Protects the contents of the sent messages from forwarding and saving
 * @property remove_caption Pass <em>True</em> to copy the messages without their captions
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct CopyMessagesRequest {
    /// Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>)
    pub chat_id: String,
    /// Unique identifier for the target message thread (topic) of the forum; for forum supergroups only
    pub message_thread_id: Option<Integer>,
    /// Unique identifier for the chat where the original messages were sent (or channel username in the format <code>@channelusername</code>)
    pub from_chat_id: String,
    /// A JSON-serialized list of 1-100 identifiers of messages in the chat <em>from_chat_id</em> to copy. The identifiers must be specified in a strictly increasing order.
    pub message_ids: Vec<Integer>,
    /// Sends the messages <a href="https://telegram.org/blog/channels-2-0#silent-messages">silently</a>. Users will receive a notification with no sound.
    pub disable_notification: Option<bool>,
    /// Protects the contents of the sent messages from forwarding and saving
    pub protect_content: Option<bool>,
    /// Pass <em>True</em> to copy the messages without their captions
    pub remove_caption: Option<bool>
}

/**
 * <p>Use this method to send photos. On success, the sent <a href="#message">Message</a> is returned.</p>
 *
 * @property business_connection_id Unique identifier of the business connection on behalf of which the message will be sent
 * @property chat_id Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>)
 * @property message_thread_id Unique identifier for the target message thread (topic) of the forum; for forum supergroups only
 * @property photo Photo to send. Pass a file_id as String to send a photo that exists on the Telegram servers (recommended), pass an HTTP URL as a String for Telegram to get a photo from the Internet, or upload a new photo using multipart/form-data. The photo must be at most 10 MB in size. The photo's width and height must not exceed 10000 in total. Width and height ratio must be at most 20. <a href="#sending-files">More information on Sending Files »</a>
 * @property caption Photo caption (may also be used when resending photos by <em>file_id</em>), 0-1024 characters after entities parsing
 * @property parse_mode Mode for parsing entities in the photo caption. See <a href="#formatting-options">formatting options</a> for more details.
 * @property caption_entities A JSON-serialized list of special entities that appear in the caption, which can be specified instead of <em>parse_mode</em>
 * @property show_caption_above_media Pass <em>True</em>, if the caption must be shown above the message media
 * @property has_spoiler Pass <em>True</em> if the photo needs to be covered with a spoiler animation
 * @property disable_notification Sends the message <a href="https://telegram.org/blog/channels-2-0#silent-messages">silently</a>. Users will receive a notification with no sound.
 * @property protect_content Protects the contents of the sent message from forwarding and saving
 * @property message_effect_id Unique identifier of the message effect to be added to the message; for private chats only
 * @property reply_parameters Description of the message to reply to
 * @property reply_markup Additional interface options. A JSON-serialized object for an <a href="/bots/features#inline-keyboards">inline keyboard</a>, <a href="/bots/features#keyboards">custom reply keyboard</a>, instructions to remove a reply keyboard or to force a reply from the user
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct SendPhotoRequest {
    /// Unique identifier of the business connection on behalf of which the message will be sent
    pub business_connection_id: Option<String>,
    /// Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>)
    pub chat_id: String,
    /// Unique identifier for the target message thread (topic) of the forum; for forum supergroups only
    pub message_thread_id: Option<Integer>,
    /// Photo to send. Pass a file_id as String to send a photo that exists on the Telegram servers (recommended), pass an HTTP URL as a String for Telegram to get a photo from the Internet, or upload a new photo using multipart/form-data. The photo must be at most 10 MB in size. The photo's width and height must not exceed 10000 in total. Width and height ratio must be at most 20. <a href="#sending-files">More information on Sending Files »</a>
    pub photo: String,
    /// Photo caption (may also be used when resending photos by <em>file_id</em>), 0-1024 characters after entities parsing
    pub caption: Option<String>,
    /// Mode for parsing entities in the photo caption. See <a href="#formatting-options">formatting options</a> for more details.
    pub parse_mode: Option<ParseMode>,
    /// A JSON-serialized list of special entities that appear in the caption, which can be specified instead of <em>parse_mode</em>
    pub caption_entities: Option<Vec<MessageEntity>>,
    /// Pass <em>True</em>, if the caption must be shown above the message media
    pub show_caption_above_media: Option<bool>,
    /// Pass <em>True</em> if the photo needs to be covered with a spoiler animation
    pub has_spoiler: Option<bool>,
    /// Sends the message <a href="https://telegram.org/blog/channels-2-0#silent-messages">silently</a>. Users will receive a notification with no sound.
    pub disable_notification: Option<bool>,
    /// Protects the contents of the sent message from forwarding and saving
    pub protect_content: Option<bool>,
    /// Unique identifier of the message effect to be added to the message; for private chats only
    pub message_effect_id: Option<String>,
    /// Description of the message to reply to
    pub reply_parameters: Option<ReplyParameters>,
    /// Additional interface options. A JSON-serialized object for an <a href="/bots/features#inline-keyboards">inline keyboard</a>, <a href="/bots/features#keyboards">custom reply keyboard</a>, instructions to remove a reply keyboard or to force a reply from the user
    pub reply_markup: Option<KeyboardOption>
}

/**
 * <p>Use this method to send audio files, if you want Telegram clients to display them in the music player. Your audio must be in the .MP3 or .M4A format. On success, the sent <a href="#message">Message</a> is returned. Bots can currently send audio files of up to 50 MB in size, this limit may be changed in the future.</p><p>For sending voice messages, use the <a href="#sendvoice">sendVoice</a> method instead.</p>
 *
 * @property business_connection_id Unique identifier of the business connection on behalf of which the message will be sent
 * @property chat_id Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>)
 * @property message_thread_id Unique identifier for the target message thread (topic) of the forum; for forum supergroups only
 * @property audio Audio file to send. Pass a file_id as String to send an audio file that exists on the Telegram servers (recommended), pass an HTTP URL as a String for Telegram to get an audio file from the Internet, or upload a new one using multipart/form-data. <a href="#sending-files">More information on Sending Files »</a>
 * @property caption Audio caption, 0-1024 characters after entities parsing
 * @property parse_mode Mode for parsing entities in the audio caption. See <a href="#formatting-options">formatting options</a> for more details.
 * @property caption_entities A JSON-serialized list of special entities that appear in the caption, which can be specified instead of <em>parse_mode</em>
 * @property duration Duration of the audio in seconds
 * @property performer Performer
 * @property title Track name
 * @property thumbnail Thumbnail of the file sent; can be ignored if thumbnail generation for the file is supported server-side. The thumbnail should be in JPEG format and less than 200 kB in size. A thumbnail's width and height should not exceed 320. Ignored if the file is not uploaded using multipart/form-data. Thumbnails can't be reused and can be only uploaded as a new file, so you can pass “attach://&lt;file_attach_name&gt;” if the thumbnail was uploaded using multipart/form-data under &lt;file_attach_name&gt;. <a href="#sending-files">More information on Sending Files »</a>
 * @property disable_notification Sends the message <a href="https://telegram.org/blog/channels-2-0#silent-messages">silently</a>. Users will receive a notification with no sound.
 * @property protect_content Protects the contents of the sent message from forwarding and saving
 * @property message_effect_id Unique identifier of the message effect to be added to the message; for private chats only
 * @property reply_parameters Description of the message to reply to
 * @property reply_markup Additional interface options. A JSON-serialized object for an <a href="/bots/features#inline-keyboards">inline keyboard</a>, <a href="/bots/features#keyboards">custom reply keyboard</a>, instructions to remove a reply keyboard or to force a reply from the user
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct SendAudioRequest {
    /// Unique identifier of the business connection on behalf of which the message will be sent
    pub business_connection_id: Option<String>,
    /// Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>)
    pub chat_id: String,
    /// Unique identifier for the target message thread (topic) of the forum; for forum supergroups only
    pub message_thread_id: Option<Integer>,
    /// Audio file to send. Pass a file_id as String to send an audio file that exists on the Telegram servers (recommended), pass an HTTP URL as a String for Telegram to get an audio file from the Internet, or upload a new one using multipart/form-data. <a href="#sending-files">More information on Sending Files »</a>
    pub audio: String,
    /// Audio caption, 0-1024 characters after entities parsing
    pub caption: Option<String>,
    /// Mode for parsing entities in the audio caption. See <a href="#formatting-options">formatting options</a> for more details.
    pub parse_mode: Option<ParseMode>,
    /// A JSON-serialized list of special entities that appear in the caption, which can be specified instead of <em>parse_mode</em>
    pub caption_entities: Option<Vec<MessageEntity>>,
    /// Duration of the audio in seconds
    pub duration: Option<Integer>,
    /// Performer
    pub performer: Option<String>,
    /// Track name
    pub title: Option<String>,
    /// Thumbnail of the file sent; can be ignored if thumbnail generation for the file is supported server-side. The thumbnail should be in JPEG format and less than 200 kB in size. A thumbnail's width and height should not exceed 320. Ignored if the file is not uploaded using multipart/form-data. Thumbnails can't be reused and can be only uploaded as a new file, so you can pass “attach://&lt;file_attach_name&gt;” if the thumbnail was uploaded using multipart/form-data under &lt;file_attach_name&gt;. <a href="#sending-files">More information on Sending Files »</a>
    pub thumbnail: Option<String>,
    /// Sends the message <a href="https://telegram.org/blog/channels-2-0#silent-messages">silently</a>. Users will receive a notification with no sound.
    pub disable_notification: Option<bool>,
    /// Protects the contents of the sent message from forwarding and saving
    pub protect_content: Option<bool>,
    /// Unique identifier of the message effect to be added to the message; for private chats only
    pub message_effect_id: Option<String>,
    /// Description of the message to reply to
    pub reply_parameters: Option<ReplyParameters>,
    /// Additional interface options. A JSON-serialized object for an <a href="/bots/features#inline-keyboards">inline keyboard</a>, <a href="/bots/features#keyboards">custom reply keyboard</a>, instructions to remove a reply keyboard or to force a reply from the user
    pub reply_markup: Option<KeyboardOption>
}

/**
 * <p>Use this method to send general files. On success, the sent <a href="#message">Message</a> is returned. Bots can currently send files of any type of up to 50 MB in size, this limit may be changed in the future.</p>
 *
 * @property business_connection_id Unique identifier of the business connection on behalf of which the message will be sent
 * @property chat_id Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>)
 * @property message_thread_id Unique identifier for the target message thread (topic) of the forum; for forum supergroups only
 * @property document File to send. Pass a file_id as String to send a file that exists on the Telegram servers (recommended), pass an HTTP URL as a String for Telegram to get a file from the Internet, or upload a new one using multipart/form-data. <a href="#sending-files">More information on Sending Files »</a>
 * @property thumbnail Thumbnail of the file sent; can be ignored if thumbnail generation for the file is supported server-side. The thumbnail should be in JPEG format and less than 200 kB in size. A thumbnail's width and height should not exceed 320. Ignored if the file is not uploaded using multipart/form-data. Thumbnails can't be reused and can be only uploaded as a new file, so you can pass “attach://&lt;file_attach_name&gt;” if the thumbnail was uploaded using multipart/form-data under &lt;file_attach_name&gt;. <a href="#sending-files">More information on Sending Files »</a>
 * @property caption Document caption (may also be used when resending documents by <em>file_id</em>), 0-1024 characters after entities parsing
 * @property parse_mode Mode for parsing entities in the document caption. See <a href="#formatting-options">formatting options</a> for more details.
 * @property caption_entities A JSON-serialized list of special entities that appear in the caption, which can be specified instead of <em>parse_mode</em>
 * @property disable_content_type_detection Disables automatic server-side content type detection for files uploaded using multipart/form-data
 * @property disable_notification Sends the message <a href="https://telegram.org/blog/channels-2-0#silent-messages">silently</a>. Users will receive a notification with no sound.
 * @property protect_content Protects the contents of the sent message from forwarding and saving
 * @property message_effect_id Unique identifier of the message effect to be added to the message; for private chats only
 * @property reply_parameters Description of the message to reply to
 * @property reply_markup Additional interface options. A JSON-serialized object for an <a href="/bots/features#inline-keyboards">inline keyboard</a>, <a href="/bots/features#keyboards">custom reply keyboard</a>, instructions to remove a reply keyboard or to force a reply from the user
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct SendDocumentRequest {
    /// Unique identifier of the business connection on behalf of which the message will be sent
    pub business_connection_id: Option<String>,
    /// Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>)
    pub chat_id: String,
    /// Unique identifier for the target message thread (topic) of the forum; for forum supergroups only
    pub message_thread_id: Option<Integer>,
    /// File to send. Pass a file_id as String to send a file that exists on the Telegram servers (recommended), pass an HTTP URL as a String for Telegram to get a file from the Internet, or upload a new one using multipart/form-data. <a href="#sending-files">More information on Sending Files »</a>
    pub document: String,
    /// Thumbnail of the file sent; can be ignored if thumbnail generation for the file is supported server-side. The thumbnail should be in JPEG format and less than 200 kB in size. A thumbnail's width and height should not exceed 320. Ignored if the file is not uploaded using multipart/form-data. Thumbnails can't be reused and can be only uploaded as a new file, so you can pass “attach://&lt;file_attach_name&gt;” if the thumbnail was uploaded using multipart/form-data under &lt;file_attach_name&gt;. <a href="#sending-files">More information on Sending Files »</a>
    pub thumbnail: Option<String>,
    /// Document caption (may also be used when resending documents by <em>file_id</em>), 0-1024 characters after entities parsing
    pub caption: Option<String>,
    /// Mode for parsing entities in the document caption. See <a href="#formatting-options">formatting options</a> for more details.
    pub parse_mode: Option<ParseMode>,
    /// A JSON-serialized list of special entities that appear in the caption, which can be specified instead of <em>parse_mode</em>
    pub caption_entities: Option<Vec<MessageEntity>>,
    /// Disables automatic server-side content type detection for files uploaded using multipart/form-data
    pub disable_content_type_detection: Option<bool>,
    /// Sends the message <a href="https://telegram.org/blog/channels-2-0#silent-messages">silently</a>. Users will receive a notification with no sound.
    pub disable_notification: Option<bool>,
    /// Protects the contents of the sent message from forwarding and saving
    pub protect_content: Option<bool>,
    /// Unique identifier of the message effect to be added to the message; for private chats only
    pub message_effect_id: Option<String>,
    /// Description of the message to reply to
    pub reply_parameters: Option<ReplyParameters>,
    /// Additional interface options. A JSON-serialized object for an <a href="/bots/features#inline-keyboards">inline keyboard</a>, <a href="/bots/features#keyboards">custom reply keyboard</a>, instructions to remove a reply keyboard or to force a reply from the user
    pub reply_markup: Option<KeyboardOption>
}

/**
 * <p>Use this method to send video files, Telegram clients support MPEG4 videos (other formats may be sent as <a href="#document">Document</a>). On success, the sent <a href="#message">Message</a> is returned. Bots can currently send video files of up to 50 MB in size, this limit may be changed in the future.</p>
 *
 * @property business_connection_id Unique identifier of the business connection on behalf of which the message will be sent
 * @property chat_id Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>)
 * @property message_thread_id Unique identifier for the target message thread (topic) of the forum; for forum supergroups only
 * @property video Video to send. Pass a file_id as String to send a video that exists on the Telegram servers (recommended), pass an HTTP URL as a String for Telegram to get a video from the Internet, or upload a new video using multipart/form-data. <a href="#sending-files">More information on Sending Files »</a>
 * @property duration Duration of sent video in seconds
 * @property width Video width
 * @property height Video height
 * @property thumbnail Thumbnail of the file sent; can be ignored if thumbnail generation for the file is supported server-side. The thumbnail should be in JPEG format and less than 200 kB in size. A thumbnail's width and height should not exceed 320. Ignored if the file is not uploaded using multipart/form-data. Thumbnails can't be reused and can be only uploaded as a new file, so you can pass “attach://&lt;file_attach_name&gt;” if the thumbnail was uploaded using multipart/form-data under &lt;file_attach_name&gt;. <a href="#sending-files">More information on Sending Files »</a>
 * @property caption Video caption (may also be used when resending videos by <em>file_id</em>), 0-1024 characters after entities parsing
 * @property parse_mode Mode for parsing entities in the video caption. See <a href="#formatting-options">formatting options</a> for more details.
 * @property caption_entities A JSON-serialized list of special entities that appear in the caption, which can be specified instead of <em>parse_mode</em>
 * @property show_caption_above_media Pass <em>True</em>, if the caption must be shown above the message media
 * @property has_spoiler Pass <em>True</em> if the video needs to be covered with a spoiler animation
 * @property supports_streaming Pass <em>True</em> if the uploaded video is suitable for streaming
 * @property disable_notification Sends the message <a href="https://telegram.org/blog/channels-2-0#silent-messages">silently</a>. Users will receive a notification with no sound.
 * @property protect_content Protects the contents of the sent message from forwarding and saving
 * @property message_effect_id Unique identifier of the message effect to be added to the message; for private chats only
 * @property reply_parameters Description of the message to reply to
 * @property reply_markup Additional interface options. A JSON-serialized object for an <a href="/bots/features#inline-keyboards">inline keyboard</a>, <a href="/bots/features#keyboards">custom reply keyboard</a>, instructions to remove a reply keyboard or to force a reply from the user
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct SendVideoRequest {
    /// Unique identifier of the business connection on behalf of which the message will be sent
    pub business_connection_id: Option<String>,
    /// Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>)
    pub chat_id: String,
    /// Unique identifier for the target message thread (topic) of the forum; for forum supergroups only
    pub message_thread_id: Option<Integer>,
    /// Video to send. Pass a file_id as String to send a video that exists on the Telegram servers (recommended), pass an HTTP URL as a String for Telegram to get a video from the Internet, or upload a new video using multipart/form-data. <a href="#sending-files">More information on Sending Files »</a>
    pub video: String,
    /// Duration of sent video in seconds
    pub duration: Option<Integer>,
    /// Video width
    pub width: Option<Integer>,
    /// Video height
    pub height: Option<Integer>,
    /// Thumbnail of the file sent; can be ignored if thumbnail generation for the file is supported server-side. The thumbnail should be in JPEG format and less than 200 kB in size. A thumbnail's width and height should not exceed 320. Ignored if the file is not uploaded using multipart/form-data. Thumbnails can't be reused and can be only uploaded as a new file, so you can pass “attach://&lt;file_attach_name&gt;” if the thumbnail was uploaded using multipart/form-data under &lt;file_attach_name&gt;. <a href="#sending-files">More information on Sending Files »</a>
    pub thumbnail: Option<String>,
    /// Video caption (may also be used when resending videos by <em>file_id</em>), 0-1024 characters after entities parsing
    pub caption: Option<String>,
    /// Mode for parsing entities in the video caption. See <a href="#formatting-options">formatting options</a> for more details.
    pub parse_mode: Option<ParseMode>,
    /// A JSON-serialized list of special entities that appear in the caption, which can be specified instead of <em>parse_mode</em>
    pub caption_entities: Option<Vec<MessageEntity>>,
    /// Pass <em>True</em>, if the caption must be shown above the message media
    pub show_caption_above_media: Option<bool>,
    /// Pass <em>True</em> if the video needs to be covered with a spoiler animation
    pub has_spoiler: Option<bool>,
    /// Pass <em>True</em> if the uploaded video is suitable for streaming
    pub supports_streaming: Option<bool>,
    /// Sends the message <a href="https://telegram.org/blog/channels-2-0#silent-messages">silently</a>. Users will receive a notification with no sound.
    pub disable_notification: Option<bool>,
    /// Protects the contents of the sent message from forwarding and saving
    pub protect_content: Option<bool>,
    /// Unique identifier of the message effect to be added to the message; for private chats only
    pub message_effect_id: Option<String>,
    /// Description of the message to reply to
    pub reply_parameters: Option<ReplyParameters>,
    /// Additional interface options. A JSON-serialized object for an <a href="/bots/features#inline-keyboards">inline keyboard</a>, <a href="/bots/features#keyboards">custom reply keyboard</a>, instructions to remove a reply keyboard or to force a reply from the user
    pub reply_markup: Option<KeyboardOption>
}

/**
 * <p>Use this method to send animation files (GIF or H.264/MPEG-4 AVC video without sound). On success, the sent <a href="#message">Message</a> is returned. Bots can currently send animation files of up to 50 MB in size, this limit may be changed in the future.</p>
 *
 * @property business_connection_id Unique identifier of the business connection on behalf of which the message will be sent
 * @property chat_id Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>)
 * @property message_thread_id Unique identifier for the target message thread (topic) of the forum; for forum supergroups only
 * @property animation Animation to send. Pass a file_id as String to send an animation that exists on the Telegram servers (recommended), pass an HTTP URL as a String for Telegram to get an animation from the Internet, or upload a new animation using multipart/form-data. <a href="#sending-files">More information on Sending Files »</a>
 * @property duration Duration of sent animation in seconds
 * @property width Animation width
 * @property height Animation height
 * @property thumbnail Thumbnail of the file sent; can be ignored if thumbnail generation for the file is supported server-side. The thumbnail should be in JPEG format and less than 200 kB in size. A thumbnail's width and height should not exceed 320. Ignored if the file is not uploaded using multipart/form-data. Thumbnails can't be reused and can be only uploaded as a new file, so you can pass “attach://&lt;file_attach_name&gt;” if the thumbnail was uploaded using multipart/form-data under &lt;file_attach_name&gt;. <a href="#sending-files">More information on Sending Files »</a>
 * @property caption Animation caption (may also be used when resending animation by <em>file_id</em>), 0-1024 characters after entities parsing
 * @property parse_mode Mode for parsing entities in the animation caption. See <a href="#formatting-options">formatting options</a> for more details.
 * @property caption_entities A JSON-serialized list of special entities that appear in the caption, which can be specified instead of <em>parse_mode</em>
 * @property show_caption_above_media Pass <em>True</em>, if the caption must be shown above the message media
 * @property has_spoiler Pass <em>True</em> if the animation needs to be covered with a spoiler animation
 * @property disable_notification Sends the message <a href="https://telegram.org/blog/channels-2-0#silent-messages">silently</a>. Users will receive a notification with no sound.
 * @property protect_content Protects the contents of the sent message from forwarding and saving
 * @property message_effect_id Unique identifier of the message effect to be added to the message; for private chats only
 * @property reply_parameters Description of the message to reply to
 * @property reply_markup Additional interface options. A JSON-serialized object for an <a href="/bots/features#inline-keyboards">inline keyboard</a>, <a href="/bots/features#keyboards">custom reply keyboard</a>, instructions to remove a reply keyboard or to force a reply from the user
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct SendAnimationRequest {
    /// Unique identifier of the business connection on behalf of which the message will be sent
    pub business_connection_id: Option<String>,
    /// Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>)
    pub chat_id: String,
    /// Unique identifier for the target message thread (topic) of the forum; for forum supergroups only
    pub message_thread_id: Option<Integer>,
    /// Animation to send. Pass a file_id as String to send an animation that exists on the Telegram servers (recommended), pass an HTTP URL as a String for Telegram to get an animation from the Internet, or upload a new animation using multipart/form-data. <a href="#sending-files">More information on Sending Files »</a>
    pub animation: String,
    /// Duration of sent animation in seconds
    pub duration: Option<Integer>,
    /// Animation width
    pub width: Option<Integer>,
    /// Animation height
    pub height: Option<Integer>,
    /// Thumbnail of the file sent; can be ignored if thumbnail generation for the file is supported server-side. The thumbnail should be in JPEG format and less than 200 kB in size. A thumbnail's width and height should not exceed 320. Ignored if the file is not uploaded using multipart/form-data. Thumbnails can't be reused and can be only uploaded as a new file, so you can pass “attach://&lt;file_attach_name&gt;” if the thumbnail was uploaded using multipart/form-data under &lt;file_attach_name&gt;. <a href="#sending-files">More information on Sending Files »</a>
    pub thumbnail: Option<String>,
    /// Animation caption (may also be used when resending animation by <em>file_id</em>), 0-1024 characters after entities parsing
    pub caption: Option<String>,
    /// Mode for parsing entities in the animation caption. See <a href="#formatting-options">formatting options</a> for more details.
    pub parse_mode: Option<ParseMode>,
    /// A JSON-serialized list of special entities that appear in the caption, which can be specified instead of <em>parse_mode</em>
    pub caption_entities: Option<Vec<MessageEntity>>,
    /// Pass <em>True</em>, if the caption must be shown above the message media
    pub show_caption_above_media: Option<bool>,
    /// Pass <em>True</em> if the animation needs to be covered with a spoiler animation
    pub has_spoiler: Option<bool>,
    /// Sends the message <a href="https://telegram.org/blog/channels-2-0#silent-messages">silently</a>. Users will receive a notification with no sound.
    pub disable_notification: Option<bool>,
    /// Protects the contents of the sent message from forwarding and saving
    pub protect_content: Option<bool>,
    /// Unique identifier of the message effect to be added to the message; for private chats only
    pub message_effect_id: Option<String>,
    /// Description of the message to reply to
    pub reply_parameters: Option<ReplyParameters>,
    /// Additional interface options. A JSON-serialized object for an <a href="/bots/features#inline-keyboards">inline keyboard</a>, <a href="/bots/features#keyboards">custom reply keyboard</a>, instructions to remove a reply keyboard or to force a reply from the user
    pub reply_markup: Option<KeyboardOption>
}

/**
 * <p>Use this method to send audio files, if you want Telegram clients to display the file as a playable voice message. For this to work, your audio must be in an .OGG file encoded with OPUS, or in .MP3 format, or in .M4A format (other formats may be sent as <a href="#audio">Audio</a> or <a href="#document">Document</a>). On success, the sent <a href="#message">Message</a> is returned. Bots can currently send voice messages of up to 50 MB in size, this limit may be changed in the future.</p>
 *
 * @property business_connection_id Unique identifier of the business connection on behalf of which the message will be sent
 * @property chat_id Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>)
 * @property message_thread_id Unique identifier for the target message thread (topic) of the forum; for forum supergroups only
 * @property voice Audio file to send. Pass a file_id as String to send a file that exists on the Telegram servers (recommended), pass an HTTP URL as a String for Telegram to get a file from the Internet, or upload a new one using multipart/form-data. <a href="#sending-files">More information on Sending Files »</a>
 * @property caption Voice message caption, 0-1024 characters after entities parsing
 * @property parse_mode Mode for parsing entities in the voice message caption. See <a href="#formatting-options">formatting options</a> for more details.
 * @property caption_entities A JSON-serialized list of special entities that appear in the caption, which can be specified instead of <em>parse_mode</em>
 * @property duration Duration of the voice message in seconds
 * @property disable_notification Sends the message <a href="https://telegram.org/blog/channels-2-0#silent-messages">silently</a>. Users will receive a notification with no sound.
 * @property protect_content Protects the contents of the sent message from forwarding and saving
 * @property message_effect_id Unique identifier of the message effect to be added to the message; for private chats only
 * @property reply_parameters Description of the message to reply to
 * @property reply_markup Additional interface options. A JSON-serialized object for an <a href="/bots/features#inline-keyboards">inline keyboard</a>, <a href="/bots/features#keyboards">custom reply keyboard</a>, instructions to remove a reply keyboard or to force a reply from the user
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct SendVoiceRequest {
    /// Unique identifier of the business connection on behalf of which the message will be sent
    pub business_connection_id: Option<String>,
    /// Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>)
    pub chat_id: String,
    /// Unique identifier for the target message thread (topic) of the forum; for forum supergroups only
    pub message_thread_id: Option<Integer>,
    /// Audio file to send. Pass a file_id as String to send a file that exists on the Telegram servers (recommended), pass an HTTP URL as a String for Telegram to get a file from the Internet, or upload a new one using multipart/form-data. <a href="#sending-files">More information on Sending Files »</a>
    pub voice: String,
    /// Voice message caption, 0-1024 characters after entities parsing
    pub caption: Option<String>,
    /// Mode for parsing entities in the voice message caption. See <a href="#formatting-options">formatting options</a> for more details.
    pub parse_mode: Option<ParseMode>,
    /// A JSON-serialized list of special entities that appear in the caption, which can be specified instead of <em>parse_mode</em>
    pub caption_entities: Option<Vec<MessageEntity>>,
    /// Duration of the voice message in seconds
    pub duration: Option<Integer>,
    /// Sends the message <a href="https://telegram.org/blog/channels-2-0#silent-messages">silently</a>. Users will receive a notification with no sound.
    pub disable_notification: Option<bool>,
    /// Protects the contents of the sent message from forwarding and saving
    pub protect_content: Option<bool>,
    /// Unique identifier of the message effect to be added to the message; for private chats only
    pub message_effect_id: Option<String>,
    /// Description of the message to reply to
    pub reply_parameters: Option<ReplyParameters>,
    /// Additional interface options. A JSON-serialized object for an <a href="/bots/features#inline-keyboards">inline keyboard</a>, <a href="/bots/features#keyboards">custom reply keyboard</a>, instructions to remove a reply keyboard or to force a reply from the user
    pub reply_markup: Option<KeyboardOption>
}

/**
 * <p>As of <a href="https://telegram.org/blog/video-messages-and-telescope">v.4.0</a>, Telegram clients support rounded square MPEG4 videos of up to 1 minute long. Use this method to send video messages. On success, the sent <a href="#message">Message</a> is returned.</p>
 *
 * @property business_connection_id Unique identifier of the business connection on behalf of which the message will be sent
 * @property chat_id Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>)
 * @property message_thread_id Unique identifier for the target message thread (topic) of the forum; for forum supergroups only
 * @property video_note Video note to send. Pass a file_id as String to send a video note that exists on the Telegram servers (recommended) or upload a new video using multipart/form-data. <a href="#sending-files">More information on Sending Files »</a>. Sending video notes by a URL is currently unsupported
 * @property duration Duration of sent video in seconds
 * @property length Video width and height, i.e. diameter of the video message
 * @property thumbnail Thumbnail of the file sent; can be ignored if thumbnail generation for the file is supported server-side. The thumbnail should be in JPEG format and less than 200 kB in size. A thumbnail's width and height should not exceed 320. Ignored if the file is not uploaded using multipart/form-data. Thumbnails can't be reused and can be only uploaded as a new file, so you can pass “attach://&lt;file_attach_name&gt;” if the thumbnail was uploaded using multipart/form-data under &lt;file_attach_name&gt;. <a href="#sending-files">More information on Sending Files »</a>
 * @property disable_notification Sends the message <a href="https://telegram.org/blog/channels-2-0#silent-messages">silently</a>. Users will receive a notification with no sound.
 * @property protect_content Protects the contents of the sent message from forwarding and saving
 * @property message_effect_id Unique identifier of the message effect to be added to the message; for private chats only
 * @property reply_parameters Description of the message to reply to
 * @property reply_markup Additional interface options. A JSON-serialized object for an <a href="/bots/features#inline-keyboards">inline keyboard</a>, <a href="/bots/features#keyboards">custom reply keyboard</a>, instructions to remove a reply keyboard or to force a reply from the user
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct SendVideoNoteRequest {
    /// Unique identifier of the business connection on behalf of which the message will be sent
    pub business_connection_id: Option<String>,
    /// Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>)
    pub chat_id: String,
    /// Unique identifier for the target message thread (topic) of the forum; for forum supergroups only
    pub message_thread_id: Option<Integer>,
    /// Video note to send. Pass a file_id as String to send a video note that exists on the Telegram servers (recommended) or upload a new video using multipart/form-data. <a href="#sending-files">More information on Sending Files »</a>. Sending video notes by a URL is currently unsupported
    pub video_note: String,
    /// Duration of sent video in seconds
    pub duration: Option<Integer>,
    /// Video width and height, i.e. diameter of the video message
    pub length: Option<Integer>,
    /// Thumbnail of the file sent; can be ignored if thumbnail generation for the file is supported server-side. The thumbnail should be in JPEG format and less than 200 kB in size. A thumbnail's width and height should not exceed 320. Ignored if the file is not uploaded using multipart/form-data. Thumbnails can't be reused and can be only uploaded as a new file, so you can pass “attach://&lt;file_attach_name&gt;” if the thumbnail was uploaded using multipart/form-data under &lt;file_attach_name&gt;. <a href="#sending-files">More information on Sending Files »</a>
    pub thumbnail: Option<String>,
    /// Sends the message <a href="https://telegram.org/blog/channels-2-0#silent-messages">silently</a>. Users will receive a notification with no sound.
    pub disable_notification: Option<bool>,
    /// Protects the contents of the sent message from forwarding and saving
    pub protect_content: Option<bool>,
    /// Unique identifier of the message effect to be added to the message; for private chats only
    pub message_effect_id: Option<String>,
    /// Description of the message to reply to
    pub reply_parameters: Option<ReplyParameters>,
    /// Additional interface options. A JSON-serialized object for an <a href="/bots/features#inline-keyboards">inline keyboard</a>, <a href="/bots/features#keyboards">custom reply keyboard</a>, instructions to remove a reply keyboard or to force a reply from the user
    pub reply_markup: Option<KeyboardOption>
}

/**
 * <p>Use this method to send a group of photos, videos, documents or audios as an album. Documents and audio files can be only grouped in an album with messages of the same type. On success, an array of <a href="#message">Messages</a> that were sent is returned.</p>
 *
 * @property business_connection_id Unique identifier of the business connection on behalf of which the message will be sent
 * @property chat_id Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>)
 * @property message_thread_id Unique identifier for the target message thread (topic) of the forum; for forum supergroups only
 * @property media A JSON-serialized array describing messages to be sent, must include 2-10 items
 * @property disable_notification Sends messages <a href="https://telegram.org/blog/channels-2-0#silent-messages">silently</a>. Users will receive a notification with no sound.
 * @property protect_content Protects the contents of the sent messages from forwarding and saving
 * @property message_effect_id Unique identifier of the message effect to be added to the message; for private chats only
 * @property reply_parameters Description of the message to reply to
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct SendMediaGroupRequest {
    /// Unique identifier of the business connection on behalf of which the message will be sent
    pub business_connection_id: Option<String>,
    /// Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>)
    pub chat_id: String,
    /// Unique identifier for the target message thread (topic) of the forum; for forum supergroups only
    pub message_thread_id: Option<Integer>,
    /// A JSON-serialized array describing messages to be sent, must include 2-10 items
    pub media: Vec<InputMedia>,
    /// Sends messages <a href="https://telegram.org/blog/channels-2-0#silent-messages">silently</a>. Users will receive a notification with no sound.
    pub disable_notification: Option<bool>,
    /// Protects the contents of the sent messages from forwarding and saving
    pub protect_content: Option<bool>,
    /// Unique identifier of the message effect to be added to the message; for private chats only
    pub message_effect_id: Option<String>,
    /// Description of the message to reply to
    pub reply_parameters: Option<ReplyParameters>
}

/**
 * <p>Use this method to send point on the map. On success, the sent <a href="#message">Message</a> is returned.</p>
 *
 * @property business_connection_id Unique identifier of the business connection on behalf of which the message will be sent
 * @property chat_id Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>)
 * @property message_thread_id Unique identifier for the target message thread (topic) of the forum; for forum supergroups only
 * @property latitude Latitude of the location
 * @property longitude Longitude of the location
 * @property horizontal_accuracy The radius of uncertainty for the location, measured in meters; 0-1500
 * @property live_period Period in seconds during which the location will be updated (see <a href="https://telegram.org/blog/live-locations">Live Locations</a>, should be between 60 and 86400, or 0x7FFFFFFF for live locations that can be edited indefinitely.
 * @property heading For live locations, a direction in which the user is moving, in degrees. Must be between 1 and 360 if specified.
 * @property proximity_alert_radius For live locations, a maximum distance for proximity alerts about approaching another chat member, in meters. Must be between 1 and 100000 if specified.
 * @property disable_notification Sends the message <a href="https://telegram.org/blog/channels-2-0#silent-messages">silently</a>. Users will receive a notification with no sound.
 * @property protect_content Protects the contents of the sent message from forwarding and saving
 * @property message_effect_id Unique identifier of the message effect to be added to the message; for private chats only
 * @property reply_parameters Description of the message to reply to
 * @property reply_markup Additional interface options. A JSON-serialized object for an <a href="/bots/features#inline-keyboards">inline keyboard</a>, <a href="/bots/features#keyboards">custom reply keyboard</a>, instructions to remove a reply keyboard or to force a reply from the user
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct SendLocationRequest {
    /// Unique identifier of the business connection on behalf of which the message will be sent
    pub business_connection_id: Option<String>,
    /// Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>)
    pub chat_id: String,
    /// Unique identifier for the target message thread (topic) of the forum; for forum supergroups only
    pub message_thread_id: Option<Integer>,
    /// Latitude of the location
    pub latitude: Float,
    /// Longitude of the location
    pub longitude: Float,
    /// The radius of uncertainty for the location, measured in meters; 0-1500
    pub horizontal_accuracy: Option<Float>,
    /// Period in seconds during which the location will be updated (see <a href="https://telegram.org/blog/live-locations">Live Locations</a>, should be between 60 and 86400, or 0x7FFFFFFF for live locations that can be edited indefinitely.
    pub live_period: Option<Integer>,
    /// For live locations, a direction in which the user is moving, in degrees. Must be between 1 and 360 if specified.
    pub heading: Option<Integer>,
    /// For live locations, a maximum distance for proximity alerts about approaching another chat member, in meters. Must be between 1 and 100000 if specified.
    pub proximity_alert_radius: Option<Integer>,
    /// Sends the message <a href="https://telegram.org/blog/channels-2-0#silent-messages">silently</a>. Users will receive a notification with no sound.
    pub disable_notification: Option<bool>,
    /// Protects the contents of the sent message from forwarding and saving
    pub protect_content: Option<bool>,
    /// Unique identifier of the message effect to be added to the message; for private chats only
    pub message_effect_id: Option<String>,
    /// Description of the message to reply to
    pub reply_parameters: Option<ReplyParameters>,
    /// Additional interface options. A JSON-serialized object for an <a href="/bots/features#inline-keyboards">inline keyboard</a>, <a href="/bots/features#keyboards">custom reply keyboard</a>, instructions to remove a reply keyboard or to force a reply from the user
    pub reply_markup: Option<KeyboardOption>
}

/**
 * <p>Use this method to send information about a venue. On success, the sent <a href="#message">Message</a> is returned.</p>
 *
 * @property business_connection_id Unique identifier of the business connection on behalf of which the message will be sent
 * @property chat_id Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>)
 * @property message_thread_id Unique identifier for the target message thread (topic) of the forum; for forum supergroups only
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
 * @property message_effect_id Unique identifier of the message effect to be added to the message; for private chats only
 * @property reply_parameters Description of the message to reply to
 * @property reply_markup Additional interface options. A JSON-serialized object for an <a href="/bots/features#inline-keyboards">inline keyboard</a>, <a href="/bots/features#keyboards">custom reply keyboard</a>, instructions to remove a reply keyboard or to force a reply from the user
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct SendVenueRequest {
    /// Unique identifier of the business connection on behalf of which the message will be sent
    pub business_connection_id: Option<String>,
    /// Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>)
    pub chat_id: String,
    /// Unique identifier for the target message thread (topic) of the forum; for forum supergroups only
    pub message_thread_id: Option<Integer>,
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
    /// Google Places identifier of the venue
    pub google_place_id: Option<String>,
    /// Google Places type of the venue. (See <a href="https://developers.google.com/places/web-service/supported_types">supported types</a>.)
    pub google_place_type: Option<String>,
    /// Sends the message <a href="https://telegram.org/blog/channels-2-0#silent-messages">silently</a>. Users will receive a notification with no sound.
    pub disable_notification: Option<bool>,
    /// Protects the contents of the sent message from forwarding and saving
    pub protect_content: Option<bool>,
    /// Unique identifier of the message effect to be added to the message; for private chats only
    pub message_effect_id: Option<String>,
    /// Description of the message to reply to
    pub reply_parameters: Option<ReplyParameters>,
    /// Additional interface options. A JSON-serialized object for an <a href="/bots/features#inline-keyboards">inline keyboard</a>, <a href="/bots/features#keyboards">custom reply keyboard</a>, instructions to remove a reply keyboard or to force a reply from the user
    pub reply_markup: Option<KeyboardOption>
}

/**
 * <p>Use this method to send phone contacts. On success, the sent <a href="#message">Message</a> is returned.</p>
 *
 * @property business_connection_id Unique identifier of the business connection on behalf of which the message will be sent
 * @property chat_id Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>)
 * @property message_thread_id Unique identifier for the target message thread (topic) of the forum; for forum supergroups only
 * @property phone_number Contact's phone number
 * @property first_name Contact's first name
 * @property last_name Contact's last name
 * @property vcard Additional data about the contact in the form of a <a href="https://en.wikipedia.org/wiki/VCard">vCard</a>, 0-2048 bytes
 * @property disable_notification Sends the message <a href="https://telegram.org/blog/channels-2-0#silent-messages">silently</a>. Users will receive a notification with no sound.
 * @property protect_content Protects the contents of the sent message from forwarding and saving
 * @property message_effect_id Unique identifier of the message effect to be added to the message; for private chats only
 * @property reply_parameters Description of the message to reply to
 * @property reply_markup Additional interface options. A JSON-serialized object for an <a href="/bots/features#inline-keyboards">inline keyboard</a>, <a href="/bots/features#keyboards">custom reply keyboard</a>, instructions to remove a reply keyboard or to force a reply from the user
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct SendContactRequest {
    /// Unique identifier of the business connection on behalf of which the message will be sent
    pub business_connection_id: Option<String>,
    /// Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>)
    pub chat_id: String,
    /// Unique identifier for the target message thread (topic) of the forum; for forum supergroups only
    pub message_thread_id: Option<Integer>,
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
    /// Protects the contents of the sent message from forwarding and saving
    pub protect_content: Option<bool>,
    /// Unique identifier of the message effect to be added to the message; for private chats only
    pub message_effect_id: Option<String>,
    /// Description of the message to reply to
    pub reply_parameters: Option<ReplyParameters>,
    /// Additional interface options. A JSON-serialized object for an <a href="/bots/features#inline-keyboards">inline keyboard</a>, <a href="/bots/features#keyboards">custom reply keyboard</a>, instructions to remove a reply keyboard or to force a reply from the user
    pub reply_markup: Option<KeyboardOption>
}

/**
 * <p>Use this method to send a native poll. On success, the sent <a href="#message">Message</a> is returned.</p>
 *
 * @property business_connection_id Unique identifier of the business connection on behalf of which the message will be sent
 * @property chat_id Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>)
 * @property message_thread_id Unique identifier for the target message thread (topic) of the forum; for forum supergroups only
 * @property question Poll question, 1-300 characters
 * @property question_parse_mode Mode for parsing entities in the question. See <a href="#formatting-options">formatting options</a> for more details. Currently, only custom emoji entities are allowed
 * @property question_entities A JSON-serialized list of special entities that appear in the poll question. It can be specified instead of <em>question_parse_mode</em>
 * @property options A JSON-serialized list of 2-10 answer options
 * @property is_anonymous <em>True</em>, if the poll needs to be anonymous, defaults to <em>True</em>
 * @property type Poll type, “quiz” or “regular”, defaults to “regular”
 * @property allows_multiple_answers <em>True</em>, if the poll allows multiple answers, ignored for polls in quiz mode, defaults to <em>False</em>
 * @property correct_option_id 0-based identifier of the correct answer option, required for polls in quiz mode
 * @property explanation Text that is shown when a user chooses an incorrect answer or taps on the lamp icon in a quiz-style poll, 0-200 characters with at most 2 line feeds after entities parsing
 * @property explanation_parse_mode Mode for parsing entities in the explanation. See <a href="#formatting-options">formatting options</a> for more details.
 * @property explanation_entities A JSON-serialized list of special entities that appear in the poll explanation. It can be specified instead of <em>explanation_parse_mode</em>
 * @property open_period Amount of time in seconds the poll will be active after creation, 5-600. Can't be used together with <em>close_date</em>.
 * @property close_date Point in time (Unix timestamp) when the poll will be automatically closed. Must be at least 5 and no more than 600 seconds in the future. Can't be used together with <em>open_period</em>.
 * @property is_closed Pass <em>True</em> if the poll needs to be immediately closed. This can be useful for poll preview.
 * @property disable_notification Sends the message <a href="https://telegram.org/blog/channels-2-0#silent-messages">silently</a>. Users will receive a notification with no sound.
 * @property protect_content Protects the contents of the sent message from forwarding and saving
 * @property message_effect_id Unique identifier of the message effect to be added to the message; for private chats only
 * @property reply_parameters Description of the message to reply to
 * @property reply_markup Additional interface options. A JSON-serialized object for an <a href="/bots/features#inline-keyboards">inline keyboard</a>, <a href="/bots/features#keyboards">custom reply keyboard</a>, instructions to remove a reply keyboard or to force a reply from the user
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct SendPollRequest {
    /// Unique identifier of the business connection on behalf of which the message will be sent
    pub business_connection_id: Option<String>,
    /// Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>)
    pub chat_id: String,
    /// Unique identifier for the target message thread (topic) of the forum; for forum supergroups only
    pub message_thread_id: Option<Integer>,
    /// Poll question, 1-300 characters
    pub question: String,
    /// Mode for parsing entities in the question. See <a href="#formatting-options">formatting options</a> for more details. Currently, only custom emoji entities are allowed
    pub question_parse_mode: Option<String>,
    /// A JSON-serialized list of special entities that appear in the poll question. It can be specified instead of <em>question_parse_mode</em>
    pub question_entities: Option<Vec<MessageEntity>>,
    /// A JSON-serialized list of 2-10 answer options
    pub options: Vec<InputPollOption>,
    /// <em>True</em>, if the poll needs to be anonymous, defaults to <em>True</em>
    pub is_anonymous: Option<bool>,
    /// Poll type, “quiz” or “regular”, defaults to “regular”
    #[serde(rename = "type")]
    pub type_: Option<String>,
    /// <em>True</em>, if the poll allows multiple answers, ignored for polls in quiz mode, defaults to <em>False</em>
    pub allows_multiple_answers: Option<bool>,
    /// 0-based identifier of the correct answer option, required for polls in quiz mode
    pub correct_option_id: Option<Integer>,
    /// Text that is shown when a user chooses an incorrect answer or taps on the lamp icon in a quiz-style poll, 0-200 characters with at most 2 line feeds after entities parsing
    pub explanation: Option<String>,
    /// Mode for parsing entities in the explanation. See <a href="#formatting-options">formatting options</a> for more details.
    pub explanation_parse_mode: Option<String>,
    /// A JSON-serialized list of special entities that appear in the poll explanation. It can be specified instead of <em>explanation_parse_mode</em>
    pub explanation_entities: Option<Vec<MessageEntity>>,
    /// Amount of time in seconds the poll will be active after creation, 5-600. Can't be used together with <em>close_date</em>.
    pub open_period: Option<Integer>,
    /// Point in time (Unix timestamp) when the poll will be automatically closed. Must be at least 5 and no more than 600 seconds in the future. Can't be used together with <em>open_period</em>.
    pub close_date: Option<Integer>,
    /// Pass <em>True</em> if the poll needs to be immediately closed. This can be useful for poll preview.
    pub is_closed: Option<bool>,
    /// Sends the message <a href="https://telegram.org/blog/channels-2-0#silent-messages">silently</a>. Users will receive a notification with no sound.
    pub disable_notification: Option<bool>,
    /// Protects the contents of the sent message from forwarding and saving
    pub protect_content: Option<bool>,
    /// Unique identifier of the message effect to be added to the message; for private chats only
    pub message_effect_id: Option<String>,
    /// Description of the message to reply to
    pub reply_parameters: Option<ReplyParameters>,
    /// Additional interface options. A JSON-serialized object for an <a href="/bots/features#inline-keyboards">inline keyboard</a>, <a href="/bots/features#keyboards">custom reply keyboard</a>, instructions to remove a reply keyboard or to force a reply from the user
    pub reply_markup: Option<KeyboardOption>
}

/**
 * <p>Use this method to send an animated emoji that will display a random value. On success, the sent <a href="#message">Message</a> is returned.</p>
 *
 * @property business_connection_id Unique identifier of the business connection on behalf of which the message will be sent
 * @property chat_id Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>)
 * @property message_thread_id Unique identifier for the target message thread (topic) of the forum; for forum supergroups only
 * @property emoji Emoji on which the dice throw animation is based. Currently, must be one of “<img class="emoji" src="//telegram.org/img/emoji/40/F09F8EB2.png" width="20" height="20" alt="🎲">”, “<img class="emoji" src="//telegram.org/img/emoji/40/F09F8EAF.png" width="20" height="20" alt="🎯">”, “<img class="emoji" src="//telegram.org/img/emoji/40/F09F8F80.png" width="20" height="20" alt="🏀">”, “<img class="emoji" src="//telegram.org/img/emoji/40/E29ABD.png" width="20" height="20" alt="⚽">”, “<img class="emoji" src="//telegram.org/img/emoji/40/F09F8EB3.png" width="20" height="20" alt="🎳">”, or “<img class="emoji" src="//telegram.org/img/emoji/40/F09F8EB0.png" width="20" height="20" alt="🎰">”. Dice can have values 1-6 for “<img class="emoji" src="//telegram.org/img/emoji/40/F09F8EB2.png" width="20" height="20" alt="🎲">”, “<img class="emoji" src="//telegram.org/img/emoji/40/F09F8EAF.png" width="20" height="20" alt="🎯">” and “<img class="emoji" src="//telegram.org/img/emoji/40/F09F8EB3.png" width="20" height="20" alt="🎳">”, values 1-5 for “<img class="emoji" src="//telegram.org/img/emoji/40/F09F8F80.png" width="20" height="20" alt="🏀">” and “<img class="emoji" src="//telegram.org/img/emoji/40/E29ABD.png" width="20" height="20" alt="⚽">”, and values 1-64 for “<img class="emoji" src="//telegram.org/img/emoji/40/F09F8EB0.png" width="20" height="20" alt="🎰">”. Defaults to “<img class="emoji" src="//telegram.org/img/emoji/40/F09F8EB2.png" width="20" height="20" alt="🎲">”
 * @property disable_notification Sends the message <a href="https://telegram.org/blog/channels-2-0#silent-messages">silently</a>. Users will receive a notification with no sound.
 * @property protect_content Protects the contents of the sent message from forwarding
 * @property message_effect_id Unique identifier of the message effect to be added to the message; for private chats only
 * @property reply_parameters Description of the message to reply to
 * @property reply_markup Additional interface options. A JSON-serialized object for an <a href="/bots/features#inline-keyboards">inline keyboard</a>, <a href="/bots/features#keyboards">custom reply keyboard</a>, instructions to remove a reply keyboard or to force a reply from the user
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct SendDiceRequest {
    /// Unique identifier of the business connection on behalf of which the message will be sent
    pub business_connection_id: Option<String>,
    /// Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>)
    pub chat_id: String,
    /// Unique identifier for the target message thread (topic) of the forum; for forum supergroups only
    pub message_thread_id: Option<Integer>,
    /// Emoji on which the dice throw animation is based. Currently, must be one of “<img class="emoji" src="//telegram.org/img/emoji/40/F09F8EB2.png" width="20" height="20" alt="🎲">”, “<img class="emoji" src="//telegram.org/img/emoji/40/F09F8EAF.png" width="20" height="20" alt="🎯">”, “<img class="emoji" src="//telegram.org/img/emoji/40/F09F8F80.png" width="20" height="20" alt="🏀">”, “<img class="emoji" src="//telegram.org/img/emoji/40/E29ABD.png" width="20" height="20" alt="⚽">”, “<img class="emoji" src="//telegram.org/img/emoji/40/F09F8EB3.png" width="20" height="20" alt="🎳">”, or “<img class="emoji" src="//telegram.org/img/emoji/40/F09F8EB0.png" width="20" height="20" alt="🎰">”. Dice can have values 1-6 for “<img class="emoji" src="//telegram.org/img/emoji/40/F09F8EB2.png" width="20" height="20" alt="🎲">”, “<img class="emoji" src="//telegram.org/img/emoji/40/F09F8EAF.png" width="20" height="20" alt="🎯">” and “<img class="emoji" src="//telegram.org/img/emoji/40/F09F8EB3.png" width="20" height="20" alt="🎳">”, values 1-5 for “<img class="emoji" src="//telegram.org/img/emoji/40/F09F8F80.png" width="20" height="20" alt="🏀">” and “<img class="emoji" src="//telegram.org/img/emoji/40/E29ABD.png" width="20" height="20" alt="⚽">”, and values 1-64 for “<img class="emoji" src="//telegram.org/img/emoji/40/F09F8EB0.png" width="20" height="20" alt="🎰">”. Defaults to “<img class="emoji" src="//telegram.org/img/emoji/40/F09F8EB2.png" width="20" height="20" alt="🎲">”
    pub emoji: Option<String>,
    /// Sends the message <a href="https://telegram.org/blog/channels-2-0#silent-messages">silently</a>. Users will receive a notification with no sound.
    pub disable_notification: Option<bool>,
    /// Protects the contents of the sent message from forwarding
    pub protect_content: Option<bool>,
    /// Unique identifier of the message effect to be added to the message; for private chats only
    pub message_effect_id: Option<String>,
    /// Description of the message to reply to
    pub reply_parameters: Option<ReplyParameters>,
    /// Additional interface options. A JSON-serialized object for an <a href="/bots/features#inline-keyboards">inline keyboard</a>, <a href="/bots/features#keyboards">custom reply keyboard</a>, instructions to remove a reply keyboard or to force a reply from the user
    pub reply_markup: Option<KeyboardOption>
}

/**
 * <p>Use this method when you need to tell the user that something is happening on the bot's side. The status is set for 5 seconds or less (when a message arrives from your bot, Telegram clients clear its typing status). Returns <em>True</em> on success.</p><blockquote>
 *  <p>Example: The <a href="https://t.me/imagebot">ImageBot</a> needs some time to process a request and upload the image. Instead of sending a text message along the lines of “Retrieving image, please wait…”, the bot may use <a href="#sendchataction">sendChatAction</a> with <em>action</em> = <em>upload_photo</em>. The user will see a “sending photo” status for the bot.</p>
 * </blockquote><p>We only recommend using this method when a response from the bot will take a <strong>noticeable</strong> amount of time to arrive.</p>
 *
 * @property business_connection_id Unique identifier of the business connection on behalf of which the action will be sent
 * @property chat_id Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>)
 * @property message_thread_id Unique identifier for the target message thread; for supergroups only
 * @property action Type of action to broadcast. Choose one, depending on what the user is about to receive: <em>typing</em> for <a href="#sendmessage">text messages</a>, <em>upload_photo</em> for <a href="#sendphoto">photos</a>, <em>record_video</em> or <em>upload_video</em> for <a href="#sendvideo">videos</a>, <em>record_voice</em> or <em>upload_voice</em> for <a href="#sendvoice">voice notes</a>, <em>upload_document</em> for <a href="#senddocument">general files</a>, <em>choose_sticker</em> for <a href="#sendsticker">stickers</a>, <em>find_location</em> for <a href="#sendlocation">location data</a>, <em>record_video_note</em> or <em>upload_video_note</em> for <a href="#sendvideonote">video notes</a>.
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct SendChatActionRequest {
    /// Unique identifier of the business connection on behalf of which the action will be sent
    pub business_connection_id: Option<String>,
    /// Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>)
    pub chat_id: String,
    /// Unique identifier for the target message thread; for supergroups only
    pub message_thread_id: Option<Integer>,
    /// Type of action to broadcast. Choose one, depending on what the user is about to receive: <em>typing</em> for <a href="#sendmessage">text messages</a>, <em>upload_photo</em> for <a href="#sendphoto">photos</a>, <em>record_video</em> or <em>upload_video</em> for <a href="#sendvideo">videos</a>, <em>record_voice</em> or <em>upload_voice</em> for <a href="#sendvoice">voice notes</a>, <em>upload_document</em> for <a href="#senddocument">general files</a>, <em>choose_sticker</em> for <a href="#sendsticker">stickers</a>, <em>find_location</em> for <a href="#sendlocation">location data</a>, <em>record_video_note</em> or <em>upload_video_note</em> for <a href="#sendvideonote">video notes</a>.
    pub action: String
}

/**
 * <p>Use this method to change the chosen reactions on a message. Service messages can't be reacted to. Automatically forwarded messages from a channel to its discussion group have the same available reactions as messages in the channel. Returns <em>True</em> on success.</p>
 *
 * @property chat_id Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>)
 * @property message_id Identifier of the target message. If the message belongs to a media group, the reaction is set to the first non-deleted message in the group instead.
 * @property reaction A JSON-serialized list of reaction types to set on the message. Currently, as non-premium users, bots can set up to one reaction per message. A custom emoji reaction can be used if it is either already present on the message or explicitly allowed by chat administrators.
 * @property is_big Pass <em>True</em> to set the reaction with a big animation
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct SetMessageReactionRequest {
    /// Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>)
    pub chat_id: String,
    /// Identifier of the target message. If the message belongs to a media group, the reaction is set to the first non-deleted message in the group instead.
    pub message_id: Integer,
    /// A JSON-serialized list of reaction types to set on the message. Currently, as non-premium users, bots can set up to one reaction per message. A custom emoji reaction can be used if it is either already present on the message or explicitly allowed by chat administrators.
    pub reaction: Option<Vec<ReactionType>>,
    /// Pass <em>True</em> to set the reaction with a big animation
    pub is_big: Option<bool>
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
 * <p>Use this method to get basic information about a file and prepare it for downloading. For the moment, bots can download files of up to 20MB in size. On success, a <a href="#file">File</a> object is returned. The file can then be downloaded via the link <code>https://api.telegram.org/file/bot&lt;token&gt;/&lt;file_path&gt;</code>, where <code>&lt;file_path&gt;</code> is taken from the response. It is guaranteed that the link will be valid for at least 1 hour. When the link expires, a new one can be requested by calling <a href="#getfile">getFile</a> again.</p><p><strong>Note:</strong> This function may not preserve the original file name and MIME type. You should save the file's MIME type and name (if available) when the File object is received.</p>
 *
 * @property file_id File identifier to get information about
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct GetFileRequest {
    /// File identifier to get information about
    pub file_id: String
}

/**
 * <p>Use this method to ban a user in a group, a supergroup or a channel. In the case of supergroups and channels, the user will not be able to return to the chat on their own using invite links, etc., unless <a href="#unbanchatmember">unbanned</a> first. The bot must be an administrator in the chat for this to work and must have the appropriate administrator rights. Returns <em>True</em> on success.</p>
 *
 * @property chat_id Unique identifier for the target group or username of the target supergroup or channel (in the format <code>@channelusername</code>)
 * @property user_id Unique identifier of the target user
 * @property until_date Date when the user will be unbanned; Unix time. If user is banned for more than 366 days or less than 30 seconds from the current time they are considered to be banned forever. Applied for supergroups and channels only.
 * @property revoke_messages Pass <em>True</em> to delete all messages from the chat for the user that is being removed. If <em>False</em>, the user will be able to see messages in the group that were sent before the user was removed. Always <em>True</em> for supergroups and channels.
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct BanChatMemberRequest {
    /// Unique identifier for the target group or username of the target supergroup or channel (in the format <code>@channelusername</code>)
    pub chat_id: String,
    /// Unique identifier of the target user
    pub user_id: Integer,
    /// Date when the user will be unbanned; Unix time. If user is banned for more than 366 days or less than 30 seconds from the current time they are considered to be banned forever. Applied for supergroups and channels only.
    pub until_date: Option<Integer>,
    /// Pass <em>True</em> to delete all messages from the chat for the user that is being removed. If <em>False</em>, the user will be able to see messages in the group that were sent before the user was removed. Always <em>True</em> for supergroups and channels.
    pub revoke_messages: Option<bool>
}

/**
 * <p>Use this method to unban a previously banned user in a supergroup or channel. The user will <strong>not</strong> return to the group or channel automatically, but will be able to join via link, etc. The bot must be an administrator for this to work. By default, this method guarantees that after the call the user is not a member of the chat, but will be able to join it. So if the user is a member of the chat they will also be <strong>removed</strong> from the chat. If you don't want this, use the parameter <em>only_if_banned</em>. Returns <em>True</em> on success.</p>
 *
 * @property chat_id Unique identifier for the target group or username of the target supergroup or channel (in the format <code>@channelusername</code>)
 * @property user_id Unique identifier of the target user
 * @property only_if_banned Do nothing if the user is not banned
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct UnbanChatMemberRequest {
    /// Unique identifier for the target group or username of the target supergroup or channel (in the format <code>@channelusername</code>)
    pub chat_id: String,
    /// Unique identifier of the target user
    pub user_id: Integer,
    /// Do nothing if the user is not banned
    pub only_if_banned: Option<bool>
}

/**
 * <p>Use this method to restrict a user in a supergroup. The bot must be an administrator in the supergroup for this to work and must have the appropriate administrator rights. Pass <em>True</em> for all permissions to lift restrictions from a user. Returns <em>True</em> on success.</p>
 *
 * @property chat_id Unique identifier for the target chat or username of the target supergroup (in the format <code>@supergroupusername</code>)
 * @property user_id Unique identifier of the target user
 * @property permissions A JSON-serialized object for new user permissions
 * @property use_independent_chat_permissions Pass <em>True</em> if chat permissions are set independently. Otherwise, the <em>can_send_other_messages</em> and <em>can_add_web_page_previews</em> permissions will imply the <em>can_send_messages</em>, <em>can_send_audios</em>, <em>can_send_documents</em>, <em>can_send_photos</em>, <em>can_send_videos</em>, <em>can_send_video_notes</em>, and <em>can_send_voice_notes</em> permissions; the <em>can_send_polls</em> permission will imply the <em>can_send_messages</em> permission.
 * @property until_date Date when restrictions will be lifted for the user; Unix time. If user is restricted for more than 366 days or less than 30 seconds from the current time, they are considered to be restricted forever
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct RestrictChatMemberRequest {
    /// Unique identifier for the target chat or username of the target supergroup (in the format <code>@supergroupusername</code>)
    pub chat_id: String,
    /// Unique identifier of the target user
    pub user_id: Integer,
    /// A JSON-serialized object for new user permissions
    pub permissions: ChatPermissions,
    /// Pass <em>True</em> if chat permissions are set independently. Otherwise, the <em>can_send_other_messages</em> and <em>can_add_web_page_previews</em> permissions will imply the <em>can_send_messages</em>, <em>can_send_audios</em>, <em>can_send_documents</em>, <em>can_send_photos</em>, <em>can_send_videos</em>, <em>can_send_video_notes</em>, and <em>can_send_voice_notes</em> permissions; the <em>can_send_polls</em> permission will imply the <em>can_send_messages</em> permission.
    pub use_independent_chat_permissions: Option<bool>,
    /// Date when restrictions will be lifted for the user; Unix time. If user is restricted for more than 366 days or less than 30 seconds from the current time, they are considered to be restricted forever
    pub until_date: Option<Integer>
}

/**
 * <p>Use this method to promote or demote a user in a supergroup or a channel. The bot must be an administrator in the chat for this to work and must have the appropriate administrator rights. Pass <em>False</em> for all boolean parameters to demote a user. Returns <em>True</em> on success.</p>
 *
 * @property chat_id Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>)
 * @property user_id Unique identifier of the target user
 * @property is_anonymous Pass <em>True</em> if the administrator's presence in the chat is hidden
 * @property can_manage_chat Pass <em>True</em> if the administrator can access the chat event log, get boost list, see hidden supergroup and channel members, report spam messages and ignore slow mode. Implied by any other administrator privilege.
 * @property can_delete_messages Pass <em>True</em> if the administrator can delete messages of other users
 * @property can_manage_video_chats Pass <em>True</em> if the administrator can manage video chats
 * @property can_restrict_members Pass <em>True</em> if the administrator can restrict, ban or unban chat members, or access supergroup statistics
 * @property can_promote_members Pass <em>True</em> if the administrator can add new administrators with a subset of their own privileges or demote administrators that they have promoted, directly or indirectly (promoted by administrators that were appointed by him)
 * @property can_change_info Pass <em>True</em> if the administrator can change chat title, photo and other settings
 * @property can_invite_users Pass <em>True</em> if the administrator can invite new users to the chat
 * @property can_post_stories Pass <em>True</em> if the administrator can post stories to the chat
 * @property can_edit_stories Pass <em>True</em> if the administrator can edit stories posted by other users, post stories to the chat page, pin chat stories, and access the chat's story archive
 * @property can_delete_stories Pass <em>True</em> if the administrator can delete stories posted by other users
 * @property can_post_messages Pass <em>True</em> if the administrator can post messages in the channel, or access channel statistics; for channels only
 * @property can_edit_messages Pass <em>True</em> if the administrator can edit messages of other users and can pin messages; for channels only
 * @property can_pin_messages Pass <em>True</em> if the administrator can pin messages; for supergroups only
 * @property can_manage_topics Pass <em>True</em> if the user is allowed to create, rename, close, and reopen forum topics; for supergroups only
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct PromoteChatMemberRequest {
    /// Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>)
    pub chat_id: String,
    /// Unique identifier of the target user
    pub user_id: Integer,
    /// Pass <em>True</em> if the administrator's presence in the chat is hidden
    pub is_anonymous: Option<bool>,
    /// Pass <em>True</em> if the administrator can access the chat event log, get boost list, see hidden supergroup and channel members, report spam messages and ignore slow mode. Implied by any other administrator privilege.
    pub can_manage_chat: Option<bool>,
    /// Pass <em>True</em> if the administrator can delete messages of other users
    pub can_delete_messages: Option<bool>,
    /// Pass <em>True</em> if the administrator can manage video chats
    pub can_manage_video_chats: Option<bool>,
    /// Pass <em>True</em> if the administrator can restrict, ban or unban chat members, or access supergroup statistics
    pub can_restrict_members: Option<bool>,
    /// Pass <em>True</em> if the administrator can add new administrators with a subset of their own privileges or demote administrators that they have promoted, directly or indirectly (promoted by administrators that were appointed by him)
    pub can_promote_members: Option<bool>,
    /// Pass <em>True</em> if the administrator can change chat title, photo and other settings
    pub can_change_info: Option<bool>,
    /// Pass <em>True</em> if the administrator can invite new users to the chat
    pub can_invite_users: Option<bool>,
    /// Pass <em>True</em> if the administrator can post stories to the chat
    pub can_post_stories: Option<bool>,
    /// Pass <em>True</em> if the administrator can edit stories posted by other users, post stories to the chat page, pin chat stories, and access the chat's story archive
    pub can_edit_stories: Option<bool>,
    /// Pass <em>True</em> if the administrator can delete stories posted by other users
    pub can_delete_stories: Option<bool>,
    /// Pass <em>True</em> if the administrator can post messages in the channel, or access channel statistics; for channels only
    pub can_post_messages: Option<bool>,
    /// Pass <em>True</em> if the administrator can edit messages of other users and can pin messages; for channels only
    pub can_edit_messages: Option<bool>,
    /// Pass <em>True</em> if the administrator can pin messages; for supergroups only
    pub can_pin_messages: Option<bool>,
    /// Pass <em>True</em> if the user is allowed to create, rename, close, and reopen forum topics; for supergroups only
    pub can_manage_topics: Option<bool>
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
 * <p>Use this method to ban a channel chat in a supergroup or a channel. Until the chat is <a href="#unbanchatsenderchat">unbanned</a>, the owner of the banned chat won't be able to send messages on behalf of <strong>any of their channels</strong>. The bot must be an administrator in the supergroup or channel for this to work and must have the appropriate administrator rights. Returns <em>True</em> on success.</p>
 *
 * @property chat_id Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>)
 * @property sender_chat_id Unique identifier of the target sender chat
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct BanChatSenderChatRequest {
    /// Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>)
    pub chat_id: String,
    /// Unique identifier of the target sender chat
    pub sender_chat_id: Integer
}

/**
 * <p>Use this method to unban a previously banned channel chat in a supergroup or channel. The bot must be an administrator for this to work and must have the appropriate administrator rights. Returns <em>True</em> on success.</p>
 *
 * @property chat_id Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>)
 * @property sender_chat_id Unique identifier of the target sender chat
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct UnbanChatSenderChatRequest {
    /// Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>)
    pub chat_id: String,
    /// Unique identifier of the target sender chat
    pub sender_chat_id: Integer
}

/**
 * <p>Use this method to set default chat permissions for all members. The bot must be an administrator in the group or a supergroup for this to work and must have the <em>can_restrict_members</em> administrator rights. Returns <em>True</em> on success.</p>
 *
 * @property chat_id Unique identifier for the target chat or username of the target supergroup (in the format <code>@supergroupusername</code>)
 * @property permissions A JSON-serialized object for new default chat permissions
 * @property use_independent_chat_permissions Pass <em>True</em> if chat permissions are set independently. Otherwise, the <em>can_send_other_messages</em> and <em>can_add_web_page_previews</em> permissions will imply the <em>can_send_messages</em>, <em>can_send_audios</em>, <em>can_send_documents</em>, <em>can_send_photos</em>, <em>can_send_videos</em>, <em>can_send_video_notes</em>, and <em>can_send_voice_notes</em> permissions; the <em>can_send_polls</em> permission will imply the <em>can_send_messages</em> permission.
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct SetChatPermissionsRequest {
    /// Unique identifier for the target chat or username of the target supergroup (in the format <code>@supergroupusername</code>)
    pub chat_id: String,
    /// A JSON-serialized object for new default chat permissions
    pub permissions: ChatPermissions,
    /// Pass <em>True</em> if chat permissions are set independently. Otherwise, the <em>can_send_other_messages</em> and <em>can_add_web_page_previews</em> permissions will imply the <em>can_send_messages</em>, <em>can_send_audios</em>, <em>can_send_documents</em>, <em>can_send_photos</em>, <em>can_send_videos</em>, <em>can_send_video_notes</em>, and <em>can_send_voice_notes</em> permissions; the <em>can_send_polls</em> permission will imply the <em>can_send_messages</em> permission.
    pub use_independent_chat_permissions: Option<bool>
}

/**
 * <p>Use this method to generate a new primary invite link for a chat; any previously generated primary link is revoked. The bot must be an administrator in the chat for this to work and must have the appropriate administrator rights. Returns the new invite link as <em>String</em> on success.</p><blockquote>
 *  <p>Note: Each administrator in a chat generates their own invite links. Bots can't use invite links generated by other administrators. If you want your bot to work with invite links, it will need to generate its own link using <a href="#exportchatinvitelink">exportChatInviteLink</a> or by calling the <a href="#getchat">getChat</a> method. If your bot needs to generate a new primary invite link replacing its previous one, use <a href="#exportchatinvitelink">exportChatInviteLink</a> again.</p>
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
 * <p>Use this method to create an additional invite link for a chat. The bot must be an administrator in the chat for this to work and must have the appropriate administrator rights. The link can be revoked using the method <a href="#revokechatinvitelink">revokeChatInviteLink</a>. Returns the new invite link as <a href="#chatinvitelink">ChatInviteLink</a> object.</p>
 *
 * @property chat_id Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>)
 * @property name Invite link name; 0-32 characters
 * @property expire_date Point in time (Unix timestamp) when the link will expire
 * @property member_limit The maximum number of users that can be members of the chat simultaneously after joining the chat via this invite link; 1-99999
 * @property creates_join_request <em>True</em>, if users joining the chat via the link need to be approved by chat administrators. If <em>True</em>, <em>member_limit</em> can't be specified
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct CreateChatInviteLinkRequest {
    /// Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>)
    pub chat_id: String,
    /// Invite link name; 0-32 characters
    pub name: Option<String>,
    /// Point in time (Unix timestamp) when the link will expire
    pub expire_date: Option<Integer>,
    /// The maximum number of users that can be members of the chat simultaneously after joining the chat via this invite link; 1-99999
    pub member_limit: Option<Integer>,
    /// <em>True</em>, if users joining the chat via the link need to be approved by chat administrators. If <em>True</em>, <em>member_limit</em> can't be specified
    pub creates_join_request: Option<bool>
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
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct EditChatInviteLinkRequest {
    /// Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>)
    pub chat_id: String,
    /// The invite link to edit
    pub invite_link: String,
    /// Invite link name; 0-32 characters
    pub name: Option<String>,
    /// Point in time (Unix timestamp) when the link will expire
    pub expire_date: Option<Integer>,
    /// The maximum number of users that can be members of the chat simultaneously after joining the chat via this invite link; 1-99999
    pub member_limit: Option<Integer>,
    /// <em>True</em>, if users joining the chat via the link need to be approved by chat administrators. If <em>True</em>, <em>member_limit</em> can't be specified
    pub creates_join_request: Option<bool>
}

/**
 * <p>Use this method to revoke an invite link created by the bot. If the primary link is revoked, a new link is automatically generated. The bot must be an administrator in the chat for this to work and must have the appropriate administrator rights. Returns the revoked invite link as <a href="#chatinvitelink">ChatInviteLink</a> object.</p>
 *
 * @property chat_id Unique identifier of the target chat or username of the target channel (in the format <code>@channelusername</code>)
 * @property invite_link The invite link to revoke
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct RevokeChatInviteLinkRequest {
    /// Unique identifier of the target chat or username of the target channel (in the format <code>@channelusername</code>)
    pub chat_id: String,
    /// The invite link to revoke
    pub invite_link: String
}

/**
 * <p>Use this method to approve a chat join request. The bot must be an administrator in the chat for this to work and must have the <em>can_invite_users</em> administrator right. Returns <em>True</em> on success.</p>
 *
 * @property chat_id Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>)
 * @property user_id Unique identifier of the target user
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct ApproveChatJoinRequestRequest {
    /// Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>)
    pub chat_id: String,
    /// Unique identifier of the target user
    pub user_id: Integer
}

/**
 * <p>Use this method to decline a chat join request. The bot must be an administrator in the chat for this to work and must have the <em>can_invite_users</em> administrator right. Returns <em>True</em> on success.</p>
 *
 * @property chat_id Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>)
 * @property user_id Unique identifier of the target user
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct DeclineChatJoinRequestRequest {
    /// Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>)
    pub chat_id: String,
    /// Unique identifier of the target user
    pub user_id: Integer
}

/**
 * <p>Use this method to set a new profile photo for the chat. Photos can't be changed for private chats. The bot must be an administrator in the chat for this to work and must have the appropriate administrator rights. Returns <em>True</em> on success.</p>
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
 * <p>Use this method to delete a chat photo. Photos can't be changed for private chats. The bot must be an administrator in the chat for this to work and must have the appropriate administrator rights. Returns <em>True</em> on success.</p>
 *
 * @property chat_id Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>)
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct DeleteChatPhotoRequest {
    /// Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>)
    pub chat_id: String
}

/**
 * <p>Use this method to change the title of a chat. Titles can't be changed for private chats. The bot must be an administrator in the chat for this to work and must have the appropriate administrator rights. Returns <em>True</em> on success.</p>
 *
 * @property chat_id Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>)
 * @property title New chat title, 1-128 characters
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct SetChatTitleRequest {
    /// Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>)
    pub chat_id: String,
    /// New chat title, 1-128 characters
    pub title: String
}

/**
 * <p>Use this method to change the description of a group, a supergroup or a channel. The bot must be an administrator in the chat for this to work and must have the appropriate administrator rights. Returns <em>True</em> on success.</p>
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
 * <p>Use this method to add a message to the list of pinned messages in a chat. If the chat is not a private chat, the bot must be an administrator in the chat for this to work and must have the 'can_pin_messages' administrator right in a supergroup or 'can_edit_messages' administrator right in a channel. Returns <em>True</em> on success.</p>
 *
 * @property chat_id Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>)
 * @property message_id Identifier of a message to pin
 * @property disable_notification Pass <em>True</em> if it is not necessary to send a notification to all chat members about the new pinned message. Notifications are always disabled in channels and private chats.
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct PinChatMessageRequest {
    /// Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>)
    pub chat_id: String,
    /// Identifier of a message to pin
    pub message_id: Integer,
    /// Pass <em>True</em> if it is not necessary to send a notification to all chat members about the new pinned message. Notifications are always disabled in channels and private chats.
    pub disable_notification: Option<bool>
}

/**
 * <p>Use this method to remove a message from the list of pinned messages in a chat. If the chat is not a private chat, the bot must be an administrator in the chat for this to work and must have the 'can_pin_messages' administrator right in a supergroup or 'can_edit_messages' administrator right in a channel. Returns <em>True</em> on success.</p>
 *
 * @property chat_id Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>)
 * @property message_id Identifier of a message to unpin. If not specified, the most recent pinned message (by sending date) will be unpinned.
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct UnpinChatMessageRequest {
    /// Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>)
    pub chat_id: String,
    /// Identifier of a message to unpin. If not specified, the most recent pinned message (by sending date) will be unpinned.
    pub message_id: Option<Integer>
}

/**
 * <p>Use this method to clear the list of pinned messages in a chat. If the chat is not a private chat, the bot must be an administrator in the chat for this to work and must have the 'can_pin_messages' administrator right in a supergroup or 'can_edit_messages' administrator right in a channel. Returns <em>True</em> on success.</p>
 *
 * @property chat_id Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>)
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct UnpinAllChatMessagesRequest {
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
 * <p>Use this method to get up-to-date information about the chat. Returns a <a href="#chatfullinfo">ChatFullInfo</a> object on success.</p>
 *
 * @property chat_id Unique identifier for the target chat or username of the target supergroup or channel (in the format <code>@channelusername</code>)
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct GetChatRequest {
    /// Unique identifier for the target chat or username of the target supergroup or channel (in the format <code>@channelusername</code>)
    pub chat_id: String
}

/**
 * <p>Use this method to get a list of administrators in a chat, which aren't bots. Returns an Array of <a href="#chatmember">ChatMember</a> objects.</p>
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
pub struct GetChatMemberCountRequest {
    /// Unique identifier for the target chat or username of the target supergroup or channel (in the format <code>@channelusername</code>)
    pub chat_id: String
}

/**
 * <p>Use this method to get information about a member of a chat. The method is only guaranteed to work for other users if the bot is an administrator in the chat. Returns a <a href="#chatmember">ChatMember</a> object on success.</p>
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
 * <p>Use this method to set a new group sticker set for a supergroup. The bot must be an administrator in the chat for this to work and must have the appropriate administrator rights. Use the field <em>can_set_sticker_set</em> optionally returned in <a href="#getchat">getChat</a> requests to check if the bot can use this method. Returns <em>True</em> on success.</p>
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
 * <p>Use this method to delete a group sticker set from a supergroup. The bot must be an administrator in the chat for this to work and must have the appropriate administrator rights. Use the field <em>can_set_sticker_set</em> optionally returned in <a href="#getchat">getChat</a> requests to check if the bot can use this method. Returns <em>True</em> on success.</p>
 *
 * @property chat_id Unique identifier for the target chat or username of the target supergroup (in the format <code>@supergroupusername</code>)
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct DeleteChatStickerSetRequest {
    /// Unique identifier for the target chat or username of the target supergroup (in the format <code>@supergroupusername</code>)
    pub chat_id: String
}

/**
 * <p>Use this method to create a topic in a forum supergroup chat. The bot must be an administrator in the chat for this to work and must have the <em>can_manage_topics</em> administrator rights. Returns information about the created topic as a <a href="#forumtopic">ForumTopic</a> object.</p>
 *
 * @property chat_id Unique identifier for the target chat or username of the target supergroup (in the format <code>@supergroupusername</code>)
 * @property name Topic name, 1-128 characters
 * @property icon_color Color of the topic icon in RGB format. Currently, must be one of 7322096 (0x6FB9F0), 16766590 (0xFFD67E), 13338331 (0xCB86DB), 9367192 (0x8EEE98), 16749490 (0xFF93B2), or 16478047 (0xFB6F5F)
 * @property icon_custom_emoji_id Unique identifier of the custom emoji shown as the topic icon. Use <a href="#getforumtopiciconstickers">getForumTopicIconStickers</a> to get all allowed custom emoji identifiers.
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct CreateForumTopicRequest {
    /// Unique identifier for the target chat or username of the target supergroup (in the format <code>@supergroupusername</code>)
    pub chat_id: String,
    /// Topic name, 1-128 characters
    pub name: String,
    /// Color of the topic icon in RGB format. Currently, must be one of 7322096 (0x6FB9F0), 16766590 (0xFFD67E), 13338331 (0xCB86DB), 9367192 (0x8EEE98), 16749490 (0xFF93B2), or 16478047 (0xFB6F5F)
    pub icon_color: Option<Integer>,
    /// Unique identifier of the custom emoji shown as the topic icon. Use <a href="#getforumtopiciconstickers">getForumTopicIconStickers</a> to get all allowed custom emoji identifiers.
    pub icon_custom_emoji_id: Option<String>
}

/**
 * <p>Use this method to edit name and icon of a topic in a forum supergroup chat. The bot must be an administrator in the chat for this to work and must have <em>can_manage_topics</em> administrator rights, unless it is the creator of the topic. Returns <em>True</em> on success.</p>
 *
 * @property chat_id Unique identifier for the target chat or username of the target supergroup (in the format <code>@supergroupusername</code>)
 * @property message_thread_id Unique identifier for the target message thread of the forum topic
 * @property name New topic name, 0-128 characters. If not specified or empty, the current name of the topic will be kept
 * @property icon_custom_emoji_id New unique identifier of the custom emoji shown as the topic icon. Use <a href="#getforumtopiciconstickers">getForumTopicIconStickers</a> to get all allowed custom emoji identifiers. Pass an empty string to remove the icon. If not specified, the current icon will be kept
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct EditForumTopicRequest {
    /// Unique identifier for the target chat or username of the target supergroup (in the format <code>@supergroupusername</code>)
    pub chat_id: String,
    /// Unique identifier for the target message thread of the forum topic
    pub message_thread_id: Integer,
    /// New topic name, 0-128 characters. If not specified or empty, the current name of the topic will be kept
    pub name: Option<String>,
    /// New unique identifier of the custom emoji shown as the topic icon. Use <a href="#getforumtopiciconstickers">getForumTopicIconStickers</a> to get all allowed custom emoji identifiers. Pass an empty string to remove the icon. If not specified, the current icon will be kept
    pub icon_custom_emoji_id: Option<String>
}

/**
 * <p>Use this method to close an open topic in a forum supergroup chat. The bot must be an administrator in the chat for this to work and must have the <em>can_manage_topics</em> administrator rights, unless it is the creator of the topic. Returns <em>True</em> on success.</p>
 *
 * @property chat_id Unique identifier for the target chat or username of the target supergroup (in the format <code>@supergroupusername</code>)
 * @property message_thread_id Unique identifier for the target message thread of the forum topic
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct CloseForumTopicRequest {
    /// Unique identifier for the target chat or username of the target supergroup (in the format <code>@supergroupusername</code>)
    pub chat_id: String,
    /// Unique identifier for the target message thread of the forum topic
    pub message_thread_id: Integer
}

/**
 * <p>Use this method to reopen a closed topic in a forum supergroup chat. The bot must be an administrator in the chat for this to work and must have the <em>can_manage_topics</em> administrator rights, unless it is the creator of the topic. Returns <em>True</em> on success.</p>
 *
 * @property chat_id Unique identifier for the target chat or username of the target supergroup (in the format <code>@supergroupusername</code>)
 * @property message_thread_id Unique identifier for the target message thread of the forum topic
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct ReopenForumTopicRequest {
    /// Unique identifier for the target chat or username of the target supergroup (in the format <code>@supergroupusername</code>)
    pub chat_id: String,
    /// Unique identifier for the target message thread of the forum topic
    pub message_thread_id: Integer
}

/**
 * <p>Use this method to delete a forum topic along with all its messages in a forum supergroup chat. The bot must be an administrator in the chat for this to work and must have the <em>can_delete_messages</em> administrator rights. Returns <em>True</em> on success.</p>
 *
 * @property chat_id Unique identifier for the target chat or username of the target supergroup (in the format <code>@supergroupusername</code>)
 * @property message_thread_id Unique identifier for the target message thread of the forum topic
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct DeleteForumTopicRequest {
    /// Unique identifier for the target chat or username of the target supergroup (in the format <code>@supergroupusername</code>)
    pub chat_id: String,
    /// Unique identifier for the target message thread of the forum topic
    pub message_thread_id: Integer
}

/**
 * <p>Use this method to clear the list of pinned messages in a forum topic. The bot must be an administrator in the chat for this to work and must have the <em>can_pin_messages</em> administrator right in the supergroup. Returns <em>True</em> on success.</p>
 *
 * @property chat_id Unique identifier for the target chat or username of the target supergroup (in the format <code>@supergroupusername</code>)
 * @property message_thread_id Unique identifier for the target message thread of the forum topic
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct UnpinAllForumTopicMessagesRequest {
    /// Unique identifier for the target chat or username of the target supergroup (in the format <code>@supergroupusername</code>)
    pub chat_id: String,
    /// Unique identifier for the target message thread of the forum topic
    pub message_thread_id: Integer
}

/**
 * <p>Use this method to edit the name of the 'General' topic in a forum supergroup chat. The bot must be an administrator in the chat for this to work and must have <em>can_manage_topics</em> administrator rights. Returns <em>True</em> on success.</p>
 *
 * @property chat_id Unique identifier for the target chat or username of the target supergroup (in the format <code>@supergroupusername</code>)
 * @property name New topic name, 1-128 characters
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct EditGeneralForumTopicRequest {
    /// Unique identifier for the target chat or username of the target supergroup (in the format <code>@supergroupusername</code>)
    pub chat_id: String,
    /// New topic name, 1-128 characters
    pub name: String
}

/**
 * <p>Use this method to close an open 'General' topic in a forum supergroup chat. The bot must be an administrator in the chat for this to work and must have the <em>can_manage_topics</em> administrator rights. Returns <em>True</em> on success.</p>
 *
 * @property chat_id Unique identifier for the target chat or username of the target supergroup (in the format <code>@supergroupusername</code>)
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct CloseGeneralForumTopicRequest {
    /// Unique identifier for the target chat or username of the target supergroup (in the format <code>@supergroupusername</code>)
    pub chat_id: String
}

/**
 * <p>Use this method to reopen a closed 'General' topic in a forum supergroup chat. The bot must be an administrator in the chat for this to work and must have the <em>can_manage_topics</em> administrator rights. The topic will be automatically unhidden if it was hidden. Returns <em>True</em> on success.</p>
 *
 * @property chat_id Unique identifier for the target chat or username of the target supergroup (in the format <code>@supergroupusername</code>)
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct ReopenGeneralForumTopicRequest {
    /// Unique identifier for the target chat or username of the target supergroup (in the format <code>@supergroupusername</code>)
    pub chat_id: String
}

/**
 * <p>Use this method to hide the 'General' topic in a forum supergroup chat. The bot must be an administrator in the chat for this to work and must have the <em>can_manage_topics</em> administrator rights. The topic will be automatically closed if it was open. Returns <em>True</em> on success.</p>
 *
 * @property chat_id Unique identifier for the target chat or username of the target supergroup (in the format <code>@supergroupusername</code>)
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct HideGeneralForumTopicRequest {
    /// Unique identifier for the target chat or username of the target supergroup (in the format <code>@supergroupusername</code>)
    pub chat_id: String
}

/**
 * <p>Use this method to unhide the 'General' topic in a forum supergroup chat. The bot must be an administrator in the chat for this to work and must have the <em>can_manage_topics</em> administrator rights. Returns <em>True</em> on success.</p>
 *
 * @property chat_id Unique identifier for the target chat or username of the target supergroup (in the format <code>@supergroupusername</code>)
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct UnhideGeneralForumTopicRequest {
    /// Unique identifier for the target chat or username of the target supergroup (in the format <code>@supergroupusername</code>)
    pub chat_id: String
}

/**
 * <p>Use this method to clear the list of pinned messages in a General forum topic. The bot must be an administrator in the chat for this to work and must have the <em>can_pin_messages</em> administrator right in the supergroup. Returns <em>True</em> on success.</p>
 *
 * @property chat_id Unique identifier for the target chat or username of the target supergroup (in the format <code>@supergroupusername</code>)
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct UnpinAllGeneralForumTopicMessagesRequest {
    /// Unique identifier for the target chat or username of the target supergroup (in the format <code>@supergroupusername</code>)
    pub chat_id: String
}

/**
 * <p>Use this method to send answers to callback queries sent from <a href="/bots/features#inline-keyboards">inline keyboards</a>. The answer will be displayed to the user as a notification at the top of the chat screen or as an alert. On success, <em>True</em> is returned.</p><blockquote>
 *  <p>Alternatively, the user can be redirected to the specified Game URL. For this option to work, you must first create a game for your bot via <a href="https://t.me/botfather">@BotFather</a> and accept the terms. Otherwise, you may use links like <code>t.me/your_bot?start=XXXX</code> that open your bot with a parameter.</p>
 * </blockquote>
 *
 * @property callback_query_id Unique identifier for the query to be answered
 * @property text Text of the notification. If not specified, nothing will be shown to the user, 0-200 characters
 * @property show_alert If <em>True</em>, an alert will be shown by the client instead of a notification at the top of the chat screen. Defaults to <em>false</em>.
 * @property url URL that will be opened by the user's client. If you have created a <a href="#game">Game</a> and accepted the conditions via <a href="https://t.me/botfather">@BotFather</a>, specify the URL that opens your game - note that this will only work if the query comes from a <a href="#inlinekeyboardbutton"><em>callback_game</em></a> button.<br><br>Otherwise, you may use links like <code>t.me/your_bot?start=XXXX</code> that open your bot with a parameter.
 * @property cache_time The maximum amount of time in seconds that the result of the callback query may be cached client-side. Telegram apps will support caching starting in version 3.14. Defaults to 0.
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct AnswerCallbackQueryRequest {
    /// Unique identifier for the query to be answered
    pub callback_query_id: String,
    /// Text of the notification. If not specified, nothing will be shown to the user, 0-200 characters
    pub text: Option<String>,
    /// If <em>True</em>, an alert will be shown by the client instead of a notification at the top of the chat screen. Defaults to <em>false</em>.
    pub show_alert: Option<bool>,
    /// URL that will be opened by the user's client. If you have created a <a href="#game">Game</a> and accepted the conditions via <a href="https://t.me/botfather">@BotFather</a>, specify the URL that opens your game - note that this will only work if the query comes from a <a href="#inlinekeyboardbutton"><em>callback_game</em></a> button.<br><br>Otherwise, you may use links like <code>t.me/your_bot?start=XXXX</code> that open your bot with a parameter.
    pub url: Option<String>,
    /// The maximum amount of time in seconds that the result of the callback query may be cached client-side. Telegram apps will support caching starting in version 3.14. Defaults to 0.
    pub cache_time: Option<Integer>
}

/**
 * <p>Use this method to get the list of boosts added to a chat by a user. Requires administrator rights in the chat. Returns a <a href="#userchatboosts">UserChatBoosts</a> object.</p>
 *
 * @property chat_id Unique identifier for the chat or username of the channel (in the format <code>@channelusername</code>)
 * @property user_id Unique identifier of the target user
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct GetUserChatBoostsRequest {
    /// Unique identifier for the chat or username of the channel (in the format <code>@channelusername</code>)
    pub chat_id: String,
    /// Unique identifier of the target user
    pub user_id: Integer
}

/**
 * <p>Use this method to get information about the connection of the bot with a business account. Returns a <a href="#businessconnection">BusinessConnection</a> object on success.</p>
 *
 * @property business_connection_id Unique identifier of the business connection
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct GetBusinessConnectionRequest {
    /// Unique identifier of the business connection
    pub business_connection_id: String
}

/**
 * <p>Use this method to change the list of the bot's commands. See <a href="/bots/features#commands">this manual</a> for more details about bot commands. Returns <em>True</em> on success.</p>
 *
 * @property commands A JSON-serialized list of bot commands to be set as the list of the bot's commands. At most 100 commands can be specified.
 * @property scope A JSON-serialized object, describing scope of users for which the commands are relevant. Defaults to <a href="#botcommandscopedefault">BotCommandScopeDefault</a>.
 * @property language_code A two-letter ISO 639-1 language code. If empty, commands will be applied to all users from the given scope, for whose language there are no dedicated commands
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct SetMyCommandsRequest {
    /// A JSON-serialized list of bot commands to be set as the list of the bot's commands. At most 100 commands can be specified.
    pub commands: Vec<BotCommand>,
    /// A JSON-serialized object, describing scope of users for which the commands are relevant. Defaults to <a href="#botcommandscopedefault">BotCommandScopeDefault</a>.
    pub scope: Option<BotCommandScope>,
    /// A two-letter ISO 639-1 language code. If empty, commands will be applied to all users from the given scope, for whose language there are no dedicated commands
    pub language_code: Option<String>
}

/**
 * <p>Use this method to delete the list of the bot's commands for the given scope and user language. After deletion, <a href="#determining-list-of-commands">higher level commands</a> will be shown to affected users. Returns <em>True</em> on success.</p>
 *
 * @property scope A JSON-serialized object, describing scope of users for which the commands are relevant. Defaults to <a href="#botcommandscopedefault">BotCommandScopeDefault</a>.
 * @property language_code A two-letter ISO 639-1 language code. If empty, commands will be applied to all users from the given scope, for whose language there are no dedicated commands
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct DeleteMyCommandsRequest {
    /// A JSON-serialized object, describing scope of users for which the commands are relevant. Defaults to <a href="#botcommandscopedefault">BotCommandScopeDefault</a>.
    pub scope: Option<BotCommandScope>,
    /// A two-letter ISO 639-1 language code. If empty, commands will be applied to all users from the given scope, for whose language there are no dedicated commands
    pub language_code: Option<String>
}

/**
 * <p>Use this method to get the current list of the bot's commands for the given scope and user language. Returns an Array of <a href="#botcommand">BotCommand</a> objects. If commands aren't set, an empty list is returned.</p>
 *
 * @property scope A JSON-serialized object, describing scope of users. Defaults to <a href="#botcommandscopedefault">BotCommandScopeDefault</a>.
 * @property language_code A two-letter ISO 639-1 language code or an empty string
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct GetMyCommandsRequest {
    /// A JSON-serialized object, describing scope of users. Defaults to <a href="#botcommandscopedefault">BotCommandScopeDefault</a>.
    pub scope: Option<BotCommandScope>,
    /// A two-letter ISO 639-1 language code or an empty string
    pub language_code: Option<String>
}

/**
 * <p>Use this method to change the bot's name. Returns <em>True</em> on success.</p>
 *
 * @property name New bot name; 0-64 characters. Pass an empty string to remove the dedicated name for the given language.
 * @property language_code A two-letter ISO 639-1 language code. If empty, the name will be shown to all users for whose language there is no dedicated name.
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct SetMyNameRequest {
    /// New bot name; 0-64 characters. Pass an empty string to remove the dedicated name for the given language.
    pub name: Option<String>,
    /// A two-letter ISO 639-1 language code. If empty, the name will be shown to all users for whose language there is no dedicated name.
    pub language_code: Option<String>
}

/**
 * <p>Use this method to get the current bot name for the given user language. Returns <a href="#botname">BotName</a> on success.</p>
 *
 * @property language_code A two-letter ISO 639-1 language code or an empty string
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct GetMyNameRequest {
    /// A two-letter ISO 639-1 language code or an empty string
    pub language_code: Option<String>
}

/**
 * <p>Use this method to change the bot's description, which is shown in the chat with the bot if the chat is empty. Returns <em>True</em> on success.</p>
 *
 * @property description New bot description; 0-512 characters. Pass an empty string to remove the dedicated description for the given language.
 * @property language_code A two-letter ISO 639-1 language code. If empty, the description will be applied to all users for whose language there is no dedicated description.
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct SetMyDescriptionRequest {
    /// New bot description; 0-512 characters. Pass an empty string to remove the dedicated description for the given language.
    pub description: Option<String>,
    /// A two-letter ISO 639-1 language code. If empty, the description will be applied to all users for whose language there is no dedicated description.
    pub language_code: Option<String>
}

/**
 * <p>Use this method to get the current bot description for the given user language. Returns <a href="#botdescription">BotDescription</a> on success.</p>
 *
 * @property language_code A two-letter ISO 639-1 language code or an empty string
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct GetMyDescriptionRequest {
    /// A two-letter ISO 639-1 language code or an empty string
    pub language_code: Option<String>
}

/**
 * <p>Use this method to change the bot's short description, which is shown on the bot's profile page and is sent together with the link when users share the bot. Returns <em>True</em> on success.</p>
 *
 * @property short_description New short description for the bot; 0-120 characters. Pass an empty string to remove the dedicated short description for the given language.
 * @property language_code A two-letter ISO 639-1 language code. If empty, the short description will be applied to all users for whose language there is no dedicated short description.
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct SetMyShortDescriptionRequest {
    /// New short description for the bot; 0-120 characters. Pass an empty string to remove the dedicated short description for the given language.
    pub short_description: Option<String>,
    /// A two-letter ISO 639-1 language code. If empty, the short description will be applied to all users for whose language there is no dedicated short description.
    pub language_code: Option<String>
}

/**
 * <p>Use this method to get the current bot short description for the given user language. Returns <a href="#botshortdescription">BotShortDescription</a> on success.</p>
 *
 * @property language_code A two-letter ISO 639-1 language code or an empty string
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct GetMyShortDescriptionRequest {
    /// A two-letter ISO 639-1 language code or an empty string
    pub language_code: Option<String>
}

/**
 * <p>Use this method to change the bot's menu button in a private chat, or the default menu button. Returns <em>True</em> on success.</p>
 *
 * @property chat_id Unique identifier for the target private chat. If not specified, default bot's menu button will be changed
 * @property menu_button A JSON-serialized object for the bot's new menu button. Defaults to <a href="#menubuttondefault">MenuButtonDefault</a>
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct SetChatMenuButtonRequest {
    /// Unique identifier for the target private chat. If not specified, default bot's menu button will be changed
    pub chat_id: Option<Integer>,
    /// A JSON-serialized object for the bot's new menu button. Defaults to <a href="#menubuttondefault">MenuButtonDefault</a>
    pub menu_button: Option<MenuButton>
}

/**
 * <p>Use this method to get the current value of the bot's menu button in a private chat, or the default menu button. Returns <a href="#menubutton">MenuButton</a> on success.</p>
 *
 * @property chat_id Unique identifier for the target private chat. If not specified, default bot's menu button will be returned
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct GetChatMenuButtonRequest {
    /// Unique identifier for the target private chat. If not specified, default bot's menu button will be returned
    pub chat_id: Option<Integer>
}

/**
 * <p>Use this method to change the default administrator rights requested by the bot when it's added as an administrator to groups or channels. These rights will be suggested to users, but they are free to modify the list before adding the bot. Returns <em>True</em> on success.</p>
 *
 * @property rights A JSON-serialized object describing new default administrator rights. If not specified, the default administrator rights will be cleared.
 * @property for_channels Pass <em>True</em> to change the default administrator rights of the bot in channels. Otherwise, the default administrator rights of the bot for groups and supergroups will be changed.
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct SetMyDefaultAdministratorRightsRequest {
    /// A JSON-serialized object describing new default administrator rights. If not specified, the default administrator rights will be cleared.
    pub rights: Option<ChatAdministratorRights>,
    /// Pass <em>True</em> to change the default administrator rights of the bot in channels. Otherwise, the default administrator rights of the bot for groups and supergroups will be changed.
    pub for_channels: Option<bool>
}

/**
 * <p>Use this method to get the current default administrator rights of the bot. Returns <a href="#chatadministratorrights">ChatAdministratorRights</a> on success.</p>
 *
 * @property for_channels Pass <em>True</em> to get default administrator rights of the bot in channels. Otherwise, default administrator rights of the bot for groups and supergroups will be returned.
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct GetMyDefaultAdministratorRightsRequest {
    /// Pass <em>True</em> to get default administrator rights of the bot in channels. Otherwise, default administrator rights of the bot for groups and supergroups will be returned.
    pub for_channels: Option<bool>
}


/// Updating messages

/**
 * <p>Use this method to edit text and <a href="#games">game</a> messages. On success, if the edited message is not an inline message, the edited <a href="#message">Message</a> is returned, otherwise <em>True</em> is returned.</p>
 *
 * @property chat_id Required if <em>inline_message_id</em> is not specified. Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>)
 * @property message_id Required if <em>inline_message_id</em> is not specified. Identifier of the message to edit
 * @property inline_message_id Required if <em>chat_id</em> and <em>message_id</em> are not specified. Identifier of the inline message
 * @property text New text of the message, 1-4096 characters after entities parsing
 * @property parse_mode Mode for parsing entities in the message text. See <a href="#formatting-options">formatting options</a> for more details.
 * @property entities A JSON-serialized list of special entities that appear in message text, which can be specified instead of <em>parse_mode</em>
 * @property link_preview_options Link preview generation options for the message
 * @property reply_markup A JSON-serialized object for an <a href="/bots/features#inline-keyboards">inline keyboard</a>.
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
    /// A JSON-serialized list of special entities that appear in message text, which can be specified instead of <em>parse_mode</em>
    pub entities: Option<Vec<MessageEntity>>,
    /// Link preview generation options for the message
    pub link_preview_options: Option<LinkPreviewOptions>,
    /// A JSON-serialized object for an <a href="/bots/features#inline-keyboards">inline keyboard</a>.
    pub reply_markup: Option<InlineKeyboardMarkup>
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
 * @property show_caption_above_media Pass <em>True</em>, if the caption must be shown above the message media. Supported only for animation, photo and video messages.
 * @property reply_markup A JSON-serialized object for an <a href="/bots/features#inline-keyboards">inline keyboard</a>.
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
    /// A JSON-serialized list of special entities that appear in the caption, which can be specified instead of <em>parse_mode</em>
    pub caption_entities: Option<Vec<MessageEntity>>,
    /// Pass <em>True</em>, if the caption must be shown above the message media. Supported only for animation, photo and video messages.
    pub show_caption_above_media: Option<bool>,
    /// A JSON-serialized object for an <a href="/bots/features#inline-keyboards">inline keyboard</a>.
    pub reply_markup: Option<InlineKeyboardMarkup>
}

/**
 * <p>Use this method to edit animation, audio, document, photo, or video messages. If a message is part of a message album, then it can be edited only to an audio for audio albums, only to a document for document albums and to a photo or a video otherwise. When an inline message is edited, a new file can't be uploaded; use a previously uploaded file via its file_id or specify a URL. On success, if the edited message is not an inline message, the edited <a href="#message">Message</a> is returned, otherwise <em>True</em> is returned.</p>
 *
 * @property chat_id Required if <em>inline_message_id</em> is not specified. Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>)
 * @property message_id Required if <em>inline_message_id</em> is not specified. Identifier of the message to edit
 * @property inline_message_id Required if <em>chat_id</em> and <em>message_id</em> are not specified. Identifier of the inline message
 * @property media A JSON-serialized object for a new media content of the message
 * @property reply_markup A JSON-serialized object for a new <a href="/bots/features#inline-keyboards">inline keyboard</a>.
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
    /// A JSON-serialized object for a new <a href="/bots/features#inline-keyboards">inline keyboard</a>.
    pub reply_markup: Option<InlineKeyboardMarkup>
}

/**
 * <p>Use this method to edit live location messages. A location can be edited until its <em>live_period</em> expires or editing is explicitly disabled by a call to <a href="#stopmessagelivelocation">stopMessageLiveLocation</a>. On success, if the edited message is not an inline message, the edited <a href="#message">Message</a> is returned, otherwise <em>True</em> is returned.</p>
 *
 * @property chat_id Required if <em>inline_message_id</em> is not specified. Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>)
 * @property message_id Required if <em>inline_message_id</em> is not specified. Identifier of the message to edit
 * @property inline_message_id Required if <em>chat_id</em> and <em>message_id</em> are not specified. Identifier of the inline message
 * @property latitude Latitude of new location
 * @property longitude Longitude of new location
 * @property live_period New period in seconds during which the location can be updated, starting from the message send date. If 0x7FFFFFFF is specified, then the location can be updated forever. Otherwise, the new value must not exceed the current <em>live_period</em> by more than a day, and the live location expiration date must remain within the next 90 days. If not specified, then <em>live_period</em> remains unchanged
 * @property horizontal_accuracy The radius of uncertainty for the location, measured in meters; 0-1500
 * @property heading Direction in which the user is moving, in degrees. Must be between 1 and 360 if specified.
 * @property proximity_alert_radius The maximum distance for proximity alerts about approaching another chat member, in meters. Must be between 1 and 100000 if specified.
 * @property reply_markup A JSON-serialized object for a new <a href="/bots/features#inline-keyboards">inline keyboard</a>.
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
    /// New period in seconds during which the location can be updated, starting from the message send date. If 0x7FFFFFFF is specified, then the location can be updated forever. Otherwise, the new value must not exceed the current <em>live_period</em> by more than a day, and the live location expiration date must remain within the next 90 days. If not specified, then <em>live_period</em> remains unchanged
    pub live_period: Option<Integer>,
    /// The radius of uncertainty for the location, measured in meters; 0-1500
    pub horizontal_accuracy: Option<Float>,
    /// Direction in which the user is moving, in degrees. Must be between 1 and 360 if specified.
    pub heading: Option<Integer>,
    /// The maximum distance for proximity alerts about approaching another chat member, in meters. Must be between 1 and 100000 if specified.
    pub proximity_alert_radius: Option<Integer>,
    /// A JSON-serialized object for a new <a href="/bots/features#inline-keyboards">inline keyboard</a>.
    pub reply_markup: Option<InlineKeyboardMarkup>
}

/**
 * <p>Use this method to stop updating a live location message before <em>live_period</em> expires. On success, if the message is not an inline message, the edited <a href="#message">Message</a> is returned, otherwise <em>True</em> is returned.</p>
 *
 * @property chat_id Required if <em>inline_message_id</em> is not specified. Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>)
 * @property message_id Required if <em>inline_message_id</em> is not specified. Identifier of the message with live location to stop
 * @property inline_message_id Required if <em>chat_id</em> and <em>message_id</em> are not specified. Identifier of the inline message
 * @property reply_markup A JSON-serialized object for a new <a href="/bots/features#inline-keyboards">inline keyboard</a>.
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct StopMessageLiveLocationRequest {
    /// Required if <em>inline_message_id</em> is not specified. Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>)
    pub chat_id: Option<String>,
    /// Required if <em>inline_message_id</em> is not specified. Identifier of the message with live location to stop
    pub message_id: Option<Integer>,
    /// Required if <em>chat_id</em> and <em>message_id</em> are not specified. Identifier of the inline message
    pub inline_message_id: Option<String>,
    /// A JSON-serialized object for a new <a href="/bots/features#inline-keyboards">inline keyboard</a>.
    pub reply_markup: Option<InlineKeyboardMarkup>
}

/**
 * <p>Use this method to edit only the reply markup of messages. On success, if the edited message is not an inline message, the edited <a href="#message">Message</a> is returned, otherwise <em>True</em> is returned.</p>
 *
 * @property chat_id Required if <em>inline_message_id</em> is not specified. Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>)
 * @property message_id Required if <em>inline_message_id</em> is not specified. Identifier of the message to edit
 * @property inline_message_id Required if <em>chat_id</em> and <em>message_id</em> are not specified. Identifier of the inline message
 * @property reply_markup A JSON-serialized object for an <a href="/bots/features#inline-keyboards">inline keyboard</a>.
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct EditMessageReplyMarkupRequest {
    /// Required if <em>inline_message_id</em> is not specified. Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>)
    pub chat_id: Option<String>,
    /// Required if <em>inline_message_id</em> is not specified. Identifier of the message to edit
    pub message_id: Option<Integer>,
    /// Required if <em>chat_id</em> and <em>message_id</em> are not specified. Identifier of the inline message
    pub inline_message_id: Option<String>,
    /// A JSON-serialized object for an <a href="/bots/features#inline-keyboards">inline keyboard</a>.
    pub reply_markup: Option<InlineKeyboardMarkup>
}

/**
 * <p>Use this method to stop a poll which was sent by the bot. On success, the stopped <a href="#poll">Poll</a> is returned.</p>
 *
 * @property chat_id Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>)
 * @property message_id Identifier of the original message with the poll
 * @property reply_markup A JSON-serialized object for a new message <a href="/bots/features#inline-keyboards">inline keyboard</a>.
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct StopPollRequest {
    /// Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>)
    pub chat_id: String,
    /// Identifier of the original message with the poll
    pub message_id: Integer,
    /// A JSON-serialized object for a new message <a href="/bots/features#inline-keyboards">inline keyboard</a>.
    pub reply_markup: Option<InlineKeyboardMarkup>
}

/**
 * <p>Use this method to delete a message, including service messages, with the following limitations:<br>- A message can only be deleted if it was sent less than 48 hours ago.<br>- Service messages about a supergroup, channel, or forum topic creation can't be deleted.<br>- A dice message in a private chat can only be deleted if it was sent more than 24 hours ago.<br>- Bots can delete outgoing messages in private chats, groups, and supergroups.<br>- Bots can delete incoming messages in private chats.<br>- Bots granted <em>can_post_messages</em> permissions can delete outgoing messages in channels.<br>- If the bot is an administrator of a group, it can delete any message there.<br>- If the bot has <em>can_delete_messages</em> permission in a supergroup or a channel, it can delete any message there.<br>Returns <em>True</em> on success.</p>
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

/**
 * <p>Use this method to delete multiple messages simultaneously. If some of the specified messages can't be found, they are skipped. Returns <em>True</em> on success.</p>
 *
 * @property chat_id Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>)
 * @property message_ids A JSON-serialized list of 1-100 identifiers of messages to delete. See <a href="#deletemessage">deleteMessage</a> for limitations on which messages can be deleted
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct DeleteMessagesRequest {
    /// Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>)
    pub chat_id: String,
    /// A JSON-serialized list of 1-100 identifiers of messages to delete. See <a href="#deletemessage">deleteMessage</a> for limitations on which messages can be deleted
    pub message_ids: Vec<Integer>
}


/// Stickers

/**
 * <p>Use this method to send static .WEBP, <a href="https://telegram.org/blog/animated-stickers">animated</a> .TGS, or <a href="https://telegram.org/blog/video-stickers-better-reactions">video</a> .WEBM stickers. On success, the sent <a href="#message">Message</a> is returned.</p>
 *
 * @property business_connection_id Unique identifier of the business connection on behalf of which the message will be sent
 * @property chat_id Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>)
 * @property message_thread_id Unique identifier for the target message thread (topic) of the forum; for forum supergroups only
 * @property sticker Sticker to send. Pass a file_id as String to send a file that exists on the Telegram servers (recommended), pass an HTTP URL as a String for Telegram to get a .WEBP sticker from the Internet, or upload a new .WEBP, .TGS, or .WEBM sticker using multipart/form-data. <a href="#sending-files">More information on Sending Files »</a>. Video and animated stickers can't be sent via an HTTP URL.
 * @property emoji Emoji associated with the sticker; only for just uploaded stickers
 * @property disable_notification Sends the message <a href="https://telegram.org/blog/channels-2-0#silent-messages">silently</a>. Users will receive a notification with no sound.
 * @property protect_content Protects the contents of the sent message from forwarding and saving
 * @property message_effect_id Unique identifier of the message effect to be added to the message; for private chats only
 * @property reply_parameters Description of the message to reply to
 * @property reply_markup Additional interface options. A JSON-serialized object for an <a href="/bots/features#inline-keyboards">inline keyboard</a>, <a href="/bots/features#keyboards">custom reply keyboard</a>, instructions to remove a reply keyboard or to force a reply from the user
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct SendStickerRequest {
    /// Unique identifier of the business connection on behalf of which the message will be sent
    pub business_connection_id: Option<String>,
    /// Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>)
    pub chat_id: String,
    /// Unique identifier for the target message thread (topic) of the forum; for forum supergroups only
    pub message_thread_id: Option<Integer>,
    /// Sticker to send. Pass a file_id as String to send a file that exists on the Telegram servers (recommended), pass an HTTP URL as a String for Telegram to get a .WEBP sticker from the Internet, or upload a new .WEBP, .TGS, or .WEBM sticker using multipart/form-data. <a href="#sending-files">More information on Sending Files »</a>. Video and animated stickers can't be sent via an HTTP URL.
    pub sticker: String,
    /// Emoji associated with the sticker; only for just uploaded stickers
    pub emoji: Option<String>,
    /// Sends the message <a href="https://telegram.org/blog/channels-2-0#silent-messages">silently</a>. Users will receive a notification with no sound.
    pub disable_notification: Option<bool>,
    /// Protects the contents of the sent message from forwarding and saving
    pub protect_content: Option<bool>,
    /// Unique identifier of the message effect to be added to the message; for private chats only
    pub message_effect_id: Option<String>,
    /// Description of the message to reply to
    pub reply_parameters: Option<ReplyParameters>,
    /// Additional interface options. A JSON-serialized object for an <a href="/bots/features#inline-keyboards">inline keyboard</a>, <a href="/bots/features#keyboards">custom reply keyboard</a>, instructions to remove a reply keyboard or to force a reply from the user
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
 * <p>Use this method to get information about custom emoji stickers by their identifiers. Returns an Array of <a href="#sticker">Sticker</a> objects.</p>
 *
 * @property custom_emoji_ids A JSON-serialized list of custom emoji identifiers. At most 200 custom emoji identifiers can be specified.
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct GetCustomEmojiStickersRequest {
    /// A JSON-serialized list of custom emoji identifiers. At most 200 custom emoji identifiers can be specified.
    pub custom_emoji_ids: Vec<String>
}

/**
 * <p>Use this method to upload a file with a sticker for later use in the <a href="#createnewstickerset">createNewStickerSet</a>, <a href="#addstickertoset">addStickerToSet</a>, or <a href="#replacestickerinset">replaceStickerInSet</a> methods (the file can be used multiple times). Returns the uploaded <a href="#file">File</a> on success.</p>
 *
 * @property user_id User identifier of sticker file owner
 * @property sticker A file with the sticker in .WEBP, .PNG, .TGS, or .WEBM format. See <a href="/stickers"></a><a href="https://core.telegram.org/stickers">https://core.telegram.org/stickers</a> for technical requirements. <a href="#sending-files">More information on Sending Files »</a>
 * @property sticker_format Format of the sticker, must be one of “static”, “animated”, “video”
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct UploadStickerFileRequest {
    /// User identifier of sticker file owner
    pub user_id: Integer,
    /// A file with the sticker in .WEBP, .PNG, .TGS, or .WEBM format. See <a href="/stickers"></a><a href="https://core.telegram.org/stickers">https://core.telegram.org/stickers</a> for technical requirements. <a href="#sending-files">More information on Sending Files »</a>
    pub sticker: InputFile,
    /// Format of the sticker, must be one of “static”, “animated”, “video”
    pub sticker_format: String
}

/**
 * <p>Use this method to create a new sticker set owned by a user. The bot will be able to edit the sticker set thus created. Returns <em>True</em> on success.</p>
 *
 * @property user_id User identifier of created sticker set owner
 * @property name Short name of sticker set, to be used in <code>t.me/addstickers/</code> URLs (e.g., <em>animals</em>). Can contain only English letters, digits and underscores. Must begin with a letter, can't contain consecutive underscores and must end in <code>"_by_&lt;bot_username&gt;"</code>. <code>&lt;bot_username&gt;</code> is case insensitive. 1-64 characters.
 * @property title Sticker set title, 1-64 characters
 * @property stickers A JSON-serialized list of 1-50 initial stickers to be added to the sticker set
 * @property sticker_type Type of stickers in the set, pass “regular”, “mask”, or “custom_emoji”. By default, a regular sticker set is created.
 * @property needs_repainting Pass <em>True</em> if stickers in the sticker set must be repainted to the color of text when used in messages, the accent color if used as emoji status, white on chat photos, or another appropriate color based on context; for custom emoji sticker sets only
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct CreateNewStickerSetRequest {
    /// User identifier of created sticker set owner
    pub user_id: Integer,
    /// Short name of sticker set, to be used in <code>t.me/addstickers/</code> URLs (e.g., <em>animals</em>). Can contain only English letters, digits and underscores. Must begin with a letter, can't contain consecutive underscores and must end in <code>"_by_&lt;bot_username&gt;"</code>. <code>&lt;bot_username&gt;</code> is case insensitive. 1-64 characters.
    pub name: String,
    /// Sticker set title, 1-64 characters
    pub title: String,
    /// A JSON-serialized list of 1-50 initial stickers to be added to the sticker set
    pub stickers: Vec<InputSticker>,
    /// Type of stickers in the set, pass “regular”, “mask”, or “custom_emoji”. By default, a regular sticker set is created.
    pub sticker_type: Option<String>,
    /// Pass <em>True</em> if stickers in the sticker set must be repainted to the color of text when used in messages, the accent color if used as emoji status, white on chat photos, or another appropriate color based on context; for custom emoji sticker sets only
    pub needs_repainting: Option<bool>
}

/**
 * <p>Use this method to add a new sticker to a set created by the bot. Emoji sticker sets can have up to 200 stickers. Other sticker sets can have up to 120 stickers. Returns <em>True</em> on success.</p>
 *
 * @property user_id User identifier of sticker set owner
 * @property name Sticker set name
 * @property sticker A JSON-serialized object with information about the added sticker. If exactly the same sticker had already been added to the set, then the set isn't changed.
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct AddStickerToSetRequest {
    /// User identifier of sticker set owner
    pub user_id: Integer,
    /// Sticker set name
    pub name: String,
    /// A JSON-serialized object with information about the added sticker. If exactly the same sticker had already been added to the set, then the set isn't changed.
    pub sticker: InputSticker
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
 * <p>Use this method to replace an existing sticker in a sticker set with a new one. The method is equivalent to calling <a href="#deletestickerfromset">deleteStickerFromSet</a>, then <a href="#addstickertoset">addStickerToSet</a>, then <a href="#setstickerpositioninset">setStickerPositionInSet</a>. Returns <em>True</em> on success.</p>
 *
 * @property user_id User identifier of the sticker set owner
 * @property name Sticker set name
 * @property old_sticker File identifier of the replaced sticker
 * @property sticker A JSON-serialized object with information about the added sticker. If exactly the same sticker had already been added to the set, then the set remains unchanged.
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct ReplaceStickerInSetRequest {
    /// User identifier of the sticker set owner
    pub user_id: Integer,
    /// Sticker set name
    pub name: String,
    /// File identifier of the replaced sticker
    pub old_sticker: String,
    /// A JSON-serialized object with information about the added sticker. If exactly the same sticker had already been added to the set, then the set remains unchanged.
    pub sticker: InputSticker
}

/**
 * <p>Use this method to change the list of emoji assigned to a regular or custom emoji sticker. The sticker must belong to a sticker set created by the bot. Returns <em>True</em> on success.</p>
 *
 * @property sticker File identifier of the sticker
 * @property emoji_list A JSON-serialized list of 1-20 emoji associated with the sticker
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct SetStickerEmojiListRequest {
    /// File identifier of the sticker
    pub sticker: String,
    /// A JSON-serialized list of 1-20 emoji associated with the sticker
    pub emoji_list: Vec<String>
}

/**
 * <p>Use this method to change search keywords assigned to a regular or custom emoji sticker. The sticker must belong to a sticker set created by the bot. Returns <em>True</em> on success.</p>
 *
 * @property sticker File identifier of the sticker
 * @property keywords A JSON-serialized list of 0-20 search keywords for the sticker with total length of up to 64 characters
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct SetStickerKeywordsRequest {
    /// File identifier of the sticker
    pub sticker: String,
    /// A JSON-serialized list of 0-20 search keywords for the sticker with total length of up to 64 characters
    pub keywords: Option<Vec<String>>
}

/**
 * <p>Use this method to change the <a href="#maskposition">mask position</a> of a mask sticker. The sticker must belong to a sticker set that was created by the bot. Returns <em>True</em> on success.</p>
 *
 * @property sticker File identifier of the sticker
 * @property mask_position A JSON-serialized object with the position where the mask should be placed on faces. Omit the parameter to remove the mask position.
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct SetStickerMaskPositionRequest {
    /// File identifier of the sticker
    pub sticker: String,
    /// A JSON-serialized object with the position where the mask should be placed on faces. Omit the parameter to remove the mask position.
    pub mask_position: Option<MaskPosition>
}

/**
 * <p>Use this method to set the title of a created sticker set. Returns <em>True</em> on success.</p>
 *
 * @property name Sticker set name
 * @property title Sticker set title, 1-64 characters
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct SetStickerSetTitleRequest {
    /// Sticker set name
    pub name: String,
    /// Sticker set title, 1-64 characters
    pub title: String
}

/**
 * <p>Use this method to set the thumbnail of a regular or mask sticker set. The format of the thumbnail file must match the format of the stickers in the set. Returns <em>True</em> on success.</p>
 *
 * @property name Sticker set name
 * @property user_id User identifier of the sticker set owner
 * @property thumbnail A <strong>.WEBP</strong> or <strong>.PNG</strong> image with the thumbnail, must be up to 128 kilobytes in size and have a width and height of exactly 100px, or a <strong>.TGS</strong> animation with a thumbnail up to 32 kilobytes in size (see <a href="/stickers#animated-sticker-requirements"></a><a href="https://core.telegram.org/stickers#animated-sticker-requirements">https://core.telegram.org/stickers#animated-sticker-requirements</a> for animated sticker technical requirements), or a <strong>WEBM</strong> video with the thumbnail up to 32 kilobytes in size; see <a href="/stickers#video-sticker-requirements"></a><a href="https://core.telegram.org/stickers#video-sticker-requirements">https://core.telegram.org/stickers#video-sticker-requirements</a> for video sticker technical requirements. Pass a <em>file_id</em> as a String to send a file that already exists on the Telegram servers, pass an HTTP URL as a String for Telegram to get a file from the Internet, or upload a new one using multipart/form-data. <a href="#sending-files">More information on Sending Files »</a>. Animated and video sticker set thumbnails can't be uploaded via HTTP URL. If omitted, then the thumbnail is dropped and the first sticker is used as the thumbnail.
 * @property format Format of the thumbnail, must be one of “static” for a <strong>.WEBP</strong> or <strong>.PNG</strong> image, “animated” for a <strong>.TGS</strong> animation, or “video” for a <strong>WEBM</strong> video
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct SetStickerSetThumbnailRequest {
    /// Sticker set name
    pub name: String,
    /// User identifier of the sticker set owner
    pub user_id: Integer,
    /// A <strong>.WEBP</strong> or <strong>.PNG</strong> image with the thumbnail, must be up to 128 kilobytes in size and have a width and height of exactly 100px, or a <strong>.TGS</strong> animation with a thumbnail up to 32 kilobytes in size (see <a href="/stickers#animated-sticker-requirements"></a><a href="https://core.telegram.org/stickers#animated-sticker-requirements">https://core.telegram.org/stickers#animated-sticker-requirements</a> for animated sticker technical requirements), or a <strong>WEBM</strong> video with the thumbnail up to 32 kilobytes in size; see <a href="/stickers#video-sticker-requirements"></a><a href="https://core.telegram.org/stickers#video-sticker-requirements">https://core.telegram.org/stickers#video-sticker-requirements</a> for video sticker technical requirements. Pass a <em>file_id</em> as a String to send a file that already exists on the Telegram servers, pass an HTTP URL as a String for Telegram to get a file from the Internet, or upload a new one using multipart/form-data. <a href="#sending-files">More information on Sending Files »</a>. Animated and video sticker set thumbnails can't be uploaded via HTTP URL. If omitted, then the thumbnail is dropped and the first sticker is used as the thumbnail.
    pub thumbnail: Option<String>,
    /// Format of the thumbnail, must be one of “static” for a <strong>.WEBP</strong> or <strong>.PNG</strong> image, “animated” for a <strong>.TGS</strong> animation, or “video” for a <strong>WEBM</strong> video
    pub format: String
}

/**
 * <p>Use this method to set the thumbnail of a custom emoji sticker set. Returns <em>True</em> on success.</p>
 *
 * @property name Sticker set name
 * @property custom_emoji_id Custom emoji identifier of a sticker from the sticker set; pass an empty string to drop the thumbnail and use the first sticker as the thumbnail.
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct SetCustomEmojiStickerSetThumbnailRequest {
    /// Sticker set name
    pub name: String,
    /// Custom emoji identifier of a sticker from the sticker set; pass an empty string to drop the thumbnail and use the first sticker as the thumbnail.
    pub custom_emoji_id: Option<String>
}

/**
 * <p>Use this method to delete a sticker set that was created by the bot. Returns <em>True</em> on success.</p>
 *
 * @property name Sticker set name
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct DeleteStickerSetRequest {
    /// Sticker set name
    pub name: String
}


/// Inline mode

/**
 * <p>Use this method to send answers to an inline query. On success, <em>True</em> is returned.<br>No more than <strong>50</strong> results per query are allowed.</p>
 *
 * @property inline_query_id Unique identifier for the answered query
 * @property results A JSON-serialized array of results for the inline query
 * @property cache_time The maximum amount of time in seconds that the result of the inline query may be cached on the server. Defaults to 300.
 * @property is_personal Pass <em>True</em> if results may be cached on the server side only for the user that sent the query. By default, results may be returned to any user who sends the same query.
 * @property next_offset Pass the offset that a client should send in the next query with the same text to receive more results. Pass an empty string if there are no more results or if you don't support pagination. Offset length can't exceed 64 bytes.
 * @property button A JSON-serialized object describing a button to be shown above inline query results
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct AnswerInlineQueryRequest {
    /// Unique identifier for the answered query
    pub inline_query_id: String,
    /// A JSON-serialized array of results for the inline query
    pub results: Vec<InlineQueryResult>,
    /// The maximum amount of time in seconds that the result of the inline query may be cached on the server. Defaults to 300.
    pub cache_time: Option<Integer>,
    /// Pass <em>True</em> if results may be cached on the server side only for the user that sent the query. By default, results may be returned to any user who sends the same query.
    pub is_personal: Option<bool>,
    /// Pass the offset that a client should send in the next query with the same text to receive more results. Pass an empty string if there are no more results or if you don't support pagination. Offset length can't exceed 64 bytes.
    pub next_offset: Option<String>,
    /// A JSON-serialized object describing a button to be shown above inline query results
    pub button: Option<InlineQueryResultsButton>
}

/**
 * <p>Use this method to set the result of an interaction with a <a href="/bots/webapps">Web App</a> and send a corresponding message on behalf of the user to the chat from which the query originated. On success, a <a href="#sentwebappmessage">SentWebAppMessage</a> object is returned.</p>
 *
 * @property web_app_query_id Unique identifier for the query to be answered
 * @property result A JSON-serialized object describing the message to be sent
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct AnswerWebAppQueryRequest {
    /// Unique identifier for the query to be answered
    pub web_app_query_id: String,
    /// A JSON-serialized object describing the message to be sent
    pub result: InlineQueryResult
}


/// Payments

/**
 * <p>Use this method to send invoices. On success, the sent <a href="#message">Message</a> is returned.</p>
 *
 * @property chat_id Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>)
 * @property message_thread_id Unique identifier for the target message thread (topic) of the forum; for forum supergroups only
 * @property title Product name, 1-32 characters
 * @property description Product description, 1-255 characters
 * @property payload Bot-defined invoice payload, 1-128 bytes. This will not be displayed to the user, use for your internal processes.
 * @property provider_token Payment provider token, obtained via <a href="https://t.me/botfather">@BotFather</a>. Pass an empty string for payments in <a href="https://t.me/BotNews/90">Telegram Stars</a>.
 * @property currency Three-letter ISO 4217 currency code, see <a href="/bots/payments#supported-currencies">more on currencies</a>. Pass “XTR” for payments in <a href="https://t.me/BotNews/90">Telegram Stars</a>.
 * @property prices Price breakdown, a JSON-serialized list of components (e.g. product price, tax, discount, delivery cost, delivery tax, bonus, etc.). Must contain exactly one item for payments in <a href="https://t.me/BotNews/90">Telegram Stars</a>.
 * @property max_tip_amount The maximum accepted amount for tips in the <em>smallest units</em> of the currency (integer, <strong>not</strong> float/double). For example, for a maximum tip of <code>US$ 1.45</code> pass <code>max_tip_amount = 145</code>. See the <em>exp</em> parameter in <a href="/bots/payments/currencies.json">currencies.json</a>, it shows the number of digits past the decimal point for each currency (2 for the majority of currencies). Defaults to 0. Not supported for payments in <a href="https://t.me/BotNews/90">Telegram Stars</a>.
 * @property suggested_tip_amounts A JSON-serialized array of suggested amounts of tips in the <em>smallest units</em> of the currency (integer, <strong>not</strong> float/double). At most 4 suggested tip amounts can be specified. The suggested tip amounts must be positive, passed in a strictly increased order and must not exceed <em>max_tip_amount</em>.
 * @property start_parameter Unique deep-linking parameter. If left empty, <strong>forwarded copies</strong> of the sent message will have a <em>Pay</em> button, allowing multiple users to pay directly from the forwarded message, using the same invoice. If non-empty, forwarded copies of the sent message will have a <em>URL</em> button with a deep link to the bot (instead of a <em>Pay</em> button), with the value used as the start parameter
 * @property provider_data JSON-serialized data about the invoice, which will be shared with the payment provider. A detailed description of required fields should be provided by the payment provider.
 * @property photo_url URL of the product photo for the invoice. Can be a photo of the goods or a marketing image for a service. People like it better when they see what they are paying for.
 * @property photo_size Photo size in bytes
 * @property photo_width Photo width
 * @property photo_height Photo height
 * @property need_name Pass <em>True</em> if you require the user's full name to complete the order. Ignored for payments in <a href="https://t.me/BotNews/90">Telegram Stars</a>.
 * @property need_phone_number Pass <em>True</em> if you require the user's phone number to complete the order. Ignored for payments in <a href="https://t.me/BotNews/90">Telegram Stars</a>.
 * @property need_email Pass <em>True</em> if you require the user's email address to complete the order. Ignored for payments in <a href="https://t.me/BotNews/90">Telegram Stars</a>.
 * @property need_shipping_address Pass <em>True</em> if you require the user's shipping address to complete the order. Ignored for payments in <a href="https://t.me/BotNews/90">Telegram Stars</a>.
 * @property send_phone_number_to_provider Pass <em>True</em> if the user's phone number should be sent to the provider. Ignored for payments in <a href="https://t.me/BotNews/90">Telegram Stars</a>.
 * @property send_email_to_provider Pass <em>True</em> if the user's email address should be sent to the provider. Ignored for payments in <a href="https://t.me/BotNews/90">Telegram Stars</a>.
 * @property is_flexible Pass <em>True</em> if the final price depends on the shipping method. Ignored for payments in <a href="https://t.me/BotNews/90">Telegram Stars</a>.
 * @property disable_notification Sends the message <a href="https://telegram.org/blog/channels-2-0#silent-messages">silently</a>. Users will receive a notification with no sound.
 * @property protect_content Protects the contents of the sent message from forwarding and saving
 * @property message_effect_id Unique identifier of the message effect to be added to the message; for private chats only
 * @property reply_parameters Description of the message to reply to
 * @property reply_markup A JSON-serialized object for an <a href="/bots/features#inline-keyboards">inline keyboard</a>. If empty, one 'Pay <code>total price</code>' button will be shown. If not empty, the first button must be a Pay button.
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct SendInvoiceRequest {
    /// Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>)
    pub chat_id: String,
    /// Unique identifier for the target message thread (topic) of the forum; for forum supergroups only
    pub message_thread_id: Option<Integer>,
    /// Product name, 1-32 characters
    pub title: String,
    /// Product description, 1-255 characters
    pub description: String,
    /// Bot-defined invoice payload, 1-128 bytes. This will not be displayed to the user, use for your internal processes.
    pub payload: String,
    /// Payment provider token, obtained via <a href="https://t.me/botfather">@BotFather</a>. Pass an empty string for payments in <a href="https://t.me/BotNews/90">Telegram Stars</a>.
    pub provider_token: Option<String>,
    /// Three-letter ISO 4217 currency code, see <a href="/bots/payments#supported-currencies">more on currencies</a>. Pass “XTR” for payments in <a href="https://t.me/BotNews/90">Telegram Stars</a>.
    pub currency: String,
    /// Price breakdown, a JSON-serialized list of components (e.g. product price, tax, discount, delivery cost, delivery tax, bonus, etc.). Must contain exactly one item for payments in <a href="https://t.me/BotNews/90">Telegram Stars</a>.
    pub prices: Vec<LabeledPrice>,
    /// The maximum accepted amount for tips in the <em>smallest units</em> of the currency (integer, <strong>not</strong> float/double). For example, for a maximum tip of <code>US$ 1.45</code> pass <code>max_tip_amount = 145</code>. See the <em>exp</em> parameter in <a href="/bots/payments/currencies.json">currencies.json</a>, it shows the number of digits past the decimal point for each currency (2 for the majority of currencies). Defaults to 0. Not supported for payments in <a href="https://t.me/BotNews/90">Telegram Stars</a>.
    pub max_tip_amount: Option<Integer>,
    /// A JSON-serialized array of suggested amounts of tips in the <em>smallest units</em> of the currency (integer, <strong>not</strong> float/double). At most 4 suggested tip amounts can be specified. The suggested tip amounts must be positive, passed in a strictly increased order and must not exceed <em>max_tip_amount</em>.
    pub suggested_tip_amounts: Option<Vec<Integer>>,
    /// Unique deep-linking parameter. If left empty, <strong>forwarded copies</strong> of the sent message will have a <em>Pay</em> button, allowing multiple users to pay directly from the forwarded message, using the same invoice. If non-empty, forwarded copies of the sent message will have a <em>URL</em> button with a deep link to the bot (instead of a <em>Pay</em> button), with the value used as the start parameter
    pub start_parameter: Option<String>,
    /// JSON-serialized data about the invoice, which will be shared with the payment provider. A detailed description of required fields should be provided by the payment provider.
    pub provider_data: Option<String>,
    /// URL of the product photo for the invoice. Can be a photo of the goods or a marketing image for a service. People like it better when they see what they are paying for.
    pub photo_url: Option<String>,
    /// Photo size in bytes
    pub photo_size: Option<Integer>,
    /// Photo width
    pub photo_width: Option<Integer>,
    /// Photo height
    pub photo_height: Option<Integer>,
    /// Pass <em>True</em> if you require the user's full name to complete the order. Ignored for payments in <a href="https://t.me/BotNews/90">Telegram Stars</a>.
    pub need_name: Option<bool>,
    /// Pass <em>True</em> if you require the user's phone number to complete the order. Ignored for payments in <a href="https://t.me/BotNews/90">Telegram Stars</a>.
    pub need_phone_number: Option<bool>,
    /// Pass <em>True</em> if you require the user's email address to complete the order. Ignored for payments in <a href="https://t.me/BotNews/90">Telegram Stars</a>.
    pub need_email: Option<bool>,
    /// Pass <em>True</em> if you require the user's shipping address to complete the order. Ignored for payments in <a href="https://t.me/BotNews/90">Telegram Stars</a>.
    pub need_shipping_address: Option<bool>,
    /// Pass <em>True</em> if the user's phone number should be sent to the provider. Ignored for payments in <a href="https://t.me/BotNews/90">Telegram Stars</a>.
    pub send_phone_number_to_provider: Option<bool>,
    /// Pass <em>True</em> if the user's email address should be sent to the provider. Ignored for payments in <a href="https://t.me/BotNews/90">Telegram Stars</a>.
    pub send_email_to_provider: Option<bool>,
    /// Pass <em>True</em> if the final price depends on the shipping method. Ignored for payments in <a href="https://t.me/BotNews/90">Telegram Stars</a>.
    pub is_flexible: Option<bool>,
    /// Sends the message <a href="https://telegram.org/blog/channels-2-0#silent-messages">silently</a>. Users will receive a notification with no sound.
    pub disable_notification: Option<bool>,
    /// Protects the contents of the sent message from forwarding and saving
    pub protect_content: Option<bool>,
    /// Unique identifier of the message effect to be added to the message; for private chats only
    pub message_effect_id: Option<String>,
    /// Description of the message to reply to
    pub reply_parameters: Option<ReplyParameters>,
    /// A JSON-serialized object for an <a href="/bots/features#inline-keyboards">inline keyboard</a>. If empty, one 'Pay <code>total price</code>' button will be shown. If not empty, the first button must be a Pay button.
    pub reply_markup: Option<InlineKeyboardMarkup>
}

/**
 * <p>Use this method to create a link for an invoice. Returns the created invoice link as <em>String</em> on success.</p>
 *
 * @property title Product name, 1-32 characters
 * @property description Product description, 1-255 characters
 * @property payload Bot-defined invoice payload, 1-128 bytes. This will not be displayed to the user, use for your internal processes.
 * @property provider_token Payment provider token, obtained via <a href="https://t.me/botfather">@BotFather</a>. Pass an empty string for payments in <a href="https://t.me/BotNews/90">Telegram Stars</a>.
 * @property currency Three-letter ISO 4217 currency code, see <a href="/bots/payments#supported-currencies">more on currencies</a>. Pass “XTR” for payments in <a href="https://t.me/BotNews/90">Telegram Stars</a>.
 * @property prices Price breakdown, a JSON-serialized list of components (e.g. product price, tax, discount, delivery cost, delivery tax, bonus, etc.). Must contain exactly one item for payments in <a href="https://t.me/BotNews/90">Telegram Stars</a>.
 * @property max_tip_amount The maximum accepted amount for tips in the <em>smallest units</em> of the currency (integer, <strong>not</strong> float/double). For example, for a maximum tip of <code>US$ 1.45</code> pass <code>max_tip_amount = 145</code>. See the <em>exp</em> parameter in <a href="/bots/payments/currencies.json">currencies.json</a>, it shows the number of digits past the decimal point for each currency (2 for the majority of currencies). Defaults to 0. Not supported for payments in <a href="https://t.me/BotNews/90">Telegram Stars</a>.
 * @property suggested_tip_amounts A JSON-serialized array of suggested amounts of tips in the <em>smallest units</em> of the currency (integer, <strong>not</strong> float/double). At most 4 suggested tip amounts can be specified. The suggested tip amounts must be positive, passed in a strictly increased order and must not exceed <em>max_tip_amount</em>.
 * @property provider_data JSON-serialized data about the invoice, which will be shared with the payment provider. A detailed description of required fields should be provided by the payment provider.
 * @property photo_url URL of the product photo for the invoice. Can be a photo of the goods or a marketing image for a service.
 * @property photo_size Photo size in bytes
 * @property photo_width Photo width
 * @property photo_height Photo height
 * @property need_name Pass <em>True</em> if you require the user's full name to complete the order. Ignored for payments in <a href="https://t.me/BotNews/90">Telegram Stars</a>.
 * @property need_phone_number Pass <em>True</em> if you require the user's phone number to complete the order. Ignored for payments in <a href="https://t.me/BotNews/90">Telegram Stars</a>.
 * @property need_email Pass <em>True</em> if you require the user's email address to complete the order. Ignored for payments in <a href="https://t.me/BotNews/90">Telegram Stars</a>.
 * @property need_shipping_address Pass <em>True</em> if you require the user's shipping address to complete the order. Ignored for payments in <a href="https://t.me/BotNews/90">Telegram Stars</a>.
 * @property send_phone_number_to_provider Pass <em>True</em> if the user's phone number should be sent to the provider. Ignored for payments in <a href="https://t.me/BotNews/90">Telegram Stars</a>.
 * @property send_email_to_provider Pass <em>True</em> if the user's email address should be sent to the provider. Ignored for payments in <a href="https://t.me/BotNews/90">Telegram Stars</a>.
 * @property is_flexible Pass <em>True</em> if the final price depends on the shipping method. Ignored for payments in <a href="https://t.me/BotNews/90">Telegram Stars</a>.
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct CreateInvoiceLinkRequest {
    /// Product name, 1-32 characters
    pub title: String,
    /// Product description, 1-255 characters
    pub description: String,
    /// Bot-defined invoice payload, 1-128 bytes. This will not be displayed to the user, use for your internal processes.
    pub payload: String,
    /// Payment provider token, obtained via <a href="https://t.me/botfather">@BotFather</a>. Pass an empty string for payments in <a href="https://t.me/BotNews/90">Telegram Stars</a>.
    pub provider_token: Option<String>,
    /// Three-letter ISO 4217 currency code, see <a href="/bots/payments#supported-currencies">more on currencies</a>. Pass “XTR” for payments in <a href="https://t.me/BotNews/90">Telegram Stars</a>.
    pub currency: String,
    /// Price breakdown, a JSON-serialized list of components (e.g. product price, tax, discount, delivery cost, delivery tax, bonus, etc.). Must contain exactly one item for payments in <a href="https://t.me/BotNews/90">Telegram Stars</a>.
    pub prices: Vec<LabeledPrice>,
    /// The maximum accepted amount for tips in the <em>smallest units</em> of the currency (integer, <strong>not</strong> float/double). For example, for a maximum tip of <code>US$ 1.45</code> pass <code>max_tip_amount = 145</code>. See the <em>exp</em> parameter in <a href="/bots/payments/currencies.json">currencies.json</a>, it shows the number of digits past the decimal point for each currency (2 for the majority of currencies). Defaults to 0. Not supported for payments in <a href="https://t.me/BotNews/90">Telegram Stars</a>.
    pub max_tip_amount: Option<Integer>,
    /// A JSON-serialized array of suggested amounts of tips in the <em>smallest units</em> of the currency (integer, <strong>not</strong> float/double). At most 4 suggested tip amounts can be specified. The suggested tip amounts must be positive, passed in a strictly increased order and must not exceed <em>max_tip_amount</em>.
    pub suggested_tip_amounts: Option<Vec<Integer>>,
    /// JSON-serialized data about the invoice, which will be shared with the payment provider. A detailed description of required fields should be provided by the payment provider.
    pub provider_data: Option<String>,
    /// URL of the product photo for the invoice. Can be a photo of the goods or a marketing image for a service.
    pub photo_url: Option<String>,
    /// Photo size in bytes
    pub photo_size: Option<Integer>,
    /// Photo width
    pub photo_width: Option<Integer>,
    /// Photo height
    pub photo_height: Option<Integer>,
    /// Pass <em>True</em> if you require the user's full name to complete the order. Ignored for payments in <a href="https://t.me/BotNews/90">Telegram Stars</a>.
    pub need_name: Option<bool>,
    /// Pass <em>True</em> if you require the user's phone number to complete the order. Ignored for payments in <a href="https://t.me/BotNews/90">Telegram Stars</a>.
    pub need_phone_number: Option<bool>,
    /// Pass <em>True</em> if you require the user's email address to complete the order. Ignored for payments in <a href="https://t.me/BotNews/90">Telegram Stars</a>.
    pub need_email: Option<bool>,
    /// Pass <em>True</em> if you require the user's shipping address to complete the order. Ignored for payments in <a href="https://t.me/BotNews/90">Telegram Stars</a>.
    pub need_shipping_address: Option<bool>,
    /// Pass <em>True</em> if the user's phone number should be sent to the provider. Ignored for payments in <a href="https://t.me/BotNews/90">Telegram Stars</a>.
    pub send_phone_number_to_provider: Option<bool>,
    /// Pass <em>True</em> if the user's email address should be sent to the provider. Ignored for payments in <a href="https://t.me/BotNews/90">Telegram Stars</a>.
    pub send_email_to_provider: Option<bool>,
    /// Pass <em>True</em> if the final price depends on the shipping method. Ignored for payments in <a href="https://t.me/BotNews/90">Telegram Stars</a>.
    pub is_flexible: Option<bool>
}

/**
 * <p>If you sent an invoice requesting a shipping address and the parameter <em>is_flexible</em> was specified, the Bot API will send an <a href="#update">Update</a> with a <em>shipping_query</em> field to the bot. Use this method to reply to shipping queries. On success, <em>True</em> is returned.</p>
 *
 * @property shipping_query_id Unique identifier for the query to be answered
 * @property ok Pass <em>True</em> if delivery to the specified address is possible and <em>False</em> if there are any problems (for example, if delivery to the specified address is not possible)
 * @property shipping_options Required if <em>ok</em> is <em>True</em>. A JSON-serialized array of available shipping options.
 * @property error_message Required if <em>ok</em> is <em>False</em>. Error message in human readable form that explains why it is impossible to complete the order (e.g. "Sorry, delivery to your desired address is unavailable'). Telegram will display this message to the user.
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct AnswerShippingQueryRequest {
    /// Unique identifier for the query to be answered
    pub shipping_query_id: String,
    /// Pass <em>True</em> if delivery to the specified address is possible and <em>False</em> if there are any problems (for example, if delivery to the specified address is not possible)
    pub ok: bool,
    /// Required if <em>ok</em> is <em>True</em>. A JSON-serialized array of available shipping options.
    pub shipping_options: Option<Vec<ShippingOption>>,
    /// Required if <em>ok</em> is <em>False</em>. Error message in human readable form that explains why it is impossible to complete the order (e.g. "Sorry, delivery to your desired address is unavailable'). Telegram will display this message to the user.
    pub error_message: Option<String>
}

/**
 * <p>Once the user has confirmed their payment and shipping details, the Bot API sends the final confirmation in the form of an <a href="#update">Update</a> with the field <em>pre_checkout_query</em>. Use this method to respond to such pre-checkout queries. On success, <em>True</em> is returned. <strong>Note:</strong> The Bot API must receive an answer within 10 seconds after the pre-checkout query was sent.</p>
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

/**
 * <p>Refunds a successful payment in <a href="https://t.me/BotNews/90">Telegram Stars</a>. Returns <em>True</em> on success.</p>
 *
 * @property user_id Identifier of the user whose payment will be refunded
 * @property telegram_payment_charge_id Telegram payment identifier
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct RefundStarPaymentRequest {
    /// Identifier of the user whose payment will be refunded
    pub user_id: Integer,
    /// Telegram payment identifier
    pub telegram_payment_charge_id: String
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
 * @property business_connection_id Unique identifier of the business connection on behalf of which the message will be sent
 * @property chat_id Unique identifier for the target chat
 * @property message_thread_id Unique identifier for the target message thread (topic) of the forum; for forum supergroups only
 * @property game_short_name Short name of the game, serves as the unique identifier for the game. Set up your games via <a href="https://t.me/botfather">@BotFather</a>.
 * @property disable_notification Sends the message <a href="https://telegram.org/blog/channels-2-0#silent-messages">silently</a>. Users will receive a notification with no sound.
 * @property protect_content Protects the contents of the sent message from forwarding and saving
 * @property message_effect_id Unique identifier of the message effect to be added to the message; for private chats only
 * @property reply_parameters Description of the message to reply to
 * @property reply_markup A JSON-serialized object for an <a href="/bots/features#inline-keyboards">inline keyboard</a>. If empty, one 'Play game_title' button will be shown. If not empty, the first button must launch the game.
 * */
#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]
pub struct SendGameRequest {
    /// Unique identifier of the business connection on behalf of which the message will be sent
    pub business_connection_id: Option<String>,
    /// Unique identifier for the target chat
    pub chat_id: Integer,
    /// Unique identifier for the target message thread (topic) of the forum; for forum supergroups only
    pub message_thread_id: Option<Integer>,
    /// Short name of the game, serves as the unique identifier for the game. Set up your games via <a href="https://t.me/botfather">@BotFather</a>.
    pub game_short_name: String,
    /// Sends the message <a href="https://telegram.org/blog/channels-2-0#silent-messages">silently</a>. Users will receive a notification with no sound.
    pub disable_notification: Option<bool>,
    /// Protects the contents of the sent message from forwarding and saving
    pub protect_content: Option<bool>,
    /// Unique identifier of the message effect to be added to the message; for private chats only
    pub message_effect_id: Option<String>,
    /// Description of the message to reply to
    pub reply_parameters: Option<ReplyParameters>,
    /// A JSON-serialized object for an <a href="/bots/features#inline-keyboards">inline keyboard</a>. If empty, one 'Play game_title' button will be shown. If not empty, the first button must launch the game.
    pub reply_markup: Option<InlineKeyboardMarkup>
}

/**
 * <p>Use this method to set the score of the specified user in a game message. On success, if the message is not an inline message, the <a href="#message">Message</a> is returned, otherwise <em>True</em> is returned. Returns an error, if the new score is not greater than the user's current score in the chat and <em>force</em> is <em>False</em>.</p>
 *
 * @property user_id User identifier
 * @property score New score, must be non-negative
 * @property force Pass <em>True</em> if the high score is allowed to decrease. This can be useful when fixing mistakes or banning cheaters
 * @property disable_edit_message Pass <em>True</em> if the game message should not be automatically edited to include the current scoreboard
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
    /// Pass <em>True</em> if the high score is allowed to decrease. This can be useful when fixing mistakes or banning cheaters
    pub force: Option<bool>,
    /// Pass <em>True</em> if the game message should not be automatically edited to include the current scoreboard
    pub disable_edit_message: Option<bool>,
    /// Required if <em>inline_message_id</em> is not specified. Unique identifier for the target chat
    pub chat_id: Option<Integer>,
    /// Required if <em>inline_message_id</em> is not specified. Identifier of the sent message
    pub message_id: Option<Integer>,
    /// Required if <em>chat_id</em> and <em>message_id</em> are not specified. Identifier of the inline message
    pub inline_message_id: Option<String>
}

/**
 * <p>Use this method to get data for high score tables. Will return the score of the specified user and several of their neighbors in a game. Returns an Array of <a href="#gamehighscore">GameHighScore</a> objects.</p><blockquote>
 *  <p>This method will currently return scores for the target user, plus two of their closest neighbors on each side. Will also return the top three users if the user and their neighbors are not among them. Please note that this behavior is subject to change.</p>
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

