# telegram-api-generator
Parse https://core.telegram.org/bots/api page and generate a Kotlin class "DocSection" with "DocType" and "DocMethod"

Example in:

| Format | Generator | Output |
| --- | --- | --- |
| Kotlin | [GeneratorKotlin.kt](src/main/kotlin/GeneratorKotlin.kt) | [TelegramModels.kt](example/TelegramModels.kt) + [TelegramMethods.kt](example/TelegramMethods.kt) | 
| Json | [GeneratorJson.kt](src/main/kotlin/GeneratorJson.kt) | [telegram.json](example/telegram.json) |
| Markdown | [GeneratorReadmeExample.kt](src/main/kotlin/GeneratorReadmeExample.kt) | [telegram.md](example/telegram.md) |
| Build your own ... |


## Kotlin Example

[TelegramMethods.kt](example/TelegramMethods.kt)
```kotlin
sealed class TelegramRequest {

    // Getting updates
    
    @Serializable
    data class GetUpdatesRequest(
        val offset: Int? = null,
        val limit: Int? = null,
        val timeout: Int? = null,
        val allowed_updates: List<String>? = null
    ) : TelegramRequest()
    
    @Serializable
    data class SetWebhookRequest(
        val url: String,
        val certificate: Any? = null,
        val max_connections: Int? = null,
        val allowed_updates: List<String>? = null
    ) : TelegramRequest()
    
    
    // Available methods
    // ...
}

object TelegramMethod {


    // Getting updates

    /**
     * <p>Use this method to receive incoming updates using long polling (<a href="http://en.wikipedia.org/wiki/Push_technology#Long_polling">wiki</a>). An Array of <a href="#update">Update</a> objects is returned.</p><blockquote>
    <p><strong>Notes</strong><br><strong>1.</strong> This method will not work if an outgoing webhook is set up.<br><strong>2.</strong> In order to avoid getting duplicate updates, recalculate <em>offset</em> after each server response.</p>
    </blockquote>
     *
     * @property offset Identifier of the first update to be returned. Must be greater by one than the highest among the identifiers of previously received updates. By default, updates starting with the earliest unconfirmed update are returned. An update is considered confirmed as soon as <a href="#getupdates">getUpdates</a> is called with an <em>offset</em> higher than its <em>update_id</em>. The negative offset can be specified to retrieve updates starting from <em>-offset</em> update from the end of the updates queue. All previous updates will forgotten.
     * @property limit Limits the number of updates to be retrieved. Values between 1—100 are accepted. Defaults to 100.
     * @property timeout Timeout in seconds for long polling. Defaults to 0, i.e. usual short polling. Should be positive, short polling should be used for testing purposes only.
     * @property allowed_updates List the types of updates you want your bot to receive. For example, specify [“message”, “edited_channel_post”, “callback_query”] to only receive updates of these types. See <a href="#update">Update</a> for a complete list of available update types. Specify an empty list to receive all updates regardless of type (default). If not specified, the previous setting will be used.<br><br>Please note that this parameter doesn't affect updates created before the call to the getUpdates, so unwanted updates may be received for a short period of time.
     *
     * @return [List<Update>]
     * */
    fun getUpdates(
        offset: Int? = null,
        limit: Int? = null,
        timeout: Int? = null,
        allowed_updates: List<String>? = null
    ) = telegram(
        "$basePath/getUpdates",
        TelegramRequest.GetUpdatesRequest(
            offset,
            limit,
            timeout,
            allowed_updates
        ).toJsonContent(TelegramRequest.GetUpdatesRequest.serializer()),
        Update.serializer().list
    )

    // ...
}
```

[TelegramModels.kt](example/TelegramModels.kt)
```kotlin
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

// ...
```

## Example Markdown

Below an example generated with [GeneratorReadmeExample.kt](src/main/kotlin/GeneratorReadmeExample.kt)

---


## Getting updates

### Data Types
    Update(update_id: Integer, message: Message, edited_message: Message, channel_post: Message, edited_channel_post: Message, inline_query: InlineQuery, chosen_inline_result: ChosenInlineResult, callback_query: CallbackQuery, shipping_query: ShippingQuery, pre_checkout_query: PreCheckoutQuery)
    WebhookInfo(url: String, has_custom_certificate: Boolean, pending_update_count: Integer, last_error_date: Integer, last_error_message: String, max_connections: Integer, allowed_updates: List<String>)

### Methods
    getUpdates(offset: Integer, limit: Integer, timeout: Integer, allowed_updates: List<String>)
    setWebhook(url: String, certificate: InputFile, max_connections: Integer, allowed_updates: List<String>)
    deleteWebhook()
    getWebhookInfo()


## Available types

### Data Types
    User(id: Integer, is_bot: Boolean, first_name: String, last_name: String, username: String, language_code: String)
    Chat(id: Integer, type: String, title: String, username: String, first_name: String, last_name: String, all_members_are_administrators: Boolean, photo: ChatPhoto, description: String, invite_link: String, pinned_message: Message, sticker_set_name: String, can_set_sticker_set: Boolean)
    Message(message_id: Integer, from: User, date: Integer, chat: Chat, forward_from: User, forward_from_chat: Chat, forward_from_message_id: Integer, forward_signature: String, forward_date: Integer, reply_to_message: Message, edit_date: Integer, media_group_id: String, author_signature: String, text: String, entities: List<MessageEntity>, caption_entities: List<MessageEntity>, audio: Audio, document: Document, animation: Animation, game: Game, photo: List<PhotoSize>, sticker: Sticker, video: Video, voice: Voice, video_note: VideoNote, caption: String, contact: Contact, location: Location, venue: Venue, new_chat_members: List<User>, left_chat_member: User, new_chat_title: String, new_chat_photo: List<PhotoSize>, delete_chat_photo: Boolean, group_chat_created: Boolean, supergroup_chat_created: Boolean, channel_chat_created: Boolean, migrate_to_chat_id: Integer, migrate_from_chat_id: Integer, pinned_message: Message, invoice: Invoice, successful_payment: SuccessfulPayment, connected_website: String, passport_data: PassportData)
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
    UserProfilePhotos(total_count: Integer, photos: List<List<PhotoSize>>)
    File(file_id: String, file_size: Integer, file_path: String)
    ReplyKeyboardMarkup(keyboard: List<List<KeyboardButton>>, resize_keyboard: Boolean, one_time_keyboard: Boolean, selective: Boolean)
    KeyboardButton(text: String, request_contact: Boolean, request_location: Boolean)
    ReplyKeyboardRemove(remove_keyboard: Boolean, selective: Boolean)
    InlineKeyboardMarkup(inline_keyboard: List<List<InlineKeyboardButton>>)
    InlineKeyboardButton(text: String, url: String, callback_data: String, switch_inline_query: String, switch_inline_query_current_chat: String, callback_game: CallbackGame, pay: Boolean)
    CallbackQuery(id: String, from: User, message: Message, inline_message_id: String, chat_instance: String, data: String, game_short_name: String)
    ForceReply(force_reply: Boolean, selective: Boolean)
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
    sendMediaGroup(chat_id: Integer or String, media: List<InputMediaPhoto and InputMediaVideo>, disable_notification: Boolean, reply_to_message_id: Integer)
    sendLocation(chat_id: Integer or String, latitude: Float, longitude: Float, live_period: Integer, disable_notification: Boolean, reply_to_message_id: Integer, reply_markup: InlineKeyboardMarkup or ReplyKeyboardMarkup or ReplyKeyboardRemove or ForceReply)
    editMessageLiveLocation(chat_id: Integer or String, message_id: Integer, inline_message_id: String, latitude: Float, longitude: Float, reply_markup: InlineKeyboardMarkup)
    stopMessageLiveLocation(chat_id: Integer or String, message_id: Integer, inline_message_id: String, reply_markup: InlineKeyboardMarkup)
    sendVenue(chat_id: Integer or String, latitude: Float, longitude: Float, title: String, address: String, foursquare_id: String, foursquare_type: String, disable_notification: Boolean, reply_to_message_id: Integer, reply_markup: InlineKeyboardMarkup or ReplyKeyboardMarkup or ReplyKeyboardRemove or ForceReply)
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
    StickerSet(name: String, title: String, contains_masks: Boolean, stickers: List<Sticker>)
    MaskPosition(point: String, x_shift: Float, y_shift: Float, scale: Float)

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
    InlineQueryResultLocation(type: String, id: String, latitude: Float, longitude: Float, title: String, live_period: Integer, reply_markup: InlineKeyboardMarkup, input_message_content: InputMessageContent, thumb_url: String, thumb_width: Integer, thumb_height: Integer)
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
    answerInlineQuery(inline_query_id: String, results: List<InlineQueryResult>, cache_time: Integer, is_personal: Boolean, next_offset: String, switch_pm_text: String, switch_pm_parameter: String)


## Payments

### Data Types
    LabeledPrice(label: String, amount: Integer)
    Invoice(title: String, description: String, start_parameter: String, currency: String, total_amount: Integer)
    ShippingAddress(country_code: String, state: String, city: String, street_line1: String, street_line2: String, post_code: String)
    OrderInfo(name: String, phone_number: String, email: String, shipping_address: ShippingAddress)
    ShippingOption(id: String, title: String, prices: List<LabeledPrice>)
    SuccessfulPayment(currency: String, total_amount: Integer, invoice_payload: String, shipping_option_id: String, order_info: OrderInfo, telegram_payment_charge_id: String, provider_payment_charge_id: String)
    ShippingQuery(id: String, from: User, invoice_payload: String, shipping_address: ShippingAddress)
    PreCheckoutQuery(id: String, from: User, currency: String, total_amount: Integer, invoice_payload: String, shipping_option_id: String, order_info: OrderInfo)

### Methods
    sendInvoice(chat_id: Integer, title: String, description: String, payload: String, provider_token: String, start_parameter: String, currency: String, prices: List<LabeledPrice>, provider_data: String, photo_url: String, photo_size: Integer, photo_width: Integer, photo_height: Integer, need_name: Boolean, need_phone_number: Boolean, need_email: Boolean, need_shipping_address: Boolean, send_phone_number_to_provider: Boolean, send_email_to_provider: Boolean, is_flexible: Boolean, disable_notification: Boolean, reply_to_message_id: Integer, reply_markup: InlineKeyboardMarkup)
    answerShippingQuery(shipping_query_id: String, ok: Boolean, shipping_options: List<ShippingOption>, error_message: String)
    answerPreCheckoutQuery(pre_checkout_query_id: String, ok: Boolean, error_message: String)


## Telegram Passport

### Data Types
    PassportData(data: List<EncryptedPassportElement>, credentials: EncryptedCredentials)
    PassportFile(file_id: String, file_size: Integer, file_date: Integer)
    EncryptedPassportElement(type: String, data: String, phone_number: String, email: String, files: List<PassportFile>, front_side: PassportFile, reverse_side: PassportFile, selfie: PassportFile, translation: List<PassportFile>, hash: String)
    EncryptedCredentials(data: String, hash: String, secret: String)
    PassportElementErrorDataField(source: String, type: String, field_name: String, data_hash: String, message: String)
    PassportElementErrorFrontSide(source: String, type: String, file_hash: String, message: String)
    PassportElementErrorReverseSide(source: String, type: String, file_hash: String, message: String)
    PassportElementErrorSelfie(source: String, type: String, file_hash: String, message: String)
    PassportElementErrorFile(source: String, type: String, file_hash: String, message: String)
    PassportElementErrorFiles(source: String, type: String, file_hashes: List<String>, message: String)
    PassportElementErrorTranslationFile(source: String, type: String, file_hash: String, message: String)
    PassportElementErrorTranslationFiles(source: String, type: String, file_hashes: List<String>, message: String)
    PassportElementErrorUnspecified(source: String, type: String, element_hash: String, message: String)

### Methods
    setPassportDataErrors(user_id: Integer, errors: List<PassportElementError>)


## Games

### Data Types
    Game(title: String, description: String, photo: List<PhotoSize>, text: String, text_entities: List<MessageEntity>, animation: Animation)
    GameHighScore(position: Integer, user: User, score: Integer)

### Methods
    sendGame(chat_id: Integer, game_short_name: String, disable_notification: Boolean, reply_to_message_id: Integer, reply_markup: InlineKeyboardMarkup)
    setGameScore(user_id: Integer, score: Integer, force: Boolean, disable_edit_message: Boolean, chat_id: Integer, message_id: Integer, inline_message_id: String)
    getGameHighScores(user_id: Integer, chat_id: Integer, message_id: Integer, inline_message_id: String)
