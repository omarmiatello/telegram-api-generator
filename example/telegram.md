

## Getting updates

### Data Types
<p>This <a href="#available-types">object</a> represents an incoming update.<br>At most <strong>one</strong> of the optional parameters can be present in any given update.</p>

    Update(update_id: Integer, message: Message, edited_message: Message, channel_post: Message, edited_channel_post: Message, inline_query: InlineQuery, chosen_inline_result: ChosenInlineResult, callback_query: CallbackQuery, shipping_query: ShippingQuery, pre_checkout_query: PreCheckoutQuery, poll: Poll, poll_answer: PollAnswer)

<p>Contains information about the current status of a webhook.</p>

    WebhookInfo(url: String, has_custom_certificate: Boolean, pending_update_count: Integer, last_error_date: Integer, last_error_message: String, max_connections: Integer, allowed_updates: List<String>)


### Methods
<p>Use this method to receive incoming updates using long polling (<a href="https://en.wikipedia.org/wiki/Push_technology#Long_polling">wiki</a>). An Array of <a href="#update">Update</a> objects is returned.</p><blockquote> 
 <p><strong>Notes</strong><br><strong>1.</strong> This method will not work if an outgoing webhook is set up.<br><strong>2.</strong> In order to avoid getting duplicate updates, recalculate <em>offset</em> after each server response.</p> 
</blockquote>

    getUpdates(offset: Integer, limit: Integer, timeout: Integer, allowed_updates: List<String>)

<p>Use this method to specify a url and receive incoming updates via an outgoing webhook. Whenever there is an update for the bot, we will send an HTTPS POST request to the specified url, containing a JSON-serialized <a href="#update">Update</a>. In case of an unsuccessful request, we will give up after a reasonable amount of attempts. Returns <em>True</em> on success.</p><p>If you'd like to make sure that the Webhook request comes from Telegram, we recommend using a secret path in the URL, e.g. <code>https://www.example.com/&lt;token&gt;</code>. Since nobody else knows your bot's token, you can be pretty sure it's us.</p><blockquote> 
 <p><strong>Notes</strong><br><strong>1.</strong> You will not be able to receive updates using <a href="#getupdates">getUpdates</a> for as long as an outgoing webhook is set up.<br><strong>2.</strong> To use a self-signed certificate, you need to upload your <a href="/bots/self-signed">public key certificate</a> using <em>certificate</em> parameter. Please upload as InputFile, sending a String will not work.<br><strong>3.</strong> Ports currently supported <em>for Webhooks</em>: <strong>443, 80, 88, 8443</strong>.</p> 
 <p><strong>NEW!</strong> If you're having any trouble setting up webhooks, please check out this <a href="/bots/webhooks">amazing guide to Webhooks</a>.</p> 
</blockquote>

    setWebhook(url: String, certificate: InputFile, max_connections: Integer, allowed_updates: List<String>)

<p>Use this method to remove webhook integration if you decide to switch back to <a href="#getupdates">getUpdates</a>. Returns <em>True</em> on success. Requires no parameters.</p>

    deleteWebhook()

<p>Use this method to get current webhook status. Requires no parameters. On success, returns a <a href="#webhookinfo">WebhookInfo</a> object. If the bot is using <a href="#getupdates">getUpdates</a>, will return an object with the <em>url</em> field empty.</p>

    getWebhookInfo()



## Available types

### Data Types
<p>This object represents a Telegram user or bot.</p>

    User(id: Integer, is_bot: Boolean, first_name: String, last_name: String, username: String, language_code: String, can_join_groups: Boolean, can_read_all_group_messages: Boolean, supports_inline_queries: Boolean)

<p>This object represents a chat.</p>

    Chat(id: Integer, type: String, title: String, username: String, first_name: String, last_name: String, photo: ChatPhoto, description: String, invite_link: String, pinned_message: Message, permissions: ChatPermissions, slow_mode_delay: Integer, sticker_set_name: String, can_set_sticker_set: Boolean)

<p>This object represents a message.</p>

    Message(message_id: Integer, from: User, date: Integer, chat: Chat, forward_from: User, forward_from_chat: Chat, forward_from_message_id: Integer, forward_signature: String, forward_sender_name: String, forward_date: Integer, reply_to_message: Message, via_bot: User, edit_date: Integer, media_group_id: String, author_signature: String, text: String, entities: List<MessageEntity>, animation: Animation, audio: Audio, document: Document, photo: List<PhotoSize>, sticker: Sticker, video: Video, video_note: VideoNote, voice: Voice, caption: String, caption_entities: List<MessageEntity>, contact: Contact, dice: Dice, game: Game, poll: Poll, venue: Venue, location: Location, new_chat_members: List<User>, left_chat_member: User, new_chat_title: String, new_chat_photo: List<PhotoSize>, delete_chat_photo: Boolean, group_chat_created: Boolean, supergroup_chat_created: Boolean, channel_chat_created: Boolean, migrate_to_chat_id: Integer, migrate_from_chat_id: Integer, pinned_message: Message, invoice: Invoice, successful_payment: SuccessfulPayment, connected_website: String, passport_data: PassportData, reply_markup: InlineKeyboardMarkup)

<p>This object represents one special entity in a text message. For example, hashtags, usernames, URLs, etc.</p>

    MessageEntity(type: String, offset: Integer, length: Integer, url: String, user: User, language: String)

<p>This object represents one size of a photo or a <a href="#document">file</a> / <a href="#sticker">sticker</a> thumbnail.</p>

    PhotoSize(file_id: String, file_unique_id: String, width: Integer, height: Integer, file_size: Integer)

<p>This object represents an animation file (GIF or H.264/MPEG-4 AVC video without sound).</p>

    Animation(file_id: String, file_unique_id: String, width: Integer, height: Integer, duration: Integer, thumb: PhotoSize, file_name: String, mime_type: String, file_size: Integer)

<p>This object represents an audio file to be treated as music by the Telegram clients.</p>

    Audio(file_id: String, file_unique_id: String, duration: Integer, performer: String, title: String, mime_type: String, file_size: Integer, thumb: PhotoSize)

<p>This object represents a general file (as opposed to <a href="#photosize">photos</a>, <a href="#voice">voice messages</a> and <a href="#audio">audio files</a>).</p>

    Document(file_id: String, file_unique_id: String, thumb: PhotoSize, file_name: String, mime_type: String, file_size: Integer)

<p>This object represents a video file.</p>

    Video(file_id: String, file_unique_id: String, width: Integer, height: Integer, duration: Integer, thumb: PhotoSize, mime_type: String, file_size: Integer)

<p>This object represents a <a href="https://telegram.org/blog/video-messages-and-telescope">video message</a> (available in Telegram apps as of <a href="https://telegram.org/blog/video-messages-and-telescope">v.4.0</a>).</p>

    VideoNote(file_id: String, file_unique_id: String, length: Integer, duration: Integer, thumb: PhotoSize, file_size: Integer)

<p>This object represents a voice note.</p>

    Voice(file_id: String, file_unique_id: String, duration: Integer, mime_type: String, file_size: Integer)

<p>This object represents a phone contact.</p>

    Contact(phone_number: String, first_name: String, last_name: String, user_id: Integer, vcard: String)

<p>This object represents an animated emoji that displays a random value.</p>

    Dice(emoji: String, value: Integer)

<p>This object contains information about one answer option in a poll.</p>

    PollOption(text: String, voter_count: Integer)

<p>This object represents an answer of a user in a non-anonymous poll.</p>

    PollAnswer(poll_id: String, user: User, option_ids: List<Integer>)

<p>This object contains information about a poll.</p>

    Poll(id: String, question: String, options: List<PollOption>, total_voter_count: Integer, is_closed: Boolean, is_anonymous: Boolean, type: String, allows_multiple_answers: Boolean, correct_option_id: Integer, explanation: String, explanation_entities: List<MessageEntity>, open_period: Integer, close_date: Integer)

<p>This object represents a point on the map.</p>

    Location(longitude: Float, latitude: Float)

<p>This object represents a venue.</p>

    Venue(location: Location, title: String, address: String, foursquare_id: String, foursquare_type: String)

<p>This object represent a user's profile pictures.</p>

    UserProfilePhotos(total_count: Integer, photos: List<List<PhotoSize>>)

<p>This object represents a file ready to be downloaded. The file can be downloaded via the link <code>https://api.telegram.org/file/bot&lt;token&gt;/&lt;file_path&gt;</code>. It is guaranteed that the link will be valid for at least 1 hour. When the link expires, a new one can be requested by calling <a href="#getfile">getFile</a>.</p><blockquote> 
 <p>Maximum file size to download is 20 MB</p> 
</blockquote>

    File(file_id: String, file_unique_id: String, file_size: Integer, file_path: String)

<p>This object represents a <a href="https://core.telegram.org/bots#keyboards">custom keyboard</a> with reply options (see <a href="https://core.telegram.org/bots#keyboards">Introduction to bots</a> for details and examples).</p>

    ReplyKeyboardMarkup(keyboard: List<List<KeyboardButton>>, resize_keyboard: Boolean, one_time_keyboard: Boolean, selective: Boolean)

<p>This object represents one button of the reply keyboard. For simple text buttons <em>String</em> can be used instead of this object to specify text of the button. Optional fields <em>request_contact</em>, <em>request_location</em>, and <em>request_poll</em> are mutually exclusive.</p><p><strong>Note:</strong> <em>request_contact</em> and <em>request_location</em> options will only work in Telegram versions released after 9 April, 2016. Older clients will display <em>unsupported message</em>.<br><strong>Note:</strong> <em>request_poll</em> option will only work in Telegram versions released after 23 January, 2020. Older clients will display <em>unsupported message</em>.</p>

    KeyboardButton(text: String, request_contact: Boolean, request_location: Boolean, request_poll: KeyboardButtonPollType)

<p>This object represents type of a poll, which is allowed to be created and sent when the corresponding button is pressed.</p>

    KeyboardButtonPollType(type: String)

<p>Upon receiving a message with this object, Telegram clients will remove the current custom keyboard and display the default letter-keyboard. By default, custom keyboards are displayed until a new keyboard is sent by a bot. An exception is made for one-time keyboards that are hidden immediately after the user presses a button (see <a href="#replykeyboardmarkup">ReplyKeyboardMarkup</a>).</p>

    ReplyKeyboardRemove(remove_keyboard: Boolean, selective: Boolean)

<p>This object represents an <a href="https://core.telegram.org/bots#inline-keyboards-and-on-the-fly-updating">inline keyboard</a> that appears right next to the message it belongs to.</p><p><strong>Note:</strong> This will only work in Telegram versions released after 9 April, 2016. Older clients will display <em>unsupported message</em>.</p>

    InlineKeyboardMarkup(inline_keyboard: List<List<InlineKeyboardButton>>)

<p>This object represents one button of an inline keyboard. You <strong>must</strong> use exactly one of the optional fields.</p>

    InlineKeyboardButton(text: String, url: String, login_url: LoginUrl, callback_data: String, switch_inline_query: String, switch_inline_query_current_chat: String, callback_game: CallbackGame, pay: Boolean)

<p>This object represents a parameter of the inline keyboard button used to automatically authorize a user. Serves as a great replacement for the <a href="https://core.telegram.org/widgets/login">Telegram Login Widget</a> when the user is coming from Telegram. All the user needs to do is tap/click a button and confirm that they want to log in:</p><p>Telegram apps support these buttons as of <a href="https://telegram.org/blog/privacy-discussions-web-bots#meet-seamless-web-bots">version 5.7</a>.</p><blockquote> 
 <p>Sample bot: <a href="https://t.me/discussbot">@discussbot</a></p> 
</blockquote>

    LoginUrl(url: String, forward_text: String, bot_username: String, request_write_access: Boolean)

<p>This object represents an incoming callback query from a callback button in an <a href="/bots#inline-keyboards-and-on-the-fly-updating">inline keyboard</a>. If the button that originated the query was attached to a message sent by the bot, the field <em>message</em> will be present. If the button was attached to a message sent via the bot (in <a href="#inline-mode">inline mode</a>), the field <em>inline_message_id</em> will be present. Exactly one of the fields <em>data</em> or <em>game_short_name</em> will be present.</p><blockquote> 
 <p><strong>NOTE:</strong> After the user presses a callback button, Telegram clients will display a progress bar until you call <a href="#answercallbackquery">answerCallbackQuery</a>. It is, therefore, necessary to react by calling <a href="#answercallbackquery">answerCallbackQuery</a> even if no notification to the user is needed (e.g., without specifying any of the optional parameters).</p> 
</blockquote>

    CallbackQuery(id: String, from: User, message: Message, inline_message_id: String, chat_instance: String, data: String, game_short_name: String)

<p>Upon receiving a message with this object, Telegram clients will display a reply interface to the user (act as if the user has selected the bot's message and tapped 'Reply'). This can be extremely useful if you want to create user-friendly step-by-step interfaces without having to sacrifice <a href="/bots#privacy-mode">privacy mode</a>.</p><blockquote> 
 <p><strong>Example:</strong> A <a href="https://t.me/PollBot">poll bot</a> for groups runs in privacy mode (only receives commands, replies to its messages and mentions). There could be two ways to create a new poll:</p> 
 <ul> 
  <li>Explain the user how to send a command with parameters (e.g. /newpoll question answer1 answer2). May be appealing for hardcore users but lacks modern day polish.</li> 
  <li>Guide the user through a step-by-step process. 'Please send me your question', 'Cool, now let's add the first answer option', 'Great. Keep adding answer options, then send /done when you're ready'.</li> 
 </ul> 
 <p>The last option is definitely more attractive. And if you use <a href="#forcereply">ForceReply</a> in your bot's questions, it will receive the user's answers even if it only receives replies, commands and mentions — without any extra work for the user.</p> 
</blockquote>

    ForceReply(force_reply: Boolean, selective: Boolean)

<p>This object represents a chat photo.</p>

    ChatPhoto(small_file_id: String, small_file_unique_id: String, big_file_id: String, big_file_unique_id: String)

<p>This object contains information about one member of a chat.</p>

    ChatMember(user: User, status: String, custom_title: String, until_date: Integer, can_be_edited: Boolean, can_post_messages: Boolean, can_edit_messages: Boolean, can_delete_messages: Boolean, can_restrict_members: Boolean, can_promote_members: Boolean, can_change_info: Boolean, can_invite_users: Boolean, can_pin_messages: Boolean, is_member: Boolean, can_send_messages: Boolean, can_send_media_messages: Boolean, can_send_polls: Boolean, can_send_other_messages: Boolean, can_add_web_page_previews: Boolean)

<p>Describes actions that a non-administrator user is allowed to take in a chat.</p>

    ChatPermissions(can_send_messages: Boolean, can_send_media_messages: Boolean, can_send_polls: Boolean, can_send_other_messages: Boolean, can_add_web_page_previews: Boolean, can_change_info: Boolean, can_invite_users: Boolean, can_pin_messages: Boolean)

<p>This object represents a bot command.</p>

    BotCommand(command: String, description: String)

<p>Contains information about why a request was unsuccessful.</p>

    ResponseParameters(migrate_to_chat_id: Integer, retry_after: Integer)

<p>Represents a photo to be sent.</p>

    InputMediaPhoto(type: String, media: String, caption: String, parse_mode: ParseMode)

<p>Represents a video to be sent.</p>

    InputMediaVideo(type: String, media: String, thumb: InputFileOrString, caption: String, parse_mode: ParseMode, width: Integer, height: Integer, duration: Integer, supports_streaming: Boolean)

<p>Represents an animation file (GIF or H.264/MPEG-4 AVC video without sound) to be sent.</p>

    InputMediaAnimation(type: String, media: String, thumb: InputFileOrString, caption: String, parse_mode: ParseMode, width: Integer, height: Integer, duration: Integer)

<p>Represents an audio file to be treated as music to be sent.</p>

    InputMediaAudio(type: String, media: String, thumb: InputFileOrString, caption: String, parse_mode: ParseMode, duration: Integer, performer: String, title: String)

<p>Represents a general file to be sent.</p>

    InputMediaDocument(type: String, media: String, thumb: InputFileOrString, caption: String, parse_mode: ParseMode)



## Available methods

### Methods
<p>Use this method to send text messages. On success, the sent <a href="#message">Message</a> is returned.</p>

    sendMessage(chat_id: IntegerOrString, text: String, parse_mode: ParseMode, disable_web_page_preview: Boolean, disable_notification: Boolean, reply_to_message_id: Integer, reply_markup: KeyboardOption)

<p>Use this method to forward messages of any kind. On success, the sent <a href="#message">Message</a> is returned.</p>

    forwardMessage(chat_id: IntegerOrString, from_chat_id: IntegerOrString, disable_notification: Boolean, message_id: Integer)

<p>Use this method to send photos. On success, the sent <a href="#message">Message</a> is returned.</p>

    sendPhoto(chat_id: IntegerOrString, photo: InputFileOrString, caption: String, parse_mode: ParseMode, disable_notification: Boolean, reply_to_message_id: Integer, reply_markup: KeyboardOption)

<p>Use this method to send audio files, if you want Telegram clients to display them in the music player. Your audio must be in the .MP3 or .M4A format. On success, the sent <a href="#message">Message</a> is returned. Bots can currently send audio files of up to 50 MB in size, this limit may be changed in the future.</p><p>For sending voice messages, use the <a href="#sendvoice">sendVoice</a> method instead.</p>

    sendAudio(chat_id: IntegerOrString, audio: InputFileOrString, caption: String, parse_mode: ParseMode, duration: Integer, performer: String, title: String, thumb: InputFileOrString, disable_notification: Boolean, reply_to_message_id: Integer, reply_markup: KeyboardOption)

<p>Use this method to send general files. On success, the sent <a href="#message">Message</a> is returned. Bots can currently send files of any type of up to 50 MB in size, this limit may be changed in the future.</p>

    sendDocument(chat_id: IntegerOrString, document: InputFileOrString, thumb: InputFileOrString, caption: String, parse_mode: ParseMode, disable_notification: Boolean, reply_to_message_id: Integer, reply_markup: KeyboardOption)

<p>Use this method to send video files, Telegram clients support mp4 videos (other formats may be sent as <a href="#document">Document</a>). On success, the sent <a href="#message">Message</a> is returned. Bots can currently send video files of up to 50 MB in size, this limit may be changed in the future.</p>

    sendVideo(chat_id: IntegerOrString, video: InputFileOrString, duration: Integer, width: Integer, height: Integer, thumb: InputFileOrString, caption: String, parse_mode: ParseMode, supports_streaming: Boolean, disable_notification: Boolean, reply_to_message_id: Integer, reply_markup: KeyboardOption)

<p>Use this method to send animation files (GIF or H.264/MPEG-4 AVC video without sound). On success, the sent <a href="#message">Message</a> is returned. Bots can currently send animation files of up to 50 MB in size, this limit may be changed in the future.</p>

    sendAnimation(chat_id: IntegerOrString, animation: InputFileOrString, duration: Integer, width: Integer, height: Integer, thumb: InputFileOrString, caption: String, parse_mode: ParseMode, disable_notification: Boolean, reply_to_message_id: Integer, reply_markup: KeyboardOption)

<p>Use this method to send audio files, if you want Telegram clients to display the file as a playable voice message. For this to work, your audio must be in an .OGG file encoded with OPUS (other formats may be sent as <a href="#audio">Audio</a> or <a href="#document">Document</a>). On success, the sent <a href="#message">Message</a> is returned. Bots can currently send voice messages of up to 50 MB in size, this limit may be changed in the future.</p>

    sendVoice(chat_id: IntegerOrString, voice: InputFileOrString, caption: String, parse_mode: ParseMode, duration: Integer, disable_notification: Boolean, reply_to_message_id: Integer, reply_markup: KeyboardOption)

<p>As of <a href="https://telegram.org/blog/video-messages-and-telescope">v.4.0</a>, Telegram clients support rounded square mp4 videos of up to 1 minute long. Use this method to send video messages. On success, the sent <a href="#message">Message</a> is returned.</p>

    sendVideoNote(chat_id: IntegerOrString, video_note: InputFileOrString, duration: Integer, length: Integer, thumb: InputFileOrString, disable_notification: Boolean, reply_to_message_id: Integer, reply_markup: KeyboardOption)

<p>Use this method to send a group of photos or videos as an album. On success, an array of the sent <a href="#message">Messages</a> is returned.</p>

    sendMediaGroup(chat_id: IntegerOrString, media: List<InputMediaPhotoOrVideo>, disable_notification: Boolean, reply_to_message_id: Integer)

<p>Use this method to send point on the map. On success, the sent <a href="#message">Message</a> is returned.</p>

    sendLocation(chat_id: IntegerOrString, latitude: Float, longitude: Float, live_period: Integer, disable_notification: Boolean, reply_to_message_id: Integer, reply_markup: KeyboardOption)

<p>Use this method to edit live location messages. A location can be edited until its <em>live_period</em> expires or editing is explicitly disabled by a call to <a href="#stopmessagelivelocation">stopMessageLiveLocation</a>. On success, if the edited message was sent by the bot, the edited <a href="#message">Message</a> is returned, otherwise <em>True</em> is returned.</p>

    editMessageLiveLocation(chat_id: IntegerOrString, message_id: Integer, inline_message_id: String, latitude: Float, longitude: Float, reply_markup: InlineKeyboardMarkup)

<p>Use this method to stop updating a live location message before <em>live_period</em> expires. On success, if the message was sent by the bot, the sent <a href="#message">Message</a> is returned, otherwise <em>True</em> is returned.</p>

    stopMessageLiveLocation(chat_id: IntegerOrString, message_id: Integer, inline_message_id: String, reply_markup: InlineKeyboardMarkup)

<p>Use this method to send information about a venue. On success, the sent <a href="#message">Message</a> is returned.</p>

    sendVenue(chat_id: IntegerOrString, latitude: Float, longitude: Float, title: String, address: String, foursquare_id: String, foursquare_type: String, disable_notification: Boolean, reply_to_message_id: Integer, reply_markup: KeyboardOption)

<p>Use this method to send phone contacts. On success, the sent <a href="#message">Message</a> is returned.</p>

    sendContact(chat_id: IntegerOrString, phone_number: String, first_name: String, last_name: String, vcard: String, disable_notification: Boolean, reply_to_message_id: Integer, reply_markup: KeyboardOption)

<p>Use this method to send a native poll. On success, the sent <a href="#message">Message</a> is returned.</p>

    sendPoll(chat_id: IntegerOrString, question: String, options: List<String>, is_anonymous: Boolean, type: String, allows_multiple_answers: Boolean, correct_option_id: Integer, explanation: String, explanation_parse_mode: String, open_period: Integer, close_date: Integer, is_closed: Boolean, disable_notification: Boolean, reply_to_message_id: Integer, reply_markup: KeyboardOption)

<p>Use this method to send an animated emoji that will display a random value. On success, the sent <a href="#message">Message</a> is returned.</p>

    sendDice(chat_id: IntegerOrString, emoji: String, disable_notification: Boolean, reply_to_message_id: Integer, reply_markup: KeyboardOption)

<p>Use this method when you need to tell the user that something is happening on the bot's side. The status is set for 5 seconds or less (when a message arrives from your bot, Telegram clients clear its typing status). Returns <em>True</em> on success.</p><blockquote> 
 <p>Example: The <a href="https://t.me/imagebot">ImageBot</a> needs some time to process a request and upload the image. Instead of sending a text message along the lines of “Retrieving image, please wait…”, the bot may use <a href="#sendchataction">sendChatAction</a> with <em>action</em> = <em>upload_photo</em>. The user will see a “sending photo” status for the bot.</p> 
</blockquote><p>We only recommend using this method when a response from the bot will take a <strong>noticeable</strong> amount of time to arrive.</p>

    sendChatAction(chat_id: IntegerOrString, action: String)

<p>Use this method to get a list of profile pictures for a user. Returns a <a href="#userprofilephotos">UserProfilePhotos</a> object.</p>

    getUserProfilePhotos(user_id: Integer, offset: Integer, limit: Integer)

<p>Use this method to get basic info about a file and prepare it for downloading. For the moment, bots can download files of up to 20MB in size. On success, a <a href="#file">File</a> object is returned. The file can then be downloaded via the link <code>https://api.telegram.org/file/bot&lt;token&gt;/&lt;file_path&gt;</code>, where <code>&lt;file_path&gt;</code> is taken from the response. It is guaranteed that the link will be valid for at least 1 hour. When the link expires, a new one can be requested by calling <a href="#getfile">getFile</a> again.</p><p><strong>Note:</strong> This function may not preserve the original file name and MIME type. You should save the file's MIME type and name (if available) when the File object is received.</p>

    getFile(file_id: String)

<p>Use this method to kick a user from a group, a supergroup or a channel. In the case of supergroups and channels, the user will not be able to return to the group on their own using invite links, etc., unless <a href="#unbanchatmember">unbanned</a> first. The bot must be an administrator in the chat for this to work and must have the appropriate admin rights. Returns <em>True</em> on success.</p>

    kickChatMember(chat_id: IntegerOrString, user_id: Integer, until_date: Integer)

<p>Use this method to unban a previously kicked user in a supergroup or channel. The user will <strong>not</strong> return to the group or channel automatically, but will be able to join via link, etc. The bot must be an administrator for this to work. Returns <em>True</em> on success.</p>

    unbanChatMember(chat_id: IntegerOrString, user_id: Integer)

<p>Use this method to restrict a user in a supergroup. The bot must be an administrator in the supergroup for this to work and must have the appropriate admin rights. Pass <em>True</em> for all permissions to lift restrictions from a user. Returns <em>True</em> on success.</p>

    restrictChatMember(chat_id: IntegerOrString, user_id: Integer, permissions: ChatPermissions, until_date: Integer)

<p>Use this method to promote or demote a user in a supergroup or a channel. The bot must be an administrator in the chat for this to work and must have the appropriate admin rights. Pass <em>False</em> for all boolean parameters to demote a user. Returns <em>True</em> on success.</p>

    promoteChatMember(chat_id: IntegerOrString, user_id: Integer, can_change_info: Boolean, can_post_messages: Boolean, can_edit_messages: Boolean, can_delete_messages: Boolean, can_invite_users: Boolean, can_restrict_members: Boolean, can_pin_messages: Boolean, can_promote_members: Boolean)

<p>Use this method to set a custom title for an administrator in a supergroup promoted by the bot. Returns <em>True</em> on success.</p>

    setChatAdministratorCustomTitle(chat_id: IntegerOrString, user_id: Integer, custom_title: String)

<p>Use this method to set default chat permissions for all members. The bot must be an administrator in the group or a supergroup for this to work and must have the <em>can_restrict_members</em> admin rights. Returns <em>True</em> on success.</p>

    setChatPermissions(chat_id: IntegerOrString, permissions: ChatPermissions)

<p>Use this method to generate a new invite link for a chat; any previously generated link is revoked. The bot must be an administrator in the chat for this to work and must have the appropriate admin rights. Returns the new invite link as <em>String</em> on success.</p><blockquote> 
 <p>Note: Each administrator in a chat generates their own invite links. Bots can't use invite links generated by other administrators. If you want your bot to work with invite links, it will need to generate its own link using <a href="#exportchatinvitelink">exportChatInviteLink</a> — after this the link will become available to the bot via the <a href="#getchat">getChat</a> method. If your bot needs to generate a new invite link replacing its previous one, use <a href="#exportchatinvitelink">exportChatInviteLink</a> again.</p> 
</blockquote>

    exportChatInviteLink(chat_id: IntegerOrString)

<p>Use this method to set a new profile photo for the chat. Photos can't be changed for private chats. The bot must be an administrator in the chat for this to work and must have the appropriate admin rights. Returns <em>True</em> on success.</p>

    setChatPhoto(chat_id: IntegerOrString, photo: InputFile)

<p>Use this method to delete a chat photo. Photos can't be changed for private chats. The bot must be an administrator in the chat for this to work and must have the appropriate admin rights. Returns <em>True</em> on success.</p>

    deleteChatPhoto(chat_id: IntegerOrString)

<p>Use this method to change the title of a chat. Titles can't be changed for private chats. The bot must be an administrator in the chat for this to work and must have the appropriate admin rights. Returns <em>True</em> on success.</p>

    setChatTitle(chat_id: IntegerOrString, title: String)

<p>Use this method to change the description of a group, a supergroup or a channel. The bot must be an administrator in the chat for this to work and must have the appropriate admin rights. Returns <em>True</em> on success.</p>

    setChatDescription(chat_id: IntegerOrString, description: String)

<p>Use this method to pin a message in a group, a supergroup, or a channel. The bot must be an administrator in the chat for this to work and must have the 'can_pin_messages' admin right in the supergroup or 'can_edit_messages' admin right in the channel. Returns <em>True</em> on success.</p>

    pinChatMessage(chat_id: IntegerOrString, message_id: Integer, disable_notification: Boolean)

<p>Use this method to unpin a message in a group, a supergroup, or a channel. The bot must be an administrator in the chat for this to work and must have the 'can_pin_messages' admin right in the supergroup or 'can_edit_messages' admin right in the channel. Returns <em>True</em> on success.</p>

    unpinChatMessage(chat_id: IntegerOrString)

<p>Use this method for your bot to leave a group, supergroup or channel. Returns <em>True</em> on success.</p>

    leaveChat(chat_id: IntegerOrString)

<p>Use this method to get up to date information about the chat (current name of the user for one-on-one conversations, current username of a user, group or channel, etc.). Returns a <a href="#chat">Chat</a> object on success.</p>

    getChat(chat_id: IntegerOrString)

<p>Use this method to get a list of administrators in a chat. On success, returns an Array of <a href="#chatmember">ChatMember</a> objects that contains information about all chat administrators except other bots. If the chat is a group or a supergroup and no administrators were appointed, only the creator will be returned.</p>

    getChatAdministrators(chat_id: IntegerOrString)

<p>Use this method to get the number of members in a chat. Returns <em>Int</em> on success.</p>

    getChatMembersCount(chat_id: IntegerOrString)

<p>Use this method to get information about a member of a chat. Returns a <a href="#chatmember">ChatMember</a> object on success.</p>

    getChatMember(chat_id: IntegerOrString, user_id: Integer)

<p>Use this method to set a new group sticker set for a supergroup. The bot must be an administrator in the chat for this to work and must have the appropriate admin rights. Use the field <em>can_set_sticker_set</em> optionally returned in <a href="#getchat">getChat</a> requests to check if the bot can use this method. Returns <em>True</em> on success.</p>

    setChatStickerSet(chat_id: IntegerOrString, sticker_set_name: String)

<p>Use this method to delete a group sticker set from a supergroup. The bot must be an administrator in the chat for this to work and must have the appropriate admin rights. Use the field <em>can_set_sticker_set</em> optionally returned in <a href="#getchat">getChat</a> requests to check if the bot can use this method. Returns <em>True</em> on success.</p>

    deleteChatStickerSet(chat_id: IntegerOrString)

<p>Use this method to send answers to callback queries sent from <a href="/bots#inline-keyboards-and-on-the-fly-updating">inline keyboards</a>. The answer will be displayed to the user as a notification at the top of the chat screen or as an alert. On success, <em>True</em> is returned.</p><blockquote> 
 <p>Alternatively, the user can be redirected to the specified Game URL. For this option to work, you must first create a game for your bot via <a href="https://t.me/botfather">@Botfather</a> and accept the terms. Otherwise, you may use links like <code>t.me/your_bot?start=XXXX</code> that open your bot with a parameter.</p> 
</blockquote>

    answerCallbackQuery(callback_query_id: String, text: String, show_alert: Boolean, url: String, cache_time: Integer)

<p>Use this method to change the list of the bot's commands. Returns <em>True</em> on success.</p>

    setMyCommands(commands: List<BotCommand>)

<p>Use this method to get the current list of the bot's commands. Requires no parameters. Returns Array of <a href="#botcommand">BotCommand</a> on success.</p>

    getMyCommands()



## Updating messages

### Methods
<p>Use this method to edit text and <a href="#games">game</a> messages. On success, if edited message is sent by the bot, the edited <a href="#message">Message</a> is returned, otherwise <em>True</em> is returned.</p>

    editMessageText(chat_id: IntegerOrString, message_id: Integer, inline_message_id: String, text: String, parse_mode: ParseMode, disable_web_page_preview: Boolean, reply_markup: InlineKeyboardMarkup)

<p>Use this method to edit captions of messages. On success, if edited message is sent by the bot, the edited <a href="#message">Message</a> is returned, otherwise <em>True</em> is returned.</p>

    editMessageCaption(chat_id: IntegerOrString, message_id: Integer, inline_message_id: String, caption: String, parse_mode: ParseMode, reply_markup: InlineKeyboardMarkup)

<p>Use this method to edit animation, audio, document, photo, or video messages. If a message is a part of a message album, then it can be edited only to a photo or a video. Otherwise, message type can be changed arbitrarily. When inline message is edited, new file can't be uploaded. Use previously uploaded file via its file_id or specify a URL. On success, if the edited message was sent by the bot, the edited <a href="#message">Message</a> is returned, otherwise <em>True</em> is returned.</p>

    editMessageMedia(chat_id: IntegerOrString, message_id: Integer, inline_message_id: String, media: InputMedia, reply_markup: InlineKeyboardMarkup)

<p>Use this method to edit only the reply markup of messages. On success, if edited message is sent by the bot, the edited <a href="#message">Message</a> is returned, otherwise <em>True</em> is returned.</p>

    editMessageReplyMarkup(chat_id: IntegerOrString, message_id: Integer, inline_message_id: String, reply_markup: InlineKeyboardMarkup)

<p>Use this method to stop a poll which was sent by the bot. On success, the stopped <a href="#poll">Poll</a> with the final results is returned.</p>

    stopPoll(chat_id: IntegerOrString, message_id: Integer, reply_markup: InlineKeyboardMarkup)

<p>Use this method to delete a message, including service messages, with the following limitations:<br>- A message can only be deleted if it was sent less than 48 hours ago.<br>- A dice message in a private chat can only be deleted if it was sent more than 24 hours ago.<br>- Bots can delete outgoing messages in private chats, groups, and supergroups.<br>- Bots can delete incoming messages in private chats.<br>- Bots granted <em>can_post_messages</em> permissions can delete outgoing messages in channels.<br>- If the bot is an administrator of a group, it can delete any message there.<br>- If the bot has <em>can_delete_messages</em> permission in a supergroup or a channel, it can delete any message there.<br>Returns <em>True</em> on success.</p>

    deleteMessage(chat_id: IntegerOrString, message_id: Integer)



## Stickers

### Data Types
<p>This object represents a sticker.</p>

    Sticker(file_id: String, file_unique_id: String, width: Integer, height: Integer, is_animated: Boolean, thumb: PhotoSize, emoji: String, set_name: String, mask_position: MaskPosition, file_size: Integer)

<p>This object represents a sticker set.</p>

    StickerSet(name: String, title: String, is_animated: Boolean, contains_masks: Boolean, stickers: List<Sticker>, thumb: PhotoSize)

<p>This object describes the position on faces where a mask should be placed by default.</p>

    MaskPosition(point: String, x_shift: Float, y_shift: Float, scale: Float)


### Methods
<p>Use this method to send static .WEBP or <a href="https://telegram.org/blog/animated-stickers">animated</a> .TGS stickers. On success, the sent <a href="#message">Message</a> is returned.</p>

    sendSticker(chat_id: IntegerOrString, sticker: InputFileOrString, disable_notification: Boolean, reply_to_message_id: Integer, reply_markup: KeyboardOption)

<p>Use this method to get a sticker set. On success, a <a href="#stickerset">StickerSet</a> object is returned.</p>

    getStickerSet(name: String)

<p>Use this method to upload a .PNG file with a sticker for later use in <em>createNewStickerSet</em> and <em>addStickerToSet</em> methods (can be used multiple times). Returns the uploaded <a href="#file">File</a> on success.</p>

    uploadStickerFile(user_id: Integer, png_sticker: InputFile)

<p>Use this method to create a new sticker set owned by a user. The bot will be able to edit the sticker set thus created. You <strong>must</strong> use exactly one of the fields <em>png_sticker</em> or <em>tgs_sticker</em>. Returns <em>True</em> on success.</p>

    createNewStickerSet(user_id: Integer, name: String, title: String, png_sticker: InputFileOrString, tgs_sticker: InputFile, emojis: String, contains_masks: Boolean, mask_position: MaskPosition)

<p>Use this method to add a new sticker to a set created by the bot. You <strong>must</strong> use exactly one of the fields <em>png_sticker</em> or <em>tgs_sticker</em>. Animated stickers can be added to animated sticker sets and only to them. Animated sticker sets can have up to 50 stickers. Static sticker sets can have up to 120 stickers. Returns <em>True</em> on success.</p>

    addStickerToSet(user_id: Integer, name: String, png_sticker: InputFileOrString, tgs_sticker: InputFile, emojis: String, mask_position: MaskPosition)

<p>Use this method to move a sticker in a set created by the bot to a specific position. Returns <em>True</em> on success.</p>

    setStickerPositionInSet(sticker: String, position: Integer)

<p>Use this method to delete a sticker from a set created by the bot. Returns <em>True</em> on success.</p>

    deleteStickerFromSet(sticker: String)

<p>Use this method to set the thumbnail of a sticker set. Animated thumbnails can be set for animated sticker sets only. Returns <em>True</em> on success.</p>

    setStickerSetThumb(name: String, user_id: Integer, thumb: InputFileOrString)



## Inline mode

### Data Types
<p>This object represents an incoming inline query. When the user sends an empty query, your bot could return some default or trending results.</p>

    InlineQuery(id: String, from: User, location: Location, query: String, offset: String)

<p>Represents a link to an article or web page.</p>

    InlineQueryResultArticle(type: String, id: String, title: String, input_message_content: InputMessageContent, reply_markup: InlineKeyboardMarkup, url: String, hide_url: Boolean, description: String, thumb_url: String, thumb_width: Integer, thumb_height: Integer)

<p>Represents a link to a photo. By default, this photo will be sent by the user with optional caption. Alternatively, you can use <em>input_message_content</em> to send a message with the specified content instead of the photo.</p>

    InlineQueryResultPhoto(type: String, id: String, photo_url: String, thumb_url: String, photo_width: Integer, photo_height: Integer, title: String, description: String, caption: String, parse_mode: ParseMode, reply_markup: InlineKeyboardMarkup, input_message_content: InputMessageContent)

<p>Represents a link to an animated GIF file. By default, this animated GIF file will be sent by the user with optional caption. Alternatively, you can use <em>input_message_content</em> to send a message with the specified content instead of the animation.</p>

    InlineQueryResultGif(type: String, id: String, gif_url: String, gif_width: Integer, gif_height: Integer, gif_duration: Integer, thumb_url: String, thumb_mime_type: String, title: String, caption: String, parse_mode: ParseMode, reply_markup: InlineKeyboardMarkup, input_message_content: InputMessageContent)

<p>Represents a link to a video animation (H.264/MPEG-4 AVC video without sound). By default, this animated MPEG-4 file will be sent by the user with optional caption. Alternatively, you can use <em>input_message_content</em> to send a message with the specified content instead of the animation.</p>

    InlineQueryResultMpeg4Gif(type: String, id: String, mpeg4_url: String, mpeg4_width: Integer, mpeg4_height: Integer, mpeg4_duration: Integer, thumb_url: String, thumb_mime_type: String, title: String, caption: String, parse_mode: ParseMode, reply_markup: InlineKeyboardMarkup, input_message_content: InputMessageContent)

<p>Represents a link to a page containing an embedded video player or a video file. By default, this video file will be sent by the user with an optional caption. Alternatively, you can use <em>input_message_content</em> to send a message with the specified content instead of the video.</p><blockquote> 
 <p>If an InlineQueryResultVideo message contains an embedded video (e.g., YouTube), you <strong>must</strong> replace its content using <em>input_message_content</em>.</p> 
</blockquote>

    InlineQueryResultVideo(type: String, id: String, video_url: String, mime_type: String, thumb_url: String, title: String, caption: String, parse_mode: ParseMode, video_width: Integer, video_height: Integer, video_duration: Integer, description: String, reply_markup: InlineKeyboardMarkup, input_message_content: InputMessageContent)

<p>Represents a link to an MP3 audio file. By default, this audio file will be sent by the user. Alternatively, you can use <em>input_message_content</em> to send a message with the specified content instead of the audio.</p><p><strong>Note:</strong> This will only work in Telegram versions released after 9 April, 2016. Older clients will ignore them.</p>

    InlineQueryResultAudio(type: String, id: String, audio_url: String, title: String, caption: String, parse_mode: ParseMode, performer: String, audio_duration: Integer, reply_markup: InlineKeyboardMarkup, input_message_content: InputMessageContent)

<p>Represents a link to a voice recording in an .OGG container encoded with OPUS. By default, this voice recording will be sent by the user. Alternatively, you can use <em>input_message_content</em> to send a message with the specified content instead of the the voice message.</p><p><strong>Note:</strong> This will only work in Telegram versions released after 9 April, 2016. Older clients will ignore them.</p>

    InlineQueryResultVoice(type: String, id: String, voice_url: String, title: String, caption: String, parse_mode: ParseMode, voice_duration: Integer, reply_markup: InlineKeyboardMarkup, input_message_content: InputMessageContent)

<p>Represents a link to a file. By default, this file will be sent by the user with an optional caption. Alternatively, you can use <em>input_message_content</em> to send a message with the specified content instead of the file. Currently, only <strong>.PDF</strong> and <strong>.ZIP</strong> files can be sent using this method.</p><p><strong>Note:</strong> This will only work in Telegram versions released after 9 April, 2016. Older clients will ignore them.</p>

    InlineQueryResultDocument(type: String, id: String, title: String, caption: String, parse_mode: ParseMode, document_url: String, mime_type: String, description: String, reply_markup: InlineKeyboardMarkup, input_message_content: InputMessageContent, thumb_url: String, thumb_width: Integer, thumb_height: Integer)

<p>Represents a location on a map. By default, the location will be sent by the user. Alternatively, you can use <em>input_message_content</em> to send a message with the specified content instead of the location.</p><p><strong>Note:</strong> This will only work in Telegram versions released after 9 April, 2016. Older clients will ignore them.</p>

    InlineQueryResultLocation(type: String, id: String, latitude: Float, longitude: Float, title: String, live_period: Integer, reply_markup: InlineKeyboardMarkup, input_message_content: InputMessageContent, thumb_url: String, thumb_width: Integer, thumb_height: Integer)

<p>Represents a venue. By default, the venue will be sent by the user. Alternatively, you can use <em>input_message_content</em> to send a message with the specified content instead of the venue.</p><p><strong>Note:</strong> This will only work in Telegram versions released after 9 April, 2016. Older clients will ignore them.</p>

    InlineQueryResultVenue(type: String, id: String, latitude: Float, longitude: Float, title: String, address: String, foursquare_id: String, foursquare_type: String, reply_markup: InlineKeyboardMarkup, input_message_content: InputMessageContent, thumb_url: String, thumb_width: Integer, thumb_height: Integer)

<p>Represents a contact with a phone number. By default, this contact will be sent by the user. Alternatively, you can use <em>input_message_content</em> to send a message with the specified content instead of the contact.</p><p><strong>Note:</strong> This will only work in Telegram versions released after 9 April, 2016. Older clients will ignore them.</p>

    InlineQueryResultContact(type: String, id: String, phone_number: String, first_name: String, last_name: String, vcard: String, reply_markup: InlineKeyboardMarkup, input_message_content: InputMessageContent, thumb_url: String, thumb_width: Integer, thumb_height: Integer)

<p>Represents a <a href="#games">Game</a>.</p><p><strong>Note:</strong> This will only work in Telegram versions released after October 1, 2016. Older clients will not display any inline results if a game result is among them.</p>

    InlineQueryResultGame(type: String, id: String, game_short_name: String, reply_markup: InlineKeyboardMarkup)

<p>Represents a link to a photo stored on the Telegram servers. By default, this photo will be sent by the user with an optional caption. Alternatively, you can use <em>input_message_content</em> to send a message with the specified content instead of the photo.</p>

    InlineQueryResultCachedPhoto(type: String, id: String, photo_file_id: String, title: String, description: String, caption: String, parse_mode: ParseMode, reply_markup: InlineKeyboardMarkup, input_message_content: InputMessageContent)

<p>Represents a link to an animated GIF file stored on the Telegram servers. By default, this animated GIF file will be sent by the user with an optional caption. Alternatively, you can use <em>input_message_content</em> to send a message with specified content instead of the animation.</p>

    InlineQueryResultCachedGif(type: String, id: String, gif_file_id: String, title: String, caption: String, parse_mode: ParseMode, reply_markup: InlineKeyboardMarkup, input_message_content: InputMessageContent)

<p>Represents a link to a video animation (H.264/MPEG-4 AVC video without sound) stored on the Telegram servers. By default, this animated MPEG-4 file will be sent by the user with an optional caption. Alternatively, you can use <em>input_message_content</em> to send a message with the specified content instead of the animation.</p>

    InlineQueryResultCachedMpeg4Gif(type: String, id: String, mpeg4_file_id: String, title: String, caption: String, parse_mode: ParseMode, reply_markup: InlineKeyboardMarkup, input_message_content: InputMessageContent)

<p>Represents a link to a sticker stored on the Telegram servers. By default, this sticker will be sent by the user. Alternatively, you can use <em>input_message_content</em> to send a message with the specified content instead of the sticker.</p><p><strong>Note:</strong> This will only work in Telegram versions released after 9 April, 2016 for static stickers and after 06 July, 2019 for <a href="https://telegram.org/blog/animated-stickers">animated stickers</a>. Older clients will ignore them.</p>

    InlineQueryResultCachedSticker(type: String, id: String, sticker_file_id: String, reply_markup: InlineKeyboardMarkup, input_message_content: InputMessageContent)

<p>Represents a link to a file stored on the Telegram servers. By default, this file will be sent by the user with an optional caption. Alternatively, you can use <em>input_message_content</em> to send a message with the specified content instead of the file.</p><p><strong>Note:</strong> This will only work in Telegram versions released after 9 April, 2016. Older clients will ignore them.</p>

    InlineQueryResultCachedDocument(type: String, id: String, title: String, document_file_id: String, description: String, caption: String, parse_mode: ParseMode, reply_markup: InlineKeyboardMarkup, input_message_content: InputMessageContent)

<p>Represents a link to a video file stored on the Telegram servers. By default, this video file will be sent by the user with an optional caption. Alternatively, you can use <em>input_message_content</em> to send a message with the specified content instead of the video.</p>

    InlineQueryResultCachedVideo(type: String, id: String, video_file_id: String, title: String, description: String, caption: String, parse_mode: ParseMode, reply_markup: InlineKeyboardMarkup, input_message_content: InputMessageContent)

<p>Represents a link to a voice message stored on the Telegram servers. By default, this voice message will be sent by the user. Alternatively, you can use <em>input_message_content</em> to send a message with the specified content instead of the voice message.</p><p><strong>Note:</strong> This will only work in Telegram versions released after 9 April, 2016. Older clients will ignore them.</p>

    InlineQueryResultCachedVoice(type: String, id: String, voice_file_id: String, title: String, caption: String, parse_mode: ParseMode, reply_markup: InlineKeyboardMarkup, input_message_content: InputMessageContent)

<p>Represents a link to an MP3 audio file stored on the Telegram servers. By default, this audio file will be sent by the user. Alternatively, you can use <em>input_message_content</em> to send a message with the specified content instead of the audio.</p><p><strong>Note:</strong> This will only work in Telegram versions released after 9 April, 2016. Older clients will ignore them.</p>

    InlineQueryResultCachedAudio(type: String, id: String, audio_file_id: String, caption: String, parse_mode: ParseMode, reply_markup: InlineKeyboardMarkup, input_message_content: InputMessageContent)

<p>Represents the <a href="#inputmessagecontent">content</a> of a text message to be sent as the result of an inline query.</p>

    InputTextMessageContent(message_text: String, parse_mode: ParseMode, disable_web_page_preview: Boolean)

<p>Represents the <a href="#inputmessagecontent">content</a> of a location message to be sent as the result of an inline query.</p>

    InputLocationMessageContent(latitude: Float, longitude: Float, live_period: Integer)

<p>Represents the <a href="#inputmessagecontent">content</a> of a venue message to be sent as the result of an inline query.</p>

    InputVenueMessageContent(latitude: Float, longitude: Float, title: String, address: String, foursquare_id: String, foursquare_type: String)

<p>Represents the <a href="#inputmessagecontent">content</a> of a contact message to be sent as the result of an inline query.</p>

    InputContactMessageContent(phone_number: String, first_name: String, last_name: String, vcard: String)

<p>Represents a <a href="#inlinequeryresult">result</a> of an inline query that was chosen by the user and sent to their chat partner.</p><p><strong>Note:</strong> It is necessary to enable <a href="/bots/inline#collecting-feedback">inline feedback</a> via <a href="https://t.me/botfather">@Botfather</a> in order to receive these objects in updates.</p>

    ChosenInlineResult(result_id: String, from: User, location: Location, inline_message_id: String, query: String)


### Methods
<p>Use this method to send answers to an inline query. On success, <em>True</em> is returned.<br>No more than <strong>50</strong> results per query are allowed.</p>

    answerInlineQuery(inline_query_id: String, results: List<InlineQueryResult>, cache_time: Integer, is_personal: Boolean, next_offset: String, switch_pm_text: String, switch_pm_parameter: String)



## Payments

### Data Types
<p>This object represents a portion of the price for goods or services.</p>

    LabeledPrice(label: String, amount: Integer)

<p>This object contains basic information about an invoice.</p>

    Invoice(title: String, description: String, start_parameter: String, currency: String, total_amount: Integer)

<p>This object represents a shipping address.</p>

    ShippingAddress(country_code: String, state: String, city: String, street_line1: String, street_line2: String, post_code: String)

<p>This object represents information about an order.</p>

    OrderInfo(name: String, phone_number: String, email: String, shipping_address: ShippingAddress)

<p>This object represents one shipping option.</p>

    ShippingOption(id: String, title: String, prices: List<LabeledPrice>)

<p>This object contains basic information about a successful payment.</p>

    SuccessfulPayment(currency: String, total_amount: Integer, invoice_payload: String, shipping_option_id: String, order_info: OrderInfo, telegram_payment_charge_id: String, provider_payment_charge_id: String)

<p>This object contains information about an incoming shipping query.</p>

    ShippingQuery(id: String, from: User, invoice_payload: String, shipping_address: ShippingAddress)

<p>This object contains information about an incoming pre-checkout query.</p>

    PreCheckoutQuery(id: String, from: User, currency: String, total_amount: Integer, invoice_payload: String, shipping_option_id: String, order_info: OrderInfo)


### Methods
<p>Use this method to send invoices. On success, the sent <a href="#message">Message</a> is returned.</p>

    sendInvoice(chat_id: Integer, title: String, description: String, payload: String, provider_token: String, start_parameter: String, currency: String, prices: List<LabeledPrice>, provider_data: String, photo_url: String, photo_size: Integer, photo_width: Integer, photo_height: Integer, need_name: Boolean, need_phone_number: Boolean, need_email: Boolean, need_shipping_address: Boolean, send_phone_number_to_provider: Boolean, send_email_to_provider: Boolean, is_flexible: Boolean, disable_notification: Boolean, reply_to_message_id: Integer, reply_markup: InlineKeyboardMarkup)

<p>If you sent an invoice requesting a shipping address and the parameter <em>is_flexible</em> was specified, the Bot API will send an <a href="#update">Update</a> with a <em>shipping_query</em> field to the bot. Use this method to reply to shipping queries. On success, True is returned.</p>

    answerShippingQuery(shipping_query_id: String, ok: Boolean, shipping_options: List<ShippingOption>, error_message: String)

<p>Once the user has confirmed their payment and shipping details, the Bot API sends the final confirmation in the form of an <a href="#update">Update</a> with the field <em>pre_checkout_query</em>. Use this method to respond to such pre-checkout queries. On success, True is returned. <strong>Note:</strong> The Bot API must receive an answer within 10 seconds after the pre-checkout query was sent.</p>

    answerPreCheckoutQuery(pre_checkout_query_id: String, ok: Boolean, error_message: String)



## Telegram Passport

### Data Types
<p>Contains information about Telegram Passport data shared with the bot by the user.</p>

    PassportData(data: List<EncryptedPassportElement>, credentials: EncryptedCredentials)

<p>This object represents a file uploaded to Telegram Passport. Currently all Telegram Passport files are in JPEG format when decrypted and don't exceed 10MB.</p>

    PassportFile(file_id: String, file_unique_id: String, file_size: Integer, file_date: Integer)

<p>Contains information about documents or other Telegram Passport elements shared with the bot by the user.</p>

    EncryptedPassportElement(type: String, data: String, phone_number: String, email: String, files: List<PassportFile>, front_side: PassportFile, reverse_side: PassportFile, selfie: PassportFile, translation: List<PassportFile>, hash: String)

<p>Contains data required for decrypting and authenticating <a href="#encryptedpassportelement">EncryptedPassportElement</a>. See the <a href="https://core.telegram.org/passport#receiving-information">Telegram Passport Documentation</a> for a complete description of the data decryption and authentication processes.</p>

    EncryptedCredentials(data: String, hash: String, secret: String)

<p>Represents an issue in one of the data fields that was provided by the user. The error is considered resolved when the field's value changes.</p>

    PassportElementErrorDataField(source: String, type: String, field_name: String, data_hash: String, message: String)

<p>Represents an issue with the front side of a document. The error is considered resolved when the file with the front side of the document changes.</p>

    PassportElementErrorFrontSide(source: String, type: String, file_hash: String, message: String)

<p>Represents an issue with the reverse side of a document. The error is considered resolved when the file with reverse side of the document changes.</p>

    PassportElementErrorReverseSide(source: String, type: String, file_hash: String, message: String)

<p>Represents an issue with the selfie with a document. The error is considered resolved when the file with the selfie changes.</p>

    PassportElementErrorSelfie(source: String, type: String, file_hash: String, message: String)

<p>Represents an issue with a document scan. The error is considered resolved when the file with the document scan changes.</p>

    PassportElementErrorFile(source: String, type: String, file_hash: String, message: String)

<p>Represents an issue with a list of scans. The error is considered resolved when the list of files containing the scans changes.</p>

    PassportElementErrorFiles(source: String, type: String, file_hashes: List<String>, message: String)

<p>Represents an issue with one of the files that constitute the translation of a document. The error is considered resolved when the file changes.</p>

    PassportElementErrorTranslationFile(source: String, type: String, file_hash: String, message: String)

<p>Represents an issue with the translated version of a document. The error is considered resolved when a file with the document translation change.</p>

    PassportElementErrorTranslationFiles(source: String, type: String, file_hashes: List<String>, message: String)

<p>Represents an issue in an unspecified place. The error is considered resolved when new data is added.</p>

    PassportElementErrorUnspecified(source: String, type: String, element_hash: String, message: String)


### Methods
<p>Informs a user that some of the Telegram Passport elements they provided contains errors. The user will not be able to re-submit their Passport to you until the errors are fixed (the contents of the field for which you returned the error must change). Returns <em>True</em> on success.</p><p>Use this if the data submitted by the user doesn't satisfy the standards your service requires for any reason. For example, if a birthday date seems invalid, a submitted document is blurry, a scan shows evidence of tampering, etc. Supply some details in the error message to make sure the user knows how to correct the issues.</p>

    setPassportDataErrors(user_id: Integer, errors: List<PassportElementError>)



## Games

### Data Types
<p>This object represents a game. Use BotFather to create and edit games, their short names will act as unique identifiers.</p>

    Game(title: String, description: String, photo: List<PhotoSize>, text: String, text_entities: List<MessageEntity>, animation: Animation)

<p>This object represents one row of the high scores table for a game.</p><p>And that's about all we've got for now.<br>If you've got any questions, please check out our <a href="/bots/faq"><strong>Bot FAQ »</strong></a></p>

    GameHighScore(position: Integer, user: User, score: Integer)


### Methods
<p>Use this method to send a game. On success, the sent <a href="#message">Message</a> is returned.</p>

    sendGame(chat_id: Integer, game_short_name: String, disable_notification: Boolean, reply_to_message_id: Integer, reply_markup: InlineKeyboardMarkup)

<p>Use this method to set the score of the specified user in a game. On success, if the message was sent by the bot, returns the edited <a href="#message">Message</a>, otherwise returns <em>True</em>. Returns an error, if the new score is not greater than the user's current score in the chat and <em>force</em> is <em>False</em>.</p>

    setGameScore(user_id: Integer, score: Integer, force: Boolean, disable_edit_message: Boolean, chat_id: Integer, message_id: Integer, inline_message_id: String)

<p>Use this method to get data for high score tables. Will return the score of the specified user and several of their neighbors in a game. On success, returns an <em>Array</em> of <a href="#gamehighscore">GameHighScore</a> objects.</p><blockquote> 
 <p>This method will currently return scores for the target user, plus two of their closest neighbors on each side. Will also return the top three users if the user and his neighbors are not among them. Please note that this behavior is subject to change.</p> 
</blockquote>

    getGameHighScores(user_id: Integer, chat_id: Integer, message_id: Integer, inline_message_id: String)

