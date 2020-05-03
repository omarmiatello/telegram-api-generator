

## Getting updates

### Data Types
#### Update

    Update(update_id: Integer, message: Message, edited_message: Message, channel_post: Message, edited_channel_post: Message, inline_query: InlineQuery, chosen_inline_result: ChosenInlineResult, callback_query: CallbackQuery, shipping_query: ShippingQuery, pre_checkout_query: PreCheckoutQuery, poll: Poll, poll_answer: PollAnswer)

<p>This <a href="#available-types">object</a> represents an incoming update.<br>At most <strong>one</strong> of the optional parameters can be present in any given update.</p>

| name | type | required | description |
|---|---|---|---|
| update_id | Integer | true | The update‘s unique identifier. Update identifiers start from a certain positive number and increase sequentially. This ID becomes especially handy if you’re using <a href="#setwebhook">Webhooks</a>, since it allows you to ignore repeated updates or to restore the correct update sequence, should they get out of order. If there are no new updates for at least a week, then identifier of the next update will be chosen randomly instead of sequentially. |
| message | Message | false | <em>Optional</em>. New incoming message of any kind — text, photo, sticker, etc. |
| edited_message | Message | false | <em>Optional</em>. New version of a message that is known to the bot and was edited |
| channel_post | Message | false | <em>Optional</em>. New incoming channel post of any kind — text, photo, sticker, etc. |
| edited_channel_post | Message | false | <em>Optional</em>. New version of a channel post that is known to the bot and was edited |
| inline_query | InlineQuery | false | <em>Optional</em>. New incoming <a href="#inline-mode">inline</a> query |
| chosen_inline_result | ChosenInlineResult | false | <em>Optional</em>. The result of an <a href="#inline-mode">inline</a> query that was chosen by a user and sent to their chat partner. Please see our documentation on the <a href="/bots/inline#collecting-feedback">feedback collecting</a> for details on how to enable these updates for your bot. |
| callback_query | CallbackQuery | false | <em>Optional</em>. New incoming callback query |
| shipping_query | ShippingQuery | false | <em>Optional</em>. New incoming shipping query. Only for invoices with flexible price |
| pre_checkout_query | PreCheckoutQuery | false | <em>Optional</em>. New incoming pre-checkout query. Contains full information about checkout |
| poll | Poll | false | <em>Optional</em>. New poll state. Bots receive only updates about stopped polls and polls, which are sent by the bot |
| poll_answer | PollAnswer | false | <em>Optional</em>. A user changed their answer in a non-anonymous poll. Bots receive new votes only in polls that were sent by the bot itself. |

#### WebhookInfo

    WebhookInfo(url: String, has_custom_certificate: Boolean, pending_update_count: Integer, last_error_date: Integer, last_error_message: String, max_connections: Integer, allowed_updates: List<String>)

<p>Contains information about the current status of a webhook.</p>

| name | type | required | description |
|---|---|---|---|
| url | String | true | Webhook URL, may be empty if webhook is not set up |
| has_custom_certificate | Boolean | true | True, if a custom certificate was provided for webhook certificate checks |
| pending_update_count | Integer | true | Number of updates awaiting delivery |
| last_error_date | Integer | false | <em>Optional</em>. Unix time for the most recent error that happened when trying to deliver an update via webhook |
| last_error_message | String | false | <em>Optional</em>. Error message in human-readable format for the most recent error that happened when trying to deliver an update via webhook |
| max_connections | Integer | false | <em>Optional</em>. Maximum allowed number of simultaneous HTTPS connections to the webhook for update delivery |
| allowed_updates | List<String> | false | <em>Optional</em>. A list of update types the bot is subscribed to. Defaults to all update types |


### Methods
#### getUpdates

    getUpdates(offset: Integer, limit: Integer, timeout: Integer, allowed_updates: List<String>)

<p>Use this method to receive incoming updates using long polling (<a href="https://en.wikipedia.org/wiki/Push_technology#Long_polling">wiki</a>). An Array of <a href="#update">Update</a> objects is returned.</p><blockquote> 
 <p><strong>Notes</strong><br><strong>1.</strong> This method will not work if an outgoing webhook is set up.<br><strong>2.</strong> In order to avoid getting duplicate updates, recalculate <em>offset</em> after each server response.</p> 
</blockquote>

| name | type | required | description |
|---|---|---|---|
| offset | Integer | false | Identifier of the first update to be returned. Must be greater by one than the highest among the identifiers of previously received updates. By default, updates starting with the earliest unconfirmed update are returned. An update is considered confirmed as soon as <a href="#getupdates">getUpdates</a> is called with an <em>offset</em> higher than its <em>update_id</em>. The negative offset can be specified to retrieve updates starting from <em>-offset</em> update from the end of the updates queue. All previous updates will forgotten. |
| limit | Integer | false | Limits the number of updates to be retrieved. Values between 1-100 are accepted. Defaults to 100. |
| timeout | Integer | false | Timeout in seconds for long polling. Defaults to 0, i.e. usual short polling. Should be positive, short polling should be used for testing purposes only. |
| allowed_updates | List<String> | false | A JSON-serialized list of the update types you want your bot to receive. For example, specify [“message”, “edited_channel_post”, “callback_query”] to only receive updates of these types. See <a href="#update">Update</a> for a complete list of available update types. Specify an empty list to receive all updates regardless of type (default). If not specified, the previous setting will be used.<br><br>Please note that this parameter doesn't affect updates created before the call to the getUpdates, so unwanted updates may be received for a short period of time. |

#### setWebhook

    setWebhook(url: String, certificate: InputFile, max_connections: Integer, allowed_updates: List<String>)

<p>Use this method to specify a url and receive incoming updates via an outgoing webhook. Whenever there is an update for the bot, we will send an HTTPS POST request to the specified url, containing a JSON-serialized <a href="#update">Update</a>. In case of an unsuccessful request, we will give up after a reasonable amount of attempts. Returns <em>True</em> on success.</p><p>If you'd like to make sure that the Webhook request comes from Telegram, we recommend using a secret path in the URL, e.g. <code>https://www.example.com/&lt;token&gt;</code>. Since nobody else knows your bot‘s token, you can be pretty sure it’s us.</p><blockquote> 
 <p><strong>Notes</strong><br><strong>1.</strong> You will not be able to receive updates using <a href="#getupdates">getUpdates</a> for as long as an outgoing webhook is set up.<br><strong>2.</strong> To use a self-signed certificate, you need to upload your <a href="/bots/self-signed">public key certificate</a> using <em>certificate</em> parameter. Please upload as InputFile, sending a String will not work.<br><strong>3.</strong> Ports currently supported <em>for Webhooks</em>: <strong>443, 80, 88, 8443</strong>.</p> 
 <p><strong>NEW!</strong> If you're having any trouble setting up webhooks, please check out this <a href="/bots/webhooks">amazing guide to Webhooks</a>.</p> 
</blockquote>

| name | type | required | description |
|---|---|---|---|
| url | String | true | HTTPS url to send updates to. Use an empty string to remove webhook integration |
| certificate | InputFile | false | Upload your public key certificate so that the root certificate in use can be checked. See our <a href="/bots/self-signed">self-signed guide</a> for details. |
| max_connections | Integer | false | Maximum allowed number of simultaneous HTTPS connections to the webhook for update delivery, 1-100. Defaults to <em>40</em>. Use lower values to limit the load on your bot‘s server, and higher values to increase your bot’s throughput. |
| allowed_updates | List<String> | false | A JSON-serialized list of the update types you want your bot to receive. For example, specify [“message”, “edited_channel_post”, “callback_query”] to only receive updates of these types. See <a href="#update">Update</a> for a complete list of available update types. Specify an empty list to receive all updates regardless of type (default). If not specified, the previous setting will be used.<br><br>Please note that this parameter doesn't affect updates created before the call to the setWebhook, so unwanted updates may be received for a short period of time. |

#### deleteWebhook

    deleteWebhook()

<p>Use this method to remove webhook integration if you decide to switch back to <a href="#getupdates">getUpdates</a>. Returns <em>True</em> on success. Requires no parameters.</p>

#### getWebhookInfo

    getWebhookInfo()

<p>Use this method to get current webhook status. Requires no parameters. On success, returns a <a href="#webhookinfo">WebhookInfo</a> object. If the bot is using <a href="#getupdates">getUpdates</a>, will return an object with the <em>url</em> field empty.</p>



## Available types

### Data Types
#### User

    User(id: Integer, is_bot: Boolean, first_name: String, last_name: String, username: String, language_code: String, can_join_groups: Boolean, can_read_all_group_messages: Boolean, supports_inline_queries: Boolean)

<p>This object represents a Telegram user or bot.</p>

| name | type | required | description |
|---|---|---|---|
| id | Integer | true | Unique identifier for this user or bot |
| is_bot | Boolean | true | True, if this user is a bot |
| first_name | String | true | User‘s or bot’s first name |
| last_name | String | false | <em>Optional</em>. User‘s or bot’s last name |
| username | String | false | <em>Optional</em>. User‘s or bot’s username |
| language_code | String | false | <em>Optional</em>. <a href="https://en.wikipedia.org/wiki/IETF_language_tag">IETF language tag</a> of the user's language |
| can_join_groups | Boolean | false | <em>Optional</em>. True, if the bot can be invited to groups. Returned only in <a href="#getme">getMe</a>. |
| can_read_all_group_messages | Boolean | false | <em>Optional</em>. True, if <a href="https://core.telegram.org/bots#privacy-mode">privacy mode</a> is disabled for the bot. Returned only in <a href="#getme">getMe</a>. |
| supports_inline_queries | Boolean | false | <em>Optional</em>. True, if the bot supports inline queries. Returned only in <a href="#getme">getMe</a>. |

#### Chat

    Chat(id: Integer, type: String, title: String, username: String, first_name: String, last_name: String, photo: ChatPhoto, description: String, invite_link: String, pinned_message: Message, permissions: ChatPermissions, slow_mode_delay: Integer, sticker_set_name: String, can_set_sticker_set: Boolean)

<p>This object represents a chat.</p>

| name | type | required | description |
|---|---|---|---|
| id | Integer | true | Unique identifier for this chat. This number may be greater than 32 bits and some programming languages may have difficulty/silent defects in interpreting it. But it is smaller than 52 bits, so a signed 64 bit integer or double-precision float type are safe for storing this identifier. |
| type | String | true | Type of chat, can be either “private”, “group”, “supergroup” or “channel” |
| title | String | false | <em>Optional</em>. Title, for supergroups, channels and group chats |
| username | String | false | <em>Optional</em>. Username, for private chats, supergroups and channels if available |
| first_name | String | false | <em>Optional</em>. First name of the other party in a private chat |
| last_name | String | false | <em>Optional</em>. Last name of the other party in a private chat |
| photo | ChatPhoto | false | <em>Optional</em>. Chat photo. Returned only in <a href="#getchat">getChat</a>. |
| description | String | false | <em>Optional</em>. Description, for groups, supergroups and channel chats. Returned only in <a href="#getchat">getChat</a>. |
| invite_link | String | false | <em>Optional</em>. Chat invite link, for groups, supergroups and channel chats. Each administrator in a chat generates their own invite links, so the bot must first generate the link using <a href="#exportchatinvitelink">exportChatInviteLink</a>. Returned only in <a href="#getchat">getChat</a>. |
| pinned_message | Message | false | <em>Optional</em>. Pinned message, for groups, supergroups and channels. Returned only in <a href="#getchat">getChat</a>. |
| permissions | ChatPermissions | false | <em>Optional</em>. Default chat member permissions, for groups and supergroups. Returned only in <a href="#getchat">getChat</a>. |
| slow_mode_delay | Integer | false | <em>Optional</em>. For supergroups, the minimum allowed delay between consecutive messages sent by each unpriviledged user. Returned only in <a href="#getchat">getChat</a>. |
| sticker_set_name | String | false | <em>Optional</em>. For supergroups, name of group sticker set. Returned only in <a href="#getchat">getChat</a>. |
| can_set_sticker_set | Boolean | false | <em>Optional</em>. True, if the bot can change the group sticker set. Returned only in <a href="#getchat">getChat</a>. |

#### Message

    Message(message_id: Integer, from: User, date: Integer, chat: Chat, forward_from: User, forward_from_chat: Chat, forward_from_message_id: Integer, forward_signature: String, forward_sender_name: String, forward_date: Integer, reply_to_message: Message, edit_date: Integer, media_group_id: String, author_signature: String, text: String, entities: List<MessageEntity>, caption_entities: List<MessageEntity>, audio: Audio, document: Document, animation: Animation, game: Game, photo: List<PhotoSize>, sticker: Sticker, video: Video, voice: Voice, video_note: VideoNote, caption: String, contact: Contact, location: Location, venue: Venue, poll: Poll, dice: Dice, new_chat_members: List<User>, left_chat_member: User, new_chat_title: String, new_chat_photo: List<PhotoSize>, delete_chat_photo: Boolean, group_chat_created: Boolean, supergroup_chat_created: Boolean, channel_chat_created: Boolean, migrate_to_chat_id: Integer, migrate_from_chat_id: Integer, pinned_message: Message, invoice: Invoice, successful_payment: SuccessfulPayment, connected_website: String, passport_data: PassportData, reply_markup: InlineKeyboardMarkup)

<p>This object represents a message.</p>

| name | type | required | description |
|---|---|---|---|
| message_id | Integer | true | Unique message identifier inside this chat |
| from | User | false | <em>Optional</em>. Sender, empty for messages sent to channels |
| date | Integer | true | Date the message was sent in Unix time |
| chat | Chat | true | Conversation the message belongs to |
| forward_from | User | false | <em>Optional</em>. For forwarded messages, sender of the original message |
| forward_from_chat | Chat | false | <em>Optional</em>. For messages forwarded from channels, information about the original channel |
| forward_from_message_id | Integer | false | <em>Optional</em>. For messages forwarded from channels, identifier of the original message in the channel |
| forward_signature | String | false | <em>Optional</em>. For messages forwarded from channels, signature of the post author if present |
| forward_sender_name | String | false | <em>Optional</em>. Sender's name for messages forwarded from users who disallow adding a link to their account in forwarded messages |
| forward_date | Integer | false | <em>Optional</em>. For forwarded messages, date the original message was sent in Unix time |
| reply_to_message | Message | false | <em>Optional</em>. For replies, the original message. Note that the Message object in this field will not contain further <em>reply_to_message</em> fields even if it itself is a reply. |
| edit_date | Integer | false | <em>Optional</em>. Date the message was last edited in Unix time |
| media_group_id | String | false | <em>Optional</em>. The unique identifier of a media message group this message belongs to |
| author_signature | String | false | <em>Optional</em>. Signature of the post author for messages in channels |
| text | String | false | <em>Optional</em>. For text messages, the actual UTF-8 text of the message, 0-4096 characters |
| entities | List<MessageEntity> | false | <em>Optional</em>. For text messages, special entities like usernames, URLs, bot commands, etc. that appear in the text |
| caption_entities | List<MessageEntity> | false | <em>Optional</em>. For messages with a caption, special entities like usernames, URLs, bot commands, etc. that appear in the caption |
| audio | Audio | false | <em>Optional</em>. Message is an audio file, information about the file |
| document | Document | false | <em>Optional</em>. Message is a general file, information about the file |
| animation | Animation | false | <em>Optional</em>. Message is an animation, information about the animation. For backward compatibility, when this field is set, the <em>document</em> field will also be set |
| game | Game | false | <em>Optional</em>. Message is a game, information about the game. <a href="#games">More about games »</a> |
| photo | List<PhotoSize> | false | <em>Optional</em>. Message is a photo, available sizes of the photo |
| sticker | Sticker | false | <em>Optional</em>. Message is a sticker, information about the sticker |
| video | Video | false | <em>Optional</em>. Message is a video, information about the video |
| voice | Voice | false | <em>Optional</em>. Message is a voice message, information about the file |
| video_note | VideoNote | false | <em>Optional</em>. Message is a <a href="https://telegram.org/blog/video-messages-and-telescope">video note</a>, information about the video message |
| caption | String | false | <em>Optional</em>. Caption for the animation, audio, document, photo, video or voice, 0-1024 characters |
| contact | Contact | false | <em>Optional</em>. Message is a shared contact, information about the contact |
| location | Location | false | <em>Optional</em>. Message is a shared location, information about the location |
| venue | Venue | false | <em>Optional</em>. Message is a venue, information about the venue |
| poll | Poll | false | <em>Optional</em>. Message is a native poll, information about the poll |
| dice | Dice | false | <em>Optional</em>. Message is a dice with random value from 1 to 6 |
| new_chat_members | List<User> | false | <em>Optional</em>. New members that were added to the group or supergroup and information about them (the bot itself may be one of these members) |
| left_chat_member | User | false | <em>Optional</em>. A member was removed from the group, information about them (this member may be the bot itself) |
| new_chat_title | String | false | <em>Optional</em>. A chat title was changed to this value |
| new_chat_photo | List<PhotoSize> | false | <em>Optional</em>. A chat photo was change to this value |
| delete_chat_photo | Boolean | false | <em>Optional</em>. Service message: the chat photo was deleted |
| group_chat_created | Boolean | false | <em>Optional</em>. Service message: the group has been created |
| supergroup_chat_created | Boolean | false | <em>Optional</em>. Service message: the supergroup has been created. This field can‘t be received in a message coming through updates, because bot can’t be a member of a supergroup when it is created. It can only be found in reply_to_message if someone replies to a very first message in a directly created supergroup. |
| channel_chat_created | Boolean | false | <em>Optional</em>. Service message: the channel has been created. This field can‘t be received in a message coming through updates, because bot can’t be a member of a channel when it is created. It can only be found in reply_to_message if someone replies to a very first message in a channel. |
| migrate_to_chat_id | Integer | false | <em>Optional</em>. The group has been migrated to a supergroup with the specified identifier. This number may be greater than 32 bits and some programming languages may have difficulty/silent defects in interpreting it. But it is smaller than 52 bits, so a signed 64 bit integer or double-precision float type are safe for storing this identifier. |
| migrate_from_chat_id | Integer | false | <em>Optional</em>. The supergroup has been migrated from a group with the specified identifier. This number may be greater than 32 bits and some programming languages may have difficulty/silent defects in interpreting it. But it is smaller than 52 bits, so a signed 64 bit integer or double-precision float type are safe for storing this identifier. |
| pinned_message | Message | false | <em>Optional</em>. Specified message was pinned. Note that the Message object in this field will not contain further <em>reply_to_message</em> fields even if it is itself a reply. |
| invoice | Invoice | false | <em>Optional</em>. Message is an invoice for a <a href="#payments">payment</a>, information about the invoice. <a href="#payments">More about payments »</a> |
| successful_payment | SuccessfulPayment | false | <em>Optional</em>. Message is a service message about a successful payment, information about the payment. <a href="#payments">More about payments »</a> |
| connected_website | String | false | <em>Optional</em>. The domain name of the website on which the user has logged in. <a href="/widgets/login">More about Telegram Login »</a> |
| passport_data | PassportData | false | <em>Optional</em>. Telegram Passport data |
| reply_markup | InlineKeyboardMarkup | false | <em>Optional</em>. Inline keyboard attached to the message. <code>login_url</code> buttons are represented as ordinary <code>url</code> buttons. |

#### MessageEntity

    MessageEntity(type: String, offset: Integer, length: Integer, url: String, user: User, language: String)

<p>This object represents one special entity in a text message. For example, hashtags, usernames, URLs, etc.</p>

| name | type | required | description |
|---|---|---|---|
| type | String | true | Type of the entity. Can be “mention” (<code>@username</code>), “hashtag” (<code>#hashtag</code>), “cashtag” (<code>$USD</code>), “bot_command” (<code>/start@jobs_bot</code>), “url” (<code>https://telegram.org</code>), “email” (<code>do-not-reply@telegram.org</code>), “phone_number” (<code>+1-212-555-0123</code>), “bold” (<strong>bold text</strong>), “italic” (<em>italic text</em>), “underline” (underlined text), “strikethrough” (strikethrough text), “code” (monowidth string), “pre” (monowidth block), “text_link” (for clickable text URLs), “text_mention” (for users <a href="https://telegram.org/blog/edit#new-mentions">without usernames</a>) |
| offset | Integer | true | Offset in UTF-16 code units to the start of the entity |
| length | Integer | true | Length of the entity in UTF-16 code units |
| url | String | false | <em>Optional</em>. For “text_link” only, url that will be opened after user taps on the text |
| user | User | false | <em>Optional</em>. For “text_mention” only, the mentioned user |
| language | String | false | <em>Optional</em>. For “pre” only, the programming language of the entity text |

#### PhotoSize

    PhotoSize(file_id: String, file_unique_id: String, width: Integer, height: Integer, file_size: Integer)

<p>This object represents one size of a photo or a <a href="#document">file</a> / <a href="#sticker">sticker</a> thumbnail.</p>

| name | type | required | description |
|---|---|---|---|
| file_id | String | true | Identifier for this file, which can be used to download or reuse the file |
| file_unique_id | String | true | Unique identifier for this file, which is supposed to be the same over time and for different bots. Can't be used to download or reuse the file. |
| width | Integer | true | Photo width |
| height | Integer | true | Photo height |
| file_size | Integer | false | <em>Optional</em>. File size |

#### Audio

    Audio(file_id: String, file_unique_id: String, duration: Integer, performer: String, title: String, mime_type: String, file_size: Integer, thumb: PhotoSize)

<p>This object represents an audio file to be treated as music by the Telegram clients.</p>

| name | type | required | description |
|---|---|---|---|
| file_id | String | true | Identifier for this file, which can be used to download or reuse the file |
| file_unique_id | String | true | Unique identifier for this file, which is supposed to be the same over time and for different bots. Can't be used to download or reuse the file. |
| duration | Integer | true | Duration of the audio in seconds as defined by sender |
| performer | String | false | <em>Optional</em>. Performer of the audio as defined by sender or by audio tags |
| title | String | false | <em>Optional</em>. Title of the audio as defined by sender or by audio tags |
| mime_type | String | false | <em>Optional</em>. MIME type of the file as defined by sender |
| file_size | Integer | false | <em>Optional</em>. File size |
| thumb | PhotoSize | false | <em>Optional</em>. Thumbnail of the album cover to which the music file belongs |

#### Document

    Document(file_id: String, file_unique_id: String, thumb: PhotoSize, file_name: String, mime_type: String, file_size: Integer)

<p>This object represents a general file (as opposed to <a href="#photosize">photos</a>, <a href="#voice">voice messages</a> and <a href="#audio">audio files</a>).</p>

| name | type | required | description |
|---|---|---|---|
| file_id | String | true | Identifier for this file, which can be used to download or reuse the file |
| file_unique_id | String | true | Unique identifier for this file, which is supposed to be the same over time and for different bots. Can't be used to download or reuse the file. |
| thumb | PhotoSize | false | <em>Optional</em>. Document thumbnail as defined by sender |
| file_name | String | false | <em>Optional</em>. Original filename as defined by sender |
| mime_type | String | false | <em>Optional</em>. MIME type of the file as defined by sender |
| file_size | Integer | false | <em>Optional</em>. File size |

#### Video

    Video(file_id: String, file_unique_id: String, width: Integer, height: Integer, duration: Integer, thumb: PhotoSize, mime_type: String, file_size: Integer)

<p>This object represents a video file.</p>

| name | type | required | description |
|---|---|---|---|
| file_id | String | true | Identifier for this file, which can be used to download or reuse the file |
| file_unique_id | String | true | Unique identifier for this file, which is supposed to be the same over time and for different bots. Can't be used to download or reuse the file. |
| width | Integer | true | Video width as defined by sender |
| height | Integer | true | Video height as defined by sender |
| duration | Integer | true | Duration of the video in seconds as defined by sender |
| thumb | PhotoSize | false | <em>Optional</em>. Video thumbnail |
| mime_type | String | false | <em>Optional</em>. Mime type of a file as defined by sender |
| file_size | Integer | false | <em>Optional</em>. File size |

#### Animation

    Animation(file_id: String, file_unique_id: String, width: Integer, height: Integer, duration: Integer, thumb: PhotoSize, file_name: String, mime_type: String, file_size: Integer)

<p>This object represents an animation file (GIF or H.264/MPEG-4 AVC video without sound).</p>

| name | type | required | description |
|---|---|---|---|
| file_id | String | true | Identifier for this file, which can be used to download or reuse the file |
| file_unique_id | String | true | Unique identifier for this file, which is supposed to be the same over time and for different bots. Can't be used to download or reuse the file. |
| width | Integer | true | Video width as defined by sender |
| height | Integer | true | Video height as defined by sender |
| duration | Integer | true | Duration of the video in seconds as defined by sender |
| thumb | PhotoSize | false | <em>Optional</em>. Animation thumbnail as defined by sender |
| file_name | String | false | <em>Optional</em>. Original animation filename as defined by sender |
| mime_type | String | false | <em>Optional</em>. MIME type of the file as defined by sender |
| file_size | Integer | false | <em>Optional</em>. File size |

#### Voice

    Voice(file_id: String, file_unique_id: String, duration: Integer, mime_type: String, file_size: Integer)

<p>This object represents a voice note.</p>

| name | type | required | description |
|---|---|---|---|
| file_id | String | true | Identifier for this file, which can be used to download or reuse the file |
| file_unique_id | String | true | Unique identifier for this file, which is supposed to be the same over time and for different bots. Can't be used to download or reuse the file. |
| duration | Integer | true | Duration of the audio in seconds as defined by sender |
| mime_type | String | false | <em>Optional</em>. MIME type of the file as defined by sender |
| file_size | Integer | false | <em>Optional</em>. File size |

#### VideoNote

    VideoNote(file_id: String, file_unique_id: String, length: Integer, duration: Integer, thumb: PhotoSize, file_size: Integer)

<p>This object represents a <a href="https://telegram.org/blog/video-messages-and-telescope">video message</a> (available in Telegram apps as of <a href="https://telegram.org/blog/video-messages-and-telescope">v.4.0</a>).</p>

| name | type | required | description |
|---|---|---|---|
| file_id | String | true | Identifier for this file, which can be used to download or reuse the file |
| file_unique_id | String | true | Unique identifier for this file, which is supposed to be the same over time and for different bots. Can't be used to download or reuse the file. |
| length | Integer | true | Video width and height (diameter of the video message) as defined by sender |
| duration | Integer | true | Duration of the video in seconds as defined by sender |
| thumb | PhotoSize | false | <em>Optional</em>. Video thumbnail |
| file_size | Integer | false | <em>Optional</em>. File size |

#### Contact

    Contact(phone_number: String, first_name: String, last_name: String, user_id: Integer, vcard: String)

<p>This object represents a phone contact.</p>

| name | type | required | description |
|---|---|---|---|
| phone_number | String | true | Contact's phone number |
| first_name | String | true | Contact's first name |
| last_name | String | false | <em>Optional</em>. Contact's last name |
| user_id | Integer | false | <em>Optional</em>. Contact's user identifier in Telegram |
| vcard | String | false | <em>Optional</em>. Additional data about the contact in the form of a <a href="https://en.wikipedia.org/wiki/VCard">vCard</a> |

#### Location

    Location(longitude: Float, latitude: Float)

<p>This object represents a point on the map.</p>

| name | type | required | description |
|---|---|---|---|
| longitude | Float | true | Longitude as defined by sender |
| latitude | Float | true | Latitude as defined by sender |

#### Venue

    Venue(location: Location, title: String, address: String, foursquare_id: String, foursquare_type: String)

<p>This object represents a venue.</p>

| name | type | required | description |
|---|---|---|---|
| location | Location | true | Venue location |
| title | String | true | Name of the venue |
| address | String | true | Address of the venue |
| foursquare_id | String | false | <em>Optional</em>. Foursquare identifier of the venue |
| foursquare_type | String | false | <em>Optional</em>. Foursquare type of the venue. (For example, “arts_entertainment/default”, “arts_entertainment/aquarium” or “food/icecream”.) |

#### PollOption

    PollOption(text: String, voter_count: Integer)

<p>This object contains information about one answer option in a poll.</p>

| name | type | required | description |
|---|---|---|---|
| text | String | true | Option text, 1-100 characters |
| voter_count | Integer | true | Number of users that voted for this option |

#### PollAnswer

    PollAnswer(poll_id: String, user: User, option_ids: List<Integer>)

<p>This object represents an answer of a user in a non-anonymous poll.</p>

| name | type | required | description |
|---|---|---|---|
| poll_id | String | true | Unique poll identifier |
| user | User | true | The user, who changed the answer to the poll |
| option_ids | List<Integer> | true | 0-based identifiers of answer options, chosen by the user. May be empty if the user retracted their vote. |

#### Poll

    Poll(id: String, question: String, options: List<PollOption>, total_voter_count: Integer, is_closed: Boolean, is_anonymous: Boolean, type: String, allows_multiple_answers: Boolean, correct_option_id: Integer, explanation: String, explanation_entities: List<MessageEntity>, open_period: Integer, close_date: Integer)

<p>This object contains information about a poll.</p>

| name | type | required | description |
|---|---|---|---|
| id | String | true | Unique poll identifier |
| question | String | true | Poll question, 1-255 characters |
| options | List<PollOption> | true | List of poll options |
| total_voter_count | Integer | true | Total number of users that voted in the poll |
| is_closed | Boolean | true | True, if the poll is closed |
| is_anonymous | Boolean | true | True, if the poll is anonymous |
| type | String | true | Poll type, currently can be “regular” or “quiz” |
| allows_multiple_answers | Boolean | true | True, if the poll allows multiple answers |
| correct_option_id | Integer | false | <em>Optional</em>. 0-based identifier of the correct answer option. Available only for polls in the quiz mode, which are closed, or was sent (not forwarded) by the bot or to the private chat with the bot. |
| explanation | String | false | <em>Optional</em>. Text that is shown when a user chooses an incorrect answer or taps on the lamp icon in a quiz-style poll, 0-200 characters |
| explanation_entities | List<MessageEntity> | false | <em>Optional</em>. Special entities like usernames, URLs, bot commands, etc. that appear in the <em>explanation</em> |
| open_period | Integer | false | <em>Optional</em>. Amount of time in seconds the poll will be active after creation |
| close_date | Integer | false | <em>Optional</em>. Point in time (Unix timestamp) when the poll will be automatically closed |

#### Dice

    Dice(emoji: String, value: Integer)

<p>This object represents a dice with a random value from 1 to 6 for currently supported base emoji. (Yes, we're aware of the <em>“proper”</em> singular of <em>die</em>. But it's awkward, and we decided to help it change. One dice at a time!)</p>

| name | type | required | description |
|---|---|---|---|
| emoji | String | true | Emoji on which the dice throw animation is based |
| value | Integer | true | Value of the dice, 1-6 for currently supported base emoji |

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
 <p>Maximum file size to download is 20 MB</p> 
</blockquote>

| name | type | required | description |
|---|---|---|---|
| file_id | String | true | Identifier for this file, which can be used to download or reuse the file |
| file_unique_id | String | true | Unique identifier for this file, which is supposed to be the same over time and for different bots. Can't be used to download or reuse the file. |
| file_size | Integer | false | <em>Optional</em>. File size, if known |
| file_path | String | false | <em>Optional</em>. File path. Use <code>https://api.telegram.org/file/bot&lt;token&gt;/&lt;file_path&gt;</code> to get the file. |

#### ReplyKeyboardMarkup

    ReplyKeyboardMarkup(keyboard: List<List<KeyboardButton>>, resize_keyboard: Boolean, one_time_keyboard: Boolean, selective: Boolean)

<p>This object represents a <a href="https://core.telegram.org/bots#keyboards">custom keyboard</a> with reply options (see <a href="https://core.telegram.org/bots#keyboards">Introduction to bots</a> for details and examples).</p>

| name | type | required | description |
|---|---|---|---|
| keyboard | List<List<KeyboardButton>> | true | Array of button rows, each represented by an Array of <a href="#keyboardbutton">KeyboardButton</a> objects |
| resize_keyboard | Boolean | false | <em>Optional</em>. Requests clients to resize the keyboard vertically for optimal fit (e.g., make the keyboard smaller if there are just two rows of buttons). Defaults to <em>false</em>, in which case the custom keyboard is always of the same height as the app's standard keyboard. |
| one_time_keyboard | Boolean | false | <em>Optional</em>. Requests clients to hide the keyboard as soon as it's been used. The keyboard will still be available, but clients will automatically display the usual letter-keyboard in the chat – the user can press a special button in the input field to see the custom keyboard again. Defaults to <em>false</em>. |
| selective | Boolean | false | <em>Optional</em>. Use this parameter if you want to show the keyboard to specific users only. Targets: 1) users that are @mentioned in the <em>text</em> of the <a href="#message">Message</a> object; 2) if the bot's message is a reply (has <em>reply_to_message_id</em>), sender of the original message.<br><br><em>Example:</em> A user requests to change the bot‘s language, bot replies to the request with a keyboard to select the new language. Other users in the group don’t see the keyboard. |

#### KeyboardButton

    KeyboardButton(text: String, request_contact: Boolean, request_location: Boolean, request_poll: KeyboardButtonPollType)

<p>This object represents one button of the reply keyboard. For simple text buttons <em>String</em> can be used instead of this object to specify text of the button. Optional fields <em>request_contact</em>, <em>request_location</em>, and <em>request_poll</em> are mutually exclusive.</p><p><strong>Note:</strong> <em>request_contact</em> and <em>request_location</em> options will only work in Telegram versions released after 9 April, 2016. Older clients will display <em>unsupported message</em>.<br><strong>Note:</strong> <em>request_poll</em> option will only work in Telegram versions released after 23 January, 2020. Older clients will display <em>unsupported message</em>.</p>

| name | type | required | description |
|---|---|---|---|
| text | String | true | Text of the button. If none of the optional fields are used, it will be sent as a message when the button is pressed |
| request_contact | Boolean | false | <em>Optional</em>. If <em>True</em>, the user's phone number will be sent as a contact when the button is pressed. Available in private chats only |
| request_location | Boolean | false | <em>Optional</em>. If <em>True</em>, the user's current location will be sent when the button is pressed. Available in private chats only |
| request_poll | KeyboardButtonPollType | false | <em>Optional</em>. If specified, the user will be asked to create a poll and send it to the bot when the button is pressed. Available in private chats only |

#### KeyboardButtonPollType

    KeyboardButtonPollType(type: String)

<p>This object represents type of a poll, which is allowed to be created and sent when the corresponding button is pressed.</p>

| name | type | required | description |
|---|---|---|---|
| type | String | false | <em>Optional</em>. If <em>quiz</em> is passed, the user will be allowed to create only polls in the quiz mode. If <em>regular</em> is passed, only regular polls will be allowed. Otherwise, the user will be allowed to create a poll of any type. |

#### ReplyKeyboardRemove

    ReplyKeyboardRemove(remove_keyboard: Boolean, selective: Boolean)

<p>Upon receiving a message with this object, Telegram clients will remove the current custom keyboard and display the default letter-keyboard. By default, custom keyboards are displayed until a new keyboard is sent by a bot. An exception is made for one-time keyboards that are hidden immediately after the user presses a button (see <a href="#replykeyboardmarkup">ReplyKeyboardMarkup</a>).</p>

| name | type | required | description |
|---|---|---|---|
| remove_keyboard | Boolean | true | Requests clients to remove the custom keyboard (user will not be able to summon this keyboard; if you want to hide the keyboard from sight but keep it accessible, use <em>one_time_keyboard</em> in <a href="#replykeyboardmarkup">ReplyKeyboardMarkup</a>) |
| selective | Boolean | false | <em>Optional</em>. Use this parameter if you want to remove the keyboard for specific users only. Targets: 1) users that are @mentioned in the <em>text</em> of the <a href="#message">Message</a> object; 2) if the bot's message is a reply (has <em>reply_to_message_id</em>), sender of the original message.<br><br><em>Example:</em> A user votes in a poll, bot returns confirmation message in reply to the vote and removes the keyboard for that user, while still showing the keyboard with poll options to users who haven't voted yet. |

#### InlineKeyboardMarkup

    InlineKeyboardMarkup(inline_keyboard: List<List<InlineKeyboardButton>>)

<p>This object represents an <a href="https://core.telegram.org/bots#inline-keyboards-and-on-the-fly-updating">inline keyboard</a> that appears right next to the message it belongs to.</p><p><strong>Note:</strong> This will only work in Telegram versions released after 9 April, 2016. Older clients will display <em>unsupported message</em>.</p>

| name | type | required | description |
|---|---|---|---|
| inline_keyboard | List<List<InlineKeyboardButton>> | true | Array of button rows, each represented by an Array of <a href="#inlinekeyboardbutton">InlineKeyboardButton</a> objects |

#### InlineKeyboardButton

    InlineKeyboardButton(text: String, url: String, login_url: LoginUrl, callback_data: String, switch_inline_query: String, switch_inline_query_current_chat: String, callback_game: CallbackGame, pay: Boolean)

<p>This object represents one button of an inline keyboard. You <strong>must</strong> use exactly one of the optional fields.</p>

| name | type | required | description |
|---|---|---|---|
| text | String | true | Label text on the button |
| url | String | false | <em>Optional</em>. HTTP or tg:// url to be opened when button is pressed |
| login_url | LoginUrl | false | <em>Optional</em>. An HTTP URL used to automatically authorize the user. Can be used as a replacement for the <a href="https://core.telegram.org/widgets/login">Telegram Login Widget</a>. |
| callback_data | String | false | <em>Optional</em>. Data to be sent in a <a href="#callbackquery">callback query</a> to the bot when button is pressed, 1-64 bytes |
| switch_inline_query | String | false | <em>Optional</em>. If set, pressing the button will prompt the user to select one of their chats, open that chat and insert the bot‘s username and the specified inline query in the input field. Can be empty, in which case just the bot’s username will be inserted.<br><br><strong>Note:</strong> This offers an easy way for users to start using your bot in <a href="/bots/inline">inline mode</a> when they are currently in a private chat with it. Especially useful when combined with <a href="#answerinlinequery"><em>switch_pm…</em></a> actions – in this case the user will be automatically returned to the chat they switched from, skipping the chat selection screen. |
| switch_inline_query_current_chat | String | false | <em>Optional</em>. If set, pressing the button will insert the bot‘s username and the specified inline query in the current chat’s input field. Can be empty, in which case only the bot's username will be inserted.<br><br>This offers a quick way for the user to open your bot in inline mode in the same chat – good for selecting something from multiple options. |
| callback_game | CallbackGame | false | <em>Optional</em>. Description of the game that will be launched when the user presses the button.<br><br><strong>NOTE:</strong> This type of button <strong>must</strong> always be the first button in the first row. |
| pay | Boolean | false | <em>Optional</em>. Specify True, to send a <a href="#payments">Pay button</a>.<br><br><strong>NOTE:</strong> This type of button <strong>must</strong> always be the first button in the first row. |

#### LoginUrl

    LoginUrl(url: String, forward_text: String, bot_username: String, request_write_access: Boolean)

<p>This object represents a parameter of the inline keyboard button used to automatically authorize a user. Serves as a great replacement for the <a href="https://core.telegram.org/widgets/login">Telegram Login Widget</a> when the user is coming from Telegram. All the user needs to do is tap/click a button and confirm that they want to log in:</p><p>Telegram apps support these buttons as of <a href="https://telegram.org/blog/privacy-discussions-web-bots#meet-seamless-web-bots">version 5.7</a>.</p><blockquote> 
 <p>Sample bot: <a href="https://t.me/discussbot">@discussbot</a></p> 
</blockquote>

| name | type | required | description |
|---|---|---|---|
| url | String | true | An HTTP URL to be opened with user authorization data added to the query string when the button is pressed. If the user refuses to provide authorization data, the original URL without information about the user will be opened. The data added is the same as described in <a href="https://core.telegram.org/widgets/login#receiving-authorization-data">Receiving authorization data</a>.<br><br><strong>NOTE:</strong> You <strong>must</strong> always check the hash of the received data to verify the authentication and the integrity of the data as described in <a href="https://core.telegram.org/widgets/login#checking-authorization">Checking authorization</a>. |
| forward_text | String | false | <em>Optional</em>. New text of the button in forwarded messages. |
| bot_username | String | false | <em>Optional</em>. Username of a bot, which will be used for user authorization. See <a href="https://core.telegram.org/widgets/login#setting-up-a-bot">Setting up a bot</a> for more details. If not specified, the current bot's username will be assumed. The <em>url</em>'s domain must be the same as the domain linked with the bot. See <a href="https://core.telegram.org/widgets/login#linking-your-domain-to-the-bot">Linking your domain to the bot</a> for more details. |
| request_write_access | Boolean | false | <em>Optional</em>. Pass True to request the permission for your bot to send messages to the user. |

#### CallbackQuery

    CallbackQuery(id: String, from: User, message: Message, inline_message_id: String, chat_instance: String, data: String, game_short_name: String)

<p>This object represents an incoming callback query from a callback button in an <a href="/bots#inline-keyboards-and-on-the-fly-updating">inline keyboard</a>. If the button that originated the query was attached to a message sent by the bot, the field <em>message</em> will be present. If the button was attached to a message sent via the bot (in <a href="#inline-mode">inline mode</a>), the field <em>inline_message_id</em> will be present. Exactly one of the fields <em>data</em> or <em>game_short_name</em> will be present.</p><blockquote> 
 <p><strong>NOTE:</strong> After the user presses a callback button, Telegram clients will display a progress bar until you call <a href="#answercallbackquery">answerCallbackQuery</a>. It is, therefore, necessary to react by calling <a href="#answercallbackquery">answerCallbackQuery</a> even if no notification to the user is needed (e.g., without specifying any of the optional parameters).</p> 
</blockquote>

| name | type | required | description |
|---|---|---|---|
| id | String | true | Unique identifier for this query |
| from | User | true | Sender |
| message | Message | false | <em>Optional</em>. Message with the callback button that originated the query. Note that message content and message date will not be available if the message is too old |
| inline_message_id | String | false | <em>Optional</em>. Identifier of the message sent via the bot in inline mode, that originated the query. |
| chat_instance | String | true | Global identifier, uniquely corresponding to the chat to which the message with the callback button was sent. Useful for high scores in <a href="#games">games</a>. |
| data | String | false | <em>Optional</em>. Data associated with the callback button. Be aware that a bad client can send arbitrary data in this field. |
| game_short_name | String | false | <em>Optional</em>. Short name of a <a href="#games">Game</a> to be returned, serves as the unique identifier for the game |

#### ForceReply

    ForceReply(force_reply: Boolean, selective: Boolean)

<p>Upon receiving a message with this object, Telegram clients will display a reply interface to the user (act as if the user has selected the bot‘s message and tapped ’Reply'). This can be extremely useful if you want to create user-friendly step-by-step interfaces without having to sacrifice <a href="/bots#privacy-mode">privacy mode</a>.</p><blockquote> 
 <p><strong>Example:</strong> A <a href="https://t.me/PollBot">poll bot</a> for groups runs in privacy mode (only receives commands, replies to its messages and mentions). There could be two ways to create a new poll:</p> 
 <ul> 
  <li>Explain the user how to send a command with parameters (e.g. /newpoll question answer1 answer2). May be appealing for hardcore users but lacks modern day polish.</li> 
  <li>Guide the user through a step-by-step process. ‘Please send me your question’, ‘Cool, now let’s add the first answer option‘, ’Great. Keep adding answer options, then send /done when you‘re ready’.</li> 
 </ul> 
 <p>The last option is definitely more attractive. And if you use <a href="#forcereply">ForceReply</a> in your bot‘s questions, it will receive the user’s answers even if it only receives replies, commands and mentions — without any extra work for the user.</p> 
</blockquote>

| name | type | required | description |
|---|---|---|---|
| force_reply | Boolean | true | Shows reply interface to the user, as if they manually selected the bot‘s message and tapped ’Reply' |
| selective | Boolean | false | <em>Optional</em>. Use this parameter if you want to force reply from specific users only. Targets: 1) users that are @mentioned in the <em>text</em> of the <a href="#message">Message</a> object; 2) if the bot's message is a reply (has <em>reply_to_message_id</em>), sender of the original message. |

#### ChatPhoto

    ChatPhoto(small_file_id: String, small_file_unique_id: String, big_file_id: String, big_file_unique_id: String)

<p>This object represents a chat photo.</p>

| name | type | required | description |
|---|---|---|---|
| small_file_id | String | true | File identifier of small (160x160) chat photo. This file_id can be used only for photo download and only for as long as the photo is not changed. |
| small_file_unique_id | String | true | Unique file identifier of small (160x160) chat photo, which is supposed to be the same over time and for different bots. Can't be used to download or reuse the file. |
| big_file_id | String | true | File identifier of big (640x640) chat photo. This file_id can be used only for photo download and only for as long as the photo is not changed. |
| big_file_unique_id | String | true | Unique file identifier of big (640x640) chat photo, which is supposed to be the same over time and for different bots. Can't be used to download or reuse the file. |

#### ChatMember

    ChatMember(user: User, status: String, custom_title: String, until_date: Integer, can_be_edited: Boolean, can_post_messages: Boolean, can_edit_messages: Boolean, can_delete_messages: Boolean, can_restrict_members: Boolean, can_promote_members: Boolean, can_change_info: Boolean, can_invite_users: Boolean, can_pin_messages: Boolean, is_member: Boolean, can_send_messages: Boolean, can_send_media_messages: Boolean, can_send_polls: Boolean, can_send_other_messages: Boolean, can_add_web_page_previews: Boolean)

<p>This object contains information about one member of a chat.</p>

| name | type | required | description |
|---|---|---|---|
| user | User | true | Information about the user |
| status | String | true | The member's status in the chat. Can be “creator”, “administrator”, “member”, “restricted”, “left” or “kicked” |
| custom_title | String | false | <em>Optional</em>. Owner and administrators only. Custom title for this user |
| until_date | Integer | false | <em>Optional</em>. Restricted and kicked only. Date when restrictions will be lifted for this user; unix time |
| can_be_edited | Boolean | false | <em>Optional</em>. Administrators only. True, if the bot is allowed to edit administrator privileges of that user |
| can_post_messages | Boolean | false | <em>Optional</em>. Administrators only. True, if the administrator can post in the channel; channels only |
| can_edit_messages | Boolean | false | <em>Optional</em>. Administrators only. True, if the administrator can edit messages of other users and can pin messages; channels only |
| can_delete_messages | Boolean | false | <em>Optional</em>. Administrators only. True, if the administrator can delete messages of other users |
| can_restrict_members | Boolean | false | <em>Optional</em>. Administrators only. True, if the administrator can restrict, ban or unban chat members |
| can_promote_members | Boolean | false | <em>Optional</em>. Administrators only. True, if the administrator can add new administrators with a subset of their own privileges or demote administrators that he has promoted, directly or indirectly (promoted by administrators that were appointed by the user) |
| can_change_info | Boolean | false | <em>Optional</em>. Administrators and restricted only. True, if the user is allowed to change the chat title, photo and other settings |
| can_invite_users | Boolean | false | <em>Optional</em>. Administrators and restricted only. True, if the user is allowed to invite new users to the chat |
| can_pin_messages | Boolean | false | <em>Optional</em>. Administrators and restricted only. True, if the user is allowed to pin messages; groups and supergroups only |
| is_member | Boolean | false | <em>Optional</em>. Restricted only. True, if the user is a member of the chat at the moment of the request |
| can_send_messages | Boolean | false | <em>Optional</em>. Restricted only. True, if the user is allowed to send text messages, contacts, locations and venues |
| can_send_media_messages | Boolean | false | <em>Optional</em>. Restricted only. True, if the user is allowed to send audios, documents, photos, videos, video notes and voice notes |
| can_send_polls | Boolean | false | <em>Optional</em>. Restricted only. True, if the user is allowed to send polls |
| can_send_other_messages | Boolean | false | <em>Optional</em>. Restricted only. True, if the user is allowed to send animations, games, stickers and use inline bots |
| can_add_web_page_previews | Boolean | false | <em>Optional</em>. Restricted only. True, if the user is allowed to add web page previews to their messages |

#### ChatPermissions

    ChatPermissions(can_send_messages: Boolean, can_send_media_messages: Boolean, can_send_polls: Boolean, can_send_other_messages: Boolean, can_add_web_page_previews: Boolean, can_change_info: Boolean, can_invite_users: Boolean, can_pin_messages: Boolean)

<p>Describes actions that a non-administrator user is allowed to take in a chat.</p>

| name | type | required | description |
|---|---|---|---|
| can_send_messages | Boolean | false | <em>Optional</em>. True, if the user is allowed to send text messages, contacts, locations and venues |
| can_send_media_messages | Boolean | false | <em>Optional</em>. True, if the user is allowed to send audios, documents, photos, videos, video notes and voice notes, implies can_send_messages |
| can_send_polls | Boolean | false | <em>Optional</em>. True, if the user is allowed to send polls, implies can_send_messages |
| can_send_other_messages | Boolean | false | <em>Optional</em>. True, if the user is allowed to send animations, games, stickers and use inline bots, implies can_send_media_messages |
| can_add_web_page_previews | Boolean | false | <em>Optional</em>. True, if the user is allowed to add web page previews to their messages, implies can_send_media_messages |
| can_change_info | Boolean | false | <em>Optional</em>. True, if the user is allowed to change the chat title, photo and other settings. Ignored in public supergroups |
| can_invite_users | Boolean | false | <em>Optional</em>. True, if the user is allowed to invite new users to the chat |
| can_pin_messages | Boolean | false | <em>Optional</em>. True, if the user is allowed to pin messages. Ignored in public supergroups |

#### BotCommand

    BotCommand(command: String, description: String)

<p>This object represents a bot command.</p>

| name | type | required | description |
|---|---|---|---|
| command | String | true | Text of the command, 1-32 characters. Can contain only lowercase English letters, digits and underscores. |
| description | String | true | Description of the command, 3-256 characters. |

#### ResponseParameters

    ResponseParameters(migrate_to_chat_id: Integer, retry_after: Integer)

<p>Contains information about why a request was unsuccessful.</p>

| name | type | required | description |
|---|---|---|---|
| migrate_to_chat_id | Integer | false | <em>Optional</em>. The group has been migrated to a supergroup with the specified identifier. This number may be greater than 32 bits and some programming languages may have difficulty/silent defects in interpreting it. But it is smaller than 52 bits, so a signed 64 bit integer or double-precision float type are safe for storing this identifier. |
| retry_after | Integer | false | <em>Optional</em>. In case of exceeding flood control, the number of seconds left to wait before the request can be repeated |

#### InputMediaPhoto

    InputMediaPhoto(type: String, media: String, caption: String, parse_mode: ParseMode)

<p>Represents a photo to be sent.</p>

| name | type | required | description |
|---|---|---|---|
| type | String | true | Type of the result, must be <em>photo</em> |
| media | String | true | File to send. Pass a file_id to send a file that exists on the Telegram servers (recommended), pass an HTTP URL for Telegram to get a file from the Internet, or pass “attach://&lt;file_attach_name&gt;” to upload a new one using multipart/form-data under &lt;file_attach_name&gt; name. <a href="#sending-files">More info on Sending Files »</a> |
| caption | String | false | <em>Optional</em>. Caption of the photo to be sent, 0-1024 characters after entities parsing |
| parse_mode | ParseMode | false | <em>Optional</em>. Mode for parsing entities in the photo caption. See <a href="#formatting-options">formatting options</a> for more details. |

#### InputMediaVideo

    InputMediaVideo(type: String, media: String, thumb: InputFileOrString, caption: String, parse_mode: ParseMode, width: Integer, height: Integer, duration: Integer, supports_streaming: Boolean)

<p>Represents a video to be sent.</p>

| name | type | required | description |
|---|---|---|---|
| type | String | true | Type of the result, must be <em>video</em> |
| media | String | true | File to send. Pass a file_id to send a file that exists on the Telegram servers (recommended), pass an HTTP URL for Telegram to get a file from the Internet, or pass “attach://&lt;file_attach_name&gt;” to upload a new one using multipart/form-data under &lt;file_attach_name&gt; name. <a href="#sending-files">More info on Sending Files »</a> |
| thumb | InputFileOrString | false | <em>Optional</em>. Thumbnail of the file sent; can be ignored if thumbnail generation for the file is supported server-side. The thumbnail should be in JPEG format and less than 200 kB in size. A thumbnail‘s width and height should not exceed 320. Ignored if the file is not uploaded using multipart/form-data. Thumbnails can’t be reused and can be only uploaded as a new file, so you can pass “attach://&lt;file_attach_name&gt;” if the thumbnail was uploaded using multipart/form-data under &lt;file_attach_name&gt;. <a href="#sending-files">More info on Sending Files »</a> |
| caption | String | false | <em>Optional</em>. Caption of the video to be sent, 0-1024 characters after entities parsing |
| parse_mode | ParseMode | false | <em>Optional</em>. Mode for parsing entities in the video caption. See <a href="#formatting-options">formatting options</a> for more details. |
| width | Integer | false | <em>Optional</em>. Video width |
| height | Integer | false | <em>Optional</em>. Video height |
| duration | Integer | false | <em>Optional</em>. Video duration |
| supports_streaming | Boolean | false | <em>Optional</em>. Pass <em>True</em>, if the uploaded video is suitable for streaming |

#### InputMediaAnimation

    InputMediaAnimation(type: String, media: String, thumb: InputFileOrString, caption: String, parse_mode: ParseMode, width: Integer, height: Integer, duration: Integer)

<p>Represents an animation file (GIF or H.264/MPEG-4 AVC video without sound) to be sent.</p>

| name | type | required | description |
|---|---|---|---|
| type | String | true | Type of the result, must be <em>animation</em> |
| media | String | true | File to send. Pass a file_id to send a file that exists on the Telegram servers (recommended), pass an HTTP URL for Telegram to get a file from the Internet, or pass “attach://&lt;file_attach_name&gt;” to upload a new one using multipart/form-data under &lt;file_attach_name&gt; name. <a href="#sending-files">More info on Sending Files »</a> |
| thumb | InputFileOrString | false | <em>Optional</em>. Thumbnail of the file sent; can be ignored if thumbnail generation for the file is supported server-side. The thumbnail should be in JPEG format and less than 200 kB in size. A thumbnail‘s width and height should not exceed 320. Ignored if the file is not uploaded using multipart/form-data. Thumbnails can’t be reused and can be only uploaded as a new file, so you can pass “attach://&lt;file_attach_name&gt;” if the thumbnail was uploaded using multipart/form-data under &lt;file_attach_name&gt;. <a href="#sending-files">More info on Sending Files »</a> |
| caption | String | false | <em>Optional</em>. Caption of the animation to be sent, 0-1024 characters after entities parsing |
| parse_mode | ParseMode | false | <em>Optional</em>. Mode for parsing entities in the animation caption. See <a href="#formatting-options">formatting options</a> for more details. |
| width | Integer | false | <em>Optional</em>. Animation width |
| height | Integer | false | <em>Optional</em>. Animation height |
| duration | Integer | false | <em>Optional</em>. Animation duration |

#### InputMediaAudio

    InputMediaAudio(type: String, media: String, thumb: InputFileOrString, caption: String, parse_mode: ParseMode, duration: Integer, performer: String, title: String)

<p>Represents an audio file to be treated as music to be sent.</p>

| name | type | required | description |
|---|---|---|---|
| type | String | true | Type of the result, must be <em>audio</em> |
| media | String | true | File to send. Pass a file_id to send a file that exists on the Telegram servers (recommended), pass an HTTP URL for Telegram to get a file from the Internet, or pass “attach://&lt;file_attach_name&gt;” to upload a new one using multipart/form-data under &lt;file_attach_name&gt; name. <a href="#sending-files">More info on Sending Files »</a> |
| thumb | InputFileOrString | false | <em>Optional</em>. Thumbnail of the file sent; can be ignored if thumbnail generation for the file is supported server-side. The thumbnail should be in JPEG format and less than 200 kB in size. A thumbnail‘s width and height should not exceed 320. Ignored if the file is not uploaded using multipart/form-data. Thumbnails can’t be reused and can be only uploaded as a new file, so you can pass “attach://&lt;file_attach_name&gt;” if the thumbnail was uploaded using multipart/form-data under &lt;file_attach_name&gt;. <a href="#sending-files">More info on Sending Files »</a> |
| caption | String | false | <em>Optional</em>. Caption of the audio to be sent, 0-1024 characters after entities parsing |
| parse_mode | ParseMode | false | <em>Optional</em>. Mode for parsing entities in the audio caption. See <a href="#formatting-options">formatting options</a> for more details. |
| duration | Integer | false | <em>Optional</em>. Duration of the audio in seconds |
| performer | String | false | <em>Optional</em>. Performer of the audio |
| title | String | false | <em>Optional</em>. Title of the audio |

#### InputMediaDocument

    InputMediaDocument(type: String, media: String, thumb: InputFileOrString, caption: String, parse_mode: ParseMode)

<p>Represents a general file to be sent.</p>

| name | type | required | description |
|---|---|---|---|
| type | String | true | Type of the result, must be <em>document</em> |
| media | String | true | File to send. Pass a file_id to send a file that exists on the Telegram servers (recommended), pass an HTTP URL for Telegram to get a file from the Internet, or pass “attach://&lt;file_attach_name&gt;” to upload a new one using multipart/form-data under &lt;file_attach_name&gt; name. <a href="#sending-files">More info on Sending Files »</a> |
| thumb | InputFileOrString | false | <em>Optional</em>. Thumbnail of the file sent; can be ignored if thumbnail generation for the file is supported server-side. The thumbnail should be in JPEG format and less than 200 kB in size. A thumbnail‘s width and height should not exceed 320. Ignored if the file is not uploaded using multipart/form-data. Thumbnails can’t be reused and can be only uploaded as a new file, so you can pass “attach://&lt;file_attach_name&gt;” if the thumbnail was uploaded using multipart/form-data under &lt;file_attach_name&gt;. <a href="#sending-files">More info on Sending Files »</a> |
| caption | String | false | <em>Optional</em>. Caption of the document to be sent, 0-1024 characters after entities parsing |
| parse_mode | ParseMode | false | <em>Optional</em>. Mode for parsing entities in the document caption. See <a href="#formatting-options">formatting options</a> for more details. |



## Available methods

### Methods
#### sendMessage

    sendMessage(chat_id: IntegerOrString, text: String, parse_mode: ParseMode, disable_web_page_preview: Boolean, disable_notification: Boolean, reply_to_message_id: Integer, reply_markup: KeyboardOption)

<p>Use this method to send text messages. On success, the sent <a href="#message">Message</a> is returned.</p>

| name | type | required | description |
|---|---|---|---|
| chat_id | IntegerOrString | true | Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>) |
| text | String | true | Text of the message to be sent, 1-4096 characters after entities parsing |
| parse_mode | ParseMode | false | Mode for parsing entities in the message text. See <a href="#formatting-options">formatting options</a> for more details. |
| disable_web_page_preview | Boolean | false | Disables link previews for links in this message |
| disable_notification | Boolean | false | Sends the message <a href="https://telegram.org/blog/channels-2-0#silent-messages">silently</a>. Users will receive a notification with no sound. |
| reply_to_message_id | Integer | false | If the message is a reply, ID of the original message |
| reply_markup | KeyboardOption | false | Additional interface options. A JSON-serialized object for an <a href="https://core.telegram.org/bots#inline-keyboards-and-on-the-fly-updating">inline keyboard</a>, <a href="https://core.telegram.org/bots#keyboards">custom reply keyboard</a>, instructions to remove reply keyboard or to force a reply from the user. |

#### forwardMessage

    forwardMessage(chat_id: IntegerOrString, from_chat_id: IntegerOrString, disable_notification: Boolean, message_id: Integer)

<p>Use this method to forward messages of any kind. On success, the sent <a href="#message">Message</a> is returned.</p>

| name | type | required | description |
|---|---|---|---|
| chat_id | IntegerOrString | true | Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>) |
| from_chat_id | IntegerOrString | true | Unique identifier for the chat where the original message was sent (or channel username in the format <code>@channelusername</code>) |
| disable_notification | Boolean | false | Sends the message <a href="https://telegram.org/blog/channels-2-0#silent-messages">silently</a>. Users will receive a notification with no sound. |
| message_id | Integer | true | Message identifier in the chat specified in <em>from_chat_id</em> |

#### sendPhoto

    sendPhoto(chat_id: IntegerOrString, photo: InputFileOrString, caption: String, parse_mode: ParseMode, disable_notification: Boolean, reply_to_message_id: Integer, reply_markup: KeyboardOption)

<p>Use this method to send photos. On success, the sent <a href="#message">Message</a> is returned.</p>

| name | type | required | description |
|---|---|---|---|
| chat_id | IntegerOrString | true | Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>) |
| photo | InputFileOrString | true | Photo to send. Pass a file_id as String to send a photo that exists on the Telegram servers (recommended), pass an HTTP URL as a String for Telegram to get a photo from the Internet, or upload a new photo using multipart/form-data. <a href="#sending-files">More info on Sending Files »</a> |
| caption | String | false | Photo caption (may also be used when resending photos by <em>file_id</em>), 0-1024 characters after entities parsing |
| parse_mode | ParseMode | false | Mode for parsing entities in the photo caption. See <a href="#formatting-options">formatting options</a> for more details. |
| disable_notification | Boolean | false | Sends the message <a href="https://telegram.org/blog/channels-2-0#silent-messages">silently</a>. Users will receive a notification with no sound. |
| reply_to_message_id | Integer | false | If the message is a reply, ID of the original message |
| reply_markup | KeyboardOption | false | Additional interface options. A JSON-serialized object for an <a href="https://core.telegram.org/bots#inline-keyboards-and-on-the-fly-updating">inline keyboard</a>, <a href="https://core.telegram.org/bots#keyboards">custom reply keyboard</a>, instructions to remove reply keyboard or to force a reply from the user. |

#### sendAudio

    sendAudio(chat_id: IntegerOrString, audio: InputFileOrString, caption: String, parse_mode: ParseMode, duration: Integer, performer: String, title: String, thumb: InputFileOrString, disable_notification: Boolean, reply_to_message_id: Integer, reply_markup: KeyboardOption)

<p>Use this method to send audio files, if you want Telegram clients to display them in the music player. Your audio must be in the .MP3 or .M4A format. On success, the sent <a href="#message">Message</a> is returned. Bots can currently send audio files of up to 50 MB in size, this limit may be changed in the future.</p><p>For sending voice messages, use the <a href="#sendvoice">sendVoice</a> method instead.</p>

| name | type | required | description |
|---|---|---|---|
| chat_id | IntegerOrString | true | Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>) |
| audio | InputFileOrString | true | Audio file to send. Pass a file_id as String to send an audio file that exists on the Telegram servers (recommended), pass an HTTP URL as a String for Telegram to get an audio file from the Internet, or upload a new one using multipart/form-data. <a href="#sending-files">More info on Sending Files »</a> |
| caption | String | false | Audio caption, 0-1024 characters after entities parsing |
| parse_mode | ParseMode | false | Mode for parsing entities in the audio caption. See <a href="#formatting-options">formatting options</a> for more details. |
| duration | Integer | false | Duration of the audio in seconds |
| performer | String | false | Performer |
| title | String | false | Track name |
| thumb | InputFileOrString | false | Thumbnail of the file sent; can be ignored if thumbnail generation for the file is supported server-side. The thumbnail should be in JPEG format and less than 200 kB in size. A thumbnail‘s width and height should not exceed 320. Ignored if the file is not uploaded using multipart/form-data. Thumbnails can’t be reused and can be only uploaded as a new file, so you can pass “attach://&lt;file_attach_name&gt;” if the thumbnail was uploaded using multipart/form-data under &lt;file_attach_name&gt;. <a href="#sending-files">More info on Sending Files »</a> |
| disable_notification | Boolean | false | Sends the message <a href="https://telegram.org/blog/channels-2-0#silent-messages">silently</a>. Users will receive a notification with no sound. |
| reply_to_message_id | Integer | false | If the message is a reply, ID of the original message |
| reply_markup | KeyboardOption | false | Additional interface options. A JSON-serialized object for an <a href="https://core.telegram.org/bots#inline-keyboards-and-on-the-fly-updating">inline keyboard</a>, <a href="https://core.telegram.org/bots#keyboards">custom reply keyboard</a>, instructions to remove reply keyboard or to force a reply from the user. |

#### sendDocument

    sendDocument(chat_id: IntegerOrString, document: InputFileOrString, thumb: InputFileOrString, caption: String, parse_mode: ParseMode, disable_notification: Boolean, reply_to_message_id: Integer, reply_markup: KeyboardOption)

<p>Use this method to send general files. On success, the sent <a href="#message">Message</a> is returned. Bots can currently send files of any type of up to 50 MB in size, this limit may be changed in the future.</p>

| name | type | required | description |
|---|---|---|---|
| chat_id | IntegerOrString | true | Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>) |
| document | InputFileOrString | true | File to send. Pass a file_id as String to send a file that exists on the Telegram servers (recommended), pass an HTTP URL as a String for Telegram to get a file from the Internet, or upload a new one using multipart/form-data. <a href="#sending-files">More info on Sending Files »</a> |
| thumb | InputFileOrString | false | Thumbnail of the file sent; can be ignored if thumbnail generation for the file is supported server-side. The thumbnail should be in JPEG format and less than 200 kB in size. A thumbnail‘s width and height should not exceed 320. Ignored if the file is not uploaded using multipart/form-data. Thumbnails can’t be reused and can be only uploaded as a new file, so you can pass “attach://&lt;file_attach_name&gt;” if the thumbnail was uploaded using multipart/form-data under &lt;file_attach_name&gt;. <a href="#sending-files">More info on Sending Files »</a> |
| caption | String | false | Document caption (may also be used when resending documents by <em>file_id</em>), 0-1024 characters after entities parsing |
| parse_mode | ParseMode | false | Mode for parsing entities in the document caption. See <a href="#formatting-options">formatting options</a> for more details. |
| disable_notification | Boolean | false | Sends the message <a href="https://telegram.org/blog/channels-2-0#silent-messages">silently</a>. Users will receive a notification with no sound. |
| reply_to_message_id | Integer | false | If the message is a reply, ID of the original message |
| reply_markup | KeyboardOption | false | Additional interface options. A JSON-serialized object for an <a href="https://core.telegram.org/bots#inline-keyboards-and-on-the-fly-updating">inline keyboard</a>, <a href="https://core.telegram.org/bots#keyboards">custom reply keyboard</a>, instructions to remove reply keyboard or to force a reply from the user. |

#### sendVideo

    sendVideo(chat_id: IntegerOrString, video: InputFileOrString, duration: Integer, width: Integer, height: Integer, thumb: InputFileOrString, caption: String, parse_mode: ParseMode, supports_streaming: Boolean, disable_notification: Boolean, reply_to_message_id: Integer, reply_markup: KeyboardOption)

<p>Use this method to send video files, Telegram clients support mp4 videos (other formats may be sent as <a href="#document">Document</a>). On success, the sent <a href="#message">Message</a> is returned. Bots can currently send video files of up to 50 MB in size, this limit may be changed in the future.</p>

| name | type | required | description |
|---|---|---|---|
| chat_id | IntegerOrString | true | Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>) |
| video | InputFileOrString | true | Video to send. Pass a file_id as String to send a video that exists on the Telegram servers (recommended), pass an HTTP URL as a String for Telegram to get a video from the Internet, or upload a new video using multipart/form-data. <a href="#sending-files">More info on Sending Files »</a> |
| duration | Integer | false | Duration of sent video in seconds |
| width | Integer | false | Video width |
| height | Integer | false | Video height |
| thumb | InputFileOrString | false | Thumbnail of the file sent; can be ignored if thumbnail generation for the file is supported server-side. The thumbnail should be in JPEG format and less than 200 kB in size. A thumbnail‘s width and height should not exceed 320. Ignored if the file is not uploaded using multipart/form-data. Thumbnails can’t be reused and can be only uploaded as a new file, so you can pass “attach://&lt;file_attach_name&gt;” if the thumbnail was uploaded using multipart/form-data under &lt;file_attach_name&gt;. <a href="#sending-files">More info on Sending Files »</a> |
| caption | String | false | Video caption (may also be used when resending videos by <em>file_id</em>), 0-1024 characters after entities parsing |
| parse_mode | ParseMode | false | Mode for parsing entities in the video caption. See <a href="#formatting-options">formatting options</a> for more details. |
| supports_streaming | Boolean | false | Pass <em>True</em>, if the uploaded video is suitable for streaming |
| disable_notification | Boolean | false | Sends the message <a href="https://telegram.org/blog/channels-2-0#silent-messages">silently</a>. Users will receive a notification with no sound. |
| reply_to_message_id | Integer | false | If the message is a reply, ID of the original message |
| reply_markup | KeyboardOption | false | Additional interface options. A JSON-serialized object for an <a href="https://core.telegram.org/bots#inline-keyboards-and-on-the-fly-updating">inline keyboard</a>, <a href="https://core.telegram.org/bots#keyboards">custom reply keyboard</a>, instructions to remove reply keyboard or to force a reply from the user. |

#### sendAnimation

    sendAnimation(chat_id: IntegerOrString, animation: InputFileOrString, duration: Integer, width: Integer, height: Integer, thumb: InputFileOrString, caption: String, parse_mode: ParseMode, disable_notification: Boolean, reply_to_message_id: Integer, reply_markup: KeyboardOption)

<p>Use this method to send animation files (GIF or H.264/MPEG-4 AVC video without sound). On success, the sent <a href="#message">Message</a> is returned. Bots can currently send animation files of up to 50 MB in size, this limit may be changed in the future.</p>

| name | type | required | description |
|---|---|---|---|
| chat_id | IntegerOrString | true | Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>) |
| animation | InputFileOrString | true | Animation to send. Pass a file_id as String to send an animation that exists on the Telegram servers (recommended), pass an HTTP URL as a String for Telegram to get an animation from the Internet, or upload a new animation using multipart/form-data. <a href="#sending-files">More info on Sending Files »</a> |
| duration | Integer | false | Duration of sent animation in seconds |
| width | Integer | false | Animation width |
| height | Integer | false | Animation height |
| thumb | InputFileOrString | false | Thumbnail of the file sent; can be ignored if thumbnail generation for the file is supported server-side. The thumbnail should be in JPEG format and less than 200 kB in size. A thumbnail‘s width and height should not exceed 320. Ignored if the file is not uploaded using multipart/form-data. Thumbnails can’t be reused and can be only uploaded as a new file, so you can pass “attach://&lt;file_attach_name&gt;” if the thumbnail was uploaded using multipart/form-data under &lt;file_attach_name&gt;. <a href="#sending-files">More info on Sending Files »</a> |
| caption | String | false | Animation caption (may also be used when resending animation by <em>file_id</em>), 0-1024 characters after entities parsing |
| parse_mode | ParseMode | false | Mode for parsing entities in the animation caption. See <a href="#formatting-options">formatting options</a> for more details. |
| disable_notification | Boolean | false | Sends the message <a href="https://telegram.org/blog/channels-2-0#silent-messages">silently</a>. Users will receive a notification with no sound. |
| reply_to_message_id | Integer | false | If the message is a reply, ID of the original message |
| reply_markup | KeyboardOption | false | Additional interface options. A JSON-serialized object for an <a href="https://core.telegram.org/bots#inline-keyboards-and-on-the-fly-updating">inline keyboard</a>, <a href="https://core.telegram.org/bots#keyboards">custom reply keyboard</a>, instructions to remove reply keyboard or to force a reply from the user. |

#### sendVoice

    sendVoice(chat_id: IntegerOrString, voice: InputFileOrString, caption: String, parse_mode: ParseMode, duration: Integer, disable_notification: Boolean, reply_to_message_id: Integer, reply_markup: KeyboardOption)

<p>Use this method to send audio files, if you want Telegram clients to display the file as a playable voice message. For this to work, your audio must be in an .OGG file encoded with OPUS (other formats may be sent as <a href="#audio">Audio</a> or <a href="#document">Document</a>). On success, the sent <a href="#message">Message</a> is returned. Bots can currently send voice messages of up to 50 MB in size, this limit may be changed in the future.</p>

| name | type | required | description |
|---|---|---|---|
| chat_id | IntegerOrString | true | Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>) |
| voice | InputFileOrString | true | Audio file to send. Pass a file_id as String to send a file that exists on the Telegram servers (recommended), pass an HTTP URL as a String for Telegram to get a file from the Internet, or upload a new one using multipart/form-data. <a href="#sending-files">More info on Sending Files »</a> |
| caption | String | false | Voice message caption, 0-1024 characters after entities parsing |
| parse_mode | ParseMode | false | Mode for parsing entities in the voice message caption. See <a href="#formatting-options">formatting options</a> for more details. |
| duration | Integer | false | Duration of the voice message in seconds |
| disable_notification | Boolean | false | Sends the message <a href="https://telegram.org/blog/channels-2-0#silent-messages">silently</a>. Users will receive a notification with no sound. |
| reply_to_message_id | Integer | false | If the message is a reply, ID of the original message |
| reply_markup | KeyboardOption | false | Additional interface options. A JSON-serialized object for an <a href="https://core.telegram.org/bots#inline-keyboards-and-on-the-fly-updating">inline keyboard</a>, <a href="https://core.telegram.org/bots#keyboards">custom reply keyboard</a>, instructions to remove reply keyboard or to force a reply from the user. |

#### sendVideoNote

    sendVideoNote(chat_id: IntegerOrString, video_note: InputFileOrString, duration: Integer, length: Integer, thumb: InputFileOrString, disable_notification: Boolean, reply_to_message_id: Integer, reply_markup: KeyboardOption)

<p>As of <a href="https://telegram.org/blog/video-messages-and-telescope">v.4.0</a>, Telegram clients support rounded square mp4 videos of up to 1 minute long. Use this method to send video messages. On success, the sent <a href="#message">Message</a> is returned.</p>

| name | type | required | description |
|---|---|---|---|
| chat_id | IntegerOrString | true | Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>) |
| video_note | InputFileOrString | true | Video note to send. Pass a file_id as String to send a video note that exists on the Telegram servers (recommended) or upload a new video using multipart/form-data. <a href="#sending-files">More info on Sending Files »</a>. Sending video notes by a URL is currently unsupported |
| duration | Integer | false | Duration of sent video in seconds |
| length | Integer | false | Video width and height, i.e. diameter of the video message |
| thumb | InputFileOrString | false | Thumbnail of the file sent; can be ignored if thumbnail generation for the file is supported server-side. The thumbnail should be in JPEG format and less than 200 kB in size. A thumbnail‘s width and height should not exceed 320. Ignored if the file is not uploaded using multipart/form-data. Thumbnails can’t be reused and can be only uploaded as a new file, so you can pass “attach://&lt;file_attach_name&gt;” if the thumbnail was uploaded using multipart/form-data under &lt;file_attach_name&gt;. <a href="#sending-files">More info on Sending Files »</a> |
| disable_notification | Boolean | false | Sends the message <a href="https://telegram.org/blog/channels-2-0#silent-messages">silently</a>. Users will receive a notification with no sound. |
| reply_to_message_id | Integer | false | If the message is a reply, ID of the original message |
| reply_markup | KeyboardOption | false | Additional interface options. A JSON-serialized object for an <a href="https://core.telegram.org/bots#inline-keyboards-and-on-the-fly-updating">inline keyboard</a>, <a href="https://core.telegram.org/bots#keyboards">custom reply keyboard</a>, instructions to remove reply keyboard or to force a reply from the user. |

#### sendMediaGroup

    sendMediaGroup(chat_id: IntegerOrString, media: List<InputMediaPhotoOrVideo>, disable_notification: Boolean, reply_to_message_id: Integer)

<p>Use this method to send a group of photos or videos as an album. On success, an array of the sent <a href="#message">Messages</a> is returned.</p>

| name | type | required | description |
|---|---|---|---|
| chat_id | IntegerOrString | true | Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>) |
| media | List<InputMediaPhotoOrVideo> | true | A JSON-serialized array describing photos and videos to be sent, must include 2-10 items |
| disable_notification | Boolean | false | Sends the messages <a href="https://telegram.org/blog/channels-2-0#silent-messages">silently</a>. Users will receive a notification with no sound. |
| reply_to_message_id | Integer | false | If the messages are a reply, ID of the original message |

#### sendLocation

    sendLocation(chat_id: IntegerOrString, latitude: Float, longitude: Float, live_period: Integer, disable_notification: Boolean, reply_to_message_id: Integer, reply_markup: KeyboardOption)

<p>Use this method to send point on the map. On success, the sent <a href="#message">Message</a> is returned.</p>

| name | type | required | description |
|---|---|---|---|
| chat_id | IntegerOrString | true | Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>) |
| latitude | Float | true | Latitude of the location |
| longitude | Float | true | Longitude of the location |
| live_period | Integer | false | Period in seconds for which the location will be updated (see <a href="https://telegram.org/blog/live-locations">Live Locations</a>, should be between 60 and 86400. |
| disable_notification | Boolean | false | Sends the message <a href="https://telegram.org/blog/channels-2-0#silent-messages">silently</a>. Users will receive a notification with no sound. |
| reply_to_message_id | Integer | false | If the message is a reply, ID of the original message |
| reply_markup | KeyboardOption | false | Additional interface options. A JSON-serialized object for an <a href="https://core.telegram.org/bots#inline-keyboards-and-on-the-fly-updating">inline keyboard</a>, <a href="https://core.telegram.org/bots#keyboards">custom reply keyboard</a>, instructions to remove reply keyboard or to force a reply from the user. |

#### editMessageLiveLocation

    editMessageLiveLocation(chat_id: IntegerOrString, message_id: Integer, inline_message_id: String, latitude: Float, longitude: Float, reply_markup: InlineKeyboardMarkup)

<p>Use this method to edit live location messages. A location can be edited until its <em>live_period</em> expires or editing is explicitly disabled by a call to <a href="#stopmessagelivelocation">stopMessageLiveLocation</a>. On success, if the edited message was sent by the bot, the edited <a href="#message">Message</a> is returned, otherwise <em>True</em> is returned.</p>

| name | type | required | description |
|---|---|---|---|
| chat_id | IntegerOrString | false | Required if <em>inline_message_id</em> is not specified. Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>) |
| message_id | Integer | false | Required if <em>inline_message_id</em> is not specified. Identifier of the message to edit |
| inline_message_id | String | false | Required if <em>chat_id</em> and <em>message_id</em> are not specified. Identifier of the inline message |
| latitude | Float | true | Latitude of new location |
| longitude | Float | true | Longitude of new location |
| reply_markup | InlineKeyboardMarkup | false | A JSON-serialized object for a new <a href="https://core.telegram.org/bots#inline-keyboards-and-on-the-fly-updating">inline keyboard</a>. |

#### stopMessageLiveLocation

    stopMessageLiveLocation(chat_id: IntegerOrString, message_id: Integer, inline_message_id: String, reply_markup: InlineKeyboardMarkup)

<p>Use this method to stop updating a live location message before <em>live_period</em> expires. On success, if the message was sent by the bot, the sent <a href="#message">Message</a> is returned, otherwise <em>True</em> is returned.</p>

| name | type | required | description |
|---|---|---|---|
| chat_id | IntegerOrString | false | Required if <em>inline_message_id</em> is not specified. Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>) |
| message_id | Integer | false | Required if <em>inline_message_id</em> is not specified. Identifier of the message with live location to stop |
| inline_message_id | String | false | Required if <em>chat_id</em> and <em>message_id</em> are not specified. Identifier of the inline message |
| reply_markup | InlineKeyboardMarkup | false | A JSON-serialized object for a new <a href="https://core.telegram.org/bots#inline-keyboards-and-on-the-fly-updating">inline keyboard</a>. |

#### sendVenue

    sendVenue(chat_id: IntegerOrString, latitude: Float, longitude: Float, title: String, address: String, foursquare_id: String, foursquare_type: String, disable_notification: Boolean, reply_to_message_id: Integer, reply_markup: KeyboardOption)

<p>Use this method to send information about a venue. On success, the sent <a href="#message">Message</a> is returned.</p>

| name | type | required | description |
|---|---|---|---|
| chat_id | IntegerOrString | true | Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>) |
| latitude | Float | true | Latitude of the venue |
| longitude | Float | true | Longitude of the venue |
| title | String | true | Name of the venue |
| address | String | true | Address of the venue |
| foursquare_id | String | false | Foursquare identifier of the venue |
| foursquare_type | String | false | Foursquare type of the venue, if known. (For example, “arts_entertainment/default”, “arts_entertainment/aquarium” or “food/icecream”.) |
| disable_notification | Boolean | false | Sends the message <a href="https://telegram.org/blog/channels-2-0#silent-messages">silently</a>. Users will receive a notification with no sound. |
| reply_to_message_id | Integer | false | If the message is a reply, ID of the original message |
| reply_markup | KeyboardOption | false | Additional interface options. A JSON-serialized object for an <a href="https://core.telegram.org/bots#inline-keyboards-and-on-the-fly-updating">inline keyboard</a>, <a href="https://core.telegram.org/bots#keyboards">custom reply keyboard</a>, instructions to remove reply keyboard or to force a reply from the user. |

#### sendContact

    sendContact(chat_id: IntegerOrString, phone_number: String, first_name: String, last_name: String, vcard: String, disable_notification: Boolean, reply_to_message_id: Integer, reply_markup: KeyboardOption)

<p>Use this method to send phone contacts. On success, the sent <a href="#message">Message</a> is returned.</p>

| name | type | required | description |
|---|---|---|---|
| chat_id | IntegerOrString | true | Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>) |
| phone_number | String | true | Contact's phone number |
| first_name | String | true | Contact's first name |
| last_name | String | false | Contact's last name |
| vcard | String | false | Additional data about the contact in the form of a <a href="https://en.wikipedia.org/wiki/VCard">vCard</a>, 0-2048 bytes |
| disable_notification | Boolean | false | Sends the message <a href="https://telegram.org/blog/channels-2-0#silent-messages">silently</a>. Users will receive a notification with no sound. |
| reply_to_message_id | Integer | false | If the message is a reply, ID of the original message |
| reply_markup | KeyboardOption | false | Additional interface options. A JSON-serialized object for an <a href="https://core.telegram.org/bots#inline-keyboards-and-on-the-fly-updating">inline keyboard</a>, <a href="https://core.telegram.org/bots#keyboards">custom reply keyboard</a>, instructions to remove keyboard or to force a reply from the user. |

#### sendPoll

    sendPoll(chat_id: IntegerOrString, question: String, options: List<String>, is_anonymous: Boolean, type: String, allows_multiple_answers: Boolean, correct_option_id: Integer, explanation: String, explanation_parse_mode: String, open_period: Integer, close_date: Integer, is_closed: Boolean, disable_notification: Boolean, reply_to_message_id: Integer, reply_markup: KeyboardOption)

<p>Use this method to send a native poll. On success, the sent <a href="#message">Message</a> is returned.</p>

| name | type | required | description |
|---|---|---|---|
| chat_id | IntegerOrString | true | Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>) |
| question | String | true | Poll question, 1-255 characters |
| options | List<String> | true | A JSON-serialized list of answer options, 2-10 strings 1-100 characters each |
| is_anonymous | Boolean | false | True, if the poll needs to be anonymous, defaults to <em>True</em> |
| type | String | false | Poll type, “quiz” or “regular”, defaults to “regular” |
| allows_multiple_answers | Boolean | false | True, if the poll allows multiple answers, ignored for polls in quiz mode, defaults to <em>False</em> |
| correct_option_id | Integer | false | 0-based identifier of the correct answer option, required for polls in quiz mode |
| explanation | String | false | Text that is shown when a user chooses an incorrect answer or taps on the lamp icon in a quiz-style poll, 0-200 characters with at most 2 line feeds after entities parsing |
| explanation_parse_mode | String | false | Mode for parsing entities in the explanation. See <a href="#formatting-options">formatting options</a> for more details. |
| open_period | Integer | false | Amount of time in seconds the poll will be active after creation, 5-600. Can't be used together with <em>close_date</em>. |
| close_date | Integer | false | Point in time (Unix timestamp) when the poll will be automatically closed. Must be at least 5 and no more than 600 seconds in the future. Can't be used together with <em>open_period</em>. |
| is_closed | Boolean | false | Pass <em>True</em>, if the poll needs to be immediately closed. This can be useful for poll preview. |
| disable_notification | Boolean | false | Sends the message <a href="https://telegram.org/blog/channels-2-0#silent-messages">silently</a>. Users will receive a notification with no sound. |
| reply_to_message_id | Integer | false | If the message is a reply, ID of the original message |
| reply_markup | KeyboardOption | false | Additional interface options. A JSON-serialized object for an <a href="https://core.telegram.org/bots#inline-keyboards-and-on-the-fly-updating">inline keyboard</a>, <a href="https://core.telegram.org/bots#keyboards">custom reply keyboard</a>, instructions to remove reply keyboard or to force a reply from the user. |

#### sendDice

    sendDice(chat_id: IntegerOrString, emoji: String, disable_notification: Boolean, reply_to_message_id: Integer, reply_markup: KeyboardOption)

<p>Use this method to send a dice, which will have a random value from 1 to 6. On success, the sent <a href="#message">Message</a> is returned. (Yes, we're aware of the <em>“proper”</em> singular of <em>die</em>. But it's awkward, and we decided to help it change. One dice at a time!)</p>

| name | type | required | description |
|---|---|---|---|
| chat_id | IntegerOrString | true | Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>) |
| emoji | String | false | Emoji on which the dice throw animation is based. Currently, must be one of “<img class="emoji" src="//telegram.org/img/emoji/40/F09F8EB2.png" width="20" height="20" alt="🎲">” or “<img class="emoji" src="//telegram.org/img/emoji/40/F09F8EAF.png" width="20" height="20" alt="🎯">”. Defauts to “<img class="emoji" src="//telegram.org/img/emoji/40/F09F8EB2.png" width="20" height="20" alt="🎲">” |
| disable_notification | Boolean | false | Sends the message <a href="https://telegram.org/blog/channels-2-0#silent-messages">silently</a>. Users will receive a notification with no sound. |
| reply_to_message_id | Integer | false | If the message is a reply, ID of the original message |
| reply_markup | KeyboardOption | false | Additional interface options. A JSON-serialized object for an <a href="https://core.telegram.org/bots#inline-keyboards-and-on-the-fly-updating">inline keyboard</a>, <a href="https://core.telegram.org/bots#keyboards">custom reply keyboard</a>, instructions to remove reply keyboard or to force a reply from the user. |

#### sendChatAction

    sendChatAction(chat_id: IntegerOrString, action: String)

<p>Use this method when you need to tell the user that something is happening on the bot's side. The status is set for 5 seconds or less (when a message arrives from your bot, Telegram clients clear its typing status). Returns <em>True</em> on success.</p><blockquote> 
 <p>Example: The <a href="https://t.me/imagebot">ImageBot</a> needs some time to process a request and upload the image. Instead of sending a text message along the lines of “Retrieving image, please wait…”, the bot may use <a href="#sendchataction">sendChatAction</a> with <em>action</em> = <em>upload_photo</em>. The user will see a “sending photo” status for the bot.</p> 
</blockquote><p>We only recommend using this method when a response from the bot will take a <strong>noticeable</strong> amount of time to arrive.</p>

| name | type | required | description |
|---|---|---|---|
| chat_id | IntegerOrString | true | Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>) |
| action | String | true | Type of action to broadcast. Choose one, depending on what the user is about to receive: <em>typing</em> for <a href="#sendmessage">text messages</a>, <em>upload_photo</em> for <a href="#sendphoto">photos</a>, <em>record_video</em> or <em>upload_video</em> for <a href="#sendvideo">videos</a>, <em>record_audio</em> or <em>upload_audio</em> for <a href="#sendaudio">audio files</a>, <em>upload_document</em> for <a href="#senddocument">general files</a>, <em>find_location</em> for <a href="#sendlocation">location data</a>, <em>record_video_note</em> or <em>upload_video_note</em> for <a href="#sendvideonote">video notes</a>. |

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

<p>Use this method to get basic info about a file and prepare it for downloading. For the moment, bots can download files of up to 20MB in size. On success, a <a href="#file">File</a> object is returned. The file can then be downloaded via the link <code>https://api.telegram.org/file/bot&lt;token&gt;/&lt;file_path&gt;</code>, where <code>&lt;file_path&gt;</code> is taken from the response. It is guaranteed that the link will be valid for at least 1 hour. When the link expires, a new one can be requested by calling <a href="#getfile">getFile</a> again.</p><p><strong>Note:</strong> This function may not preserve the original file name and MIME type. You should save the file's MIME type and name (if available) when the File object is received.</p>

| name | type | required | description |
|---|---|---|---|
| file_id | String | true | File identifier to get info about |

#### kickChatMember

    kickChatMember(chat_id: IntegerOrString, user_id: Integer, until_date: Integer)

<p>Use this method to kick a user from a group, a supergroup or a channel. In the case of supergroups and channels, the user will not be able to return to the group on their own using invite links, etc., unless <a href="#unbanchatmember">unbanned</a> first. The bot must be an administrator in the chat for this to work and must have the appropriate admin rights. Returns <em>True</em> on success.</p>

| name | type | required | description |
|---|---|---|---|
| chat_id | IntegerOrString | true | Unique identifier for the target group or username of the target supergroup or channel (in the format <code>@channelusername</code>) |
| user_id | Integer | true | Unique identifier of the target user |
| until_date | Integer | false | Date when the user will be unbanned, unix time. If user is banned for more than 366 days or less than 30 seconds from the current time they are considered to be banned forever |

#### unbanChatMember

    unbanChatMember(chat_id: IntegerOrString, user_id: Integer)

<p>Use this method to unban a previously kicked user in a supergroup or channel. The user will <strong>not</strong> return to the group or channel automatically, but will be able to join via link, etc. The bot must be an administrator for this to work. Returns <em>True</em> on success.</p>

| name | type | required | description |
|---|---|---|---|
| chat_id | IntegerOrString | true | Unique identifier for the target group or username of the target supergroup or channel (in the format <code>@username</code>) |
| user_id | Integer | true | Unique identifier of the target user |

#### restrictChatMember

    restrictChatMember(chat_id: IntegerOrString, user_id: Integer, permissions: ChatPermissions, until_date: Integer)

<p>Use this method to restrict a user in a supergroup. The bot must be an administrator in the supergroup for this to work and must have the appropriate admin rights. Pass <em>True</em> for all permissions to lift restrictions from a user. Returns <em>True</em> on success.</p>

| name | type | required | description |
|---|---|---|---|
| chat_id | IntegerOrString | true | Unique identifier for the target chat or username of the target supergroup (in the format <code>@supergroupusername</code>) |
| user_id | Integer | true | Unique identifier of the target user |
| permissions | ChatPermissions | true | New user permissions |
| until_date | Integer | false | Date when restrictions will be lifted for the user, unix time. If user is restricted for more than 366 days or less than 30 seconds from the current time, they are considered to be restricted forever |

#### promoteChatMember

    promoteChatMember(chat_id: IntegerOrString, user_id: Integer, can_change_info: Boolean, can_post_messages: Boolean, can_edit_messages: Boolean, can_delete_messages: Boolean, can_invite_users: Boolean, can_restrict_members: Boolean, can_pin_messages: Boolean, can_promote_members: Boolean)

<p>Use this method to promote or demote a user in a supergroup or a channel. The bot must be an administrator in the chat for this to work and must have the appropriate admin rights. Pass <em>False</em> for all boolean parameters to demote a user. Returns <em>True</em> on success.</p>

| name | type | required | description |
|---|---|---|---|
| chat_id | IntegerOrString | true | Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>) |
| user_id | Integer | true | Unique identifier of the target user |
| can_change_info | Boolean | false | Pass True, if the administrator can change chat title, photo and other settings |
| can_post_messages | Boolean | false | Pass True, if the administrator can create channel posts, channels only |
| can_edit_messages | Boolean | false | Pass True, if the administrator can edit messages of other users and can pin messages, channels only |
| can_delete_messages | Boolean | false | Pass True, if the administrator can delete messages of other users |
| can_invite_users | Boolean | false | Pass True, if the administrator can invite new users to the chat |
| can_restrict_members | Boolean | false | Pass True, if the administrator can restrict, ban or unban chat members |
| can_pin_messages | Boolean | false | Pass True, if the administrator can pin messages, supergroups only |
| can_promote_members | Boolean | false | Pass True, if the administrator can add new administrators with a subset of their own privileges or demote administrators that he has promoted, directly or indirectly (promoted by administrators that were appointed by him) |

#### setChatAdministratorCustomTitle

    setChatAdministratorCustomTitle(chat_id: IntegerOrString, user_id: Integer, custom_title: String)

<p>Use this method to set a custom title for an administrator in a supergroup promoted by the bot. Returns <em>True</em> on success.</p>

| name | type | required | description |
|---|---|---|---|
| chat_id | IntegerOrString | true | Unique identifier for the target chat or username of the target supergroup (in the format <code>@supergroupusername</code>) |
| user_id | Integer | true | Unique identifier of the target user |
| custom_title | String | true | New custom title for the administrator; 0-16 characters, emoji are not allowed |

#### setChatPermissions

    setChatPermissions(chat_id: IntegerOrString, permissions: ChatPermissions)

<p>Use this method to set default chat permissions for all members. The bot must be an administrator in the group or a supergroup for this to work and must have the <em>can_restrict_members</em> admin rights. Returns <em>True</em> on success.</p>

| name | type | required | description |
|---|---|---|---|
| chat_id | IntegerOrString | true | Unique identifier for the target chat or username of the target supergroup (in the format <code>@supergroupusername</code>) |
| permissions | ChatPermissions | true | New default chat permissions |

#### exportChatInviteLink

    exportChatInviteLink(chat_id: IntegerOrString)

<p>Use this method to generate a new invite link for a chat; any previously generated link is revoked. The bot must be an administrator in the chat for this to work and must have the appropriate admin rights. Returns the new invite link as <em>String</em> on success.</p><blockquote> 
 <p>Note: Each administrator in a chat generates their own invite links. Bots can't use invite links generated by other administrators. If you want your bot to work with invite links, it will need to generate its own link using <a href="#exportchatinvitelink">exportChatInviteLink</a> — after this the link will become available to the bot via the <a href="#getchat">getChat</a> method. If your bot needs to generate a new invite link replacing its previous one, use <a href="#exportchatinvitelink">exportChatInviteLink</a> again.</p> 
</blockquote>

| name | type | required | description |
|---|---|---|---|
| chat_id | IntegerOrString | true | Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>) |

#### setChatPhoto

    setChatPhoto(chat_id: IntegerOrString, photo: InputFile)

<p>Use this method to set a new profile photo for the chat. Photos can't be changed for private chats. The bot must be an administrator in the chat for this to work and must have the appropriate admin rights. Returns <em>True</em> on success.</p>

| name | type | required | description |
|---|---|---|---|
| chat_id | IntegerOrString | true | Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>) |
| photo | InputFile | true | New chat photo, uploaded using multipart/form-data |

#### deleteChatPhoto

    deleteChatPhoto(chat_id: IntegerOrString)

<p>Use this method to delete a chat photo. Photos can't be changed for private chats. The bot must be an administrator in the chat for this to work and must have the appropriate admin rights. Returns <em>True</em> on success.</p>

| name | type | required | description |
|---|---|---|---|
| chat_id | IntegerOrString | true | Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>) |

#### setChatTitle

    setChatTitle(chat_id: IntegerOrString, title: String)

<p>Use this method to change the title of a chat. Titles can't be changed for private chats. The bot must be an administrator in the chat for this to work and must have the appropriate admin rights. Returns <em>True</em> on success.</p>

| name | type | required | description |
|---|---|---|---|
| chat_id | IntegerOrString | true | Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>) |
| title | String | true | New chat title, 1-255 characters |

#### setChatDescription

    setChatDescription(chat_id: IntegerOrString, description: String)

<p>Use this method to change the description of a group, a supergroup or a channel. The bot must be an administrator in the chat for this to work and must have the appropriate admin rights. Returns <em>True</em> on success.</p>

| name | type | required | description |
|---|---|---|---|
| chat_id | IntegerOrString | true | Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>) |
| description | String | false | New chat description, 0-255 characters |

#### pinChatMessage

    pinChatMessage(chat_id: IntegerOrString, message_id: Integer, disable_notification: Boolean)

<p>Use this method to pin a message in a group, a supergroup, or a channel. The bot must be an administrator in the chat for this to work and must have the ‘can_pin_messages’ admin right in the supergroup or ‘can_edit_messages’ admin right in the channel. Returns <em>True</em> on success.</p>

| name | type | required | description |
|---|---|---|---|
| chat_id | IntegerOrString | true | Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>) |
| message_id | Integer | true | Identifier of a message to pin |
| disable_notification | Boolean | false | Pass <em>True</em>, if it is not necessary to send a notification to all chat members about the new pinned message. Notifications are always disabled in channels. |

#### unpinChatMessage

    unpinChatMessage(chat_id: IntegerOrString)

<p>Use this method to unpin a message in a group, a supergroup, or a channel. The bot must be an administrator in the chat for this to work and must have the ‘can_pin_messages’ admin right in the supergroup or ‘can_edit_messages’ admin right in the channel. Returns <em>True</em> on success.</p>

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

<p>Use this method to get up to date information about the chat (current name of the user for one-on-one conversations, current username of a user, group or channel, etc.). Returns a <a href="#chat">Chat</a> object on success.</p>

| name | type | required | description |
|---|---|---|---|
| chat_id | IntegerOrString | true | Unique identifier for the target chat or username of the target supergroup or channel (in the format <code>@channelusername</code>) |

#### getChatAdministrators

    getChatAdministrators(chat_id: IntegerOrString)

<p>Use this method to get a list of administrators in a chat. On success, returns an Array of <a href="#chatmember">ChatMember</a> objects that contains information about all chat administrators except other bots. If the chat is a group or a supergroup and no administrators were appointed, only the creator will be returned.</p>

| name | type | required | description |
|---|---|---|---|
| chat_id | IntegerOrString | true | Unique identifier for the target chat or username of the target supergroup or channel (in the format <code>@channelusername</code>) |

#### getChatMembersCount

    getChatMembersCount(chat_id: IntegerOrString)

<p>Use this method to get the number of members in a chat. Returns <em>Int</em> on success.</p>

| name | type | required | description |
|---|---|---|---|
| chat_id | IntegerOrString | true | Unique identifier for the target chat or username of the target supergroup or channel (in the format <code>@channelusername</code>) |

#### getChatMember

    getChatMember(chat_id: IntegerOrString, user_id: Integer)

<p>Use this method to get information about a member of a chat. Returns a <a href="#chatmember">ChatMember</a> object on success.</p>

| name | type | required | description |
|---|---|---|---|
| chat_id | IntegerOrString | true | Unique identifier for the target chat or username of the target supergroup or channel (in the format <code>@channelusername</code>) |
| user_id | Integer | true | Unique identifier of the target user |

#### setChatStickerSet

    setChatStickerSet(chat_id: IntegerOrString, sticker_set_name: String)

<p>Use this method to set a new group sticker set for a supergroup. The bot must be an administrator in the chat for this to work and must have the appropriate admin rights. Use the field <em>can_set_sticker_set</em> optionally returned in <a href="#getchat">getChat</a> requests to check if the bot can use this method. Returns <em>True</em> on success.</p>

| name | type | required | description |
|---|---|---|---|
| chat_id | IntegerOrString | true | Unique identifier for the target chat or username of the target supergroup (in the format <code>@supergroupusername</code>) |
| sticker_set_name | String | true | Name of the sticker set to be set as the group sticker set |

#### deleteChatStickerSet

    deleteChatStickerSet(chat_id: IntegerOrString)

<p>Use this method to delete a group sticker set from a supergroup. The bot must be an administrator in the chat for this to work and must have the appropriate admin rights. Use the field <em>can_set_sticker_set</em> optionally returned in <a href="#getchat">getChat</a> requests to check if the bot can use this method. Returns <em>True</em> on success.</p>

| name | type | required | description |
|---|---|---|---|
| chat_id | IntegerOrString | true | Unique identifier for the target chat or username of the target supergroup (in the format <code>@supergroupusername</code>) |

#### answerCallbackQuery

    answerCallbackQuery(callback_query_id: String, text: String, show_alert: Boolean, url: String, cache_time: Integer)

<p>Use this method to send answers to callback queries sent from <a href="/bots#inline-keyboards-and-on-the-fly-updating">inline keyboards</a>. The answer will be displayed to the user as a notification at the top of the chat screen or as an alert. On success, <em>True</em> is returned.</p><blockquote> 
 <p>Alternatively, the user can be redirected to the specified Game URL. For this option to work, you must first create a game for your bot via <a href="https://t.me/botfather">@Botfather</a> and accept the terms. Otherwise, you may use links like <code>t.me/your_bot?start=XXXX</code> that open your bot with a parameter.</p> 
</blockquote>

| name | type | required | description |
|---|---|---|---|
| callback_query_id | String | true | Unique identifier for the query to be answered |
| text | String | false | Text of the notification. If not specified, nothing will be shown to the user, 0-200 characters |
| show_alert | Boolean | false | If <em>true</em>, an alert will be shown by the client instead of a notification at the top of the chat screen. Defaults to <em>false</em>. |
| url | String | false | URL that will be opened by the user's client. If you have created a <a href="#game">Game</a> and accepted the conditions via <a href="https://t.me/botfather">@Botfather</a>, specify the URL that opens your game — note that this will only work if the query comes from a <a href="#inlinekeyboardbutton"><em>callback_game</em></a> button.<br><br>Otherwise, you may use links like <code>t.me/your_bot?start=XXXX</code> that open your bot with a parameter. |
| cache_time | Integer | false | The maximum amount of time in seconds that the result of the callback query may be cached client-side. Telegram apps will support caching starting in version 3.14. Defaults to 0. |

#### setMyCommands

    setMyCommands(commands: List<BotCommand>)

<p>Use this method to change the list of the bot's commands. Returns <em>True</em> on success.</p>

| name | type | required | description |
|---|---|---|---|
| commands | List<BotCommand> | true | A JSON-serialized list of bot commands to be set as the list of the bot's commands. At most 100 commands can be specified. |

#### getMyCommands

    getMyCommands()

<p>Use this method to get the current list of the bot's commands. Requires no parameters. Returns Array of <a href="#botcommand">BotCommand</a> on success.</p>



## Updating messages

### Methods
#### editMessageText

    editMessageText(chat_id: IntegerOrString, message_id: Integer, inline_message_id: String, text: String, parse_mode: ParseMode, disable_web_page_preview: Boolean, reply_markup: InlineKeyboardMarkup)

<p>Use this method to edit text and <a href="#games">game</a> messages. On success, if edited message is sent by the bot, the edited <a href="#message">Message</a> is returned, otherwise <em>True</em> is returned.</p>

| name | type | required | description |
|---|---|---|---|
| chat_id | IntegerOrString | false | Required if <em>inline_message_id</em> is not specified. Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>) |
| message_id | Integer | false | Required if <em>inline_message_id</em> is not specified. Identifier of the message to edit |
| inline_message_id | String | false | Required if <em>chat_id</em> and <em>message_id</em> are not specified. Identifier of the inline message |
| text | String | true | New text of the message, 1-4096 characters after entities parsing |
| parse_mode | ParseMode | false | Mode for parsing entities in the message text. See <a href="#formatting-options">formatting options</a> for more details. |
| disable_web_page_preview | Boolean | false | Disables link previews for links in this message |
| reply_markup | InlineKeyboardMarkup | false | A JSON-serialized object for an <a href="https://core.telegram.org/bots#inline-keyboards-and-on-the-fly-updating">inline keyboard</a>. |

#### editMessageCaption

    editMessageCaption(chat_id: IntegerOrString, message_id: Integer, inline_message_id: String, caption: String, parse_mode: ParseMode, reply_markup: InlineKeyboardMarkup)

<p>Use this method to edit captions of messages. On success, if edited message is sent by the bot, the edited <a href="#message">Message</a> is returned, otherwise <em>True</em> is returned.</p>

| name | type | required | description |
|---|---|---|---|
| chat_id | IntegerOrString | false | Required if <em>inline_message_id</em> is not specified. Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>) |
| message_id | Integer | false | Required if <em>inline_message_id</em> is not specified. Identifier of the message to edit |
| inline_message_id | String | false | Required if <em>chat_id</em> and <em>message_id</em> are not specified. Identifier of the inline message |
| caption | String | false | New caption of the message, 0-1024 characters after entities parsing |
| parse_mode | ParseMode | false | Mode for parsing entities in the message caption. See <a href="#formatting-options">formatting options</a> for more details. |
| reply_markup | InlineKeyboardMarkup | false | A JSON-serialized object for an <a href="https://core.telegram.org/bots#inline-keyboards-and-on-the-fly-updating">inline keyboard</a>. |

#### editMessageMedia

    editMessageMedia(chat_id: IntegerOrString, message_id: Integer, inline_message_id: String, media: InputMedia, reply_markup: InlineKeyboardMarkup)

<p>Use this method to edit animation, audio, document, photo, or video messages. If a message is a part of a message album, then it can be edited only to a photo or a video. Otherwise, message type can be changed arbitrarily. When inline message is edited, new file can't be uploaded. Use previously uploaded file via its file_id or specify a URL. On success, if the edited message was sent by the bot, the edited <a href="#message">Message</a> is returned, otherwise <em>True</em> is returned.</p>

| name | type | required | description |
|---|---|---|---|
| chat_id | IntegerOrString | false | Required if <em>inline_message_id</em> is not specified. Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>) |
| message_id | Integer | false | Required if <em>inline_message_id</em> is not specified. Identifier of the message to edit |
| inline_message_id | String | false | Required if <em>chat_id</em> and <em>message_id</em> are not specified. Identifier of the inline message |
| media | InputMedia | true | A JSON-serialized object for a new media content of the message |
| reply_markup | InlineKeyboardMarkup | false | A JSON-serialized object for a new <a href="https://core.telegram.org/bots#inline-keyboards-and-on-the-fly-updating">inline keyboard</a>. |

#### editMessageReplyMarkup

    editMessageReplyMarkup(chat_id: IntegerOrString, message_id: Integer, inline_message_id: String, reply_markup: InlineKeyboardMarkup)

<p>Use this method to edit only the reply markup of messages. On success, if edited message is sent by the bot, the edited <a href="#message">Message</a> is returned, otherwise <em>True</em> is returned.</p>

| name | type | required | description |
|---|---|---|---|
| chat_id | IntegerOrString | false | Required if <em>inline_message_id</em> is not specified. Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>) |
| message_id | Integer | false | Required if <em>inline_message_id</em> is not specified. Identifier of the message to edit |
| inline_message_id | String | false | Required if <em>chat_id</em> and <em>message_id</em> are not specified. Identifier of the inline message |
| reply_markup | InlineKeyboardMarkup | false | A JSON-serialized object for an <a href="https://core.telegram.org/bots#inline-keyboards-and-on-the-fly-updating">inline keyboard</a>. |

#### stopPoll

    stopPoll(chat_id: IntegerOrString, message_id: Integer, reply_markup: InlineKeyboardMarkup)

<p>Use this method to stop a poll which was sent by the bot. On success, the stopped <a href="#poll">Poll</a> with the final results is returned.</p>

| name | type | required | description |
|---|---|---|---|
| chat_id | IntegerOrString | true | Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>) |
| message_id | Integer | true | Identifier of the original message with the poll |
| reply_markup | InlineKeyboardMarkup | false | A JSON-serialized object for a new message <a href="https://core.telegram.org/bots#inline-keyboards-and-on-the-fly-updating">inline keyboard</a>. |

#### deleteMessage

    deleteMessage(chat_id: IntegerOrString, message_id: Integer)

<p>Use this method to delete a message, including service messages, with the following limitations:<br>- A message can only be deleted if it was sent less than 48 hours ago.<br>- A dice message in a private chat can only be deleted if it was sent more than 24 hours ago.<br>- Bots can delete outgoing messages in private chats, groups, and supergroups.<br>- Bots can delete incoming messages in private chats.<br>- Bots granted <em>can_post_messages</em> permissions can delete outgoing messages in channels.<br>- If the bot is an administrator of a group, it can delete any message there.<br>- If the bot has <em>can_delete_messages</em> permission in a supergroup or a channel, it can delete any message there.<br>Returns <em>True</em> on success.</p>

| name | type | required | description |
|---|---|---|---|
| chat_id | IntegerOrString | true | Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>) |
| message_id | Integer | true | Identifier of the message to delete |



## Stickers

### Data Types
#### Sticker

    Sticker(file_id: String, file_unique_id: String, width: Integer, height: Integer, is_animated: Boolean, thumb: PhotoSize, emoji: String, set_name: String, mask_position: MaskPosition, file_size: Integer)

<p>This object represents a sticker.</p>

| name | type | required | description |
|---|---|---|---|
| file_id | String | true | Identifier for this file, which can be used to download or reuse the file |
| file_unique_id | String | true | Unique identifier for this file, which is supposed to be the same over time and for different bots. Can't be used to download or reuse the file. |
| width | Integer | true | Sticker width |
| height | Integer | true | Sticker height |
| is_animated | Boolean | true | <em>True</em>, if the sticker is <a href="https://telegram.org/blog/animated-stickers">animated</a> |
| thumb | PhotoSize | false | <em>Optional</em>. Sticker thumbnail in the .WEBP or .JPG format |
| emoji | String | false | <em>Optional</em>. Emoji associated with the sticker |
| set_name | String | false | <em>Optional</em>. Name of the sticker set to which the sticker belongs |
| mask_position | MaskPosition | false | <em>Optional</em>. For mask stickers, the position where the mask should be placed |
| file_size | Integer | false | <em>Optional</em>. File size |

#### StickerSet

    StickerSet(name: String, title: String, is_animated: Boolean, contains_masks: Boolean, stickers: List<Sticker>, thumb: PhotoSize)

<p>This object represents a sticker set.</p>

| name | type | required | description |
|---|---|---|---|
| name | String | true | Sticker set name |
| title | String | true | Sticker set title |
| is_animated | Boolean | true | <em>True</em>, if the sticker set contains <a href="https://telegram.org/blog/animated-stickers">animated stickers</a> |
| contains_masks | Boolean | true | <em>True</em>, if the sticker set contains masks |
| stickers | List<Sticker> | true | List of all set stickers |
| thumb | PhotoSize | false | <em>Optional</em>. Sticker set thumbnail in the .WEBP or .TGS format |

#### MaskPosition

    MaskPosition(point: String, x_shift: Float, y_shift: Float, scale: Float)

<p>This object describes the position on faces where a mask should be placed by default.</p>

| name | type | required | description |
|---|---|---|---|
| point | String | true | The part of the face relative to which the mask should be placed. One of “forehead”, “eyes”, “mouth”, or “chin”. |
| x_shift | Float | true | Shift by X-axis measured in widths of the mask scaled to the face size, from left to right. For example, choosing -1.0 will place mask just to the left of the default mask position. |
| y_shift | Float | true | Shift by Y-axis measured in heights of the mask scaled to the face size, from top to bottom. For example, 1.0 will place the mask just below the default mask position. |
| scale | Float | true | Mask scaling coefficient. For example, 2.0 means double size. |


### Methods
#### sendSticker

    sendSticker(chat_id: IntegerOrString, sticker: InputFileOrString, disable_notification: Boolean, reply_to_message_id: Integer, reply_markup: KeyboardOption)

<p>Use this method to send static .WEBP or <a href="https://telegram.org/blog/animated-stickers">animated</a> .TGS stickers. On success, the sent <a href="#message">Message</a> is returned.</p>

| name | type | required | description |
|---|---|---|---|
| chat_id | IntegerOrString | true | Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>) |
| sticker | InputFileOrString | true | Sticker to send. Pass a file_id as String to send a file that exists on the Telegram servers (recommended), pass an HTTP URL as a String for Telegram to get a .WEBP file from the Internet, or upload a new one using multipart/form-data. <a href="#sending-files">More info on Sending Files »</a> |
| disable_notification | Boolean | false | Sends the message <a href="https://telegram.org/blog/channels-2-0#silent-messages">silently</a>. Users will receive a notification with no sound. |
| reply_to_message_id | Integer | false | If the message is a reply, ID of the original message |
| reply_markup | KeyboardOption | false | Additional interface options. A JSON-serialized object for an <a href="https://core.telegram.org/bots#inline-keyboards-and-on-the-fly-updating">inline keyboard</a>, <a href="https://core.telegram.org/bots#keyboards">custom reply keyboard</a>, instructions to remove reply keyboard or to force a reply from the user. |

#### getStickerSet

    getStickerSet(name: String)

<p>Use this method to get a sticker set. On success, a <a href="#stickerset">StickerSet</a> object is returned.</p>

| name | type | required | description |
|---|---|---|---|
| name | String | true | Name of the sticker set |

#### uploadStickerFile

    uploadStickerFile(user_id: Integer, png_sticker: InputFile)

<p>Use this method to upload a .PNG file with a sticker for later use in <em>createNewStickerSet</em> and <em>addStickerToSet</em> methods (can be used multiple times). Returns the uploaded <a href="#file">File</a> on success.</p>

| name | type | required | description |
|---|---|---|---|
| user_id | Integer | true | User identifier of sticker file owner |
| png_sticker | InputFile | true | <strong>PNG</strong> image with the sticker, must be up to 512 kilobytes in size, dimensions must not exceed 512px, and either width or height must be exactly 512px. <a href="#sending-files">More info on Sending Files »</a> |

#### createNewStickerSet

    createNewStickerSet(user_id: Integer, name: String, title: String, png_sticker: InputFileOrString, tgs_sticker: InputFile, emojis: String, contains_masks: Boolean, mask_position: MaskPosition)

<p>Use this method to create a new sticker set owned by a user. The bot will be able to edit the sticker set thus created. You <strong>must</strong> use exactly one of the fields <em>png_sticker</em> or <em>tgs_sticker</em>. Returns <em>True</em> on success.</p>

| name | type | required | description |
|---|---|---|---|
| user_id | Integer | true | User identifier of created sticker set owner |
| name | String | true | Short name of sticker set, to be used in <code>t.me/addstickers/</code> URLs (e.g., <em>animals</em>). Can contain only english letters, digits and underscores. Must begin with a letter, can't contain consecutive underscores and must end in <em>“_by_&lt;bot username&gt;”</em>. <em>&lt;bot_username&gt;</em> is case insensitive. 1-64 characters. |
| title | String | true | Sticker set title, 1-64 characters |
| png_sticker | InputFileOrString | false | <strong>PNG</strong> image with the sticker, must be up to 512 kilobytes in size, dimensions must not exceed 512px, and either width or height must be exactly 512px. Pass a <em>file_id</em> as a String to send a file that already exists on the Telegram servers, pass an HTTP URL as a String for Telegram to get a file from the Internet, or upload a new one using multipart/form-data. <a href="#sending-files">More info on Sending Files »</a> |
| tgs_sticker | InputFile | false | <strong>TGS</strong> animation with the sticker, uploaded using multipart/form-data. See <a href="https://core.telegram.org/animated_stickers#technical-requirements"></a><a href="https://core.telegram.org/animated_stickers#technical-requirements">https://core.telegram.org/animated_stickers#technical-requirements</a> for technical requirements |
| emojis | String | true | One or more emoji corresponding to the sticker |
| contains_masks | Boolean | false | Pass <em>True</em>, if a set of mask stickers should be created |
| mask_position | MaskPosition | false | A JSON-serialized object for position where the mask should be placed on faces |

#### addStickerToSet

    addStickerToSet(user_id: Integer, name: String, png_sticker: InputFileOrString, tgs_sticker: InputFile, emojis: String, mask_position: MaskPosition)

<p>Use this method to add a new sticker to a set created by the bot. You <strong>must</strong> use exactly one of the fields <em>png_sticker</em> or <em>tgs_sticker</em>. Animated stickers can be added to animated sticker sets and only to them. Animated sticker sets can have up to 50 stickers. Static sticker sets can have up to 120 stickers. Returns <em>True</em> on success.</p>

| name | type | required | description |
|---|---|---|---|
| user_id | Integer | true | User identifier of sticker set owner |
| name | String | true | Sticker set name |
| png_sticker | InputFileOrString | true | <strong>PNG</strong> image with the sticker, must be up to 512 kilobytes in size, dimensions must not exceed 512px, and either width or height must be exactly 512px. Pass a <em>file_id</em> as a String to send a file that already exists on the Telegram servers, pass an HTTP URL as a String for Telegram to get a file from the Internet, or upload a new one using multipart/form-data. <a href="#sending-files">More info on Sending Files »</a> |
| tgs_sticker | InputFile | false | <strong>TGS</strong> animation with the sticker, uploaded using multipart/form-data. See <a href="https://core.telegram.org/animated_stickers#technical-requirements"></a><a href="https://core.telegram.org/animated_stickers#technical-requirements">https://core.telegram.org/animated_stickers#technical-requirements</a> for technical requirements |
| emojis | String | true | One or more emoji corresponding to the sticker |
| mask_position | MaskPosition | false | A JSON-serialized object for position where the mask should be placed on faces |

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

#### setStickerSetThumb

    setStickerSetThumb(name: String, user_id: Integer, thumb: InputFileOrString)

<p>Use this method to set the thumbnail of a sticker set. Animated thumbnails can be set for animated sticker sets only. Returns <em>True</em> on success.</p>

| name | type | required | description |
|---|---|---|---|
| name | String | true | Sticker set name |
| user_id | Integer | true | User identifier of the sticker set owner |
| thumb | InputFileOrString | false | A <strong>PNG</strong> image with the thumbnail, must be up to 128 kilobytes in size and have width and height exactly 100px, or a <strong>TGS</strong> animation with the thumbnail up to 32 kilobytes in size; see <a href="https://core.telegram.org/animated_stickers#technical-requirements"></a><a href="https://core.telegram.org/animated_stickers#technical-requirements">https://core.telegram.org/animated_stickers#technical-requirements</a> for animated sticker technical requirements. Pass a <em>file_id</em> as a String to send a file that already exists on the Telegram servers, pass an HTTP URL as a String for Telegram to get a file from the Internet, or upload a new one using multipart/form-data. <a href="#sending-files">More info on Sending Files »</a>. Animated sticker set thumbnail can't be uploaded via HTTP URL. |



## Inline mode

### Data Types
#### InlineQuery

    InlineQuery(id: String, from: User, location: Location, query: String, offset: String)

<p>This object represents an incoming inline query. When the user sends an empty query, your bot could return some default or trending results.</p>

| name | type | required | description |
|---|---|---|---|
| id | String | true | Unique identifier for this query |
| from | User | true | Sender |
| location | Location | false | <em>Optional</em>. Sender location, only for bots that request user location |
| query | String | true | Text of the query (up to 256 characters) |
| offset | String | true | Offset of the results to be returned, can be controlled by the bot |

#### InlineQueryResultArticle

    InlineQueryResultArticle(type: String, id: String, title: String, input_message_content: InputMessageContent, reply_markup: InlineKeyboardMarkup, url: String, hide_url: Boolean, description: String, thumb_url: String, thumb_width: Integer, thumb_height: Integer)

<p>Represents a link to an article or web page.</p>

| name | type | required | description |
|---|---|---|---|
| type | String | true | Type of the result, must be <em>article</em> |
| id | String | true | Unique identifier for this result, 1-64 Bytes |
| title | String | true | Title of the result |
| input_message_content | InputMessageContent | true | Content of the message to be sent |
| reply_markup | InlineKeyboardMarkup | false | <em>Optional</em>. <a href="/bots#inline-keyboards-and-on-the-fly-updating">Inline keyboard</a> attached to the message |
| url | String | false | <em>Optional</em>. URL of the result |
| hide_url | Boolean | false | <em>Optional</em>. Pass <em>True</em>, if you don't want the URL to be shown in the message |
| description | String | false | <em>Optional</em>. Short description of the result |
| thumb_url | String | false | <em>Optional</em>. Url of the thumbnail for the result |
| thumb_width | Integer | false | <em>Optional</em>. Thumbnail width |
| thumb_height | Integer | false | <em>Optional</em>. Thumbnail height |

#### InlineQueryResultPhoto

    InlineQueryResultPhoto(type: String, id: String, photo_url: String, thumb_url: String, photo_width: Integer, photo_height: Integer, title: String, description: String, caption: String, parse_mode: ParseMode, reply_markup: InlineKeyboardMarkup, input_message_content: InputMessageContent)

<p>Represents a link to a photo. By default, this photo will be sent by the user with optional caption. Alternatively, you can use <em>input_message_content</em> to send a message with the specified content instead of the photo.</p>

| name | type | required | description |
|---|---|---|---|
| type | String | true | Type of the result, must be <em>photo</em> |
| id | String | true | Unique identifier for this result, 1-64 bytes |
| photo_url | String | true | A valid URL of the photo. Photo must be in <strong>jpeg</strong> format. Photo size must not exceed 5MB |
| thumb_url | String | true | URL of the thumbnail for the photo |
| photo_width | Integer | false | <em>Optional</em>. Width of the photo |
| photo_height | Integer | false | <em>Optional</em>. Height of the photo |
| title | String | false | <em>Optional</em>. Title for the result |
| description | String | false | <em>Optional</em>. Short description of the result |
| caption | String | false | <em>Optional</em>. Caption of the photo to be sent, 0-1024 characters after entities parsing |
| parse_mode | ParseMode | false | <em>Optional</em>. Mode for parsing entities in the photo caption. See <a href="#formatting-options">formatting options</a> for more details. |
| reply_markup | InlineKeyboardMarkup | false | <em>Optional</em>. <a href="/bots#inline-keyboards-and-on-the-fly-updating">Inline keyboard</a> attached to the message |
| input_message_content | InputMessageContent | false | <em>Optional</em>. Content of the message to be sent instead of the photo |

#### InlineQueryResultGif

    InlineQueryResultGif(type: String, id: String, gif_url: String, gif_width: Integer, gif_height: Integer, gif_duration: Integer, thumb_url: String, title: String, caption: String, parse_mode: ParseMode, reply_markup: InlineKeyboardMarkup, input_message_content: InputMessageContent)

<p>Represents a link to an animated GIF file. By default, this animated GIF file will be sent by the user with optional caption. Alternatively, you can use <em>input_message_content</em> to send a message with the specified content instead of the animation.</p>

| name | type | required | description |
|---|---|---|---|
| type | String | true | Type of the result, must be <em>gif</em> |
| id | String | true | Unique identifier for this result, 1-64 bytes |
| gif_url | String | true | A valid URL for the GIF file. File size must not exceed 1MB |
| gif_width | Integer | false | <em>Optional</em>. Width of the GIF |
| gif_height | Integer | false | <em>Optional</em>. Height of the GIF |
| gif_duration | Integer | false | <em>Optional</em>. Duration of the GIF |
| thumb_url | String | true | URL of the static thumbnail for the result (jpeg or gif) |
| title | String | false | <em>Optional</em>. Title for the result |
| caption | String | false | <em>Optional</em>. Caption of the GIF file to be sent, 0-1024 characters after entities parsing |
| parse_mode | ParseMode | false | <em>Optional</em>. Mode for parsing entities in the caption. See <a href="#formatting-options">formatting options</a> for more details. |
| reply_markup | InlineKeyboardMarkup | false | <em>Optional</em>. <a href="/bots#inline-keyboards-and-on-the-fly-updating">Inline keyboard</a> attached to the message |
| input_message_content | InputMessageContent | false | <em>Optional</em>. Content of the message to be sent instead of the GIF animation |

#### InlineQueryResultMpeg4Gif

    InlineQueryResultMpeg4Gif(type: String, id: String, mpeg4_url: String, mpeg4_width: Integer, mpeg4_height: Integer, mpeg4_duration: Integer, thumb_url: String, title: String, caption: String, parse_mode: ParseMode, reply_markup: InlineKeyboardMarkup, input_message_content: InputMessageContent)

<p>Represents a link to a video animation (H.264/MPEG-4 AVC video without sound). By default, this animated MPEG-4 file will be sent by the user with optional caption. Alternatively, you can use <em>input_message_content</em> to send a message with the specified content instead of the animation.</p>

| name | type | required | description |
|---|---|---|---|
| type | String | true | Type of the result, must be <em>mpeg4_gif</em> |
| id | String | true | Unique identifier for this result, 1-64 bytes |
| mpeg4_url | String | true | A valid URL for the MP4 file. File size must not exceed 1MB |
| mpeg4_width | Integer | false | <em>Optional</em>. Video width |
| mpeg4_height | Integer | false | <em>Optional</em>. Video height |
| mpeg4_duration | Integer | false | <em>Optional</em>. Video duration |
| thumb_url | String | true | URL of the static thumbnail (jpeg or gif) for the result |
| title | String | false | <em>Optional</em>. Title for the result |
| caption | String | false | <em>Optional</em>. Caption of the MPEG-4 file to be sent, 0-1024 characters after entities parsing |
| parse_mode | ParseMode | false | <em>Optional</em>. Mode for parsing entities in the caption. See <a href="#formatting-options">formatting options</a> for more details. |
| reply_markup | InlineKeyboardMarkup | false | <em>Optional</em>. <a href="/bots#inline-keyboards-and-on-the-fly-updating">Inline keyboard</a> attached to the message |
| input_message_content | InputMessageContent | false | <em>Optional</em>. Content of the message to be sent instead of the video animation |

#### InlineQueryResultVideo

    InlineQueryResultVideo(type: String, id: String, video_url: String, mime_type: String, thumb_url: String, title: String, caption: String, parse_mode: ParseMode, video_width: Integer, video_height: Integer, video_duration: Integer, description: String, reply_markup: InlineKeyboardMarkup, input_message_content: InputMessageContent)

<p>Represents a link to a page containing an embedded video player or a video file. By default, this video file will be sent by the user with an optional caption. Alternatively, you can use <em>input_message_content</em> to send a message with the specified content instead of the video.</p><blockquote> 
 <p>If an InlineQueryResultVideo message contains an embedded video (e.g., YouTube), you <strong>must</strong> replace its content using <em>input_message_content</em>.</p> 
</blockquote>

| name | type | required | description |
|---|---|---|---|
| type | String | true | Type of the result, must be <em>video</em> |
| id | String | true | Unique identifier for this result, 1-64 bytes |
| video_url | String | true | A valid URL for the embedded video player or video file |
| mime_type | String | true | Mime type of the content of video url, “text/html” or “video/mp4” |
| thumb_url | String | true | URL of the thumbnail (jpeg only) for the video |
| title | String | true | Title for the result |
| caption | String | false | <em>Optional</em>. Caption of the video to be sent, 0-1024 characters after entities parsing |
| parse_mode | ParseMode | false | <em>Optional</em>. Mode for parsing entities in the video caption. See <a href="#formatting-options">formatting options</a> for more details. |
| video_width | Integer | false | <em>Optional</em>. Video width |
| video_height | Integer | false | <em>Optional</em>. Video height |
| video_duration | Integer | false | <em>Optional</em>. Video duration in seconds |
| description | String | false | <em>Optional</em>. Short description of the result |
| reply_markup | InlineKeyboardMarkup | false | <em>Optional</em>. <a href="/bots#inline-keyboards-and-on-the-fly-updating">Inline keyboard</a> attached to the message |
| input_message_content | InputMessageContent | false | <em>Optional</em>. Content of the message to be sent instead of the video. This field is <strong>required</strong> if InlineQueryResultVideo is used to send an HTML-page as a result (e.g., a YouTube video). |

#### InlineQueryResultAudio

    InlineQueryResultAudio(type: String, id: String, audio_url: String, title: String, caption: String, parse_mode: ParseMode, performer: String, audio_duration: Integer, reply_markup: InlineKeyboardMarkup, input_message_content: InputMessageContent)

<p>Represents a link to an MP3 audio file. By default, this audio file will be sent by the user. Alternatively, you can use <em>input_message_content</em> to send a message with the specified content instead of the audio.</p><p><strong>Note:</strong> This will only work in Telegram versions released after 9 April, 2016. Older clients will ignore them.</p>

| name | type | required | description |
|---|---|---|---|
| type | String | true | Type of the result, must be <em>audio</em> |
| id | String | true | Unique identifier for this result, 1-64 bytes |
| audio_url | String | true | A valid URL for the audio file |
| title | String | true | Title |
| caption | String | false | <em>Optional</em>. Caption, 0-1024 characters after entities parsing |
| parse_mode | ParseMode | false | <em>Optional</em>. Mode for parsing entities in the audio caption. See <a href="#formatting-options">formatting options</a> for more details. |
| performer | String | false | <em>Optional</em>. Performer |
| audio_duration | Integer | false | <em>Optional</em>. Audio duration in seconds |
| reply_markup | InlineKeyboardMarkup | false | <em>Optional</em>. <a href="/bots#inline-keyboards-and-on-the-fly-updating">Inline keyboard</a> attached to the message |
| input_message_content | InputMessageContent | false | <em>Optional</em>. Content of the message to be sent instead of the audio |

#### InlineQueryResultVoice

    InlineQueryResultVoice(type: String, id: String, voice_url: String, title: String, caption: String, parse_mode: ParseMode, voice_duration: Integer, reply_markup: InlineKeyboardMarkup, input_message_content: InputMessageContent)

<p>Represents a link to a voice recording in an .OGG container encoded with OPUS. By default, this voice recording will be sent by the user. Alternatively, you can use <em>input_message_content</em> to send a message with the specified content instead of the the voice message.</p><p><strong>Note:</strong> This will only work in Telegram versions released after 9 April, 2016. Older clients will ignore them.</p>

| name | type | required | description |
|---|---|---|---|
| type | String | true | Type of the result, must be <em>voice</em> |
| id | String | true | Unique identifier for this result, 1-64 bytes |
| voice_url | String | true | A valid URL for the voice recording |
| title | String | true | Recording title |
| caption | String | false | <em>Optional</em>. Caption, 0-1024 characters after entities parsing |
| parse_mode | ParseMode | false | <em>Optional</em>. Mode for parsing entities in the voice message caption. See <a href="#formatting-options">formatting options</a> for more details. |
| voice_duration | Integer | false | <em>Optional</em>. Recording duration in seconds |
| reply_markup | InlineKeyboardMarkup | false | <em>Optional</em>. <a href="/bots#inline-keyboards-and-on-the-fly-updating">Inline keyboard</a> attached to the message |
| input_message_content | InputMessageContent | false | <em>Optional</em>. Content of the message to be sent instead of the voice recording |

#### InlineQueryResultDocument

    InlineQueryResultDocument(type: String, id: String, title: String, caption: String, parse_mode: ParseMode, document_url: String, mime_type: String, description: String, reply_markup: InlineKeyboardMarkup, input_message_content: InputMessageContent, thumb_url: String, thumb_width: Integer, thumb_height: Integer)

<p>Represents a link to a file. By default, this file will be sent by the user with an optional caption. Alternatively, you can use <em>input_message_content</em> to send a message with the specified content instead of the file. Currently, only <strong>.PDF</strong> and <strong>.ZIP</strong> files can be sent using this method.</p><p><strong>Note:</strong> This will only work in Telegram versions released after 9 April, 2016. Older clients will ignore them.</p>

| name | type | required | description |
|---|---|---|---|
| type | String | true | Type of the result, must be <em>document</em> |
| id | String | true | Unique identifier for this result, 1-64 bytes |
| title | String | true | Title for the result |
| caption | String | false | <em>Optional</em>. Caption of the document to be sent, 0-1024 characters after entities parsing |
| parse_mode | ParseMode | false | <em>Optional</em>. Mode for parsing entities in the document caption. See <a href="#formatting-options">formatting options</a> for more details. |
| document_url | String | true | A valid URL for the file |
| mime_type | String | true | Mime type of the content of the file, either “application/pdf” or “application/zip” |
| description | String | false | <em>Optional</em>. Short description of the result |
| reply_markup | InlineKeyboardMarkup | false | <em>Optional</em>. Inline keyboard attached to the message |
| input_message_content | InputMessageContent | false | <em>Optional</em>. Content of the message to be sent instead of the file |
| thumb_url | String | false | <em>Optional</em>. URL of the thumbnail (jpeg only) for the file |
| thumb_width | Integer | false | <em>Optional</em>. Thumbnail width |
| thumb_height | Integer | false | <em>Optional</em>. Thumbnail height |

#### InlineQueryResultLocation

    InlineQueryResultLocation(type: String, id: String, latitude: Float, longitude: Float, title: String, live_period: Integer, reply_markup: InlineKeyboardMarkup, input_message_content: InputMessageContent, thumb_url: String, thumb_width: Integer, thumb_height: Integer)

<p>Represents a location on a map. By default, the location will be sent by the user. Alternatively, you can use <em>input_message_content</em> to send a message with the specified content instead of the location.</p><p><strong>Note:</strong> This will only work in Telegram versions released after 9 April, 2016. Older clients will ignore them.</p>

| name | type | required | description |
|---|---|---|---|
| type | String | true | Type of the result, must be <em>location</em> |
| id | String | true | Unique identifier for this result, 1-64 Bytes |
| latitude | Float | true | Location latitude in degrees |
| longitude | Float | true | Location longitude in degrees |
| title | String | true | Location title |
| live_period | Integer | false | <em>Optional</em>. Period in seconds for which the location can be updated, should be between 60 and 86400. |
| reply_markup | InlineKeyboardMarkup | false | <em>Optional</em>. <a href="/bots#inline-keyboards-and-on-the-fly-updating">Inline keyboard</a> attached to the message |
| input_message_content | InputMessageContent | false | <em>Optional</em>. Content of the message to be sent instead of the location |
| thumb_url | String | false | <em>Optional</em>. Url of the thumbnail for the result |
| thumb_width | Integer | false | <em>Optional</em>. Thumbnail width |
| thumb_height | Integer | false | <em>Optional</em>. Thumbnail height |

#### InlineQueryResultVenue

    InlineQueryResultVenue(type: String, id: String, latitude: Float, longitude: Float, title: String, address: String, foursquare_id: String, foursquare_type: String, reply_markup: InlineKeyboardMarkup, input_message_content: InputMessageContent, thumb_url: String, thumb_width: Integer, thumb_height: Integer)

<p>Represents a venue. By default, the venue will be sent by the user. Alternatively, you can use <em>input_message_content</em> to send a message with the specified content instead of the venue.</p><p><strong>Note:</strong> This will only work in Telegram versions released after 9 April, 2016. Older clients will ignore them.</p>

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
| reply_markup | InlineKeyboardMarkup | false | <em>Optional</em>. <a href="/bots#inline-keyboards-and-on-the-fly-updating">Inline keyboard</a> attached to the message |
| input_message_content | InputMessageContent | false | <em>Optional</em>. Content of the message to be sent instead of the venue |
| thumb_url | String | false | <em>Optional</em>. Url of the thumbnail for the result |
| thumb_width | Integer | false | <em>Optional</em>. Thumbnail width |
| thumb_height | Integer | false | <em>Optional</em>. Thumbnail height |

#### InlineQueryResultContact

    InlineQueryResultContact(type: String, id: String, phone_number: String, first_name: String, last_name: String, vcard: String, reply_markup: InlineKeyboardMarkup, input_message_content: InputMessageContent, thumb_url: String, thumb_width: Integer, thumb_height: Integer)

<p>Represents a contact with a phone number. By default, this contact will be sent by the user. Alternatively, you can use <em>input_message_content</em> to send a message with the specified content instead of the contact.</p><p><strong>Note:</strong> This will only work in Telegram versions released after 9 April, 2016. Older clients will ignore them.</p>

| name | type | required | description |
|---|---|---|---|
| type | String | true | Type of the result, must be <em>contact</em> |
| id | String | true | Unique identifier for this result, 1-64 Bytes |
| phone_number | String | true | Contact's phone number |
| first_name | String | true | Contact's first name |
| last_name | String | false | <em>Optional</em>. Contact's last name |
| vcard | String | false | <em>Optional</em>. Additional data about the contact in the form of a <a href="https://en.wikipedia.org/wiki/VCard">vCard</a>, 0-2048 bytes |
| reply_markup | InlineKeyboardMarkup | false | <em>Optional</em>. <a href="/bots#inline-keyboards-and-on-the-fly-updating">Inline keyboard</a> attached to the message |
| input_message_content | InputMessageContent | false | <em>Optional</em>. Content of the message to be sent instead of the contact |
| thumb_url | String | false | <em>Optional</em>. Url of the thumbnail for the result |
| thumb_width | Integer | false | <em>Optional</em>. Thumbnail width |
| thumb_height | Integer | false | <em>Optional</em>. Thumbnail height |

#### InlineQueryResultGame

    InlineQueryResultGame(type: String, id: String, game_short_name: String, reply_markup: InlineKeyboardMarkup)

<p>Represents a <a href="#games">Game</a>.</p><p><strong>Note:</strong> This will only work in Telegram versions released after October 1, 2016. Older clients will not display any inline results if a game result is among them.</p>

| name | type | required | description |
|---|---|---|---|
| type | String | true | Type of the result, must be <em>game</em> |
| id | String | true | Unique identifier for this result, 1-64 bytes |
| game_short_name | String | true | Short name of the game |
| reply_markup | InlineKeyboardMarkup | false | <em>Optional</em>. <a href="/bots#inline-keyboards-and-on-the-fly-updating">Inline keyboard</a> attached to the message |

#### InlineQueryResultCachedPhoto

    InlineQueryResultCachedPhoto(type: String, id: String, photo_file_id: String, title: String, description: String, caption: String, parse_mode: ParseMode, reply_markup: InlineKeyboardMarkup, input_message_content: InputMessageContent)

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
| reply_markup | InlineKeyboardMarkup | false | <em>Optional</em>. <a href="/bots#inline-keyboards-and-on-the-fly-updating">Inline keyboard</a> attached to the message |
| input_message_content | InputMessageContent | false | <em>Optional</em>. Content of the message to be sent instead of the photo |

#### InlineQueryResultCachedGif

    InlineQueryResultCachedGif(type: String, id: String, gif_file_id: String, title: String, caption: String, parse_mode: ParseMode, reply_markup: InlineKeyboardMarkup, input_message_content: InputMessageContent)

<p>Represents a link to an animated GIF file stored on the Telegram servers. By default, this animated GIF file will be sent by the user with an optional caption. Alternatively, you can use <em>input_message_content</em> to send a message with specified content instead of the animation.</p>

| name | type | required | description |
|---|---|---|---|
| type | String | true | Type of the result, must be <em>gif</em> |
| id | String | true | Unique identifier for this result, 1-64 bytes |
| gif_file_id | String | true | A valid file identifier for the GIF file |
| title | String | false | <em>Optional</em>. Title for the result |
| caption | String | false | <em>Optional</em>. Caption of the GIF file to be sent, 0-1024 characters after entities parsing |
| parse_mode | ParseMode | false | <em>Optional</em>. Mode for parsing entities in the caption. See <a href="#formatting-options">formatting options</a> for more details. |
| reply_markup | InlineKeyboardMarkup | false | <em>Optional</em>. <a href="/bots#inline-keyboards-and-on-the-fly-updating">Inline keyboard</a> attached to the message |
| input_message_content | InputMessageContent | false | <em>Optional</em>. Content of the message to be sent instead of the GIF animation |

#### InlineQueryResultCachedMpeg4Gif

    InlineQueryResultCachedMpeg4Gif(type: String, id: String, mpeg4_file_id: String, title: String, caption: String, parse_mode: ParseMode, reply_markup: InlineKeyboardMarkup, input_message_content: InputMessageContent)

<p>Represents a link to a video animation (H.264/MPEG-4 AVC video without sound) stored on the Telegram servers. By default, this animated MPEG-4 file will be sent by the user with an optional caption. Alternatively, you can use <em>input_message_content</em> to send a message with the specified content instead of the animation.</p>

| name | type | required | description |
|---|---|---|---|
| type | String | true | Type of the result, must be <em>mpeg4_gif</em> |
| id | String | true | Unique identifier for this result, 1-64 bytes |
| mpeg4_file_id | String | true | A valid file identifier for the MP4 file |
| title | String | false | <em>Optional</em>. Title for the result |
| caption | String | false | <em>Optional</em>. Caption of the MPEG-4 file to be sent, 0-1024 characters after entities parsing |
| parse_mode | ParseMode | false | <em>Optional</em>. Mode for parsing entities in the caption. See <a href="#formatting-options">formatting options</a> for more details. |
| reply_markup | InlineKeyboardMarkup | false | <em>Optional</em>. <a href="/bots#inline-keyboards-and-on-the-fly-updating">Inline keyboard</a> attached to the message |
| input_message_content | InputMessageContent | false | <em>Optional</em>. Content of the message to be sent instead of the video animation |

#### InlineQueryResultCachedSticker

    InlineQueryResultCachedSticker(type: String, id: String, sticker_file_id: String, reply_markup: InlineKeyboardMarkup, input_message_content: InputMessageContent)

<p>Represents a link to a sticker stored on the Telegram servers. By default, this sticker will be sent by the user. Alternatively, you can use <em>input_message_content</em> to send a message with the specified content instead of the sticker.</p><p><strong>Note:</strong> This will only work in Telegram versions released after 9 April, 2016 for static stickers and after 06 July, 2019 for <a href="https://telegram.org/blog/animated-stickers">animated stickers</a>. Older clients will ignore them.</p>

| name | type | required | description |
|---|---|---|---|
| type | String | true | Type of the result, must be <em>sticker</em> |
| id | String | true | Unique identifier for this result, 1-64 bytes |
| sticker_file_id | String | true | A valid file identifier of the sticker |
| reply_markup | InlineKeyboardMarkup | false | <em>Optional</em>. <a href="/bots#inline-keyboards-and-on-the-fly-updating">Inline keyboard</a> attached to the message |
| input_message_content | InputMessageContent | false | <em>Optional</em>. Content of the message to be sent instead of the sticker |

#### InlineQueryResultCachedDocument

    InlineQueryResultCachedDocument(type: String, id: String, title: String, document_file_id: String, description: String, caption: String, parse_mode: ParseMode, reply_markup: InlineKeyboardMarkup, input_message_content: InputMessageContent)

<p>Represents a link to a file stored on the Telegram servers. By default, this file will be sent by the user with an optional caption. Alternatively, you can use <em>input_message_content</em> to send a message with the specified content instead of the file.</p><p><strong>Note:</strong> This will only work in Telegram versions released after 9 April, 2016. Older clients will ignore them.</p>

| name | type | required | description |
|---|---|---|---|
| type | String | true | Type of the result, must be <em>document</em> |
| id | String | true | Unique identifier for this result, 1-64 bytes |
| title | String | true | Title for the result |
| document_file_id | String | true | A valid file identifier for the file |
| description | String | false | <em>Optional</em>. Short description of the result |
| caption | String | false | <em>Optional</em>. Caption of the document to be sent, 0-1024 characters after entities parsing |
| parse_mode | ParseMode | false | <em>Optional</em>. Mode for parsing entities in the document caption. See <a href="#formatting-options">formatting options</a> for more details. |
| reply_markup | InlineKeyboardMarkup | false | <em>Optional</em>. <a href="/bots#inline-keyboards-and-on-the-fly-updating">Inline keyboard</a> attached to the message |
| input_message_content | InputMessageContent | false | <em>Optional</em>. Content of the message to be sent instead of the file |

#### InlineQueryResultCachedVideo

    InlineQueryResultCachedVideo(type: String, id: String, video_file_id: String, title: String, description: String, caption: String, parse_mode: ParseMode, reply_markup: InlineKeyboardMarkup, input_message_content: InputMessageContent)

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
| reply_markup | InlineKeyboardMarkup | false | <em>Optional</em>. <a href="/bots#inline-keyboards-and-on-the-fly-updating">Inline keyboard</a> attached to the message |
| input_message_content | InputMessageContent | false | <em>Optional</em>. Content of the message to be sent instead of the video |

#### InlineQueryResultCachedVoice

    InlineQueryResultCachedVoice(type: String, id: String, voice_file_id: String, title: String, caption: String, parse_mode: ParseMode, reply_markup: InlineKeyboardMarkup, input_message_content: InputMessageContent)

<p>Represents a link to a voice message stored on the Telegram servers. By default, this voice message will be sent by the user. Alternatively, you can use <em>input_message_content</em> to send a message with the specified content instead of the voice message.</p><p><strong>Note:</strong> This will only work in Telegram versions released after 9 April, 2016. Older clients will ignore them.</p>

| name | type | required | description |
|---|---|---|---|
| type | String | true | Type of the result, must be <em>voice</em> |
| id | String | true | Unique identifier for this result, 1-64 bytes |
| voice_file_id | String | true | A valid file identifier for the voice message |
| title | String | true | Voice message title |
| caption | String | false | <em>Optional</em>. Caption, 0-1024 characters after entities parsing |
| parse_mode | ParseMode | false | <em>Optional</em>. Mode for parsing entities in the voice message caption. See <a href="#formatting-options">formatting options</a> for more details. |
| reply_markup | InlineKeyboardMarkup | false | <em>Optional</em>. <a href="/bots#inline-keyboards-and-on-the-fly-updating">Inline keyboard</a> attached to the message |
| input_message_content | InputMessageContent | false | <em>Optional</em>. Content of the message to be sent instead of the voice message |

#### InlineQueryResultCachedAudio

    InlineQueryResultCachedAudio(type: String, id: String, audio_file_id: String, caption: String, parse_mode: ParseMode, reply_markup: InlineKeyboardMarkup, input_message_content: InputMessageContent)

<p>Represents a link to an MP3 audio file stored on the Telegram servers. By default, this audio file will be sent by the user. Alternatively, you can use <em>input_message_content</em> to send a message with the specified content instead of the audio.</p><p><strong>Note:</strong> This will only work in Telegram versions released after 9 April, 2016. Older clients will ignore them.</p>

| name | type | required | description |
|---|---|---|---|
| type | String | true | Type of the result, must be <em>audio</em> |
| id | String | true | Unique identifier for this result, 1-64 bytes |
| audio_file_id | String | true | A valid file identifier for the audio file |
| caption | String | false | <em>Optional</em>. Caption, 0-1024 characters after entities parsing |
| parse_mode | ParseMode | false | <em>Optional</em>. Mode for parsing entities in the audio caption. See <a href="#formatting-options">formatting options</a> for more details. |
| reply_markup | InlineKeyboardMarkup | false | <em>Optional</em>. <a href="/bots#inline-keyboards-and-on-the-fly-updating">Inline keyboard</a> attached to the message |
| input_message_content | InputMessageContent | false | <em>Optional</em>. Content of the message to be sent instead of the audio |

#### InputTextMessageContent

    InputTextMessageContent(message_text: String, parse_mode: ParseMode, disable_web_page_preview: Boolean)

<p>Represents the <a href="#inputmessagecontent">content</a> of a text message to be sent as the result of an inline query.</p>

| name | type | required | description |
|---|---|---|---|
| message_text | String | true | Text of the message to be sent, 1-4096 characters |
| parse_mode | ParseMode | false | <em>Optional</em>. Mode for parsing entities in the message text. See <a href="#formatting-options">formatting options</a> for more details. |
| disable_web_page_preview | Boolean | false | <em>Optional</em>. Disables link previews for links in the sent message |

#### InputLocationMessageContent

    InputLocationMessageContent(latitude: Float, longitude: Float, live_period: Integer)

<p>Represents the <a href="#inputmessagecontent">content</a> of a location message to be sent as the result of an inline query.</p>

| name | type | required | description |
|---|---|---|---|
| latitude | Float | true | Latitude of the location in degrees |
| longitude | Float | true | Longitude of the location in degrees |
| live_period | Integer | false | <em>Optional</em>. Period in seconds for which the location can be updated, should be between 60 and 86400. |

#### InputVenueMessageContent

    InputVenueMessageContent(latitude: Float, longitude: Float, title: String, address: String, foursquare_id: String, foursquare_type: String)

<p>Represents the <a href="#inputmessagecontent">content</a> of a venue message to be sent as the result of an inline query.</p>

| name | type | required | description |
|---|---|---|---|
| latitude | Float | true | Latitude of the venue in degrees |
| longitude | Float | true | Longitude of the venue in degrees |
| title | String | true | Name of the venue |
| address | String | true | Address of the venue |
| foursquare_id | String | false | <em>Optional</em>. Foursquare identifier of the venue, if known |
| foursquare_type | String | false | <em>Optional</em>. Foursquare type of the venue, if known. (For example, “arts_entertainment/default”, “arts_entertainment/aquarium” or “food/icecream”.) |

#### InputContactMessageContent

    InputContactMessageContent(phone_number: String, first_name: String, last_name: String, vcard: String)

<p>Represents the <a href="#inputmessagecontent">content</a> of a contact message to be sent as the result of an inline query.</p>

| name | type | required | description |
|---|---|---|---|
| phone_number | String | true | Contact's phone number |
| first_name | String | true | Contact's first name |
| last_name | String | false | <em>Optional</em>. Contact's last name |
| vcard | String | false | <em>Optional</em>. Additional data about the contact in the form of a <a href="https://en.wikipedia.org/wiki/VCard">vCard</a>, 0-2048 bytes |

#### ChosenInlineResult

    ChosenInlineResult(result_id: String, from: User, location: Location, inline_message_id: String, query: String)

<p>Represents a <a href="#inlinequeryresult">result</a> of an inline query that was chosen by the user and sent to their chat partner.</p><p><strong>Note:</strong> It is necessary to enable <a href="/bots/inline#collecting-feedback">inline feedback</a> via <a href="https://t.me/botfather">@Botfather</a> in order to receive these objects in updates.</p>

| name | type | required | description |
|---|---|---|---|
| result_id | String | true | The unique identifier for the result that was chosen |
| from | User | true | The user that chose the result |
| location | Location | false | <em>Optional</em>. Sender location, only for bots that require user location |
| inline_message_id | String | false | <em>Optional</em>. Identifier of the sent inline message. Available only if there is an <a href="#inlinekeyboardmarkup">inline keyboard</a> attached to the message. Will be also received in <a href="#callbackquery">callback queries</a> and can be used to <a href="#updating-messages">edit</a> the message. |
| query | String | true | The query that was used to obtain the result |


### Methods
#### answerInlineQuery

    answerInlineQuery(inline_query_id: String, results: List<InlineQueryResult>, cache_time: Integer, is_personal: Boolean, next_offset: String, switch_pm_text: String, switch_pm_parameter: String)

<p>Use this method to send answers to an inline query. On success, <em>True</em> is returned.<br>No more than <strong>50</strong> results per query are allowed.</p>

| name | type | required | description |
|---|---|---|---|
| inline_query_id | String | true | Unique identifier for the answered query |
| results | List<InlineQueryResult> | true | A JSON-serialized array of results for the inline query |
| cache_time | Integer | false | The maximum amount of time in seconds that the result of the inline query may be cached on the server. Defaults to 300. |
| is_personal | Boolean | false | Pass <em>True</em>, if results may be cached on the server side only for the user that sent the query. By default, results may be returned to any user who sends the same query |
| next_offset | String | false | Pass the offset that a client should send in the next query with the same text to receive more results. Pass an empty string if there are no more results or if you don‘t support pagination. Offset length can’t exceed 64 bytes. |
| switch_pm_text | String | false | If passed, clients will display a button with specified text that switches the user to a private chat with the bot and sends the bot a start message with the parameter <em>switch_pm_parameter</em> |
| switch_pm_parameter | String | false | <a href="/bots#deep-linking">Deep-linking</a> parameter for the /start message sent to the bot when user presses the switch button. 1-64 characters, only <code>A-Z</code>, <code>a-z</code>, <code>0-9</code>, <code>_</code> and <code>-</code> are allowed.<br><br><em>Example:</em> An inline bot that sends YouTube videos can ask the user to connect the bot to their YouTube account to adapt search results accordingly. To do this, it displays a ‘Connect your YouTube account’ button above the results, or even before showing any. The user presses the button, switches to a private chat with the bot and, in doing so, passes a start parameter that instructs the bot to return an oauth link. Once done, the bot can offer a <a href="#inlinekeyboardmarkup"><em>switch_inline</em></a> button so that the user can easily return to the chat where they wanted to use the bot's inline capabilities. |



## Payments

### Data Types
#### LabeledPrice

    LabeledPrice(label: String, amount: Integer)

<p>This object represents a portion of the price for goods or services.</p>

| name | type | required | description |
|---|---|---|---|
| label | String | true | Portion label |
| amount | Integer | true | Price of the product in the <em>smallest units</em> of the <a href="/bots/payments#supported-currencies">currency</a> (integer, <strong>not</strong> float/double). For example, for a price of <code>US$ 1.45</code> pass <code>amount = 145</code>. See the <em>exp</em> parameter in <a href="https://core.telegram.org/bots/payments/currencies.json">currencies.json</a>, it shows the number of digits past the decimal point for each currency (2 for the majority of currencies). |

#### Invoice

    Invoice(title: String, description: String, start_parameter: String, currency: String, total_amount: Integer)

<p>This object contains basic information about an invoice.</p>

| name | type | required | description |
|---|---|---|---|
| title | String | true | Product name |
| description | String | true | Product description |
| start_parameter | String | true | Unique bot deep-linking parameter that can be used to generate this invoice |
| currency | String | true | Three-letter ISO 4217 <a href="/bots/payments#supported-currencies">currency</a> code |
| total_amount | Integer | true | Total price in the <em>smallest units</em> of the currency (integer, <strong>not</strong> float/double). For example, for a price of <code>US$ 1.45</code> pass <code>amount = 145</code>. See the <em>exp</em> parameter in <a href="https://core.telegram.org/bots/payments/currencies.json">currencies.json</a>, it shows the number of digits past the decimal point for each currency (2 for the majority of currencies). |

#### ShippingAddress

    ShippingAddress(country_code: String, state: String, city: String, street_line1: String, street_line2: String, post_code: String)

<p>This object represents a shipping address.</p>

| name | type | required | description |
|---|---|---|---|
| country_code | String | true | ISO 3166-1 alpha-2 country code |
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
| currency | String | true | Three-letter ISO 4217 <a href="/bots/payments#supported-currencies">currency</a> code |
| total_amount | Integer | true | Total price in the <em>smallest units</em> of the currency (integer, <strong>not</strong> float/double). For example, for a price of <code>US$ 1.45</code> pass <code>amount = 145</code>. See the <em>exp</em> parameter in <a href="https://core.telegram.org/bots/payments/currencies.json">currencies.json</a>, it shows the number of digits past the decimal point for each currency (2 for the majority of currencies). |
| invoice_payload | String | true | Bot specified invoice payload |
| shipping_option_id | String | false | <em>Optional</em>. Identifier of the shipping option chosen by the user |
| order_info | OrderInfo | false | <em>Optional</em>. Order info provided by the user |
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
| currency | String | true | Three-letter ISO 4217 <a href="/bots/payments#supported-currencies">currency</a> code |
| total_amount | Integer | true | Total price in the <em>smallest units</em> of the currency (integer, <strong>not</strong> float/double). For example, for a price of <code>US$ 1.45</code> pass <code>amount = 145</code>. See the <em>exp</em> parameter in <a href="https://core.telegram.org/bots/payments/currencies.json">currencies.json</a>, it shows the number of digits past the decimal point for each currency (2 for the majority of currencies). |
| invoice_payload | String | true | Bot specified invoice payload |
| shipping_option_id | String | false | <em>Optional</em>. Identifier of the shipping option chosen by the user |
| order_info | OrderInfo | false | <em>Optional</em>. Order info provided by the user |


### Methods
#### sendInvoice

    sendInvoice(chat_id: Integer, title: String, description: String, payload: String, provider_token: String, start_parameter: String, currency: String, prices: List<LabeledPrice>, provider_data: String, photo_url: String, photo_size: Integer, photo_width: Integer, photo_height: Integer, need_name: Boolean, need_phone_number: Boolean, need_email: Boolean, need_shipping_address: Boolean, send_phone_number_to_provider: Boolean, send_email_to_provider: Boolean, is_flexible: Boolean, disable_notification: Boolean, reply_to_message_id: Integer, reply_markup: InlineKeyboardMarkup)

<p>Use this method to send invoices. On success, the sent <a href="#message">Message</a> is returned.</p>

| name | type | required | description |
|---|---|---|---|
| chat_id | Integer | true | Unique identifier for the target private chat |
| title | String | true | Product name, 1-32 characters |
| description | String | true | Product description, 1-255 characters |
| payload | String | true | Bot-defined invoice payload, 1-128 bytes. This will not be displayed to the user, use for your internal processes. |
| provider_token | String | true | Payments provider token, obtained via <a href="https://t.me/botfather">Botfather</a> |
| start_parameter | String | true | Unique deep-linking parameter that can be used to generate this invoice when used as a start parameter |
| currency | String | true | Three-letter ISO 4217 currency code, see <a href="/bots/payments#supported-currencies">more on currencies</a> |
| prices | List<LabeledPrice> | true | Price breakdown, a JSON-serialized list of components (e.g. product price, tax, discount, delivery cost, delivery tax, bonus, etc.) |
| provider_data | String | false | JSON-encoded data about the invoice, which will be shared with the payment provider. A detailed description of required fields should be provided by the payment provider. |
| photo_url | String | false | URL of the product photo for the invoice. Can be a photo of the goods or a marketing image for a service. People like it better when they see what they are paying for. |
| photo_size | Integer | false | Photo size |
| photo_width | Integer | false | Photo width |
| photo_height | Integer | false | Photo height |
| need_name | Boolean | false | Pass <em>True</em>, if you require the user's full name to complete the order |
| need_phone_number | Boolean | false | Pass <em>True</em>, if you require the user's phone number to complete the order |
| need_email | Boolean | false | Pass <em>True</em>, if you require the user's email address to complete the order |
| need_shipping_address | Boolean | false | Pass <em>True</em>, if you require the user's shipping address to complete the order |
| send_phone_number_to_provider | Boolean | false | Pass <em>True</em>, if user's phone number should be sent to provider |
| send_email_to_provider | Boolean | false | Pass <em>True</em>, if user's email address should be sent to provider |
| is_flexible | Boolean | false | Pass <em>True</em>, if the final price depends on the shipping method |
| disable_notification | Boolean | false | Sends the message <a href="https://telegram.org/blog/channels-2-0#silent-messages">silently</a>. Users will receive a notification with no sound. |
| reply_to_message_id | Integer | false | If the message is a reply, ID of the original message |
| reply_markup | InlineKeyboardMarkup | false | A JSON-serialized object for an <a href="https://core.telegram.org/bots#inline-keyboards-and-on-the-fly-updating">inline keyboard</a>. If empty, one 'Pay <code>total price</code>' button will be shown. If not empty, the first button must be a Pay button. |

#### answerShippingQuery

    answerShippingQuery(shipping_query_id: String, ok: Boolean, shipping_options: List<ShippingOption>, error_message: String)

<p>If you sent an invoice requesting a shipping address and the parameter <em>is_flexible</em> was specified, the Bot API will send an <a href="#update">Update</a> with a <em>shipping_query</em> field to the bot. Use this method to reply to shipping queries. On success, True is returned.</p>

| name | type | required | description |
|---|---|---|---|
| shipping_query_id | String | true | Unique identifier for the query to be answered |
| ok | Boolean | true | Specify True if delivery to the specified address is possible and False if there are any problems (for example, if delivery to the specified address is not possible) |
| shipping_options | List<ShippingOption> | false | Required if <em>ok</em> is True. A JSON-serialized array of available shipping options. |
| error_message | String | false | Required if <em>ok</em> is False. Error message in human readable form that explains why it is impossible to complete the order (e.g. "Sorry, delivery to your desired address is unavailable'). Telegram will display this message to the user. |

#### answerPreCheckoutQuery

    answerPreCheckoutQuery(pre_checkout_query_id: String, ok: Boolean, error_message: String)

<p>Once the user has confirmed their payment and shipping details, the Bot API sends the final confirmation in the form of an <a href="#update">Update</a> with the field <em>pre_checkout_query</em>. Use this method to respond to such pre-checkout queries. On success, True is returned. <strong>Note:</strong> The Bot API must receive an answer within 10 seconds after the pre-checkout query was sent.</p>

| name | type | required | description |
|---|---|---|---|
| pre_checkout_query_id | String | true | Unique identifier for the query to be answered |
| ok | Boolean | true | Specify <em>True</em> if everything is alright (goods are available, etc.) and the bot is ready to proceed with the order. Use <em>False</em> if there are any problems. |
| error_message | String | false | Required if <em>ok</em> is <em>False</em>. Error message in human readable form that explains the reason for failure to proceed with the checkout (e.g. "Sorry, somebody just bought the last of our amazing black T-shirts while you were busy filling out your payment details. Please choose a different color or garment!"). Telegram will display this message to the user. |



## Telegram Passport

### Data Types
#### PassportData

    PassportData(data: List<EncryptedPassportElement>, credentials: EncryptedCredentials)

<p>Contains information about Telegram Passport data shared with the bot by the user.</p>

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
| file_size | Integer | true | File size |
| file_date | Integer | true | Unix time when the file was uploaded |

#### EncryptedPassportElement

    EncryptedPassportElement(type: String, data: String, phone_number: String, email: String, files: List<PassportFile>, front_side: PassportFile, reverse_side: PassportFile, selfie: PassportFile, translation: List<PassportFile>, hash: String)

<p>Contains information about documents or other Telegram Passport elements shared with the bot by the user.</p>

| name | type | required | description |
|---|---|---|---|
| type | String | true | Element type. One of “personal_details”, “passport”, “driver_license”, “identity_card”, “internal_passport”, “address”, “utility_bill”, “bank_statement”, “rental_agreement”, “passport_registration”, “temporary_registration”, “phone_number”, “email”. |
| data | String | false | <em>Optional</em>. Base64-encoded encrypted Telegram Passport element data provided by the user, available for “personal_details”, “passport”, “driver_license”, “identity_card”, “internal_passport” and “address” types. Can be decrypted and verified using the accompanying <a href="#encryptedcredentials">EncryptedCredentials</a>. |
| phone_number | String | false | <em>Optional</em>. User's verified phone number, available only for “phone_number” type |
| email | String | false | <em>Optional</em>. User's verified email address, available only for “email” type |
| files | List<PassportFile> | false | <em>Optional</em>. Array of encrypted files with documents provided by the user, available for “utility_bill”, “bank_statement”, “rental_agreement”, “passport_registration” and “temporary_registration” types. Files can be decrypted and verified using the accompanying <a href="#encryptedcredentials">EncryptedCredentials</a>. |
| front_side | PassportFile | false | <em>Optional</em>. Encrypted file with the front side of the document, provided by the user. Available for “passport”, “driver_license”, “identity_card” and “internal_passport”. The file can be decrypted and verified using the accompanying <a href="#encryptedcredentials">EncryptedCredentials</a>. |
| reverse_side | PassportFile | false | <em>Optional</em>. Encrypted file with the reverse side of the document, provided by the user. Available for “driver_license” and “identity_card”. The file can be decrypted and verified using the accompanying <a href="#encryptedcredentials">EncryptedCredentials</a>. |
| selfie | PassportFile | false | <em>Optional</em>. Encrypted file with the selfie of the user holding a document, provided by the user; available for “passport”, “driver_license”, “identity_card” and “internal_passport”. The file can be decrypted and verified using the accompanying <a href="#encryptedcredentials">EncryptedCredentials</a>. |
| translation | List<PassportFile> | false | <em>Optional</em>. Array of encrypted files with translated versions of documents provided by the user. Available if requested for “passport”, “driver_license”, “identity_card”, “internal_passport”, “utility_bill”, “bank_statement”, “rental_agreement”, “passport_registration” and “temporary_registration” types. Files can be decrypted and verified using the accompanying <a href="#encryptedcredentials">EncryptedCredentials</a>. |
| hash | String | true | Base64-encoded element hash for using in <a href="#passportelementerrorunspecified">PassportElementErrorUnspecified</a> |

#### EncryptedCredentials

    EncryptedCredentials(data: String, hash: String, secret: String)

<p>Contains data required for decrypting and authenticating <a href="#encryptedpassportelement">EncryptedPassportElement</a>. See the <a href="https://core.telegram.org/passport#receiving-information">Telegram Passport Documentation</a> for a complete description of the data decryption and authentication processes.</p>

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

<p>This object represents one row of the high scores table for a game.</p><p>And that‘s about all we’ve got for now.<br>If you've got any questions, please check out our <a href="/bots/faq"><strong>Bot FAQ »</strong></a></p>

| name | type | required | description |
|---|---|---|---|
| position | Integer | true | Position in high score table for the game |
| user | User | true | User |
| score | Integer | true | Score |


### Methods
#### sendGame

    sendGame(chat_id: Integer, game_short_name: String, disable_notification: Boolean, reply_to_message_id: Integer, reply_markup: InlineKeyboardMarkup)

<p>Use this method to send a game. On success, the sent <a href="#message">Message</a> is returned.</p>

| name | type | required | description |
|---|---|---|---|
| chat_id | Integer | true | Unique identifier for the target chat |
| game_short_name | String | true | Short name of the game, serves as the unique identifier for the game. Set up your games via <a href="https://t.me/botfather">Botfather</a>. |
| disable_notification | Boolean | false | Sends the message <a href="https://telegram.org/blog/channels-2-0#silent-messages">silently</a>. Users will receive a notification with no sound. |
| reply_to_message_id | Integer | false | If the message is a reply, ID of the original message |
| reply_markup | InlineKeyboardMarkup | false | A JSON-serialized object for an <a href="https://core.telegram.org/bots#inline-keyboards-and-on-the-fly-updating">inline keyboard</a>. If empty, one ‘Play game_title’ button will be shown. If not empty, the first button must launch the game. |

#### setGameScore

    setGameScore(user_id: Integer, score: Integer, force: Boolean, disable_edit_message: Boolean, chat_id: Integer, message_id: Integer, inline_message_id: String)

<p>Use this method to set the score of the specified user in a game. On success, if the message was sent by the bot, returns the edited <a href="#message">Message</a>, otherwise returns <em>True</em>. Returns an error, if the new score is not greater than the user's current score in the chat and <em>force</em> is <em>False</em>.</p>

| name | type | required | description |
|---|---|---|---|
| user_id | Integer | true | User identifier |
| score | Integer | true | New score, must be non-negative |
| force | Boolean | false | Pass True, if the high score is allowed to decrease. This can be useful when fixing mistakes or banning cheaters |
| disable_edit_message | Boolean | false | Pass True, if the game message should not be automatically edited to include the current scoreboard |
| chat_id | Integer | false | Required if <em>inline_message_id</em> is not specified. Unique identifier for the target chat |
| message_id | Integer | false | Required if <em>inline_message_id</em> is not specified. Identifier of the sent message |
| inline_message_id | String | false | Required if <em>chat_id</em> and <em>message_id</em> are not specified. Identifier of the inline message |

#### getGameHighScores

    getGameHighScores(user_id: Integer, chat_id: Integer, message_id: Integer, inline_message_id: String)

<p>Use this method to get data for high score tables. Will return the score of the specified user and several of their neighbors in a game. On success, returns an <em>Array</em> of <a href="#gamehighscore">GameHighScore</a> objects.</p><blockquote> 
 <p>This method will currently return scores for the target user, plus two of their closest neighbors on each side. Will also return the top three users if the user and his neighbors are not among them. Please note that this behavior is subject to change.</p> 
</blockquote>

| name | type | required | description |
|---|---|---|---|
| user_id | Integer | true | Target user id |
| chat_id | Integer | false | Required if <em>inline_message_id</em> is not specified. Unique identifier for the target chat |
| message_id | Integer | false | Required if <em>inline_message_id</em> is not specified. Identifier of the sent message |
| inline_message_id | String | false | Required if <em>chat_id</em> and <em>message_id</em> are not specified. Identifier of the inline message |

