package com.github.omarmiatello.telegram

sealed class TelegramModel

sealed class InputMedia : TelegramModel()
sealed class InputMessageContent : TelegramModel()
sealed class InlineQueryResult : TelegramModel()
sealed class PassportElementError : TelegramModel()
sealed class ChatMember : TelegramModel()
sealed class BotCommandScope : TelegramModel()
sealed class ReactionType : TelegramModel()
sealed class MessageOrigin : TelegramModel()
sealed class ChatBoostSource : TelegramModel()
sealed class MenuButton : TelegramModel()
sealed class KeyboardOption : TelegramModel()
sealed class MaybeInaccessibleMessage : TelegramModel()
sealed class BackgroundType : TelegramModel()
sealed class BackgroundFill : TelegramModel()
sealed class InputFileOrString : TelegramModel()
sealed class IntegerOrString : TelegramModel()
data class TelegramResponse<T>(val ok: Boolean, val result: T? = null)

enum class ParseMode { MarkdownV2, Markdown, HTML }


data class Update(
    @SerialName("update_id")
    val updateId: Long,
    @SerialName("message")
    val message: Message? = null,
    @SerialName("edited_message")
    val editedMessage: Message? = null,
    @SerialName("channel_post")
    val channelPost: Message? = null,
    @SerialName("edited_channel_post")
    val editedChannelPost: Message? = null,
    @SerialName("business_connection")
    val businessConnection: BusinessConnection? = null,
    @SerialName("business_message")
    val businessMessage: Message? = null,
    @SerialName("edited_business_message")
    val editedBusinessMessage: Message? = null,
    @SerialName("deleted_business_messages")
    val deletedBusinessMessages: BusinessMessagesDeleted? = null,
    @SerialName("message_reaction")
    val messageReaction: MessageReactionUpdated? = null,
    @SerialName("message_reaction_count")
    val messageReactionCount: MessageReactionCountUpdated? = null,
    @SerialName("inline_query")
    val inlineQuery: InlineQuery? = null,
    @SerialName("chosen_inline_result")
    val chosenInlineResult: ChosenInlineResult? = null,
    @SerialName("callback_query")
    val callbackQuery: CallbackQuery? = null,
    @SerialName("shipping_query")
    val shippingQuery: ShippingQuery? = null,
    @SerialName("pre_checkout_query")
    val preCheckoutQuery: PreCheckoutQuery? = null,
    @SerialName("poll")
    val poll: Poll? = null,
    @SerialName("poll_answer")
    val pollAnswer: PollAnswer? = null,
    @SerialName("my_chat_member")
    val myChatMember: ChatMemberUpdated? = null,
    @SerialName("chat_member")
    val chatMember: ChatMemberUpdated? = null,
    @SerialName("chat_join_request")
    val chatJoinRequest: ChatJoinRequest? = null,
    @SerialName("chat_boost")
    val chatBoost: ChatBoostUpdated? = null,
    @SerialName("removed_chat_boost")
    val removedChatBoost: ChatBoostRemoved? = null,
) : TelegramModel()

data class WebhookInfo(
    @SerialName("url")
    val url: String,
    @SerialName("has_custom_certificate")
    val hasCustomCertificate: Boolean,
    @SerialName("pending_update_count")
    val pendingUpdateCount: Long,
    @SerialName("ip_address")
    val ipAddress: String? = null,
    @SerialName("last_error_date")
    val lastErrorDate: Long? = null,
    @SerialName("last_error_message")
    val lastErrorMessage: String? = null,
    @SerialName("last_synchronization_error_date")
    val lastSynchronizationErrorDate: Long? = null,
    @SerialName("max_connections")
    val maxConnections: Long? = null,
    @SerialName("allowed_updates")
    val allowedUpdates: List<String>? = null,
) : TelegramModel()

data class User(
    @SerialName("id")
    val id: Long,
    @SerialName("is_bot")
    val isBot: Boolean,
    @SerialName("first_name")
    val firstName: String,
    @SerialName("last_name")
    val lastName: String? = null,
    @SerialName("username")
    val username: String? = null,
    @SerialName("language_code")
    val languageCode: String? = null,
    @SerialName("is_premium")
    val isPremium: Boolean? = null,
    @SerialName("added_to_attachment_menu")
    val addedToAttachmentMenu: Boolean? = null,
    @SerialName("can_join_groups")
    val canJoinGroups: Boolean? = null,
    @SerialName("can_read_all_group_messages")
    val canReadAllGroupMessages: Boolean? = null,
    @SerialName("supports_inline_queries")
    val supportsInlineQueries: Boolean? = null,
    @SerialName("can_connect_to_business")
    val canConnectToBusiness: Boolean? = null,
) : TelegramModel()

data class Chat(
    @SerialName("id")
    val id: Long,
    @SerialName("type")
    val type: String,
    @SerialName("title")
    val title: String? = null,
    @SerialName("username")
    val username: String? = null,
    @SerialName("first_name")
    val firstName: String? = null,
    @SerialName("last_name")
    val lastName: String? = null,
    @SerialName("is_forum")
    val isForum: Boolean? = null,
) : TelegramModel()

data class ChatFullInfo(
    @SerialName("id")
    val id: Long,
    @SerialName("type")
    val type: String,
    @SerialName("title")
    val title: String? = null,
    @SerialName("username")
    val username: String? = null,
    @SerialName("first_name")
    val firstName: String? = null,
    @SerialName("last_name")
    val lastName: String? = null,
    @SerialName("is_forum")
    val isForum: Boolean? = null,
    @SerialName("accent_color_id")
    val accentColorId: Long,
    @SerialName("max_reaction_count")
    val maxReactionCount: Long,
    @SerialName("photo")
    val photo: ChatPhoto? = null,
    @SerialName("active_usernames")
    val activeUsernames: List<String>? = null,
    @SerialName("birthdate")
    val birthdate: Birthdate? = null,
    @SerialName("business_intro")
    val businessIntro: BusinessIntro? = null,
    @SerialName("business_location")
    val businessLocation: BusinessLocation? = null,
    @SerialName("business_opening_hours")
    val businessOpeningHours: BusinessOpeningHours? = null,
    @SerialName("personal_chat")
    val personalChat: Chat? = null,
    @SerialName("available_reactions")
    val availableReactions: List<ReactionType>? = null,
    @SerialName("background_custom_emoji_id")
    val backgroundCustomEmojiId: String? = null,
    @SerialName("profile_accent_color_id")
    val profileAccentColorId: Long? = null,
    @SerialName("profile_background_custom_emoji_id")
    val profileBackgroundCustomEmojiId: String? = null,
    @SerialName("emoji_status_custom_emoji_id")
    val emojiStatusCustomEmojiId: String? = null,
    @SerialName("emoji_status_expiration_date")
    val emojiStatusExpirationDate: Long? = null,
    @SerialName("bio")
    val bio: String? = null,
    @SerialName("has_private_forwards")
    val hasPrivateForwards: Boolean? = null,
    @SerialName("has_restricted_voice_and_video_messages")
    val hasRestrictedVoiceAndVideoMessages: Boolean? = null,
    @SerialName("join_to_send_messages")
    val joinToSendMessages: Boolean? = null,
    @SerialName("join_by_request")
    val joinByRequest: Boolean? = null,
    @SerialName("description")
    val description: String? = null,
    @SerialName("invite_link")
    val inviteLink: String? = null,
    @SerialName("pinned_message")
    val pinnedMessage: Message? = null,
    @SerialName("permissions")
    val permissions: ChatPermissions? = null,
    @SerialName("slow_mode_delay")
    val slowModeDelay: Long? = null,
    @SerialName("unrestrict_boost_count")
    val unrestrictBoostCount: Long? = null,
    @SerialName("message_auto_delete_time")
    val messageAutoDeleteTime: Long? = null,
    @SerialName("has_aggressive_anti_spam_enabled")
    val hasAggressiveAntiSpamEnabled: Boolean? = null,
    @SerialName("has_hidden_members")
    val hasHiddenMembers: Boolean? = null,
    @SerialName("has_protected_content")
    val hasProtectedContent: Boolean? = null,
    @SerialName("has_visible_history")
    val hasVisibleHistory: Boolean? = null,
    @SerialName("sticker_set_name")
    val stickerSetName: String? = null,
    @SerialName("can_set_sticker_set")
    val canSetStickerSet: Boolean? = null,
    @SerialName("custom_emoji_sticker_set_name")
    val customEmojiStickerSetName: String? = null,
    @SerialName("linked_chat_id")
    val linkedChatId: Long? = null,
    @SerialName("location")
    val location: ChatLocation? = null,
) : TelegramModel()

data class Message(
    @SerialName("message_id")
    val messageId: Long,
    @SerialName("message_thread_id")
    val messageThreadId: Long? = null,
    @SerialName("from")
    val from: User? = null,
    @SerialName("sender_chat")
    val senderChat: Chat? = null,
    @SerialName("sender_boost_count")
    val senderBoostCount: Long? = null,
    @SerialName("sender_business_bot")
    val senderBusinessBot: User? = null,
    @SerialName("date")
    val date: Long,
    @SerialName("business_connection_id")
    val businessConnectionId: String? = null,
    @SerialName("chat")
    val chat: Chat,
    @SerialName("forward_origin")
    val forwardOrigin: MessageOrigin? = null,
    @SerialName("is_topic_message")
    val isTopicMessage: Boolean? = null,
    @SerialName("is_automatic_forward")
    val isAutomaticForward: Boolean? = null,
    @SerialName("reply_to_message")
    val replyToMessage: Message? = null,
    @SerialName("external_reply")
    val externalReply: ExternalReplyInfo? = null,
    @SerialName("quote")
    val quote: TextQuote? = null,
    @SerialName("reply_to_story")
    val replyToStory: Story? = null,
    @SerialName("via_bot")
    val viaBot: User? = null,
    @SerialName("edit_date")
    val editDate: Long? = null,
    @SerialName("has_protected_content")
    val hasProtectedContent: Boolean? = null,
    @SerialName("is_from_offline")
    val isFromOffline: Boolean? = null,
    @SerialName("media_group_id")
    val mediaGroupId: String? = null,
    @SerialName("author_signature")
    val authorSignature: String? = null,
    @SerialName("text")
    val text: String? = null,
    @SerialName("entities")
    val entities: List<MessageEntity>? = null,
    @SerialName("link_preview_options")
    val linkPreviewOptions: LinkPreviewOptions? = null,
    @SerialName("effect_id")
    val effectId: String? = null,
    @SerialName("animation")
    val animation: Animation? = null,
    @SerialName("audio")
    val audio: Audio? = null,
    @SerialName("document")
    val document: Document? = null,
    @SerialName("photo")
    val photo: List<PhotoSize>? = null,
    @SerialName("sticker")
    val sticker: Sticker? = null,
    @SerialName("story")
    val story: Story? = null,
    @SerialName("video")
    val video: Video? = null,
    @SerialName("video_note")
    val videoNote: VideoNote? = null,
    @SerialName("voice")
    val voice: Voice? = null,
    @SerialName("caption")
    val caption: String? = null,
    @SerialName("caption_entities")
    val captionEntities: List<MessageEntity>? = null,
    @SerialName("show_caption_above_media")
    val showCaptionAboveMedia: Boolean? = null,
    @SerialName("has_media_spoiler")
    val hasMediaSpoiler: Boolean? = null,
    @SerialName("contact")
    val contact: Contact? = null,
    @SerialName("dice")
    val dice: Dice? = null,
    @SerialName("game")
    val game: Game? = null,
    @SerialName("poll")
    val poll: Poll? = null,
    @SerialName("venue")
    val venue: Venue? = null,
    @SerialName("location")
    val location: Location? = null,
    @SerialName("new_chat_members")
    val newChatMembers: List<User>? = null,
    @SerialName("left_chat_member")
    val leftChatMember: User? = null,
    @SerialName("new_chat_title")
    val newChatTitle: String? = null,
    @SerialName("new_chat_photo")
    val newChatPhoto: List<PhotoSize>? = null,
    @SerialName("delete_chat_photo")
    val deleteChatPhoto: Boolean? = null,
    @SerialName("group_chat_created")
    val groupChatCreated: Boolean? = null,
    @SerialName("supergroup_chat_created")
    val supergroupChatCreated: Boolean? = null,
    @SerialName("channel_chat_created")
    val channelChatCreated: Boolean? = null,
    @SerialName("message_auto_delete_timer_changed")
    val messageAutoDeleteTimerChanged: MessageAutoDeleteTimerChanged? = null,
    @SerialName("migrate_to_chat_id")
    val migrateToChatId: Long? = null,
    @SerialName("migrate_from_chat_id")
    val migrateFromChatId: Long? = null,
    @SerialName("pinned_message")
    val pinnedMessage: MaybeInaccessibleMessage? = null,
    @SerialName("invoice")
    val invoice: Invoice? = null,
    @SerialName("successful_payment")
    val successfulPayment: SuccessfulPayment? = null,
    @SerialName("users_shared")
    val usersShared: UsersShared? = null,
    @SerialName("chat_shared")
    val chatShared: ChatShared? = null,
    @SerialName("connected_website")
    val connectedWebsite: String? = null,
    @SerialName("write_access_allowed")
    val writeAccessAllowed: WriteAccessAllowed? = null,
    @SerialName("passport_data")
    val passportData: PassportData? = null,
    @SerialName("proximity_alert_triggered")
    val proximityAlertTriggered: ProximityAlertTriggered? = null,
    @SerialName("boost_added")
    val boostAdded: ChatBoostAdded? = null,
    @SerialName("chat_background_set")
    val chatBackgroundSet: ChatBackground? = null,
    @SerialName("forum_topic_created")
    val forumTopicCreated: ForumTopicCreated? = null,
    @SerialName("forum_topic_edited")
    val forumTopicEdited: ForumTopicEdited? = null,
    @SerialName("forum_topic_closed")
    val forumTopicClosed: Any? = null,
    @SerialName("forum_topic_reopened")
    val forumTopicReopened: Any? = null,
    @SerialName("general_forum_topic_hidden")
    val generalForumTopicHidden: Any? = null,
    @SerialName("general_forum_topic_unhidden")
    val generalForumTopicUnhidden: Any? = null,
    @SerialName("giveaway_created")
    val giveawayCreated: Any? = null,
    @SerialName("giveaway")
    val giveaway: Giveaway? = null,
    @SerialName("giveaway_winners")
    val giveawayWinners: GiveawayWinners? = null,
    @SerialName("giveaway_completed")
    val giveawayCompleted: GiveawayCompleted? = null,
    @SerialName("video_chat_scheduled")
    val videoChatScheduled: VideoChatScheduled? = null,
    @SerialName("video_chat_started")
    val videoChatStarted: Any? = null,
    @SerialName("video_chat_ended")
    val videoChatEnded: VideoChatEnded? = null,
    @SerialName("video_chat_participants_invited")
    val videoChatParticipantsInvited: VideoChatParticipantsInvited? = null,
    @SerialName("web_app_data")
    val webAppData: WebAppData? = null,
    @SerialName("reply_markup")
    val replyMarkup: InlineKeyboardMarkup? = null,
) : MaybeInaccessibleMessage()

data class MessageId(
    @SerialName("message_id")
    val messageId: Long,
) : TelegramModel()

data class InaccessibleMessage(
    @SerialName("chat")
    val chat: Chat,
    @SerialName("message_id")
    val messageId: Long,
    @SerialName("date")
    val date: Long,
) : MaybeInaccessibleMessage()

data class MessageEntity(
    @SerialName("type")
    val type: String,
    @SerialName("offset")
    val offset: Long,
    @SerialName("length")
    val length: Long,
    @SerialName("url")
    val url: String? = null,
    @SerialName("user")
    val user: User? = null,
    @SerialName("language")
    val language: String? = null,
    @SerialName("custom_emoji_id")
    val customEmojiId: String? = null,
) : TelegramModel()

data class TextQuote(
    @SerialName("text")
    val text: String,
    @SerialName("entities")
    val entities: List<MessageEntity>? = null,
    @SerialName("position")
    val position: Long,
    @SerialName("is_manual")
    val isManual: Boolean? = null,
) : TelegramModel()

data class ExternalReplyInfo(
    @SerialName("origin")
    val origin: MessageOrigin,
    @SerialName("chat")
    val chat: Chat? = null,
    @SerialName("message_id")
    val messageId: Long? = null,
    @SerialName("link_preview_options")
    val linkPreviewOptions: LinkPreviewOptions? = null,
    @SerialName("animation")
    val animation: Animation? = null,
    @SerialName("audio")
    val audio: Audio? = null,
    @SerialName("document")
    val document: Document? = null,
    @SerialName("photo")
    val photo: List<PhotoSize>? = null,
    @SerialName("sticker")
    val sticker: Sticker? = null,
    @SerialName("story")
    val story: Story? = null,
    @SerialName("video")
    val video: Video? = null,
    @SerialName("video_note")
    val videoNote: VideoNote? = null,
    @SerialName("voice")
    val voice: Voice? = null,
    @SerialName("has_media_spoiler")
    val hasMediaSpoiler: Boolean? = null,
    @SerialName("contact")
    val contact: Contact? = null,
    @SerialName("dice")
    val dice: Dice? = null,
    @SerialName("game")
    val game: Game? = null,
    @SerialName("giveaway")
    val giveaway: Giveaway? = null,
    @SerialName("giveaway_winners")
    val giveawayWinners: GiveawayWinners? = null,
    @SerialName("invoice")
    val invoice: Invoice? = null,
    @SerialName("location")
    val location: Location? = null,
    @SerialName("poll")
    val poll: Poll? = null,
    @SerialName("venue")
    val venue: Venue? = null,
) : TelegramModel()

data class ReplyParameters(
    @SerialName("message_id")
    val messageId: Long,
    @SerialName("chat_id")
    val chatId: String? = null,
    @SerialName("allow_sending_without_reply")
    val allowSendingWithoutReply: Boolean? = null,
    @SerialName("quote")
    val quote: String? = null,
    @SerialName("quote_parse_mode")
    val quoteParseMode: String? = null,
    @SerialName("quote_entities")
    val quoteEntities: List<MessageEntity>? = null,
    @SerialName("quote_position")
    val quotePosition: Long? = null,
) : TelegramModel()

data class MessageOriginUser(
    @SerialName("type")
    val type: String,
    @SerialName("date")
    val date: Long,
    @SerialName("sender_user")
    val senderUser: User,
) : MessageOrigin()

data class MessageOriginHiddenUser(
    @SerialName("type")
    val type: String,
    @SerialName("date")
    val date: Long,
    @SerialName("sender_user_name")
    val senderUserName: String,
) : MessageOrigin()

data class MessageOriginChat(
    @SerialName("type")
    val type: String,
    @SerialName("date")
    val date: Long,
    @SerialName("sender_chat")
    val senderChat: Chat,
    @SerialName("author_signature")
    val authorSignature: String? = null,
) : MessageOrigin()

data class MessageOriginChannel(
    @SerialName("type")
    val type: String,
    @SerialName("date")
    val date: Long,
    @SerialName("chat")
    val chat: Chat,
    @SerialName("message_id")
    val messageId: Long,
    @SerialName("author_signature")
    val authorSignature: String? = null,
) : MessageOrigin()

data class PhotoSize(
    @SerialName("file_id")
    val fileId: String,
    @SerialName("file_unique_id")
    val fileUniqueId: String,
    @SerialName("width")
    val width: Long,
    @SerialName("height")
    val height: Long,
    @SerialName("file_size")
    val fileSize: Long? = null,
) : TelegramModel()

data class Animation(
    @SerialName("file_id")
    val fileId: String,
    @SerialName("file_unique_id")
    val fileUniqueId: String,
    @SerialName("width")
    val width: Long,
    @SerialName("height")
    val height: Long,
    @SerialName("duration")
    val duration: Long,
    @SerialName("thumbnail")
    val thumbnail: PhotoSize? = null,
    @SerialName("file_name")
    val fileName: String? = null,
    @SerialName("mime_type")
    val mimeType: String? = null,
    @SerialName("file_size")
    val fileSize: Long? = null,
) : TelegramModel()

data class Audio(
    @SerialName("file_id")
    val fileId: String,
    @SerialName("file_unique_id")
    val fileUniqueId: String,
    @SerialName("duration")
    val duration: Long,
    @SerialName("performer")
    val performer: String? = null,
    @SerialName("title")
    val title: String? = null,
    @SerialName("file_name")
    val fileName: String? = null,
    @SerialName("mime_type")
    val mimeType: String? = null,
    @SerialName("file_size")
    val fileSize: Long? = null,
    @SerialName("thumbnail")
    val thumbnail: PhotoSize? = null,
) : TelegramModel()

data class Document(
    @SerialName("file_id")
    val fileId: String,
    @SerialName("file_unique_id")
    val fileUniqueId: String,
    @SerialName("thumbnail")
    val thumbnail: PhotoSize? = null,
    @SerialName("file_name")
    val fileName: String? = null,
    @SerialName("mime_type")
    val mimeType: String? = null,
    @SerialName("file_size")
    val fileSize: Long? = null,
) : TelegramModel()

data class Story(
    @SerialName("chat")
    val chat: Chat,
    @SerialName("id")
    val id: Long,
) : TelegramModel()

data class Video(
    @SerialName("file_id")
    val fileId: String,
    @SerialName("file_unique_id")
    val fileUniqueId: String,
    @SerialName("width")
    val width: Long,
    @SerialName("height")
    val height: Long,
    @SerialName("duration")
    val duration: Long,
    @SerialName("thumbnail")
    val thumbnail: PhotoSize? = null,
    @SerialName("file_name")
    val fileName: String? = null,
    @SerialName("mime_type")
    val mimeType: String? = null,
    @SerialName("file_size")
    val fileSize: Long? = null,
) : TelegramModel()

data class VideoNote(
    @SerialName("file_id")
    val fileId: String,
    @SerialName("file_unique_id")
    val fileUniqueId: String,
    @SerialName("length")
    val length: Long,
    @SerialName("duration")
    val duration: Long,
    @SerialName("thumbnail")
    val thumbnail: PhotoSize? = null,
    @SerialName("file_size")
    val fileSize: Long? = null,
) : TelegramModel()

data class Voice(
    @SerialName("file_id")
    val fileId: String,
    @SerialName("file_unique_id")
    val fileUniqueId: String,
    @SerialName("duration")
    val duration: Long,
    @SerialName("mime_type")
    val mimeType: String? = null,
    @SerialName("file_size")
    val fileSize: Long? = null,
) : TelegramModel()

data class Contact(
    @SerialName("phone_number")
    val phoneNumber: String,
    @SerialName("first_name")
    val firstName: String,
    @SerialName("last_name")
    val lastName: String? = null,
    @SerialName("user_id")
    val userId: Long? = null,
    @SerialName("vcard")
    val vcard: String? = null,
) : TelegramModel()

data class Dice(
    @SerialName("emoji")
    val emoji: String,
    @SerialName("value")
    val value: Long,
) : TelegramModel()

data class PollOption(
    @SerialName("text")
    val text: String,
    @SerialName("text_entities")
    val textEntities: List<MessageEntity>? = null,
    @SerialName("voter_count")
    val voterCount: Long,
) : TelegramModel()

data class InputPollOption(
    @SerialName("text")
    val text: String,
    @SerialName("text_parse_mode")
    val textParseMode: String? = null,
    @SerialName("text_entities")
    val textEntities: List<MessageEntity>? = null,
) : TelegramModel()

data class PollAnswer(
    @SerialName("poll_id")
    val pollId: String,
    @SerialName("voter_chat")
    val voterChat: Chat? = null,
    @SerialName("user")
    val user: User? = null,
    @SerialName("option_ids")
    val optionIds: List<Long>,
) : TelegramModel()

data class Poll(
    @SerialName("id")
    val id: String,
    @SerialName("question")
    val question: String,
    @SerialName("question_entities")
    val questionEntities: List<MessageEntity>? = null,
    @SerialName("options")
    val options: List<PollOption>,
    @SerialName("total_voter_count")
    val totalVoterCount: Long,
    @SerialName("is_closed")
    val isClosed: Boolean,
    @SerialName("is_anonymous")
    val isAnonymous: Boolean,
    @SerialName("type")
    val type: String,
    @SerialName("allows_multiple_answers")
    val allowsMultipleAnswers: Boolean,
    @SerialName("correct_option_id")
    val correctOptionId: Long? = null,
    @SerialName("explanation")
    val explanation: String? = null,
    @SerialName("explanation_entities")
    val explanationEntities: List<MessageEntity>? = null,
    @SerialName("open_period")
    val openPeriod: Long? = null,
    @SerialName("close_date")
    val closeDate: Long? = null,
) : TelegramModel()

data class Location(
    @SerialName("latitude")
    val latitude: Float,
    @SerialName("longitude")
    val longitude: Float,
    @SerialName("horizontal_accuracy")
    val horizontalAccuracy: Float? = null,
    @SerialName("live_period")
    val livePeriod: Long? = null,
    @SerialName("heading")
    val heading: Long? = null,
    @SerialName("proximity_alert_radius")
    val proximityAlertRadius: Long? = null,
) : TelegramModel()

data class Venue(
    @SerialName("location")
    val location: Location,
    @SerialName("title")
    val title: String,
    @SerialName("address")
    val address: String,
    @SerialName("foursquare_id")
    val foursquareId: String? = null,
    @SerialName("foursquare_type")
    val foursquareType: String? = null,
    @SerialName("google_place_id")
    val googlePlaceId: String? = null,
    @SerialName("google_place_type")
    val googlePlaceType: String? = null,
) : TelegramModel()

data class WebAppData(
    @SerialName("data")
    val data: String,
    @SerialName("button_text")
    val buttonText: String,
) : TelegramModel()

data class ProximityAlertTriggered(
    @SerialName("traveler")
    val traveler: User,
    @SerialName("watcher")
    val watcher: User,
    @SerialName("distance")
    val distance: Long,
) : TelegramModel()

data class MessageAutoDeleteTimerChanged(
    @SerialName("message_auto_delete_time")
    val messageAutoDeleteTime: Long,
) : TelegramModel()

data class ChatBoostAdded(
    @SerialName("boost_count")
    val boostCount: Long,
) : TelegramModel()

data class BackgroundFillSolid(
    @SerialName("type")
    val type: String,
    @SerialName("color")
    val color: Long,
) : BackgroundFill()

data class BackgroundFillGradient(
    @SerialName("type")
    val type: String,
    @SerialName("top_color")
    val topColor: Long,
    @SerialName("bottom_color")
    val bottomColor: Long,
    @SerialName("rotation_angle")
    val rotationAngle: Long,
) : BackgroundFill()

data class BackgroundFillFreeformGradient(
    @SerialName("type")
    val type: String,
    @SerialName("colors")
    val colors: List<Long>,
) : BackgroundFill()

data class BackgroundTypeFill(
    @SerialName("type")
    val type: String,
    @SerialName("fill")
    val fill: BackgroundFill,
    @SerialName("dark_theme_dimming")
    val darkThemeDimming: Long,
) : BackgroundType()

data class BackgroundTypeWallpaper(
    @SerialName("type")
    val type: String,
    @SerialName("document")
    val document: Document,
    @SerialName("dark_theme_dimming")
    val darkThemeDimming: Long,
    @SerialName("is_blurred")
    val isBlurred: Boolean? = null,
    @SerialName("is_moving")
    val isMoving: Boolean? = null,
) : BackgroundType()

data class BackgroundTypePattern(
    @SerialName("type")
    val type: String,
    @SerialName("document")
    val document: Document,
    @SerialName("fill")
    val fill: BackgroundFill,
    @SerialName("intensity")
    val intensity: Long,
    @SerialName("is_inverted")
    val isInverted: Boolean? = null,
    @SerialName("is_moving")
    val isMoving: Boolean? = null,
) : BackgroundType()

data class BackgroundTypeChatTheme(
    @SerialName("type")
    val type: String,
    @SerialName("theme_name")
    val themeName: String,
) : BackgroundType()

data class ChatBackground(
    @SerialName("type")
    val type: BackgroundType,
) : TelegramModel()

data class ForumTopicCreated(
    @SerialName("name")
    val name: String,
    @SerialName("icon_color")
    val iconColor: Long,
    @SerialName("icon_custom_emoji_id")
    val iconCustomEmojiId: String? = null,
) : TelegramModel()

data class ForumTopicEdited(
    @SerialName("name")
    val name: String? = null,
    @SerialName("icon_custom_emoji_id")
    val iconCustomEmojiId: String? = null,
) : TelegramModel()

data class SharedUser(
    @SerialName("user_id")
    val userId: Long,
    @SerialName("first_name")
    val firstName: String? = null,
    @SerialName("last_name")
    val lastName: String? = null,
    @SerialName("username")
    val username: String? = null,
    @SerialName("photo")
    val photo: List<PhotoSize>? = null,
) : TelegramModel()

data class UsersShared(
    @SerialName("request_id")
    val requestId: Long,
    @SerialName("users")
    val users: List<SharedUser>,
) : TelegramModel()

data class ChatShared(
    @SerialName("request_id")
    val requestId: Long,
    @SerialName("chat_id")
    val chatId: Long,
    @SerialName("title")
    val title: String? = null,
    @SerialName("username")
    val username: String? = null,
    @SerialName("photo")
    val photo: List<PhotoSize>? = null,
) : TelegramModel()

data class WriteAccessAllowed(
    @SerialName("from_request")
    val fromRequest: Boolean? = null,
    @SerialName("web_app_name")
    val webAppName: String? = null,
    @SerialName("from_attachment_menu")
    val fromAttachmentMenu: Boolean? = null,
) : TelegramModel()

data class VideoChatScheduled(
    @SerialName("start_date")
    val startDate: Long,
) : TelegramModel()

data class VideoChatEnded(
    @SerialName("duration")
    val duration: Long,
) : TelegramModel()

data class VideoChatParticipantsInvited(
    @SerialName("users")
    val users: List<User>,
) : TelegramModel()

data class Giveaway(
    @SerialName("chats")
    val chats: List<Chat>,
    @SerialName("winners_selection_date")
    val winnersSelectionDate: Long,
    @SerialName("winner_count")
    val winnerCount: Long,
    @SerialName("only_new_members")
    val onlyNewMembers: Boolean? = null,
    @SerialName("has_public_winners")
    val hasPublicWinners: Boolean? = null,
    @SerialName("prize_description")
    val prizeDescription: String? = null,
    @SerialName("country_codes")
    val countryCodes: List<String>? = null,
    @SerialName("premium_subscription_month_count")
    val premiumSubscriptionMonthCount: Long? = null,
) : TelegramModel()

data class GiveawayWinners(
    @SerialName("chat")
    val chat: Chat,
    @SerialName("giveaway_message_id")
    val giveawayMessageId: Long,
    @SerialName("winners_selection_date")
    val winnersSelectionDate: Long,
    @SerialName("winner_count")
    val winnerCount: Long,
    @SerialName("winners")
    val winners: List<User>,
    @SerialName("additional_chat_count")
    val additionalChatCount: Long? = null,
    @SerialName("premium_subscription_month_count")
    val premiumSubscriptionMonthCount: Long? = null,
    @SerialName("unclaimed_prize_count")
    val unclaimedPrizeCount: Long? = null,
    @SerialName("only_new_members")
    val onlyNewMembers: Boolean? = null,
    @SerialName("was_refunded")
    val wasRefunded: Boolean? = null,
    @SerialName("prize_description")
    val prizeDescription: String? = null,
) : TelegramModel()

data class GiveawayCompleted(
    @SerialName("winner_count")
    val winnerCount: Long,
    @SerialName("unclaimed_prize_count")
    val unclaimedPrizeCount: Long? = null,
    @SerialName("giveaway_message")
    val giveawayMessage: Message? = null,
) : TelegramModel()

data class LinkPreviewOptions(
    @SerialName("is_disabled")
    val isDisabled: Boolean? = null,
    @SerialName("url")
    val url: String? = null,
    @SerialName("prefer_small_media")
    val preferSmallMedia: Boolean? = null,
    @SerialName("prefer_large_media")
    val preferLargeMedia: Boolean? = null,
    @SerialName("show_above_text")
    val showAboveText: Boolean? = null,
) : TelegramModel()

data class UserProfilePhotos(
    @SerialName("total_count")
    val totalCount: Long,
    @SerialName("photos")
    val photos: List<List<PhotoSize>>,
) : TelegramModel()

data class File(
    @SerialName("file_id")
    val fileId: String,
    @SerialName("file_unique_id")
    val fileUniqueId: String,
    @SerialName("file_size")
    val fileSize: Long? = null,
    @SerialName("file_path")
    val filePath: String? = null,
) : TelegramModel()

data class WebAppInfo(
    @SerialName("url")
    val url: String,
) : TelegramModel()

data class ReplyKeyboardMarkup(
    @SerialName("keyboard")
    val keyboard: List<List<KeyboardButton>>,
    @SerialName("is_persistent")
    val isPersistent: Boolean? = null,
    @SerialName("resize_keyboard")
    val resizeKeyboard: Boolean? = null,
    @SerialName("one_time_keyboard")
    val oneTimeKeyboard: Boolean? = null,
    @SerialName("input_field_placeholder")
    val inputFieldPlaceholder: String? = null,
    @SerialName("selective")
    val selective: Boolean? = null,
) : KeyboardOption()

data class KeyboardButton(
    @SerialName("text")
    val text: String,
    @SerialName("request_users")
    val requestUsers: KeyboardButtonRequestUsers? = null,
    @SerialName("request_chat")
    val requestChat: KeyboardButtonRequestChat? = null,
    @SerialName("request_contact")
    val requestContact: Boolean? = null,
    @SerialName("request_location")
    val requestLocation: Boolean? = null,
    @SerialName("request_poll")
    val requestPoll: KeyboardButtonPollType? = null,
    @SerialName("web_app")
    val webApp: WebAppInfo? = null,
) : TelegramModel()

data class KeyboardButtonRequestUsers(
    @SerialName("request_id")
    val requestId: Long,
    @SerialName("user_is_bot")
    val userIsBot: Boolean? = null,
    @SerialName("user_is_premium")
    val userIsPremium: Boolean? = null,
    @SerialName("max_quantity")
    val maxQuantity: Long? = null,
    @SerialName("request_name")
    val requestName: Boolean? = null,
    @SerialName("request_username")
    val requestUsername: Boolean? = null,
    @SerialName("request_photo")
    val requestPhoto: Boolean? = null,
) : TelegramModel()

data class KeyboardButtonRequestChat(
    @SerialName("request_id")
    val requestId: Long,
    @SerialName("chat_is_channel")
    val chatIsChannel: Boolean,
    @SerialName("chat_is_forum")
    val chatIsForum: Boolean? = null,
    @SerialName("chat_has_username")
    val chatHasUsername: Boolean? = null,
    @SerialName("chat_is_created")
    val chatIsCreated: Boolean? = null,
    @SerialName("user_administrator_rights")
    val userAdministratorRights: ChatAdministratorRights? = null,
    @SerialName("bot_administrator_rights")
    val botAdministratorRights: ChatAdministratorRights? = null,
    @SerialName("bot_is_member")
    val botIsMember: Boolean? = null,
    @SerialName("request_title")
    val requestTitle: Boolean? = null,
    @SerialName("request_username")
    val requestUsername: Boolean? = null,
    @SerialName("request_photo")
    val requestPhoto: Boolean? = null,
) : TelegramModel()

data class KeyboardButtonPollType(
    @SerialName("type")
    val type: String? = null,
) : TelegramModel()

data class ReplyKeyboardRemove(
    @SerialName("remove_keyboard")
    val removeKeyboard: Boolean,
    @SerialName("selective")
    val selective: Boolean? = null,
) : KeyboardOption()

data class InlineKeyboardMarkup(
    @SerialName("inline_keyboard")
    val inlineKeyboard: List<List<InlineKeyboardButton>>,
) : KeyboardOption()

data class InlineKeyboardButton(
    @SerialName("text")
    val text: String,
    @SerialName("url")
    val url: String? = null,
    @SerialName("callback_data")
    val callbackData: String? = null,
    @SerialName("web_app")
    val webApp: WebAppInfo? = null,
    @SerialName("login_url")
    val loginUrl: LoginUrl? = null,
    @SerialName("switch_inline_query")
    val switchInlineQuery: String? = null,
    @SerialName("switch_inline_query_current_chat")
    val switchInlineQueryCurrentChat: String? = null,
    @SerialName("switch_inline_query_chosen_chat")
    val switchInlineQueryChosenChat: SwitchInlineQueryChosenChat? = null,
    @SerialName("callback_game")
    val callbackGame: Any? = null,
    @SerialName("pay")
    val pay: Boolean? = null,
) : TelegramModel()

data class LoginUrl(
    @SerialName("url")
    val url: String,
    @SerialName("forward_text")
    val forwardText: String? = null,
    @SerialName("bot_username")
    val botUsername: String? = null,
    @SerialName("request_write_access")
    val requestWriteAccess: Boolean? = null,
) : TelegramModel()

data class SwitchInlineQueryChosenChat(
    @SerialName("query")
    val query: String? = null,
    @SerialName("allow_user_chats")
    val allowUserChats: Boolean? = null,
    @SerialName("allow_bot_chats")
    val allowBotChats: Boolean? = null,
    @SerialName("allow_group_chats")
    val allowGroupChats: Boolean? = null,
    @SerialName("allow_channel_chats")
    val allowChannelChats: Boolean? = null,
) : TelegramModel()

data class CallbackQuery(
    @SerialName("id")
    val id: String,
    @SerialName("from")
    val from: User,
    @SerialName("message")
    val message: MaybeInaccessibleMessage? = null,
    @SerialName("inline_message_id")
    val inlineMessageId: String? = null,
    @SerialName("chat_instance")
    val chatInstance: String,
    @SerialName("data")
    val data: String? = null,
    @SerialName("game_short_name")
    val gameShortName: String? = null,
) : TelegramModel()

data class ForceReply(
    @SerialName("force_reply")
    val forceReply: Boolean,
    @SerialName("input_field_placeholder")
    val inputFieldPlaceholder: String? = null,
    @SerialName("selective")
    val selective: Boolean? = null,
) : KeyboardOption()

data class ChatPhoto(
    @SerialName("small_file_id")
    val smallFileId: String,
    @SerialName("small_file_unique_id")
    val smallFileUniqueId: String,
    @SerialName("big_file_id")
    val bigFileId: String,
    @SerialName("big_file_unique_id")
    val bigFileUniqueId: String,
) : TelegramModel()

data class ChatInviteLink(
    @SerialName("invite_link")
    val inviteLink: String,
    @SerialName("creator")
    val creator: User,
    @SerialName("creates_join_request")
    val createsJoinRequest: Boolean,
    @SerialName("is_primary")
    val isPrimary: Boolean,
    @SerialName("is_revoked")
    val isRevoked: Boolean,
    @SerialName("name")
    val name: String? = null,
    @SerialName("expire_date")
    val expireDate: Long? = null,
    @SerialName("member_limit")
    val memberLimit: Long? = null,
    @SerialName("pending_join_request_count")
    val pendingJoinRequestCount: Long? = null,
) : TelegramModel()

data class ChatAdministratorRights(
    @SerialName("is_anonymous")
    val isAnonymous: Boolean,
    @SerialName("can_manage_chat")
    val canManageChat: Boolean,
    @SerialName("can_delete_messages")
    val canDeleteMessages: Boolean,
    @SerialName("can_manage_video_chats")
    val canManageVideoChats: Boolean,
    @SerialName("can_restrict_members")
    val canRestrictMembers: Boolean,
    @SerialName("can_promote_members")
    val canPromoteMembers: Boolean,
    @SerialName("can_change_info")
    val canChangeInfo: Boolean,
    @SerialName("can_invite_users")
    val canInviteUsers: Boolean,
    @SerialName("can_post_stories")
    val canPostStories: Boolean,
    @SerialName("can_edit_stories")
    val canEditStories: Boolean,
    @SerialName("can_delete_stories")
    val canDeleteStories: Boolean,
    @SerialName("can_post_messages")
    val canPostMessages: Boolean? = null,
    @SerialName("can_edit_messages")
    val canEditMessages: Boolean? = null,
    @SerialName("can_pin_messages")
    val canPinMessages: Boolean? = null,
    @SerialName("can_manage_topics")
    val canManageTopics: Boolean? = null,
) : TelegramModel()

data class ChatMemberUpdated(
    @SerialName("chat")
    val chat: Chat,
    @SerialName("from")
    val from: User,
    @SerialName("date")
    val date: Long,
    @SerialName("old_chat_member")
    val oldChatMember: ChatMember,
    @SerialName("new_chat_member")
    val newChatMember: ChatMember,
    @SerialName("invite_link")
    val inviteLink: ChatInviteLink? = null,
    @SerialName("via_join_request")
    val viaJoinRequest: Boolean? = null,
    @SerialName("via_chat_folder_invite_link")
    val viaChatFolderInviteLink: Boolean? = null,
) : ChatMember()

data class ChatMemberOwner(
    @SerialName("status")
    val status: String,
    @SerialName("user")
    val user: User,
    @SerialName("is_anonymous")
    val isAnonymous: Boolean,
    @SerialName("custom_title")
    val customTitle: String? = null,
) : ChatMember()

data class ChatMemberAdministrator(
    @SerialName("status")
    val status: String,
    @SerialName("user")
    val user: User,
    @SerialName("can_be_edited")
    val canBeEdited: Boolean,
    @SerialName("is_anonymous")
    val isAnonymous: Boolean,
    @SerialName("can_manage_chat")
    val canManageChat: Boolean,
    @SerialName("can_delete_messages")
    val canDeleteMessages: Boolean,
    @SerialName("can_manage_video_chats")
    val canManageVideoChats: Boolean,
    @SerialName("can_restrict_members")
    val canRestrictMembers: Boolean,
    @SerialName("can_promote_members")
    val canPromoteMembers: Boolean,
    @SerialName("can_change_info")
    val canChangeInfo: Boolean,
    @SerialName("can_invite_users")
    val canInviteUsers: Boolean,
    @SerialName("can_post_stories")
    val canPostStories: Boolean,
    @SerialName("can_edit_stories")
    val canEditStories: Boolean,
    @SerialName("can_delete_stories")
    val canDeleteStories: Boolean,
    @SerialName("can_post_messages")
    val canPostMessages: Boolean? = null,
    @SerialName("can_edit_messages")
    val canEditMessages: Boolean? = null,
    @SerialName("can_pin_messages")
    val canPinMessages: Boolean? = null,
    @SerialName("can_manage_topics")
    val canManageTopics: Boolean? = null,
    @SerialName("custom_title")
    val customTitle: String? = null,
) : ChatMember()

data class ChatMemberMember(
    @SerialName("status")
    val status: String,
    @SerialName("user")
    val user: User,
) : ChatMember()

data class ChatMemberRestricted(
    @SerialName("status")
    val status: String,
    @SerialName("user")
    val user: User,
    @SerialName("is_member")
    val isMember: Boolean,
    @SerialName("can_send_messages")
    val canSendMessages: Boolean,
    @SerialName("can_send_audios")
    val canSendAudios: Boolean,
    @SerialName("can_send_documents")
    val canSendDocuments: Boolean,
    @SerialName("can_send_photos")
    val canSendPhotos: Boolean,
    @SerialName("can_send_videos")
    val canSendVideos: Boolean,
    @SerialName("can_send_video_notes")
    val canSendVideoNotes: Boolean,
    @SerialName("can_send_voice_notes")
    val canSendVoiceNotes: Boolean,
    @SerialName("can_send_polls")
    val canSendPolls: Boolean,
    @SerialName("can_send_other_messages")
    val canSendOtherMessages: Boolean,
    @SerialName("can_add_web_page_previews")
    val canAddWebPagePreviews: Boolean,
    @SerialName("can_change_info")
    val canChangeInfo: Boolean,
    @SerialName("can_invite_users")
    val canInviteUsers: Boolean,
    @SerialName("can_pin_messages")
    val canPinMessages: Boolean,
    @SerialName("can_manage_topics")
    val canManageTopics: Boolean,
    @SerialName("until_date")
    val untilDate: Long,
) : ChatMember()

data class ChatMemberLeft(
    @SerialName("status")
    val status: String,
    @SerialName("user")
    val user: User,
) : ChatMember()

data class ChatMemberBanned(
    @SerialName("status")
    val status: String,
    @SerialName("user")
    val user: User,
    @SerialName("until_date")
    val untilDate: Long,
) : ChatMember()

data class ChatJoinRequest(
    @SerialName("chat")
    val chat: Chat,
    @SerialName("from")
    val from: User,
    @SerialName("user_chat_id")
    val userChatId: Long,
    @SerialName("date")
    val date: Long,
    @SerialName("bio")
    val bio: String? = null,
    @SerialName("invite_link")
    val inviteLink: ChatInviteLink? = null,
) : TelegramModel()

data class ChatPermissions(
    @SerialName("can_send_messages")
    val canSendMessages: Boolean? = null,
    @SerialName("can_send_audios")
    val canSendAudios: Boolean? = null,
    @SerialName("can_send_documents")
    val canSendDocuments: Boolean? = null,
    @SerialName("can_send_photos")
    val canSendPhotos: Boolean? = null,
    @SerialName("can_send_videos")
    val canSendVideos: Boolean? = null,
    @SerialName("can_send_video_notes")
    val canSendVideoNotes: Boolean? = null,
    @SerialName("can_send_voice_notes")
    val canSendVoiceNotes: Boolean? = null,
    @SerialName("can_send_polls")
    val canSendPolls: Boolean? = null,
    @SerialName("can_send_other_messages")
    val canSendOtherMessages: Boolean? = null,
    @SerialName("can_add_web_page_previews")
    val canAddWebPagePreviews: Boolean? = null,
    @SerialName("can_change_info")
    val canChangeInfo: Boolean? = null,
    @SerialName("can_invite_users")
    val canInviteUsers: Boolean? = null,
    @SerialName("can_pin_messages")
    val canPinMessages: Boolean? = null,
    @SerialName("can_manage_topics")
    val canManageTopics: Boolean? = null,
) : TelegramModel()

data class Birthdate(
    @SerialName("day")
    val day: Long,
    @SerialName("month")
    val month: Long,
    @SerialName("year")
    val year: Long? = null,
) : TelegramModel()

data class BusinessIntro(
    @SerialName("title")
    val title: String? = null,
    @SerialName("message")
    val message: String? = null,
    @SerialName("sticker")
    val sticker: Sticker? = null,
) : TelegramModel()

data class BusinessLocation(
    @SerialName("address")
    val address: String,
    @SerialName("location")
    val location: Location? = null,
) : TelegramModel()

data class BusinessOpeningHoursInterval(
    @SerialName("opening_minute")
    val openingMinute: Long,
    @SerialName("closing_minute")
    val closingMinute: Long,
) : TelegramModel()

data class BusinessOpeningHours(
    @SerialName("time_zone_name")
    val timeZoneName: String,
    @SerialName("opening_hours")
    val openingHours: List<BusinessOpeningHoursInterval>,
) : TelegramModel()

data class ChatLocation(
    @SerialName("location")
    val location: Location,
    @SerialName("address")
    val address: String,
) : TelegramModel()

data class ReactionTypeEmoji(
    @SerialName("type")
    val type: String,
    @SerialName("emoji")
    val emoji: String,
) : ReactionType()

data class ReactionTypeCustomEmoji(
    @SerialName("type")
    val type: String,
    @SerialName("custom_emoji_id")
    val customEmojiId: String,
) : ReactionType()

data class ReactionCount(
    @SerialName("type")
    val type: ReactionType,
    @SerialName("total_count")
    val totalCount: Long,
) : TelegramModel()

data class MessageReactionUpdated(
    @SerialName("chat")
    val chat: Chat,
    @SerialName("message_id")
    val messageId: Long,
    @SerialName("user")
    val user: User? = null,
    @SerialName("actor_chat")
    val actorChat: Chat? = null,
    @SerialName("date")
    val date: Long,
    @SerialName("old_reaction")
    val oldReaction: List<ReactionType>,
    @SerialName("new_reaction")
    val newReaction: List<ReactionType>,
) : TelegramModel()

data class MessageReactionCountUpdated(
    @SerialName("chat")
    val chat: Chat,
    @SerialName("message_id")
    val messageId: Long,
    @SerialName("date")
    val date: Long,
    @SerialName("reactions")
    val reactions: List<ReactionCount>,
) : TelegramModel()

data class ForumTopic(
    @SerialName("message_thread_id")
    val messageThreadId: Long,
    @SerialName("name")
    val name: String,
    @SerialName("icon_color")
    val iconColor: Long,
    @SerialName("icon_custom_emoji_id")
    val iconCustomEmojiId: String? = null,
) : TelegramModel()

data class BotCommand(
    @SerialName("command")
    val command: String,
    @SerialName("description")
    val description: String,
) : TelegramModel()

data class BotCommandScopeDefault(
    @SerialName("type")
    val type: String,
) : BotCommandScope()

data class BotCommandScopeAllPrivateChats(
    @SerialName("type")
    val type: String,
) : BotCommandScope()

data class BotCommandScopeAllGroupChats(
    @SerialName("type")
    val type: String,
) : BotCommandScope()

data class BotCommandScopeAllChatAdministrators(
    @SerialName("type")
    val type: String,
) : BotCommandScope()

data class BotCommandScopeChat(
    @SerialName("type")
    val type: String,
    @SerialName("chat_id")
    val chatId: String,
) : BotCommandScope()

data class BotCommandScopeChatAdministrators(
    @SerialName("type")
    val type: String,
    @SerialName("chat_id")
    val chatId: String,
) : BotCommandScope()

data class BotCommandScopeChatMember(
    @SerialName("type")
    val type: String,
    @SerialName("chat_id")
    val chatId: String,
    @SerialName("user_id")
    val userId: Long,
) : BotCommandScope()

data class BotName(
    @SerialName("name")
    val name: String,
) : TelegramModel()

data class BotDescription(
    @SerialName("description")
    val description: String,
) : TelegramModel()

data class BotShortDescription(
    @SerialName("short_description")
    val shortDescription: String,
) : TelegramModel()

data class MenuButtonCommands(
    @SerialName("type")
    val type: String,
) : MenuButton()

data class MenuButtonWebApp(
    @SerialName("type")
    val type: String,
    @SerialName("text")
    val text: String,
    @SerialName("web_app")
    val webApp: WebAppInfo,
) : MenuButton()

data class MenuButtonDefault(
    @SerialName("type")
    val type: String,
) : MenuButton()

data class ChatBoostSourcePremium(
    @SerialName("source")
    val source: String,
    @SerialName("user")
    val user: User,
) : ChatBoostSource()

data class ChatBoostSourceGiftCode(
    @SerialName("source")
    val source: String,
    @SerialName("user")
    val user: User,
) : ChatBoostSource()

data class ChatBoostSourceGiveaway(
    @SerialName("source")
    val source: String,
    @SerialName("giveaway_message_id")
    val giveawayMessageId: Long,
    @SerialName("user")
    val user: User? = null,
    @SerialName("is_unclaimed")
    val isUnclaimed: Boolean? = null,
) : ChatBoostSource()

data class ChatBoost(
    @SerialName("boost_id")
    val boostId: String,
    @SerialName("add_date")
    val addDate: Long,
    @SerialName("expiration_date")
    val expirationDate: Long,
    @SerialName("source")
    val source: ChatBoostSource,
) : TelegramModel()

data class ChatBoostUpdated(
    @SerialName("chat")
    val chat: Chat,
    @SerialName("boost")
    val boost: ChatBoost,
) : TelegramModel()

data class ChatBoostRemoved(
    @SerialName("chat")
    val chat: Chat,
    @SerialName("boost_id")
    val boostId: String,
    @SerialName("remove_date")
    val removeDate: Long,
    @SerialName("source")
    val source: ChatBoostSource,
) : TelegramModel()

data class UserChatBoosts(
    @SerialName("boosts")
    val boosts: List<ChatBoost>,
) : TelegramModel()

data class BusinessConnection(
    @SerialName("id")
    val id: String,
    @SerialName("user")
    val user: User,
    @SerialName("user_chat_id")
    val userChatId: Long,
    @SerialName("date")
    val date: Long,
    @SerialName("can_reply")
    val canReply: Boolean,
    @SerialName("is_enabled")
    val isEnabled: Boolean,
) : TelegramModel()

data class BusinessMessagesDeleted(
    @SerialName("business_connection_id")
    val businessConnectionId: String,
    @SerialName("chat")
    val chat: Chat,
    @SerialName("message_ids")
    val messageIds: List<Long>,
) : TelegramModel()

data class ResponseParameters(
    @SerialName("migrate_to_chat_id")
    val migrateToChatId: Long? = null,
    @SerialName("retry_after")
    val retryAfter: Long? = null,
) : TelegramModel()

data class InputMediaPhoto(
    @SerialName("type")
    val type: String,
    @SerialName("media")
    val media: String,
    @SerialName("caption")
    val caption: String? = null,
    @SerialName("parse_mode")
    val parseMode: ParseMode? = null,
    @SerialName("caption_entities")
    val captionEntities: List<MessageEntity>? = null,
    @SerialName("show_caption_above_media")
    val showCaptionAboveMedia: Boolean? = null,
    @SerialName("has_spoiler")
    val hasSpoiler: Boolean? = null,
) : InputMedia()

data class InputMediaVideo(
    @SerialName("type")
    val type: String,
    @SerialName("media")
    val media: String,
    @SerialName("thumbnail")
    val thumbnail: String? = null,
    @SerialName("caption")
    val caption: String? = null,
    @SerialName("parse_mode")
    val parseMode: ParseMode? = null,
    @SerialName("caption_entities")
    val captionEntities: List<MessageEntity>? = null,
    @SerialName("show_caption_above_media")
    val showCaptionAboveMedia: Boolean? = null,
    @SerialName("width")
    val width: Long? = null,
    @SerialName("height")
    val height: Long? = null,
    @SerialName("duration")
    val duration: Long? = null,
    @SerialName("supports_streaming")
    val supportsStreaming: Boolean? = null,
    @SerialName("has_spoiler")
    val hasSpoiler: Boolean? = null,
) : InputMedia()

data class InputMediaAnimation(
    @SerialName("type")
    val type: String,
    @SerialName("media")
    val media: String,
    @SerialName("thumbnail")
    val thumbnail: String? = null,
    @SerialName("caption")
    val caption: String? = null,
    @SerialName("parse_mode")
    val parseMode: ParseMode? = null,
    @SerialName("caption_entities")
    val captionEntities: List<MessageEntity>? = null,
    @SerialName("show_caption_above_media")
    val showCaptionAboveMedia: Boolean? = null,
    @SerialName("width")
    val width: Long? = null,
    @SerialName("height")
    val height: Long? = null,
    @SerialName("duration")
    val duration: Long? = null,
    @SerialName("has_spoiler")
    val hasSpoiler: Boolean? = null,
) : InputMedia()

data class InputMediaAudio(
    @SerialName("type")
    val type: String,
    @SerialName("media")
    val media: String,
    @SerialName("thumbnail")
    val thumbnail: String? = null,
    @SerialName("caption")
    val caption: String? = null,
    @SerialName("parse_mode")
    val parseMode: ParseMode? = null,
    @SerialName("caption_entities")
    val captionEntities: List<MessageEntity>? = null,
    @SerialName("duration")
    val duration: Long? = null,
    @SerialName("performer")
    val performer: String? = null,
    @SerialName("title")
    val title: String? = null,
) : InputMedia()

data class InputMediaDocument(
    @SerialName("type")
    val type: String,
    @SerialName("media")
    val media: String,
    @SerialName("thumbnail")
    val thumbnail: String? = null,
    @SerialName("caption")
    val caption: String? = null,
    @SerialName("parse_mode")
    val parseMode: ParseMode? = null,
    @SerialName("caption_entities")
    val captionEntities: List<MessageEntity>? = null,
    @SerialName("disable_content_type_detection")
    val disableContentTypeDetection: Boolean? = null,
) : InputMedia()

data class Sticker(
    @SerialName("file_id")
    val fileId: String,
    @SerialName("file_unique_id")
    val fileUniqueId: String,
    @SerialName("type")
    val type: String,
    @SerialName("width")
    val width: Long,
    @SerialName("height")
    val height: Long,
    @SerialName("is_animated")
    val isAnimated: Boolean,
    @SerialName("is_video")
    val isVideo: Boolean,
    @SerialName("thumbnail")
    val thumbnail: PhotoSize? = null,
    @SerialName("emoji")
    val emoji: String? = null,
    @SerialName("set_name")
    val setName: String? = null,
    @SerialName("premium_animation")
    val premiumAnimation: File? = null,
    @SerialName("mask_position")
    val maskPosition: MaskPosition? = null,
    @SerialName("custom_emoji_id")
    val customEmojiId: String? = null,
    @SerialName("needs_repainting")
    val needsRepainting: Boolean? = null,
    @SerialName("file_size")
    val fileSize: Long? = null,
) : TelegramModel()

data class StickerSet(
    @SerialName("name")
    val name: String,
    @SerialName("title")
    val title: String,
    @SerialName("sticker_type")
    val stickerType: String,
    @SerialName("stickers")
    val stickers: List<Sticker>,
    @SerialName("thumbnail")
    val thumbnail: PhotoSize? = null,
) : TelegramModel()

data class MaskPosition(
    @SerialName("point")
    val point: String,
    @SerialName("x_shift")
    val xShift: Float,
    @SerialName("y_shift")
    val yShift: Float,
    @SerialName("scale")
    val scale: Float,
) : TelegramModel()

data class InputSticker(
    @SerialName("sticker")
    val sticker: String,
    @SerialName("format")
    val format: String,
    @SerialName("emoji_list")
    val emojiList: List<String>,
    @SerialName("mask_position")
    val maskPosition: MaskPosition? = null,
    @SerialName("keywords")
    val keywords: List<String>? = null,
) : TelegramModel()

data class InlineQuery(
    @SerialName("id")
    val id: String,
    @SerialName("from")
    val from: User,
    @SerialName("query")
    val query: String,
    @SerialName("offset")
    val offset: String,
    @SerialName("chat_type")
    val chatType: String? = null,
    @SerialName("location")
    val location: Location? = null,
) : TelegramModel()

data class InlineQueryResultsButton(
    @SerialName("text")
    val text: String,
    @SerialName("web_app")
    val webApp: WebAppInfo? = null,
    @SerialName("start_parameter")
    val startParameter: String? = null,
) : TelegramModel()

data class InlineQueryResultArticle(
    @SerialName("type")
    val type: String,
    @SerialName("id")
    val id: String,
    @SerialName("title")
    val title: String,
    @SerialName("input_message_content")
    val inputMessageContent: InputMessageContent,
    @SerialName("reply_markup")
    val replyMarkup: InlineKeyboardMarkup? = null,
    @SerialName("url")
    val url: String? = null,
    @SerialName("hide_url")
    val hideUrl: Boolean? = null,
    @SerialName("description")
    val description: String? = null,
    @SerialName("thumbnail_url")
    val thumbnailUrl: String? = null,
    @SerialName("thumbnail_width")
    val thumbnailWidth: Long? = null,
    @SerialName("thumbnail_height")
    val thumbnailHeight: Long? = null,
) : InlineQueryResult()

data class InlineQueryResultPhoto(
    @SerialName("type")
    val type: String,
    @SerialName("id")
    val id: String,
    @SerialName("photo_url")
    val photoUrl: String,
    @SerialName("thumbnail_url")
    val thumbnailUrl: String,
    @SerialName("photo_width")
    val photoWidth: Long? = null,
    @SerialName("photo_height")
    val photoHeight: Long? = null,
    @SerialName("title")
    val title: String? = null,
    @SerialName("description")
    val description: String? = null,
    @SerialName("caption")
    val caption: String? = null,
    @SerialName("parse_mode")
    val parseMode: ParseMode? = null,
    @SerialName("caption_entities")
    val captionEntities: List<MessageEntity>? = null,
    @SerialName("show_caption_above_media")
    val showCaptionAboveMedia: Boolean? = null,
    @SerialName("reply_markup")
    val replyMarkup: InlineKeyboardMarkup? = null,
    @SerialName("input_message_content")
    val inputMessageContent: InputMessageContent? = null,
) : InlineQueryResult()

data class InlineQueryResultGif(
    @SerialName("type")
    val type: String,
    @SerialName("id")
    val id: String,
    @SerialName("gif_url")
    val gifUrl: String,
    @SerialName("gif_width")
    val gifWidth: Long? = null,
    @SerialName("gif_height")
    val gifHeight: Long? = null,
    @SerialName("gif_duration")
    val gifDuration: Long? = null,
    @SerialName("thumbnail_url")
    val thumbnailUrl: String,
    @SerialName("thumbnail_mime_type")
    val thumbnailMimeType: String? = null,
    @SerialName("title")
    val title: String? = null,
    @SerialName("caption")
    val caption: String? = null,
    @SerialName("parse_mode")
    val parseMode: ParseMode? = null,
    @SerialName("caption_entities")
    val captionEntities: List<MessageEntity>? = null,
    @SerialName("show_caption_above_media")
    val showCaptionAboveMedia: Boolean? = null,
    @SerialName("reply_markup")
    val replyMarkup: InlineKeyboardMarkup? = null,
    @SerialName("input_message_content")
    val inputMessageContent: InputMessageContent? = null,
) : InlineQueryResult()

data class InlineQueryResultMpeg4Gif(
    @SerialName("type")
    val type: String,
    @SerialName("id")
    val id: String,
    @SerialName("mpeg4_url")
    val mpeg4Url: String,
    @SerialName("mpeg4_width")
    val mpeg4Width: Long? = null,
    @SerialName("mpeg4_height")
    val mpeg4Height: Long? = null,
    @SerialName("mpeg4_duration")
    val mpeg4Duration: Long? = null,
    @SerialName("thumbnail_url")
    val thumbnailUrl: String,
    @SerialName("thumbnail_mime_type")
    val thumbnailMimeType: String? = null,
    @SerialName("title")
    val title: String? = null,
    @SerialName("caption")
    val caption: String? = null,
    @SerialName("parse_mode")
    val parseMode: ParseMode? = null,
    @SerialName("caption_entities")
    val captionEntities: List<MessageEntity>? = null,
    @SerialName("show_caption_above_media")
    val showCaptionAboveMedia: Boolean? = null,
    @SerialName("reply_markup")
    val replyMarkup: InlineKeyboardMarkup? = null,
    @SerialName("input_message_content")
    val inputMessageContent: InputMessageContent? = null,
) : InlineQueryResult()

data class InlineQueryResultVideo(
    @SerialName("type")
    val type: String,
    @SerialName("id")
    val id: String,
    @SerialName("video_url")
    val videoUrl: String,
    @SerialName("mime_type")
    val mimeType: String,
    @SerialName("thumbnail_url")
    val thumbnailUrl: String,
    @SerialName("title")
    val title: String,
    @SerialName("caption")
    val caption: String? = null,
    @SerialName("parse_mode")
    val parseMode: ParseMode? = null,
    @SerialName("caption_entities")
    val captionEntities: List<MessageEntity>? = null,
    @SerialName("show_caption_above_media")
    val showCaptionAboveMedia: Boolean? = null,
    @SerialName("video_width")
    val videoWidth: Long? = null,
    @SerialName("video_height")
    val videoHeight: Long? = null,
    @SerialName("video_duration")
    val videoDuration: Long? = null,
    @SerialName("description")
    val description: String? = null,
    @SerialName("reply_markup")
    val replyMarkup: InlineKeyboardMarkup? = null,
    @SerialName("input_message_content")
    val inputMessageContent: InputMessageContent? = null,
) : InlineQueryResult()

data class InlineQueryResultAudio(
    @SerialName("type")
    val type: String,
    @SerialName("id")
    val id: String,
    @SerialName("audio_url")
    val audioUrl: String,
    @SerialName("title")
    val title: String,
    @SerialName("caption")
    val caption: String? = null,
    @SerialName("parse_mode")
    val parseMode: ParseMode? = null,
    @SerialName("caption_entities")
    val captionEntities: List<MessageEntity>? = null,
    @SerialName("performer")
    val performer: String? = null,
    @SerialName("audio_duration")
    val audioDuration: Long? = null,
    @SerialName("reply_markup")
    val replyMarkup: InlineKeyboardMarkup? = null,
    @SerialName("input_message_content")
    val inputMessageContent: InputMessageContent? = null,
) : InlineQueryResult()

data class InlineQueryResultVoice(
    @SerialName("type")
    val type: String,
    @SerialName("id")
    val id: String,
    @SerialName("voice_url")
    val voiceUrl: String,
    @SerialName("title")
    val title: String,
    @SerialName("caption")
    val caption: String? = null,
    @SerialName("parse_mode")
    val parseMode: ParseMode? = null,
    @SerialName("caption_entities")
    val captionEntities: List<MessageEntity>? = null,
    @SerialName("voice_duration")
    val voiceDuration: Long? = null,
    @SerialName("reply_markup")
    val replyMarkup: InlineKeyboardMarkup? = null,
    @SerialName("input_message_content")
    val inputMessageContent: InputMessageContent? = null,
) : InlineQueryResult()

data class InlineQueryResultDocument(
    @SerialName("type")
    val type: String,
    @SerialName("id")
    val id: String,
    @SerialName("title")
    val title: String,
    @SerialName("caption")
    val caption: String? = null,
    @SerialName("parse_mode")
    val parseMode: ParseMode? = null,
    @SerialName("caption_entities")
    val captionEntities: List<MessageEntity>? = null,
    @SerialName("document_url")
    val documentUrl: String,
    @SerialName("mime_type")
    val mimeType: String,
    @SerialName("description")
    val description: String? = null,
    @SerialName("reply_markup")
    val replyMarkup: InlineKeyboardMarkup? = null,
    @SerialName("input_message_content")
    val inputMessageContent: InputMessageContent? = null,
    @SerialName("thumbnail_url")
    val thumbnailUrl: String? = null,
    @SerialName("thumbnail_width")
    val thumbnailWidth: Long? = null,
    @SerialName("thumbnail_height")
    val thumbnailHeight: Long? = null,
) : InlineQueryResult()

data class InlineQueryResultLocation(
    @SerialName("type")
    val type: String,
    @SerialName("id")
    val id: String,
    @SerialName("latitude")
    val latitude: Float,
    @SerialName("longitude")
    val longitude: Float,
    @SerialName("title")
    val title: String,
    @SerialName("horizontal_accuracy")
    val horizontalAccuracy: Float? = null,
    @SerialName("live_period")
    val livePeriod: Long? = null,
    @SerialName("heading")
    val heading: Long? = null,
    @SerialName("proximity_alert_radius")
    val proximityAlertRadius: Long? = null,
    @SerialName("reply_markup")
    val replyMarkup: InlineKeyboardMarkup? = null,
    @SerialName("input_message_content")
    val inputMessageContent: InputMessageContent? = null,
    @SerialName("thumbnail_url")
    val thumbnailUrl: String? = null,
    @SerialName("thumbnail_width")
    val thumbnailWidth: Long? = null,
    @SerialName("thumbnail_height")
    val thumbnailHeight: Long? = null,
) : InlineQueryResult()

data class InlineQueryResultVenue(
    @SerialName("type")
    val type: String,
    @SerialName("id")
    val id: String,
    @SerialName("latitude")
    val latitude: Float,
    @SerialName("longitude")
    val longitude: Float,
    @SerialName("title")
    val title: String,
    @SerialName("address")
    val address: String,
    @SerialName("foursquare_id")
    val foursquareId: String? = null,
    @SerialName("foursquare_type")
    val foursquareType: String? = null,
    @SerialName("google_place_id")
    val googlePlaceId: String? = null,
    @SerialName("google_place_type")
    val googlePlaceType: String? = null,
    @SerialName("reply_markup")
    val replyMarkup: InlineKeyboardMarkup? = null,
    @SerialName("input_message_content")
    val inputMessageContent: InputMessageContent? = null,
    @SerialName("thumbnail_url")
    val thumbnailUrl: String? = null,
    @SerialName("thumbnail_width")
    val thumbnailWidth: Long? = null,
    @SerialName("thumbnail_height")
    val thumbnailHeight: Long? = null,
) : InlineQueryResult()

data class InlineQueryResultContact(
    @SerialName("type")
    val type: String,
    @SerialName("id")
    val id: String,
    @SerialName("phone_number")
    val phoneNumber: String,
    @SerialName("first_name")
    val firstName: String,
    @SerialName("last_name")
    val lastName: String? = null,
    @SerialName("vcard")
    val vcard: String? = null,
    @SerialName("reply_markup")
    val replyMarkup: InlineKeyboardMarkup? = null,
    @SerialName("input_message_content")
    val inputMessageContent: InputMessageContent? = null,
    @SerialName("thumbnail_url")
    val thumbnailUrl: String? = null,
    @SerialName("thumbnail_width")
    val thumbnailWidth: Long? = null,
    @SerialName("thumbnail_height")
    val thumbnailHeight: Long? = null,
) : InlineQueryResult()

data class InlineQueryResultGame(
    @SerialName("type")
    val type: String,
    @SerialName("id")
    val id: String,
    @SerialName("game_short_name")
    val gameShortName: String,
    @SerialName("reply_markup")
    val replyMarkup: InlineKeyboardMarkup? = null,
) : InlineQueryResult()

data class InlineQueryResultCachedPhoto(
    @SerialName("type")
    val type: String,
    @SerialName("id")
    val id: String,
    @SerialName("photo_file_id")
    val photoFileId: String,
    @SerialName("title")
    val title: String? = null,
    @SerialName("description")
    val description: String? = null,
    @SerialName("caption")
    val caption: String? = null,
    @SerialName("parse_mode")
    val parseMode: ParseMode? = null,
    @SerialName("caption_entities")
    val captionEntities: List<MessageEntity>? = null,
    @SerialName("show_caption_above_media")
    val showCaptionAboveMedia: Boolean? = null,
    @SerialName("reply_markup")
    val replyMarkup: InlineKeyboardMarkup? = null,
    @SerialName("input_message_content")
    val inputMessageContent: InputMessageContent? = null,
) : InlineQueryResult()

data class InlineQueryResultCachedGif(
    @SerialName("type")
    val type: String,
    @SerialName("id")
    val id: String,
    @SerialName("gif_file_id")
    val gifFileId: String,
    @SerialName("title")
    val title: String? = null,
    @SerialName("caption")
    val caption: String? = null,
    @SerialName("parse_mode")
    val parseMode: ParseMode? = null,
    @SerialName("caption_entities")
    val captionEntities: List<MessageEntity>? = null,
    @SerialName("show_caption_above_media")
    val showCaptionAboveMedia: Boolean? = null,
    @SerialName("reply_markup")
    val replyMarkup: InlineKeyboardMarkup? = null,
    @SerialName("input_message_content")
    val inputMessageContent: InputMessageContent? = null,
) : InlineQueryResult()

data class InlineQueryResultCachedMpeg4Gif(
    @SerialName("type")
    val type: String,
    @SerialName("id")
    val id: String,
    @SerialName("mpeg4_file_id")
    val mpeg4FileId: String,
    @SerialName("title")
    val title: String? = null,
    @SerialName("caption")
    val caption: String? = null,
    @SerialName("parse_mode")
    val parseMode: ParseMode? = null,
    @SerialName("caption_entities")
    val captionEntities: List<MessageEntity>? = null,
    @SerialName("show_caption_above_media")
    val showCaptionAboveMedia: Boolean? = null,
    @SerialName("reply_markup")
    val replyMarkup: InlineKeyboardMarkup? = null,
    @SerialName("input_message_content")
    val inputMessageContent: InputMessageContent? = null,
) : InlineQueryResult()

data class InlineQueryResultCachedSticker(
    @SerialName("type")
    val type: String,
    @SerialName("id")
    val id: String,
    @SerialName("sticker_file_id")
    val stickerFileId: String,
    @SerialName("reply_markup")
    val replyMarkup: InlineKeyboardMarkup? = null,
    @SerialName("input_message_content")
    val inputMessageContent: InputMessageContent? = null,
) : InlineQueryResult()

data class InlineQueryResultCachedDocument(
    @SerialName("type")
    val type: String,
    @SerialName("id")
    val id: String,
    @SerialName("title")
    val title: String,
    @SerialName("document_file_id")
    val documentFileId: String,
    @SerialName("description")
    val description: String? = null,
    @SerialName("caption")
    val caption: String? = null,
    @SerialName("parse_mode")
    val parseMode: ParseMode? = null,
    @SerialName("caption_entities")
    val captionEntities: List<MessageEntity>? = null,
    @SerialName("reply_markup")
    val replyMarkup: InlineKeyboardMarkup? = null,
    @SerialName("input_message_content")
    val inputMessageContent: InputMessageContent? = null,
) : InlineQueryResult()

data class InlineQueryResultCachedVideo(
    @SerialName("type")
    val type: String,
    @SerialName("id")
    val id: String,
    @SerialName("video_file_id")
    val videoFileId: String,
    @SerialName("title")
    val title: String,
    @SerialName("description")
    val description: String? = null,
    @SerialName("caption")
    val caption: String? = null,
    @SerialName("parse_mode")
    val parseMode: ParseMode? = null,
    @SerialName("caption_entities")
    val captionEntities: List<MessageEntity>? = null,
    @SerialName("show_caption_above_media")
    val showCaptionAboveMedia: Boolean? = null,
    @SerialName("reply_markup")
    val replyMarkup: InlineKeyboardMarkup? = null,
    @SerialName("input_message_content")
    val inputMessageContent: InputMessageContent? = null,
) : InlineQueryResult()

data class InlineQueryResultCachedVoice(
    @SerialName("type")
    val type: String,
    @SerialName("id")
    val id: String,
    @SerialName("voice_file_id")
    val voiceFileId: String,
    @SerialName("title")
    val title: String,
    @SerialName("caption")
    val caption: String? = null,
    @SerialName("parse_mode")
    val parseMode: ParseMode? = null,
    @SerialName("caption_entities")
    val captionEntities: List<MessageEntity>? = null,
    @SerialName("reply_markup")
    val replyMarkup: InlineKeyboardMarkup? = null,
    @SerialName("input_message_content")
    val inputMessageContent: InputMessageContent? = null,
) : InlineQueryResult()

data class InlineQueryResultCachedAudio(
    @SerialName("type")
    val type: String,
    @SerialName("id")
    val id: String,
    @SerialName("audio_file_id")
    val audioFileId: String,
    @SerialName("caption")
    val caption: String? = null,
    @SerialName("parse_mode")
    val parseMode: ParseMode? = null,
    @SerialName("caption_entities")
    val captionEntities: List<MessageEntity>? = null,
    @SerialName("reply_markup")
    val replyMarkup: InlineKeyboardMarkup? = null,
    @SerialName("input_message_content")
    val inputMessageContent: InputMessageContent? = null,
) : InlineQueryResult()

data class InputTextMessageContent(
    @SerialName("message_text")
    val messageText: String,
    @SerialName("parse_mode")
    val parseMode: ParseMode? = null,
    @SerialName("entities")
    val entities: List<MessageEntity>? = null,
    @SerialName("link_preview_options")
    val linkPreviewOptions: LinkPreviewOptions? = null,
) : InputMessageContent()

data class InputLocationMessageContent(
    @SerialName("latitude")
    val latitude: Float,
    @SerialName("longitude")
    val longitude: Float,
    @SerialName("horizontal_accuracy")
    val horizontalAccuracy: Float? = null,
    @SerialName("live_period")
    val livePeriod: Long? = null,
    @SerialName("heading")
    val heading: Long? = null,
    @SerialName("proximity_alert_radius")
    val proximityAlertRadius: Long? = null,
) : InputMessageContent()

data class InputVenueMessageContent(
    @SerialName("latitude")
    val latitude: Float,
    @SerialName("longitude")
    val longitude: Float,
    @SerialName("title")
    val title: String,
    @SerialName("address")
    val address: String,
    @SerialName("foursquare_id")
    val foursquareId: String? = null,
    @SerialName("foursquare_type")
    val foursquareType: String? = null,
    @SerialName("google_place_id")
    val googlePlaceId: String? = null,
    @SerialName("google_place_type")
    val googlePlaceType: String? = null,
) : InputMessageContent()

data class InputContactMessageContent(
    @SerialName("phone_number")
    val phoneNumber: String,
    @SerialName("first_name")
    val firstName: String,
    @SerialName("last_name")
    val lastName: String? = null,
    @SerialName("vcard")
    val vcard: String? = null,
) : InputMessageContent()

data class InputInvoiceMessageContent(
    @SerialName("title")
    val title: String,
    @SerialName("description")
    val description: String,
    @SerialName("payload")
    val payload: String,
    @SerialName("provider_token")
    val providerToken: String? = null,
    @SerialName("currency")
    val currency: String,
    @SerialName("prices")
    val prices: List<LabeledPrice>,
    @SerialName("max_tip_amount")
    val maxTipAmount: Long? = null,
    @SerialName("suggested_tip_amounts")
    val suggestedTipAmounts: List<Long>? = null,
    @SerialName("provider_data")
    val providerData: String? = null,
    @SerialName("photo_url")
    val photoUrl: String? = null,
    @SerialName("photo_size")
    val photoSize: Long? = null,
    @SerialName("photo_width")
    val photoWidth: Long? = null,
    @SerialName("photo_height")
    val photoHeight: Long? = null,
    @SerialName("need_name")
    val needName: Boolean? = null,
    @SerialName("need_phone_number")
    val needPhoneNumber: Boolean? = null,
    @SerialName("need_email")
    val needEmail: Boolean? = null,
    @SerialName("need_shipping_address")
    val needShippingAddress: Boolean? = null,
    @SerialName("send_phone_number_to_provider")
    val sendPhoneNumberToProvider: Boolean? = null,
    @SerialName("send_email_to_provider")
    val sendEmailToProvider: Boolean? = null,
    @SerialName("is_flexible")
    val isFlexible: Boolean? = null,
) : InputMessageContent()

data class ChosenInlineResult(
    @SerialName("result_id")
    val resultId: String,
    @SerialName("from")
    val from: User,
    @SerialName("location")
    val location: Location? = null,
    @SerialName("inline_message_id")
    val inlineMessageId: String? = null,
    @SerialName("query")
    val query: String,
) : TelegramModel()

data class SentWebAppMessage(
    @SerialName("inline_message_id")
    val inlineMessageId: String? = null,
) : TelegramModel()

data class LabeledPrice(
    @SerialName("label")
    val label: String,
    @SerialName("amount")
    val amount: Long,
) : TelegramModel()

data class Invoice(
    @SerialName("title")
    val title: String,
    @SerialName("description")
    val description: String,
    @SerialName("start_parameter")
    val startParameter: String,
    @SerialName("currency")
    val currency: String,
    @SerialName("total_amount")
    val totalAmount: Long,
) : TelegramModel()

data class ShippingAddress(
    @SerialName("country_code")
    val countryCode: String,
    @SerialName("state")
    val state: String,
    @SerialName("city")
    val city: String,
    @SerialName("street_line1")
    val streetLine1: String,
    @SerialName("street_line2")
    val streetLine2: String,
    @SerialName("post_code")
    val postCode: String,
) : TelegramModel()

data class OrderInfo(
    @SerialName("name")
    val name: String? = null,
    @SerialName("phone_number")
    val phoneNumber: String? = null,
    @SerialName("email")
    val email: String? = null,
    @SerialName("shipping_address")
    val shippingAddress: ShippingAddress? = null,
) : TelegramModel()

data class ShippingOption(
    @SerialName("id")
    val id: String,
    @SerialName("title")
    val title: String,
    @SerialName("prices")
    val prices: List<LabeledPrice>,
) : TelegramModel()

data class SuccessfulPayment(
    @SerialName("currency")
    val currency: String,
    @SerialName("total_amount")
    val totalAmount: Long,
    @SerialName("invoice_payload")
    val invoicePayload: String,
    @SerialName("shipping_option_id")
    val shippingOptionId: String? = null,
    @SerialName("order_info")
    val orderInfo: OrderInfo? = null,
    @SerialName("telegram_payment_charge_id")
    val telegramPaymentChargeId: String,
    @SerialName("provider_payment_charge_id")
    val providerPaymentChargeId: String,
) : TelegramModel()

data class ShippingQuery(
    @SerialName("id")
    val id: String,
    @SerialName("from")
    val from: User,
    @SerialName("invoice_payload")
    val invoicePayload: String,
    @SerialName("shipping_address")
    val shippingAddress: ShippingAddress,
) : TelegramModel()

data class PreCheckoutQuery(
    @SerialName("id")
    val id: String,
    @SerialName("from")
    val from: User,
    @SerialName("currency")
    val currency: String,
    @SerialName("total_amount")
    val totalAmount: Long,
    @SerialName("invoice_payload")
    val invoicePayload: String,
    @SerialName("shipping_option_id")
    val shippingOptionId: String? = null,
    @SerialName("order_info")
    val orderInfo: OrderInfo? = null,
) : TelegramModel()

data class PassportData(
    @SerialName("data")
    val data: List<EncryptedPassportElement>,
    @SerialName("credentials")
    val credentials: EncryptedCredentials,
) : TelegramModel()

data class PassportFile(
    @SerialName("file_id")
    val fileId: String,
    @SerialName("file_unique_id")
    val fileUniqueId: String,
    @SerialName("file_size")
    val fileSize: Long,
    @SerialName("file_date")
    val fileDate: Long,
) : TelegramModel()

data class EncryptedPassportElement(
    @SerialName("type")
    val type: String,
    @SerialName("data")
    val data: String? = null,
    @SerialName("phone_number")
    val phoneNumber: String? = null,
    @SerialName("email")
    val email: String? = null,
    @SerialName("files")
    val files: List<PassportFile>? = null,
    @SerialName("front_side")
    val frontSide: PassportFile? = null,
    @SerialName("reverse_side")
    val reverseSide: PassportFile? = null,
    @SerialName("selfie")
    val selfie: PassportFile? = null,
    @SerialName("translation")
    val translation: List<PassportFile>? = null,
    @SerialName("hash")
    val hash: String,
) : TelegramModel()

data class EncryptedCredentials(
    @SerialName("data")
    val data: String,
    @SerialName("hash")
    val hash: String,
    @SerialName("secret")
    val secret: String,
) : TelegramModel()

data class PassportElementErrorDataField(
    @SerialName("source")
    val source: String,
    @SerialName("type")
    val type: String,
    @SerialName("field_name")
    val fieldName: String,
    @SerialName("data_hash")
    val dataHash: String,
    @SerialName("message")
    val message: String,
) : PassportElementError()

data class PassportElementErrorFrontSide(
    @SerialName("source")
    val source: String,
    @SerialName("type")
    val type: String,
    @SerialName("file_hash")
    val fileHash: String,
    @SerialName("message")
    val message: String,
) : PassportElementError()

data class PassportElementErrorReverseSide(
    @SerialName("source")
    val source: String,
    @SerialName("type")
    val type: String,
    @SerialName("file_hash")
    val fileHash: String,
    @SerialName("message")
    val message: String,
) : PassportElementError()

data class PassportElementErrorSelfie(
    @SerialName("source")
    val source: String,
    @SerialName("type")
    val type: String,
    @SerialName("file_hash")
    val fileHash: String,
    @SerialName("message")
    val message: String,
) : PassportElementError()

data class PassportElementErrorFile(
    @SerialName("source")
    val source: String,
    @SerialName("type")
    val type: String,
    @SerialName("file_hash")
    val fileHash: String,
    @SerialName("message")
    val message: String,
) : PassportElementError()

data class PassportElementErrorFiles(
    @SerialName("source")
    val source: String,
    @SerialName("type")
    val type: String,
    @SerialName("file_hashes")
    val fileHashes: List<String>,
    @SerialName("message")
    val message: String,
) : PassportElementError()

data class PassportElementErrorTranslationFile(
    @SerialName("source")
    val source: String,
    @SerialName("type")
    val type: String,
    @SerialName("file_hash")
    val fileHash: String,
    @SerialName("message")
    val message: String,
) : PassportElementError()

data class PassportElementErrorTranslationFiles(
    @SerialName("source")
    val source: String,
    @SerialName("type")
    val type: String,
    @SerialName("file_hashes")
    val fileHashes: List<String>,
    @SerialName("message")
    val message: String,
) : PassportElementError()

data class PassportElementErrorUnspecified(
    @SerialName("source")
    val source: String,
    @SerialName("type")
    val type: String,
    @SerialName("element_hash")
    val elementHash: String,
    @SerialName("message")
    val message: String,
) : PassportElementError()

data class Game(
    @SerialName("title")
    val title: String,
    @SerialName("description")
    val description: String,
    @SerialName("photo")
    val photo: List<PhotoSize>,
    @SerialName("text")
    val text: String? = null,
    @SerialName("text_entities")
    val textEntities: List<MessageEntity>? = null,
    @SerialName("animation")
    val animation: Animation? = null,
) : TelegramModel()

data class GameHighScore(
    @SerialName("position")
    val position: Long,
    @SerialName("user")
    val user: User,
    @SerialName("score")
    val score: Long,
) : TelegramModel()

sealed class TelegramRequest {

    data class GetUpdatesRequest(
        val offset: Long? = null,
        val limit: Long? = null,
        val timeout: Long? = null,
        val allowedUpdates: List<String>? = null,
    ) : TelegramRequest()

    data class SetWebhookRequest(
        val url: String,
        val certificate: Any? = null,
        val ipAddress: String? = null,
        val maxConnections: Long? = null,
        val allowedUpdates: List<String>? = null,
        val dropPendingUpdates: Boolean? = null,
        val secretToken: String? = null,
    ) : TelegramRequest()

    data class DeleteWebhookRequest(
        val dropPendingUpdates: Boolean? = null,
    ) : TelegramRequest()

    data class SendMessageRequest(
        val businessConnectionId: String? = null,
        val chatId: String,
        val messageThreadId: Long? = null,
        val text: String,
        val parseMode: ParseMode? = null,
        val entities: List<MessageEntity>? = null,
        val linkPreviewOptions: LinkPreviewOptions? = null,
        val disableNotification: Boolean? = null,
        val protectContent: Boolean? = null,
        val messageEffectId: String? = null,
        val replyParameters: ReplyParameters? = null,
        val replyMarkup: KeyboardOption? = null,
    ) : TelegramRequest()

    data class ForwardMessageRequest(
        val chatId: String,
        val messageThreadId: Long? = null,
        val fromChatId: String,
        val disableNotification: Boolean? = null,
        val protectContent: Boolean? = null,
        val messageId: Long,
    ) : TelegramRequest()

    data class ForwardMessagesRequest(
        val chatId: String,
        val messageThreadId: Long? = null,
        val fromChatId: String,
        val messageIds: List<Long>,
        val disableNotification: Boolean? = null,
        val protectContent: Boolean? = null,
    ) : TelegramRequest()

    data class CopyMessageRequest(
        val chatId: String,
        val messageThreadId: Long? = null,
        val fromChatId: String,
        val messageId: Long,
        val caption: String? = null,
        val parseMode: ParseMode? = null,
        val captionEntities: List<MessageEntity>? = null,
        val showCaptionAboveMedia: Boolean? = null,
        val disableNotification: Boolean? = null,
        val protectContent: Boolean? = null,
        val replyParameters: ReplyParameters? = null,
        val replyMarkup: KeyboardOption? = null,
    ) : TelegramRequest()

    data class CopyMessagesRequest(
        val chatId: String,
        val messageThreadId: Long? = null,
        val fromChatId: String,
        val messageIds: List<Long>,
        val disableNotification: Boolean? = null,
        val protectContent: Boolean? = null,
        val removeCaption: Boolean? = null,
    ) : TelegramRequest()

    data class SendPhotoRequest(
        val businessConnectionId: String? = null,
        val chatId: String,
        val messageThreadId: Long? = null,
        val photo: String,
        val caption: String? = null,
        val parseMode: ParseMode? = null,
        val captionEntities: List<MessageEntity>? = null,
        val showCaptionAboveMedia: Boolean? = null,
        val hasSpoiler: Boolean? = null,
        val disableNotification: Boolean? = null,
        val protectContent: Boolean? = null,
        val messageEffectId: String? = null,
        val replyParameters: ReplyParameters? = null,
        val replyMarkup: KeyboardOption? = null,
    ) : TelegramRequest()

    data class SendAudioRequest(
        val businessConnectionId: String? = null,
        val chatId: String,
        val messageThreadId: Long? = null,
        val audio: String,
        val caption: String? = null,
        val parseMode: ParseMode? = null,
        val captionEntities: List<MessageEntity>? = null,
        val duration: Long? = null,
        val performer: String? = null,
        val title: String? = null,
        val thumbnail: String? = null,
        val disableNotification: Boolean? = null,
        val protectContent: Boolean? = null,
        val messageEffectId: String? = null,
        val replyParameters: ReplyParameters? = null,
        val replyMarkup: KeyboardOption? = null,
    ) : TelegramRequest()

    data class SendDocumentRequest(
        val businessConnectionId: String? = null,
        val chatId: String,
        val messageThreadId: Long? = null,
        val document: String,
        val thumbnail: String? = null,
        val caption: String? = null,
        val parseMode: ParseMode? = null,
        val captionEntities: List<MessageEntity>? = null,
        val disableContentTypeDetection: Boolean? = null,
        val disableNotification: Boolean? = null,
        val protectContent: Boolean? = null,
        val messageEffectId: String? = null,
        val replyParameters: ReplyParameters? = null,
        val replyMarkup: KeyboardOption? = null,
    ) : TelegramRequest()

    data class SendVideoRequest(
        val businessConnectionId: String? = null,
        val chatId: String,
        val messageThreadId: Long? = null,
        val video: String,
        val duration: Long? = null,
        val width: Long? = null,
        val height: Long? = null,
        val thumbnail: String? = null,
        val caption: String? = null,
        val parseMode: ParseMode? = null,
        val captionEntities: List<MessageEntity>? = null,
        val showCaptionAboveMedia: Boolean? = null,
        val hasSpoiler: Boolean? = null,
        val supportsStreaming: Boolean? = null,
        val disableNotification: Boolean? = null,
        val protectContent: Boolean? = null,
        val messageEffectId: String? = null,
        val replyParameters: ReplyParameters? = null,
        val replyMarkup: KeyboardOption? = null,
    ) : TelegramRequest()

    data class SendAnimationRequest(
        val businessConnectionId: String? = null,
        val chatId: String,
        val messageThreadId: Long? = null,
        val animation: String,
        val duration: Long? = null,
        val width: Long? = null,
        val height: Long? = null,
        val thumbnail: String? = null,
        val caption: String? = null,
        val parseMode: ParseMode? = null,
        val captionEntities: List<MessageEntity>? = null,
        val showCaptionAboveMedia: Boolean? = null,
        val hasSpoiler: Boolean? = null,
        val disableNotification: Boolean? = null,
        val protectContent: Boolean? = null,
        val messageEffectId: String? = null,
        val replyParameters: ReplyParameters? = null,
        val replyMarkup: KeyboardOption? = null,
    ) : TelegramRequest()

    data class SendVoiceRequest(
        val businessConnectionId: String? = null,
        val chatId: String,
        val messageThreadId: Long? = null,
        val voice: String,
        val caption: String? = null,
        val parseMode: ParseMode? = null,
        val captionEntities: List<MessageEntity>? = null,
        val duration: Long? = null,
        val disableNotification: Boolean? = null,
        val protectContent: Boolean? = null,
        val messageEffectId: String? = null,
        val replyParameters: ReplyParameters? = null,
        val replyMarkup: KeyboardOption? = null,
    ) : TelegramRequest()

    data class SendVideoNoteRequest(
        val businessConnectionId: String? = null,
        val chatId: String,
        val messageThreadId: Long? = null,
        val videoNote: String,
        val duration: Long? = null,
        val length: Long? = null,
        val thumbnail: String? = null,
        val disableNotification: Boolean? = null,
        val protectContent: Boolean? = null,
        val messageEffectId: String? = null,
        val replyParameters: ReplyParameters? = null,
        val replyMarkup: KeyboardOption? = null,
    ) : TelegramRequest()

    data class SendMediaGroupRequest(
        val businessConnectionId: String? = null,
        val chatId: String,
        val messageThreadId: Long? = null,
        val media: List<InputMedia>,
        val disableNotification: Boolean? = null,
        val protectContent: Boolean? = null,
        val messageEffectId: String? = null,
        val replyParameters: ReplyParameters? = null,
    ) : TelegramRequest()

    data class SendLocationRequest(
        val businessConnectionId: String? = null,
        val chatId: String,
        val messageThreadId: Long? = null,
        val latitude: Float,
        val longitude: Float,
        val horizontalAccuracy: Float? = null,
        val livePeriod: Long? = null,
        val heading: Long? = null,
        val proximityAlertRadius: Long? = null,
        val disableNotification: Boolean? = null,
        val protectContent: Boolean? = null,
        val messageEffectId: String? = null,
        val replyParameters: ReplyParameters? = null,
        val replyMarkup: KeyboardOption? = null,
    ) : TelegramRequest()

    data class SendVenueRequest(
        val businessConnectionId: String? = null,
        val chatId: String,
        val messageThreadId: Long? = null,
        val latitude: Float,
        val longitude: Float,
        val title: String,
        val address: String,
        val foursquareId: String? = null,
        val foursquareType: String? = null,
        val googlePlaceId: String? = null,
        val googlePlaceType: String? = null,
        val disableNotification: Boolean? = null,
        val protectContent: Boolean? = null,
        val messageEffectId: String? = null,
        val replyParameters: ReplyParameters? = null,
        val replyMarkup: KeyboardOption? = null,
    ) : TelegramRequest()

    data class SendContactRequest(
        val businessConnectionId: String? = null,
        val chatId: String,
        val messageThreadId: Long? = null,
        val phoneNumber: String,
        val firstName: String,
        val lastName: String? = null,
        val vcard: String? = null,
        val disableNotification: Boolean? = null,
        val protectContent: Boolean? = null,
        val messageEffectId: String? = null,
        val replyParameters: ReplyParameters? = null,
        val replyMarkup: KeyboardOption? = null,
    ) : TelegramRequest()

    data class SendPollRequest(
        val businessConnectionId: String? = null,
        val chatId: String,
        val messageThreadId: Long? = null,
        val question: String,
        val questionParseMode: String? = null,
        val questionEntities: List<MessageEntity>? = null,
        val options: List<InputPollOption>,
        val isAnonymous: Boolean? = null,
        val type: String? = null,
        val allowsMultipleAnswers: Boolean? = null,
        val correctOptionId: Long? = null,
        val explanation: String? = null,
        val explanationParseMode: String? = null,
        val explanationEntities: List<MessageEntity>? = null,
        val openPeriod: Long? = null,
        val closeDate: Long? = null,
        val isClosed: Boolean? = null,
        val disableNotification: Boolean? = null,
        val protectContent: Boolean? = null,
        val messageEffectId: String? = null,
        val replyParameters: ReplyParameters? = null,
        val replyMarkup: KeyboardOption? = null,
    ) : TelegramRequest()

    data class SendDiceRequest(
        val businessConnectionId: String? = null,
        val chatId: String,
        val messageThreadId: Long? = null,
        val emoji: String? = null,
        val disableNotification: Boolean? = null,
        val protectContent: Boolean? = null,
        val messageEffectId: String? = null,
        val replyParameters: ReplyParameters? = null,
        val replyMarkup: KeyboardOption? = null,
    ) : TelegramRequest()

    data class SendChatActionRequest(
        val businessConnectionId: String? = null,
        val chatId: String,
        val messageThreadId: Long? = null,
        val action: String,
    ) : TelegramRequest()

    data class SetMessageReactionRequest(
        val chatId: String,
        val messageId: Long,
        val reaction: List<ReactionType>? = null,
        val isBig: Boolean? = null,
    ) : TelegramRequest()

    data class GetUserProfilePhotosRequest(
        val userId: Long,
        val offset: Long? = null,
        val limit: Long? = null,
    ) : TelegramRequest()

    data class GetFileRequest(
        val fileId: String,
    ) : TelegramRequest()

    data class BanChatMemberRequest(
        val chatId: String,
        val userId: Long,
        val untilDate: Long? = null,
        val revokeMessages: Boolean? = null,
    ) : TelegramRequest()

    data class UnbanChatMemberRequest(
        val chatId: String,
        val userId: Long,
        val onlyIfBanned: Boolean? = null,
    ) : TelegramRequest()

    data class RestrictChatMemberRequest(
        val chatId: String,
        val userId: Long,
        val permissions: ChatPermissions,
        val useIndependentChatPermissions: Boolean? = null,
        val untilDate: Long? = null,
    ) : TelegramRequest()

    data class PromoteChatMemberRequest(
        val chatId: String,
        val userId: Long,
        val isAnonymous: Boolean? = null,
        val canManageChat: Boolean? = null,
        val canDeleteMessages: Boolean? = null,
        val canManageVideoChats: Boolean? = null,
        val canRestrictMembers: Boolean? = null,
        val canPromoteMembers: Boolean? = null,
        val canChangeInfo: Boolean? = null,
        val canInviteUsers: Boolean? = null,
        val canPostStories: Boolean? = null,
        val canEditStories: Boolean? = null,
        val canDeleteStories: Boolean? = null,
        val canPostMessages: Boolean? = null,
        val canEditMessages: Boolean? = null,
        val canPinMessages: Boolean? = null,
        val canManageTopics: Boolean? = null,
    ) : TelegramRequest()

    data class SetChatAdministratorCustomTitleRequest(
        val chatId: String,
        val userId: Long,
        val customTitle: String,
    ) : TelegramRequest()

    data class BanChatSenderChatRequest(
        val chatId: String,
        val senderChatId: Long,
    ) : TelegramRequest()

    data class UnbanChatSenderChatRequest(
        val chatId: String,
        val senderChatId: Long,
    ) : TelegramRequest()

    data class SetChatPermissionsRequest(
        val chatId: String,
        val permissions: ChatPermissions,
        val useIndependentChatPermissions: Boolean? = null,
    ) : TelegramRequest()

    data class ExportChatInviteLinkRequest(
        val chatId: String,
    ) : TelegramRequest()

    data class CreateChatInviteLinkRequest(
        val chatId: String,
        val name: String? = null,
        val expireDate: Long? = null,
        val memberLimit: Long? = null,
        val createsJoinRequest: Boolean? = null,
    ) : TelegramRequest()

    data class EditChatInviteLinkRequest(
        val chatId: String,
        val inviteLink: String,
        val name: String? = null,
        val expireDate: Long? = null,
        val memberLimit: Long? = null,
        val createsJoinRequest: Boolean? = null,
    ) : TelegramRequest()

    data class RevokeChatInviteLinkRequest(
        val chatId: String,
        val inviteLink: String,
    ) : TelegramRequest()

    data class ApproveChatJoinRequestRequest(
        val chatId: String,
        val userId: Long,
    ) : TelegramRequest()

    data class DeclineChatJoinRequestRequest(
        val chatId: String,
        val userId: Long,
    ) : TelegramRequest()

    data class SetChatPhotoRequest(
        val chatId: String,
        val photo: Any,
    ) : TelegramRequest()

    data class DeleteChatPhotoRequest(
        val chatId: String,
    ) : TelegramRequest()

    data class SetChatTitleRequest(
        val chatId: String,
        val title: String,
    ) : TelegramRequest()

    data class SetChatDescriptionRequest(
        val chatId: String,
        val description: String? = null,
    ) : TelegramRequest()

    data class PinChatMessageRequest(
        val chatId: String,
        val messageId: Long,
        val disableNotification: Boolean? = null,
    ) : TelegramRequest()

    data class UnpinChatMessageRequest(
        val chatId: String,
        val messageId: Long? = null,
    ) : TelegramRequest()

    data class UnpinAllChatMessagesRequest(
        val chatId: String,
    ) : TelegramRequest()

    data class LeaveChatRequest(
        val chatId: String,
    ) : TelegramRequest()

    data class GetChatRequest(
        val chatId: String,
    ) : TelegramRequest()

    data class GetChatAdministratorsRequest(
        val chatId: String,
    ) : TelegramRequest()

    data class GetChatMemberCountRequest(
        val chatId: String,
    ) : TelegramRequest()

    data class GetChatMemberRequest(
        val chatId: String,
        val userId: Long,
    ) : TelegramRequest()

    data class SetChatStickerSetRequest(
        val chatId: String,
        val stickerSetName: String,
    ) : TelegramRequest()

    data class DeleteChatStickerSetRequest(
        val chatId: String,
    ) : TelegramRequest()

    data class CreateForumTopicRequest(
        val chatId: String,
        val name: String,
        val iconColor: Long? = null,
        val iconCustomEmojiId: String? = null,
    ) : TelegramRequest()

    data class EditForumTopicRequest(
        val chatId: String,
        val messageThreadId: Long,
        val name: String? = null,
        val iconCustomEmojiId: String? = null,
    ) : TelegramRequest()

    data class CloseForumTopicRequest(
        val chatId: String,
        val messageThreadId: Long,
    ) : TelegramRequest()

    data class ReopenForumTopicRequest(
        val chatId: String,
        val messageThreadId: Long,
    ) : TelegramRequest()

    data class DeleteForumTopicRequest(
        val chatId: String,
        val messageThreadId: Long,
    ) : TelegramRequest()

    data class UnpinAllForumTopicMessagesRequest(
        val chatId: String,
        val messageThreadId: Long,
    ) : TelegramRequest()

    data class EditGeneralForumTopicRequest(
        val chatId: String,
        val name: String,
    ) : TelegramRequest()

    data class CloseGeneralForumTopicRequest(
        val chatId: String,
    ) : TelegramRequest()

    data class ReopenGeneralForumTopicRequest(
        val chatId: String,
    ) : TelegramRequest()

    data class HideGeneralForumTopicRequest(
        val chatId: String,
    ) : TelegramRequest()

    data class UnhideGeneralForumTopicRequest(
        val chatId: String,
    ) : TelegramRequest()

    data class UnpinAllGeneralForumTopicMessagesRequest(
        val chatId: String,
    ) : TelegramRequest()

    data class AnswerCallbackQueryRequest(
        val callbackQueryId: String,
        val text: String? = null,
        val showAlert: Boolean? = null,
        val url: String? = null,
        val cacheTime: Long? = null,
    ) : TelegramRequest()

    data class GetUserChatBoostsRequest(
        val chatId: String,
        val userId: Long,
    ) : TelegramRequest()

    data class GetBusinessConnectionRequest(
        val businessConnectionId: String,
    ) : TelegramRequest()

    data class SetMyCommandsRequest(
        val commands: List<BotCommand>,
        val scope: BotCommandScope? = null,
        val languageCode: String? = null,
    ) : TelegramRequest()

    data class DeleteMyCommandsRequest(
        val scope: BotCommandScope? = null,
        val languageCode: String? = null,
    ) : TelegramRequest()

    data class GetMyCommandsRequest(
        val scope: BotCommandScope? = null,
        val languageCode: String? = null,
    ) : TelegramRequest()

    data class SetMyNameRequest(
        val name: String? = null,
        val languageCode: String? = null,
    ) : TelegramRequest()

    data class GetMyNameRequest(
        val languageCode: String? = null,
    ) : TelegramRequest()

    data class SetMyDescriptionRequest(
        val description: String? = null,
        val languageCode: String? = null,
    ) : TelegramRequest()

    data class GetMyDescriptionRequest(
        val languageCode: String? = null,
    ) : TelegramRequest()

    data class SetMyShortDescriptionRequest(
        val shortDescription: String? = null,
        val languageCode: String? = null,
    ) : TelegramRequest()

    data class GetMyShortDescriptionRequest(
        val languageCode: String? = null,
    ) : TelegramRequest()

    data class SetChatMenuButtonRequest(
        val chatId: Long? = null,
        val menuButton: MenuButton? = null,
    ) : TelegramRequest()

    data class GetChatMenuButtonRequest(
        val chatId: Long? = null,
    ) : TelegramRequest()

    data class SetMyDefaultAdministratorRightsRequest(
        val rights: ChatAdministratorRights? = null,
        val forChannels: Boolean? = null,
    ) : TelegramRequest()

    data class GetMyDefaultAdministratorRightsRequest(
        val forChannels: Boolean? = null,
    ) : TelegramRequest()

    data class EditMessageTextRequest(
        val chatId: String? = null,
        val messageId: Long? = null,
        val inlineMessageId: String? = null,
        val text: String,
        val parseMode: ParseMode? = null,
        val entities: List<MessageEntity>? = null,
        val linkPreviewOptions: LinkPreviewOptions? = null,
        val replyMarkup: InlineKeyboardMarkup? = null,
    ) : TelegramRequest()

    data class EditMessageCaptionRequest(
        val chatId: String? = null,
        val messageId: Long? = null,
        val inlineMessageId: String? = null,
        val caption: String? = null,
        val parseMode: ParseMode? = null,
        val captionEntities: List<MessageEntity>? = null,
        val showCaptionAboveMedia: Boolean? = null,
        val replyMarkup: InlineKeyboardMarkup? = null,
    ) : TelegramRequest()

    data class EditMessageMediaRequest(
        val chatId: String? = null,
        val messageId: Long? = null,
        val inlineMessageId: String? = null,
        val media: InputMedia,
        val replyMarkup: InlineKeyboardMarkup? = null,
    ) : TelegramRequest()

    data class EditMessageLiveLocationRequest(
        val chatId: String? = null,
        val messageId: Long? = null,
        val inlineMessageId: String? = null,
        val latitude: Float,
        val longitude: Float,
        val livePeriod: Long? = null,
        val horizontalAccuracy: Float? = null,
        val heading: Long? = null,
        val proximityAlertRadius: Long? = null,
        val replyMarkup: InlineKeyboardMarkup? = null,
    ) : TelegramRequest()

    data class StopMessageLiveLocationRequest(
        val chatId: String? = null,
        val messageId: Long? = null,
        val inlineMessageId: String? = null,
        val replyMarkup: InlineKeyboardMarkup? = null,
    ) : TelegramRequest()

    data class EditMessageReplyMarkupRequest(
        val chatId: String? = null,
        val messageId: Long? = null,
        val inlineMessageId: String? = null,
        val replyMarkup: InlineKeyboardMarkup? = null,
    ) : TelegramRequest()

    data class StopPollRequest(
        val chatId: String,
        val messageId: Long,
        val replyMarkup: InlineKeyboardMarkup? = null,
    ) : TelegramRequest()

    data class DeleteMessageRequest(
        val chatId: String,
        val messageId: Long,
    ) : TelegramRequest()

    data class DeleteMessagesRequest(
        val chatId: String,
        val messageIds: List<Long>,
    ) : TelegramRequest()

    data class SendStickerRequest(
        val businessConnectionId: String? = null,
        val chatId: String,
        val messageThreadId: Long? = null,
        val sticker: String,
        val emoji: String? = null,
        val disableNotification: Boolean? = null,
        val protectContent: Boolean? = null,
        val messageEffectId: String? = null,
        val replyParameters: ReplyParameters? = null,
        val replyMarkup: KeyboardOption? = null,
    ) : TelegramRequest()

    data class GetStickerSetRequest(
        val name: String,
    ) : TelegramRequest()

    data class GetCustomEmojiStickersRequest(
        val customEmojiIds: List<String>,
    ) : TelegramRequest()

    data class UploadStickerFileRequest(
        val userId: Long,
        val sticker: Any,
        val stickerFormat: String,
    ) : TelegramRequest()

    data class CreateNewStickerSetRequest(
        val userId: Long,
        val name: String,
        val title: String,
        val stickers: List<InputSticker>,
        val stickerType: String? = null,
        val needsRepainting: Boolean? = null,
    ) : TelegramRequest()

    data class AddStickerToSetRequest(
        val userId: Long,
        val name: String,
        val sticker: InputSticker,
    ) : TelegramRequest()

    data class SetStickerPositionInSetRequest(
        val sticker: String,
        val position: Long,
    ) : TelegramRequest()

    data class DeleteStickerFromSetRequest(
        val sticker: String,
    ) : TelegramRequest()

    data class ReplaceStickerInSetRequest(
        val userId: Long,
        val name: String,
        val oldSticker: String,
        val sticker: InputSticker,
    ) : TelegramRequest()

    data class SetStickerEmojiListRequest(
        val sticker: String,
        val emojiList: List<String>,
    ) : TelegramRequest()

    data class SetStickerKeywordsRequest(
        val sticker: String,
        val keywords: List<String>? = null,
    ) : TelegramRequest()

    data class SetStickerMaskPositionRequest(
        val sticker: String,
        val maskPosition: MaskPosition? = null,
    ) : TelegramRequest()

    data class SetStickerSetTitleRequest(
        val name: String,
        val title: String,
    ) : TelegramRequest()

    data class SetStickerSetThumbnailRequest(
        val name: String,
        val userId: Long,
        val thumbnail: String? = null,
        val format: String,
    ) : TelegramRequest()

    data class SetCustomEmojiStickerSetThumbnailRequest(
        val name: String,
        val customEmojiId: String? = null,
    ) : TelegramRequest()

    data class DeleteStickerSetRequest(
        val name: String,
    ) : TelegramRequest()

    data class AnswerInlineQueryRequest(
        val inlineQueryId: String,
        val results: List<InlineQueryResult>,
        val cacheTime: Long? = null,
        val isPersonal: Boolean? = null,
        val nextOffset: String? = null,
        val button: InlineQueryResultsButton? = null,
    ) : TelegramRequest()

    data class AnswerWebAppQueryRequest(
        val webAppQueryId: String,
        val result: InlineQueryResult,
    ) : TelegramRequest()

    data class SendInvoiceRequest(
        val chatId: String,
        val messageThreadId: Long? = null,
        val title: String,
        val description: String,
        val payload: String,
        val providerToken: String? = null,
        val currency: String,
        val prices: List<LabeledPrice>,
        val maxTipAmount: Long? = null,
        val suggestedTipAmounts: List<Long>? = null,
        val startParameter: String? = null,
        val providerData: String? = null,
        val photoUrl: String? = null,
        val photoSize: Long? = null,
        val photoWidth: Long? = null,
        val photoHeight: Long? = null,
        val needName: Boolean? = null,
        val needPhoneNumber: Boolean? = null,
        val needEmail: Boolean? = null,
        val needShippingAddress: Boolean? = null,
        val sendPhoneNumberToProvider: Boolean? = null,
        val sendEmailToProvider: Boolean? = null,
        val isFlexible: Boolean? = null,
        val disableNotification: Boolean? = null,
        val protectContent: Boolean? = null,
        val messageEffectId: String? = null,
        val replyParameters: ReplyParameters? = null,
        val replyMarkup: InlineKeyboardMarkup? = null,
    ) : TelegramRequest()

    data class CreateInvoiceLinkRequest(
        val title: String,
        val description: String,
        val payload: String,
        val providerToken: String? = null,
        val currency: String,
        val prices: List<LabeledPrice>,
        val maxTipAmount: Long? = null,
        val suggestedTipAmounts: List<Long>? = null,
        val providerData: String? = null,
        val photoUrl: String? = null,
        val photoSize: Long? = null,
        val photoWidth: Long? = null,
        val photoHeight: Long? = null,
        val needName: Boolean? = null,
        val needPhoneNumber: Boolean? = null,
        val needEmail: Boolean? = null,
        val needShippingAddress: Boolean? = null,
        val sendPhoneNumberToProvider: Boolean? = null,
        val sendEmailToProvider: Boolean? = null,
        val isFlexible: Boolean? = null,
    ) : TelegramRequest()

    data class AnswerShippingQueryRequest(
        val shippingQueryId: String,
        val ok: Boolean,
        val shippingOptions: List<ShippingOption>? = null,
        val errorMessage: String? = null,
    ) : TelegramRequest()

    data class AnswerPreCheckoutQueryRequest(
        val preCheckoutQueryId: String,
        val ok: Boolean,
        val errorMessage: String? = null,
    ) : TelegramRequest()

    data class RefundStarPaymentRequest(
        val userId: Long,
        val telegramPaymentChargeId: String,
    ) : TelegramRequest()

    data class SetPassportDataErrorsRequest(
        val userId: Long,
        val errors: List<PassportElementError>,
    ) : TelegramRequest()

    data class SendGameRequest(
        val businessConnectionId: String? = null,
        val chatId: Long,
        val messageThreadId: Long? = null,
        val gameShortName: String,
        val disableNotification: Boolean? = null,
        val protectContent: Boolean? = null,
        val messageEffectId: String? = null,
        val replyParameters: ReplyParameters? = null,
        val replyMarkup: InlineKeyboardMarkup? = null,
    ) : TelegramRequest()

    data class SetGameScoreRequest(
        val userId: Long,
        val score: Long,
        val force: Boolean? = null,
        val disableEditMessage: Boolean? = null,
        val chatId: Long? = null,
        val messageId: Long? = null,
        val inlineMessageId: String? = null,
    ) : TelegramRequest()

    data class GetGameHighScoresRequest(
        val userId: Long,
        val chatId: Long? = null,
        val messageId: Long? = null,
        val inlineMessageId: String? = null,
    ) : TelegramRequest()
}
