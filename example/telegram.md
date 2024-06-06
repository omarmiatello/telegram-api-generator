

## Getting updates

### Data Types
<p>This <a href="#available-types">object</a> represents an incoming update.<br>At most <strong>one</strong> of the optional parameters can be present in any given update.</p>

    Update(update_id: Integer, message: Message, edited_message: Message, channel_post: Message, edited_channel_post: Message, business_connection: BusinessConnection, business_message: Message, edited_business_message: Message, deleted_business_messages: BusinessMessagesDeleted, message_reaction: MessageReactionUpdated, message_reaction_count: MessageReactionCountUpdated, inline_query: InlineQuery, chosen_inline_result: ChosenInlineResult, callback_query: CallbackQuery, shipping_query: ShippingQuery, pre_checkout_query: PreCheckoutQuery, poll: Poll, poll_answer: PollAnswer, my_chat_member: ChatMemberUpdated, chat_member: ChatMemberUpdated, chat_join_request: ChatJoinRequest, chat_boost: ChatBoostUpdated, removed_chat_boost: ChatBoostRemoved)

<p>Describes the current status of a webhook.</p>

    WebhookInfo(url: String, has_custom_certificate: Boolean, pending_update_count: Integer, ip_address: String, last_error_date: Integer, last_error_message: String, last_synchronization_error_date: Integer, max_connections: Integer, allowed_updates: List<String>)


### Methods
<p>Use this method to receive incoming updates using long polling (<a href="https://en.wikipedia.org/wiki/Push_technology#Long_polling">wiki</a>). Returns an Array of <a href="#update">Update</a> objects.</p><blockquote>
 <p><strong>Notes</strong><br><strong>1.</strong> This method will not work if an outgoing webhook is set up.<br><strong>2.</strong> In order to avoid getting duplicate updates, recalculate <em>offset</em> after each server response.</p>
</blockquote>

    getUpdates(offset: Integer, limit: Integer, timeout: Integer, allowed_updates: List<String>)

<p>Use this method to specify a URL and receive incoming updates via an outgoing webhook. Whenever there is an update for the bot, we will send an HTTPS POST request to the specified URL, containing a JSON-serialized <a href="#update">Update</a>. In case of an unsuccessful request, we will give up after a reasonable amount of attempts. Returns <em>True</em> on success.</p><p>If you'd like to make sure that the webhook was set by you, you can specify secret data in the parameter <em>secret_token</em>. If specified, the request will contain a header “X-Telegram-Bot-Api-Secret-Token” with the secret token as content.</p><blockquote>
 <p><strong>Notes</strong><br><strong>1.</strong> You will not be able to receive updates using <a href="#getupdates">getUpdates</a> for as long as an outgoing webhook is set up.<br><strong>2.</strong> To use a self-signed certificate, you need to upload your <a href="/bots/self-signed">public key certificate</a> using <em>certificate</em> parameter. Please upload as InputFile, sending a String will not work.<br><strong>3.</strong> Ports currently supported <em>for webhooks</em>: <strong>443, 80, 88, 8443</strong>.</p>
 <p>If you're having any trouble setting up webhooks, please check out this <a href="/bots/webhooks">amazing guide to webhooks</a>.</p>
</blockquote>

    setWebhook(url: String, certificate: InputFile, ip_address: String, max_connections: Integer, allowed_updates: List<String>, drop_pending_updates: Boolean, secret_token: String, invalid_user_url: String)

<p>Use this method to remove webhook integration if you decide to switch back to <a href="#getupdates">getUpdates</a>. Returns <em>True</em> on success.</p>

    deleteWebhook(drop_pending_updates: Boolean)

<p>Use this method to get current webhook status. Requires no parameters. On success, returns a <a href="#webhookinfo">WebhookInfo</a> object. If the bot is using <a href="#getupdates">getUpdates</a>, will return an object with the <em>url</em> field empty.</p>

    getWebhookInfo()



## Available types

### Data Types
<p>This object represents a Telegram user or bot.</p>

    User(id: Integer, is_bot: Boolean, first_name: String, last_name: String, username: String, language_code: String, is_premium: Boolean, added_to_attachment_menu: Boolean, can_join_groups: Boolean, can_read_all_group_messages: Boolean, supports_inline_queries: Boolean, can_connect_to_business: Boolean)

<p>This object represents a chat.</p>

    Chat(id: Integer, type: String, title: String, username: String, first_name: String, last_name: String, is_forum: Boolean)

<p>This object contains full information about a chat.</p>

    ChatFullInfo(id: Integer, type: String, title: String, username: String, first_name: String, last_name: String, is_forum: Boolean, accent_color_id: Integer, max_reaction_count: Integer, photo: ChatPhoto, active_usernames: List<String>, birthdate: Birthdate, business_intro: BusinessIntro, business_location: BusinessLocation, business_opening_hours: BusinessOpeningHours, personal_chat: Chat, available_reactions: List<ReactionType>, background_custom_emoji_id: String, profile_accent_color_id: Integer, profile_background_custom_emoji_id: String, emoji_status_custom_emoji_id: String, emoji_status_expiration_date: Integer, bio: String, has_private_forwards: Boolean, has_restricted_voice_and_video_messages: Boolean, join_to_send_messages: Boolean, join_by_request: Boolean, description: String, invite_link: String, pinned_message: Message, permissions: ChatPermissions, slow_mode_delay: Integer, unrestrict_boost_count: Integer, message_auto_delete_time: Integer, has_aggressive_anti_spam_enabled: Boolean, has_hidden_members: Boolean, has_protected_content: Boolean, has_visible_history: Boolean, sticker_set_name: String, can_set_sticker_set: Boolean, custom_emoji_sticker_set_name: String, linked_chat_id: Integer, location: ChatLocation)

<p>This object represents a message.</p>

    Message(message_id: Integer, message_thread_id: Integer, from: User, sender_chat: Chat, sender_boost_count: Integer, sender_business_bot: User, date: Integer, business_connection_id: String, chat: Chat, forward_origin: MessageOrigin, is_topic_message: Boolean, is_automatic_forward: Boolean, reply_to_message: Message, external_reply: ExternalReplyInfo, quote: TextQuote, reply_to_story: Story, via_bot: User, edit_date: Integer, has_protected_content: Boolean, is_from_offline: Boolean, media_group_id: String, author_signature: String, text: String, entities: List<MessageEntity>, link_preview_options: LinkPreviewOptions, effect_id: String, animation: Animation, audio: Audio, document: Document, photo: List<PhotoSize>, sticker: Sticker, story: Story, video: Video, video_note: VideoNote, voice: Voice, caption: String, caption_entities: List<MessageEntity>, show_caption_above_media: Boolean, has_media_spoiler: Boolean, contact: Contact, dice: Dice, game: Game, poll: Poll, venue: Venue, location: Location, new_chat_members: List<User>, left_chat_member: User, new_chat_title: String, new_chat_photo: List<PhotoSize>, delete_chat_photo: Boolean, group_chat_created: Boolean, supergroup_chat_created: Boolean, channel_chat_created: Boolean, message_auto_delete_timer_changed: MessageAutoDeleteTimerChanged, migrate_to_chat_id: Integer, migrate_from_chat_id: Integer, pinned_message: MaybeInaccessibleMessage, invoice: Invoice, successful_payment: SuccessfulPayment, users_shared: UsersShared, chat_shared: ChatShared, connected_website: String, write_access_allowed: WriteAccessAllowed, passport_data: PassportData, proximity_alert_triggered: ProximityAlertTriggered, boost_added: ChatBoostAdded, chat_background_set: ChatBackground, forum_topic_created: ForumTopicCreated, forum_topic_edited: ForumTopicEdited, forum_topic_closed: ForumTopicClosed, forum_topic_reopened: ForumTopicReopened, general_forum_topic_hidden: GeneralForumTopicHidden, general_forum_topic_unhidden: GeneralForumTopicUnhidden, giveaway_created: GiveawayCreated, giveaway: Giveaway, giveaway_winners: GiveawayWinners, giveaway_completed: GiveawayCompleted, video_chat_scheduled: VideoChatScheduled, video_chat_started: VideoChatStarted, video_chat_ended: VideoChatEnded, video_chat_participants_invited: VideoChatParticipantsInvited, web_app_data: WebAppData, reply_markup: InlineKeyboardMarkup)

<p>This object represents a unique message identifier.</p>

    MessageId(message_id: Integer)

<p>This object describes a message that was deleted or is otherwise inaccessible to the bot.</p>

    InaccessibleMessage(chat: Chat, message_id: Integer, date: Integer)

<p>This object represents one special entity in a text message. For example, hashtags, usernames, URLs, etc.</p>

    MessageEntity(type: String, offset: Integer, length: Integer, url: String, user: User, language: String, custom_emoji_id: String)

<p>This object contains information about the quoted part of a message that is replied to by the given message.</p>

    TextQuote(text: String, entities: List<MessageEntity>, position: Integer, is_manual: Boolean)

<p>This object contains information about a message that is being replied to, which may come from another chat or forum topic.</p>

    ExternalReplyInfo(origin: MessageOrigin, chat: Chat, message_id: Integer, link_preview_options: LinkPreviewOptions, animation: Animation, audio: Audio, document: Document, photo: List<PhotoSize>, sticker: Sticker, story: Story, video: Video, video_note: VideoNote, voice: Voice, has_media_spoiler: Boolean, contact: Contact, dice: Dice, game: Game, giveaway: Giveaway, giveaway_winners: GiveawayWinners, invoice: Invoice, location: Location, poll: Poll, venue: Venue)

<p>Describes reply parameters for the message that is being sent.</p>

    ReplyParameters(message_id: Integer, chat_id: IntegerOrString, allow_sending_without_reply: Boolean, quote: String, quote_parse_mode: String, quote_entities: List<MessageEntity>, quote_position: Integer)

<p>The message was originally sent by a known user.</p>

    MessageOriginUser(type: String, date: Integer, sender_user: User)

<p>The message was originally sent by an unknown user.</p>

    MessageOriginHiddenUser(type: String, date: Integer, sender_user_name: String)

<p>The message was originally sent on behalf of a chat to a group chat.</p>

    MessageOriginChat(type: String, date: Integer, sender_chat: Chat, author_signature: String)

<p>The message was originally sent to a channel chat.</p>

    MessageOriginChannel(type: String, date: Integer, chat: Chat, message_id: Integer, author_signature: String)

<p>This object represents one size of a photo or a <a href="#document">file</a> / <a href="#sticker">sticker</a> thumbnail.</p>

    PhotoSize(file_id: String, file_unique_id: String, width: Integer, height: Integer, file_size: Integer)

<p>This object represents an animation file (GIF or H.264/MPEG-4 AVC video without sound).</p>

    Animation(file_id: String, file_unique_id: String, width: Integer, height: Integer, duration: Integer, thumbnail: PhotoSize, file_name: String, mime_type: String, file_size: Integer)

<p>This object represents an audio file to be treated as music by the Telegram clients.</p>

    Audio(file_id: String, file_unique_id: String, duration: Integer, performer: String, title: String, file_name: String, mime_type: String, file_size: Integer, thumbnail: PhotoSize)

<p>This object represents a general file (as opposed to <a href="#photosize">photos</a>, <a href="#voice">voice messages</a> and <a href="#audio">audio files</a>).</p>

    Document(file_id: String, file_unique_id: String, thumbnail: PhotoSize, file_name: String, mime_type: String, file_size: Integer)

<p>This object represents a story.</p>

    Story(chat: Chat, id: Integer)

<p>This object represents a video file.</p>

    Video(file_id: String, file_unique_id: String, width: Integer, height: Integer, duration: Integer, thumbnail: PhotoSize, file_name: String, mime_type: String, file_size: Integer)

<p>This object represents a <a href="https://telegram.org/blog/video-messages-and-telescope">video message</a> (available in Telegram apps as of <a href="https://telegram.org/blog/video-messages-and-telescope">v.4.0</a>).</p>

    VideoNote(file_id: String, file_unique_id: String, length: Integer, duration: Integer, thumbnail: PhotoSize, file_size: Integer)

<p>This object represents a voice note.</p>

    Voice(file_id: String, file_unique_id: String, duration: Integer, mime_type: String, file_size: Integer)

<p>This object represents a phone contact.</p>

    Contact(phone_number: String, first_name: String, last_name: String, user_id: Integer, vcard: String)

<p>This object represents an animated emoji that displays a random value.</p>

    Dice(emoji: String, value: Integer)

<p>This object contains information about one answer option in a poll.</p>

    PollOption(text: String, text_entities: List<MessageEntity>, voter_count: Integer)

<p>This object contains information about one answer option in a poll to send.</p>

    InputPollOption(text: String, text_parse_mode: String, text_entities: List<MessageEntity>)

<p>This object represents an answer of a user in a non-anonymous poll.</p>

    PollAnswer(poll_id: String, voter_chat: Chat, user: User, option_ids: List<Integer>)

<p>This object contains information about a poll.</p>

    Poll(id: String, question: String, question_entities: List<MessageEntity>, options: List<PollOption>, total_voter_count: Integer, is_closed: Boolean, is_anonymous: Boolean, type: String, allows_multiple_answers: Boolean, correct_option_id: Integer, explanation: String, explanation_entities: List<MessageEntity>, open_period: Integer, close_date: Integer)

<p>This object represents a point on the map.</p>

    Location(latitude: Float, longitude: Float, horizontal_accuracy: Float, live_period: Integer, heading: Integer, proximity_alert_radius: Integer)

<p>This object represents a venue.</p>

    Venue(location: Location, title: String, address: String, foursquare_id: String, foursquare_type: String, google_place_id: String, google_place_type: String)

<p>Describes data sent from a <a href="/bots/webapps">Web App</a> to the bot.</p>

    WebAppData(data: String, button_text: String)

<p>This object represents the content of a service message, sent whenever a user in the chat triggers a proximity alert set by another user.</p>

    ProximityAlertTriggered(traveler: User, watcher: User, distance: Integer)

<p>This object represents a service message about a change in auto-delete timer settings.</p>

    MessageAutoDeleteTimerChanged(message_auto_delete_time: Integer)

<p>This object represents a service message about a user boosting a chat.</p>

    ChatBoostAdded(boost_count: Integer)

<p>The background is filled using the selected color.</p>

    BackgroundFillSolid(type: String, color: Integer)

<p>The background is a gradient fill.</p>

    BackgroundFillGradient(type: String, top_color: Integer, bottom_color: Integer, rotation_angle: Integer)

<p>The background is a freeform gradient that rotates after every message in the chat.</p>

    BackgroundFillFreeformGradient(type: String, colors: List<Integer>)

<p>The background is automatically filled based on the selected colors.</p>

    BackgroundTypeFill(type: String, fill: BackgroundFill, dark_theme_dimming: Integer)

<p>The background is a wallpaper in the JPEG format.</p>

    BackgroundTypeWallpaper(type: String, document: Document, dark_theme_dimming: Integer, is_blurred: Boolean, is_moving: Boolean)

<p>The background is a PNG or TGV (gzipped subset of SVG with MIME type “application/x-tgwallpattern”) pattern to be combined with the background fill chosen by the user.</p>

    BackgroundTypePattern(type: String, document: Document, fill: BackgroundFill, intensity: Integer, is_inverted: Boolean, is_moving: Boolean)

<p>The background is taken directly from a built-in chat theme.</p>

    BackgroundTypeChatTheme(type: String, theme_name: String)

<p>This object represents a chat background.</p>

    ChatBackground(type: BackgroundType)

<p>This object represents a service message about a new forum topic created in the chat.</p>

    ForumTopicCreated(name: String, icon_color: Integer, icon_custom_emoji_id: String)

<p>This object represents a service message about an edited forum topic.</p>

    ForumTopicEdited(name: String, icon_custom_emoji_id: String)

<p>This object contains information about a user that was shared with the bot using a <a href="#keyboardbuttonrequestusers">KeyboardButtonRequestUsers</a> button.</p>

    SharedUser(user_id: Integer, first_name: String, last_name: String, username: String, photo: List<PhotoSize>)

<p>This object contains information about the users whose identifiers were shared with the bot using a <a href="#keyboardbuttonrequestusers">KeyboardButtonRequestUsers</a> button.</p>

    UsersShared(request_id: Integer, users: List<SharedUser>)

<p>This object contains information about a chat that was shared with the bot using a <a href="#keyboardbuttonrequestchat">KeyboardButtonRequestChat</a> button.</p>

    ChatShared(request_id: Integer, chat_id: Integer, title: String, username: String, photo: List<PhotoSize>)

<p>This object represents a service message about a user allowing a bot to write messages after adding it to the attachment menu, launching a Web App from a link, or accepting an explicit request from a Web App sent by the method <a href="/bots/webapps#initializing-mini-apps">requestWriteAccess</a>.</p>

    WriteAccessAllowed(from_request: Boolean, web_app_name: String, from_attachment_menu: Boolean)

<p>This object represents a service message about a video chat scheduled in the chat.</p>

    VideoChatScheduled(start_date: Integer)

<p>This object represents a service message about a video chat ended in the chat.</p>

    VideoChatEnded(duration: Integer)

<p>This object represents a service message about new members invited to a video chat.</p>

    VideoChatParticipantsInvited(users: List<User>)

<p>This object represents a message about a scheduled giveaway.</p>

    Giveaway(chats: List<Chat>, winners_selection_date: Integer, winner_count: Integer, only_new_members: Boolean, has_public_winners: Boolean, prize_description: String, country_codes: List<String>, premium_subscription_month_count: Integer)

<p>This object represents a message about the completion of a giveaway with public winners.</p>

    GiveawayWinners(chat: Chat, giveaway_message_id: Integer, winners_selection_date: Integer, winner_count: Integer, winners: List<User>, additional_chat_count: Integer, premium_subscription_month_count: Integer, unclaimed_prize_count: Integer, only_new_members: Boolean, was_refunded: Boolean, prize_description: String)

<p>This object represents a service message about the completion of a giveaway without public winners.</p>

    GiveawayCompleted(winner_count: Integer, unclaimed_prize_count: Integer, giveaway_message: Message)

<p>Describes the options used for link preview generation.</p>

    LinkPreviewOptions(is_disabled: Boolean, url: String, prefer_small_media: Boolean, prefer_large_media: Boolean, show_above_text: Boolean)

<p>This object represent a user's profile pictures.</p>

    UserProfilePhotos(total_count: Integer, photos: List<List<PhotoSize>>)

<p>This object represents a file ready to be downloaded. The file can be downloaded via the link <code>https://api.telegram.org/file/bot&lt;token&gt;/&lt;file_path&gt;</code>. It is guaranteed that the link will be valid for at least 1 hour. When the link expires, a new one can be requested by calling <a href="#getfile">getFile</a>.</p><blockquote>
 <p>The maximum file size to download is 20 MB</p>
</blockquote>

    File(file_id: String, file_unique_id: String, file_size: Integer, file_path: String)

<p>Describes a <a href="/bots/webapps">Web App</a>.</p>

    WebAppInfo(url: String)

<p>This object represents a <a href="/bots/features#keyboards">custom keyboard</a> with reply options (see <a href="/bots/features#keyboards">Introduction to bots</a> for details and examples). Not supported in channels and for messages sent on behalf of a Telegram Business account.</p>

    ReplyKeyboardMarkup(keyboard: List<List<KeyboardButton>>, is_persistent: Boolean, resize_keyboard: Boolean, one_time_keyboard: Boolean, input_field_placeholder: String, selective: Boolean)

<p>This object represents one button of the reply keyboard. At most one of the optional fields must be used to specify type of the button. For simple text buttons, <em>String</em> can be used instead of this object to specify the button text.</p><p><strong>Note:</strong> <em>request_users</em> and <em>request_chat</em> options will only work in Telegram versions released after 3 February, 2023. Older clients will display <em>unsupported message</em>.</p>

    KeyboardButton(text: String, request_users: KeyboardButtonRequestUsers, request_chat: KeyboardButtonRequestChat, request_contact: Boolean, request_location: Boolean, request_poll: KeyboardButtonPollType, web_app: WebAppInfo)

<p>This object defines the criteria used to request suitable users. Information about the selected users will be shared with the bot when the corresponding button is pressed. <a href="/bots/features#chat-and-user-selection">More about requesting users »</a></p>

    KeyboardButtonRequestUsers(request_id: Integer, user_is_bot: Boolean, user_is_premium: Boolean, max_quantity: Integer, request_name: Boolean, request_username: Boolean, request_photo: Boolean)

<p>This object defines the criteria used to request a suitable chat. Information about the selected chat will be shared with the bot when the corresponding button is pressed. The bot will be granted requested rights in the chat if appropriate. <a href="/bots/features#chat-and-user-selection">More about requesting chats »</a>.</p>

    KeyboardButtonRequestChat(request_id: Integer, chat_is_channel: Boolean, chat_is_forum: Boolean, chat_has_username: Boolean, chat_is_created: Boolean, user_administrator_rights: ChatAdministratorRights, bot_administrator_rights: ChatAdministratorRights, bot_is_member: Boolean, request_title: Boolean, request_username: Boolean, request_photo: Boolean)

<p>This object represents type of a poll, which is allowed to be created and sent when the corresponding button is pressed.</p>

    KeyboardButtonPollType(type: String)

<p>Upon receiving a message with this object, Telegram clients will remove the current custom keyboard and display the default letter-keyboard. By default, custom keyboards are displayed until a new keyboard is sent by a bot. An exception is made for one-time keyboards that are hidden immediately after the user presses a button (see <a href="#replykeyboardmarkup">ReplyKeyboardMarkup</a>). Not supported in channels and for messages sent on behalf of a Telegram Business account.</p>

    ReplyKeyboardRemove(remove_keyboard: Boolean, selective: Boolean)

<p>This object represents an <a href="/bots/features#inline-keyboards">inline keyboard</a> that appears right next to the message it belongs to.</p>

    InlineKeyboardMarkup(inline_keyboard: List<List<InlineKeyboardButton>>)

<p>This object represents one button of an inline keyboard. Exactly one of the optional fields must be used to specify type of the button.</p>

    InlineKeyboardButton(text: String, url: String, callback_data: String, web_app: WebAppInfo, login_url: LoginUrl, switch_inline_query: String, switch_inline_query_current_chat: String, switch_inline_query_chosen_chat: SwitchInlineQueryChosenChat, callback_game: CallbackGame, pay: Boolean)

<p>This object represents a parameter of the inline keyboard button used to automatically authorize a user. Serves as a great replacement for the <a href="/widgets/login">Telegram Login Widget</a> when the user is coming from Telegram. All the user needs to do is tap/click a button and confirm that they want to log in:</p><p>Telegram apps support these buttons as of <a href="https://telegram.org/blog/privacy-discussions-web-bots#meet-seamless-web-bots">version 5.7</a>.</p><blockquote>
 <p>Sample bot: <a href="https://t.me/discussbot">@discussbot</a></p>
</blockquote>

    LoginUrl(url: String, forward_text: String, bot_username: String, request_write_access: Boolean)

<p>This object represents an inline button that switches the current user to inline mode in a chosen chat, with an optional default inline query.</p>

    SwitchInlineQueryChosenChat(query: String, allow_user_chats: Boolean, allow_bot_chats: Boolean, allow_group_chats: Boolean, allow_channel_chats: Boolean)

<p>This object represents an incoming callback query from a callback button in an <a href="/bots/features#inline-keyboards">inline keyboard</a>. If the button that originated the query was attached to a message sent by the bot, the field <em>message</em> will be present. If the button was attached to a message sent via the bot (in <a href="#inline-mode">inline mode</a>), the field <em>inline_message_id</em> will be present. Exactly one of the fields <em>data</em> or <em>game_short_name</em> will be present.</p><blockquote>
 <p><strong>NOTE:</strong> After the user presses a callback button, Telegram clients will display a progress bar until you call <a href="#answercallbackquery">answerCallbackQuery</a>. It is, therefore, necessary to react by calling <a href="#answercallbackquery">answerCallbackQuery</a> even if no notification to the user is needed (e.g., without specifying any of the optional parameters).</p>
</blockquote>

    CallbackQuery(id: String, from: User, message: MaybeInaccessibleMessage, inline_message_id: String, chat_instance: String, data: String, game_short_name: String)

<p>Upon receiving a message with this object, Telegram clients will display a reply interface to the user (act as if the user has selected the bot's message and tapped 'Reply'). This can be extremely useful if you want to create user-friendly step-by-step interfaces without having to sacrifice <a href="/bots/features#privacy-mode">privacy mode</a>. Not supported in channels and for messages sent on behalf of a Telegram Business account.</p><blockquote>
 <p><strong>Example:</strong> A <a href="https://t.me/PollBot">poll bot</a> for groups runs in privacy mode (only receives commands, replies to its messages and mentions). There could be two ways to create a new poll:</p>
 <ul>
  <li>Explain the user how to send a command with parameters (e.g. /newpoll question answer1 answer2). May be appealing for hardcore users but lacks modern day polish.</li>
  <li>Guide the user through a step-by-step process. 'Please send me your question', 'Cool, now let's add the first answer option', 'Great. Keep adding answer options, then send /done when you're ready'.</li>
 </ul>
 <p>The last option is definitely more attractive. And if you use <a href="#forcereply">ForceReply</a> in your bot's questions, it will receive the user's answers even if it only receives replies, commands and mentions - without any extra work for the user.</p>
</blockquote>

    ForceReply(force_reply: Boolean, input_field_placeholder: String, selective: Boolean)

<p>This object represents a chat photo.</p>

    ChatPhoto(small_file_id: String, small_file_unique_id: String, big_file_id: String, big_file_unique_id: String)

<p>Represents an invite link for a chat.</p>

    ChatInviteLink(invite_link: String, creator: User, creates_join_request: Boolean, is_primary: Boolean, is_revoked: Boolean, name: String, expire_date: Integer, member_limit: Integer, pending_join_request_count: Integer)

<p>Represents the rights of an administrator in a chat.</p>

    ChatAdministratorRights(is_anonymous: Boolean, can_manage_chat: Boolean, can_delete_messages: Boolean, can_manage_video_chats: Boolean, can_restrict_members: Boolean, can_promote_members: Boolean, can_change_info: Boolean, can_invite_users: Boolean, can_post_stories: Boolean, can_edit_stories: Boolean, can_delete_stories: Boolean, can_post_messages: Boolean, can_edit_messages: Boolean, can_pin_messages: Boolean, can_manage_topics: Boolean)

<p>This object represents changes in the status of a chat member.</p>

    ChatMemberUpdated(chat: Chat, from: User, date: Integer, old_chat_member: ChatMember, new_chat_member: ChatMember, invite_link: ChatInviteLink, via_join_request: Boolean, via_chat_folder_invite_link: Boolean)

<p>Represents a <a href="#chatmember">chat member</a> that owns the chat and has all administrator privileges.</p>

    ChatMemberOwner(status: String, user: User, is_anonymous: Boolean, custom_title: String)

<p>Represents a <a href="#chatmember">chat member</a> that has some additional privileges.</p>

    ChatMemberAdministrator(status: String, user: User, can_be_edited: Boolean, is_anonymous: Boolean, can_manage_chat: Boolean, can_delete_messages: Boolean, can_manage_video_chats: Boolean, can_restrict_members: Boolean, can_promote_members: Boolean, can_change_info: Boolean, can_invite_users: Boolean, can_post_stories: Boolean, can_edit_stories: Boolean, can_delete_stories: Boolean, can_post_messages: Boolean, can_edit_messages: Boolean, can_pin_messages: Boolean, can_manage_topics: Boolean, custom_title: String)

<p>Represents a <a href="#chatmember">chat member</a> that has no additional privileges or restrictions.</p>

    ChatMemberMember(status: String, user: User)

<p>Represents a <a href="#chatmember">chat member</a> that is under certain restrictions in the chat. Supergroups only.</p>

    ChatMemberRestricted(status: String, user: User, is_member: Boolean, can_send_messages: Boolean, can_send_audios: Boolean, can_send_documents: Boolean, can_send_photos: Boolean, can_send_videos: Boolean, can_send_video_notes: Boolean, can_send_voice_notes: Boolean, can_send_polls: Boolean, can_send_other_messages: Boolean, can_add_web_page_previews: Boolean, can_change_info: Boolean, can_invite_users: Boolean, can_pin_messages: Boolean, can_manage_topics: Boolean, until_date: Integer)

<p>Represents a <a href="#chatmember">chat member</a> that isn't currently a member of the chat, but may join it themselves.</p>

    ChatMemberLeft(status: String, user: User)

<p>Represents a <a href="#chatmember">chat member</a> that was banned in the chat and can't return to the chat or view chat messages.</p>

    ChatMemberBanned(status: String, user: User, until_date: Integer)

<p>Represents a join request sent to a chat.</p>

    ChatJoinRequest(chat: Chat, from: User, user_chat_id: Integer, date: Integer, bio: String, invite_link: ChatInviteLink)

<p>Describes actions that a non-administrator user is allowed to take in a chat.</p>

    ChatPermissions(can_send_messages: Boolean, can_send_audios: Boolean, can_send_documents: Boolean, can_send_photos: Boolean, can_send_videos: Boolean, can_send_video_notes: Boolean, can_send_voice_notes: Boolean, can_send_polls: Boolean, can_send_other_messages: Boolean, can_add_web_page_previews: Boolean, can_change_info: Boolean, can_invite_users: Boolean, can_pin_messages: Boolean, can_manage_topics: Boolean)

<p>Describes the birthdate of a user.</p>

    Birthdate(day: Integer, month: Integer, year: Integer)

<p>Contains information about the start page settings of a Telegram Business account.</p>

    BusinessIntro(title: String, message: String, sticker: Sticker)

<p>Contains information about the location of a Telegram Business account.</p>

    BusinessLocation(address: String, location: Location)

<p>Describes an interval of time during which a business is open.</p>

    BusinessOpeningHoursInterval(opening_minute: Integer, closing_minute: Integer)

<p>Describes the opening hours of a business.</p>

    BusinessOpeningHours(time_zone_name: String, opening_hours: List<BusinessOpeningHoursInterval>)

<p>Represents a location to which a chat is connected.</p>

    ChatLocation(location: Location, address: String)

<p>The reaction is based on an emoji.</p>

    ReactionTypeEmoji(type: String, emoji: String)

<p>The reaction is based on a custom emoji.</p>

    ReactionTypeCustomEmoji(type: String, custom_emoji_id: String)

<p>Represents a reaction added to a message along with the number of times it was added.</p>

    ReactionCount(type: ReactionType, total_count: Integer)

<p>This object represents a change of a reaction on a message performed by a user.</p>

    MessageReactionUpdated(chat: Chat, message_id: Integer, user: User, actor_chat: Chat, date: Integer, old_reaction: List<ReactionType>, new_reaction: List<ReactionType>)

<p>This object represents reaction changes on a message with anonymous reactions.</p>

    MessageReactionCountUpdated(chat: Chat, message_id: Integer, date: Integer, reactions: List<ReactionCount>)

<p>This object represents a forum topic.</p>

    ForumTopic(message_thread_id: Integer, name: String, icon_color: Integer, icon_custom_emoji_id: String)

<p>This object represents a bot command.</p>

    BotCommand(command: String, description: String)

<p>Represents the default <a href="#botcommandscope">scope</a> of bot commands. Default commands are used if no commands with a <a href="#determining-list-of-commands">narrower scope</a> are specified for the user.</p>

    BotCommandScopeDefault(type: String)

<p>Represents the <a href="#botcommandscope">scope</a> of bot commands, covering all private chats.</p>

    BotCommandScopeAllPrivateChats(type: String)

<p>Represents the <a href="#botcommandscope">scope</a> of bot commands, covering all group and supergroup chats.</p>

    BotCommandScopeAllGroupChats(type: String)

<p>Represents the <a href="#botcommandscope">scope</a> of bot commands, covering all group and supergroup chat administrators.</p>

    BotCommandScopeAllChatAdministrators(type: String)

<p>Represents the <a href="#botcommandscope">scope</a> of bot commands, covering a specific chat.</p>

    BotCommandScopeChat(type: String, chat_id: IntegerOrString)

<p>Represents the <a href="#botcommandscope">scope</a> of bot commands, covering all administrators of a specific group or supergroup chat.</p>

    BotCommandScopeChatAdministrators(type: String, chat_id: IntegerOrString)

<p>Represents the <a href="#botcommandscope">scope</a> of bot commands, covering a specific member of a group or supergroup chat.</p>

    BotCommandScopeChatMember(type: String, chat_id: IntegerOrString, user_id: Integer)

<p>This object represents the bot's name.</p>

    BotName(name: String)

<p>This object represents the bot's description.</p>

    BotDescription(description: String)

<p>This object represents the bot's short description.</p>

    BotShortDescription(short_description: String)

<p>Represents a menu button, which opens the bot's list of commands.</p>

    MenuButtonCommands(type: String)

<p>Represents a menu button, which launches a <a href="/bots/webapps">Web App</a>.</p>

    MenuButtonWebApp(type: String, text: String, web_app: WebAppInfo)

<p>Describes that no specific value for the menu button was set.</p>

    MenuButtonDefault(type: String)

<p>The boost was obtained by subscribing to Telegram Premium or by gifting a Telegram Premium subscription to another user.</p>

    ChatBoostSourcePremium(source: String, user: User)

<p>The boost was obtained by the creation of Telegram Premium gift codes to boost a chat. Each such code boosts the chat 4 times for the duration of the corresponding Telegram Premium subscription.</p>

    ChatBoostSourceGiftCode(source: String, user: User)

<p>The boost was obtained by the creation of a Telegram Premium giveaway. This boosts the chat 4 times for the duration of the corresponding Telegram Premium subscription.</p>

    ChatBoostSourceGiveaway(source: String, giveaway_message_id: Integer, user: User, is_unclaimed: Boolean)

<p>This object contains information about a chat boost.</p>

    ChatBoost(boost_id: String, add_date: Integer, expiration_date: Integer, source: ChatBoostSource)

<p>This object represents a boost added to a chat or changed.</p>

    ChatBoostUpdated(chat: Chat, boost: ChatBoost)

<p>This object represents a boost removed from a chat.</p>

    ChatBoostRemoved(chat: Chat, boost_id: String, remove_date: Integer, source: ChatBoostSource)

<p>This object represents a list of boosts added to a chat by a user.</p>

    UserChatBoosts(boosts: List<ChatBoost>)

<p>Describes the connection of the bot with a business account.</p>

    BusinessConnection(id: String, user: User, user_chat_id: Integer, date: Integer, can_reply: Boolean, is_enabled: Boolean)

<p>This object is received when messages are deleted from a connected business account.</p>

    BusinessMessagesDeleted(business_connection_id: String, chat: Chat, message_ids: List<Integer>)

<p>Describes why a request was unsuccessful.</p>

    ResponseParameters(migrate_to_chat_id: Integer, retry_after: Integer)

<p>Represents a photo to be sent.</p>

    InputMediaPhoto(type: String, media: String, caption: String, parse_mode: ParseMode, caption_entities: List<MessageEntity>, show_caption_above_media: Boolean, has_spoiler: Boolean)

<p>Represents a video to be sent.</p>

    InputMediaVideo(type: String, media: String, thumbnail: InputFileOrString, caption: String, parse_mode: ParseMode, caption_entities: List<MessageEntity>, show_caption_above_media: Boolean, width: Integer, height: Integer, duration: Integer, supports_streaming: Boolean, has_spoiler: Boolean)

<p>Represents an animation file (GIF or H.264/MPEG-4 AVC video without sound) to be sent.</p>

    InputMediaAnimation(type: String, media: String, thumbnail: InputFileOrString, caption: String, parse_mode: ParseMode, caption_entities: List<MessageEntity>, show_caption_above_media: Boolean, width: Integer, height: Integer, duration: Integer, has_spoiler: Boolean)

<p>Represents an audio file to be treated as music to be sent.</p>

    InputMediaAudio(type: String, media: String, thumbnail: InputFileOrString, caption: String, parse_mode: ParseMode, caption_entities: List<MessageEntity>, duration: Integer, performer: String, title: String)

<p>Represents a general file to be sent.</p>

    InputMediaDocument(type: String, media: String, thumbnail: InputFileOrString, caption: String, parse_mode: ParseMode, caption_entities: List<MessageEntity>, disable_content_type_detection: Boolean)



## Available methods

### Methods
<p>Use this method to log out from the cloud Bot API server before launching the bot locally. You <strong>must</strong> log out the bot before running it locally, otherwise there is no guarantee that the bot will receive updates. After a successful call, you can immediately log in on a local server, but will not be able to log in back to the cloud Bot API server for 10 minutes. Returns <em>True</em> on success. Requires no parameters.</p>

    logOut()

<p>Use this method to close the bot instance before moving it from one local server to another. You need to delete the webhook before calling this method to ensure that the bot isn't launched again after server restart. The method will return error 429 in the first 10 minutes after the bot is launched. Returns <em>True</em> on success. Requires no parameters.</p>

    close()

<p>Use this method to send text messages. On success, the sent <a href="#message">Message</a> is returned.</p>

    sendMessage(business_connection_id: String, chat_id: IntegerOrString, message_thread_id: Integer, text: String, parse_mode: ParseMode, entities: List<MessageEntity>, link_preview_options: LinkPreviewOptions, disable_notification: Boolean, protect_content: Boolean, message_effect_id: String, reply_parameters: ReplyParameters, reply_markup: KeyboardOption)

<p>Use this method to forward messages of any kind. Service messages and messages with protected content can't be forwarded. On success, the sent <a href="#message">Message</a> is returned.</p>

    forwardMessage(chat_id: IntegerOrString, message_thread_id: Integer, from_chat_id: IntegerOrString, disable_notification: Boolean, protect_content: Boolean, message_id: Integer)

<p>Use this method to forward multiple messages of any kind. If some of the specified messages can't be found or forwarded, they are skipped. Service messages and messages with protected content can't be forwarded. Album grouping is kept for forwarded messages. On success, an array of <a href="#messageid">MessageId</a> of the sent messages is returned.</p>

    forwardMessages(chat_id: IntegerOrString, message_thread_id: Integer, from_chat_id: IntegerOrString, message_ids: List<Integer>, disable_notification: Boolean, protect_content: Boolean)

<p>Use this method to copy messages of any kind. Service messages, giveaway messages, giveaway winners messages, and invoice messages can't be copied. A quiz <a href="#poll">poll</a> can be copied only if the value of the field <em>correct_option_id</em> is known to the bot. The method is analogous to the method <a href="#forwardmessage">forwardMessage</a>, but the copied message doesn't have a link to the original message. Returns the <a href="#messageid">MessageId</a> of the sent message on success.</p>

    copyMessage(chat_id: IntegerOrString, message_thread_id: Integer, from_chat_id: IntegerOrString, message_id: Integer, caption: String, parse_mode: ParseMode, caption_entities: List<MessageEntity>, show_caption_above_media: Boolean, disable_notification: Boolean, protect_content: Boolean, reply_parameters: ReplyParameters, reply_markup: KeyboardOption)

<p>Use this method to copy messages of any kind. If some of the specified messages can't be found or copied, they are skipped. Service messages, giveaway messages, giveaway winners messages, and invoice messages can't be copied. A quiz <a href="#poll">poll</a> can be copied only if the value of the field <em>correct_option_id</em> is known to the bot. The method is analogous to the method <a href="#forwardmessages">forwardMessages</a>, but the copied messages don't have a link to the original message. Album grouping is kept for copied messages. On success, an array of <a href="#messageid">MessageId</a> of the sent messages is returned.</p>

    copyMessages(chat_id: IntegerOrString, message_thread_id: Integer, from_chat_id: IntegerOrString, message_ids: List<Integer>, disable_notification: Boolean, protect_content: Boolean, remove_caption: Boolean)

<p>Use this method to send photos. On success, the sent <a href="#message">Message</a> is returned.</p>

    sendPhoto(business_connection_id: String, chat_id: IntegerOrString, message_thread_id: Integer, photo: InputFileOrString, caption: String, parse_mode: ParseMode, caption_entities: List<MessageEntity>, show_caption_above_media: Boolean, has_spoiler: Boolean, disable_notification: Boolean, protect_content: Boolean, message_effect_id: String, reply_parameters: ReplyParameters, reply_markup: KeyboardOption)

<p>Use this method to send audio files, if you want Telegram clients to display them in the music player. Your audio must be in the .MP3 or .M4A format. On success, the sent <a href="#message">Message</a> is returned. Bots can currently send audio files of up to 50 MB in size, this limit may be changed in the future.</p><p>For sending voice messages, use the <a href="#sendvoice">sendVoice</a> method instead.</p>

    sendAudio(business_connection_id: String, chat_id: IntegerOrString, message_thread_id: Integer, audio: InputFileOrString, caption: String, parse_mode: ParseMode, caption_entities: List<MessageEntity>, duration: Integer, performer: String, title: String, thumbnail: InputFileOrString, disable_notification: Boolean, protect_content: Boolean, message_effect_id: String, reply_parameters: ReplyParameters, reply_markup: KeyboardOption)

<p>Use this method to send general files. On success, the sent <a href="#message">Message</a> is returned. Bots can currently send files of any type of up to 50 MB in size, this limit may be changed in the future.</p>

    sendDocument(business_connection_id: String, chat_id: IntegerOrString, message_thread_id: Integer, document: InputFileOrString, thumbnail: InputFileOrString, caption: String, parse_mode: ParseMode, caption_entities: List<MessageEntity>, disable_content_type_detection: Boolean, disable_notification: Boolean, protect_content: Boolean, message_effect_id: String, reply_parameters: ReplyParameters, reply_markup: KeyboardOption)

<p>Use this method to send video files, Telegram clients support MPEG4 videos (other formats may be sent as <a href="#document">Document</a>). On success, the sent <a href="#message">Message</a> is returned. Bots can currently send video files of up to 50 MB in size, this limit may be changed in the future.</p>

    sendVideo(business_connection_id: String, chat_id: IntegerOrString, message_thread_id: Integer, video: InputFileOrString, duration: Integer, width: Integer, height: Integer, thumbnail: InputFileOrString, caption: String, parse_mode: ParseMode, caption_entities: List<MessageEntity>, show_caption_above_media: Boolean, has_spoiler: Boolean, supports_streaming: Boolean, disable_notification: Boolean, protect_content: Boolean, message_effect_id: String, reply_parameters: ReplyParameters, reply_markup: KeyboardOption)

<p>Use this method to send animation files (GIF or H.264/MPEG-4 AVC video without sound). On success, the sent <a href="#message">Message</a> is returned. Bots can currently send animation files of up to 50 MB in size, this limit may be changed in the future.</p>

    sendAnimation(business_connection_id: String, chat_id: IntegerOrString, message_thread_id: Integer, animation: InputFileOrString, duration: Integer, width: Integer, height: Integer, thumbnail: InputFileOrString, caption: String, parse_mode: ParseMode, caption_entities: List<MessageEntity>, show_caption_above_media: Boolean, has_spoiler: Boolean, disable_notification: Boolean, protect_content: Boolean, message_effect_id: String, reply_parameters: ReplyParameters, reply_markup: KeyboardOption)

<p>Use this method to send audio files, if you want Telegram clients to display the file as a playable voice message. For this to work, your audio must be in an .OGG file encoded with OPUS, or in .MP3 format, or in .M4A format (other formats may be sent as <a href="#audio">Audio</a> or <a href="#document">Document</a>). On success, the sent <a href="#message">Message</a> is returned. Bots can currently send voice messages of up to 50 MB in size, this limit may be changed in the future.</p>

    sendVoice(business_connection_id: String, chat_id: IntegerOrString, message_thread_id: Integer, voice: InputFileOrString, caption: String, parse_mode: ParseMode, caption_entities: List<MessageEntity>, duration: Integer, disable_notification: Boolean, protect_content: Boolean, message_effect_id: String, reply_parameters: ReplyParameters, reply_markup: KeyboardOption)

<p>As of <a href="https://telegram.org/blog/video-messages-and-telescope">v.4.0</a>, Telegram clients support rounded square MPEG4 videos of up to 1 minute long. Use this method to send video messages. On success, the sent <a href="#message">Message</a> is returned.</p>

    sendVideoNote(business_connection_id: String, chat_id: IntegerOrString, message_thread_id: Integer, video_note: InputFileOrString, duration: Integer, length: Integer, thumbnail: InputFileOrString, disable_notification: Boolean, protect_content: Boolean, message_effect_id: String, reply_parameters: ReplyParameters, reply_markup: KeyboardOption)

<p>Use this method to send a group of photos, videos, documents or audios as an album. Documents and audio files can be only grouped in an album with messages of the same type. On success, an array of <a href="#message">Messages</a> that were sent is returned.</p>

    sendMediaGroup(business_connection_id: String, chat_id: IntegerOrString, message_thread_id: Integer, media: List<InputMedia>, disable_notification: Boolean, protect_content: Boolean, message_effect_id: String, reply_parameters: ReplyParameters)

<p>Use this method to send point on the map. On success, the sent <a href="#message">Message</a> is returned.</p>

    sendLocation(business_connection_id: String, chat_id: IntegerOrString, message_thread_id: Integer, latitude: Float, longitude: Float, horizontal_accuracy: Float, live_period: Integer, heading: Integer, proximity_alert_radius: Integer, disable_notification: Boolean, protect_content: Boolean, message_effect_id: String, reply_parameters: ReplyParameters, reply_markup: KeyboardOption)

<p>Use this method to send information about a venue. On success, the sent <a href="#message">Message</a> is returned.</p>

    sendVenue(business_connection_id: String, chat_id: IntegerOrString, message_thread_id: Integer, latitude: Float, longitude: Float, title: String, address: String, foursquare_id: String, foursquare_type: String, google_place_id: String, google_place_type: String, disable_notification: Boolean, protect_content: Boolean, message_effect_id: String, reply_parameters: ReplyParameters, reply_markup: KeyboardOption)

<p>Use this method to send phone contacts. On success, the sent <a href="#message">Message</a> is returned.</p>

    sendContact(business_connection_id: String, chat_id: IntegerOrString, message_thread_id: Integer, phone_number: String, first_name: String, last_name: String, vcard: String, disable_notification: Boolean, protect_content: Boolean, message_effect_id: String, reply_parameters: ReplyParameters, reply_markup: KeyboardOption)

<p>Use this method to send a native poll. On success, the sent <a href="#message">Message</a> is returned.</p>

    sendPoll(business_connection_id: String, chat_id: IntegerOrString, message_thread_id: Integer, question: String, question_parse_mode: String, question_entities: List<MessageEntity>, options: List<InputPollOption>, is_anonymous: Boolean, type: String, allows_multiple_answers: Boolean, correct_option_id: Integer, explanation: String, explanation_parse_mode: String, explanation_entities: List<MessageEntity>, open_period: Integer, close_date: Integer, is_closed: Boolean, disable_notification: Boolean, protect_content: Boolean, message_effect_id: String, reply_parameters: ReplyParameters, reply_markup: KeyboardOption)

<p>Use this method to send an animated emoji that will display a random value. On success, the sent <a href="#message">Message</a> is returned.</p>

    sendDice(business_connection_id: String, chat_id: IntegerOrString, message_thread_id: Integer, emoji: String, disable_notification: Boolean, protect_content: Boolean, message_effect_id: String, reply_parameters: ReplyParameters, reply_markup: KeyboardOption)

<p>Use this method when you need to tell the user that something is happening on the bot's side. The status is set for 5 seconds or less (when a message arrives from your bot, Telegram clients clear its typing status). Returns <em>True</em> on success.</p><blockquote>
 <p>Example: The <a href="https://t.me/imagebot">ImageBot</a> needs some time to process a request and upload the image. Instead of sending a text message along the lines of “Retrieving image, please wait…”, the bot may use <a href="#sendchataction">sendChatAction</a> with <em>action</em> = <em>upload_photo</em>. The user will see a “sending photo” status for the bot.</p>
</blockquote><p>We only recommend using this method when a response from the bot will take a <strong>noticeable</strong> amount of time to arrive.</p>

    sendChatAction(business_connection_id: String, chat_id: IntegerOrString, message_thread_id: Integer, action: String)

<p>Use this method to change the chosen reactions on a message. Service messages can't be reacted to. Automatically forwarded messages from a channel to its discussion group have the same available reactions as messages in the channel. Returns <em>True</em> on success.</p>

    setMessageReaction(chat_id: IntegerOrString, message_id: Integer, reaction: List<ReactionType>, is_big: Boolean)

<p>Use this method to get a list of profile pictures for a user. Returns a <a href="#userprofilephotos">UserProfilePhotos</a> object.</p>

    getUserProfilePhotos(user_id: Integer, offset: Integer, limit: Integer)

<p>Use this method to get basic information about a file and prepare it for downloading. For the moment, bots can download files of up to 20MB in size. On success, a <a href="#file">File</a> object is returned. The file can then be downloaded via the link <code>https://api.telegram.org/file/bot&lt;token&gt;/&lt;file_path&gt;</code>, where <code>&lt;file_path&gt;</code> is taken from the response. It is guaranteed that the link will be valid for at least 1 hour. When the link expires, a new one can be requested by calling <a href="#getfile">getFile</a> again.</p><p><strong>Note:</strong> This function may not preserve the original file name and MIME type. You should save the file's MIME type and name (if available) when the File object is received.</p>

    getFile(file_id: String)

<p>Use this method to ban a user in a group, a supergroup or a channel. In the case of supergroups and channels, the user will not be able to return to the chat on their own using invite links, etc., unless <a href="#unbanchatmember">unbanned</a> first. The bot must be an administrator in the chat for this to work and must have the appropriate administrator rights. Returns <em>True</em> on success.</p>

    banChatMember(chat_id: IntegerOrString, user_id: Integer, until_date: Integer, revoke_messages: Boolean)

<p>Use this method to unban a previously banned user in a supergroup or channel. The user will <strong>not</strong> return to the group or channel automatically, but will be able to join via link, etc. The bot must be an administrator for this to work. By default, this method guarantees that after the call the user is not a member of the chat, but will be able to join it. So if the user is a member of the chat they will also be <strong>removed</strong> from the chat. If you don't want this, use the parameter <em>only_if_banned</em>. Returns <em>True</em> on success.</p>

    unbanChatMember(chat_id: IntegerOrString, user_id: Integer, only_if_banned: Boolean)

<p>Use this method to restrict a user in a supergroup. The bot must be an administrator in the supergroup for this to work and must have the appropriate administrator rights. Pass <em>True</em> for all permissions to lift restrictions from a user. Returns <em>True</em> on success.</p>

    restrictChatMember(chat_id: IntegerOrString, user_id: Integer, permissions: ChatPermissions, use_independent_chat_permissions: Boolean, until_date: Integer)

<p>Use this method to promote or demote a user in a supergroup or a channel. The bot must be an administrator in the chat for this to work and must have the appropriate administrator rights. Pass <em>False</em> for all boolean parameters to demote a user. Returns <em>True</em> on success.</p>

    promoteChatMember(chat_id: IntegerOrString, user_id: Integer, is_anonymous: Boolean, can_manage_chat: Boolean, can_delete_messages: Boolean, can_manage_video_chats: Boolean, can_restrict_members: Boolean, can_promote_members: Boolean, can_change_info: Boolean, can_invite_users: Boolean, can_post_stories: Boolean, can_edit_stories: Boolean, can_delete_stories: Boolean, can_post_messages: Boolean, can_edit_messages: Boolean, can_pin_messages: Boolean, can_manage_topics: Boolean)

<p>Use this method to set a custom title for an administrator in a supergroup promoted by the bot. Returns <em>True</em> on success.</p>

    setChatAdministratorCustomTitle(chat_id: IntegerOrString, user_id: Integer, custom_title: String)

<p>Use this method to ban a channel chat in a supergroup or a channel. Until the chat is <a href="#unbanchatsenderchat">unbanned</a>, the owner of the banned chat won't be able to send messages on behalf of <strong>any of their channels</strong>. The bot must be an administrator in the supergroup or channel for this to work and must have the appropriate administrator rights. Returns <em>True</em> on success.</p>

    banChatSenderChat(chat_id: IntegerOrString, sender_chat_id: Integer)

<p>Use this method to unban a previously banned channel chat in a supergroup or channel. The bot must be an administrator for this to work and must have the appropriate administrator rights. Returns <em>True</em> on success.</p>

    unbanChatSenderChat(chat_id: IntegerOrString, sender_chat_id: Integer)

<p>Use this method to set default chat permissions for all members. The bot must be an administrator in the group or a supergroup for this to work and must have the <em>can_restrict_members</em> administrator rights. Returns <em>True</em> on success.</p>

    setChatPermissions(chat_id: IntegerOrString, permissions: ChatPermissions, use_independent_chat_permissions: Boolean)

<p>Use this method to generate a new primary invite link for a chat; any previously generated primary link is revoked. The bot must be an administrator in the chat for this to work and must have the appropriate administrator rights. Returns the new invite link as <em>String</em> on success.</p><blockquote>
 <p>Note: Each administrator in a chat generates their own invite links. Bots can't use invite links generated by other administrators. If you want your bot to work with invite links, it will need to generate its own link using <a href="#exportchatinvitelink">exportChatInviteLink</a> or by calling the <a href="#getchat">getChat</a> method. If your bot needs to generate a new primary invite link replacing its previous one, use <a href="#exportchatinvitelink">exportChatInviteLink</a> again.</p>
</blockquote>

    exportChatInviteLink(chat_id: IntegerOrString)

<p>Use this method to create an additional invite link for a chat. The bot must be an administrator in the chat for this to work and must have the appropriate administrator rights. The link can be revoked using the method <a href="#revokechatinvitelink">revokeChatInviteLink</a>. Returns the new invite link as <a href="#chatinvitelink">ChatInviteLink</a> object.</p>

    createChatInviteLink(chat_id: IntegerOrString, name: String, expire_date: Integer, member_limit: Integer, creates_join_request: Boolean)

<p>Use this method to edit a non-primary invite link created by the bot. The bot must be an administrator in the chat for this to work and must have the appropriate administrator rights. Returns the edited invite link as a <a href="#chatinvitelink">ChatInviteLink</a> object.</p>

    editChatInviteLink(chat_id: IntegerOrString, invite_link: String, name: String, expire_date: Integer, member_limit: Integer, creates_join_request: Boolean)

<p>Use this method to revoke an invite link created by the bot. If the primary link is revoked, a new link is automatically generated. The bot must be an administrator in the chat for this to work and must have the appropriate administrator rights. Returns the revoked invite link as <a href="#chatinvitelink">ChatInviteLink</a> object.</p>

    revokeChatInviteLink(chat_id: IntegerOrString, invite_link: String)

<p>Use this method to approve a chat join request. The bot must be an administrator in the chat for this to work and must have the <em>can_invite_users</em> administrator right. Returns <em>True</em> on success.</p>

    approveChatJoinRequest(chat_id: IntegerOrString, user_id: Integer)

<p>Use this method to decline a chat join request. The bot must be an administrator in the chat for this to work and must have the <em>can_invite_users</em> administrator right. Returns <em>True</em> on success.</p>

    declineChatJoinRequest(chat_id: IntegerOrString, user_id: Integer)

<p>Use this method to set a new profile photo for the chat. Photos can't be changed for private chats. The bot must be an administrator in the chat for this to work and must have the appropriate administrator rights. Returns <em>True</em> on success.</p>

    setChatPhoto(chat_id: IntegerOrString, photo: InputFile)

<p>Use this method to delete a chat photo. Photos can't be changed for private chats. The bot must be an administrator in the chat for this to work and must have the appropriate administrator rights. Returns <em>True</em> on success.</p>

    deleteChatPhoto(chat_id: IntegerOrString)

<p>Use this method to change the title of a chat. Titles can't be changed for private chats. The bot must be an administrator in the chat for this to work and must have the appropriate administrator rights. Returns <em>True</em> on success.</p>

    setChatTitle(chat_id: IntegerOrString, title: String)

<p>Use this method to change the description of a group, a supergroup or a channel. The bot must be an administrator in the chat for this to work and must have the appropriate administrator rights. Returns <em>True</em> on success.</p>

    setChatDescription(chat_id: IntegerOrString, description: String)

<p>Use this method to add a message to the list of pinned messages in a chat. If the chat is not a private chat, the bot must be an administrator in the chat for this to work and must have the 'can_pin_messages' administrator right in a supergroup or 'can_edit_messages' administrator right in a channel. Returns <em>True</em> on success.</p>

    pinChatMessage(chat_id: IntegerOrString, message_id: Integer, disable_notification: Boolean)

<p>Use this method to remove a message from the list of pinned messages in a chat. If the chat is not a private chat, the bot must be an administrator in the chat for this to work and must have the 'can_pin_messages' administrator right in a supergroup or 'can_edit_messages' administrator right in a channel. Returns <em>True</em> on success.</p>

    unpinChatMessage(chat_id: IntegerOrString, message_id: Integer)

<p>Use this method to clear the list of pinned messages in a chat. If the chat is not a private chat, the bot must be an administrator in the chat for this to work and must have the 'can_pin_messages' administrator right in a supergroup or 'can_edit_messages' administrator right in a channel. Returns <em>True</em> on success.</p>

    unpinAllChatMessages(chat_id: IntegerOrString)

<p>Use this method for your bot to leave a group, supergroup or channel. Returns <em>True</em> on success.</p>

    leaveChat(chat_id: IntegerOrString)

<p>Use this method to get up-to-date information about the chat. Returns a <a href="#chatfullinfo">ChatFullInfo</a> object on success.</p>

    getChat(chat_id: IntegerOrString)

<p>Use this method to get a list of administrators in a chat, which aren't bots. Returns an Array of <a href="#chatmember">ChatMember</a> objects.</p>

    getChatAdministrators(chat_id: IntegerOrString)

<p>Use this method to get the number of members in a chat. Returns <em>Int</em> on success.</p>

    getChatMemberCount(chat_id: IntegerOrString)

<p>Use this method to get information about a member of a chat. The method is only guaranteed to work for other users if the bot is an administrator in the chat. Returns a <a href="#chatmember">ChatMember</a> object on success.</p>

    getChatMember(chat_id: IntegerOrString, user_id: Integer)

<p>Use this method to set a new group sticker set for a supergroup. The bot must be an administrator in the chat for this to work and must have the appropriate administrator rights. Use the field <em>can_set_sticker_set</em> optionally returned in <a href="#getchat">getChat</a> requests to check if the bot can use this method. Returns <em>True</em> on success.</p>

    setChatStickerSet(chat_id: IntegerOrString, sticker_set_name: String)

<p>Use this method to delete a group sticker set from a supergroup. The bot must be an administrator in the chat for this to work and must have the appropriate administrator rights. Use the field <em>can_set_sticker_set</em> optionally returned in <a href="#getchat">getChat</a> requests to check if the bot can use this method. Returns <em>True</em> on success.</p>

    deleteChatStickerSet(chat_id: IntegerOrString)

<p>Use this method to get custom emoji stickers, which can be used as a forum topic icon by any user. Requires no parameters. Returns an Array of <a href="#sticker">Sticker</a> objects.</p>

    getForumTopicIconStickers()

<p>Use this method to create a topic in a forum supergroup chat. The bot must be an administrator in the chat for this to work and must have the <em>can_manage_topics</em> administrator rights. Returns information about the created topic as a <a href="#forumtopic">ForumTopic</a> object.</p>

    createForumTopic(chat_id: IntegerOrString, name: String, icon_color: Integer, icon_custom_emoji_id: String)

<p>Use this method to edit name and icon of a topic in a forum supergroup chat. The bot must be an administrator in the chat for this to work and must have <em>can_manage_topics</em> administrator rights, unless it is the creator of the topic. Returns <em>True</em> on success.</p>

    editForumTopic(chat_id: IntegerOrString, message_thread_id: Integer, name: String, icon_custom_emoji_id: String)

<p>Use this method to close an open topic in a forum supergroup chat. The bot must be an administrator in the chat for this to work and must have the <em>can_manage_topics</em> administrator rights, unless it is the creator of the topic. Returns <em>True</em> on success.</p>

    closeForumTopic(chat_id: IntegerOrString, message_thread_id: Integer)

<p>Use this method to reopen a closed topic in a forum supergroup chat. The bot must be an administrator in the chat for this to work and must have the <em>can_manage_topics</em> administrator rights, unless it is the creator of the topic. Returns <em>True</em> on success.</p>

    reopenForumTopic(chat_id: IntegerOrString, message_thread_id: Integer)

<p>Use this method to delete a forum topic along with all its messages in a forum supergroup chat. The bot must be an administrator in the chat for this to work and must have the <em>can_delete_messages</em> administrator rights. Returns <em>True</em> on success.</p>

    deleteForumTopic(chat_id: IntegerOrString, message_thread_id: Integer)

<p>Use this method to clear the list of pinned messages in a forum topic. The bot must be an administrator in the chat for this to work and must have the <em>can_pin_messages</em> administrator right in the supergroup. Returns <em>True</em> on success.</p>

    unpinAllForumTopicMessages(chat_id: IntegerOrString, message_thread_id: Integer)

<p>Use this method to edit the name of the 'General' topic in a forum supergroup chat. The bot must be an administrator in the chat for this to work and must have <em>can_manage_topics</em> administrator rights. Returns <em>True</em> on success.</p>

    editGeneralForumTopic(chat_id: IntegerOrString, name: String)

<p>Use this method to close an open 'General' topic in a forum supergroup chat. The bot must be an administrator in the chat for this to work and must have the <em>can_manage_topics</em> administrator rights. Returns <em>True</em> on success.</p>

    closeGeneralForumTopic(chat_id: IntegerOrString)

<p>Use this method to reopen a closed 'General' topic in a forum supergroup chat. The bot must be an administrator in the chat for this to work and must have the <em>can_manage_topics</em> administrator rights. The topic will be automatically unhidden if it was hidden. Returns <em>True</em> on success.</p>

    reopenGeneralForumTopic(chat_id: IntegerOrString)

<p>Use this method to hide the 'General' topic in a forum supergroup chat. The bot must be an administrator in the chat for this to work and must have the <em>can_manage_topics</em> administrator rights. The topic will be automatically closed if it was open. Returns <em>True</em> on success.</p>

    hideGeneralForumTopic(chat_id: IntegerOrString)

<p>Use this method to unhide the 'General' topic in a forum supergroup chat. The bot must be an administrator in the chat for this to work and must have the <em>can_manage_topics</em> administrator rights. Returns <em>True</em> on success.</p>

    unhideGeneralForumTopic(chat_id: IntegerOrString)

<p>Use this method to clear the list of pinned messages in a General forum topic. The bot must be an administrator in the chat for this to work and must have the <em>can_pin_messages</em> administrator right in the supergroup. Returns <em>True</em> on success.</p>

    unpinAllGeneralForumTopicMessages(chat_id: IntegerOrString)

<p>Use this method to send answers to callback queries sent from <a href="/bots/features#inline-keyboards">inline keyboards</a>. The answer will be displayed to the user as a notification at the top of the chat screen or as an alert. On success, <em>True</em> is returned.</p><blockquote>
 <p>Alternatively, the user can be redirected to the specified Game URL. For this option to work, you must first create a game for your bot via <a href="https://t.me/botfather">@BotFather</a> and accept the terms. Otherwise, you may use links like <code>t.me/your_bot?start=XXXX</code> that open your bot with a parameter.</p>
</blockquote>

    answerCallbackQuery(callback_query_id: String, text: String, show_alert: Boolean, url: String, cache_time: Integer)

<p>Use this method to get the list of boosts added to a chat by a user. Requires administrator rights in the chat. Returns a <a href="#userchatboosts">UserChatBoosts</a> object.</p>

    getUserChatBoosts(chat_id: IntegerOrString, user_id: Integer)

<p>Use this method to get information about the connection of the bot with a business account. Returns a <a href="#businessconnection">BusinessConnection</a> object on success.</p>

    getBusinessConnection(business_connection_id: String)

<p>Use this method to change the list of the bot's commands. See <a href="/bots/features#commands">this manual</a> for more details about bot commands. Returns <em>True</em> on success.</p>

    setMyCommands(commands: List<BotCommand>, scope: BotCommandScope, language_code: String)

<p>Use this method to delete the list of the bot's commands for the given scope and user language. After deletion, <a href="#determining-list-of-commands">higher level commands</a> will be shown to affected users. Returns <em>True</em> on success.</p>

    deleteMyCommands(scope: BotCommandScope, language_code: String)

<p>Use this method to get the current list of the bot's commands for the given scope and user language. Returns an Array of <a href="#botcommand">BotCommand</a> objects. If commands aren't set, an empty list is returned.</p>

    getMyCommands(scope: BotCommandScope, language_code: String)

<p>Use this method to change the bot's name. Returns <em>True</em> on success.</p>

    setMyName(name: String, language_code: String)

<p>Use this method to get the current bot name for the given user language. Returns <a href="#botname">BotName</a> on success.</p>

    getMyName(language_code: String)

<p>Use this method to change the bot's description, which is shown in the chat with the bot if the chat is empty. Returns <em>True</em> on success.</p>

    setMyDescription(description: String, language_code: String)

<p>Use this method to get the current bot description for the given user language. Returns <a href="#botdescription">BotDescription</a> on success.</p>

    getMyDescription(language_code: String)

<p>Use this method to change the bot's short description, which is shown on the bot's profile page and is sent together with the link when users share the bot. Returns <em>True</em> on success.</p>

    setMyShortDescription(short_description: String, language_code: String)

<p>Use this method to get the current bot short description for the given user language. Returns <a href="#botshortdescription">BotShortDescription</a> on success.</p>

    getMyShortDescription(language_code: String)

<p>Use this method to change the bot's menu button in a private chat, or the default menu button. Returns <em>True</em> on success.</p>

    setChatMenuButton(chat_id: Integer, menu_button: MenuButton)

<p>Use this method to get the current value of the bot's menu button in a private chat, or the default menu button. Returns <a href="#menubutton">MenuButton</a> on success.</p>

    getChatMenuButton(chat_id: Integer)

<p>Use this method to change the default administrator rights requested by the bot when it's added as an administrator to groups or channels. These rights will be suggested to users, but they are free to modify the list before adding the bot. Returns <em>True</em> on success.</p>

    setMyDefaultAdministratorRights(rights: ChatAdministratorRights, for_channels: Boolean)

<p>Use this method to get the current default administrator rights of the bot. Returns <a href="#chatadministratorrights">ChatAdministratorRights</a> on success.</p>

    getMyDefaultAdministratorRights(for_channels: Boolean)



## Updating messages

### Methods
<p>Use this method to edit text and <a href="#games">game</a> messages. On success, if the edited message is not an inline message, the edited <a href="#message">Message</a> is returned, otherwise <em>True</em> is returned.</p>

    editMessageText(chat_id: IntegerOrString, message_id: Integer, inline_message_id: String, text: String, parse_mode: ParseMode, entities: List<MessageEntity>, link_preview_options: LinkPreviewOptions, reply_markup: InlineKeyboardMarkup)

<p>Use this method to edit captions of messages. On success, if the edited message is not an inline message, the edited <a href="#message">Message</a> is returned, otherwise <em>True</em> is returned.</p>

    editMessageCaption(chat_id: IntegerOrString, message_id: Integer, inline_message_id: String, caption: String, parse_mode: ParseMode, caption_entities: List<MessageEntity>, show_caption_above_media: Boolean, reply_markup: InlineKeyboardMarkup)

<p>Use this method to edit animation, audio, document, photo, or video messages. If a message is part of a message album, then it can be edited only to an audio for audio albums, only to a document for document albums and to a photo or a video otherwise. When an inline message is edited, a new file can't be uploaded; use a previously uploaded file via its file_id or specify a URL. On success, if the edited message is not an inline message, the edited <a href="#message">Message</a> is returned, otherwise <em>True</em> is returned.</p>

    editMessageMedia(chat_id: IntegerOrString, message_id: Integer, inline_message_id: String, media: InputMedia, reply_markup: InlineKeyboardMarkup)

<p>Use this method to edit live location messages. A location can be edited until its <em>live_period</em> expires or editing is explicitly disabled by a call to <a href="#stopmessagelivelocation">stopMessageLiveLocation</a>. On success, if the edited message is not an inline message, the edited <a href="#message">Message</a> is returned, otherwise <em>True</em> is returned.</p>

    editMessageLiveLocation(chat_id: IntegerOrString, message_id: Integer, inline_message_id: String, latitude: Float, longitude: Float, live_period: Integer, horizontal_accuracy: Float, heading: Integer, proximity_alert_radius: Integer, reply_markup: InlineKeyboardMarkup)

<p>Use this method to stop updating a live location message before <em>live_period</em> expires. On success, if the message is not an inline message, the edited <a href="#message">Message</a> is returned, otherwise <em>True</em> is returned.</p>

    stopMessageLiveLocation(chat_id: IntegerOrString, message_id: Integer, inline_message_id: String, reply_markup: InlineKeyboardMarkup)

<p>Use this method to edit only the reply markup of messages. On success, if the edited message is not an inline message, the edited <a href="#message">Message</a> is returned, otherwise <em>True</em> is returned.</p>

    editMessageReplyMarkup(chat_id: IntegerOrString, message_id: Integer, inline_message_id: String, reply_markup: InlineKeyboardMarkup)

<p>Use this method to stop a poll which was sent by the bot. On success, the stopped <a href="#poll">Poll</a> is returned.</p>

    stopPoll(chat_id: IntegerOrString, message_id: Integer, reply_markup: InlineKeyboardMarkup)

<p>Use this method to delete a message, including service messages, with the following limitations:<br>- A message can only be deleted if it was sent less than 48 hours ago.<br>- Service messages about a supergroup, channel, or forum topic creation can't be deleted.<br>- A dice message in a private chat can only be deleted if it was sent more than 24 hours ago.<br>- Bots can delete outgoing messages in private chats, groups, and supergroups.<br>- Bots can delete incoming messages in private chats.<br>- Bots granted <em>can_post_messages</em> permissions can delete outgoing messages in channels.<br>- If the bot is an administrator of a group, it can delete any message there.<br>- If the bot has <em>can_delete_messages</em> permission in a supergroup or a channel, it can delete any message there.<br>Returns <em>True</em> on success.</p>

    deleteMessage(chat_id: IntegerOrString, message_id: Integer)

<p>Use this method to delete multiple messages simultaneously. If some of the specified messages can't be found, they are skipped. Returns <em>True</em> on success.</p>

    deleteMessages(chat_id: IntegerOrString, message_ids: List<Integer>)



## Stickers

### Data Types
<p>This object represents a sticker.</p>

    Sticker(file_id: String, file_unique_id: String, type: String, width: Integer, height: Integer, is_animated: Boolean, is_video: Boolean, thumbnail: PhotoSize, emoji: String, set_name: String, premium_animation: File, mask_position: MaskPosition, custom_emoji_id: String, needs_repainting: Boolean, file_size: Integer)

<p>This object represents a sticker set.</p>

    StickerSet(name: String, title: String, sticker_type: String, stickers: List<Sticker>, thumbnail: PhotoSize)

<p>This object describes the position on faces where a mask should be placed by default.</p>

    MaskPosition(point: String, x_shift: Float, y_shift: Float, scale: Float)

<p>This object describes a sticker to be added to a sticker set.</p>

    InputSticker(sticker: InputFileOrString, format: String, emoji_list: List<String>, mask_position: MaskPosition, keywords: List<String>)


### Methods
<p>Use this method to send static .WEBP, <a href="https://telegram.org/blog/animated-stickers">animated</a> .TGS, or <a href="https://telegram.org/blog/video-stickers-better-reactions">video</a> .WEBM stickers. On success, the sent <a href="#message">Message</a> is returned.</p>

    sendSticker(business_connection_id: String, chat_id: IntegerOrString, message_thread_id: Integer, sticker: InputFileOrString, emoji: String, disable_notification: Boolean, protect_content: Boolean, message_effect_id: String, reply_parameters: ReplyParameters, reply_markup: KeyboardOption)

<p>Use this method to get a sticker set. On success, a <a href="#stickerset">StickerSet</a> object is returned.</p>

    getStickerSet(name: String)

<p>Use this method to get information about custom emoji stickers by their identifiers. Returns an Array of <a href="#sticker">Sticker</a> objects.</p>

    getCustomEmojiStickers(custom_emoji_ids: List<String>)

<p>Use this method to upload a file with a sticker for later use in the <a href="#createnewstickerset">createNewStickerSet</a>, <a href="#addstickertoset">addStickerToSet</a>, or <a href="#replacestickerinset">replaceStickerInSet</a> methods (the file can be used multiple times). Returns the uploaded <a href="#file">File</a> on success.</p>

    uploadStickerFile(user_id: Integer, sticker: InputFile, sticker_format: String)

<p>Use this method to create a new sticker set owned by a user. The bot will be able to edit the sticker set thus created. Returns <em>True</em> on success.</p>

    createNewStickerSet(user_id: Integer, name: String, title: String, stickers: List<InputSticker>, sticker_type: String, needs_repainting: Boolean)

<p>Use this method to add a new sticker to a set created by the bot. Emoji sticker sets can have up to 200 stickers. Other sticker sets can have up to 120 stickers. Returns <em>True</em> on success.</p>

    addStickerToSet(user_id: Integer, name: String, sticker: InputSticker)

<p>Use this method to move a sticker in a set created by the bot to a specific position. Returns <em>True</em> on success.</p>

    setStickerPositionInSet(sticker: String, position: Integer)

<p>Use this method to delete a sticker from a set created by the bot. Returns <em>True</em> on success.</p>

    deleteStickerFromSet(sticker: String)

<p>Use this method to replace an existing sticker in a sticker set with a new one. The method is equivalent to calling <a href="#deletestickerfromset">deleteStickerFromSet</a>, then <a href="#addstickertoset">addStickerToSet</a>, then <a href="#setstickerpositioninset">setStickerPositionInSet</a>. Returns <em>True</em> on success.</p>

    replaceStickerInSet(user_id: Integer, name: String, old_sticker: String, sticker: InputSticker)

<p>Use this method to change the list of emoji assigned to a regular or custom emoji sticker. The sticker must belong to a sticker set created by the bot. Returns <em>True</em> on success.</p>

    setStickerEmojiList(sticker: String, emoji_list: List<String>)

<p>Use this method to change search keywords assigned to a regular or custom emoji sticker. The sticker must belong to a sticker set created by the bot. Returns <em>True</em> on success.</p>

    setStickerKeywords(sticker: String, keywords: List<String>)

<p>Use this method to change the <a href="#maskposition">mask position</a> of a mask sticker. The sticker must belong to a sticker set that was created by the bot. Returns <em>True</em> on success.</p>

    setStickerMaskPosition(sticker: String, mask_position: MaskPosition)

<p>Use this method to set the title of a created sticker set. Returns <em>True</em> on success.</p>

    setStickerSetTitle(name: String, title: String)

<p>Use this method to set the thumbnail of a regular or mask sticker set. The format of the thumbnail file must match the format of the stickers in the set. Returns <em>True</em> on success.</p>

    setStickerSetThumbnail(name: String, user_id: Integer, thumbnail: InputFileOrString, format: String)

<p>Use this method to set the thumbnail of a custom emoji sticker set. Returns <em>True</em> on success.</p>

    setCustomEmojiStickerSetThumbnail(name: String, custom_emoji_id: String)

<p>Use this method to delete a sticker set that was created by the bot. Returns <em>True</em> on success.</p>

    deleteStickerSet(name: String)



## Inline mode

### Data Types
<p>This object represents an incoming inline query. When the user sends an empty query, your bot could return some default or trending results.</p>

    InlineQuery(id: String, from: User, query: String, offset: String, chat_type: String, location: Location)

<p>This object represents a button to be shown above inline query results. You <strong>must</strong> use exactly one of the optional fields.</p>

    InlineQueryResultsButton(text: String, web_app: WebAppInfo, start_parameter: String)

<p>Represents a link to an article or web page.</p>

    InlineQueryResultArticle(type: String, id: String, title: String, input_message_content: InputMessageContent, reply_markup: InlineKeyboardMarkup, url: String, hide_url: Boolean, description: String, thumbnail_url: String, thumbnail_width: Integer, thumbnail_height: Integer)

<p>Represents a link to a photo. By default, this photo will be sent by the user with optional caption. Alternatively, you can use <em>input_message_content</em> to send a message with the specified content instead of the photo.</p>

    InlineQueryResultPhoto(type: String, id: String, photo_url: String, thumbnail_url: String, photo_width: Integer, photo_height: Integer, title: String, description: String, caption: String, parse_mode: ParseMode, caption_entities: List<MessageEntity>, show_caption_above_media: Boolean, reply_markup: InlineKeyboardMarkup, input_message_content: InputMessageContent)

<p>Represents a link to an animated GIF file. By default, this animated GIF file will be sent by the user with optional caption. Alternatively, you can use <em>input_message_content</em> to send a message with the specified content instead of the animation.</p>

    InlineQueryResultGif(type: String, id: String, gif_url: String, gif_width: Integer, gif_height: Integer, gif_duration: Integer, thumbnail_url: String, thumbnail_mime_type: String, title: String, caption: String, parse_mode: ParseMode, caption_entities: List<MessageEntity>, show_caption_above_media: Boolean, reply_markup: InlineKeyboardMarkup, input_message_content: InputMessageContent)

<p>Represents a link to a video animation (H.264/MPEG-4 AVC video without sound). By default, this animated MPEG-4 file will be sent by the user with optional caption. Alternatively, you can use <em>input_message_content</em> to send a message with the specified content instead of the animation.</p>

    InlineQueryResultMpeg4Gif(type: String, id: String, mpeg4_url: String, mpeg4_width: Integer, mpeg4_height: Integer, mpeg4_duration: Integer, thumbnail_url: String, thumbnail_mime_type: String, title: String, caption: String, parse_mode: ParseMode, caption_entities: List<MessageEntity>, show_caption_above_media: Boolean, reply_markup: InlineKeyboardMarkup, input_message_content: InputMessageContent)

<p>Represents a link to a page containing an embedded video player or a video file. By default, this video file will be sent by the user with an optional caption. Alternatively, you can use <em>input_message_content</em> to send a message with the specified content instead of the video.</p><blockquote>
 <p>If an InlineQueryResultVideo message contains an embedded video (e.g., YouTube), you <strong>must</strong> replace its content using <em>input_message_content</em>.</p>
</blockquote>

    InlineQueryResultVideo(type: String, id: String, video_url: String, mime_type: String, thumbnail_url: String, title: String, caption: String, parse_mode: ParseMode, caption_entities: List<MessageEntity>, show_caption_above_media: Boolean, video_width: Integer, video_height: Integer, video_duration: Integer, description: String, reply_markup: InlineKeyboardMarkup, input_message_content: InputMessageContent)

<p>Represents a link to an MP3 audio file. By default, this audio file will be sent by the user. Alternatively, you can use <em>input_message_content</em> to send a message with the specified content instead of the audio.</p>

    InlineQueryResultAudio(type: String, id: String, audio_url: String, title: String, caption: String, parse_mode: ParseMode, caption_entities: List<MessageEntity>, performer: String, audio_duration: Integer, reply_markup: InlineKeyboardMarkup, input_message_content: InputMessageContent)

<p>Represents a link to a voice recording in an .OGG container encoded with OPUS. By default, this voice recording will be sent by the user. Alternatively, you can use <em>input_message_content</em> to send a message with the specified content instead of the the voice message.</p>

    InlineQueryResultVoice(type: String, id: String, voice_url: String, title: String, caption: String, parse_mode: ParseMode, caption_entities: List<MessageEntity>, voice_duration: Integer, reply_markup: InlineKeyboardMarkup, input_message_content: InputMessageContent)

<p>Represents a link to a file. By default, this file will be sent by the user with an optional caption. Alternatively, you can use <em>input_message_content</em> to send a message with the specified content instead of the file. Currently, only <strong>.PDF</strong> and <strong>.ZIP</strong> files can be sent using this method.</p>

    InlineQueryResultDocument(type: String, id: String, title: String, caption: String, parse_mode: ParseMode, caption_entities: List<MessageEntity>, document_url: String, mime_type: String, description: String, reply_markup: InlineKeyboardMarkup, input_message_content: InputMessageContent, thumbnail_url: String, thumbnail_width: Integer, thumbnail_height: Integer)

<p>Represents a location on a map. By default, the location will be sent by the user. Alternatively, you can use <em>input_message_content</em> to send a message with the specified content instead of the location.</p>

    InlineQueryResultLocation(type: String, id: String, latitude: Float, longitude: Float, title: String, horizontal_accuracy: Float, live_period: Integer, heading: Integer, proximity_alert_radius: Integer, reply_markup: InlineKeyboardMarkup, input_message_content: InputMessageContent, thumbnail_url: String, thumbnail_width: Integer, thumbnail_height: Integer)

<p>Represents a venue. By default, the venue will be sent by the user. Alternatively, you can use <em>input_message_content</em> to send a message with the specified content instead of the venue.</p>

    InlineQueryResultVenue(type: String, id: String, latitude: Float, longitude: Float, title: String, address: String, foursquare_id: String, foursquare_type: String, google_place_id: String, google_place_type: String, reply_markup: InlineKeyboardMarkup, input_message_content: InputMessageContent, thumbnail_url: String, thumbnail_width: Integer, thumbnail_height: Integer)

<p>Represents a contact with a phone number. By default, this contact will be sent by the user. Alternatively, you can use <em>input_message_content</em> to send a message with the specified content instead of the contact.</p>

    InlineQueryResultContact(type: String, id: String, phone_number: String, first_name: String, last_name: String, vcard: String, reply_markup: InlineKeyboardMarkup, input_message_content: InputMessageContent, thumbnail_url: String, thumbnail_width: Integer, thumbnail_height: Integer)

<p>Represents a <a href="#games">Game</a>.</p>

    InlineQueryResultGame(type: String, id: String, game_short_name: String, reply_markup: InlineKeyboardMarkup)

<p>Represents a link to a photo stored on the Telegram servers. By default, this photo will be sent by the user with an optional caption. Alternatively, you can use <em>input_message_content</em> to send a message with the specified content instead of the photo.</p>

    InlineQueryResultCachedPhoto(type: String, id: String, photo_file_id: String, title: String, description: String, caption: String, parse_mode: ParseMode, caption_entities: List<MessageEntity>, show_caption_above_media: Boolean, reply_markup: InlineKeyboardMarkup, input_message_content: InputMessageContent)

<p>Represents a link to an animated GIF file stored on the Telegram servers. By default, this animated GIF file will be sent by the user with an optional caption. Alternatively, you can use <em>input_message_content</em> to send a message with specified content instead of the animation.</p>

    InlineQueryResultCachedGif(type: String, id: String, gif_file_id: String, title: String, caption: String, parse_mode: ParseMode, caption_entities: List<MessageEntity>, show_caption_above_media: Boolean, reply_markup: InlineKeyboardMarkup, input_message_content: InputMessageContent)

<p>Represents a link to a video animation (H.264/MPEG-4 AVC video without sound) stored on the Telegram servers. By default, this animated MPEG-4 file will be sent by the user with an optional caption. Alternatively, you can use <em>input_message_content</em> to send a message with the specified content instead of the animation.</p>

    InlineQueryResultCachedMpeg4Gif(type: String, id: String, mpeg4_file_id: String, title: String, caption: String, parse_mode: ParseMode, caption_entities: List<MessageEntity>, show_caption_above_media: Boolean, reply_markup: InlineKeyboardMarkup, input_message_content: InputMessageContent)

<p>Represents a link to a sticker stored on the Telegram servers. By default, this sticker will be sent by the user. Alternatively, you can use <em>input_message_content</em> to send a message with the specified content instead of the sticker.</p>

    InlineQueryResultCachedSticker(type: String, id: String, sticker_file_id: String, reply_markup: InlineKeyboardMarkup, input_message_content: InputMessageContent)

<p>Represents a link to a file stored on the Telegram servers. By default, this file will be sent by the user with an optional caption. Alternatively, you can use <em>input_message_content</em> to send a message with the specified content instead of the file.</p>

    InlineQueryResultCachedDocument(type: String, id: String, title: String, document_file_id: String, description: String, caption: String, parse_mode: ParseMode, caption_entities: List<MessageEntity>, reply_markup: InlineKeyboardMarkup, input_message_content: InputMessageContent)

<p>Represents a link to a video file stored on the Telegram servers. By default, this video file will be sent by the user with an optional caption. Alternatively, you can use <em>input_message_content</em> to send a message with the specified content instead of the video.</p>

    InlineQueryResultCachedVideo(type: String, id: String, video_file_id: String, title: String, description: String, caption: String, parse_mode: ParseMode, caption_entities: List<MessageEntity>, show_caption_above_media: Boolean, reply_markup: InlineKeyboardMarkup, input_message_content: InputMessageContent)

<p>Represents a link to a voice message stored on the Telegram servers. By default, this voice message will be sent by the user. Alternatively, you can use <em>input_message_content</em> to send a message with the specified content instead of the voice message.</p>

    InlineQueryResultCachedVoice(type: String, id: String, voice_file_id: String, title: String, caption: String, parse_mode: ParseMode, caption_entities: List<MessageEntity>, reply_markup: InlineKeyboardMarkup, input_message_content: InputMessageContent)

<p>Represents a link to an MP3 audio file stored on the Telegram servers. By default, this audio file will be sent by the user. Alternatively, you can use <em>input_message_content</em> to send a message with the specified content instead of the audio.</p>

    InlineQueryResultCachedAudio(type: String, id: String, audio_file_id: String, caption: String, parse_mode: ParseMode, caption_entities: List<MessageEntity>, reply_markup: InlineKeyboardMarkup, input_message_content: InputMessageContent)

<p>Represents the <a href="#inputmessagecontent">content</a> of a text message to be sent as the result of an inline query.</p>

    InputTextMessageContent(message_text: String, parse_mode: ParseMode, entities: List<MessageEntity>, link_preview_options: LinkPreviewOptions)

<p>Represents the <a href="#inputmessagecontent">content</a> of a location message to be sent as the result of an inline query.</p>

    InputLocationMessageContent(latitude: Float, longitude: Float, horizontal_accuracy: Float, live_period: Integer, heading: Integer, proximity_alert_radius: Integer)

<p>Represents the <a href="#inputmessagecontent">content</a> of a venue message to be sent as the result of an inline query.</p>

    InputVenueMessageContent(latitude: Float, longitude: Float, title: String, address: String, foursquare_id: String, foursquare_type: String, google_place_id: String, google_place_type: String)

<p>Represents the <a href="#inputmessagecontent">content</a> of a contact message to be sent as the result of an inline query.</p>

    InputContactMessageContent(phone_number: String, first_name: String, last_name: String, vcard: String)

<p>Represents the <a href="#inputmessagecontent">content</a> of an invoice message to be sent as the result of an inline query.</p>

    InputInvoiceMessageContent(title: String, description: String, payload: String, provider_token: String, currency: String, prices: List<LabeledPrice>, max_tip_amount: Integer, suggested_tip_amounts: List<Integer>, provider_data: String, photo_url: String, photo_size: Integer, photo_width: Integer, photo_height: Integer, need_name: Boolean, need_phone_number: Boolean, need_email: Boolean, need_shipping_address: Boolean, send_phone_number_to_provider: Boolean, send_email_to_provider: Boolean, is_flexible: Boolean)

<p>Represents a <a href="#inlinequeryresult">result</a> of an inline query that was chosen by the user and sent to their chat partner.</p><p><strong>Note:</strong> It is necessary to enable <a href="/bots/inline#collecting-feedback">inline feedback</a> via <a href="https://t.me/botfather">@BotFather</a> in order to receive these objects in updates.</p>

    ChosenInlineResult(result_id: String, from: User, location: Location, inline_message_id: String, query: String)

<p>Describes an inline message sent by a <a href="/bots/webapps">Web App</a> on behalf of a user.</p>

    SentWebAppMessage(inline_message_id: String)


### Methods
<p>Use this method to send answers to an inline query. On success, <em>True</em> is returned.<br>No more than <strong>50</strong> results per query are allowed.</p>

    answerInlineQuery(inline_query_id: String, results: List<InlineQueryResult>, cache_time: Integer, is_personal: Boolean, next_offset: String, button: InlineQueryResultsButton)

<p>Use this method to set the result of an interaction with a <a href="/bots/webapps">Web App</a> and send a corresponding message on behalf of the user to the chat from which the query originated. On success, a <a href="#sentwebappmessage">SentWebAppMessage</a> object is returned.</p>

    answerWebAppQuery(web_app_query_id: String, result: InlineQueryResult)



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

    sendInvoice(chat_id: IntegerOrString, message_thread_id: Integer, title: String, description: String, payload: String, provider_token: String, currency: String, prices: List<LabeledPrice>, max_tip_amount: Integer, suggested_tip_amounts: List<Integer>, start_parameter: String, provider_data: String, photo_url: String, photo_size: Integer, photo_width: Integer, photo_height: Integer, need_name: Boolean, need_phone_number: Boolean, need_email: Boolean, need_shipping_address: Boolean, send_phone_number_to_provider: Boolean, send_email_to_provider: Boolean, is_flexible: Boolean, disable_notification: Boolean, protect_content: Boolean, message_effect_id: String, reply_parameters: ReplyParameters, reply_markup: InlineKeyboardMarkup)

<p>Use this method to create a link for an invoice. Returns the created invoice link as <em>String</em> on success.</p>

    createInvoiceLink(title: String, description: String, payload: String, provider_token: String, currency: String, prices: List<LabeledPrice>, max_tip_amount: Integer, suggested_tip_amounts: List<Integer>, provider_data: String, photo_url: String, photo_size: Integer, photo_width: Integer, photo_height: Integer, need_name: Boolean, need_phone_number: Boolean, need_email: Boolean, need_shipping_address: Boolean, send_phone_number_to_provider: Boolean, send_email_to_provider: Boolean, is_flexible: Boolean)

<p>If you sent an invoice requesting a shipping address and the parameter <em>is_flexible</em> was specified, the Bot API will send an <a href="#update">Update</a> with a <em>shipping_query</em> field to the bot. Use this method to reply to shipping queries. On success, <em>True</em> is returned.</p>

    answerShippingQuery(shipping_query_id: String, ok: Boolean, shipping_options: List<ShippingOption>, error_message: String)

<p>Once the user has confirmed their payment and shipping details, the Bot API sends the final confirmation in the form of an <a href="#update">Update</a> with the field <em>pre_checkout_query</em>. Use this method to respond to such pre-checkout queries. On success, <em>True</em> is returned. <strong>Note:</strong> The Bot API must receive an answer within 10 seconds after the pre-checkout query was sent.</p>

    answerPreCheckoutQuery(pre_checkout_query_id: String, ok: Boolean, error_message: String)

<p>Refunds a successful payment in <a href="https://t.me/BotNews/90">Telegram Stars</a>. Returns <em>True</em> on success.</p>

    refundStarPayment(user_id: Integer, telegram_payment_charge_id: String)



## Telegram Passport

### Data Types
<p>Describes Telegram Passport data shared with the bot by the user.</p>

    PassportData(data: List<EncryptedPassportElement>, credentials: EncryptedCredentials)

<p>This object represents a file uploaded to Telegram Passport. Currently all Telegram Passport files are in JPEG format when decrypted and don't exceed 10MB.</p>

    PassportFile(file_id: String, file_unique_id: String, file_size: Integer, file_date: Integer)

<p>Describes documents or other Telegram Passport elements shared with the bot by the user.</p>

    EncryptedPassportElement(type: String, data: String, phone_number: String, email: String, files: List<PassportFile>, front_side: PassportFile, reverse_side: PassportFile, selfie: PassportFile, translation: List<PassportFile>, hash: String)

<p>Describes data required for decrypting and authenticating <a href="#encryptedpassportelement">EncryptedPassportElement</a>. See the <a href="/passport#receiving-information">Telegram Passport Documentation</a> for a complete description of the data decryption and authentication processes.</p>

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

    sendGame(business_connection_id: String, chat_id: Integer, message_thread_id: Integer, game_short_name: String, disable_notification: Boolean, protect_content: Boolean, message_effect_id: String, reply_parameters: ReplyParameters, reply_markup: InlineKeyboardMarkup)

<p>Use this method to set the score of the specified user in a game message. On success, if the message is not an inline message, the <a href="#message">Message</a> is returned, otherwise <em>True</em> is returned. Returns an error, if the new score is not greater than the user's current score in the chat and <em>force</em> is <em>False</em>.</p>

    setGameScore(user_id: Integer, score: Integer, force: Boolean, disable_edit_message: Boolean, chat_id: Integer, message_id: Integer, inline_message_id: String)

<p>Use this method to get data for high score tables. Will return the score of the specified user and several of their neighbors in a game. Returns an Array of <a href="#gamehighscore">GameHighScore</a> objects.</p><blockquote>
 <p>This method will currently return scores for the target user, plus two of their closest neighbors on each side. Will also return the top three users if the user and their neighbors are not among them. Please note that this behavior is subject to change.</p>
</blockquote>

    getGameHighScores(user_id: Integer, chat_id: Integer, message_id: Integer, inline_message_id: String)

