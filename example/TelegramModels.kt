package com.github.jacklt.gae.ktor.tg.appengine.telegram

import kotlinx.serialization.Optional
import kotlinx.serialization.Serializable

sealed class TelegramModel


// Getting updates

@Serializable
data class Update(
    val update_id: Int,
    @Optional val message: Message? = null,
    @Optional val edited_message: Message? = null,
    @Optional val channel_post: Message? = null,
    @Optional val edited_channel_post: Message? = null,
    @Optional val inline_query: InlineQuery? = null,
    @Optional val chosen_inline_result: ChosenInlineResult? = null,
    @Optional val callback_query: CallbackQuery? = null,
    @Optional val shipping_query: ShippingQuery? = null,
    @Optional val pre_checkout_query: PreCheckoutQuery? = null
) : TelegramModel()

@Serializable
data class WebhookInfo(
    val url: String,
    val has_custom_certificate: Boolean,
    val pending_update_count: Int,
    @Optional val last_error_date: Int? = null,
    @Optional val last_error_message: String? = null,
    @Optional val max_connections: Int? = null,
    @Optional val allowed_updates: List<String>? = null
) : TelegramModel()



// Available types

@Serializable
data class User(
    val id: Int,
    val is_bot: Boolean,
    val first_name: String,
    @Optional val last_name: String? = null,
    @Optional val username: String? = null,
    @Optional val language_code: String? = null
) : TelegramModel()

@Serializable
data class Chat(
    val id: Int,
    val type: String,
    @Optional val title: String? = null,
    @Optional val username: String? = null,
    @Optional val first_name: String? = null,
    @Optional val last_name: String? = null,
    @Optional val all_members_are_administrators: Boolean? = null,
    @Optional val photo: ChatPhoto? = null,
    @Optional val description: String? = null,
    @Optional val invite_link: String? = null,
    @Optional val pinned_message: Message? = null,
    @Optional val sticker_set_name: String? = null,
    @Optional val can_set_sticker_set: Boolean? = null
) : TelegramModel()

@Serializable
data class Message(
    val message_id: Int,
    @Optional val from: User? = null,
    val date: Int,
    val chat: Chat,
    @Optional val forward_from: User? = null,
    @Optional val forward_from_chat: Chat? = null,
    @Optional val forward_from_message_id: Int? = null,
    @Optional val forward_signature: String? = null,
    @Optional val forward_date: Int? = null,
    @Optional val reply_to_message: Message? = null,
    @Optional val edit_date: Int? = null,
    @Optional val media_group_id: String? = null,
    @Optional val author_signature: String? = null,
    @Optional val text: String? = null,
    @Optional val entities: List<MessageEntity>? = null,
    @Optional val caption_entities: List<MessageEntity>? = null,
    @Optional val audio: Audio? = null,
    @Optional val document: Document? = null,
    @Optional val animation: Animation? = null,
    @Optional val game: Game? = null,
    @Optional val photo: List<PhotoSize>? = null,
    @Optional val sticker: Sticker? = null,
    @Optional val video: Video? = null,
    @Optional val voice: Voice? = null,
    @Optional val video_note: VideoNote? = null,
    @Optional val caption: String? = null,
    @Optional val contact: Contact? = null,
    @Optional val location: Location? = null,
    @Optional val venue: Venue? = null,
    @Optional val new_chat_members: List<User>? = null,
    @Optional val left_chat_member: User? = null,
    @Optional val new_chat_title: String? = null,
    @Optional val new_chat_photo: List<PhotoSize>? = null,
    @Optional val delete_chat_photo: Boolean? = null,
    @Optional val group_chat_created: Boolean? = null,
    @Optional val supergroup_chat_created: Boolean? = null,
    @Optional val channel_chat_created: Boolean? = null,
    @Optional val migrate_to_chat_id: Int? = null,
    @Optional val migrate_from_chat_id: Int? = null,
    @Optional val pinned_message: Message? = null,
    @Optional val invoice: Invoice? = null,
    @Optional val successful_payment: SuccessfulPayment? = null,
    @Optional val connected_website: String? = null,
    @Optional val passport_data: PassportData? = null
) : TelegramModel()

@Serializable
data class MessageEntity(
    val type: String,
    val offset: Int,
    val length: Int,
    @Optional val url: String? = null,
    @Optional val user: User? = null
) : TelegramModel()

@Serializable
data class PhotoSize(
    val file_id: String,
    val width: Int,
    val height: Int,
    @Optional val file_size: Int? = null
) : TelegramModel()

@Serializable
data class Audio(
    val file_id: String,
    val duration: Int,
    @Optional val performer: String? = null,
    @Optional val title: String? = null,
    @Optional val mime_type: String? = null,
    @Optional val file_size: Int? = null,
    @Optional val thumb: PhotoSize? = null
) : TelegramModel()

@Serializable
data class Document(
    val file_id: String,
    @Optional val thumb: PhotoSize? = null,
    @Optional val file_name: String? = null,
    @Optional val mime_type: String? = null,
    @Optional val file_size: Int? = null
) : TelegramModel()

@Serializable
data class Video(
    val file_id: String,
    val width: Int,
    val height: Int,
    val duration: Int,
    @Optional val thumb: PhotoSize? = null,
    @Optional val mime_type: String? = null,
    @Optional val file_size: Int? = null
) : TelegramModel()

@Serializable
data class Animation(
    val file_id: String,
    val width: Int,
    val height: Int,
    val duration: Int,
    @Optional val thumb: PhotoSize? = null,
    @Optional val file_name: String? = null,
    @Optional val mime_type: String? = null,
    @Optional val file_size: Int? = null
) : TelegramModel()

@Serializable
data class Voice(
    val file_id: String,
    val duration: Int,
    @Optional val mime_type: String? = null,
    @Optional val file_size: Int? = null
) : TelegramModel()

@Serializable
data class VideoNote(
    val file_id: String,
    val length: Int,
    val duration: Int,
    @Optional val thumb: PhotoSize? = null,
    @Optional val file_size: Int? = null
) : TelegramModel()

@Serializable
data class Contact(
    val phone_number: String,
    val first_name: String,
    @Optional val last_name: String? = null,
    @Optional val user_id: Int? = null,
    @Optional val vcard: String? = null
) : TelegramModel()

@Serializable
data class Location(
    val longitude: Float,
    val latitude: Float
) : TelegramModel()

@Serializable
data class Venue(
    val location: Location,
    val title: String,
    val address: String,
    @Optional val foursquare_id: String? = null,
    @Optional val foursquare_type: String? = null
) : TelegramModel()

@Serializable
data class UserProfilePhotos(
    val total_count: Int,
    val photos: List<List<PhotoSize>>
) : TelegramModel()

@Serializable
data class File(
    val file_id: String,
    @Optional val file_size: Int? = null,
    @Optional val file_path: String? = null
) : TelegramModel()

@Serializable
data class ReplyKeyboardMarkup(
    val keyboard: List<List<KeyboardButton>>,
    @Optional val resize_keyboard: Boolean? = null,
    @Optional val one_time_keyboard: Boolean? = null,
    @Optional val selective: Boolean? = null
) : TelegramModel()

@Serializable
data class KeyboardButton(
    val text: String,
    @Optional val request_contact: Boolean? = null,
    @Optional val request_location: Boolean? = null
) : TelegramModel()

@Serializable
data class ReplyKeyboardRemove(
    val remove_keyboard: Boolean,
    @Optional val selective: Boolean? = null
) : TelegramModel()

@Serializable
data class InlineKeyboardMarkup(
    val inline_keyboard: List<List<InlineKeyboardButton>>
) : TelegramModel()

@Serializable
data class InlineKeyboardButton(
    val text: String,
    @Optional val url: String? = null,
    @Optional val callback_data: String? = null,
    @Optional val switch_inline_query: String? = null,
    @Optional val switch_inline_query_current_chat: String? = null,
    @Optional val callback_game: Any? = null,
    @Optional val pay: Boolean? = null
) : TelegramModel()

@Serializable
data class CallbackQuery(
    val id: String,
    val from: User,
    @Optional val message: Message? = null,
    @Optional val inline_message_id: String? = null,
    val chat_instance: String,
    @Optional val data: String? = null,
    @Optional val game_short_name: String? = null
) : TelegramModel()

@Serializable
data class ForceReply(
    val force_reply: Boolean,
    @Optional val selective: Boolean? = null
) : TelegramModel()

@Serializable
data class ChatPhoto(
    val small_file_id: String,
    val big_file_id: String
) : TelegramModel()

@Serializable
data class ChatMember(
    val user: User,
    val status: String,
    @Optional val until_date: Int? = null,
    @Optional val can_be_edited: Boolean? = null,
    @Optional val can_change_info: Boolean? = null,
    @Optional val can_post_messages: Boolean? = null,
    @Optional val can_edit_messages: Boolean? = null,
    @Optional val can_delete_messages: Boolean? = null,
    @Optional val can_invite_users: Boolean? = null,
    @Optional val can_restrict_members: Boolean? = null,
    @Optional val can_pin_messages: Boolean? = null,
    @Optional val can_promote_members: Boolean? = null,
    @Optional val can_send_messages: Boolean? = null,
    @Optional val can_send_media_messages: Boolean? = null,
    @Optional val can_send_other_messages: Boolean? = null,
    @Optional val can_add_web_page_previews: Boolean? = null
) : TelegramModel()

@Serializable
data class ResponseParameters(
    @Optional val migrate_to_chat_id: Int? = null,
    @Optional val retry_after: Int? = null
) : TelegramModel()

@Serializable
data class InputMediaPhoto(
    val type: String,
    val media: String,
    @Optional val caption: String? = null,
    @Optional val parse_mode: String? = null
) : TelegramModel()

@Serializable
data class InputMediaVideo(
    val type: String,
    val media: String,
    @Optional val thumb: Any? = null,
    @Optional val caption: String? = null,
    @Optional val parse_mode: String? = null,
    @Optional val width: Int? = null,
    @Optional val height: Int? = null,
    @Optional val duration: Int? = null,
    @Optional val supports_streaming: Boolean? = null
) : TelegramModel()

@Serializable
data class InputMediaAnimation(
    val type: String,
    val media: String,
    @Optional val thumb: Any? = null,
    @Optional val caption: String? = null,
    @Optional val parse_mode: String? = null,
    @Optional val width: Int? = null,
    @Optional val height: Int? = null,
    @Optional val duration: Int? = null
) : TelegramModel()

@Serializable
data class InputMediaAudio(
    val type: String,
    val media: String,
    @Optional val thumb: Any? = null,
    @Optional val caption: String? = null,
    @Optional val parse_mode: String? = null,
    @Optional val duration: Int? = null,
    @Optional val performer: String? = null,
    @Optional val title: String? = null
) : TelegramModel()

@Serializable
data class InputMediaDocument(
    val type: String,
    val media: String,
    @Optional val thumb: Any? = null,
    @Optional val caption: String? = null,
    @Optional val parse_mode: String? = null
) : TelegramModel()



// Stickers

@Serializable
data class Sticker(
    val file_id: String,
    val width: Int,
    val height: Int,
    @Optional val thumb: PhotoSize? = null,
    @Optional val emoji: String? = null,
    @Optional val set_name: String? = null,
    @Optional val mask_position: MaskPosition? = null,
    @Optional val file_size: Int? = null
) : TelegramModel()

@Serializable
data class StickerSet(
    val name: String,
    val title: String,
    val contains_masks: Boolean,
    val stickers: List<Sticker>
) : TelegramModel()

@Serializable
data class MaskPosition(
    val point: String,
    val x_shift: Float,
    val y_shift: Float,
    val scale: Float
) : TelegramModel()



// Inline mode

@Serializable
data class InlineQuery(
    val id: String,
    val from: User,
    @Optional val location: Location? = null,
    val query: String,
    val offset: String
) : TelegramModel()

@Serializable
data class InlineQueryResultArticle(
    val type: String,
    val id: String,
    val title: String,
    val input_message_content: Any,
    @Optional val reply_markup: InlineKeyboardMarkup? = null,
    @Optional val url: String? = null,
    @Optional val hide_url: Boolean? = null,
    @Optional val description: String? = null,
    @Optional val thumb_url: String? = null,
    @Optional val thumb_width: Int? = null,
    @Optional val thumb_height: Int? = null
) : TelegramModel()

@Serializable
data class InlineQueryResultPhoto(
    val type: String,
    val id: String,
    val photo_url: String,
    val thumb_url: String,
    @Optional val photo_width: Int? = null,
    @Optional val photo_height: Int? = null,
    @Optional val title: String? = null,
    @Optional val description: String? = null,
    @Optional val caption: String? = null,
    @Optional val parse_mode: String? = null,
    @Optional val reply_markup: InlineKeyboardMarkup? = null,
    @Optional val input_message_content: Any? = null
) : TelegramModel()

@Serializable
data class InlineQueryResultGif(
    val type: String,
    val id: String,
    val gif_url: String,
    @Optional val gif_width: Int? = null,
    @Optional val gif_height: Int? = null,
    @Optional val gif_duration: Int? = null,
    val thumb_url: String,
    @Optional val title: String? = null,
    @Optional val caption: String? = null,
    @Optional val parse_mode: String? = null,
    @Optional val reply_markup: InlineKeyboardMarkup? = null,
    @Optional val input_message_content: Any? = null
) : TelegramModel()

@Serializable
data class InlineQueryResultMpeg4Gif(
    val type: String,
    val id: String,
    val mpeg4_url: String,
    @Optional val mpeg4_width: Int? = null,
    @Optional val mpeg4_height: Int? = null,
    @Optional val mpeg4_duration: Int? = null,
    val thumb_url: String,
    @Optional val title: String? = null,
    @Optional val caption: String? = null,
    @Optional val parse_mode: String? = null,
    @Optional val reply_markup: InlineKeyboardMarkup? = null,
    @Optional val input_message_content: Any? = null
) : TelegramModel()

@Serializable
data class InlineQueryResultVideo(
    val type: String,
    val id: String,
    val video_url: String,
    val mime_type: String,
    val thumb_url: String,
    val title: String,
    @Optional val caption: String? = null,
    @Optional val parse_mode: String? = null,
    @Optional val video_width: Int? = null,
    @Optional val video_height: Int? = null,
    @Optional val video_duration: Int? = null,
    @Optional val description: String? = null,
    @Optional val reply_markup: InlineKeyboardMarkup? = null,
    @Optional val input_message_content: Any? = null
) : TelegramModel()

@Serializable
data class InlineQueryResultAudio(
    val type: String,
    val id: String,
    val audio_url: String,
    val title: String,
    @Optional val caption: String? = null,
    @Optional val parse_mode: String? = null,
    @Optional val performer: String? = null,
    @Optional val audio_duration: Int? = null,
    @Optional val reply_markup: InlineKeyboardMarkup? = null,
    @Optional val input_message_content: Any? = null
) : TelegramModel()

@Serializable
data class InlineQueryResultVoice(
    val type: String,
    val id: String,
    val voice_url: String,
    val title: String,
    @Optional val caption: String? = null,
    @Optional val parse_mode: String? = null,
    @Optional val voice_duration: Int? = null,
    @Optional val reply_markup: InlineKeyboardMarkup? = null,
    @Optional val input_message_content: Any? = null
) : TelegramModel()

@Serializable
data class InlineQueryResultDocument(
    val type: String,
    val id: String,
    val title: String,
    @Optional val caption: String? = null,
    @Optional val parse_mode: String? = null,
    val document_url: String,
    val mime_type: String,
    @Optional val description: String? = null,
    @Optional val reply_markup: InlineKeyboardMarkup? = null,
    @Optional val input_message_content: Any? = null,
    @Optional val thumb_url: String? = null,
    @Optional val thumb_width: Int? = null,
    @Optional val thumb_height: Int? = null
) : TelegramModel()

@Serializable
data class InlineQueryResultLocation(
    val type: String,
    val id: String,
    val latitude: Float,
    val longitude: Float,
    val title: String,
    @Optional val live_period: Int? = null,
    @Optional val reply_markup: InlineKeyboardMarkup? = null,
    @Optional val input_message_content: Any? = null,
    @Optional val thumb_url: String? = null,
    @Optional val thumb_width: Int? = null,
    @Optional val thumb_height: Int? = null
) : TelegramModel()

@Serializable
data class InlineQueryResultVenue(
    val type: String,
    val id: String,
    val latitude: Float,
    val longitude: Float,
    val title: String,
    val address: String,
    @Optional val foursquare_id: String? = null,
    @Optional val foursquare_type: String? = null,
    @Optional val reply_markup: InlineKeyboardMarkup? = null,
    @Optional val input_message_content: Any? = null,
    @Optional val thumb_url: String? = null,
    @Optional val thumb_width: Int? = null,
    @Optional val thumb_height: Int? = null
) : TelegramModel()

@Serializable
data class InlineQueryResultContact(
    val type: String,
    val id: String,
    val phone_number: String,
    val first_name: String,
    @Optional val last_name: String? = null,
    @Optional val vcard: String? = null,
    @Optional val reply_markup: InlineKeyboardMarkup? = null,
    @Optional val input_message_content: Any? = null,
    @Optional val thumb_url: String? = null,
    @Optional val thumb_width: Int? = null,
    @Optional val thumb_height: Int? = null
) : TelegramModel()

@Serializable
data class InlineQueryResultGame(
    val type: String,
    val id: String,
    val game_short_name: String,
    @Optional val reply_markup: InlineKeyboardMarkup? = null
) : TelegramModel()

@Serializable
data class InlineQueryResultCachedPhoto(
    val type: String,
    val id: String,
    val photo_file_id: String,
    @Optional val title: String? = null,
    @Optional val description: String? = null,
    @Optional val caption: String? = null,
    @Optional val parse_mode: String? = null,
    @Optional val reply_markup: InlineKeyboardMarkup? = null,
    @Optional val input_message_content: Any? = null
) : TelegramModel()

@Serializable
data class InlineQueryResultCachedGif(
    val type: String,
    val id: String,
    val gif_file_id: String,
    @Optional val title: String? = null,
    @Optional val caption: String? = null,
    @Optional val parse_mode: String? = null,
    @Optional val reply_markup: InlineKeyboardMarkup? = null,
    @Optional val input_message_content: Any? = null
) : TelegramModel()

@Serializable
data class InlineQueryResultCachedMpeg4Gif(
    val type: String,
    val id: String,
    val mpeg4_file_id: String,
    @Optional val title: String? = null,
    @Optional val caption: String? = null,
    @Optional val parse_mode: String? = null,
    @Optional val reply_markup: InlineKeyboardMarkup? = null,
    @Optional val input_message_content: Any? = null
) : TelegramModel()

@Serializable
data class InlineQueryResultCachedSticker(
    val type: String,
    val id: String,
    val sticker_file_id: String,
    @Optional val reply_markup: InlineKeyboardMarkup? = null,
    @Optional val input_message_content: Any? = null
) : TelegramModel()

@Serializable
data class InlineQueryResultCachedDocument(
    val type: String,
    val id: String,
    val title: String,
    val document_file_id: String,
    @Optional val description: String? = null,
    @Optional val caption: String? = null,
    @Optional val parse_mode: String? = null,
    @Optional val reply_markup: InlineKeyboardMarkup? = null,
    @Optional val input_message_content: Any? = null
) : TelegramModel()

@Serializable
data class InlineQueryResultCachedVideo(
    val type: String,
    val id: String,
    val video_file_id: String,
    val title: String,
    @Optional val description: String? = null,
    @Optional val caption: String? = null,
    @Optional val parse_mode: String? = null,
    @Optional val reply_markup: InlineKeyboardMarkup? = null,
    @Optional val input_message_content: Any? = null
) : TelegramModel()

@Serializable
data class InlineQueryResultCachedVoice(
    val type: String,
    val id: String,
    val voice_file_id: String,
    val title: String,
    @Optional val caption: String? = null,
    @Optional val parse_mode: String? = null,
    @Optional val reply_markup: InlineKeyboardMarkup? = null,
    @Optional val input_message_content: Any? = null
) : TelegramModel()

@Serializable
data class InlineQueryResultCachedAudio(
    val type: String,
    val id: String,
    val audio_file_id: String,
    @Optional val caption: String? = null,
    @Optional val parse_mode: String? = null,
    @Optional val reply_markup: InlineKeyboardMarkup? = null,
    @Optional val input_message_content: Any? = null
) : TelegramModel()

@Serializable
data class InputTextMessageContent(
    val message_text: String,
    @Optional val parse_mode: String? = null,
    @Optional val disable_web_page_preview: Boolean? = null
) : TelegramModel()

@Serializable
data class InputLocationMessageContent(
    val latitude: Float,
    val longitude: Float,
    @Optional val live_period: Int? = null
) : TelegramModel()

@Serializable
data class InputVenueMessageContent(
    val latitude: Float,
    val longitude: Float,
    val title: String,
    val address: String,
    @Optional val foursquare_id: String? = null,
    @Optional val foursquare_type: String? = null
) : TelegramModel()

@Serializable
data class InputContactMessageContent(
    val phone_number: String,
    val first_name: String,
    @Optional val last_name: String? = null,
    @Optional val vcard: String? = null
) : TelegramModel()

@Serializable
data class ChosenInlineResult(
    val result_id: String,
    val from: User,
    @Optional val location: Location? = null,
    @Optional val inline_message_id: String? = null,
    val query: String
) : TelegramModel()



// Payments

@Serializable
data class LabeledPrice(
    val label: String,
    val amount: Int
) : TelegramModel()

@Serializable
data class Invoice(
    val title: String,
    val description: String,
    val start_parameter: String,
    val currency: String,
    val total_amount: Int
) : TelegramModel()

@Serializable
data class ShippingAddress(
    val country_code: String,
    val state: String,
    val city: String,
    val street_line1: String,
    val street_line2: String,
    val post_code: String
) : TelegramModel()

@Serializable
data class OrderInfo(
    @Optional val name: String? = null,
    @Optional val phone_number: String? = null,
    @Optional val email: String? = null,
    @Optional val shipping_address: ShippingAddress? = null
) : TelegramModel()

@Serializable
data class ShippingOption(
    val id: String,
    val title: String,
    val prices: List<LabeledPrice>
) : TelegramModel()

@Serializable
data class SuccessfulPayment(
    val currency: String,
    val total_amount: Int,
    val invoice_payload: String,
    @Optional val shipping_option_id: String? = null,
    @Optional val order_info: OrderInfo? = null,
    val telegram_payment_charge_id: String,
    val provider_payment_charge_id: String
) : TelegramModel()

@Serializable
data class ShippingQuery(
    val id: String,
    val from: User,
    val invoice_payload: String,
    val shipping_address: ShippingAddress
) : TelegramModel()

@Serializable
data class PreCheckoutQuery(
    val id: String,
    val from: User,
    val currency: String,
    val total_amount: Int,
    val invoice_payload: String,
    @Optional val shipping_option_id: String? = null,
    @Optional val order_info: OrderInfo? = null
) : TelegramModel()



// Telegram Passport

@Serializable
data class PassportData(
    val data: List<EncryptedPassportElement>,
    val credentials: EncryptedCredentials
) : TelegramModel()

@Serializable
data class PassportFile(
    val file_id: String,
    val file_size: Int,
    val file_date: Int
) : TelegramModel()

@Serializable
data class EncryptedPassportElement(
    val type: String,
    @Optional val data: String? = null,
    @Optional val phone_number: String? = null,
    @Optional val email: String? = null,
    @Optional val files: List<PassportFile>? = null,
    @Optional val front_side: PassportFile? = null,
    @Optional val reverse_side: PassportFile? = null,
    @Optional val selfie: PassportFile? = null,
    @Optional val translation: List<PassportFile>? = null,
    val hash: String
) : TelegramModel()

@Serializable
data class EncryptedCredentials(
    val data: String,
    val hash: String,
    val secret: String
) : TelegramModel()

@Serializable
data class PassportElementErrorDataField(
    val source: String,
    val type: String,
    val field_name: String,
    val data_hash: String,
    val message: String
) : TelegramModel()

@Serializable
data class PassportElementErrorFrontSide(
    val source: String,
    val type: String,
    val file_hash: String,
    val message: String
) : TelegramModel()

@Serializable
data class PassportElementErrorReverseSide(
    val source: String,
    val type: String,
    val file_hash: String,
    val message: String
) : TelegramModel()

@Serializable
data class PassportElementErrorSelfie(
    val source: String,
    val type: String,
    val file_hash: String,
    val message: String
) : TelegramModel()

@Serializable
data class PassportElementErrorFile(
    val source: String,
    val type: String,
    val file_hash: String,
    val message: String
) : TelegramModel()

@Serializable
data class PassportElementErrorFiles(
    val source: String,
    val type: String,
    val file_hashes: List<String>,
    val message: String
) : TelegramModel()

@Serializable
data class PassportElementErrorTranslationFile(
    val source: String,
    val type: String,
    val file_hash: String,
    val message: String
) : TelegramModel()

@Serializable
data class PassportElementErrorTranslationFiles(
    val source: String,
    val type: String,
    val file_hashes: List<String>,
    val message: String
) : TelegramModel()

@Serializable
data class PassportElementErrorUnspecified(
    val source: String,
    val type: String,
    val element_hash: String,
    val message: String
) : TelegramModel()



// Games

@Serializable
data class Game(
    val title: String,
    val description: String,
    val photo: List<PhotoSize>,
    @Optional val text: String? = null,
    @Optional val text_entities: List<MessageEntity>? = null,
    @Optional val animation: Animation? = null
) : TelegramModel()

@Serializable
data class GameHighScore(
    val position: Int,
    val user: User,
    val score: Int
) : TelegramModel()