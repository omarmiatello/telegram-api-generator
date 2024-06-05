@file:Suppress("ktlint:standard:no-wildcard-imports")

package com.github.omarmiatello.telegram

import com.github.omarmiatello.telegram.TelegramRequest.*
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.http.ContentType
import io.ktor.http.content.TextContent
import kotlinx.serialization.KSerializer
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.builtins.serializer
import kotlinx.serialization.json.Json

class TelegramClient(
    apiKey: String,
    private val httpClient: HttpClient = HttpClient(),
    private val apiUrl: String = "https://api.telegram.org",
    private val requestConfigurer: HttpRequestBuilder.() -> Unit = {},
) {
    private val basePath = "$apiUrl/bot$apiKey"
    private val json = Json {
        ignoreUnknownKeys = true
        prettyPrint = true
        encodeDefaults = false
    }

    private suspend fun <T> telegramGet(path: String, serializer: KSerializer<T>): TelegramResponse<T> {
        val responseString: String = httpClient.get(path) {
            this.requestConfigurer()
        }.body()
        return json.decodeFromString(TelegramResponse.serializer(serializer), responseString)
    }

    private suspend fun <T> telegramPost(path: String, body: String, serializer: KSerializer<T>): TelegramResponse<T> {
        val responseString: String = httpClient
            .post(path) {
                setBody(TextContent(body, ContentType.Application.Json))
                this.requestConfigurer()
            }
            .body()
        return json.decodeFromString(TelegramResponse.serializer(serializer), responseString)
    }

    suspend fun getUpdates(
        offset: Long? = null,
        limit: Long? = null,
        timeout: Long? = null,
        allowedUpdates: List<String>? = null,
    ) = telegramPost(
        "$basePath/getUpdates",
        GetUpdatesRequest(
            offset,
            limit,
            timeout,
            allowedUpdates,
        ).toJsonForRequest(),
        ListSerializer(Update.serializer())
    )

    suspend fun setWebhook(
        url: String,
        certificate: Any? = null,
        ipAddress: String? = null,
        maxConnections: Long? = null,
        allowedUpdates: List<String>? = null,
        dropPendingUpdates: Boolean? = null,
        secretToken: String? = null,
    ) = telegramPost(
        "$basePath/setWebhook",
        SetWebhookRequest(
            url,
            certificate,
            ipAddress,
            maxConnections,
            allowedUpdates,
            dropPendingUpdates,
            secretToken,
        ).toJsonForRequest(),
        Boolean.serializer()
    )

    suspend fun deleteWebhook(
        dropPendingUpdates: Boolean? = null,
    ) = telegramPost(
        "$basePath/deleteWebhook",
        DeleteWebhookRequest(
            dropPendingUpdates,
        ).toJsonForRequest(),
        Boolean.serializer()
    )

    suspend fun getWebhookInfo() = telegramGet(
        "$basePath/getWebhookInfo",
        WebhookInfo.serializer(),
    )

    suspend fun logOut() = telegramGet(
        "$basePath/logOut",
        Boolean.serializer(),
    )

    suspend fun close() = telegramGet(
        "$basePath/close",
        Boolean.serializer(),
    )

    suspend fun sendMessage(
        chatId: String,
        text: String,
        businessConnectionId: String? = null,
        messageThreadId: Long? = null,
        parseMode: ParseMode? = null,
        entities: List<MessageEntity>? = null,
        linkPreviewOptions: LinkPreviewOptions? = null,
        disableNotification: Boolean? = null,
        protectContent: Boolean? = null,
        messageEffectId: String? = null,
        replyParameters: ReplyParameters? = null,
        replyMarkup: KeyboardOption? = null,
    ) = telegramPost(
        "$basePath/sendMessage",
        SendMessageRequest(
            businessConnectionId,
            chatId,
            messageThreadId,
            text,
            parseMode,
            entities,
            linkPreviewOptions,
            disableNotification,
            protectContent,
            messageEffectId,
            replyParameters,
            replyMarkup,
        ).toJsonForRequest(),
        Message.serializer()
    )

    suspend fun forwardMessage(
        chatId: String,
        fromChatId: String,
        messageId: Long,
        messageThreadId: Long? = null,
        disableNotification: Boolean? = null,
        protectContent: Boolean? = null,
    ) = telegramPost(
        "$basePath/forwardMessage",
        ForwardMessageRequest(
            chatId,
            messageThreadId,
            fromChatId,
            disableNotification,
            protectContent,
            messageId,
        ).toJsonForRequest(),
        Message.serializer()
    )

    suspend fun forwardMessages(
        chatId: String,
        fromChatId: String,
        messageIds: List<Long>,
        messageThreadId: Long? = null,
        disableNotification: Boolean? = null,
        protectContent: Boolean? = null,
    ) = telegramPost(
        "$basePath/forwardMessages",
        ForwardMessagesRequest(
            chatId,
            messageThreadId,
            fromChatId,
            messageIds,
            disableNotification,
            protectContent,
        ).toJsonForRequest(),
        ListSerializer(MessageId.serializer())
    )

    suspend fun copyMessage(
        chatId: String,
        fromChatId: String,
        messageId: Long,
        messageThreadId: Long? = null,
        caption: String? = null,
        parseMode: ParseMode? = null,
        captionEntities: List<MessageEntity>? = null,
        showCaptionAboveMedia: Boolean? = null,
        disableNotification: Boolean? = null,
        protectContent: Boolean? = null,
        replyParameters: ReplyParameters? = null,
        replyMarkup: KeyboardOption? = null,
    ) = telegramPost(
        "$basePath/copyMessage",
        CopyMessageRequest(
            chatId,
            messageThreadId,
            fromChatId,
            messageId,
            caption,
            parseMode,
            captionEntities,
            showCaptionAboveMedia,
            disableNotification,
            protectContent,
            replyParameters,
            replyMarkup,
        ).toJsonForRequest(),
        MessageId.serializer()
    )

    suspend fun copyMessages(
        chatId: String,
        fromChatId: String,
        messageIds: List<Long>,
        messageThreadId: Long? = null,
        disableNotification: Boolean? = null,
        protectContent: Boolean? = null,
        removeCaption: Boolean? = null,
    ) = telegramPost(
        "$basePath/copyMessages",
        CopyMessagesRequest(
            chatId,
            messageThreadId,
            fromChatId,
            messageIds,
            disableNotification,
            protectContent,
            removeCaption,
        ).toJsonForRequest(),
        ListSerializer(MessageId.serializer())
    )

    suspend fun sendPhoto(
        chatId: String,
        photo: String,
        businessConnectionId: String? = null,
        messageThreadId: Long? = null,
        caption: String? = null,
        parseMode: ParseMode? = null,
        captionEntities: List<MessageEntity>? = null,
        showCaptionAboveMedia: Boolean? = null,
        hasSpoiler: Boolean? = null,
        disableNotification: Boolean? = null,
        protectContent: Boolean? = null,
        messageEffectId: String? = null,
        replyParameters: ReplyParameters? = null,
        replyMarkup: KeyboardOption? = null,
    ) = telegramPost(
        "$basePath/sendPhoto",
        SendPhotoRequest(
            businessConnectionId,
            chatId,
            messageThreadId,
            photo,
            caption,
            parseMode,
            captionEntities,
            showCaptionAboveMedia,
            hasSpoiler,
            disableNotification,
            protectContent,
            messageEffectId,
            replyParameters,
            replyMarkup,
        ).toJsonForRequest(),
        Message.serializer()
    )

    suspend fun sendAudio(
        chatId: String,
        audio: String,
        businessConnectionId: String? = null,
        messageThreadId: Long? = null,
        caption: String? = null,
        parseMode: ParseMode? = null,
        captionEntities: List<MessageEntity>? = null,
        duration: Long? = null,
        performer: String? = null,
        title: String? = null,
        thumbnail: String? = null,
        disableNotification: Boolean? = null,
        protectContent: Boolean? = null,
        messageEffectId: String? = null,
        replyParameters: ReplyParameters? = null,
        replyMarkup: KeyboardOption? = null,
    ) = telegramPost(
        "$basePath/sendAudio",
        SendAudioRequest(
            businessConnectionId,
            chatId,
            messageThreadId,
            audio,
            caption,
            parseMode,
            captionEntities,
            duration,
            performer,
            title,
            thumbnail,
            disableNotification,
            protectContent,
            messageEffectId,
            replyParameters,
            replyMarkup,
        ).toJsonForRequest(),
        Message.serializer()
    )

    suspend fun sendDocument(
        chatId: String,
        document: String,
        businessConnectionId: String? = null,
        messageThreadId: Long? = null,
        thumbnail: String? = null,
        caption: String? = null,
        parseMode: ParseMode? = null,
        captionEntities: List<MessageEntity>? = null,
        disableContentTypeDetection: Boolean? = null,
        disableNotification: Boolean? = null,
        protectContent: Boolean? = null,
        messageEffectId: String? = null,
        replyParameters: ReplyParameters? = null,
        replyMarkup: KeyboardOption? = null,
    ) = telegramPost(
        "$basePath/sendDocument",
        SendDocumentRequest(
            businessConnectionId,
            chatId,
            messageThreadId,
            document,
            thumbnail,
            caption,
            parseMode,
            captionEntities,
            disableContentTypeDetection,
            disableNotification,
            protectContent,
            messageEffectId,
            replyParameters,
            replyMarkup,
        ).toJsonForRequest(),
        Message.serializer()
    )

    suspend fun sendVideo(
        chatId: String,
        video: String,
        businessConnectionId: String? = null,
        messageThreadId: Long? = null,
        duration: Long? = null,
        width: Long? = null,
        height: Long? = null,
        thumbnail: String? = null,
        caption: String? = null,
        parseMode: ParseMode? = null,
        captionEntities: List<MessageEntity>? = null,
        showCaptionAboveMedia: Boolean? = null,
        hasSpoiler: Boolean? = null,
        supportsStreaming: Boolean? = null,
        disableNotification: Boolean? = null,
        protectContent: Boolean? = null,
        messageEffectId: String? = null,
        replyParameters: ReplyParameters? = null,
        replyMarkup: KeyboardOption? = null,
    ) = telegramPost(
        "$basePath/sendVideo",
        SendVideoRequest(
            businessConnectionId,
            chatId,
            messageThreadId,
            video,
            duration,
            width,
            height,
            thumbnail,
            caption,
            parseMode,
            captionEntities,
            showCaptionAboveMedia,
            hasSpoiler,
            supportsStreaming,
            disableNotification,
            protectContent,
            messageEffectId,
            replyParameters,
            replyMarkup,
        ).toJsonForRequest(),
        Message.serializer()
    )

    suspend fun sendAnimation(
        chatId: String,
        animation: String,
        businessConnectionId: String? = null,
        messageThreadId: Long? = null,
        duration: Long? = null,
        width: Long? = null,
        height: Long? = null,
        thumbnail: String? = null,
        caption: String? = null,
        parseMode: ParseMode? = null,
        captionEntities: List<MessageEntity>? = null,
        showCaptionAboveMedia: Boolean? = null,
        hasSpoiler: Boolean? = null,
        disableNotification: Boolean? = null,
        protectContent: Boolean? = null,
        messageEffectId: String? = null,
        replyParameters: ReplyParameters? = null,
        replyMarkup: KeyboardOption? = null,
    ) = telegramPost(
        "$basePath/sendAnimation",
        SendAnimationRequest(
            businessConnectionId,
            chatId,
            messageThreadId,
            animation,
            duration,
            width,
            height,
            thumbnail,
            caption,
            parseMode,
            captionEntities,
            showCaptionAboveMedia,
            hasSpoiler,
            disableNotification,
            protectContent,
            messageEffectId,
            replyParameters,
            replyMarkup,
        ).toJsonForRequest(),
        Message.serializer()
    )

    suspend fun sendVoice(
        chatId: String,
        voice: String,
        businessConnectionId: String? = null,
        messageThreadId: Long? = null,
        caption: String? = null,
        parseMode: ParseMode? = null,
        captionEntities: List<MessageEntity>? = null,
        duration: Long? = null,
        disableNotification: Boolean? = null,
        protectContent: Boolean? = null,
        messageEffectId: String? = null,
        replyParameters: ReplyParameters? = null,
        replyMarkup: KeyboardOption? = null,
    ) = telegramPost(
        "$basePath/sendVoice",
        SendVoiceRequest(
            businessConnectionId,
            chatId,
            messageThreadId,
            voice,
            caption,
            parseMode,
            captionEntities,
            duration,
            disableNotification,
            protectContent,
            messageEffectId,
            replyParameters,
            replyMarkup,
        ).toJsonForRequest(),
        Message.serializer()
    )

    suspend fun sendVideoNote(
        chatId: String,
        videoNote: String,
        businessConnectionId: String? = null,
        messageThreadId: Long? = null,
        duration: Long? = null,
        length: Long? = null,
        thumbnail: String? = null,
        disableNotification: Boolean? = null,
        protectContent: Boolean? = null,
        messageEffectId: String? = null,
        replyParameters: ReplyParameters? = null,
        replyMarkup: KeyboardOption? = null,
    ) = telegramPost(
        "$basePath/sendVideoNote",
        SendVideoNoteRequest(
            businessConnectionId,
            chatId,
            messageThreadId,
            videoNote,
            duration,
            length,
            thumbnail,
            disableNotification,
            protectContent,
            messageEffectId,
            replyParameters,
            replyMarkup,
        ).toJsonForRequest(),
        Message.serializer()
    )

    suspend fun sendMediaGroup(
        chatId: String,
        media: List<InputMedia>,
        businessConnectionId: String? = null,
        messageThreadId: Long? = null,
        disableNotification: Boolean? = null,
        protectContent: Boolean? = null,
        messageEffectId: String? = null,
        replyParameters: ReplyParameters? = null,
    ) = telegramPost(
        "$basePath/sendMediaGroup",
        SendMediaGroupRequest(
            businessConnectionId,
            chatId,
            messageThreadId,
            media,
            disableNotification,
            protectContent,
            messageEffectId,
            replyParameters,
        ).toJsonForRequest(),
        ListSerializer(Message.serializer())
    )

    suspend fun sendLocation(
        chatId: String,
        latitude: Float,
        longitude: Float,
        businessConnectionId: String? = null,
        messageThreadId: Long? = null,
        horizontalAccuracy: Float? = null,
        livePeriod: Long? = null,
        heading: Long? = null,
        proximityAlertRadius: Long? = null,
        disableNotification: Boolean? = null,
        protectContent: Boolean? = null,
        messageEffectId: String? = null,
        replyParameters: ReplyParameters? = null,
        replyMarkup: KeyboardOption? = null,
    ) = telegramPost(
        "$basePath/sendLocation",
        SendLocationRequest(
            businessConnectionId,
            chatId,
            messageThreadId,
            latitude,
            longitude,
            horizontalAccuracy,
            livePeriod,
            heading,
            proximityAlertRadius,
            disableNotification,
            protectContent,
            messageEffectId,
            replyParameters,
            replyMarkup,
        ).toJsonForRequest(),
        Message.serializer()
    )

    suspend fun sendVenue(
        chatId: String,
        latitude: Float,
        longitude: Float,
        title: String,
        address: String,
        businessConnectionId: String? = null,
        messageThreadId: Long? = null,
        foursquareId: String? = null,
        foursquareType: String? = null,
        googlePlaceId: String? = null,
        googlePlaceType: String? = null,
        disableNotification: Boolean? = null,
        protectContent: Boolean? = null,
        messageEffectId: String? = null,
        replyParameters: ReplyParameters? = null,
        replyMarkup: KeyboardOption? = null,
    ) = telegramPost(
        "$basePath/sendVenue",
        SendVenueRequest(
            businessConnectionId,
            chatId,
            messageThreadId,
            latitude,
            longitude,
            title,
            address,
            foursquareId,
            foursquareType,
            googlePlaceId,
            googlePlaceType,
            disableNotification,
            protectContent,
            messageEffectId,
            replyParameters,
            replyMarkup,
        ).toJsonForRequest(),
        Message.serializer()
    )

    suspend fun sendContact(
        chatId: String,
        phoneNumber: String,
        firstName: String,
        businessConnectionId: String? = null,
        messageThreadId: Long? = null,
        lastName: String? = null,
        vcard: String? = null,
        disableNotification: Boolean? = null,
        protectContent: Boolean? = null,
        messageEffectId: String? = null,
        replyParameters: ReplyParameters? = null,
        replyMarkup: KeyboardOption? = null,
    ) = telegramPost(
        "$basePath/sendContact",
        SendContactRequest(
            businessConnectionId,
            chatId,
            messageThreadId,
            phoneNumber,
            firstName,
            lastName,
            vcard,
            disableNotification,
            protectContent,
            messageEffectId,
            replyParameters,
            replyMarkup,
        ).toJsonForRequest(),
        Message.serializer()
    )

    suspend fun sendPoll(
        chatId: String,
        question: String,
        options: List<InputPollOption>,
        businessConnectionId: String? = null,
        messageThreadId: Long? = null,
        questionParseMode: String? = null,
        questionEntities: List<MessageEntity>? = null,
        isAnonymous: Boolean? = null,
        type: String? = null,
        allowsMultipleAnswers: Boolean? = null,
        correctOptionId: Long? = null,
        explanation: String? = null,
        explanationParseMode: String? = null,
        explanationEntities: List<MessageEntity>? = null,
        openPeriod: Long? = null,
        closeDate: Long? = null,
        isClosed: Boolean? = null,
        disableNotification: Boolean? = null,
        protectContent: Boolean? = null,
        messageEffectId: String? = null,
        replyParameters: ReplyParameters? = null,
        replyMarkup: KeyboardOption? = null,
    ) = telegramPost(
        "$basePath/sendPoll",
        SendPollRequest(
            businessConnectionId,
            chatId,
            messageThreadId,
            question,
            questionParseMode,
            questionEntities,
            options,
            isAnonymous,
            type,
            allowsMultipleAnswers,
            correctOptionId,
            explanation,
            explanationParseMode,
            explanationEntities,
            openPeriod,
            closeDate,
            isClosed,
            disableNotification,
            protectContent,
            messageEffectId,
            replyParameters,
            replyMarkup,
        ).toJsonForRequest(),
        Message.serializer()
    )

    suspend fun sendDice(
        chatId: String,
        businessConnectionId: String? = null,
        messageThreadId: Long? = null,
        emoji: String? = null,
        disableNotification: Boolean? = null,
        protectContent: Boolean? = null,
        messageEffectId: String? = null,
        replyParameters: ReplyParameters? = null,
        replyMarkup: KeyboardOption? = null,
    ) = telegramPost(
        "$basePath/sendDice",
        SendDiceRequest(
            businessConnectionId,
            chatId,
            messageThreadId,
            emoji,
            disableNotification,
            protectContent,
            messageEffectId,
            replyParameters,
            replyMarkup,
        ).toJsonForRequest(),
        Message.serializer()
    )

    suspend fun sendChatAction(
        chatId: String,
        action: String,
        businessConnectionId: String? = null,
        messageThreadId: Long? = null,
    ) = telegramPost(
        "$basePath/sendChatAction",
        SendChatActionRequest(
            businessConnectionId,
            chatId,
            messageThreadId,
            action,
        ).toJsonForRequest(),
        Boolean.serializer()
    )

    suspend fun setMessageReaction(
        chatId: String,
        messageId: Long,
        reaction: List<ReactionType>? = null,
        isBig: Boolean? = null,
    ) = telegramPost(
        "$basePath/setMessageReaction",
        SetMessageReactionRequest(
            chatId,
            messageId,
            reaction,
            isBig,
        ).toJsonForRequest(),
        Boolean.serializer()
    )

    suspend fun getUserProfilePhotos(
        userId: Long,
        offset: Long? = null,
        limit: Long? = null,
    ) = telegramPost(
        "$basePath/getUserProfilePhotos",
        GetUserProfilePhotosRequest(
            userId,
            offset,
            limit,
        ).toJsonForRequest(),
        UserProfilePhotos.serializer()
    )

    suspend fun getFile(
        fileId: String,
    ) = telegramPost(
        "$basePath/getFile",
        GetFileRequest(
            fileId,
        ).toJsonForRequest(),
        File.serializer()
    )

    suspend fun banChatMember(
        chatId: String,
        userId: Long,
        untilDate: Long? = null,
        revokeMessages: Boolean? = null,
    ) = telegramPost(
        "$basePath/banChatMember",
        BanChatMemberRequest(
            chatId,
            userId,
            untilDate,
            revokeMessages,
        ).toJsonForRequest(),
        Boolean.serializer()
    )

    suspend fun unbanChatMember(
        chatId: String,
        userId: Long,
        onlyIfBanned: Boolean? = null,
    ) = telegramPost(
        "$basePath/unbanChatMember",
        UnbanChatMemberRequest(
            chatId,
            userId,
            onlyIfBanned,
        ).toJsonForRequest(),
        Boolean.serializer()
    )

    suspend fun restrictChatMember(
        chatId: String,
        userId: Long,
        permissions: ChatPermissions,
        useIndependentChatPermissions: Boolean? = null,
        untilDate: Long? = null,
    ) = telegramPost(
        "$basePath/restrictChatMember",
        RestrictChatMemberRequest(
            chatId,
            userId,
            permissions,
            useIndependentChatPermissions,
            untilDate,
        ).toJsonForRequest(),
        Boolean.serializer()
    )

    suspend fun promoteChatMember(
        chatId: String,
        userId: Long,
        isAnonymous: Boolean? = null,
        canManageChat: Boolean? = null,
        canDeleteMessages: Boolean? = null,
        canManageVideoChats: Boolean? = null,
        canRestrictMembers: Boolean? = null,
        canPromoteMembers: Boolean? = null,
        canChangeInfo: Boolean? = null,
        canInviteUsers: Boolean? = null,
        canPostStories: Boolean? = null,
        canEditStories: Boolean? = null,
        canDeleteStories: Boolean? = null,
        canPostMessages: Boolean? = null,
        canEditMessages: Boolean? = null,
        canPinMessages: Boolean? = null,
        canManageTopics: Boolean? = null,
    ) = telegramPost(
        "$basePath/promoteChatMember",
        PromoteChatMemberRequest(
            chatId,
            userId,
            isAnonymous,
            canManageChat,
            canDeleteMessages,
            canManageVideoChats,
            canRestrictMembers,
            canPromoteMembers,
            canChangeInfo,
            canInviteUsers,
            canPostStories,
            canEditStories,
            canDeleteStories,
            canPostMessages,
            canEditMessages,
            canPinMessages,
            canManageTopics,
        ).toJsonForRequest(),
        Boolean.serializer()
    )

    suspend fun setChatAdministratorCustomTitle(
        chatId: String,
        userId: Long,
        customTitle: String,
    ) = telegramPost(
        "$basePath/setChatAdministratorCustomTitle",
        SetChatAdministratorCustomTitleRequest(
            chatId,
            userId,
            customTitle,
        ).toJsonForRequest(),
        Boolean.serializer()
    )

    suspend fun banChatSenderChat(
        chatId: String,
        senderChatId: Long,
    ) = telegramPost(
        "$basePath/banChatSenderChat",
        BanChatSenderChatRequest(
            chatId,
            senderChatId,
        ).toJsonForRequest(),
        Boolean.serializer()
    )

    suspend fun unbanChatSenderChat(
        chatId: String,
        senderChatId: Long,
    ) = telegramPost(
        "$basePath/unbanChatSenderChat",
        UnbanChatSenderChatRequest(
            chatId,
            senderChatId,
        ).toJsonForRequest(),
        Boolean.serializer()
    )

    suspend fun setChatPermissions(
        chatId: String,
        permissions: ChatPermissions,
        useIndependentChatPermissions: Boolean? = null,
    ) = telegramPost(
        "$basePath/setChatPermissions",
        SetChatPermissionsRequest(
            chatId,
            permissions,
            useIndependentChatPermissions,
        ).toJsonForRequest(),
        Boolean.serializer()
    )

    suspend fun exportChatInviteLink(
        chatId: String,
    ) = telegramPost(
        "$basePath/exportChatInviteLink",
        ExportChatInviteLinkRequest(
            chatId,
        ).toJsonForRequest(),
        String.serializer()
    )

    suspend fun createChatInviteLink(
        chatId: String,
        name: String? = null,
        expireDate: Long? = null,
        memberLimit: Long? = null,
        createsJoinRequest: Boolean? = null,
    ) = telegramPost(
        "$basePath/createChatInviteLink",
        CreateChatInviteLinkRequest(
            chatId,
            name,
            expireDate,
            memberLimit,
            createsJoinRequest,
        ).toJsonForRequest(),
        ChatInviteLink.serializer()
    )

    suspend fun editChatInviteLink(
        chatId: String,
        inviteLink: String,
        name: String? = null,
        expireDate: Long? = null,
        memberLimit: Long? = null,
        createsJoinRequest: Boolean? = null,
    ) = telegramPost(
        "$basePath/editChatInviteLink",
        EditChatInviteLinkRequest(
            chatId,
            inviteLink,
            name,
            expireDate,
            memberLimit,
            createsJoinRequest,
        ).toJsonForRequest(),
        ChatInviteLink.serializer()
    )

    suspend fun revokeChatInviteLink(
        chatId: String,
        inviteLink: String,
    ) = telegramPost(
        "$basePath/revokeChatInviteLink",
        RevokeChatInviteLinkRequest(
            chatId,
            inviteLink,
        ).toJsonForRequest(),
        ChatInviteLink.serializer()
    )

    suspend fun approveChatJoinRequest(
        chatId: String,
        userId: Long,
    ) = telegramPost(
        "$basePath/approveChatJoinRequest",
        ApproveChatJoinRequestRequest(
            chatId,
            userId,
        ).toJsonForRequest(),
        Boolean.serializer()
    )

    suspend fun declineChatJoinRequest(
        chatId: String,
        userId: Long,
    ) = telegramPost(
        "$basePath/declineChatJoinRequest",
        DeclineChatJoinRequestRequest(
            chatId,
            userId,
        ).toJsonForRequest(),
        Boolean.serializer()
    )

    suspend fun setChatPhoto(
        chatId: String,
        photo: Any,
    ) = telegramPost(
        "$basePath/setChatPhoto",
        SetChatPhotoRequest(
            chatId,
            photo,
        ).toJsonForRequest(),
        Boolean.serializer()
    )

    suspend fun deleteChatPhoto(
        chatId: String,
    ) = telegramPost(
        "$basePath/deleteChatPhoto",
        DeleteChatPhotoRequest(
            chatId,
        ).toJsonForRequest(),
        Boolean.serializer()
    )

    suspend fun setChatTitle(
        chatId: String,
        title: String,
    ) = telegramPost(
        "$basePath/setChatTitle",
        SetChatTitleRequest(
            chatId,
            title,
        ).toJsonForRequest(),
        Boolean.serializer()
    )

    suspend fun setChatDescription(
        chatId: String,
        description: String? = null,
    ) = telegramPost(
        "$basePath/setChatDescription",
        SetChatDescriptionRequest(
            chatId,
            description,
        ).toJsonForRequest(),
        Boolean.serializer()
    )

    suspend fun pinChatMessage(
        chatId: String,
        messageId: Long,
        disableNotification: Boolean? = null,
    ) = telegramPost(
        "$basePath/pinChatMessage",
        PinChatMessageRequest(
            chatId,
            messageId,
            disableNotification,
        ).toJsonForRequest(),
        Boolean.serializer()
    )

    suspend fun unpinChatMessage(
        chatId: String,
        messageId: Long? = null,
    ) = telegramPost(
        "$basePath/unpinChatMessage",
        UnpinChatMessageRequest(
            chatId,
            messageId,
        ).toJsonForRequest(),
        Boolean.serializer()
    )

    suspend fun unpinAllChatMessages(
        chatId: String,
    ) = telegramPost(
        "$basePath/unpinAllChatMessages",
        UnpinAllChatMessagesRequest(
            chatId,
        ).toJsonForRequest(),
        Boolean.serializer()
    )

    suspend fun leaveChat(
        chatId: String,
    ) = telegramPost(
        "$basePath/leaveChat",
        LeaveChatRequest(
            chatId,
        ).toJsonForRequest(),
        Boolean.serializer()
    )

    suspend fun getChat(
        chatId: String,
    ) = telegramPost(
        "$basePath/getChat",
        GetChatRequest(
            chatId,
        ).toJsonForRequest(),
        ChatFullInfo.serializer()
    )

    suspend fun getChatAdministrators(
        chatId: String,
    ) = telegramPost(
        "$basePath/getChatAdministrators",
        GetChatAdministratorsRequest(
            chatId,
        ).toJsonForRequest(),
        ListSerializer(ChatMember.serializer())
    )

    suspend fun getChatMemberCount(
        chatId: String,
    ) = telegramPost(
        "$basePath/getChatMemberCount",
        GetChatMemberCountRequest(
            chatId,
        ).toJsonForRequest(),
        Int.serializer()
    )

    suspend fun getChatMember(
        chatId: String,
        userId: Long,
    ) = telegramPost(
        "$basePath/getChatMember",
        GetChatMemberRequest(
            chatId,
            userId,
        ).toJsonForRequest(),
        ChatMember.serializer()
    )

    suspend fun setChatStickerSet(
        chatId: String,
        stickerSetName: String,
    ) = telegramPost(
        "$basePath/setChatStickerSet",
        SetChatStickerSetRequest(
            chatId,
            stickerSetName,
        ).toJsonForRequest(),
        Boolean.serializer()
    )

    suspend fun deleteChatStickerSet(
        chatId: String,
    ) = telegramPost(
        "$basePath/deleteChatStickerSet",
        DeleteChatStickerSetRequest(
            chatId,
        ).toJsonForRequest(),
        Boolean.serializer()
    )

    suspend fun getForumTopicIconStickers() = telegramGet(
        "$basePath/getForumTopicIconStickers",
        ListSerializer(Sticker.serializer()),
    )

    suspend fun createForumTopic(
        chatId: String,
        name: String,
        iconColor: Long? = null,
        iconCustomEmojiId: String? = null,
    ) = telegramPost(
        "$basePath/createForumTopic",
        CreateForumTopicRequest(
            chatId,
            name,
            iconColor,
            iconCustomEmojiId,
        ).toJsonForRequest(),
        ForumTopic.serializer()
    )

    suspend fun editForumTopic(
        chatId: String,
        messageThreadId: Long,
        name: String? = null,
        iconCustomEmojiId: String? = null,
    ) = telegramPost(
        "$basePath/editForumTopic",
        EditForumTopicRequest(
            chatId,
            messageThreadId,
            name,
            iconCustomEmojiId,
        ).toJsonForRequest(),
        Boolean.serializer()
    )

    suspend fun closeForumTopic(
        chatId: String,
        messageThreadId: Long,
    ) = telegramPost(
        "$basePath/closeForumTopic",
        CloseForumTopicRequest(
            chatId,
            messageThreadId,
        ).toJsonForRequest(),
        Boolean.serializer()
    )

    suspend fun reopenForumTopic(
        chatId: String,
        messageThreadId: Long,
    ) = telegramPost(
        "$basePath/reopenForumTopic",
        ReopenForumTopicRequest(
            chatId,
            messageThreadId,
        ).toJsonForRequest(),
        Boolean.serializer()
    )

    suspend fun deleteForumTopic(
        chatId: String,
        messageThreadId: Long,
    ) = telegramPost(
        "$basePath/deleteForumTopic",
        DeleteForumTopicRequest(
            chatId,
            messageThreadId,
        ).toJsonForRequest(),
        Boolean.serializer()
    )

    suspend fun unpinAllForumTopicMessages(
        chatId: String,
        messageThreadId: Long,
    ) = telegramPost(
        "$basePath/unpinAllForumTopicMessages",
        UnpinAllForumTopicMessagesRequest(
            chatId,
            messageThreadId,
        ).toJsonForRequest(),
        Boolean.serializer()
    )

    suspend fun editGeneralForumTopic(
        chatId: String,
        name: String,
    ) = telegramPost(
        "$basePath/editGeneralForumTopic",
        EditGeneralForumTopicRequest(
            chatId,
            name,
        ).toJsonForRequest(),
        Boolean.serializer()
    )

    suspend fun closeGeneralForumTopic(
        chatId: String,
    ) = telegramPost(
        "$basePath/closeGeneralForumTopic",
        CloseGeneralForumTopicRequest(
            chatId,
        ).toJsonForRequest(),
        Boolean.serializer()
    )

    suspend fun reopenGeneralForumTopic(
        chatId: String,
    ) = telegramPost(
        "$basePath/reopenGeneralForumTopic",
        ReopenGeneralForumTopicRequest(
            chatId,
        ).toJsonForRequest(),
        Boolean.serializer()
    )

    suspend fun hideGeneralForumTopic(
        chatId: String,
    ) = telegramPost(
        "$basePath/hideGeneralForumTopic",
        HideGeneralForumTopicRequest(
            chatId,
        ).toJsonForRequest(),
        Boolean.serializer()
    )

    suspend fun unhideGeneralForumTopic(
        chatId: String,
    ) = telegramPost(
        "$basePath/unhideGeneralForumTopic",
        UnhideGeneralForumTopicRequest(
            chatId,
        ).toJsonForRequest(),
        Boolean.serializer()
    )

    suspend fun unpinAllGeneralForumTopicMessages(
        chatId: String,
    ) = telegramPost(
        "$basePath/unpinAllGeneralForumTopicMessages",
        UnpinAllGeneralForumTopicMessagesRequest(
            chatId,
        ).toJsonForRequest(),
        Boolean.serializer()
    )

    suspend fun answerCallbackQuery(
        callbackQueryId: String,
        text: String? = null,
        showAlert: Boolean? = null,
        url: String? = null,
        cacheTime: Long? = null,
    ) = telegramPost(
        "$basePath/answerCallbackQuery",
        AnswerCallbackQueryRequest(
            callbackQueryId,
            text,
            showAlert,
            url,
            cacheTime,
        ).toJsonForRequest(),
        Boolean.serializer()
    )

    suspend fun getUserChatBoosts(
        chatId: String,
        userId: Long,
    ) = telegramPost(
        "$basePath/getUserChatBoosts",
        GetUserChatBoostsRequest(
            chatId,
            userId,
        ).toJsonForRequest(),
        UserChatBoosts.serializer()
    )

    suspend fun getBusinessConnection(
        businessConnectionId: String,
    ) = telegramPost(
        "$basePath/getBusinessConnection",
        GetBusinessConnectionRequest(
            businessConnectionId,
        ).toJsonForRequest(),
        BusinessConnection.serializer()
    )

    suspend fun setMyCommands(
        commands: List<BotCommand>,
        scope: BotCommandScope? = null,
        languageCode: String? = null,
    ) = telegramPost(
        "$basePath/setMyCommands",
        SetMyCommandsRequest(
            commands,
            scope,
            languageCode,
        ).toJsonForRequest(),
        Boolean.serializer()
    )

    suspend fun deleteMyCommands(
        scope: BotCommandScope? = null,
        languageCode: String? = null,
    ) = telegramPost(
        "$basePath/deleteMyCommands",
        DeleteMyCommandsRequest(
            scope,
            languageCode,
        ).toJsonForRequest(),
        Boolean.serializer()
    )

    suspend fun getMyCommands(
        scope: BotCommandScope? = null,
        languageCode: String? = null,
    ) = telegramPost(
        "$basePath/getMyCommands",
        GetMyCommandsRequest(
            scope,
            languageCode,
        ).toJsonForRequest(),
        ListSerializer(BotCommand.serializer())
    )

    suspend fun setMyName(
        name: String? = null,
        languageCode: String? = null,
    ) = telegramPost(
        "$basePath/setMyName",
        SetMyNameRequest(
            name,
            languageCode,
        ).toJsonForRequest(),
        Boolean.serializer()
    )

    suspend fun getMyName(
        languageCode: String? = null,
    ) = telegramPost(
        "$basePath/getMyName",
        GetMyNameRequest(
            languageCode,
        ).toJsonForRequest(),
        BotName.serializer()
    )

    suspend fun setMyDescription(
        description: String? = null,
        languageCode: String? = null,
    ) = telegramPost(
        "$basePath/setMyDescription",
        SetMyDescriptionRequest(
            description,
            languageCode,
        ).toJsonForRequest(),
        Boolean.serializer()
    )

    suspend fun getMyDescription(
        languageCode: String? = null,
    ) = telegramPost(
        "$basePath/getMyDescription",
        GetMyDescriptionRequest(
            languageCode,
        ).toJsonForRequest(),
        BotDescription.serializer()
    )

    suspend fun setMyShortDescription(
        shortDescription: String? = null,
        languageCode: String? = null,
    ) = telegramPost(
        "$basePath/setMyShortDescription",
        SetMyShortDescriptionRequest(
            shortDescription,
            languageCode,
        ).toJsonForRequest(),
        Boolean.serializer()
    )

    suspend fun getMyShortDescription(
        languageCode: String? = null,
    ) = telegramPost(
        "$basePath/getMyShortDescription",
        GetMyShortDescriptionRequest(
            languageCode,
        ).toJsonForRequest(),
        BotShortDescription.serializer()
    )

    suspend fun setChatMenuButton(
        chatId: Long? = null,
        menuButton: MenuButton? = null,
    ) = telegramPost(
        "$basePath/setChatMenuButton",
        SetChatMenuButtonRequest(
            chatId,
            menuButton,
        ).toJsonForRequest(),
        Boolean.serializer()
    )

    suspend fun getChatMenuButton(
        chatId: Long? = null,
    ) = telegramPost(
        "$basePath/getChatMenuButton",
        GetChatMenuButtonRequest(
            chatId,
        ).toJsonForRequest(),
        MenuButton.serializer()
    )

    suspend fun setMyDefaultAdministratorRights(
        rights: ChatAdministratorRights? = null,
        forChannels: Boolean? = null,
    ) = telegramPost(
        "$basePath/setMyDefaultAdministratorRights",
        SetMyDefaultAdministratorRightsRequest(
            rights,
            forChannels,
        ).toJsonForRequest(),
        Boolean.serializer()
    )

    suspend fun getMyDefaultAdministratorRights(
        forChannels: Boolean? = null,
    ) = telegramPost(
        "$basePath/getMyDefaultAdministratorRights",
        GetMyDefaultAdministratorRightsRequest(
            forChannels,
        ).toJsonForRequest(),
        ChatAdministratorRights.serializer()
    )

    suspend fun editMessageText(
        text: String,
        chatId: String? = null,
        messageId: Long? = null,
        inlineMessageId: String? = null,
        parseMode: ParseMode? = null,
        entities: List<MessageEntity>? = null,
        linkPreviewOptions: LinkPreviewOptions? = null,
        replyMarkup: InlineKeyboardMarkup? = null,
    ) = telegramPost(
        "$basePath/editMessageText",
        EditMessageTextRequest(
            chatId,
            messageId,
            inlineMessageId,
            text,
            parseMode,
            entities,
            linkPreviewOptions,
            replyMarkup,
        ).toJsonForRequest(),
        Message.serializer()
    )

    suspend fun editMessageCaption(
        chatId: String? = null,
        messageId: Long? = null,
        inlineMessageId: String? = null,
        caption: String? = null,
        parseMode: ParseMode? = null,
        captionEntities: List<MessageEntity>? = null,
        showCaptionAboveMedia: Boolean? = null,
        replyMarkup: InlineKeyboardMarkup? = null,
    ) = telegramPost(
        "$basePath/editMessageCaption",
        EditMessageCaptionRequest(
            chatId,
            messageId,
            inlineMessageId,
            caption,
            parseMode,
            captionEntities,
            showCaptionAboveMedia,
            replyMarkup,
        ).toJsonForRequest(),
        Message.serializer()
    )

    suspend fun editMessageMedia(
        media: InputMedia,
        chatId: String? = null,
        messageId: Long? = null,
        inlineMessageId: String? = null,
        replyMarkup: InlineKeyboardMarkup? = null,
    ) = telegramPost(
        "$basePath/editMessageMedia",
        EditMessageMediaRequest(
            chatId,
            messageId,
            inlineMessageId,
            media,
            replyMarkup,
        ).toJsonForRequest(),
        Message.serializer()
    )

    suspend fun editMessageLiveLocation(
        latitude: Float,
        longitude: Float,
        chatId: String? = null,
        messageId: Long? = null,
        inlineMessageId: String? = null,
        livePeriod: Long? = null,
        horizontalAccuracy: Float? = null,
        heading: Long? = null,
        proximityAlertRadius: Long? = null,
        replyMarkup: InlineKeyboardMarkup? = null,
    ) = telegramPost(
        "$basePath/editMessageLiveLocation",
        EditMessageLiveLocationRequest(
            chatId,
            messageId,
            inlineMessageId,
            latitude,
            longitude,
            livePeriod,
            horizontalAccuracy,
            heading,
            proximityAlertRadius,
            replyMarkup,
        ).toJsonForRequest(),
        Message.serializer()
    )

    suspend fun stopMessageLiveLocation(
        chatId: String? = null,
        messageId: Long? = null,
        inlineMessageId: String? = null,
        replyMarkup: InlineKeyboardMarkup? = null,
    ) = telegramPost(
        "$basePath/stopMessageLiveLocation",
        StopMessageLiveLocationRequest(
            chatId,
            messageId,
            inlineMessageId,
            replyMarkup,
        ).toJsonForRequest(),
        Message.serializer()
    )

    suspend fun editMessageReplyMarkup(
        chatId: String? = null,
        messageId: Long? = null,
        inlineMessageId: String? = null,
        replyMarkup: InlineKeyboardMarkup? = null,
    ) = telegramPost(
        "$basePath/editMessageReplyMarkup",
        EditMessageReplyMarkupRequest(
            chatId,
            messageId,
            inlineMessageId,
            replyMarkup,
        ).toJsonForRequest(),
        Message.serializer()
    )

    suspend fun stopPoll(
        chatId: String,
        messageId: Long,
        replyMarkup: InlineKeyboardMarkup? = null,
    ) = telegramPost(
        "$basePath/stopPoll",
        StopPollRequest(
            chatId,
            messageId,
            replyMarkup,
        ).toJsonForRequest(),
        Poll.serializer()
    )

    suspend fun deleteMessage(
        chatId: String,
        messageId: Long,
    ) = telegramPost(
        "$basePath/deleteMessage",
        DeleteMessageRequest(
            chatId,
            messageId,
        ).toJsonForRequest(),
        Boolean.serializer()
    )

    suspend fun deleteMessages(
        chatId: String,
        messageIds: List<Long>,
    ) = telegramPost(
        "$basePath/deleteMessages",
        DeleteMessagesRequest(
            chatId,
            messageIds,
        ).toJsonForRequest(),
        Boolean.serializer()
    )

    suspend fun sendSticker(
        chatId: String,
        sticker: String,
        businessConnectionId: String? = null,
        messageThreadId: Long? = null,
        emoji: String? = null,
        disableNotification: Boolean? = null,
        protectContent: Boolean? = null,
        messageEffectId: String? = null,
        replyParameters: ReplyParameters? = null,
        replyMarkup: KeyboardOption? = null,
    ) = telegramPost(
        "$basePath/sendSticker",
        SendStickerRequest(
            businessConnectionId,
            chatId,
            messageThreadId,
            sticker,
            emoji,
            disableNotification,
            protectContent,
            messageEffectId,
            replyParameters,
            replyMarkup,
        ).toJsonForRequest(),
        Message.serializer()
    )

    suspend fun getStickerSet(
        name: String,
    ) = telegramPost(
        "$basePath/getStickerSet",
        GetStickerSetRequest(
            name,
        ).toJsonForRequest(),
        StickerSet.serializer()
    )

    suspend fun getCustomEmojiStickers(
        customEmojiIds: List<String>,
    ) = telegramPost(
        "$basePath/getCustomEmojiStickers",
        GetCustomEmojiStickersRequest(
            customEmojiIds,
        ).toJsonForRequest(),
        ListSerializer(Sticker.serializer())
    )

    suspend fun uploadStickerFile(
        userId: Long,
        sticker: Any,
        stickerFormat: String,
    ) = telegramPost(
        "$basePath/uploadStickerFile",
        UploadStickerFileRequest(
            userId,
            sticker,
            stickerFormat,
        ).toJsonForRequest(),
        File.serializer()
    )

    suspend fun createNewStickerSet(
        userId: Long,
        name: String,
        title: String,
        stickers: List<InputSticker>,
        stickerType: String? = null,
        needsRepainting: Boolean? = null,
    ) = telegramPost(
        "$basePath/createNewStickerSet",
        CreateNewStickerSetRequest(
            userId,
            name,
            title,
            stickers,
            stickerType,
            needsRepainting,
        ).toJsonForRequest(),
        Boolean.serializer()
    )

    suspend fun addStickerToSet(
        userId: Long,
        name: String,
        sticker: InputSticker,
    ) = telegramPost(
        "$basePath/addStickerToSet",
        AddStickerToSetRequest(
            userId,
            name,
            sticker,
        ).toJsonForRequest(),
        Boolean.serializer()
    )

    suspend fun setStickerPositionInSet(
        sticker: String,
        position: Long,
    ) = telegramPost(
        "$basePath/setStickerPositionInSet",
        SetStickerPositionInSetRequest(
            sticker,
            position,
        ).toJsonForRequest(),
        Boolean.serializer()
    )

    suspend fun deleteStickerFromSet(
        sticker: String,
    ) = telegramPost(
        "$basePath/deleteStickerFromSet",
        DeleteStickerFromSetRequest(
            sticker,
        ).toJsonForRequest(),
        Boolean.serializer()
    )

    suspend fun replaceStickerInSet(
        userId: Long,
        name: String,
        oldSticker: String,
        sticker: InputSticker,
    ) = telegramPost(
        "$basePath/replaceStickerInSet",
        ReplaceStickerInSetRequest(
            userId,
            name,
            oldSticker,
            sticker,
        ).toJsonForRequest(),
        Boolean.serializer()
    )

    suspend fun setStickerEmojiList(
        sticker: String,
        emojiList: List<String>,
    ) = telegramPost(
        "$basePath/setStickerEmojiList",
        SetStickerEmojiListRequest(
            sticker,
            emojiList,
        ).toJsonForRequest(),
        Boolean.serializer()
    )

    suspend fun setStickerKeywords(
        sticker: String,
        keywords: List<String>? = null,
    ) = telegramPost(
        "$basePath/setStickerKeywords",
        SetStickerKeywordsRequest(
            sticker,
            keywords,
        ).toJsonForRequest(),
        Boolean.serializer()
    )

    suspend fun setStickerMaskPosition(
        sticker: String,
        maskPosition: MaskPosition? = null,
    ) = telegramPost(
        "$basePath/setStickerMaskPosition",
        SetStickerMaskPositionRequest(
            sticker,
            maskPosition,
        ).toJsonForRequest(),
        Boolean.serializer()
    )

    suspend fun setStickerSetTitle(
        name: String,
        title: String,
    ) = telegramPost(
        "$basePath/setStickerSetTitle",
        SetStickerSetTitleRequest(
            name,
            title,
        ).toJsonForRequest(),
        Boolean.serializer()
    )

    suspend fun setStickerSetThumbnail(
        name: String,
        userId: Long,
        format: String,
        thumbnail: String? = null,
    ) = telegramPost(
        "$basePath/setStickerSetThumbnail",
        SetStickerSetThumbnailRequest(
            name,
            userId,
            thumbnail,
            format,
        ).toJsonForRequest(),
        Boolean.serializer()
    )

    suspend fun setCustomEmojiStickerSetThumbnail(
        name: String,
        customEmojiId: String? = null,
    ) = telegramPost(
        "$basePath/setCustomEmojiStickerSetThumbnail",
        SetCustomEmojiStickerSetThumbnailRequest(
            name,
            customEmojiId,
        ).toJsonForRequest(),
        Boolean.serializer()
    )

    suspend fun deleteStickerSet(
        name: String,
    ) = telegramPost(
        "$basePath/deleteStickerSet",
        DeleteStickerSetRequest(
            name,
        ).toJsonForRequest(),
        Boolean.serializer()
    )

    suspend fun answerInlineQuery(
        inlineQueryId: String,
        results: List<InlineQueryResult>,
        cacheTime: Long? = null,
        isPersonal: Boolean? = null,
        nextOffset: String? = null,
        button: InlineQueryResultsButton? = null,
    ) = telegramPost(
        "$basePath/answerInlineQuery",
        AnswerInlineQueryRequest(
            inlineQueryId,
            results,
            cacheTime,
            isPersonal,
            nextOffset,
            button,
        ).toJsonForRequest(),
        Boolean.serializer()
    )

    suspend fun answerWebAppQuery(
        webAppQueryId: String,
        result: InlineQueryResult,
    ) = telegramPost(
        "$basePath/answerWebAppQuery",
        AnswerWebAppQueryRequest(
            webAppQueryId,
            result,
        ).toJsonForRequest(),
        SentWebAppMessage.serializer()
    )

    suspend fun sendInvoice(
        chatId: String,
        title: String,
        description: String,
        payload: String,
        currency: String,
        prices: List<LabeledPrice>,
        messageThreadId: Long? = null,
        providerToken: String? = null,
        maxTipAmount: Long? = null,
        suggestedTipAmounts: List<Long>? = null,
        startParameter: String? = null,
        providerData: String? = null,
        photoUrl: String? = null,
        photoSize: Long? = null,
        photoWidth: Long? = null,
        photoHeight: Long? = null,
        needName: Boolean? = null,
        needPhoneNumber: Boolean? = null,
        needEmail: Boolean? = null,
        needShippingAddress: Boolean? = null,
        sendPhoneNumberToProvider: Boolean? = null,
        sendEmailToProvider: Boolean? = null,
        isFlexible: Boolean? = null,
        disableNotification: Boolean? = null,
        protectContent: Boolean? = null,
        messageEffectId: String? = null,
        replyParameters: ReplyParameters? = null,
        replyMarkup: InlineKeyboardMarkup? = null,
    ) = telegramPost(
        "$basePath/sendInvoice",
        SendInvoiceRequest(
            chatId,
            messageThreadId,
            title,
            description,
            payload,
            providerToken,
            currency,
            prices,
            maxTipAmount,
            suggestedTipAmounts,
            startParameter,
            providerData,
            photoUrl,
            photoSize,
            photoWidth,
            photoHeight,
            needName,
            needPhoneNumber,
            needEmail,
            needShippingAddress,
            sendPhoneNumberToProvider,
            sendEmailToProvider,
            isFlexible,
            disableNotification,
            protectContent,
            messageEffectId,
            replyParameters,
            replyMarkup,
        ).toJsonForRequest(),
        Message.serializer()
    )

    suspend fun createInvoiceLink(
        title: String,
        description: String,
        payload: String,
        currency: String,
        prices: List<LabeledPrice>,
        providerToken: String? = null,
        maxTipAmount: Long? = null,
        suggestedTipAmounts: List<Long>? = null,
        providerData: String? = null,
        photoUrl: String? = null,
        photoSize: Long? = null,
        photoWidth: Long? = null,
        photoHeight: Long? = null,
        needName: Boolean? = null,
        needPhoneNumber: Boolean? = null,
        needEmail: Boolean? = null,
        needShippingAddress: Boolean? = null,
        sendPhoneNumberToProvider: Boolean? = null,
        sendEmailToProvider: Boolean? = null,
        isFlexible: Boolean? = null,
    ) = telegramPost(
        "$basePath/createInvoiceLink",
        CreateInvoiceLinkRequest(
            title,
            description,
            payload,
            providerToken,
            currency,
            prices,
            maxTipAmount,
            suggestedTipAmounts,
            providerData,
            photoUrl,
            photoSize,
            photoWidth,
            photoHeight,
            needName,
            needPhoneNumber,
            needEmail,
            needShippingAddress,
            sendPhoneNumberToProvider,
            sendEmailToProvider,
            isFlexible,
        ).toJsonForRequest(),
        String.serializer()
    )

    suspend fun answerShippingQuery(
        shippingQueryId: String,
        ok: Boolean,
        shippingOptions: List<ShippingOption>? = null,
        errorMessage: String? = null,
    ) = telegramPost(
        "$basePath/answerShippingQuery",
        AnswerShippingQueryRequest(
            shippingQueryId,
            ok,
            shippingOptions,
            errorMessage,
        ).toJsonForRequest(),
        Boolean.serializer()
    )

    suspend fun answerPreCheckoutQuery(
        preCheckoutQueryId: String,
        ok: Boolean,
        errorMessage: String? = null,
    ) = telegramPost(
        "$basePath/answerPreCheckoutQuery",
        AnswerPreCheckoutQueryRequest(
            preCheckoutQueryId,
            ok,
            errorMessage,
        ).toJsonForRequest(),
        Boolean.serializer()
    )

    suspend fun refundStarPayment(
        userId: Long,
        telegramPaymentChargeId: String,
    ) = telegramPost(
        "$basePath/refundStarPayment",
        RefundStarPaymentRequest(
            userId,
            telegramPaymentChargeId,
        ).toJsonForRequest(),
        Boolean.serializer()
    )

    suspend fun setPassportDataErrors(
        userId: Long,
        errors: List<PassportElementError>,
    ) = telegramPost(
        "$basePath/setPassportDataErrors",
        SetPassportDataErrorsRequest(
            userId,
            errors,
        ).toJsonForRequest(),
        Boolean.serializer()
    )

    suspend fun sendGame(
        chatId: Long,
        gameShortName: String,
        businessConnectionId: String? = null,
        messageThreadId: Long? = null,
        disableNotification: Boolean? = null,
        protectContent: Boolean? = null,
        messageEffectId: String? = null,
        replyParameters: ReplyParameters? = null,
        replyMarkup: InlineKeyboardMarkup? = null,
    ) = telegramPost(
        "$basePath/sendGame",
        SendGameRequest(
            businessConnectionId,
            chatId,
            messageThreadId,
            gameShortName,
            disableNotification,
            protectContent,
            messageEffectId,
            replyParameters,
            replyMarkup,
        ).toJsonForRequest(),
        Message.serializer()
    )

    suspend fun setGameScore(
        userId: Long,
        score: Long,
        force: Boolean? = null,
        disableEditMessage: Boolean? = null,
        chatId: Long? = null,
        messageId: Long? = null,
        inlineMessageId: String? = null,
    ) = telegramPost(
        "$basePath/setGameScore",
        SetGameScoreRequest(
            userId,
            score,
            force,
            disableEditMessage,
            chatId,
            messageId,
            inlineMessageId,
        ).toJsonForRequest(),
        Message.serializer()
    )

    suspend fun getGameHighScores(
        userId: Long,
        chatId: Long? = null,
        messageId: Long? = null,
        inlineMessageId: String? = null,
    ) = telegramPost(
        "$basePath/getGameHighScores",
        GetGameHighScoresRequest(
            userId,
            chatId,
            messageId,
            inlineMessageId,
        ).toJsonForRequest(),
        ListSerializer(GameHighScore.serializer())
    )
}
