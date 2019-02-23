# telegram-api-generator
Parse https://core.telegram.org/bots/api page and generate a Kotlin class "Section" with "Type" and "Method"

Below an example generated with [TelegramApiGenerator.kt](src/main/kotlin/TelegramApiGenerator.kt)

---


## Getting updates

### Data Types
    Update(update_id: Integer, message: Message, edited_message: Message, channel_post: Message, edited_channel_post: Message, inline_query: InlineQuery, chosen_inline_result: ChosenInlineResult, callback_query: CallbackQuery, shipping_query: ShippingQuery, pre_checkout_query: PreCheckoutQuery)
    WebhookInfo(url: String, has_custom_certificate: Boolean, pending_update_count: Integer, last_error_date: Integer, last_error_message: String, max_connections: Integer, allowed_updates: Array of String)

### Methods
    getUpdates(offset: Integer, limit: Integer, timeout: Integer, allowed_updates: Array of String)
    setWebhook(url: String, certificate: InputFile, max_connections: Integer, allowed_updates: Array of String)
    deleteWebhook()
    getWebhookInfo()


## Available types

### Data Types
    User(id: Integer, is_bot: Boolean, first_name: String, last_name: String, username: String, language_code: String)
    Chat(id: Integer, type: String, title: String, username: String, first_name: String, last_name: String, all_members_are_administrators: Boolean, photo: ChatPhoto, description: String, invite_link: String, pinned_message: Message, sticker_set_name: String, can_set_sticker_set: Boolean)
    Message(message_id: Integer, from: User, date: Integer, chat: Chat, forward_from: User, forward_from_chat: Chat, forward_from_message_id: Integer, forward_signature: String, forward_date: Integer, reply_to_message: Message, edit_date: Integer, media_group_id: String, author_signature: String, text: String, entities: Array of MessageEntity, caption_entities: Array of MessageEntity, audio: Audio, document: Document, animation: Animation, game: Game, photo: Array of PhotoSize, sticker: Sticker, video: Video, voice: Voice, video_note: VideoNote, caption: String, contact: Contact, location: Location, venue: Venue, new_chat_members: Array of User, left_chat_member: User, new_chat_title: String, new_chat_photo: Array of PhotoSize, delete_chat_photo: True, group_chat_created: True, supergroup_chat_created: True, channel_chat_created: True, migrate_to_chat_id: Integer, migrate_from_chat_id: Integer, pinned_message: Message, invoice: Invoice, successful_payment: SuccessfulPayment, connected_website: String, passport_data: PassportData)
    MessageEntity(type: String, offset: Integer, length: Integer, url: String, user: User)
    PhotoSize(file_id: String, width: Integer, height: Integer, file_size: Integer)
    Audio(file_id: String, duration: Integer, performer: String, title: String, mime_type: String, file_size: Integer, thumb: PhotoSize)
    Document(file_id: String, thumb: PhotoSize, file_name: String, mime_type: String, file_size: Integer)
    Video(file_id: String, width: Integer, height: Integer, duration: Integer, thumb: PhotoSize, mime_type: String, file_size: Integer)
    Animation(file_id: String, width: Integer, height: Integer, duration: Integer, thumb: PhotoSize, file_name: String, mime_type: String, file_size: Integer)
    Voice(file_id: String, duration: Integer, mime_type: String, file_size: Integer)
    VideoNote(file_id: String, length: Integer, duration: Integer, thumb: PhotoSize, file_size: Integer)
    Contact(phone_number: String, first_name: String, last_name: String, user_id: Integer, vcard: String)
    Location(longitude: Float, latitude: Float)
    Venue(location: Location, title: String, address: String, foursquare_id: String, foursquare_type: String)
    UserProfilePhotos(total_count: Integer, photos: Array of Array of PhotoSize)
    File(file_id: String, file_size: Integer, file_path: String)
    ReplyKeyboardMarkup(keyboard: Array of Array of KeyboardButton, resize_keyboard: Boolean, one_time_keyboard: Boolean, selective: Boolean)
    KeyboardButton(text: String, request_contact: Boolean, request_location: Boolean)
    ReplyKeyboardRemove(remove_keyboard: True, selective: Boolean)
    InlineKeyboardMarkup(inline_keyboard: Array of Array of InlineKeyboardButton)
    InlineKeyboardButton(text: String, url: String, callback_data: String, switch_inline_query: String, switch_inline_query_current_chat: String, callback_game: CallbackGame, pay: Boolean)
    CallbackQuery(id: String, from: User, message: Message, inline_message_id: String, chat_instance: String, data: String, game_short_name: String)
    ForceReply(force_reply: True, selective: Boolean)
    ChatPhoto(small_file_id: String, big_file_id: String)
    ChatMember(user: User, status: String, until_date: Integer, can_be_edited: Boolean, can_change_info: Boolean, can_post_messages: Boolean, can_edit_messages: Boolean, can_delete_messages: Boolean, can_invite_users: Boolean, can_restrict_members: Boolean, can_pin_messages: Boolean, can_promote_members: Boolean, can_send_messages: Boolean, can_send_media_messages: Boolean, can_send_other_messages: Boolean, can_add_web_page_previews: Boolean)
    ResponseParameters(migrate_to_chat_id: Integer, retry_after: Integer)
    InputMediaPhoto(type: String, media: String, caption: String, parse_mode: String)
    InputMediaVideo(type: String, media: String, thumb: InputFile or String, caption: String, parse_mode: String, width: Integer, height: Integer, duration: Integer, supports_streaming: Boolean)
    InputMediaAnimation(type: String, media: String, thumb: InputFile or String, caption: String, parse_mode: String, width: Integer, height: Integer, duration: Integer)
    InputMediaAudio(type: String, media: String, thumb: InputFile or String, caption: String, parse_mode: String, duration: Integer, performer: String, title: String)
    InputMediaDocument(type: String, media: String, thumb: InputFile or String, caption: String, parse_mode: String)


## Available methods

### Methods
    sendMessage(chat_id: Integer or String, text: String, parse_mode: String, disable_web_page_preview: Boolean, disable_notification: Boolean, reply_to_message_id: Integer, reply_markup: InlineKeyboardMarkup or ReplyKeyboardMarkup or ReplyKeyboardRemove or ForceReply)
    forwardMessage(chat_id: Integer or String, from_chat_id: Integer or String, disable_notification: Boolean, message_id: Integer)
    sendPhoto(chat_id: Integer or String, photo: InputFile or String, caption: String, parse_mode: String, disable_notification: Boolean, reply_to_message_id: Integer, reply_markup: InlineKeyboardMarkup or ReplyKeyboardMarkup or ReplyKeyboardRemove or ForceReply)
    sendAudio(chat_id: Integer or String, audio: InputFile or String, caption: String, parse_mode: String, duration: Integer, performer: String, title: String, thumb: InputFile or String, disable_notification: Boolean, reply_to_message_id: Integer, reply_markup: InlineKeyboardMarkup or ReplyKeyboardMarkup or ReplyKeyboardRemove or ForceReply)
    sendDocument(chat_id: Integer or String, document: InputFile or String, thumb: InputFile or String, caption: String, parse_mode: String, disable_notification: Boolean, reply_to_message_id: Integer, reply_markup: InlineKeyboardMarkup or ReplyKeyboardMarkup or ReplyKeyboardRemove or ForceReply)
    sendVideo(chat_id: Integer or String, video: InputFile or String, duration: Integer, width: Integer, height: Integer, thumb: InputFile or String, caption: String, parse_mode: String, supports_streaming: Boolean, disable_notification: Boolean, reply_to_message_id: Integer, reply_markup: InlineKeyboardMarkup or ReplyKeyboardMarkup or ReplyKeyboardRemove or ForceReply)
    sendAnimation(chat_id: Integer or String, animation: InputFile or String, duration: Integer, width: Integer, height: Integer, thumb: InputFile or String, caption: String, parse_mode: String, disable_notification: Boolean, reply_to_message_id: Integer, reply_markup: InlineKeyboardMarkup or ReplyKeyboardMarkup or ReplyKeyboardRemove or ForceReply)
    sendVoice(chat_id: Integer or String, voice: InputFile or String, caption: String, parse_mode: String, duration: Integer, disable_notification: Boolean, reply_to_message_id: Integer, reply_markup: InlineKeyboardMarkup or ReplyKeyboardMarkup or ReplyKeyboardRemove or ForceReply)
    sendVideoNote(chat_id: Integer or String, video_note: InputFile or String, duration: Integer, length: Integer, thumb: InputFile or String, disable_notification: Boolean, reply_to_message_id: Integer, reply_markup: InlineKeyboardMarkup or ReplyKeyboardMarkup or ReplyKeyboardRemove or ForceReply)
    sendMediaGroup(chat_id: Integer or String, media: Array of InputMediaPhoto and InputMediaVideo, disable_notification: Boolean, reply_to_message_id: Integer)
    sendLocation(chat_id: Integer or String, latitude: Float number, longitude: Float number, live_period: Integer, disable_notification: Boolean, reply_to_message_id: Integer, reply_markup: InlineKeyboardMarkup or ReplyKeyboardMarkup or ReplyKeyboardRemove or ForceReply)
    editMessageLiveLocation(chat_id: Integer or String, message_id: Integer, inline_message_id: String, latitude: Float number, longitude: Float number, reply_markup: InlineKeyboardMarkup)
    stopMessageLiveLocation(chat_id: Integer or String, message_id: Integer, inline_message_id: String, reply_markup: InlineKeyboardMarkup)
    sendVenue(chat_id: Integer or String, latitude: Float number, longitude: Float number, title: String, address: String, foursquare_id: String, foursquare_type: String, disable_notification: Boolean, reply_to_message_id: Integer, reply_markup: InlineKeyboardMarkup or ReplyKeyboardMarkup or ReplyKeyboardRemove or ForceReply)
    sendContact(chat_id: Integer or String, phone_number: String, first_name: String, last_name: String, vcard: String, disable_notification: Boolean, reply_to_message_id: Integer, reply_markup: InlineKeyboardMarkup or ReplyKeyboardMarkup or ReplyKeyboardRemove or ForceReply)
    sendChatAction(chat_id: Integer or String, action: String)
    getUserProfilePhotos(user_id: Integer, offset: Integer, limit: Integer)
    getFile(file_id: String)
    kickChatMember(chat_id: Integer or String, user_id: Integer, until_date: Integer)
    unbanChatMember(chat_id: Integer or String, user_id: Integer)
    restrictChatMember(chat_id: Integer or String, user_id: Integer, until_date: Integer, can_send_messages: Boolean, can_send_media_messages: Boolean, can_send_other_messages: Boolean, can_add_web_page_previews: Boolean)
    promoteChatMember(chat_id: Integer or String, user_id: Integer, can_change_info: Boolean, can_post_messages: Boolean, can_edit_messages: Boolean, can_delete_messages: Boolean, can_invite_users: Boolean, can_restrict_members: Boolean, can_pin_messages: Boolean, can_promote_members: Boolean)
    exportChatInviteLink(chat_id: Integer or String)
    setChatPhoto(chat_id: Integer or String, photo: InputFile)
    deleteChatPhoto(chat_id: Integer or String)
    setChatTitle(chat_id: Integer or String, title: String)
    setChatDescription(chat_id: Integer or String, description: String)
    pinChatMessage(chat_id: Integer or String, message_id: Integer, disable_notification: Boolean)
    unpinChatMessage(chat_id: Integer or String)
    leaveChat(chat_id: Integer or String)
    getChat(chat_id: Integer or String)
    getChatAdministrators(chat_id: Integer or String)
    getChatMembersCount(chat_id: Integer or String)
    getChatMember(chat_id: Integer or String, user_id: Integer)
    setChatStickerSet(chat_id: Integer or String, sticker_set_name: String)
    deleteChatStickerSet(chat_id: Integer or String)
    answerCallbackQuery(callback_query_id: String, text: String, show_alert: Boolean, url: String, cache_time: Integer)


## Updating messages

### Methods
    editMessageText(chat_id: Integer or String, message_id: Integer, inline_message_id: String, text: String, parse_mode: String, disable_web_page_preview: Boolean, reply_markup: InlineKeyboardMarkup)
    editMessageCaption(chat_id: Integer or String, message_id: Integer, inline_message_id: String, caption: String, parse_mode: String, reply_markup: InlineKeyboardMarkup)
    editMessageMedia(chat_id: Integer or String, message_id: Integer, inline_message_id: String, media: InputMedia, reply_markup: InlineKeyboardMarkup)
    editMessageReplyMarkup(chat_id: Integer or String, message_id: Integer, inline_message_id: String, reply_markup: InlineKeyboardMarkup)
    deleteMessage(chat_id: Integer or String, message_id: Integer)


## Stickers

### Data Types
    Sticker(file_id: String, width: Integer, height: Integer, thumb: PhotoSize, emoji: String, set_name: String, mask_position: MaskPosition, file_size: Integer)
    StickerSet(name: String, title: String, contains_masks: Boolean, stickers: Array of Sticker)
    MaskPosition(point: String, x_shift: Float number, y_shift: Float number, scale: Float number)

### Methods
    sendSticker(chat_id: Integer or String, sticker: InputFile or String, disable_notification: Boolean, reply_to_message_id: Integer, reply_markup: InlineKeyboardMarkup or ReplyKeyboardMarkup or ReplyKeyboardRemove or ForceReply)
    getStickerSet(name: String)
    uploadStickerFile(user_id: Integer, png_sticker: InputFile)
    createNewStickerSet(user_id: Integer, name: String, title: String, png_sticker: InputFile or String, emojis: String, contains_masks: Boolean, mask_position: MaskPosition)
    addStickerToSet(user_id: Integer, name: String, png_sticker: InputFile or String, emojis: String, mask_position: MaskPosition)
    setStickerPositionInSet(sticker: String, position: Integer)
    deleteStickerFromSet(sticker: String)


## Inline mode

### Data Types
    InlineQuery(id: String, from: User, location: Location, query: String, offset: String)
    InlineQueryResultArticle(type: String, id: String, title: String, input_message_content: InputMessageContent, reply_markup: InlineKeyboardMarkup, url: String, hide_url: Boolean, description: String, thumb_url: String, thumb_width: Integer, thumb_height: Integer)
    InlineQueryResultPhoto(type: String, id: String, photo_url: String, thumb_url: String, photo_width: Integer, photo_height: Integer, title: String, description: String, caption: String, parse_mode: String, reply_markup: InlineKeyboardMarkup, input_message_content: InputMessageContent)
    InlineQueryResultGif(type: String, id: String, gif_url: String, gif_width: Integer, gif_height: Integer, gif_duration: Integer, thumb_url: String, title: String, caption: String, parse_mode: String, reply_markup: InlineKeyboardMarkup, input_message_content: InputMessageContent)
    InlineQueryResultMpeg4Gif(type: String, id: String, mpeg4_url: String, mpeg4_width: Integer, mpeg4_height: Integer, mpeg4_duration: Integer, thumb_url: String, title: String, caption: String, parse_mode: String, reply_markup: InlineKeyboardMarkup, input_message_content: InputMessageContent)
    InlineQueryResultVideo(type: String, id: String, video_url: String, mime_type: String, thumb_url: String, title: String, caption: String, parse_mode: String, video_width: Integer, video_height: Integer, video_duration: Integer, description: String, reply_markup: InlineKeyboardMarkup, input_message_content: InputMessageContent)
    InlineQueryResultAudio(type: String, id: String, audio_url: String, title: String, caption: String, parse_mode: String, performer: String, audio_duration: Integer, reply_markup: InlineKeyboardMarkup, input_message_content: InputMessageContent)
    InlineQueryResultVoice(type: String, id: String, voice_url: String, title: String, caption: String, parse_mode: String, voice_duration: Integer, reply_markup: InlineKeyboardMarkup, input_message_content: InputMessageContent)
    InlineQueryResultDocument(type: String, id: String, title: String, caption: String, parse_mode: String, document_url: String, mime_type: String, description: String, reply_markup: InlineKeyboardMarkup, input_message_content: InputMessageContent, thumb_url: String, thumb_width: Integer, thumb_height: Integer)
    InlineQueryResultLocation(type: String, id: String, latitude: Float number, longitude: Float number, title: String, live_period: Integer, reply_markup: InlineKeyboardMarkup, input_message_content: InputMessageContent, thumb_url: String, thumb_width: Integer, thumb_height: Integer)
    InlineQueryResultVenue(type: String, id: String, latitude: Float, longitude: Float, title: String, address: String, foursquare_id: String, foursquare_type: String, reply_markup: InlineKeyboardMarkup, input_message_content: InputMessageContent, thumb_url: String, thumb_width: Integer, thumb_height: Integer)
    InlineQueryResultContact(type: String, id: String, phone_number: String, first_name: String, last_name: String, vcard: String, reply_markup: InlineKeyboardMarkup, input_message_content: InputMessageContent, thumb_url: String, thumb_width: Integer, thumb_height: Integer)
    InlineQueryResultGame(type: String, id: String, game_short_name: String, reply_markup: InlineKeyboardMarkup)
    InlineQueryResultCachedPhoto(type: String, id: String, photo_file_id: String, title: String, description: String, caption: String, parse_mode: String, reply_markup: InlineKeyboardMarkup, input_message_content: InputMessageContent)
    InlineQueryResultCachedGif(type: String, id: String, gif_file_id: String, title: String, caption: String, parse_mode: String, reply_markup: InlineKeyboardMarkup, input_message_content: InputMessageContent)
    InlineQueryResultCachedMpeg4Gif(type: String, id: String, mpeg4_file_id: String, title: String, caption: String, parse_mode: String, reply_markup: InlineKeyboardMarkup, input_message_content: InputMessageContent)
    InlineQueryResultCachedSticker(type: String, id: String, sticker_file_id: String, reply_markup: InlineKeyboardMarkup, input_message_content: InputMessageContent)
    InlineQueryResultCachedDocument(type: String, id: String, title: String, document_file_id: String, description: String, caption: String, parse_mode: String, reply_markup: InlineKeyboardMarkup, input_message_content: InputMessageContent)
    InlineQueryResultCachedVideo(type: String, id: String, video_file_id: String, title: String, description: String, caption: String, parse_mode: String, reply_markup: InlineKeyboardMarkup, input_message_content: InputMessageContent)
    InlineQueryResultCachedVoice(type: String, id: String, voice_file_id: String, title: String, caption: String, parse_mode: String, reply_markup: InlineKeyboardMarkup, input_message_content: InputMessageContent)
    InlineQueryResultCachedAudio(type: String, id: String, audio_file_id: String, caption: String, parse_mode: String, reply_markup: InlineKeyboardMarkup, input_message_content: InputMessageContent)
    InputTextMessageContent(message_text: String, parse_mode: String, disable_web_page_preview: Boolean)
    InputLocationMessageContent(latitude: Float, longitude: Float, live_period: Integer)
    InputVenueMessageContent(latitude: Float, longitude: Float, title: String, address: String, foursquare_id: String, foursquare_type: String)
    InputContactMessageContent(phone_number: String, first_name: String, last_name: String, vcard: String)
    ChosenInlineResult(result_id: String, from: User, location: Location, inline_message_id: String, query: String)

### Methods
    answerInlineQuery(inline_query_id: String, results: Array of InlineQueryResult, cache_time: Integer, is_personal: Boolean, next_offset: String, switch_pm_text: String, switch_pm_parameter: String)


## Payments

### Data Types
    LabeledPrice(label: String, amount: Integer)
    Invoice(title: String, description: String, start_parameter: String, currency: String, total_amount: Integer)
    ShippingAddress(country_code: String, state: String, city: String, street_line1: String, street_line2: String, post_code: String)
    OrderInfo(name: String, phone_number: String, email: String, shipping_address: ShippingAddress)
    ShippingOption(id: String, title: String, prices: Array of LabeledPrice)
    SuccessfulPayment(currency: String, total_amount: Integer, invoice_payload: String, shipping_option_id: String, order_info: OrderInfo, telegram_payment_charge_id: String, provider_payment_charge_id: String)
    ShippingQuery(id: String, from: User, invoice_payload: String, shipping_address: ShippingAddress)
    PreCheckoutQuery(id: String, from: User, currency: String, total_amount: Integer, invoice_payload: String, shipping_option_id: String, order_info: OrderInfo)

### Methods
    sendInvoice(chat_id: Integer, title: String, description: String, payload: String, provider_token: String, start_parameter: String, currency: String, prices: Array of LabeledPrice, provider_data: String, photo_url: String, photo_size: Integer, photo_width: Integer, photo_height: Integer, need_name: Boolean, need_phone_number: Boolean, need_email: Boolean, need_shipping_address: Boolean, send_phone_number_to_provider: Boolean, send_email_to_provider: Boolean, is_flexible: Boolean, disable_notification: Boolean, reply_to_message_id: Integer, reply_markup: InlineKeyboardMarkup)
    answerShippingQuery(shipping_query_id: String, ok: Boolean, shipping_options: Array of ShippingOption, error_message: String)
    answerPreCheckoutQuery(pre_checkout_query_id: String, ok: Boolean, error_message: String)


## Telegram Passport

### Data Types
    PassportData(data: Array of EncryptedPassportElement, credentials: EncryptedCredentials)
    PassportFile(file_id: String, file_size: Integer, file_date: Integer)
    EncryptedPassportElement(type: String, data: String, phone_number: String, email: String, files: Array of PassportFile, front_side: PassportFile, reverse_side: PassportFile, selfie: PassportFile, translation: Array of PassportFile, hash: String)
    EncryptedCredentials(data: String, hash: String, secret: String)
    PassportElementErrorDataField(source: String, type: String, field_name: String, data_hash: String, message: String)
    PassportElementErrorFrontSide(source: String, type: String, file_hash: String, message: String)
    PassportElementErrorReverseSide(source: String, type: String, file_hash: String, message: String)
    PassportElementErrorSelfie(source: String, type: String, file_hash: String, message: String)
    PassportElementErrorFile(source: String, type: String, file_hash: String, message: String)
    PassportElementErrorFiles(source: String, type: String, file_hashes: Array of String, message: String)
    PassportElementErrorTranslationFile(source: String, type: String, file_hash: String, message: String)
    PassportElementErrorTranslationFiles(source: String, type: String, file_hashes: Array of String, message: String)
    PassportElementErrorUnspecified(source: String, type: String, element_hash: String, message: String)

### Methods
    setPassportDataErrors(user_id: Integer, errors: Array of PassportElementError)


## Games

### Data Types
    Game(title: String, description: String, photo: Array of PhotoSize, text: String, text_entities: Array of MessageEntity, animation: Animation)
    GameHighScore(position: Integer, user: User, score: Integer)

### Methods
    sendGame(chat_id: Integer, game_short_name: String, disable_notification: Boolean, reply_to_message_id: Integer, reply_markup: InlineKeyboardMarkup)
    setGameScore(user_id: Integer, score: Integer, force: Boolean, disable_edit_message: Boolean, chat_id: Integer, message_id: Integer, inline_message_id: String)
    getGameHighScores(user_id: Integer, chat_id: Integer, message_id: Integer, inline_message_id: String)
