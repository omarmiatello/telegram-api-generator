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
sealed class PaidMedia : TelegramModel()
sealed class StoryAreaType : TelegramModel()
sealed class OwnedGift : TelegramModel()
sealed class RevenueWithdrawalState : TelegramModel()
sealed class TransactionPartner : TelegramModel()
sealed class InputPaidMedia : TelegramModel()
sealed class InputProfilePhoto : TelegramModel()
sealed class InputStoryContent : TelegramModel()
sealed class InputFileOrString : TelegramModel()
sealed class IntegerOrString : TelegramModel()
data class TelegramResponse<T>(
    val ok: Boolean,
    val result: T? = null,
    val errorCode: Int? = null,
    val description: String? = null,
)

// --- Utility ---

enum class ParseMode { MarkdownV2, Markdown, HTML }


// Getting updates

/**
 * <p>This <a href="#available-types">object</a> represents an incoming update.<br>At most <strong>one</strong> of the optional parameters can be present in any given update.</p>
 *
 * @property updateId The update's unique identifier. Update identifiers start from a certain positive number and increase sequentially. This identifier becomes especially handy if you're using <a href="#setwebhook">webhooks</a>, since it allows you to ignore repeated updates or to restore the correct update sequence, should they get out of order. If there are no new updates for at least a week, then identifier of the next update will be chosen randomly instead of sequentially.
 * @property message <em>Optional</em>. New incoming message of any kind - text, photo, sticker, etc.
 * @property editedMessage <em>Optional</em>. New version of a message that is known to the bot and was edited. This update may at times be triggered by changes to message fields that are either unavailable or not actively used by your bot.
 * @property channelPost <em>Optional</em>. New incoming channel post of any kind - text, photo, sticker, etc.
 * @property editedChannelPost <em>Optional</em>. New version of a channel post that is known to the bot and was edited. This update may at times be triggered by changes to message fields that are either unavailable or not actively used by your bot.
 * @property businessConnection <em>Optional</em>. The bot was connected to or disconnected from a business account, or a user edited an existing connection with the bot
 * @property businessMessage <em>Optional</em>. New message from a connected business account
 * @property editedBusinessMessage <em>Optional</em>. New version of a message from a connected business account
 * @property deletedBusinessMessages <em>Optional</em>. Messages were deleted from a connected business account
 * @property messageReaction <em>Optional</em>. A reaction to a message was changed by a user. The bot must be an administrator in the chat and must explicitly specify <code>"message_reaction"</code> in the list of <em>allowed_updates</em> to receive these updates. The update isn't received for reactions set by bots.
 * @property messageReactionCount <em>Optional</em>. Reactions to a message with anonymous reactions were changed. The bot must be an administrator in the chat and must explicitly specify <code>"message_reaction_count"</code> in the list of <em>allowed_updates</em> to receive these updates. The updates are grouped and can be sent with delay up to a few minutes.
 * @property inlineQuery <em>Optional</em>. New incoming <a href="#inline-mode">inline</a> query
 * @property chosenInlineResult <em>Optional</em>. The result of an <a href="#inline-mode">inline</a> query that was chosen by a user and sent to their chat partner. Please see our documentation on the <a href="/bots/inline#collecting-feedback">feedback collecting</a> for details on how to enable these updates for your bot.
 * @property callbackQuery <em>Optional</em>. New incoming callback query
 * @property shippingQuery <em>Optional</em>. New incoming shipping query. Only for invoices with flexible price
 * @property preCheckoutQuery <em>Optional</em>. New incoming pre-checkout query. Contains full information about checkout
 * @property purchasedPaidMedia <em>Optional</em>. A user purchased paid media with a non-empty payload sent by the bot in a non-channel chat
 * @property poll <em>Optional</em>. New poll state. Bots receive only updates about manually stopped polls and polls, which are sent by the bot
 * @property pollAnswer <em>Optional</em>. A user changed their answer in a non-anonymous poll. Bots receive new votes only in polls that were sent by the bot itself.
 * @property myChatMember <em>Optional</em>. The bot's chat member status was updated in a chat. For private chats, this update is received only when the bot is blocked or unblocked by the user.
 * @property chatMember <em>Optional</em>. A chat member's status was updated in a chat. The bot must be an administrator in the chat and must explicitly specify <code>"chat_member"</code> in the list of <em>allowed_updates</em> to receive these updates.
 * @property chatJoinRequest <em>Optional</em>. A request to join the chat has been sent. The bot must have the <em>can_invite_users</em> administrator right in the chat to receive these updates.
 * @property chatBoost <em>Optional</em>. A chat boost was added or changed. The bot must be an administrator in the chat to receive these updates.
 * @property removedChatBoost <em>Optional</em>. A boost was removed from a chat. The bot must be an administrator in the chat to receive these updates.
 *
 * @constructor Creates a [Update].
 * */
data class Update(
    val updateId: Long,
    val message: Message? = null,
    val editedMessage: Message? = null,
    val channelPost: Message? = null,
    val editedChannelPost: Message? = null,
    val businessConnection: BusinessConnection? = null,
    val businessMessage: Message? = null,
    val editedBusinessMessage: Message? = null,
    val deletedBusinessMessages: BusinessMessagesDeleted? = null,
    val messageReaction: MessageReactionUpdated? = null,
    val messageReactionCount: MessageReactionCountUpdated? = null,
    val inlineQuery: InlineQuery? = null,
    val chosenInlineResult: ChosenInlineResult? = null,
    val callbackQuery: CallbackQuery? = null,
    val shippingQuery: ShippingQuery? = null,
    val preCheckoutQuery: PreCheckoutQuery? = null,
    val purchasedPaidMedia: PaidMediaPurchased? = null,
    val poll: Poll? = null,
    val pollAnswer: PollAnswer? = null,
    val myChatMember: ChatMemberUpdated? = null,
    val chatMember: ChatMemberUpdated? = null,
    val chatJoinRequest: ChatJoinRequest? = null,
    val chatBoost: ChatBoostUpdated? = null,
    val removedChatBoost: ChatBoostRemoved? = null,
) : TelegramModel()

/**
 * <p>Describes the current status of a webhook.</p>
 *
 * @property url Webhook URL, may be empty if webhook is not set up
 * @property hasCustomCertificate <em>True</em>, if a custom certificate was provided for webhook certificate checks
 * @property pendingUpdateCount Number of updates awaiting delivery
 * @property ipAddress <em>Optional</em>. Currently used webhook IP address
 * @property lastErrorDate <em>Optional</em>. Unix time for the most recent error that happened when trying to deliver an update via webhook
 * @property lastErrorMessage <em>Optional</em>. Error message in human-readable format for the most recent error that happened when trying to deliver an update via webhook
 * @property lastSynchronizationErrorDate <em>Optional</em>. Unix time of the most recent error that happened when trying to synchronize available updates with Telegram datacenters
 * @property maxConnections <em>Optional</em>. The maximum allowed number of simultaneous HTTPS connections to the webhook for update delivery
 * @property allowedUpdates <em>Optional</em>. A list of update types the bot is subscribed to. Defaults to all update types except <em>chat_member</em>
 *
 * @constructor Creates a [WebhookInfo].
 * */
data class WebhookInfo(
    val url: String,
    val hasCustomCertificate: Boolean,
    val pendingUpdateCount: Long,
    val ipAddress: String? = null,
    val lastErrorDate: Long? = null,
    val lastErrorMessage: String? = null,
    val lastSynchronizationErrorDate: Long? = null,
    val maxConnections: Long? = null,
    val allowedUpdates: List<String>? = null,
) : TelegramModel()

// Available types

/**
 * <p>This object represents a Telegram user or bot.</p>
 *
 * @property id Unique identifier for this user or bot. This number may have more than 32 significant bits and some programming languages may have difficulty/silent defects in interpreting it. But it has at most 52 significant bits, so a 64-bit integer or double-precision float type are safe for storing this identifier.
 * @property isBot <em>True</em>, if this user is a bot
 * @property firstName User's or bot's first name
 * @property lastName <em>Optional</em>. User's or bot's last name
 * @property username <em>Optional</em>. User's or bot's username
 * @property languageCode <em>Optional</em>. <a href="https://en.wikipedia.org/wiki/IETF_language_tag">IETF language tag</a> of the user's language
 * @property isPremium <em>Optional</em>. <em>True</em>, if this user is a Telegram Premium user
 * @property addedToAttachmentMenu <em>Optional</em>. <em>True</em>, if this user added the bot to the attachment menu
 * @property canJoinGroups <em>Optional</em>. <em>True</em>, if the bot can be invited to groups. Returned only in <a href="#getme">getMe</a>.
 * @property canReadAllGroupMessages <em>Optional</em>. <em>True</em>, if <a href="/bots/features#privacy-mode">privacy mode</a> is disabled for the bot. Returned only in <a href="#getme">getMe</a>.
 * @property supportsInlineQueries <em>Optional</em>. <em>True</em>, if the bot supports inline queries. Returned only in <a href="#getme">getMe</a>.
 * @property canConnectToBusiness <em>Optional</em>. <em>True</em>, if the bot can be connected to a Telegram Business account to receive its messages. Returned only in <a href="#getme">getMe</a>.
 * @property hasMainWebApp <em>Optional</em>. <em>True</em>, if the bot has a main Web App. Returned only in <a href="#getme">getMe</a>.
 *
 * @constructor Creates a [User].
 * */
data class User(
    val id: Long,
    val isBot: Boolean,
    val firstName: String,
    val lastName: String? = null,
    val username: String? = null,
    val languageCode: String? = null,
    val isPremium: Boolean? = null,
    val addedToAttachmentMenu: Boolean? = null,
    val canJoinGroups: Boolean? = null,
    val canReadAllGroupMessages: Boolean? = null,
    val supportsInlineQueries: Boolean? = null,
    val canConnectToBusiness: Boolean? = null,
    val hasMainWebApp: Boolean? = null,
) : TelegramModel()

/**
 * <p>This object represents a chat.</p>
 *
 * @property id Unique identifier for this chat. This number may have more than 32 significant bits and some programming languages may have difficulty/silent defects in interpreting it. But it has at most 52 significant bits, so a signed 64-bit integer or double-precision float type are safe for storing this identifier.
 * @property type Type of the chat, can be either “private”, “group”, “supergroup” or “channel”
 * @property title <em>Optional</em>. Title, for supergroups, channels and group chats
 * @property username <em>Optional</em>. Username, for private chats, supergroups and channels if available
 * @property firstName <em>Optional</em>. First name of the other party in a private chat
 * @property lastName <em>Optional</em>. Last name of the other party in a private chat
 * @property isForum <em>Optional</em>. <em>True</em>, if the supergroup chat is a forum (has <a href="https://telegram.org/blog/topics-in-groups-collectible-usernames#topics-in-groups">topics</a> enabled)
 *
 * @constructor Creates a [Chat].
 * */
data class Chat(
    val id: Long,
    val type: String,
    val title: String? = null,
    val username: String? = null,
    val firstName: String? = null,
    val lastName: String? = null,
    val isForum: Boolean? = null,
) : TelegramModel()

/**
 * <p>This object contains full information about a chat.</p>
 *
 * @property id Unique identifier for this chat. This number may have more than 32 significant bits and some programming languages may have difficulty/silent defects in interpreting it. But it has at most 52 significant bits, so a signed 64-bit integer or double-precision float type are safe for storing this identifier.
 * @property type Type of the chat, can be either “private”, “group”, “supergroup” or “channel”
 * @property title <em>Optional</em>. Title, for supergroups, channels and group chats
 * @property username <em>Optional</em>. Username, for private chats, supergroups and channels if available
 * @property firstName <em>Optional</em>. First name of the other party in a private chat
 * @property lastName <em>Optional</em>. Last name of the other party in a private chat
 * @property isForum <em>Optional</em>. <em>True</em>, if the supergroup chat is a forum (has <a href="https://telegram.org/blog/topics-in-groups-collectible-usernames#topics-in-groups">topics</a> enabled)
 * @property accentColorId Identifier of the accent color for the chat name and backgrounds of the chat photo, reply header, and link preview. See <a href="#accent-colors">accent colors</a> for more details.
 * @property maxReactionCount The maximum number of reactions that can be set on a message in the chat
 * @property photo <em>Optional</em>. Chat photo
 * @property activeUsernames <em>Optional</em>. If non-empty, the list of all <a href="https://telegram.org/blog/topics-in-groups-collectible-usernames#collectible-usernames">active chat usernames</a>; for private chats, supergroups and channels
 * @property birthdate <em>Optional</em>. For private chats, the date of birth of the user
 * @property businessIntro <em>Optional</em>. For private chats with business accounts, the intro of the business
 * @property businessLocation <em>Optional</em>. For private chats with business accounts, the location of the business
 * @property businessOpeningHours <em>Optional</em>. For private chats with business accounts, the opening hours of the business
 * @property personalChat <em>Optional</em>. For private chats, the personal channel of the user
 * @property availableReactions <em>Optional</em>. List of available reactions allowed in the chat. If omitted, then all <a href="#reactiontypeemoji">emoji reactions</a> are allowed.
 * @property backgroundCustomEmojiId <em>Optional</em>. Custom emoji identifier of the emoji chosen by the chat for the reply header and link preview background
 * @property profileAccentColorId <em>Optional</em>. Identifier of the accent color for the chat's profile background. See <a href="#profile-accent-colors">profile accent colors</a> for more details.
 * @property profileBackgroundCustomEmojiId <em>Optional</em>. Custom emoji identifier of the emoji chosen by the chat for its profile background
 * @property emojiStatusCustomEmojiId <em>Optional</em>. Custom emoji identifier of the emoji status of the chat or the other party in a private chat
 * @property emojiStatusExpirationDate <em>Optional</em>. Expiration date of the emoji status of the chat or the other party in a private chat, in Unix time, if any
 * @property bio <em>Optional</em>. Bio of the other party in a private chat
 * @property hasPrivateForwards <em>Optional</em>. <em>True</em>, if privacy settings of the other party in the private chat allows to use <code>tg://user?id=&lt;user_id&gt;</code> links only in chats with the user
 * @property hasRestrictedVoiceAndVideoMessages <em>Optional</em>. <em>True</em>, if the privacy settings of the other party restrict sending voice and video note messages in the private chat
 * @property joinToSendMessages <em>Optional</em>. <em>True</em>, if users need to join the supergroup before they can send messages
 * @property joinByRequest <em>Optional</em>. <em>True</em>, if all users directly joining the supergroup without using an invite link need to be approved by supergroup administrators
 * @property description <em>Optional</em>. Description, for groups, supergroups and channel chats
 * @property inviteLink <em>Optional</em>. Primary invite link, for groups, supergroups and channel chats
 * @property pinnedMessage <em>Optional</em>. The most recent pinned message (by sending date)
 * @property permissions <em>Optional</em>. Default chat member permissions, for groups and supergroups
 * @property acceptedGiftTypes Information about types of gifts that are accepted by the chat or by the corresponding user for private chats
 * @property canSendPaidMedia <em>Optional</em>. <em>True</em>, if paid media messages can be sent or forwarded to the channel chat. The field is available only for channel chats.
 * @property slowModeDelay <em>Optional</em>. For supergroups, the minimum allowed delay between consecutive messages sent by each unprivileged user; in seconds
 * @property unrestrictBoostCount <em>Optional</em>. For supergroups, the minimum number of boosts that a non-administrator user needs to add in order to ignore slow mode and chat permissions
 * @property messageAutoDeleteTime <em>Optional</em>. The time after which all messages sent to the chat will be automatically deleted; in seconds
 * @property hasAggressiveAntiSpamEnabled <em>Optional</em>. <em>True</em>, if aggressive anti-spam checks are enabled in the supergroup. The field is only available to chat administrators.
 * @property hasHiddenMembers <em>Optional</em>. <em>True</em>, if non-administrators can only get the list of bots and administrators in the chat
 * @property hasProtectedContent <em>Optional</em>. <em>True</em>, if messages from the chat can't be forwarded to other chats
 * @property hasVisibleHistory <em>Optional</em>. <em>True</em>, if new chat members will have access to old messages; available only to chat administrators
 * @property stickerSetName <em>Optional</em>. For supergroups, name of the group sticker set
 * @property canSetStickerSet <em>Optional</em>. <em>True</em>, if the bot can change the group sticker set
 * @property customEmojiStickerSetName <em>Optional</em>. For supergroups, the name of the group's custom emoji sticker set. Custom emoji from this set can be used by all users and bots in the group.
 * @property linkedChatId <em>Optional</em>. Unique identifier for the linked chat, i.e. the discussion group identifier for a channel and vice versa; for supergroups and channel chats. This identifier may be greater than 32 bits and some programming languages may have difficulty/silent defects in interpreting it. But it is smaller than 52 bits, so a signed 64 bit integer or double-precision float type are safe for storing this identifier.
 * @property location <em>Optional</em>. For supergroups, the location to which the supergroup is connected
 *
 * @constructor Creates a [ChatFullInfo].
 * */
data class ChatFullInfo(
    val id: Long,
    val type: String,
    val title: String? = null,
    val username: String? = null,
    val firstName: String? = null,
    val lastName: String? = null,
    val isForum: Boolean? = null,
    val accentColorId: Long,
    val maxReactionCount: Long,
    val photo: ChatPhoto? = null,
    val activeUsernames: List<String>? = null,
    val birthdate: Birthdate? = null,
    val businessIntro: BusinessIntro? = null,
    val businessLocation: BusinessLocation? = null,
    val businessOpeningHours: BusinessOpeningHours? = null,
    val personalChat: Chat? = null,
    val availableReactions: List<ReactionType>? = null,
    val backgroundCustomEmojiId: String? = null,
    val profileAccentColorId: Long? = null,
    val profileBackgroundCustomEmojiId: String? = null,
    val emojiStatusCustomEmojiId: String? = null,
    val emojiStatusExpirationDate: Long? = null,
    val bio: String? = null,
    val hasPrivateForwards: Boolean? = null,
    val hasRestrictedVoiceAndVideoMessages: Boolean? = null,
    val joinToSendMessages: Boolean? = null,
    val joinByRequest: Boolean? = null,
    val description: String? = null,
    val inviteLink: String? = null,
    val pinnedMessage: Message? = null,
    val permissions: ChatPermissions? = null,
    val acceptedGiftTypes: AcceptedGiftTypes,
    val canSendPaidMedia: Boolean? = null,
    val slowModeDelay: Long? = null,
    val unrestrictBoostCount: Long? = null,
    val messageAutoDeleteTime: Long? = null,
    val hasAggressiveAntiSpamEnabled: Boolean? = null,
    val hasHiddenMembers: Boolean? = null,
    val hasProtectedContent: Boolean? = null,
    val hasVisibleHistory: Boolean? = null,
    val stickerSetName: String? = null,
    val canSetStickerSet: Boolean? = null,
    val customEmojiStickerSetName: String? = null,
    val linkedChatId: Long? = null,
    val location: ChatLocation? = null,
) : TelegramModel()

/**
 * <p>This object represents a message.</p>
 *
 * @property messageId Unique message identifier inside this chat. In specific instances (e.g., message containing a video sent to a big chat), the server might automatically schedule a message instead of sending it immediately. In such cases, this field will be 0 and the relevant message will be unusable until it is actually sent
 * @property messageThreadId <em>Optional</em>. Unique identifier of a message thread to which the message belongs; for supergroups only
 * @property from <em>Optional</em>. Sender of the message; may be empty for messages sent to channels. For backward compatibility, if the message was sent on behalf of a chat, the field contains a fake sender user in non-channel chats
 * @property senderChat <em>Optional</em>. Sender of the message when sent on behalf of a chat. For example, the supergroup itself for messages sent by its anonymous administrators or a linked channel for messages automatically forwarded to the channel's discussion group. For backward compatibility, if the message was sent on behalf of a chat, the field <em>from</em> contains a fake sender user in non-channel chats.
 * @property senderBoostCount <em>Optional</em>. If the sender of the message boosted the chat, the number of boosts added by the user
 * @property senderBusinessBot <em>Optional</em>. The bot that actually sent the message on behalf of the business account. Available only for outgoing messages sent on behalf of the connected business account.
 * @property date Date the message was sent in Unix time. It is always a positive number, representing a valid date.
 * @property businessConnectionId <em>Optional</em>. Unique identifier of the business connection from which the message was received. If non-empty, the message belongs to a chat of the corresponding business account that is independent from any potential bot chat which might share the same identifier.
 * @property chat Chat the message belongs to
 * @property forwardOrigin <em>Optional</em>. Information about the original message for forwarded messages
 * @property isTopicMessage <em>Optional</em>. <em>True</em>, if the message is sent to a forum topic
 * @property isAutomaticForward <em>Optional</em>. <em>True</em>, if the message is a channel post that was automatically forwarded to the connected discussion group
 * @property replyToMessage <em>Optional</em>. For replies in the same chat and message thread, the original message. Note that the Message object in this field will not contain further <em>reply_to_message</em> fields even if it itself is a reply.
 * @property externalReply <em>Optional</em>. Information about the message that is being replied to, which may come from another chat or forum topic
 * @property quote <em>Optional</em>. For replies that quote part of the original message, the quoted part of the message
 * @property replyToStory <em>Optional</em>. For replies to a story, the original story
 * @property viaBot <em>Optional</em>. Bot through which the message was sent
 * @property editDate <em>Optional</em>. Date the message was last edited in Unix time
 * @property hasProtectedContent <em>Optional</em>. <em>True</em>, if the message can't be forwarded
 * @property isFromOffline <em>Optional</em>. <em>True</em>, if the message was sent by an implicit action, for example, as an away or a greeting business message, or as a scheduled message
 * @property mediaGroupId <em>Optional</em>. The unique identifier of a media message group this message belongs to
 * @property authorSignature <em>Optional</em>. Signature of the post author for messages in channels, or the custom title of an anonymous group administrator
 * @property paidStarCount <em>Optional</em>. The number of Telegram Stars that were paid by the sender of the message to send it
 * @property text <em>Optional</em>. For text messages, the actual UTF-8 text of the message
 * @property entities <em>Optional</em>. For text messages, special entities like usernames, URLs, bot commands, etc. that appear in the text
 * @property linkPreviewOptions <em>Optional</em>. Options used for link preview generation for the message, if it is a text message and link preview options were changed
 * @property effectId <em>Optional</em>. Unique identifier of the message effect added to the message
 * @property animation <em>Optional</em>. Message is an animation, information about the animation. For backward compatibility, when this field is set, the <em>document</em> field will also be set
 * @property audio <em>Optional</em>. Message is an audio file, information about the file
 * @property document <em>Optional</em>. Message is a general file, information about the file
 * @property paidMedia <em>Optional</em>. Message contains paid media; information about the paid media
 * @property photo <em>Optional</em>. Message is a photo, available sizes of the photo
 * @property sticker <em>Optional</em>. Message is a sticker, information about the sticker
 * @property story <em>Optional</em>. Message is a forwarded story
 * @property video <em>Optional</em>. Message is a video, information about the video
 * @property videoNote <em>Optional</em>. Message is a <a href="https://telegram.org/blog/video-messages-and-telescope">video note</a>, information about the video message
 * @property voice <em>Optional</em>. Message is a voice message, information about the file
 * @property caption <em>Optional</em>. Caption for the animation, audio, document, paid media, photo, video or voice
 * @property captionEntities <em>Optional</em>. For messages with a caption, special entities like usernames, URLs, bot commands, etc. that appear in the caption
 * @property showCaptionAboveMedia <em>Optional</em>. <em>True</em>, if the caption must be shown above the message media
 * @property hasMediaSpoiler <em>Optional</em>. <em>True</em>, if the message media is covered by a spoiler animation
 * @property checklist <em>Optional</em>. Message is a checklist
 * @property contact <em>Optional</em>. Message is a shared contact, information about the contact
 * @property dice <em>Optional</em>. Message is a dice with random value
 * @property game <em>Optional</em>. Message is a game, information about the game. <a href="#games">More about games »</a>
 * @property poll <em>Optional</em>. Message is a native poll, information about the poll
 * @property venue <em>Optional</em>. Message is a venue, information about the venue. For backward compatibility, when this field is set, the <em>location</em> field will also be set
 * @property location <em>Optional</em>. Message is a shared location, information about the location
 * @property newChatMembers <em>Optional</em>. New members that were added to the group or supergroup and information about them (the bot itself may be one of these members)
 * @property leftChatMember <em>Optional</em>. A member was removed from the group, information about them (this member may be the bot itself)
 * @property newChatTitle <em>Optional</em>. A chat title was changed to this value
 * @property newChatPhoto <em>Optional</em>. A chat photo was change to this value
 * @property deleteChatPhoto <em>Optional</em>. Service message: the chat photo was deleted
 * @property groupChatCreated <em>Optional</em>. Service message: the group has been created
 * @property supergroupChatCreated <em>Optional</em>. Service message: the supergroup has been created. This field can't be received in a message coming through updates, because bot can't be a member of a supergroup when it is created. It can only be found in reply_to_message if someone replies to a very first message in a directly created supergroup.
 * @property channelChatCreated <em>Optional</em>. Service message: the channel has been created. This field can't be received in a message coming through updates, because bot can't be a member of a channel when it is created. It can only be found in reply_to_message if someone replies to a very first message in a channel.
 * @property messageAutoDeleteTimerChanged <em>Optional</em>. Service message: auto-delete timer settings changed in the chat
 * @property migrateToChatId <em>Optional</em>. The group has been migrated to a supergroup with the specified identifier. This number may have more than 32 significant bits and some programming languages may have difficulty/silent defects in interpreting it. But it has at most 52 significant bits, so a signed 64-bit integer or double-precision float type are safe for storing this identifier.
 * @property migrateFromChatId <em>Optional</em>. The supergroup has been migrated from a group with the specified identifier. This number may have more than 32 significant bits and some programming languages may have difficulty/silent defects in interpreting it. But it has at most 52 significant bits, so a signed 64-bit integer or double-precision float type are safe for storing this identifier.
 * @property pinnedMessage <em>Optional</em>. Specified message was pinned. Note that the Message object in this field will not contain further <em>reply_to_message</em> fields even if it itself is a reply.
 * @property invoice <em>Optional</em>. Message is an invoice for a <a href="#payments">payment</a>, information about the invoice. <a href="#payments">More about payments »</a>
 * @property successfulPayment <em>Optional</em>. Message is a service message about a successful payment, information about the payment. <a href="#payments">More about payments »</a>
 * @property refundedPayment <em>Optional</em>. Message is a service message about a refunded payment, information about the payment. <a href="#payments">More about payments »</a>
 * @property usersShared <em>Optional</em>. Service message: users were shared with the bot
 * @property chatShared <em>Optional</em>. Service message: a chat was shared with the bot
 * @property gift <em>Optional</em>. Service message: a regular gift was sent or received
 * @property uniqueGift <em>Optional</em>. Service message: a unique gift was sent or received
 * @property connectedWebsite <em>Optional</em>. The domain name of the website on which the user has logged in. <a href="/widgets/login">More about Telegram Login »</a>
 * @property writeAccessAllowed <em>Optional</em>. Service message: the user allowed the bot to write messages after adding it to the attachment or side menu, launching a Web App from a link, or accepting an explicit request from a Web App sent by the method <a href="/bots/webapps#initializing-mini-apps">requestWriteAccess</a>
 * @property passportData <em>Optional</em>. Telegram Passport data
 * @property proximityAlertTriggered <em>Optional</em>. Service message. A user in the chat triggered another user's proximity alert while sharing Live Location.
 * @property boostAdded <em>Optional</em>. Service message: user boosted the chat
 * @property chatBackgroundSet <em>Optional</em>. Service message: chat background set
 * @property checklistTasksDone <em>Optional</em>. Service message: some tasks in a checklist were marked as done or not done
 * @property checklistTasksAdded <em>Optional</em>. Service message: tasks were added to a checklist
 * @property directMessagePriceChanged <em>Optional</em>. Service message: the price for paid messages in the corresponding direct messages chat of a channel has changed
 * @property forumTopicCreated <em>Optional</em>. Service message: forum topic created
 * @property forumTopicEdited <em>Optional</em>. Service message: forum topic edited
 * @property forumTopicClosed <em>Optional</em>. Service message: forum topic closed
 * @property forumTopicReopened <em>Optional</em>. Service message: forum topic reopened
 * @property generalForumTopicHidden <em>Optional</em>. Service message: the 'General' forum topic hidden
 * @property generalForumTopicUnhidden <em>Optional</em>. Service message: the 'General' forum topic unhidden
 * @property giveawayCreated <em>Optional</em>. Service message: a scheduled giveaway was created
 * @property giveaway <em>Optional</em>. The message is a scheduled giveaway message
 * @property giveawayWinners <em>Optional</em>. A giveaway with public winners was completed
 * @property giveawayCompleted <em>Optional</em>. Service message: a giveaway without public winners was completed
 * @property paidMessagePriceChanged <em>Optional</em>. Service message: the price for paid messages has changed in the chat
 * @property videoChatScheduled <em>Optional</em>. Service message: video chat scheduled
 * @property videoChatStarted <em>Optional</em>. Service message: video chat started
 * @property videoChatEnded <em>Optional</em>. Service message: video chat ended
 * @property videoChatParticipantsInvited <em>Optional</em>. Service message: new participants invited to a video chat
 * @property webAppData <em>Optional</em>. Service message: data sent by a Web App
 * @property replyMarkup <em>Optional</em>. Inline keyboard attached to the message. <code>login_url</code> buttons are represented as ordinary <code>url</code> buttons.
 *
 * @constructor Creates a [Message].
 * */
data class Message(
    val messageId: Long,
    val messageThreadId: Long? = null,
    val from: User? = null,
    val senderChat: Chat? = null,
    val senderBoostCount: Long? = null,
    val senderBusinessBot: User? = null,
    val date: Long,
    val businessConnectionId: String? = null,
    val chat: Chat,
    val forwardOrigin: MessageOrigin? = null,
    val isTopicMessage: Boolean? = null,
    val isAutomaticForward: Boolean? = null,
    val replyToMessage: Message? = null,
    val externalReply: ExternalReplyInfo? = null,
    val quote: TextQuote? = null,
    val replyToStory: Story? = null,
    val viaBot: User? = null,
    val editDate: Long? = null,
    val hasProtectedContent: Boolean? = null,
    val isFromOffline: Boolean? = null,
    val mediaGroupId: String? = null,
    val authorSignature: String? = null,
    val paidStarCount: Long? = null,
    val text: String? = null,
    val entities: List<MessageEntity>? = null,
    val linkPreviewOptions: LinkPreviewOptions? = null,
    val effectId: String? = null,
    val animation: Animation? = null,
    val audio: Audio? = null,
    val document: Document? = null,
    val paidMedia: PaidMediaInfo? = null,
    val photo: List<PhotoSize>? = null,
    val sticker: Sticker? = null,
    val story: Story? = null,
    val video: Video? = null,
    val videoNote: VideoNote? = null,
    val voice: Voice? = null,
    val caption: String? = null,
    val captionEntities: List<MessageEntity>? = null,
    val showCaptionAboveMedia: Boolean? = null,
    val hasMediaSpoiler: Boolean? = null,
    val checklist: Checklist? = null,
    val contact: Contact? = null,
    val dice: Dice? = null,
    val game: Game? = null,
    val poll: Poll? = null,
    val venue: Venue? = null,
    val location: Location? = null,
    val newChatMembers: List<User>? = null,
    val leftChatMember: User? = null,
    val newChatTitle: String? = null,
    val newChatPhoto: List<PhotoSize>? = null,
    val deleteChatPhoto: Boolean? = null,
    val groupChatCreated: Boolean? = null,
    val supergroupChatCreated: Boolean? = null,
    val channelChatCreated: Boolean? = null,
    val messageAutoDeleteTimerChanged: MessageAutoDeleteTimerChanged? = null,
    val migrateToChatId: Long? = null,
    val migrateFromChatId: Long? = null,
    val pinnedMessage: MaybeInaccessibleMessage? = null,
    val invoice: Invoice? = null,
    val successfulPayment: SuccessfulPayment? = null,
    val refundedPayment: RefundedPayment? = null,
    val usersShared: UsersShared? = null,
    val chatShared: ChatShared? = null,
    val gift: GiftInfo? = null,
    val uniqueGift: UniqueGiftInfo? = null,
    val connectedWebsite: String? = null,
    val writeAccessAllowed: WriteAccessAllowed? = null,
    val passportData: PassportData? = null,
    val proximityAlertTriggered: ProximityAlertTriggered? = null,
    val boostAdded: ChatBoostAdded? = null,
    val chatBackgroundSet: ChatBackground? = null,
    val checklistTasksDone: ChecklistTasksDone? = null,
    val checklistTasksAdded: ChecklistTasksAdded? = null,
    val directMessagePriceChanged: DirectMessagePriceChanged? = null,
    val forumTopicCreated: ForumTopicCreated? = null,
    val forumTopicEdited: ForumTopicEdited? = null,
    val forumTopicClosed: Any? = null,
    val forumTopicReopened: Any? = null,
    val generalForumTopicHidden: Any? = null,
    val generalForumTopicUnhidden: Any? = null,
    val giveawayCreated: Any? = null,
    val giveaway: Giveaway? = null,
    val giveawayWinners: GiveawayWinners? = null,
    val giveawayCompleted: GiveawayCompleted? = null,
    val paidMessagePriceChanged: PaidMessagePriceChanged? = null,
    val videoChatScheduled: VideoChatScheduled? = null,
    val videoChatStarted: Any? = null,
    val videoChatEnded: VideoChatEnded? = null,
    val videoChatParticipantsInvited: VideoChatParticipantsInvited? = null,
    val webAppData: WebAppData? = null,
    val replyMarkup: InlineKeyboardMarkup? = null,
) : MaybeInaccessibleMessage()

/**
 * <p>This object represents a unique message identifier.</p>
 *
 * @property messageId Unique message identifier. In specific instances (e.g., message containing a video sent to a big chat), the server might automatically schedule a message instead of sending it immediately. In such cases, this field will be 0 and the relevant message will be unusable until it is actually sent
 *
 * @constructor Creates a [MessageId].
 * */
data class MessageId(
    val messageId: Long,
) : TelegramModel()

/**
 * <p>This object describes a message that was deleted or is otherwise inaccessible to the bot.</p>
 *
 * @property chat Chat the message belonged to
 * @property messageId Unique message identifier inside the chat
 * @property date Always 0. The field can be used to differentiate regular and inaccessible messages.
 *
 * @constructor Creates a [InaccessibleMessage].
 * */
data class InaccessibleMessage(
    val chat: Chat,
    val messageId: Long,
    val date: Long,
) : MaybeInaccessibleMessage()

/**
 * <p>This object represents one special entity in a text message. For example, hashtags, usernames, URLs, etc.</p>
 *
 * @property type Type of the entity. Currently, can be “mention” (<code>@username</code>), “hashtag” (<code>#hashtag</code> or <code>#hashtag@chatusername</code>), “cashtag” (<code>$USD</code> or <code>$USD@chatusername</code>), “bot_command” (<code>/start@jobs_bot</code>), “url” (<code>https://telegram.org</code>), “email” (<code>do-not-reply@telegram.org</code>), “phone_number” (<code>+1-212-555-0123</code>), “bold” (<strong>bold text</strong>), “italic” (<em>italic text</em>), “underline” (underlined text), “strikethrough” (strikethrough text), “spoiler” (spoiler message), “blockquote” (block quotation), “expandable_blockquote” (collapsed-by-default block quotation), “code” (monowidth string), “pre” (monowidth block), “text_link” (for clickable text URLs), “text_mention” (for users <a href="https://telegram.org/blog/edit#new-mentions">without usernames</a>), “custom_emoji” (for inline custom emoji stickers)
 * @property offset Offset in <a href="/api/entities#entity-length">UTF-16 code units</a> to the start of the entity
 * @property length Length of the entity in <a href="/api/entities#entity-length">UTF-16 code units</a>
 * @property url <em>Optional</em>. For “text_link” only, URL that will be opened after user taps on the text
 * @property user <em>Optional</em>. For “text_mention” only, the mentioned user
 * @property language <em>Optional</em>. For “pre” only, the programming language of the entity text
 * @property customEmojiId <em>Optional</em>. For “custom_emoji” only, unique identifier of the custom emoji. Use <a href="#getcustomemojistickers">getCustomEmojiStickers</a> to get full information about the sticker
 *
 * @constructor Creates a [MessageEntity].
 * */
data class MessageEntity(
    val type: String,
    val offset: Long,
    val length: Long,
    val url: String? = null,
    val user: User? = null,
    val language: String? = null,
    val customEmojiId: String? = null,
) : TelegramModel()

/**
 * <p>This object contains information about the quoted part of a message that is replied to by the given message.</p>
 *
 * @property text Text of the quoted part of a message that is replied to by the given message
 * @property entities <em>Optional</em>. Special entities that appear in the quote. Currently, only <em>bold</em>, <em>italic</em>, <em>underline</em>, <em>strikethrough</em>, <em>spoiler</em>, and <em>custom_emoji</em> entities are kept in quotes.
 * @property position Approximate quote position in the original message in UTF-16 code units as specified by the sender
 * @property isManual <em>Optional</em>. <em>True</em>, if the quote was chosen manually by the message sender. Otherwise, the quote was added automatically by the server.
 *
 * @constructor Creates a [TextQuote].
 * */
data class TextQuote(
    val text: String,
    val entities: List<MessageEntity>? = null,
    val position: Long,
    val isManual: Boolean? = null,
) : TelegramModel()

/**
 * <p>This object contains information about a message that is being replied to, which may come from another chat or forum topic.</p>
 *
 * @property origin Origin of the message replied to by the given message
 * @property chat <em>Optional</em>. Chat the original message belongs to. Available only if the chat is a supergroup or a channel.
 * @property messageId <em>Optional</em>. Unique message identifier inside the original chat. Available only if the original chat is a supergroup or a channel.
 * @property linkPreviewOptions <em>Optional</em>. Options used for link preview generation for the original message, if it is a text message
 * @property animation <em>Optional</em>. Message is an animation, information about the animation
 * @property audio <em>Optional</em>. Message is an audio file, information about the file
 * @property document <em>Optional</em>. Message is a general file, information about the file
 * @property paidMedia <em>Optional</em>. Message contains paid media; information about the paid media
 * @property photo <em>Optional</em>. Message is a photo, available sizes of the photo
 * @property sticker <em>Optional</em>. Message is a sticker, information about the sticker
 * @property story <em>Optional</em>. Message is a forwarded story
 * @property video <em>Optional</em>. Message is a video, information about the video
 * @property videoNote <em>Optional</em>. Message is a <a href="https://telegram.org/blog/video-messages-and-telescope">video note</a>, information about the video message
 * @property voice <em>Optional</em>. Message is a voice message, information about the file
 * @property hasMediaSpoiler <em>Optional</em>. <em>True</em>, if the message media is covered by a spoiler animation
 * @property checklist <em>Optional</em>. Message is a checklist
 * @property contact <em>Optional</em>. Message is a shared contact, information about the contact
 * @property dice <em>Optional</em>. Message is a dice with random value
 * @property game <em>Optional</em>. Message is a game, information about the game. <a href="#games">More about games »</a>
 * @property giveaway <em>Optional</em>. Message is a scheduled giveaway, information about the giveaway
 * @property giveawayWinners <em>Optional</em>. A giveaway with public winners was completed
 * @property invoice <em>Optional</em>. Message is an invoice for a <a href="#payments">payment</a>, information about the invoice. <a href="#payments">More about payments »</a>
 * @property location <em>Optional</em>. Message is a shared location, information about the location
 * @property poll <em>Optional</em>. Message is a native poll, information about the poll
 * @property venue <em>Optional</em>. Message is a venue, information about the venue
 *
 * @constructor Creates a [ExternalReplyInfo].
 * */
data class ExternalReplyInfo(
    val origin: MessageOrigin,
    val chat: Chat? = null,
    val messageId: Long? = null,
    val linkPreviewOptions: LinkPreviewOptions? = null,
    val animation: Animation? = null,
    val audio: Audio? = null,
    val document: Document? = null,
    val paidMedia: PaidMediaInfo? = null,
    val photo: List<PhotoSize>? = null,
    val sticker: Sticker? = null,
    val story: Story? = null,
    val video: Video? = null,
    val videoNote: VideoNote? = null,
    val voice: Voice? = null,
    val hasMediaSpoiler: Boolean? = null,
    val checklist: Checklist? = null,
    val contact: Contact? = null,
    val dice: Dice? = null,
    val game: Game? = null,
    val giveaway: Giveaway? = null,
    val giveawayWinners: GiveawayWinners? = null,
    val invoice: Invoice? = null,
    val location: Location? = null,
    val poll: Poll? = null,
    val venue: Venue? = null,
) : TelegramModel()

/**
 * <p>Describes reply parameters for the message that is being sent.</p>
 *
 * @property messageId Identifier of the message that will be replied to in the current chat, or in the chat <em>chat_id</em> if it is specified
 * @property chatId <em>Optional</em>. If the message to be replied to is from a different chat, unique identifier for the chat or username of the channel (in the format <code>@channelusername</code>). Not supported for messages sent on behalf of a business account.
 * @property allowSendingWithoutReply <em>Optional</em>. Pass <em>True</em> if the message should be sent even if the specified message to be replied to is not found. Always <em>False</em> for replies in another chat or forum topic. Always <em>True</em> for messages sent on behalf of a business account.
 * @property quote <em>Optional</em>. Quoted part of the message to be replied to; 0-1024 characters after entities parsing. The quote must be an exact substring of the message to be replied to, including <em>bold</em>, <em>italic</em>, <em>underline</em>, <em>strikethrough</em>, <em>spoiler</em>, and <em>custom_emoji</em> entities. The message will fail to send if the quote isn't found in the original message.
 * @property quoteParseMode <em>Optional</em>. Mode for parsing entities in the quote. See <a href="#formatting-options">formatting options</a> for more details.
 * @property quoteEntities <em>Optional</em>. A JSON-serialized list of special entities that appear in the quote. It can be specified instead of <em>quote_parse_mode</em>.
 * @property quotePosition <em>Optional</em>. Position of the quote in the original message in UTF-16 code units
 *
 * @constructor Creates a [ReplyParameters].
 * */
data class ReplyParameters(
    val messageId: Long,
    val chatId: String? = null,
    val allowSendingWithoutReply: Boolean? = null,
    val quote: String? = null,
    val quoteParseMode: String? = null,
    val quoteEntities: List<MessageEntity>? = null,
    val quotePosition: Long? = null,
) : TelegramModel()

/**
 * <p>The message was originally sent by a known user.</p>
 *
 * @property type Type of the message origin, always “user”
 * @property date Date the message was sent originally in Unix time
 * @property senderUser User that sent the message originally
 *
 * @constructor Creates a [MessageOriginUser].
 * */
data class MessageOriginUser(
    val type: String,
    val date: Long,
    val senderUser: User,
) : MessageOrigin()

/**
 * <p>The message was originally sent by an unknown user.</p>
 *
 * @property type Type of the message origin, always “hidden_user”
 * @property date Date the message was sent originally in Unix time
 * @property senderUserName Name of the user that sent the message originally
 *
 * @constructor Creates a [MessageOriginHiddenUser].
 * */
data class MessageOriginHiddenUser(
    val type: String,
    val date: Long,
    val senderUserName: String,
) : MessageOrigin()

/**
 * <p>The message was originally sent on behalf of a chat to a group chat.</p>
 *
 * @property type Type of the message origin, always “chat”
 * @property date Date the message was sent originally in Unix time
 * @property senderChat Chat that sent the message originally
 * @property authorSignature <em>Optional</em>. For messages originally sent by an anonymous chat administrator, original message author signature
 *
 * @constructor Creates a [MessageOriginChat].
 * */
data class MessageOriginChat(
    val type: String,
    val date: Long,
    val senderChat: Chat,
    val authorSignature: String? = null,
) : MessageOrigin()

/**
 * <p>The message was originally sent to a channel chat.</p>
 *
 * @property type Type of the message origin, always “channel”
 * @property date Date the message was sent originally in Unix time
 * @property chat Channel chat to which the message was originally sent
 * @property messageId Unique message identifier inside the chat
 * @property authorSignature <em>Optional</em>. Signature of the original post author
 *
 * @constructor Creates a [MessageOriginChannel].
 * */
data class MessageOriginChannel(
    val type: String,
    val date: Long,
    val chat: Chat,
    val messageId: Long,
    val authorSignature: String? = null,
) : MessageOrigin()

/**
 * <p>This object represents one size of a photo or a <a href="#document">file</a> / <a href="#sticker">sticker</a> thumbnail.</p>
 *
 * @property fileId Identifier for this file, which can be used to download or reuse the file
 * @property fileUniqueId Unique identifier for this file, which is supposed to be the same over time and for different bots. Can't be used to download or reuse the file.
 * @property width Photo width
 * @property height Photo height
 * @property fileSize <em>Optional</em>. File size in bytes
 *
 * @constructor Creates a [PhotoSize].
 * */
data class PhotoSize(
    val fileId: String,
    val fileUniqueId: String,
    val width: Long,
    val height: Long,
    val fileSize: Long? = null,
) : TelegramModel()

/**
 * <p>This object represents an animation file (GIF or H.264/MPEG-4 AVC video without sound).</p>
 *
 * @property fileId Identifier for this file, which can be used to download or reuse the file
 * @property fileUniqueId Unique identifier for this file, which is supposed to be the same over time and for different bots. Can't be used to download or reuse the file.
 * @property width Video width as defined by the sender
 * @property height Video height as defined by the sender
 * @property duration Duration of the video in seconds as defined by the sender
 * @property thumbnail <em>Optional</em>. Animation thumbnail as defined by the sender
 * @property fileName <em>Optional</em>. Original animation filename as defined by the sender
 * @property mimeType <em>Optional</em>. MIME type of the file as defined by the sender
 * @property fileSize <em>Optional</em>. File size in bytes. It can be bigger than 2^31 and some programming languages may have difficulty/silent defects in interpreting it. But it has at most 52 significant bits, so a signed 64-bit integer or double-precision float type are safe for storing this value.
 *
 * @constructor Creates a [Animation].
 * */
data class Animation(
    val fileId: String,
    val fileUniqueId: String,
    val width: Long,
    val height: Long,
    val duration: Long,
    val thumbnail: PhotoSize? = null,
    val fileName: String? = null,
    val mimeType: String? = null,
    val fileSize: Long? = null,
) : TelegramModel()

/**
 * <p>This object represents an audio file to be treated as music by the Telegram clients.</p>
 *
 * @property fileId Identifier for this file, which can be used to download or reuse the file
 * @property fileUniqueId Unique identifier for this file, which is supposed to be the same over time and for different bots. Can't be used to download or reuse the file.
 * @property duration Duration of the audio in seconds as defined by the sender
 * @property performer <em>Optional</em>. Performer of the audio as defined by the sender or by audio tags
 * @property title <em>Optional</em>. Title of the audio as defined by the sender or by audio tags
 * @property fileName <em>Optional</em>. Original filename as defined by the sender
 * @property mimeType <em>Optional</em>. MIME type of the file as defined by the sender
 * @property fileSize <em>Optional</em>. File size in bytes. It can be bigger than 2^31 and some programming languages may have difficulty/silent defects in interpreting it. But it has at most 52 significant bits, so a signed 64-bit integer or double-precision float type are safe for storing this value.
 * @property thumbnail <em>Optional</em>. Thumbnail of the album cover to which the music file belongs
 *
 * @constructor Creates a [Audio].
 * */
data class Audio(
    val fileId: String,
    val fileUniqueId: String,
    val duration: Long,
    val performer: String? = null,
    val title: String? = null,
    val fileName: String? = null,
    val mimeType: String? = null,
    val fileSize: Long? = null,
    val thumbnail: PhotoSize? = null,
) : TelegramModel()

/**
 * <p>This object represents a general file (as opposed to <a href="#photosize">photos</a>, <a href="#voice">voice messages</a> and <a href="#audio">audio files</a>).</p>
 *
 * @property fileId Identifier for this file, which can be used to download or reuse the file
 * @property fileUniqueId Unique identifier for this file, which is supposed to be the same over time and for different bots. Can't be used to download or reuse the file.
 * @property thumbnail <em>Optional</em>. Document thumbnail as defined by the sender
 * @property fileName <em>Optional</em>. Original filename as defined by the sender
 * @property mimeType <em>Optional</em>. MIME type of the file as defined by the sender
 * @property fileSize <em>Optional</em>. File size in bytes. It can be bigger than 2^31 and some programming languages may have difficulty/silent defects in interpreting it. But it has at most 52 significant bits, so a signed 64-bit integer or double-precision float type are safe for storing this value.
 *
 * @constructor Creates a [Document].
 * */
data class Document(
    val fileId: String,
    val fileUniqueId: String,
    val thumbnail: PhotoSize? = null,
    val fileName: String? = null,
    val mimeType: String? = null,
    val fileSize: Long? = null,
) : TelegramModel()

/**
 * <p>This object represents a story.</p>
 *
 * @property chat Chat that posted the story
 * @property id Unique identifier for the story in the chat
 *
 * @constructor Creates a [Story].
 * */
data class Story(
    val chat: Chat,
    val id: Long,
) : TelegramModel()

/**
 * <p>This object represents a video file.</p>
 *
 * @property fileId Identifier for this file, which can be used to download or reuse the file
 * @property fileUniqueId Unique identifier for this file, which is supposed to be the same over time and for different bots. Can't be used to download or reuse the file.
 * @property width Video width as defined by the sender
 * @property height Video height as defined by the sender
 * @property duration Duration of the video in seconds as defined by the sender
 * @property thumbnail <em>Optional</em>. Video thumbnail
 * @property cover <em>Optional</em>. Available sizes of the cover of the video in the message
 * @property startTimestamp <em>Optional</em>. Timestamp in seconds from which the video will play in the message
 * @property fileName <em>Optional</em>. Original filename as defined by the sender
 * @property mimeType <em>Optional</em>. MIME type of the file as defined by the sender
 * @property fileSize <em>Optional</em>. File size in bytes. It can be bigger than 2^31 and some programming languages may have difficulty/silent defects in interpreting it. But it has at most 52 significant bits, so a signed 64-bit integer or double-precision float type are safe for storing this value.
 *
 * @constructor Creates a [Video].
 * */
data class Video(
    val fileId: String,
    val fileUniqueId: String,
    val width: Long,
    val height: Long,
    val duration: Long,
    val thumbnail: PhotoSize? = null,
    val cover: List<PhotoSize>? = null,
    val startTimestamp: Long? = null,
    val fileName: String? = null,
    val mimeType: String? = null,
    val fileSize: Long? = null,
) : TelegramModel()

/**
 * <p>This object represents a <a href="https://telegram.org/blog/video-messages-and-telescope">video message</a> (available in Telegram apps as of <a href="https://telegram.org/blog/video-messages-and-telescope">v.4.0</a>).</p>
 *
 * @property fileId Identifier for this file, which can be used to download or reuse the file
 * @property fileUniqueId Unique identifier for this file, which is supposed to be the same over time and for different bots. Can't be used to download or reuse the file.
 * @property length Video width and height (diameter of the video message) as defined by the sender
 * @property duration Duration of the video in seconds as defined by the sender
 * @property thumbnail <em>Optional</em>. Video thumbnail
 * @property fileSize <em>Optional</em>. File size in bytes
 *
 * @constructor Creates a [VideoNote].
 * */
data class VideoNote(
    val fileId: String,
    val fileUniqueId: String,
    val length: Long,
    val duration: Long,
    val thumbnail: PhotoSize? = null,
    val fileSize: Long? = null,
) : TelegramModel()

/**
 * <p>This object represents a voice note.</p>
 *
 * @property fileId Identifier for this file, which can be used to download or reuse the file
 * @property fileUniqueId Unique identifier for this file, which is supposed to be the same over time and for different bots. Can't be used to download or reuse the file.
 * @property duration Duration of the audio in seconds as defined by the sender
 * @property mimeType <em>Optional</em>. MIME type of the file as defined by the sender
 * @property fileSize <em>Optional</em>. File size in bytes. It can be bigger than 2^31 and some programming languages may have difficulty/silent defects in interpreting it. But it has at most 52 significant bits, so a signed 64-bit integer or double-precision float type are safe for storing this value.
 *
 * @constructor Creates a [Voice].
 * */
data class Voice(
    val fileId: String,
    val fileUniqueId: String,
    val duration: Long,
    val mimeType: String? = null,
    val fileSize: Long? = null,
) : TelegramModel()

/**
 * <p>Describes the paid media added to a message.</p>
 *
 * @property starCount The number of Telegram Stars that must be paid to buy access to the media
 * @property paidMedia Information about the paid media
 *
 * @constructor Creates a [PaidMediaInfo].
 * */
data class PaidMediaInfo(
    val starCount: Long,
    val paidMedia: List<PaidMedia>,
) : TelegramModel()

/**
 * <p>The paid media isn't available before the payment.</p>
 *
 * @property type Type of the paid media, always “preview”
 * @property width <em>Optional</em>. Media width as defined by the sender
 * @property height <em>Optional</em>. Media height as defined by the sender
 * @property duration <em>Optional</em>. Duration of the media in seconds as defined by the sender
 *
 * @constructor Creates a [PaidMediaPreview].
 * */
data class PaidMediaPreview(
    val type: String,
    val width: Long? = null,
    val height: Long? = null,
    val duration: Long? = null,
) : PaidMedia()

/**
 * <p>The paid media is a photo.</p>
 *
 * @property type Type of the paid media, always “photo”
 * @property photo The photo
 *
 * @constructor Creates a [PaidMediaPhoto].
 * */
data class PaidMediaPhoto(
    val type: String,
    val photo: List<PhotoSize>,
) : PaidMedia()

/**
 * <p>The paid media is a video.</p>
 *
 * @property type Type of the paid media, always “video”
 * @property video The video
 *
 * @constructor Creates a [PaidMediaVideo].
 * */
data class PaidMediaVideo(
    val type: String,
    val video: Video,
) : PaidMedia()

/**
 * <p>This object represents a phone contact.</p>
 *
 * @property phoneNumber Contact's phone number
 * @property firstName Contact's first name
 * @property lastName <em>Optional</em>. Contact's last name
 * @property userId <em>Optional</em>. Contact's user identifier in Telegram. This number may have more than 32 significant bits and some programming languages may have difficulty/silent defects in interpreting it. But it has at most 52 significant bits, so a 64-bit integer or double-precision float type are safe for storing this identifier.
 * @property vcard <em>Optional</em>. Additional data about the contact in the form of a <a href="https://en.wikipedia.org/wiki/VCard">vCard</a>
 *
 * @constructor Creates a [Contact].
 * */
data class Contact(
    val phoneNumber: String,
    val firstName: String,
    val lastName: String? = null,
    val userId: Long? = null,
    val vcard: String? = null,
) : TelegramModel()

/**
 * <p>This object represents an animated emoji that displays a random value.</p>
 *
 * @property emoji Emoji on which the dice throw animation is based
 * @property value Value of the dice, 1-6 for “<img class="emoji" src="//telegram.org/img/emoji/40/F09F8EB2.png" width="20" height="20" alt="🎲">”, “<img class="emoji" src="//telegram.org/img/emoji/40/F09F8EAF.png" width="20" height="20" alt="🎯">” and “<img class="emoji" src="//telegram.org/img/emoji/40/F09F8EB3.png" width="20" height="20" alt="🎳">” base emoji, 1-5 for “<img class="emoji" src="//telegram.org/img/emoji/40/F09F8F80.png" width="20" height="20" alt="🏀">” and “<img class="emoji" src="//telegram.org/img/emoji/40/E29ABD.png" width="20" height="20" alt="⚽">” base emoji, 1-64 for “<img class="emoji" src="//telegram.org/img/emoji/40/F09F8EB0.png" width="20" height="20" alt="🎰">” base emoji
 *
 * @constructor Creates a [Dice].
 * */
data class Dice(
    val emoji: String,
    val value: Long,
) : TelegramModel()

/**
 * <p>This object contains information about one answer option in a poll.</p>
 *
 * @property text Option text, 1-100 characters
 * @property textEntities <em>Optional</em>. Special entities that appear in the option <em>text</em>. Currently, only custom emoji entities are allowed in poll option texts
 * @property voterCount Number of users that voted for this option
 *
 * @constructor Creates a [PollOption].
 * */
data class PollOption(
    val text: String,
    val textEntities: List<MessageEntity>? = null,
    val voterCount: Long,
) : TelegramModel()

/**
 * <p>This object contains information about one answer option in a poll to be sent.</p>
 *
 * @property text Option text, 1-100 characters
 * @property textParseMode <em>Optional</em>. Mode for parsing entities in the text. See <a href="#formatting-options">formatting options</a> for more details. Currently, only custom emoji entities are allowed
 * @property textEntities <em>Optional</em>. A JSON-serialized list of special entities that appear in the poll option text. It can be specified instead of <em>text_parse_mode</em>
 *
 * @constructor Creates a [InputPollOption].
 * */
data class InputPollOption(
    val text: String,
    val textParseMode: String? = null,
    val textEntities: List<MessageEntity>? = null,
) : TelegramModel()

/**
 * <p>This object represents an answer of a user in a non-anonymous poll.</p>
 *
 * @property pollId Unique poll identifier
 * @property voterChat <em>Optional</em>. The chat that changed the answer to the poll, if the voter is anonymous
 * @property user <em>Optional</em>. The user that changed the answer to the poll, if the voter isn't anonymous
 * @property optionIds 0-based identifiers of chosen answer options. May be empty if the vote was retracted.
 *
 * @constructor Creates a [PollAnswer].
 * */
data class PollAnswer(
    val pollId: String,
    val voterChat: Chat? = null,
    val user: User? = null,
    val optionIds: List<Long>,
) : TelegramModel()

/**
 * <p>This object contains information about a poll.</p>
 *
 * @property id Unique poll identifier
 * @property question Poll question, 1-300 characters
 * @property questionEntities <em>Optional</em>. Special entities that appear in the <em>question</em>. Currently, only custom emoji entities are allowed in poll questions
 * @property options List of poll options
 * @property totalVoterCount Total number of users that voted in the poll
 * @property isClosed <em>True</em>, if the poll is closed
 * @property isAnonymous <em>True</em>, if the poll is anonymous
 * @property type Poll type, currently can be “regular” or “quiz”
 * @property allowsMultipleAnswers <em>True</em>, if the poll allows multiple answers
 * @property correctOptionId <em>Optional</em>. 0-based identifier of the correct answer option. Available only for polls in the quiz mode, which are closed, or was sent (not forwarded) by the bot or to the private chat with the bot.
 * @property explanation <em>Optional</em>. Text that is shown when a user chooses an incorrect answer or taps on the lamp icon in a quiz-style poll, 0-200 characters
 * @property explanationEntities <em>Optional</em>. Special entities like usernames, URLs, bot commands, etc. that appear in the <em>explanation</em>
 * @property openPeriod <em>Optional</em>. Amount of time in seconds the poll will be active after creation
 * @property closeDate <em>Optional</em>. Point in time (Unix timestamp) when the poll will be automatically closed
 *
 * @constructor Creates a [Poll].
 * */
data class Poll(
    val id: String,
    val question: String,
    val questionEntities: List<MessageEntity>? = null,
    val options: List<PollOption>,
    val totalVoterCount: Long,
    val isClosed: Boolean,
    val isAnonymous: Boolean,
    val type: String,
    val allowsMultipleAnswers: Boolean,
    val correctOptionId: Long? = null,
    val explanation: String? = null,
    val explanationEntities: List<MessageEntity>? = null,
    val openPeriod: Long? = null,
    val closeDate: Long? = null,
) : TelegramModel()

/**
 * <p>Describes a task in a checklist.</p>
 *
 * @property id Unique identifier of the task
 * @property text Text of the task
 * @property textEntities <em>Optional</em>. Special entities that appear in the task text
 * @property completedByUser <em>Optional</em>. User that completed the task; omitted if the task wasn't completed
 * @property completionDate <em>Optional</em>. Point in time (Unix timestamp) when the task was completed; 0 if the task wasn't completed
 *
 * @constructor Creates a [ChecklistTask].
 * */
data class ChecklistTask(
    val id: Long,
    val text: String,
    val textEntities: List<MessageEntity>? = null,
    val completedByUser: User? = null,
    val completionDate: Long? = null,
) : TelegramModel()

/**
 * <p>Describes a checklist.</p>
 *
 * @property title Title of the checklist
 * @property titleEntities <em>Optional</em>. Special entities that appear in the checklist title
 * @property tasks List of tasks in the checklist
 * @property othersCanAddTasks <em>Optional</em>. <em>True</em>, if users other than the creator of the list can add tasks to the list
 * @property othersCanMarkTasksAsDone <em>Optional</em>. <em>True</em>, if users other than the creator of the list can mark tasks as done or not done
 *
 * @constructor Creates a [Checklist].
 * */
data class Checklist(
    val title: String,
    val titleEntities: List<MessageEntity>? = null,
    val tasks: List<ChecklistTask>,
    val othersCanAddTasks: Boolean? = null,
    val othersCanMarkTasksAsDone: Boolean? = null,
) : TelegramModel()

/**
 * <p>Describes a task to add to a checklist.</p>
 *
 * @property id Unique identifier of the task; must be positive and unique among all task identifiers currently present in the checklist
 * @property text Text of the task; 1-100 characters after entities parsing
 * @property parseMode Optional. Mode for parsing entities in the text. See <a href="https://core.telegram.org/bots/api#formatting-options">formatting options</a> for more details.
 * @property textEntities <em>Optional</em>. List of special entities that appear in the text, which can be specified instead of parse_mode. Currently, only <em>bold</em>, <em>italic</em>, <em>underline</em>, <em>strikethrough</em>, <em>spoiler</em>, and <em>custom_emoji</em> entities are allowed.
 *
 * @constructor Creates a [InputChecklistTask].
 * */
data class InputChecklistTask(
    val id: Long,
    val text: String,
    val parseMode: ParseMode? = null,
    val textEntities: List<MessageEntity>? = null,
) : TelegramModel()

/**
 * <p>Describes a checklist to create.</p>
 *
 * @property title Title of the checklist; 1-255 characters after entities parsing
 * @property parseMode Optional. Mode for parsing entities in the title. See <a href="#formatting-options">formatting options</a> for more details.
 * @property titleEntities <em>Optional</em>. List of special entities that appear in the title, which can be specified instead of parse_mode. Currently, only <em>bold</em>, <em>italic</em>, <em>underline</em>, <em>strikethrough</em>, <em>spoiler</em>, and <em>custom_emoji</em> entities are allowed.
 * @property tasks List of 1-30 tasks in the checklist
 * @property othersCanAddTasks <em>Optional</em>. Pass <em>True</em> if other users can add tasks to the checklist
 * @property othersCanMarkTasksAsDone <em>Optional</em>. Pass <em>True</em> if other users can mark tasks as done or not done in the checklist
 *
 * @constructor Creates a [InputChecklist].
 * */
data class InputChecklist(
    val title: String,
    val parseMode: ParseMode? = null,
    val titleEntities: List<MessageEntity>? = null,
    val tasks: List<InputChecklistTask>,
    val othersCanAddTasks: Boolean? = null,
    val othersCanMarkTasksAsDone: Boolean? = null,
) : TelegramModel()

/**
 * <p>Describes a service message about checklist tasks marked as done or not done.</p>
 *
 * @property checklistMessage <em>Optional</em>. Message containing the checklist whose tasks were marked as done or not done. Note that the Message object in this field will not contain the <em>reply_to_message</em> field even if it itself is a reply.
 * @property markedAsDoneTaskIds <em>Optional</em>. Identifiers of the tasks that were marked as done
 * @property markedAsNotDoneTaskIds <em>Optional</em>. Identifiers of the tasks that were marked as not done
 *
 * @constructor Creates a [ChecklistTasksDone].
 * */
data class ChecklistTasksDone(
    val checklistMessage: Message? = null,
    val markedAsDoneTaskIds: List<Long>? = null,
    val markedAsNotDoneTaskIds: List<Long>? = null,
) : TelegramModel()

/**
 * <p>Describes a service message about tasks added to a checklist.</p>
 *
 * @property checklistMessage <em>Optional</em>. Message containing the checklist to which the tasks were added. Note that the Message object in this field will not contain the <em>reply_to_message</em> field even if it itself is a reply.
 * @property tasks List of tasks added to the checklist
 *
 * @constructor Creates a [ChecklistTasksAdded].
 * */
data class ChecklistTasksAdded(
    val checklistMessage: Message? = null,
    val tasks: List<ChecklistTask>,
) : TelegramModel()

/**
 * <p>This object represents a point on the map.</p>
 *
 * @property latitude Latitude as defined by the sender
 * @property longitude Longitude as defined by the sender
 * @property horizontalAccuracy <em>Optional</em>. The radius of uncertainty for the location, measured in meters; 0-1500
 * @property livePeriod <em>Optional</em>. Time relative to the message sending date, during which the location can be updated; in seconds. For active live locations only.
 * @property heading <em>Optional</em>. The direction in which user is moving, in degrees; 1-360. For active live locations only.
 * @property proximityAlertRadius <em>Optional</em>. The maximum distance for proximity alerts about approaching another chat member, in meters. For sent live locations only.
 *
 * @constructor Creates a [Location].
 * */
data class Location(
    val latitude: Float,
    val longitude: Float,
    val horizontalAccuracy: Float? = null,
    val livePeriod: Long? = null,
    val heading: Long? = null,
    val proximityAlertRadius: Long? = null,
) : TelegramModel()

/**
 * <p>This object represents a venue.</p>
 *
 * @property location Venue location. Can't be a live location
 * @property title Name of the venue
 * @property address Address of the venue
 * @property foursquareId <em>Optional</em>. Foursquare identifier of the venue
 * @property foursquareType <em>Optional</em>. Foursquare type of the venue. (For example, “arts_entertainment/default”, “arts_entertainment/aquarium” or “food/icecream”.)
 * @property googlePlaceId <em>Optional</em>. Google Places identifier of the venue
 * @property googlePlaceType <em>Optional</em>. Google Places type of the venue. (See <a href="https://developers.google.com/places/web-service/supported_types">supported types</a>.)
 *
 * @constructor Creates a [Venue].
 * */
data class Venue(
    val location: Location,
    val title: String,
    val address: String,
    val foursquareId: String? = null,
    val foursquareType: String? = null,
    val googlePlaceId: String? = null,
    val googlePlaceType: String? = null,
) : TelegramModel()

/**
 * <p>Describes data sent from a <a href="/bots/webapps">Web App</a> to the bot.</p>
 *
 * @property data The data. Be aware that a bad client can send arbitrary data in this field.
 * @property buttonText Text of the <em>web_app</em> keyboard button from which the Web App was opened. Be aware that a bad client can send arbitrary data in this field.
 *
 * @constructor Creates a [WebAppData].
 * */
data class WebAppData(
    val data: String,
    val buttonText: String,
) : TelegramModel()

/**
 * <p>This object represents the content of a service message, sent whenever a user in the chat triggers a proximity alert set by another user.</p>
 *
 * @property traveler User that triggered the alert
 * @property watcher User that set the alert
 * @property distance The distance between the users
 *
 * @constructor Creates a [ProximityAlertTriggered].
 * */
data class ProximityAlertTriggered(
    val traveler: User,
    val watcher: User,
    val distance: Long,
) : TelegramModel()

/**
 * <p>This object represents a service message about a change in auto-delete timer settings.</p>
 *
 * @property messageAutoDeleteTime New auto-delete time for messages in the chat; in seconds
 *
 * @constructor Creates a [MessageAutoDeleteTimerChanged].
 * */
data class MessageAutoDeleteTimerChanged(
    val messageAutoDeleteTime: Long,
) : TelegramModel()

/**
 * <p>This object represents a service message about a user boosting a chat.</p>
 *
 * @property boostCount Number of boosts added by the user
 *
 * @constructor Creates a [ChatBoostAdded].
 * */
data class ChatBoostAdded(
    val boostCount: Long,
) : TelegramModel()

/**
 * <p>The background is filled using the selected color.</p>
 *
 * @property type Type of the background fill, always “solid”
 * @property color The color of the background fill in the RGB24 format
 *
 * @constructor Creates a [BackgroundFillSolid].
 * */
data class BackgroundFillSolid(
    val type: String,
    val color: Long,
) : BackgroundFill()

/**
 * <p>The background is a gradient fill.</p>
 *
 * @property type Type of the background fill, always “gradient”
 * @property topColor Top color of the gradient in the RGB24 format
 * @property bottomColor Bottom color of the gradient in the RGB24 format
 * @property rotationAngle Clockwise rotation angle of the background fill in degrees; 0-359
 *
 * @constructor Creates a [BackgroundFillGradient].
 * */
data class BackgroundFillGradient(
    val type: String,
    val topColor: Long,
    val bottomColor: Long,
    val rotationAngle: Long,
) : BackgroundFill()

/**
 * <p>The background is a freeform gradient that rotates after every message in the chat.</p>
 *
 * @property type Type of the background fill, always “freeform_gradient”
 * @property colors A list of the 3 or 4 base colors that are used to generate the freeform gradient in the RGB24 format
 *
 * @constructor Creates a [BackgroundFillFreeformGradient].
 * */
data class BackgroundFillFreeformGradient(
    val type: String,
    val colors: List<Long>,
) : BackgroundFill()

/**
 * <p>The background is automatically filled based on the selected colors.</p>
 *
 * @property type Type of the background, always “fill”
 * @property fill The background fill
 * @property darkThemeDimming Dimming of the background in dark themes, as a percentage; 0-100
 *
 * @constructor Creates a [BackgroundTypeFill].
 * */
data class BackgroundTypeFill(
    val type: String,
    val fill: BackgroundFill,
    val darkThemeDimming: Long,
) : BackgroundType()

/**
 * <p>The background is a wallpaper in the JPEG format.</p>
 *
 * @property type Type of the background, always “wallpaper”
 * @property document Document with the wallpaper
 * @property darkThemeDimming Dimming of the background in dark themes, as a percentage; 0-100
 * @property isBlurred <em>Optional</em>. <em>True</em>, if the wallpaper is downscaled to fit in a 450x450 square and then box-blurred with radius 12
 * @property isMoving <em>Optional</em>. <em>True</em>, if the background moves slightly when the device is tilted
 *
 * @constructor Creates a [BackgroundTypeWallpaper].
 * */
data class BackgroundTypeWallpaper(
    val type: String,
    val document: Document,
    val darkThemeDimming: Long,
    val isBlurred: Boolean? = null,
    val isMoving: Boolean? = null,
) : BackgroundType()

/**
 * <p>The background is a .PNG or .TGV (gzipped subset of SVG with MIME type “application/x-tgwallpattern”) pattern to be combined with the background fill chosen by the user.</p>
 *
 * @property type Type of the background, always “pattern”
 * @property document Document with the pattern
 * @property fill The background fill that is combined with the pattern
 * @property intensity Intensity of the pattern when it is shown above the filled background; 0-100
 * @property isInverted <em>Optional</em>. <em>True</em>, if the background fill must be applied only to the pattern itself. All other pixels are black in this case. For dark themes only
 * @property isMoving <em>Optional</em>. <em>True</em>, if the background moves slightly when the device is tilted
 *
 * @constructor Creates a [BackgroundTypePattern].
 * */
data class BackgroundTypePattern(
    val type: String,
    val document: Document,
    val fill: BackgroundFill,
    val intensity: Long,
    val isInverted: Boolean? = null,
    val isMoving: Boolean? = null,
) : BackgroundType()

/**
 * <p>The background is taken directly from a built-in chat theme.</p>
 *
 * @property type Type of the background, always “chat_theme”
 * @property themeName Name of the chat theme, which is usually an emoji
 *
 * @constructor Creates a [BackgroundTypeChatTheme].
 * */
data class BackgroundTypeChatTheme(
    val type: String,
    val themeName: String,
) : BackgroundType()

/**
 * <p>This object represents a chat background.</p>
 *
 * @property type Type of the background
 *
 * @constructor Creates a [ChatBackground].
 * */
data class ChatBackground(
    val type: BackgroundType,
) : TelegramModel()

/**
 * <p>This object represents a service message about a new forum topic created in the chat.</p>
 *
 * @property name Name of the topic
 * @property iconColor Color of the topic icon in RGB format
 * @property iconCustomEmojiId <em>Optional</em>. Unique identifier of the custom emoji shown as the topic icon
 *
 * @constructor Creates a [ForumTopicCreated].
 * */
data class ForumTopicCreated(
    val name: String,
    val iconColor: Long,
    val iconCustomEmojiId: String? = null,
) : TelegramModel()

/**
 * <p>This object represents a service message about an edited forum topic.</p>
 *
 * @property name <em>Optional</em>. New name of the topic, if it was edited
 * @property iconCustomEmojiId <em>Optional</em>. New identifier of the custom emoji shown as the topic icon, if it was edited; an empty string if the icon was removed
 *
 * @constructor Creates a [ForumTopicEdited].
 * */
data class ForumTopicEdited(
    val name: String? = null,
    val iconCustomEmojiId: String? = null,
) : TelegramModel()

/**
 * <p>This object contains information about a user that was shared with the bot using a <a href="#keyboardbuttonrequestusers">KeyboardButtonRequestUsers</a> button.</p>
 *
 * @property userId Identifier of the shared user. This number may have more than 32 significant bits and some programming languages may have difficulty/silent defects in interpreting it. But it has at most 52 significant bits, so 64-bit integers or double-precision float types are safe for storing these identifiers. The bot may not have access to the user and could be unable to use this identifier, unless the user is already known to the bot by some other means.
 * @property firstName <em>Optional</em>. First name of the user, if the name was requested by the bot
 * @property lastName <em>Optional</em>. Last name of the user, if the name was requested by the bot
 * @property username <em>Optional</em>. Username of the user, if the username was requested by the bot
 * @property photo <em>Optional</em>. Available sizes of the chat photo, if the photo was requested by the bot
 *
 * @constructor Creates a [SharedUser].
 * */
data class SharedUser(
    val userId: Long,
    val firstName: String? = null,
    val lastName: String? = null,
    val username: String? = null,
    val photo: List<PhotoSize>? = null,
) : TelegramModel()

/**
 * <p>This object contains information about the users whose identifiers were shared with the bot using a <a href="#keyboardbuttonrequestusers">KeyboardButtonRequestUsers</a> button.</p>
 *
 * @property requestId Identifier of the request
 * @property users Information about users shared with the bot.
 *
 * @constructor Creates a [UsersShared].
 * */
data class UsersShared(
    val requestId: Long,
    val users: List<SharedUser>,
) : TelegramModel()

/**
 * <p>This object contains information about a chat that was shared with the bot using a <a href="#keyboardbuttonrequestchat">KeyboardButtonRequestChat</a> button.</p>
 *
 * @property requestId Identifier of the request
 * @property chatId Identifier of the shared chat. This number may have more than 32 significant bits and some programming languages may have difficulty/silent defects in interpreting it. But it has at most 52 significant bits, so a 64-bit integer or double-precision float type are safe for storing this identifier. The bot may not have access to the chat and could be unable to use this identifier, unless the chat is already known to the bot by some other means.
 * @property title <em>Optional</em>. Title of the chat, if the title was requested by the bot.
 * @property username <em>Optional</em>. Username of the chat, if the username was requested by the bot and available.
 * @property photo <em>Optional</em>. Available sizes of the chat photo, if the photo was requested by the bot
 *
 * @constructor Creates a [ChatShared].
 * */
data class ChatShared(
    val requestId: Long,
    val chatId: Long,
    val title: String? = null,
    val username: String? = null,
    val photo: List<PhotoSize>? = null,
) : TelegramModel()

/**
 * <p>This object represents a service message about a user allowing a bot to write messages after adding it to the attachment menu, launching a Web App from a link, or accepting an explicit request from a Web App sent by the method <a href="/bots/webapps#initializing-mini-apps">requestWriteAccess</a>.</p>
 *
 * @property fromRequest <em>Optional</em>. <em>True</em>, if the access was granted after the user accepted an explicit request from a Web App sent by the method <a href="/bots/webapps#initializing-mini-apps">requestWriteAccess</a>
 * @property webAppName <em>Optional</em>. Name of the Web App, if the access was granted when the Web App was launched from a link
 * @property fromAttachmentMenu <em>Optional</em>. <em>True</em>, if the access was granted when the bot was added to the attachment or side menu
 *
 * @constructor Creates a [WriteAccessAllowed].
 * */
data class WriteAccessAllowed(
    val fromRequest: Boolean? = null,
    val webAppName: String? = null,
    val fromAttachmentMenu: Boolean? = null,
) : TelegramModel()

/**
 * <p>This object represents a service message about a video chat scheduled in the chat.</p>
 *
 * @property startDate Point in time (Unix timestamp) when the video chat is supposed to be started by a chat administrator
 *
 * @constructor Creates a [VideoChatScheduled].
 * */
data class VideoChatScheduled(
    val startDate: Long,
) : TelegramModel()

/**
 * <p>This object represents a service message about a video chat ended in the chat.</p>
 *
 * @property duration Video chat duration in seconds
 *
 * @constructor Creates a [VideoChatEnded].
 * */
data class VideoChatEnded(
    val duration: Long,
) : TelegramModel()

/**
 * <p>This object represents a service message about new members invited to a video chat.</p>
 *
 * @property users New members that were invited to the video chat
 *
 * @constructor Creates a [VideoChatParticipantsInvited].
 * */
data class VideoChatParticipantsInvited(
    val users: List<User>,
) : TelegramModel()

/**
 * <p>Describes a service message about a change in the price of paid messages within a chat.</p>
 *
 * @property paidMessageStarCount The new number of Telegram Stars that must be paid by non-administrator users of the supergroup chat for each sent message
 *
 * @constructor Creates a [PaidMessagePriceChanged].
 * */
data class PaidMessagePriceChanged(
    val paidMessageStarCount: Long,
) : TelegramModel()

/**
 * <p>Describes a service message about a change in the price of direct messages sent to a channel chat.</p>
 *
 * @property areDirectMessagesEnabled <em>True</em>, if direct messages are enabled for the channel chat; false otherwise
 * @property directMessageStarCount <em>Optional</em>. The new number of Telegram Stars that must be paid by users for each direct message sent to the channel. Does not apply to users who have been exempted by administrators. Defaults to 0.
 *
 * @constructor Creates a [DirectMessagePriceChanged].
 * */
data class DirectMessagePriceChanged(
    val areDirectMessagesEnabled: Boolean,
    val directMessageStarCount: Long? = null,
) : TelegramModel()

/**
 * <p>This object represents a service message about the creation of a scheduled giveaway.</p>
 *
 * @property prizeStarCount <em>Optional</em>. The number of Telegram Stars to be split between giveaway winners; for Telegram Star giveaways only
 *
 * @constructor Creates a [GiveawayCreated].
 * */
data class GiveawayCreated(
    val prizeStarCount: Long? = null,
) : TelegramModel()

/**
 * <p>This object represents a message about a scheduled giveaway.</p>
 *
 * @property chats The list of chats which the user must join to participate in the giveaway
 * @property winnersSelectionDate Point in time (Unix timestamp) when winners of the giveaway will be selected
 * @property winnerCount The number of users which are supposed to be selected as winners of the giveaway
 * @property onlyNewMembers <em>Optional</em>. <em>True</em>, if only users who join the chats after the giveaway started should be eligible to win
 * @property hasPublicWinners <em>Optional</em>. <em>True</em>, if the list of giveaway winners will be visible to everyone
 * @property prizeDescription <em>Optional</em>. Description of additional giveaway prize
 * @property countryCodes <em>Optional</em>. A list of two-letter <a href="https://en.wikipedia.org/wiki/ISO_3166-1_alpha-2">ISO 3166-1 alpha-2</a> country codes indicating the countries from which eligible users for the giveaway must come. If empty, then all users can participate in the giveaway. Users with a phone number that was bought on Fragment can always participate in giveaways.
 * @property prizeStarCount <em>Optional</em>. The number of Telegram Stars to be split between giveaway winners; for Telegram Star giveaways only
 * @property premiumSubscriptionMonthCount <em>Optional</em>. The number of months the Telegram Premium subscription won from the giveaway will be active for; for Telegram Premium giveaways only
 *
 * @constructor Creates a [Giveaway].
 * */
data class Giveaway(
    val chats: List<Chat>,
    val winnersSelectionDate: Long,
    val winnerCount: Long,
    val onlyNewMembers: Boolean? = null,
    val hasPublicWinners: Boolean? = null,
    val prizeDescription: String? = null,
    val countryCodes: List<String>? = null,
    val prizeStarCount: Long? = null,
    val premiumSubscriptionMonthCount: Long? = null,
) : TelegramModel()

/**
 * <p>This object represents a message about the completion of a giveaway with public winners.</p>
 *
 * @property chat The chat that created the giveaway
 * @property giveawayMessageId Identifier of the message with the giveaway in the chat
 * @property winnersSelectionDate Point in time (Unix timestamp) when winners of the giveaway were selected
 * @property winnerCount Total number of winners in the giveaway
 * @property winners List of up to 100 winners of the giveaway
 * @property additionalChatCount <em>Optional</em>. The number of other chats the user had to join in order to be eligible for the giveaway
 * @property prizeStarCount <em>Optional</em>. The number of Telegram Stars that were split between giveaway winners; for Telegram Star giveaways only
 * @property premiumSubscriptionMonthCount <em>Optional</em>. The number of months the Telegram Premium subscription won from the giveaway will be active for; for Telegram Premium giveaways only
 * @property unclaimedPrizeCount <em>Optional</em>. Number of undistributed prizes
 * @property onlyNewMembers <em>Optional</em>. <em>True</em>, if only users who had joined the chats after the giveaway started were eligible to win
 * @property wasRefunded <em>Optional</em>. <em>True</em>, if the giveaway was canceled because the payment for it was refunded
 * @property prizeDescription <em>Optional</em>. Description of additional giveaway prize
 *
 * @constructor Creates a [GiveawayWinners].
 * */
data class GiveawayWinners(
    val chat: Chat,
    val giveawayMessageId: Long,
    val winnersSelectionDate: Long,
    val winnerCount: Long,
    val winners: List<User>,
    val additionalChatCount: Long? = null,
    val prizeStarCount: Long? = null,
    val premiumSubscriptionMonthCount: Long? = null,
    val unclaimedPrizeCount: Long? = null,
    val onlyNewMembers: Boolean? = null,
    val wasRefunded: Boolean? = null,
    val prizeDescription: String? = null,
) : TelegramModel()

/**
 * <p>This object represents a service message about the completion of a giveaway without public winners.</p>
 *
 * @property winnerCount Number of winners in the giveaway
 * @property unclaimedPrizeCount <em>Optional</em>. Number of undistributed prizes
 * @property giveawayMessage <em>Optional</em>. Message with the giveaway that was completed, if it wasn't deleted
 * @property isStarGiveaway <em>Optional</em>. <em>True</em>, if the giveaway is a Telegram Star giveaway. Otherwise, currently, the giveaway is a Telegram Premium giveaway.
 *
 * @constructor Creates a [GiveawayCompleted].
 * */
data class GiveawayCompleted(
    val winnerCount: Long,
    val unclaimedPrizeCount: Long? = null,
    val giveawayMessage: Message? = null,
    val isStarGiveaway: Boolean? = null,
) : TelegramModel()

/**
 * <p>Describes the options used for link preview generation.</p>
 *
 * @property isDisabled <em>Optional</em>. <em>True</em>, if the link preview is disabled
 * @property url <em>Optional</em>. URL to use for the link preview. If empty, then the first URL found in the message text will be used
 * @property preferSmallMedia <em>Optional</em>. <em>True</em>, if the media in the link preview is supposed to be shrunk; ignored if the URL isn't explicitly specified or media size change isn't supported for the preview
 * @property preferLargeMedia <em>Optional</em>. <em>True</em>, if the media in the link preview is supposed to be enlarged; ignored if the URL isn't explicitly specified or media size change isn't supported for the preview
 * @property showAboveText <em>Optional</em>. <em>True</em>, if the link preview must be shown above the message text; otherwise, the link preview will be shown below the message text
 *
 * @constructor Creates a [LinkPreviewOptions].
 * */
data class LinkPreviewOptions(
    val isDisabled: Boolean? = null,
    val url: String? = null,
    val preferSmallMedia: Boolean? = null,
    val preferLargeMedia: Boolean? = null,
    val showAboveText: Boolean? = null,
) : TelegramModel()

/**
 * <p>This object represent a user's profile pictures.</p>
 *
 * @property totalCount Total number of profile pictures the target user has
 * @property photos Requested profile pictures (in up to 4 sizes each)
 *
 * @constructor Creates a [UserProfilePhotos].
 * */
data class UserProfilePhotos(
    val totalCount: Long,
    val photos: List<List<PhotoSize>>,
) : TelegramModel()

/**
 * <p>This object represents a file ready to be downloaded. The file can be downloaded via the link <code>https://api.telegram.org/file/bot&lt;token&gt;/&lt;file_path&gt;</code>. It is guaranteed that the link will be valid for at least 1 hour. When the link expires, a new one can be requested by calling <a href="#getfile">getFile</a>.</p><blockquote>
 *  <p>The maximum file size to download is 20 MB</p>
 * </blockquote>
 *
 * @property fileId Identifier for this file, which can be used to download or reuse the file
 * @property fileUniqueId Unique identifier for this file, which is supposed to be the same over time and for different bots. Can't be used to download or reuse the file.
 * @property fileSize <em>Optional</em>. File size in bytes. It can be bigger than 2^31 and some programming languages may have difficulty/silent defects in interpreting it. But it has at most 52 significant bits, so a signed 64-bit integer or double-precision float type are safe for storing this value.
 * @property filePath <em>Optional</em>. File path. Use <code>https://api.telegram.org/file/bot&lt;token&gt;/&lt;file_path&gt;</code> to get the file.
 *
 * @constructor Creates a [File].
 * */
data class File(
    val fileId: String,
    val fileUniqueId: String,
    val fileSize: Long? = null,
    val filePath: String? = null,
) : TelegramModel()

/**
 * <p>Describes a <a href="/bots/webapps">Web App</a>.</p>
 *
 * @property url An HTTPS URL of a Web App to be opened with additional data as specified in <a href="/bots/webapps#initializing-mini-apps">Initializing Web Apps</a>
 *
 * @constructor Creates a [WebAppInfo].
 * */
data class WebAppInfo(
    val url: String,
) : TelegramModel()

/**
 * <p>This object represents a <a href="/bots/features#keyboards">custom keyboard</a> with reply options (see <a href="/bots/features#keyboards">Introduction to bots</a> for details and examples). Not supported in channels and for messages sent on behalf of a Telegram Business account.</p>
 *
 * @property keyboard Array of button rows, each represented by an Array of <a href="#keyboardbutton">KeyboardButton</a> objects
 * @property isPersistent <em>Optional</em>. Requests clients to always show the keyboard when the regular keyboard is hidden. Defaults to <em>false</em>, in which case the custom keyboard can be hidden and opened with a keyboard icon.
 * @property resizeKeyboard <em>Optional</em>. Requests clients to resize the keyboard vertically for optimal fit (e.g., make the keyboard smaller if there are just two rows of buttons). Defaults to <em>false</em>, in which case the custom keyboard is always of the same height as the app's standard keyboard.
 * @property oneTimeKeyboard <em>Optional</em>. Requests clients to hide the keyboard as soon as it's been used. The keyboard will still be available, but clients will automatically display the usual letter-keyboard in the chat - the user can press a special button in the input field to see the custom keyboard again. Defaults to <em>false</em>.
 * @property inputFieldPlaceholder <em>Optional</em>. The placeholder to be shown in the input field when the keyboard is active; 1-64 characters
 * @property selective <em>Optional</em>. Use this parameter if you want to show the keyboard to specific users only. Targets: 1) users that are @mentioned in the <em>text</em> of the <a href="#message">Message</a> object; 2) if the bot's message is a reply to a message in the same chat and forum topic, sender of the original message.<br><br><em>Example:</em> A user requests to change the bot's language, bot replies to the request with a keyboard to select the new language. Other users in the group don't see the keyboard.
 *
 * @constructor Creates a [ReplyKeyboardMarkup].
 * */
data class ReplyKeyboardMarkup(
    val keyboard: List<List<KeyboardButton>>,
    val isPersistent: Boolean? = null,
    val resizeKeyboard: Boolean? = null,
    val oneTimeKeyboard: Boolean? = null,
    val inputFieldPlaceholder: String? = null,
    val selective: Boolean? = null,
) : KeyboardOption()

/**
 * <p>This object represents one button of the reply keyboard. At most one of the optional fields must be used to specify type of the button. For simple text buttons, <em>String</em> can be used instead of this object to specify the button text.</p><p><strong>Note:</strong> <em>request_users</em> and <em>request_chat</em> options will only work in Telegram versions released after 3 February, 2023. Older clients will display <em>unsupported message</em>.</p>
 *
 * @property text Text of the button. If none of the optional fields are used, it will be sent as a message when the button is pressed
 * @property requestUsers <em>Optional.</em> If specified, pressing the button will open a list of suitable users. Identifiers of selected users will be sent to the bot in a “users_shared” service message. Available in private chats only.
 * @property requestChat <em>Optional.</em> If specified, pressing the button will open a list of suitable chats. Tapping on a chat will send its identifier to the bot in a “chat_shared” service message. Available in private chats only.
 * @property requestContact <em>Optional</em>. If <em>True</em>, the user's phone number will be sent as a contact when the button is pressed. Available in private chats only.
 * @property requestLocation <em>Optional</em>. If <em>True</em>, the user's current location will be sent when the button is pressed. Available in private chats only.
 * @property requestPoll <em>Optional</em>. If specified, the user will be asked to create a poll and send it to the bot when the button is pressed. Available in private chats only.
 * @property webApp <em>Optional</em>. If specified, the described <a href="/bots/webapps">Web App</a> will be launched when the button is pressed. The Web App will be able to send a “web_app_data” service message. Available in private chats only.
 *
 * @constructor Creates a [KeyboardButton].
 * */
data class KeyboardButton(
    val text: String,
    val requestUsers: KeyboardButtonRequestUsers? = null,
    val requestChat: KeyboardButtonRequestChat? = null,
    val requestContact: Boolean? = null,
    val requestLocation: Boolean? = null,
    val requestPoll: KeyboardButtonPollType? = null,
    val webApp: WebAppInfo? = null,
) : TelegramModel()

/**
 * <p>This object defines the criteria used to request suitable users. Information about the selected users will be shared with the bot when the corresponding button is pressed. <a href="/bots/features#chat-and-user-selection">More about requesting users »</a></p>
 *
 * @property requestId Signed 32-bit identifier of the request that will be received back in the <a href="#usersshared">UsersShared</a> object. Must be unique within the message
 * @property userIsBot <em>Optional</em>. Pass <em>True</em> to request bots, pass <em>False</em> to request regular users. If not specified, no additional restrictions are applied.
 * @property userIsPremium <em>Optional</em>. Pass <em>True</em> to request premium users, pass <em>False</em> to request non-premium users. If not specified, no additional restrictions are applied.
 * @property maxQuantity <em>Optional</em>. The maximum number of users to be selected; 1-10. Defaults to 1.
 * @property requestName <em>Optional</em>. Pass <em>True</em> to request the users' first and last names
 * @property requestUsername <em>Optional</em>. Pass <em>True</em> to request the users' usernames
 * @property requestPhoto <em>Optional</em>. Pass <em>True</em> to request the users' photos
 *
 * @constructor Creates a [KeyboardButtonRequestUsers].
 * */
data class KeyboardButtonRequestUsers(
    val requestId: Long,
    val userIsBot: Boolean? = null,
    val userIsPremium: Boolean? = null,
    val maxQuantity: Long? = null,
    val requestName: Boolean? = null,
    val requestUsername: Boolean? = null,
    val requestPhoto: Boolean? = null,
) : TelegramModel()

/**
 * <p>This object defines the criteria used to request a suitable chat. Information about the selected chat will be shared with the bot when the corresponding button is pressed. The bot will be granted requested rights in the chat if appropriate. <a href="/bots/features#chat-and-user-selection">More about requesting chats »</a>.</p>
 *
 * @property requestId Signed 32-bit identifier of the request, which will be received back in the <a href="#chatshared">ChatShared</a> object. Must be unique within the message
 * @property chatIsChannel Pass <em>True</em> to request a channel chat, pass <em>False</em> to request a group or a supergroup chat.
 * @property chatIsForum <em>Optional</em>. Pass <em>True</em> to request a forum supergroup, pass <em>False</em> to request a non-forum chat. If not specified, no additional restrictions are applied.
 * @property chatHasUsername <em>Optional</em>. Pass <em>True</em> to request a supergroup or a channel with a username, pass <em>False</em> to request a chat without a username. If not specified, no additional restrictions are applied.
 * @property chatIsCreated <em>Optional</em>. Pass <em>True</em> to request a chat owned by the user. Otherwise, no additional restrictions are applied.
 * @property userAdministratorRights <em>Optional</em>. A JSON-serialized object listing the required administrator rights of the user in the chat. The rights must be a superset of <em>bot_administrator_rights</em>. If not specified, no additional restrictions are applied.
 * @property botAdministratorRights <em>Optional</em>. A JSON-serialized object listing the required administrator rights of the bot in the chat. The rights must be a subset of <em>user_administrator_rights</em>. If not specified, no additional restrictions are applied.
 * @property botIsMember <em>Optional</em>. Pass <em>True</em> to request a chat with the bot as a member. Otherwise, no additional restrictions are applied.
 * @property requestTitle <em>Optional</em>. Pass <em>True</em> to request the chat's title
 * @property requestUsername <em>Optional</em>. Pass <em>True</em> to request the chat's username
 * @property requestPhoto <em>Optional</em>. Pass <em>True</em> to request the chat's photo
 *
 * @constructor Creates a [KeyboardButtonRequestChat].
 * */
data class KeyboardButtonRequestChat(
    val requestId: Long,
    val chatIsChannel: Boolean,
    val chatIsForum: Boolean? = null,
    val chatHasUsername: Boolean? = null,
    val chatIsCreated: Boolean? = null,
    val userAdministratorRights: ChatAdministratorRights? = null,
    val botAdministratorRights: ChatAdministratorRights? = null,
    val botIsMember: Boolean? = null,
    val requestTitle: Boolean? = null,
    val requestUsername: Boolean? = null,
    val requestPhoto: Boolean? = null,
) : TelegramModel()

/**
 * <p>This object represents type of a poll, which is allowed to be created and sent when the corresponding button is pressed.</p>
 *
 * @property type <em>Optional</em>. If <em>quiz</em> is passed, the user will be allowed to create only polls in the quiz mode. If <em>regular</em> is passed, only regular polls will be allowed. Otherwise, the user will be allowed to create a poll of any type.
 *
 * @constructor Creates a [KeyboardButtonPollType].
 * */
data class KeyboardButtonPollType(
    val type: String? = null,
) : TelegramModel()

/**
 * <p>Upon receiving a message with this object, Telegram clients will remove the current custom keyboard and display the default letter-keyboard. By default, custom keyboards are displayed until a new keyboard is sent by a bot. An exception is made for one-time keyboards that are hidden immediately after the user presses a button (see <a href="#replykeyboardmarkup">ReplyKeyboardMarkup</a>). Not supported in channels and for messages sent on behalf of a Telegram Business account.</p>
 *
 * @property removeKeyboard Requests clients to remove the custom keyboard (user will not be able to summon this keyboard; if you want to hide the keyboard from sight but keep it accessible, use <em>one_time_keyboard</em> in <a href="#replykeyboardmarkup">ReplyKeyboardMarkup</a>)
 * @property selective <em>Optional</em>. Use this parameter if you want to remove the keyboard for specific users only. Targets: 1) users that are @mentioned in the <em>text</em> of the <a href="#message">Message</a> object; 2) if the bot's message is a reply to a message in the same chat and forum topic, sender of the original message.<br><br><em>Example:</em> A user votes in a poll, bot returns confirmation message in reply to the vote and removes the keyboard for that user, while still showing the keyboard with poll options to users who haven't voted yet.
 *
 * @constructor Creates a [ReplyKeyboardRemove].
 * */
data class ReplyKeyboardRemove(
    val removeKeyboard: Boolean,
    val selective: Boolean? = null,
) : KeyboardOption()

/**
 * <p>This object represents an <a href="/bots/features#inline-keyboards">inline keyboard</a> that appears right next to the message it belongs to.</p>
 *
 * @property inlineKeyboard Array of button rows, each represented by an Array of <a href="#inlinekeyboardbutton">InlineKeyboardButton</a> objects
 *
 * @constructor Creates a [InlineKeyboardMarkup].
 * */
data class InlineKeyboardMarkup(
    val inlineKeyboard: List<List<InlineKeyboardButton>>,
) : KeyboardOption()

/**
 * <p>This object represents one button of an inline keyboard. Exactly one of the optional fields must be used to specify type of the button.</p>
 *
 * @property text Label text on the button
 * @property url <em>Optional</em>. HTTP or tg:// URL to be opened when the button is pressed. Links <code>tg://user?id=&lt;user_id&gt;</code> can be used to mention a user by their identifier without using a username, if this is allowed by their privacy settings.
 * @property callbackData <em>Optional</em>. Data to be sent in a <a href="#callbackquery">callback query</a> to the bot when the button is pressed, 1-64 bytes
 * @property webApp <em>Optional</em>. Description of the <a href="/bots/webapps">Web App</a> that will be launched when the user presses the button. The Web App will be able to send an arbitrary message on behalf of the user using the method <a href="#answerwebappquery">answerWebAppQuery</a>. Available only in private chats between a user and the bot. Not supported for messages sent on behalf of a Telegram Business account.
 * @property loginUrl <em>Optional</em>. An HTTPS URL used to automatically authorize the user. Can be used as a replacement for the <a href="/widgets/login">Telegram Login Widget</a>.
 * @property switchInlineQuery <em>Optional</em>. If set, pressing the button will prompt the user to select one of their chats, open that chat and insert the bot's username and the specified inline query in the input field. May be empty, in which case just the bot's username will be inserted. Not supported for messages sent on behalf of a Telegram Business account.
 * @property switchInlineQueryCurrentChat <em>Optional</em>. If set, pressing the button will insert the bot's username and the specified inline query in the current chat's input field. May be empty, in which case only the bot's username will be inserted.<br><br>This offers a quick way for the user to open your bot in inline mode in the same chat - good for selecting something from multiple options. Not supported in channels and for messages sent on behalf of a Telegram Business account.
 * @property switchInlineQueryChosenChat <em>Optional</em>. If set, pressing the button will prompt the user to select one of their chats of the specified type, open that chat and insert the bot's username and the specified inline query in the input field. Not supported for messages sent on behalf of a Telegram Business account.
 * @property copyText <em>Optional</em>. Description of the button that copies the specified text to the clipboard.
 * @property callbackGame <em>Optional</em>. Description of the game that will be launched when the user presses the button.<br><br><strong>NOTE:</strong> This type of button <strong>must</strong> always be the first button in the first row.
 * @property pay <em>Optional</em>. Specify <em>True</em>, to send a <a href="#payments">Pay button</a>. Substrings “<img class="emoji" src="//telegram.org/img/emoji/40/E2AD90.png" width="20" height="20" alt="⭐">” and “XTR” in the buttons's text will be replaced with a Telegram Star icon.<br><br><strong>NOTE:</strong> This type of button <strong>must</strong> always be the first button in the first row and can only be used in invoice messages.
 *
 * @constructor Creates a [InlineKeyboardButton].
 * */
data class InlineKeyboardButton(
    val text: String,
    val url: String? = null,
    val callbackData: String? = null,
    val webApp: WebAppInfo? = null,
    val loginUrl: LoginUrl? = null,
    val switchInlineQuery: String? = null,
    val switchInlineQueryCurrentChat: String? = null,
    val switchInlineQueryChosenChat: SwitchInlineQueryChosenChat? = null,
    val copyText: CopyTextButton? = null,
    val callbackGame: Any? = null,
    val pay: Boolean? = null,
) : TelegramModel()

/**
 * <p>This object represents a parameter of the inline keyboard button used to automatically authorize a user. Serves as a great replacement for the <a href="/widgets/login">Telegram Login Widget</a> when the user is coming from Telegram. All the user needs to do is tap/click a button and confirm that they want to log in:</p><p>Telegram apps support these buttons as of <a href="https://telegram.org/blog/privacy-discussions-web-bots#meet-seamless-web-bots">version 5.7</a>.</p><blockquote>
 *  <p>Sample bot: <a href="https://t.me/discussbot">@discussbot</a></p>
 * </blockquote>
 *
 * @property url An HTTPS URL to be opened with user authorization data added to the query string when the button is pressed. If the user refuses to provide authorization data, the original URL without information about the user will be opened. The data added is the same as described in <a href="/widgets/login#receiving-authorization-data">Receiving authorization data</a>.<br><br><strong>NOTE:</strong> You <strong>must</strong> always check the hash of the received data to verify the authentication and the integrity of the data as described in <a href="/widgets/login#checking-authorization">Checking authorization</a>.
 * @property forwardText <em>Optional</em>. New text of the button in forwarded messages.
 * @property botUsername <em>Optional</em>. Username of a bot, which will be used for user authorization. See <a href="/widgets/login#setting-up-a-bot">Setting up a bot</a> for more details. If not specified, the current bot's username will be assumed. The <em>url</em>'s domain must be the same as the domain linked with the bot. See <a href="/widgets/login#linking-your-domain-to-the-bot">Linking your domain to the bot</a> for more details.
 * @property requestWriteAccess <em>Optional</em>. Pass <em>True</em> to request the permission for your bot to send messages to the user.
 *
 * @constructor Creates a [LoginUrl].
 * */
data class LoginUrl(
    val url: String,
    val forwardText: String? = null,
    val botUsername: String? = null,
    val requestWriteAccess: Boolean? = null,
) : TelegramModel()

/**
 * <p>This object represents an inline button that switches the current user to inline mode in a chosen chat, with an optional default inline query.</p>
 *
 * @property query <em>Optional</em>. The default inline query to be inserted in the input field. If left empty, only the bot's username will be inserted
 * @property allowUserChats <em>Optional</em>. <em>True</em>, if private chats with users can be chosen
 * @property allowBotChats <em>Optional</em>. <em>True</em>, if private chats with bots can be chosen
 * @property allowGroupChats <em>Optional</em>. <em>True</em>, if group and supergroup chats can be chosen
 * @property allowChannelChats <em>Optional</em>. <em>True</em>, if channel chats can be chosen
 *
 * @constructor Creates a [SwitchInlineQueryChosenChat].
 * */
data class SwitchInlineQueryChosenChat(
    val query: String? = null,
    val allowUserChats: Boolean? = null,
    val allowBotChats: Boolean? = null,
    val allowGroupChats: Boolean? = null,
    val allowChannelChats: Boolean? = null,
) : TelegramModel()

/**
 * <p>This object represents an inline keyboard button that copies specified text to the clipboard.</p>
 *
 * @property text The text to be copied to the clipboard; 1-256 characters
 *
 * @constructor Creates a [CopyTextButton].
 * */
data class CopyTextButton(
    val text: String,
) : TelegramModel()

/**
 * <p>This object represents an incoming callback query from a callback button in an <a href="/bots/features#inline-keyboards">inline keyboard</a>. If the button that originated the query was attached to a message sent by the bot, the field <em>message</em> will be present. If the button was attached to a message sent via the bot (in <a href="#inline-mode">inline mode</a>), the field <em>inline_message_id</em> will be present. Exactly one of the fields <em>data</em> or <em>game_short_name</em> will be present.</p><blockquote>
 *  <p><strong>NOTE:</strong> After the user presses a callback button, Telegram clients will display a progress bar until you call <a href="#answercallbackquery">answerCallbackQuery</a>. It is, therefore, necessary to react by calling <a href="#answercallbackquery">answerCallbackQuery</a> even if no notification to the user is needed (e.g., without specifying any of the optional parameters).</p>
 * </blockquote>
 *
 * @property id Unique identifier for this query
 * @property from Sender
 * @property message <em>Optional</em>. Message sent by the bot with the callback button that originated the query
 * @property inlineMessageId <em>Optional</em>. Identifier of the message sent via the bot in inline mode, that originated the query.
 * @property chatInstance Global identifier, uniquely corresponding to the chat to which the message with the callback button was sent. Useful for high scores in <a href="#games">games</a>.
 * @property data <em>Optional</em>. Data associated with the callback button. Be aware that the message originated the query can contain no callback buttons with this data.
 * @property gameShortName <em>Optional</em>. Short name of a <a href="#games">Game</a> to be returned, serves as the unique identifier for the game
 *
 * @constructor Creates a [CallbackQuery].
 * */
data class CallbackQuery(
    val id: String,
    val from: User,
    val message: MaybeInaccessibleMessage? = null,
    val inlineMessageId: String? = null,
    val chatInstance: String,
    val data: String? = null,
    val gameShortName: String? = null,
) : TelegramModel()

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
 * @property forceReply Shows reply interface to the user, as if they manually selected the bot's message and tapped 'Reply'
 * @property inputFieldPlaceholder <em>Optional</em>. The placeholder to be shown in the input field when the reply is active; 1-64 characters
 * @property selective <em>Optional</em>. Use this parameter if you want to force reply from specific users only. Targets: 1) users that are @mentioned in the <em>text</em> of the <a href="#message">Message</a> object; 2) if the bot's message is a reply to a message in the same chat and forum topic, sender of the original message.
 *
 * @constructor Creates a [ForceReply].
 * */
data class ForceReply(
    val forceReply: Boolean,
    val inputFieldPlaceholder: String? = null,
    val selective: Boolean? = null,
) : KeyboardOption()

/**
 * <p>This object represents a chat photo.</p>
 *
 * @property smallFileId File identifier of small (160x160) chat photo. This file_id can be used only for photo download and only for as long as the photo is not changed.
 * @property smallFileUniqueId Unique file identifier of small (160x160) chat photo, which is supposed to be the same over time and for different bots. Can't be used to download or reuse the file.
 * @property bigFileId File identifier of big (640x640) chat photo. This file_id can be used only for photo download and only for as long as the photo is not changed.
 * @property bigFileUniqueId Unique file identifier of big (640x640) chat photo, which is supposed to be the same over time and for different bots. Can't be used to download or reuse the file.
 *
 * @constructor Creates a [ChatPhoto].
 * */
data class ChatPhoto(
    val smallFileId: String,
    val smallFileUniqueId: String,
    val bigFileId: String,
    val bigFileUniqueId: String,
) : TelegramModel()

/**
 * <p>Represents an invite link for a chat.</p>
 *
 * @property inviteLink The invite link. If the link was created by another chat administrator, then the second part of the link will be replaced with “…”.
 * @property creator Creator of the link
 * @property createsJoinRequest <em>True</em>, if users joining the chat via the link need to be approved by chat administrators
 * @property isPrimary <em>True</em>, if the link is primary
 * @property isRevoked <em>True</em>, if the link is revoked
 * @property name <em>Optional</em>. Invite link name
 * @property expireDate <em>Optional</em>. Point in time (Unix timestamp) when the link will expire or has been expired
 * @property memberLimit <em>Optional</em>. The maximum number of users that can be members of the chat simultaneously after joining the chat via this invite link; 1-99999
 * @property pendingJoinRequestCount <em>Optional</em>. Number of pending join requests created using this link
 * @property subscriptionPeriod <em>Optional</em>. The number of seconds the subscription will be active for before the next payment
 * @property subscriptionPrice <em>Optional</em>. The amount of Telegram Stars a user must pay initially and after each subsequent subscription period to be a member of the chat using the link
 *
 * @constructor Creates a [ChatInviteLink].
 * */
data class ChatInviteLink(
    val inviteLink: String,
    val creator: User,
    val createsJoinRequest: Boolean,
    val isPrimary: Boolean,
    val isRevoked: Boolean,
    val name: String? = null,
    val expireDate: Long? = null,
    val memberLimit: Long? = null,
    val pendingJoinRequestCount: Long? = null,
    val subscriptionPeriod: Long? = null,
    val subscriptionPrice: Long? = null,
) : TelegramModel()

/**
 * <p>Represents the rights of an administrator in a chat.</p>
 *
 * @property isAnonymous <em>True</em>, if the user's presence in the chat is hidden
 * @property canManageChat <em>True</em>, if the administrator can access the chat event log, get boost list, see hidden supergroup and channel members, report spam messages, ignore slow mode, and send messages to the chat without paying Telegram Stars. Implied by any other administrator privilege.
 * @property canDeleteMessages <em>True</em>, if the administrator can delete messages of other users
 * @property canManageVideoChats <em>True</em>, if the administrator can manage video chats
 * @property canRestrictMembers <em>True</em>, if the administrator can restrict, ban or unban chat members, or access supergroup statistics
 * @property canPromoteMembers <em>True</em>, if the administrator can add new administrators with a subset of their own privileges or demote administrators that they have promoted, directly or indirectly (promoted by administrators that were appointed by the user)
 * @property canChangeInfo <em>True</em>, if the user is allowed to change the chat title, photo and other settings
 * @property canInviteUsers <em>True</em>, if the user is allowed to invite new users to the chat
 * @property canPostStories <em>True</em>, if the administrator can post stories to the chat
 * @property canEditStories <em>True</em>, if the administrator can edit stories posted by other users, post stories to the chat page, pin chat stories, and access the chat's story archive
 * @property canDeleteStories <em>True</em>, if the administrator can delete stories posted by other users
 * @property canPostMessages <em>Optional</em>. <em>True</em>, if the administrator can post messages in the channel, approve suggested posts, or access channel statistics; for channels only
 * @property canEditMessages <em>Optional</em>. <em>True</em>, if the administrator can edit messages of other users and can pin messages; for channels only
 * @property canPinMessages <em>Optional</em>. <em>True</em>, if the user is allowed to pin messages; for groups and supergroups only
 * @property canManageTopics <em>Optional</em>. <em>True</em>, if the user is allowed to create, rename, close, and reopen forum topics; for supergroups only
 *
 * @constructor Creates a [ChatAdministratorRights].
 * */
data class ChatAdministratorRights(
    val isAnonymous: Boolean,
    val canManageChat: Boolean,
    val canDeleteMessages: Boolean,
    val canManageVideoChats: Boolean,
    val canRestrictMembers: Boolean,
    val canPromoteMembers: Boolean,
    val canChangeInfo: Boolean,
    val canInviteUsers: Boolean,
    val canPostStories: Boolean,
    val canEditStories: Boolean,
    val canDeleteStories: Boolean,
    val canPostMessages: Boolean? = null,
    val canEditMessages: Boolean? = null,
    val canPinMessages: Boolean? = null,
    val canManageTopics: Boolean? = null,
) : TelegramModel()

/**
 * <p>This object represents changes in the status of a chat member.</p>
 *
 * @property chat Chat the user belongs to
 * @property from Performer of the action, which resulted in the change
 * @property date Date the change was done in Unix time
 * @property oldChatMember Previous information about the chat member
 * @property newChatMember New information about the chat member
 * @property inviteLink <em>Optional</em>. Chat invite link, which was used by the user to join the chat; for joining by invite link events only.
 * @property viaJoinRequest <em>Optional</em>. <em>True</em>, if the user joined the chat after sending a direct join request without using an invite link and being approved by an administrator
 * @property viaChatFolderInviteLink <em>Optional</em>. <em>True</em>, if the user joined the chat via a chat folder invite link
 *
 * @constructor Creates a [ChatMemberUpdated].
 * */
data class ChatMemberUpdated(
    val chat: Chat,
    val from: User,
    val date: Long,
    val oldChatMember: ChatMember,
    val newChatMember: ChatMember,
    val inviteLink: ChatInviteLink? = null,
    val viaJoinRequest: Boolean? = null,
    val viaChatFolderInviteLink: Boolean? = null,
) : TelegramModel()

/**
 * <p>Represents a <a href="#chatmember">chat member</a> that owns the chat and has all administrator privileges.</p>
 *
 * @property status The member's status in the chat, always “creator”
 * @property user Information about the user
 * @property isAnonymous <em>True</em>, if the user's presence in the chat is hidden
 * @property customTitle <em>Optional</em>. Custom title for this user
 *
 * @constructor Creates a [ChatMemberOwner].
 * */
data class ChatMemberOwner(
    val status: String,
    val user: User,
    val isAnonymous: Boolean,
    val customTitle: String? = null,
) : ChatMember()

/**
 * <p>Represents a <a href="#chatmember">chat member</a> that has some additional privileges.</p>
 *
 * @property status The member's status in the chat, always “administrator”
 * @property user Information about the user
 * @property canBeEdited <em>True</em>, if the bot is allowed to edit administrator privileges of that user
 * @property isAnonymous <em>True</em>, if the user's presence in the chat is hidden
 * @property canManageChat <em>True</em>, if the administrator can access the chat event log, get boost list, see hidden supergroup and channel members, report spam messages, ignore slow mode, and send messages to the chat without paying Telegram Stars. Implied by any other administrator privilege.
 * @property canDeleteMessages <em>True</em>, if the administrator can delete messages of other users
 * @property canManageVideoChats <em>True</em>, if the administrator can manage video chats
 * @property canRestrictMembers <em>True</em>, if the administrator can restrict, ban or unban chat members, or access supergroup statistics
 * @property canPromoteMembers <em>True</em>, if the administrator can add new administrators with a subset of their own privileges or demote administrators that they have promoted, directly or indirectly (promoted by administrators that were appointed by the user)
 * @property canChangeInfo <em>True</em>, if the user is allowed to change the chat title, photo and other settings
 * @property canInviteUsers <em>True</em>, if the user is allowed to invite new users to the chat
 * @property canPostStories <em>True</em>, if the administrator can post stories to the chat
 * @property canEditStories <em>True</em>, if the administrator can edit stories posted by other users, post stories to the chat page, pin chat stories, and access the chat's story archive
 * @property canDeleteStories <em>True</em>, if the administrator can delete stories posted by other users
 * @property canPostMessages <em>Optional</em>. <em>True</em>, if the administrator can post messages in the channel, approve suggested posts, or access channel statistics; for channels only
 * @property canEditMessages <em>Optional</em>. <em>True</em>, if the administrator can edit messages of other users and can pin messages; for channels only
 * @property canPinMessages <em>Optional</em>. <em>True</em>, if the user is allowed to pin messages; for groups and supergroups only
 * @property canManageTopics <em>Optional</em>. <em>True</em>, if the user is allowed to create, rename, close, and reopen forum topics; for supergroups only
 * @property customTitle <em>Optional</em>. Custom title for this user
 *
 * @constructor Creates a [ChatMemberAdministrator].
 * */
data class ChatMemberAdministrator(
    val status: String,
    val user: User,
    val canBeEdited: Boolean,
    val isAnonymous: Boolean,
    val canManageChat: Boolean,
    val canDeleteMessages: Boolean,
    val canManageVideoChats: Boolean,
    val canRestrictMembers: Boolean,
    val canPromoteMembers: Boolean,
    val canChangeInfo: Boolean,
    val canInviteUsers: Boolean,
    val canPostStories: Boolean,
    val canEditStories: Boolean,
    val canDeleteStories: Boolean,
    val canPostMessages: Boolean? = null,
    val canEditMessages: Boolean? = null,
    val canPinMessages: Boolean? = null,
    val canManageTopics: Boolean? = null,
    val customTitle: String? = null,
) : ChatMember()

/**
 * <p>Represents a <a href="#chatmember">chat member</a> that has no additional privileges or restrictions.</p>
 *
 * @property status The member's status in the chat, always “member”
 * @property user Information about the user
 * @property untilDate <em>Optional</em>. Date when the user's subscription will expire; Unix time
 *
 * @constructor Creates a [ChatMemberMember].
 * */
data class ChatMemberMember(
    val status: String,
    val user: User,
    val untilDate: Long? = null,
) : ChatMember()

/**
 * <p>Represents a <a href="#chatmember">chat member</a> that is under certain restrictions in the chat. Supergroups only.</p>
 *
 * @property status The member's status in the chat, always “restricted”
 * @property user Information about the user
 * @property isMember <em>True</em>, if the user is a member of the chat at the moment of the request
 * @property canSendMessages <em>True</em>, if the user is allowed to send text messages, contacts, giveaways, giveaway winners, invoices, locations and venues
 * @property canSendAudios <em>True</em>, if the user is allowed to send audios
 * @property canSendDocuments <em>True</em>, if the user is allowed to send documents
 * @property canSendPhotos <em>True</em>, if the user is allowed to send photos
 * @property canSendVideos <em>True</em>, if the user is allowed to send videos
 * @property canSendVideoNotes <em>True</em>, if the user is allowed to send video notes
 * @property canSendVoiceNotes <em>True</em>, if the user is allowed to send voice notes
 * @property canSendPolls <em>True</em>, if the user is allowed to send polls and checklists
 * @property canSendOtherMessages <em>True</em>, if the user is allowed to send animations, games, stickers and use inline bots
 * @property canAddWebPagePreviews <em>True</em>, if the user is allowed to add web page previews to their messages
 * @property canChangeInfo <em>True</em>, if the user is allowed to change the chat title, photo and other settings
 * @property canInviteUsers <em>True</em>, if the user is allowed to invite new users to the chat
 * @property canPinMessages <em>True</em>, if the user is allowed to pin messages
 * @property canManageTopics <em>True</em>, if the user is allowed to create forum topics
 * @property untilDate Date when restrictions will be lifted for this user; Unix time. If 0, then the user is restricted forever
 *
 * @constructor Creates a [ChatMemberRestricted].
 * */
data class ChatMemberRestricted(
    val status: String,
    val user: User,
    val isMember: Boolean,
    val canSendMessages: Boolean,
    val canSendAudios: Boolean,
    val canSendDocuments: Boolean,
    val canSendPhotos: Boolean,
    val canSendVideos: Boolean,
    val canSendVideoNotes: Boolean,
    val canSendVoiceNotes: Boolean,
    val canSendPolls: Boolean,
    val canSendOtherMessages: Boolean,
    val canAddWebPagePreviews: Boolean,
    val canChangeInfo: Boolean,
    val canInviteUsers: Boolean,
    val canPinMessages: Boolean,
    val canManageTopics: Boolean,
    val untilDate: Long,
) : ChatMember()

/**
 * <p>Represents a <a href="#chatmember">chat member</a> that isn't currently a member of the chat, but may join it themselves.</p>
 *
 * @property status The member's status in the chat, always “left”
 * @property user Information about the user
 *
 * @constructor Creates a [ChatMemberLeft].
 * */
data class ChatMemberLeft(
    val status: String,
    val user: User,
) : ChatMember()

/**
 * <p>Represents a <a href="#chatmember">chat member</a> that was banned in the chat and can't return to the chat or view chat messages.</p>
 *
 * @property status The member's status in the chat, always “kicked”
 * @property user Information about the user
 * @property untilDate Date when restrictions will be lifted for this user; Unix time. If 0, then the user is banned forever
 *
 * @constructor Creates a [ChatMemberBanned].
 * */
data class ChatMemberBanned(
    val status: String,
    val user: User,
    val untilDate: Long,
) : ChatMember()

/**
 * <p>Represents a join request sent to a chat.</p>
 *
 * @property chat Chat to which the request was sent
 * @property from User that sent the join request
 * @property userChatId Identifier of a private chat with the user who sent the join request. This number may have more than 32 significant bits and some programming languages may have difficulty/silent defects in interpreting it. But it has at most 52 significant bits, so a 64-bit integer or double-precision float type are safe for storing this identifier. The bot can use this identifier for 5 minutes to send messages until the join request is processed, assuming no other administrator contacted the user.
 * @property date Date the request was sent in Unix time
 * @property bio <em>Optional</em>. Bio of the user.
 * @property inviteLink <em>Optional</em>. Chat invite link that was used by the user to send the join request
 *
 * @constructor Creates a [ChatJoinRequest].
 * */
data class ChatJoinRequest(
    val chat: Chat,
    val from: User,
    val userChatId: Long,
    val date: Long,
    val bio: String? = null,
    val inviteLink: ChatInviteLink? = null,
) : TelegramModel()

/**
 * <p>Describes actions that a non-administrator user is allowed to take in a chat.</p>
 *
 * @property canSendMessages <em>Optional</em>. <em>True</em>, if the user is allowed to send text messages, contacts, giveaways, giveaway winners, invoices, locations and venues
 * @property canSendAudios <em>Optional</em>. <em>True</em>, if the user is allowed to send audios
 * @property canSendDocuments <em>Optional</em>. <em>True</em>, if the user is allowed to send documents
 * @property canSendPhotos <em>Optional</em>. <em>True</em>, if the user is allowed to send photos
 * @property canSendVideos <em>Optional</em>. <em>True</em>, if the user is allowed to send videos
 * @property canSendVideoNotes <em>Optional</em>. <em>True</em>, if the user is allowed to send video notes
 * @property canSendVoiceNotes <em>Optional</em>. <em>True</em>, if the user is allowed to send voice notes
 * @property canSendPolls <em>Optional</em>. <em>True</em>, if the user is allowed to send polls and checklists
 * @property canSendOtherMessages <em>Optional</em>. <em>True</em>, if the user is allowed to send animations, games, stickers and use inline bots
 * @property canAddWebPagePreviews <em>Optional</em>. <em>True</em>, if the user is allowed to add web page previews to their messages
 * @property canChangeInfo <em>Optional</em>. <em>True</em>, if the user is allowed to change the chat title, photo and other settings. Ignored in public supergroups
 * @property canInviteUsers <em>Optional</em>. <em>True</em>, if the user is allowed to invite new users to the chat
 * @property canPinMessages <em>Optional</em>. <em>True</em>, if the user is allowed to pin messages. Ignored in public supergroups
 * @property canManageTopics <em>Optional</em>. <em>True</em>, if the user is allowed to create forum topics. If omitted defaults to the value of can_pin_messages
 *
 * @constructor Creates a [ChatPermissions].
 * */
data class ChatPermissions(
    val canSendMessages: Boolean? = null,
    val canSendAudios: Boolean? = null,
    val canSendDocuments: Boolean? = null,
    val canSendPhotos: Boolean? = null,
    val canSendVideos: Boolean? = null,
    val canSendVideoNotes: Boolean? = null,
    val canSendVoiceNotes: Boolean? = null,
    val canSendPolls: Boolean? = null,
    val canSendOtherMessages: Boolean? = null,
    val canAddWebPagePreviews: Boolean? = null,
    val canChangeInfo: Boolean? = null,
    val canInviteUsers: Boolean? = null,
    val canPinMessages: Boolean? = null,
    val canManageTopics: Boolean? = null,
) : TelegramModel()

/**
 * <p>Describes the birthdate of a user.</p>
 *
 * @property day Day of the user's birth; 1-31
 * @property month Month of the user's birth; 1-12
 * @property year <em>Optional</em>. Year of the user's birth
 *
 * @constructor Creates a [Birthdate].
 * */
data class Birthdate(
    val day: Long,
    val month: Long,
    val year: Long? = null,
) : TelegramModel()

/**
 * <p>Contains information about the start page settings of a Telegram Business account.</p>
 *
 * @property title <em>Optional</em>. Title text of the business intro
 * @property message <em>Optional</em>. Message text of the business intro
 * @property sticker <em>Optional</em>. Sticker of the business intro
 *
 * @constructor Creates a [BusinessIntro].
 * */
data class BusinessIntro(
    val title: String? = null,
    val message: String? = null,
    val sticker: Sticker? = null,
) : TelegramModel()

/**
 * <p>Contains information about the location of a Telegram Business account.</p>
 *
 * @property address Address of the business
 * @property location <em>Optional</em>. Location of the business
 *
 * @constructor Creates a [BusinessLocation].
 * */
data class BusinessLocation(
    val address: String,
    val location: Location? = null,
) : TelegramModel()

/**
 * <p>Describes an interval of time during which a business is open.</p>
 *
 * @property openingMinute The minute's sequence number in a week, starting on Monday, marking the start of the time interval during which the business is open; 0 - 7 * 24 * 60
 * @property closingMinute The minute's sequence number in a week, starting on Monday, marking the end of the time interval during which the business is open; 0 - 8 * 24 * 60
 *
 * @constructor Creates a [BusinessOpeningHoursInterval].
 * */
data class BusinessOpeningHoursInterval(
    val openingMinute: Long,
    val closingMinute: Long,
) : TelegramModel()

/**
 * <p>Describes the opening hours of a business.</p>
 *
 * @property timeZoneName Unique name of the time zone for which the opening hours are defined
 * @property openingHours List of time intervals describing business opening hours
 *
 * @constructor Creates a [BusinessOpeningHours].
 * */
data class BusinessOpeningHours(
    val timeZoneName: String,
    val openingHours: List<BusinessOpeningHoursInterval>,
) : TelegramModel()

/**
 * <p>Describes the position of a clickable area within a story.</p>
 *
 * @property xPercentage The abscissa of the area's center, as a percentage of the media width
 * @property yPercentage The ordinate of the area's center, as a percentage of the media height
 * @property widthPercentage The width of the area's rectangle, as a percentage of the media width
 * @property heightPercentage The height of the area's rectangle, as a percentage of the media height
 * @property rotationAngle The clockwise rotation angle of the rectangle, in degrees; 0-360
 * @property cornerRadiusPercentage The radius of the rectangle corner rounding, as a percentage of the media width
 *
 * @constructor Creates a [StoryAreaPosition].
 * */
data class StoryAreaPosition(
    val xPercentage: Float,
    val yPercentage: Float,
    val widthPercentage: Float,
    val heightPercentage: Float,
    val rotationAngle: Float,
    val cornerRadiusPercentage: Float,
) : TelegramModel()

/**
 * <p>Describes the physical address of a location.</p>
 *
 * @property countryCode The two-letter ISO 3166-1 alpha-2 country code of the country where the location is located
 * @property state <em>Optional</em>. State of the location
 * @property city <em>Optional</em>. City of the location
 * @property street <em>Optional</em>. Street address of the location
 *
 * @constructor Creates a [LocationAddress].
 * */
data class LocationAddress(
    val countryCode: String,
    val state: String? = null,
    val city: String? = null,
    val street: String? = null,
) : TelegramModel()

/**
 * <p>Describes a story area pointing to a location. Currently, a story can have up to 10 location areas.</p>
 *
 * @property type Type of the area, always “location”
 * @property latitude Location latitude in degrees
 * @property longitude Location longitude in degrees
 * @property address <em>Optional</em>. Address of the location
 *
 * @constructor Creates a [StoryAreaTypeLocation].
 * */
data class StoryAreaTypeLocation(
    val type: String,
    val latitude: Float,
    val longitude: Float,
    val address: LocationAddress? = null,
) : StoryAreaType()

/**
 * <p>Describes a story area pointing to a suggested reaction. Currently, a story can have up to 5 suggested reaction areas.</p>
 *
 * @property type Type of the area, always “suggested_reaction”
 * @property reactionType Type of the reaction
 * @property isDark <em>Optional</em>. Pass <em>True</em> if the reaction area has a dark background
 * @property isFlipped <em>Optional</em>. Pass <em>True</em> if reaction area corner is flipped
 *
 * @constructor Creates a [StoryAreaTypeSuggestedReaction].
 * */
data class StoryAreaTypeSuggestedReaction(
    val type: String,
    val reactionType: ReactionType,
    val isDark: Boolean? = null,
    val isFlipped: Boolean? = null,
) : StoryAreaType()

/**
 * <p>Describes a story area pointing to an HTTP or tg:// link. Currently, a story can have up to 3 link areas.</p>
 *
 * @property type Type of the area, always “link”
 * @property url HTTP or tg:// URL to be opened when the area is clicked
 *
 * @constructor Creates a [StoryAreaTypeLink].
 * */
data class StoryAreaTypeLink(
    val type: String,
    val url: String,
) : StoryAreaType()

/**
 * <p>Describes a story area containing weather information. Currently, a story can have up to 3 weather areas.</p>
 *
 * @property type Type of the area, always “weather”
 * @property temperature Temperature, in degree Celsius
 * @property emoji Emoji representing the weather
 * @property backgroundColor A color of the area background in the ARGB format
 *
 * @constructor Creates a [StoryAreaTypeWeather].
 * */
data class StoryAreaTypeWeather(
    val type: String,
    val temperature: Float,
    val emoji: String,
    val backgroundColor: Long,
) : StoryAreaType()

/**
 * <p>Describes a story area pointing to a unique gift. Currently, a story can have at most 1 unique gift area.</p>
 *
 * @property type Type of the area, always “unique_gift”
 * @property name Unique name of the gift
 *
 * @constructor Creates a [StoryAreaTypeUniqueGift].
 * */
data class StoryAreaTypeUniqueGift(
    val type: String,
    val name: String,
) : StoryAreaType()

/**
 * <p>Describes a clickable area on a story media.</p>
 *
 * @property position Position of the area
 * @property type Type of the area
 *
 * @constructor Creates a [StoryArea].
 * */
data class StoryArea(
    val position: StoryAreaPosition,
    val type: StoryAreaType,
) : TelegramModel()

/**
 * <p>Represents a location to which a chat is connected.</p>
 *
 * @property location The location to which the supergroup is connected. Can't be a live location.
 * @property address Location address; 1-64 characters, as defined by the chat owner
 *
 * @constructor Creates a [ChatLocation].
 * */
data class ChatLocation(
    val location: Location,
    val address: String,
) : TelegramModel()

/**
 * <p>The reaction is based on an emoji.</p>
 *
 * @property type Type of the reaction, always “emoji”
 * @property emoji Reaction emoji. Currently, it can be one of "<img class="emoji" src="//telegram.org/img/emoji/40/E29DA4.png" width="20" height="20" alt="❤">", "<img class="emoji" src="//telegram.org/img/emoji/40/F09F918D.png" width="20" height="20" alt="👍">", "<img class="emoji" src="//telegram.org/img/emoji/40/F09F918E.png" width="20" height="20" alt="👎">", "<img class="emoji" src="//telegram.org/img/emoji/40/F09F94A5.png" width="20" height="20" alt="🔥">", "<img class="emoji" src="//telegram.org/img/emoji/40/F09FA5B0.png" width="20" height="20" alt="🥰">", "<img class="emoji" src="//telegram.org/img/emoji/40/F09F918F.png" width="20" height="20" alt="👏">", "<img class="emoji" src="//telegram.org/img/emoji/40/F09F9881.png" width="20" height="20" alt="😁">", "<img class="emoji" src="//telegram.org/img/emoji/40/F09FA494.png" width="20" height="20" alt="🤔">", "<img class="emoji" src="//telegram.org/img/emoji/40/F09FA4AF.png" width="20" height="20" alt="🤯">", "<img class="emoji" src="//telegram.org/img/emoji/40/F09F98B1.png" width="20" height="20" alt="😱">", "<img class="emoji" src="//telegram.org/img/emoji/40/F09FA4AC.png" width="20" height="20" alt="🤬">", "<img class="emoji" src="//telegram.org/img/emoji/40/F09F98A2.png" width="20" height="20" alt="😢">", "<img class="emoji" src="//telegram.org/img/emoji/40/F09F8E89.png" width="20" height="20" alt="🎉">", "<img class="emoji" src="//telegram.org/img/emoji/40/F09FA4A9.png" width="20" height="20" alt="🤩">", "<img class="emoji" src="//telegram.org/img/emoji/40/F09FA4AE.png" width="20" height="20" alt="🤮">", "<img class="emoji" src="//telegram.org/img/emoji/40/F09F92A9.png" width="20" height="20" alt="💩">", "<img class="emoji" src="//telegram.org/img/emoji/40/F09F998F.png" width="20" height="20" alt="🙏">", "<img class="emoji" src="//telegram.org/img/emoji/40/F09F918C.png" width="20" height="20" alt="👌">", "<img class="emoji" src="//telegram.org/img/emoji/40/F09F958A.png" width="20" height="20" alt="🕊">", "<img class="emoji" src="//telegram.org/img/emoji/40/F09FA4A1.png" width="20" height="20" alt="🤡">", "<img class="emoji" src="//telegram.org/img/emoji/40/F09FA5B1.png" width="20" height="20" alt="🥱">", "<img class="emoji" src="//telegram.org/img/emoji/40/F09FA5B4.png" width="20" height="20" alt="🥴">", "<img class="emoji" src="//telegram.org/img/emoji/40/F09F988D.png" width="20" height="20" alt="😍">", "<img class="emoji" src="//telegram.org/img/emoji/40/F09F90B3.png" width="20" height="20" alt="🐳">", "<img class="emoji" src="//telegram.org/img/emoji/40/E29DA4E2808DF09F94A5.png" width="20" height="20" alt="❤‍🔥">", "<img class="emoji" src="//telegram.org/img/emoji/40/F09F8C9A.png" width="20" height="20" alt="🌚">", "<img class="emoji" src="//telegram.org/img/emoji/40/F09F8CAD.png" width="20" height="20" alt="🌭">", "<img class="emoji" src="//telegram.org/img/emoji/40/F09F92AF.png" width="20" height="20" alt="💯">", "<img class="emoji" src="//telegram.org/img/emoji/40/F09FA4A3.png" width="20" height="20" alt="🤣">", "<img class="emoji" src="//telegram.org/img/emoji/40/E29AA1.png" width="20" height="20" alt="⚡">", "<img class="emoji" src="//telegram.org/img/emoji/40/F09F8D8C.png" width="20" height="20" alt="🍌">", "<img class="emoji" src="//telegram.org/img/emoji/40/F09F8F86.png" width="20" height="20" alt="🏆">", "<img class="emoji" src="//telegram.org/img/emoji/40/F09F9294.png" width="20" height="20" alt="💔">", "<img class="emoji" src="//telegram.org/img/emoji/40/F09FA4A8.png" width="20" height="20" alt="🤨">", "<img class="emoji" src="//telegram.org/img/emoji/40/F09F9890.png" width="20" height="20" alt="😐">", "<img class="emoji" src="//telegram.org/img/emoji/40/F09F8D93.png" width="20" height="20" alt="🍓">", "<img class="emoji" src="//telegram.org/img/emoji/40/F09F8DBE.png" width="20" height="20" alt="🍾">", "<img class="emoji" src="//telegram.org/img/emoji/40/F09F928B.png" width="20" height="20" alt="💋">", "<img class="emoji" src="//telegram.org/img/emoji/40/F09F9695.png" width="20" height="20" alt="🖕">", "<img class="emoji" src="//telegram.org/img/emoji/40/F09F9888.png" width="20" height="20" alt="😈">", "<img class="emoji" src="//telegram.org/img/emoji/40/F09F98B4.png" width="20" height="20" alt="😴">", "<img class="emoji" src="//telegram.org/img/emoji/40/F09F98AD.png" width="20" height="20" alt="😭">", "<img class="emoji" src="//telegram.org/img/emoji/40/F09FA493.png" width="20" height="20" alt="🤓">", "<img class="emoji" src="//telegram.org/img/emoji/40/F09F91BB.png" width="20" height="20" alt="👻">", "<img class="emoji" src="//telegram.org/img/emoji/40/F09F91A8E2808DF09F92BB.png" width="20" height="20" alt="👨‍💻">", "<img class="emoji" src="//telegram.org/img/emoji/40/F09F9180.png" width="20" height="20" alt="👀">", "<img class="emoji" src="//telegram.org/img/emoji/40/F09F8E83.png" width="20" height="20" alt="🎃">", "<img class="emoji" src="//telegram.org/img/emoji/40/F09F9988.png" width="20" height="20" alt="🙈">", "<img class="emoji" src="//telegram.org/img/emoji/40/F09F9887.png" width="20" height="20" alt="😇">", "<img class="emoji" src="//telegram.org/img/emoji/40/F09F98A8.png" width="20" height="20" alt="😨">", "<img class="emoji" src="//telegram.org/img/emoji/40/F09FA49D.png" width="20" height="20" alt="🤝">", "<img class="emoji" src="//telegram.org/img/emoji/40/E29C8D.png" width="20" height="20" alt="✍">", "<img class="emoji" src="//telegram.org/img/emoji/40/F09FA497.png" width="20" height="20" alt="🤗">", "<img class="emoji" src="//telegram.org/img/emoji/40/F09FABA1.png" width="20" height="20" alt="🫡">", "<img class="emoji" src="//telegram.org/img/emoji/40/F09F8E85.png" width="20" height="20" alt="🎅">", "<img class="emoji" src="//telegram.org/img/emoji/40/F09F8E84.png" width="20" height="20" alt="🎄">", "<img class="emoji" src="//telegram.org/img/emoji/40/E29883.png" width="20" height="20" alt="☃">", "<img class="emoji" src="//telegram.org/img/emoji/40/F09F9285.png" width="20" height="20" alt="💅">", "<img class="emoji" src="//telegram.org/img/emoji/40/F09FA4AA.png" width="20" height="20" alt="🤪">", "<img class="emoji" src="//telegram.org/img/emoji/40/F09F97BF.png" width="20" height="20" alt="🗿">", "<img class="emoji" src="//telegram.org/img/emoji/40/F09F8692.png" width="20" height="20" alt="🆒">", "<img class="emoji" src="//telegram.org/img/emoji/40/F09F9298.png" width="20" height="20" alt="💘">", "<img class="emoji" src="//telegram.org/img/emoji/40/F09F9989.png" width="20" height="20" alt="🙉">", "<img class="emoji" src="//telegram.org/img/emoji/40/F09FA684.png" width="20" height="20" alt="🦄">", "<img class="emoji" src="//telegram.org/img/emoji/40/F09F9898.png" width="20" height="20" alt="😘">", "<img class="emoji" src="//telegram.org/img/emoji/40/F09F928A.png" width="20" height="20" alt="💊">", "<img class="emoji" src="//telegram.org/img/emoji/40/F09F998A.png" width="20" height="20" alt="🙊">", "<img class="emoji" src="//telegram.org/img/emoji/40/F09F988E.png" width="20" height="20" alt="😎">", "<img class="emoji" src="//telegram.org/img/emoji/40/F09F91BE.png" width="20" height="20" alt="👾">", "<img class="emoji" src="//telegram.org/img/emoji/40/F09FA4B7E2808DE29982.png" width="20" height="20" alt="🤷‍♂">", "<img class="emoji" src="//telegram.org/img/emoji/40/F09FA4B7.png" width="20" height="20" alt="🤷">", "<img class="emoji" src="//telegram.org/img/emoji/40/F09FA4B7E2808DE29980.png" width="20" height="20" alt="🤷‍♀">", "<img class="emoji" src="//telegram.org/img/emoji/40/F09F98A1.png" width="20" height="20" alt="😡">"
 *
 * @constructor Creates a [ReactionTypeEmoji].
 * */
data class ReactionTypeEmoji(
    val type: String,
    val emoji: String,
) : ReactionType()

/**
 * <p>The reaction is based on a custom emoji.</p>
 *
 * @property type Type of the reaction, always “custom_emoji”
 * @property customEmojiId Custom emoji identifier
 *
 * @constructor Creates a [ReactionTypeCustomEmoji].
 * */
data class ReactionTypeCustomEmoji(
    val type: String,
    val customEmojiId: String,
) : ReactionType()

/**
 * <p>The reaction is paid.</p>
 *
 * @property type Type of the reaction, always “paid”
 *
 * @constructor Creates a [ReactionTypePaid].
 * */
data class ReactionTypePaid(
    val type: String,
) : ReactionType()

/**
 * <p>Represents a reaction added to a message along with the number of times it was added.</p>
 *
 * @property type Type of the reaction
 * @property totalCount Number of times the reaction was added
 *
 * @constructor Creates a [ReactionCount].
 * */
data class ReactionCount(
    val type: ReactionType,
    val totalCount: Long,
) : TelegramModel()

/**
 * <p>This object represents a change of a reaction on a message performed by a user.</p>
 *
 * @property chat The chat containing the message the user reacted to
 * @property messageId Unique identifier of the message inside the chat
 * @property user <em>Optional</em>. The user that changed the reaction, if the user isn't anonymous
 * @property actorChat <em>Optional</em>. The chat on behalf of which the reaction was changed, if the user is anonymous
 * @property date Date of the change in Unix time
 * @property oldReaction Previous list of reaction types that were set by the user
 * @property newReaction New list of reaction types that have been set by the user
 *
 * @constructor Creates a [MessageReactionUpdated].
 * */
data class MessageReactionUpdated(
    val chat: Chat,
    val messageId: Long,
    val user: User? = null,
    val actorChat: Chat? = null,
    val date: Long,
    val oldReaction: List<ReactionType>,
    val newReaction: List<ReactionType>,
) : TelegramModel()

/**
 * <p>This object represents reaction changes on a message with anonymous reactions.</p>
 *
 * @property chat The chat containing the message
 * @property messageId Unique message identifier inside the chat
 * @property date Date of the change in Unix time
 * @property reactions List of reactions that are present on the message
 *
 * @constructor Creates a [MessageReactionCountUpdated].
 * */
data class MessageReactionCountUpdated(
    val chat: Chat,
    val messageId: Long,
    val date: Long,
    val reactions: List<ReactionCount>,
) : TelegramModel()

/**
 * <p>This object represents a forum topic.</p>
 *
 * @property messageThreadId Unique identifier of the forum topic
 * @property name Name of the topic
 * @property iconColor Color of the topic icon in RGB format
 * @property iconCustomEmojiId <em>Optional</em>. Unique identifier of the custom emoji shown as the topic icon
 *
 * @constructor Creates a [ForumTopic].
 * */
data class ForumTopic(
    val messageThreadId: Long,
    val name: String,
    val iconColor: Long,
    val iconCustomEmojiId: String? = null,
) : TelegramModel()

/**
 * <p>This object represents a gift that can be sent by the bot.</p>
 *
 * @property id Unique identifier of the gift
 * @property sticker The sticker that represents the gift
 * @property starCount The number of Telegram Stars that must be paid to send the sticker
 * @property upgradeStarCount <em>Optional</em>. The number of Telegram Stars that must be paid to upgrade the gift to a unique one
 * @property totalCount <em>Optional</em>. The total number of the gifts of this type that can be sent; for limited gifts only
 * @property remainingCount <em>Optional</em>. The number of remaining gifts of this type that can be sent; for limited gifts only
 *
 * @constructor Creates a [Gift].
 * */
data class Gift(
    val id: String,
    val sticker: Sticker,
    val starCount: Long,
    val upgradeStarCount: Long? = null,
    val totalCount: Long? = null,
    val remainingCount: Long? = null,
) : TelegramModel()

/**
 * <p>This object represent a list of gifts.</p>
 *
 * @property gifts The list of gifts
 *
 * @constructor Creates a [Gifts].
 * */
data class Gifts(
    val gifts: List<Gift>,
) : TelegramModel()

/**
 * <p>This object describes the model of a unique gift.</p>
 *
 * @property name Name of the model
 * @property sticker The sticker that represents the unique gift
 * @property rarityPerMille The number of unique gifts that receive this model for every 1000 gifts upgraded
 *
 * @constructor Creates a [UniqueGiftModel].
 * */
data class UniqueGiftModel(
    val name: String,
    val sticker: Sticker,
    val rarityPerMille: Long,
) : TelegramModel()

/**
 * <p>This object describes the symbol shown on the pattern of a unique gift.</p>
 *
 * @property name Name of the symbol
 * @property sticker The sticker that represents the unique gift
 * @property rarityPerMille The number of unique gifts that receive this model for every 1000 gifts upgraded
 *
 * @constructor Creates a [UniqueGiftSymbol].
 * */
data class UniqueGiftSymbol(
    val name: String,
    val sticker: Sticker,
    val rarityPerMille: Long,
) : TelegramModel()

/**
 * <p>This object describes the colors of the backdrop of a unique gift.</p>
 *
 * @property centerColor The color in the center of the backdrop in RGB format
 * @property edgeColor The color on the edges of the backdrop in RGB format
 * @property symbolColor The color to be applied to the symbol in RGB format
 * @property textColor The color for the text on the backdrop in RGB format
 *
 * @constructor Creates a [UniqueGiftBackdropColors].
 * */
data class UniqueGiftBackdropColors(
    val centerColor: Long,
    val edgeColor: Long,
    val symbolColor: Long,
    val textColor: Long,
) : TelegramModel()

/**
 * <p>This object describes the backdrop of a unique gift.</p>
 *
 * @property name Name of the backdrop
 * @property colors Colors of the backdrop
 * @property rarityPerMille The number of unique gifts that receive this backdrop for every 1000 gifts upgraded
 *
 * @constructor Creates a [UniqueGiftBackdrop].
 * */
data class UniqueGiftBackdrop(
    val name: String,
    val colors: UniqueGiftBackdropColors,
    val rarityPerMille: Long,
) : TelegramModel()

/**
 * <p>This object describes a unique gift that was upgraded from a regular gift.</p>
 *
 * @property baseName Human-readable name of the regular gift from which this unique gift was upgraded
 * @property name Unique name of the gift. This name can be used in <code>https://t.me/nft/...</code> links and story areas
 * @property number Unique number of the upgraded gift among gifts upgraded from the same regular gift
 * @property model Model of the gift
 * @property symbol Symbol of the gift
 * @property backdrop Backdrop of the gift
 *
 * @constructor Creates a [UniqueGift].
 * */
data class UniqueGift(
    val baseName: String,
    val name: String,
    val number: Long,
    val model: UniqueGiftModel,
    val symbol: UniqueGiftSymbol,
    val backdrop: UniqueGiftBackdrop,
) : TelegramModel()

/**
 * <p>Describes a service message about a regular gift that was sent or received.</p>
 *
 * @property gift Information about the gift
 * @property ownedGiftId <em>Optional</em>. Unique identifier of the received gift for the bot; only present for gifts received on behalf of business accounts
 * @property convertStarCount <em>Optional</em>. Number of Telegram Stars that can be claimed by the receiver by converting the gift; omitted if conversion to Telegram Stars is impossible
 * @property prepaidUpgradeStarCount <em>Optional</em>. Number of Telegram Stars that were prepaid by the sender for the ability to upgrade the gift
 * @property canBeUpgraded <em>Optional</em>. <em>True</em>, if the gift can be upgraded to a unique gift
 * @property text <em>Optional</em>. Text of the message that was added to the gift
 * @property entities <em>Optional</em>. Special entities that appear in the text
 * @property isPrivate <em>Optional</em>. <em>True</em>, if the sender and gift text are shown only to the gift receiver; otherwise, everyone will be able to see them
 *
 * @constructor Creates a [GiftInfo].
 * */
data class GiftInfo(
    val gift: Gift,
    val ownedGiftId: String? = null,
    val convertStarCount: Long? = null,
    val prepaidUpgradeStarCount: Long? = null,
    val canBeUpgraded: Boolean? = null,
    val text: String? = null,
    val entities: List<MessageEntity>? = null,
    val isPrivate: Boolean? = null,
) : TelegramModel()

/**
 * <p>Describes a service message about a unique gift that was sent or received.</p>
 *
 * @property gift Information about the gift
 * @property origin Origin of the gift. Currently, either “upgrade” for gifts upgraded from regular gifts, “transfer” for gifts transferred from other users or channels, or “resale” for gifts bought from other users
 * @property lastResaleStarCount <em>Optional</em>. For gifts bought from other users, the price paid for the gift
 * @property ownedGiftId <em>Optional</em>. Unique identifier of the received gift for the bot; only present for gifts received on behalf of business accounts
 * @property transferStarCount <em>Optional</em>. Number of Telegram Stars that must be paid to transfer the gift; omitted if the bot cannot transfer the gift
 * @property nextTransferDate <em>Optional</em>. Point in time (Unix timestamp) when the gift can be transferred. If it is in the past, then the gift can be transferred now
 *
 * @constructor Creates a [UniqueGiftInfo].
 * */
data class UniqueGiftInfo(
    val gift: UniqueGift,
    val origin: String,
    val lastResaleStarCount: Long? = null,
    val ownedGiftId: String? = null,
    val transferStarCount: Long? = null,
    val nextTransferDate: Long? = null,
) : TelegramModel()

/**
 * <p>Describes a regular gift owned by a user or a chat.</p>
 *
 * @property type Type of the gift, always “regular”
 * @property gift Information about the regular gift
 * @property ownedGiftId <em>Optional</em>. Unique identifier of the gift for the bot; for gifts received on behalf of business accounts only
 * @property senderUser <em>Optional</em>. Sender of the gift if it is a known user
 * @property sendDate Date the gift was sent in Unix time
 * @property text <em>Optional</em>. Text of the message that was added to the gift
 * @property entities <em>Optional</em>. Special entities that appear in the text
 * @property isPrivate <em>Optional</em>. <em>True</em>, if the sender and gift text are shown only to the gift receiver; otherwise, everyone will be able to see them
 * @property isSaved <em>Optional</em>. <em>True</em>, if the gift is displayed on the account's profile page; for gifts received on behalf of business accounts only
 * @property canBeUpgraded <em>Optional</em>. <em>True</em>, if the gift can be upgraded to a unique gift; for gifts received on behalf of business accounts only
 * @property wasRefunded <em>Optional</em>. <em>True</em>, if the gift was refunded and isn't available anymore
 * @property convertStarCount <em>Optional</em>. Number of Telegram Stars that can be claimed by the receiver instead of the gift; omitted if the gift cannot be converted to Telegram Stars
 * @property prepaidUpgradeStarCount <em>Optional</em>. Number of Telegram Stars that were paid by the sender for the ability to upgrade the gift
 *
 * @constructor Creates a [OwnedGiftRegular].
 * */
data class OwnedGiftRegular(
    val type: String,
    val gift: Gift,
    val ownedGiftId: String? = null,
    val senderUser: User? = null,
    val sendDate: Long,
    val text: String? = null,
    val entities: List<MessageEntity>? = null,
    val isPrivate: Boolean? = null,
    val isSaved: Boolean? = null,
    val canBeUpgraded: Boolean? = null,
    val wasRefunded: Boolean? = null,
    val convertStarCount: Long? = null,
    val prepaidUpgradeStarCount: Long? = null,
) : OwnedGift()

/**
 * <p>Describes a unique gift received and owned by a user or a chat.</p>
 *
 * @property type Type of the gift, always “unique”
 * @property gift Information about the unique gift
 * @property ownedGiftId <em>Optional</em>. Unique identifier of the received gift for the bot; for gifts received on behalf of business accounts only
 * @property senderUser <em>Optional</em>. Sender of the gift if it is a known user
 * @property sendDate Date the gift was sent in Unix time
 * @property isSaved <em>Optional</em>. <em>True</em>, if the gift is displayed on the account's profile page; for gifts received on behalf of business accounts only
 * @property canBeTransferred <em>Optional</em>. <em>True</em>, if the gift can be transferred to another owner; for gifts received on behalf of business accounts only
 * @property transferStarCount <em>Optional</em>. Number of Telegram Stars that must be paid to transfer the gift; omitted if the bot cannot transfer the gift
 * @property nextTransferDate <em>Optional</em>. Point in time (Unix timestamp) when the gift can be transferred. If it is in the past, then the gift can be transferred now
 *
 * @constructor Creates a [OwnedGiftUnique].
 * */
data class OwnedGiftUnique(
    val type: String,
    val gift: UniqueGift,
    val ownedGiftId: String? = null,
    val senderUser: User? = null,
    val sendDate: Long,
    val isSaved: Boolean? = null,
    val canBeTransferred: Boolean? = null,
    val transferStarCount: Long? = null,
    val nextTransferDate: Long? = null,
) : OwnedGift()

/**
 * <p>Contains the list of gifts received and owned by a user or a chat.</p>
 *
 * @property totalCount The total number of gifts owned by the user or the chat
 * @property gifts The list of gifts
 * @property nextOffset <em>Optional</em>. Offset for the next request. If empty, then there are no more results
 *
 * @constructor Creates a [OwnedGifts].
 * */
data class OwnedGifts(
    val totalCount: Long,
    val gifts: List<OwnedGift>,
    val nextOffset: String? = null,
) : TelegramModel()

/**
 * <p>This object describes the types of gifts that can be gifted to a user or a chat.</p>
 *
 * @property unlimitedGifts <em>True</em>, if unlimited regular gifts are accepted
 * @property limitedGifts <em>True</em>, if limited regular gifts are accepted
 * @property uniqueGifts <em>True</em>, if unique gifts or gifts that can be upgraded to unique for free are accepted
 * @property premiumSubscription <em>True</em>, if a Telegram Premium subscription is accepted
 *
 * @constructor Creates a [AcceptedGiftTypes].
 * */
data class AcceptedGiftTypes(
    val unlimitedGifts: Boolean,
    val limitedGifts: Boolean,
    val uniqueGifts: Boolean,
    val premiumSubscription: Boolean,
) : TelegramModel()

/**
 * <p>Describes an amount of Telegram Stars.</p>
 *
 * @property amount Integer amount of Telegram Stars, rounded to 0; can be negative
 * @property nanostarAmount <em>Optional</em>. The number of 1/1000000000 shares of Telegram Stars; from -999999999 to 999999999; can be negative if and only if <em>amount</em> is non-positive
 *
 * @constructor Creates a [StarAmount].
 * */
data class StarAmount(
    val amount: Long,
    val nanostarAmount: Long? = null,
) : TelegramModel()

/**
 * <p>This object represents a bot command.</p>
 *
 * @property command Text of the command; 1-32 characters. Can contain only lowercase English letters, digits and underscores.
 * @property description Description of the command; 1-256 characters.
 *
 * @constructor Creates a [BotCommand].
 * */
data class BotCommand(
    val command: String,
    val description: String,
) : TelegramModel()

/**
 * <p>Represents the default <a href="#botcommandscope">scope</a> of bot commands. Default commands are used if no commands with a <a href="#determining-list-of-commands">narrower scope</a> are specified for the user.</p>
 *
 * @property type Scope type, must be <em>default</em>
 *
 * @constructor Creates a [BotCommandScopeDefault].
 * */
data class BotCommandScopeDefault(
    val type: String,
) : BotCommandScope()

/**
 * <p>Represents the <a href="#botcommandscope">scope</a> of bot commands, covering all private chats.</p>
 *
 * @property type Scope type, must be <em>all_private_chats</em>
 *
 * @constructor Creates a [BotCommandScopeAllPrivateChats].
 * */
data class BotCommandScopeAllPrivateChats(
    val type: String,
) : BotCommandScope()

/**
 * <p>Represents the <a href="#botcommandscope">scope</a> of bot commands, covering all group and supergroup chats.</p>
 *
 * @property type Scope type, must be <em>all_group_chats</em>
 *
 * @constructor Creates a [BotCommandScopeAllGroupChats].
 * */
data class BotCommandScopeAllGroupChats(
    val type: String,
) : BotCommandScope()

/**
 * <p>Represents the <a href="#botcommandscope">scope</a> of bot commands, covering all group and supergroup chat administrators.</p>
 *
 * @property type Scope type, must be <em>all_chat_administrators</em>
 *
 * @constructor Creates a [BotCommandScopeAllChatAdministrators].
 * */
data class BotCommandScopeAllChatAdministrators(
    val type: String,
) : BotCommandScope()

/**
 * <p>Represents the <a href="#botcommandscope">scope</a> of bot commands, covering a specific chat.</p>
 *
 * @property type Scope type, must be <em>chat</em>
 * @property chatId Unique identifier for the target chat or username of the target supergroup (in the format <code>@supergroupusername</code>)
 *
 * @constructor Creates a [BotCommandScopeChat].
 * */
data class BotCommandScopeChat(
    val type: String,
    val chatId: String,
) : BotCommandScope()

/**
 * <p>Represents the <a href="#botcommandscope">scope</a> of bot commands, covering all administrators of a specific group or supergroup chat.</p>
 *
 * @property type Scope type, must be <em>chat_administrators</em>
 * @property chatId Unique identifier for the target chat or username of the target supergroup (in the format <code>@supergroupusername</code>)
 *
 * @constructor Creates a [BotCommandScopeChatAdministrators].
 * */
data class BotCommandScopeChatAdministrators(
    val type: String,
    val chatId: String,
) : BotCommandScope()

/**
 * <p>Represents the <a href="#botcommandscope">scope</a> of bot commands, covering a specific member of a group or supergroup chat.</p>
 *
 * @property type Scope type, must be <em>chat_member</em>
 * @property chatId Unique identifier for the target chat or username of the target supergroup (in the format <code>@supergroupusername</code>)
 * @property userId Unique identifier of the target user
 *
 * @constructor Creates a [BotCommandScopeChatMember].
 * */
data class BotCommandScopeChatMember(
    val type: String,
    val chatId: String,
    val userId: Long,
) : BotCommandScope()

/**
 * <p>This object represents the bot's name.</p>
 *
 * @property name The bot's name
 *
 * @constructor Creates a [BotName].
 * */
data class BotName(
    val name: String,
) : TelegramModel()

/**
 * <p>This object represents the bot's description.</p>
 *
 * @property description The bot's description
 *
 * @constructor Creates a [BotDescription].
 * */
data class BotDescription(
    val description: String,
) : TelegramModel()

/**
 * <p>This object represents the bot's short description.</p>
 *
 * @property shortDescription The bot's short description
 *
 * @constructor Creates a [BotShortDescription].
 * */
data class BotShortDescription(
    val shortDescription: String,
) : TelegramModel()

/**
 * <p>Represents a menu button, which opens the bot's list of commands.</p>
 *
 * @property type Type of the button, must be <em>commands</em>
 *
 * @constructor Creates a [MenuButtonCommands].
 * */
data class MenuButtonCommands(
    val type: String,
) : MenuButton()

/**
 * <p>Represents a menu button, which launches a <a href="/bots/webapps">Web App</a>.</p>
 *
 * @property type Type of the button, must be <em>web_app</em>
 * @property text Text on the button
 * @property webApp Description of the Web App that will be launched when the user presses the button. The Web App will be able to send an arbitrary message on behalf of the user using the method <a href="#answerwebappquery">answerWebAppQuery</a>. Alternatively, a <code>t.me</code> link to a Web App of the bot can be specified in the object instead of the Web App's URL, in which case the Web App will be opened as if the user pressed the link.
 *
 * @constructor Creates a [MenuButtonWebApp].
 * */
data class MenuButtonWebApp(
    val type: String,
    val text: String,
    val webApp: WebAppInfo,
) : MenuButton()

/**
 * <p>Describes that no specific value for the menu button was set.</p>
 *
 * @property type Type of the button, must be <em>default</em>
 *
 * @constructor Creates a [MenuButtonDefault].
 * */
data class MenuButtonDefault(
    val type: String,
) : MenuButton()

/**
 * <p>The boost was obtained by subscribing to Telegram Premium or by gifting a Telegram Premium subscription to another user.</p>
 *
 * @property source Source of the boost, always “premium”
 * @property user User that boosted the chat
 *
 * @constructor Creates a [ChatBoostSourcePremium].
 * */
data class ChatBoostSourcePremium(
    val source: String,
    val user: User,
) : ChatBoostSource()

/**
 * <p>The boost was obtained by the creation of Telegram Premium gift codes to boost a chat. Each such code boosts the chat 4 times for the duration of the corresponding Telegram Premium subscription.</p>
 *
 * @property source Source of the boost, always “gift_code”
 * @property user User for which the gift code was created
 *
 * @constructor Creates a [ChatBoostSourceGiftCode].
 * */
data class ChatBoostSourceGiftCode(
    val source: String,
    val user: User,
) : ChatBoostSource()

/**
 * <p>The boost was obtained by the creation of a Telegram Premium or a Telegram Star giveaway. This boosts the chat 4 times for the duration of the corresponding Telegram Premium subscription for Telegram Premium giveaways and <em>prize_star_count</em> / 500 times for one year for Telegram Star giveaways.</p>
 *
 * @property source Source of the boost, always “giveaway”
 * @property giveawayMessageId Identifier of a message in the chat with the giveaway; the message could have been deleted already. May be 0 if the message isn't sent yet.
 * @property user <em>Optional</em>. User that won the prize in the giveaway if any; for Telegram Premium giveaways only
 * @property prizeStarCount <em>Optional</em>. The number of Telegram Stars to be split between giveaway winners; for Telegram Star giveaways only
 * @property isUnclaimed <em>Optional</em>. <em>True</em>, if the giveaway was completed, but there was no user to win the prize
 *
 * @constructor Creates a [ChatBoostSourceGiveaway].
 * */
data class ChatBoostSourceGiveaway(
    val source: String,
    val giveawayMessageId: Long,
    val user: User? = null,
    val prizeStarCount: Long? = null,
    val isUnclaimed: Boolean? = null,
) : ChatBoostSource()

/**
 * <p>This object contains information about a chat boost.</p>
 *
 * @property boostId Unique identifier of the boost
 * @property addDate Point in time (Unix timestamp) when the chat was boosted
 * @property expirationDate Point in time (Unix timestamp) when the boost will automatically expire, unless the booster's Telegram Premium subscription is prolonged
 * @property source Source of the added boost
 *
 * @constructor Creates a [ChatBoost].
 * */
data class ChatBoost(
    val boostId: String,
    val addDate: Long,
    val expirationDate: Long,
    val source: ChatBoostSource,
) : TelegramModel()

/**
 * <p>This object represents a boost added to a chat or changed.</p>
 *
 * @property chat Chat which was boosted
 * @property boost Information about the chat boost
 *
 * @constructor Creates a [ChatBoostUpdated].
 * */
data class ChatBoostUpdated(
    val chat: Chat,
    val boost: ChatBoost,
) : TelegramModel()

/**
 * <p>This object represents a boost removed from a chat.</p>
 *
 * @property chat Chat which was boosted
 * @property boostId Unique identifier of the boost
 * @property removeDate Point in time (Unix timestamp) when the boost was removed
 * @property source Source of the removed boost
 *
 * @constructor Creates a [ChatBoostRemoved].
 * */
data class ChatBoostRemoved(
    val chat: Chat,
    val boostId: String,
    val removeDate: Long,
    val source: ChatBoostSource,
) : TelegramModel()

/**
 * <p>This object represents a list of boosts added to a chat by a user.</p>
 *
 * @property boosts The list of boosts added to the chat by the user
 *
 * @constructor Creates a [UserChatBoosts].
 * */
data class UserChatBoosts(
    val boosts: List<ChatBoost>,
) : TelegramModel()

/**
 * <p>Represents the rights of a business bot.</p>
 *
 * @property canReply <em>Optional</em>. <em>True</em>, if the bot can send and edit messages in the private chats that had incoming messages in the last 24 hours
 * @property canReadMessages <em>Optional</em>. <em>True</em>, if the bot can mark incoming private messages as read
 * @property canDeleteSentMessages <em>Optional</em>. <em>True</em>, if the bot can delete messages sent by the bot
 * @property canDeleteAllMessages <em>Optional</em>. <em>True</em>, if the bot can delete all private messages in managed chats
 * @property canEditName <em>Optional</em>. <em>True</em>, if the bot can edit the first and last name of the business account
 * @property canEditBio <em>Optional</em>. <em>True</em>, if the bot can edit the bio of the business account
 * @property canEditProfilePhoto <em>Optional</em>. <em>True</em>, if the bot can edit the profile photo of the business account
 * @property canEditUsername <em>Optional</em>. <em>True</em>, if the bot can edit the username of the business account
 * @property canChangeGiftSettings <em>Optional</em>. <em>True</em>, if the bot can change the privacy settings pertaining to gifts for the business account
 * @property canViewGiftsAndStars <em>Optional</em>. <em>True</em>, if the bot can view gifts and the amount of Telegram Stars owned by the business account
 * @property canConvertGiftsToStars <em>Optional</em>. <em>True</em>, if the bot can convert regular gifts owned by the business account to Telegram Stars
 * @property canTransferAndUpgradeGifts <em>Optional</em>. <em>True</em>, if the bot can transfer and upgrade gifts owned by the business account
 * @property canTransferStars <em>Optional</em>. <em>True</em>, if the bot can transfer Telegram Stars received by the business account to its own account, or use them to upgrade and transfer gifts
 * @property canManageStories <em>Optional</em>. <em>True</em>, if the bot can post, edit and delete stories on behalf of the business account
 *
 * @constructor Creates a [BusinessBotRights].
 * */
data class BusinessBotRights(
    val canReply: Boolean? = null,
    val canReadMessages: Boolean? = null,
    val canDeleteSentMessages: Boolean? = null,
    val canDeleteAllMessages: Boolean? = null,
    val canEditName: Boolean? = null,
    val canEditBio: Boolean? = null,
    val canEditProfilePhoto: Boolean? = null,
    val canEditUsername: Boolean? = null,
    val canChangeGiftSettings: Boolean? = null,
    val canViewGiftsAndStars: Boolean? = null,
    val canConvertGiftsToStars: Boolean? = null,
    val canTransferAndUpgradeGifts: Boolean? = null,
    val canTransferStars: Boolean? = null,
    val canManageStories: Boolean? = null,
) : TelegramModel()

/**
 * <p>Describes the connection of the bot with a business account.</p>
 *
 * @property id Unique identifier of the business connection
 * @property user Business account user that created the business connection
 * @property userChatId Identifier of a private chat with the user who created the business connection. This number may have more than 32 significant bits and some programming languages may have difficulty/silent defects in interpreting it. But it has at most 52 significant bits, so a 64-bit integer or double-precision float type are safe for storing this identifier.
 * @property date Date the connection was established in Unix time
 * @property rights <em>Optional</em>. Rights of the business bot
 * @property isEnabled <em>True</em>, if the connection is active
 *
 * @constructor Creates a [BusinessConnection].
 * */
data class BusinessConnection(
    val id: String,
    val user: User,
    val userChatId: Long,
    val date: Long,
    val rights: BusinessBotRights? = null,
    val isEnabled: Boolean,
) : TelegramModel()

/**
 * <p>This object is received when messages are deleted from a connected business account.</p>
 *
 * @property businessConnectionId Unique identifier of the business connection
 * @property chat Information about a chat in the business account. The bot may not have access to the chat or the corresponding user.
 * @property messageIds The list of identifiers of deleted messages in the chat of the business account
 *
 * @constructor Creates a [BusinessMessagesDeleted].
 * */
data class BusinessMessagesDeleted(
    val businessConnectionId: String,
    val chat: Chat,
    val messageIds: List<Long>,
) : TelegramModel()

/**
 * <p>Describes why a request was unsuccessful.</p>
 *
 * @property migrateToChatId <em>Optional</em>. The group has been migrated to a supergroup with the specified identifier. This number may have more than 32 significant bits and some programming languages may have difficulty/silent defects in interpreting it. But it has at most 52 significant bits, so a signed 64-bit integer or double-precision float type are safe for storing this identifier.
 * @property retryAfter <em>Optional</em>. In case of exceeding flood control, the number of seconds left to wait before the request can be repeated
 *
 * @constructor Creates a [ResponseParameters].
 * */
data class ResponseParameters(
    val migrateToChatId: Long? = null,
    val retryAfter: Long? = null,
) : TelegramModel()

/**
 * <p>Represents a photo to be sent.</p>
 *
 * @property type Type of the result, must be <em>photo</em>
 * @property media File to send. Pass a file_id to send a file that exists on the Telegram servers (recommended), pass an HTTP URL for Telegram to get a file from the Internet, or pass “attach://&lt;file_attach_name&gt;” to upload a new one using multipart/form-data under &lt;file_attach_name&gt; name. <a href="#sending-files">More information on Sending Files »</a>
 * @property caption <em>Optional</em>. Caption of the photo to be sent, 0-1024 characters after entities parsing
 * @property parseMode <em>Optional</em>. Mode for parsing entities in the photo caption. See <a href="#formatting-options">formatting options</a> for more details.
 * @property captionEntities <em>Optional</em>. List of special entities that appear in the caption, which can be specified instead of <em>parse_mode</em>
 * @property showCaptionAboveMedia <em>Optional</em>. Pass <em>True</em>, if the caption must be shown above the message media
 * @property hasSpoiler <em>Optional</em>. Pass <em>True</em> if the photo needs to be covered with a spoiler animation
 *
 * @constructor Creates a [InputMediaPhoto].
 * */
data class InputMediaPhoto(
    val type: String,
    val media: String,
    val caption: String? = null,
    val parseMode: ParseMode? = null,
    val captionEntities: List<MessageEntity>? = null,
    val showCaptionAboveMedia: Boolean? = null,
    val hasSpoiler: Boolean? = null,
) : InputMedia()

/**
 * <p>Represents a video to be sent.</p>
 *
 * @property type Type of the result, must be <em>video</em>
 * @property media File to send. Pass a file_id to send a file that exists on the Telegram servers (recommended), pass an HTTP URL for Telegram to get a file from the Internet, or pass “attach://&lt;file_attach_name&gt;” to upload a new one using multipart/form-data under &lt;file_attach_name&gt; name. <a href="#sending-files">More information on Sending Files »</a>
 * @property thumbnail <em>Optional</em>. Thumbnail of the file sent; can be ignored if thumbnail generation for the file is supported server-side. The thumbnail should be in JPEG format and less than 200 kB in size. A thumbnail's width and height should not exceed 320. Ignored if the file is not uploaded using multipart/form-data. Thumbnails can't be reused and can be only uploaded as a new file, so you can pass “attach://&lt;file_attach_name&gt;” if the thumbnail was uploaded using multipart/form-data under &lt;file_attach_name&gt;. <a href="#sending-files">More information on Sending Files »</a>
 * @property cover <em>Optional</em>. Cover for the video in the message. Pass a file_id to send a file that exists on the Telegram servers (recommended), pass an HTTP URL for Telegram to get a file from the Internet, or pass “attach://&lt;file_attach_name&gt;” to upload a new one using multipart/form-data under &lt;file_attach_name&gt; name. <a href="#sending-files">More information on Sending Files »</a>
 * @property startTimestamp <em>Optional</em>. Start timestamp for the video in the message
 * @property caption <em>Optional</em>. Caption of the video to be sent, 0-1024 characters after entities parsing
 * @property parseMode <em>Optional</em>. Mode for parsing entities in the video caption. See <a href="#formatting-options">formatting options</a> for more details.
 * @property captionEntities <em>Optional</em>. List of special entities that appear in the caption, which can be specified instead of <em>parse_mode</em>
 * @property showCaptionAboveMedia <em>Optional</em>. Pass <em>True</em>, if the caption must be shown above the message media
 * @property width <em>Optional</em>. Video width
 * @property height <em>Optional</em>. Video height
 * @property duration <em>Optional</em>. Video duration in seconds
 * @property supportsStreaming <em>Optional</em>. Pass <em>True</em> if the uploaded video is suitable for streaming
 * @property hasSpoiler <em>Optional</em>. Pass <em>True</em> if the video needs to be covered with a spoiler animation
 *
 * @constructor Creates a [InputMediaVideo].
 * */
data class InputMediaVideo(
    val type: String,
    val media: String,
    val thumbnail: String? = null,
    val cover: String? = null,
    val startTimestamp: Long? = null,
    val caption: String? = null,
    val parseMode: ParseMode? = null,
    val captionEntities: List<MessageEntity>? = null,
    val showCaptionAboveMedia: Boolean? = null,
    val width: Long? = null,
    val height: Long? = null,
    val duration: Long? = null,
    val supportsStreaming: Boolean? = null,
    val hasSpoiler: Boolean? = null,
) : InputMedia()

/**
 * <p>Represents an animation file (GIF or H.264/MPEG-4 AVC video without sound) to be sent.</p>
 *
 * @property type Type of the result, must be <em>animation</em>
 * @property media File to send. Pass a file_id to send a file that exists on the Telegram servers (recommended), pass an HTTP URL for Telegram to get a file from the Internet, or pass “attach://&lt;file_attach_name&gt;” to upload a new one using multipart/form-data under &lt;file_attach_name&gt; name. <a href="#sending-files">More information on Sending Files »</a>
 * @property thumbnail <em>Optional</em>. Thumbnail of the file sent; can be ignored if thumbnail generation for the file is supported server-side. The thumbnail should be in JPEG format and less than 200 kB in size. A thumbnail's width and height should not exceed 320. Ignored if the file is not uploaded using multipart/form-data. Thumbnails can't be reused and can be only uploaded as a new file, so you can pass “attach://&lt;file_attach_name&gt;” if the thumbnail was uploaded using multipart/form-data under &lt;file_attach_name&gt;. <a href="#sending-files">More information on Sending Files »</a>
 * @property caption <em>Optional</em>. Caption of the animation to be sent, 0-1024 characters after entities parsing
 * @property parseMode <em>Optional</em>. Mode for parsing entities in the animation caption. See <a href="#formatting-options">formatting options</a> for more details.
 * @property captionEntities <em>Optional</em>. List of special entities that appear in the caption, which can be specified instead of <em>parse_mode</em>
 * @property showCaptionAboveMedia <em>Optional</em>. Pass <em>True</em>, if the caption must be shown above the message media
 * @property width <em>Optional</em>. Animation width
 * @property height <em>Optional</em>. Animation height
 * @property duration <em>Optional</em>. Animation duration in seconds
 * @property hasSpoiler <em>Optional</em>. Pass <em>True</em> if the animation needs to be covered with a spoiler animation
 *
 * @constructor Creates a [InputMediaAnimation].
 * */
data class InputMediaAnimation(
    val type: String,
    val media: String,
    val thumbnail: String? = null,
    val caption: String? = null,
    val parseMode: ParseMode? = null,
    val captionEntities: List<MessageEntity>? = null,
    val showCaptionAboveMedia: Boolean? = null,
    val width: Long? = null,
    val height: Long? = null,
    val duration: Long? = null,
    val hasSpoiler: Boolean? = null,
) : InputMedia()

/**
 * <p>Represents an audio file to be treated as music to be sent.</p>
 *
 * @property type Type of the result, must be <em>audio</em>
 * @property media File to send. Pass a file_id to send a file that exists on the Telegram servers (recommended), pass an HTTP URL for Telegram to get a file from the Internet, or pass “attach://&lt;file_attach_name&gt;” to upload a new one using multipart/form-data under &lt;file_attach_name&gt; name. <a href="#sending-files">More information on Sending Files »</a>
 * @property thumbnail <em>Optional</em>. Thumbnail of the file sent; can be ignored if thumbnail generation for the file is supported server-side. The thumbnail should be in JPEG format and less than 200 kB in size. A thumbnail's width and height should not exceed 320. Ignored if the file is not uploaded using multipart/form-data. Thumbnails can't be reused and can be only uploaded as a new file, so you can pass “attach://&lt;file_attach_name&gt;” if the thumbnail was uploaded using multipart/form-data under &lt;file_attach_name&gt;. <a href="#sending-files">More information on Sending Files »</a>
 * @property caption <em>Optional</em>. Caption of the audio to be sent, 0-1024 characters after entities parsing
 * @property parseMode <em>Optional</em>. Mode for parsing entities in the audio caption. See <a href="#formatting-options">formatting options</a> for more details.
 * @property captionEntities <em>Optional</em>. List of special entities that appear in the caption, which can be specified instead of <em>parse_mode</em>
 * @property duration <em>Optional</em>. Duration of the audio in seconds
 * @property performer <em>Optional</em>. Performer of the audio
 * @property title <em>Optional</em>. Title of the audio
 *
 * @constructor Creates a [InputMediaAudio].
 * */
data class InputMediaAudio(
    val type: String,
    val media: String,
    val thumbnail: String? = null,
    val caption: String? = null,
    val parseMode: ParseMode? = null,
    val captionEntities: List<MessageEntity>? = null,
    val duration: Long? = null,
    val performer: String? = null,
    val title: String? = null,
) : InputMedia()

/**
 * <p>Represents a general file to be sent.</p>
 *
 * @property type Type of the result, must be <em>document</em>
 * @property media File to send. Pass a file_id to send a file that exists on the Telegram servers (recommended), pass an HTTP URL for Telegram to get a file from the Internet, or pass “attach://&lt;file_attach_name&gt;” to upload a new one using multipart/form-data under &lt;file_attach_name&gt; name. <a href="#sending-files">More information on Sending Files »</a>
 * @property thumbnail <em>Optional</em>. Thumbnail of the file sent; can be ignored if thumbnail generation for the file is supported server-side. The thumbnail should be in JPEG format and less than 200 kB in size. A thumbnail's width and height should not exceed 320. Ignored if the file is not uploaded using multipart/form-data. Thumbnails can't be reused and can be only uploaded as a new file, so you can pass “attach://&lt;file_attach_name&gt;” if the thumbnail was uploaded using multipart/form-data under &lt;file_attach_name&gt;. <a href="#sending-files">More information on Sending Files »</a>
 * @property caption <em>Optional</em>. Caption of the document to be sent, 0-1024 characters after entities parsing
 * @property parseMode <em>Optional</em>. Mode for parsing entities in the document caption. See <a href="#formatting-options">formatting options</a> for more details.
 * @property captionEntities <em>Optional</em>. List of special entities that appear in the caption, which can be specified instead of <em>parse_mode</em>
 * @property disableContentTypeDetection <em>Optional</em>. Disables automatic server-side content type detection for files uploaded using multipart/form-data. Always <em>True</em>, if the document is sent as part of an album.
 *
 * @constructor Creates a [InputMediaDocument].
 * */
data class InputMediaDocument(
    val type: String,
    val media: String,
    val thumbnail: String? = null,
    val caption: String? = null,
    val parseMode: ParseMode? = null,
    val captionEntities: List<MessageEntity>? = null,
    val disableContentTypeDetection: Boolean? = null,
) : InputMedia()

/**
 * <p>The paid media to send is a photo.</p>
 *
 * @property type Type of the media, must be <em>photo</em>
 * @property media File to send. Pass a file_id to send a file that exists on the Telegram servers (recommended), pass an HTTP URL for Telegram to get a file from the Internet, or pass “attach://&lt;file_attach_name&gt;” to upload a new one using multipart/form-data under &lt;file_attach_name&gt; name. <a href="#sending-files">More information on Sending Files »</a>
 *
 * @constructor Creates a [InputPaidMediaPhoto].
 * */
data class InputPaidMediaPhoto(
    val type: String,
    val media: String,
) : InputPaidMedia()

/**
 * <p>The paid media to send is a video.</p>
 *
 * @property type Type of the media, must be <em>video</em>
 * @property media File to send. Pass a file_id to send a file that exists on the Telegram servers (recommended), pass an HTTP URL for Telegram to get a file from the Internet, or pass “attach://&lt;file_attach_name&gt;” to upload a new one using multipart/form-data under &lt;file_attach_name&gt; name. <a href="#sending-files">More information on Sending Files »</a>
 * @property thumbnail <em>Optional</em>. Thumbnail of the file sent; can be ignored if thumbnail generation for the file is supported server-side. The thumbnail should be in JPEG format and less than 200 kB in size. A thumbnail's width and height should not exceed 320. Ignored if the file is not uploaded using multipart/form-data. Thumbnails can't be reused and can be only uploaded as a new file, so you can pass “attach://&lt;file_attach_name&gt;” if the thumbnail was uploaded using multipart/form-data under &lt;file_attach_name&gt;. <a href="#sending-files">More information on Sending Files »</a>
 * @property cover <em>Optional</em>. Cover for the video in the message. Pass a file_id to send a file that exists on the Telegram servers (recommended), pass an HTTP URL for Telegram to get a file from the Internet, or pass “attach://&lt;file_attach_name&gt;” to upload a new one using multipart/form-data under &lt;file_attach_name&gt; name. <a href="#sending-files">More information on Sending Files »</a>
 * @property startTimestamp <em>Optional</em>. Start timestamp for the video in the message
 * @property width <em>Optional</em>. Video width
 * @property height <em>Optional</em>. Video height
 * @property duration <em>Optional</em>. Video duration in seconds
 * @property supportsStreaming <em>Optional</em>. Pass <em>True</em> if the uploaded video is suitable for streaming
 *
 * @constructor Creates a [InputPaidMediaVideo].
 * */
data class InputPaidMediaVideo(
    val type: String,
    val media: String,
    val thumbnail: String? = null,
    val cover: String? = null,
    val startTimestamp: Long? = null,
    val width: Long? = null,
    val height: Long? = null,
    val duration: Long? = null,
    val supportsStreaming: Boolean? = null,
) : InputPaidMedia()

/**
 * <p>A static profile photo in the .JPG format.</p>
 *
 * @property type Type of the profile photo, must be <em>static</em>
 * @property photo The static profile photo. Profile photos can't be reused and can only be uploaded as a new file, so you can pass “attach://&lt;file_attach_name&gt;” if the photo was uploaded using multipart/form-data under &lt;file_attach_name&gt;. <a href="#sending-files">More information on Sending Files »</a>
 *
 * @constructor Creates a [InputProfilePhotoStatic].
 * */
data class InputProfilePhotoStatic(
    val type: String,
    val photo: String,
) : InputProfilePhoto()

/**
 * <p>An animated profile photo in the MPEG4 format.</p>
 *
 * @property type Type of the profile photo, must be <em>animated</em>
 * @property animation The animated profile photo. Profile photos can't be reused and can only be uploaded as a new file, so you can pass “attach://&lt;file_attach_name&gt;” if the photo was uploaded using multipart/form-data under &lt;file_attach_name&gt;. <a href="#sending-files">More information on Sending Files »</a>
 * @property mainFrameTimestamp <em>Optional</em>. Timestamp in seconds of the frame that will be used as the static profile photo. Defaults to 0.0.
 *
 * @constructor Creates a [InputProfilePhotoAnimated].
 * */
data class InputProfilePhotoAnimated(
    val type: String,
    val animation: String,
    val mainFrameTimestamp: Float? = null,
) : InputProfilePhoto()

/**
 * <p>Describes a photo to post as a story.</p>
 *
 * @property type Type of the content, must be <em>photo</em>
 * @property photo The photo to post as a story. The photo must be of the size 1080x1920 and must not exceed 10 MB. The photo can't be reused and can only be uploaded as a new file, so you can pass “attach://&lt;file_attach_name&gt;” if the photo was uploaded using multipart/form-data under &lt;file_attach_name&gt;. <a href="#sending-files">More information on Sending Files »</a>
 *
 * @constructor Creates a [InputStoryContentPhoto].
 * */
data class InputStoryContentPhoto(
    val type: String,
    val photo: String,
) : InputStoryContent()

/**
 * <p>Describes a video to post as a story.</p>
 *
 * @property type Type of the content, must be <em>video</em>
 * @property video The video to post as a story. The video must be of the size 720x1280, streamable, encoded with H.265 codec, with key frames added each second in the MPEG4 format, and must not exceed 30 MB. The video can't be reused and can only be uploaded as a new file, so you can pass “attach://&lt;file_attach_name&gt;” if the video was uploaded using multipart/form-data under &lt;file_attach_name&gt;. <a href="#sending-files">More information on Sending Files »</a>
 * @property duration <em>Optional</em>. Precise duration of the video in seconds; 0-60
 * @property coverFrameTimestamp <em>Optional</em>. Timestamp in seconds of the frame that will be used as the static cover for the story. Defaults to 0.0.
 * @property isAnimation <em>Optional</em>. Pass <em>True</em> if the video has no sound
 *
 * @constructor Creates a [InputStoryContentVideo].
 * */
data class InputStoryContentVideo(
    val type: String,
    val video: String,
    val duration: Float? = null,
    val coverFrameTimestamp: Float? = null,
    val isAnimation: Boolean? = null,
) : InputStoryContent()

// Stickers

/**
 * <p>This object represents a sticker.</p>
 *
 * @property fileId Identifier for this file, which can be used to download or reuse the file
 * @property fileUniqueId Unique identifier for this file, which is supposed to be the same over time and for different bots. Can't be used to download or reuse the file.
 * @property type Type of the sticker, currently one of “regular”, “mask”, “custom_emoji”. The type of the sticker is independent from its format, which is determined by the fields <em>is_animated</em> and <em>is_video</em>.
 * @property width Sticker width
 * @property height Sticker height
 * @property isAnimated <em>True</em>, if the sticker is <a href="https://telegram.org/blog/animated-stickers">animated</a>
 * @property isVideo <em>True</em>, if the sticker is a <a href="https://telegram.org/blog/video-stickers-better-reactions">video sticker</a>
 * @property thumbnail <em>Optional</em>. Sticker thumbnail in the .WEBP or .JPG format
 * @property emoji <em>Optional</em>. Emoji associated with the sticker
 * @property setName <em>Optional</em>. Name of the sticker set to which the sticker belongs
 * @property premiumAnimation <em>Optional</em>. For premium regular stickers, premium animation for the sticker
 * @property maskPosition <em>Optional</em>. For mask stickers, the position where the mask should be placed
 * @property customEmojiId <em>Optional</em>. For custom emoji stickers, unique identifier of the custom emoji
 * @property needsRepainting <em>Optional</em>. <em>True</em>, if the sticker must be repainted to a text color in messages, the color of the Telegram Premium badge in emoji status, white color on chat photos, or another appropriate color in other places
 * @property fileSize <em>Optional</em>. File size in bytes
 *
 * @constructor Creates a [Sticker].
 * */
data class Sticker(
    val fileId: String,
    val fileUniqueId: String,
    val type: String,
    val width: Long,
    val height: Long,
    val isAnimated: Boolean,
    val isVideo: Boolean,
    val thumbnail: PhotoSize? = null,
    val emoji: String? = null,
    val setName: String? = null,
    val premiumAnimation: File? = null,
    val maskPosition: MaskPosition? = null,
    val customEmojiId: String? = null,
    val needsRepainting: Boolean? = null,
    val fileSize: Long? = null,
) : TelegramModel()

/**
 * <p>This object represents a sticker set.</p>
 *
 * @property name Sticker set name
 * @property title Sticker set title
 * @property stickerType Type of stickers in the set, currently one of “regular”, “mask”, “custom_emoji”
 * @property stickers List of all set stickers
 * @property thumbnail <em>Optional</em>. Sticker set thumbnail in the .WEBP, .TGS, or .WEBM format
 *
 * @constructor Creates a [StickerSet].
 * */
data class StickerSet(
    val name: String,
    val title: String,
    val stickerType: String,
    val stickers: List<Sticker>,
    val thumbnail: PhotoSize? = null,
) : TelegramModel()

/**
 * <p>This object describes the position on faces where a mask should be placed by default.</p>
 *
 * @property point The part of the face relative to which the mask should be placed. One of “forehead”, “eyes”, “mouth”, or “chin”.
 * @property xShift Shift by X-axis measured in widths of the mask scaled to the face size, from left to right. For example, choosing -1.0 will place mask just to the left of the default mask position.
 * @property yShift Shift by Y-axis measured in heights of the mask scaled to the face size, from top to bottom. For example, 1.0 will place the mask just below the default mask position.
 * @property scale Mask scaling coefficient. For example, 2.0 means double size.
 *
 * @constructor Creates a [MaskPosition].
 * */
data class MaskPosition(
    val point: String,
    val xShift: Float,
    val yShift: Float,
    val scale: Float,
) : TelegramModel()

/**
 * <p>This object describes a sticker to be added to a sticker set.</p>
 *
 * @property sticker The added sticker. Pass a <em>file_id</em> as a String to send a file that already exists on the Telegram servers, pass an HTTP URL as a String for Telegram to get a file from the Internet, or pass “attach://&lt;file_attach_name&gt;” to upload a new file using multipart/form-data under &lt;file_attach_name&gt; name. Animated and video stickers can't be uploaded via HTTP URL. <a href="#sending-files">More information on Sending Files »</a>
 * @property format Format of the added sticker, must be one of “static” for a <strong>.WEBP</strong> or <strong>.PNG</strong> image, “animated” for a <strong>.TGS</strong> animation, “video” for a <strong>.WEBM</strong> video
 * @property emojiList List of 1-20 emoji associated with the sticker
 * @property maskPosition <em>Optional</em>. Position where the mask should be placed on faces. For “mask” stickers only.
 * @property keywords <em>Optional</em>. List of 0-20 search keywords for the sticker with total length of up to 64 characters. For “regular” and “custom_emoji” stickers only.
 *
 * @constructor Creates a [InputSticker].
 * */
data class InputSticker(
    val sticker: String,
    val format: String,
    val emojiList: List<String>,
    val maskPosition: MaskPosition? = null,
    val keywords: List<String>? = null,
) : TelegramModel()

// Inline mode

/**
 * <p>This object represents an incoming inline query. When the user sends an empty query, your bot could return some default or trending results.</p>
 *
 * @property id Unique identifier for this query
 * @property from Sender
 * @property query Text of the query (up to 256 characters)
 * @property offset Offset of the results to be returned, can be controlled by the bot
 * @property chatType <em>Optional</em>. Type of the chat from which the inline query was sent. Can be either “sender” for a private chat with the inline query sender, “private”, “group”, “supergroup”, or “channel”. The chat type should be always known for requests sent from official clients and most third-party clients, unless the request was sent from a secret chat
 * @property location <em>Optional</em>. Sender location, only for bots that request user location
 *
 * @constructor Creates a [InlineQuery].
 * */
data class InlineQuery(
    val id: String,
    val from: User,
    val query: String,
    val offset: String,
    val chatType: String? = null,
    val location: Location? = null,
) : TelegramModel()

/**
 * <p>This object represents a button to be shown above inline query results. You <strong>must</strong> use exactly one of the optional fields.</p>
 *
 * @property text Label text on the button
 * @property webApp <em>Optional</em>. Description of the <a href="/bots/webapps">Web App</a> that will be launched when the user presses the button. The Web App will be able to switch back to the inline mode using the method <a href="/bots/webapps#initializing-mini-apps">switchInlineQuery</a> inside the Web App.
 * @property startParameter <em>Optional</em>. <a href="/bots/features#deep-linking">Deep-linking</a> parameter for the /start message sent to the bot when a user presses the button. 1-64 characters, only <code>A-Z</code>, <code>a-z</code>, <code>0-9</code>, <code>_</code> and <code>-</code> are allowed.<br><br><em>Example:</em> An inline bot that sends YouTube videos can ask the user to connect the bot to their YouTube account to adapt search results accordingly. To do this, it displays a 'Connect your YouTube account' button above the results, or even before showing any. The user presses the button, switches to a private chat with the bot and, in doing so, passes a start parameter that instructs the bot to return an OAuth link. Once done, the bot can offer a <a href="#inlinekeyboardmarkup"><em>switch_inline</em></a> button so that the user can easily return to the chat where they wanted to use the bot's inline capabilities.
 *
 * @constructor Creates a [InlineQueryResultsButton].
 * */
data class InlineQueryResultsButton(
    val text: String,
    val webApp: WebAppInfo? = null,
    val startParameter: String? = null,
) : TelegramModel()

/**
 * <p>Represents a link to an article or web page.</p>
 *
 * @property type Type of the result, must be <em>article</em>
 * @property id Unique identifier for this result, 1-64 Bytes
 * @property title Title of the result
 * @property inputMessageContent Content of the message to be sent
 * @property replyMarkup <em>Optional</em>. <a href="/bots/features#inline-keyboards">Inline keyboard</a> attached to the message
 * @property url <em>Optional</em>. URL of the result
 * @property description <em>Optional</em>. Short description of the result
 * @property thumbnailUrl <em>Optional</em>. Url of the thumbnail for the result
 * @property thumbnailWidth <em>Optional</em>. Thumbnail width
 * @property thumbnailHeight <em>Optional</em>. Thumbnail height
 *
 * @constructor Creates a [InlineQueryResultArticle].
 * */
data class InlineQueryResultArticle(
    val type: String,
    val id: String,
    val title: String,
    val inputMessageContent: InputMessageContent,
    val replyMarkup: InlineKeyboardMarkup? = null,
    val url: String? = null,
    val description: String? = null,
    val thumbnailUrl: String? = null,
    val thumbnailWidth: Long? = null,
    val thumbnailHeight: Long? = null,
) : InlineQueryResult()

/**
 * <p>Represents a link to a photo. By default, this photo will be sent by the user with optional caption. Alternatively, you can use <em>input_message_content</em> to send a message with the specified content instead of the photo.</p>
 *
 * @property type Type of the result, must be <em>photo</em>
 * @property id Unique identifier for this result, 1-64 bytes
 * @property photoUrl A valid URL of the photo. Photo must be in <strong>JPEG</strong> format. Photo size must not exceed 5MB
 * @property thumbnailUrl URL of the thumbnail for the photo
 * @property photoWidth <em>Optional</em>. Width of the photo
 * @property photoHeight <em>Optional</em>. Height of the photo
 * @property title <em>Optional</em>. Title for the result
 * @property description <em>Optional</em>. Short description of the result
 * @property caption <em>Optional</em>. Caption of the photo to be sent, 0-1024 characters after entities parsing
 * @property parseMode <em>Optional</em>. Mode for parsing entities in the photo caption. See <a href="#formatting-options">formatting options</a> for more details.
 * @property captionEntities <em>Optional</em>. List of special entities that appear in the caption, which can be specified instead of <em>parse_mode</em>
 * @property showCaptionAboveMedia <em>Optional</em>. Pass <em>True</em>, if the caption must be shown above the message media
 * @property replyMarkup <em>Optional</em>. <a href="/bots/features#inline-keyboards">Inline keyboard</a> attached to the message
 * @property inputMessageContent <em>Optional</em>. Content of the message to be sent instead of the photo
 *
 * @constructor Creates a [InlineQueryResultPhoto].
 * */
data class InlineQueryResultPhoto(
    val type: String,
    val id: String,
    val photoUrl: String,
    val thumbnailUrl: String,
    val photoWidth: Long? = null,
    val photoHeight: Long? = null,
    val title: String? = null,
    val description: String? = null,
    val caption: String? = null,
    val parseMode: ParseMode? = null,
    val captionEntities: List<MessageEntity>? = null,
    val showCaptionAboveMedia: Boolean? = null,
    val replyMarkup: InlineKeyboardMarkup? = null,
    val inputMessageContent: InputMessageContent? = null,
) : InlineQueryResult()

/**
 * <p>Represents a link to an animated GIF file. By default, this animated GIF file will be sent by the user with optional caption. Alternatively, you can use <em>input_message_content</em> to send a message with the specified content instead of the animation.</p>
 *
 * @property type Type of the result, must be <em>gif</em>
 * @property id Unique identifier for this result, 1-64 bytes
 * @property gifUrl A valid URL for the GIF file
 * @property gifWidth <em>Optional</em>. Width of the GIF
 * @property gifHeight <em>Optional</em>. Height of the GIF
 * @property gifDuration <em>Optional</em>. Duration of the GIF in seconds
 * @property thumbnailUrl URL of the static (JPEG or GIF) or animated (MPEG4) thumbnail for the result
 * @property thumbnailMimeType <em>Optional</em>. MIME type of the thumbnail, must be one of “image/jpeg”, “image/gif”, or “video/mp4”. Defaults to “image/jpeg”
 * @property title <em>Optional</em>. Title for the result
 * @property caption <em>Optional</em>. Caption of the GIF file to be sent, 0-1024 characters after entities parsing
 * @property parseMode <em>Optional</em>. Mode for parsing entities in the caption. See <a href="#formatting-options">formatting options</a> for more details.
 * @property captionEntities <em>Optional</em>. List of special entities that appear in the caption, which can be specified instead of <em>parse_mode</em>
 * @property showCaptionAboveMedia <em>Optional</em>. Pass <em>True</em>, if the caption must be shown above the message media
 * @property replyMarkup <em>Optional</em>. <a href="/bots/features#inline-keyboards">Inline keyboard</a> attached to the message
 * @property inputMessageContent <em>Optional</em>. Content of the message to be sent instead of the GIF animation
 *
 * @constructor Creates a [InlineQueryResultGif].
 * */
data class InlineQueryResultGif(
    val type: String,
    val id: String,
    val gifUrl: String,
    val gifWidth: Long? = null,
    val gifHeight: Long? = null,
    val gifDuration: Long? = null,
    val thumbnailUrl: String,
    val thumbnailMimeType: String? = null,
    val title: String? = null,
    val caption: String? = null,
    val parseMode: ParseMode? = null,
    val captionEntities: List<MessageEntity>? = null,
    val showCaptionAboveMedia: Boolean? = null,
    val replyMarkup: InlineKeyboardMarkup? = null,
    val inputMessageContent: InputMessageContent? = null,
) : InlineQueryResult()

/**
 * <p>Represents a link to a video animation (H.264/MPEG-4 AVC video without sound). By default, this animated MPEG-4 file will be sent by the user with optional caption. Alternatively, you can use <em>input_message_content</em> to send a message with the specified content instead of the animation.</p>
 *
 * @property type Type of the result, must be <em>mpeg4_gif</em>
 * @property id Unique identifier for this result, 1-64 bytes
 * @property mpeg4Url A valid URL for the MPEG4 file
 * @property mpeg4Width <em>Optional</em>. Video width
 * @property mpeg4Height <em>Optional</em>. Video height
 * @property mpeg4Duration <em>Optional</em>. Video duration in seconds
 * @property thumbnailUrl URL of the static (JPEG or GIF) or animated (MPEG4) thumbnail for the result
 * @property thumbnailMimeType <em>Optional</em>. MIME type of the thumbnail, must be one of “image/jpeg”, “image/gif”, or “video/mp4”. Defaults to “image/jpeg”
 * @property title <em>Optional</em>. Title for the result
 * @property caption <em>Optional</em>. Caption of the MPEG-4 file to be sent, 0-1024 characters after entities parsing
 * @property parseMode <em>Optional</em>. Mode for parsing entities in the caption. See <a href="#formatting-options">formatting options</a> for more details.
 * @property captionEntities <em>Optional</em>. List of special entities that appear in the caption, which can be specified instead of <em>parse_mode</em>
 * @property showCaptionAboveMedia <em>Optional</em>. Pass <em>True</em>, if the caption must be shown above the message media
 * @property replyMarkup <em>Optional</em>. <a href="/bots/features#inline-keyboards">Inline keyboard</a> attached to the message
 * @property inputMessageContent <em>Optional</em>. Content of the message to be sent instead of the video animation
 *
 * @constructor Creates a [InlineQueryResultMpeg4Gif].
 * */
data class InlineQueryResultMpeg4Gif(
    val type: String,
    val id: String,
    val mpeg4Url: String,
    val mpeg4Width: Long? = null,
    val mpeg4Height: Long? = null,
    val mpeg4Duration: Long? = null,
    val thumbnailUrl: String,
    val thumbnailMimeType: String? = null,
    val title: String? = null,
    val caption: String? = null,
    val parseMode: ParseMode? = null,
    val captionEntities: List<MessageEntity>? = null,
    val showCaptionAboveMedia: Boolean? = null,
    val replyMarkup: InlineKeyboardMarkup? = null,
    val inputMessageContent: InputMessageContent? = null,
) : InlineQueryResult()

/**
 * <p>Represents a link to a page containing an embedded video player or a video file. By default, this video file will be sent by the user with an optional caption. Alternatively, you can use <em>input_message_content</em> to send a message with the specified content instead of the video.</p><blockquote>
 *  <p>If an InlineQueryResultVideo message contains an embedded video (e.g., YouTube), you <strong>must</strong> replace its content using <em>input_message_content</em>.</p>
 * </blockquote>
 *
 * @property type Type of the result, must be <em>video</em>
 * @property id Unique identifier for this result, 1-64 bytes
 * @property videoUrl A valid URL for the embedded video player or video file
 * @property mimeType MIME type of the content of the video URL, “text/html” or “video/mp4”
 * @property thumbnailUrl URL of the thumbnail (JPEG only) for the video
 * @property title Title for the result
 * @property caption <em>Optional</em>. Caption of the video to be sent, 0-1024 characters after entities parsing
 * @property parseMode <em>Optional</em>. Mode for parsing entities in the video caption. See <a href="#formatting-options">formatting options</a> for more details.
 * @property captionEntities <em>Optional</em>. List of special entities that appear in the caption, which can be specified instead of <em>parse_mode</em>
 * @property showCaptionAboveMedia <em>Optional</em>. Pass <em>True</em>, if the caption must be shown above the message media
 * @property videoWidth <em>Optional</em>. Video width
 * @property videoHeight <em>Optional</em>. Video height
 * @property videoDuration <em>Optional</em>. Video duration in seconds
 * @property description <em>Optional</em>. Short description of the result
 * @property replyMarkup <em>Optional</em>. <a href="/bots/features#inline-keyboards">Inline keyboard</a> attached to the message
 * @property inputMessageContent <em>Optional</em>. Content of the message to be sent instead of the video. This field is <strong>required</strong> if InlineQueryResultVideo is used to send an HTML-page as a result (e.g., a YouTube video).
 *
 * @constructor Creates a [InlineQueryResultVideo].
 * */
data class InlineQueryResultVideo(
    val type: String,
    val id: String,
    val videoUrl: String,
    val mimeType: String,
    val thumbnailUrl: String,
    val title: String,
    val caption: String? = null,
    val parseMode: ParseMode? = null,
    val captionEntities: List<MessageEntity>? = null,
    val showCaptionAboveMedia: Boolean? = null,
    val videoWidth: Long? = null,
    val videoHeight: Long? = null,
    val videoDuration: Long? = null,
    val description: String? = null,
    val replyMarkup: InlineKeyboardMarkup? = null,
    val inputMessageContent: InputMessageContent? = null,
) : InlineQueryResult()

/**
 * <p>Represents a link to an MP3 audio file. By default, this audio file will be sent by the user. Alternatively, you can use <em>input_message_content</em> to send a message with the specified content instead of the audio.</p>
 *
 * @property type Type of the result, must be <em>audio</em>
 * @property id Unique identifier for this result, 1-64 bytes
 * @property audioUrl A valid URL for the audio file
 * @property title Title
 * @property caption <em>Optional</em>. Caption, 0-1024 characters after entities parsing
 * @property parseMode <em>Optional</em>. Mode for parsing entities in the audio caption. See <a href="#formatting-options">formatting options</a> for more details.
 * @property captionEntities <em>Optional</em>. List of special entities that appear in the caption, which can be specified instead of <em>parse_mode</em>
 * @property performer <em>Optional</em>. Performer
 * @property audioDuration <em>Optional</em>. Audio duration in seconds
 * @property replyMarkup <em>Optional</em>. <a href="/bots/features#inline-keyboards">Inline keyboard</a> attached to the message
 * @property inputMessageContent <em>Optional</em>. Content of the message to be sent instead of the audio
 *
 * @constructor Creates a [InlineQueryResultAudio].
 * */
data class InlineQueryResultAudio(
    val type: String,
    val id: String,
    val audioUrl: String,
    val title: String,
    val caption: String? = null,
    val parseMode: ParseMode? = null,
    val captionEntities: List<MessageEntity>? = null,
    val performer: String? = null,
    val audioDuration: Long? = null,
    val replyMarkup: InlineKeyboardMarkup? = null,
    val inputMessageContent: InputMessageContent? = null,
) : InlineQueryResult()

/**
 * <p>Represents a link to a voice recording in an .OGG container encoded with OPUS. By default, this voice recording will be sent by the user. Alternatively, you can use <em>input_message_content</em> to send a message with the specified content instead of the the voice message.</p>
 *
 * @property type Type of the result, must be <em>voice</em>
 * @property id Unique identifier for this result, 1-64 bytes
 * @property voiceUrl A valid URL for the voice recording
 * @property title Recording title
 * @property caption <em>Optional</em>. Caption, 0-1024 characters after entities parsing
 * @property parseMode <em>Optional</em>. Mode for parsing entities in the voice message caption. See <a href="#formatting-options">formatting options</a> for more details.
 * @property captionEntities <em>Optional</em>. List of special entities that appear in the caption, which can be specified instead of <em>parse_mode</em>
 * @property voiceDuration <em>Optional</em>. Recording duration in seconds
 * @property replyMarkup <em>Optional</em>. <a href="/bots/features#inline-keyboards">Inline keyboard</a> attached to the message
 * @property inputMessageContent <em>Optional</em>. Content of the message to be sent instead of the voice recording
 *
 * @constructor Creates a [InlineQueryResultVoice].
 * */
data class InlineQueryResultVoice(
    val type: String,
    val id: String,
    val voiceUrl: String,
    val title: String,
    val caption: String? = null,
    val parseMode: ParseMode? = null,
    val captionEntities: List<MessageEntity>? = null,
    val voiceDuration: Long? = null,
    val replyMarkup: InlineKeyboardMarkup? = null,
    val inputMessageContent: InputMessageContent? = null,
) : InlineQueryResult()

/**
 * <p>Represents a link to a file. By default, this file will be sent by the user with an optional caption. Alternatively, you can use <em>input_message_content</em> to send a message with the specified content instead of the file. Currently, only <strong>.PDF</strong> and <strong>.ZIP</strong> files can be sent using this method.</p>
 *
 * @property type Type of the result, must be <em>document</em>
 * @property id Unique identifier for this result, 1-64 bytes
 * @property title Title for the result
 * @property caption <em>Optional</em>. Caption of the document to be sent, 0-1024 characters after entities parsing
 * @property parseMode <em>Optional</em>. Mode for parsing entities in the document caption. See <a href="#formatting-options">formatting options</a> for more details.
 * @property captionEntities <em>Optional</em>. List of special entities that appear in the caption, which can be specified instead of <em>parse_mode</em>
 * @property documentUrl A valid URL for the file
 * @property mimeType MIME type of the content of the file, either “application/pdf” or “application/zip”
 * @property description <em>Optional</em>. Short description of the result
 * @property replyMarkup <em>Optional</em>. Inline keyboard attached to the message
 * @property inputMessageContent <em>Optional</em>. Content of the message to be sent instead of the file
 * @property thumbnailUrl <em>Optional</em>. URL of the thumbnail (JPEG only) for the file
 * @property thumbnailWidth <em>Optional</em>. Thumbnail width
 * @property thumbnailHeight <em>Optional</em>. Thumbnail height
 *
 * @constructor Creates a [InlineQueryResultDocument].
 * */
data class InlineQueryResultDocument(
    val type: String,
    val id: String,
    val title: String,
    val caption: String? = null,
    val parseMode: ParseMode? = null,
    val captionEntities: List<MessageEntity>? = null,
    val documentUrl: String,
    val mimeType: String,
    val description: String? = null,
    val replyMarkup: InlineKeyboardMarkup? = null,
    val inputMessageContent: InputMessageContent? = null,
    val thumbnailUrl: String? = null,
    val thumbnailWidth: Long? = null,
    val thumbnailHeight: Long? = null,
) : InlineQueryResult()

/**
 * <p>Represents a location on a map. By default, the location will be sent by the user. Alternatively, you can use <em>input_message_content</em> to send a message with the specified content instead of the location.</p>
 *
 * @property type Type of the result, must be <em>location</em>
 * @property id Unique identifier for this result, 1-64 Bytes
 * @property latitude Location latitude in degrees
 * @property longitude Location longitude in degrees
 * @property title Location title
 * @property horizontalAccuracy <em>Optional</em>. The radius of uncertainty for the location, measured in meters; 0-1500
 * @property livePeriod <em>Optional</em>. Period in seconds during which the location can be updated, should be between 60 and 86400, or 0x7FFFFFFF for live locations that can be edited indefinitely.
 * @property heading <em>Optional</em>. For live locations, a direction in which the user is moving, in degrees. Must be between 1 and 360 if specified.
 * @property proximityAlertRadius <em>Optional</em>. For live locations, a maximum distance for proximity alerts about approaching another chat member, in meters. Must be between 1 and 100000 if specified.
 * @property replyMarkup <em>Optional</em>. <a href="/bots/features#inline-keyboards">Inline keyboard</a> attached to the message
 * @property inputMessageContent <em>Optional</em>. Content of the message to be sent instead of the location
 * @property thumbnailUrl <em>Optional</em>. Url of the thumbnail for the result
 * @property thumbnailWidth <em>Optional</em>. Thumbnail width
 * @property thumbnailHeight <em>Optional</em>. Thumbnail height
 *
 * @constructor Creates a [InlineQueryResultLocation].
 * */
data class InlineQueryResultLocation(
    val type: String,
    val id: String,
    val latitude: Float,
    val longitude: Float,
    val title: String,
    val horizontalAccuracy: Float? = null,
    val livePeriod: Long? = null,
    val heading: Long? = null,
    val proximityAlertRadius: Long? = null,
    val replyMarkup: InlineKeyboardMarkup? = null,
    val inputMessageContent: InputMessageContent? = null,
    val thumbnailUrl: String? = null,
    val thumbnailWidth: Long? = null,
    val thumbnailHeight: Long? = null,
) : InlineQueryResult()

/**
 * <p>Represents a venue. By default, the venue will be sent by the user. Alternatively, you can use <em>input_message_content</em> to send a message with the specified content instead of the venue.</p>
 *
 * @property type Type of the result, must be <em>venue</em>
 * @property id Unique identifier for this result, 1-64 Bytes
 * @property latitude Latitude of the venue location in degrees
 * @property longitude Longitude of the venue location in degrees
 * @property title Title of the venue
 * @property address Address of the venue
 * @property foursquareId <em>Optional</em>. Foursquare identifier of the venue if known
 * @property foursquareType <em>Optional</em>. Foursquare type of the venue, if known. (For example, “arts_entertainment/default”, “arts_entertainment/aquarium” or “food/icecream”.)
 * @property googlePlaceId <em>Optional</em>. Google Places identifier of the venue
 * @property googlePlaceType <em>Optional</em>. Google Places type of the venue. (See <a href="https://developers.google.com/places/web-service/supported_types">supported types</a>.)
 * @property replyMarkup <em>Optional</em>. <a href="/bots/features#inline-keyboards">Inline keyboard</a> attached to the message
 * @property inputMessageContent <em>Optional</em>. Content of the message to be sent instead of the venue
 * @property thumbnailUrl <em>Optional</em>. Url of the thumbnail for the result
 * @property thumbnailWidth <em>Optional</em>. Thumbnail width
 * @property thumbnailHeight <em>Optional</em>. Thumbnail height
 *
 * @constructor Creates a [InlineQueryResultVenue].
 * */
data class InlineQueryResultVenue(
    val type: String,
    val id: String,
    val latitude: Float,
    val longitude: Float,
    val title: String,
    val address: String,
    val foursquareId: String? = null,
    val foursquareType: String? = null,
    val googlePlaceId: String? = null,
    val googlePlaceType: String? = null,
    val replyMarkup: InlineKeyboardMarkup? = null,
    val inputMessageContent: InputMessageContent? = null,
    val thumbnailUrl: String? = null,
    val thumbnailWidth: Long? = null,
    val thumbnailHeight: Long? = null,
) : InlineQueryResult()

/**
 * <p>Represents a contact with a phone number. By default, this contact will be sent by the user. Alternatively, you can use <em>input_message_content</em> to send a message with the specified content instead of the contact.</p>
 *
 * @property type Type of the result, must be <em>contact</em>
 * @property id Unique identifier for this result, 1-64 Bytes
 * @property phoneNumber Contact's phone number
 * @property firstName Contact's first name
 * @property lastName <em>Optional</em>. Contact's last name
 * @property vcard <em>Optional</em>. Additional data about the contact in the form of a <a href="https://en.wikipedia.org/wiki/VCard">vCard</a>, 0-2048 bytes
 * @property replyMarkup <em>Optional</em>. <a href="/bots/features#inline-keyboards">Inline keyboard</a> attached to the message
 * @property inputMessageContent <em>Optional</em>. Content of the message to be sent instead of the contact
 * @property thumbnailUrl <em>Optional</em>. Url of the thumbnail for the result
 * @property thumbnailWidth <em>Optional</em>. Thumbnail width
 * @property thumbnailHeight <em>Optional</em>. Thumbnail height
 *
 * @constructor Creates a [InlineQueryResultContact].
 * */
data class InlineQueryResultContact(
    val type: String,
    val id: String,
    val phoneNumber: String,
    val firstName: String,
    val lastName: String? = null,
    val vcard: String? = null,
    val replyMarkup: InlineKeyboardMarkup? = null,
    val inputMessageContent: InputMessageContent? = null,
    val thumbnailUrl: String? = null,
    val thumbnailWidth: Long? = null,
    val thumbnailHeight: Long? = null,
) : InlineQueryResult()

/**
 * <p>Represents a <a href="#games">Game</a>.</p>
 *
 * @property type Type of the result, must be <em>game</em>
 * @property id Unique identifier for this result, 1-64 bytes
 * @property gameShortName Short name of the game
 * @property replyMarkup <em>Optional</em>. <a href="/bots/features#inline-keyboards">Inline keyboard</a> attached to the message
 *
 * @constructor Creates a [InlineQueryResultGame].
 * */
data class InlineQueryResultGame(
    val type: String,
    val id: String,
    val gameShortName: String,
    val replyMarkup: InlineKeyboardMarkup? = null,
) : InlineQueryResult()

/**
 * <p>Represents a link to a photo stored on the Telegram servers. By default, this photo will be sent by the user with an optional caption. Alternatively, you can use <em>input_message_content</em> to send a message with the specified content instead of the photo.</p>
 *
 * @property type Type of the result, must be <em>photo</em>
 * @property id Unique identifier for this result, 1-64 bytes
 * @property photoFileId A valid file identifier of the photo
 * @property title <em>Optional</em>. Title for the result
 * @property description <em>Optional</em>. Short description of the result
 * @property caption <em>Optional</em>. Caption of the photo to be sent, 0-1024 characters after entities parsing
 * @property parseMode <em>Optional</em>. Mode for parsing entities in the photo caption. See <a href="#formatting-options">formatting options</a> for more details.
 * @property captionEntities <em>Optional</em>. List of special entities that appear in the caption, which can be specified instead of <em>parse_mode</em>
 * @property showCaptionAboveMedia <em>Optional</em>. Pass <em>True</em>, if the caption must be shown above the message media
 * @property replyMarkup <em>Optional</em>. <a href="/bots/features#inline-keyboards">Inline keyboard</a> attached to the message
 * @property inputMessageContent <em>Optional</em>. Content of the message to be sent instead of the photo
 *
 * @constructor Creates a [InlineQueryResultCachedPhoto].
 * */
data class InlineQueryResultCachedPhoto(
    val type: String,
    val id: String,
    val photoFileId: String,
    val title: String? = null,
    val description: String? = null,
    val caption: String? = null,
    val parseMode: ParseMode? = null,
    val captionEntities: List<MessageEntity>? = null,
    val showCaptionAboveMedia: Boolean? = null,
    val replyMarkup: InlineKeyboardMarkup? = null,
    val inputMessageContent: InputMessageContent? = null,
) : InlineQueryResult()

/**
 * <p>Represents a link to an animated GIF file stored on the Telegram servers. By default, this animated GIF file will be sent by the user with an optional caption. Alternatively, you can use <em>input_message_content</em> to send a message with specified content instead of the animation.</p>
 *
 * @property type Type of the result, must be <em>gif</em>
 * @property id Unique identifier for this result, 1-64 bytes
 * @property gifFileId A valid file identifier for the GIF file
 * @property title <em>Optional</em>. Title for the result
 * @property caption <em>Optional</em>. Caption of the GIF file to be sent, 0-1024 characters after entities parsing
 * @property parseMode <em>Optional</em>. Mode for parsing entities in the caption. See <a href="#formatting-options">formatting options</a> for more details.
 * @property captionEntities <em>Optional</em>. List of special entities that appear in the caption, which can be specified instead of <em>parse_mode</em>
 * @property showCaptionAboveMedia <em>Optional</em>. Pass <em>True</em>, if the caption must be shown above the message media
 * @property replyMarkup <em>Optional</em>. <a href="/bots/features#inline-keyboards">Inline keyboard</a> attached to the message
 * @property inputMessageContent <em>Optional</em>. Content of the message to be sent instead of the GIF animation
 *
 * @constructor Creates a [InlineQueryResultCachedGif].
 * */
data class InlineQueryResultCachedGif(
    val type: String,
    val id: String,
    val gifFileId: String,
    val title: String? = null,
    val caption: String? = null,
    val parseMode: ParseMode? = null,
    val captionEntities: List<MessageEntity>? = null,
    val showCaptionAboveMedia: Boolean? = null,
    val replyMarkup: InlineKeyboardMarkup? = null,
    val inputMessageContent: InputMessageContent? = null,
) : InlineQueryResult()

/**
 * <p>Represents a link to a video animation (H.264/MPEG-4 AVC video without sound) stored on the Telegram servers. By default, this animated MPEG-4 file will be sent by the user with an optional caption. Alternatively, you can use <em>input_message_content</em> to send a message with the specified content instead of the animation.</p>
 *
 * @property type Type of the result, must be <em>mpeg4_gif</em>
 * @property id Unique identifier for this result, 1-64 bytes
 * @property mpeg4FileId A valid file identifier for the MPEG4 file
 * @property title <em>Optional</em>. Title for the result
 * @property caption <em>Optional</em>. Caption of the MPEG-4 file to be sent, 0-1024 characters after entities parsing
 * @property parseMode <em>Optional</em>. Mode for parsing entities in the caption. See <a href="#formatting-options">formatting options</a> for more details.
 * @property captionEntities <em>Optional</em>. List of special entities that appear in the caption, which can be specified instead of <em>parse_mode</em>
 * @property showCaptionAboveMedia <em>Optional</em>. Pass <em>True</em>, if the caption must be shown above the message media
 * @property replyMarkup <em>Optional</em>. <a href="/bots/features#inline-keyboards">Inline keyboard</a> attached to the message
 * @property inputMessageContent <em>Optional</em>. Content of the message to be sent instead of the video animation
 *
 * @constructor Creates a [InlineQueryResultCachedMpeg4Gif].
 * */
data class InlineQueryResultCachedMpeg4Gif(
    val type: String,
    val id: String,
    val mpeg4FileId: String,
    val title: String? = null,
    val caption: String? = null,
    val parseMode: ParseMode? = null,
    val captionEntities: List<MessageEntity>? = null,
    val showCaptionAboveMedia: Boolean? = null,
    val replyMarkup: InlineKeyboardMarkup? = null,
    val inputMessageContent: InputMessageContent? = null,
) : InlineQueryResult()

/**
 * <p>Represents a link to a sticker stored on the Telegram servers. By default, this sticker will be sent by the user. Alternatively, you can use <em>input_message_content</em> to send a message with the specified content instead of the sticker.</p>
 *
 * @property type Type of the result, must be <em>sticker</em>
 * @property id Unique identifier for this result, 1-64 bytes
 * @property stickerFileId A valid file identifier of the sticker
 * @property replyMarkup <em>Optional</em>. <a href="/bots/features#inline-keyboards">Inline keyboard</a> attached to the message
 * @property inputMessageContent <em>Optional</em>. Content of the message to be sent instead of the sticker
 *
 * @constructor Creates a [InlineQueryResultCachedSticker].
 * */
data class InlineQueryResultCachedSticker(
    val type: String,
    val id: String,
    val stickerFileId: String,
    val replyMarkup: InlineKeyboardMarkup? = null,
    val inputMessageContent: InputMessageContent? = null,
) : InlineQueryResult()

/**
 * <p>Represents a link to a file stored on the Telegram servers. By default, this file will be sent by the user with an optional caption. Alternatively, you can use <em>input_message_content</em> to send a message with the specified content instead of the file.</p>
 *
 * @property type Type of the result, must be <em>document</em>
 * @property id Unique identifier for this result, 1-64 bytes
 * @property title Title for the result
 * @property documentFileId A valid file identifier for the file
 * @property description <em>Optional</em>. Short description of the result
 * @property caption <em>Optional</em>. Caption of the document to be sent, 0-1024 characters after entities parsing
 * @property parseMode <em>Optional</em>. Mode for parsing entities in the document caption. See <a href="#formatting-options">formatting options</a> for more details.
 * @property captionEntities <em>Optional</em>. List of special entities that appear in the caption, which can be specified instead of <em>parse_mode</em>
 * @property replyMarkup <em>Optional</em>. <a href="/bots/features#inline-keyboards">Inline keyboard</a> attached to the message
 * @property inputMessageContent <em>Optional</em>. Content of the message to be sent instead of the file
 *
 * @constructor Creates a [InlineQueryResultCachedDocument].
 * */
data class InlineQueryResultCachedDocument(
    val type: String,
    val id: String,
    val title: String,
    val documentFileId: String,
    val description: String? = null,
    val caption: String? = null,
    val parseMode: ParseMode? = null,
    val captionEntities: List<MessageEntity>? = null,
    val replyMarkup: InlineKeyboardMarkup? = null,
    val inputMessageContent: InputMessageContent? = null,
) : InlineQueryResult()

/**
 * <p>Represents a link to a video file stored on the Telegram servers. By default, this video file will be sent by the user with an optional caption. Alternatively, you can use <em>input_message_content</em> to send a message with the specified content instead of the video.</p>
 *
 * @property type Type of the result, must be <em>video</em>
 * @property id Unique identifier for this result, 1-64 bytes
 * @property videoFileId A valid file identifier for the video file
 * @property title Title for the result
 * @property description <em>Optional</em>. Short description of the result
 * @property caption <em>Optional</em>. Caption of the video to be sent, 0-1024 characters after entities parsing
 * @property parseMode <em>Optional</em>. Mode for parsing entities in the video caption. See <a href="#formatting-options">formatting options</a> for more details.
 * @property captionEntities <em>Optional</em>. List of special entities that appear in the caption, which can be specified instead of <em>parse_mode</em>
 * @property showCaptionAboveMedia <em>Optional</em>. Pass <em>True</em>, if the caption must be shown above the message media
 * @property replyMarkup <em>Optional</em>. <a href="/bots/features#inline-keyboards">Inline keyboard</a> attached to the message
 * @property inputMessageContent <em>Optional</em>. Content of the message to be sent instead of the video
 *
 * @constructor Creates a [InlineQueryResultCachedVideo].
 * */
data class InlineQueryResultCachedVideo(
    val type: String,
    val id: String,
    val videoFileId: String,
    val title: String,
    val description: String? = null,
    val caption: String? = null,
    val parseMode: ParseMode? = null,
    val captionEntities: List<MessageEntity>? = null,
    val showCaptionAboveMedia: Boolean? = null,
    val replyMarkup: InlineKeyboardMarkup? = null,
    val inputMessageContent: InputMessageContent? = null,
) : InlineQueryResult()

/**
 * <p>Represents a link to a voice message stored on the Telegram servers. By default, this voice message will be sent by the user. Alternatively, you can use <em>input_message_content</em> to send a message with the specified content instead of the voice message.</p>
 *
 * @property type Type of the result, must be <em>voice</em>
 * @property id Unique identifier for this result, 1-64 bytes
 * @property voiceFileId A valid file identifier for the voice message
 * @property title Voice message title
 * @property caption <em>Optional</em>. Caption, 0-1024 characters after entities parsing
 * @property parseMode <em>Optional</em>. Mode for parsing entities in the voice message caption. See <a href="#formatting-options">formatting options</a> for more details.
 * @property captionEntities <em>Optional</em>. List of special entities that appear in the caption, which can be specified instead of <em>parse_mode</em>
 * @property replyMarkup <em>Optional</em>. <a href="/bots/features#inline-keyboards">Inline keyboard</a> attached to the message
 * @property inputMessageContent <em>Optional</em>. Content of the message to be sent instead of the voice message
 *
 * @constructor Creates a [InlineQueryResultCachedVoice].
 * */
data class InlineQueryResultCachedVoice(
    val type: String,
    val id: String,
    val voiceFileId: String,
    val title: String,
    val caption: String? = null,
    val parseMode: ParseMode? = null,
    val captionEntities: List<MessageEntity>? = null,
    val replyMarkup: InlineKeyboardMarkup? = null,
    val inputMessageContent: InputMessageContent? = null,
) : InlineQueryResult()

/**
 * <p>Represents a link to an MP3 audio file stored on the Telegram servers. By default, this audio file will be sent by the user. Alternatively, you can use <em>input_message_content</em> to send a message with the specified content instead of the audio.</p>
 *
 * @property type Type of the result, must be <em>audio</em>
 * @property id Unique identifier for this result, 1-64 bytes
 * @property audioFileId A valid file identifier for the audio file
 * @property caption <em>Optional</em>. Caption, 0-1024 characters after entities parsing
 * @property parseMode <em>Optional</em>. Mode for parsing entities in the audio caption. See <a href="#formatting-options">formatting options</a> for more details.
 * @property captionEntities <em>Optional</em>. List of special entities that appear in the caption, which can be specified instead of <em>parse_mode</em>
 * @property replyMarkup <em>Optional</em>. <a href="/bots/features#inline-keyboards">Inline keyboard</a> attached to the message
 * @property inputMessageContent <em>Optional</em>. Content of the message to be sent instead of the audio
 *
 * @constructor Creates a [InlineQueryResultCachedAudio].
 * */
data class InlineQueryResultCachedAudio(
    val type: String,
    val id: String,
    val audioFileId: String,
    val caption: String? = null,
    val parseMode: ParseMode? = null,
    val captionEntities: List<MessageEntity>? = null,
    val replyMarkup: InlineKeyboardMarkup? = null,
    val inputMessageContent: InputMessageContent? = null,
) : InlineQueryResult()

/**
 * <p>Represents the <a href="#inputmessagecontent">content</a> of a text message to be sent as the result of an inline query.</p>
 *
 * @property messageText Text of the message to be sent, 1-4096 characters
 * @property parseMode <em>Optional</em>. Mode for parsing entities in the message text. See <a href="#formatting-options">formatting options</a> for more details.
 * @property entities <em>Optional</em>. List of special entities that appear in message text, which can be specified instead of <em>parse_mode</em>
 * @property linkPreviewOptions <em>Optional</em>. Link preview generation options for the message
 *
 * @constructor Creates a [InputTextMessageContent].
 * */
data class InputTextMessageContent(
    val messageText: String,
    val parseMode: ParseMode? = null,
    val entities: List<MessageEntity>? = null,
    val linkPreviewOptions: LinkPreviewOptions? = null,
) : InputMessageContent()

/**
 * <p>Represents the <a href="#inputmessagecontent">content</a> of a location message to be sent as the result of an inline query.</p>
 *
 * @property latitude Latitude of the location in degrees
 * @property longitude Longitude of the location in degrees
 * @property horizontalAccuracy <em>Optional</em>. The radius of uncertainty for the location, measured in meters; 0-1500
 * @property livePeriod <em>Optional</em>. Period in seconds during which the location can be updated, should be between 60 and 86400, or 0x7FFFFFFF for live locations that can be edited indefinitely.
 * @property heading <em>Optional</em>. For live locations, a direction in which the user is moving, in degrees. Must be between 1 and 360 if specified.
 * @property proximityAlertRadius <em>Optional</em>. For live locations, a maximum distance for proximity alerts about approaching another chat member, in meters. Must be between 1 and 100000 if specified.
 *
 * @constructor Creates a [InputLocationMessageContent].
 * */
data class InputLocationMessageContent(
    val latitude: Float,
    val longitude: Float,
    val horizontalAccuracy: Float? = null,
    val livePeriod: Long? = null,
    val heading: Long? = null,
    val proximityAlertRadius: Long? = null,
) : InputMessageContent()

/**
 * <p>Represents the <a href="#inputmessagecontent">content</a> of a venue message to be sent as the result of an inline query.</p>
 *
 * @property latitude Latitude of the venue in degrees
 * @property longitude Longitude of the venue in degrees
 * @property title Name of the venue
 * @property address Address of the venue
 * @property foursquareId <em>Optional</em>. Foursquare identifier of the venue, if known
 * @property foursquareType <em>Optional</em>. Foursquare type of the venue, if known. (For example, “arts_entertainment/default”, “arts_entertainment/aquarium” or “food/icecream”.)
 * @property googlePlaceId <em>Optional</em>. Google Places identifier of the venue
 * @property googlePlaceType <em>Optional</em>. Google Places type of the venue. (See <a href="https://developers.google.com/places/web-service/supported_types">supported types</a>.)
 *
 * @constructor Creates a [InputVenueMessageContent].
 * */
data class InputVenueMessageContent(
    val latitude: Float,
    val longitude: Float,
    val title: String,
    val address: String,
    val foursquareId: String? = null,
    val foursquareType: String? = null,
    val googlePlaceId: String? = null,
    val googlePlaceType: String? = null,
) : InputMessageContent()

/**
 * <p>Represents the <a href="#inputmessagecontent">content</a> of a contact message to be sent as the result of an inline query.</p>
 *
 * @property phoneNumber Contact's phone number
 * @property firstName Contact's first name
 * @property lastName <em>Optional</em>. Contact's last name
 * @property vcard <em>Optional</em>. Additional data about the contact in the form of a <a href="https://en.wikipedia.org/wiki/VCard">vCard</a>, 0-2048 bytes
 *
 * @constructor Creates a [InputContactMessageContent].
 * */
data class InputContactMessageContent(
    val phoneNumber: String,
    val firstName: String,
    val lastName: String? = null,
    val vcard: String? = null,
) : InputMessageContent()

/**
 * <p>Represents the <a href="#inputmessagecontent">content</a> of an invoice message to be sent as the result of an inline query.</p>
 *
 * @property title Product name, 1-32 characters
 * @property description Product description, 1-255 characters
 * @property payload Bot-defined invoice payload, 1-128 bytes. This will not be displayed to the user, use it for your internal processes.
 * @property providerToken <em>Optional</em>. Payment provider token, obtained via <a href="https://t.me/botfather">@BotFather</a>. Pass an empty string for payments in <a href="https://t.me/BotNews/90">Telegram Stars</a>.
 * @property currency Three-letter ISO 4217 currency code, see <a href="/bots/payments#supported-currencies">more on currencies</a>. Pass “XTR” for payments in <a href="https://t.me/BotNews/90">Telegram Stars</a>.
 * @property prices Price breakdown, a JSON-serialized list of components (e.g. product price, tax, discount, delivery cost, delivery tax, bonus, etc.). Must contain exactly one item for payments in <a href="https://t.me/BotNews/90">Telegram Stars</a>.
 * @property maxTipAmount <em>Optional</em>. The maximum accepted amount for tips in the <em>smallest units</em> of the currency (integer, <strong>not</strong> float/double). For example, for a maximum tip of <code>US$ 1.45</code> pass <code>max_tip_amount = 145</code>. See the <em>exp</em> parameter in <a href="/bots/payments/currencies.json">currencies.json</a>, it shows the number of digits past the decimal point for each currency (2 for the majority of currencies). Defaults to 0. Not supported for payments in <a href="https://t.me/BotNews/90">Telegram Stars</a>.
 * @property suggestedTipAmounts <em>Optional</em>. A JSON-serialized array of suggested amounts of tip in the <em>smallest units</em> of the currency (integer, <strong>not</strong> float/double). At most 4 suggested tip amounts can be specified. The suggested tip amounts must be positive, passed in a strictly increased order and must not exceed <em>max_tip_amount</em>.
 * @property providerData <em>Optional</em>. A JSON-serialized object for data about the invoice, which will be shared with the payment provider. A detailed description of the required fields should be provided by the payment provider.
 * @property photoUrl <em>Optional</em>. URL of the product photo for the invoice. Can be a photo of the goods or a marketing image for a service.
 * @property photoSize <em>Optional</em>. Photo size in bytes
 * @property photoWidth <em>Optional</em>. Photo width
 * @property photoHeight <em>Optional</em>. Photo height
 * @property needName <em>Optional</em>. Pass <em>True</em> if you require the user's full name to complete the order. Ignored for payments in <a href="https://t.me/BotNews/90">Telegram Stars</a>.
 * @property needPhoneNumber <em>Optional</em>. Pass <em>True</em> if you require the user's phone number to complete the order. Ignored for payments in <a href="https://t.me/BotNews/90">Telegram Stars</a>.
 * @property needEmail <em>Optional</em>. Pass <em>True</em> if you require the user's email address to complete the order. Ignored for payments in <a href="https://t.me/BotNews/90">Telegram Stars</a>.
 * @property needShippingAddress <em>Optional</em>. Pass <em>True</em> if you require the user's shipping address to complete the order. Ignored for payments in <a href="https://t.me/BotNews/90">Telegram Stars</a>.
 * @property sendPhoneNumberToProvider <em>Optional</em>. Pass <em>True</em> if the user's phone number should be sent to the provider. Ignored for payments in <a href="https://t.me/BotNews/90">Telegram Stars</a>.
 * @property sendEmailToProvider <em>Optional</em>. Pass <em>True</em> if the user's email address should be sent to the provider. Ignored for payments in <a href="https://t.me/BotNews/90">Telegram Stars</a>.
 * @property isFlexible <em>Optional</em>. Pass <em>True</em> if the final price depends on the shipping method. Ignored for payments in <a href="https://t.me/BotNews/90">Telegram Stars</a>.
 *
 * @constructor Creates a [InputInvoiceMessageContent].
 * */
data class InputInvoiceMessageContent(
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
) : InputMessageContent()

/**
 * <p>Represents a <a href="#inlinequeryresult">result</a> of an inline query that was chosen by the user and sent to their chat partner.</p><p><strong>Note:</strong> It is necessary to enable <a href="/bots/inline#collecting-feedback">inline feedback</a> via <a href="https://t.me/botfather">@BotFather</a> in order to receive these objects in updates.</p>
 *
 * @property resultId The unique identifier for the result that was chosen
 * @property from The user that chose the result
 * @property location <em>Optional</em>. Sender location, only for bots that require user location
 * @property inlineMessageId <em>Optional</em>. Identifier of the sent inline message. Available only if there is an <a href="#inlinekeyboardmarkup">inline keyboard</a> attached to the message. Will be also received in <a href="#callbackquery">callback queries</a> and can be used to <a href="#updating-messages">edit</a> the message.
 * @property query The query that was used to obtain the result
 *
 * @constructor Creates a [ChosenInlineResult].
 * */
data class ChosenInlineResult(
    val resultId: String,
    val from: User,
    val location: Location? = null,
    val inlineMessageId: String? = null,
    val query: String,
) : TelegramModel()

/**
 * <p>Describes an inline message sent by a <a href="/bots/webapps">Web App</a> on behalf of a user.</p>
 *
 * @property inlineMessageId <em>Optional</em>. Identifier of the sent inline message. Available only if there is an <a href="#inlinekeyboardmarkup">inline keyboard</a> attached to the message.
 *
 * @constructor Creates a [SentWebAppMessage].
 * */
data class SentWebAppMessage(
    val inlineMessageId: String? = null,
) : TelegramModel()

/**
 * <p>Describes an inline message to be sent by a user of a Mini App.</p>
 *
 * @property id Unique identifier of the prepared message
 * @property expirationDate Expiration date of the prepared message, in Unix time. Expired prepared messages can no longer be used
 *
 * @constructor Creates a [PreparedInlineMessage].
 * */
data class PreparedInlineMessage(
    val id: String,
    val expirationDate: Long,
) : TelegramModel()

// Payments

/**
 * <p>This object represents a portion of the price for goods or services.</p>
 *
 * @property label Portion label
 * @property amount Price of the product in the <em>smallest units</em> of the <a href="/bots/payments#supported-currencies">currency</a> (integer, <strong>not</strong> float/double). For example, for a price of <code>US$ 1.45</code> pass <code>amount = 145</code>. See the <em>exp</em> parameter in <a href="/bots/payments/currencies.json">currencies.json</a>, it shows the number of digits past the decimal point for each currency (2 for the majority of currencies).
 *
 * @constructor Creates a [LabeledPrice].
 * */
data class LabeledPrice(
    val label: String,
    val amount: Long,
) : TelegramModel()

/**
 * <p>This object contains basic information about an invoice.</p>
 *
 * @property title Product name
 * @property description Product description
 * @property startParameter Unique bot deep-linking parameter that can be used to generate this invoice
 * @property currency Three-letter ISO 4217 <a href="/bots/payments#supported-currencies">currency</a> code, or “XTR” for payments in <a href="https://t.me/BotNews/90">Telegram Stars</a>
 * @property totalAmount Total price in the <em>smallest units</em> of the currency (integer, <strong>not</strong> float/double). For example, for a price of <code>US$ 1.45</code> pass <code>amount = 145</code>. See the <em>exp</em> parameter in <a href="/bots/payments/currencies.json">currencies.json</a>, it shows the number of digits past the decimal point for each currency (2 for the majority of currencies).
 *
 * @constructor Creates a [Invoice].
 * */
data class Invoice(
    val title: String,
    val description: String,
    val startParameter: String,
    val currency: String,
    val totalAmount: Long,
) : TelegramModel()

/**
 * <p>This object represents a shipping address.</p>
 *
 * @property countryCode Two-letter <a href="https://en.wikipedia.org/wiki/ISO_3166-1_alpha-2">ISO 3166-1 alpha-2</a> country code
 * @property state State, if applicable
 * @property city City
 * @property streetLine1 First line for the address
 * @property streetLine2 Second line for the address
 * @property postCode Address post code
 *
 * @constructor Creates a [ShippingAddress].
 * */
data class ShippingAddress(
    val countryCode: String,
    val state: String,
    val city: String,
    val streetLine1: String,
    val streetLine2: String,
    val postCode: String,
) : TelegramModel()

/**
 * <p>This object represents information about an order.</p>
 *
 * @property name <em>Optional</em>. User name
 * @property phoneNumber <em>Optional</em>. User's phone number
 * @property email <em>Optional</em>. User email
 * @property shippingAddress <em>Optional</em>. User shipping address
 *
 * @constructor Creates a [OrderInfo].
 * */
data class OrderInfo(
    val name: String? = null,
    val phoneNumber: String? = null,
    val email: String? = null,
    val shippingAddress: ShippingAddress? = null,
) : TelegramModel()

/**
 * <p>This object represents one shipping option.</p>
 *
 * @property id Shipping option identifier
 * @property title Option title
 * @property prices List of price portions
 *
 * @constructor Creates a [ShippingOption].
 * */
data class ShippingOption(
    val id: String,
    val title: String,
    val prices: List<LabeledPrice>,
) : TelegramModel()

/**
 * <p>This object contains basic information about a successful payment. Note that if the buyer initiates a chargeback with the relevant payment provider following this transaction, the funds may be debited from your balance. This is outside of Telegram's control.</p>
 *
 * @property currency Three-letter ISO 4217 <a href="/bots/payments#supported-currencies">currency</a> code, or “XTR” for payments in <a href="https://t.me/BotNews/90">Telegram Stars</a>
 * @property totalAmount Total price in the <em>smallest units</em> of the currency (integer, <strong>not</strong> float/double). For example, for a price of <code>US$ 1.45</code> pass <code>amount = 145</code>. See the <em>exp</em> parameter in <a href="/bots/payments/currencies.json">currencies.json</a>, it shows the number of digits past the decimal point for each currency (2 for the majority of currencies).
 * @property invoicePayload Bot-specified invoice payload
 * @property subscriptionExpirationDate <em>Optional</em>. Expiration date of the subscription, in Unix time; for recurring payments only
 * @property isRecurring <em>Optional</em>. <em>True</em>, if the payment is a recurring payment for a subscription
 * @property isFirstRecurring <em>Optional</em>. <em>True</em>, if the payment is the first payment for a subscription
 * @property shippingOptionId <em>Optional</em>. Identifier of the shipping option chosen by the user
 * @property orderInfo <em>Optional</em>. Order information provided by the user
 * @property telegramPaymentChargeId Telegram payment identifier
 * @property providerPaymentChargeId Provider payment identifier
 *
 * @constructor Creates a [SuccessfulPayment].
 * */
data class SuccessfulPayment(
    val currency: String,
    val totalAmount: Long,
    val invoicePayload: String,
    val subscriptionExpirationDate: Long? = null,
    val isRecurring: Boolean? = null,
    val isFirstRecurring: Boolean? = null,
    val shippingOptionId: String? = null,
    val orderInfo: OrderInfo? = null,
    val telegramPaymentChargeId: String,
    val providerPaymentChargeId: String,
) : TelegramModel()

/**
 * <p>This object contains basic information about a refunded payment.</p>
 *
 * @property currency Three-letter ISO 4217 <a href="/bots/payments#supported-currencies">currency</a> code, or “XTR” for payments in <a href="https://t.me/BotNews/90">Telegram Stars</a>. Currently, always “XTR”
 * @property totalAmount Total refunded price in the <em>smallest units</em> of the currency (integer, <strong>not</strong> float/double). For example, for a price of <code>US$ 1.45</code>, <code>total_amount = 145</code>. See the <em>exp</em> parameter in <a href="/bots/payments/currencies.json">currencies.json</a>, it shows the number of digits past the decimal point for each currency (2 for the majority of currencies).
 * @property invoicePayload Bot-specified invoice payload
 * @property telegramPaymentChargeId Telegram payment identifier
 * @property providerPaymentChargeId <em>Optional</em>. Provider payment identifier
 *
 * @constructor Creates a [RefundedPayment].
 * */
data class RefundedPayment(
    val currency: String,
    val totalAmount: Long,
    val invoicePayload: String,
    val telegramPaymentChargeId: String,
    val providerPaymentChargeId: String? = null,
) : TelegramModel()

/**
 * <p>This object contains information about an incoming shipping query.</p>
 *
 * @property id Unique query identifier
 * @property from User who sent the query
 * @property invoicePayload Bot-specified invoice payload
 * @property shippingAddress User specified shipping address
 *
 * @constructor Creates a [ShippingQuery].
 * */
data class ShippingQuery(
    val id: String,
    val from: User,
    val invoicePayload: String,
    val shippingAddress: ShippingAddress,
) : TelegramModel()

/**
 * <p>This object contains information about an incoming pre-checkout query.</p>
 *
 * @property id Unique query identifier
 * @property from User who sent the query
 * @property currency Three-letter ISO 4217 <a href="/bots/payments#supported-currencies">currency</a> code, or “XTR” for payments in <a href="https://t.me/BotNews/90">Telegram Stars</a>
 * @property totalAmount Total price in the <em>smallest units</em> of the currency (integer, <strong>not</strong> float/double). For example, for a price of <code>US$ 1.45</code> pass <code>amount = 145</code>. See the <em>exp</em> parameter in <a href="/bots/payments/currencies.json">currencies.json</a>, it shows the number of digits past the decimal point for each currency (2 for the majority of currencies).
 * @property invoicePayload Bot-specified invoice payload
 * @property shippingOptionId <em>Optional</em>. Identifier of the shipping option chosen by the user
 * @property orderInfo <em>Optional</em>. Order information provided by the user
 *
 * @constructor Creates a [PreCheckoutQuery].
 * */
data class PreCheckoutQuery(
    val id: String,
    val from: User,
    val currency: String,
    val totalAmount: Long,
    val invoicePayload: String,
    val shippingOptionId: String? = null,
    val orderInfo: OrderInfo? = null,
) : TelegramModel()

/**
 * <p>This object contains information about a paid media purchase.</p>
 *
 * @property from User who purchased the media
 * @property paidMediaPayload Bot-specified paid media payload
 *
 * @constructor Creates a [PaidMediaPurchased].
 * */
data class PaidMediaPurchased(
    val from: User,
    val paidMediaPayload: String,
) : TelegramModel()

/**
 * <p>The withdrawal is in progress.</p>
 *
 * @property type Type of the state, always “pending”
 *
 * @constructor Creates a [RevenueWithdrawalStatePending].
 * */
data class RevenueWithdrawalStatePending(
    val type: String,
) : RevenueWithdrawalState()

/**
 * <p>The withdrawal succeeded.</p>
 *
 * @property type Type of the state, always “succeeded”
 * @property date Date the withdrawal was completed in Unix time
 * @property url An HTTPS URL that can be used to see transaction details
 *
 * @constructor Creates a [RevenueWithdrawalStateSucceeded].
 * */
data class RevenueWithdrawalStateSucceeded(
    val type: String,
    val date: Long,
    val url: String,
) : RevenueWithdrawalState()

/**
 * <p>The withdrawal failed and the transaction was refunded.</p>
 *
 * @property type Type of the state, always “failed”
 *
 * @constructor Creates a [RevenueWithdrawalStateFailed].
 * */
data class RevenueWithdrawalStateFailed(
    val type: String,
) : RevenueWithdrawalState()

/**
 * <p>Contains information about the affiliate that received a commission via this transaction.</p>
 *
 * @property affiliateUser <em>Optional</em>. The bot or the user that received an affiliate commission if it was received by a bot or a user
 * @property affiliateChat <em>Optional</em>. The chat that received an affiliate commission if it was received by a chat
 * @property commissionPerMille The number of Telegram Stars received by the affiliate for each 1000 Telegram Stars received by the bot from referred users
 * @property amount Integer amount of Telegram Stars received by the affiliate from the transaction, rounded to 0; can be negative for refunds
 * @property nanostarAmount <em>Optional</em>. The number of 1/1000000000 shares of Telegram Stars received by the affiliate; from -999999999 to 999999999; can be negative for refunds
 *
 * @constructor Creates a [AffiliateInfo].
 * */
data class AffiliateInfo(
    val affiliateUser: User? = null,
    val affiliateChat: Chat? = null,
    val commissionPerMille: Long,
    val amount: Long,
    val nanostarAmount: Long? = null,
) : TelegramModel()

/**
 * <p>Describes a transaction with a user.</p>
 *
 * @property type Type of the transaction partner, always “user”
 * @property transactionType Type of the transaction, currently one of “invoice_payment” for payments via invoices, “paid_media_payment” for payments for paid media, “gift_purchase” for gifts sent by the bot, “premium_purchase” for Telegram Premium subscriptions gifted by the bot, “business_account_transfer” for direct transfers from managed business accounts
 * @property user Information about the user
 * @property affiliate <em>Optional</em>. Information about the affiliate that received a commission via this transaction. Can be available only for “invoice_payment” and “paid_media_payment” transactions.
 * @property invoicePayload <em>Optional</em>. Bot-specified invoice payload. Can be available only for “invoice_payment” transactions.
 * @property subscriptionPeriod <em>Optional</em>. The duration of the paid subscription. Can be available only for “invoice_payment” transactions.
 * @property paidMedia <em>Optional</em>. Information about the paid media bought by the user; for “paid_media_payment” transactions only
 * @property paidMediaPayload <em>Optional</em>. Bot-specified paid media payload. Can be available only for “paid_media_payment” transactions.
 * @property gift <em>Optional</em>. The gift sent to the user by the bot; for “gift_purchase” transactions only
 * @property premiumSubscriptionDuration <em>Optional</em>. Number of months the gifted Telegram Premium subscription will be active for; for “premium_purchase” transactions only
 *
 * @constructor Creates a [TransactionPartnerUser].
 * */
data class TransactionPartnerUser(
    val type: String,
    val transactionType: String,
    val user: User,
    val affiliate: AffiliateInfo? = null,
    val invoicePayload: String? = null,
    val subscriptionPeriod: Long? = null,
    val paidMedia: List<PaidMedia>? = null,
    val paidMediaPayload: String? = null,
    val gift: Gift? = null,
    val premiumSubscriptionDuration: Long? = null,
) : TransactionPartner()

/**
 * <p>Describes a transaction with a chat.</p>
 *
 * @property type Type of the transaction partner, always “chat”
 * @property chat Information about the chat
 * @property gift <em>Optional</em>. The gift sent to the chat by the bot
 *
 * @constructor Creates a [TransactionPartnerChat].
 * */
data class TransactionPartnerChat(
    val type: String,
    val chat: Chat,
    val gift: Gift? = null,
) : TransactionPartner()

/**
 * <p>Describes the affiliate program that issued the affiliate commission received via this transaction.</p>
 *
 * @property type Type of the transaction partner, always “affiliate_program”
 * @property sponsorUser <em>Optional</em>. Information about the bot that sponsored the affiliate program
 * @property commissionPerMille The number of Telegram Stars received by the bot for each 1000 Telegram Stars received by the affiliate program sponsor from referred users
 *
 * @constructor Creates a [TransactionPartnerAffiliateProgram].
 * */
data class TransactionPartnerAffiliateProgram(
    val type: String,
    val sponsorUser: User? = null,
    val commissionPerMille: Long,
) : TransactionPartner()

/**
 * <p>Describes a withdrawal transaction with Fragment.</p>
 *
 * @property type Type of the transaction partner, always “fragment”
 * @property withdrawalState <em>Optional</em>. State of the transaction if the transaction is outgoing
 *
 * @constructor Creates a [TransactionPartnerFragment].
 * */
data class TransactionPartnerFragment(
    val type: String,
    val withdrawalState: RevenueWithdrawalState? = null,
) : TransactionPartner()

/**
 * <p>Describes a withdrawal transaction to the Telegram Ads platform.</p>
 *
 * @property type Type of the transaction partner, always “telegram_ads”
 *
 * @constructor Creates a [TransactionPartnerTelegramAds].
 * */
data class TransactionPartnerTelegramAds(
    val type: String,
) : TransactionPartner()

/**
 * <p>Describes a transaction with payment for <a href="#paid-broadcasts">paid broadcasting</a>.</p>
 *
 * @property type Type of the transaction partner, always “telegram_api”
 * @property requestCount The number of successful requests that exceeded regular limits and were therefore billed
 *
 * @constructor Creates a [TransactionPartnerTelegramApi].
 * */
data class TransactionPartnerTelegramApi(
    val type: String,
    val requestCount: Long,
) : TransactionPartner()

/**
 * <p>Describes a transaction with an unknown source or recipient.</p>
 *
 * @property type Type of the transaction partner, always “other”
 *
 * @constructor Creates a [TransactionPartnerOther].
 * */
data class TransactionPartnerOther(
    val type: String,
) : TransactionPartner()

/**
 * <p>Describes a Telegram Star transaction. Note that if the buyer initiates a chargeback with the payment provider from whom they acquired Stars (e.g., Apple, Google) following this transaction, the refunded Stars will be deducted from the bot's balance. This is outside of Telegram's control.</p>
 *
 * @property id Unique identifier of the transaction. Coincides with the identifier of the original transaction for refund transactions. Coincides with <em>SuccessfulPayment.telegram_payment_charge_id</em> for successful incoming payments from users.
 * @property amount Integer amount of Telegram Stars transferred by the transaction
 * @property nanostarAmount <em>Optional</em>. The number of 1/1000000000 shares of Telegram Stars transferred by the transaction; from 0 to 999999999
 * @property date Date the transaction was created in Unix time
 * @property source <em>Optional</em>. Source of an incoming transaction (e.g., a user purchasing goods or services, Fragment refunding a failed withdrawal). Only for incoming transactions
 * @property receiver <em>Optional</em>. Receiver of an outgoing transaction (e.g., a user for a purchase refund, Fragment for a withdrawal). Only for outgoing transactions
 *
 * @constructor Creates a [StarTransaction].
 * */
data class StarTransaction(
    val id: String,
    val amount: Long,
    val nanostarAmount: Long? = null,
    val date: Long,
    val source: TransactionPartner? = null,
    val receiver: TransactionPartner? = null,
) : TelegramModel()

/**
 * <p>Contains a list of Telegram Star transactions.</p>
 *
 * @property transactions The list of transactions
 *
 * @constructor Creates a [StarTransactions].
 * */
data class StarTransactions(
    val transactions: List<StarTransaction>,
) : TelegramModel()

// Telegram Passport

/**
 * <p>Describes Telegram Passport data shared with the bot by the user.</p>
 *
 * @property data Array with information about documents and other Telegram Passport elements that was shared with the bot
 * @property credentials Encrypted credentials required to decrypt the data
 *
 * @constructor Creates a [PassportData].
 * */
data class PassportData(
    val data: List<EncryptedPassportElement>,
    val credentials: EncryptedCredentials,
) : TelegramModel()

/**
 * <p>This object represents a file uploaded to Telegram Passport. Currently all Telegram Passport files are in JPEG format when decrypted and don't exceed 10MB.</p>
 *
 * @property fileId Identifier for this file, which can be used to download or reuse the file
 * @property fileUniqueId Unique identifier for this file, which is supposed to be the same over time and for different bots. Can't be used to download or reuse the file.
 * @property fileSize File size in bytes
 * @property fileDate Unix time when the file was uploaded
 *
 * @constructor Creates a [PassportFile].
 * */
data class PassportFile(
    val fileId: String,
    val fileUniqueId: String,
    val fileSize: Long,
    val fileDate: Long,
) : TelegramModel()

/**
 * <p>Describes documents or other Telegram Passport elements shared with the bot by the user.</p>
 *
 * @property type Element type. One of “personal_details”, “passport”, “driver_license”, “identity_card”, “internal_passport”, “address”, “utility_bill”, “bank_statement”, “rental_agreement”, “passport_registration”, “temporary_registration”, “phone_number”, “email”.
 * @property data <em>Optional</em>. Base64-encoded encrypted Telegram Passport element data provided by the user; available only for “personal_details”, “passport”, “driver_license”, “identity_card”, “internal_passport” and “address” types. Can be decrypted and verified using the accompanying <a href="#encryptedcredentials">EncryptedCredentials</a>.
 * @property phoneNumber <em>Optional</em>. User's verified phone number; available only for “phone_number” type
 * @property email <em>Optional</em>. User's verified email address; available only for “email” type
 * @property files <em>Optional</em>. Array of encrypted files with documents provided by the user; available only for “utility_bill”, “bank_statement”, “rental_agreement”, “passport_registration” and “temporary_registration” types. Files can be decrypted and verified using the accompanying <a href="#encryptedcredentials">EncryptedCredentials</a>.
 * @property frontSide <em>Optional</em>. Encrypted file with the front side of the document, provided by the user; available only for “passport”, “driver_license”, “identity_card” and “internal_passport”. The file can be decrypted and verified using the accompanying <a href="#encryptedcredentials">EncryptedCredentials</a>.
 * @property reverseSide <em>Optional</em>. Encrypted file with the reverse side of the document, provided by the user; available only for “driver_license” and “identity_card”. The file can be decrypted and verified using the accompanying <a href="#encryptedcredentials">EncryptedCredentials</a>.
 * @property selfie <em>Optional</em>. Encrypted file with the selfie of the user holding a document, provided by the user; available if requested for “passport”, “driver_license”, “identity_card” and “internal_passport”. The file can be decrypted and verified using the accompanying <a href="#encryptedcredentials">EncryptedCredentials</a>.
 * @property translation <em>Optional</em>. Array of encrypted files with translated versions of documents provided by the user; available if requested for “passport”, “driver_license”, “identity_card”, “internal_passport”, “utility_bill”, “bank_statement”, “rental_agreement”, “passport_registration” and “temporary_registration” types. Files can be decrypted and verified using the accompanying <a href="#encryptedcredentials">EncryptedCredentials</a>.
 * @property hash Base64-encoded element hash for using in <a href="#passportelementerrorunspecified">PassportElementErrorUnspecified</a>
 *
 * @constructor Creates a [EncryptedPassportElement].
 * */
data class EncryptedPassportElement(
    val type: String,
    val data: String? = null,
    val phoneNumber: String? = null,
    val email: String? = null,
    val files: List<PassportFile>? = null,
    val frontSide: PassportFile? = null,
    val reverseSide: PassportFile? = null,
    val selfie: PassportFile? = null,
    val translation: List<PassportFile>? = null,
    val hash: String,
) : TelegramModel()

/**
 * <p>Describes data required for decrypting and authenticating <a href="#encryptedpassportelement">EncryptedPassportElement</a>. See the <a href="/passport#receiving-information">Telegram Passport Documentation</a> for a complete description of the data decryption and authentication processes.</p>
 *
 * @property data Base64-encoded encrypted JSON-serialized data with unique user's payload, data hashes and secrets required for <a href="#encryptedpassportelement">EncryptedPassportElement</a> decryption and authentication
 * @property hash Base64-encoded data hash for data authentication
 * @property secret Base64-encoded secret, encrypted with the bot's public RSA key, required for data decryption
 *
 * @constructor Creates a [EncryptedCredentials].
 * */
data class EncryptedCredentials(
    val data: String,
    val hash: String,
    val secret: String,
) : TelegramModel()

/**
 * <p>Represents an issue in one of the data fields that was provided by the user. The error is considered resolved when the field's value changes.</p>
 *
 * @property source Error source, must be <em>data</em>
 * @property type The section of the user's Telegram Passport which has the error, one of “personal_details”, “passport”, “driver_license”, “identity_card”, “internal_passport”, “address”
 * @property fieldName Name of the data field which has the error
 * @property dataHash Base64-encoded data hash
 * @property message Error message
 *
 * @constructor Creates a [PassportElementErrorDataField].
 * */
data class PassportElementErrorDataField(
    val source: String,
    val type: String,
    val fieldName: String,
    val dataHash: String,
    val message: String,
) : PassportElementError()

/**
 * <p>Represents an issue with the front side of a document. The error is considered resolved when the file with the front side of the document changes.</p>
 *
 * @property source Error source, must be <em>front_side</em>
 * @property type The section of the user's Telegram Passport which has the issue, one of “passport”, “driver_license”, “identity_card”, “internal_passport”
 * @property fileHash Base64-encoded hash of the file with the front side of the document
 * @property message Error message
 *
 * @constructor Creates a [PassportElementErrorFrontSide].
 * */
data class PassportElementErrorFrontSide(
    val source: String,
    val type: String,
    val fileHash: String,
    val message: String,
) : PassportElementError()

/**
 * <p>Represents an issue with the reverse side of a document. The error is considered resolved when the file with reverse side of the document changes.</p>
 *
 * @property source Error source, must be <em>reverse_side</em>
 * @property type The section of the user's Telegram Passport which has the issue, one of “driver_license”, “identity_card”
 * @property fileHash Base64-encoded hash of the file with the reverse side of the document
 * @property message Error message
 *
 * @constructor Creates a [PassportElementErrorReverseSide].
 * */
data class PassportElementErrorReverseSide(
    val source: String,
    val type: String,
    val fileHash: String,
    val message: String,
) : PassportElementError()

/**
 * <p>Represents an issue with the selfie with a document. The error is considered resolved when the file with the selfie changes.</p>
 *
 * @property source Error source, must be <em>selfie</em>
 * @property type The section of the user's Telegram Passport which has the issue, one of “passport”, “driver_license”, “identity_card”, “internal_passport”
 * @property fileHash Base64-encoded hash of the file with the selfie
 * @property message Error message
 *
 * @constructor Creates a [PassportElementErrorSelfie].
 * */
data class PassportElementErrorSelfie(
    val source: String,
    val type: String,
    val fileHash: String,
    val message: String,
) : PassportElementError()

/**
 * <p>Represents an issue with a document scan. The error is considered resolved when the file with the document scan changes.</p>
 *
 * @property source Error source, must be <em>file</em>
 * @property type The section of the user's Telegram Passport which has the issue, one of “utility_bill”, “bank_statement”, “rental_agreement”, “passport_registration”, “temporary_registration”
 * @property fileHash Base64-encoded file hash
 * @property message Error message
 *
 * @constructor Creates a [PassportElementErrorFile].
 * */
data class PassportElementErrorFile(
    val source: String,
    val type: String,
    val fileHash: String,
    val message: String,
) : PassportElementError()

/**
 * <p>Represents an issue with a list of scans. The error is considered resolved when the list of files containing the scans changes.</p>
 *
 * @property source Error source, must be <em>files</em>
 * @property type The section of the user's Telegram Passport which has the issue, one of “utility_bill”, “bank_statement”, “rental_agreement”, “passport_registration”, “temporary_registration”
 * @property fileHashes List of base64-encoded file hashes
 * @property message Error message
 *
 * @constructor Creates a [PassportElementErrorFiles].
 * */
data class PassportElementErrorFiles(
    val source: String,
    val type: String,
    val fileHashes: List<String>,
    val message: String,
) : PassportElementError()

/**
 * <p>Represents an issue with one of the files that constitute the translation of a document. The error is considered resolved when the file changes.</p>
 *
 * @property source Error source, must be <em>translation_file</em>
 * @property type Type of element of the user's Telegram Passport which has the issue, one of “passport”, “driver_license”, “identity_card”, “internal_passport”, “utility_bill”, “bank_statement”, “rental_agreement”, “passport_registration”, “temporary_registration”
 * @property fileHash Base64-encoded file hash
 * @property message Error message
 *
 * @constructor Creates a [PassportElementErrorTranslationFile].
 * */
data class PassportElementErrorTranslationFile(
    val source: String,
    val type: String,
    val fileHash: String,
    val message: String,
) : PassportElementError()

/**
 * <p>Represents an issue with the translated version of a document. The error is considered resolved when a file with the document translation change.</p>
 *
 * @property source Error source, must be <em>translation_files</em>
 * @property type Type of element of the user's Telegram Passport which has the issue, one of “passport”, “driver_license”, “identity_card”, “internal_passport”, “utility_bill”, “bank_statement”, “rental_agreement”, “passport_registration”, “temporary_registration”
 * @property fileHashes List of base64-encoded file hashes
 * @property message Error message
 *
 * @constructor Creates a [PassportElementErrorTranslationFiles].
 * */
data class PassportElementErrorTranslationFiles(
    val source: String,
    val type: String,
    val fileHashes: List<String>,
    val message: String,
) : PassportElementError()

/**
 * <p>Represents an issue in an unspecified place. The error is considered resolved when new data is added.</p>
 *
 * @property source Error source, must be <em>unspecified</em>
 * @property type Type of element of the user's Telegram Passport which has the issue
 * @property elementHash Base64-encoded element hash
 * @property message Error message
 *
 * @constructor Creates a [PassportElementErrorUnspecified].
 * */
data class PassportElementErrorUnspecified(
    val source: String,
    val type: String,
    val elementHash: String,
    val message: String,
) : PassportElementError()

// Games

/**
 * <p>This object represents a game. Use BotFather to create and edit games, their short names will act as unique identifiers.</p>
 *
 * @property title Title of the game
 * @property description Description of the game
 * @property photo Photo that will be displayed in the game message in chats.
 * @property text <em>Optional</em>. Brief description of the game or high scores included in the game message. Can be automatically edited to include current high scores for the game when the bot calls <a href="#setgamescore">setGameScore</a>, or manually edited using <a href="#editmessagetext">editMessageText</a>. 0-4096 characters.
 * @property textEntities <em>Optional</em>. Special entities that appear in <em>text</em>, such as usernames, URLs, bot commands, etc.
 * @property animation <em>Optional</em>. Animation that will be displayed in the game message in chats. Upload via <a href="https://t.me/botfather">BotFather</a>
 *
 * @constructor Creates a [Game].
 * */
data class Game(
    val title: String,
    val description: String,
    val photo: List<PhotoSize>,
    val text: String? = null,
    val textEntities: List<MessageEntity>? = null,
    val animation: Animation? = null,
) : TelegramModel()

/**
 * <p>This object represents one row of the high scores table for a game.</p><p>And that's about all we've got for now.<br>If you've got any questions, please check out our <a href="/bots/faq"><strong>Bot FAQ »</strong></a></p>
 *
 * @property position Position in high score table for the game
 * @property user User
 * @property score Score
 *
 * @constructor Creates a [GameHighScore].
 * */
data class GameHighScore(
    val position: Long,
    val user: User,
    val score: Long,
) : TelegramModel()

// --- Requests ---

sealed class TelegramRequest {

    // Getting updates

    /**
     * <p>Use this method to receive incoming updates using long polling (<a href="https://en.wikipedia.org/wiki/Push_technology#Long_polling">wiki</a>). Returns an Array of <a href="#update">Update</a> objects.</p><blockquote>
     *  <p><strong>Notes</strong><br><strong>1.</strong> This method will not work if an outgoing webhook is set up.<br><strong>2.</strong> In order to avoid getting duplicate updates, recalculate <em>offset</em> after each server response.</p>
     * </blockquote>
     *
     * @property offset Identifier of the first update to be returned. Must be greater by one than the highest among the identifiers of previously received updates. By default, updates starting with the earliest unconfirmed update are returned. An update is considered confirmed as soon as <a href="#getupdates">getUpdates</a> is called with an <em>offset</em> higher than its <em>update_id</em>. The negative offset can be specified to retrieve updates starting from <em>-offset</em> update from the end of the updates queue. All previous updates will be forgotten.
     * @property limit Limits the number of updates to be retrieved. Values between 1-100 are accepted. Defaults to 100.
     * @property timeout Timeout in seconds for long polling. Defaults to 0, i.e. usual short polling. Should be positive, short polling should be used for testing purposes only.
     * @property allowedUpdates A JSON-serialized list of the update types you want your bot to receive. For example, specify <code>["message", "edited_channel_post", "callback_query"]</code> to only receive updates of these types. See <a href="#update">Update</a> for a complete list of available update types. Specify an empty list to receive all update types except <em>chat_member</em>, <em>message_reaction</em>, and <em>message_reaction_count</em> (default). If not specified, the previous setting will be used.<br><br>Please note that this parameter doesn't affect updates created before the call to getUpdates, so unwanted updates may be received for a short period of time.
     * */
    data class GetUpdatesRequest(
        val offset: Long? = null,
        val limit: Long? = null,
        val timeout: Long? = null,
        val allowedUpdates: List<String>? = null,
    ) : TelegramRequest()

    /**
     * <p>Use this method to specify a URL and receive incoming updates via an outgoing webhook. Whenever there is an update for the bot, we will send an HTTPS POST request to the specified URL, containing a JSON-serialized <a href="#update">Update</a>. In case of an unsuccessful request (a request with response <a href="https://en.wikipedia.org/wiki/List_of_HTTP_status_codes">HTTP status code</a> different from <code>2XY</code>), we will repeat the request and give up after a reasonable amount of attempts. Returns <em>True</em> on success.</p><p>If you'd like to make sure that the webhook was set by you, you can specify secret data in the parameter <em>secret_token</em>. If specified, the request will contain a header “X-Telegram-Bot-Api-Secret-Token” with the secret token as content.</p><blockquote>
     *  <p><strong>Notes</strong><br><strong>1.</strong> You will not be able to receive updates using <a href="#getupdates">getUpdates</a> for as long as an outgoing webhook is set up.<br><strong>2.</strong> To use a self-signed certificate, you need to upload your <a href="/bots/self-signed">public key certificate</a> using <em>certificate</em> parameter. Please upload as InputFile, sending a String will not work.<br><strong>3.</strong> Ports currently supported <em>for webhooks</em>: <strong>443, 80, 88, 8443</strong>.</p>
     *  <p>If you're having any trouble setting up webhooks, please check out this <a href="/bots/webhooks">amazing guide to webhooks</a>.</p>
     * </blockquote>
     *
     * @property url HTTPS URL to send updates to. Use an empty string to remove webhook integration
     * @property certificate Upload your public key certificate so that the root certificate in use can be checked. See our <a href="/bots/self-signed">self-signed guide</a> for details.
     * @property ipAddress The fixed IP address which will be used to send webhook requests instead of the IP address resolved through DNS
     * @property maxConnections The maximum allowed number of simultaneous HTTPS connections to the webhook for update delivery, 1-100. Defaults to <em>40</em>. Use lower values to limit the load on your bot's server, and higher values to increase your bot's throughput.
     * @property allowedUpdates A JSON-serialized list of the update types you want your bot to receive. For example, specify <code>["message", "edited_channel_post", "callback_query"]</code> to only receive updates of these types. See <a href="#update">Update</a> for a complete list of available update types. Specify an empty list to receive all update types except <em>chat_member</em>, <em>message_reaction</em>, and <em>message_reaction_count</em> (default). If not specified, the previous setting will be used.<br>Please note that this parameter doesn't affect updates created before the call to the setWebhook, so unwanted updates may be received for a short period of time.
     * @property dropPendingUpdates Pass <em>True</em> to drop all pending updates
     * @property secretToken A secret token to be sent in a header “X-Telegram-Bot-Api-Secret-Token” in every webhook request, 1-256 characters. Only characters <code>A-Z</code>, <code>a-z</code>, <code>0-9</code>, <code>_</code> and <code>-</code> are allowed. The header is useful to ensure that the request comes from a webhook set by you.
     * @property invalidUserUrl HTTPS URL to send updates to. Use an empty string to remove webhook integration
     * */
    data class SetWebhookRequest(
        val url: String,
        val certificate: Any? = null,
        val ipAddress: String? = null,
        val maxConnections: Long? = null,
        val allowedUpdates: List<String>? = null,
        val dropPendingUpdates: Boolean? = null,
        val secretToken: String? = null,
        val invalidUserUrl: String? = null,
    ) : TelegramRequest()

    /**
     * <p>Use this method to remove webhook integration if you decide to switch back to <a href="#getupdates">getUpdates</a>. Returns <em>True</em> on success.</p>
     *
     * @property dropPendingUpdates Pass <em>True</em> to drop all pending updates
     * */
    data class DeleteWebhookRequest(
        val dropPendingUpdates: Boolean? = null,
    ) : TelegramRequest()

    // Available methods

    /**
     * <p>Use this method to send text messages. On success, the sent <a href="#message">Message</a> is returned.</p>
     *
     * @property chatId Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>)
     * @property text Text of the message to be sent, 1-4096 characters after entities parsing
     * @property businessConnectionId Unique identifier of the business connection on behalf of which the message will be sent
     * @property messageThreadId Unique identifier for the target message thread (topic) of the forum; for forum supergroups only
     * @property parseMode Mode for parsing entities in the message text. See <a href="#formatting-options">formatting options</a> for more details.
     * @property entities A JSON-serialized list of special entities that appear in message text, which can be specified instead of <em>parse_mode</em>
     * @property linkPreviewOptions Link preview generation options for the message
     * @property disableNotification Sends the message <a href="https://telegram.org/blog/channels-2-0#silent-messages">silently</a>. Users will receive a notification with no sound.
     * @property protectContent Protects the contents of the sent message from forwarding and saving
     * @property allowPaidBroadcast Pass <em>True</em> to allow up to 1000 messages per second, ignoring <a href="https://core.telegram.org/bots/faq#how-can-i-message-all-of-my-bot-39s-subscribers-at-once">broadcasting limits</a> for a fee of 0.1 Telegram Stars per message. The relevant Stars will be withdrawn from the bot's balance
     * @property messageEffectId Unique identifier of the message effect to be added to the message; for private chats only
     * @property replyParameters Description of the message to reply to
     * @property replyMarkup Additional interface options. A JSON-serialized object for an <a href="/bots/features#inline-keyboards">inline keyboard</a>, <a href="/bots/features#keyboards">custom reply keyboard</a>, instructions to remove a reply keyboard or to force a reply from the user
     * */
    data class SendMessageRequest(
        val chatId: String,
        val text: String,
        val businessConnectionId: String? = null,
        val messageThreadId: Long? = null,
        val parseMode: ParseMode? = null,
        val entities: List<MessageEntity>? = null,
        val linkPreviewOptions: LinkPreviewOptions? = null,
        val disableNotification: Boolean? = null,
        val protectContent: Boolean? = null,
        val allowPaidBroadcast: Boolean? = null,
        val messageEffectId: String? = null,
        val replyParameters: ReplyParameters? = null,
        val replyMarkup: KeyboardOption? = null,
    ) : TelegramRequest()

    /**
     * <p>Use this method to forward messages of any kind. Service messages and messages with protected content can't be forwarded. On success, the sent <a href="#message">Message</a> is returned.</p>
     *
     * @property chatId Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>)
     * @property fromChatId Unique identifier for the chat where the original message was sent (or channel username in the format <code>@channelusername</code>)
     * @property messageId Message identifier in the chat specified in <em>from_chat_id</em>
     * @property messageThreadId Unique identifier for the target message thread (topic) of the forum; for forum supergroups only
     * @property videoStartTimestamp New start timestamp for the forwarded video in the message
     * @property disableNotification Sends the message <a href="https://telegram.org/blog/channels-2-0#silent-messages">silently</a>. Users will receive a notification with no sound.
     * @property protectContent Protects the contents of the forwarded message from forwarding and saving
     * */
    data class ForwardMessageRequest(
        val chatId: String,
        val fromChatId: String,
        val messageId: Long,
        val messageThreadId: Long? = null,
        val videoStartTimestamp: Long? = null,
        val disableNotification: Boolean? = null,
        val protectContent: Boolean? = null,
    ) : TelegramRequest()

    /**
     * <p>Use this method to forward multiple messages of any kind. If some of the specified messages can't be found or forwarded, they are skipped. Service messages and messages with protected content can't be forwarded. Album grouping is kept for forwarded messages. On success, an array of <a href="#messageid">MessageId</a> of the sent messages is returned.</p>
     *
     * @property chatId Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>)
     * @property fromChatId Unique identifier for the chat where the original messages were sent (or channel username in the format <code>@channelusername</code>)
     * @property messageIds A JSON-serialized list of 1-100 identifiers of messages in the chat <em>from_chat_id</em> to forward. The identifiers must be specified in a strictly increasing order.
     * @property messageThreadId Unique identifier for the target message thread (topic) of the forum; for forum supergroups only
     * @property disableNotification Sends the messages <a href="https://telegram.org/blog/channels-2-0#silent-messages">silently</a>. Users will receive a notification with no sound.
     * @property protectContent Protects the contents of the forwarded messages from forwarding and saving
     * */
    data class ForwardMessagesRequest(
        val chatId: String,
        val fromChatId: String,
        val messageIds: List<Long>,
        val messageThreadId: Long? = null,
        val disableNotification: Boolean? = null,
        val protectContent: Boolean? = null,
    ) : TelegramRequest()

    /**
     * <p>Use this method to copy messages of any kind. Service messages, paid media messages, giveaway messages, giveaway winners messages, and invoice messages can't be copied. A quiz <a href="#poll">poll</a> can be copied only if the value of the field <em>correct_option_id</em> is known to the bot. The method is analogous to the method <a href="#forwardmessage">forwardMessage</a>, but the copied message doesn't have a link to the original message. Returns the <a href="#messageid">MessageId</a> of the sent message on success.</p>
     *
     * @property chatId Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>)
     * @property fromChatId Unique identifier for the chat where the original message was sent (or channel username in the format <code>@channelusername</code>)
     * @property messageId Message identifier in the chat specified in <em>from_chat_id</em>
     * @property messageThreadId Unique identifier for the target message thread (topic) of the forum; for forum supergroups only
     * @property videoStartTimestamp New start timestamp for the copied video in the message
     * @property caption New caption for media, 0-1024 characters after entities parsing. If not specified, the original caption is kept
     * @property parseMode Mode for parsing entities in the new caption. See <a href="#formatting-options">formatting options</a> for more details.
     * @property captionEntities A JSON-serialized list of special entities that appear in the new caption, which can be specified instead of <em>parse_mode</em>
     * @property showCaptionAboveMedia Pass <em>True</em>, if the caption must be shown above the message media. Ignored if a new caption isn't specified.
     * @property disableNotification Sends the message <a href="https://telegram.org/blog/channels-2-0#silent-messages">silently</a>. Users will receive a notification with no sound.
     * @property protectContent Protects the contents of the sent message from forwarding and saving
     * @property allowPaidBroadcast Pass <em>True</em> to allow up to 1000 messages per second, ignoring <a href="https://core.telegram.org/bots/faq#how-can-i-message-all-of-my-bot-39s-subscribers-at-once">broadcasting limits</a> for a fee of 0.1 Telegram Stars per message. The relevant Stars will be withdrawn from the bot's balance
     * @property replyParameters Description of the message to reply to
     * @property replyMarkup Additional interface options. A JSON-serialized object for an <a href="/bots/features#inline-keyboards">inline keyboard</a>, <a href="/bots/features#keyboards">custom reply keyboard</a>, instructions to remove a reply keyboard or to force a reply from the user
     * */
    data class CopyMessageRequest(
        val chatId: String,
        val fromChatId: String,
        val messageId: Long,
        val messageThreadId: Long? = null,
        val videoStartTimestamp: Long? = null,
        val caption: String? = null,
        val parseMode: ParseMode? = null,
        val captionEntities: List<MessageEntity>? = null,
        val showCaptionAboveMedia: Boolean? = null,
        val disableNotification: Boolean? = null,
        val protectContent: Boolean? = null,
        val allowPaidBroadcast: Boolean? = null,
        val replyParameters: ReplyParameters? = null,
        val replyMarkup: KeyboardOption? = null,
    ) : TelegramRequest()

    /**
     * <p>Use this method to copy messages of any kind. If some of the specified messages can't be found or copied, they are skipped. Service messages, paid media messages, giveaway messages, giveaway winners messages, and invoice messages can't be copied. A quiz <a href="#poll">poll</a> can be copied only if the value of the field <em>correct_option_id</em> is known to the bot. The method is analogous to the method <a href="#forwardmessages">forwardMessages</a>, but the copied messages don't have a link to the original message. Album grouping is kept for copied messages. On success, an array of <a href="#messageid">MessageId</a> of the sent messages is returned.</p>
     *
     * @property chatId Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>)
     * @property fromChatId Unique identifier for the chat where the original messages were sent (or channel username in the format <code>@channelusername</code>)
     * @property messageIds A JSON-serialized list of 1-100 identifiers of messages in the chat <em>from_chat_id</em> to copy. The identifiers must be specified in a strictly increasing order.
     * @property messageThreadId Unique identifier for the target message thread (topic) of the forum; for forum supergroups only
     * @property disableNotification Sends the messages <a href="https://telegram.org/blog/channels-2-0#silent-messages">silently</a>. Users will receive a notification with no sound.
     * @property protectContent Protects the contents of the sent messages from forwarding and saving
     * @property removeCaption Pass <em>True</em> to copy the messages without their captions
     * */
    data class CopyMessagesRequest(
        val chatId: String,
        val fromChatId: String,
        val messageIds: List<Long>,
        val messageThreadId: Long? = null,
        val disableNotification: Boolean? = null,
        val protectContent: Boolean? = null,
        val removeCaption: Boolean? = null,
    ) : TelegramRequest()

    /**
     * <p>Use this method to send photos. On success, the sent <a href="#message">Message</a> is returned.</p>
     *
     * @property chatId Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>)
     * @property photo Photo to send. Pass a file_id as String to send a photo that exists on the Telegram servers (recommended), pass an HTTP URL as a String for Telegram to get a photo from the Internet, or upload a new photo using multipart/form-data. The photo must be at most 10 MB in size. The photo's width and height must not exceed 10000 in total. Width and height ratio must be at most 20. <a href="#sending-files">More information on Sending Files »</a>
     * @property businessConnectionId Unique identifier of the business connection on behalf of which the message will be sent
     * @property messageThreadId Unique identifier for the target message thread (topic) of the forum; for forum supergroups only
     * @property caption Photo caption (may also be used when resending photos by <em>file_id</em>), 0-1024 characters after entities parsing
     * @property parseMode Mode for parsing entities in the photo caption. See <a href="#formatting-options">formatting options</a> for more details.
     * @property captionEntities A JSON-serialized list of special entities that appear in the caption, which can be specified instead of <em>parse_mode</em>
     * @property showCaptionAboveMedia Pass <em>True</em>, if the caption must be shown above the message media
     * @property hasSpoiler Pass <em>True</em> if the photo needs to be covered with a spoiler animation
     * @property disableNotification Sends the message <a href="https://telegram.org/blog/channels-2-0#silent-messages">silently</a>. Users will receive a notification with no sound.
     * @property protectContent Protects the contents of the sent message from forwarding and saving
     * @property allowPaidBroadcast Pass <em>True</em> to allow up to 1000 messages per second, ignoring <a href="https://core.telegram.org/bots/faq#how-can-i-message-all-of-my-bot-39s-subscribers-at-once">broadcasting limits</a> for a fee of 0.1 Telegram Stars per message. The relevant Stars will be withdrawn from the bot's balance
     * @property messageEffectId Unique identifier of the message effect to be added to the message; for private chats only
     * @property replyParameters Description of the message to reply to
     * @property replyMarkup Additional interface options. A JSON-serialized object for an <a href="/bots/features#inline-keyboards">inline keyboard</a>, <a href="/bots/features#keyboards">custom reply keyboard</a>, instructions to remove a reply keyboard or to force a reply from the user
     * */
    data class SendPhotoRequest(
        val chatId: String,
        val photo: String,
        val businessConnectionId: String? = null,
        val messageThreadId: Long? = null,
        val caption: String? = null,
        val parseMode: ParseMode? = null,
        val captionEntities: List<MessageEntity>? = null,
        val showCaptionAboveMedia: Boolean? = null,
        val hasSpoiler: Boolean? = null,
        val disableNotification: Boolean? = null,
        val protectContent: Boolean? = null,
        val allowPaidBroadcast: Boolean? = null,
        val messageEffectId: String? = null,
        val replyParameters: ReplyParameters? = null,
        val replyMarkup: KeyboardOption? = null,
    ) : TelegramRequest()

    /**
     * <p>Use this method to send audio files, if you want Telegram clients to display them in the music player. Your audio must be in the .MP3 or .M4A format. On success, the sent <a href="#message">Message</a> is returned. Bots can currently send audio files of up to 50 MB in size, this limit may be changed in the future.</p><p>For sending voice messages, use the <a href="#sendvoice">sendVoice</a> method instead.</p>
     *
     * @property chatId Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>)
     * @property audio Audio file to send. Pass a file_id as String to send an audio file that exists on the Telegram servers (recommended), pass an HTTP URL as a String for Telegram to get an audio file from the Internet, or upload a new one using multipart/form-data. <a href="#sending-files">More information on Sending Files »</a>
     * @property businessConnectionId Unique identifier of the business connection on behalf of which the message will be sent
     * @property messageThreadId Unique identifier for the target message thread (topic) of the forum; for forum supergroups only
     * @property caption Audio caption, 0-1024 characters after entities parsing
     * @property parseMode Mode for parsing entities in the audio caption. See <a href="#formatting-options">formatting options</a> for more details.
     * @property captionEntities A JSON-serialized list of special entities that appear in the caption, which can be specified instead of <em>parse_mode</em>
     * @property duration Duration of the audio in seconds
     * @property performer Performer
     * @property title Track name
     * @property thumbnail Thumbnail of the file sent; can be ignored if thumbnail generation for the file is supported server-side. The thumbnail should be in JPEG format and less than 200 kB in size. A thumbnail's width and height should not exceed 320. Ignored if the file is not uploaded using multipart/form-data. Thumbnails can't be reused and can be only uploaded as a new file, so you can pass “attach://&lt;file_attach_name&gt;” if the thumbnail was uploaded using multipart/form-data under &lt;file_attach_name&gt;. <a href="#sending-files">More information on Sending Files »</a>
     * @property disableNotification Sends the message <a href="https://telegram.org/blog/channels-2-0#silent-messages">silently</a>. Users will receive a notification with no sound.
     * @property protectContent Protects the contents of the sent message from forwarding and saving
     * @property allowPaidBroadcast Pass <em>True</em> to allow up to 1000 messages per second, ignoring <a href="https://core.telegram.org/bots/faq#how-can-i-message-all-of-my-bot-39s-subscribers-at-once">broadcasting limits</a> for a fee of 0.1 Telegram Stars per message. The relevant Stars will be withdrawn from the bot's balance
     * @property messageEffectId Unique identifier of the message effect to be added to the message; for private chats only
     * @property replyParameters Description of the message to reply to
     * @property replyMarkup Additional interface options. A JSON-serialized object for an <a href="/bots/features#inline-keyboards">inline keyboard</a>, <a href="/bots/features#keyboards">custom reply keyboard</a>, instructions to remove a reply keyboard or to force a reply from the user
     * */
    data class SendAudioRequest(
        val chatId: String,
        val audio: String,
        val businessConnectionId: String? = null,
        val messageThreadId: Long? = null,
        val caption: String? = null,
        val parseMode: ParseMode? = null,
        val captionEntities: List<MessageEntity>? = null,
        val duration: Long? = null,
        val performer: String? = null,
        val title: String? = null,
        val thumbnail: String? = null,
        val disableNotification: Boolean? = null,
        val protectContent: Boolean? = null,
        val allowPaidBroadcast: Boolean? = null,
        val messageEffectId: String? = null,
        val replyParameters: ReplyParameters? = null,
        val replyMarkup: KeyboardOption? = null,
    ) : TelegramRequest()

    /**
     * <p>Use this method to send general files. On success, the sent <a href="#message">Message</a> is returned. Bots can currently send files of any type of up to 50 MB in size, this limit may be changed in the future.</p>
     *
     * @property chatId Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>)
     * @property document File to send. Pass a file_id as String to send a file that exists on the Telegram servers (recommended), pass an HTTP URL as a String for Telegram to get a file from the Internet, or upload a new one using multipart/form-data. <a href="#sending-files">More information on Sending Files »</a>
     * @property businessConnectionId Unique identifier of the business connection on behalf of which the message will be sent
     * @property messageThreadId Unique identifier for the target message thread (topic) of the forum; for forum supergroups only
     * @property thumbnail Thumbnail of the file sent; can be ignored if thumbnail generation for the file is supported server-side. The thumbnail should be in JPEG format and less than 200 kB in size. A thumbnail's width and height should not exceed 320. Ignored if the file is not uploaded using multipart/form-data. Thumbnails can't be reused and can be only uploaded as a new file, so you can pass “attach://&lt;file_attach_name&gt;” if the thumbnail was uploaded using multipart/form-data under &lt;file_attach_name&gt;. <a href="#sending-files">More information on Sending Files »</a>
     * @property caption Document caption (may also be used when resending documents by <em>file_id</em>), 0-1024 characters after entities parsing
     * @property parseMode Mode for parsing entities in the document caption. See <a href="#formatting-options">formatting options</a> for more details.
     * @property captionEntities A JSON-serialized list of special entities that appear in the caption, which can be specified instead of <em>parse_mode</em>
     * @property disableContentTypeDetection Disables automatic server-side content type detection for files uploaded using multipart/form-data
     * @property disableNotification Sends the message <a href="https://telegram.org/blog/channels-2-0#silent-messages">silently</a>. Users will receive a notification with no sound.
     * @property protectContent Protects the contents of the sent message from forwarding and saving
     * @property allowPaidBroadcast Pass <em>True</em> to allow up to 1000 messages per second, ignoring <a href="https://core.telegram.org/bots/faq#how-can-i-message-all-of-my-bot-39s-subscribers-at-once">broadcasting limits</a> for a fee of 0.1 Telegram Stars per message. The relevant Stars will be withdrawn from the bot's balance
     * @property messageEffectId Unique identifier of the message effect to be added to the message; for private chats only
     * @property replyParameters Description of the message to reply to
     * @property replyMarkup Additional interface options. A JSON-serialized object for an <a href="/bots/features#inline-keyboards">inline keyboard</a>, <a href="/bots/features#keyboards">custom reply keyboard</a>, instructions to remove a reply keyboard or to force a reply from the user
     * */
    data class SendDocumentRequest(
        val chatId: String,
        val document: String,
        val businessConnectionId: String? = null,
        val messageThreadId: Long? = null,
        val thumbnail: String? = null,
        val caption: String? = null,
        val parseMode: ParseMode? = null,
        val captionEntities: List<MessageEntity>? = null,
        val disableContentTypeDetection: Boolean? = null,
        val disableNotification: Boolean? = null,
        val protectContent: Boolean? = null,
        val allowPaidBroadcast: Boolean? = null,
        val messageEffectId: String? = null,
        val replyParameters: ReplyParameters? = null,
        val replyMarkup: KeyboardOption? = null,
    ) : TelegramRequest()

    /**
     * <p>Use this method to send video files, Telegram clients support MPEG4 videos (other formats may be sent as <a href="#document">Document</a>). On success, the sent <a href="#message">Message</a> is returned. Bots can currently send video files of up to 50 MB in size, this limit may be changed in the future.</p>
     *
     * @property chatId Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>)
     * @property video Video to send. Pass a file_id as String to send a video that exists on the Telegram servers (recommended), pass an HTTP URL as a String for Telegram to get a video from the Internet, or upload a new video using multipart/form-data. <a href="#sending-files">More information on Sending Files »</a>
     * @property businessConnectionId Unique identifier of the business connection on behalf of which the message will be sent
     * @property messageThreadId Unique identifier for the target message thread (topic) of the forum; for forum supergroups only
     * @property duration Duration of sent video in seconds
     * @property width Video width
     * @property height Video height
     * @property thumbnail Thumbnail of the file sent; can be ignored if thumbnail generation for the file is supported server-side. The thumbnail should be in JPEG format and less than 200 kB in size. A thumbnail's width and height should not exceed 320. Ignored if the file is not uploaded using multipart/form-data. Thumbnails can't be reused and can be only uploaded as a new file, so you can pass “attach://&lt;file_attach_name&gt;” if the thumbnail was uploaded using multipart/form-data under &lt;file_attach_name&gt;. <a href="#sending-files">More information on Sending Files »</a>
     * @property cover Cover for the video in the message. Pass a file_id to send a file that exists on the Telegram servers (recommended), pass an HTTP URL for Telegram to get a file from the Internet, or pass “attach://&lt;file_attach_name&gt;” to upload a new one using multipart/form-data under &lt;file_attach_name&gt; name. <a href="#sending-files">More information on Sending Files »</a>
     * @property startTimestamp Start timestamp for the video in the message
     * @property caption Video caption (may also be used when resending videos by <em>file_id</em>), 0-1024 characters after entities parsing
     * @property parseMode Mode for parsing entities in the video caption. See <a href="#formatting-options">formatting options</a> for more details.
     * @property captionEntities A JSON-serialized list of special entities that appear in the caption, which can be specified instead of <em>parse_mode</em>
     * @property showCaptionAboveMedia Pass <em>True</em>, if the caption must be shown above the message media
     * @property hasSpoiler Pass <em>True</em> if the video needs to be covered with a spoiler animation
     * @property supportsStreaming Pass <em>True</em> if the uploaded video is suitable for streaming
     * @property disableNotification Sends the message <a href="https://telegram.org/blog/channels-2-0#silent-messages">silently</a>. Users will receive a notification with no sound.
     * @property protectContent Protects the contents of the sent message from forwarding and saving
     * @property allowPaidBroadcast Pass <em>True</em> to allow up to 1000 messages per second, ignoring <a href="https://core.telegram.org/bots/faq#how-can-i-message-all-of-my-bot-39s-subscribers-at-once">broadcasting limits</a> for a fee of 0.1 Telegram Stars per message. The relevant Stars will be withdrawn from the bot's balance
     * @property messageEffectId Unique identifier of the message effect to be added to the message; for private chats only
     * @property replyParameters Description of the message to reply to
     * @property replyMarkup Additional interface options. A JSON-serialized object for an <a href="/bots/features#inline-keyboards">inline keyboard</a>, <a href="/bots/features#keyboards">custom reply keyboard</a>, instructions to remove a reply keyboard or to force a reply from the user
     * */
    data class SendVideoRequest(
        val chatId: String,
        val video: String,
        val businessConnectionId: String? = null,
        val messageThreadId: Long? = null,
        val duration: Long? = null,
        val width: Long? = null,
        val height: Long? = null,
        val thumbnail: String? = null,
        val cover: String? = null,
        val startTimestamp: Long? = null,
        val caption: String? = null,
        val parseMode: ParseMode? = null,
        val captionEntities: List<MessageEntity>? = null,
        val showCaptionAboveMedia: Boolean? = null,
        val hasSpoiler: Boolean? = null,
        val supportsStreaming: Boolean? = null,
        val disableNotification: Boolean? = null,
        val protectContent: Boolean? = null,
        val allowPaidBroadcast: Boolean? = null,
        val messageEffectId: String? = null,
        val replyParameters: ReplyParameters? = null,
        val replyMarkup: KeyboardOption? = null,
    ) : TelegramRequest()

    /**
     * <p>Use this method to send animation files (GIF or H.264/MPEG-4 AVC video without sound). On success, the sent <a href="#message">Message</a> is returned. Bots can currently send animation files of up to 50 MB in size, this limit may be changed in the future.</p>
     *
     * @property chatId Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>)
     * @property animation Animation to send. Pass a file_id as String to send an animation that exists on the Telegram servers (recommended), pass an HTTP URL as a String for Telegram to get an animation from the Internet, or upload a new animation using multipart/form-data. <a href="#sending-files">More information on Sending Files »</a>
     * @property businessConnectionId Unique identifier of the business connection on behalf of which the message will be sent
     * @property messageThreadId Unique identifier for the target message thread (topic) of the forum; for forum supergroups only
     * @property duration Duration of sent animation in seconds
     * @property width Animation width
     * @property height Animation height
     * @property thumbnail Thumbnail of the file sent; can be ignored if thumbnail generation for the file is supported server-side. The thumbnail should be in JPEG format and less than 200 kB in size. A thumbnail's width and height should not exceed 320. Ignored if the file is not uploaded using multipart/form-data. Thumbnails can't be reused and can be only uploaded as a new file, so you can pass “attach://&lt;file_attach_name&gt;” if the thumbnail was uploaded using multipart/form-data under &lt;file_attach_name&gt;. <a href="#sending-files">More information on Sending Files »</a>
     * @property caption Animation caption (may also be used when resending animation by <em>file_id</em>), 0-1024 characters after entities parsing
     * @property parseMode Mode for parsing entities in the animation caption. See <a href="#formatting-options">formatting options</a> for more details.
     * @property captionEntities A JSON-serialized list of special entities that appear in the caption, which can be specified instead of <em>parse_mode</em>
     * @property showCaptionAboveMedia Pass <em>True</em>, if the caption must be shown above the message media
     * @property hasSpoiler Pass <em>True</em> if the animation needs to be covered with a spoiler animation
     * @property disableNotification Sends the message <a href="https://telegram.org/blog/channels-2-0#silent-messages">silently</a>. Users will receive a notification with no sound.
     * @property protectContent Protects the contents of the sent message from forwarding and saving
     * @property allowPaidBroadcast Pass <em>True</em> to allow up to 1000 messages per second, ignoring <a href="https://core.telegram.org/bots/faq#how-can-i-message-all-of-my-bot-39s-subscribers-at-once">broadcasting limits</a> for a fee of 0.1 Telegram Stars per message. The relevant Stars will be withdrawn from the bot's balance
     * @property messageEffectId Unique identifier of the message effect to be added to the message; for private chats only
     * @property replyParameters Description of the message to reply to
     * @property replyMarkup Additional interface options. A JSON-serialized object for an <a href="/bots/features#inline-keyboards">inline keyboard</a>, <a href="/bots/features#keyboards">custom reply keyboard</a>, instructions to remove a reply keyboard or to force a reply from the user
     * */
    data class SendAnimationRequest(
        val chatId: String,
        val animation: String,
        val businessConnectionId: String? = null,
        val messageThreadId: Long? = null,
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
        val allowPaidBroadcast: Boolean? = null,
        val messageEffectId: String? = null,
        val replyParameters: ReplyParameters? = null,
        val replyMarkup: KeyboardOption? = null,
    ) : TelegramRequest()

    /**
     * <p>Use this method to send audio files, if you want Telegram clients to display the file as a playable voice message. For this to work, your audio must be in an .OGG file encoded with OPUS, or in .MP3 format, or in .M4A format (other formats may be sent as <a href="#audio">Audio</a> or <a href="#document">Document</a>). On success, the sent <a href="#message">Message</a> is returned. Bots can currently send voice messages of up to 50 MB in size, this limit may be changed in the future.</p>
     *
     * @property chatId Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>)
     * @property voice Audio file to send. Pass a file_id as String to send a file that exists on the Telegram servers (recommended), pass an HTTP URL as a String for Telegram to get a file from the Internet, or upload a new one using multipart/form-data. <a href="#sending-files">More information on Sending Files »</a>
     * @property businessConnectionId Unique identifier of the business connection on behalf of which the message will be sent
     * @property messageThreadId Unique identifier for the target message thread (topic) of the forum; for forum supergroups only
     * @property caption Voice message caption, 0-1024 characters after entities parsing
     * @property parseMode Mode for parsing entities in the voice message caption. See <a href="#formatting-options">formatting options</a> for more details.
     * @property captionEntities A JSON-serialized list of special entities that appear in the caption, which can be specified instead of <em>parse_mode</em>
     * @property duration Duration of the voice message in seconds
     * @property disableNotification Sends the message <a href="https://telegram.org/blog/channels-2-0#silent-messages">silently</a>. Users will receive a notification with no sound.
     * @property protectContent Protects the contents of the sent message from forwarding and saving
     * @property allowPaidBroadcast Pass <em>True</em> to allow up to 1000 messages per second, ignoring <a href="https://core.telegram.org/bots/faq#how-can-i-message-all-of-my-bot-39s-subscribers-at-once">broadcasting limits</a> for a fee of 0.1 Telegram Stars per message. The relevant Stars will be withdrawn from the bot's balance
     * @property messageEffectId Unique identifier of the message effect to be added to the message; for private chats only
     * @property replyParameters Description of the message to reply to
     * @property replyMarkup Additional interface options. A JSON-serialized object for an <a href="/bots/features#inline-keyboards">inline keyboard</a>, <a href="/bots/features#keyboards">custom reply keyboard</a>, instructions to remove a reply keyboard or to force a reply from the user
     * */
    data class SendVoiceRequest(
        val chatId: String,
        val voice: String,
        val businessConnectionId: String? = null,
        val messageThreadId: Long? = null,
        val caption: String? = null,
        val parseMode: ParseMode? = null,
        val captionEntities: List<MessageEntity>? = null,
        val duration: Long? = null,
        val disableNotification: Boolean? = null,
        val protectContent: Boolean? = null,
        val allowPaidBroadcast: Boolean? = null,
        val messageEffectId: String? = null,
        val replyParameters: ReplyParameters? = null,
        val replyMarkup: KeyboardOption? = null,
    ) : TelegramRequest()

    /**
     * <p>As of <a href="https://telegram.org/blog/video-messages-and-telescope">v.4.0</a>, Telegram clients support rounded square MPEG4 videos of up to 1 minute long. Use this method to send video messages. On success, the sent <a href="#message">Message</a> is returned.</p>
     *
     * @property chatId Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>)
     * @property videoNote Video note to send. Pass a file_id as String to send a video note that exists on the Telegram servers (recommended) or upload a new video using multipart/form-data. <a href="#sending-files">More information on Sending Files »</a>. Sending video notes by a URL is currently unsupported
     * @property businessConnectionId Unique identifier of the business connection on behalf of which the message will be sent
     * @property messageThreadId Unique identifier for the target message thread (topic) of the forum; for forum supergroups only
     * @property duration Duration of sent video in seconds
     * @property length Video width and height, i.e. diameter of the video message
     * @property thumbnail Thumbnail of the file sent; can be ignored if thumbnail generation for the file is supported server-side. The thumbnail should be in JPEG format and less than 200 kB in size. A thumbnail's width and height should not exceed 320. Ignored if the file is not uploaded using multipart/form-data. Thumbnails can't be reused and can be only uploaded as a new file, so you can pass “attach://&lt;file_attach_name&gt;” if the thumbnail was uploaded using multipart/form-data under &lt;file_attach_name&gt;. <a href="#sending-files">More information on Sending Files »</a>
     * @property disableNotification Sends the message <a href="https://telegram.org/blog/channels-2-0#silent-messages">silently</a>. Users will receive a notification with no sound.
     * @property protectContent Protects the contents of the sent message from forwarding and saving
     * @property allowPaidBroadcast Pass <em>True</em> to allow up to 1000 messages per second, ignoring <a href="https://core.telegram.org/bots/faq#how-can-i-message-all-of-my-bot-39s-subscribers-at-once">broadcasting limits</a> for a fee of 0.1 Telegram Stars per message. The relevant Stars will be withdrawn from the bot's balance
     * @property messageEffectId Unique identifier of the message effect to be added to the message; for private chats only
     * @property replyParameters Description of the message to reply to
     * @property replyMarkup Additional interface options. A JSON-serialized object for an <a href="/bots/features#inline-keyboards">inline keyboard</a>, <a href="/bots/features#keyboards">custom reply keyboard</a>, instructions to remove a reply keyboard or to force a reply from the user
     * */
    data class SendVideoNoteRequest(
        val chatId: String,
        val videoNote: String,
        val businessConnectionId: String? = null,
        val messageThreadId: Long? = null,
        val duration: Long? = null,
        val length: Long? = null,
        val thumbnail: String? = null,
        val disableNotification: Boolean? = null,
        val protectContent: Boolean? = null,
        val allowPaidBroadcast: Boolean? = null,
        val messageEffectId: String? = null,
        val replyParameters: ReplyParameters? = null,
        val replyMarkup: KeyboardOption? = null,
    ) : TelegramRequest()

    /**
     * <p>Use this method to send paid media. On success, the sent <a href="#message">Message</a> is returned.</p>
     *
     * @property chatId Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>). If the chat is a channel, all Telegram Star proceeds from this media will be credited to the chat's balance. Otherwise, they will be credited to the bot's balance.
     * @property starCount The number of Telegram Stars that must be paid to buy access to the media; 1-10000
     * @property media A JSON-serialized array describing the media to be sent; up to 10 items
     * @property businessConnectionId Unique identifier of the business connection on behalf of which the message will be sent
     * @property payload Bot-defined paid media payload, 0-128 bytes. This will not be displayed to the user, use it for your internal processes.
     * @property caption Media caption, 0-1024 characters after entities parsing
     * @property parseMode Mode for parsing entities in the media caption. See <a href="#formatting-options">formatting options</a> for more details.
     * @property captionEntities A JSON-serialized list of special entities that appear in the caption, which can be specified instead of <em>parse_mode</em>
     * @property showCaptionAboveMedia Pass <em>True</em>, if the caption must be shown above the message media
     * @property disableNotification Sends the message <a href="https://telegram.org/blog/channels-2-0#silent-messages">silently</a>. Users will receive a notification with no sound.
     * @property protectContent Protects the contents of the sent message from forwarding and saving
     * @property allowPaidBroadcast Pass <em>True</em> to allow up to 1000 messages per second, ignoring <a href="https://core.telegram.org/bots/faq#how-can-i-message-all-of-my-bot-39s-subscribers-at-once">broadcasting limits</a> for a fee of 0.1 Telegram Stars per message. The relevant Stars will be withdrawn from the bot's balance
     * @property replyParameters Description of the message to reply to
     * @property replyMarkup Additional interface options. A JSON-serialized object for an <a href="/bots/features#inline-keyboards">inline keyboard</a>, <a href="/bots/features#keyboards">custom reply keyboard</a>, instructions to remove a reply keyboard or to force a reply from the user
     * */
    data class SendPaidMediaRequest(
        val chatId: String,
        val starCount: Long,
        val media: List<InputPaidMedia>,
        val businessConnectionId: String? = null,
        val payload: String? = null,
        val caption: String? = null,
        val parseMode: ParseMode? = null,
        val captionEntities: List<MessageEntity>? = null,
        val showCaptionAboveMedia: Boolean? = null,
        val disableNotification: Boolean? = null,
        val protectContent: Boolean? = null,
        val allowPaidBroadcast: Boolean? = null,
        val replyParameters: ReplyParameters? = null,
        val replyMarkup: KeyboardOption? = null,
    ) : TelegramRequest()

    /**
     * <p>Use this method to send a group of photos, videos, documents or audios as an album. Documents and audio files can be only grouped in an album with messages of the same type. On success, an array of <a href="#message">Message</a> objects that were sent is returned.</p>
     *
     * @property chatId Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>)
     * @property media A JSON-serialized array describing messages to be sent, must include 2-10 items
     * @property businessConnectionId Unique identifier of the business connection on behalf of which the message will be sent
     * @property messageThreadId Unique identifier for the target message thread (topic) of the forum; for forum supergroups only
     * @property disableNotification Sends messages <a href="https://telegram.org/blog/channels-2-0#silent-messages">silently</a>. Users will receive a notification with no sound.
     * @property protectContent Protects the contents of the sent messages from forwarding and saving
     * @property allowPaidBroadcast Pass <em>True</em> to allow up to 1000 messages per second, ignoring <a href="https://core.telegram.org/bots/faq#how-can-i-message-all-of-my-bot-39s-subscribers-at-once">broadcasting limits</a> for a fee of 0.1 Telegram Stars per message. The relevant Stars will be withdrawn from the bot's balance
     * @property messageEffectId Unique identifier of the message effect to be added to the message; for private chats only
     * @property replyParameters Description of the message to reply to
     * */
    data class SendMediaGroupRequest(
        val chatId: String,
        val media: List<InputMedia>,
        val businessConnectionId: String? = null,
        val messageThreadId: Long? = null,
        val disableNotification: Boolean? = null,
        val protectContent: Boolean? = null,
        val allowPaidBroadcast: Boolean? = null,
        val messageEffectId: String? = null,
        val replyParameters: ReplyParameters? = null,
    ) : TelegramRequest()

    /**
     * <p>Use this method to send point on the map. On success, the sent <a href="#message">Message</a> is returned.</p>
     *
     * @property chatId Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>)
     * @property latitude Latitude of the location
     * @property longitude Longitude of the location
     * @property businessConnectionId Unique identifier of the business connection on behalf of which the message will be sent
     * @property messageThreadId Unique identifier for the target message thread (topic) of the forum; for forum supergroups only
     * @property horizontalAccuracy The radius of uncertainty for the location, measured in meters; 0-1500
     * @property livePeriod Period in seconds during which the location will be updated (see <a href="https://telegram.org/blog/live-locations">Live Locations</a>, should be between 60 and 86400, or 0x7FFFFFFF for live locations that can be edited indefinitely.
     * @property heading For live locations, a direction in which the user is moving, in degrees. Must be between 1 and 360 if specified.
     * @property proximityAlertRadius For live locations, a maximum distance for proximity alerts about approaching another chat member, in meters. Must be between 1 and 100000 if specified.
     * @property disableNotification Sends the message <a href="https://telegram.org/blog/channels-2-0#silent-messages">silently</a>. Users will receive a notification with no sound.
     * @property protectContent Protects the contents of the sent message from forwarding and saving
     * @property allowPaidBroadcast Pass <em>True</em> to allow up to 1000 messages per second, ignoring <a href="https://core.telegram.org/bots/faq#how-can-i-message-all-of-my-bot-39s-subscribers-at-once">broadcasting limits</a> for a fee of 0.1 Telegram Stars per message. The relevant Stars will be withdrawn from the bot's balance
     * @property messageEffectId Unique identifier of the message effect to be added to the message; for private chats only
     * @property replyParameters Description of the message to reply to
     * @property replyMarkup Additional interface options. A JSON-serialized object for an <a href="/bots/features#inline-keyboards">inline keyboard</a>, <a href="/bots/features#keyboards">custom reply keyboard</a>, instructions to remove a reply keyboard or to force a reply from the user
     * */
    data class SendLocationRequest(
        val chatId: String,
        val latitude: Float,
        val longitude: Float,
        val businessConnectionId: String? = null,
        val messageThreadId: Long? = null,
        val horizontalAccuracy: Float? = null,
        val livePeriod: Long? = null,
        val heading: Long? = null,
        val proximityAlertRadius: Long? = null,
        val disableNotification: Boolean? = null,
        val protectContent: Boolean? = null,
        val allowPaidBroadcast: Boolean? = null,
        val messageEffectId: String? = null,
        val replyParameters: ReplyParameters? = null,
        val replyMarkup: KeyboardOption? = null,
    ) : TelegramRequest()

    /**
     * <p>Use this method to send information about a venue. On success, the sent <a href="#message">Message</a> is returned.</p>
     *
     * @property chatId Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>)
     * @property latitude Latitude of the venue
     * @property longitude Longitude of the venue
     * @property title Name of the venue
     * @property address Address of the venue
     * @property businessConnectionId Unique identifier of the business connection on behalf of which the message will be sent
     * @property messageThreadId Unique identifier for the target message thread (topic) of the forum; for forum supergroups only
     * @property foursquareId Foursquare identifier of the venue
     * @property foursquareType Foursquare type of the venue, if known. (For example, “arts_entertainment/default”, “arts_entertainment/aquarium” or “food/icecream”.)
     * @property googlePlaceId Google Places identifier of the venue
     * @property googlePlaceType Google Places type of the venue. (See <a href="https://developers.google.com/places/web-service/supported_types">supported types</a>.)
     * @property disableNotification Sends the message <a href="https://telegram.org/blog/channels-2-0#silent-messages">silently</a>. Users will receive a notification with no sound.
     * @property protectContent Protects the contents of the sent message from forwarding and saving
     * @property allowPaidBroadcast Pass <em>True</em> to allow up to 1000 messages per second, ignoring <a href="https://core.telegram.org/bots/faq#how-can-i-message-all-of-my-bot-39s-subscribers-at-once">broadcasting limits</a> for a fee of 0.1 Telegram Stars per message. The relevant Stars will be withdrawn from the bot's balance
     * @property messageEffectId Unique identifier of the message effect to be added to the message; for private chats only
     * @property replyParameters Description of the message to reply to
     * @property replyMarkup Additional interface options. A JSON-serialized object for an <a href="/bots/features#inline-keyboards">inline keyboard</a>, <a href="/bots/features#keyboards">custom reply keyboard</a>, instructions to remove a reply keyboard or to force a reply from the user
     * */
    data class SendVenueRequest(
        val chatId: String,
        val latitude: Float,
        val longitude: Float,
        val title: String,
        val address: String,
        val businessConnectionId: String? = null,
        val messageThreadId: Long? = null,
        val foursquareId: String? = null,
        val foursquareType: String? = null,
        val googlePlaceId: String? = null,
        val googlePlaceType: String? = null,
        val disableNotification: Boolean? = null,
        val protectContent: Boolean? = null,
        val allowPaidBroadcast: Boolean? = null,
        val messageEffectId: String? = null,
        val replyParameters: ReplyParameters? = null,
        val replyMarkup: KeyboardOption? = null,
    ) : TelegramRequest()

    /**
     * <p>Use this method to send phone contacts. On success, the sent <a href="#message">Message</a> is returned.</p>
     *
     * @property chatId Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>)
     * @property phoneNumber Contact's phone number
     * @property firstName Contact's first name
     * @property businessConnectionId Unique identifier of the business connection on behalf of which the message will be sent
     * @property messageThreadId Unique identifier for the target message thread (topic) of the forum; for forum supergroups only
     * @property lastName Contact's last name
     * @property vcard Additional data about the contact in the form of a <a href="https://en.wikipedia.org/wiki/VCard">vCard</a>, 0-2048 bytes
     * @property disableNotification Sends the message <a href="https://telegram.org/blog/channels-2-0#silent-messages">silently</a>. Users will receive a notification with no sound.
     * @property protectContent Protects the contents of the sent message from forwarding and saving
     * @property allowPaidBroadcast Pass <em>True</em> to allow up to 1000 messages per second, ignoring <a href="https://core.telegram.org/bots/faq#how-can-i-message-all-of-my-bot-39s-subscribers-at-once">broadcasting limits</a> for a fee of 0.1 Telegram Stars per message. The relevant Stars will be withdrawn from the bot's balance
     * @property messageEffectId Unique identifier of the message effect to be added to the message; for private chats only
     * @property replyParameters Description of the message to reply to
     * @property replyMarkup Additional interface options. A JSON-serialized object for an <a href="/bots/features#inline-keyboards">inline keyboard</a>, <a href="/bots/features#keyboards">custom reply keyboard</a>, instructions to remove a reply keyboard or to force a reply from the user
     * */
    data class SendContactRequest(
        val chatId: String,
        val phoneNumber: String,
        val firstName: String,
        val businessConnectionId: String? = null,
        val messageThreadId: Long? = null,
        val lastName: String? = null,
        val vcard: String? = null,
        val disableNotification: Boolean? = null,
        val protectContent: Boolean? = null,
        val allowPaidBroadcast: Boolean? = null,
        val messageEffectId: String? = null,
        val replyParameters: ReplyParameters? = null,
        val replyMarkup: KeyboardOption? = null,
    ) : TelegramRequest()

    /**
     * <p>Use this method to send a native poll. On success, the sent <a href="#message">Message</a> is returned.</p>
     *
     * @property chatId Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>)
     * @property question Poll question, 1-300 characters
     * @property options A JSON-serialized list of 2-12 answer options
     * @property businessConnectionId Unique identifier of the business connection on behalf of which the message will be sent
     * @property messageThreadId Unique identifier for the target message thread (topic) of the forum; for forum supergroups only
     * @property questionParseMode Mode for parsing entities in the question. See <a href="#formatting-options">formatting options</a> for more details. Currently, only custom emoji entities are allowed
     * @property questionEntities A JSON-serialized list of special entities that appear in the poll question. It can be specified instead of <em>question_parse_mode</em>
     * @property isAnonymous <em>True</em>, if the poll needs to be anonymous, defaults to <em>True</em>
     * @property type Poll type, “quiz” or “regular”, defaults to “regular”
     * @property allowsMultipleAnswers <em>True</em>, if the poll allows multiple answers, ignored for polls in quiz mode, defaults to <em>False</em>
     * @property correctOptionId 0-based identifier of the correct answer option, required for polls in quiz mode
     * @property explanation Text that is shown when a user chooses an incorrect answer or taps on the lamp icon in a quiz-style poll, 0-200 characters with at most 2 line feeds after entities parsing
     * @property explanationParseMode Mode for parsing entities in the explanation. See <a href="#formatting-options">formatting options</a> for more details.
     * @property explanationEntities A JSON-serialized list of special entities that appear in the poll explanation. It can be specified instead of <em>explanation_parse_mode</em>
     * @property openPeriod Amount of time in seconds the poll will be active after creation, 5-600. Can't be used together with <em>close_date</em>.
     * @property closeDate Point in time (Unix timestamp) when the poll will be automatically closed. Must be at least 5 and no more than 600 seconds in the future. Can't be used together with <em>open_period</em>.
     * @property isClosed Pass <em>True</em> if the poll needs to be immediately closed. This can be useful for poll preview.
     * @property disableNotification Sends the message <a href="https://telegram.org/blog/channels-2-0#silent-messages">silently</a>. Users will receive a notification with no sound.
     * @property protectContent Protects the contents of the sent message from forwarding and saving
     * @property allowPaidBroadcast Pass <em>True</em> to allow up to 1000 messages per second, ignoring <a href="https://core.telegram.org/bots/faq#how-can-i-message-all-of-my-bot-39s-subscribers-at-once">broadcasting limits</a> for a fee of 0.1 Telegram Stars per message. The relevant Stars will be withdrawn from the bot's balance
     * @property messageEffectId Unique identifier of the message effect to be added to the message; for private chats only
     * @property replyParameters Description of the message to reply to
     * @property replyMarkup Additional interface options. A JSON-serialized object for an <a href="/bots/features#inline-keyboards">inline keyboard</a>, <a href="/bots/features#keyboards">custom reply keyboard</a>, instructions to remove a reply keyboard or to force a reply from the user
     * */
    data class SendPollRequest(
        val chatId: String,
        val question: String,
        val options: List<InputPollOption>,
        val businessConnectionId: String? = null,
        val messageThreadId: Long? = null,
        val questionParseMode: String? = null,
        val questionEntities: List<MessageEntity>? = null,
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
        val allowPaidBroadcast: Boolean? = null,
        val messageEffectId: String? = null,
        val replyParameters: ReplyParameters? = null,
        val replyMarkup: KeyboardOption? = null,
    ) : TelegramRequest()

    /**
     * <p>Use this method to send a checklist on behalf of a connected business account. On success, the sent <a href="#message">Message</a> is returned.</p>
     *
     * @property businessConnectionId Unique identifier of the business connection on behalf of which the message will be sent
     * @property chatId Unique identifier for the target chat
     * @property checklist A JSON-serialized object for the checklist to send
     * @property disableNotification Sends the message silently. Users will receive a notification with no sound.
     * @property protectContent Protects the contents of the sent message from forwarding and saving
     * @property messageEffectId Unique identifier of the message effect to be added to the message
     * @property replyParameters A JSON-serialized object for description of the message to reply to
     * @property replyMarkup A JSON-serialized object for an inline keyboard
     * */
    data class SendChecklistRequest(
        val businessConnectionId: String,
        val chatId: Long,
        val checklist: InputChecklist,
        val disableNotification: Boolean? = null,
        val protectContent: Boolean? = null,
        val messageEffectId: String? = null,
        val replyParameters: ReplyParameters? = null,
        val replyMarkup: InlineKeyboardMarkup? = null,
    ) : TelegramRequest()

    /**
     * <p>Use this method to send an animated emoji that will display a random value. On success, the sent <a href="#message">Message</a> is returned.</p>
     *
     * @property chatId Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>)
     * @property businessConnectionId Unique identifier of the business connection on behalf of which the message will be sent
     * @property messageThreadId Unique identifier for the target message thread (topic) of the forum; for forum supergroups only
     * @property emoji Emoji on which the dice throw animation is based. Currently, must be one of “<img class="emoji" src="//telegram.org/img/emoji/40/F09F8EB2.png" width="20" height="20" alt="🎲">”, “<img class="emoji" src="//telegram.org/img/emoji/40/F09F8EAF.png" width="20" height="20" alt="🎯">”, “<img class="emoji" src="//telegram.org/img/emoji/40/F09F8F80.png" width="20" height="20" alt="🏀">”, “<img class="emoji" src="//telegram.org/img/emoji/40/E29ABD.png" width="20" height="20" alt="⚽">”, “<img class="emoji" src="//telegram.org/img/emoji/40/F09F8EB3.png" width="20" height="20" alt="🎳">”, or “<img class="emoji" src="//telegram.org/img/emoji/40/F09F8EB0.png" width="20" height="20" alt="🎰">”. Dice can have values 1-6 for “<img class="emoji" src="//telegram.org/img/emoji/40/F09F8EB2.png" width="20" height="20" alt="🎲">”, “<img class="emoji" src="//telegram.org/img/emoji/40/F09F8EAF.png" width="20" height="20" alt="🎯">” and “<img class="emoji" src="//telegram.org/img/emoji/40/F09F8EB3.png" width="20" height="20" alt="🎳">”, values 1-5 for “<img class="emoji" src="//telegram.org/img/emoji/40/F09F8F80.png" width="20" height="20" alt="🏀">” and “<img class="emoji" src="//telegram.org/img/emoji/40/E29ABD.png" width="20" height="20" alt="⚽">”, and values 1-64 for “<img class="emoji" src="//telegram.org/img/emoji/40/F09F8EB0.png" width="20" height="20" alt="🎰">”. Defaults to “<img class="emoji" src="//telegram.org/img/emoji/40/F09F8EB2.png" width="20" height="20" alt="🎲">”
     * @property disableNotification Sends the message <a href="https://telegram.org/blog/channels-2-0#silent-messages">silently</a>. Users will receive a notification with no sound.
     * @property protectContent Protects the contents of the sent message from forwarding
     * @property allowPaidBroadcast Pass <em>True</em> to allow up to 1000 messages per second, ignoring <a href="https://core.telegram.org/bots/faq#how-can-i-message-all-of-my-bot-39s-subscribers-at-once">broadcasting limits</a> for a fee of 0.1 Telegram Stars per message. The relevant Stars will be withdrawn from the bot's balance
     * @property messageEffectId Unique identifier of the message effect to be added to the message; for private chats only
     * @property replyParameters Description of the message to reply to
     * @property replyMarkup Additional interface options. A JSON-serialized object for an <a href="/bots/features#inline-keyboards">inline keyboard</a>, <a href="/bots/features#keyboards">custom reply keyboard</a>, instructions to remove a reply keyboard or to force a reply from the user
     * */
    data class SendDiceRequest(
        val chatId: String,
        val businessConnectionId: String? = null,
        val messageThreadId: Long? = null,
        val emoji: String? = null,
        val disableNotification: Boolean? = null,
        val protectContent: Boolean? = null,
        val allowPaidBroadcast: Boolean? = null,
        val messageEffectId: String? = null,
        val replyParameters: ReplyParameters? = null,
        val replyMarkup: KeyboardOption? = null,
    ) : TelegramRequest()

    /**
     * <p>Use this method when you need to tell the user that something is happening on the bot's side. The status is set for 5 seconds or less (when a message arrives from your bot, Telegram clients clear its typing status). Returns <em>True</em> on success.</p><blockquote>
     *  <p>Example: The <a href="https://t.me/imagebot">ImageBot</a> needs some time to process a request and upload the image. Instead of sending a text message along the lines of “Retrieving image, please wait…”, the bot may use <a href="#sendchataction">sendChatAction</a> with <em>action</em> = <em>upload_photo</em>. The user will see a “sending photo” status for the bot.</p>
     * </blockquote><p>We only recommend using this method when a response from the bot will take a <strong>noticeable</strong> amount of time to arrive.</p>
     *
     * @property chatId Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>)
     * @property action Type of action to broadcast. Choose one, depending on what the user is about to receive: <em>typing</em> for <a href="#sendmessage">text messages</a>, <em>upload_photo</em> for <a href="#sendphoto">photos</a>, <em>record_video</em> or <em>upload_video</em> for <a href="#sendvideo">videos</a>, <em>record_voice</em> or <em>upload_voice</em> for <a href="#sendvoice">voice notes</a>, <em>upload_document</em> for <a href="#senddocument">general files</a>, <em>choose_sticker</em> for <a href="#sendsticker">stickers</a>, <em>find_location</em> for <a href="#sendlocation">location data</a>, <em>record_video_note</em> or <em>upload_video_note</em> for <a href="#sendvideonote">video notes</a>.
     * @property businessConnectionId Unique identifier of the business connection on behalf of which the action will be sent
     * @property messageThreadId Unique identifier for the target message thread; for supergroups only
     * */
    data class SendChatActionRequest(
        val chatId: String,
        val action: String,
        val businessConnectionId: String? = null,
        val messageThreadId: Long? = null,
    ) : TelegramRequest()

    /**
     * <p>Use this method to change the chosen reactions on a message. Service messages of some types can't be reacted to. Automatically forwarded messages from a channel to its discussion group have the same available reactions as messages in the channel. Bots can't use paid reactions. Returns <em>True</em> on success.</p>
     *
     * @property chatId Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>)
     * @property messageId Identifier of the target message. If the message belongs to a media group, the reaction is set to the first non-deleted message in the group instead.
     * @property reaction A JSON-serialized list of reaction types to set on the message. Currently, as non-premium users, bots can set up to one reaction per message. A custom emoji reaction can be used if it is either already present on the message or explicitly allowed by chat administrators. Paid reactions can't be used by bots.
     * @property isBig Pass <em>True</em> to set the reaction with a big animation
     * */
    data class SetMessageReactionRequest(
        val chatId: String,
        val messageId: Long,
        val reaction: List<ReactionType>? = null,
        val isBig: Boolean? = null,
    ) : TelegramRequest()

    /**
     * <p>Use this method to get a list of profile pictures for a user. Returns a <a href="#userprofilephotos">UserProfilePhotos</a> object.</p>
     *
     * @property userId Unique identifier of the target user
     * @property offset Sequential number of the first photo to be returned. By default, all photos are returned.
     * @property limit Limits the number of photos to be retrieved. Values between 1-100 are accepted. Defaults to 100.
     * */
    data class GetUserProfilePhotosRequest(
        val userId: Long,
        val offset: Long? = null,
        val limit: Long? = null,
    ) : TelegramRequest()

    /**
     * <p>Changes the emoji status for a given user that previously allowed the bot to manage their emoji status via the Mini App method <a href="/bots/webapps#initializing-mini-apps">requestEmojiStatusAccess</a>. Returns <em>True</em> on success.</p>
     *
     * @property userId Unique identifier of the target user
     * @property emojiStatusCustomEmojiId Custom emoji identifier of the emoji status to set. Pass an empty string to remove the status.
     * @property emojiStatusExpirationDate Expiration date of the emoji status, if any
     * */
    data class SetUserEmojiStatusRequest(
        val userId: Long,
        val emojiStatusCustomEmojiId: String? = null,
        val emojiStatusExpirationDate: Long? = null,
    ) : TelegramRequest()

    /**
     * <p>Use this method to get basic information about a file and prepare it for downloading. For the moment, bots can download files of up to 20MB in size. On success, a <a href="#file">File</a> object is returned. The file can then be downloaded via the link <code>https://api.telegram.org/file/bot&lt;token&gt;/&lt;file_path&gt;</code>, where <code>&lt;file_path&gt;</code> is taken from the response. It is guaranteed that the link will be valid for at least 1 hour. When the link expires, a new one can be requested by calling <a href="#getfile">getFile</a> again.</p><p><strong>Note:</strong> This function may not preserve the original file name and MIME type. You should save the file's MIME type and name (if available) when the File object is received.</p>
     *
     * @property fileId File identifier to get information about
     * */
    data class GetFileRequest(
        val fileId: String,
    ) : TelegramRequest()

    /**
     * <p>Use this method to ban a user in a group, a supergroup or a channel. In the case of supergroups and channels, the user will not be able to return to the chat on their own using invite links, etc., unless <a href="#unbanchatmember">unbanned</a> first. The bot must be an administrator in the chat for this to work and must have the appropriate administrator rights. Returns <em>True</em> on success.</p>
     *
     * @property chatId Unique identifier for the target group or username of the target supergroup or channel (in the format <code>@channelusername</code>)
     * @property userId Unique identifier of the target user
     * @property untilDate Date when the user will be unbanned; Unix time. If user is banned for more than 366 days or less than 30 seconds from the current time they are considered to be banned forever. Applied for supergroups and channels only.
     * @property revokeMessages Pass <em>True</em> to delete all messages from the chat for the user that is being removed. If <em>False</em>, the user will be able to see messages in the group that were sent before the user was removed. Always <em>True</em> for supergroups and channels.
     * */
    data class BanChatMemberRequest(
        val chatId: String,
        val userId: Long,
        val untilDate: Long? = null,
        val revokeMessages: Boolean? = null,
    ) : TelegramRequest()

    /**
     * <p>Use this method to unban a previously banned user in a supergroup or channel. The user will <strong>not</strong> return to the group or channel automatically, but will be able to join via link, etc. The bot must be an administrator for this to work. By default, this method guarantees that after the call the user is not a member of the chat, but will be able to join it. So if the user is a member of the chat they will also be <strong>removed</strong> from the chat. If you don't want this, use the parameter <em>only_if_banned</em>. Returns <em>True</em> on success.</p>
     *
     * @property chatId Unique identifier for the target group or username of the target supergroup or channel (in the format <code>@channelusername</code>)
     * @property userId Unique identifier of the target user
     * @property onlyIfBanned Do nothing if the user is not banned
     * */
    data class UnbanChatMemberRequest(
        val chatId: String,
        val userId: Long,
        val onlyIfBanned: Boolean? = null,
    ) : TelegramRequest()

    /**
     * <p>Use this method to restrict a user in a supergroup. The bot must be an administrator in the supergroup for this to work and must have the appropriate administrator rights. Pass <em>True</em> for all permissions to lift restrictions from a user. Returns <em>True</em> on success.</p>
     *
     * @property chatId Unique identifier for the target chat or username of the target supergroup (in the format <code>@supergroupusername</code>)
     * @property userId Unique identifier of the target user
     * @property permissions A JSON-serialized object for new user permissions
     * @property useIndependentChatPermissions Pass <em>True</em> if chat permissions are set independently. Otherwise, the <em>can_send_other_messages</em> and <em>can_add_web_page_previews</em> permissions will imply the <em>can_send_messages</em>, <em>can_send_audios</em>, <em>can_send_documents</em>, <em>can_send_photos</em>, <em>can_send_videos</em>, <em>can_send_video_notes</em>, and <em>can_send_voice_notes</em> permissions; the <em>can_send_polls</em> permission will imply the <em>can_send_messages</em> permission.
     * @property untilDate Date when restrictions will be lifted for the user; Unix time. If user is restricted for more than 366 days or less than 30 seconds from the current time, they are considered to be restricted forever
     * */
    data class RestrictChatMemberRequest(
        val chatId: String,
        val userId: Long,
        val permissions: ChatPermissions,
        val useIndependentChatPermissions: Boolean? = null,
        val untilDate: Long? = null,
    ) : TelegramRequest()

    /**
     * <p>Use this method to promote or demote a user in a supergroup or a channel. The bot must be an administrator in the chat for this to work and must have the appropriate administrator rights. Pass <em>False</em> for all boolean parameters to demote a user. Returns <em>True</em> on success.</p>
     *
     * @property chatId Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>)
     * @property userId Unique identifier of the target user
     * @property isAnonymous Pass <em>True</em> if the administrator's presence in the chat is hidden
     * @property canManageChat Pass <em>True</em> if the administrator can access the chat event log, get boost list, see hidden supergroup and channel members, report spam messages, ignore slow mode, and send messages to the chat without paying Telegram Stars. Implied by any other administrator privilege.
     * @property canDeleteMessages Pass <em>True</em> if the administrator can delete messages of other users
     * @property canManageVideoChats Pass <em>True</em> if the administrator can manage video chats
     * @property canRestrictMembers Pass <em>True</em> if the administrator can restrict, ban or unban chat members, or access supergroup statistics
     * @property canPromoteMembers Pass <em>True</em> if the administrator can add new administrators with a subset of their own privileges or demote administrators that they have promoted, directly or indirectly (promoted by administrators that were appointed by him)
     * @property canChangeInfo Pass <em>True</em> if the administrator can change chat title, photo and other settings
     * @property canInviteUsers Pass <em>True</em> if the administrator can invite new users to the chat
     * @property canPostStories Pass <em>True</em> if the administrator can post stories to the chat
     * @property canEditStories Pass <em>True</em> if the administrator can edit stories posted by other users, post stories to the chat page, pin chat stories, and access the chat's story archive
     * @property canDeleteStories Pass <em>True</em> if the administrator can delete stories posted by other users
     * @property canPostMessages Pass <em>True</em> if the administrator can post messages in the channel, approve suggested posts, or access channel statistics; for channels only
     * @property canEditMessages Pass <em>True</em> if the administrator can edit messages of other users and can pin messages; for channels only
     * @property canPinMessages Pass <em>True</em> if the administrator can pin messages; for supergroups only
     * @property canManageTopics Pass <em>True</em> if the user is allowed to create, rename, close, and reopen forum topics; for supergroups only
     * */
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

    /**
     * <p>Use this method to set a custom title for an administrator in a supergroup promoted by the bot. Returns <em>True</em> on success.</p>
     *
     * @property chatId Unique identifier for the target chat or username of the target supergroup (in the format <code>@supergroupusername</code>)
     * @property userId Unique identifier of the target user
     * @property customTitle New custom title for the administrator; 0-16 characters, emoji are not allowed
     * */
    data class SetChatAdministratorCustomTitleRequest(
        val chatId: String,
        val userId: Long,
        val customTitle: String,
    ) : TelegramRequest()

    /**
     * <p>Use this method to ban a channel chat in a supergroup or a channel. Until the chat is <a href="#unbanchatsenderchat">unbanned</a>, the owner of the banned chat won't be able to send messages on behalf of <strong>any of their channels</strong>. The bot must be an administrator in the supergroup or channel for this to work and must have the appropriate administrator rights. Returns <em>True</em> on success.</p>
     *
     * @property chatId Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>)
     * @property senderChatId Unique identifier of the target sender chat
     * */
    data class BanChatSenderChatRequest(
        val chatId: String,
        val senderChatId: Long,
    ) : TelegramRequest()

    /**
     * <p>Use this method to unban a previously banned channel chat in a supergroup or channel. The bot must be an administrator for this to work and must have the appropriate administrator rights. Returns <em>True</em> on success.</p>
     *
     * @property chatId Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>)
     * @property senderChatId Unique identifier of the target sender chat
     * */
    data class UnbanChatSenderChatRequest(
        val chatId: String,
        val senderChatId: Long,
    ) : TelegramRequest()

    /**
     * <p>Use this method to set default chat permissions for all members. The bot must be an administrator in the group or a supergroup for this to work and must have the <em>can_restrict_members</em> administrator rights. Returns <em>True</em> on success.</p>
     *
     * @property chatId Unique identifier for the target chat or username of the target supergroup (in the format <code>@supergroupusername</code>)
     * @property permissions A JSON-serialized object for new default chat permissions
     * @property useIndependentChatPermissions Pass <em>True</em> if chat permissions are set independently. Otherwise, the <em>can_send_other_messages</em> and <em>can_add_web_page_previews</em> permissions will imply the <em>can_send_messages</em>, <em>can_send_audios</em>, <em>can_send_documents</em>, <em>can_send_photos</em>, <em>can_send_videos</em>, <em>can_send_video_notes</em>, and <em>can_send_voice_notes</em> permissions; the <em>can_send_polls</em> permission will imply the <em>can_send_messages</em> permission.
     * */
    data class SetChatPermissionsRequest(
        val chatId: String,
        val permissions: ChatPermissions,
        val useIndependentChatPermissions: Boolean? = null,
    ) : TelegramRequest()

    /**
     * <p>Use this method to generate a new primary invite link for a chat; any previously generated primary link is revoked. The bot must be an administrator in the chat for this to work and must have the appropriate administrator rights. Returns the new invite link as <em>String</em> on success.</p><blockquote>
     *  <p>Note: Each administrator in a chat generates their own invite links. Bots can't use invite links generated by other administrators. If you want your bot to work with invite links, it will need to generate its own link using <a href="#exportchatinvitelink">exportChatInviteLink</a> or by calling the <a href="#getchat">getChat</a> method. If your bot needs to generate a new primary invite link replacing its previous one, use <a href="#exportchatinvitelink">exportChatInviteLink</a> again.</p>
     * </blockquote>
     *
     * @property chatId Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>)
     * */
    data class ExportChatInviteLinkRequest(
        val chatId: String,
    ) : TelegramRequest()

    /**
     * <p>Use this method to create an additional invite link for a chat. The bot must be an administrator in the chat for this to work and must have the appropriate administrator rights. The link can be revoked using the method <a href="#revokechatinvitelink">revokeChatInviteLink</a>. Returns the new invite link as <a href="#chatinvitelink">ChatInviteLink</a> object.</p>
     *
     * @property chatId Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>)
     * @property name Invite link name; 0-32 characters
     * @property expireDate Point in time (Unix timestamp) when the link will expire
     * @property memberLimit The maximum number of users that can be members of the chat simultaneously after joining the chat via this invite link; 1-99999
     * @property createsJoinRequest <em>True</em>, if users joining the chat via the link need to be approved by chat administrators. If <em>True</em>, <em>member_limit</em> can't be specified
     * */
    data class CreateChatInviteLinkRequest(
        val chatId: String,
        val name: String? = null,
        val expireDate: Long? = null,
        val memberLimit: Long? = null,
        val createsJoinRequest: Boolean? = null,
    ) : TelegramRequest()

    /**
     * <p>Use this method to edit a non-primary invite link created by the bot. The bot must be an administrator in the chat for this to work and must have the appropriate administrator rights. Returns the edited invite link as a <a href="#chatinvitelink">ChatInviteLink</a> object.</p>
     *
     * @property chatId Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>)
     * @property inviteLink The invite link to edit
     * @property name Invite link name; 0-32 characters
     * @property expireDate Point in time (Unix timestamp) when the link will expire
     * @property memberLimit The maximum number of users that can be members of the chat simultaneously after joining the chat via this invite link; 1-99999
     * @property createsJoinRequest <em>True</em>, if users joining the chat via the link need to be approved by chat administrators. If <em>True</em>, <em>member_limit</em> can't be specified
     * */
    data class EditChatInviteLinkRequest(
        val chatId: String,
        val inviteLink: String,
        val name: String? = null,
        val expireDate: Long? = null,
        val memberLimit: Long? = null,
        val createsJoinRequest: Boolean? = null,
    ) : TelegramRequest()

    /**
     * <p>Use this method to create a <a href="https://telegram.org/blog/superchannels-star-reactions-subscriptions#star-subscriptions">subscription invite link</a> for a channel chat. The bot must have the <em>can_invite_users</em> administrator rights. The link can be edited using the method <a href="#editchatsubscriptioninvitelink">editChatSubscriptionInviteLink</a> or revoked using the method <a href="#revokechatinvitelink">revokeChatInviteLink</a>. Returns the new invite link as a <a href="#chatinvitelink">ChatInviteLink</a> object.</p>
     *
     * @property chatId Unique identifier for the target channel chat or username of the target channel (in the format <code>@channelusername</code>)
     * @property subscriptionPeriod The number of seconds the subscription will be active for before the next payment. Currently, it must always be 2592000 (30 days).
     * @property subscriptionPrice The amount of Telegram Stars a user must pay initially and after each subsequent subscription period to be a member of the chat; 1-10000
     * @property name Invite link name; 0-32 characters
     * */
    data class CreateChatSubscriptionInviteLinkRequest(
        val chatId: String,
        val subscriptionPeriod: Long,
        val subscriptionPrice: Long,
        val name: String? = null,
    ) : TelegramRequest()

    /**
     * <p>Use this method to edit a subscription invite link created by the bot. The bot must have the <em>can_invite_users</em> administrator rights. Returns the edited invite link as a <a href="#chatinvitelink">ChatInviteLink</a> object.</p>
     *
     * @property chatId Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>)
     * @property inviteLink The invite link to edit
     * @property name Invite link name; 0-32 characters
     * */
    data class EditChatSubscriptionInviteLinkRequest(
        val chatId: String,
        val inviteLink: String,
        val name: String? = null,
    ) : TelegramRequest()

    /**
     * <p>Use this method to revoke an invite link created by the bot. If the primary link is revoked, a new link is automatically generated. The bot must be an administrator in the chat for this to work and must have the appropriate administrator rights. Returns the revoked invite link as <a href="#chatinvitelink">ChatInviteLink</a> object.</p>
     *
     * @property chatId Unique identifier of the target chat or username of the target channel (in the format <code>@channelusername</code>)
     * @property inviteLink The invite link to revoke
     * */
    data class RevokeChatInviteLinkRequest(
        val chatId: String,
        val inviteLink: String,
    ) : TelegramRequest()

    /**
     * <p>Use this method to approve a chat join request. The bot must be an administrator in the chat for this to work and must have the <em>can_invite_users</em> administrator right. Returns <em>True</em> on success.</p>
     *
     * @property chatId Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>)
     * @property userId Unique identifier of the target user
     * */
    data class ApproveChatJoinRequestRequest(
        val chatId: String,
        val userId: Long,
    ) : TelegramRequest()

    /**
     * <p>Use this method to decline a chat join request. The bot must be an administrator in the chat for this to work and must have the <em>can_invite_users</em> administrator right. Returns <em>True</em> on success.</p>
     *
     * @property chatId Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>)
     * @property userId Unique identifier of the target user
     * */
    data class DeclineChatJoinRequestRequest(
        val chatId: String,
        val userId: Long,
    ) : TelegramRequest()

    /**
     * <p>Use this method to set a new profile photo for the chat. Photos can't be changed for private chats. The bot must be an administrator in the chat for this to work and must have the appropriate administrator rights. Returns <em>True</em> on success.</p>
     *
     * @property chatId Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>)
     * @property photo New chat photo, uploaded using multipart/form-data
     * */
    data class SetChatPhotoRequest(
        val chatId: String,
        val photo: Any,
    ) : TelegramRequest()

    /**
     * <p>Use this method to delete a chat photo. Photos can't be changed for private chats. The bot must be an administrator in the chat for this to work and must have the appropriate administrator rights. Returns <em>True</em> on success.</p>
     *
     * @property chatId Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>)
     * */
    data class DeleteChatPhotoRequest(
        val chatId: String,
    ) : TelegramRequest()

    /**
     * <p>Use this method to change the title of a chat. Titles can't be changed for private chats. The bot must be an administrator in the chat for this to work and must have the appropriate administrator rights. Returns <em>True</em> on success.</p>
     *
     * @property chatId Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>)
     * @property title New chat title, 1-128 characters
     * */
    data class SetChatTitleRequest(
        val chatId: String,
        val title: String,
    ) : TelegramRequest()

    /**
     * <p>Use this method to change the description of a group, a supergroup or a channel. The bot must be an administrator in the chat for this to work and must have the appropriate administrator rights. Returns <em>True</em> on success.</p>
     *
     * @property chatId Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>)
     * @property description New chat description, 0-255 characters
     * */
    data class SetChatDescriptionRequest(
        val chatId: String,
        val description: String? = null,
    ) : TelegramRequest()

    /**
     * <p>Use this method to add a message to the list of pinned messages in a chat. If the chat is not a private chat, the bot must be an administrator in the chat for this to work and must have the 'can_pin_messages' administrator right in a supergroup or 'can_edit_messages' administrator right in a channel. Returns <em>True</em> on success.</p>
     *
     * @property chatId Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>)
     * @property messageId Identifier of a message to pin
     * @property businessConnectionId Unique identifier of the business connection on behalf of which the message will be pinned
     * @property disableNotification Pass <em>True</em> if it is not necessary to send a notification to all chat members about the new pinned message. Notifications are always disabled in channels and private chats.
     * */
    data class PinChatMessageRequest(
        val chatId: String,
        val messageId: Long,
        val businessConnectionId: String? = null,
        val disableNotification: Boolean? = null,
    ) : TelegramRequest()

    /**
     * <p>Use this method to remove a message from the list of pinned messages in a chat. If the chat is not a private chat, the bot must be an administrator in the chat for this to work and must have the 'can_pin_messages' administrator right in a supergroup or 'can_edit_messages' administrator right in a channel. Returns <em>True</em> on success.</p>
     *
     * @property chatId Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>)
     * @property businessConnectionId Unique identifier of the business connection on behalf of which the message will be unpinned
     * @property messageId Identifier of the message to unpin. Required if <em>business_connection_id</em> is specified. If not specified, the most recent pinned message (by sending date) will be unpinned.
     * */
    data class UnpinChatMessageRequest(
        val chatId: String,
        val businessConnectionId: String? = null,
        val messageId: Long? = null,
    ) : TelegramRequest()

    /**
     * <p>Use this method to clear the list of pinned messages in a chat. If the chat is not a private chat, the bot must be an administrator in the chat for this to work and must have the 'can_pin_messages' administrator right in a supergroup or 'can_edit_messages' administrator right in a channel. Returns <em>True</em> on success.</p>
     *
     * @property chatId Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>)
     * */
    data class UnpinAllChatMessagesRequest(
        val chatId: String,
    ) : TelegramRequest()

    /**
     * <p>Use this method for your bot to leave a group, supergroup or channel. Returns <em>True</em> on success.</p>
     *
     * @property chatId Unique identifier for the target chat or username of the target supergroup or channel (in the format <code>@channelusername</code>)
     * */
    data class LeaveChatRequest(
        val chatId: String,
    ) : TelegramRequest()

    /**
     * <p>Use this method to get up-to-date information about the chat. Returns a <a href="#chatfullinfo">ChatFullInfo</a> object on success.</p>
     *
     * @property chatId Unique identifier for the target chat or username of the target supergroup or channel (in the format <code>@channelusername</code>)
     * */
    data class GetChatRequest(
        val chatId: String,
    ) : TelegramRequest()

    /**
     * <p>Use this method to get a list of administrators in a chat, which aren't bots. Returns an Array of <a href="#chatmember">ChatMember</a> objects.</p>
     *
     * @property chatId Unique identifier for the target chat or username of the target supergroup or channel (in the format <code>@channelusername</code>)
     * */
    data class GetChatAdministratorsRequest(
        val chatId: String,
    ) : TelegramRequest()

    /**
     * <p>Use this method to get the number of members in a chat. Returns <em>Int</em> on success.</p>
     *
     * @property chatId Unique identifier for the target chat or username of the target supergroup or channel (in the format <code>@channelusername</code>)
     * */
    data class GetChatMemberCountRequest(
        val chatId: String,
    ) : TelegramRequest()

    /**
     * <p>Use this method to get information about a member of a chat. The method is only guaranteed to work for other users if the bot is an administrator in the chat. Returns a <a href="#chatmember">ChatMember</a> object on success.</p>
     *
     * @property chatId Unique identifier for the target chat or username of the target supergroup or channel (in the format <code>@channelusername</code>)
     * @property userId Unique identifier of the target user
     * */
    data class GetChatMemberRequest(
        val chatId: String,
        val userId: Long,
    ) : TelegramRequest()

    /**
     * <p>Use this method to set a new group sticker set for a supergroup. The bot must be an administrator in the chat for this to work and must have the appropriate administrator rights. Use the field <em>can_set_sticker_set</em> optionally returned in <a href="#getchat">getChat</a> requests to check if the bot can use this method. Returns <em>True</em> on success.</p>
     *
     * @property chatId Unique identifier for the target chat or username of the target supergroup (in the format <code>@supergroupusername</code>)
     * @property stickerSetName Name of the sticker set to be set as the group sticker set
     * */
    data class SetChatStickerSetRequest(
        val chatId: String,
        val stickerSetName: String,
    ) : TelegramRequest()

    /**
     * <p>Use this method to delete a group sticker set from a supergroup. The bot must be an administrator in the chat for this to work and must have the appropriate administrator rights. Use the field <em>can_set_sticker_set</em> optionally returned in <a href="#getchat">getChat</a> requests to check if the bot can use this method. Returns <em>True</em> on success.</p>
     *
     * @property chatId Unique identifier for the target chat or username of the target supergroup (in the format <code>@supergroupusername</code>)
     * */
    data class DeleteChatStickerSetRequest(
        val chatId: String,
    ) : TelegramRequest()

    /**
     * <p>Use this method to create a topic in a forum supergroup chat. The bot must be an administrator in the chat for this to work and must have the <em>can_manage_topics</em> administrator rights. Returns information about the created topic as a <a href="#forumtopic">ForumTopic</a> object.</p>
     *
     * @property chatId Unique identifier for the target chat or username of the target supergroup (in the format <code>@supergroupusername</code>)
     * @property name Topic name, 1-128 characters
     * @property iconColor Color of the topic icon in RGB format. Currently, must be one of 7322096 (0x6FB9F0), 16766590 (0xFFD67E), 13338331 (0xCB86DB), 9367192 (0x8EEE98), 16749490 (0xFF93B2), or 16478047 (0xFB6F5F)
     * @property iconCustomEmojiId Unique identifier of the custom emoji shown as the topic icon. Use <a href="#getforumtopiciconstickers">getForumTopicIconStickers</a> to get all allowed custom emoji identifiers.
     * */
    data class CreateForumTopicRequest(
        val chatId: String,
        val name: String,
        val iconColor: Long? = null,
        val iconCustomEmojiId: String? = null,
    ) : TelegramRequest()

    /**
     * <p>Use this method to edit name and icon of a topic in a forum supergroup chat. The bot must be an administrator in the chat for this to work and must have the <em>can_manage_topics</em> administrator rights, unless it is the creator of the topic. Returns <em>True</em> on success.</p>
     *
     * @property chatId Unique identifier for the target chat or username of the target supergroup (in the format <code>@supergroupusername</code>)
     * @property messageThreadId Unique identifier for the target message thread of the forum topic
     * @property name New topic name, 0-128 characters. If not specified or empty, the current name of the topic will be kept
     * @property iconCustomEmojiId New unique identifier of the custom emoji shown as the topic icon. Use <a href="#getforumtopiciconstickers">getForumTopicIconStickers</a> to get all allowed custom emoji identifiers. Pass an empty string to remove the icon. If not specified, the current icon will be kept
     * */
    data class EditForumTopicRequest(
        val chatId: String,
        val messageThreadId: Long,
        val name: String? = null,
        val iconCustomEmojiId: String? = null,
    ) : TelegramRequest()

    /**
     * <p>Use this method to close an open topic in a forum supergroup chat. The bot must be an administrator in the chat for this to work and must have the <em>can_manage_topics</em> administrator rights, unless it is the creator of the topic. Returns <em>True</em> on success.</p>
     *
     * @property chatId Unique identifier for the target chat or username of the target supergroup (in the format <code>@supergroupusername</code>)
     * @property messageThreadId Unique identifier for the target message thread of the forum topic
     * */
    data class CloseForumTopicRequest(
        val chatId: String,
        val messageThreadId: Long,
    ) : TelegramRequest()

    /**
     * <p>Use this method to reopen a closed topic in a forum supergroup chat. The bot must be an administrator in the chat for this to work and must have the <em>can_manage_topics</em> administrator rights, unless it is the creator of the topic. Returns <em>True</em> on success.</p>
     *
     * @property chatId Unique identifier for the target chat or username of the target supergroup (in the format <code>@supergroupusername</code>)
     * @property messageThreadId Unique identifier for the target message thread of the forum topic
     * */
    data class ReopenForumTopicRequest(
        val chatId: String,
        val messageThreadId: Long,
    ) : TelegramRequest()

    /**
     * <p>Use this method to delete a forum topic along with all its messages in a forum supergroup chat. The bot must be an administrator in the chat for this to work and must have the <em>can_delete_messages</em> administrator rights. Returns <em>True</em> on success.</p>
     *
     * @property chatId Unique identifier for the target chat or username of the target supergroup (in the format <code>@supergroupusername</code>)
     * @property messageThreadId Unique identifier for the target message thread of the forum topic
     * */
    data class DeleteForumTopicRequest(
        val chatId: String,
        val messageThreadId: Long,
    ) : TelegramRequest()

    /**
     * <p>Use this method to clear the list of pinned messages in a forum topic. The bot must be an administrator in the chat for this to work and must have the <em>can_pin_messages</em> administrator right in the supergroup. Returns <em>True</em> on success.</p>
     *
     * @property chatId Unique identifier for the target chat or username of the target supergroup (in the format <code>@supergroupusername</code>)
     * @property messageThreadId Unique identifier for the target message thread of the forum topic
     * */
    data class UnpinAllForumTopicMessagesRequest(
        val chatId: String,
        val messageThreadId: Long,
    ) : TelegramRequest()

    /**
     * <p>Use this method to edit the name of the 'General' topic in a forum supergroup chat. The bot must be an administrator in the chat for this to work and must have the <em>can_manage_topics</em> administrator rights. Returns <em>True</em> on success.</p>
     *
     * @property chatId Unique identifier for the target chat or username of the target supergroup (in the format <code>@supergroupusername</code>)
     * @property name New topic name, 1-128 characters
     * */
    data class EditGeneralForumTopicRequest(
        val chatId: String,
        val name: String,
    ) : TelegramRequest()

    /**
     * <p>Use this method to close an open 'General' topic in a forum supergroup chat. The bot must be an administrator in the chat for this to work and must have the <em>can_manage_topics</em> administrator rights. Returns <em>True</em> on success.</p>
     *
     * @property chatId Unique identifier for the target chat or username of the target supergroup (in the format <code>@supergroupusername</code>)
     * */
    data class CloseGeneralForumTopicRequest(
        val chatId: String,
    ) : TelegramRequest()

    /**
     * <p>Use this method to reopen a closed 'General' topic in a forum supergroup chat. The bot must be an administrator in the chat for this to work and must have the <em>can_manage_topics</em> administrator rights. The topic will be automatically unhidden if it was hidden. Returns <em>True</em> on success.</p>
     *
     * @property chatId Unique identifier for the target chat or username of the target supergroup (in the format <code>@supergroupusername</code>)
     * */
    data class ReopenGeneralForumTopicRequest(
        val chatId: String,
    ) : TelegramRequest()

    /**
     * <p>Use this method to hide the 'General' topic in a forum supergroup chat. The bot must be an administrator in the chat for this to work and must have the <em>can_manage_topics</em> administrator rights. The topic will be automatically closed if it was open. Returns <em>True</em> on success.</p>
     *
     * @property chatId Unique identifier for the target chat or username of the target supergroup (in the format <code>@supergroupusername</code>)
     * */
    data class HideGeneralForumTopicRequest(
        val chatId: String,
    ) : TelegramRequest()

    /**
     * <p>Use this method to unhide the 'General' topic in a forum supergroup chat. The bot must be an administrator in the chat for this to work and must have the <em>can_manage_topics</em> administrator rights. Returns <em>True</em> on success.</p>
     *
     * @property chatId Unique identifier for the target chat or username of the target supergroup (in the format <code>@supergroupusername</code>)
     * */
    data class UnhideGeneralForumTopicRequest(
        val chatId: String,
    ) : TelegramRequest()

    /**
     * <p>Use this method to clear the list of pinned messages in a General forum topic. The bot must be an administrator in the chat for this to work and must have the <em>can_pin_messages</em> administrator right in the supergroup. Returns <em>True</em> on success.</p>
     *
     * @property chatId Unique identifier for the target chat or username of the target supergroup (in the format <code>@supergroupusername</code>)
     * */
    data class UnpinAllGeneralForumTopicMessagesRequest(
        val chatId: String,
    ) : TelegramRequest()

    /**
     * <p>Use this method to send answers to callback queries sent from <a href="/bots/features#inline-keyboards">inline keyboards</a>. The answer will be displayed to the user as a notification at the top of the chat screen or as an alert. On success, <em>True</em> is returned.</p><blockquote>
     *  <p>Alternatively, the user can be redirected to the specified Game URL. For this option to work, you must first create a game for your bot via <a href="https://t.me/botfather">@BotFather</a> and accept the terms. Otherwise, you may use links like <code>t.me/your_bot?start=XXXX</code> that open your bot with a parameter.</p>
     * </blockquote>
     *
     * @property callbackQueryId Unique identifier for the query to be answered
     * @property text Text of the notification. If not specified, nothing will be shown to the user, 0-200 characters
     * @property showAlert If <em>True</em>, an alert will be shown by the client instead of a notification at the top of the chat screen. Defaults to <em>false</em>.
     * @property url URL that will be opened by the user's client. If you have created a <a href="#game">Game</a> and accepted the conditions via <a href="https://t.me/botfather">@BotFather</a>, specify the URL that opens your game - note that this will only work if the query comes from a <a href="#inlinekeyboardbutton"><em>callback_game</em></a> button.<br><br>Otherwise, you may use links like <code>t.me/your_bot?start=XXXX</code> that open your bot with a parameter.
     * @property cacheTime The maximum amount of time in seconds that the result of the callback query may be cached client-side. Telegram apps will support caching starting in version 3.14. Defaults to 0.
     * */
    data class AnswerCallbackQueryRequest(
        val callbackQueryId: String,
        val text: String? = null,
        val showAlert: Boolean? = null,
        val url: String? = null,
        val cacheTime: Long? = null,
    ) : TelegramRequest()

    /**
     * <p>Use this method to get the list of boosts added to a chat by a user. Requires administrator rights in the chat. Returns a <a href="#userchatboosts">UserChatBoosts</a> object.</p>
     *
     * @property chatId Unique identifier for the chat or username of the channel (in the format <code>@channelusername</code>)
     * @property userId Unique identifier of the target user
     * */
    data class GetUserChatBoostsRequest(
        val chatId: String,
        val userId: Long,
    ) : TelegramRequest()

    /**
     * <p>Use this method to get information about the connection of the bot with a business account. Returns a <a href="#businessconnection">BusinessConnection</a> object on success.</p>
     *
     * @property businessConnectionId Unique identifier of the business connection
     * */
    data class GetBusinessConnectionRequest(
        val businessConnectionId: String,
    ) : TelegramRequest()

    /**
     * <p>Use this method to change the list of the bot's commands. See <a href="/bots/features#commands">this manual</a> for more details about bot commands. Returns <em>True</em> on success.</p>
     *
     * @property commands A JSON-serialized list of bot commands to be set as the list of the bot's commands. At most 100 commands can be specified.
     * @property scope A JSON-serialized object, describing scope of users for which the commands are relevant. Defaults to <a href="#botcommandscopedefault">BotCommandScopeDefault</a>.
     * @property languageCode A two-letter ISO 639-1 language code. If empty, commands will be applied to all users from the given scope, for whose language there are no dedicated commands
     * */
    data class SetMyCommandsRequest(
        val commands: List<BotCommand>,
        val scope: BotCommandScope? = null,
        val languageCode: String? = null,
    ) : TelegramRequest()

    /**
     * <p>Use this method to delete the list of the bot's commands for the given scope and user language. After deletion, <a href="#determining-list-of-commands">higher level commands</a> will be shown to affected users. Returns <em>True</em> on success.</p>
     *
     * @property scope A JSON-serialized object, describing scope of users for which the commands are relevant. Defaults to <a href="#botcommandscopedefault">BotCommandScopeDefault</a>.
     * @property languageCode A two-letter ISO 639-1 language code. If empty, commands will be applied to all users from the given scope, for whose language there are no dedicated commands
     * */
    data class DeleteMyCommandsRequest(
        val scope: BotCommandScope? = null,
        val languageCode: String? = null,
    ) : TelegramRequest()

    /**
     * <p>Use this method to get the current list of the bot's commands for the given scope and user language. Returns an Array of <a href="#botcommand">BotCommand</a> objects. If commands aren't set, an empty list is returned.</p>
     *
     * @property scope A JSON-serialized object, describing scope of users. Defaults to <a href="#botcommandscopedefault">BotCommandScopeDefault</a>.
     * @property languageCode A two-letter ISO 639-1 language code or an empty string
     * */
    data class GetMyCommandsRequest(
        val scope: BotCommandScope? = null,
        val languageCode: String? = null,
    ) : TelegramRequest()

    /**
     * <p>Use this method to change the bot's name. Returns <em>True</em> on success.</p>
     *
     * @property name New bot name; 0-64 characters. Pass an empty string to remove the dedicated name for the given language.
     * @property languageCode A two-letter ISO 639-1 language code. If empty, the name will be shown to all users for whose language there is no dedicated name.
     * */
    data class SetMyNameRequest(
        val name: String? = null,
        val languageCode: String? = null,
    ) : TelegramRequest()

    /**
     * <p>Use this method to get the current bot name for the given user language. Returns <a href="#botname">BotName</a> on success.</p>
     *
     * @property languageCode A two-letter ISO 639-1 language code or an empty string
     * */
    data class GetMyNameRequest(
        val languageCode: String? = null,
    ) : TelegramRequest()

    /**
     * <p>Use this method to change the bot's description, which is shown in the chat with the bot if the chat is empty. Returns <em>True</em> on success.</p>
     *
     * @property description New bot description; 0-512 characters. Pass an empty string to remove the dedicated description for the given language.
     * @property languageCode A two-letter ISO 639-1 language code. If empty, the description will be applied to all users for whose language there is no dedicated description.
     * */
    data class SetMyDescriptionRequest(
        val description: String? = null,
        val languageCode: String? = null,
    ) : TelegramRequest()

    /**
     * <p>Use this method to get the current bot description for the given user language. Returns <a href="#botdescription">BotDescription</a> on success.</p>
     *
     * @property languageCode A two-letter ISO 639-1 language code or an empty string
     * */
    data class GetMyDescriptionRequest(
        val languageCode: String? = null,
    ) : TelegramRequest()

    /**
     * <p>Use this method to change the bot's short description, which is shown on the bot's profile page and is sent together with the link when users share the bot. Returns <em>True</em> on success.</p>
     *
     * @property shortDescription New short description for the bot; 0-120 characters. Pass an empty string to remove the dedicated short description for the given language.
     * @property languageCode A two-letter ISO 639-1 language code. If empty, the short description will be applied to all users for whose language there is no dedicated short description.
     * */
    data class SetMyShortDescriptionRequest(
        val shortDescription: String? = null,
        val languageCode: String? = null,
    ) : TelegramRequest()

    /**
     * <p>Use this method to get the current bot short description for the given user language. Returns <a href="#botshortdescription">BotShortDescription</a> on success.</p>
     *
     * @property languageCode A two-letter ISO 639-1 language code or an empty string
     * */
    data class GetMyShortDescriptionRequest(
        val languageCode: String? = null,
    ) : TelegramRequest()

    /**
     * <p>Use this method to change the bot's menu button in a private chat, or the default menu button. Returns <em>True</em> on success.</p>
     *
     * @property chatId Unique identifier for the target private chat. If not specified, default bot's menu button will be changed
     * @property menuButton A JSON-serialized object for the bot's new menu button. Defaults to <a href="#menubuttondefault">MenuButtonDefault</a>
     * */
    data class SetChatMenuButtonRequest(
        val chatId: Long? = null,
        val menuButton: MenuButton? = null,
    ) : TelegramRequest()

    /**
     * <p>Use this method to get the current value of the bot's menu button in a private chat, or the default menu button. Returns <a href="#menubutton">MenuButton</a> on success.</p>
     *
     * @property chatId Unique identifier for the target private chat. If not specified, default bot's menu button will be returned
     * */
    data class GetChatMenuButtonRequest(
        val chatId: Long? = null,
    ) : TelegramRequest()

    /**
     * <p>Use this method to change the default administrator rights requested by the bot when it's added as an administrator to groups or channels. These rights will be suggested to users, but they are free to modify the list before adding the bot. Returns <em>True</em> on success.</p>
     *
     * @property rights A JSON-serialized object describing new default administrator rights. If not specified, the default administrator rights will be cleared.
     * @property forChannels Pass <em>True</em> to change the default administrator rights of the bot in channels. Otherwise, the default administrator rights of the bot for groups and supergroups will be changed.
     * */
    data class SetMyDefaultAdministratorRightsRequest(
        val rights: ChatAdministratorRights? = null,
        val forChannels: Boolean? = null,
    ) : TelegramRequest()

    /**
     * <p>Use this method to get the current default administrator rights of the bot. Returns <a href="#chatadministratorrights">ChatAdministratorRights</a> on success.</p>
     *
     * @property forChannels Pass <em>True</em> to get default administrator rights of the bot in channels. Otherwise, default administrator rights of the bot for groups and supergroups will be returned.
     * */
    data class GetMyDefaultAdministratorRightsRequest(
        val forChannels: Boolean? = null,
    ) : TelegramRequest()

    // Updating messages

    /**
     * <p>Use this method to edit text and <a href="#games">game</a> messages. On success, if the edited message is not an inline message, the edited <a href="#message">Message</a> is returned, otherwise <em>True</em> is returned. Note that business messages that were not sent by the bot and do not contain an inline keyboard can only be edited within <strong>48 hours</strong> from the time they were sent.</p>
     *
     * @property text New text of the message, 1-4096 characters after entities parsing
     * @property businessConnectionId Unique identifier of the business connection on behalf of which the message to be edited was sent
     * @property chatId Required if <em>inline_message_id</em> is not specified. Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>)
     * @property messageId Required if <em>inline_message_id</em> is not specified. Identifier of the message to edit
     * @property inlineMessageId Required if <em>chat_id</em> and <em>message_id</em> are not specified. Identifier of the inline message
     * @property parseMode Mode for parsing entities in the message text. See <a href="#formatting-options">formatting options</a> for more details.
     * @property entities A JSON-serialized list of special entities that appear in message text, which can be specified instead of <em>parse_mode</em>
     * @property linkPreviewOptions Link preview generation options for the message
     * @property replyMarkup A JSON-serialized object for an <a href="/bots/features#inline-keyboards">inline keyboard</a>.
     * */
    data class EditMessageTextRequest(
        val text: String,
        val businessConnectionId: String? = null,
        val chatId: String? = null,
        val messageId: Long? = null,
        val inlineMessageId: String? = null,
        val parseMode: ParseMode? = null,
        val entities: List<MessageEntity>? = null,
        val linkPreviewOptions: LinkPreviewOptions? = null,
        val replyMarkup: InlineKeyboardMarkup? = null,
    ) : TelegramRequest()

    /**
     * <p>Use this method to edit captions of messages. On success, if the edited message is not an inline message, the edited <a href="#message">Message</a> is returned, otherwise <em>True</em> is returned. Note that business messages that were not sent by the bot and do not contain an inline keyboard can only be edited within <strong>48 hours</strong> from the time they were sent.</p>
     *
     * @property businessConnectionId Unique identifier of the business connection on behalf of which the message to be edited was sent
     * @property chatId Required if <em>inline_message_id</em> is not specified. Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>)
     * @property messageId Required if <em>inline_message_id</em> is not specified. Identifier of the message to edit
     * @property inlineMessageId Required if <em>chat_id</em> and <em>message_id</em> are not specified. Identifier of the inline message
     * @property caption New caption of the message, 0-1024 characters after entities parsing
     * @property parseMode Mode for parsing entities in the message caption. See <a href="#formatting-options">formatting options</a> for more details.
     * @property captionEntities A JSON-serialized list of special entities that appear in the caption, which can be specified instead of <em>parse_mode</em>
     * @property showCaptionAboveMedia Pass <em>True</em>, if the caption must be shown above the message media. Supported only for animation, photo and video messages.
     * @property replyMarkup A JSON-serialized object for an <a href="/bots/features#inline-keyboards">inline keyboard</a>.
     * */
    data class EditMessageCaptionRequest(
        val businessConnectionId: String? = null,
        val chatId: String? = null,
        val messageId: Long? = null,
        val inlineMessageId: String? = null,
        val caption: String? = null,
        val parseMode: ParseMode? = null,
        val captionEntities: List<MessageEntity>? = null,
        val showCaptionAboveMedia: Boolean? = null,
        val replyMarkup: InlineKeyboardMarkup? = null,
    ) : TelegramRequest()

    /**
     * <p>Use this method to edit animation, audio, document, photo, or video messages, or to add media to text messages. If a message is part of a message album, then it can be edited only to an audio for audio albums, only to a document for document albums and to a photo or a video otherwise. When an inline message is edited, a new file can't be uploaded; use a previously uploaded file via its file_id or specify a URL. On success, if the edited message is not an inline message, the edited <a href="#message">Message</a> is returned, otherwise <em>True</em> is returned. Note that business messages that were not sent by the bot and do not contain an inline keyboard can only be edited within <strong>48 hours</strong> from the time they were sent.</p>
     *
     * @property media A JSON-serialized object for a new media content of the message
     * @property businessConnectionId Unique identifier of the business connection on behalf of which the message to be edited was sent
     * @property chatId Required if <em>inline_message_id</em> is not specified. Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>)
     * @property messageId Required if <em>inline_message_id</em> is not specified. Identifier of the message to edit
     * @property inlineMessageId Required if <em>chat_id</em> and <em>message_id</em> are not specified. Identifier of the inline message
     * @property replyMarkup A JSON-serialized object for a new <a href="/bots/features#inline-keyboards">inline keyboard</a>.
     * */
    data class EditMessageMediaRequest(
        val media: InputMedia,
        val businessConnectionId: String? = null,
        val chatId: String? = null,
        val messageId: Long? = null,
        val inlineMessageId: String? = null,
        val replyMarkup: InlineKeyboardMarkup? = null,
    ) : TelegramRequest()

    /**
     * <p>Use this method to edit live location messages. A location can be edited until its <em>live_period</em> expires or editing is explicitly disabled by a call to <a href="#stopmessagelivelocation">stopMessageLiveLocation</a>. On success, if the edited message is not an inline message, the edited <a href="#message">Message</a> is returned, otherwise <em>True</em> is returned.</p>
     *
     * @property latitude Latitude of new location
     * @property longitude Longitude of new location
     * @property businessConnectionId Unique identifier of the business connection on behalf of which the message to be edited was sent
     * @property chatId Required if <em>inline_message_id</em> is not specified. Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>)
     * @property messageId Required if <em>inline_message_id</em> is not specified. Identifier of the message to edit
     * @property inlineMessageId Required if <em>chat_id</em> and <em>message_id</em> are not specified. Identifier of the inline message
     * @property livePeriod New period in seconds during which the location can be updated, starting from the message send date. If 0x7FFFFFFF is specified, then the location can be updated forever. Otherwise, the new value must not exceed the current <em>live_period</em> by more than a day, and the live location expiration date must remain within the next 90 days. If not specified, then <em>live_period</em> remains unchanged
     * @property horizontalAccuracy The radius of uncertainty for the location, measured in meters; 0-1500
     * @property heading Direction in which the user is moving, in degrees. Must be between 1 and 360 if specified.
     * @property proximityAlertRadius The maximum distance for proximity alerts about approaching another chat member, in meters. Must be between 1 and 100000 if specified.
     * @property replyMarkup A JSON-serialized object for a new <a href="/bots/features#inline-keyboards">inline keyboard</a>.
     * */
    data class EditMessageLiveLocationRequest(
        val latitude: Float,
        val longitude: Float,
        val businessConnectionId: String? = null,
        val chatId: String? = null,
        val messageId: Long? = null,
        val inlineMessageId: String? = null,
        val livePeriod: Long? = null,
        val horizontalAccuracy: Float? = null,
        val heading: Long? = null,
        val proximityAlertRadius: Long? = null,
        val replyMarkup: InlineKeyboardMarkup? = null,
    ) : TelegramRequest()

    /**
     * <p>Use this method to stop updating a live location message before <em>live_period</em> expires. On success, if the message is not an inline message, the edited <a href="#message">Message</a> is returned, otherwise <em>True</em> is returned.</p>
     *
     * @property businessConnectionId Unique identifier of the business connection on behalf of which the message to be edited was sent
     * @property chatId Required if <em>inline_message_id</em> is not specified. Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>)
     * @property messageId Required if <em>inline_message_id</em> is not specified. Identifier of the message with live location to stop
     * @property inlineMessageId Required if <em>chat_id</em> and <em>message_id</em> are not specified. Identifier of the inline message
     * @property replyMarkup A JSON-serialized object for a new <a href="/bots/features#inline-keyboards">inline keyboard</a>.
     * */
    data class StopMessageLiveLocationRequest(
        val businessConnectionId: String? = null,
        val chatId: String? = null,
        val messageId: Long? = null,
        val inlineMessageId: String? = null,
        val replyMarkup: InlineKeyboardMarkup? = null,
    ) : TelegramRequest()

    /**
     * <p>Use this method to edit a checklist on behalf of a connected business account. On success, the edited <a href="#message">Message</a> is returned.</p>
     *
     * @property businessConnectionId Unique identifier of the business connection on behalf of which the message will be sent
     * @property chatId Unique identifier for the target chat
     * @property messageId Unique identifier for the target message
     * @property checklist A JSON-serialized object for the new checklist
     * @property replyMarkup A JSON-serialized object for the new inline keyboard for the message
     * */
    data class EditMessageChecklistRequest(
        val businessConnectionId: String,
        val chatId: Long,
        val messageId: Long,
        val checklist: InputChecklist,
        val replyMarkup: InlineKeyboardMarkup? = null,
    ) : TelegramRequest()

    /**
     * <p>Use this method to edit only the reply markup of messages. On success, if the edited message is not an inline message, the edited <a href="#message">Message</a> is returned, otherwise <em>True</em> is returned. Note that business messages that were not sent by the bot and do not contain an inline keyboard can only be edited within <strong>48 hours</strong> from the time they were sent.</p>
     *
     * @property businessConnectionId Unique identifier of the business connection on behalf of which the message to be edited was sent
     * @property chatId Required if <em>inline_message_id</em> is not specified. Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>)
     * @property messageId Required if <em>inline_message_id</em> is not specified. Identifier of the message to edit
     * @property inlineMessageId Required if <em>chat_id</em> and <em>message_id</em> are not specified. Identifier of the inline message
     * @property replyMarkup A JSON-serialized object for an <a href="/bots/features#inline-keyboards">inline keyboard</a>.
     * */
    data class EditMessageReplyMarkupRequest(
        val businessConnectionId: String? = null,
        val chatId: String? = null,
        val messageId: Long? = null,
        val inlineMessageId: String? = null,
        val replyMarkup: InlineKeyboardMarkup? = null,
    ) : TelegramRequest()

    /**
     * <p>Use this method to stop a poll which was sent by the bot. On success, the stopped <a href="#poll">Poll</a> is returned.</p>
     *
     * @property chatId Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>)
     * @property messageId Identifier of the original message with the poll
     * @property businessConnectionId Unique identifier of the business connection on behalf of which the message to be edited was sent
     * @property replyMarkup A JSON-serialized object for a new message <a href="/bots/features#inline-keyboards">inline keyboard</a>.
     * */
    data class StopPollRequest(
        val chatId: String,
        val messageId: Long,
        val businessConnectionId: String? = null,
        val replyMarkup: InlineKeyboardMarkup? = null,
    ) : TelegramRequest()

    /**
     * <p>Use this method to delete a message, including service messages, with the following limitations:<br>- A message can only be deleted if it was sent less than 48 hours ago.<br>- Service messages about a supergroup, channel, or forum topic creation can't be deleted.<br>- A dice message in a private chat can only be deleted if it was sent more than 24 hours ago.<br>- Bots can delete outgoing messages in private chats, groups, and supergroups.<br>- Bots can delete incoming messages in private chats.<br>- Bots granted <em>can_post_messages</em> permissions can delete outgoing messages in channels.<br>- If the bot is an administrator of a group, it can delete any message there.<br>- If the bot has <em>can_delete_messages</em> permission in a supergroup or a channel, it can delete any message there.<br>Returns <em>True</em> on success.</p>
     *
     * @property chatId Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>)
     * @property messageId Identifier of the message to delete
     * */
    data class DeleteMessageRequest(
        val chatId: String,
        val messageId: Long,
    ) : TelegramRequest()

    /**
     * <p>Use this method to delete multiple messages simultaneously. If some of the specified messages can't be found, they are skipped. Returns <em>True</em> on success.</p>
     *
     * @property chatId Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>)
     * @property messageIds A JSON-serialized list of 1-100 identifiers of messages to delete. See <a href="#deletemessage">deleteMessage</a> for limitations on which messages can be deleted
     * */
    data class DeleteMessagesRequest(
        val chatId: String,
        val messageIds: List<Long>,
    ) : TelegramRequest()

    /**
     * <p>Sends a gift to the given user or channel chat. The gift can't be converted to Telegram Stars by the receiver. Returns <em>True</em> on success.</p>
     *
     * @property giftId Identifier of the gift
     * @property userId Required if <em>chat_id</em> is not specified. Unique identifier of the target user who will receive the gift.
     * @property chatId Required if <em>user_id</em> is not specified. Unique identifier for the chat or username of the channel (in the format <code>@channelusername</code>) that will receive the gift.
     * @property payForUpgrade Pass <em>True</em> to pay for the gift upgrade from the bot's balance, thereby making the upgrade free for the receiver
     * @property text Text that will be shown along with the gift; 0-128 characters
     * @property textParseMode Mode for parsing entities in the text. See <a href="#formatting-options">formatting options</a> for more details. Entities other than “bold”, “italic”, “underline”, “strikethrough”, “spoiler”, and “custom_emoji” are ignored.
     * @property textEntities A JSON-serialized list of special entities that appear in the gift text. It can be specified instead of <em>text_parse_mode</em>. Entities other than “bold”, “italic”, “underline”, “strikethrough”, “spoiler”, and “custom_emoji” are ignored.
     * */
    data class SendGiftRequest(
        val giftId: String,
        val userId: Long? = null,
        val chatId: String? = null,
        val payForUpgrade: Boolean? = null,
        val text: String? = null,
        val textParseMode: String? = null,
        val textEntities: List<MessageEntity>? = null,
    ) : TelegramRequest()

    /**
     * <p>Gifts a Telegram Premium subscription to the given user. Returns <em>True</em> on success.</p>
     *
     * @property userId Unique identifier of the target user who will receive a Telegram Premium subscription
     * @property monthCount Number of months the Telegram Premium subscription will be active for the user; must be one of 3, 6, or 12
     * @property starCount Number of Telegram Stars to pay for the Telegram Premium subscription; must be 1000 for 3 months, 1500 for 6 months, and 2500 for 12 months
     * @property text Text that will be shown along with the service message about the subscription; 0-128 characters
     * @property textParseMode Mode for parsing entities in the text. See <a href="#formatting-options">formatting options</a> for more details. Entities other than “bold”, “italic”, “underline”, “strikethrough”, “spoiler”, and “custom_emoji” are ignored.
     * @property textEntities A JSON-serialized list of special entities that appear in the gift text. It can be specified instead of <em>text_parse_mode</em>. Entities other than “bold”, “italic”, “underline”, “strikethrough”, “spoiler”, and “custom_emoji” are ignored.
     * */
    data class GiftPremiumSubscriptionRequest(
        val userId: Long,
        val monthCount: Long,
        val starCount: Long,
        val text: String? = null,
        val textParseMode: String? = null,
        val textEntities: List<MessageEntity>? = null,
    ) : TelegramRequest()

    /**
     * <p>Verifies a user <a href="https://telegram.org/verify#third-party-verification">on behalf of the organization</a> which is represented by the bot. Returns <em>True</em> on success.</p>
     *
     * @property userId Unique identifier of the target user
     * @property customDescription Custom description for the verification; 0-70 characters. Must be empty if the organization isn't allowed to provide a custom verification description.
     * */
    data class VerifyUserRequest(
        val userId: Long,
        val customDescription: String? = null,
    ) : TelegramRequest()

    /**
     * <p>Verifies a chat <a href="https://telegram.org/verify#third-party-verification">on behalf of the organization</a> which is represented by the bot. Returns <em>True</em> on success.</p>
     *
     * @property chatId Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>)
     * @property customDescription Custom description for the verification; 0-70 characters. Must be empty if the organization isn't allowed to provide a custom verification description.
     * */
    data class VerifyChatRequest(
        val chatId: String,
        val customDescription: String? = null,
    ) : TelegramRequest()

    /**
     * <p>Removes verification from a user who is currently verified <a href="https://telegram.org/verify#third-party-verification">on behalf of the organization</a> represented by the bot. Returns <em>True</em> on success.</p>
     *
     * @property userId Unique identifier of the target user
     * */
    data class RemoveUserVerificationRequest(
        val userId: Long,
    ) : TelegramRequest()

    /**
     * <p>Removes verification from a chat that is currently verified <a href="https://telegram.org/verify#third-party-verification">on behalf of the organization</a> represented by the bot. Returns <em>True</em> on success.</p>
     *
     * @property chatId Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>)
     * */
    data class RemoveChatVerificationRequest(
        val chatId: String,
    ) : TelegramRequest()

    /**
     * <p>Marks incoming message as read on behalf of a business account. Requires the <em>can_read_messages</em> business bot right. Returns <em>True</em> on success.</p>
     *
     * @property businessConnectionId Unique identifier of the business connection on behalf of which to read the message
     * @property chatId Unique identifier of the chat in which the message was received. The chat must have been active in the last 24 hours.
     * @property messageId Unique identifier of the message to mark as read
     * */
    data class ReadBusinessMessageRequest(
        val businessConnectionId: String,
        val chatId: Long,
        val messageId: Long,
    ) : TelegramRequest()

    /**
     * <p>Delete messages on behalf of a business account. Requires the <em>can_delete_sent_messages</em> business bot right to delete messages sent by the bot itself, or the <em>can_delete_all_messages</em> business bot right to delete any message. Returns <em>True</em> on success.</p>
     *
     * @property businessConnectionId Unique identifier of the business connection on behalf of which to delete the messages
     * @property messageIds A JSON-serialized list of 1-100 identifiers of messages to delete. All messages must be from the same chat. See <a href="#deletemessage">deleteMessage</a> for limitations on which messages can be deleted
     * */
    data class DeleteBusinessMessagesRequest(
        val businessConnectionId: String,
        val messageIds: List<Long>,
    ) : TelegramRequest()

    /**
     * <p>Changes the first and last name of a managed business account. Requires the <em>can_change_name</em> business bot right. Returns <em>True</em> on success.</p>
     *
     * @property businessConnectionId Unique identifier of the business connection
     * @property firstName The new value of the first name for the business account; 1-64 characters
     * @property lastName The new value of the last name for the business account; 0-64 characters
     * */
    data class SetBusinessAccountNameRequest(
        val businessConnectionId: String,
        val firstName: String,
        val lastName: String? = null,
    ) : TelegramRequest()

    /**
     * <p>Changes the username of a managed business account. Requires the <em>can_change_username</em> business bot right. Returns <em>True</em> on success.</p>
     *
     * @property businessConnectionId Unique identifier of the business connection
     * @property username The new value of the username for the business account; 0-32 characters
     * */
    data class SetBusinessAccountUsernameRequest(
        val businessConnectionId: String,
        val username: String? = null,
    ) : TelegramRequest()

    /**
     * <p>Changes the bio of a managed business account. Requires the <em>can_change_bio</em> business bot right. Returns <em>True</em> on success.</p>
     *
     * @property businessConnectionId Unique identifier of the business connection
     * @property bio The new value of the bio for the business account; 0-140 characters
     * */
    data class SetBusinessAccountBioRequest(
        val businessConnectionId: String,
        val bio: String? = null,
    ) : TelegramRequest()

    /**
     * <p>Changes the profile photo of a managed business account. Requires the <em>can_edit_profile_photo</em> business bot right. Returns <em>True</em> on success.</p>
     *
     * @property businessConnectionId Unique identifier of the business connection
     * @property photo The new profile photo to set
     * @property isPublic Pass <em>True</em> to set the public photo, which will be visible even if the main photo is hidden by the business account's privacy settings. An account can have only one public photo.
     * */
    data class SetBusinessAccountProfilePhotoRequest(
        val businessConnectionId: String,
        val photo: InputProfilePhoto,
        val isPublic: Boolean? = null,
    ) : TelegramRequest()

    /**
     * <p>Removes the current profile photo of a managed business account. Requires the <em>can_edit_profile_photo</em> business bot right. Returns <em>True</em> on success.</p>
     *
     * @property businessConnectionId Unique identifier of the business connection
     * @property isPublic Pass <em>True</em> to remove the public photo, which is visible even if the main photo is hidden by the business account's privacy settings. After the main photo is removed, the previous profile photo (if present) becomes the main photo.
     * */
    data class RemoveBusinessAccountProfilePhotoRequest(
        val businessConnectionId: String,
        val isPublic: Boolean? = null,
    ) : TelegramRequest()

    /**
     * <p>Changes the privacy settings pertaining to incoming gifts in a managed business account. Requires the <em>can_change_gift_settings</em> business bot right. Returns <em>True</em> on success.</p>
     *
     * @property businessConnectionId Unique identifier of the business connection
     * @property showGiftButton Pass <em>True</em>, if a button for sending a gift to the user or by the business account must always be shown in the input field
     * @property acceptedGiftTypes Types of gifts accepted by the business account
     * */
    data class SetBusinessAccountGiftSettingsRequest(
        val businessConnectionId: String,
        val showGiftButton: Boolean,
        val acceptedGiftTypes: AcceptedGiftTypes,
    ) : TelegramRequest()

    /**
     * <p>Returns the amount of Telegram Stars owned by a managed business account. Requires the <em>can_view_gifts_and_stars</em> business bot right. Returns <a href="#staramount">StarAmount</a> on success.</p>
     *
     * @property businessConnectionId Unique identifier of the business connection
     * */
    data class GetBusinessAccountStarBalanceRequest(
        val businessConnectionId: String,
    ) : TelegramRequest()

    /**
     * <p>Transfers Telegram Stars from the business account balance to the bot's balance. Requires the <em>can_transfer_stars</em> business bot right. Returns <em>True</em> on success.</p>
     *
     * @property businessConnectionId Unique identifier of the business connection
     * @property starCount Number of Telegram Stars to transfer; 1-10000
     * */
    data class TransferBusinessAccountStarsRequest(
        val businessConnectionId: String,
        val starCount: Long,
    ) : TelegramRequest()

    /**
     * <p>Returns the gifts received and owned by a managed business account. Requires the <em>can_view_gifts_and_stars</em> business bot right. Returns <a href="#ownedgifts">OwnedGifts</a> on success.</p>
     *
     * @property businessConnectionId Unique identifier of the business connection
     * @property excludeUnsaved Pass <em>True</em> to exclude gifts that aren't saved to the account's profile page
     * @property excludeSaved Pass <em>True</em> to exclude gifts that are saved to the account's profile page
     * @property excludeUnlimited Pass <em>True</em> to exclude gifts that can be purchased an unlimited number of times
     * @property excludeLimited Pass <em>True</em> to exclude gifts that can be purchased a limited number of times
     * @property excludeUnique Pass <em>True</em> to exclude unique gifts
     * @property sortByPrice Pass <em>True</em> to sort results by gift price instead of send date. Sorting is applied before pagination.
     * @property offset Offset of the first entry to return as received from the previous request; use empty string to get the first chunk of results
     * @property limit The maximum number of gifts to be returned; 1-100. Defaults to 100
     * */
    data class GetBusinessAccountGiftsRequest(
        val businessConnectionId: String,
        val excludeUnsaved: Boolean? = null,
        val excludeSaved: Boolean? = null,
        val excludeUnlimited: Boolean? = null,
        val excludeLimited: Boolean? = null,
        val excludeUnique: Boolean? = null,
        val sortByPrice: Boolean? = null,
        val offset: String? = null,
        val limit: Long? = null,
    ) : TelegramRequest()

    /**
     * <p>Converts a given regular gift to Telegram Stars. Requires the <em>can_convert_gifts_to_stars</em> business bot right. Returns <em>True</em> on success.</p>
     *
     * @property businessConnectionId Unique identifier of the business connection
     * @property ownedGiftId Unique identifier of the regular gift that should be converted to Telegram Stars
     * */
    data class ConvertGiftToStarsRequest(
        val businessConnectionId: String,
        val ownedGiftId: String,
    ) : TelegramRequest()

    /**
     * <p>Upgrades a given regular gift to a unique gift. Requires the <em>can_transfer_and_upgrade_gifts</em> business bot right. Additionally requires the <em>can_transfer_stars</em> business bot right if the upgrade is paid. Returns <em>True</em> on success.</p>
     *
     * @property businessConnectionId Unique identifier of the business connection
     * @property ownedGiftId Unique identifier of the regular gift that should be upgraded to a unique one
     * @property keepOriginalDetails Pass <em>True</em> to keep the original gift text, sender and receiver in the upgraded gift
     * @property starCount The amount of Telegram Stars that will be paid for the upgrade from the business account balance. If <code>gift.prepaid_upgrade_star_count &gt; 0</code>, then pass 0, otherwise, the <em>can_transfer_stars</em> business bot right is required and <code>gift.upgrade_star_count</code> must be passed.
     * */
    data class UpgradeGiftRequest(
        val businessConnectionId: String,
        val ownedGiftId: String,
        val keepOriginalDetails: Boolean? = null,
        val starCount: Long? = null,
    ) : TelegramRequest()

    /**
     * <p>Transfers an owned unique gift to another user. Requires the <em>can_transfer_and_upgrade_gifts</em> business bot right. Requires <em>can_transfer_stars</em> business bot right if the transfer is paid. Returns <em>True</em> on success.</p>
     *
     * @property businessConnectionId Unique identifier of the business connection
     * @property ownedGiftId Unique identifier of the regular gift that should be transferred
     * @property newOwnerChatId Unique identifier of the chat which will own the gift. The chat must be active in the last 24 hours.
     * @property starCount The amount of Telegram Stars that will be paid for the transfer from the business account balance. If positive, then the <em>can_transfer_stars</em> business bot right is required.
     * */
    data class TransferGiftRequest(
        val businessConnectionId: String,
        val ownedGiftId: String,
        val newOwnerChatId: Long,
        val starCount: Long? = null,
    ) : TelegramRequest()

    /**
     * <p>Posts a story on behalf of a managed business account. Requires the <em>can_manage_stories</em> business bot right. Returns <a href="#story">Story</a> on success.</p>
     *
     * @property businessConnectionId Unique identifier of the business connection
     * @property content Content of the story
     * @property activePeriod Period after which the story is moved to the archive, in seconds; must be one of <code>6 * 3600</code>, <code>12 * 3600</code>, <code>86400</code>, or <code>2 * 86400</code>
     * @property caption Caption of the story, 0-2048 characters after entities parsing
     * @property parseMode Mode for parsing entities in the story caption. See <a href="#formatting-options">formatting options</a> for more details.
     * @property captionEntities A JSON-serialized list of special entities that appear in the caption, which can be specified instead of <em>parse_mode</em>
     * @property areas A JSON-serialized list of clickable areas to be shown on the story
     * @property postToChatPage Pass <em>True</em> to keep the story accessible after it expires
     * @property protectContent Pass <em>True</em> if the content of the story must be protected from forwarding and screenshotting
     * */
    data class PostStoryRequest(
        val businessConnectionId: String,
        val content: InputStoryContent,
        val activePeriod: Long,
        val caption: String? = null,
        val parseMode: ParseMode? = null,
        val captionEntities: List<MessageEntity>? = null,
        val areas: List<StoryArea>? = null,
        val postToChatPage: Boolean? = null,
        val protectContent: Boolean? = null,
    ) : TelegramRequest()

    /**
     * <p>Edits a story previously posted by the bot on behalf of a managed business account. Requires the <em>can_manage_stories</em> business bot right. Returns <a href="#story">Story</a> on success.</p>
     *
     * @property businessConnectionId Unique identifier of the business connection
     * @property storyId Unique identifier of the story to edit
     * @property content Content of the story
     * @property caption Caption of the story, 0-2048 characters after entities parsing
     * @property parseMode Mode for parsing entities in the story caption. See <a href="#formatting-options">formatting options</a> for more details.
     * @property captionEntities A JSON-serialized list of special entities that appear in the caption, which can be specified instead of <em>parse_mode</em>
     * @property areas A JSON-serialized list of clickable areas to be shown on the story
     * */
    data class EditStoryRequest(
        val businessConnectionId: String,
        val storyId: Long,
        val content: InputStoryContent,
        val caption: String? = null,
        val parseMode: ParseMode? = null,
        val captionEntities: List<MessageEntity>? = null,
        val areas: List<StoryArea>? = null,
    ) : TelegramRequest()

    /**
     * <p>Deletes a story previously posted by the bot on behalf of a managed business account. Requires the <em>can_manage_stories</em> business bot right. Returns <em>True</em> on success.</p>
     *
     * @property businessConnectionId Unique identifier of the business connection
     * @property storyId Unique identifier of the story to delete
     * */
    data class DeleteStoryRequest(
        val businessConnectionId: String,
        val storyId: Long,
    ) : TelegramRequest()

    // Stickers

    /**
     * <p>Use this method to send static .WEBP, <a href="https://telegram.org/blog/animated-stickers">animated</a> .TGS, or <a href="https://telegram.org/blog/video-stickers-better-reactions">video</a> .WEBM stickers. On success, the sent <a href="#message">Message</a> is returned.</p>
     *
     * @property chatId Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>)
     * @property sticker Sticker to send. Pass a file_id as String to send a file that exists on the Telegram servers (recommended), pass an HTTP URL as a String for Telegram to get a .WEBP sticker from the Internet, or upload a new .WEBP, .TGS, or .WEBM sticker using multipart/form-data. <a href="#sending-files">More information on Sending Files »</a>. Video and animated stickers can't be sent via an HTTP URL.
     * @property businessConnectionId Unique identifier of the business connection on behalf of which the message will be sent
     * @property messageThreadId Unique identifier for the target message thread (topic) of the forum; for forum supergroups only
     * @property emoji Emoji associated with the sticker; only for just uploaded stickers
     * @property disableNotification Sends the message <a href="https://telegram.org/blog/channels-2-0#silent-messages">silently</a>. Users will receive a notification with no sound.
     * @property protectContent Protects the contents of the sent message from forwarding and saving
     * @property allowPaidBroadcast Pass <em>True</em> to allow up to 1000 messages per second, ignoring <a href="https://core.telegram.org/bots/faq#how-can-i-message-all-of-my-bot-39s-subscribers-at-once">broadcasting limits</a> for a fee of 0.1 Telegram Stars per message. The relevant Stars will be withdrawn from the bot's balance
     * @property messageEffectId Unique identifier of the message effect to be added to the message; for private chats only
     * @property replyParameters Description of the message to reply to
     * @property replyMarkup Additional interface options. A JSON-serialized object for an <a href="/bots/features#inline-keyboards">inline keyboard</a>, <a href="/bots/features#keyboards">custom reply keyboard</a>, instructions to remove a reply keyboard or to force a reply from the user
     * */
    data class SendStickerRequest(
        val chatId: String,
        val sticker: String,
        val businessConnectionId: String? = null,
        val messageThreadId: Long? = null,
        val emoji: String? = null,
        val disableNotification: Boolean? = null,
        val protectContent: Boolean? = null,
        val allowPaidBroadcast: Boolean? = null,
        val messageEffectId: String? = null,
        val replyParameters: ReplyParameters? = null,
        val replyMarkup: KeyboardOption? = null,
    ) : TelegramRequest()

    /**
     * <p>Use this method to get a sticker set. On success, a <a href="#stickerset">StickerSet</a> object is returned.</p>
     *
     * @property name Name of the sticker set
     * */
    data class GetStickerSetRequest(
        val name: String,
    ) : TelegramRequest()

    /**
     * <p>Use this method to get information about custom emoji stickers by their identifiers. Returns an Array of <a href="#sticker">Sticker</a> objects.</p>
     *
     * @property customEmojiIds A JSON-serialized list of custom emoji identifiers. At most 200 custom emoji identifiers can be specified.
     * */
    data class GetCustomEmojiStickersRequest(
        val customEmojiIds: List<String>,
    ) : TelegramRequest()

    /**
     * <p>Use this method to upload a file with a sticker for later use in the <a href="#createnewstickerset">createNewStickerSet</a>, <a href="#addstickertoset">addStickerToSet</a>, or <a href="#replacestickerinset">replaceStickerInSet</a> methods (the file can be used multiple times). Returns the uploaded <a href="#file">File</a> on success.</p>
     *
     * @property userId User identifier of sticker file owner
     * @property sticker A file with the sticker in .WEBP, .PNG, .TGS, or .WEBM format. See <a href="/stickers"></a><a href="https://core.telegram.org/stickers">https://core.telegram.org/stickers</a> for technical requirements. <a href="#sending-files">More information on Sending Files »</a>
     * @property stickerFormat Format of the sticker, must be one of “static”, “animated”, “video”
     * */
    data class UploadStickerFileRequest(
        val userId: Long,
        val sticker: Any,
        val stickerFormat: String,
    ) : TelegramRequest()

    /**
     * <p>Use this method to create a new sticker set owned by a user. The bot will be able to edit the sticker set thus created. Returns <em>True</em> on success.</p>
     *
     * @property userId User identifier of created sticker set owner
     * @property name Short name of sticker set, to be used in <code>t.me/addstickers/</code> URLs (e.g., <em>animals</em>). Can contain only English letters, digits and underscores. Must begin with a letter, can't contain consecutive underscores and must end in <code>"_by_&lt;bot_username&gt;"</code>. <code>&lt;bot_username&gt;</code> is case insensitive. 1-64 characters.
     * @property title Sticker set title, 1-64 characters
     * @property stickers A JSON-serialized list of 1-50 initial stickers to be added to the sticker set
     * @property stickerType Type of stickers in the set, pass “regular”, “mask”, or “custom_emoji”. By default, a regular sticker set is created.
     * @property needsRepainting Pass <em>True</em> if stickers in the sticker set must be repainted to the color of text when used in messages, the accent color if used as emoji status, white on chat photos, or another appropriate color based on context; for custom emoji sticker sets only
     * */
    data class CreateNewStickerSetRequest(
        val userId: Long,
        val name: String,
        val title: String,
        val stickers: List<InputSticker>,
        val stickerType: String? = null,
        val needsRepainting: Boolean? = null,
    ) : TelegramRequest()

    /**
     * <p>Use this method to add a new sticker to a set created by the bot. Emoji sticker sets can have up to 200 stickers. Other sticker sets can have up to 120 stickers. Returns <em>True</em> on success.</p>
     *
     * @property userId User identifier of sticker set owner
     * @property name Sticker set name
     * @property sticker A JSON-serialized object with information about the added sticker. If exactly the same sticker had already been added to the set, then the set isn't changed.
     * */
    data class AddStickerToSetRequest(
        val userId: Long,
        val name: String,
        val sticker: InputSticker,
    ) : TelegramRequest()

    /**
     * <p>Use this method to move a sticker in a set created by the bot to a specific position. Returns <em>True</em> on success.</p>
     *
     * @property sticker File identifier of the sticker
     * @property position New sticker position in the set, zero-based
     * */
    data class SetStickerPositionInSetRequest(
        val sticker: String,
        val position: Long,
    ) : TelegramRequest()

    /**
     * <p>Use this method to delete a sticker from a set created by the bot. Returns <em>True</em> on success.</p>
     *
     * @property sticker File identifier of the sticker
     * */
    data class DeleteStickerFromSetRequest(
        val sticker: String,
    ) : TelegramRequest()

    /**
     * <p>Use this method to replace an existing sticker in a sticker set with a new one. The method is equivalent to calling <a href="#deletestickerfromset">deleteStickerFromSet</a>, then <a href="#addstickertoset">addStickerToSet</a>, then <a href="#setstickerpositioninset">setStickerPositionInSet</a>. Returns <em>True</em> on success.</p>
     *
     * @property userId User identifier of the sticker set owner
     * @property name Sticker set name
     * @property oldSticker File identifier of the replaced sticker
     * @property sticker A JSON-serialized object with information about the added sticker. If exactly the same sticker had already been added to the set, then the set remains unchanged.
     * */
    data class ReplaceStickerInSetRequest(
        val userId: Long,
        val name: String,
        val oldSticker: String,
        val sticker: InputSticker,
    ) : TelegramRequest()

    /**
     * <p>Use this method to change the list of emoji assigned to a regular or custom emoji sticker. The sticker must belong to a sticker set created by the bot. Returns <em>True</em> on success.</p>
     *
     * @property sticker File identifier of the sticker
     * @property emojiList A JSON-serialized list of 1-20 emoji associated with the sticker
     * */
    data class SetStickerEmojiListRequest(
        val sticker: String,
        val emojiList: List<String>,
    ) : TelegramRequest()

    /**
     * <p>Use this method to change search keywords assigned to a regular or custom emoji sticker. The sticker must belong to a sticker set created by the bot. Returns <em>True</em> on success.</p>
     *
     * @property sticker File identifier of the sticker
     * @property keywords A JSON-serialized list of 0-20 search keywords for the sticker with total length of up to 64 characters
     * */
    data class SetStickerKeywordsRequest(
        val sticker: String,
        val keywords: List<String>? = null,
    ) : TelegramRequest()

    /**
     * <p>Use this method to change the <a href="#maskposition">mask position</a> of a mask sticker. The sticker must belong to a sticker set that was created by the bot. Returns <em>True</em> on success.</p>
     *
     * @property sticker File identifier of the sticker
     * @property maskPosition A JSON-serialized object with the position where the mask should be placed on faces. Omit the parameter to remove the mask position.
     * */
    data class SetStickerMaskPositionRequest(
        val sticker: String,
        val maskPosition: MaskPosition? = null,
    ) : TelegramRequest()

    /**
     * <p>Use this method to set the title of a created sticker set. Returns <em>True</em> on success.</p>
     *
     * @property name Sticker set name
     * @property title Sticker set title, 1-64 characters
     * */
    data class SetStickerSetTitleRequest(
        val name: String,
        val title: String,
    ) : TelegramRequest()

    /**
     * <p>Use this method to set the thumbnail of a regular or mask sticker set. The format of the thumbnail file must match the format of the stickers in the set. Returns <em>True</em> on success.</p>
     *
     * @property name Sticker set name
     * @property userId User identifier of the sticker set owner
     * @property format Format of the thumbnail, must be one of “static” for a <strong>.WEBP</strong> or <strong>.PNG</strong> image, “animated” for a <strong>.TGS</strong> animation, or “video” for a <strong>.WEBM</strong> video
     * @property thumbnail A <strong>.WEBP</strong> or <strong>.PNG</strong> image with the thumbnail, must be up to 128 kilobytes in size and have a width and height of exactly 100px, or a <strong>.TGS</strong> animation with a thumbnail up to 32 kilobytes in size (see <a href="/stickers#animation-requirements"></a><a href="https://core.telegram.org/stickers#animation-requirements">https://core.telegram.org/stickers#animation-requirements</a> for animated sticker technical requirements), or a <strong>.WEBM</strong> video with the thumbnail up to 32 kilobytes in size; see <a href="/stickers#video-requirements"></a><a href="https://core.telegram.org/stickers#video-requirements">https://core.telegram.org/stickers#video-requirements</a> for video sticker technical requirements. Pass a <em>file_id</em> as a String to send a file that already exists on the Telegram servers, pass an HTTP URL as a String for Telegram to get a file from the Internet, or upload a new one using multipart/form-data. <a href="#sending-files">More information on Sending Files »</a>. Animated and video sticker set thumbnails can't be uploaded via HTTP URL. If omitted, then the thumbnail is dropped and the first sticker is used as the thumbnail.
     * */
    data class SetStickerSetThumbnailRequest(
        val name: String,
        val userId: Long,
        val format: String,
        val thumbnail: String? = null,
    ) : TelegramRequest()

    /**
     * <p>Use this method to set the thumbnail of a custom emoji sticker set. Returns <em>True</em> on success.</p>
     *
     * @property name Sticker set name
     * @property customEmojiId Custom emoji identifier of a sticker from the sticker set; pass an empty string to drop the thumbnail and use the first sticker as the thumbnail.
     * */
    data class SetCustomEmojiStickerSetThumbnailRequest(
        val name: String,
        val customEmojiId: String? = null,
    ) : TelegramRequest()

    /**
     * <p>Use this method to delete a sticker set that was created by the bot. Returns <em>True</em> on success.</p>
     *
     * @property name Sticker set name
     * */
    data class DeleteStickerSetRequest(
        val name: String,
    ) : TelegramRequest()

    // Inline mode

    /**
     * <p>Use this method to send answers to an inline query. On success, <em>True</em> is returned.<br>No more than <strong>50</strong> results per query are allowed.</p>
     *
     * @property inlineQueryId Unique identifier for the answered query
     * @property results A JSON-serialized array of results for the inline query
     * @property cacheTime The maximum amount of time in seconds that the result of the inline query may be cached on the server. Defaults to 300.
     * @property isPersonal Pass <em>True</em> if results may be cached on the server side only for the user that sent the query. By default, results may be returned to any user who sends the same query.
     * @property nextOffset Pass the offset that a client should send in the next query with the same text to receive more results. Pass an empty string if there are no more results or if you don't support pagination. Offset length can't exceed 64 bytes.
     * @property button A JSON-serialized object describing a button to be shown above inline query results
     * */
    data class AnswerInlineQueryRequest(
        val inlineQueryId: String,
        val results: List<InlineQueryResult>,
        val cacheTime: Long? = null,
        val isPersonal: Boolean? = null,
        val nextOffset: String? = null,
        val button: InlineQueryResultsButton? = null,
    ) : TelegramRequest()

    /**
     * <p>Use this method to set the result of an interaction with a <a href="/bots/webapps">Web App</a> and send a corresponding message on behalf of the user to the chat from which the query originated. On success, a <a href="#sentwebappmessage">SentWebAppMessage</a> object is returned.</p>
     *
     * @property webAppQueryId Unique identifier for the query to be answered
     * @property result A JSON-serialized object describing the message to be sent
     * */
    data class AnswerWebAppQueryRequest(
        val webAppQueryId: String,
        val result: InlineQueryResult,
    ) : TelegramRequest()

    /**
     * <p>Stores a message that can be sent by a user of a Mini App. Returns a <a href="#preparedinlinemessage">PreparedInlineMessage</a> object.</p>
     *
     * @property userId Unique identifier of the target user that can use the prepared message
     * @property result A JSON-serialized object describing the message to be sent
     * @property allowUserChats Pass <em>True</em> if the message can be sent to private chats with users
     * @property allowBotChats Pass <em>True</em> if the message can be sent to private chats with bots
     * @property allowGroupChats Pass <em>True</em> if the message can be sent to group and supergroup chats
     * @property allowChannelChats Pass <em>True</em> if the message can be sent to channel chats
     * */
    data class SavePreparedInlineMessageRequest(
        val userId: Long,
        val result: InlineQueryResult,
        val allowUserChats: Boolean? = null,
        val allowBotChats: Boolean? = null,
        val allowGroupChats: Boolean? = null,
        val allowChannelChats: Boolean? = null,
    ) : TelegramRequest()

    // Payments

    /**
     * <p>Use this method to send invoices. On success, the sent <a href="#message">Message</a> is returned.</p>
     *
     * @property chatId Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>)
     * @property title Product name, 1-32 characters
     * @property description Product description, 1-255 characters
     * @property payload Bot-defined invoice payload, 1-128 bytes. This will not be displayed to the user, use it for your internal processes.
     * @property currency Three-letter ISO 4217 currency code, see <a href="/bots/payments#supported-currencies">more on currencies</a>. Pass “XTR” for payments in <a href="https://t.me/BotNews/90">Telegram Stars</a>.
     * @property prices Price breakdown, a JSON-serialized list of components (e.g. product price, tax, discount, delivery cost, delivery tax, bonus, etc.). Must contain exactly one item for payments in <a href="https://t.me/BotNews/90">Telegram Stars</a>.
     * @property messageThreadId Unique identifier for the target message thread (topic) of the forum; for forum supergroups only
     * @property providerToken Payment provider token, obtained via <a href="https://t.me/botfather">@BotFather</a>. Pass an empty string for payments in <a href="https://t.me/BotNews/90">Telegram Stars</a>.
     * @property maxTipAmount The maximum accepted amount for tips in the <em>smallest units</em> of the currency (integer, <strong>not</strong> float/double). For example, for a maximum tip of <code>US$ 1.45</code> pass <code>max_tip_amount = 145</code>. See the <em>exp</em> parameter in <a href="/bots/payments/currencies.json">currencies.json</a>, it shows the number of digits past the decimal point for each currency (2 for the majority of currencies). Defaults to 0. Not supported for payments in <a href="https://t.me/BotNews/90">Telegram Stars</a>.
     * @property suggestedTipAmounts A JSON-serialized array of suggested amounts of tips in the <em>smallest units</em> of the currency (integer, <strong>not</strong> float/double). At most 4 suggested tip amounts can be specified. The suggested tip amounts must be positive, passed in a strictly increased order and must not exceed <em>max_tip_amount</em>.
     * @property startParameter Unique deep-linking parameter. If left empty, <strong>forwarded copies</strong> of the sent message will have a <em>Pay</em> button, allowing multiple users to pay directly from the forwarded message, using the same invoice. If non-empty, forwarded copies of the sent message will have a <em>URL</em> button with a deep link to the bot (instead of a <em>Pay</em> button), with the value used as the start parameter
     * @property providerData JSON-serialized data about the invoice, which will be shared with the payment provider. A detailed description of required fields should be provided by the payment provider.
     * @property photoUrl URL of the product photo for the invoice. Can be a photo of the goods or a marketing image for a service. People like it better when they see what they are paying for.
     * @property photoSize Photo size in bytes
     * @property photoWidth Photo width
     * @property photoHeight Photo height
     * @property needName Pass <em>True</em> if you require the user's full name to complete the order. Ignored for payments in <a href="https://t.me/BotNews/90">Telegram Stars</a>.
     * @property needPhoneNumber Pass <em>True</em> if you require the user's phone number to complete the order. Ignored for payments in <a href="https://t.me/BotNews/90">Telegram Stars</a>.
     * @property needEmail Pass <em>True</em> if you require the user's email address to complete the order. Ignored for payments in <a href="https://t.me/BotNews/90">Telegram Stars</a>.
     * @property needShippingAddress Pass <em>True</em> if you require the user's shipping address to complete the order. Ignored for payments in <a href="https://t.me/BotNews/90">Telegram Stars</a>.
     * @property sendPhoneNumberToProvider Pass <em>True</em> if the user's phone number should be sent to the provider. Ignored for payments in <a href="https://t.me/BotNews/90">Telegram Stars</a>.
     * @property sendEmailToProvider Pass <em>True</em> if the user's email address should be sent to the provider. Ignored for payments in <a href="https://t.me/BotNews/90">Telegram Stars</a>.
     * @property isFlexible Pass <em>True</em> if the final price depends on the shipping method. Ignored for payments in <a href="https://t.me/BotNews/90">Telegram Stars</a>.
     * @property disableNotification Sends the message <a href="https://telegram.org/blog/channels-2-0#silent-messages">silently</a>. Users will receive a notification with no sound.
     * @property protectContent Protects the contents of the sent message from forwarding and saving
     * @property allowPaidBroadcast Pass <em>True</em> to allow up to 1000 messages per second, ignoring <a href="https://core.telegram.org/bots/faq#how-can-i-message-all-of-my-bot-39s-subscribers-at-once">broadcasting limits</a> for a fee of 0.1 Telegram Stars per message. The relevant Stars will be withdrawn from the bot's balance
     * @property messageEffectId Unique identifier of the message effect to be added to the message; for private chats only
     * @property replyParameters Description of the message to reply to
     * @property replyMarkup A JSON-serialized object for an <a href="/bots/features#inline-keyboards">inline keyboard</a>. If empty, one 'Pay <code>total price</code>' button will be shown. If not empty, the first button must be a Pay button.
     * */
    data class SendInvoiceRequest(
        val chatId: String,
        val title: String,
        val description: String,
        val payload: String,
        val currency: String,
        val prices: List<LabeledPrice>,
        val messageThreadId: Long? = null,
        val providerToken: String? = null,
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
        val allowPaidBroadcast: Boolean? = null,
        val messageEffectId: String? = null,
        val replyParameters: ReplyParameters? = null,
        val replyMarkup: InlineKeyboardMarkup? = null,
    ) : TelegramRequest()

    /**
     * <p>Use this method to create a link for an invoice. Returns the created invoice link as <em>String</em> on success.</p>
     *
     * @property title Product name, 1-32 characters
     * @property description Product description, 1-255 characters
     * @property payload Bot-defined invoice payload, 1-128 bytes. This will not be displayed to the user, use it for your internal processes.
     * @property currency Three-letter ISO 4217 currency code, see <a href="/bots/payments#supported-currencies">more on currencies</a>. Pass “XTR” for payments in <a href="https://t.me/BotNews/90">Telegram Stars</a>.
     * @property prices Price breakdown, a JSON-serialized list of components (e.g. product price, tax, discount, delivery cost, delivery tax, bonus, etc.). Must contain exactly one item for payments in <a href="https://t.me/BotNews/90">Telegram Stars</a>.
     * @property businessConnectionId Unique identifier of the business connection on behalf of which the link will be created. For payments in <a href="https://t.me/BotNews/90">Telegram Stars</a> only.
     * @property providerToken Payment provider token, obtained via <a href="https://t.me/botfather">@BotFather</a>. Pass an empty string for payments in <a href="https://t.me/BotNews/90">Telegram Stars</a>.
     * @property subscriptionPeriod The number of seconds the subscription will be active for before the next payment. The currency must be set to “XTR” (Telegram Stars) if the parameter is used. Currently, it must always be 2592000 (30 days) if specified. Any number of subscriptions can be active for a given bot at the same time, including multiple concurrent subscriptions from the same user. Subscription price must no exceed 10000 Telegram Stars.
     * @property maxTipAmount The maximum accepted amount for tips in the <em>smallest units</em> of the currency (integer, <strong>not</strong> float/double). For example, for a maximum tip of <code>US$ 1.45</code> pass <code>max_tip_amount = 145</code>. See the <em>exp</em> parameter in <a href="/bots/payments/currencies.json">currencies.json</a>, it shows the number of digits past the decimal point for each currency (2 for the majority of currencies). Defaults to 0. Not supported for payments in <a href="https://t.me/BotNews/90">Telegram Stars</a>.
     * @property suggestedTipAmounts A JSON-serialized array of suggested amounts of tips in the <em>smallest units</em> of the currency (integer, <strong>not</strong> float/double). At most 4 suggested tip amounts can be specified. The suggested tip amounts must be positive, passed in a strictly increased order and must not exceed <em>max_tip_amount</em>.
     * @property providerData JSON-serialized data about the invoice, which will be shared with the payment provider. A detailed description of required fields should be provided by the payment provider.
     * @property photoUrl URL of the product photo for the invoice. Can be a photo of the goods or a marketing image for a service.
     * @property photoSize Photo size in bytes
     * @property photoWidth Photo width
     * @property photoHeight Photo height
     * @property needName Pass <em>True</em> if you require the user's full name to complete the order. Ignored for payments in <a href="https://t.me/BotNews/90">Telegram Stars</a>.
     * @property needPhoneNumber Pass <em>True</em> if you require the user's phone number to complete the order. Ignored for payments in <a href="https://t.me/BotNews/90">Telegram Stars</a>.
     * @property needEmail Pass <em>True</em> if you require the user's email address to complete the order. Ignored for payments in <a href="https://t.me/BotNews/90">Telegram Stars</a>.
     * @property needShippingAddress Pass <em>True</em> if you require the user's shipping address to complete the order. Ignored for payments in <a href="https://t.me/BotNews/90">Telegram Stars</a>.
     * @property sendPhoneNumberToProvider Pass <em>True</em> if the user's phone number should be sent to the provider. Ignored for payments in <a href="https://t.me/BotNews/90">Telegram Stars</a>.
     * @property sendEmailToProvider Pass <em>True</em> if the user's email address should be sent to the provider. Ignored for payments in <a href="https://t.me/BotNews/90">Telegram Stars</a>.
     * @property isFlexible Pass <em>True</em> if the final price depends on the shipping method. Ignored for payments in <a href="https://t.me/BotNews/90">Telegram Stars</a>.
     * */
    data class CreateInvoiceLinkRequest(
        val title: String,
        val description: String,
        val payload: String,
        val currency: String,
        val prices: List<LabeledPrice>,
        val businessConnectionId: String? = null,
        val providerToken: String? = null,
        val subscriptionPeriod: Long? = null,
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

    /**
     * <p>If you sent an invoice requesting a shipping address and the parameter <em>is_flexible</em> was specified, the Bot API will send an <a href="#update">Update</a> with a <em>shipping_query</em> field to the bot. Use this method to reply to shipping queries. On success, <em>True</em> is returned.</p>
     *
     * @property shippingQueryId Unique identifier for the query to be answered
     * @property ok Pass <em>True</em> if delivery to the specified address is possible and <em>False</em> if there are any problems (for example, if delivery to the specified address is not possible)
     * @property shippingOptions Required if <em>ok</em> is <em>True</em>. A JSON-serialized array of available shipping options.
     * @property errorMessage Required if <em>ok</em> is <em>False</em>. Error message in human readable form that explains why it is impossible to complete the order (e.g. “Sorry, delivery to your desired address is unavailable”). Telegram will display this message to the user.
     * */
    data class AnswerShippingQueryRequest(
        val shippingQueryId: String,
        val ok: Boolean,
        val shippingOptions: List<ShippingOption>? = null,
        val errorMessage: String? = null,
    ) : TelegramRequest()

    /**
     * <p>Once the user has confirmed their payment and shipping details, the Bot API sends the final confirmation in the form of an <a href="#update">Update</a> with the field <em>pre_checkout_query</em>. Use this method to respond to such pre-checkout queries. On success, <em>True</em> is returned. <strong>Note:</strong> The Bot API must receive an answer within 10 seconds after the pre-checkout query was sent.</p>
     *
     * @property preCheckoutQueryId Unique identifier for the query to be answered
     * @property ok Specify <em>True</em> if everything is alright (goods are available, etc.) and the bot is ready to proceed with the order. Use <em>False</em> if there are any problems.
     * @property errorMessage Required if <em>ok</em> is <em>False</em>. Error message in human readable form that explains the reason for failure to proceed with the checkout (e.g. "Sorry, somebody just bought the last of our amazing black T-shirts while you were busy filling out your payment details. Please choose a different color or garment!"). Telegram will display this message to the user.
     * */
    data class AnswerPreCheckoutQueryRequest(
        val preCheckoutQueryId: String,
        val ok: Boolean,
        val errorMessage: String? = null,
    ) : TelegramRequest()

    /**
     * <p>Returns the bot's Telegram Star transactions in chronological order. On success, returns a <a href="#startransactions">StarTransactions</a> object.</p>
     *
     * @property offset Number of transactions to skip in the response
     * @property limit The maximum number of transactions to be retrieved. Values between 1-100 are accepted. Defaults to 100.
     * */
    data class GetStarTransactionsRequest(
        val offset: Long? = null,
        val limit: Long? = null,
    ) : TelegramRequest()

    /**
     * <p>Refunds a successful payment in <a href="https://t.me/BotNews/90">Telegram Stars</a>. Returns <em>True</em> on success.</p>
     *
     * @property userId Identifier of the user whose payment will be refunded
     * @property telegramPaymentChargeId Telegram payment identifier
     * */
    data class RefundStarPaymentRequest(
        val userId: Long,
        val telegramPaymentChargeId: String,
    ) : TelegramRequest()

    /**
     * <p>Allows the bot to cancel or re-enable extension of a subscription paid in Telegram Stars. Returns <em>True</em> on success.</p>
     *
     * @property userId Identifier of the user whose subscription will be edited
     * @property telegramPaymentChargeId Telegram payment identifier for the subscription
     * @property isCanceled Pass <em>True</em> to cancel extension of the user subscription; the subscription must be active up to the end of the current subscription period. Pass <em>False</em> to allow the user to re-enable a subscription that was previously canceled by the bot.
     * */
    data class EditUserStarSubscriptionRequest(
        val userId: Long,
        val telegramPaymentChargeId: String,
        val isCanceled: Boolean,
    ) : TelegramRequest()

    // Telegram Passport

    /**
     * <p>Informs a user that some of the Telegram Passport elements they provided contains errors. The user will not be able to re-submit their Passport to you until the errors are fixed (the contents of the field for which you returned the error must change). Returns <em>True</em> on success.</p><p>Use this if the data submitted by the user doesn't satisfy the standards your service requires for any reason. For example, if a birthday date seems invalid, a submitted document is blurry, a scan shows evidence of tampering, etc. Supply some details in the error message to make sure the user knows how to correct the issues.</p>
     *
     * @property userId User identifier
     * @property errors A JSON-serialized array describing the errors
     * */
    data class SetPassportDataErrorsRequest(
        val userId: Long,
        val errors: List<PassportElementError>,
    ) : TelegramRequest()

    // Games

    /**
     * <p>Use this method to send a game. On success, the sent <a href="#message">Message</a> is returned.</p>
     *
     * @property chatId Unique identifier for the target chat
     * @property gameShortName Short name of the game, serves as the unique identifier for the game. Set up your games via <a href="https://t.me/botfather">@BotFather</a>.
     * @property businessConnectionId Unique identifier of the business connection on behalf of which the message will be sent
     * @property messageThreadId Unique identifier for the target message thread (topic) of the forum; for forum supergroups only
     * @property disableNotification Sends the message <a href="https://telegram.org/blog/channels-2-0#silent-messages">silently</a>. Users will receive a notification with no sound.
     * @property protectContent Protects the contents of the sent message from forwarding and saving
     * @property allowPaidBroadcast Pass <em>True</em> to allow up to 1000 messages per second, ignoring <a href="https://core.telegram.org/bots/faq#how-can-i-message-all-of-my-bot-39s-subscribers-at-once">broadcasting limits</a> for a fee of 0.1 Telegram Stars per message. The relevant Stars will be withdrawn from the bot's balance
     * @property messageEffectId Unique identifier of the message effect to be added to the message; for private chats only
     * @property replyParameters Description of the message to reply to
     * @property replyMarkup A JSON-serialized object for an <a href="/bots/features#inline-keyboards">inline keyboard</a>. If empty, one 'Play game_title' button will be shown. If not empty, the first button must launch the game.
     * */
    data class SendGameRequest(
        val chatId: Long,
        val gameShortName: String,
        val businessConnectionId: String? = null,
        val messageThreadId: Long? = null,
        val disableNotification: Boolean? = null,
        val protectContent: Boolean? = null,
        val allowPaidBroadcast: Boolean? = null,
        val messageEffectId: String? = null,
        val replyParameters: ReplyParameters? = null,
        val replyMarkup: InlineKeyboardMarkup? = null,
    ) : TelegramRequest()

    /**
     * <p>Use this method to set the score of the specified user in a game message. On success, if the message is not an inline message, the <a href="#message">Message</a> is returned, otherwise <em>True</em> is returned. Returns an error, if the new score is not greater than the user's current score in the chat and <em>force</em> is <em>False</em>.</p>
     *
     * @property userId User identifier
     * @property score New score, must be non-negative
     * @property force Pass <em>True</em> if the high score is allowed to decrease. This can be useful when fixing mistakes or banning cheaters
     * @property disableEditMessage Pass <em>True</em> if the game message should not be automatically edited to include the current scoreboard
     * @property chatId Required if <em>inline_message_id</em> is not specified. Unique identifier for the target chat
     * @property messageId Required if <em>inline_message_id</em> is not specified. Identifier of the sent message
     * @property inlineMessageId Required if <em>chat_id</em> and <em>message_id</em> are not specified. Identifier of the inline message
     * */
    data class SetGameScoreRequest(
        val userId: Long,
        val score: Long,
        val force: Boolean? = null,
        val disableEditMessage: Boolean? = null,
        val chatId: Long? = null,
        val messageId: Long? = null,
        val inlineMessageId: String? = null,
    ) : TelegramRequest()

    /**
     * <p>Use this method to get data for high score tables. Will return the score of the specified user and several of their neighbors in a game. Returns an Array of <a href="#gamehighscore">GameHighScore</a> objects.</p><blockquote>
     *  <p>This method will currently return scores for the target user, plus two of their closest neighbors on each side. Will also return the top three users if the user and their neighbors are not among them. Please note that this behavior is subject to change.</p>
     * </blockquote>
     *
     * @property userId Target user id
     * @property chatId Required if <em>inline_message_id</em> is not specified. Unique identifier for the target chat
     * @property messageId Required if <em>inline_message_id</em> is not specified. Identifier of the sent message
     * @property inlineMessageId Required if <em>chat_id</em> and <em>message_id</em> are not specified. Identifier of the inline message
     * */
    data class GetGameHighScoresRequest(
        val userId: Long,
        val chatId: Long? = null,
        val messageId: Long? = null,
        val inlineMessageId: String? = null,
    ) : TelegramRequest()
}
