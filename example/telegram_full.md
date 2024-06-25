

## Getting updates

### Data Types
#### Update

    Update(update_id: Integer, message: Message, edited_message: Message, channel_post: Message, edited_channel_post: Message, business_connection: BusinessConnection, business_message: Message, edited_business_message: Message, deleted_business_messages: BusinessMessagesDeleted, message_reaction: MessageReactionUpdated, message_reaction_count: MessageReactionCountUpdated, inline_query: InlineQuery, chosen_inline_result: ChosenInlineResult, callback_query: CallbackQuery, shipping_query: ShippingQuery, pre_checkout_query: PreCheckoutQuery, poll: Poll, poll_answer: PollAnswer, my_chat_member: ChatMemberUpdated, chat_member: ChatMemberUpdated, chat_join_request: ChatJoinRequest, chat_boost: ChatBoostUpdated, removed_chat_boost: ChatBoostRemoved)

<p>This <a href="#available-types">object</a> represents an incoming update.<br>At most <strong>one</strong> of the optional parameters can be present in any given update.</p>

| name | type | required | description |
|---|---|---|---|
| update_id | Integer | true | The update's unique identifier. Update identifiers start from a certain positive number and increase sequentially. This identifier becomes especially handy if you're using <a href="#setwebhook">webhooks</a>, since it allows you to ignore repeated updates or to restore the correct update sequence, should they get out of order. If there are no new updates for at least a week, then identifier of the next update will be chosen randomly instead of sequentially. |
| message | Message | false | <em>Optional</em>. New incoming message of any kind - text, photo, sticker, etc. |
| edited_message | Message | false | <em>Optional</em>. New version of a message that is known to the bot and was edited. This update may at times be triggered by changes to message fields that are either unavailable or not actively used by your bot. |
| channel_post | Message | false | <em>Optional</em>. New incoming channel post of any kind - text, photo, sticker, etc. |
| edited_channel_post | Message | false | <em>Optional</em>. New version of a channel post that is known to the bot and was edited. This update may at times be triggered by changes to message fields that are either unavailable or not actively used by your bot. |
| business_connection | BusinessConnection | false | <em>Optional</em>. The bot was connected to or disconnected from a business account, or a user edited an existing connection with the bot |
| business_message | Message | false | <em>Optional</em>. New message from a connected business account |
| edited_business_message | Message | false | <em>Optional</em>. New version of a message from a connected business account |
| deleted_business_messages | BusinessMessagesDeleted | false | <em>Optional</em>. Messages were deleted from a connected business account |
| message_reaction | MessageReactionUpdated | false | <em>Optional</em>. A reaction to a message was changed by a user. The bot must be an administrator in the chat and must explicitly specify <code>"message_reaction"</code> in the list of <em>allowed_updates</em> to receive these updates. The update isn't received for reactions set by bots. |
| message_reaction_count | MessageReactionCountUpdated | false | <em>Optional</em>. Reactions to a message with anonymous reactions were changed. The bot must be an administrator in the chat and must explicitly specify <code>"message_reaction_count"</code> in the list of <em>allowed_updates</em> to receive these updates. The updates are grouped and can be sent with delay up to a few minutes. |
| inline_query | InlineQuery | false | <em>Optional</em>. New incoming <a href="#inline-mode">inline</a> query |
| chosen_inline_result | ChosenInlineResult | false | <em>Optional</em>. The result of an <a href="#inline-mode">inline</a> query that was chosen by a user and sent to their chat partner. Please see our documentation on the <a href="/bots/inline#collecting-feedback">feedback collecting</a> for details on how to enable these updates for your bot. |
| callback_query | CallbackQuery | false | <em>Optional</em>. New incoming callback query |
| shipping_query | ShippingQuery | false | <em>Optional</em>. New incoming shipping query. Only for invoices with flexible price |
| pre_checkout_query | PreCheckoutQuery | false | <em>Optional</em>. New incoming pre-checkout query. Contains full information about checkout |
| poll | Poll | false | <em>Optional</em>. New poll state. Bots receive only updates about manually stopped polls and polls, which are sent by the bot |
| poll_answer | PollAnswer | false | <em>Optional</em>. A user changed their answer in a non-anonymous poll. Bots receive new votes only in polls that were sent by the bot itself. |
| my_chat_member | ChatMemberUpdated | false | <em>Optional</em>. The bot's chat member status was updated in a chat. For private chats, this update is received only when the bot is blocked or unblocked by the user. |
| chat_member | ChatMemberUpdated | false | <em>Optional</em>. A chat member's status was updated in a chat. The bot must be an administrator in the chat and must explicitly specify <code>"chat_member"</code> in the list of <em>allowed_updates</em> to receive these updates. |
| chat_join_request | ChatJoinRequest | false | <em>Optional</em>. A request to join the chat has been sent. The bot must have the <em>can_invite_users</em> administrator right in the chat to receive these updates. |
| chat_boost | ChatBoostUpdated | false | <em>Optional</em>. A chat boost was added or changed. The bot must be an administrator in the chat to receive these updates. |
| removed_chat_boost | ChatBoostRemoved | false | <em>Optional</em>. A boost was removed from a chat. The bot must be an administrator in the chat to receive these updates. |

#### WebhookInfo

    WebhookInfo(url: String, has_custom_certificate: Boolean, pending_update_count: Integer, ip_address: String, last_error_date: Integer, last_error_message: String, last_synchronization_error_date: Integer, max_connections: Integer, allowed_updates: List<String>)

<p>Describes the current status of a webhook.</p>

| name | type | required | description |
|---|---|---|---|
| url | String | true | Webhook URL, may be empty if webhook is not set up |
| has_custom_certificate | Boolean | true | <em>True</em>, if a custom certificate was provided for webhook certificate checks |
| pending_update_count | Integer | true | Number of updates awaiting delivery |
| ip_address | String | false | <em>Optional</em>. Currently used webhook IP address |
| last_error_date | Integer | false | <em>Optional</em>. Unix time for the most recent error that happened when trying to deliver an update via webhook |
| last_error_message | String | false | <em>Optional</em>. Error message in human-readable format for the most recent error that happened when trying to deliver an update via webhook |
| last_synchronization_error_date | Integer | false | <em>Optional</em>. Unix time of the most recent error that happened when trying to synchronize available updates with Telegram datacenters |
| max_connections | Integer | false | <em>Optional</em>. The maximum allowed number of simultaneous HTTPS connections to the webhook for update delivery |
| allowed_updates | List<String> | false | <em>Optional</em>. A list of update types the bot is subscribed to. Defaults to all update types except <em>chat_member</em> |


### Methods
#### getUpdates

    getUpdates(offset: Integer, limit: Integer, timeout: Integer, allowed_updates: List<String>)

<p>Use this method to receive incoming updates using long polling (<a href="https://en.wikipedia.org/wiki/Push_technology#Long_polling">wiki</a>). Returns an Array of <a href="#update">Update</a> objects.</p><blockquote>
 <p><strong>Notes</strong><br><strong>1.</strong> This method will not work if an outgoing webhook is set up.<br><strong>2.</strong> In order to avoid getting duplicate updates, recalculate <em>offset</em> after each server response.</p>
</blockquote>

| name | type | required | description |
|---|---|---|---|
| offset | Integer | false | Identifier of the first update to be returned. Must be greater by one than the highest among the identifiers of previously received updates. By default, updates starting with the earliest unconfirmed update are returned. An update is considered confirmed as soon as <a href="#getupdates">getUpdates</a> is called with an <em>offset</em> higher than its <em>update_id</em>. The negative offset can be specified to retrieve updates starting from <em>-offset</em> update from the end of the updates queue. All previous updates will be forgotten. |
| limit | Integer | false | Limits the number of updates to be retrieved. Values between 1-100 are accepted. Defaults to 100. |
| timeout | Integer | false | Timeout in seconds for long polling. Defaults to 0, i.e. usual short polling. Should be positive, short polling should be used for testing purposes only. |
| allowed_updates | List<String> | false | A JSON-serialized list of the update types you want your bot to receive. For example, specify <code>["message", "edited_channel_post", "callback_query"]</code> to only receive updates of these types. See <a href="#update">Update</a> for a complete list of available update types. Specify an empty list to receive all update types except <em>chat_member</em>, <em>message_reaction</em>, and <em>message_reaction_count</em> (default). If not specified, the previous setting will be used.<br><br>Please note that this parameter doesn't affect updates created before the call to the getUpdates, so unwanted updates may be received for a short period of time. |

#### setWebhook

    setWebhook(url: String, certificate: InputFile, ip_address: String, max_connections: Integer, allowed_updates: List<String>, drop_pending_updates: Boolean, secret_token: String)

<p>Use this method to specify a URL and receive incoming updates via an outgoing webhook. Whenever there is an update for the bot, we will send an HTTPS POST request to the specified URL, containing a JSON-serialized <a href="#update">Update</a>. In case of an unsuccessful request, we will give up after a reasonable amount of attempts. Returns <em>True</em> on success.</p><p>If you'd like to make sure that the webhook was set by you, you can specify secret data in the parameter <em>secret_token</em>. If specified, the request will contain a header “X-Telegram-Bot-Api-Secret-Token” with the secret token as content.</p><blockquote>
 <p><strong>Notes</strong><br><strong>1.</strong> You will not be able to receive updates using <a href="#getupdates">getUpdates</a> for as long as an outgoing webhook is set up.<br><strong>2.</strong> To use a self-signed certificate, you need to upload your <a href="/bots/self-signed">public key certificate</a> using <em>certificate</em> parameter. Please upload as InputFile, sending a String will not work.<br><strong>3.</strong> Ports currently supported <em>for webhooks</em>: <strong>443, 80, 88, 8443</strong>.</p>
 <p>If you're having any trouble setting up webhooks, please check out this <a href="/bots/webhooks">amazing guide to webhooks</a>.</p>
</blockquote>

| name | type | required | description |
|---|---|---|---|
| url | String | true | HTTPS URL to send updates to. Use an empty string to remove webhook integration |
| certificate | InputFile | false | Upload your public key certificate so that the root certificate in use can be checked. See our <a href="/bots/self-signed">self-signed guide</a> for details. |
| ip_address | String | false | The fixed IP address which will be used to send webhook requests instead of the IP address resolved through DNS |
| max_connections | Integer | false | The maximum allowed number of simultaneous HTTPS connections to the webhook for update delivery, 1-100. Defaults to <em>40</em>. Use lower values to limit the load on your bot's server, and higher values to increase your bot's throughput. |
| allowed_updates | List<String> | false | A JSON-serialized list of the update types you want your bot to receive. For example, specify <code>["message", "edited_channel_post", "callback_query"]</code> to only receive updates of these types. See <a href="#update">Update</a> for a complete list of available update types. Specify an empty list to receive all update types except <em>chat_member</em>, <em>message_reaction</em>, and <em>message_reaction_count</em> (default). If not specified, the previous setting will be used.<br>Please note that this parameter doesn't affect updates created before the call to the setWebhook, so unwanted updates may be received for a short period of time. |
| drop_pending_updates | Boolean | false | Pass <em>True</em> to drop all pending updates |
| secret_token | String | false | A secret token to be sent in a header “X-Telegram-Bot-Api-Secret-Token” in every webhook request, 1-256 characters. Only characters <code>A-Z</code>, <code>a-z</code>, <code>0-9</code>, <code>_</code> and <code>-</code> are allowed. The header is useful to ensure that the request comes from a webhook set by you. |

#### deleteWebhook

    deleteWebhook(drop_pending_updates: Boolean)

<p>Use this method to remove webhook integration if you decide to switch back to <a href="#getupdates">getUpdates</a>. Returns <em>True</em> on success.</p>

| name | type | required | description |
|---|---|---|---|
| drop_pending_updates | Boolean | false | Pass <em>True</em> to drop all pending updates |

#### getWebhookInfo

    getWebhookInfo()

<p>Use this method to get current webhook status. Requires no parameters. On success, returns a <a href="#webhookinfo">WebhookInfo</a> object. If the bot is using <a href="#getupdates">getUpdates</a>, will return an object with the <em>url</em> field empty.</p>



## Available types

### Data Types
#### User

    User(id: Integer, is_bot: Boolean, first_name: String, last_name: String, username: String, language_code: String, is_premium: Boolean, added_to_attachment_menu: Boolean, can_join_groups: Boolean, can_read_all_group_messages: Boolean, supports_inline_queries: Boolean, can_connect_to_business: Boolean)

<p>This object represents a Telegram user or bot.</p>

| name | type | required | description |
|---|---|---|---|
| id | Integer | true | Unique identifier for this user or bot. This number may have more than 32 significant bits and some programming languages may have difficulty/silent defects in interpreting it. But it has at most 52 significant bits, so a 64-bit integer or double-precision float type are safe for storing this identifier. |
| is_bot | Boolean | true | <em>True</em>, if this user is a bot |
| first_name | String | true | User's or bot's first name |
| last_name | String | false | <em>Optional</em>. User's or bot's last name |
| username | String | false | <em>Optional</em>. User's or bot's username |
| language_code | String | false | <em>Optional</em>. <a href="https://en.wikipedia.org/wiki/IETF_language_tag">IETF language tag</a> of the user's language |
| is_premium | Boolean | false | <em>Optional</em>. <em>True</em>, if this user is a Telegram Premium user |
| added_to_attachment_menu | Boolean | false | <em>Optional</em>. <em>True</em>, if this user added the bot to the attachment menu |
| can_join_groups | Boolean | false | <em>Optional</em>. <em>True</em>, if the bot can be invited to groups. Returned only in <a href="#getme">getMe</a>. |
| can_read_all_group_messages | Boolean | false | <em>Optional</em>. <em>True</em>, if <a href="/bots/features#privacy-mode">privacy mode</a> is disabled for the bot. Returned only in <a href="#getme">getMe</a>. |
| supports_inline_queries | Boolean | false | <em>Optional</em>. <em>True</em>, if the bot supports inline queries. Returned only in <a href="#getme">getMe</a>. |
| can_connect_to_business | Boolean | false | <em>Optional</em>. <em>True</em>, if the bot can be connected to a Telegram Business account to receive its messages. Returned only in <a href="#getme">getMe</a>. |

#### Chat

    Chat(id: Integer, type: String, title: String, username: String, first_name: String, last_name: String, is_forum: Boolean)

<p>This object represents a chat.</p>

| name | type | required | description |
|---|---|---|---|
| id | Integer | true | Unique identifier for this chat. This number may have more than 32 significant bits and some programming languages may have difficulty/silent defects in interpreting it. But it has at most 52 significant bits, so a signed 64-bit integer or double-precision float type are safe for storing this identifier. |
| type | String | true | Type of the chat, can be either “private”, “group”, “supergroup” or “channel” |
| title | String | false | <em>Optional</em>. Title, for supergroups, channels and group chats |
| username | String | false | <em>Optional</em>. Username, for private chats, supergroups and channels if available |
| first_name | String | false | <em>Optional</em>. First name of the other party in a private chat |
| last_name | String | false | <em>Optional</em>. Last name of the other party in a private chat |
| is_forum | Boolean | false | <em>Optional</em>. <em>True</em>, if the supergroup chat is a forum (has <a href="https://telegram.org/blog/topics-in-groups-collectible-usernames#topics-in-groups">topics</a> enabled) |

#### ChatFullInfo

    ChatFullInfo(id: Integer, type: String, title: String, username: String, first_name: String, last_name: String, is_forum: Boolean, accent_color_id: Integer, max_reaction_count: Integer, photo: ChatPhoto, active_usernames: List<String>, birthdate: Birthdate, business_intro: BusinessIntro, business_location: BusinessLocation, business_opening_hours: BusinessOpeningHours, personal_chat: Chat, available_reactions: List<ReactionType>, background_custom_emoji_id: String, profile_accent_color_id: Integer, profile_background_custom_emoji_id: String, emoji_status_custom_emoji_id: String, emoji_status_expiration_date: Integer, bio: String, has_private_forwards: Boolean, has_restricted_voice_and_video_messages: Boolean, join_to_send_messages: Boolean, join_by_request: Boolean, description: String, invite_link: String, pinned_message: Message, permissions: ChatPermissions, slow_mode_delay: Integer, unrestrict_boost_count: Integer, message_auto_delete_time: Integer, has_aggressive_anti_spam_enabled: Boolean, has_hidden_members: Boolean, has_protected_content: Boolean, has_visible_history: Boolean, sticker_set_name: String, can_set_sticker_set: Boolean, custom_emoji_sticker_set_name: String, linked_chat_id: Integer, location: ChatLocation)

<p>This object contains full information about a chat.</p>

| name | type | required | description |
|---|---|---|---|
| id | Integer | true | Unique identifier for this chat. This number may have more than 32 significant bits and some programming languages may have difficulty/silent defects in interpreting it. But it has at most 52 significant bits, so a signed 64-bit integer or double-precision float type are safe for storing this identifier. |
| type | String | true | Type of the chat, can be either “private”, “group”, “supergroup” or “channel” |
| title | String | false | <em>Optional</em>. Title, for supergroups, channels and group chats |
| username | String | false | <em>Optional</em>. Username, for private chats, supergroups and channels if available |
| first_name | String | false | <em>Optional</em>. First name of the other party in a private chat |
| last_name | String | false | <em>Optional</em>. Last name of the other party in a private chat |
| is_forum | Boolean | false | <em>Optional</em>. <em>True</em>, if the supergroup chat is a forum (has <a href="https://telegram.org/blog/topics-in-groups-collectible-usernames#topics-in-groups">topics</a> enabled) |
| accent_color_id | Integer | true | Identifier of the accent color for the chat name and backgrounds of the chat photo, reply header, and link preview. See <a href="#accent-colors">accent colors</a> for more details. |
| max_reaction_count | Integer | true | The maximum number of reactions that can be set on a message in the chat |
| photo | ChatPhoto | false | <em>Optional</em>. Chat photo |
| active_usernames | List<String> | false | <em>Optional</em>. If non-empty, the list of all <a href="https://telegram.org/blog/topics-in-groups-collectible-usernames#collectible-usernames">active chat usernames</a>; for private chats, supergroups and channels |
| birthdate | Birthdate | false | <em>Optional</em>. For private chats, the date of birth of the user |
| business_intro | BusinessIntro | false | <em>Optional</em>. For private chats with business accounts, the intro of the business |
| business_location | BusinessLocation | false | <em>Optional</em>. For private chats with business accounts, the location of the business |
| business_opening_hours | BusinessOpeningHours | false | <em>Optional</em>. For private chats with business accounts, the opening hours of the business |
| personal_chat | Chat | false | <em>Optional</em>. For private chats, the personal channel of the user |
| available_reactions | List<ReactionType> | false | <em>Optional</em>. List of available reactions allowed in the chat. If omitted, then all <a href="#reactiontypeemoji">emoji reactions</a> are allowed. |
| background_custom_emoji_id | String | false | <em>Optional</em>. Custom emoji identifier of the emoji chosen by the chat for the reply header and link preview background |
| profile_accent_color_id | Integer | false | <em>Optional</em>. Identifier of the accent color for the chat's profile background. See <a href="#profile-accent-colors">profile accent colors</a> for more details. |
| profile_background_custom_emoji_id | String | false | <em>Optional</em>. Custom emoji identifier of the emoji chosen by the chat for its profile background |
| emoji_status_custom_emoji_id | String | false | <em>Optional</em>. Custom emoji identifier of the emoji status of the chat or the other party in a private chat |
| emoji_status_expiration_date | Integer | false | <em>Optional</em>. Expiration date of the emoji status of the chat or the other party in a private chat, in Unix time, if any |
| bio | String | false | <em>Optional</em>. Bio of the other party in a private chat |
| has_private_forwards | Boolean | false | <em>Optional</em>. <em>True</em>, if privacy settings of the other party in the private chat allows to use <code>tg://user?id=&lt;user_id&gt;</code> links only in chats with the user |
| has_restricted_voice_and_video_messages | Boolean | false | <em>Optional</em>. <em>True</em>, if the privacy settings of the other party restrict sending voice and video note messages in the private chat |
| join_to_send_messages | Boolean | false | <em>Optional</em>. <em>True</em>, if users need to join the supergroup before they can send messages |
| join_by_request | Boolean | false | <em>Optional</em>. <em>True</em>, if all users directly joining the supergroup without using an invite link need to be approved by supergroup administrators |
| description | String | false | <em>Optional</em>. Description, for groups, supergroups and channel chats |
| invite_link | String | false | <em>Optional</em>. Primary invite link, for groups, supergroups and channel chats |
| pinned_message | Message | false | <em>Optional</em>. The most recent pinned message (by sending date) |
| permissions | ChatPermissions | false | <em>Optional</em>. Default chat member permissions, for groups and supergroups |
| slow_mode_delay | Integer | false | <em>Optional</em>. For supergroups, the minimum allowed delay between consecutive messages sent by each unprivileged user; in seconds |
| unrestrict_boost_count | Integer | false | <em>Optional</em>. For supergroups, the minimum number of boosts that a non-administrator user needs to add in order to ignore slow mode and chat permissions |
| message_auto_delete_time | Integer | false | <em>Optional</em>. The time after which all messages sent to the chat will be automatically deleted; in seconds |
| has_aggressive_anti_spam_enabled | Boolean | false | <em>Optional</em>. <em>True</em>, if aggressive anti-spam checks are enabled in the supergroup. The field is only available to chat administrators. |
| has_hidden_members | Boolean | false | <em>Optional</em>. <em>True</em>, if non-administrators can only get the list of bots and administrators in the chat |
| has_protected_content | Boolean | false | <em>Optional</em>. <em>True</em>, if messages from the chat can't be forwarded to other chats |
| has_visible_history | Boolean | false | <em>Optional</em>. <em>True</em>, if new chat members will have access to old messages; available only to chat administrators |
| sticker_set_name | String | false | <em>Optional</em>. For supergroups, name of the group sticker set |
| can_set_sticker_set | Boolean | false | <em>Optional</em>. <em>True</em>, if the bot can change the group sticker set |
| custom_emoji_sticker_set_name | String | false | <em>Optional</em>. For supergroups, the name of the group's custom emoji sticker set. Custom emoji from this set can be used by all users and bots in the group. |
| linked_chat_id | Integer | false | <em>Optional</em>. Unique identifier for the linked chat, i.e. the discussion group identifier for a channel and vice versa; for supergroups and channel chats. This identifier may be greater than 32 bits and some programming languages may have difficulty/silent defects in interpreting it. But it is smaller than 52 bits, so a signed 64 bit integer or double-precision float type are safe for storing this identifier. |
| location | ChatLocation | false | <em>Optional</em>. For supergroups, the location to which the supergroup is connected |

#### Message

    Message(message_id: Integer, message_thread_id: Integer, from: User, sender_chat: Chat, sender_boost_count: Integer, sender_business_bot: User, date: Integer, business_connection_id: String, chat: Chat, forward_origin: MessageOrigin, is_topic_message: Boolean, is_automatic_forward: Boolean, reply_to_message: Message, external_reply: ExternalReplyInfo, quote: TextQuote, reply_to_story: Story, via_bot: User, edit_date: Integer, has_protected_content: Boolean, is_from_offline: Boolean, media_group_id: String, author_signature: String, text: String, entities: List<MessageEntity>, link_preview_options: LinkPreviewOptions, effect_id: String, animation: Animation, audio: Audio, document: Document, photo: List<PhotoSize>, sticker: Sticker, story: Story, video: Video, video_note: VideoNote, voice: Voice, caption: String, caption_entities: List<MessageEntity>, show_caption_above_media: Boolean, has_media_spoiler: Boolean, contact: Contact, dice: Dice, game: Game, poll: Poll, venue: Venue, location: Location, new_chat_members: List<User>, left_chat_member: User, new_chat_title: String, new_chat_photo: List<PhotoSize>, delete_chat_photo: Boolean, group_chat_created: Boolean, supergroup_chat_created: Boolean, channel_chat_created: Boolean, message_auto_delete_timer_changed: MessageAutoDeleteTimerChanged, migrate_to_chat_id: Integer, migrate_from_chat_id: Integer, pinned_message: MaybeInaccessibleMessage, invoice: Invoice, successful_payment: SuccessfulPayment, users_shared: UsersShared, chat_shared: ChatShared, connected_website: String, write_access_allowed: WriteAccessAllowed, passport_data: PassportData, proximity_alert_triggered: ProximityAlertTriggered, boost_added: ChatBoostAdded, chat_background_set: ChatBackground, forum_topic_created: ForumTopicCreated, forum_topic_edited: ForumTopicEdited, forum_topic_closed: ForumTopicClosed, forum_topic_reopened: ForumTopicReopened, general_forum_topic_hidden: GeneralForumTopicHidden, general_forum_topic_unhidden: GeneralForumTopicUnhidden, giveaway_created: GiveawayCreated, giveaway: Giveaway, giveaway_winners: GiveawayWinners, giveaway_completed: GiveawayCompleted, video_chat_scheduled: VideoChatScheduled, video_chat_started: VideoChatStarted, video_chat_ended: VideoChatEnded, video_chat_participants_invited: VideoChatParticipantsInvited, web_app_data: WebAppData, reply_markup: InlineKeyboardMarkup)

<p>This object represents a message.</p>

| name | type | required | description |
|---|---|---|---|
| message_id | Integer | true | Unique message identifier inside this chat |
| message_thread_id | Integer | false | <em>Optional</em>. Unique identifier of a message thread to which the message belongs; for supergroups only |
| from | User | false | <em>Optional</em>. Sender of the message; empty for messages sent to channels. For backward compatibility, the field contains a fake sender user in non-channel chats, if the message was sent on behalf of a chat. |
| sender_chat | Chat | false | <em>Optional</em>. Sender of the message, sent on behalf of a chat. For example, the channel itself for channel posts, the supergroup itself for messages from anonymous group administrators, the linked channel for messages automatically forwarded to the discussion group. For backward compatibility, the field <em>from</em> contains a fake sender user in non-channel chats, if the message was sent on behalf of a chat. |
| sender_boost_count | Integer | false | <em>Optional</em>. If the sender of the message boosted the chat, the number of boosts added by the user |
| sender_business_bot | User | false | <em>Optional</em>. The bot that actually sent the message on behalf of the business account. Available only for outgoing messages sent on behalf of the connected business account. |
| date | Integer | true | Date the message was sent in Unix time. It is always a positive number, representing a valid date. |
| business_connection_id | String | false | <em>Optional</em>. Unique identifier of the business connection from which the message was received. If non-empty, the message belongs to a chat of the corresponding business account that is independent from any potential bot chat which might share the same identifier. |
| chat | Chat | true | Chat the message belongs to |
| forward_origin | MessageOrigin | false | <em>Optional</em>. Information about the original message for forwarded messages |
| is_topic_message | Boolean | false | <em>Optional</em>. <em>True</em>, if the message is sent to a forum topic |
| is_automatic_forward | Boolean | false | <em>Optional</em>. <em>True</em>, if the message is a channel post that was automatically forwarded to the connected discussion group |
| reply_to_message | Message | false | <em>Optional</em>. For replies in the same chat and message thread, the original message. Note that the Message object in this field will not contain further <em>reply_to_message</em> fields even if it itself is a reply. |
| external_reply | ExternalReplyInfo | false | <em>Optional</em>. Information about the message that is being replied to, which may come from another chat or forum topic |
| quote | TextQuote | false | <em>Optional</em>. For replies that quote part of the original message, the quoted part of the message |
| reply_to_story | Story | false | <em>Optional</em>. For replies to a story, the original story |
| via_bot | User | false | <em>Optional</em>. Bot through which the message was sent |
| edit_date | Integer | false | <em>Optional</em>. Date the message was last edited in Unix time |
| has_protected_content | Boolean | false | <em>Optional</em>. <em>True</em>, if the message can't be forwarded |
| is_from_offline | Boolean | false | <em>Optional</em>. True, if the message was sent by an implicit action, for example, as an away or a greeting business message, or as a scheduled message |
| media_group_id | String | false | <em>Optional</em>. The unique identifier of a media message group this message belongs to |
| author_signature | String | false | <em>Optional</em>. Signature of the post author for messages in channels, or the custom title of an anonymous group administrator |
| text | String | false | <em>Optional</em>. For text messages, the actual UTF-8 text of the message |
| entities | List<MessageEntity> | false | <em>Optional</em>. For text messages, special entities like usernames, URLs, bot commands, etc. that appear in the text |
| link_preview_options | LinkPreviewOptions | false | <em>Optional</em>. Options used for link preview generation for the message, if it is a text message and link preview options were changed |
| effect_id | String | false | <em>Optional</em>. Unique identifier of the message effect added to the message |
| animation | Animation | false | <em>Optional</em>. Message is an animation, information about the animation. For backward compatibility, when this field is set, the <em>document</em> field will also be set |
| audio | Audio | false | <em>Optional</em>. Message is an audio file, information about the file |
| document | Document | false | <em>Optional</em>. Message is a general file, information about the file |
| photo | List<PhotoSize> | false | <em>Optional</em>. Message is a photo, available sizes of the photo |
| sticker | Sticker | false | <em>Optional</em>. Message is a sticker, information about the sticker |
| story | Story | false | <em>Optional</em>. Message is a forwarded story |
| video | Video | false | <em>Optional</em>. Message is a video, information about the video |
| video_note | VideoNote | false | <em>Optional</em>. Message is a <a href="https://telegram.org/blog/video-messages-and-telescope">video note</a>, information about the video message |
| voice | Voice | false | <em>Optional</em>. Message is a voice message, information about the file |
| caption | String | false | <em>Optional</em>. Caption for the animation, audio, document, photo, video or voice |
| caption_entities | List<MessageEntity> | false | <em>Optional</em>. For messages with a caption, special entities like usernames, URLs, bot commands, etc. that appear in the caption |
| show_caption_above_media | Boolean | false | <em>Optional</em>. True, if the caption must be shown above the message media |
| has_media_spoiler | Boolean | false | <em>Optional</em>. <em>True</em>, if the message media is covered by a spoiler animation |
| contact | Contact | false | <em>Optional</em>. Message is a shared contact, information about the contact |
| dice | Dice | false | <em>Optional</em>. Message is a dice with random value |
| game | Game | false | <em>Optional</em>. Message is a game, information about the game. <a href="#games">More about games »</a> |
| poll | Poll | false | <em>Optional</em>. Message is a native poll, information about the poll |
| venue | Venue | false | <em>Optional</em>. Message is a venue, information about the venue. For backward compatibility, when this field is set, the <em>location</em> field will also be set |
| location | Location | false | <em>Optional</em>. Message is a shared location, information about the location |
| new_chat_members | List<User> | false | <em>Optional</em>. New members that were added to the group or supergroup and information about them (the bot itself may be one of these members) |
| left_chat_member | User | false | <em>Optional</em>. A member was removed from the group, information about them (this member may be the bot itself) |
| new_chat_title | String | false | <em>Optional</em>. A chat title was changed to this value |
| new_chat_photo | List<PhotoSize> | false | <em>Optional</em>. A chat photo was change to this value |
| delete_chat_photo | Boolean | false | <em>Optional</em>. Service message: the chat photo was deleted |
| group_chat_created | Boolean | false | <em>Optional</em>. Service message: the group has been created |
| supergroup_chat_created | Boolean | false | <em>Optional</em>. Service message: the supergroup has been created. This field can't be received in a message coming through updates, because bot can't be a member of a supergroup when it is created. It can only be found in reply_to_message if someone replies to a very first message in a directly created supergroup. |
| channel_chat_created | Boolean | false | <em>Optional</em>. Service message: the channel has been created. This field can't be received in a message coming through updates, because bot can't be a member of a channel when it is created. It can only be found in reply_to_message if someone replies to a very first message in a channel. |
| message_auto_delete_timer_changed | MessageAutoDeleteTimerChanged | false | <em>Optional</em>. Service message: auto-delete timer settings changed in the chat |
| migrate_to_chat_id | Integer | false | <em>Optional</em>. The group has been migrated to a supergroup with the specified identifier. This number may have more than 32 significant bits and some programming languages may have difficulty/silent defects in interpreting it. But it has at most 52 significant bits, so a signed 64-bit integer or double-precision float type are safe for storing this identifier. |
| migrate_from_chat_id | Integer | false | <em>Optional</em>. The supergroup has been migrated from a group with the specified identifier. This number may have more than 32 significant bits and some programming languages may have difficulty/silent defects in interpreting it. But it has at most 52 significant bits, so a signed 64-bit integer or double-precision float type are safe for storing this identifier. |
| pinned_message | MaybeInaccessibleMessage | false | <em>Optional</em>. Specified message was pinned. Note that the Message object in this field will not contain further <em>reply_to_message</em> fields even if it itself is a reply. |
| invoice | Invoice | false | <em>Optional</em>. Message is an invoice for a <a href="#payments">payment</a>, information about the invoice. <a href="#payments">More about payments »</a> |
| successful_payment | SuccessfulPayment | false | <em>Optional</em>. Message is a service message about a successful payment, information about the payment. <a href="#payments">More about payments »</a> |
| users_shared | UsersShared | false | <em>Optional</em>. Service message: users were shared with the bot |
| chat_shared | ChatShared | false | <em>Optional</em>. Service message: a chat was shared with the bot |
| connected_website | String | false | <em>Optional</em>. The domain name of the website on which the user has logged in. <a href="/widgets/login">More about Telegram Login »</a> |
| write_access_allowed | WriteAccessAllowed | false | <em>Optional</em>. Service message: the user allowed the bot to write messages after adding it to the attachment or side menu, launching a Web App from a link, or accepting an explicit request from a Web App sent by the method <a href="/bots/webapps#initializing-mini-apps">requestWriteAccess</a> |
| passport_data | PassportData | false | <em>Optional</em>. Telegram Passport data |
| proximity_alert_triggered | ProximityAlertTriggered | false | <em>Optional</em>. Service message. A user in the chat triggered another user's proximity alert while sharing Live Location. |
| boost_added | ChatBoostAdded | false | <em>Optional</em>. Service message: user boosted the chat |
| chat_background_set | ChatBackground | false | <em>Optional</em>. Service message: chat background set |
| forum_topic_created | ForumTopicCreated | false | <em>Optional</em>. Service message: forum topic created |
| forum_topic_edited | ForumTopicEdited | false | <em>Optional</em>. Service message: forum topic edited |
| forum_topic_closed | ForumTopicClosed | false | <em>Optional</em>. Service message: forum topic closed |
| forum_topic_reopened | ForumTopicReopened | false | <em>Optional</em>. Service message: forum topic reopened |
| general_forum_topic_hidden | GeneralForumTopicHidden | false | <em>Optional</em>. Service message: the 'General' forum topic hidden |
| general_forum_topic_unhidden | GeneralForumTopicUnhidden | false | <em>Optional</em>. Service message: the 'General' forum topic unhidden |
| giveaway_created | GiveawayCreated | false | <em>Optional</em>. Service message: a scheduled giveaway was created |
| giveaway | Giveaway | false | <em>Optional</em>. The message is a scheduled giveaway message |
| giveaway_winners | GiveawayWinners | false | <em>Optional</em>. A giveaway with public winners was completed |
| giveaway_completed | GiveawayCompleted | false | <em>Optional</em>. Service message: a giveaway without public winners was completed |
| video_chat_scheduled | VideoChatScheduled | false | <em>Optional</em>. Service message: video chat scheduled |
| video_chat_started | VideoChatStarted | false | <em>Optional</em>. Service message: video chat started |
| video_chat_ended | VideoChatEnded | false | <em>Optional</em>. Service message: video chat ended |
| video_chat_participants_invited | VideoChatParticipantsInvited | false | <em>Optional</em>. Service message: new participants invited to a video chat |
| web_app_data | WebAppData | false | <em>Optional</em>. Service message: data sent by a Web App |
| reply_markup | InlineKeyboardMarkup | false | <em>Optional</em>. Inline keyboard attached to the message. <code>login_url</code> buttons are represented as ordinary <code>url</code> buttons. |

#### MessageId

    MessageId(message_id: Integer)

<p>This object represents a unique message identifier.</p>

| name | type | required | description |
|---|---|---|---|
| message_id | Integer | true | Unique message identifier |

#### InaccessibleMessage

    InaccessibleMessage(chat: Chat, message_id: Integer, date: Integer)

<p>This object describes a message that was deleted or is otherwise inaccessible to the bot.</p>

| name | type | required | description |
|---|---|---|---|
| chat | Chat | true | Chat the message belonged to |
| message_id | Integer | true | Unique message identifier inside the chat |
| date | Integer | true | Always 0. The field can be used to differentiate regular and inaccessible messages. |

#### MessageEntity

    MessageEntity(type: String, offset: Integer, length: Integer, url: String, user: User, language: String, custom_emoji_id: String)

<p>This object represents one special entity in a text message. For example, hashtags, usernames, URLs, etc.</p>

| name | type | required | description |
|---|---|---|---|
| type | String | true | Type of the entity. Currently, can be “mention” (<code>@username</code>), “hashtag” (<code>#hashtag</code>), “cashtag” (<code>$USD</code>), “bot_command” (<code>/start@jobs_bot</code>), “url” (<code>https://telegram.org</code>), “email” (<code>do-not-reply@telegram.org</code>), “phone_number” (<code>+1-212-555-0123</code>), “bold” (<strong>bold text</strong>), “italic” (<em>italic text</em>), “underline” (underlined text), “strikethrough” (strikethrough text), “spoiler” (spoiler message), “blockquote” (block quotation), “expandable_blockquote” (collapsed-by-default block quotation), “code” (monowidth string), “pre” (monowidth block), “text_link” (for clickable text URLs), “text_mention” (for users <a href="https://telegram.org/blog/edit#new-mentions">without usernames</a>), “custom_emoji” (for inline custom emoji stickers) |
| offset | Integer | true | Offset in <a href="/api/entities#entity-length">UTF-16 code units</a> to the start of the entity |
| length | Integer | true | Length of the entity in <a href="/api/entities#entity-length">UTF-16 code units</a> |
| url | String | false | <em>Optional</em>. For “text_link” only, URL that will be opened after user taps on the text |
| user | User | false | <em>Optional</em>. For “text_mention” only, the mentioned user |
| language | String | false | <em>Optional</em>. For “pre” only, the programming language of the entity text |
| custom_emoji_id | String | false | <em>Optional</em>. For “custom_emoji” only, unique identifier of the custom emoji. Use <a href="#getcustomemojistickers">getCustomEmojiStickers</a> to get full information about the sticker |

#### TextQuote

    TextQuote(text: String, entities: List<MessageEntity>, position: Integer, is_manual: Boolean)

<p>This object contains information about the quoted part of a message that is replied to by the given message.</p>

| name | type | required | description |
|---|---|---|---|
| text | String | true | Text of the quoted part of a message that is replied to by the given message |
| entities | List<MessageEntity> | false | <em>Optional</em>. Special entities that appear in the quote. Currently, only <em>bold</em>, <em>italic</em>, <em>underline</em>, <em>strikethrough</em>, <em>spoiler</em>, and <em>custom_emoji</em> entities are kept in quotes. |
| position | Integer | true | Approximate quote position in the original message in UTF-16 code units as specified by the sender |
| is_manual | Boolean | false | <em>Optional</em>. True, if the quote was chosen manually by the message sender. Otherwise, the quote was added automatically by the server. |

#### ExternalReplyInfo

    ExternalReplyInfo(origin: MessageOrigin, chat: Chat, message_id: Integer, link_preview_options: LinkPreviewOptions, animation: Animation, audio: Audio, document: Document, photo: List<PhotoSize>, sticker: Sticker, story: Story, video: Video, video_note: VideoNote, voice: Voice, has_media_spoiler: Boolean, contact: Contact, dice: Dice, game: Game, giveaway: Giveaway, giveaway_winners: GiveawayWinners, invoice: Invoice, location: Location, poll: Poll, venue: Venue)

<p>This object contains information about a message that is being replied to, which may come from another chat or forum topic.</p>

| name | type | required | description |
|---|---|---|---|
| origin | MessageOrigin | true | Origin of the message replied to by the given message |
| chat | Chat | false | <em>Optional</em>. Chat the original message belongs to. Available only if the chat is a supergroup or a channel. |
| message_id | Integer | false | <em>Optional</em>. Unique message identifier inside the original chat. Available only if the original chat is a supergroup or a channel. |
| link_preview_options | LinkPreviewOptions | false | <em>Optional</em>. Options used for link preview generation for the original message, if it is a text message |
| animation | Animation | false | <em>Optional</em>. Message is an animation, information about the animation |
| audio | Audio | false | <em>Optional</em>. Message is an audio file, information about the file |
| document | Document | false | <em>Optional</em>. Message is a general file, information about the file |
| photo | List<PhotoSize> | false | <em>Optional</em>. Message is a photo, available sizes of the photo |
| sticker | Sticker | false | <em>Optional</em>. Message is a sticker, information about the sticker |
| story | Story | false | <em>Optional</em>. Message is a forwarded story |
| video | Video | false | <em>Optional</em>. Message is a video, information about the video |
| video_note | VideoNote | false | <em>Optional</em>. Message is a <a href="https://telegram.org/blog/video-messages-and-telescope">video note</a>, information about the video message |
| voice | Voice | false | <em>Optional</em>. Message is a voice message, information about the file |
| has_media_spoiler | Boolean | false | <em>Optional</em>. <em>True</em>, if the message media is covered by a spoiler animation |
| contact | Contact | false | <em>Optional</em>. Message is a shared contact, information about the contact |
| dice | Dice | false | <em>Optional</em>. Message is a dice with random value |
| game | Game | false | <em>Optional</em>. Message is a game, information about the game. <a href="#games">More about games »</a> |
| giveaway | Giveaway | false | <em>Optional</em>. Message is a scheduled giveaway, information about the giveaway |
| giveaway_winners | GiveawayWinners | false | <em>Optional</em>. A giveaway with public winners was completed |
| invoice | Invoice | false | <em>Optional</em>. Message is an invoice for a <a href="#payments">payment</a>, information about the invoice. <a href="#payments">More about payments »</a> |
| location | Location | false | <em>Optional</em>. Message is a shared location, information about the location |
| poll | Poll | false | <em>Optional</em>. Message is a native poll, information about the poll |
| venue | Venue | false | <em>Optional</em>. Message is a venue, information about the venue |

#### ReplyParameters

    ReplyParameters(message_id: Integer, chat_id: IntegerOrString, allow_sending_without_reply: Boolean, quote: String, quote_parse_mode: String, quote_entities: List<MessageEntity>, quote_position: Integer)

<p>Describes reply parameters for the message that is being sent.</p>

| name | type | required | description |
|---|---|---|---|
| message_id | Integer | true | Identifier of the message that will be replied to in the current chat, or in the chat <em>chat_id</em> if it is specified |
| chat_id | IntegerOrString | false | <em>Optional</em>. If the message to be replied to is from a different chat, unique identifier for the chat or username of the channel (in the format <code>@channelusername</code>). Not supported for messages sent on behalf of a business account. |
| allow_sending_without_reply | Boolean | false | <em>Optional</em>. Pass <em>True</em> if the message should be sent even if the specified message to be replied to is not found. Always <em>False</em> for replies in another chat or forum topic. Always <em>True</em> for messages sent on behalf of a business account. |
| quote | String | false | <em>Optional</em>. Quoted part of the message to be replied to; 0-1024 characters after entities parsing. The quote must be an exact substring of the message to be replied to, including <em>bold</em>, <em>italic</em>, <em>underline</em>, <em>strikethrough</em>, <em>spoiler</em>, and <em>custom_emoji</em> entities. The message will fail to send if the quote isn't found in the original message. |
| quote_parse_mode | String | false | <em>Optional</em>. Mode for parsing entities in the quote. See <a href="#formatting-options">formatting options</a> for more details. |
| quote_entities | List<MessageEntity> | false | <em>Optional</em>. A JSON-serialized list of special entities that appear in the quote. It can be specified instead of <em>quote_parse_mode</em>. |
| quote_position | Integer | false | <em>Optional</em>. Position of the quote in the original message in UTF-16 code units |

#### MessageOriginUser

    MessageOriginUser(type: String, date: Integer, sender_user: User)

<p>The message was originally sent by a known user.</p>

| name | type | required | description |
|---|---|---|---|
| type | String | true | Type of the message origin, always “user” |
| date | Integer | true | Date the message was sent originally in Unix time |
| sender_user | User | true | User that sent the message originally |

#### MessageOriginHiddenUser

    MessageOriginHiddenUser(type: String, date: Integer, sender_user_name: String)

<p>The message was originally sent by an unknown user.</p>

| name | type | required | description |
|---|---|---|---|
| type | String | true | Type of the message origin, always “hidden_user” |
| date | Integer | true | Date the message was sent originally in Unix time |
| sender_user_name | String | true | Name of the user that sent the message originally |

#### MessageOriginChat

    MessageOriginChat(type: String, date: Integer, sender_chat: Chat, author_signature: String)

<p>The message was originally sent on behalf of a chat to a group chat.</p>

| name | type | required | description |
|---|---|---|---|
| type | String | true | Type of the message origin, always “chat” |
| date | Integer | true | Date the message was sent originally in Unix time |
| sender_chat | Chat | true | Chat that sent the message originally |
| author_signature | String | false | <em>Optional</em>. For messages originally sent by an anonymous chat administrator, original message author signature |

#### MessageOriginChannel

    MessageOriginChannel(type: String, date: Integer, chat: Chat, message_id: Integer, author_signature: String)

<p>The message was originally sent to a channel chat.</p>

| name | type | required | description |
|---|---|---|---|
| type | String | true | Type of the message origin, always “channel” |
| date | Integer | true | Date the message was sent originally in Unix time |
| chat | Chat | true | Channel chat to which the message was originally sent |
| message_id | Integer | true | Unique message identifier inside the chat |
| author_signature | String | false | <em>Optional</em>. Signature of the original post author |

#### PhotoSize

    PhotoSize(file_id: String, file_unique_id: String, width: Integer, height: Integer, file_size: Integer)

<p>This object represents one size of a photo or a <a href="#document">file</a> / <a href="#sticker">sticker</a> thumbnail.</p>

| name | type | required | description |
|---|---|---|---|
| file_id | String | true | Identifier for this file, which can be used to download or reuse the file |
| file_unique_id | String | true | Unique identifier for this file, which is supposed to be the same over time and for different bots. Can't be used to download or reuse the file. |
| width | Integer | true | Photo width |
| height | Integer | true | Photo height |
| file_size | Integer | false | <em>Optional</em>. File size in bytes |

#### Animation

    Animation(file_id: String, file_unique_id: String, width: Integer, height: Integer, duration: Integer, thumbnail: PhotoSize, file_name: String, mime_type: String, file_size: Integer)

<p>This object represents an animation file (GIF or H.264/MPEG-4 AVC video without sound).</p>

| name | type | required | description |
|---|---|---|---|
| file_id | String | true | Identifier for this file, which can be used to download or reuse the file |
| file_unique_id | String | true | Unique identifier for this file, which is supposed to be the same over time and for different bots. Can't be used to download or reuse the file. |
| width | Integer | true | Video width as defined by sender |
| height | Integer | true | Video height as defined by sender |
| duration | Integer | true | Duration of the video in seconds as defined by sender |
| thumbnail | PhotoSize | false | <em>Optional</em>. Animation thumbnail as defined by sender |
| file_name | String | false | <em>Optional</em>. Original animation filename as defined by sender |
| mime_type | String | false | <em>Optional</em>. MIME type of the file as defined by sender |
| file_size | Integer | false | <em>Optional</em>. File size in bytes. It can be bigger than 2^31 and some programming languages may have difficulty/silent defects in interpreting it. But it has at most 52 significant bits, so a signed 64-bit integer or double-precision float type are safe for storing this value. |

#### Audio

    Audio(file_id: String, file_unique_id: String, duration: Integer, performer: String, title: String, file_name: String, mime_type: String, file_size: Integer, thumbnail: PhotoSize)

<p>This object represents an audio file to be treated as music by the Telegram clients.</p>

| name | type | required | description |
|---|---|---|---|
| file_id | String | true | Identifier for this file, which can be used to download or reuse the file |
| file_unique_id | String | true | Unique identifier for this file, which is supposed to be the same over time and for different bots. Can't be used to download or reuse the file. |
| duration | Integer | true | Duration of the audio in seconds as defined by sender |
| performer | String | false | <em>Optional</em>. Performer of the audio as defined by sender or by audio tags |
| title | String | false | <em>Optional</em>. Title of the audio as defined by sender or by audio tags |
| file_name | String | false | <em>Optional</em>. Original filename as defined by sender |
| mime_type | String | false | <em>Optional</em>. MIME type of the file as defined by sender |
| file_size | Integer | false | <em>Optional</em>. File size in bytes. It can be bigger than 2^31 and some programming languages may have difficulty/silent defects in interpreting it. But it has at most 52 significant bits, so a signed 64-bit integer or double-precision float type are safe for storing this value. |
| thumbnail | PhotoSize | false | <em>Optional</em>. Thumbnail of the album cover to which the music file belongs |

#### Document

    Document(file_id: String, file_unique_id: String, thumbnail: PhotoSize, file_name: String, mime_type: String, file_size: Integer)

<p>This object represents a general file (as opposed to <a href="#photosize">photos</a>, <a href="#voice">voice messages</a> and <a href="#audio">audio files</a>).</p>

| name | type | required | description |
|---|---|---|---|
| file_id | String | true | Identifier for this file, which can be used to download or reuse the file |
| file_unique_id | String | true | Unique identifier for this file, which is supposed to be the same over time and for different bots. Can't be used to download or reuse the file. |
| thumbnail | PhotoSize | false | <em>Optional</em>. Document thumbnail as defined by sender |
| file_name | String | false | <em>Optional</em>. Original filename as defined by sender |
| mime_type | String | false | <em>Optional</em>. MIME type of the file as defined by sender |
| file_size | Integer | false | <em>Optional</em>. File size in bytes. It can be bigger than 2^31 and some programming languages may have difficulty/silent defects in interpreting it. But it has at most 52 significant bits, so a signed 64-bit integer or double-precision float type are safe for storing this value. |

#### Story

    Story(chat: Chat, id: Integer)

<p>This object represents a story.</p>

| name | type | required | description |
|---|---|---|---|
| chat | Chat | true | Chat that posted the story |
| id | Integer | true | Unique identifier for the story in the chat |

#### Video

    Video(file_id: String, file_unique_id: String, width: Integer, height: Integer, duration: Integer, thumbnail: PhotoSize, file_name: String, mime_type: String, file_size: Integer)

<p>This object represents a video file.</p>

| name | type | required | description |
|---|---|---|---|
| file_id | String | true | Identifier for this file, which can be used to download or reuse the file |
| file_unique_id | String | true | Unique identifier for this file, which is supposed to be the same over time and for different bots. Can't be used to download or reuse the file. |
| width | Integer | true | Video width as defined by sender |
| height | Integer | true | Video height as defined by sender |
| duration | Integer | true | Duration of the video in seconds as defined by sender |
| thumbnail | PhotoSize | false | <em>Optional</em>. Video thumbnail |
| file_name | String | false | <em>Optional</em>. Original filename as defined by sender |
| mime_type | String | false | <em>Optional</em>. MIME type of the file as defined by sender |
| file_size | Integer | false | <em>Optional</em>. File size in bytes. It can be bigger than 2^31 and some programming languages may have difficulty/silent defects in interpreting it. But it has at most 52 significant bits, so a signed 64-bit integer or double-precision float type are safe for storing this value. |

#### VideoNote

    VideoNote(file_id: String, file_unique_id: String, length: Integer, duration: Integer, thumbnail: PhotoSize, file_size: Integer)

<p>This object represents a <a href="https://telegram.org/blog/video-messages-and-telescope">video message</a> (available in Telegram apps as of <a href="https://telegram.org/blog/video-messages-and-telescope">v.4.0</a>).</p>

| name | type | required | description |
|---|---|---|---|
| file_id | String | true | Identifier for this file, which can be used to download or reuse the file |
| file_unique_id | String | true | Unique identifier for this file, which is supposed to be the same over time and for different bots. Can't be used to download or reuse the file. |
| length | Integer | true | Video width and height (diameter of the video message) as defined by sender |
| duration | Integer | true | Duration of the video in seconds as defined by sender |
| thumbnail | PhotoSize | false | <em>Optional</em>. Video thumbnail |
| file_size | Integer | false | <em>Optional</em>. File size in bytes |

#### Voice

    Voice(file_id: String, file_unique_id: String, duration: Integer, mime_type: String, file_size: Integer)

<p>This object represents a voice note.</p>

| name | type | required | description |
|---|---|---|---|
| file_id | String | true | Identifier for this file, which can be used to download or reuse the file |
| file_unique_id | String | true | Unique identifier for this file, which is supposed to be the same over time and for different bots. Can't be used to download or reuse the file. |
| duration | Integer | true | Duration of the audio in seconds as defined by sender |
| mime_type | String | false | <em>Optional</em>. MIME type of the file as defined by sender |
| file_size | Integer | false | <em>Optional</em>. File size in bytes. It can be bigger than 2^31 and some programming languages may have difficulty/silent defects in interpreting it. But it has at most 52 significant bits, so a signed 64-bit integer or double-precision float type are safe for storing this value. |

#### Contact

    Contact(phone_number: String, first_name: String, last_name: String, user_id: Integer, vcard: String)

<p>This object represents a phone contact.</p>

| name | type | required | description |
|---|---|---|---|
| phone_number | String | true | Contact's phone number |
| first_name | String | true | Contact's first name |
| last_name | String | false | <em>Optional</em>. Contact's last name |
| user_id | Integer | false | <em>Optional</em>. Contact's user identifier in Telegram. This number may have more than 32 significant bits and some programming languages may have difficulty/silent defects in interpreting it. But it has at most 52 significant bits, so a 64-bit integer or double-precision float type are safe for storing this identifier. |
| vcard | String | false | <em>Optional</em>. Additional data about the contact in the form of a <a href="https://en.wikipedia.org/wiki/VCard">vCard</a> |

#### Dice

    Dice(emoji: String, value: Integer)

<p>This object represents an animated emoji that displays a random value.</p>

| name | type | required | description |
|---|---|---|---|
| emoji | String | true | Emoji on which the dice throw animation is based |
| value | Integer | true | Value of the dice, 1-6 for “<img class="emoji" src="//telegram.org/img/emoji/40/F09F8EB2.png" width="20" height="20" alt="🎲">”, “<img class="emoji" src="//telegram.org/img/emoji/40/F09F8EAF.png" width="20" height="20" alt="🎯">” and “<img class="emoji" src="//telegram.org/img/emoji/40/F09F8EB3.png" width="20" height="20" alt="🎳">” base emoji, 1-5 for “<img class="emoji" src="//telegram.org/img/emoji/40/F09F8F80.png" width="20" height="20" alt="🏀">” and “<img class="emoji" src="//telegram.org/img/emoji/40/E29ABD.png" width="20" height="20" alt="⚽">” base emoji, 1-64 for “<img class="emoji" src="//telegram.org/img/emoji/40/F09F8EB0.png" width="20" height="20" alt="🎰">” base emoji |

#### PollOption

    PollOption(text: String, text_entities: List<MessageEntity>, voter_count: Integer)

<p>This object contains information about one answer option in a poll.</p>

| name | type | required | description |
|---|---|---|---|
| text | String | true | Option text, 1-100 characters |
| text_entities | List<MessageEntity> | false | <em>Optional</em>. Special entities that appear in the option <em>text</em>. Currently, only custom emoji entities are allowed in poll option texts |
| voter_count | Integer | true | Number of users that voted for this option |

#### InputPollOption

    InputPollOption(text: String, text_parse_mode: String, text_entities: List<MessageEntity>)

<p>This object contains information about one answer option in a poll to send.</p>

| name | type | required | description |
|---|---|---|---|
| text | String | true | Option text, 1-100 characters |
| text_parse_mode | String | false | <em>Optional</em>. Mode for parsing entities in the text. See <a href="#formatting-options">formatting options</a> for more details. Currently, only custom emoji entities are allowed |
| text_entities | List<MessageEntity> | false | <em>Optional</em>. A JSON-serialized list of special entities that appear in the poll option text. It can be specified instead of <em>text_parse_mode</em> |

#### PollAnswer

    PollAnswer(poll_id: String, voter_chat: Chat, user: User, option_ids: List<Integer>)

<p>This object represents an answer of a user in a non-anonymous poll.</p>

| name | type | required | description |
|---|---|---|---|
| poll_id | String | true | Unique poll identifier |
| voter_chat | Chat | false | <em>Optional</em>. The chat that changed the answer to the poll, if the voter is anonymous |
| user | User | false | <em>Optional</em>. The user that changed the answer to the poll, if the voter isn't anonymous |
| option_ids | List<Integer> | true | 0-based identifiers of chosen answer options. May be empty if the vote was retracted. |

#### Poll

    Poll(id: String, question: String, question_entities: List<MessageEntity>, options: List<PollOption>, total_voter_count: Integer, is_closed: Boolean, is_anonymous: Boolean, type: String, allows_multiple_answers: Boolean, correct_option_id: Integer, explanation: String, explanation_entities: List<MessageEntity>, open_period: Integer, close_date: Integer)

<p>This object contains information about a poll.</p>

| name | type | required | description |
|---|---|---|---|
| id | String | true | Unique poll identifier |
| question | String | true | Poll question, 1-300 characters |
| question_entities | List<MessageEntity> | false | <em>Optional</em>. Special entities that appear in the <em>question</em>. Currently, only custom emoji entities are allowed in poll questions |
| options | List<PollOption> | true | List of poll options |
| total_voter_count | Integer | true | Total number of users that voted in the poll |
| is_closed | Boolean | true | <em>True</em>, if the poll is closed |
| is_anonymous | Boolean | true | <em>True</em>, if the poll is anonymous |
| type | String | true | Poll type, currently can be “regular” or “quiz” |
| allows_multiple_answers | Boolean | true | <em>True</em>, if the poll allows multiple answers |
| correct_option_id | Integer | false | <em>Optional</em>. 0-based identifier of the correct answer option. Available only for polls in the quiz mode, which are closed, or was sent (not forwarded) by the bot or to the private chat with the bot. |
| explanation | String | false | <em>Optional</em>. Text that is shown when a user chooses an incorrect answer or taps on the lamp icon in a quiz-style poll, 0-200 characters |
| explanation_entities | List<MessageEntity> | false | <em>Optional</em>. Special entities like usernames, URLs, bot commands, etc. that appear in the <em>explanation</em> |
| open_period | Integer | false | <em>Optional</em>. Amount of time in seconds the poll will be active after creation |
| close_date | Integer | false | <em>Optional</em>. Point in time (Unix timestamp) when the poll will be automatically closed |

#### Location

    Location(latitude: Float, longitude: Float, horizontal_accuracy: Float, live_period: Integer, heading: Integer, proximity_alert_radius: Integer)

<p>This object represents a point on the map.</p>

| name | type | required | description |
|---|---|---|---|
| latitude | Float | true | Latitude as defined by sender |
| longitude | Float | true | Longitude as defined by sender |
| horizontal_accuracy | Float | false | <em>Optional</em>. The radius of uncertainty for the location, measured in meters; 0-1500 |
| live_period | Integer | false | <em>Optional</em>. Time relative to the message sending date, during which the location can be updated; in seconds. For active live locations only. |
| heading | Integer | false | <em>Optional</em>. The direction in which user is moving, in degrees; 1-360. For active live locations only. |
| proximity_alert_radius | Integer | false | <em>Optional</em>. The maximum distance for proximity alerts about approaching another chat member, in meters. For sent live locations only. |

#### Venue

    Venue(location: Location, title: String, address: String, foursquare_id: String, foursquare_type: String, google_place_id: String, google_place_type: String)

<p>This object represents a venue.</p>

| name | type | required | description |
|---|---|---|---|
| location | Location | true | Venue location. Can't be a live location |
| title | String | true | Name of the venue |
| address | String | true | Address of the venue |
| foursquare_id | String | false | <em>Optional</em>. Foursquare identifier of the venue |
| foursquare_type | String | false | <em>Optional</em>. Foursquare type of the venue. (For example, “arts_entertainment/default”, “arts_entertainment/aquarium” or “food/icecream”.) |
| google_place_id | String | false | <em>Optional</em>. Google Places identifier of the venue |
| google_place_type | String | false | <em>Optional</em>. Google Places type of the venue. (See <a href="https://developers.google.com/places/web-service/supported_types">supported types</a>.) |

#### WebAppData

    WebAppData(data: String, button_text: String)

<p>Describes data sent from a <a href="/bots/webapps">Web App</a> to the bot.</p>

| name | type | required | description |
|---|---|---|---|
| data | String | true | The data. Be aware that a bad client can send arbitrary data in this field. |
| button_text | String | true | Text of the <em>web_app</em> keyboard button from which the Web App was opened. Be aware that a bad client can send arbitrary data in this field. |

#### ProximityAlertTriggered

    ProximityAlertTriggered(traveler: User, watcher: User, distance: Integer)

<p>This object represents the content of a service message, sent whenever a user in the chat triggers a proximity alert set by another user.</p>

| name | type | required | description |
|---|---|---|---|
| traveler | User | true | User that triggered the alert |
| watcher | User | true | User that set the alert |
| distance | Integer | true | The distance between the users |

#### MessageAutoDeleteTimerChanged

    MessageAutoDeleteTimerChanged(message_auto_delete_time: Integer)

<p>This object represents a service message about a change in auto-delete timer settings.</p>

| name | type | required | description |
|---|---|---|---|
| message_auto_delete_time | Integer | true | New auto-delete time for messages in the chat; in seconds |

#### ChatBoostAdded

    ChatBoostAdded(boost_count: Integer)

<p>This object represents a service message about a user boosting a chat.</p>

| name | type | required | description |
|---|---|---|---|
| boost_count | Integer | true | Number of boosts added by the user |

#### BackgroundFillSolid

    BackgroundFillSolid(type: String, color: Integer)

<p>The background is filled using the selected color.</p>

| name | type | required | description |
|---|---|---|---|
| type | String | true | Type of the background fill, always “solid” |
| color | Integer | true | The color of the background fill in the RGB24 format |

#### BackgroundFillGradient

    BackgroundFillGradient(type: String, top_color: Integer, bottom_color: Integer, rotation_angle: Integer)

<p>The background is a gradient fill.</p>

| name | type | required | description |
|---|---|---|---|
| type | String | true | Type of the background fill, always “gradient” |
| top_color | Integer | true | Top color of the gradient in the RGB24 format |
| bottom_color | Integer | true | Bottom color of the gradient in the RGB24 format |
| rotation_angle | Integer | true | Clockwise rotation angle of the background fill in degrees; 0-359 |

#### BackgroundFillFreeformGradient

    BackgroundFillFreeformGradient(type: String, colors: List<Integer>)

<p>The background is a freeform gradient that rotates after every message in the chat.</p>

| name | type | required | description |
|---|---|---|---|
| type | String | true | Type of the background fill, always “freeform_gradient” |
| colors | List<Integer> | true | A list of the 3 or 4 base colors that are used to generate the freeform gradient in the RGB24 format |

#### BackgroundTypeFill

    BackgroundTypeFill(type: String, fill: BackgroundFill, dark_theme_dimming: Integer)

<p>The background is automatically filled based on the selected colors.</p>

| name | type | required | description |
|---|---|---|---|
| type | String | true | Type of the background, always “fill” |
| fill | BackgroundFill | true | The background fill |
| dark_theme_dimming | Integer | true | Dimming of the background in dark themes, as a percentage; 0-100 |

#### BackgroundTypeWallpaper

    BackgroundTypeWallpaper(type: String, document: Document, dark_theme_dimming: Integer, is_blurred: Boolean, is_moving: Boolean)

<p>The background is a wallpaper in the JPEG format.</p>

| name | type | required | description |
|---|---|---|---|
| type | String | true | Type of the background, always “wallpaper” |
| document | Document | true | Document with the wallpaper |
| dark_theme_dimming | Integer | true | Dimming of the background in dark themes, as a percentage; 0-100 |
| is_blurred | Boolean | false | <em>Optional</em>. <em>True</em>, if the wallpaper is downscaled to fit in a 450x450 square and then box-blurred with radius 12 |
| is_moving | Boolean | false | <em>Optional</em>. <em>True</em>, if the background moves slightly when the device is tilted |

#### BackgroundTypePattern

    BackgroundTypePattern(type: String, document: Document, fill: BackgroundFill, intensity: Integer, is_inverted: Boolean, is_moving: Boolean)

<p>The background is a PNG or TGV (gzipped subset of SVG with MIME type “application/x-tgwallpattern”) pattern to be combined with the background fill chosen by the user.</p>

| name | type | required | description |
|---|---|---|---|
| type | String | true | Type of the background, always “pattern” |
| document | Document | true | Document with the pattern |
| fill | BackgroundFill | true | The background fill that is combined with the pattern |
| intensity | Integer | true | Intensity of the pattern when it is shown above the filled background; 0-100 |
| is_inverted | Boolean | false | <em>Optional</em>. <em>True</em>, if the background fill must be applied only to the pattern itself. All other pixels are black in this case. For dark themes only |
| is_moving | Boolean | false | <em>Optional</em>. <em>True</em>, if the background moves slightly when the device is tilted |

#### BackgroundTypeChatTheme

    BackgroundTypeChatTheme(type: String, theme_name: String)

<p>The background is taken directly from a built-in chat theme.</p>

| name | type | required | description |
|---|---|---|---|
| type | String | true | Type of the background, always “chat_theme” |
| theme_name | String | true | Name of the chat theme, which is usually an emoji |

#### ChatBackground

    ChatBackground(type: BackgroundType)

<p>This object represents a chat background.</p>

| name | type | required | description |
|---|---|---|---|
| type | BackgroundType | true | Type of the background |

#### ForumTopicCreated

    ForumTopicCreated(name: String, icon_color: Integer, icon_custom_emoji_id: String)

<p>This object represents a service message about a new forum topic created in the chat.</p>

| name | type | required | description |
|---|---|---|---|
| name | String | true | Name of the topic |
| icon_color | Integer | true | Color of the topic icon in RGB format |
| icon_custom_emoji_id | String | false | <em>Optional</em>. Unique identifier of the custom emoji shown as the topic icon |

#### ForumTopicEdited

    ForumTopicEdited(name: String, icon_custom_emoji_id: String)

<p>This object represents a service message about an edited forum topic.</p>

| name | type | required | description |
|---|---|---|---|
| name | String | false | <em>Optional</em>. New name of the topic, if it was edited |
| icon_custom_emoji_id | String | false | <em>Optional</em>. New identifier of the custom emoji shown as the topic icon, if it was edited; an empty string if the icon was removed |

#### SharedUser

    SharedUser(user_id: Integer, first_name: String, last_name: String, username: String, photo: List<PhotoSize>)

<p>This object contains information about a user that was shared with the bot using a <a href="#keyboardbuttonrequestusers">KeyboardButtonRequestUsers</a> button.</p>

| name | type | required | description |
|---|---|---|---|
| user_id | Integer | true | Identifier of the shared user. This number may have more than 32 significant bits and some programming languages may have difficulty/silent defects in interpreting it. But it has at most 52 significant bits, so 64-bit integers or double-precision float types are safe for storing these identifiers. The bot may not have access to the user and could be unable to use this identifier, unless the user is already known to the bot by some other means. |
| first_name | String | false | <em>Optional</em>. First name of the user, if the name was requested by the bot |
| last_name | String | false | <em>Optional</em>. Last name of the user, if the name was requested by the bot |
| username | String | false | <em>Optional</em>. Username of the user, if the username was requested by the bot |
| photo | List<PhotoSize> | false | <em>Optional</em>. Available sizes of the chat photo, if the photo was requested by the bot |

#### UsersShared

    UsersShared(request_id: Integer, users: List<SharedUser>)

<p>This object contains information about the users whose identifiers were shared with the bot using a <a href="#keyboardbuttonrequestusers">KeyboardButtonRequestUsers</a> button.</p>

| name | type | required | description |
|---|---|---|---|
| request_id | Integer | true | Identifier of the request |
| users | List<SharedUser> | true | Information about users shared with the bot. |

#### ChatShared

    ChatShared(request_id: Integer, chat_id: Integer, title: String, username: String, photo: List<PhotoSize>)

<p>This object contains information about a chat that was shared with the bot using a <a href="#keyboardbuttonrequestchat">KeyboardButtonRequestChat</a> button.</p>

| name | type | required | description |
|---|---|---|---|
| request_id | Integer | true | Identifier of the request |
| chat_id | Integer | true | Identifier of the shared chat. This number may have more than 32 significant bits and some programming languages may have difficulty/silent defects in interpreting it. But it has at most 52 significant bits, so a 64-bit integer or double-precision float type are safe for storing this identifier. The bot may not have access to the chat and could be unable to use this identifier, unless the chat is already known to the bot by some other means. |
| title | String | false | <em>Optional</em>. Title of the chat, if the title was requested by the bot. |
| username | String | false | <em>Optional</em>. Username of the chat, if the username was requested by the bot and available. |
| photo | List<PhotoSize> | false | <em>Optional</em>. Available sizes of the chat photo, if the photo was requested by the bot |

#### WriteAccessAllowed

    WriteAccessAllowed(from_request: Boolean, web_app_name: String, from_attachment_menu: Boolean)

<p>This object represents a service message about a user allowing a bot to write messages after adding it to the attachment menu, launching a Web App from a link, or accepting an explicit request from a Web App sent by the method <a href="/bots/webapps#initializing-mini-apps">requestWriteAccess</a>.</p>

| name | type | required | description |
|---|---|---|---|
| from_request | Boolean | false | <em>Optional</em>. True, if the access was granted after the user accepted an explicit request from a Web App sent by the method <a href="/bots/webapps#initializing-mini-apps">requestWriteAccess</a> |
| web_app_name | String | false | <em>Optional</em>. Name of the Web App, if the access was granted when the Web App was launched from a link |
| from_attachment_menu | Boolean | false | <em>Optional</em>. True, if the access was granted when the bot was added to the attachment or side menu |

#### VideoChatScheduled

    VideoChatScheduled(start_date: Integer)

<p>This object represents a service message about a video chat scheduled in the chat.</p>

| name | type | required | description |
|---|---|---|---|
| start_date | Integer | true | Point in time (Unix timestamp) when the video chat is supposed to be started by a chat administrator |

#### VideoChatEnded

    VideoChatEnded(duration: Integer)

<p>This object represents a service message about a video chat ended in the chat.</p>

| name | type | required | description |
|---|---|---|---|
| duration | Integer | true | Video chat duration in seconds |

#### VideoChatParticipantsInvited

    VideoChatParticipantsInvited(users: List<User>)

<p>This object represents a service message about new members invited to a video chat.</p>

| name | type | required | description |
|---|---|---|---|
| users | List<User> | true | New members that were invited to the video chat |

#### Giveaway

    Giveaway(chats: List<Chat>, winners_selection_date: Integer, winner_count: Integer, only_new_members: Boolean, has_public_winners: Boolean, prize_description: String, country_codes: List<String>, premium_subscription_month_count: Integer)

<p>This object represents a message about a scheduled giveaway.</p>

| name | type | required | description |
|---|---|---|---|
| chats | List<Chat> | true | The list of chats which the user must join to participate in the giveaway |
| winners_selection_date | Integer | true | Point in time (Unix timestamp) when winners of the giveaway will be selected |
| winner_count | Integer | true | The number of users which are supposed to be selected as winners of the giveaway |
| only_new_members | Boolean | false | <em>Optional</em>. <em>True</em>, if only users who join the chats after the giveaway started should be eligible to win |
| has_public_winners | Boolean | false | <em>Optional</em>. <em>True</em>, if the list of giveaway winners will be visible to everyone |
| prize_description | String | false | <em>Optional</em>. Description of additional giveaway prize |
| country_codes | List<String> | false | <em>Optional</em>. A list of two-letter <a href="https://en.wikipedia.org/wiki/ISO_3166-1_alpha-2">ISO 3166-1 alpha-2</a> country codes indicating the countries from which eligible users for the giveaway must come. If empty, then all users can participate in the giveaway. Users with a phone number that was bought on Fragment can always participate in giveaways. |
| premium_subscription_month_count | Integer | false | <em>Optional</em>. The number of months the Telegram Premium subscription won from the giveaway will be active for |

#### GiveawayWinners

    GiveawayWinners(chat: Chat, giveaway_message_id: Integer, winners_selection_date: Integer, winner_count: Integer, winners: List<User>, additional_chat_count: Integer, premium_subscription_month_count: Integer, unclaimed_prize_count: Integer, only_new_members: Boolean, was_refunded: Boolean, prize_description: String)

<p>This object represents a message about the completion of a giveaway with public winners.</p>

| name | type | required | description |
|---|---|---|---|
| chat | Chat | true | The chat that created the giveaway |
| giveaway_message_id | Integer | true | Identifier of the message with the giveaway in the chat |
| winners_selection_date | Integer | true | Point in time (Unix timestamp) when winners of the giveaway were selected |
| winner_count | Integer | true | Total number of winners in the giveaway |
| winners | List<User> | true | List of up to 100 winners of the giveaway |
| additional_chat_count | Integer | false | <em>Optional</em>. The number of other chats the user had to join in order to be eligible for the giveaway |
| premium_subscription_month_count | Integer | false | <em>Optional</em>. The number of months the Telegram Premium subscription won from the giveaway will be active for |
| unclaimed_prize_count | Integer | false | <em>Optional</em>. Number of undistributed prizes |
| only_new_members | Boolean | false | <em>Optional</em>. <em>True</em>, if only users who had joined the chats after the giveaway started were eligible to win |
| was_refunded | Boolean | false | <em>Optional</em>. <em>True</em>, if the giveaway was canceled because the payment for it was refunded |
| prize_description | String | false | <em>Optional</em>. Description of additional giveaway prize |

#### GiveawayCompleted

    GiveawayCompleted(winner_count: Integer, unclaimed_prize_count: Integer, giveaway_message: Message)

<p>This object represents a service message about the completion of a giveaway without public winners.</p>

| name | type | required | description |
|---|---|---|---|
| winner_count | Integer | true | Number of winners in the giveaway |
| unclaimed_prize_count | Integer | false | <em>Optional</em>. Number of undistributed prizes |
| giveaway_message | Message | false | <em>Optional</em>. Message with the giveaway that was completed, if it wasn't deleted |

#### LinkPreviewOptions

    LinkPreviewOptions(is_disabled: Boolean, url: String, prefer_small_media: Boolean, prefer_large_media: Boolean, show_above_text: Boolean)

<p>Describes the options used for link preview generation.</p>

| name | type | required | description |
|---|---|---|---|
| is_disabled | Boolean | false | <em>Optional</em>. <em>True</em>, if the link preview is disabled |
| url | String | false | <em>Optional</em>. URL to use for the link preview. If empty, then the first URL found in the message text will be used |
| prefer_small_media | Boolean | false | <em>Optional</em>. <em>True</em>, if the media in the link preview is supposed to be shrunk; ignored if the URL isn't explicitly specified or media size change isn't supported for the preview |
| prefer_large_media | Boolean | false | <em>Optional</em>. <em>True</em>, if the media in the link preview is supposed to be enlarged; ignored if the URL isn't explicitly specified or media size change isn't supported for the preview |
| show_above_text | Boolean | false | <em>Optional</em>. <em>True</em>, if the link preview must be shown above the message text; otherwise, the link preview will be shown below the message text |

#### UserProfilePhotos

    UserProfilePhotos(total_count: Integer, photos: List<List<PhotoSize>>)

<p>This object represent a user's profile pictures.</p>

| name | type | required | description |
|---|---|---|---|
| total_count | Integer | true | Total number of profile pictures the target user has |
| photos | List<List<PhotoSize>> | true | Requested profile pictures (in up to 4 sizes each) |

#### File

    File(file_id: String, file_unique_id: String, file_size: Integer, file_path: String)

<p>This object represents a file ready to be downloaded. The file can be downloaded via the link <code>https://api.telegram.org/file/bot&lt;token&gt;/&lt;file_path&gt;</code>. It is guaranteed that the link will be valid for at least 1 hour. When the link expires, a new one can be requested by calling <a href="#getfile">getFile</a>.</p><blockquote>
 <p>The maximum file size to download is 20 MB</p>
</blockquote>

| name | type | required | description |
|---|---|---|---|
| file_id | String | true | Identifier for this file, which can be used to download or reuse the file |
| file_unique_id | String | true | Unique identifier for this file, which is supposed to be the same over time and for different bots. Can't be used to download or reuse the file. |
| file_size | Integer | false | <em>Optional</em>. File size in bytes. It can be bigger than 2^31 and some programming languages may have difficulty/silent defects in interpreting it. But it has at most 52 significant bits, so a signed 64-bit integer or double-precision float type are safe for storing this value. |
| file_path | String | false | <em>Optional</em>. File path. Use <code>https://api.telegram.org/file/bot&lt;token&gt;/&lt;file_path&gt;</code> to get the file. |

#### WebAppInfo

    WebAppInfo(url: String)

<p>Describes a <a href="/bots/webapps">Web App</a>.</p>

| name | type | required | description |
|---|---|---|---|
| url | String | true | An HTTPS URL of a Web App to be opened with additional data as specified in <a href="/bots/webapps#initializing-mini-apps">Initializing Web Apps</a> |

#### ReplyKeyboardMarkup

    ReplyKeyboardMarkup(keyboard: List<List<KeyboardButton>>, is_persistent: Boolean, resize_keyboard: Boolean, one_time_keyboard: Boolean, input_field_placeholder: String, selective: Boolean)

<p>This object represents a <a href="/bots/features#keyboards">custom keyboard</a> with reply options (see <a href="/bots/features#keyboards">Introduction to bots</a> for details and examples). Not supported in channels and for messages sent on behalf of a Telegram Business account.</p>

| name | type | required | description |
|---|---|---|---|
| keyboard | List<List<KeyboardButton>> | true | Array of button rows, each represented by an Array of <a href="#keyboardbutton">KeyboardButton</a> objects |
| is_persistent | Boolean | false | <em>Optional</em>. Requests clients to always show the keyboard when the regular keyboard is hidden. Defaults to <em>false</em>, in which case the custom keyboard can be hidden and opened with a keyboard icon. |
| resize_keyboard | Boolean | false | <em>Optional</em>. Requests clients to resize the keyboard vertically for optimal fit (e.g., make the keyboard smaller if there are just two rows of buttons). Defaults to <em>false</em>, in which case the custom keyboard is always of the same height as the app's standard keyboard. |
| one_time_keyboard | Boolean | false | <em>Optional</em>. Requests clients to hide the keyboard as soon as it's been used. The keyboard will still be available, but clients will automatically display the usual letter-keyboard in the chat - the user can press a special button in the input field to see the custom keyboard again. Defaults to <em>false</em>. |
| input_field_placeholder | String | false | <em>Optional</em>. The placeholder to be shown in the input field when the keyboard is active; 1-64 characters |
| selective | Boolean | false | <em>Optional</em>. Use this parameter if you want to show the keyboard to specific users only. Targets: 1) users that are @mentioned in the <em>text</em> of the <a href="#message">Message</a> object; 2) if the bot's message is a reply to a message in the same chat and forum topic, sender of the original message.<br><br><em>Example:</em> A user requests to change the bot's language, bot replies to the request with a keyboard to select the new language. Other users in the group don't see the keyboard. |

#### KeyboardButton

    KeyboardButton(text: String, request_users: KeyboardButtonRequestUsers, request_chat: KeyboardButtonRequestChat, request_contact: Boolean, request_location: Boolean, request_poll: KeyboardButtonPollType, web_app: WebAppInfo)

<p>This object represents one button of the reply keyboard. At most one of the optional fields must be used to specify type of the button. For simple text buttons, <em>String</em> can be used instead of this object to specify the button text.</p><p><strong>Note:</strong> <em>request_users</em> and <em>request_chat</em> options will only work in Telegram versions released after 3 February, 2023. Older clients will display <em>unsupported message</em>.</p>

| name | type | required | description |
|---|---|---|---|
| text | String | true | Text of the button. If none of the optional fields are used, it will be sent as a message when the button is pressed |
| request_users | KeyboardButtonRequestUsers | false | <em>Optional.</em> If specified, pressing the button will open a list of suitable users. Identifiers of selected users will be sent to the bot in a “users_shared” service message. Available in private chats only. |
| request_chat | KeyboardButtonRequestChat | false | <em>Optional.</em> If specified, pressing the button will open a list of suitable chats. Tapping on a chat will send its identifier to the bot in a “chat_shared” service message. Available in private chats only. |
| request_contact | Boolean | false | <em>Optional</em>. If <em>True</em>, the user's phone number will be sent as a contact when the button is pressed. Available in private chats only. |
| request_location | Boolean | false | <em>Optional</em>. If <em>True</em>, the user's current location will be sent when the button is pressed. Available in private chats only. |
| request_poll | KeyboardButtonPollType | false | <em>Optional</em>. If specified, the user will be asked to create a poll and send it to the bot when the button is pressed. Available in private chats only. |
| web_app | WebAppInfo | false | <em>Optional</em>. If specified, the described <a href="/bots/webapps">Web App</a> will be launched when the button is pressed. The Web App will be able to send a “web_app_data” service message. Available in private chats only. |

#### KeyboardButtonRequestUsers

    KeyboardButtonRequestUsers(request_id: Integer, user_is_bot: Boolean, user_is_premium: Boolean, max_quantity: Integer, request_name: Boolean, request_username: Boolean, request_photo: Boolean)

<p>This object defines the criteria used to request suitable users. Information about the selected users will be shared with the bot when the corresponding button is pressed. <a href="/bots/features#chat-and-user-selection">More about requesting users »</a></p>

| name | type | required | description |
|---|---|---|---|
| request_id | Integer | true | Signed 32-bit identifier of the request that will be received back in the <a href="#usersshared">UsersShared</a> object. Must be unique within the message |
| user_is_bot | Boolean | false | <em>Optional</em>. Pass <em>True</em> to request bots, pass <em>False</em> to request regular users. If not specified, no additional restrictions are applied. |
| user_is_premium | Boolean | false | <em>Optional</em>. Pass <em>True</em> to request premium users, pass <em>False</em> to request non-premium users. If not specified, no additional restrictions are applied. |
| max_quantity | Integer | false | <em>Optional</em>. The maximum number of users to be selected; 1-10. Defaults to 1. |
| request_name | Boolean | false | <em>Optional</em>. Pass <em>True</em> to request the users' first and last names |
| request_username | Boolean | false | <em>Optional</em>. Pass <em>True</em> to request the users' usernames |
| request_photo | Boolean | false | <em>Optional</em>. Pass <em>True</em> to request the users' photos |

#### KeyboardButtonRequestChat

    KeyboardButtonRequestChat(request_id: Integer, chat_is_channel: Boolean, chat_is_forum: Boolean, chat_has_username: Boolean, chat_is_created: Boolean, user_administrator_rights: ChatAdministratorRights, bot_administrator_rights: ChatAdministratorRights, bot_is_member: Boolean, request_title: Boolean, request_username: Boolean, request_photo: Boolean)

<p>This object defines the criteria used to request a suitable chat. Information about the selected chat will be shared with the bot when the corresponding button is pressed. The bot will be granted requested rights in the chat if appropriate. <a href="/bots/features#chat-and-user-selection">More about requesting chats »</a>.</p>

| name | type | required | description |
|---|---|---|---|
| request_id | Integer | true | Signed 32-bit identifier of the request, which will be received back in the <a href="#chatshared">ChatShared</a> object. Must be unique within the message |
| chat_is_channel | Boolean | true | Pass <em>True</em> to request a channel chat, pass <em>False</em> to request a group or a supergroup chat. |
| chat_is_forum | Boolean | false | <em>Optional</em>. Pass <em>True</em> to request a forum supergroup, pass <em>False</em> to request a non-forum chat. If not specified, no additional restrictions are applied. |
| chat_has_username | Boolean | false | <em>Optional</em>. Pass <em>True</em> to request a supergroup or a channel with a username, pass <em>False</em> to request a chat without a username. If not specified, no additional restrictions are applied. |
| chat_is_created | Boolean | false | <em>Optional</em>. Pass <em>True</em> to request a chat owned by the user. Otherwise, no additional restrictions are applied. |
| user_administrator_rights | ChatAdministratorRights | false | <em>Optional</em>. A JSON-serialized object listing the required administrator rights of the user in the chat. The rights must be a superset of <em>bot_administrator_rights</em>. If not specified, no additional restrictions are applied. |
| bot_administrator_rights | ChatAdministratorRights | false | <em>Optional</em>. A JSON-serialized object listing the required administrator rights of the bot in the chat. The rights must be a subset of <em>user_administrator_rights</em>. If not specified, no additional restrictions are applied. |
| bot_is_member | Boolean | false | <em>Optional</em>. Pass <em>True</em> to request a chat with the bot as a member. Otherwise, no additional restrictions are applied. |
| request_title | Boolean | false | <em>Optional</em>. Pass <em>True</em> to request the chat's title |
| request_username | Boolean | false | <em>Optional</em>. Pass <em>True</em> to request the chat's username |
| request_photo | Boolean | false | <em>Optional</em>. Pass <em>True</em> to request the chat's photo |

#### KeyboardButtonPollType

    KeyboardButtonPollType(type: String)

<p>This object represents type of a poll, which is allowed to be created and sent when the corresponding button is pressed.</p>

| name | type | required | description |
|---|---|---|---|
| type | String | false | <em>Optional</em>. If <em>quiz</em> is passed, the user will be allowed to create only polls in the quiz mode. If <em>regular</em> is passed, only regular polls will be allowed. Otherwise, the user will be allowed to create a poll of any type. |

#### ReplyKeyboardRemove

    ReplyKeyboardRemove(remove_keyboard: Boolean, selective: Boolean)

<p>Upon receiving a message with this object, Telegram clients will remove the current custom keyboard and display the default letter-keyboard. By default, custom keyboards are displayed until a new keyboard is sent by a bot. An exception is made for one-time keyboards that are hidden immediately after the user presses a button (see <a href="#replykeyboardmarkup">ReplyKeyboardMarkup</a>). Not supported in channels and for messages sent on behalf of a Telegram Business account.</p>

| name | type | required | description |
|---|---|---|---|
| remove_keyboard | Boolean | true | Requests clients to remove the custom keyboard (user will not be able to summon this keyboard; if you want to hide the keyboard from sight but keep it accessible, use <em>one_time_keyboard</em> in <a href="#replykeyboardmarkup">ReplyKeyboardMarkup</a>) |
| selective | Boolean | false | <em>Optional</em>. Use this parameter if you want to remove the keyboard for specific users only. Targets: 1) users that are @mentioned in the <em>text</em> of the <a href="#message">Message</a> object; 2) if the bot's message is a reply to a message in the same chat and forum topic, sender of the original message.<br><br><em>Example:</em> A user votes in a poll, bot returns confirmation message in reply to the vote and removes the keyboard for that user, while still showing the keyboard with poll options to users who haven't voted yet. |

#### InlineKeyboardMarkup

    InlineKeyboardMarkup(inline_keyboard: List<List<InlineKeyboardButton>>)

<p>This object represents an <a href="/bots/features#inline-keyboards">inline keyboard</a> that appears right next to the message it belongs to.</p>

| name | type | required | description |
|---|---|---|---|
| inline_keyboard | List<List<InlineKeyboardButton>> | true | Array of button rows, each represented by an Array of <a href="#inlinekeyboardbutton">InlineKeyboardButton</a> objects |

#### InlineKeyboardButton

    InlineKeyboardButton(text: String, url: String, callback_data: String, web_app: WebAppInfo, login_url: LoginUrl, switch_inline_query: String, switch_inline_query_current_chat: String, switch_inline_query_chosen_chat: SwitchInlineQueryChosenChat, callback_game: CallbackGame, pay: Boolean)

<p>This object represents one button of an inline keyboard. Exactly one of the optional fields must be used to specify type of the button.</p>

| name | type | required | description |
|---|---|---|---|
| text | String | true | Label text on the button |
| url | String | false | <em>Optional</em>. HTTP or tg:// URL to be opened when the button is pressed. Links <code>tg://user?id=&lt;user_id&gt;</code> can be used to mention a user by their identifier without using a username, if this is allowed by their privacy settings. |
| callback_data | String | false | <em>Optional</em>. Data to be sent in a <a href="#callbackquery">callback query</a> to the bot when the button is pressed, 1-64 bytes |
| web_app | WebAppInfo | false | <em>Optional</em>. Description of the <a href="/bots/webapps">Web App</a> that will be launched when the user presses the button. The Web App will be able to send an arbitrary message on behalf of the user using the method <a href="#answerwebappquery">answerWebAppQuery</a>. Available only in private chats between a user and the bot. Not supported for messages sent on behalf of a Telegram Business account. |
| login_url | LoginUrl | false | <em>Optional</em>. An HTTPS URL used to automatically authorize the user. Can be used as a replacement for the <a href="/widgets/login">Telegram Login Widget</a>. |
| switch_inline_query | String | false | <em>Optional</em>. If set, pressing the button will prompt the user to select one of their chats, open that chat and insert the bot's username and the specified inline query in the input field. May be empty, in which case just the bot's username will be inserted. Not supported for messages sent on behalf of a Telegram Business account. |
| switch_inline_query_current_chat | String | false | <em>Optional</em>. If set, pressing the button will insert the bot's username and the specified inline query in the current chat's input field. May be empty, in which case only the bot's username will be inserted.<br><br>This offers a quick way for the user to open your bot in inline mode in the same chat - good for selecting something from multiple options. Not supported in channels and for messages sent on behalf of a Telegram Business account. |
| switch_inline_query_chosen_chat | SwitchInlineQueryChosenChat | false | <em>Optional</em>. If set, pressing the button will prompt the user to select one of their chats of the specified type, open that chat and insert the bot's username and the specified inline query in the input field. Not supported for messages sent on behalf of a Telegram Business account. |
| callback_game | CallbackGame | false | <em>Optional</em>. Description of the game that will be launched when the user presses the button.<br><br><strong>NOTE:</strong> This type of button <strong>must</strong> always be the first button in the first row. |
| pay | Boolean | false | <em>Optional</em>. Specify <em>True</em>, to send a <a href="#payments">Pay button</a>. Substrings “<img class="emoji" src="//telegram.org/img/emoji/40/E2AD90.png" width="20" height="20" alt="⭐">” and “XTR” in the buttons's text will be replaced with a Telegram Star icon.<br><br><strong>NOTE:</strong> This type of button <strong>must</strong> always be the first button in the first row and can only be used in invoice messages. |

#### LoginUrl

    LoginUrl(url: String, forward_text: String, bot_username: String, request_write_access: Boolean)

<p>This object represents a parameter of the inline keyboard button used to automatically authorize a user. Serves as a great replacement for the <a href="/widgets/login">Telegram Login Widget</a> when the user is coming from Telegram. All the user needs to do is tap/click a button and confirm that they want to log in:</p><p>Telegram apps support these buttons as of <a href="https://telegram.org/blog/privacy-discussions-web-bots#meet-seamless-web-bots">version 5.7</a>.</p><blockquote>
 <p>Sample bot: <a href="https://t.me/discussbot">@discussbot</a></p>
</blockquote>

| name | type | required | description |
|---|---|---|---|
| url | String | true | An HTTPS URL to be opened with user authorization data added to the query string when the button is pressed. If the user refuses to provide authorization data, the original URL without information about the user will be opened. The data added is the same as described in <a href="/widgets/login#receiving-authorization-data">Receiving authorization data</a>.<br><br><strong>NOTE:</strong> You <strong>must</strong> always check the hash of the received data to verify the authentication and the integrity of the data as described in <a href="/widgets/login#checking-authorization">Checking authorization</a>. |
| forward_text | String | false | <em>Optional</em>. New text of the button in forwarded messages. |
| bot_username | String | false | <em>Optional</em>. Username of a bot, which will be used for user authorization. See <a href="/widgets/login#setting-up-a-bot">Setting up a bot</a> for more details. If not specified, the current bot's username will be assumed. The <em>url</em>'s domain must be the same as the domain linked with the bot. See <a href="/widgets/login#linking-your-domain-to-the-bot">Linking your domain to the bot</a> for more details. |
| request_write_access | Boolean | false | <em>Optional</em>. Pass <em>True</em> to request the permission for your bot to send messages to the user. |

#### SwitchInlineQueryChosenChat

    SwitchInlineQueryChosenChat(query: String, allow_user_chats: Boolean, allow_bot_chats: Boolean, allow_group_chats: Boolean, allow_channel_chats: Boolean)

<p>This object represents an inline button that switches the current user to inline mode in a chosen chat, with an optional default inline query.</p>

| name | type | required | description |
|---|---|---|---|
| query | String | false | <em>Optional</em>. The default inline query to be inserted in the input field. If left empty, only the bot's username will be inserted |
| allow_user_chats | Boolean | false | <em>Optional</em>. True, if private chats with users can be chosen |
| allow_bot_chats | Boolean | false | <em>Optional</em>. True, if private chats with bots can be chosen |
| allow_group_chats | Boolean | false | <em>Optional</em>. True, if group and supergroup chats can be chosen |
| allow_channel_chats | Boolean | false | <em>Optional</em>. True, if channel chats can be chosen |

#### CallbackQuery

    CallbackQuery(id: String, from: User, message: MaybeInaccessibleMessage, inline_message_id: String, chat_instance: String, data: String, game_short_name: String)

<p>This object represents an incoming callback query from a callback button in an <a href="/bots/features#inline-keyboards">inline keyboard</a>. If the button that originated the query was attached to a message sent by the bot, the field <em>message</em> will be present. If the button was attached to a message sent via the bot (in <a href="#inline-mode">inline mode</a>), the field <em>inline_message_id</em> will be present. Exactly one of the fields <em>data</em> or <em>game_short_name</em> will be present.</p><blockquote>
 <p><strong>NOTE:</strong> After the user presses a callback button, Telegram clients will display a progress bar until you call <a href="#answercallbackquery">answerCallbackQuery</a>. It is, therefore, necessary to react by calling <a href="#answercallbackquery">answerCallbackQuery</a> even if no notification to the user is needed (e.g., without specifying any of the optional parameters).</p>
</blockquote>

| name | type | required | description |
|---|---|---|---|
| id | String | true | Unique identifier for this query |
| from | User | true | Sender |
| message | MaybeInaccessibleMessage | false | <em>Optional</em>. Message sent by the bot with the callback button that originated the query |
| inline_message_id | String | false | <em>Optional</em>. Identifier of the message sent via the bot in inline mode, that originated the query. |
| chat_instance | String | true | Global identifier, uniquely corresponding to the chat to which the message with the callback button was sent. Useful for high scores in <a href="#games">games</a>. |
| data | String | false | <em>Optional</em>. Data associated with the callback button. Be aware that the message originated the query can contain no callback buttons with this data. |
| game_short_name | String | false | <em>Optional</em>. Short name of a <a href="#games">Game</a> to be returned, serves as the unique identifier for the game |

#### ForceReply

    ForceReply(force_reply: Boolean, input_field_placeholder: String, selective: Boolean)

<p>Upon receiving a message with this object, Telegram clients will display a reply interface to the user (act as if the user has selected the bot's message and tapped 'Reply'). This can be extremely useful if you want to create user-friendly step-by-step interfaces without having to sacrifice <a href="/bots/features#privacy-mode">privacy mode</a>. Not supported in channels and for messages sent on behalf of a Telegram Business account.</p><blockquote>
 <p><strong>Example:</strong> A <a href="https://t.me/PollBot">poll bot</a> for groups runs in privacy mode (only receives commands, replies to its messages and mentions). There could be two ways to create a new poll:</p>
 <ul>
  <li>Explain the user how to send a command with parameters (e.g. /newpoll question answer1 answer2). May be appealing for hardcore users but lacks modern day polish.</li>
  <li>Guide the user through a step-by-step process. 'Please send me your question', 'Cool, now let's add the first answer option', 'Great. Keep adding answer options, then send /done when you're ready'.</li>
 </ul>
 <p>The last option is definitely more attractive. And if you use <a href="#forcereply">ForceReply</a> in your bot's questions, it will receive the user's answers even if it only receives replies, commands and mentions - without any extra work for the user.</p>
</blockquote>

| name | type | required | description |
|---|---|---|---|
| force_reply | Boolean | true | Shows reply interface to the user, as if they manually selected the bot's message and tapped 'Reply' |
| input_field_placeholder | String | false | <em>Optional</em>. The placeholder to be shown in the input field when the reply is active; 1-64 characters |
| selective | Boolean | false | <em>Optional</em>. Use this parameter if you want to force reply from specific users only. Targets: 1) users that are @mentioned in the <em>text</em> of the <a href="#message">Message</a> object; 2) if the bot's message is a reply to a message in the same chat and forum topic, sender of the original message. |

#### ChatPhoto

    ChatPhoto(small_file_id: String, small_file_unique_id: String, big_file_id: String, big_file_unique_id: String)

<p>This object represents a chat photo.</p>

| name | type | required | description |
|---|---|---|---|
| small_file_id | String | true | File identifier of small (160x160) chat photo. This file_id can be used only for photo download and only for as long as the photo is not changed. |
| small_file_unique_id | String | true | Unique file identifier of small (160x160) chat photo, which is supposed to be the same over time and for different bots. Can't be used to download or reuse the file. |
| big_file_id | String | true | File identifier of big (640x640) chat photo. This file_id can be used only for photo download and only for as long as the photo is not changed. |
| big_file_unique_id | String | true | Unique file identifier of big (640x640) chat photo, which is supposed to be the same over time and for different bots. Can't be used to download or reuse the file. |

#### ChatInviteLink

    ChatInviteLink(invite_link: String, creator: User, creates_join_request: Boolean, is_primary: Boolean, is_revoked: Boolean, name: String, expire_date: Integer, member_limit: Integer, pending_join_request_count: Integer)

<p>Represents an invite link for a chat.</p>

| name | type | required | description |
|---|---|---|---|
| invite_link | String | true | The invite link. If the link was created by another chat administrator, then the second part of the link will be replaced with “…”. |
| creator | User | true | Creator of the link |
| creates_join_request | Boolean | true | <em>True</em>, if users joining the chat via the link need to be approved by chat administrators |
| is_primary | Boolean | true | <em>True</em>, if the link is primary |
| is_revoked | Boolean | true | <em>True</em>, if the link is revoked |
| name | String | false | <em>Optional</em>. Invite link name |
| expire_date | Integer | false | <em>Optional</em>. Point in time (Unix timestamp) when the link will expire or has been expired |
| member_limit | Integer | false | <em>Optional</em>. The maximum number of users that can be members of the chat simultaneously after joining the chat via this invite link; 1-99999 |
| pending_join_request_count | Integer | false | <em>Optional</em>. Number of pending join requests created using this link |

#### ChatAdministratorRights

    ChatAdministratorRights(is_anonymous: Boolean, can_manage_chat: Boolean, can_delete_messages: Boolean, can_manage_video_chats: Boolean, can_restrict_members: Boolean, can_promote_members: Boolean, can_change_info: Boolean, can_invite_users: Boolean, can_post_stories: Boolean, can_edit_stories: Boolean, can_delete_stories: Boolean, can_post_messages: Boolean, can_edit_messages: Boolean, can_pin_messages: Boolean, can_manage_topics: Boolean)

<p>Represents the rights of an administrator in a chat.</p>

| name | type | required | description |
|---|---|---|---|
| is_anonymous | Boolean | true | <em>True</em>, if the user's presence in the chat is hidden |
| can_manage_chat | Boolean | true | <em>True</em>, if the administrator can access the chat event log, get boost list, see hidden supergroup and channel members, report spam messages and ignore slow mode. Implied by any other administrator privilege. |
| can_delete_messages | Boolean | true | <em>True</em>, if the administrator can delete messages of other users |
| can_manage_video_chats | Boolean | true | <em>True</em>, if the administrator can manage video chats |
| can_restrict_members | Boolean | true | <em>True</em>, if the administrator can restrict, ban or unban chat members, or access supergroup statistics |
| can_promote_members | Boolean | true | <em>True</em>, if the administrator can add new administrators with a subset of their own privileges or demote administrators that they have promoted, directly or indirectly (promoted by administrators that were appointed by the user) |
| can_change_info | Boolean | true | <em>True</em>, if the user is allowed to change the chat title, photo and other settings |
| can_invite_users | Boolean | true | <em>True</em>, if the user is allowed to invite new users to the chat |
| can_post_stories | Boolean | true | <em>True</em>, if the administrator can post stories to the chat |
| can_edit_stories | Boolean | true | <em>True</em>, if the administrator can edit stories posted by other users, post stories to the chat page, pin chat stories, and access the chat's story archive |
| can_delete_stories | Boolean | true | <em>True</em>, if the administrator can delete stories posted by other users |
| can_post_messages | Boolean | false | <em>Optional</em>. <em>True</em>, if the administrator can post messages in the channel, or access channel statistics; for channels only |
| can_edit_messages | Boolean | false | <em>Optional</em>. <em>True</em>, if the administrator can edit messages of other users and can pin messages; for channels only |
| can_pin_messages | Boolean | false | <em>Optional</em>. <em>True</em>, if the user is allowed to pin messages; for groups and supergroups only |
| can_manage_topics | Boolean | false | <em>Optional</em>. <em>True</em>, if the user is allowed to create, rename, close, and reopen forum topics; for supergroups only |

#### ChatMemberUpdated

    ChatMemberUpdated(chat: Chat, from: User, date: Integer, old_chat_member: ChatMember, new_chat_member: ChatMember, invite_link: ChatInviteLink, via_join_request: Boolean, via_chat_folder_invite_link: Boolean)

<p>This object represents changes in the status of a chat member.</p>

| name | type | required | description |
|---|---|---|---|
| chat | Chat | true | Chat the user belongs to |
| from | User | true | Performer of the action, which resulted in the change |
| date | Integer | true | Date the change was done in Unix time |
| old_chat_member | ChatMember | true | Previous information about the chat member |
| new_chat_member | ChatMember | true | New information about the chat member |
| invite_link | ChatInviteLink | false | <em>Optional</em>. Chat invite link, which was used by the user to join the chat; for joining by invite link events only. |
| via_join_request | Boolean | false | <em>Optional</em>. True, if the user joined the chat after sending a direct join request without using an invite link and being approved by an administrator |
| via_chat_folder_invite_link | Boolean | false | <em>Optional</em>. True, if the user joined the chat via a chat folder invite link |

#### ChatMemberOwner

    ChatMemberOwner(status: String, user: User, is_anonymous: Boolean, custom_title: String)

<p>Represents a <a href="#chatmember">chat member</a> that owns the chat and has all administrator privileges.</p>

| name | type | required | description |
|---|---|---|---|
| status | String | true | The member's status in the chat, always “creator” |
| user | User | true | Information about the user |
| is_anonymous | Boolean | true | <em>True</em>, if the user's presence in the chat is hidden |
| custom_title | String | false | <em>Optional</em>. Custom title for this user |

#### ChatMemberAdministrator

    ChatMemberAdministrator(status: String, user: User, can_be_edited: Boolean, is_anonymous: Boolean, can_manage_chat: Boolean, can_delete_messages: Boolean, can_manage_video_chats: Boolean, can_restrict_members: Boolean, can_promote_members: Boolean, can_change_info: Boolean, can_invite_users: Boolean, can_post_stories: Boolean, can_edit_stories: Boolean, can_delete_stories: Boolean, can_post_messages: Boolean, can_edit_messages: Boolean, can_pin_messages: Boolean, can_manage_topics: Boolean, custom_title: String)

<p>Represents a <a href="#chatmember">chat member</a> that has some additional privileges.</p>

| name | type | required | description |
|---|---|---|---|
| status | String | true | The member's status in the chat, always “administrator” |
| user | User | true | Information about the user |
| can_be_edited | Boolean | true | <em>True</em>, if the bot is allowed to edit administrator privileges of that user |
| is_anonymous | Boolean | true | <em>True</em>, if the user's presence in the chat is hidden |
| can_manage_chat | Boolean | true | <em>True</em>, if the administrator can access the chat event log, get boost list, see hidden supergroup and channel members, report spam messages and ignore slow mode. Implied by any other administrator privilege. |
| can_delete_messages | Boolean | true | <em>True</em>, if the administrator can delete messages of other users |
| can_manage_video_chats | Boolean | true | <em>True</em>, if the administrator can manage video chats |
| can_restrict_members | Boolean | true | <em>True</em>, if the administrator can restrict, ban or unban chat members, or access supergroup statistics |
| can_promote_members | Boolean | true | <em>True</em>, if the administrator can add new administrators with a subset of their own privileges or demote administrators that they have promoted, directly or indirectly (promoted by administrators that were appointed by the user) |
| can_change_info | Boolean | true | <em>True</em>, if the user is allowed to change the chat title, photo and other settings |
| can_invite_users | Boolean | true | <em>True</em>, if the user is allowed to invite new users to the chat |
| can_post_stories | Boolean | true | <em>True</em>, if the administrator can post stories to the chat |
| can_edit_stories | Boolean | true | <em>True</em>, if the administrator can edit stories posted by other users, post stories to the chat page, pin chat stories, and access the chat's story archive |
| can_delete_stories | Boolean | true | <em>True</em>, if the administrator can delete stories posted by other users |
| can_post_messages | Boolean | false | <em>Optional</em>. <em>True</em>, if the administrator can post messages in the channel, or access channel statistics; for channels only |
| can_edit_messages | Boolean | false | <em>Optional</em>. <em>True</em>, if the administrator can edit messages of other users and can pin messages; for channels only |
| can_pin_messages | Boolean | false | <em>Optional</em>. <em>True</em>, if the user is allowed to pin messages; for groups and supergroups only |
| can_manage_topics | Boolean | false | <em>Optional</em>. <em>True</em>, if the user is allowed to create, rename, close, and reopen forum topics; for supergroups only |
| custom_title | String | false | <em>Optional</em>. Custom title for this user |

#### ChatMemberMember

    ChatMemberMember(status: String, user: User)

<p>Represents a <a href="#chatmember">chat member</a> that has no additional privileges or restrictions.</p>

| name | type | required | description |
|---|---|---|---|
| status | String | true | The member's status in the chat, always “member” |
| user | User | true | Information about the user |

#### ChatMemberRestricted

    ChatMemberRestricted(status: String, user: User, is_member: Boolean, can_send_messages: Boolean, can_send_audios: Boolean, can_send_documents: Boolean, can_send_photos: Boolean, can_send_videos: Boolean, can_send_video_notes: Boolean, can_send_voice_notes: Boolean, can_send_polls: Boolean, can_send_other_messages: Boolean, can_add_web_page_previews: Boolean, can_change_info: Boolean, can_invite_users: Boolean, can_pin_messages: Boolean, can_manage_topics: Boolean, until_date: Integer)

<p>Represents a <a href="#chatmember">chat member</a> that is under certain restrictions in the chat. Supergroups only.</p>

| name | type | required | description |
|---|---|---|---|
| status | String | true | The member's status in the chat, always “restricted” |
| user | User | true | Information about the user |
| is_member | Boolean | true | <em>True</em>, if the user is a member of the chat at the moment of the request |
| can_send_messages | Boolean | true | <em>True</em>, if the user is allowed to send text messages, contacts, giveaways, giveaway winners, invoices, locations and venues |
| can_send_audios | Boolean | true | <em>True</em>, if the user is allowed to send audios |
| can_send_documents | Boolean | true | <em>True</em>, if the user is allowed to send documents |
| can_send_photos | Boolean | true | <em>True</em>, if the user is allowed to send photos |
| can_send_videos | Boolean | true | <em>True</em>, if the user is allowed to send videos |
| can_send_video_notes | Boolean | true | <em>True</em>, if the user is allowed to send video notes |
| can_send_voice_notes | Boolean | true | <em>True</em>, if the user is allowed to send voice notes |
| can_send_polls | Boolean | true | <em>True</em>, if the user is allowed to send polls |
| can_send_other_messages | Boolean | true | <em>True</em>, if the user is allowed to send animations, games, stickers and use inline bots |
| can_add_web_page_previews | Boolean | true | <em>True</em>, if the user is allowed to add web page previews to their messages |
| can_change_info | Boolean | true | <em>True</em>, if the user is allowed to change the chat title, photo and other settings |
| can_invite_users | Boolean | true | <em>True</em>, if the user is allowed to invite new users to the chat |
| can_pin_messages | Boolean | true | <em>True</em>, if the user is allowed to pin messages |
| can_manage_topics | Boolean | true | <em>True</em>, if the user is allowed to create forum topics |
| until_date | Integer | true | Date when restrictions will be lifted for this user; Unix time. If 0, then the user is restricted forever |

#### ChatMemberLeft

    ChatMemberLeft(status: String, user: User)

<p>Represents a <a href="#chatmember">chat member</a> that isn't currently a member of the chat, but may join it themselves.</p>

| name | type | required | description |
|---|---|---|---|
| status | String | true | The member's status in the chat, always “left” |
| user | User | true | Information about the user |

#### ChatMemberBanned

    ChatMemberBanned(status: String, user: User, until_date: Integer)

<p>Represents a <a href="#chatmember">chat member</a> that was banned in the chat and can't return to the chat or view chat messages.</p>

| name | type | required | description |
|---|---|---|---|
| status | String | true | The member's status in the chat, always “kicked” |
| user | User | true | Information about the user |
| until_date | Integer | true | Date when restrictions will be lifted for this user; Unix time. If 0, then the user is banned forever |

#### ChatJoinRequest

    ChatJoinRequest(chat: Chat, from: User, user_chat_id: Integer, date: Integer, bio: String, invite_link: ChatInviteLink)

<p>Represents a join request sent to a chat.</p>

| name | type | required | description |
|---|---|---|---|
| chat | Chat | true | Chat to which the request was sent |
| from | User | true | User that sent the join request |
| user_chat_id | Integer | true | Identifier of a private chat with the user who sent the join request. This number may have more than 32 significant bits and some programming languages may have difficulty/silent defects in interpreting it. But it has at most 52 significant bits, so a 64-bit integer or double-precision float type are safe for storing this identifier. The bot can use this identifier for 5 minutes to send messages until the join request is processed, assuming no other administrator contacted the user. |
| date | Integer | true | Date the request was sent in Unix time |
| bio | String | false | <em>Optional</em>. Bio of the user. |
| invite_link | ChatInviteLink | false | <em>Optional</em>. Chat invite link that was used by the user to send the join request |

#### ChatPermissions

    ChatPermissions(can_send_messages: Boolean, can_send_audios: Boolean, can_send_documents: Boolean, can_send_photos: Boolean, can_send_videos: Boolean, can_send_video_notes: Boolean, can_send_voice_notes: Boolean, can_send_polls: Boolean, can_send_other_messages: Boolean, can_add_web_page_previews: Boolean, can_change_info: Boolean, can_invite_users: Boolean, can_pin_messages: Boolean, can_manage_topics: Boolean)

<p>Describes actions that a non-administrator user is allowed to take in a chat.</p>

| name | type | required | description |
|---|---|---|---|
| can_send_messages | Boolean | false | <em>Optional</em>. <em>True</em>, if the user is allowed to send text messages, contacts, giveaways, giveaway winners, invoices, locations and venues |
| can_send_audios | Boolean | false | <em>Optional</em>. <em>True</em>, if the user is allowed to send audios |
| can_send_documents | Boolean | false | <em>Optional</em>. <em>True</em>, if the user is allowed to send documents |
| can_send_photos | Boolean | false | <em>Optional</em>. <em>True</em>, if the user is allowed to send photos |
| can_send_videos | Boolean | false | <em>Optional</em>. <em>True</em>, if the user is allowed to send videos |
| can_send_video_notes | Boolean | false | <em>Optional</em>. <em>True</em>, if the user is allowed to send video notes |
| can_send_voice_notes | Boolean | false | <em>Optional</em>. <em>True</em>, if the user is allowed to send voice notes |
| can_send_polls | Boolean | false | <em>Optional</em>. <em>True</em>, if the user is allowed to send polls |
| can_send_other_messages | Boolean | false | <em>Optional</em>. <em>True</em>, if the user is allowed to send animations, games, stickers and use inline bots |
| can_add_web_page_previews | Boolean | false | <em>Optional</em>. <em>True</em>, if the user is allowed to add web page previews to their messages |
| can_change_info | Boolean | false | <em>Optional</em>. <em>True</em>, if the user is allowed to change the chat title, photo and other settings. Ignored in public supergroups |
| can_invite_users | Boolean | false | <em>Optional</em>. <em>True</em>, if the user is allowed to invite new users to the chat |
| can_pin_messages | Boolean | false | <em>Optional</em>. <em>True</em>, if the user is allowed to pin messages. Ignored in public supergroups |
| can_manage_topics | Boolean | false | <em>Optional</em>. <em>True</em>, if the user is allowed to create forum topics. If omitted defaults to the value of can_pin_messages |

#### Birthdate

    Birthdate(day: Integer, month: Integer, year: Integer)

<p>Describes the birthdate of a user.</p>

| name | type | required | description |
|---|---|---|---|
| day | Integer | true | Day of the user's birth; 1-31 |
| month | Integer | true | Month of the user's birth; 1-12 |
| year | Integer | false | <em>Optional</em>. Year of the user's birth |

#### BusinessIntro

    BusinessIntro(title: String, message: String, sticker: Sticker)

<p>Contains information about the start page settings of a Telegram Business account.</p>

| name | type | required | description |
|---|---|---|---|
| title | String | false | <em>Optional</em>. Title text of the business intro |
| message | String | false | <em>Optional</em>. Message text of the business intro |
| sticker | Sticker | false | <em>Optional</em>. Sticker of the business intro |

#### BusinessLocation

    BusinessLocation(address: String, location: Location)

<p>Contains information about the location of a Telegram Business account.</p>

| name | type | required | description |
|---|---|---|---|
| address | String | true | Address of the business |
| location | Location | false | <em>Optional</em>. Location of the business |

#### BusinessOpeningHoursInterval

    BusinessOpeningHoursInterval(opening_minute: Integer, closing_minute: Integer)

<p>Describes an interval of time during which a business is open.</p>

| name | type | required | description |
|---|---|---|---|
| opening_minute | Integer | true | The minute's sequence number in a week, starting on Monday, marking the start of the time interval during which the business is open; 0 - 7 * 24 * 60 |
| closing_minute | Integer | true | The minute's sequence number in a week, starting on Monday, marking the end of the time interval during which the business is open; 0 - 8 * 24 * 60 |

#### BusinessOpeningHours

    BusinessOpeningHours(time_zone_name: String, opening_hours: List<BusinessOpeningHoursInterval>)

<p>Describes the opening hours of a business.</p>

| name | type | required | description |
|---|---|---|---|
| time_zone_name | String | true | Unique name of the time zone for which the opening hours are defined |
| opening_hours | List<BusinessOpeningHoursInterval> | true | List of time intervals describing business opening hours |

#### ChatLocation

    ChatLocation(location: Location, address: String)

<p>Represents a location to which a chat is connected.</p>

| name | type | required | description |
|---|---|---|---|
| location | Location | true | The location to which the supergroup is connected. Can't be a live location. |
| address | String | true | Location address; 1-64 characters, as defined by the chat owner |

#### ReactionTypeEmoji

    ReactionTypeEmoji(type: String, emoji: String)

<p>The reaction is based on an emoji.</p>

| name | type | required | description |
|---|---|---|---|
| type | String | true | Type of the reaction, always “emoji” |
| emoji | String | true | Reaction emoji. Currently, it can be one of "<img class="emoji" src="//telegram.org/img/emoji/40/F09F918D.png" width="20" height="20" alt="👍">", "<img class="emoji" src="//telegram.org/img/emoji/40/F09F918E.png" width="20" height="20" alt="👎">", "<img class="emoji" src="//telegram.org/img/emoji/40/E29DA4.png" width="20" height="20" alt="❤">", "<img class="emoji" src="//telegram.org/img/emoji/40/F09F94A5.png" width="20" height="20" alt="🔥">", "<img class="emoji" src="//telegram.org/img/emoji/40/F09FA5B0.png" width="20" height="20" alt="🥰">", "<img class="emoji" src="//telegram.org/img/emoji/40/F09F918F.png" width="20" height="20" alt="👏">", "<img class="emoji" src="//telegram.org/img/emoji/40/F09F9881.png" width="20" height="20" alt="😁">", "<img class="emoji" src="//telegram.org/img/emoji/40/F09FA494.png" width="20" height="20" alt="🤔">", "<img class="emoji" src="//telegram.org/img/emoji/40/F09FA4AF.png" width="20" height="20" alt="🤯">", "<img class="emoji" src="//telegram.org/img/emoji/40/F09F98B1.png" width="20" height="20" alt="😱">", "<img class="emoji" src="//telegram.org/img/emoji/40/F09FA4AC.png" width="20" height="20" alt="🤬">", "<img class="emoji" src="//telegram.org/img/emoji/40/F09F98A2.png" width="20" height="20" alt="😢">", "<img class="emoji" src="//telegram.org/img/emoji/40/F09F8E89.png" width="20" height="20" alt="🎉">", "<img class="emoji" src="//telegram.org/img/emoji/40/F09FA4A9.png" width="20" height="20" alt="🤩">", "<img class="emoji" src="//telegram.org/img/emoji/40/F09FA4AE.png" width="20" height="20" alt="🤮">", "<img class="emoji" src="//telegram.org/img/emoji/40/F09F92A9.png" width="20" height="20" alt="💩">", "<img class="emoji" src="//telegram.org/img/emoji/40/F09F998F.png" width="20" height="20" alt="🙏">", "<img class="emoji" src="//telegram.org/img/emoji/40/F09F918C.png" width="20" height="20" alt="👌">", "<img class="emoji" src="//telegram.org/img/emoji/40/F09F958A.png" width="20" height="20" alt="🕊">", "<img class="emoji" src="//telegram.org/img/emoji/40/F09FA4A1.png" width="20" height="20" alt="🤡">", "<img class="emoji" src="//telegram.org/img/emoji/40/F09FA5B1.png" width="20" height="20" alt="🥱">", "<img class="emoji" src="//telegram.org/img/emoji/40/F09FA5B4.png" width="20" height="20" alt="🥴">", "<img class="emoji" src="//telegram.org/img/emoji/40/F09F988D.png" width="20" height="20" alt="😍">", "<img class="emoji" src="//telegram.org/img/emoji/40/F09F90B3.png" width="20" height="20" alt="🐳">", "<img class="emoji" src="//telegram.org/img/emoji/40/E29DA4E2808DF09F94A5.png" width="20" height="20" alt="❤‍🔥">", "<img class="emoji" src="//telegram.org/img/emoji/40/F09F8C9A.png" width="20" height="20" alt="🌚">", "<img class="emoji" src="//telegram.org/img/emoji/40/F09F8CAD.png" width="20" height="20" alt="🌭">", "<img class="emoji" src="//telegram.org/img/emoji/40/F09F92AF.png" width="20" height="20" alt="💯">", "<img class="emoji" src="//telegram.org/img/emoji/40/F09FA4A3.png" width="20" height="20" alt="🤣">", "<img class="emoji" src="//telegram.org/img/emoji/40/E29AA1.png" width="20" height="20" alt="⚡">", "<img class="emoji" src="//telegram.org/img/emoji/40/F09F8D8C.png" width="20" height="20" alt="🍌">", "<img class="emoji" src="//telegram.org/img/emoji/40/F09F8F86.png" width="20" height="20" alt="🏆">", "<img class="emoji" src="//telegram.org/img/emoji/40/F09F9294.png" width="20" height="20" alt="💔">", "<img class="emoji" src="//telegram.org/img/emoji/40/F09FA4A8.png" width="20" height="20" alt="🤨">", "<img class="emoji" src="//telegram.org/img/emoji/40/F09F9890.png" width="20" height="20" alt="😐">", "<img class="emoji" src="//telegram.org/img/emoji/40/F09F8D93.png" width="20" height="20" alt="🍓">", "<img class="emoji" src="//telegram.org/img/emoji/40/F09F8DBE.png" width="20" height="20" alt="🍾">", "<img class="emoji" src="//telegram.org/img/emoji/40/F09F928B.png" width="20" height="20" alt="💋">", "<img class="emoji" src="//telegram.org/img/emoji/40/F09F9695.png" width="20" height="20" alt="🖕">", "<img class="emoji" src="//telegram.org/img/emoji/40/F09F9888.png" width="20" height="20" alt="😈">", "<img class="emoji" src="//telegram.org/img/emoji/40/F09F98B4.png" width="20" height="20" alt="😴">", "<img class="emoji" src="//telegram.org/img/emoji/40/F09F98AD.png" width="20" height="20" alt="😭">", "<img class="emoji" src="//telegram.org/img/emoji/40/F09FA493.png" width="20" height="20" alt="🤓">", "<img class="emoji" src="//telegram.org/img/emoji/40/F09F91BB.png" width="20" height="20" alt="👻">", "<img class="emoji" src="//telegram.org/img/emoji/40/F09F91A8E2808DF09F92BB.png" width="20" height="20" alt="👨‍💻">", "<img class="emoji" src="//telegram.org/img/emoji/40/F09F9180.png" width="20" height="20" alt="👀">", "<img class="emoji" src="//telegram.org/img/emoji/40/F09F8E83.png" width="20" height="20" alt="🎃">", "<img class="emoji" src="//telegram.org/img/emoji/40/F09F9988.png" width="20" height="20" alt="🙈">", "<img class="emoji" src="//telegram.org/img/emoji/40/F09F9887.png" width="20" height="20" alt="😇">", "<img class="emoji" src="//telegram.org/img/emoji/40/F09F98A8.png" width="20" height="20" alt="😨">", "<img class="emoji" src="//telegram.org/img/emoji/40/F09FA49D.png" width="20" height="20" alt="🤝">", "<img class="emoji" src="//telegram.org/img/emoji/40/E29C8D.png" width="20" height="20" alt="✍">", "<img class="emoji" src="//telegram.org/img/emoji/40/F09FA497.png" width="20" height="20" alt="🤗">", "<img class="emoji" src="//telegram.org/img/emoji/40/F09FABA1.png" width="20" height="20" alt="🫡">", "<img class="emoji" src="//telegram.org/img/emoji/40/F09F8E85.png" width="20" height="20" alt="🎅">", "<img class="emoji" src="//telegram.org/img/emoji/40/F09F8E84.png" width="20" height="20" alt="🎄">", "<img class="emoji" src="//telegram.org/img/emoji/40/E29883.png" width="20" height="20" alt="☃">", "<img class="emoji" src="//telegram.org/img/emoji/40/F09F9285.png" width="20" height="20" alt="💅">", "<img class="emoji" src="//telegram.org/img/emoji/40/F09FA4AA.png" width="20" height="20" alt="🤪">", "<img class="emoji" src="//telegram.org/img/emoji/40/F09F97BF.png" width="20" height="20" alt="🗿">", "<img class="emoji" src="//telegram.org/img/emoji/40/F09F8692.png" width="20" height="20" alt="🆒">", "<img class="emoji" src="//telegram.org/img/emoji/40/F09F9298.png" width="20" height="20" alt="💘">", "<img class="emoji" src="//telegram.org/img/emoji/40/F09F9989.png" width="20" height="20" alt="🙉">", "<img class="emoji" src="//telegram.org/img/emoji/40/F09FA684.png" width="20" height="20" alt="🦄">", "<img class="emoji" src="//telegram.org/img/emoji/40/F09F9898.png" width="20" height="20" alt="😘">", "<img class="emoji" src="//telegram.org/img/emoji/40/F09F928A.png" width="20" height="20" alt="💊">", "<img class="emoji" src="//telegram.org/img/emoji/40/F09F998A.png" width="20" height="20" alt="🙊">", "<img class="emoji" src="//telegram.org/img/emoji/40/F09F988E.png" width="20" height="20" alt="😎">", "<img class="emoji" src="//telegram.org/img/emoji/40/F09F91BE.png" width="20" height="20" alt="👾">", "<img class="emoji" src="//telegram.org/img/emoji/40/F09FA4B7E2808DE29982.png" width="20" height="20" alt="🤷‍♂">", "<img class="emoji" src="//telegram.org/img/emoji/40/F09FA4B7.png" width="20" height="20" alt="🤷">", "<img class="emoji" src="//telegram.org/img/emoji/40/F09FA4B7E2808DE29980.png" width="20" height="20" alt="🤷‍♀">", "<img class="emoji" src="//telegram.org/img/emoji/40/F09F98A1.png" width="20" height="20" alt="😡">" |

#### ReactionTypeCustomEmoji

    ReactionTypeCustomEmoji(type: String, custom_emoji_id: String)

<p>The reaction is based on a custom emoji.</p>

| name | type | required | description |
|---|---|---|---|
| type | String | true | Type of the reaction, always “custom_emoji” |
| custom_emoji_id | String | true | Custom emoji identifier |

#### ReactionCount

    ReactionCount(type: ReactionType, total_count: Integer)

<p>Represents a reaction added to a message along with the number of times it was added.</p>

| name | type | required | description |
|---|---|---|---|
| type | ReactionType | true | Type of the reaction |
| total_count | Integer | true | Number of times the reaction was added |

#### MessageReactionUpdated

    MessageReactionUpdated(chat: Chat, message_id: Integer, user: User, actor_chat: Chat, date: Integer, old_reaction: List<ReactionType>, new_reaction: List<ReactionType>)

<p>This object represents a change of a reaction on a message performed by a user.</p>

| name | type | required | description |
|---|---|---|---|
| chat | Chat | true | The chat containing the message the user reacted to |
| message_id | Integer | true | Unique identifier of the message inside the chat |
| user | User | false | <em>Optional</em>. The user that changed the reaction, if the user isn't anonymous |
| actor_chat | Chat | false | <em>Optional</em>. The chat on behalf of which the reaction was changed, if the user is anonymous |
| date | Integer | true | Date of the change in Unix time |
| old_reaction | List<ReactionType> | true | Previous list of reaction types that were set by the user |
| new_reaction | List<ReactionType> | true | New list of reaction types that have been set by the user |

#### MessageReactionCountUpdated

    MessageReactionCountUpdated(chat: Chat, message_id: Integer, date: Integer, reactions: List<ReactionCount>)

<p>This object represents reaction changes on a message with anonymous reactions.</p>

| name | type | required | description |
|---|---|---|---|
| chat | Chat | true | The chat containing the message |
| message_id | Integer | true | Unique message identifier inside the chat |
| date | Integer | true | Date of the change in Unix time |
| reactions | List<ReactionCount> | true | List of reactions that are present on the message |

#### ForumTopic

    ForumTopic(message_thread_id: Integer, name: String, icon_color: Integer, icon_custom_emoji_id: String)

<p>This object represents a forum topic.</p>

| name | type | required | description |
|---|---|---|---|
| message_thread_id | Integer | true | Unique identifier of the forum topic |
| name | String | true | Name of the topic |
| icon_color | Integer | true | Color of the topic icon in RGB format |
| icon_custom_emoji_id | String | false | <em>Optional</em>. Unique identifier of the custom emoji shown as the topic icon |

#### BotCommand

    BotCommand(command: String, description: String)

<p>This object represents a bot command.</p>

| name | type | required | description |
|---|---|---|---|
| command | String | true | Text of the command; 1-32 characters. Can contain only lowercase English letters, digits and underscores. |
| description | String | true | Description of the command; 1-256 characters. |

#### BotCommandScopeDefault

    BotCommandScopeDefault(type: String)

<p>Represents the default <a href="#botcommandscope">scope</a> of bot commands. Default commands are used if no commands with a <a href="#determining-list-of-commands">narrower scope</a> are specified for the user.</p>

| name | type | required | description |
|---|---|---|---|
| type | String | true | Scope type, must be <em>default</em> |

#### BotCommandScopeAllPrivateChats

    BotCommandScopeAllPrivateChats(type: String)

<p>Represents the <a href="#botcommandscope">scope</a> of bot commands, covering all private chats.</p>

| name | type | required | description |
|---|---|---|---|
| type | String | true | Scope type, must be <em>all_private_chats</em> |

#### BotCommandScopeAllGroupChats

    BotCommandScopeAllGroupChats(type: String)

<p>Represents the <a href="#botcommandscope">scope</a> of bot commands, covering all group and supergroup chats.</p>

| name | type | required | description |
|---|---|---|---|
| type | String | true | Scope type, must be <em>all_group_chats</em> |

#### BotCommandScopeAllChatAdministrators

    BotCommandScopeAllChatAdministrators(type: String)

<p>Represents the <a href="#botcommandscope">scope</a> of bot commands, covering all group and supergroup chat administrators.</p>

| name | type | required | description |
|---|---|---|---|
| type | String | true | Scope type, must be <em>all_chat_administrators</em> |

#### BotCommandScopeChat

    BotCommandScopeChat(type: String, chat_id: IntegerOrString)

<p>Represents the <a href="#botcommandscope">scope</a> of bot commands, covering a specific chat.</p>

| name | type | required | description |
|---|---|---|---|
| type | String | true | Scope type, must be <em>chat</em> |
| chat_id | IntegerOrString | true | Unique identifier for the target chat or username of the target supergroup (in the format <code>@supergroupusername</code>) |

#### BotCommandScopeChatAdministrators

    BotCommandScopeChatAdministrators(type: String, chat_id: IntegerOrString)

<p>Represents the <a href="#botcommandscope">scope</a> of bot commands, covering all administrators of a specific group or supergroup chat.</p>

| name | type | required | description |
|---|---|---|---|
| type | String | true | Scope type, must be <em>chat_administrators</em> |
| chat_id | IntegerOrString | true | Unique identifier for the target chat or username of the target supergroup (in the format <code>@supergroupusername</code>) |

#### BotCommandScopeChatMember

    BotCommandScopeChatMember(type: String, chat_id: IntegerOrString, user_id: Integer)

<p>Represents the <a href="#botcommandscope">scope</a> of bot commands, covering a specific member of a group or supergroup chat.</p>

| name | type | required | description |
|---|---|---|---|
| type | String | true | Scope type, must be <em>chat_member</em> |
| chat_id | IntegerOrString | true | Unique identifier for the target chat or username of the target supergroup (in the format <code>@supergroupusername</code>) |
| user_id | Integer | true | Unique identifier of the target user |

#### BotName

    BotName(name: String)

<p>This object represents the bot's name.</p>

| name | type | required | description |
|---|---|---|---|
| name | String | true | The bot's name |

#### BotDescription

    BotDescription(description: String)

<p>This object represents the bot's description.</p>

| name | type | required | description |
|---|---|---|---|
| description | String | true | The bot's description |

#### BotShortDescription

    BotShortDescription(short_description: String)

<p>This object represents the bot's short description.</p>

| name | type | required | description |
|---|---|---|---|
| short_description | String | true | The bot's short description |

#### MenuButtonCommands

    MenuButtonCommands(type: String)

<p>Represents a menu button, which opens the bot's list of commands.</p>

| name | type | required | description |
|---|---|---|---|
| type | String | true | Type of the button, must be <em>commands</em> |

#### MenuButtonWebApp

    MenuButtonWebApp(type: String, text: String, web_app: WebAppInfo)

<p>Represents a menu button, which launches a <a href="/bots/webapps">Web App</a>.</p>

| name | type | required | description |
|---|---|---|---|
| type | String | true | Type of the button, must be <em>web_app</em> |
| text | String | true | Text on the button |
| web_app | WebAppInfo | true | Description of the Web App that will be launched when the user presses the button. The Web App will be able to send an arbitrary message on behalf of the user using the method <a href="#answerwebappquery">answerWebAppQuery</a>. |

#### MenuButtonDefault

    MenuButtonDefault(type: String)

<p>Describes that no specific value for the menu button was set.</p>

| name | type | required | description |
|---|---|---|---|
| type | String | true | Type of the button, must be <em>default</em> |

#### ChatBoostSourcePremium

    ChatBoostSourcePremium(source: String, user: User)

<p>The boost was obtained by subscribing to Telegram Premium or by gifting a Telegram Premium subscription to another user.</p>

| name | type | required | description |
|---|---|---|---|
| source | String | true | Source of the boost, always “premium” |
| user | User | true | User that boosted the chat |

#### ChatBoostSourceGiftCode

    ChatBoostSourceGiftCode(source: String, user: User)

<p>The boost was obtained by the creation of Telegram Premium gift codes to boost a chat. Each such code boosts the chat 4 times for the duration of the corresponding Telegram Premium subscription.</p>

| name | type | required | description |
|---|---|---|---|
| source | String | true | Source of the boost, always “gift_code” |
| user | User | true | User for which the gift code was created |

#### ChatBoostSourceGiveaway

    ChatBoostSourceGiveaway(source: String, giveaway_message_id: Integer, user: User, is_unclaimed: Boolean)

<p>The boost was obtained by the creation of a Telegram Premium giveaway. This boosts the chat 4 times for the duration of the corresponding Telegram Premium subscription.</p>

| name | type | required | description |
|---|---|---|---|
| source | String | true | Source of the boost, always “giveaway” |
| giveaway_message_id | Integer | true | Identifier of a message in the chat with the giveaway; the message could have been deleted already. May be 0 if the message isn't sent yet. |
| user | User | false | <em>Optional</em>. User that won the prize in the giveaway if any |
| is_unclaimed | Boolean | false | <em>Optional</em>. True, if the giveaway was completed, but there was no user to win the prize |

#### ChatBoost

    ChatBoost(boost_id: String, add_date: Integer, expiration_date: Integer, source: ChatBoostSource)

<p>This object contains information about a chat boost.</p>

| name | type | required | description |
|---|---|---|---|
| boost_id | String | true | Unique identifier of the boost |
| add_date | Integer | true | Point in time (Unix timestamp) when the chat was boosted |
| expiration_date | Integer | true | Point in time (Unix timestamp) when the boost will automatically expire, unless the booster's Telegram Premium subscription is prolonged |
| source | ChatBoostSource | true | Source of the added boost |

#### ChatBoostUpdated

    ChatBoostUpdated(chat: Chat, boost: ChatBoost)

<p>This object represents a boost added to a chat or changed.</p>

| name | type | required | description |
|---|---|---|---|
| chat | Chat | true | Chat which was boosted |
| boost | ChatBoost | true | Information about the chat boost |

#### ChatBoostRemoved

    ChatBoostRemoved(chat: Chat, boost_id: String, remove_date: Integer, source: ChatBoostSource)

<p>This object represents a boost removed from a chat.</p>

| name | type | required | description |
|---|---|---|---|
| chat | Chat | true | Chat which was boosted |
| boost_id | String | true | Unique identifier of the boost |
| remove_date | Integer | true | Point in time (Unix timestamp) when the boost was removed |
| source | ChatBoostSource | true | Source of the removed boost |

#### UserChatBoosts

    UserChatBoosts(boosts: List<ChatBoost>)

<p>This object represents a list of boosts added to a chat by a user.</p>

| name | type | required | description |
|---|---|---|---|
| boosts | List<ChatBoost> | true | The list of boosts added to the chat by the user |

#### BusinessConnection

    BusinessConnection(id: String, user: User, user_chat_id: Integer, date: Integer, can_reply: Boolean, is_enabled: Boolean)

<p>Describes the connection of the bot with a business account.</p>

| name | type | required | description |
|---|---|---|---|
| id | String | true | Unique identifier of the business connection |
| user | User | true | Business account user that created the business connection |
| user_chat_id | Integer | true | Identifier of a private chat with the user who created the business connection. This number may have more than 32 significant bits and some programming languages may have difficulty/silent defects in interpreting it. But it has at most 52 significant bits, so a 64-bit integer or double-precision float type are safe for storing this identifier. |
| date | Integer | true | Date the connection was established in Unix time |
| can_reply | Boolean | true | True, if the bot can act on behalf of the business account in chats that were active in the last 24 hours |
| is_enabled | Boolean | true | True, if the connection is active |

#### BusinessMessagesDeleted

    BusinessMessagesDeleted(business_connection_id: String, chat: Chat, message_ids: List<Integer>)

<p>This object is received when messages are deleted from a connected business account.</p>

| name | type | required | description |
|---|---|---|---|
| business_connection_id | String | true | Unique identifier of the business connection |
| chat | Chat | true | Information about a chat in the business account. The bot may not have access to the chat or the corresponding user. |
| message_ids | List<Integer> | true | The list of identifiers of deleted messages in the chat of the business account |

#### ResponseParameters

    ResponseParameters(migrate_to_chat_id: Integer, retry_after: Integer)

<p>Describes why a request was unsuccessful.</p>

| name | type | required | description |
|---|---|---|---|
| migrate_to_chat_id | Integer | false | <em>Optional</em>. The group has been migrated to a supergroup with the specified identifier. This number may have more than 32 significant bits and some programming languages may have difficulty/silent defects in interpreting it. But it has at most 52 significant bits, so a signed 64-bit integer or double-precision float type are safe for storing this identifier. |
| retry_after | Integer | false | <em>Optional</em>. In case of exceeding flood control, the number of seconds left to wait before the request can be repeated |

#### InputMediaPhoto

    InputMediaPhoto(type: String, media: String, caption: String, parse_mode: ParseMode, caption_entities: List<MessageEntity>, show_caption_above_media: Boolean, has_spoiler: Boolean)

<p>Represents a photo to be sent.</p>

| name | type | required | description |
|---|---|---|---|
| type | String | true | Type of the result, must be <em>photo</em> |
| media | String | true | File to send. Pass a file_id to send a file that exists on the Telegram servers (recommended), pass an HTTP URL for Telegram to get a file from the Internet, or pass “attach://&lt;file_attach_name&gt;” to upload a new one using multipart/form-data under &lt;file_attach_name&gt; name. <a href="#sending-files">More information on Sending Files »</a> |
| caption | String | false | <em>Optional</em>. Caption of the photo to be sent, 0-1024 characters after entities parsing |
| parse_mode | ParseMode | false | <em>Optional</em>. Mode for parsing entities in the photo caption. See <a href="#formatting-options">formatting options</a> for more details. |
| caption_entities | List<MessageEntity> | false | <em>Optional</em>. List of special entities that appear in the caption, which can be specified instead of <em>parse_mode</em> |
| show_caption_above_media | Boolean | false | <em>Optional</em>. Pass <em>True</em>, if the caption must be shown above the message media |
| has_spoiler | Boolean | false | <em>Optional</em>. Pass <em>True</em> if the photo needs to be covered with a spoiler animation |

#### InputMediaVideo

    InputMediaVideo(type: String, media: String, thumbnail: InputFileOrString, caption: String, parse_mode: ParseMode, caption_entities: List<MessageEntity>, show_caption_above_media: Boolean, width: Integer, height: Integer, duration: Integer, supports_streaming: Boolean, has_spoiler: Boolean)

<p>Represents a video to be sent.</p>

| name | type | required | description |
|---|---|---|---|
| type | String | true | Type of the result, must be <em>video</em> |
| media | String | true | File to send. Pass a file_id to send a file that exists on the Telegram servers (recommended), pass an HTTP URL for Telegram to get a file from the Internet, or pass “attach://&lt;file_attach_name&gt;” to upload a new one using multipart/form-data under &lt;file_attach_name&gt; name. <a href="#sending-files">More information on Sending Files »</a> |
| thumbnail | InputFileOrString | false | <em>Optional</em>. Thumbnail of the file sent; can be ignored if thumbnail generation for the file is supported server-side. The thumbnail should be in JPEG format and less than 200 kB in size. A thumbnail's width and height should not exceed 320. Ignored if the file is not uploaded using multipart/form-data. Thumbnails can't be reused and can be only uploaded as a new file, so you can pass “attach://&lt;file_attach_name&gt;” if the thumbnail was uploaded using multipart/form-data under &lt;file_attach_name&gt;. <a href="#sending-files">More information on Sending Files »</a> |
| caption | String | false | <em>Optional</em>. Caption of the video to be sent, 0-1024 characters after entities parsing |
| parse_mode | ParseMode | false | <em>Optional</em>. Mode for parsing entities in the video caption. See <a href="#formatting-options">formatting options</a> for more details. |
| caption_entities | List<MessageEntity> | false | <em>Optional</em>. List of special entities that appear in the caption, which can be specified instead of <em>parse_mode</em> |
| show_caption_above_media | Boolean | false | <em>Optional</em>. Pass <em>True</em>, if the caption must be shown above the message media |
| width | Integer | false | <em>Optional</em>. Video width |
| height | Integer | false | <em>Optional</em>. Video height |
| duration | Integer | false | <em>Optional</em>. Video duration in seconds |
| supports_streaming | Boolean | false | <em>Optional</em>. Pass <em>True</em> if the uploaded video is suitable for streaming |
| has_spoiler | Boolean | false | <em>Optional</em>. Pass <em>True</em> if the video needs to be covered with a spoiler animation |

#### InputMediaAnimation

    InputMediaAnimation(type: String, media: String, thumbnail: InputFileOrString, caption: String, parse_mode: ParseMode, caption_entities: List<MessageEntity>, show_caption_above_media: Boolean, width: Integer, height: Integer, duration: Integer, has_spoiler: Boolean)

<p>Represents an animation file (GIF or H.264/MPEG-4 AVC video without sound) to be sent.</p>

| name | type | required | description |
|---|---|---|---|
| type | String | true | Type of the result, must be <em>animation</em> |
| media | String | true | File to send. Pass a file_id to send a file that exists on the Telegram servers (recommended), pass an HTTP URL for Telegram to get a file from the Internet, or pass “attach://&lt;file_attach_name&gt;” to upload a new one using multipart/form-data under &lt;file_attach_name&gt; name. <a href="#sending-files">More information on Sending Files »</a> |
| thumbnail | InputFileOrString | false | <em>Optional</em>. Thumbnail of the file sent; can be ignored if thumbnail generation for the file is supported server-side. The thumbnail should be in JPEG format and less than 200 kB in size. A thumbnail's width and height should not exceed 320. Ignored if the file is not uploaded using multipart/form-data. Thumbnails can't be reused and can be only uploaded as a new file, so you can pass “attach://&lt;file_attach_name&gt;” if the thumbnail was uploaded using multipart/form-data under &lt;file_attach_name&gt;. <a href="#sending-files">More information on Sending Files »</a> |
| caption | String | false | <em>Optional</em>. Caption of the animation to be sent, 0-1024 characters after entities parsing |
| parse_mode | ParseMode | false | <em>Optional</em>. Mode for parsing entities in the animation caption. See <a href="#formatting-options">formatting options</a> for more details. |
| caption_entities | List<MessageEntity> | false | <em>Optional</em>. List of special entities that appear in the caption, which can be specified instead of <em>parse_mode</em> |
| show_caption_above_media | Boolean | false | <em>Optional</em>. Pass <em>True</em>, if the caption must be shown above the message media |
| width | Integer | false | <em>Optional</em>. Animation width |
| height | Integer | false | <em>Optional</em>. Animation height |
| duration | Integer | false | <em>Optional</em>. Animation duration in seconds |
| has_spoiler | Boolean | false | <em>Optional</em>. Pass <em>True</em> if the animation needs to be covered with a spoiler animation |

#### InputMediaAudio

    InputMediaAudio(type: String, media: String, thumbnail: InputFileOrString, caption: String, parse_mode: ParseMode, caption_entities: List<MessageEntity>, duration: Integer, performer: String, title: String)

<p>Represents an audio file to be treated as music to be sent.</p>

| name | type | required | description |
|---|---|---|---|
| type | String | true | Type of the result, must be <em>audio</em> |
| media | String | true | File to send. Pass a file_id to send a file that exists on the Telegram servers (recommended), pass an HTTP URL for Telegram to get a file from the Internet, or pass “attach://&lt;file_attach_name&gt;” to upload a new one using multipart/form-data under &lt;file_attach_name&gt; name. <a href="#sending-files">More information on Sending Files »</a> |
| thumbnail | InputFileOrString | false | <em>Optional</em>. Thumbnail of the file sent; can be ignored if thumbnail generation for the file is supported server-side. The thumbnail should be in JPEG format and less than 200 kB in size. A thumbnail's width and height should not exceed 320. Ignored if the file is not uploaded using multipart/form-data. Thumbnails can't be reused and can be only uploaded as a new file, so you can pass “attach://&lt;file_attach_name&gt;” if the thumbnail was uploaded using multipart/form-data under &lt;file_attach_name&gt;. <a href="#sending-files">More information on Sending Files »</a> |
| caption | String | false | <em>Optional</em>. Caption of the audio to be sent, 0-1024 characters after entities parsing |
| parse_mode | ParseMode | false | <em>Optional</em>. Mode for parsing entities in the audio caption. See <a href="#formatting-options">formatting options</a> for more details. |
| caption_entities | List<MessageEntity> | false | <em>Optional</em>. List of special entities that appear in the caption, which can be specified instead of <em>parse_mode</em> |
| duration | Integer | false | <em>Optional</em>. Duration of the audio in seconds |
| performer | String | false | <em>Optional</em>. Performer of the audio |
| title | String | false | <em>Optional</em>. Title of the audio |

#### InputMediaDocument

    InputMediaDocument(type: String, media: String, thumbnail: InputFileOrString, caption: String, parse_mode: ParseMode, caption_entities: List<MessageEntity>, disable_content_type_detection: Boolean)

<p>Represents a general file to be sent.</p>

| name | type | required | description |
|---|---|---|---|
| type | String | true | Type of the result, must be <em>document</em> |
| media | String | true | File to send. Pass a file_id to send a file that exists on the Telegram servers (recommended), pass an HTTP URL for Telegram to get a file from the Internet, or pass “attach://&lt;file_attach_name&gt;” to upload a new one using multipart/form-data under &lt;file_attach_name&gt; name. <a href="#sending-files">More information on Sending Files »</a> |
| thumbnail | InputFileOrString | false | <em>Optional</em>. Thumbnail of the file sent; can be ignored if thumbnail generation for the file is supported server-side. The thumbnail should be in JPEG format and less than 200 kB in size. A thumbnail's width and height should not exceed 320. Ignored if the file is not uploaded using multipart/form-data. Thumbnails can't be reused and can be only uploaded as a new file, so you can pass “attach://&lt;file_attach_name&gt;” if the thumbnail was uploaded using multipart/form-data under &lt;file_attach_name&gt;. <a href="#sending-files">More information on Sending Files »</a> |
| caption | String | false | <em>Optional</em>. Caption of the document to be sent, 0-1024 characters after entities parsing |
| parse_mode | ParseMode | false | <em>Optional</em>. Mode for parsing entities in the document caption. See <a href="#formatting-options">formatting options</a> for more details. |
| caption_entities | List<MessageEntity> | false | <em>Optional</em>. List of special entities that appear in the caption, which can be specified instead of <em>parse_mode</em> |
| disable_content_type_detection | Boolean | false | <em>Optional</em>. Disables automatic server-side content type detection for files uploaded using multipart/form-data. Always <em>True</em>, if the document is sent as part of an album. |



## Available methods

### Methods
#### logOut

    logOut()

<p>Use this method to log out from the cloud Bot API server before launching the bot locally. You <strong>must</strong> log out the bot before running it locally, otherwise there is no guarantee that the bot will receive updates. After a successful call, you can immediately log in on a local server, but will not be able to log in back to the cloud Bot API server for 10 minutes. Returns <em>True</em> on success. Requires no parameters.</p>

#### close

    close()

<p>Use this method to close the bot instance before moving it from one local server to another. You need to delete the webhook before calling this method to ensure that the bot isn't launched again after server restart. The method will return error 429 in the first 10 minutes after the bot is launched. Returns <em>True</em> on success. Requires no parameters.</p>

#### sendMessage

    sendMessage(business_connection_id: String, chat_id: IntegerOrString, message_thread_id: Integer, text: String, parse_mode: ParseMode, entities: List<MessageEntity>, link_preview_options: LinkPreviewOptions, disable_notification: Boolean, protect_content: Boolean, message_effect_id: String, reply_parameters: ReplyParameters, reply_markup: KeyboardOption)

<p>Use this method to send text messages. On success, the sent <a href="#message">Message</a> is returned.</p>

| name | type | required | description |
|---|---|---|---|
| business_connection_id | String | false | Unique identifier of the business connection on behalf of which the message will be sent |
| chat_id | IntegerOrString | true | Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>) |
| message_thread_id | Integer | false | Unique identifier for the target message thread (topic) of the forum; for forum supergroups only |
| text | String | true | Text of the message to be sent, 1-4096 characters after entities parsing |
| parse_mode | ParseMode | false | Mode for parsing entities in the message text. See <a href="#formatting-options">formatting options</a> for more details. |
| entities | List<MessageEntity> | false | A JSON-serialized list of special entities that appear in message text, which can be specified instead of <em>parse_mode</em> |
| link_preview_options | LinkPreviewOptions | false | Link preview generation options for the message |
| disable_notification | Boolean | false | Sends the message <a href="https://telegram.org/blog/channels-2-0#silent-messages">silently</a>. Users will receive a notification with no sound. |
| protect_content | Boolean | false | Protects the contents of the sent message from forwarding and saving |
| message_effect_id | String | false | Unique identifier of the message effect to be added to the message; for private chats only |
| reply_parameters | ReplyParameters | false | Description of the message to reply to |
| reply_markup | KeyboardOption | false | Additional interface options. A JSON-serialized object for an <a href="/bots/features#inline-keyboards">inline keyboard</a>, <a href="/bots/features#keyboards">custom reply keyboard</a>, instructions to remove a reply keyboard or to force a reply from the user |

#### forwardMessage

    forwardMessage(chat_id: IntegerOrString, message_thread_id: Integer, from_chat_id: IntegerOrString, disable_notification: Boolean, protect_content: Boolean, message_id: Integer)

<p>Use this method to forward messages of any kind. Service messages and messages with protected content can't be forwarded. On success, the sent <a href="#message">Message</a> is returned.</p>

| name | type | required | description |
|---|---|---|---|
| chat_id | IntegerOrString | true | Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>) |
| message_thread_id | Integer | false | Unique identifier for the target message thread (topic) of the forum; for forum supergroups only |
| from_chat_id | IntegerOrString | true | Unique identifier for the chat where the original message was sent (or channel username in the format <code>@channelusername</code>) |
| disable_notification | Boolean | false | Sends the message <a href="https://telegram.org/blog/channels-2-0#silent-messages">silently</a>. Users will receive a notification with no sound. |
| protect_content | Boolean | false | Protects the contents of the forwarded message from forwarding and saving |
| message_id | Integer | true | Message identifier in the chat specified in <em>from_chat_id</em> |

#### forwardMessages

    forwardMessages(chat_id: IntegerOrString, message_thread_id: Integer, from_chat_id: IntegerOrString, message_ids: List<Integer>, disable_notification: Boolean, protect_content: Boolean)

<p>Use this method to forward multiple messages of any kind. If some of the specified messages can't be found or forwarded, they are skipped. Service messages and messages with protected content can't be forwarded. Album grouping is kept for forwarded messages. On success, an array of <a href="#messageid">MessageId</a> of the sent messages is returned.</p>

| name | type | required | description |
|---|---|---|---|
| chat_id | IntegerOrString | true | Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>) |
| message_thread_id | Integer | false | Unique identifier for the target message thread (topic) of the forum; for forum supergroups only |
| from_chat_id | IntegerOrString | true | Unique identifier for the chat where the original messages were sent (or channel username in the format <code>@channelusername</code>) |
| message_ids | List<Integer> | true | A JSON-serialized list of 1-100 identifiers of messages in the chat <em>from_chat_id</em> to forward. The identifiers must be specified in a strictly increasing order. |
| disable_notification | Boolean | false | Sends the messages <a href="https://telegram.org/blog/channels-2-0#silent-messages">silently</a>. Users will receive a notification with no sound. |
| protect_content | Boolean | false | Protects the contents of the forwarded messages from forwarding and saving |

#### copyMessage

    copyMessage(chat_id: IntegerOrString, message_thread_id: Integer, from_chat_id: IntegerOrString, message_id: Integer, caption: String, parse_mode: ParseMode, caption_entities: List<MessageEntity>, show_caption_above_media: Boolean, disable_notification: Boolean, protect_content: Boolean, reply_parameters: ReplyParameters, reply_markup: KeyboardOption)

<p>Use this method to copy messages of any kind. Service messages, giveaway messages, giveaway winners messages, and invoice messages can't be copied. A quiz <a href="#poll">poll</a> can be copied only if the value of the field <em>correct_option_id</em> is known to the bot. The method is analogous to the method <a href="#forwardmessage">forwardMessage</a>, but the copied message doesn't have a link to the original message. Returns the <a href="#messageid">MessageId</a> of the sent message on success.</p>

| name | type | required | description |
|---|---|---|---|
| chat_id | IntegerOrString | true | Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>) |
| message_thread_id | Integer | false | Unique identifier for the target message thread (topic) of the forum; for forum supergroups only |
| from_chat_id | IntegerOrString | true | Unique identifier for the chat where the original message was sent (or channel username in the format <code>@channelusername</code>) |
| message_id | Integer | true | Message identifier in the chat specified in <em>from_chat_id</em> |
| caption | String | false | New caption for media, 0-1024 characters after entities parsing. If not specified, the original caption is kept |
| parse_mode | ParseMode | false | Mode for parsing entities in the new caption. See <a href="#formatting-options">formatting options</a> for more details. |
| caption_entities | List<MessageEntity> | false | A JSON-serialized list of special entities that appear in the new caption, which can be specified instead of <em>parse_mode</em> |
| show_caption_above_media | Boolean | false | Pass <em>True</em>, if the caption must be shown above the message media. Ignored if a new caption isn't specified. |
| disable_notification | Boolean | false | Sends the message <a href="https://telegram.org/blog/channels-2-0#silent-messages">silently</a>. Users will receive a notification with no sound. |
| protect_content | Boolean | false | Protects the contents of the sent message from forwarding and saving |
| reply_parameters | ReplyParameters | false | Description of the message to reply to |
| reply_markup | KeyboardOption | false | Additional interface options. A JSON-serialized object for an <a href="/bots/features#inline-keyboards">inline keyboard</a>, <a href="/bots/features#keyboards">custom reply keyboard</a>, instructions to remove a reply keyboard or to force a reply from the user |

#### copyMessages

    copyMessages(chat_id: IntegerOrString, message_thread_id: Integer, from_chat_id: IntegerOrString, message_ids: List<Integer>, disable_notification: Boolean, protect_content: Boolean, remove_caption: Boolean)

<p>Use this method to copy messages of any kind. If some of the specified messages can't be found or copied, they are skipped. Service messages, giveaway messages, giveaway winners messages, and invoice messages can't be copied. A quiz <a href="#poll">poll</a> can be copied only if the value of the field <em>correct_option_id</em> is known to the bot. The method is analogous to the method <a href="#forwardmessages">forwardMessages</a>, but the copied messages don't have a link to the original message. Album grouping is kept for copied messages. On success, an array of <a href="#messageid">MessageId</a> of the sent messages is returned.</p>

| name | type | required | description |
|---|---|---|---|
| chat_id | IntegerOrString | true | Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>) |
| message_thread_id | Integer | false | Unique identifier for the target message thread (topic) of the forum; for forum supergroups only |
| from_chat_id | IntegerOrString | true | Unique identifier for the chat where the original messages were sent (or channel username in the format <code>@channelusername</code>) |
| message_ids | List<Integer> | true | A JSON-serialized list of 1-100 identifiers of messages in the chat <em>from_chat_id</em> to copy. The identifiers must be specified in a strictly increasing order. |
| disable_notification | Boolean | false | Sends the messages <a href="https://telegram.org/blog/channels-2-0#silent-messages">silently</a>. Users will receive a notification with no sound. |
| protect_content | Boolean | false | Protects the contents of the sent messages from forwarding and saving |
| remove_caption | Boolean | false | Pass <em>True</em> to copy the messages without their captions |

#### sendPhoto

    sendPhoto(business_connection_id: String, chat_id: IntegerOrString, message_thread_id: Integer, photo: InputFileOrString, caption: String, parse_mode: ParseMode, caption_entities: List<MessageEntity>, show_caption_above_media: Boolean, has_spoiler: Boolean, disable_notification: Boolean, protect_content: Boolean, message_effect_id: String, reply_parameters: ReplyParameters, reply_markup: KeyboardOption)

<p>Use this method to send photos. On success, the sent <a href="#message">Message</a> is returned.</p>

| name | type | required | description |
|---|---|---|---|
| business_connection_id | String | false | Unique identifier of the business connection on behalf of which the message will be sent |
| chat_id | IntegerOrString | true | Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>) |
| message_thread_id | Integer | false | Unique identifier for the target message thread (topic) of the forum; for forum supergroups only |
| photo | InputFileOrString | true | Photo to send. Pass a file_id as String to send a photo that exists on the Telegram servers (recommended), pass an HTTP URL as a String for Telegram to get a photo from the Internet, or upload a new photo using multipart/form-data. The photo must be at most 10 MB in size. The photo's width and height must not exceed 10000 in total. Width and height ratio must be at most 20. <a href="#sending-files">More information on Sending Files »</a> |
| caption | String | false | Photo caption (may also be used when resending photos by <em>file_id</em>), 0-1024 characters after entities parsing |
| parse_mode | ParseMode | false | Mode for parsing entities in the photo caption. See <a href="#formatting-options">formatting options</a> for more details. |
| caption_entities | List<MessageEntity> | false | A JSON-serialized list of special entities that appear in the caption, which can be specified instead of <em>parse_mode</em> |
| show_caption_above_media | Boolean | false | Pass <em>True</em>, if the caption must be shown above the message media |
| has_spoiler | Boolean | false | Pass <em>True</em> if the photo needs to be covered with a spoiler animation |
| disable_notification | Boolean | false | Sends the message <a href="https://telegram.org/blog/channels-2-0#silent-messages">silently</a>. Users will receive a notification with no sound. |
| protect_content | Boolean | false | Protects the contents of the sent message from forwarding and saving |
| message_effect_id | String | false | Unique identifier of the message effect to be added to the message; for private chats only |
| reply_parameters | ReplyParameters | false | Description of the message to reply to |
| reply_markup | KeyboardOption | false | Additional interface options. A JSON-serialized object for an <a href="/bots/features#inline-keyboards">inline keyboard</a>, <a href="/bots/features#keyboards">custom reply keyboard</a>, instructions to remove a reply keyboard or to force a reply from the user |

#### sendAudio

    sendAudio(business_connection_id: String, chat_id: IntegerOrString, message_thread_id: Integer, audio: InputFileOrString, caption: String, parse_mode: ParseMode, caption_entities: List<MessageEntity>, duration: Integer, performer: String, title: String, thumbnail: InputFileOrString, disable_notification: Boolean, protect_content: Boolean, message_effect_id: String, reply_parameters: ReplyParameters, reply_markup: KeyboardOption)

<p>Use this method to send audio files, if you want Telegram clients to display them in the music player. Your audio must be in the .MP3 or .M4A format. On success, the sent <a href="#message">Message</a> is returned. Bots can currently send audio files of up to 50 MB in size, this limit may be changed in the future.</p><p>For sending voice messages, use the <a href="#sendvoice">sendVoice</a> method instead.</p>

| name | type | required | description |
|---|---|---|---|
| business_connection_id | String | false | Unique identifier of the business connection on behalf of which the message will be sent |
| chat_id | IntegerOrString | true | Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>) |
| message_thread_id | Integer | false | Unique identifier for the target message thread (topic) of the forum; for forum supergroups only |
| audio | InputFileOrString | true | Audio file to send. Pass a file_id as String to send an audio file that exists on the Telegram servers (recommended), pass an HTTP URL as a String for Telegram to get an audio file from the Internet, or upload a new one using multipart/form-data. <a href="#sending-files">More information on Sending Files »</a> |
| caption | String | false | Audio caption, 0-1024 characters after entities parsing |
| parse_mode | ParseMode | false | Mode for parsing entities in the audio caption. See <a href="#formatting-options">formatting options</a> for more details. |
| caption_entities | List<MessageEntity> | false | A JSON-serialized list of special entities that appear in the caption, which can be specified instead of <em>parse_mode</em> |
| duration | Integer | false | Duration of the audio in seconds |
| performer | String | false | Performer |
| title | String | false | Track name |
| thumbnail | InputFileOrString | false | Thumbnail of the file sent; can be ignored if thumbnail generation for the file is supported server-side. The thumbnail should be in JPEG format and less than 200 kB in size. A thumbnail's width and height should not exceed 320. Ignored if the file is not uploaded using multipart/form-data. Thumbnails can't be reused and can be only uploaded as a new file, so you can pass “attach://&lt;file_attach_name&gt;” if the thumbnail was uploaded using multipart/form-data under &lt;file_attach_name&gt;. <a href="#sending-files">More information on Sending Files »</a> |
| disable_notification | Boolean | false | Sends the message <a href="https://telegram.org/blog/channels-2-0#silent-messages">silently</a>. Users will receive a notification with no sound. |
| protect_content | Boolean | false | Protects the contents of the sent message from forwarding and saving |
| message_effect_id | String | false | Unique identifier of the message effect to be added to the message; for private chats only |
| reply_parameters | ReplyParameters | false | Description of the message to reply to |
| reply_markup | KeyboardOption | false | Additional interface options. A JSON-serialized object for an <a href="/bots/features#inline-keyboards">inline keyboard</a>, <a href="/bots/features#keyboards">custom reply keyboard</a>, instructions to remove a reply keyboard or to force a reply from the user |

#### sendDocument

    sendDocument(business_connection_id: String, chat_id: IntegerOrString, message_thread_id: Integer, document: InputFileOrString, thumbnail: InputFileOrString, caption: String, parse_mode: ParseMode, caption_entities: List<MessageEntity>, disable_content_type_detection: Boolean, disable_notification: Boolean, protect_content: Boolean, message_effect_id: String, reply_parameters: ReplyParameters, reply_markup: KeyboardOption)

<p>Use this method to send general files. On success, the sent <a href="#message">Message</a> is returned. Bots can currently send files of any type of up to 50 MB in size, this limit may be changed in the future.</p>

| name | type | required | description |
|---|---|---|---|
| business_connection_id | String | false | Unique identifier of the business connection on behalf of which the message will be sent |
| chat_id | IntegerOrString | true | Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>) |
| message_thread_id | Integer | false | Unique identifier for the target message thread (topic) of the forum; for forum supergroups only |
| document | InputFileOrString | true | File to send. Pass a file_id as String to send a file that exists on the Telegram servers (recommended), pass an HTTP URL as a String for Telegram to get a file from the Internet, or upload a new one using multipart/form-data. <a href="#sending-files">More information on Sending Files »</a> |
| thumbnail | InputFileOrString | false | Thumbnail of the file sent; can be ignored if thumbnail generation for the file is supported server-side. The thumbnail should be in JPEG format and less than 200 kB in size. A thumbnail's width and height should not exceed 320. Ignored if the file is not uploaded using multipart/form-data. Thumbnails can't be reused and can be only uploaded as a new file, so you can pass “attach://&lt;file_attach_name&gt;” if the thumbnail was uploaded using multipart/form-data under &lt;file_attach_name&gt;. <a href="#sending-files">More information on Sending Files »</a> |
| caption | String | false | Document caption (may also be used when resending documents by <em>file_id</em>), 0-1024 characters after entities parsing |
| parse_mode | ParseMode | false | Mode for parsing entities in the document caption. See <a href="#formatting-options">formatting options</a> for more details. |
| caption_entities | List<MessageEntity> | false | A JSON-serialized list of special entities that appear in the caption, which can be specified instead of <em>parse_mode</em> |
| disable_content_type_detection | Boolean | false | Disables automatic server-side content type detection for files uploaded using multipart/form-data |
| disable_notification | Boolean | false | Sends the message <a href="https://telegram.org/blog/channels-2-0#silent-messages">silently</a>. Users will receive a notification with no sound. |
| protect_content | Boolean | false | Protects the contents of the sent message from forwarding and saving |
| message_effect_id | String | false | Unique identifier of the message effect to be added to the message; for private chats only |
| reply_parameters | ReplyParameters | false | Description of the message to reply to |
| reply_markup | KeyboardOption | false | Additional interface options. A JSON-serialized object for an <a href="/bots/features#inline-keyboards">inline keyboard</a>, <a href="/bots/features#keyboards">custom reply keyboard</a>, instructions to remove a reply keyboard or to force a reply from the user |

#### sendVideo

    sendVideo(business_connection_id: String, chat_id: IntegerOrString, message_thread_id: Integer, video: InputFileOrString, duration: Integer, width: Integer, height: Integer, thumbnail: InputFileOrString, caption: String, parse_mode: ParseMode, caption_entities: List<MessageEntity>, show_caption_above_media: Boolean, has_spoiler: Boolean, supports_streaming: Boolean, disable_notification: Boolean, protect_content: Boolean, message_effect_id: String, reply_parameters: ReplyParameters, reply_markup: KeyboardOption)

<p>Use this method to send video files, Telegram clients support MPEG4 videos (other formats may be sent as <a href="#document">Document</a>). On success, the sent <a href="#message">Message</a> is returned. Bots can currently send video files of up to 50 MB in size, this limit may be changed in the future.</p>

| name | type | required | description |
|---|---|---|---|
| business_connection_id | String | false | Unique identifier of the business connection on behalf of which the message will be sent |
| chat_id | IntegerOrString | true | Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>) |
| message_thread_id | Integer | false | Unique identifier for the target message thread (topic) of the forum; for forum supergroups only |
| video | InputFileOrString | true | Video to send. Pass a file_id as String to send a video that exists on the Telegram servers (recommended), pass an HTTP URL as a String for Telegram to get a video from the Internet, or upload a new video using multipart/form-data. <a href="#sending-files">More information on Sending Files »</a> |
| duration | Integer | false | Duration of sent video in seconds |
| width | Integer | false | Video width |
| height | Integer | false | Video height |
| thumbnail | InputFileOrString | false | Thumbnail of the file sent; can be ignored if thumbnail generation for the file is supported server-side. The thumbnail should be in JPEG format and less than 200 kB in size. A thumbnail's width and height should not exceed 320. Ignored if the file is not uploaded using multipart/form-data. Thumbnails can't be reused and can be only uploaded as a new file, so you can pass “attach://&lt;file_attach_name&gt;” if the thumbnail was uploaded using multipart/form-data under &lt;file_attach_name&gt;. <a href="#sending-files">More information on Sending Files »</a> |
| caption | String | false | Video caption (may also be used when resending videos by <em>file_id</em>), 0-1024 characters after entities parsing |
| parse_mode | ParseMode | false | Mode for parsing entities in the video caption. See <a href="#formatting-options">formatting options</a> for more details. |
| caption_entities | List<MessageEntity> | false | A JSON-serialized list of special entities that appear in the caption, which can be specified instead of <em>parse_mode</em> |
| show_caption_above_media | Boolean | false | Pass <em>True</em>, if the caption must be shown above the message media |
| has_spoiler | Boolean | false | Pass <em>True</em> if the video needs to be covered with a spoiler animation |
| supports_streaming | Boolean | false | Pass <em>True</em> if the uploaded video is suitable for streaming |
| disable_notification | Boolean | false | Sends the message <a href="https://telegram.org/blog/channels-2-0#silent-messages">silently</a>. Users will receive a notification with no sound. |
| protect_content | Boolean | false | Protects the contents of the sent message from forwarding and saving |
| message_effect_id | String | false | Unique identifier of the message effect to be added to the message; for private chats only |
| reply_parameters | ReplyParameters | false | Description of the message to reply to |
| reply_markup | KeyboardOption | false | Additional interface options. A JSON-serialized object for an <a href="/bots/features#inline-keyboards">inline keyboard</a>, <a href="/bots/features#keyboards">custom reply keyboard</a>, instructions to remove a reply keyboard or to force a reply from the user |

#### sendAnimation

    sendAnimation(business_connection_id: String, chat_id: IntegerOrString, message_thread_id: Integer, animation: InputFileOrString, duration: Integer, width: Integer, height: Integer, thumbnail: InputFileOrString, caption: String, parse_mode: ParseMode, caption_entities: List<MessageEntity>, show_caption_above_media: Boolean, has_spoiler: Boolean, disable_notification: Boolean, protect_content: Boolean, message_effect_id: String, reply_parameters: ReplyParameters, reply_markup: KeyboardOption)

<p>Use this method to send animation files (GIF or H.264/MPEG-4 AVC video without sound). On success, the sent <a href="#message">Message</a> is returned. Bots can currently send animation files of up to 50 MB in size, this limit may be changed in the future.</p>

| name | type | required | description |
|---|---|---|---|
| business_connection_id | String | false | Unique identifier of the business connection on behalf of which the message will be sent |
| chat_id | IntegerOrString | true | Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>) |
| message_thread_id | Integer | false | Unique identifier for the target message thread (topic) of the forum; for forum supergroups only |
| animation | InputFileOrString | true | Animation to send. Pass a file_id as String to send an animation that exists on the Telegram servers (recommended), pass an HTTP URL as a String for Telegram to get an animation from the Internet, or upload a new animation using multipart/form-data. <a href="#sending-files">More information on Sending Files »</a> |
| duration | Integer | false | Duration of sent animation in seconds |
| width | Integer | false | Animation width |
| height | Integer | false | Animation height |
| thumbnail | InputFileOrString | false | Thumbnail of the file sent; can be ignored if thumbnail generation for the file is supported server-side. The thumbnail should be in JPEG format and less than 200 kB in size. A thumbnail's width and height should not exceed 320. Ignored if the file is not uploaded using multipart/form-data. Thumbnails can't be reused and can be only uploaded as a new file, so you can pass “attach://&lt;file_attach_name&gt;” if the thumbnail was uploaded using multipart/form-data under &lt;file_attach_name&gt;. <a href="#sending-files">More information on Sending Files »</a> |
| caption | String | false | Animation caption (may also be used when resending animation by <em>file_id</em>), 0-1024 characters after entities parsing |
| parse_mode | ParseMode | false | Mode for parsing entities in the animation caption. See <a href="#formatting-options">formatting options</a> for more details. |
| caption_entities | List<MessageEntity> | false | A JSON-serialized list of special entities that appear in the caption, which can be specified instead of <em>parse_mode</em> |
| show_caption_above_media | Boolean | false | Pass <em>True</em>, if the caption must be shown above the message media |
| has_spoiler | Boolean | false | Pass <em>True</em> if the animation needs to be covered with a spoiler animation |
| disable_notification | Boolean | false | Sends the message <a href="https://telegram.org/blog/channels-2-0#silent-messages">silently</a>. Users will receive a notification with no sound. |
| protect_content | Boolean | false | Protects the contents of the sent message from forwarding and saving |
| message_effect_id | String | false | Unique identifier of the message effect to be added to the message; for private chats only |
| reply_parameters | ReplyParameters | false | Description of the message to reply to |
| reply_markup | KeyboardOption | false | Additional interface options. A JSON-serialized object for an <a href="/bots/features#inline-keyboards">inline keyboard</a>, <a href="/bots/features#keyboards">custom reply keyboard</a>, instructions to remove a reply keyboard or to force a reply from the user |

#### sendVoice

    sendVoice(business_connection_id: String, chat_id: IntegerOrString, message_thread_id: Integer, voice: InputFileOrString, caption: String, parse_mode: ParseMode, caption_entities: List<MessageEntity>, duration: Integer, disable_notification: Boolean, protect_content: Boolean, message_effect_id: String, reply_parameters: ReplyParameters, reply_markup: KeyboardOption)

<p>Use this method to send audio files, if you want Telegram clients to display the file as a playable voice message. For this to work, your audio must be in an .OGG file encoded with OPUS, or in .MP3 format, or in .M4A format (other formats may be sent as <a href="#audio">Audio</a> or <a href="#document">Document</a>). On success, the sent <a href="#message">Message</a> is returned. Bots can currently send voice messages of up to 50 MB in size, this limit may be changed in the future.</p>

| name | type | required | description |
|---|---|---|---|
| business_connection_id | String | false | Unique identifier of the business connection on behalf of which the message will be sent |
| chat_id | IntegerOrString | true | Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>) |
| message_thread_id | Integer | false | Unique identifier for the target message thread (topic) of the forum; for forum supergroups only |
| voice | InputFileOrString | true | Audio file to send. Pass a file_id as String to send a file that exists on the Telegram servers (recommended), pass an HTTP URL as a String for Telegram to get a file from the Internet, or upload a new one using multipart/form-data. <a href="#sending-files">More information on Sending Files »</a> |
| caption | String | false | Voice message caption, 0-1024 characters after entities parsing |
| parse_mode | ParseMode | false | Mode for parsing entities in the voice message caption. See <a href="#formatting-options">formatting options</a> for more details. |
| caption_entities | List<MessageEntity> | false | A JSON-serialized list of special entities that appear in the caption, which can be specified instead of <em>parse_mode</em> |
| duration | Integer | false | Duration of the voice message in seconds |
| disable_notification | Boolean | false | Sends the message <a href="https://telegram.org/blog/channels-2-0#silent-messages">silently</a>. Users will receive a notification with no sound. |
| protect_content | Boolean | false | Protects the contents of the sent message from forwarding and saving |
| message_effect_id | String | false | Unique identifier of the message effect to be added to the message; for private chats only |
| reply_parameters | ReplyParameters | false | Description of the message to reply to |
| reply_markup | KeyboardOption | false | Additional interface options. A JSON-serialized object for an <a href="/bots/features#inline-keyboards">inline keyboard</a>, <a href="/bots/features#keyboards">custom reply keyboard</a>, instructions to remove a reply keyboard or to force a reply from the user |

#### sendVideoNote

    sendVideoNote(business_connection_id: String, chat_id: IntegerOrString, message_thread_id: Integer, video_note: InputFileOrString, duration: Integer, length: Integer, thumbnail: InputFileOrString, disable_notification: Boolean, protect_content: Boolean, message_effect_id: String, reply_parameters: ReplyParameters, reply_markup: KeyboardOption)

<p>As of <a href="https://telegram.org/blog/video-messages-and-telescope">v.4.0</a>, Telegram clients support rounded square MPEG4 videos of up to 1 minute long. Use this method to send video messages. On success, the sent <a href="#message">Message</a> is returned.</p>

| name | type | required | description |
|---|---|---|---|
| business_connection_id | String | false | Unique identifier of the business connection on behalf of which the message will be sent |
| chat_id | IntegerOrString | true | Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>) |
| message_thread_id | Integer | false | Unique identifier for the target message thread (topic) of the forum; for forum supergroups only |
| video_note | InputFileOrString | true | Video note to send. Pass a file_id as String to send a video note that exists on the Telegram servers (recommended) or upload a new video using multipart/form-data. <a href="#sending-files">More information on Sending Files »</a>. Sending video notes by a URL is currently unsupported |
| duration | Integer | false | Duration of sent video in seconds |
| length | Integer | false | Video width and height, i.e. diameter of the video message |
| thumbnail | InputFileOrString | false | Thumbnail of the file sent; can be ignored if thumbnail generation for the file is supported server-side. The thumbnail should be in JPEG format and less than 200 kB in size. A thumbnail's width and height should not exceed 320. Ignored if the file is not uploaded using multipart/form-data. Thumbnails can't be reused and can be only uploaded as a new file, so you can pass “attach://&lt;file_attach_name&gt;” if the thumbnail was uploaded using multipart/form-data under &lt;file_attach_name&gt;. <a href="#sending-files">More information on Sending Files »</a> |
| disable_notification | Boolean | false | Sends the message <a href="https://telegram.org/blog/channels-2-0#silent-messages">silently</a>. Users will receive a notification with no sound. |
| protect_content | Boolean | false | Protects the contents of the sent message from forwarding and saving |
| message_effect_id | String | false | Unique identifier of the message effect to be added to the message; for private chats only |
| reply_parameters | ReplyParameters | false | Description of the message to reply to |
| reply_markup | KeyboardOption | false | Additional interface options. A JSON-serialized object for an <a href="/bots/features#inline-keyboards">inline keyboard</a>, <a href="/bots/features#keyboards">custom reply keyboard</a>, instructions to remove a reply keyboard or to force a reply from the user |

#### sendMediaGroup

    sendMediaGroup(business_connection_id: String, chat_id: IntegerOrString, message_thread_id: Integer, media: List<InputMedia>, disable_notification: Boolean, protect_content: Boolean, message_effect_id: String, reply_parameters: ReplyParameters)

<p>Use this method to send a group of photos, videos, documents or audios as an album. Documents and audio files can be only grouped in an album with messages of the same type. On success, an array of <a href="#message">Messages</a> that were sent is returned.</p>

| name | type | required | description |
|---|---|---|---|
| business_connection_id | String | false | Unique identifier of the business connection on behalf of which the message will be sent |
| chat_id | IntegerOrString | true | Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>) |
| message_thread_id | Integer | false | Unique identifier for the target message thread (topic) of the forum; for forum supergroups only |
| media | List<InputMedia> | true | A JSON-serialized array describing messages to be sent, must include 2-10 items |
| disable_notification | Boolean | false | Sends messages <a href="https://telegram.org/blog/channels-2-0#silent-messages">silently</a>. Users will receive a notification with no sound. |
| protect_content | Boolean | false | Protects the contents of the sent messages from forwarding and saving |
| message_effect_id | String | false | Unique identifier of the message effect to be added to the message; for private chats only |
| reply_parameters | ReplyParameters | false | Description of the message to reply to |

#### sendLocation

    sendLocation(business_connection_id: String, chat_id: IntegerOrString, message_thread_id: Integer, latitude: Float, longitude: Float, horizontal_accuracy: Float, live_period: Integer, heading: Integer, proximity_alert_radius: Integer, disable_notification: Boolean, protect_content: Boolean, message_effect_id: String, reply_parameters: ReplyParameters, reply_markup: KeyboardOption)

<p>Use this method to send point on the map. On success, the sent <a href="#message">Message</a> is returned.</p>

| name | type | required | description |
|---|---|---|---|
| business_connection_id | String | false | Unique identifier of the business connection on behalf of which the message will be sent |
| chat_id | IntegerOrString | true | Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>) |
| message_thread_id | Integer | false | Unique identifier for the target message thread (topic) of the forum; for forum supergroups only |
| latitude | Float | true | Latitude of the location |
| longitude | Float | true | Longitude of the location |
| horizontal_accuracy | Float | false | The radius of uncertainty for the location, measured in meters; 0-1500 |
| live_period | Integer | false | Period in seconds during which the location will be updated (see <a href="https://telegram.org/blog/live-locations">Live Locations</a>, should be between 60 and 86400, or 0x7FFFFFFF for live locations that can be edited indefinitely. |
| heading | Integer | false | For live locations, a direction in which the user is moving, in degrees. Must be between 1 and 360 if specified. |
| proximity_alert_radius | Integer | false | For live locations, a maximum distance for proximity alerts about approaching another chat member, in meters. Must be between 1 and 100000 if specified. |
| disable_notification | Boolean | false | Sends the message <a href="https://telegram.org/blog/channels-2-0#silent-messages">silently</a>. Users will receive a notification with no sound. |
| protect_content | Boolean | false | Protects the contents of the sent message from forwarding and saving |
| message_effect_id | String | false | Unique identifier of the message effect to be added to the message; for private chats only |
| reply_parameters | ReplyParameters | false | Description of the message to reply to |
| reply_markup | KeyboardOption | false | Additional interface options. A JSON-serialized object for an <a href="/bots/features#inline-keyboards">inline keyboard</a>, <a href="/bots/features#keyboards">custom reply keyboard</a>, instructions to remove a reply keyboard or to force a reply from the user |

#### sendVenue

    sendVenue(business_connection_id: String, chat_id: IntegerOrString, message_thread_id: Integer, latitude: Float, longitude: Float, title: String, address: String, foursquare_id: String, foursquare_type: String, google_place_id: String, google_place_type: String, disable_notification: Boolean, protect_content: Boolean, message_effect_id: String, reply_parameters: ReplyParameters, reply_markup: KeyboardOption)

<p>Use this method to send information about a venue. On success, the sent <a href="#message">Message</a> is returned.</p>

| name | type | required | description |
|---|---|---|---|
| business_connection_id | String | false | Unique identifier of the business connection on behalf of which the message will be sent |
| chat_id | IntegerOrString | true | Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>) |
| message_thread_id | Integer | false | Unique identifier for the target message thread (topic) of the forum; for forum supergroups only |
| latitude | Float | true | Latitude of the venue |
| longitude | Float | true | Longitude of the venue |
| title | String | true | Name of the venue |
| address | String | true | Address of the venue |
| foursquare_id | String | false | Foursquare identifier of the venue |
| foursquare_type | String | false | Foursquare type of the venue, if known. (For example, “arts_entertainment/default”, “arts_entertainment/aquarium” or “food/icecream”.) |
| google_place_id | String | false | Google Places identifier of the venue |
| google_place_type | String | false | Google Places type of the venue. (See <a href="https://developers.google.com/places/web-service/supported_types">supported types</a>.) |
| disable_notification | Boolean | false | Sends the message <a href="https://telegram.org/blog/channels-2-0#silent-messages">silently</a>. Users will receive a notification with no sound. |
| protect_content | Boolean | false | Protects the contents of the sent message from forwarding and saving |
| message_effect_id | String | false | Unique identifier of the message effect to be added to the message; for private chats only |
| reply_parameters | ReplyParameters | false | Description of the message to reply to |
| reply_markup | KeyboardOption | false | Additional interface options. A JSON-serialized object for an <a href="/bots/features#inline-keyboards">inline keyboard</a>, <a href="/bots/features#keyboards">custom reply keyboard</a>, instructions to remove a reply keyboard or to force a reply from the user |

#### sendContact

    sendContact(business_connection_id: String, chat_id: IntegerOrString, message_thread_id: Integer, phone_number: String, first_name: String, last_name: String, vcard: String, disable_notification: Boolean, protect_content: Boolean, message_effect_id: String, reply_parameters: ReplyParameters, reply_markup: KeyboardOption)

<p>Use this method to send phone contacts. On success, the sent <a href="#message">Message</a> is returned.</p>

| name | type | required | description |
|---|---|---|---|
| business_connection_id | String | false | Unique identifier of the business connection on behalf of which the message will be sent |
| chat_id | IntegerOrString | true | Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>) |
| message_thread_id | Integer | false | Unique identifier for the target message thread (topic) of the forum; for forum supergroups only |
| phone_number | String | true | Contact's phone number |
| first_name | String | true | Contact's first name |
| last_name | String | false | Contact's last name |
| vcard | String | false | Additional data about the contact in the form of a <a href="https://en.wikipedia.org/wiki/VCard">vCard</a>, 0-2048 bytes |
| disable_notification | Boolean | false | Sends the message <a href="https://telegram.org/blog/channels-2-0#silent-messages">silently</a>. Users will receive a notification with no sound. |
| protect_content | Boolean | false | Protects the contents of the sent message from forwarding and saving |
| message_effect_id | String | false | Unique identifier of the message effect to be added to the message; for private chats only |
| reply_parameters | ReplyParameters | false | Description of the message to reply to |
| reply_markup | KeyboardOption | false | Additional interface options. A JSON-serialized object for an <a href="/bots/features#inline-keyboards">inline keyboard</a>, <a href="/bots/features#keyboards">custom reply keyboard</a>, instructions to remove a reply keyboard or to force a reply from the user |

#### sendPoll

    sendPoll(business_connection_id: String, chat_id: IntegerOrString, message_thread_id: Integer, question: String, question_parse_mode: String, question_entities: List<MessageEntity>, options: List<InputPollOption>, is_anonymous: Boolean, type: String, allows_multiple_answers: Boolean, correct_option_id: Integer, explanation: String, explanation_parse_mode: String, explanation_entities: List<MessageEntity>, open_period: Integer, close_date: Integer, is_closed: Boolean, disable_notification: Boolean, protect_content: Boolean, message_effect_id: String, reply_parameters: ReplyParameters, reply_markup: KeyboardOption)

<p>Use this method to send a native poll. On success, the sent <a href="#message">Message</a> is returned.</p>

| name | type | required | description |
|---|---|---|---|
| business_connection_id | String | false | Unique identifier of the business connection on behalf of which the message will be sent |
| chat_id | IntegerOrString | true | Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>) |
| message_thread_id | Integer | false | Unique identifier for the target message thread (topic) of the forum; for forum supergroups only |
| question | String | true | Poll question, 1-300 characters |
| question_parse_mode | String | false | Mode for parsing entities in the question. See <a href="#formatting-options">formatting options</a> for more details. Currently, only custom emoji entities are allowed |
| question_entities | List<MessageEntity> | false | A JSON-serialized list of special entities that appear in the poll question. It can be specified instead of <em>question_parse_mode</em> |
| options | List<InputPollOption> | true | A JSON-serialized list of 2-10 answer options |
| is_anonymous | Boolean | false | <em>True</em>, if the poll needs to be anonymous, defaults to <em>True</em> |
| type | String | false | Poll type, “quiz” or “regular”, defaults to “regular” |
| allows_multiple_answers | Boolean | false | <em>True</em>, if the poll allows multiple answers, ignored for polls in quiz mode, defaults to <em>False</em> |
| correct_option_id | Integer | false | 0-based identifier of the correct answer option, required for polls in quiz mode |
| explanation | String | false | Text that is shown when a user chooses an incorrect answer or taps on the lamp icon in a quiz-style poll, 0-200 characters with at most 2 line feeds after entities parsing |
| explanation_parse_mode | String | false | Mode for parsing entities in the explanation. See <a href="#formatting-options">formatting options</a> for more details. |
| explanation_entities | List<MessageEntity> | false | A JSON-serialized list of special entities that appear in the poll explanation. It can be specified instead of <em>explanation_parse_mode</em> |
| open_period | Integer | false | Amount of time in seconds the poll will be active after creation, 5-600. Can't be used together with <em>close_date</em>. |
| close_date | Integer | false | Point in time (Unix timestamp) when the poll will be automatically closed. Must be at least 5 and no more than 600 seconds in the future. Can't be used together with <em>open_period</em>. |
| is_closed | Boolean | false | Pass <em>True</em> if the poll needs to be immediately closed. This can be useful for poll preview. |
| disable_notification | Boolean | false | Sends the message <a href="https://telegram.org/blog/channels-2-0#silent-messages">silently</a>. Users will receive a notification with no sound. |
| protect_content | Boolean | false | Protects the contents of the sent message from forwarding and saving |
| message_effect_id | String | false | Unique identifier of the message effect to be added to the message; for private chats only |
| reply_parameters | ReplyParameters | false | Description of the message to reply to |
| reply_markup | KeyboardOption | false | Additional interface options. A JSON-serialized object for an <a href="/bots/features#inline-keyboards">inline keyboard</a>, <a href="/bots/features#keyboards">custom reply keyboard</a>, instructions to remove a reply keyboard or to force a reply from the user |

#### sendDice

    sendDice(business_connection_id: String, chat_id: IntegerOrString, message_thread_id: Integer, emoji: String, disable_notification: Boolean, protect_content: Boolean, message_effect_id: String, reply_parameters: ReplyParameters, reply_markup: KeyboardOption)

<p>Use this method to send an animated emoji that will display a random value. On success, the sent <a href="#message">Message</a> is returned.</p>

| name | type | required | description |
|---|---|---|---|
| business_connection_id | String | false | Unique identifier of the business connection on behalf of which the message will be sent |
| chat_id | IntegerOrString | true | Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>) |
| message_thread_id | Integer | false | Unique identifier for the target message thread (topic) of the forum; for forum supergroups only |
| emoji | String | false | Emoji on which the dice throw animation is based. Currently, must be one of “<img class="emoji" src="//telegram.org/img/emoji/40/F09F8EB2.png" width="20" height="20" alt="🎲">”, “<img class="emoji" src="//telegram.org/img/emoji/40/F09F8EAF.png" width="20" height="20" alt="🎯">”, “<img class="emoji" src="//telegram.org/img/emoji/40/F09F8F80.png" width="20" height="20" alt="🏀">”, “<img class="emoji" src="//telegram.org/img/emoji/40/E29ABD.png" width="20" height="20" alt="⚽">”, “<img class="emoji" src="//telegram.org/img/emoji/40/F09F8EB3.png" width="20" height="20" alt="🎳">”, or “<img class="emoji" src="//telegram.org/img/emoji/40/F09F8EB0.png" width="20" height="20" alt="🎰">”. Dice can have values 1-6 for “<img class="emoji" src="//telegram.org/img/emoji/40/F09F8EB2.png" width="20" height="20" alt="🎲">”, “<img class="emoji" src="//telegram.org/img/emoji/40/F09F8EAF.png" width="20" height="20" alt="🎯">” and “<img class="emoji" src="//telegram.org/img/emoji/40/F09F8EB3.png" width="20" height="20" alt="🎳">”, values 1-5 for “<img class="emoji" src="//telegram.org/img/emoji/40/F09F8F80.png" width="20" height="20" alt="🏀">” and “<img class="emoji" src="//telegram.org/img/emoji/40/E29ABD.png" width="20" height="20" alt="⚽">”, and values 1-64 for “<img class="emoji" src="//telegram.org/img/emoji/40/F09F8EB0.png" width="20" height="20" alt="🎰">”. Defaults to “<img class="emoji" src="//telegram.org/img/emoji/40/F09F8EB2.png" width="20" height="20" alt="🎲">” |
| disable_notification | Boolean | false | Sends the message <a href="https://telegram.org/blog/channels-2-0#silent-messages">silently</a>. Users will receive a notification with no sound. |
| protect_content | Boolean | false | Protects the contents of the sent message from forwarding |
| message_effect_id | String | false | Unique identifier of the message effect to be added to the message; for private chats only |
| reply_parameters | ReplyParameters | false | Description of the message to reply to |
| reply_markup | KeyboardOption | false | Additional interface options. A JSON-serialized object for an <a href="/bots/features#inline-keyboards">inline keyboard</a>, <a href="/bots/features#keyboards">custom reply keyboard</a>, instructions to remove a reply keyboard or to force a reply from the user |

#### sendChatAction

    sendChatAction(business_connection_id: String, chat_id: IntegerOrString, message_thread_id: Integer, action: String)

<p>Use this method when you need to tell the user that something is happening on the bot's side. The status is set for 5 seconds or less (when a message arrives from your bot, Telegram clients clear its typing status). Returns <em>True</em> on success.</p><blockquote>
 <p>Example: The <a href="https://t.me/imagebot">ImageBot</a> needs some time to process a request and upload the image. Instead of sending a text message along the lines of “Retrieving image, please wait…”, the bot may use <a href="#sendchataction">sendChatAction</a> with <em>action</em> = <em>upload_photo</em>. The user will see a “sending photo” status for the bot.</p>
</blockquote><p>We only recommend using this method when a response from the bot will take a <strong>noticeable</strong> amount of time to arrive.</p>

| name | type | required | description |
|---|---|---|---|
| business_connection_id | String | false | Unique identifier of the business connection on behalf of which the action will be sent |
| chat_id | IntegerOrString | true | Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>) |
| message_thread_id | Integer | false | Unique identifier for the target message thread; for supergroups only |
| action | String | true | Type of action to broadcast. Choose one, depending on what the user is about to receive: <em>typing</em> for <a href="#sendmessage">text messages</a>, <em>upload_photo</em> for <a href="#sendphoto">photos</a>, <em>record_video</em> or <em>upload_video</em> for <a href="#sendvideo">videos</a>, <em>record_voice</em> or <em>upload_voice</em> for <a href="#sendvoice">voice notes</a>, <em>upload_document</em> for <a href="#senddocument">general files</a>, <em>choose_sticker</em> for <a href="#sendsticker">stickers</a>, <em>find_location</em> for <a href="#sendlocation">location data</a>, <em>record_video_note</em> or <em>upload_video_note</em> for <a href="#sendvideonote">video notes</a>. |

#### setMessageReaction

    setMessageReaction(chat_id: IntegerOrString, message_id: Integer, reaction: List<ReactionType>, is_big: Boolean)

<p>Use this method to change the chosen reactions on a message. Service messages can't be reacted to. Automatically forwarded messages from a channel to its discussion group have the same available reactions as messages in the channel. Returns <em>True</em> on success.</p>

| name | type | required | description |
|---|---|---|---|
| chat_id | IntegerOrString | true | Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>) |
| message_id | Integer | true | Identifier of the target message. If the message belongs to a media group, the reaction is set to the first non-deleted message in the group instead. |
| reaction | List<ReactionType> | false | A JSON-serialized list of reaction types to set on the message. Currently, as non-premium users, bots can set up to one reaction per message. A custom emoji reaction can be used if it is either already present on the message or explicitly allowed by chat administrators. |
| is_big | Boolean | false | Pass <em>True</em> to set the reaction with a big animation |

#### getUserProfilePhotos

    getUserProfilePhotos(user_id: Integer, offset: Integer, limit: Integer)

<p>Use this method to get a list of profile pictures for a user. Returns a <a href="#userprofilephotos">UserProfilePhotos</a> object.</p>

| name | type | required | description |
|---|---|---|---|
| user_id | Integer | true | Unique identifier of the target user |
| offset | Integer | false | Sequential number of the first photo to be returned. By default, all photos are returned. |
| limit | Integer | false | Limits the number of photos to be retrieved. Values between 1-100 are accepted. Defaults to 100. |

#### getFile

    getFile(file_id: String)

<p>Use this method to get basic information about a file and prepare it for downloading. For the moment, bots can download files of up to 20MB in size. On success, a <a href="#file">File</a> object is returned. The file can then be downloaded via the link <code>https://api.telegram.org/file/bot&lt;token&gt;/&lt;file_path&gt;</code>, where <code>&lt;file_path&gt;</code> is taken from the response. It is guaranteed that the link will be valid for at least 1 hour. When the link expires, a new one can be requested by calling <a href="#getfile">getFile</a> again.</p><p><strong>Note:</strong> This function may not preserve the original file name and MIME type. You should save the file's MIME type and name (if available) when the File object is received.</p>

| name | type | required | description |
|---|---|---|---|
| file_id | String | true | File identifier to get information about |

#### banChatMember

    banChatMember(chat_id: IntegerOrString, user_id: Integer, until_date: Integer, revoke_messages: Boolean)

<p>Use this method to ban a user in a group, a supergroup or a channel. In the case of supergroups and channels, the user will not be able to return to the chat on their own using invite links, etc., unless <a href="#unbanchatmember">unbanned</a> first. The bot must be an administrator in the chat for this to work and must have the appropriate administrator rights. Returns <em>True</em> on success.</p>

| name | type | required | description |
|---|---|---|---|
| chat_id | IntegerOrString | true | Unique identifier for the target group or username of the target supergroup or channel (in the format <code>@channelusername</code>) |
| user_id | Integer | true | Unique identifier of the target user |
| until_date | Integer | false | Date when the user will be unbanned; Unix time. If user is banned for more than 366 days or less than 30 seconds from the current time they are considered to be banned forever. Applied for supergroups and channels only. |
| revoke_messages | Boolean | false | Pass <em>True</em> to delete all messages from the chat for the user that is being removed. If <em>False</em>, the user will be able to see messages in the group that were sent before the user was removed. Always <em>True</em> for supergroups and channels. |

#### unbanChatMember

    unbanChatMember(chat_id: IntegerOrString, user_id: Integer, only_if_banned: Boolean)

<p>Use this method to unban a previously banned user in a supergroup or channel. The user will <strong>not</strong> return to the group or channel automatically, but will be able to join via link, etc. The bot must be an administrator for this to work. By default, this method guarantees that after the call the user is not a member of the chat, but will be able to join it. So if the user is a member of the chat they will also be <strong>removed</strong> from the chat. If you don't want this, use the parameter <em>only_if_banned</em>. Returns <em>True</em> on success.</p>

| name | type | required | description |
|---|---|---|---|
| chat_id | IntegerOrString | true | Unique identifier for the target group or username of the target supergroup or channel (in the format <code>@channelusername</code>) |
| user_id | Integer | true | Unique identifier of the target user |
| only_if_banned | Boolean | false | Do nothing if the user is not banned |

#### restrictChatMember

    restrictChatMember(chat_id: IntegerOrString, user_id: Integer, permissions: ChatPermissions, use_independent_chat_permissions: Boolean, until_date: Integer)

<p>Use this method to restrict a user in a supergroup. The bot must be an administrator in the supergroup for this to work and must have the appropriate administrator rights. Pass <em>True</em> for all permissions to lift restrictions from a user. Returns <em>True</em> on success.</p>

| name | type | required | description |
|---|---|---|---|
| chat_id | IntegerOrString | true | Unique identifier for the target chat or username of the target supergroup (in the format <code>@supergroupusername</code>) |
| user_id | Integer | true | Unique identifier of the target user |
| permissions | ChatPermissions | true | A JSON-serialized object for new user permissions |
| use_independent_chat_permissions | Boolean | false | Pass <em>True</em> if chat permissions are set independently. Otherwise, the <em>can_send_other_messages</em> and <em>can_add_web_page_previews</em> permissions will imply the <em>can_send_messages</em>, <em>can_send_audios</em>, <em>can_send_documents</em>, <em>can_send_photos</em>, <em>can_send_videos</em>, <em>can_send_video_notes</em>, and <em>can_send_voice_notes</em> permissions; the <em>can_send_polls</em> permission will imply the <em>can_send_messages</em> permission. |
| until_date | Integer | false | Date when restrictions will be lifted for the user; Unix time. If user is restricted for more than 366 days or less than 30 seconds from the current time, they are considered to be restricted forever |

#### promoteChatMember

    promoteChatMember(chat_id: IntegerOrString, user_id: Integer, is_anonymous: Boolean, can_manage_chat: Boolean, can_delete_messages: Boolean, can_manage_video_chats: Boolean, can_restrict_members: Boolean, can_promote_members: Boolean, can_change_info: Boolean, can_invite_users: Boolean, can_post_stories: Boolean, can_edit_stories: Boolean, can_delete_stories: Boolean, can_post_messages: Boolean, can_edit_messages: Boolean, can_pin_messages: Boolean, can_manage_topics: Boolean)

<p>Use this method to promote or demote a user in a supergroup or a channel. The bot must be an administrator in the chat for this to work and must have the appropriate administrator rights. Pass <em>False</em> for all boolean parameters to demote a user. Returns <em>True</em> on success.</p>

| name | type | required | description |
|---|---|---|---|
| chat_id | IntegerOrString | true | Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>) |
| user_id | Integer | true | Unique identifier of the target user |
| is_anonymous | Boolean | false | Pass <em>True</em> if the administrator's presence in the chat is hidden |
| can_manage_chat | Boolean | false | Pass <em>True</em> if the administrator can access the chat event log, get boost list, see hidden supergroup and channel members, report spam messages and ignore slow mode. Implied by any other administrator privilege. |
| can_delete_messages | Boolean | false | Pass <em>True</em> if the administrator can delete messages of other users |
| can_manage_video_chats | Boolean | false | Pass <em>True</em> if the administrator can manage video chats |
| can_restrict_members | Boolean | false | Pass <em>True</em> if the administrator can restrict, ban or unban chat members, or access supergroup statistics |
| can_promote_members | Boolean | false | Pass <em>True</em> if the administrator can add new administrators with a subset of their own privileges or demote administrators that they have promoted, directly or indirectly (promoted by administrators that were appointed by him) |
| can_change_info | Boolean | false | Pass <em>True</em> if the administrator can change chat title, photo and other settings |
| can_invite_users | Boolean | false | Pass <em>True</em> if the administrator can invite new users to the chat |
| can_post_stories | Boolean | false | Pass <em>True</em> if the administrator can post stories to the chat |
| can_edit_stories | Boolean | false | Pass <em>True</em> if the administrator can edit stories posted by other users, post stories to the chat page, pin chat stories, and access the chat's story archive |
| can_delete_stories | Boolean | false | Pass <em>True</em> if the administrator can delete stories posted by other users |
| can_post_messages | Boolean | false | Pass <em>True</em> if the administrator can post messages in the channel, or access channel statistics; for channels only |
| can_edit_messages | Boolean | false | Pass <em>True</em> if the administrator can edit messages of other users and can pin messages; for channels only |
| can_pin_messages | Boolean | false | Pass <em>True</em> if the administrator can pin messages; for supergroups only |
| can_manage_topics | Boolean | false | Pass <em>True</em> if the user is allowed to create, rename, close, and reopen forum topics; for supergroups only |

#### setChatAdministratorCustomTitle

    setChatAdministratorCustomTitle(chat_id: IntegerOrString, user_id: Integer, custom_title: String)

<p>Use this method to set a custom title for an administrator in a supergroup promoted by the bot. Returns <em>True</em> on success.</p>

| name | type | required | description |
|---|---|---|---|
| chat_id | IntegerOrString | true | Unique identifier for the target chat or username of the target supergroup (in the format <code>@supergroupusername</code>) |
| user_id | Integer | true | Unique identifier of the target user |
| custom_title | String | true | New custom title for the administrator; 0-16 characters, emoji are not allowed |

#### banChatSenderChat

    banChatSenderChat(chat_id: IntegerOrString, sender_chat_id: Integer)

<p>Use this method to ban a channel chat in a supergroup or a channel. Until the chat is <a href="#unbanchatsenderchat">unbanned</a>, the owner of the banned chat won't be able to send messages on behalf of <strong>any of their channels</strong>. The bot must be an administrator in the supergroup or channel for this to work and must have the appropriate administrator rights. Returns <em>True</em> on success.</p>

| name | type | required | description |
|---|---|---|---|
| chat_id | IntegerOrString | true | Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>) |
| sender_chat_id | Integer | true | Unique identifier of the target sender chat |

#### unbanChatSenderChat

    unbanChatSenderChat(chat_id: IntegerOrString, sender_chat_id: Integer)

<p>Use this method to unban a previously banned channel chat in a supergroup or channel. The bot must be an administrator for this to work and must have the appropriate administrator rights. Returns <em>True</em> on success.</p>

| name | type | required | description |
|---|---|---|---|
| chat_id | IntegerOrString | true | Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>) |
| sender_chat_id | Integer | true | Unique identifier of the target sender chat |

#### setChatPermissions

    setChatPermissions(chat_id: IntegerOrString, permissions: ChatPermissions, use_independent_chat_permissions: Boolean)

<p>Use this method to set default chat permissions for all members. The bot must be an administrator in the group or a supergroup for this to work and must have the <em>can_restrict_members</em> administrator rights. Returns <em>True</em> on success.</p>

| name | type | required | description |
|---|---|---|---|
| chat_id | IntegerOrString | true | Unique identifier for the target chat or username of the target supergroup (in the format <code>@supergroupusername</code>) |
| permissions | ChatPermissions | true | A JSON-serialized object for new default chat permissions |
| use_independent_chat_permissions | Boolean | false | Pass <em>True</em> if chat permissions are set independently. Otherwise, the <em>can_send_other_messages</em> and <em>can_add_web_page_previews</em> permissions will imply the <em>can_send_messages</em>, <em>can_send_audios</em>, <em>can_send_documents</em>, <em>can_send_photos</em>, <em>can_send_videos</em>, <em>can_send_video_notes</em>, and <em>can_send_voice_notes</em> permissions; the <em>can_send_polls</em> permission will imply the <em>can_send_messages</em> permission. |

#### exportChatInviteLink

    exportChatInviteLink(chat_id: IntegerOrString)

<p>Use this method to generate a new primary invite link for a chat; any previously generated primary link is revoked. The bot must be an administrator in the chat for this to work and must have the appropriate administrator rights. Returns the new invite link as <em>String</em> on success.</p><blockquote>
 <p>Note: Each administrator in a chat generates their own invite links. Bots can't use invite links generated by other administrators. If you want your bot to work with invite links, it will need to generate its own link using <a href="#exportchatinvitelink">exportChatInviteLink</a> or by calling the <a href="#getchat">getChat</a> method. If your bot needs to generate a new primary invite link replacing its previous one, use <a href="#exportchatinvitelink">exportChatInviteLink</a> again.</p>
</blockquote>

| name | type | required | description |
|---|---|---|---|
| chat_id | IntegerOrString | true | Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>) |

#### createChatInviteLink

    createChatInviteLink(chat_id: IntegerOrString, name: String, expire_date: Integer, member_limit: Integer, creates_join_request: Boolean)

<p>Use this method to create an additional invite link for a chat. The bot must be an administrator in the chat for this to work and must have the appropriate administrator rights. The link can be revoked using the method <a href="#revokechatinvitelink">revokeChatInviteLink</a>. Returns the new invite link as <a href="#chatinvitelink">ChatInviteLink</a> object.</p>

| name | type | required | description |
|---|---|---|---|
| chat_id | IntegerOrString | true | Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>) |
| name | String | false | Invite link name; 0-32 characters |
| expire_date | Integer | false | Point in time (Unix timestamp) when the link will expire |
| member_limit | Integer | false | The maximum number of users that can be members of the chat simultaneously after joining the chat via this invite link; 1-99999 |
| creates_join_request | Boolean | false | <em>True</em>, if users joining the chat via the link need to be approved by chat administrators. If <em>True</em>, <em>member_limit</em> can't be specified |

#### editChatInviteLink

    editChatInviteLink(chat_id: IntegerOrString, invite_link: String, name: String, expire_date: Integer, member_limit: Integer, creates_join_request: Boolean)

<p>Use this method to edit a non-primary invite link created by the bot. The bot must be an administrator in the chat for this to work and must have the appropriate administrator rights. Returns the edited invite link as a <a href="#chatinvitelink">ChatInviteLink</a> object.</p>

| name | type | required | description |
|---|---|---|---|
| chat_id | IntegerOrString | true | Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>) |
| invite_link | String | true | The invite link to edit |
| name | String | false | Invite link name; 0-32 characters |
| expire_date | Integer | false | Point in time (Unix timestamp) when the link will expire |
| member_limit | Integer | false | The maximum number of users that can be members of the chat simultaneously after joining the chat via this invite link; 1-99999 |
| creates_join_request | Boolean | false | <em>True</em>, if users joining the chat via the link need to be approved by chat administrators. If <em>True</em>, <em>member_limit</em> can't be specified |

#### revokeChatInviteLink

    revokeChatInviteLink(chat_id: IntegerOrString, invite_link: String)

<p>Use this method to revoke an invite link created by the bot. If the primary link is revoked, a new link is automatically generated. The bot must be an administrator in the chat for this to work and must have the appropriate administrator rights. Returns the revoked invite link as <a href="#chatinvitelink">ChatInviteLink</a> object.</p>

| name | type | required | description |
|---|---|---|---|
| chat_id | IntegerOrString | true | Unique identifier of the target chat or username of the target channel (in the format <code>@channelusername</code>) |
| invite_link | String | true | The invite link to revoke |

#### approveChatJoinRequest

    approveChatJoinRequest(chat_id: IntegerOrString, user_id: Integer)

<p>Use this method to approve a chat join request. The bot must be an administrator in the chat for this to work and must have the <em>can_invite_users</em> administrator right. Returns <em>True</em> on success.</p>

| name | type | required | description |
|---|---|---|---|
| chat_id | IntegerOrString | true | Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>) |
| user_id | Integer | true | Unique identifier of the target user |

#### declineChatJoinRequest

    declineChatJoinRequest(chat_id: IntegerOrString, user_id: Integer)

<p>Use this method to decline a chat join request. The bot must be an administrator in the chat for this to work and must have the <em>can_invite_users</em> administrator right. Returns <em>True</em> on success.</p>

| name | type | required | description |
|---|---|---|---|
| chat_id | IntegerOrString | true | Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>) |
| user_id | Integer | true | Unique identifier of the target user |

#### setChatPhoto

    setChatPhoto(chat_id: IntegerOrString, photo: InputFile)

<p>Use this method to set a new profile photo for the chat. Photos can't be changed for private chats. The bot must be an administrator in the chat for this to work and must have the appropriate administrator rights. Returns <em>True</em> on success.</p>

| name | type | required | description |
|---|---|---|---|
| chat_id | IntegerOrString | true | Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>) |
| photo | InputFile | true | New chat photo, uploaded using multipart/form-data |

#### deleteChatPhoto

    deleteChatPhoto(chat_id: IntegerOrString)

<p>Use this method to delete a chat photo. Photos can't be changed for private chats. The bot must be an administrator in the chat for this to work and must have the appropriate administrator rights. Returns <em>True</em> on success.</p>

| name | type | required | description |
|---|---|---|---|
| chat_id | IntegerOrString | true | Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>) |

#### setChatTitle

    setChatTitle(chat_id: IntegerOrString, title: String)

<p>Use this method to change the title of a chat. Titles can't be changed for private chats. The bot must be an administrator in the chat for this to work and must have the appropriate administrator rights. Returns <em>True</em> on success.</p>

| name | type | required | description |
|---|---|---|---|
| chat_id | IntegerOrString | true | Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>) |
| title | String | true | New chat title, 1-128 characters |

#### setChatDescription

    setChatDescription(chat_id: IntegerOrString, description: String)

<p>Use this method to change the description of a group, a supergroup or a channel. The bot must be an administrator in the chat for this to work and must have the appropriate administrator rights. Returns <em>True</em> on success.</p>

| name | type | required | description |
|---|---|---|---|
| chat_id | IntegerOrString | true | Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>) |
| description | String | false | New chat description, 0-255 characters |

#### pinChatMessage

    pinChatMessage(chat_id: IntegerOrString, message_id: Integer, disable_notification: Boolean)

<p>Use this method to add a message to the list of pinned messages in a chat. If the chat is not a private chat, the bot must be an administrator in the chat for this to work and must have the 'can_pin_messages' administrator right in a supergroup or 'can_edit_messages' administrator right in a channel. Returns <em>True</em> on success.</p>

| name | type | required | description |
|---|---|---|---|
| chat_id | IntegerOrString | true | Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>) |
| message_id | Integer | true | Identifier of a message to pin |
| disable_notification | Boolean | false | Pass <em>True</em> if it is not necessary to send a notification to all chat members about the new pinned message. Notifications are always disabled in channels and private chats. |

#### unpinChatMessage

    unpinChatMessage(chat_id: IntegerOrString, message_id: Integer)

<p>Use this method to remove a message from the list of pinned messages in a chat. If the chat is not a private chat, the bot must be an administrator in the chat for this to work and must have the 'can_pin_messages' administrator right in a supergroup or 'can_edit_messages' administrator right in a channel. Returns <em>True</em> on success.</p>

| name | type | required | description |
|---|---|---|---|
| chat_id | IntegerOrString | true | Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>) |
| message_id | Integer | false | Identifier of a message to unpin. If not specified, the most recent pinned message (by sending date) will be unpinned. |

#### unpinAllChatMessages

    unpinAllChatMessages(chat_id: IntegerOrString)

<p>Use this method to clear the list of pinned messages in a chat. If the chat is not a private chat, the bot must be an administrator in the chat for this to work and must have the 'can_pin_messages' administrator right in a supergroup or 'can_edit_messages' administrator right in a channel. Returns <em>True</em> on success.</p>

| name | type | required | description |
|---|---|---|---|
| chat_id | IntegerOrString | true | Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>) |

#### leaveChat

    leaveChat(chat_id: IntegerOrString)

<p>Use this method for your bot to leave a group, supergroup or channel. Returns <em>True</em> on success.</p>

| name | type | required | description |
|---|---|---|---|
| chat_id | IntegerOrString | true | Unique identifier for the target chat or username of the target supergroup or channel (in the format <code>@channelusername</code>) |

#### getChat

    getChat(chat_id: IntegerOrString)

<p>Use this method to get up-to-date information about the chat. Returns a <a href="#chatfullinfo">ChatFullInfo</a> object on success.</p>

| name | type | required | description |
|---|---|---|---|
| chat_id | IntegerOrString | true | Unique identifier for the target chat or username of the target supergroup or channel (in the format <code>@channelusername</code>) |

#### getChatAdministrators

    getChatAdministrators(chat_id: IntegerOrString)

<p>Use this method to get a list of administrators in a chat, which aren't bots. Returns an Array of <a href="#chatmember">ChatMember</a> objects.</p>

| name | type | required | description |
|---|---|---|---|
| chat_id | IntegerOrString | true | Unique identifier for the target chat or username of the target supergroup or channel (in the format <code>@channelusername</code>) |

#### getChatMemberCount

    getChatMemberCount(chat_id: IntegerOrString)

<p>Use this method to get the number of members in a chat. Returns <em>Int</em> on success.</p>

| name | type | required | description |
|---|---|---|---|
| chat_id | IntegerOrString | true | Unique identifier for the target chat or username of the target supergroup or channel (in the format <code>@channelusername</code>) |

#### getChatMember

    getChatMember(chat_id: IntegerOrString, user_id: Integer)

<p>Use this method to get information about a member of a chat. The method is only guaranteed to work for other users if the bot is an administrator in the chat. Returns a <a href="#chatmember">ChatMember</a> object on success.</p>

| name | type | required | description |
|---|---|---|---|
| chat_id | IntegerOrString | true | Unique identifier for the target chat or username of the target supergroup or channel (in the format <code>@channelusername</code>) |
| user_id | Integer | true | Unique identifier of the target user |

#### setChatStickerSet

    setChatStickerSet(chat_id: IntegerOrString, sticker_set_name: String)

<p>Use this method to set a new group sticker set for a supergroup. The bot must be an administrator in the chat for this to work and must have the appropriate administrator rights. Use the field <em>can_set_sticker_set</em> optionally returned in <a href="#getchat">getChat</a> requests to check if the bot can use this method. Returns <em>True</em> on success.</p>

| name | type | required | description |
|---|---|---|---|
| chat_id | IntegerOrString | true | Unique identifier for the target chat or username of the target supergroup (in the format <code>@supergroupusername</code>) |
| sticker_set_name | String | true | Name of the sticker set to be set as the group sticker set |

#### deleteChatStickerSet

    deleteChatStickerSet(chat_id: IntegerOrString)

<p>Use this method to delete a group sticker set from a supergroup. The bot must be an administrator in the chat for this to work and must have the appropriate administrator rights. Use the field <em>can_set_sticker_set</em> optionally returned in <a href="#getchat">getChat</a> requests to check if the bot can use this method. Returns <em>True</em> on success.</p>

| name | type | required | description |
|---|---|---|---|
| chat_id | IntegerOrString | true | Unique identifier for the target chat or username of the target supergroup (in the format <code>@supergroupusername</code>) |

#### getForumTopicIconStickers

    getForumTopicIconStickers()

<p>Use this method to get custom emoji stickers, which can be used as a forum topic icon by any user. Requires no parameters. Returns an Array of <a href="#sticker">Sticker</a> objects.</p>

#### createForumTopic

    createForumTopic(chat_id: IntegerOrString, name: String, icon_color: Integer, icon_custom_emoji_id: String)

<p>Use this method to create a topic in a forum supergroup chat. The bot must be an administrator in the chat for this to work and must have the <em>can_manage_topics</em> administrator rights. Returns information about the created topic as a <a href="#forumtopic">ForumTopic</a> object.</p>

| name | type | required | description |
|---|---|---|---|
| chat_id | IntegerOrString | true | Unique identifier for the target chat or username of the target supergroup (in the format <code>@supergroupusername</code>) |
| name | String | true | Topic name, 1-128 characters |
| icon_color | Integer | false | Color of the topic icon in RGB format. Currently, must be one of 7322096 (0x6FB9F0), 16766590 (0xFFD67E), 13338331 (0xCB86DB), 9367192 (0x8EEE98), 16749490 (0xFF93B2), or 16478047 (0xFB6F5F) |
| icon_custom_emoji_id | String | false | Unique identifier of the custom emoji shown as the topic icon. Use <a href="#getforumtopiciconstickers">getForumTopicIconStickers</a> to get all allowed custom emoji identifiers. |

#### editForumTopic

    editForumTopic(chat_id: IntegerOrString, message_thread_id: Integer, name: String, icon_custom_emoji_id: String)

<p>Use this method to edit name and icon of a topic in a forum supergroup chat. The bot must be an administrator in the chat for this to work and must have <em>can_manage_topics</em> administrator rights, unless it is the creator of the topic. Returns <em>True</em> on success.</p>

| name | type | required | description |
|---|---|---|---|
| chat_id | IntegerOrString | true | Unique identifier for the target chat or username of the target supergroup (in the format <code>@supergroupusername</code>) |
| message_thread_id | Integer | true | Unique identifier for the target message thread of the forum topic |
| name | String | false | New topic name, 0-128 characters. If not specified or empty, the current name of the topic will be kept |
| icon_custom_emoji_id | String | false | New unique identifier of the custom emoji shown as the topic icon. Use <a href="#getforumtopiciconstickers">getForumTopicIconStickers</a> to get all allowed custom emoji identifiers. Pass an empty string to remove the icon. If not specified, the current icon will be kept |

#### closeForumTopic

    closeForumTopic(chat_id: IntegerOrString, message_thread_id: Integer)

<p>Use this method to close an open topic in a forum supergroup chat. The bot must be an administrator in the chat for this to work and must have the <em>can_manage_topics</em> administrator rights, unless it is the creator of the topic. Returns <em>True</em> on success.</p>

| name | type | required | description |
|---|---|---|---|
| chat_id | IntegerOrString | true | Unique identifier for the target chat or username of the target supergroup (in the format <code>@supergroupusername</code>) |
| message_thread_id | Integer | true | Unique identifier for the target message thread of the forum topic |

#### reopenForumTopic

    reopenForumTopic(chat_id: IntegerOrString, message_thread_id: Integer)

<p>Use this method to reopen a closed topic in a forum supergroup chat. The bot must be an administrator in the chat for this to work and must have the <em>can_manage_topics</em> administrator rights, unless it is the creator of the topic. Returns <em>True</em> on success.</p>

| name | type | required | description |
|---|---|---|---|
| chat_id | IntegerOrString | true | Unique identifier for the target chat or username of the target supergroup (in the format <code>@supergroupusername</code>) |
| message_thread_id | Integer | true | Unique identifier for the target message thread of the forum topic |

#### deleteForumTopic

    deleteForumTopic(chat_id: IntegerOrString, message_thread_id: Integer)

<p>Use this method to delete a forum topic along with all its messages in a forum supergroup chat. The bot must be an administrator in the chat for this to work and must have the <em>can_delete_messages</em> administrator rights. Returns <em>True</em> on success.</p>

| name | type | required | description |
|---|---|---|---|
| chat_id | IntegerOrString | true | Unique identifier for the target chat or username of the target supergroup (in the format <code>@supergroupusername</code>) |
| message_thread_id | Integer | true | Unique identifier for the target message thread of the forum topic |

#### unpinAllForumTopicMessages

    unpinAllForumTopicMessages(chat_id: IntegerOrString, message_thread_id: Integer)

<p>Use this method to clear the list of pinned messages in a forum topic. The bot must be an administrator in the chat for this to work and must have the <em>can_pin_messages</em> administrator right in the supergroup. Returns <em>True</em> on success.</p>

| name | type | required | description |
|---|---|---|---|
| chat_id | IntegerOrString | true | Unique identifier for the target chat or username of the target supergroup (in the format <code>@supergroupusername</code>) |
| message_thread_id | Integer | true | Unique identifier for the target message thread of the forum topic |

#### editGeneralForumTopic

    editGeneralForumTopic(chat_id: IntegerOrString, name: String)

<p>Use this method to edit the name of the 'General' topic in a forum supergroup chat. The bot must be an administrator in the chat for this to work and must have <em>can_manage_topics</em> administrator rights. Returns <em>True</em> on success.</p>

| name | type | required | description |
|---|---|---|---|
| chat_id | IntegerOrString | true | Unique identifier for the target chat or username of the target supergroup (in the format <code>@supergroupusername</code>) |
| name | String | true | New topic name, 1-128 characters |

#### closeGeneralForumTopic

    closeGeneralForumTopic(chat_id: IntegerOrString)

<p>Use this method to close an open 'General' topic in a forum supergroup chat. The bot must be an administrator in the chat for this to work and must have the <em>can_manage_topics</em> administrator rights. Returns <em>True</em> on success.</p>

| name | type | required | description |
|---|---|---|---|
| chat_id | IntegerOrString | true | Unique identifier for the target chat or username of the target supergroup (in the format <code>@supergroupusername</code>) |

#### reopenGeneralForumTopic

    reopenGeneralForumTopic(chat_id: IntegerOrString)

<p>Use this method to reopen a closed 'General' topic in a forum supergroup chat. The bot must be an administrator in the chat for this to work and must have the <em>can_manage_topics</em> administrator rights. The topic will be automatically unhidden if it was hidden. Returns <em>True</em> on success.</p>

| name | type | required | description |
|---|---|---|---|
| chat_id | IntegerOrString | true | Unique identifier for the target chat or username of the target supergroup (in the format <code>@supergroupusername</code>) |

#### hideGeneralForumTopic

    hideGeneralForumTopic(chat_id: IntegerOrString)

<p>Use this method to hide the 'General' topic in a forum supergroup chat. The bot must be an administrator in the chat for this to work and must have the <em>can_manage_topics</em> administrator rights. The topic will be automatically closed if it was open. Returns <em>True</em> on success.</p>

| name | type | required | description |
|---|---|---|---|
| chat_id | IntegerOrString | true | Unique identifier for the target chat or username of the target supergroup (in the format <code>@supergroupusername</code>) |

#### unhideGeneralForumTopic

    unhideGeneralForumTopic(chat_id: IntegerOrString)

<p>Use this method to unhide the 'General' topic in a forum supergroup chat. The bot must be an administrator in the chat for this to work and must have the <em>can_manage_topics</em> administrator rights. Returns <em>True</em> on success.</p>

| name | type | required | description |
|---|---|---|---|
| chat_id | IntegerOrString | true | Unique identifier for the target chat or username of the target supergroup (in the format <code>@supergroupusername</code>) |

#### unpinAllGeneralForumTopicMessages

    unpinAllGeneralForumTopicMessages(chat_id: IntegerOrString)

<p>Use this method to clear the list of pinned messages in a General forum topic. The bot must be an administrator in the chat for this to work and must have the <em>can_pin_messages</em> administrator right in the supergroup. Returns <em>True</em> on success.</p>

| name | type | required | description |
|---|---|---|---|
| chat_id | IntegerOrString | true | Unique identifier for the target chat or username of the target supergroup (in the format <code>@supergroupusername</code>) |

#### answerCallbackQuery

    answerCallbackQuery(callback_query_id: String, text: String, show_alert: Boolean, url: String, cache_time: Integer)

<p>Use this method to send answers to callback queries sent from <a href="/bots/features#inline-keyboards">inline keyboards</a>. The answer will be displayed to the user as a notification at the top of the chat screen or as an alert. On success, <em>True</em> is returned.</p><blockquote>
 <p>Alternatively, the user can be redirected to the specified Game URL. For this option to work, you must first create a game for your bot via <a href="https://t.me/botfather">@BotFather</a> and accept the terms. Otherwise, you may use links like <code>t.me/your_bot?start=XXXX</code> that open your bot with a parameter.</p>
</blockquote>

| name | type | required | description |
|---|---|---|---|
| callback_query_id | String | true | Unique identifier for the query to be answered |
| text | String | false | Text of the notification. If not specified, nothing will be shown to the user, 0-200 characters |
| show_alert | Boolean | false | If <em>True</em>, an alert will be shown by the client instead of a notification at the top of the chat screen. Defaults to <em>false</em>. |
| url | String | false | URL that will be opened by the user's client. If you have created a <a href="#game">Game</a> and accepted the conditions via <a href="https://t.me/botfather">@BotFather</a>, specify the URL that opens your game - note that this will only work if the query comes from a <a href="#inlinekeyboardbutton"><em>callback_game</em></a> button.<br><br>Otherwise, you may use links like <code>t.me/your_bot?start=XXXX</code> that open your bot with a parameter. |
| cache_time | Integer | false | The maximum amount of time in seconds that the result of the callback query may be cached client-side. Telegram apps will support caching starting in version 3.14. Defaults to 0. |

#### getUserChatBoosts

    getUserChatBoosts(chat_id: IntegerOrString, user_id: Integer)

<p>Use this method to get the list of boosts added to a chat by a user. Requires administrator rights in the chat. Returns a <a href="#userchatboosts">UserChatBoosts</a> object.</p>

| name | type | required | description |
|---|---|---|---|
| chat_id | IntegerOrString | true | Unique identifier for the chat or username of the channel (in the format <code>@channelusername</code>) |
| user_id | Integer | true | Unique identifier of the target user |

#### getBusinessConnection

    getBusinessConnection(business_connection_id: String)

<p>Use this method to get information about the connection of the bot with a business account. Returns a <a href="#businessconnection">BusinessConnection</a> object on success.</p>

| name | type | required | description |
|---|---|---|---|
| business_connection_id | String | true | Unique identifier of the business connection |

#### setMyCommands

    setMyCommands(commands: List<BotCommand>, scope: BotCommandScope, language_code: String)

<p>Use this method to change the list of the bot's commands. See <a href="/bots/features#commands">this manual</a> for more details about bot commands. Returns <em>True</em> on success.</p>

| name | type | required | description |
|---|---|---|---|
| commands | List<BotCommand> | true | A JSON-serialized list of bot commands to be set as the list of the bot's commands. At most 100 commands can be specified. |
| scope | BotCommandScope | false | A JSON-serialized object, describing scope of users for which the commands are relevant. Defaults to <a href="#botcommandscopedefault">BotCommandScopeDefault</a>. |
| language_code | String | false | A two-letter ISO 639-1 language code. If empty, commands will be applied to all users from the given scope, for whose language there are no dedicated commands |

#### deleteMyCommands

    deleteMyCommands(scope: BotCommandScope, language_code: String)

<p>Use this method to delete the list of the bot's commands for the given scope and user language. After deletion, <a href="#determining-list-of-commands">higher level commands</a> will be shown to affected users. Returns <em>True</em> on success.</p>

| name | type | required | description |
|---|---|---|---|
| scope | BotCommandScope | false | A JSON-serialized object, describing scope of users for which the commands are relevant. Defaults to <a href="#botcommandscopedefault">BotCommandScopeDefault</a>. |
| language_code | String | false | A two-letter ISO 639-1 language code. If empty, commands will be applied to all users from the given scope, for whose language there are no dedicated commands |

#### getMyCommands

    getMyCommands(scope: BotCommandScope, language_code: String)

<p>Use this method to get the current list of the bot's commands for the given scope and user language. Returns an Array of <a href="#botcommand">BotCommand</a> objects. If commands aren't set, an empty list is returned.</p>

| name | type | required | description |
|---|---|---|---|
| scope | BotCommandScope | false | A JSON-serialized object, describing scope of users. Defaults to <a href="#botcommandscopedefault">BotCommandScopeDefault</a>. |
| language_code | String | false | A two-letter ISO 639-1 language code or an empty string |

#### setMyName

    setMyName(name: String, language_code: String)

<p>Use this method to change the bot's name. Returns <em>True</em> on success.</p>

| name | type | required | description |
|---|---|---|---|
| name | String | false | New bot name; 0-64 characters. Pass an empty string to remove the dedicated name for the given language. |
| language_code | String | false | A two-letter ISO 639-1 language code. If empty, the name will be shown to all users for whose language there is no dedicated name. |

#### getMyName

    getMyName(language_code: String)

<p>Use this method to get the current bot name for the given user language. Returns <a href="#botname">BotName</a> on success.</p>

| name | type | required | description |
|---|---|---|---|
| language_code | String | false | A two-letter ISO 639-1 language code or an empty string |

#### setMyDescription

    setMyDescription(description: String, language_code: String)

<p>Use this method to change the bot's description, which is shown in the chat with the bot if the chat is empty. Returns <em>True</em> on success.</p>

| name | type | required | description |
|---|---|---|---|
| description | String | false | New bot description; 0-512 characters. Pass an empty string to remove the dedicated description for the given language. |
| language_code | String | false | A two-letter ISO 639-1 language code. If empty, the description will be applied to all users for whose language there is no dedicated description. |

#### getMyDescription

    getMyDescription(language_code: String)

<p>Use this method to get the current bot description for the given user language. Returns <a href="#botdescription">BotDescription</a> on success.</p>

| name | type | required | description |
|---|---|---|---|
| language_code | String | false | A two-letter ISO 639-1 language code or an empty string |

#### setMyShortDescription

    setMyShortDescription(short_description: String, language_code: String)

<p>Use this method to change the bot's short description, which is shown on the bot's profile page and is sent together with the link when users share the bot. Returns <em>True</em> on success.</p>

| name | type | required | description |
|---|---|---|---|
| short_description | String | false | New short description for the bot; 0-120 characters. Pass an empty string to remove the dedicated short description for the given language. |
| language_code | String | false | A two-letter ISO 639-1 language code. If empty, the short description will be applied to all users for whose language there is no dedicated short description. |

#### getMyShortDescription

    getMyShortDescription(language_code: String)

<p>Use this method to get the current bot short description for the given user language. Returns <a href="#botshortdescription">BotShortDescription</a> on success.</p>

| name | type | required | description |
|---|---|---|---|
| language_code | String | false | A two-letter ISO 639-1 language code or an empty string |

#### setChatMenuButton

    setChatMenuButton(chat_id: Integer, menu_button: MenuButton)

<p>Use this method to change the bot's menu button in a private chat, or the default menu button. Returns <em>True</em> on success.</p>

| name | type | required | description |
|---|---|---|---|
| chat_id | Integer | false | Unique identifier for the target private chat. If not specified, default bot's menu button will be changed |
| menu_button | MenuButton | false | A JSON-serialized object for the bot's new menu button. Defaults to <a href="#menubuttondefault">MenuButtonDefault</a> |

#### getChatMenuButton

    getChatMenuButton(chat_id: Integer)

<p>Use this method to get the current value of the bot's menu button in a private chat, or the default menu button. Returns <a href="#menubutton">MenuButton</a> on success.</p>

| name | type | required | description |
|---|---|---|---|
| chat_id | Integer | false | Unique identifier for the target private chat. If not specified, default bot's menu button will be returned |

#### setMyDefaultAdministratorRights

    setMyDefaultAdministratorRights(rights: ChatAdministratorRights, for_channels: Boolean)

<p>Use this method to change the default administrator rights requested by the bot when it's added as an administrator to groups or channels. These rights will be suggested to users, but they are free to modify the list before adding the bot. Returns <em>True</em> on success.</p>

| name | type | required | description |
|---|---|---|---|
| rights | ChatAdministratorRights | false | A JSON-serialized object describing new default administrator rights. If not specified, the default administrator rights will be cleared. |
| for_channels | Boolean | false | Pass <em>True</em> to change the default administrator rights of the bot in channels. Otherwise, the default administrator rights of the bot for groups and supergroups will be changed. |

#### getMyDefaultAdministratorRights

    getMyDefaultAdministratorRights(for_channels: Boolean)

<p>Use this method to get the current default administrator rights of the bot. Returns <a href="#chatadministratorrights">ChatAdministratorRights</a> on success.</p>

| name | type | required | description |
|---|---|---|---|
| for_channels | Boolean | false | Pass <em>True</em> to get default administrator rights of the bot in channels. Otherwise, default administrator rights of the bot for groups and supergroups will be returned. |



## Updating messages

### Methods
#### editMessageText

    editMessageText(business_connection_id: String, chat_id: IntegerOrString, message_id: Integer, inline_message_id: String, text: String, parse_mode: ParseMode, entities: List<MessageEntity>, link_preview_options: LinkPreviewOptions, reply_markup: InlineKeyboardMarkup)

<p>Use this method to edit text and <a href="#games">game</a> messages. On success, if the edited message is not an inline message, the edited <a href="#message">Message</a> is returned, otherwise <em>True</em> is returned. Note that business messages that were not sent by the bot and do not contain an inline keyboard can only be edited within <strong>48 hours</strong> from the time they were sent.</p>

| name | type | required | description |
|---|---|---|---|
| business_connection_id | String | false | Unique identifier of the business connection on behalf of which the message to be edited was sent |
| chat_id | IntegerOrString | false | Required if <em>inline_message_id</em> is not specified. Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>) |
| message_id | Integer | false | Required if <em>inline_message_id</em> is not specified. Identifier of the message to edit |
| inline_message_id | String | false | Required if <em>chat_id</em> and <em>message_id</em> are not specified. Identifier of the inline message |
| text | String | true | New text of the message, 1-4096 characters after entities parsing |
| parse_mode | ParseMode | false | Mode for parsing entities in the message text. See <a href="#formatting-options">formatting options</a> for more details. |
| entities | List<MessageEntity> | false | A JSON-serialized list of special entities that appear in message text, which can be specified instead of <em>parse_mode</em> |
| link_preview_options | LinkPreviewOptions | false | Link preview generation options for the message |
| reply_markup | InlineKeyboardMarkup | false | A JSON-serialized object for an <a href="/bots/features#inline-keyboards">inline keyboard</a>. |

#### editMessageCaption

    editMessageCaption(business_connection_id: String, chat_id: IntegerOrString, message_id: Integer, inline_message_id: String, caption: String, parse_mode: ParseMode, caption_entities: List<MessageEntity>, show_caption_above_media: Boolean, reply_markup: InlineKeyboardMarkup)

<p>Use this method to edit captions of messages. On success, if the edited message is not an inline message, the edited <a href="#message">Message</a> is returned, otherwise <em>True</em> is returned. Note that business messages that were not sent by the bot and do not contain an inline keyboard can only be edited within <strong>48 hours</strong> from the time they were sent.</p>

| name | type | required | description |
|---|---|---|---|
| business_connection_id | String | false | Unique identifier of the business connection on behalf of which the message to be edited was sent |
| chat_id | IntegerOrString | false | Required if <em>inline_message_id</em> is not specified. Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>) |
| message_id | Integer | false | Required if <em>inline_message_id</em> is not specified. Identifier of the message to edit |
| inline_message_id | String | false | Required if <em>chat_id</em> and <em>message_id</em> are not specified. Identifier of the inline message |
| caption | String | false | New caption of the message, 0-1024 characters after entities parsing |
| parse_mode | ParseMode | false | Mode for parsing entities in the message caption. See <a href="#formatting-options">formatting options</a> for more details. |
| caption_entities | List<MessageEntity> | false | A JSON-serialized list of special entities that appear in the caption, which can be specified instead of <em>parse_mode</em> |
| show_caption_above_media | Boolean | false | Pass <em>True</em>, if the caption must be shown above the message media. Supported only for animation, photo and video messages. |
| reply_markup | InlineKeyboardMarkup | false | A JSON-serialized object for an <a href="/bots/features#inline-keyboards">inline keyboard</a>. |

#### editMessageMedia

    editMessageMedia(business_connection_id: String, chat_id: IntegerOrString, message_id: Integer, inline_message_id: String, media: InputMedia, reply_markup: InlineKeyboardMarkup)

<p>Use this method to edit animation, audio, document, photo, or video messages. If a message is part of a message album, then it can be edited only to an audio for audio albums, only to a document for document albums and to a photo or a video otherwise. When an inline message is edited, a new file can't be uploaded; use a previously uploaded file via its file_id or specify a URL. On success, if the edited message is not an inline message, the edited <a href="#message">Message</a> is returned, otherwise <em>True</em> is returned. Note that business messages that were not sent by the bot and do not contain an inline keyboard can only be edited within <strong>48 hours</strong> from the time they were sent.</p>

| name | type | required | description |
|---|---|---|---|
| business_connection_id | String | false | Unique identifier of the business connection on behalf of which the message to be edited was sent |
| chat_id | IntegerOrString | false | Required if <em>inline_message_id</em> is not specified. Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>) |
| message_id | Integer | false | Required if <em>inline_message_id</em> is not specified. Identifier of the message to edit |
| inline_message_id | String | false | Required if <em>chat_id</em> and <em>message_id</em> are not specified. Identifier of the inline message |
| media | InputMedia | true | A JSON-serialized object for a new media content of the message |
| reply_markup | InlineKeyboardMarkup | false | A JSON-serialized object for a new <a href="/bots/features#inline-keyboards">inline keyboard</a>. |

#### editMessageLiveLocation

    editMessageLiveLocation(business_connection_id: String, chat_id: IntegerOrString, message_id: Integer, inline_message_id: String, latitude: Float, longitude: Float, live_period: Integer, horizontal_accuracy: Float, heading: Integer, proximity_alert_radius: Integer, reply_markup: InlineKeyboardMarkup)

<p>Use this method to edit live location messages. A location can be edited until its <em>live_period</em> expires or editing is explicitly disabled by a call to <a href="#stopmessagelivelocation">stopMessageLiveLocation</a>. On success, if the edited message is not an inline message, the edited <a href="#message">Message</a> is returned, otherwise <em>True</em> is returned.</p>

| name | type | required | description |
|---|---|---|---|
| business_connection_id | String | false | Unique identifier of the business connection on behalf of which the message to be edited was sent |
| chat_id | IntegerOrString | false | Required if <em>inline_message_id</em> is not specified. Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>) |
| message_id | Integer | false | Required if <em>inline_message_id</em> is not specified. Identifier of the message to edit |
| inline_message_id | String | false | Required if <em>chat_id</em> and <em>message_id</em> are not specified. Identifier of the inline message |
| latitude | Float | true | Latitude of new location |
| longitude | Float | true | Longitude of new location |
| live_period | Integer | false | New period in seconds during which the location can be updated, starting from the message send date. If 0x7FFFFFFF is specified, then the location can be updated forever. Otherwise, the new value must not exceed the current <em>live_period</em> by more than a day, and the live location expiration date must remain within the next 90 days. If not specified, then <em>live_period</em> remains unchanged |
| horizontal_accuracy | Float | false | The radius of uncertainty for the location, measured in meters; 0-1500 |
| heading | Integer | false | Direction in which the user is moving, in degrees. Must be between 1 and 360 if specified. |
| proximity_alert_radius | Integer | false | The maximum distance for proximity alerts about approaching another chat member, in meters. Must be between 1 and 100000 if specified. |
| reply_markup | InlineKeyboardMarkup | false | A JSON-serialized object for a new <a href="/bots/features#inline-keyboards">inline keyboard</a>. |

#### stopMessageLiveLocation

    stopMessageLiveLocation(business_connection_id: String, chat_id: IntegerOrString, message_id: Integer, inline_message_id: String, reply_markup: InlineKeyboardMarkup)

<p>Use this method to stop updating a live location message before <em>live_period</em> expires. On success, if the message is not an inline message, the edited <a href="#message">Message</a> is returned, otherwise <em>True</em> is returned.</p>

| name | type | required | description |
|---|---|---|---|
| business_connection_id | String | false | Unique identifier of the business connection on behalf of which the message to be edited was sent |
| chat_id | IntegerOrString | false | Required if <em>inline_message_id</em> is not specified. Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>) |
| message_id | Integer | false | Required if <em>inline_message_id</em> is not specified. Identifier of the message with live location to stop |
| inline_message_id | String | false | Required if <em>chat_id</em> and <em>message_id</em> are not specified. Identifier of the inline message |
| reply_markup | InlineKeyboardMarkup | false | A JSON-serialized object for a new <a href="/bots/features#inline-keyboards">inline keyboard</a>. |

#### editMessageReplyMarkup

    editMessageReplyMarkup(business_connection_id: String, chat_id: IntegerOrString, message_id: Integer, inline_message_id: String, reply_markup: InlineKeyboardMarkup)

<p>Use this method to edit only the reply markup of messages. On success, if the edited message is not an inline message, the edited <a href="#message">Message</a> is returned, otherwise <em>True</em> is returned. Note that business messages that were not sent by the bot and do not contain an inline keyboard can only be edited within <strong>48 hours</strong> from the time they were sent.</p>

| name | type | required | description |
|---|---|---|---|
| business_connection_id | String | false | Unique identifier of the business connection on behalf of which the message to be edited was sent |
| chat_id | IntegerOrString | false | Required if <em>inline_message_id</em> is not specified. Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>) |
| message_id | Integer | false | Required if <em>inline_message_id</em> is not specified. Identifier of the message to edit |
| inline_message_id | String | false | Required if <em>chat_id</em> and <em>message_id</em> are not specified. Identifier of the inline message |
| reply_markup | InlineKeyboardMarkup | false | A JSON-serialized object for an <a href="/bots/features#inline-keyboards">inline keyboard</a>. |

#### stopPoll

    stopPoll(business_connection_id: String, chat_id: IntegerOrString, message_id: Integer, reply_markup: InlineKeyboardMarkup)

<p>Use this method to stop a poll which was sent by the bot. On success, the stopped <a href="#poll">Poll</a> is returned.</p>

| name | type | required | description |
|---|---|---|---|
| business_connection_id | String | false | Unique identifier of the business connection on behalf of which the message to be edited was sent |
| chat_id | IntegerOrString | true | Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>) |
| message_id | Integer | true | Identifier of the original message with the poll |
| reply_markup | InlineKeyboardMarkup | false | A JSON-serialized object for a new message <a href="/bots/features#inline-keyboards">inline keyboard</a>. |

#### deleteMessage

    deleteMessage(chat_id: IntegerOrString, message_id: Integer)

<p>Use this method to delete a message, including service messages, with the following limitations:<br>- A message can only be deleted if it was sent less than 48 hours ago.<br>- Service messages about a supergroup, channel, or forum topic creation can't be deleted.<br>- A dice message in a private chat can only be deleted if it was sent more than 24 hours ago.<br>- Bots can delete outgoing messages in private chats, groups, and supergroups.<br>- Bots can delete incoming messages in private chats.<br>- Bots granted <em>can_post_messages</em> permissions can delete outgoing messages in channels.<br>- If the bot is an administrator of a group, it can delete any message there.<br>- If the bot has <em>can_delete_messages</em> permission in a supergroup or a channel, it can delete any message there.<br>Returns <em>True</em> on success.</p>

| name | type | required | description |
|---|---|---|---|
| chat_id | IntegerOrString | true | Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>) |
| message_id | Integer | true | Identifier of the message to delete |

#### deleteMessages

    deleteMessages(chat_id: IntegerOrString, message_ids: List<Integer>)

<p>Use this method to delete multiple messages simultaneously. If some of the specified messages can't be found, they are skipped. Returns <em>True</em> on success.</p>

| name | type | required | description |
|---|---|---|---|
| chat_id | IntegerOrString | true | Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>) |
| message_ids | List<Integer> | true | A JSON-serialized list of 1-100 identifiers of messages to delete. See <a href="#deletemessage">deleteMessage</a> for limitations on which messages can be deleted |



## Stickers

### Data Types
#### Sticker

    Sticker(file_id: String, file_unique_id: String, type: String, width: Integer, height: Integer, is_animated: Boolean, is_video: Boolean, thumbnail: PhotoSize, emoji: String, set_name: String, premium_animation: File, mask_position: MaskPosition, custom_emoji_id: String, needs_repainting: Boolean, file_size: Integer)

<p>This object represents a sticker.</p>

| name | type | required | description |
|---|---|---|---|
| file_id | String | true | Identifier for this file, which can be used to download or reuse the file |
| file_unique_id | String | true | Unique identifier for this file, which is supposed to be the same over time and for different bots. Can't be used to download or reuse the file. |
| type | String | true | Type of the sticker, currently one of “regular”, “mask”, “custom_emoji”. The type of the sticker is independent from its format, which is determined by the fields <em>is_animated</em> and <em>is_video</em>. |
| width | Integer | true | Sticker width |
| height | Integer | true | Sticker height |
| is_animated | Boolean | true | <em>True</em>, if the sticker is <a href="https://telegram.org/blog/animated-stickers">animated</a> |
| is_video | Boolean | true | <em>True</em>, if the sticker is a <a href="https://telegram.org/blog/video-stickers-better-reactions">video sticker</a> |
| thumbnail | PhotoSize | false | <em>Optional</em>. Sticker thumbnail in the .WEBP or .JPG format |
| emoji | String | false | <em>Optional</em>. Emoji associated with the sticker |
| set_name | String | false | <em>Optional</em>. Name of the sticker set to which the sticker belongs |
| premium_animation | File | false | <em>Optional</em>. For premium regular stickers, premium animation for the sticker |
| mask_position | MaskPosition | false | <em>Optional</em>. For mask stickers, the position where the mask should be placed |
| custom_emoji_id | String | false | <em>Optional</em>. For custom emoji stickers, unique identifier of the custom emoji |
| needs_repainting | Boolean | false | <em>Optional</em>. <em>True</em>, if the sticker must be repainted to a text color in messages, the color of the Telegram Premium badge in emoji status, white color on chat photos, or another appropriate color in other places |
| file_size | Integer | false | <em>Optional</em>. File size in bytes |

#### StickerSet

    StickerSet(name: String, title: String, sticker_type: String, stickers: List<Sticker>, thumbnail: PhotoSize)

<p>This object represents a sticker set.</p>

| name | type | required | description |
|---|---|---|---|
| name | String | true | Sticker set name |
| title | String | true | Sticker set title |
| sticker_type | String | true | Type of stickers in the set, currently one of “regular”, “mask”, “custom_emoji” |
| stickers | List<Sticker> | true | List of all set stickers |
| thumbnail | PhotoSize | false | <em>Optional</em>. Sticker set thumbnail in the .WEBP, .TGS, or .WEBM format |

#### MaskPosition

    MaskPosition(point: String, x_shift: Float, y_shift: Float, scale: Float)

<p>This object describes the position on faces where a mask should be placed by default.</p>

| name | type | required | description |
|---|---|---|---|
| point | String | true | The part of the face relative to which the mask should be placed. One of “forehead”, “eyes”, “mouth”, or “chin”. |
| x_shift | Float | true | Shift by X-axis measured in widths of the mask scaled to the face size, from left to right. For example, choosing -1.0 will place mask just to the left of the default mask position. |
| y_shift | Float | true | Shift by Y-axis measured in heights of the mask scaled to the face size, from top to bottom. For example, 1.0 will place the mask just below the default mask position. |
| scale | Float | true | Mask scaling coefficient. For example, 2.0 means double size. |

#### InputSticker

    InputSticker(sticker: InputFileOrString, format: String, emoji_list: List<String>, mask_position: MaskPosition, keywords: List<String>)

<p>This object describes a sticker to be added to a sticker set.</p>

| name | type | required | description |
|---|---|---|---|
| sticker | InputFileOrString | true | The added sticker. Pass a <em>file_id</em> as a String to send a file that already exists on the Telegram servers, pass an HTTP URL as a String for Telegram to get a file from the Internet, upload a new one using multipart/form-data, or pass “attach://&lt;file_attach_name&gt;” to upload a new one using multipart/form-data under &lt;file_attach_name&gt; name. Animated and video stickers can't be uploaded via HTTP URL. <a href="#sending-files">More information on Sending Files »</a> |
| format | String | true | Format of the added sticker, must be one of “static” for a <strong>.WEBP</strong> or <strong>.PNG</strong> image, “animated” for a <strong>.TGS</strong> animation, “video” for a <strong>WEBM</strong> video |
| emoji_list | List<String> | true | List of 1-20 emoji associated with the sticker |
| mask_position | MaskPosition | false | <em>Optional</em>. Position where the mask should be placed on faces. For “mask” stickers only. |
| keywords | List<String> | false | <em>Optional</em>. List of 0-20 search keywords for the sticker with total length of up to 64 characters. For “regular” and “custom_emoji” stickers only. |


### Methods
#### sendSticker

    sendSticker(business_connection_id: String, chat_id: IntegerOrString, message_thread_id: Integer, sticker: InputFileOrString, emoji: String, disable_notification: Boolean, protect_content: Boolean, message_effect_id: String, reply_parameters: ReplyParameters, reply_markup: KeyboardOption)

<p>Use this method to send static .WEBP, <a href="https://telegram.org/blog/animated-stickers">animated</a> .TGS, or <a href="https://telegram.org/blog/video-stickers-better-reactions">video</a> .WEBM stickers. On success, the sent <a href="#message">Message</a> is returned.</p>

| name | type | required | description |
|---|---|---|---|
| business_connection_id | String | false | Unique identifier of the business connection on behalf of which the message will be sent |
| chat_id | IntegerOrString | true | Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>) |
| message_thread_id | Integer | false | Unique identifier for the target message thread (topic) of the forum; for forum supergroups only |
| sticker | InputFileOrString | true | Sticker to send. Pass a file_id as String to send a file that exists on the Telegram servers (recommended), pass an HTTP URL as a String for Telegram to get a .WEBP sticker from the Internet, or upload a new .WEBP, .TGS, or .WEBM sticker using multipart/form-data. <a href="#sending-files">More information on Sending Files »</a>. Video and animated stickers can't be sent via an HTTP URL. |
| emoji | String | false | Emoji associated with the sticker; only for just uploaded stickers |
| disable_notification | Boolean | false | Sends the message <a href="https://telegram.org/blog/channels-2-0#silent-messages">silently</a>. Users will receive a notification with no sound. |
| protect_content | Boolean | false | Protects the contents of the sent message from forwarding and saving |
| message_effect_id | String | false | Unique identifier of the message effect to be added to the message; for private chats only |
| reply_parameters | ReplyParameters | false | Description of the message to reply to |
| reply_markup | KeyboardOption | false | Additional interface options. A JSON-serialized object for an <a href="/bots/features#inline-keyboards">inline keyboard</a>, <a href="/bots/features#keyboards">custom reply keyboard</a>, instructions to remove a reply keyboard or to force a reply from the user |

#### getStickerSet

    getStickerSet(name: String)

<p>Use this method to get a sticker set. On success, a <a href="#stickerset">StickerSet</a> object is returned.</p>

| name | type | required | description |
|---|---|---|---|
| name | String | true | Name of the sticker set |

#### getCustomEmojiStickers

    getCustomEmojiStickers(custom_emoji_ids: List<String>)

<p>Use this method to get information about custom emoji stickers by their identifiers. Returns an Array of <a href="#sticker">Sticker</a> objects.</p>

| name | type | required | description |
|---|---|---|---|
| custom_emoji_ids | List<String> | true | A JSON-serialized list of custom emoji identifiers. At most 200 custom emoji identifiers can be specified. |

#### uploadStickerFile

    uploadStickerFile(user_id: Integer, sticker: InputFile, sticker_format: String)

<p>Use this method to upload a file with a sticker for later use in the <a href="#createnewstickerset">createNewStickerSet</a>, <a href="#addstickertoset">addStickerToSet</a>, or <a href="#replacestickerinset">replaceStickerInSet</a> methods (the file can be used multiple times). Returns the uploaded <a href="#file">File</a> on success.</p>

| name | type | required | description |
|---|---|---|---|
| user_id | Integer | true | User identifier of sticker file owner |
| sticker | InputFile | true | A file with the sticker in .WEBP, .PNG, .TGS, or .WEBM format. See <a href="/stickers"></a><a href="https://core.telegram.org/stickers">https://core.telegram.org/stickers</a> for technical requirements. <a href="#sending-files">More information on Sending Files »</a> |
| sticker_format | String | true | Format of the sticker, must be one of “static”, “animated”, “video” |

#### createNewStickerSet

    createNewStickerSet(user_id: Integer, name: String, title: String, stickers: List<InputSticker>, sticker_type: String, needs_repainting: Boolean)

<p>Use this method to create a new sticker set owned by a user. The bot will be able to edit the sticker set thus created. Returns <em>True</em> on success.</p>

| name | type | required | description |
|---|---|---|---|
| user_id | Integer | true | User identifier of created sticker set owner |
| name | String | true | Short name of sticker set, to be used in <code>t.me/addstickers/</code> URLs (e.g., <em>animals</em>). Can contain only English letters, digits and underscores. Must begin with a letter, can't contain consecutive underscores and must end in <code>"_by_&lt;bot_username&gt;"</code>. <code>&lt;bot_username&gt;</code> is case insensitive. 1-64 characters. |
| title | String | true | Sticker set title, 1-64 characters |
| stickers | List<InputSticker> | true | A JSON-serialized list of 1-50 initial stickers to be added to the sticker set |
| sticker_type | String | false | Type of stickers in the set, pass “regular”, “mask”, or “custom_emoji”. By default, a regular sticker set is created. |
| needs_repainting | Boolean | false | Pass <em>True</em> if stickers in the sticker set must be repainted to the color of text when used in messages, the accent color if used as emoji status, white on chat photos, or another appropriate color based on context; for custom emoji sticker sets only |

#### addStickerToSet

    addStickerToSet(user_id: Integer, name: String, sticker: InputSticker)

<p>Use this method to add a new sticker to a set created by the bot. Emoji sticker sets can have up to 200 stickers. Other sticker sets can have up to 120 stickers. Returns <em>True</em> on success.</p>

| name | type | required | description |
|---|---|---|---|
| user_id | Integer | true | User identifier of sticker set owner |
| name | String | true | Sticker set name |
| sticker | InputSticker | true | A JSON-serialized object with information about the added sticker. If exactly the same sticker had already been added to the set, then the set isn't changed. |

#### setStickerPositionInSet

    setStickerPositionInSet(sticker: String, position: Integer)

<p>Use this method to move a sticker in a set created by the bot to a specific position. Returns <em>True</em> on success.</p>

| name | type | required | description |
|---|---|---|---|
| sticker | String | true | File identifier of the sticker |
| position | Integer | true | New sticker position in the set, zero-based |

#### deleteStickerFromSet

    deleteStickerFromSet(sticker: String)

<p>Use this method to delete a sticker from a set created by the bot. Returns <em>True</em> on success.</p>

| name | type | required | description |
|---|---|---|---|
| sticker | String | true | File identifier of the sticker |

#### replaceStickerInSet

    replaceStickerInSet(user_id: Integer, name: String, old_sticker: String, sticker: InputSticker)

<p>Use this method to replace an existing sticker in a sticker set with a new one. The method is equivalent to calling <a href="#deletestickerfromset">deleteStickerFromSet</a>, then <a href="#addstickertoset">addStickerToSet</a>, then <a href="#setstickerpositioninset">setStickerPositionInSet</a>. Returns <em>True</em> on success.</p>

| name | type | required | description |
|---|---|---|---|
| user_id | Integer | true | User identifier of the sticker set owner |
| name | String | true | Sticker set name |
| old_sticker | String | true | File identifier of the replaced sticker |
| sticker | InputSticker | true | A JSON-serialized object with information about the added sticker. If exactly the same sticker had already been added to the set, then the set remains unchanged. |

#### setStickerEmojiList

    setStickerEmojiList(sticker: String, emoji_list: List<String>)

<p>Use this method to change the list of emoji assigned to a regular or custom emoji sticker. The sticker must belong to a sticker set created by the bot. Returns <em>True</em> on success.</p>

| name | type | required | description |
|---|---|---|---|
| sticker | String | true | File identifier of the sticker |
| emoji_list | List<String> | true | A JSON-serialized list of 1-20 emoji associated with the sticker |

#### setStickerKeywords

    setStickerKeywords(sticker: String, keywords: List<String>)

<p>Use this method to change search keywords assigned to a regular or custom emoji sticker. The sticker must belong to a sticker set created by the bot. Returns <em>True</em> on success.</p>

| name | type | required | description |
|---|---|---|---|
| sticker | String | true | File identifier of the sticker |
| keywords | List<String> | false | A JSON-serialized list of 0-20 search keywords for the sticker with total length of up to 64 characters |

#### setStickerMaskPosition

    setStickerMaskPosition(sticker: String, mask_position: MaskPosition)

<p>Use this method to change the <a href="#maskposition">mask position</a> of a mask sticker. The sticker must belong to a sticker set that was created by the bot. Returns <em>True</em> on success.</p>

| name | type | required | description |
|---|---|---|---|
| sticker | String | true | File identifier of the sticker |
| mask_position | MaskPosition | false | A JSON-serialized object with the position where the mask should be placed on faces. Omit the parameter to remove the mask position. |

#### setStickerSetTitle

    setStickerSetTitle(name: String, title: String)

<p>Use this method to set the title of a created sticker set. Returns <em>True</em> on success.</p>

| name | type | required | description |
|---|---|---|---|
| name | String | true | Sticker set name |
| title | String | true | Sticker set title, 1-64 characters |

#### setStickerSetThumbnail

    setStickerSetThumbnail(name: String, user_id: Integer, thumbnail: InputFileOrString, format: String)

<p>Use this method to set the thumbnail of a regular or mask sticker set. The format of the thumbnail file must match the format of the stickers in the set. Returns <em>True</em> on success.</p>

| name | type | required | description |
|---|---|---|---|
| name | String | true | Sticker set name |
| user_id | Integer | true | User identifier of the sticker set owner |
| thumbnail | InputFileOrString | false | A <strong>.WEBP</strong> or <strong>.PNG</strong> image with the thumbnail, must be up to 128 kilobytes in size and have a width and height of exactly 100px, or a <strong>.TGS</strong> animation with a thumbnail up to 32 kilobytes in size (see <a href="/stickers#animated-sticker-requirements"></a><a href="https://core.telegram.org/stickers#animated-sticker-requirements">https://core.telegram.org/stickers#animated-sticker-requirements</a> for animated sticker technical requirements), or a <strong>WEBM</strong> video with the thumbnail up to 32 kilobytes in size; see <a href="/stickers#video-sticker-requirements"></a><a href="https://core.telegram.org/stickers#video-sticker-requirements">https://core.telegram.org/stickers#video-sticker-requirements</a> for video sticker technical requirements. Pass a <em>file_id</em> as a String to send a file that already exists on the Telegram servers, pass an HTTP URL as a String for Telegram to get a file from the Internet, or upload a new one using multipart/form-data. <a href="#sending-files">More information on Sending Files »</a>. Animated and video sticker set thumbnails can't be uploaded via HTTP URL. If omitted, then the thumbnail is dropped and the first sticker is used as the thumbnail. |
| format | String | true | Format of the thumbnail, must be one of “static” for a <strong>.WEBP</strong> or <strong>.PNG</strong> image, “animated” for a <strong>.TGS</strong> animation, or “video” for a <strong>WEBM</strong> video |

#### setCustomEmojiStickerSetThumbnail

    setCustomEmojiStickerSetThumbnail(name: String, custom_emoji_id: String)

<p>Use this method to set the thumbnail of a custom emoji sticker set. Returns <em>True</em> on success.</p>

| name | type | required | description |
|---|---|---|---|
| name | String | true | Sticker set name |
| custom_emoji_id | String | false | Custom emoji identifier of a sticker from the sticker set; pass an empty string to drop the thumbnail and use the first sticker as the thumbnail. |

#### deleteStickerSet

    deleteStickerSet(name: String)

<p>Use this method to delete a sticker set that was created by the bot. Returns <em>True</em> on success.</p>

| name | type | required | description |
|---|---|---|---|
| name | String | true | Sticker set name |



## Inline mode

### Data Types
#### InlineQuery

    InlineQuery(id: String, from: User, query: String, offset: String, chat_type: String, location: Location)

<p>This object represents an incoming inline query. When the user sends an empty query, your bot could return some default or trending results.</p>

| name | type | required | description |
|---|---|---|---|
| id | String | true | Unique identifier for this query |
| from | User | true | Sender |
| query | String | true | Text of the query (up to 256 characters) |
| offset | String | true | Offset of the results to be returned, can be controlled by the bot |
| chat_type | String | false | <em>Optional</em>. Type of the chat from which the inline query was sent. Can be either “sender” for a private chat with the inline query sender, “private”, “group”, “supergroup”, or “channel”. The chat type should be always known for requests sent from official clients and most third-party clients, unless the request was sent from a secret chat |
| location | Location | false | <em>Optional</em>. Sender location, only for bots that request user location |

#### InlineQueryResultsButton

    InlineQueryResultsButton(text: String, web_app: WebAppInfo, start_parameter: String)

<p>This object represents a button to be shown above inline query results. You <strong>must</strong> use exactly one of the optional fields.</p>

| name | type | required | description |
|---|---|---|---|
| text | String | true | Label text on the button |
| web_app | WebAppInfo | false | <em>Optional</em>. Description of the <a href="/bots/webapps">Web App</a> that will be launched when the user presses the button. The Web App will be able to switch back to the inline mode using the method <a href="/bots/webapps#initializing-mini-apps">switchInlineQuery</a> inside the Web App. |
| start_parameter | String | false | <em>Optional</em>. <a href="/bots/features#deep-linking">Deep-linking</a> parameter for the /start message sent to the bot when a user presses the button. 1-64 characters, only <code>A-Z</code>, <code>a-z</code>, <code>0-9</code>, <code>_</code> and <code>-</code> are allowed.<br><br><em>Example:</em> An inline bot that sends YouTube videos can ask the user to connect the bot to their YouTube account to adapt search results accordingly. To do this, it displays a 'Connect your YouTube account' button above the results, or even before showing any. The user presses the button, switches to a private chat with the bot and, in doing so, passes a start parameter that instructs the bot to return an OAuth link. Once done, the bot can offer a <a href="#inlinekeyboardmarkup"><em>switch_inline</em></a> button so that the user can easily return to the chat where they wanted to use the bot's inline capabilities. |

#### InlineQueryResultArticle

    InlineQueryResultArticle(type: String, id: String, title: String, input_message_content: InputMessageContent, reply_markup: InlineKeyboardMarkup, url: String, hide_url: Boolean, description: String, thumbnail_url: String, thumbnail_width: Integer, thumbnail_height: Integer)

<p>Represents a link to an article or web page.</p>

| name | type | required | description |
|---|---|---|---|
| type | String | true | Type of the result, must be <em>article</em> |
| id | String | true | Unique identifier for this result, 1-64 Bytes |
| title | String | true | Title of the result |
| input_message_content | InputMessageContent | true | Content of the message to be sent |
| reply_markup | InlineKeyboardMarkup | false | <em>Optional</em>. <a href="/bots/features#inline-keyboards">Inline keyboard</a> attached to the message |
| url | String | false | <em>Optional</em>. URL of the result |
| hide_url | Boolean | false | <em>Optional</em>. Pass <em>True</em> if you don't want the URL to be shown in the message |
| description | String | false | <em>Optional</em>. Short description of the result |
| thumbnail_url | String | false | <em>Optional</em>. Url of the thumbnail for the result |
| thumbnail_width | Integer | false | <em>Optional</em>. Thumbnail width |
| thumbnail_height | Integer | false | <em>Optional</em>. Thumbnail height |

#### InlineQueryResultPhoto

    InlineQueryResultPhoto(type: String, id: String, photo_url: String, thumbnail_url: String, photo_width: Integer, photo_height: Integer, title: String, description: String, caption: String, parse_mode: ParseMode, caption_entities: List<MessageEntity>, show_caption_above_media: Boolean, reply_markup: InlineKeyboardMarkup, input_message_content: InputMessageContent)

<p>Represents a link to a photo. By default, this photo will be sent by the user with optional caption. Alternatively, you can use <em>input_message_content</em> to send a message with the specified content instead of the photo.</p>

| name | type | required | description |
|---|---|---|---|
| type | String | true | Type of the result, must be <em>photo</em> |
| id | String | true | Unique identifier for this result, 1-64 bytes |
| photo_url | String | true | A valid URL of the photo. Photo must be in <strong>JPEG</strong> format. Photo size must not exceed 5MB |
| thumbnail_url | String | true | URL of the thumbnail for the photo |
| photo_width | Integer | false | <em>Optional</em>. Width of the photo |
| photo_height | Integer | false | <em>Optional</em>. Height of the photo |
| title | String | false | <em>Optional</em>. Title for the result |
| description | String | false | <em>Optional</em>. Short description of the result |
| caption | String | false | <em>Optional</em>. Caption of the photo to be sent, 0-1024 characters after entities parsing |
| parse_mode | ParseMode | false | <em>Optional</em>. Mode for parsing entities in the photo caption. See <a href="#formatting-options">formatting options</a> for more details. |
| caption_entities | List<MessageEntity> | false | <em>Optional</em>. List of special entities that appear in the caption, which can be specified instead of <em>parse_mode</em> |
| show_caption_above_media | Boolean | false | <em>Optional</em>. Pass <em>True</em>, if the caption must be shown above the message media |
| reply_markup | InlineKeyboardMarkup | false | <em>Optional</em>. <a href="/bots/features#inline-keyboards">Inline keyboard</a> attached to the message |
| input_message_content | InputMessageContent | false | <em>Optional</em>. Content of the message to be sent instead of the photo |

#### InlineQueryResultGif

    InlineQueryResultGif(type: String, id: String, gif_url: String, gif_width: Integer, gif_height: Integer, gif_duration: Integer, thumbnail_url: String, thumbnail_mime_type: String, title: String, caption: String, parse_mode: ParseMode, caption_entities: List<MessageEntity>, show_caption_above_media: Boolean, reply_markup: InlineKeyboardMarkup, input_message_content: InputMessageContent)

<p>Represents a link to an animated GIF file. By default, this animated GIF file will be sent by the user with optional caption. Alternatively, you can use <em>input_message_content</em> to send a message with the specified content instead of the animation.</p>

| name | type | required | description |
|---|---|---|---|
| type | String | true | Type of the result, must be <em>gif</em> |
| id | String | true | Unique identifier for this result, 1-64 bytes |
| gif_url | String | true | A valid URL for the GIF file. File size must not exceed 1MB |
| gif_width | Integer | false | <em>Optional</em>. Width of the GIF |
| gif_height | Integer | false | <em>Optional</em>. Height of the GIF |
| gif_duration | Integer | false | <em>Optional</em>. Duration of the GIF in seconds |
| thumbnail_url | String | true | URL of the static (JPEG or GIF) or animated (MPEG4) thumbnail for the result |
| thumbnail_mime_type | String | false | <em>Optional</em>. MIME type of the thumbnail, must be one of “image/jpeg”, “image/gif”, or “video/mp4”. Defaults to “image/jpeg” |
| title | String | false | <em>Optional</em>. Title for the result |
| caption | String | false | <em>Optional</em>. Caption of the GIF file to be sent, 0-1024 characters after entities parsing |
| parse_mode | ParseMode | false | <em>Optional</em>. Mode for parsing entities in the caption. See <a href="#formatting-options">formatting options</a> for more details. |
| caption_entities | List<MessageEntity> | false | <em>Optional</em>. List of special entities that appear in the caption, which can be specified instead of <em>parse_mode</em> |
| show_caption_above_media | Boolean | false | <em>Optional</em>. Pass <em>True</em>, if the caption must be shown above the message media |
| reply_markup | InlineKeyboardMarkup | false | <em>Optional</em>. <a href="/bots/features#inline-keyboards">Inline keyboard</a> attached to the message |
| input_message_content | InputMessageContent | false | <em>Optional</em>. Content of the message to be sent instead of the GIF animation |

#### InlineQueryResultMpeg4Gif

    InlineQueryResultMpeg4Gif(type: String, id: String, mpeg4_url: String, mpeg4_width: Integer, mpeg4_height: Integer, mpeg4_duration: Integer, thumbnail_url: String, thumbnail_mime_type: String, title: String, caption: String, parse_mode: ParseMode, caption_entities: List<MessageEntity>, show_caption_above_media: Boolean, reply_markup: InlineKeyboardMarkup, input_message_content: InputMessageContent)

<p>Represents a link to a video animation (H.264/MPEG-4 AVC video without sound). By default, this animated MPEG-4 file will be sent by the user with optional caption. Alternatively, you can use <em>input_message_content</em> to send a message with the specified content instead of the animation.</p>

| name | type | required | description |
|---|---|---|---|
| type | String | true | Type of the result, must be <em>mpeg4_gif</em> |
| id | String | true | Unique identifier for this result, 1-64 bytes |
| mpeg4_url | String | true | A valid URL for the MPEG4 file. File size must not exceed 1MB |
| mpeg4_width | Integer | false | <em>Optional</em>. Video width |
| mpeg4_height | Integer | false | <em>Optional</em>. Video height |
| mpeg4_duration | Integer | false | <em>Optional</em>. Video duration in seconds |
| thumbnail_url | String | true | URL of the static (JPEG or GIF) or animated (MPEG4) thumbnail for the result |
| thumbnail_mime_type | String | false | <em>Optional</em>. MIME type of the thumbnail, must be one of “image/jpeg”, “image/gif”, or “video/mp4”. Defaults to “image/jpeg” |
| title | String | false | <em>Optional</em>. Title for the result |
| caption | String | false | <em>Optional</em>. Caption of the MPEG-4 file to be sent, 0-1024 characters after entities parsing |
| parse_mode | ParseMode | false | <em>Optional</em>. Mode for parsing entities in the caption. See <a href="#formatting-options">formatting options</a> for more details. |
| caption_entities | List<MessageEntity> | false | <em>Optional</em>. List of special entities that appear in the caption, which can be specified instead of <em>parse_mode</em> |
| show_caption_above_media | Boolean | false | <em>Optional</em>. Pass <em>True</em>, if the caption must be shown above the message media |
| reply_markup | InlineKeyboardMarkup | false | <em>Optional</em>. <a href="/bots/features#inline-keyboards">Inline keyboard</a> attached to the message |
| input_message_content | InputMessageContent | false | <em>Optional</em>. Content of the message to be sent instead of the video animation |

#### InlineQueryResultVideo

    InlineQueryResultVideo(type: String, id: String, video_url: String, mime_type: String, thumbnail_url: String, title: String, caption: String, parse_mode: ParseMode, caption_entities: List<MessageEntity>, show_caption_above_media: Boolean, video_width: Integer, video_height: Integer, video_duration: Integer, description: String, reply_markup: InlineKeyboardMarkup, input_message_content: InputMessageContent)

<p>Represents a link to a page containing an embedded video player or a video file. By default, this video file will be sent by the user with an optional caption. Alternatively, you can use <em>input_message_content</em> to send a message with the specified content instead of the video.</p><blockquote>
 <p>If an InlineQueryResultVideo message contains an embedded video (e.g., YouTube), you <strong>must</strong> replace its content using <em>input_message_content</em>.</p>
</blockquote>

| name | type | required | description |
|---|---|---|---|
| type | String | true | Type of the result, must be <em>video</em> |
| id | String | true | Unique identifier for this result, 1-64 bytes |
| video_url | String | true | A valid URL for the embedded video player or video file |
| mime_type | String | true | MIME type of the content of the video URL, “text/html” or “video/mp4” |
| thumbnail_url | String | true | URL of the thumbnail (JPEG only) for the video |
| title | String | true | Title for the result |
| caption | String | false | <em>Optional</em>. Caption of the video to be sent, 0-1024 characters after entities parsing |
| parse_mode | ParseMode | false | <em>Optional</em>. Mode for parsing entities in the video caption. See <a href="#formatting-options">formatting options</a> for more details. |
| caption_entities | List<MessageEntity> | false | <em>Optional</em>. List of special entities that appear in the caption, which can be specified instead of <em>parse_mode</em> |
| show_caption_above_media | Boolean | false | <em>Optional</em>. Pass <em>True</em>, if the caption must be shown above the message media |
| video_width | Integer | false | <em>Optional</em>. Video width |
| video_height | Integer | false | <em>Optional</em>. Video height |
| video_duration | Integer | false | <em>Optional</em>. Video duration in seconds |
| description | String | false | <em>Optional</em>. Short description of the result |
| reply_markup | InlineKeyboardMarkup | false | <em>Optional</em>. <a href="/bots/features#inline-keyboards">Inline keyboard</a> attached to the message |
| input_message_content | InputMessageContent | false | <em>Optional</em>. Content of the message to be sent instead of the video. This field is <strong>required</strong> if InlineQueryResultVideo is used to send an HTML-page as a result (e.g., a YouTube video). |

#### InlineQueryResultAudio

    InlineQueryResultAudio(type: String, id: String, audio_url: String, title: String, caption: String, parse_mode: ParseMode, caption_entities: List<MessageEntity>, performer: String, audio_duration: Integer, reply_markup: InlineKeyboardMarkup, input_message_content: InputMessageContent)

<p>Represents a link to an MP3 audio file. By default, this audio file will be sent by the user. Alternatively, you can use <em>input_message_content</em> to send a message with the specified content instead of the audio.</p>

| name | type | required | description |
|---|---|---|---|
| type | String | true | Type of the result, must be <em>audio</em> |
| id | String | true | Unique identifier for this result, 1-64 bytes |
| audio_url | String | true | A valid URL for the audio file |
| title | String | true | Title |
| caption | String | false | <em>Optional</em>. Caption, 0-1024 characters after entities parsing |
| parse_mode | ParseMode | false | <em>Optional</em>. Mode for parsing entities in the audio caption. See <a href="#formatting-options">formatting options</a> for more details. |
| caption_entities | List<MessageEntity> | false | <em>Optional</em>. List of special entities that appear in the caption, which can be specified instead of <em>parse_mode</em> |
| performer | String | false | <em>Optional</em>. Performer |
| audio_duration | Integer | false | <em>Optional</em>. Audio duration in seconds |
| reply_markup | InlineKeyboardMarkup | false | <em>Optional</em>. <a href="/bots/features#inline-keyboards">Inline keyboard</a> attached to the message |
| input_message_content | InputMessageContent | false | <em>Optional</em>. Content of the message to be sent instead of the audio |

#### InlineQueryResultVoice

    InlineQueryResultVoice(type: String, id: String, voice_url: String, title: String, caption: String, parse_mode: ParseMode, caption_entities: List<MessageEntity>, voice_duration: Integer, reply_markup: InlineKeyboardMarkup, input_message_content: InputMessageContent)

<p>Represents a link to a voice recording in an .OGG container encoded with OPUS. By default, this voice recording will be sent by the user. Alternatively, you can use <em>input_message_content</em> to send a message with the specified content instead of the the voice message.</p>

| name | type | required | description |
|---|---|---|---|
| type | String | true | Type of the result, must be <em>voice</em> |
| id | String | true | Unique identifier for this result, 1-64 bytes |
| voice_url | String | true | A valid URL for the voice recording |
| title | String | true | Recording title |
| caption | String | false | <em>Optional</em>. Caption, 0-1024 characters after entities parsing |
| parse_mode | ParseMode | false | <em>Optional</em>. Mode for parsing entities in the voice message caption. See <a href="#formatting-options">formatting options</a> for more details. |
| caption_entities | List<MessageEntity> | false | <em>Optional</em>. List of special entities that appear in the caption, which can be specified instead of <em>parse_mode</em> |
| voice_duration | Integer | false | <em>Optional</em>. Recording duration in seconds |
| reply_markup | InlineKeyboardMarkup | false | <em>Optional</em>. <a href="/bots/features#inline-keyboards">Inline keyboard</a> attached to the message |
| input_message_content | InputMessageContent | false | <em>Optional</em>. Content of the message to be sent instead of the voice recording |

#### InlineQueryResultDocument

    InlineQueryResultDocument(type: String, id: String, title: String, caption: String, parse_mode: ParseMode, caption_entities: List<MessageEntity>, document_url: String, mime_type: String, description: String, reply_markup: InlineKeyboardMarkup, input_message_content: InputMessageContent, thumbnail_url: String, thumbnail_width: Integer, thumbnail_height: Integer)

<p>Represents a link to a file. By default, this file will be sent by the user with an optional caption. Alternatively, you can use <em>input_message_content</em> to send a message with the specified content instead of the file. Currently, only <strong>.PDF</strong> and <strong>.ZIP</strong> files can be sent using this method.</p>

| name | type | required | description |
|---|---|---|---|
| type | String | true | Type of the result, must be <em>document</em> |
| id | String | true | Unique identifier for this result, 1-64 bytes |
| title | String | true | Title for the result |
| caption | String | false | <em>Optional</em>. Caption of the document to be sent, 0-1024 characters after entities parsing |
| parse_mode | ParseMode | false | <em>Optional</em>. Mode for parsing entities in the document caption. See <a href="#formatting-options">formatting options</a> for more details. |
| caption_entities | List<MessageEntity> | false | <em>Optional</em>. List of special entities that appear in the caption, which can be specified instead of <em>parse_mode</em> |
| document_url | String | true | A valid URL for the file |
| mime_type | String | true | MIME type of the content of the file, either “application/pdf” or “application/zip” |
| description | String | false | <em>Optional</em>. Short description of the result |
| reply_markup | InlineKeyboardMarkup | false | <em>Optional</em>. Inline keyboard attached to the message |
| input_message_content | InputMessageContent | false | <em>Optional</em>. Content of the message to be sent instead of the file |
| thumbnail_url | String | false | <em>Optional</em>. URL of the thumbnail (JPEG only) for the file |
| thumbnail_width | Integer | false | <em>Optional</em>. Thumbnail width |
| thumbnail_height | Integer | false | <em>Optional</em>. Thumbnail height |

#### InlineQueryResultLocation

    InlineQueryResultLocation(type: String, id: String, latitude: Float, longitude: Float, title: String, horizontal_accuracy: Float, live_period: Integer, heading: Integer, proximity_alert_radius: Integer, reply_markup: InlineKeyboardMarkup, input_message_content: InputMessageContent, thumbnail_url: String, thumbnail_width: Integer, thumbnail_height: Integer)

<p>Represents a location on a map. By default, the location will be sent by the user. Alternatively, you can use <em>input_message_content</em> to send a message with the specified content instead of the location.</p>

| name | type | required | description |
|---|---|---|---|
| type | String | true | Type of the result, must be <em>location</em> |
| id | String | true | Unique identifier for this result, 1-64 Bytes |
| latitude | Float | true | Location latitude in degrees |
| longitude | Float | true | Location longitude in degrees |
| title | String | true | Location title |
| horizontal_accuracy | Float | false | <em>Optional</em>. The radius of uncertainty for the location, measured in meters; 0-1500 |
| live_period | Integer | false | <em>Optional</em>. Period in seconds during which the location can be updated, should be between 60 and 86400, or 0x7FFFFFFF for live locations that can be edited indefinitely. |
| heading | Integer | false | <em>Optional</em>. For live locations, a direction in which the user is moving, in degrees. Must be between 1 and 360 if specified. |
| proximity_alert_radius | Integer | false | <em>Optional</em>. For live locations, a maximum distance for proximity alerts about approaching another chat member, in meters. Must be between 1 and 100000 if specified. |
| reply_markup | InlineKeyboardMarkup | false | <em>Optional</em>. <a href="/bots/features#inline-keyboards">Inline keyboard</a> attached to the message |
| input_message_content | InputMessageContent | false | <em>Optional</em>. Content of the message to be sent instead of the location |
| thumbnail_url | String | false | <em>Optional</em>. Url of the thumbnail for the result |
| thumbnail_width | Integer | false | <em>Optional</em>. Thumbnail width |
| thumbnail_height | Integer | false | <em>Optional</em>. Thumbnail height |

#### InlineQueryResultVenue

    InlineQueryResultVenue(type: String, id: String, latitude: Float, longitude: Float, title: String, address: String, foursquare_id: String, foursquare_type: String, google_place_id: String, google_place_type: String, reply_markup: InlineKeyboardMarkup, input_message_content: InputMessageContent, thumbnail_url: String, thumbnail_width: Integer, thumbnail_height: Integer)

<p>Represents a venue. By default, the venue will be sent by the user. Alternatively, you can use <em>input_message_content</em> to send a message with the specified content instead of the venue.</p>

| name | type | required | description |
|---|---|---|---|
| type | String | true | Type of the result, must be <em>venue</em> |
| id | String | true | Unique identifier for this result, 1-64 Bytes |
| latitude | Float | true | Latitude of the venue location in degrees |
| longitude | Float | true | Longitude of the venue location in degrees |
| title | String | true | Title of the venue |
| address | String | true | Address of the venue |
| foursquare_id | String | false | <em>Optional</em>. Foursquare identifier of the venue if known |
| foursquare_type | String | false | <em>Optional</em>. Foursquare type of the venue, if known. (For example, “arts_entertainment/default”, “arts_entertainment/aquarium” or “food/icecream”.) |
| google_place_id | String | false | <em>Optional</em>. Google Places identifier of the venue |
| google_place_type | String | false | <em>Optional</em>. Google Places type of the venue. (See <a href="https://developers.google.com/places/web-service/supported_types">supported types</a>.) |
| reply_markup | InlineKeyboardMarkup | false | <em>Optional</em>. <a href="/bots/features#inline-keyboards">Inline keyboard</a> attached to the message |
| input_message_content | InputMessageContent | false | <em>Optional</em>. Content of the message to be sent instead of the venue |
| thumbnail_url | String | false | <em>Optional</em>. Url of the thumbnail for the result |
| thumbnail_width | Integer | false | <em>Optional</em>. Thumbnail width |
| thumbnail_height | Integer | false | <em>Optional</em>. Thumbnail height |

#### InlineQueryResultContact

    InlineQueryResultContact(type: String, id: String, phone_number: String, first_name: String, last_name: String, vcard: String, reply_markup: InlineKeyboardMarkup, input_message_content: InputMessageContent, thumbnail_url: String, thumbnail_width: Integer, thumbnail_height: Integer)

<p>Represents a contact with a phone number. By default, this contact will be sent by the user. Alternatively, you can use <em>input_message_content</em> to send a message with the specified content instead of the contact.</p>

| name | type | required | description |
|---|---|---|---|
| type | String | true | Type of the result, must be <em>contact</em> |
| id | String | true | Unique identifier for this result, 1-64 Bytes |
| phone_number | String | true | Contact's phone number |
| first_name | String | true | Contact's first name |
| last_name | String | false | <em>Optional</em>. Contact's last name |
| vcard | String | false | <em>Optional</em>. Additional data about the contact in the form of a <a href="https://en.wikipedia.org/wiki/VCard">vCard</a>, 0-2048 bytes |
| reply_markup | InlineKeyboardMarkup | false | <em>Optional</em>. <a href="/bots/features#inline-keyboards">Inline keyboard</a> attached to the message |
| input_message_content | InputMessageContent | false | <em>Optional</em>. Content of the message to be sent instead of the contact |
| thumbnail_url | String | false | <em>Optional</em>. Url of the thumbnail for the result |
| thumbnail_width | Integer | false | <em>Optional</em>. Thumbnail width |
| thumbnail_height | Integer | false | <em>Optional</em>. Thumbnail height |

#### InlineQueryResultGame

    InlineQueryResultGame(type: String, id: String, game_short_name: String, reply_markup: InlineKeyboardMarkup)

<p>Represents a <a href="#games">Game</a>.</p>

| name | type | required | description |
|---|---|---|---|
| type | String | true | Type of the result, must be <em>game</em> |
| id | String | true | Unique identifier for this result, 1-64 bytes |
| game_short_name | String | true | Short name of the game |
| reply_markup | InlineKeyboardMarkup | false | <em>Optional</em>. <a href="/bots/features#inline-keyboards">Inline keyboard</a> attached to the message |

#### InlineQueryResultCachedPhoto

    InlineQueryResultCachedPhoto(type: String, id: String, photo_file_id: String, title: String, description: String, caption: String, parse_mode: ParseMode, caption_entities: List<MessageEntity>, show_caption_above_media: Boolean, reply_markup: InlineKeyboardMarkup, input_message_content: InputMessageContent)

<p>Represents a link to a photo stored on the Telegram servers. By default, this photo will be sent by the user with an optional caption. Alternatively, you can use <em>input_message_content</em> to send a message with the specified content instead of the photo.</p>

| name | type | required | description |
|---|---|---|---|
| type | String | true | Type of the result, must be <em>photo</em> |
| id | String | true | Unique identifier for this result, 1-64 bytes |
| photo_file_id | String | true | A valid file identifier of the photo |
| title | String | false | <em>Optional</em>. Title for the result |
| description | String | false | <em>Optional</em>. Short description of the result |
| caption | String | false | <em>Optional</em>. Caption of the photo to be sent, 0-1024 characters after entities parsing |
| parse_mode | ParseMode | false | <em>Optional</em>. Mode for parsing entities in the photo caption. See <a href="#formatting-options">formatting options</a> for more details. |
| caption_entities | List<MessageEntity> | false | <em>Optional</em>. List of special entities that appear in the caption, which can be specified instead of <em>parse_mode</em> |
| show_caption_above_media | Boolean | false | <em>Optional</em>. Pass <em>True</em>, if the caption must be shown above the message media |
| reply_markup | InlineKeyboardMarkup | false | <em>Optional</em>. <a href="/bots/features#inline-keyboards">Inline keyboard</a> attached to the message |
| input_message_content | InputMessageContent | false | <em>Optional</em>. Content of the message to be sent instead of the photo |

#### InlineQueryResultCachedGif

    InlineQueryResultCachedGif(type: String, id: String, gif_file_id: String, title: String, caption: String, parse_mode: ParseMode, caption_entities: List<MessageEntity>, show_caption_above_media: Boolean, reply_markup: InlineKeyboardMarkup, input_message_content: InputMessageContent)

<p>Represents a link to an animated GIF file stored on the Telegram servers. By default, this animated GIF file will be sent by the user with an optional caption. Alternatively, you can use <em>input_message_content</em> to send a message with specified content instead of the animation.</p>

| name | type | required | description |
|---|---|---|---|
| type | String | true | Type of the result, must be <em>gif</em> |
| id | String | true | Unique identifier for this result, 1-64 bytes |
| gif_file_id | String | true | A valid file identifier for the GIF file |
| title | String | false | <em>Optional</em>. Title for the result |
| caption | String | false | <em>Optional</em>. Caption of the GIF file to be sent, 0-1024 characters after entities parsing |
| parse_mode | ParseMode | false | <em>Optional</em>. Mode for parsing entities in the caption. See <a href="#formatting-options">formatting options</a> for more details. |
| caption_entities | List<MessageEntity> | false | <em>Optional</em>. List of special entities that appear in the caption, which can be specified instead of <em>parse_mode</em> |
| show_caption_above_media | Boolean | false | <em>Optional</em>. Pass <em>True</em>, if the caption must be shown above the message media |
| reply_markup | InlineKeyboardMarkup | false | <em>Optional</em>. <a href="/bots/features#inline-keyboards">Inline keyboard</a> attached to the message |
| input_message_content | InputMessageContent | false | <em>Optional</em>. Content of the message to be sent instead of the GIF animation |

#### InlineQueryResultCachedMpeg4Gif

    InlineQueryResultCachedMpeg4Gif(type: String, id: String, mpeg4_file_id: String, title: String, caption: String, parse_mode: ParseMode, caption_entities: List<MessageEntity>, show_caption_above_media: Boolean, reply_markup: InlineKeyboardMarkup, input_message_content: InputMessageContent)

<p>Represents a link to a video animation (H.264/MPEG-4 AVC video without sound) stored on the Telegram servers. By default, this animated MPEG-4 file will be sent by the user with an optional caption. Alternatively, you can use <em>input_message_content</em> to send a message with the specified content instead of the animation.</p>

| name | type | required | description |
|---|---|---|---|
| type | String | true | Type of the result, must be <em>mpeg4_gif</em> |
| id | String | true | Unique identifier for this result, 1-64 bytes |
| mpeg4_file_id | String | true | A valid file identifier for the MPEG4 file |
| title | String | false | <em>Optional</em>. Title for the result |
| caption | String | false | <em>Optional</em>. Caption of the MPEG-4 file to be sent, 0-1024 characters after entities parsing |
| parse_mode | ParseMode | false | <em>Optional</em>. Mode for parsing entities in the caption. See <a href="#formatting-options">formatting options</a> for more details. |
| caption_entities | List<MessageEntity> | false | <em>Optional</em>. List of special entities that appear in the caption, which can be specified instead of <em>parse_mode</em> |
| show_caption_above_media | Boolean | false | <em>Optional</em>. Pass <em>True</em>, if the caption must be shown above the message media |
| reply_markup | InlineKeyboardMarkup | false | <em>Optional</em>. <a href="/bots/features#inline-keyboards">Inline keyboard</a> attached to the message |
| input_message_content | InputMessageContent | false | <em>Optional</em>. Content of the message to be sent instead of the video animation |

#### InlineQueryResultCachedSticker

    InlineQueryResultCachedSticker(type: String, id: String, sticker_file_id: String, reply_markup: InlineKeyboardMarkup, input_message_content: InputMessageContent)

<p>Represents a link to a sticker stored on the Telegram servers. By default, this sticker will be sent by the user. Alternatively, you can use <em>input_message_content</em> to send a message with the specified content instead of the sticker.</p>

| name | type | required | description |
|---|---|---|---|
| type | String | true | Type of the result, must be <em>sticker</em> |
| id | String | true | Unique identifier for this result, 1-64 bytes |
| sticker_file_id | String | true | A valid file identifier of the sticker |
| reply_markup | InlineKeyboardMarkup | false | <em>Optional</em>. <a href="/bots/features#inline-keyboards">Inline keyboard</a> attached to the message |
| input_message_content | InputMessageContent | false | <em>Optional</em>. Content of the message to be sent instead of the sticker |

#### InlineQueryResultCachedDocument

    InlineQueryResultCachedDocument(type: String, id: String, title: String, document_file_id: String, description: String, caption: String, parse_mode: ParseMode, caption_entities: List<MessageEntity>, reply_markup: InlineKeyboardMarkup, input_message_content: InputMessageContent)

<p>Represents a link to a file stored on the Telegram servers. By default, this file will be sent by the user with an optional caption. Alternatively, you can use <em>input_message_content</em> to send a message with the specified content instead of the file.</p>

| name | type | required | description |
|---|---|---|---|
| type | String | true | Type of the result, must be <em>document</em> |
| id | String | true | Unique identifier for this result, 1-64 bytes |
| title | String | true | Title for the result |
| document_file_id | String | true | A valid file identifier for the file |
| description | String | false | <em>Optional</em>. Short description of the result |
| caption | String | false | <em>Optional</em>. Caption of the document to be sent, 0-1024 characters after entities parsing |
| parse_mode | ParseMode | false | <em>Optional</em>. Mode for parsing entities in the document caption. See <a href="#formatting-options">formatting options</a> for more details. |
| caption_entities | List<MessageEntity> | false | <em>Optional</em>. List of special entities that appear in the caption, which can be specified instead of <em>parse_mode</em> |
| reply_markup | InlineKeyboardMarkup | false | <em>Optional</em>. <a href="/bots/features#inline-keyboards">Inline keyboard</a> attached to the message |
| input_message_content | InputMessageContent | false | <em>Optional</em>. Content of the message to be sent instead of the file |

#### InlineQueryResultCachedVideo

    InlineQueryResultCachedVideo(type: String, id: String, video_file_id: String, title: String, description: String, caption: String, parse_mode: ParseMode, caption_entities: List<MessageEntity>, show_caption_above_media: Boolean, reply_markup: InlineKeyboardMarkup, input_message_content: InputMessageContent)

<p>Represents a link to a video file stored on the Telegram servers. By default, this video file will be sent by the user with an optional caption. Alternatively, you can use <em>input_message_content</em> to send a message with the specified content instead of the video.</p>

| name | type | required | description |
|---|---|---|---|
| type | String | true | Type of the result, must be <em>video</em> |
| id | String | true | Unique identifier for this result, 1-64 bytes |
| video_file_id | String | true | A valid file identifier for the video file |
| title | String | true | Title for the result |
| description | String | false | <em>Optional</em>. Short description of the result |
| caption | String | false | <em>Optional</em>. Caption of the video to be sent, 0-1024 characters after entities parsing |
| parse_mode | ParseMode | false | <em>Optional</em>. Mode for parsing entities in the video caption. See <a href="#formatting-options">formatting options</a> for more details. |
| caption_entities | List<MessageEntity> | false | <em>Optional</em>. List of special entities that appear in the caption, which can be specified instead of <em>parse_mode</em> |
| show_caption_above_media | Boolean | false | <em>Optional</em>. Pass <em>True</em>, if the caption must be shown above the message media |
| reply_markup | InlineKeyboardMarkup | false | <em>Optional</em>. <a href="/bots/features#inline-keyboards">Inline keyboard</a> attached to the message |
| input_message_content | InputMessageContent | false | <em>Optional</em>. Content of the message to be sent instead of the video |

#### InlineQueryResultCachedVoice

    InlineQueryResultCachedVoice(type: String, id: String, voice_file_id: String, title: String, caption: String, parse_mode: ParseMode, caption_entities: List<MessageEntity>, reply_markup: InlineKeyboardMarkup, input_message_content: InputMessageContent)

<p>Represents a link to a voice message stored on the Telegram servers. By default, this voice message will be sent by the user. Alternatively, you can use <em>input_message_content</em> to send a message with the specified content instead of the voice message.</p>

| name | type | required | description |
|---|---|---|---|
| type | String | true | Type of the result, must be <em>voice</em> |
| id | String | true | Unique identifier for this result, 1-64 bytes |
| voice_file_id | String | true | A valid file identifier for the voice message |
| title | String | true | Voice message title |
| caption | String | false | <em>Optional</em>. Caption, 0-1024 characters after entities parsing |
| parse_mode | ParseMode | false | <em>Optional</em>. Mode for parsing entities in the voice message caption. See <a href="#formatting-options">formatting options</a> for more details. |
| caption_entities | List<MessageEntity> | false | <em>Optional</em>. List of special entities that appear in the caption, which can be specified instead of <em>parse_mode</em> |
| reply_markup | InlineKeyboardMarkup | false | <em>Optional</em>. <a href="/bots/features#inline-keyboards">Inline keyboard</a> attached to the message |
| input_message_content | InputMessageContent | false | <em>Optional</em>. Content of the message to be sent instead of the voice message |

#### InlineQueryResultCachedAudio

    InlineQueryResultCachedAudio(type: String, id: String, audio_file_id: String, caption: String, parse_mode: ParseMode, caption_entities: List<MessageEntity>, reply_markup: InlineKeyboardMarkup, input_message_content: InputMessageContent)

<p>Represents a link to an MP3 audio file stored on the Telegram servers. By default, this audio file will be sent by the user. Alternatively, you can use <em>input_message_content</em> to send a message with the specified content instead of the audio.</p>

| name | type | required | description |
|---|---|---|---|
| type | String | true | Type of the result, must be <em>audio</em> |
| id | String | true | Unique identifier for this result, 1-64 bytes |
| audio_file_id | String | true | A valid file identifier for the audio file |
| caption | String | false | <em>Optional</em>. Caption, 0-1024 characters after entities parsing |
| parse_mode | ParseMode | false | <em>Optional</em>. Mode for parsing entities in the audio caption. See <a href="#formatting-options">formatting options</a> for more details. |
| caption_entities | List<MessageEntity> | false | <em>Optional</em>. List of special entities that appear in the caption, which can be specified instead of <em>parse_mode</em> |
| reply_markup | InlineKeyboardMarkup | false | <em>Optional</em>. <a href="/bots/features#inline-keyboards">Inline keyboard</a> attached to the message |
| input_message_content | InputMessageContent | false | <em>Optional</em>. Content of the message to be sent instead of the audio |

#### InputTextMessageContent

    InputTextMessageContent(message_text: String, parse_mode: ParseMode, entities: List<MessageEntity>, link_preview_options: LinkPreviewOptions)

<p>Represents the <a href="#inputmessagecontent">content</a> of a text message to be sent as the result of an inline query.</p>

| name | type | required | description |
|---|---|---|---|
| message_text | String | true | Text of the message to be sent, 1-4096 characters |
| parse_mode | ParseMode | false | <em>Optional</em>. Mode for parsing entities in the message text. See <a href="#formatting-options">formatting options</a> for more details. |
| entities | List<MessageEntity> | false | <em>Optional</em>. List of special entities that appear in message text, which can be specified instead of <em>parse_mode</em> |
| link_preview_options | LinkPreviewOptions | false | <em>Optional</em>. Link preview generation options for the message |

#### InputLocationMessageContent

    InputLocationMessageContent(latitude: Float, longitude: Float, horizontal_accuracy: Float, live_period: Integer, heading: Integer, proximity_alert_radius: Integer)

<p>Represents the <a href="#inputmessagecontent">content</a> of a location message to be sent as the result of an inline query.</p>

| name | type | required | description |
|---|---|---|---|
| latitude | Float | true | Latitude of the location in degrees |
| longitude | Float | true | Longitude of the location in degrees |
| horizontal_accuracy | Float | false | <em>Optional</em>. The radius of uncertainty for the location, measured in meters; 0-1500 |
| live_period | Integer | false | <em>Optional</em>. Period in seconds during which the location can be updated, should be between 60 and 86400, or 0x7FFFFFFF for live locations that can be edited indefinitely. |
| heading | Integer | false | <em>Optional</em>. For live locations, a direction in which the user is moving, in degrees. Must be between 1 and 360 if specified. |
| proximity_alert_radius | Integer | false | <em>Optional</em>. For live locations, a maximum distance for proximity alerts about approaching another chat member, in meters. Must be between 1 and 100000 if specified. |

#### InputVenueMessageContent

    InputVenueMessageContent(latitude: Float, longitude: Float, title: String, address: String, foursquare_id: String, foursquare_type: String, google_place_id: String, google_place_type: String)

<p>Represents the <a href="#inputmessagecontent">content</a> of a venue message to be sent as the result of an inline query.</p>

| name | type | required | description |
|---|---|---|---|
| latitude | Float | true | Latitude of the venue in degrees |
| longitude | Float | true | Longitude of the venue in degrees |
| title | String | true | Name of the venue |
| address | String | true | Address of the venue |
| foursquare_id | String | false | <em>Optional</em>. Foursquare identifier of the venue, if known |
| foursquare_type | String | false | <em>Optional</em>. Foursquare type of the venue, if known. (For example, “arts_entertainment/default”, “arts_entertainment/aquarium” or “food/icecream”.) |
| google_place_id | String | false | <em>Optional</em>. Google Places identifier of the venue |
| google_place_type | String | false | <em>Optional</em>. Google Places type of the venue. (See <a href="https://developers.google.com/places/web-service/supported_types">supported types</a>.) |

#### InputContactMessageContent

    InputContactMessageContent(phone_number: String, first_name: String, last_name: String, vcard: String)

<p>Represents the <a href="#inputmessagecontent">content</a> of a contact message to be sent as the result of an inline query.</p>

| name | type | required | description |
|---|---|---|---|
| phone_number | String | true | Contact's phone number |
| first_name | String | true | Contact's first name |
| last_name | String | false | <em>Optional</em>. Contact's last name |
| vcard | String | false | <em>Optional</em>. Additional data about the contact in the form of a <a href="https://en.wikipedia.org/wiki/VCard">vCard</a>, 0-2048 bytes |

#### InputInvoiceMessageContent

    InputInvoiceMessageContent(title: String, description: String, payload: String, provider_token: String, currency: String, prices: List<LabeledPrice>, max_tip_amount: Integer, suggested_tip_amounts: List<Integer>, provider_data: String, photo_url: String, photo_size: Integer, photo_width: Integer, photo_height: Integer, need_name: Boolean, need_phone_number: Boolean, need_email: Boolean, need_shipping_address: Boolean, send_phone_number_to_provider: Boolean, send_email_to_provider: Boolean, is_flexible: Boolean)

<p>Represents the <a href="#inputmessagecontent">content</a> of an invoice message to be sent as the result of an inline query.</p>

| name | type | required | description |
|---|---|---|---|
| title | String | true | Product name, 1-32 characters |
| description | String | true | Product description, 1-255 characters |
| payload | String | true | Bot-defined invoice payload, 1-128 bytes. This will not be displayed to the user, use for your internal processes. |
| provider_token | String | false | <em>Optional</em>. Payment provider token, obtained via <a href="https://t.me/botfather">@BotFather</a>. Pass an empty string for payments in <a href="https://t.me/BotNews/90">Telegram Stars</a>. |
| currency | String | true | Three-letter ISO 4217 currency code, see <a href="/bots/payments#supported-currencies">more on currencies</a>. Pass “XTR” for payments in <a href="https://t.me/BotNews/90">Telegram Stars</a>. |
| prices | List<LabeledPrice> | true | Price breakdown, a JSON-serialized list of components (e.g. product price, tax, discount, delivery cost, delivery tax, bonus, etc.). Must contain exactly one item for payments in <a href="https://t.me/BotNews/90">Telegram Stars</a>. |
| max_tip_amount | Integer | false | <em>Optional</em>. The maximum accepted amount for tips in the <em>smallest units</em> of the currency (integer, <strong>not</strong> float/double). For example, for a maximum tip of <code>US$ 1.45</code> pass <code>max_tip_amount = 145</code>. See the <em>exp</em> parameter in <a href="/bots/payments/currencies.json">currencies.json</a>, it shows the number of digits past the decimal point for each currency (2 for the majority of currencies). Defaults to 0. Not supported for payments in <a href="https://t.me/BotNews/90">Telegram Stars</a>. |
| suggested_tip_amounts | List<Integer> | false | <em>Optional</em>. A JSON-serialized array of suggested amounts of tip in the <em>smallest units</em> of the currency (integer, <strong>not</strong> float/double). At most 4 suggested tip amounts can be specified. The suggested tip amounts must be positive, passed in a strictly increased order and must not exceed <em>max_tip_amount</em>. |
| provider_data | String | false | <em>Optional</em>. A JSON-serialized object for data about the invoice, which will be shared with the payment provider. A detailed description of the required fields should be provided by the payment provider. |
| photo_url | String | false | <em>Optional</em>. URL of the product photo for the invoice. Can be a photo of the goods or a marketing image for a service. |
| photo_size | Integer | false | <em>Optional</em>. Photo size in bytes |
| photo_width | Integer | false | <em>Optional</em>. Photo width |
| photo_height | Integer | false | <em>Optional</em>. Photo height |
| need_name | Boolean | false | <em>Optional</em>. Pass <em>True</em> if you require the user's full name to complete the order. Ignored for payments in <a href="https://t.me/BotNews/90">Telegram Stars</a>. |
| need_phone_number | Boolean | false | <em>Optional</em>. Pass <em>True</em> if you require the user's phone number to complete the order. Ignored for payments in <a href="https://t.me/BotNews/90">Telegram Stars</a>. |
| need_email | Boolean | false | <em>Optional</em>. Pass <em>True</em> if you require the user's email address to complete the order. Ignored for payments in <a href="https://t.me/BotNews/90">Telegram Stars</a>. |
| need_shipping_address | Boolean | false | <em>Optional</em>. Pass <em>True</em> if you require the user's shipping address to complete the order. Ignored for payments in <a href="https://t.me/BotNews/90">Telegram Stars</a>. |
| send_phone_number_to_provider | Boolean | false | <em>Optional</em>. Pass <em>True</em> if the user's phone number should be sent to the provider. Ignored for payments in <a href="https://t.me/BotNews/90">Telegram Stars</a>. |
| send_email_to_provider | Boolean | false | <em>Optional</em>. Pass <em>True</em> if the user's email address should be sent to the provider. Ignored for payments in <a href="https://t.me/BotNews/90">Telegram Stars</a>. |
| is_flexible | Boolean | false | <em>Optional</em>. Pass <em>True</em> if the final price depends on the shipping method. Ignored for payments in <a href="https://t.me/BotNews/90">Telegram Stars</a>. |

#### ChosenInlineResult

    ChosenInlineResult(result_id: String, from: User, location: Location, inline_message_id: String, query: String)

<p>Represents a <a href="#inlinequeryresult">result</a> of an inline query that was chosen by the user and sent to their chat partner.</p><p><strong>Note:</strong> It is necessary to enable <a href="/bots/inline#collecting-feedback">inline feedback</a> via <a href="https://t.me/botfather">@BotFather</a> in order to receive these objects in updates.</p>

| name | type | required | description |
|---|---|---|---|
| result_id | String | true | The unique identifier for the result that was chosen |
| from | User | true | The user that chose the result |
| location | Location | false | <em>Optional</em>. Sender location, only for bots that require user location |
| inline_message_id | String | false | <em>Optional</em>. Identifier of the sent inline message. Available only if there is an <a href="#inlinekeyboardmarkup">inline keyboard</a> attached to the message. Will be also received in <a href="#callbackquery">callback queries</a> and can be used to <a href="#updating-messages">edit</a> the message. |
| query | String | true | The query that was used to obtain the result |

#### SentWebAppMessage

    SentWebAppMessage(inline_message_id: String)

<p>Describes an inline message sent by a <a href="/bots/webapps">Web App</a> on behalf of a user.</p>

| name | type | required | description |
|---|---|---|---|
| inline_message_id | String | false | <em>Optional</em>. Identifier of the sent inline message. Available only if there is an <a href="#inlinekeyboardmarkup">inline keyboard</a> attached to the message. |


### Methods
#### answerInlineQuery

    answerInlineQuery(inline_query_id: String, results: List<InlineQueryResult>, cache_time: Integer, is_personal: Boolean, next_offset: String, button: InlineQueryResultsButton)

<p>Use this method to send answers to an inline query. On success, <em>True</em> is returned.<br>No more than <strong>50</strong> results per query are allowed.</p>

| name | type | required | description |
|---|---|---|---|
| inline_query_id | String | true | Unique identifier for the answered query |
| results | List<InlineQueryResult> | true | A JSON-serialized array of results for the inline query |
| cache_time | Integer | false | The maximum amount of time in seconds that the result of the inline query may be cached on the server. Defaults to 300. |
| is_personal | Boolean | false | Pass <em>True</em> if results may be cached on the server side only for the user that sent the query. By default, results may be returned to any user who sends the same query. |
| next_offset | String | false | Pass the offset that a client should send in the next query with the same text to receive more results. Pass an empty string if there are no more results or if you don't support pagination. Offset length can't exceed 64 bytes. |
| button | InlineQueryResultsButton | false | A JSON-serialized object describing a button to be shown above inline query results |

#### answerWebAppQuery

    answerWebAppQuery(web_app_query_id: String, result: InlineQueryResult)

<p>Use this method to set the result of an interaction with a <a href="/bots/webapps">Web App</a> and send a corresponding message on behalf of the user to the chat from which the query originated. On success, a <a href="#sentwebappmessage">SentWebAppMessage</a> object is returned.</p>

| name | type | required | description |
|---|---|---|---|
| web_app_query_id | String | true | Unique identifier for the query to be answered |
| result | InlineQueryResult | true | A JSON-serialized object describing the message to be sent |



## Payments

### Data Types
#### LabeledPrice

    LabeledPrice(label: String, amount: Integer)

<p>This object represents a portion of the price for goods or services.</p>

| name | type | required | description |
|---|---|---|---|
| label | String | true | Portion label |
| amount | Integer | true | Price of the product in the <em>smallest units</em> of the <a href="/bots/payments#supported-currencies">currency</a> (integer, <strong>not</strong> float/double). For example, for a price of <code>US$ 1.45</code> pass <code>amount = 145</code>. See the <em>exp</em> parameter in <a href="/bots/payments/currencies.json">currencies.json</a>, it shows the number of digits past the decimal point for each currency (2 for the majority of currencies). |

#### Invoice

    Invoice(title: String, description: String, start_parameter: String, currency: String, total_amount: Integer)

<p>This object contains basic information about an invoice.</p>

| name | type | required | description |
|---|---|---|---|
| title | String | true | Product name |
| description | String | true | Product description |
| start_parameter | String | true | Unique bot deep-linking parameter that can be used to generate this invoice |
| currency | String | true | Three-letter ISO 4217 <a href="/bots/payments#supported-currencies">currency</a> code, or “XTR” for payments in <a href="https://t.me/BotNews/90">Telegram Stars</a> |
| total_amount | Integer | true | Total price in the <em>smallest units</em> of the currency (integer, <strong>not</strong> float/double). For example, for a price of <code>US$ 1.45</code> pass <code>amount = 145</code>. See the <em>exp</em> parameter in <a href="/bots/payments/currencies.json">currencies.json</a>, it shows the number of digits past the decimal point for each currency (2 for the majority of currencies). |

#### ShippingAddress

    ShippingAddress(country_code: String, state: String, city: String, street_line1: String, street_line2: String, post_code: String)

<p>This object represents a shipping address.</p>

| name | type | required | description |
|---|---|---|---|
| country_code | String | true | Two-letter <a href="https://en.wikipedia.org/wiki/ISO_3166-1_alpha-2">ISO 3166-1 alpha-2</a> country code |
| state | String | true | State, if applicable |
| city | String | true | City |
| street_line1 | String | true | First line for the address |
| street_line2 | String | true | Second line for the address |
| post_code | String | true | Address post code |

#### OrderInfo

    OrderInfo(name: String, phone_number: String, email: String, shipping_address: ShippingAddress)

<p>This object represents information about an order.</p>

| name | type | required | description |
|---|---|---|---|
| name | String | false | <em>Optional</em>. User name |
| phone_number | String | false | <em>Optional</em>. User's phone number |
| email | String | false | <em>Optional</em>. User email |
| shipping_address | ShippingAddress | false | <em>Optional</em>. User shipping address |

#### ShippingOption

    ShippingOption(id: String, title: String, prices: List<LabeledPrice>)

<p>This object represents one shipping option.</p>

| name | type | required | description |
|---|---|---|---|
| id | String | true | Shipping option identifier |
| title | String | true | Option title |
| prices | List<LabeledPrice> | true | List of price portions |

#### SuccessfulPayment

    SuccessfulPayment(currency: String, total_amount: Integer, invoice_payload: String, shipping_option_id: String, order_info: OrderInfo, telegram_payment_charge_id: String, provider_payment_charge_id: String)

<p>This object contains basic information about a successful payment.</p>

| name | type | required | description |
|---|---|---|---|
| currency | String | true | Three-letter ISO 4217 <a href="/bots/payments#supported-currencies">currency</a> code, or “XTR” for payments in <a href="https://t.me/BotNews/90">Telegram Stars</a> |
| total_amount | Integer | true | Total price in the <em>smallest units</em> of the currency (integer, <strong>not</strong> float/double). For example, for a price of <code>US$ 1.45</code> pass <code>amount = 145</code>. See the <em>exp</em> parameter in <a href="/bots/payments/currencies.json">currencies.json</a>, it shows the number of digits past the decimal point for each currency (2 for the majority of currencies). |
| invoice_payload | String | true | Bot specified invoice payload |
| shipping_option_id | String | false | <em>Optional</em>. Identifier of the shipping option chosen by the user |
| order_info | OrderInfo | false | <em>Optional</em>. Order information provided by the user |
| telegram_payment_charge_id | String | true | Telegram payment identifier |
| provider_payment_charge_id | String | true | Provider payment identifier |

#### ShippingQuery

    ShippingQuery(id: String, from: User, invoice_payload: String, shipping_address: ShippingAddress)

<p>This object contains information about an incoming shipping query.</p>

| name | type | required | description |
|---|---|---|---|
| id | String | true | Unique query identifier |
| from | User | true | User who sent the query |
| invoice_payload | String | true | Bot specified invoice payload |
| shipping_address | ShippingAddress | true | User specified shipping address |

#### PreCheckoutQuery

    PreCheckoutQuery(id: String, from: User, currency: String, total_amount: Integer, invoice_payload: String, shipping_option_id: String, order_info: OrderInfo)

<p>This object contains information about an incoming pre-checkout query.</p>

| name | type | required | description |
|---|---|---|---|
| id | String | true | Unique query identifier |
| from | User | true | User who sent the query |
| currency | String | true | Three-letter ISO 4217 <a href="/bots/payments#supported-currencies">currency</a> code, or “XTR” for payments in <a href="https://t.me/BotNews/90">Telegram Stars</a> |
| total_amount | Integer | true | Total price in the <em>smallest units</em> of the currency (integer, <strong>not</strong> float/double). For example, for a price of <code>US$ 1.45</code> pass <code>amount = 145</code>. See the <em>exp</em> parameter in <a href="/bots/payments/currencies.json">currencies.json</a>, it shows the number of digits past the decimal point for each currency (2 for the majority of currencies). |
| invoice_payload | String | true | Bot specified invoice payload |
| shipping_option_id | String | false | <em>Optional</em>. Identifier of the shipping option chosen by the user |
| order_info | OrderInfo | false | <em>Optional</em>. Order information provided by the user |

#### RevenueWithdrawalStatePending

    RevenueWithdrawalStatePending(type: String)

<p>The withdrawal is in progress.</p>

| name | type | required | description |
|---|---|---|---|
| type | String | true | Type of the state, always “pending” |

#### RevenueWithdrawalStateSucceeded

    RevenueWithdrawalStateSucceeded(type: String, date: Integer, url: String)

<p>The withdrawal succeeded.</p>

| name | type | required | description |
|---|---|---|---|
| type | String | true | Type of the state, always “succeeded” |
| date | Integer | true | Date the withdrawal was completed in Unix time |
| url | String | true | An HTTPS URL that can be used to see transaction details |

#### RevenueWithdrawalStateFailed

    RevenueWithdrawalStateFailed(type: String)

<p>The withdrawal failed and the transaction was refunded.</p>

| name | type | required | description |
|---|---|---|---|
| type | String | true | Type of the state, always “failed” |

#### TransactionPartnerFragment

    TransactionPartnerFragment(type: String, withdrawal_state: RevenueWithdrawalState)

<p>Describes a withdrawal transaction with Fragment.</p>

| name | type | required | description |
|---|---|---|---|
| type | String | true | Type of the transaction partner, always “fragment” |
| withdrawal_state | RevenueWithdrawalState | false | <em>Optional</em>. State of the transaction if the transaction is outgoing |

#### TransactionPartnerUser

    TransactionPartnerUser(type: String, user: User)

<p>Describes a transaction with a user.</p>

| name | type | required | description |
|---|---|---|---|
| type | String | true | Type of the transaction partner, always “user” |
| user | User | true | Information about the user |

#### TransactionPartnerOther

    TransactionPartnerOther(type: String)

<p>Describes a transaction with an unknown source or recipient.</p>

| name | type | required | description |
|---|---|---|---|
| type | String | true | Type of the transaction partner, always “other” |

#### StarTransaction

    StarTransaction(id: String, amount: Integer, date: Integer, source: TransactionPartner, receiver: TransactionPartner)

<p>Describes a Telegram Star transaction.</p>

| name | type | required | description |
|---|---|---|---|
| id | String | true | Unique identifier of the transaction. Coincides with the identifer of the original transaction for refund transactions. Coincides with <em>SuccessfulPayment.telegram_payment_charge_id</em> for successful incoming payments from users. |
| amount | Integer | true | Number of Telegram Stars transferred by the transaction |
| date | Integer | true | Date the transaction was created in Unix time |
| source | TransactionPartner | false | <em>Optional</em>. Source of an incoming transaction (e.g., a user purchasing goods or services, Fragment refunding a failed withdrawal). Only for incoming transactions |
| receiver | TransactionPartner | false | <em>Optional</em>. Receiver of an outgoing transaction (e.g., a user for a purchase refund, Fragment for a withdrawal). Only for outgoing transactions |

#### StarTransactions

    StarTransactions(transactions: List<StarTransaction>)

<p>Contains a list of Telegram Star transactions.</p>

| name | type | required | description |
|---|---|---|---|
| transactions | List<StarTransaction> | true | The list of transactions |


### Methods
#### sendInvoice

    sendInvoice(chat_id: IntegerOrString, message_thread_id: Integer, title: String, description: String, payload: String, provider_token: String, currency: String, prices: List<LabeledPrice>, max_tip_amount: Integer, suggested_tip_amounts: List<Integer>, start_parameter: String, provider_data: String, photo_url: String, photo_size: Integer, photo_width: Integer, photo_height: Integer, need_name: Boolean, need_phone_number: Boolean, need_email: Boolean, need_shipping_address: Boolean, send_phone_number_to_provider: Boolean, send_email_to_provider: Boolean, is_flexible: Boolean, disable_notification: Boolean, protect_content: Boolean, message_effect_id: String, reply_parameters: ReplyParameters, reply_markup: InlineKeyboardMarkup)

<p>Use this method to send invoices. On success, the sent <a href="#message">Message</a> is returned.</p>

| name | type | required | description |
|---|---|---|---|
| chat_id | IntegerOrString | true | Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>) |
| message_thread_id | Integer | false | Unique identifier for the target message thread (topic) of the forum; for forum supergroups only |
| title | String | true | Product name, 1-32 characters |
| description | String | true | Product description, 1-255 characters |
| payload | String | true | Bot-defined invoice payload, 1-128 bytes. This will not be displayed to the user, use for your internal processes. |
| provider_token | String | false | Payment provider token, obtained via <a href="https://t.me/botfather">@BotFather</a>. Pass an empty string for payments in <a href="https://t.me/BotNews/90">Telegram Stars</a>. |
| currency | String | true | Three-letter ISO 4217 currency code, see <a href="/bots/payments#supported-currencies">more on currencies</a>. Pass “XTR” for payments in <a href="https://t.me/BotNews/90">Telegram Stars</a>. |
| prices | List<LabeledPrice> | true | Price breakdown, a JSON-serialized list of components (e.g. product price, tax, discount, delivery cost, delivery tax, bonus, etc.). Must contain exactly one item for payments in <a href="https://t.me/BotNews/90">Telegram Stars</a>. |
| max_tip_amount | Integer | false | The maximum accepted amount for tips in the <em>smallest units</em> of the currency (integer, <strong>not</strong> float/double). For example, for a maximum tip of <code>US$ 1.45</code> pass <code>max_tip_amount = 145</code>. See the <em>exp</em> parameter in <a href="/bots/payments/currencies.json">currencies.json</a>, it shows the number of digits past the decimal point for each currency (2 for the majority of currencies). Defaults to 0. Not supported for payments in <a href="https://t.me/BotNews/90">Telegram Stars</a>. |
| suggested_tip_amounts | List<Integer> | false | A JSON-serialized array of suggested amounts of tips in the <em>smallest units</em> of the currency (integer, <strong>not</strong> float/double). At most 4 suggested tip amounts can be specified. The suggested tip amounts must be positive, passed in a strictly increased order and must not exceed <em>max_tip_amount</em>. |
| start_parameter | String | false | Unique deep-linking parameter. If left empty, <strong>forwarded copies</strong> of the sent message will have a <em>Pay</em> button, allowing multiple users to pay directly from the forwarded message, using the same invoice. If non-empty, forwarded copies of the sent message will have a <em>URL</em> button with a deep link to the bot (instead of a <em>Pay</em> button), with the value used as the start parameter |
| provider_data | String | false | JSON-serialized data about the invoice, which will be shared with the payment provider. A detailed description of required fields should be provided by the payment provider. |
| photo_url | String | false | URL of the product photo for the invoice. Can be a photo of the goods or a marketing image for a service. People like it better when they see what they are paying for. |
| photo_size | Integer | false | Photo size in bytes |
| photo_width | Integer | false | Photo width |
| photo_height | Integer | false | Photo height |
| need_name | Boolean | false | Pass <em>True</em> if you require the user's full name to complete the order. Ignored for payments in <a href="https://t.me/BotNews/90">Telegram Stars</a>. |
| need_phone_number | Boolean | false | Pass <em>True</em> if you require the user's phone number to complete the order. Ignored for payments in <a href="https://t.me/BotNews/90">Telegram Stars</a>. |
| need_email | Boolean | false | Pass <em>True</em> if you require the user's email address to complete the order. Ignored for payments in <a href="https://t.me/BotNews/90">Telegram Stars</a>. |
| need_shipping_address | Boolean | false | Pass <em>True</em> if you require the user's shipping address to complete the order. Ignored for payments in <a href="https://t.me/BotNews/90">Telegram Stars</a>. |
| send_phone_number_to_provider | Boolean | false | Pass <em>True</em> if the user's phone number should be sent to the provider. Ignored for payments in <a href="https://t.me/BotNews/90">Telegram Stars</a>. |
| send_email_to_provider | Boolean | false | Pass <em>True</em> if the user's email address should be sent to the provider. Ignored for payments in <a href="https://t.me/BotNews/90">Telegram Stars</a>. |
| is_flexible | Boolean | false | Pass <em>True</em> if the final price depends on the shipping method. Ignored for payments in <a href="https://t.me/BotNews/90">Telegram Stars</a>. |
| disable_notification | Boolean | false | Sends the message <a href="https://telegram.org/blog/channels-2-0#silent-messages">silently</a>. Users will receive a notification with no sound. |
| protect_content | Boolean | false | Protects the contents of the sent message from forwarding and saving |
| message_effect_id | String | false | Unique identifier of the message effect to be added to the message; for private chats only |
| reply_parameters | ReplyParameters | false | Description of the message to reply to |
| reply_markup | InlineKeyboardMarkup | false | A JSON-serialized object for an <a href="/bots/features#inline-keyboards">inline keyboard</a>. If empty, one 'Pay <code>total price</code>' button will be shown. If not empty, the first button must be a Pay button. |

#### createInvoiceLink

    createInvoiceLink(title: String, description: String, payload: String, provider_token: String, currency: String, prices: List<LabeledPrice>, max_tip_amount: Integer, suggested_tip_amounts: List<Integer>, provider_data: String, photo_url: String, photo_size: Integer, photo_width: Integer, photo_height: Integer, need_name: Boolean, need_phone_number: Boolean, need_email: Boolean, need_shipping_address: Boolean, send_phone_number_to_provider: Boolean, send_email_to_provider: Boolean, is_flexible: Boolean)

<p>Use this method to create a link for an invoice. Returns the created invoice link as <em>String</em> on success.</p>

| name | type | required | description |
|---|---|---|---|
| title | String | true | Product name, 1-32 characters |
| description | String | true | Product description, 1-255 characters |
| payload | String | true | Bot-defined invoice payload, 1-128 bytes. This will not be displayed to the user, use for your internal processes. |
| provider_token | String | false | Payment provider token, obtained via <a href="https://t.me/botfather">@BotFather</a>. Pass an empty string for payments in <a href="https://t.me/BotNews/90">Telegram Stars</a>. |
| currency | String | true | Three-letter ISO 4217 currency code, see <a href="/bots/payments#supported-currencies">more on currencies</a>. Pass “XTR” for payments in <a href="https://t.me/BotNews/90">Telegram Stars</a>. |
| prices | List<LabeledPrice> | true | Price breakdown, a JSON-serialized list of components (e.g. product price, tax, discount, delivery cost, delivery tax, bonus, etc.). Must contain exactly one item for payments in <a href="https://t.me/BotNews/90">Telegram Stars</a>. |
| max_tip_amount | Integer | false | The maximum accepted amount for tips in the <em>smallest units</em> of the currency (integer, <strong>not</strong> float/double). For example, for a maximum tip of <code>US$ 1.45</code> pass <code>max_tip_amount = 145</code>. See the <em>exp</em> parameter in <a href="/bots/payments/currencies.json">currencies.json</a>, it shows the number of digits past the decimal point for each currency (2 for the majority of currencies). Defaults to 0. Not supported for payments in <a href="https://t.me/BotNews/90">Telegram Stars</a>. |
| suggested_tip_amounts | List<Integer> | false | A JSON-serialized array of suggested amounts of tips in the <em>smallest units</em> of the currency (integer, <strong>not</strong> float/double). At most 4 suggested tip amounts can be specified. The suggested tip amounts must be positive, passed in a strictly increased order and must not exceed <em>max_tip_amount</em>. |
| provider_data | String | false | JSON-serialized data about the invoice, which will be shared with the payment provider. A detailed description of required fields should be provided by the payment provider. |
| photo_url | String | false | URL of the product photo for the invoice. Can be a photo of the goods or a marketing image for a service. |
| photo_size | Integer | false | Photo size in bytes |
| photo_width | Integer | false | Photo width |
| photo_height | Integer | false | Photo height |
| need_name | Boolean | false | Pass <em>True</em> if you require the user's full name to complete the order. Ignored for payments in <a href="https://t.me/BotNews/90">Telegram Stars</a>. |
| need_phone_number | Boolean | false | Pass <em>True</em> if you require the user's phone number to complete the order. Ignored for payments in <a href="https://t.me/BotNews/90">Telegram Stars</a>. |
| need_email | Boolean | false | Pass <em>True</em> if you require the user's email address to complete the order. Ignored for payments in <a href="https://t.me/BotNews/90">Telegram Stars</a>. |
| need_shipping_address | Boolean | false | Pass <em>True</em> if you require the user's shipping address to complete the order. Ignored for payments in <a href="https://t.me/BotNews/90">Telegram Stars</a>. |
| send_phone_number_to_provider | Boolean | false | Pass <em>True</em> if the user's phone number should be sent to the provider. Ignored for payments in <a href="https://t.me/BotNews/90">Telegram Stars</a>. |
| send_email_to_provider | Boolean | false | Pass <em>True</em> if the user's email address should be sent to the provider. Ignored for payments in <a href="https://t.me/BotNews/90">Telegram Stars</a>. |
| is_flexible | Boolean | false | Pass <em>True</em> if the final price depends on the shipping method. Ignored for payments in <a href="https://t.me/BotNews/90">Telegram Stars</a>. |

#### answerShippingQuery

    answerShippingQuery(shipping_query_id: String, ok: Boolean, shipping_options: List<ShippingOption>, error_message: String)

<p>If you sent an invoice requesting a shipping address and the parameter <em>is_flexible</em> was specified, the Bot API will send an <a href="#update">Update</a> with a <em>shipping_query</em> field to the bot. Use this method to reply to shipping queries. On success, <em>True</em> is returned.</p>

| name | type | required | description |
|---|---|---|---|
| shipping_query_id | String | true | Unique identifier for the query to be answered |
| ok | Boolean | true | Pass <em>True</em> if delivery to the specified address is possible and <em>False</em> if there are any problems (for example, if delivery to the specified address is not possible) |
| shipping_options | List<ShippingOption> | false | Required if <em>ok</em> is <em>True</em>. A JSON-serialized array of available shipping options. |
| error_message | String | false | Required if <em>ok</em> is <em>False</em>. Error message in human readable form that explains why it is impossible to complete the order (e.g. "Sorry, delivery to your desired address is unavailable'). Telegram will display this message to the user. |

#### answerPreCheckoutQuery

    answerPreCheckoutQuery(pre_checkout_query_id: String, ok: Boolean, error_message: String)

<p>Once the user has confirmed their payment and shipping details, the Bot API sends the final confirmation in the form of an <a href="#update">Update</a> with the field <em>pre_checkout_query</em>. Use this method to respond to such pre-checkout queries. On success, <em>True</em> is returned. <strong>Note:</strong> The Bot API must receive an answer within 10 seconds after the pre-checkout query was sent.</p>

| name | type | required | description |
|---|---|---|---|
| pre_checkout_query_id | String | true | Unique identifier for the query to be answered |
| ok | Boolean | true | Specify <em>True</em> if everything is alright (goods are available, etc.) and the bot is ready to proceed with the order. Use <em>False</em> if there are any problems. |
| error_message | String | false | Required if <em>ok</em> is <em>False</em>. Error message in human readable form that explains the reason for failure to proceed with the checkout (e.g. "Sorry, somebody just bought the last of our amazing black T-shirts while you were busy filling out your payment details. Please choose a different color or garment!"). Telegram will display this message to the user. |

#### getStarTransactions

    getStarTransactions(offset: Integer, limit: Integer)

<p>Returns the bot's Telegram Star transactions in chronological order. On success, returns a <a href="#startransactions">StarTransactions</a> object.</p>

| name | type | required | description |
|---|---|---|---|
| offset | Integer | false | Number of transactions to skip in the response |
| limit | Integer | false | The maximum number of transactions to be retrieved. Values between 1-100 are accepted. Defaults to 100. |

#### refundStarPayment

    refundStarPayment(user_id: Integer, telegram_payment_charge_id: String)

<p>Refunds a successful payment in <a href="https://t.me/BotNews/90">Telegram Stars</a>. Returns <em>True</em> on success.</p>

| name | type | required | description |
|---|---|---|---|
| user_id | Integer | true | Identifier of the user whose payment will be refunded |
| telegram_payment_charge_id | String | true | Telegram payment identifier |



## Telegram Passport

### Data Types
#### PassportData

    PassportData(data: List<EncryptedPassportElement>, credentials: EncryptedCredentials)

<p>Describes Telegram Passport data shared with the bot by the user.</p>

| name | type | required | description |
|---|---|---|---|
| data | List<EncryptedPassportElement> | true | Array with information about documents and other Telegram Passport elements that was shared with the bot |
| credentials | EncryptedCredentials | true | Encrypted credentials required to decrypt the data |

#### PassportFile

    PassportFile(file_id: String, file_unique_id: String, file_size: Integer, file_date: Integer)

<p>This object represents a file uploaded to Telegram Passport. Currently all Telegram Passport files are in JPEG format when decrypted and don't exceed 10MB.</p>

| name | type | required | description |
|---|---|---|---|
| file_id | String | true | Identifier for this file, which can be used to download or reuse the file |
| file_unique_id | String | true | Unique identifier for this file, which is supposed to be the same over time and for different bots. Can't be used to download or reuse the file. |
| file_size | Integer | true | File size in bytes |
| file_date | Integer | true | Unix time when the file was uploaded |

#### EncryptedPassportElement

    EncryptedPassportElement(type: String, data: String, phone_number: String, email: String, files: List<PassportFile>, front_side: PassportFile, reverse_side: PassportFile, selfie: PassportFile, translation: List<PassportFile>, hash: String)

<p>Describes documents or other Telegram Passport elements shared with the bot by the user.</p>

| name | type | required | description |
|---|---|---|---|
| type | String | true | Element type. One of “personal_details”, “passport”, “driver_license”, “identity_card”, “internal_passport”, “address”, “utility_bill”, “bank_statement”, “rental_agreement”, “passport_registration”, “temporary_registration”, “phone_number”, “email”. |
| data | String | false | <em>Optional</em>. Base64-encoded encrypted Telegram Passport element data provided by the user; available only for “personal_details”, “passport”, “driver_license”, “identity_card”, “internal_passport” and “address” types. Can be decrypted and verified using the accompanying <a href="#encryptedcredentials">EncryptedCredentials</a>. |
| phone_number | String | false | <em>Optional</em>. User's verified phone number; available only for “phone_number” type |
| email | String | false | <em>Optional</em>. User's verified email address; available only for “email” type |
| files | List<PassportFile> | false | <em>Optional</em>. Array of encrypted files with documents provided by the user; available only for “utility_bill”, “bank_statement”, “rental_agreement”, “passport_registration” and “temporary_registration” types. Files can be decrypted and verified using the accompanying <a href="#encryptedcredentials">EncryptedCredentials</a>. |
| front_side | PassportFile | false | <em>Optional</em>. Encrypted file with the front side of the document, provided by the user; available only for “passport”, “driver_license”, “identity_card” and “internal_passport”. The file can be decrypted and verified using the accompanying <a href="#encryptedcredentials">EncryptedCredentials</a>. |
| reverse_side | PassportFile | false | <em>Optional</em>. Encrypted file with the reverse side of the document, provided by the user; available only for “driver_license” and “identity_card”. The file can be decrypted and verified using the accompanying <a href="#encryptedcredentials">EncryptedCredentials</a>. |
| selfie | PassportFile | false | <em>Optional</em>. Encrypted file with the selfie of the user holding a document, provided by the user; available if requested for “passport”, “driver_license”, “identity_card” and “internal_passport”. The file can be decrypted and verified using the accompanying <a href="#encryptedcredentials">EncryptedCredentials</a>. |
| translation | List<PassportFile> | false | <em>Optional</em>. Array of encrypted files with translated versions of documents provided by the user; available if requested for “passport”, “driver_license”, “identity_card”, “internal_passport”, “utility_bill”, “bank_statement”, “rental_agreement”, “passport_registration” and “temporary_registration” types. Files can be decrypted and verified using the accompanying <a href="#encryptedcredentials">EncryptedCredentials</a>. |
| hash | String | true | Base64-encoded element hash for using in <a href="#passportelementerrorunspecified">PassportElementErrorUnspecified</a> |

#### EncryptedCredentials

    EncryptedCredentials(data: String, hash: String, secret: String)

<p>Describes data required for decrypting and authenticating <a href="#encryptedpassportelement">EncryptedPassportElement</a>. See the <a href="/passport#receiving-information">Telegram Passport Documentation</a> for a complete description of the data decryption and authentication processes.</p>

| name | type | required | description |
|---|---|---|---|
| data | String | true | Base64-encoded encrypted JSON-serialized data with unique user's payload, data hashes and secrets required for <a href="#encryptedpassportelement">EncryptedPassportElement</a> decryption and authentication |
| hash | String | true | Base64-encoded data hash for data authentication |
| secret | String | true | Base64-encoded secret, encrypted with the bot's public RSA key, required for data decryption |

#### PassportElementErrorDataField

    PassportElementErrorDataField(source: String, type: String, field_name: String, data_hash: String, message: String)

<p>Represents an issue in one of the data fields that was provided by the user. The error is considered resolved when the field's value changes.</p>

| name | type | required | description |
|---|---|---|---|
| source | String | true | Error source, must be <em>data</em> |
| type | String | true | The section of the user's Telegram Passport which has the error, one of “personal_details”, “passport”, “driver_license”, “identity_card”, “internal_passport”, “address” |
| field_name | String | true | Name of the data field which has the error |
| data_hash | String | true | Base64-encoded data hash |
| message | String | true | Error message |

#### PassportElementErrorFrontSide

    PassportElementErrorFrontSide(source: String, type: String, file_hash: String, message: String)

<p>Represents an issue with the front side of a document. The error is considered resolved when the file with the front side of the document changes.</p>

| name | type | required | description |
|---|---|---|---|
| source | String | true | Error source, must be <em>front_side</em> |
| type | String | true | The section of the user's Telegram Passport which has the issue, one of “passport”, “driver_license”, “identity_card”, “internal_passport” |
| file_hash | String | true | Base64-encoded hash of the file with the front side of the document |
| message | String | true | Error message |

#### PassportElementErrorReverseSide

    PassportElementErrorReverseSide(source: String, type: String, file_hash: String, message: String)

<p>Represents an issue with the reverse side of a document. The error is considered resolved when the file with reverse side of the document changes.</p>

| name | type | required | description |
|---|---|---|---|
| source | String | true | Error source, must be <em>reverse_side</em> |
| type | String | true | The section of the user's Telegram Passport which has the issue, one of “driver_license”, “identity_card” |
| file_hash | String | true | Base64-encoded hash of the file with the reverse side of the document |
| message | String | true | Error message |

#### PassportElementErrorSelfie

    PassportElementErrorSelfie(source: String, type: String, file_hash: String, message: String)

<p>Represents an issue with the selfie with a document. The error is considered resolved when the file with the selfie changes.</p>

| name | type | required | description |
|---|---|---|---|
| source | String | true | Error source, must be <em>selfie</em> |
| type | String | true | The section of the user's Telegram Passport which has the issue, one of “passport”, “driver_license”, “identity_card”, “internal_passport” |
| file_hash | String | true | Base64-encoded hash of the file with the selfie |
| message | String | true | Error message |

#### PassportElementErrorFile

    PassportElementErrorFile(source: String, type: String, file_hash: String, message: String)

<p>Represents an issue with a document scan. The error is considered resolved when the file with the document scan changes.</p>

| name | type | required | description |
|---|---|---|---|
| source | String | true | Error source, must be <em>file</em> |
| type | String | true | The section of the user's Telegram Passport which has the issue, one of “utility_bill”, “bank_statement”, “rental_agreement”, “passport_registration”, “temporary_registration” |
| file_hash | String | true | Base64-encoded file hash |
| message | String | true | Error message |

#### PassportElementErrorFiles

    PassportElementErrorFiles(source: String, type: String, file_hashes: List<String>, message: String)

<p>Represents an issue with a list of scans. The error is considered resolved when the list of files containing the scans changes.</p>

| name | type | required | description |
|---|---|---|---|
| source | String | true | Error source, must be <em>files</em> |
| type | String | true | The section of the user's Telegram Passport which has the issue, one of “utility_bill”, “bank_statement”, “rental_agreement”, “passport_registration”, “temporary_registration” |
| file_hashes | List<String> | true | List of base64-encoded file hashes |
| message | String | true | Error message |

#### PassportElementErrorTranslationFile

    PassportElementErrorTranslationFile(source: String, type: String, file_hash: String, message: String)

<p>Represents an issue with one of the files that constitute the translation of a document. The error is considered resolved when the file changes.</p>

| name | type | required | description |
|---|---|---|---|
| source | String | true | Error source, must be <em>translation_file</em> |
| type | String | true | Type of element of the user's Telegram Passport which has the issue, one of “passport”, “driver_license”, “identity_card”, “internal_passport”, “utility_bill”, “bank_statement”, “rental_agreement”, “passport_registration”, “temporary_registration” |
| file_hash | String | true | Base64-encoded file hash |
| message | String | true | Error message |

#### PassportElementErrorTranslationFiles

    PassportElementErrorTranslationFiles(source: String, type: String, file_hashes: List<String>, message: String)

<p>Represents an issue with the translated version of a document. The error is considered resolved when a file with the document translation change.</p>

| name | type | required | description |
|---|---|---|---|
| source | String | true | Error source, must be <em>translation_files</em> |
| type | String | true | Type of element of the user's Telegram Passport which has the issue, one of “passport”, “driver_license”, “identity_card”, “internal_passport”, “utility_bill”, “bank_statement”, “rental_agreement”, “passport_registration”, “temporary_registration” |
| file_hashes | List<String> | true | List of base64-encoded file hashes |
| message | String | true | Error message |

#### PassportElementErrorUnspecified

    PassportElementErrorUnspecified(source: String, type: String, element_hash: String, message: String)

<p>Represents an issue in an unspecified place. The error is considered resolved when new data is added.</p>

| name | type | required | description |
|---|---|---|---|
| source | String | true | Error source, must be <em>unspecified</em> |
| type | String | true | Type of element of the user's Telegram Passport which has the issue |
| element_hash | String | true | Base64-encoded element hash |
| message | String | true | Error message |


### Methods
#### setPassportDataErrors

    setPassportDataErrors(user_id: Integer, errors: List<PassportElementError>)

<p>Informs a user that some of the Telegram Passport elements they provided contains errors. The user will not be able to re-submit their Passport to you until the errors are fixed (the contents of the field for which you returned the error must change). Returns <em>True</em> on success.</p><p>Use this if the data submitted by the user doesn't satisfy the standards your service requires for any reason. For example, if a birthday date seems invalid, a submitted document is blurry, a scan shows evidence of tampering, etc. Supply some details in the error message to make sure the user knows how to correct the issues.</p>

| name | type | required | description |
|---|---|---|---|
| user_id | Integer | true | User identifier |
| errors | List<PassportElementError> | true | A JSON-serialized array describing the errors |



## Games

### Data Types
#### Game

    Game(title: String, description: String, photo: List<PhotoSize>, text: String, text_entities: List<MessageEntity>, animation: Animation)

<p>This object represents a game. Use BotFather to create and edit games, their short names will act as unique identifiers.</p>

| name | type | required | description |
|---|---|---|---|
| title | String | true | Title of the game |
| description | String | true | Description of the game |
| photo | List<PhotoSize> | true | Photo that will be displayed in the game message in chats. |
| text | String | false | <em>Optional</em>. Brief description of the game or high scores included in the game message. Can be automatically edited to include current high scores for the game when the bot calls <a href="#setgamescore">setGameScore</a>, or manually edited using <a href="#editmessagetext">editMessageText</a>. 0-4096 characters. |
| text_entities | List<MessageEntity> | false | <em>Optional</em>. Special entities that appear in <em>text</em>, such as usernames, URLs, bot commands, etc. |
| animation | Animation | false | <em>Optional</em>. Animation that will be displayed in the game message in chats. Upload via <a href="https://t.me/botfather">BotFather</a> |

#### GameHighScore

    GameHighScore(position: Integer, user: User, score: Integer)

<p>This object represents one row of the high scores table for a game.</p><p>And that's about all we've got for now.<br>If you've got any questions, please check out our <a href="/bots/faq"><strong>Bot FAQ »</strong></a></p>

| name | type | required | description |
|---|---|---|---|
| position | Integer | true | Position in high score table for the game |
| user | User | true | User |
| score | Integer | true | Score |


### Methods
#### sendGame

    sendGame(business_connection_id: String, chat_id: Integer, message_thread_id: Integer, game_short_name: String, disable_notification: Boolean, protect_content: Boolean, message_effect_id: String, reply_parameters: ReplyParameters, reply_markup: InlineKeyboardMarkup)

<p>Use this method to send a game. On success, the sent <a href="#message">Message</a> is returned.</p>

| name | type | required | description |
|---|---|---|---|
| business_connection_id | String | false | Unique identifier of the business connection on behalf of which the message will be sent |
| chat_id | Integer | true | Unique identifier for the target chat |
| message_thread_id | Integer | false | Unique identifier for the target message thread (topic) of the forum; for forum supergroups only |
| game_short_name | String | true | Short name of the game, serves as the unique identifier for the game. Set up your games via <a href="https://t.me/botfather">@BotFather</a>. |
| disable_notification | Boolean | false | Sends the message <a href="https://telegram.org/blog/channels-2-0#silent-messages">silently</a>. Users will receive a notification with no sound. |
| protect_content | Boolean | false | Protects the contents of the sent message from forwarding and saving |
| message_effect_id | String | false | Unique identifier of the message effect to be added to the message; for private chats only |
| reply_parameters | ReplyParameters | false | Description of the message to reply to |
| reply_markup | InlineKeyboardMarkup | false | A JSON-serialized object for an <a href="/bots/features#inline-keyboards">inline keyboard</a>. If empty, one 'Play game_title' button will be shown. If not empty, the first button must launch the game. |

#### setGameScore

    setGameScore(user_id: Integer, score: Integer, force: Boolean, disable_edit_message: Boolean, chat_id: Integer, message_id: Integer, inline_message_id: String)

<p>Use this method to set the score of the specified user in a game message. On success, if the message is not an inline message, the <a href="#message">Message</a> is returned, otherwise <em>True</em> is returned. Returns an error, if the new score is not greater than the user's current score in the chat and <em>force</em> is <em>False</em>.</p>

| name | type | required | description |
|---|---|---|---|
| user_id | Integer | true | User identifier |
| score | Integer | true | New score, must be non-negative |
| force | Boolean | false | Pass <em>True</em> if the high score is allowed to decrease. This can be useful when fixing mistakes or banning cheaters |
| disable_edit_message | Boolean | false | Pass <em>True</em> if the game message should not be automatically edited to include the current scoreboard |
| chat_id | Integer | false | Required if <em>inline_message_id</em> is not specified. Unique identifier for the target chat |
| message_id | Integer | false | Required if <em>inline_message_id</em> is not specified. Identifier of the sent message |
| inline_message_id | String | false | Required if <em>chat_id</em> and <em>message_id</em> are not specified. Identifier of the inline message |

#### getGameHighScores

    getGameHighScores(user_id: Integer, chat_id: Integer, message_id: Integer, inline_message_id: String)

<p>Use this method to get data for high score tables. Will return the score of the specified user and several of their neighbors in a game. Returns an Array of <a href="#gamehighscore">GameHighScore</a> objects.</p><blockquote>
 <p>This method will currently return scores for the target user, plus two of their closest neighbors on each side. Will also return the top three users if the user and their neighbors are not among them. Please note that this behavior is subject to change.</p>
</blockquote>

| name | type | required | description |
|---|---|---|---|
| user_id | Integer | true | Target user id |
| chat_id | Integer | false | Required if <em>inline_message_id</em> is not specified. Unique identifier for the target chat |
| message_id | Integer | false | Required if <em>inline_message_id</em> is not specified. Identifier of the sent message |
| inline_message_id | String | false | Required if <em>chat_id</em> and <em>message_id</em> are not specified. Identifier of the inline message |

