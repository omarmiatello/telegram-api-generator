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
    private val requestConfigurer: suspend HttpRequestBuilder.() -> Unit = {},
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

    // Getting updates

    /**
     * <p>Use this method to receive incoming updates using long polling (<a href="https://en.wikipedia.org/wiki/Push_technology#Long_polling">wiki</a>). Returns an Array of <a href="#update">Update</a> objects.</p><blockquote>
     *  <p><strong>Notes</strong><br><strong>1.</strong> This method will not work if an outgoing webhook is set up.<br><strong>2.</strong> In order to avoid getting duplicate updates, recalculate <em>offset</em> after each server response.</p>
     * </blockquote>
     *
     * @property offset Identifier of the first update to be returned. Must be greater by one than the highest among the identifiers of previously received updates. By default, updates starting with the earliest unconfirmed update are returned. An update is considered confirmed as soon as <a href="#getupdates">getUpdates</a> is called with an <em>offset</em> higher than its <em>update_id</em>. The negative offset can be specified to retrieve updates starting from <em>-offset</em> update from the end of the updates queue. All previous updates will be forgotten.
     * @property limit Limits the number of updates to be retrieved. Values between 1-100 are accepted. Defaults to 100.
     * @property timeout Timeout in seconds for long polling. Defaults to 0, i.e. usual short polling. Should be positive, short polling should be used for testing purposes only.
     * @property allowedUpdates A JSON-serialized list of the update types you want your bot to receive. For example, specify <code>["message", "edited_channel_post", "callback_query"]</code> to only receive updates of these types. See <a href="#update">Update</a> for a complete list of available update types. Specify an empty list to receive all update types except <em>chat_member</em>, <em>message_reaction</em>, and <em>message_reaction_count</em> (default). If not specified, the previous setting will be used.<br><br>Please note that this parameter doesn't affect updates created before the call to the getUpdates, so unwanted updates may be received for a short period of time.
     *
     * @return [List<Update>]
     * */
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

    /**
     * <p>Use this method to specify a URL and receive incoming updates via an outgoing webhook. Whenever there is an update for the bot, we will send an HTTPS POST request to the specified URL, containing a JSON-serialized <a href="#update">Update</a>. In case of an unsuccessful request, we will give up after a reasonable amount of attempts. Returns <em>True</em> on success.</p><p>If you'd like to make sure that the webhook was set by you, you can specify secret data in the parameter <em>secret_token</em>. If specified, the request will contain a header “X-Telegram-Bot-Api-Secret-Token” with the secret token as content.</p><blockquote>
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
     *
     * @return [Boolean]
     * */
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

    /**
     * <p>Use this method to remove webhook integration if you decide to switch back to <a href="#getupdates">getUpdates</a>. Returns <em>True</em> on success.</p>
     *
     * @property dropPendingUpdates Pass <em>True</em> to drop all pending updates
     *
     * @return [Boolean]
     * */
    suspend fun deleteWebhook(
        dropPendingUpdates: Boolean? = null,
    ) = telegramPost(
        "$basePath/deleteWebhook",
        DeleteWebhookRequest(
            dropPendingUpdates,
        ).toJsonForRequest(),
        Boolean.serializer()
    )

    /**
     * <p>Use this method to get current webhook status. Requires no parameters. On success, returns a <a href="#webhookinfo">WebhookInfo</a> object. If the bot is using <a href="#getupdates">getUpdates</a>, will return an object with the <em>url</em> field empty.</p>
     *
     *
     * @return [WebhookInfo]
     * */
    suspend fun getWebhookInfo() = telegramGet(
        "$basePath/getWebhookInfo",
        WebhookInfo.serializer(),
    )

    // Available methods

    /**
     * <p>Use this method to log out from the cloud Bot API server before launching the bot locally. You <strong>must</strong> log out the bot before running it locally, otherwise there is no guarantee that the bot will receive updates. After a successful call, you can immediately log in on a local server, but will not be able to log in back to the cloud Bot API server for 10 minutes. Returns <em>True</em> on success. Requires no parameters.</p>
     *
     *
     * @return [Boolean]
     * */
    suspend fun logOut() = telegramGet(
        "$basePath/logOut",
        Boolean.serializer(),
    )

    /**
     * <p>Use this method to close the bot instance before moving it from one local server to another. You need to delete the webhook before calling this method to ensure that the bot isn't launched again after server restart. The method will return error 429 in the first 10 minutes after the bot is launched. Returns <em>True</em> on success. Requires no parameters.</p>
     *
     *
     * @return [Boolean]
     * */
    suspend fun close() = telegramGet(
        "$basePath/close",
        Boolean.serializer(),
    )

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
     * @property messageEffectId Unique identifier of the message effect to be added to the message; for private chats only
     * @property replyParameters Description of the message to reply to
     * @property replyMarkup Additional interface options. A JSON-serialized object for an <a href="/bots/features#inline-keyboards">inline keyboard</a>, <a href="/bots/features#keyboards">custom reply keyboard</a>, instructions to remove a reply keyboard or to force a reply from the user
     *
     * @return [Message]
     * */
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
            chatId,
            text,
            businessConnectionId,
            messageThreadId,
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

    /**
     * <p>Use this method to forward messages of any kind. Service messages and messages with protected content can't be forwarded. On success, the sent <a href="#message">Message</a> is returned.</p>
     *
     * @property chatId Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>)
     * @property fromChatId Unique identifier for the chat where the original message was sent (or channel username in the format <code>@channelusername</code>)
     * @property messageId Message identifier in the chat specified in <em>from_chat_id</em>
     * @property messageThreadId Unique identifier for the target message thread (topic) of the forum; for forum supergroups only
     * @property disableNotification Sends the message <a href="https://telegram.org/blog/channels-2-0#silent-messages">silently</a>. Users will receive a notification with no sound.
     * @property protectContent Protects the contents of the forwarded message from forwarding and saving
     *
     * @return [Message]
     * */
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
            fromChatId,
            messageId,
            messageThreadId,
            disableNotification,
            protectContent,
        ).toJsonForRequest(),
        Message.serializer()
    )

    /**
     * <p>Use this method to forward multiple messages of any kind. If some of the specified messages can't be found or forwarded, they are skipped. Service messages and messages with protected content can't be forwarded. Album grouping is kept for forwarded messages. On success, an array of <a href="#messageid">MessageId</a> of the sent messages is returned.</p>
     *
     * @property chatId Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>)
     * @property fromChatId Unique identifier for the chat where the original messages were sent (or channel username in the format <code>@channelusername</code>)
     * @property messageIds A JSON-serialized list of 1-100 identifiers of messages in the chat <em>from_chat_id</em> to forward. The identifiers must be specified in a strictly increasing order.
     * @property messageThreadId Unique identifier for the target message thread (topic) of the forum; for forum supergroups only
     * @property disableNotification Sends the messages <a href="https://telegram.org/blog/channels-2-0#silent-messages">silently</a>. Users will receive a notification with no sound.
     * @property protectContent Protects the contents of the forwarded messages from forwarding and saving
     *
     * @return [List<MessageId>]
     * */
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
            fromChatId,
            messageIds,
            messageThreadId,
            disableNotification,
            protectContent,
        ).toJsonForRequest(),
        ListSerializer(MessageId.serializer())
    )

    /**
     * <p>Use this method to copy messages of any kind. Service messages, giveaway messages, giveaway winners messages, and invoice messages can't be copied. A quiz <a href="#poll">poll</a> can be copied only if the value of the field <em>correct_option_id</em> is known to the bot. The method is analogous to the method <a href="#forwardmessage">forwardMessage</a>, but the copied message doesn't have a link to the original message. Returns the <a href="#messageid">MessageId</a> of the sent message on success.</p>
     *
     * @property chatId Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>)
     * @property fromChatId Unique identifier for the chat where the original message was sent (or channel username in the format <code>@channelusername</code>)
     * @property messageId Message identifier in the chat specified in <em>from_chat_id</em>
     * @property messageThreadId Unique identifier for the target message thread (topic) of the forum; for forum supergroups only
     * @property caption New caption for media, 0-1024 characters after entities parsing. If not specified, the original caption is kept
     * @property parseMode Mode for parsing entities in the new caption. See <a href="#formatting-options">formatting options</a> for more details.
     * @property captionEntities A JSON-serialized list of special entities that appear in the new caption, which can be specified instead of <em>parse_mode</em>
     * @property showCaptionAboveMedia Pass <em>True</em>, if the caption must be shown above the message media. Ignored if a new caption isn't specified.
     * @property disableNotification Sends the message <a href="https://telegram.org/blog/channels-2-0#silent-messages">silently</a>. Users will receive a notification with no sound.
     * @property protectContent Protects the contents of the sent message from forwarding and saving
     * @property replyParameters Description of the message to reply to
     * @property replyMarkup Additional interface options. A JSON-serialized object for an <a href="/bots/features#inline-keyboards">inline keyboard</a>, <a href="/bots/features#keyboards">custom reply keyboard</a>, instructions to remove a reply keyboard or to force a reply from the user
     *
     * @return [MessageId]
     * */
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
            fromChatId,
            messageId,
            messageThreadId,
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

    /**
     * <p>Use this method to copy messages of any kind. If some of the specified messages can't be found or copied, they are skipped. Service messages, giveaway messages, giveaway winners messages, and invoice messages can't be copied. A quiz <a href="#poll">poll</a> can be copied only if the value of the field <em>correct_option_id</em> is known to the bot. The method is analogous to the method <a href="#forwardmessages">forwardMessages</a>, but the copied messages don't have a link to the original message. Album grouping is kept for copied messages. On success, an array of <a href="#messageid">MessageId</a> of the sent messages is returned.</p>
     *
     * @property chatId Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>)
     * @property fromChatId Unique identifier for the chat where the original messages were sent (or channel username in the format <code>@channelusername</code>)
     * @property messageIds A JSON-serialized list of 1-100 identifiers of messages in the chat <em>from_chat_id</em> to copy. The identifiers must be specified in a strictly increasing order.
     * @property messageThreadId Unique identifier for the target message thread (topic) of the forum; for forum supergroups only
     * @property disableNotification Sends the messages <a href="https://telegram.org/blog/channels-2-0#silent-messages">silently</a>. Users will receive a notification with no sound.
     * @property protectContent Protects the contents of the sent messages from forwarding and saving
     * @property removeCaption Pass <em>True</em> to copy the messages without their captions
     *
     * @return [List<MessageId>]
     * */
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
            fromChatId,
            messageIds,
            messageThreadId,
            disableNotification,
            protectContent,
            removeCaption,
        ).toJsonForRequest(),
        ListSerializer(MessageId.serializer())
    )

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
     * @property messageEffectId Unique identifier of the message effect to be added to the message; for private chats only
     * @property replyParameters Description of the message to reply to
     * @property replyMarkup Additional interface options. A JSON-serialized object for an <a href="/bots/features#inline-keyboards">inline keyboard</a>, <a href="/bots/features#keyboards">custom reply keyboard</a>, instructions to remove a reply keyboard or to force a reply from the user
     *
     * @return [Message]
     * */
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
            chatId,
            photo,
            businessConnectionId,
            messageThreadId,
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
     * @property messageEffectId Unique identifier of the message effect to be added to the message; for private chats only
     * @property replyParameters Description of the message to reply to
     * @property replyMarkup Additional interface options. A JSON-serialized object for an <a href="/bots/features#inline-keyboards">inline keyboard</a>, <a href="/bots/features#keyboards">custom reply keyboard</a>, instructions to remove a reply keyboard or to force a reply from the user
     *
     * @return [Message]
     * */
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
            chatId,
            audio,
            businessConnectionId,
            messageThreadId,
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
     * @property messageEffectId Unique identifier of the message effect to be added to the message; for private chats only
     * @property replyParameters Description of the message to reply to
     * @property replyMarkup Additional interface options. A JSON-serialized object for an <a href="/bots/features#inline-keyboards">inline keyboard</a>, <a href="/bots/features#keyboards">custom reply keyboard</a>, instructions to remove a reply keyboard or to force a reply from the user
     *
     * @return [Message]
     * */
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
            chatId,
            document,
            businessConnectionId,
            messageThreadId,
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
     * @property caption Video caption (may also be used when resending videos by <em>file_id</em>), 0-1024 characters after entities parsing
     * @property parseMode Mode for parsing entities in the video caption. See <a href="#formatting-options">formatting options</a> for more details.
     * @property captionEntities A JSON-serialized list of special entities that appear in the caption, which can be specified instead of <em>parse_mode</em>
     * @property showCaptionAboveMedia Pass <em>True</em>, if the caption must be shown above the message media
     * @property hasSpoiler Pass <em>True</em> if the video needs to be covered with a spoiler animation
     * @property supportsStreaming Pass <em>True</em> if the uploaded video is suitable for streaming
     * @property disableNotification Sends the message <a href="https://telegram.org/blog/channels-2-0#silent-messages">silently</a>. Users will receive a notification with no sound.
     * @property protectContent Protects the contents of the sent message from forwarding and saving
     * @property messageEffectId Unique identifier of the message effect to be added to the message; for private chats only
     * @property replyParameters Description of the message to reply to
     * @property replyMarkup Additional interface options. A JSON-serialized object for an <a href="/bots/features#inline-keyboards">inline keyboard</a>, <a href="/bots/features#keyboards">custom reply keyboard</a>, instructions to remove a reply keyboard or to force a reply from the user
     *
     * @return [Message]
     * */
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
            chatId,
            video,
            businessConnectionId,
            messageThreadId,
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
     * @property messageEffectId Unique identifier of the message effect to be added to the message; for private chats only
     * @property replyParameters Description of the message to reply to
     * @property replyMarkup Additional interface options. A JSON-serialized object for an <a href="/bots/features#inline-keyboards">inline keyboard</a>, <a href="/bots/features#keyboards">custom reply keyboard</a>, instructions to remove a reply keyboard or to force a reply from the user
     *
     * @return [Message]
     * */
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
            chatId,
            animation,
            businessConnectionId,
            messageThreadId,
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
     * @property messageEffectId Unique identifier of the message effect to be added to the message; for private chats only
     * @property replyParameters Description of the message to reply to
     * @property replyMarkup Additional interface options. A JSON-serialized object for an <a href="/bots/features#inline-keyboards">inline keyboard</a>, <a href="/bots/features#keyboards">custom reply keyboard</a>, instructions to remove a reply keyboard or to force a reply from the user
     *
     * @return [Message]
     * */
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
            chatId,
            voice,
            businessConnectionId,
            messageThreadId,
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
     * @property messageEffectId Unique identifier of the message effect to be added to the message; for private chats only
     * @property replyParameters Description of the message to reply to
     * @property replyMarkup Additional interface options. A JSON-serialized object for an <a href="/bots/features#inline-keyboards">inline keyboard</a>, <a href="/bots/features#keyboards">custom reply keyboard</a>, instructions to remove a reply keyboard or to force a reply from the user
     *
     * @return [Message]
     * */
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
            chatId,
            videoNote,
            businessConnectionId,
            messageThreadId,
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

    /**
     * <p>Use this method to send a group of photos, videos, documents or audios as an album. Documents and audio files can be only grouped in an album with messages of the same type. On success, an array of <a href="#message">Messages</a> that were sent is returned.</p>
     *
     * @property chatId Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>)
     * @property media A JSON-serialized array describing messages to be sent, must include 2-10 items
     * @property businessConnectionId Unique identifier of the business connection on behalf of which the message will be sent
     * @property messageThreadId Unique identifier for the target message thread (topic) of the forum; for forum supergroups only
     * @property disableNotification Sends messages <a href="https://telegram.org/blog/channels-2-0#silent-messages">silently</a>. Users will receive a notification with no sound.
     * @property protectContent Protects the contents of the sent messages from forwarding and saving
     * @property messageEffectId Unique identifier of the message effect to be added to the message; for private chats only
     * @property replyParameters Description of the message to reply to
     *
     * @return [List<Message>]
     * */
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
            chatId,
            media,
            businessConnectionId,
            messageThreadId,
            disableNotification,
            protectContent,
            messageEffectId,
            replyParameters,
        ).toJsonForRequest(),
        ListSerializer(Message.serializer())
    )

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
     * @property messageEffectId Unique identifier of the message effect to be added to the message; for private chats only
     * @property replyParameters Description of the message to reply to
     * @property replyMarkup Additional interface options. A JSON-serialized object for an <a href="/bots/features#inline-keyboards">inline keyboard</a>, <a href="/bots/features#keyboards">custom reply keyboard</a>, instructions to remove a reply keyboard or to force a reply from the user
     *
     * @return [Message]
     * */
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
            chatId,
            latitude,
            longitude,
            businessConnectionId,
            messageThreadId,
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
     * @property messageEffectId Unique identifier of the message effect to be added to the message; for private chats only
     * @property replyParameters Description of the message to reply to
     * @property replyMarkup Additional interface options. A JSON-serialized object for an <a href="/bots/features#inline-keyboards">inline keyboard</a>, <a href="/bots/features#keyboards">custom reply keyboard</a>, instructions to remove a reply keyboard or to force a reply from the user
     *
     * @return [Message]
     * */
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
            chatId,
            latitude,
            longitude,
            title,
            address,
            businessConnectionId,
            messageThreadId,
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
     * @property messageEffectId Unique identifier of the message effect to be added to the message; for private chats only
     * @property replyParameters Description of the message to reply to
     * @property replyMarkup Additional interface options. A JSON-serialized object for an <a href="/bots/features#inline-keyboards">inline keyboard</a>, <a href="/bots/features#keyboards">custom reply keyboard</a>, instructions to remove a reply keyboard or to force a reply from the user
     *
     * @return [Message]
     * */
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
            chatId,
            phoneNumber,
            firstName,
            businessConnectionId,
            messageThreadId,
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

    /**
     * <p>Use this method to send a native poll. On success, the sent <a href="#message">Message</a> is returned.</p>
     *
     * @property chatId Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>)
     * @property question Poll question, 1-300 characters
     * @property options A JSON-serialized list of 2-10 answer options
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
     * @property messageEffectId Unique identifier of the message effect to be added to the message; for private chats only
     * @property replyParameters Description of the message to reply to
     * @property replyMarkup Additional interface options. A JSON-serialized object for an <a href="/bots/features#inline-keyboards">inline keyboard</a>, <a href="/bots/features#keyboards">custom reply keyboard</a>, instructions to remove a reply keyboard or to force a reply from the user
     *
     * @return [Message]
     * */
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
            chatId,
            question,
            options,
            businessConnectionId,
            messageThreadId,
            questionParseMode,
            questionEntities,
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

    /**
     * <p>Use this method to send an animated emoji that will display a random value. On success, the sent <a href="#message">Message</a> is returned.</p>
     *
     * @property chatId Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>)
     * @property businessConnectionId Unique identifier of the business connection on behalf of which the message will be sent
     * @property messageThreadId Unique identifier for the target message thread (topic) of the forum; for forum supergroups only
     * @property emoji Emoji on which the dice throw animation is based. Currently, must be one of “<img class="emoji" src="//telegram.org/img/emoji/40/F09F8EB2.png" width="20" height="20" alt="🎲">”, “<img class="emoji" src="//telegram.org/img/emoji/40/F09F8EAF.png" width="20" height="20" alt="🎯">”, “<img class="emoji" src="//telegram.org/img/emoji/40/F09F8F80.png" width="20" height="20" alt="🏀">”, “<img class="emoji" src="//telegram.org/img/emoji/40/E29ABD.png" width="20" height="20" alt="⚽">”, “<img class="emoji" src="//telegram.org/img/emoji/40/F09F8EB3.png" width="20" height="20" alt="🎳">”, or “<img class="emoji" src="//telegram.org/img/emoji/40/F09F8EB0.png" width="20" height="20" alt="🎰">”. Dice can have values 1-6 for “<img class="emoji" src="//telegram.org/img/emoji/40/F09F8EB2.png" width="20" height="20" alt="🎲">”, “<img class="emoji" src="//telegram.org/img/emoji/40/F09F8EAF.png" width="20" height="20" alt="🎯">” and “<img class="emoji" src="//telegram.org/img/emoji/40/F09F8EB3.png" width="20" height="20" alt="🎳">”, values 1-5 for “<img class="emoji" src="//telegram.org/img/emoji/40/F09F8F80.png" width="20" height="20" alt="🏀">” and “<img class="emoji" src="//telegram.org/img/emoji/40/E29ABD.png" width="20" height="20" alt="⚽">”, and values 1-64 for “<img class="emoji" src="//telegram.org/img/emoji/40/F09F8EB0.png" width="20" height="20" alt="🎰">”. Defaults to “<img class="emoji" src="//telegram.org/img/emoji/40/F09F8EB2.png" width="20" height="20" alt="🎲">”
     * @property disableNotification Sends the message <a href="https://telegram.org/blog/channels-2-0#silent-messages">silently</a>. Users will receive a notification with no sound.
     * @property protectContent Protects the contents of the sent message from forwarding
     * @property messageEffectId Unique identifier of the message effect to be added to the message; for private chats only
     * @property replyParameters Description of the message to reply to
     * @property replyMarkup Additional interface options. A JSON-serialized object for an <a href="/bots/features#inline-keyboards">inline keyboard</a>, <a href="/bots/features#keyboards">custom reply keyboard</a>, instructions to remove a reply keyboard or to force a reply from the user
     *
     * @return [Message]
     * */
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
            chatId,
            businessConnectionId,
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

    /**
     * <p>Use this method when you need to tell the user that something is happening on the bot's side. The status is set for 5 seconds or less (when a message arrives from your bot, Telegram clients clear its typing status). Returns <em>True</em> on success.</p><blockquote>
     *  <p>Example: The <a href="https://t.me/imagebot">ImageBot</a> needs some time to process a request and upload the image. Instead of sending a text message along the lines of “Retrieving image, please wait…”, the bot may use <a href="#sendchataction">sendChatAction</a> with <em>action</em> = <em>upload_photo</em>. The user will see a “sending photo” status for the bot.</p>
     * </blockquote><p>We only recommend using this method when a response from the bot will take a <strong>noticeable</strong> amount of time to arrive.</p>
     *
     * @property chatId Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>)
     * @property action Type of action to broadcast. Choose one, depending on what the user is about to receive: <em>typing</em> for <a href="#sendmessage">text messages</a>, <em>upload_photo</em> for <a href="#sendphoto">photos</a>, <em>record_video</em> or <em>upload_video</em> for <a href="#sendvideo">videos</a>, <em>record_voice</em> or <em>upload_voice</em> for <a href="#sendvoice">voice notes</a>, <em>upload_document</em> for <a href="#senddocument">general files</a>, <em>choose_sticker</em> for <a href="#sendsticker">stickers</a>, <em>find_location</em> for <a href="#sendlocation">location data</a>, <em>record_video_note</em> or <em>upload_video_note</em> for <a href="#sendvideonote">video notes</a>.
     * @property businessConnectionId Unique identifier of the business connection on behalf of which the action will be sent
     * @property messageThreadId Unique identifier for the target message thread; for supergroups only
     *
     * @return [Boolean]
     * */
    suspend fun sendChatAction(
        chatId: String,
        action: String,
        businessConnectionId: String? = null,
        messageThreadId: Long? = null,
    ) = telegramPost(
        "$basePath/sendChatAction",
        SendChatActionRequest(
            chatId,
            action,
            businessConnectionId,
            messageThreadId,
        ).toJsonForRequest(),
        Boolean.serializer()
    )

    /**
     * <p>Use this method to change the chosen reactions on a message. Service messages can't be reacted to. Automatically forwarded messages from a channel to its discussion group have the same available reactions as messages in the channel. Returns <em>True</em> on success.</p>
     *
     * @property chatId Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>)
     * @property messageId Identifier of the target message. If the message belongs to a media group, the reaction is set to the first non-deleted message in the group instead.
     * @property reaction A JSON-serialized list of reaction types to set on the message. Currently, as non-premium users, bots can set up to one reaction per message. A custom emoji reaction can be used if it is either already present on the message or explicitly allowed by chat administrators.
     * @property isBig Pass <em>True</em> to set the reaction with a big animation
     *
     * @return [Boolean]
     * */
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

    /**
     * <p>Use this method to get a list of profile pictures for a user. Returns a <a href="#userprofilephotos">UserProfilePhotos</a> object.</p>
     *
     * @property userId Unique identifier of the target user
     * @property offset Sequential number of the first photo to be returned. By default, all photos are returned.
     * @property limit Limits the number of photos to be retrieved. Values between 1-100 are accepted. Defaults to 100.
     *
     * @return [UserProfilePhotos]
     * */
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

    /**
     * <p>Use this method to get basic information about a file and prepare it for downloading. For the moment, bots can download files of up to 20MB in size. On success, a <a href="#file">File</a> object is returned. The file can then be downloaded via the link <code>https://api.telegram.org/file/bot&lt;token&gt;/&lt;file_path&gt;</code>, where <code>&lt;file_path&gt;</code> is taken from the response. It is guaranteed that the link will be valid for at least 1 hour. When the link expires, a new one can be requested by calling <a href="#getfile">getFile</a> again.</p><p><strong>Note:</strong> This function may not preserve the original file name and MIME type. You should save the file's MIME type and name (if available) when the File object is received.</p>
     *
     * @property fileId File identifier to get information about
     *
     * @return [File]
     * */
    suspend fun getFile(
        fileId: String,
    ) = telegramPost(
        "$basePath/getFile",
        GetFileRequest(
            fileId,
        ).toJsonForRequest(),
        File.serializer()
    )

    /**
     * <p>Use this method to ban a user in a group, a supergroup or a channel. In the case of supergroups and channels, the user will not be able to return to the chat on their own using invite links, etc., unless <a href="#unbanchatmember">unbanned</a> first. The bot must be an administrator in the chat for this to work and must have the appropriate administrator rights. Returns <em>True</em> on success.</p>
     *
     * @property chatId Unique identifier for the target group or username of the target supergroup or channel (in the format <code>@channelusername</code>)
     * @property userId Unique identifier of the target user
     * @property untilDate Date when the user will be unbanned; Unix time. If user is banned for more than 366 days or less than 30 seconds from the current time they are considered to be banned forever. Applied for supergroups and channels only.
     * @property revokeMessages Pass <em>True</em> to delete all messages from the chat for the user that is being removed. If <em>False</em>, the user will be able to see messages in the group that were sent before the user was removed. Always <em>True</em> for supergroups and channels.
     *
     * @return [Boolean]
     * */
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

    /**
     * <p>Use this method to unban a previously banned user in a supergroup or channel. The user will <strong>not</strong> return to the group or channel automatically, but will be able to join via link, etc. The bot must be an administrator for this to work. By default, this method guarantees that after the call the user is not a member of the chat, but will be able to join it. So if the user is a member of the chat they will also be <strong>removed</strong> from the chat. If you don't want this, use the parameter <em>only_if_banned</em>. Returns <em>True</em> on success.</p>
     *
     * @property chatId Unique identifier for the target group or username of the target supergroup or channel (in the format <code>@channelusername</code>)
     * @property userId Unique identifier of the target user
     * @property onlyIfBanned Do nothing if the user is not banned
     *
     * @return [Boolean]
     * */
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

    /**
     * <p>Use this method to restrict a user in a supergroup. The bot must be an administrator in the supergroup for this to work and must have the appropriate administrator rights. Pass <em>True</em> for all permissions to lift restrictions from a user. Returns <em>True</em> on success.</p>
     *
     * @property chatId Unique identifier for the target chat or username of the target supergroup (in the format <code>@supergroupusername</code>)
     * @property userId Unique identifier of the target user
     * @property permissions A JSON-serialized object for new user permissions
     * @property useIndependentChatPermissions Pass <em>True</em> if chat permissions are set independently. Otherwise, the <em>can_send_other_messages</em> and <em>can_add_web_page_previews</em> permissions will imply the <em>can_send_messages</em>, <em>can_send_audios</em>, <em>can_send_documents</em>, <em>can_send_photos</em>, <em>can_send_videos</em>, <em>can_send_video_notes</em>, and <em>can_send_voice_notes</em> permissions; the <em>can_send_polls</em> permission will imply the <em>can_send_messages</em> permission.
     * @property untilDate Date when restrictions will be lifted for the user; Unix time. If user is restricted for more than 366 days or less than 30 seconds from the current time, they are considered to be restricted forever
     *
     * @return [Boolean]
     * */
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

    /**
     * <p>Use this method to promote or demote a user in a supergroup or a channel. The bot must be an administrator in the chat for this to work and must have the appropriate administrator rights. Pass <em>False</em> for all boolean parameters to demote a user. Returns <em>True</em> on success.</p>
     *
     * @property chatId Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>)
     * @property userId Unique identifier of the target user
     * @property isAnonymous Pass <em>True</em> if the administrator's presence in the chat is hidden
     * @property canManageChat Pass <em>True</em> if the administrator can access the chat event log, get boost list, see hidden supergroup and channel members, report spam messages and ignore slow mode. Implied by any other administrator privilege.
     * @property canDeleteMessages Pass <em>True</em> if the administrator can delete messages of other users
     * @property canManageVideoChats Pass <em>True</em> if the administrator can manage video chats
     * @property canRestrictMembers Pass <em>True</em> if the administrator can restrict, ban or unban chat members, or access supergroup statistics
     * @property canPromoteMembers Pass <em>True</em> if the administrator can add new administrators with a subset of their own privileges or demote administrators that they have promoted, directly or indirectly (promoted by administrators that were appointed by him)
     * @property canChangeInfo Pass <em>True</em> if the administrator can change chat title, photo and other settings
     * @property canInviteUsers Pass <em>True</em> if the administrator can invite new users to the chat
     * @property canPostStories Pass <em>True</em> if the administrator can post stories to the chat
     * @property canEditStories Pass <em>True</em> if the administrator can edit stories posted by other users, post stories to the chat page, pin chat stories, and access the chat's story archive
     * @property canDeleteStories Pass <em>True</em> if the administrator can delete stories posted by other users
     * @property canPostMessages Pass <em>True</em> if the administrator can post messages in the channel, or access channel statistics; for channels only
     * @property canEditMessages Pass <em>True</em> if the administrator can edit messages of other users and can pin messages; for channels only
     * @property canPinMessages Pass <em>True</em> if the administrator can pin messages; for supergroups only
     * @property canManageTopics Pass <em>True</em> if the user is allowed to create, rename, close, and reopen forum topics; for supergroups only
     *
     * @return [Boolean]
     * */
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

    /**
     * <p>Use this method to set a custom title for an administrator in a supergroup promoted by the bot. Returns <em>True</em> on success.</p>
     *
     * @property chatId Unique identifier for the target chat or username of the target supergroup (in the format <code>@supergroupusername</code>)
     * @property userId Unique identifier of the target user
     * @property customTitle New custom title for the administrator; 0-16 characters, emoji are not allowed
     *
     * @return [Boolean]
     * */
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

    /**
     * <p>Use this method to ban a channel chat in a supergroup or a channel. Until the chat is <a href="#unbanchatsenderchat">unbanned</a>, the owner of the banned chat won't be able to send messages on behalf of <strong>any of their channels</strong>. The bot must be an administrator in the supergroup or channel for this to work and must have the appropriate administrator rights. Returns <em>True</em> on success.</p>
     *
     * @property chatId Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>)
     * @property senderChatId Unique identifier of the target sender chat
     *
     * @return [Boolean]
     * */
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

    /**
     * <p>Use this method to unban a previously banned channel chat in a supergroup or channel. The bot must be an administrator for this to work and must have the appropriate administrator rights. Returns <em>True</em> on success.</p>
     *
     * @property chatId Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>)
     * @property senderChatId Unique identifier of the target sender chat
     *
     * @return [Boolean]
     * */
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

    /**
     * <p>Use this method to set default chat permissions for all members. The bot must be an administrator in the group or a supergroup for this to work and must have the <em>can_restrict_members</em> administrator rights. Returns <em>True</em> on success.</p>
     *
     * @property chatId Unique identifier for the target chat or username of the target supergroup (in the format <code>@supergroupusername</code>)
     * @property permissions A JSON-serialized object for new default chat permissions
     * @property useIndependentChatPermissions Pass <em>True</em> if chat permissions are set independently. Otherwise, the <em>can_send_other_messages</em> and <em>can_add_web_page_previews</em> permissions will imply the <em>can_send_messages</em>, <em>can_send_audios</em>, <em>can_send_documents</em>, <em>can_send_photos</em>, <em>can_send_videos</em>, <em>can_send_video_notes</em>, and <em>can_send_voice_notes</em> permissions; the <em>can_send_polls</em> permission will imply the <em>can_send_messages</em> permission.
     *
     * @return [Boolean]
     * */
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

    /**
     * <p>Use this method to generate a new primary invite link for a chat; any previously generated primary link is revoked. The bot must be an administrator in the chat for this to work and must have the appropriate administrator rights. Returns the new invite link as <em>String</em> on success.</p><blockquote>
     *  <p>Note: Each administrator in a chat generates their own invite links. Bots can't use invite links generated by other administrators. If you want your bot to work with invite links, it will need to generate its own link using <a href="#exportchatinvitelink">exportChatInviteLink</a> or by calling the <a href="#getchat">getChat</a> method. If your bot needs to generate a new primary invite link replacing its previous one, use <a href="#exportchatinvitelink">exportChatInviteLink</a> again.</p>
     * </blockquote>
     *
     * @property chatId Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>)
     *
     * @return [String]
     * */
    suspend fun exportChatInviteLink(
        chatId: String,
    ) = telegramPost(
        "$basePath/exportChatInviteLink",
        ExportChatInviteLinkRequest(
            chatId,
        ).toJsonForRequest(),
        String.serializer()
    )

    /**
     * <p>Use this method to create an additional invite link for a chat. The bot must be an administrator in the chat for this to work and must have the appropriate administrator rights. The link can be revoked using the method <a href="#revokechatinvitelink">revokeChatInviteLink</a>. Returns the new invite link as <a href="#chatinvitelink">ChatInviteLink</a> object.</p>
     *
     * @property chatId Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>)
     * @property name Invite link name; 0-32 characters
     * @property expireDate Point in time (Unix timestamp) when the link will expire
     * @property memberLimit The maximum number of users that can be members of the chat simultaneously after joining the chat via this invite link; 1-99999
     * @property createsJoinRequest <em>True</em>, if users joining the chat via the link need to be approved by chat administrators. If <em>True</em>, <em>member_limit</em> can't be specified
     *
     * @return [ChatInviteLink]
     * */
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

    /**
     * <p>Use this method to edit a non-primary invite link created by the bot. The bot must be an administrator in the chat for this to work and must have the appropriate administrator rights. Returns the edited invite link as a <a href="#chatinvitelink">ChatInviteLink</a> object.</p>
     *
     * @property chatId Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>)
     * @property inviteLink The invite link to edit
     * @property name Invite link name; 0-32 characters
     * @property expireDate Point in time (Unix timestamp) when the link will expire
     * @property memberLimit The maximum number of users that can be members of the chat simultaneously after joining the chat via this invite link; 1-99999
     * @property createsJoinRequest <em>True</em>, if users joining the chat via the link need to be approved by chat administrators. If <em>True</em>, <em>member_limit</em> can't be specified
     *
     * @return [ChatInviteLink]
     * */
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

    /**
     * <p>Use this method to revoke an invite link created by the bot. If the primary link is revoked, a new link is automatically generated. The bot must be an administrator in the chat for this to work and must have the appropriate administrator rights. Returns the revoked invite link as <a href="#chatinvitelink">ChatInviteLink</a> object.</p>
     *
     * @property chatId Unique identifier of the target chat or username of the target channel (in the format <code>@channelusername</code>)
     * @property inviteLink The invite link to revoke
     *
     * @return [ChatInviteLink]
     * */
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

    /**
     * <p>Use this method to approve a chat join request. The bot must be an administrator in the chat for this to work and must have the <em>can_invite_users</em> administrator right. Returns <em>True</em> on success.</p>
     *
     * @property chatId Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>)
     * @property userId Unique identifier of the target user
     *
     * @return [Boolean]
     * */
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

    /**
     * <p>Use this method to decline a chat join request. The bot must be an administrator in the chat for this to work and must have the <em>can_invite_users</em> administrator right. Returns <em>True</em> on success.</p>
     *
     * @property chatId Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>)
     * @property userId Unique identifier of the target user
     *
     * @return [Boolean]
     * */
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

    /**
     * <p>Use this method to set a new profile photo for the chat. Photos can't be changed for private chats. The bot must be an administrator in the chat for this to work and must have the appropriate administrator rights. Returns <em>True</em> on success.</p>
     *
     * @property chatId Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>)
     * @property photo New chat photo, uploaded using multipart/form-data
     *
     * @return [Boolean]
     * */
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

    /**
     * <p>Use this method to delete a chat photo. Photos can't be changed for private chats. The bot must be an administrator in the chat for this to work and must have the appropriate administrator rights. Returns <em>True</em> on success.</p>
     *
     * @property chatId Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>)
     *
     * @return [Boolean]
     * */
    suspend fun deleteChatPhoto(
        chatId: String,
    ) = telegramPost(
        "$basePath/deleteChatPhoto",
        DeleteChatPhotoRequest(
            chatId,
        ).toJsonForRequest(),
        Boolean.serializer()
    )

    /**
     * <p>Use this method to change the title of a chat. Titles can't be changed for private chats. The bot must be an administrator in the chat for this to work and must have the appropriate administrator rights. Returns <em>True</em> on success.</p>
     *
     * @property chatId Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>)
     * @property title New chat title, 1-128 characters
     *
     * @return [Boolean]
     * */
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

    /**
     * <p>Use this method to change the description of a group, a supergroup or a channel. The bot must be an administrator in the chat for this to work and must have the appropriate administrator rights. Returns <em>True</em> on success.</p>
     *
     * @property chatId Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>)
     * @property description New chat description, 0-255 characters
     *
     * @return [Boolean]
     * */
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

    /**
     * <p>Use this method to add a message to the list of pinned messages in a chat. If the chat is not a private chat, the bot must be an administrator in the chat for this to work and must have the 'can_pin_messages' administrator right in a supergroup or 'can_edit_messages' administrator right in a channel. Returns <em>True</em> on success.</p>
     *
     * @property chatId Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>)
     * @property messageId Identifier of a message to pin
     * @property disableNotification Pass <em>True</em> if it is not necessary to send a notification to all chat members about the new pinned message. Notifications are always disabled in channels and private chats.
     *
     * @return [Boolean]
     * */
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

    /**
     * <p>Use this method to remove a message from the list of pinned messages in a chat. If the chat is not a private chat, the bot must be an administrator in the chat for this to work and must have the 'can_pin_messages' administrator right in a supergroup or 'can_edit_messages' administrator right in a channel. Returns <em>True</em> on success.</p>
     *
     * @property chatId Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>)
     * @property messageId Identifier of a message to unpin. If not specified, the most recent pinned message (by sending date) will be unpinned.
     *
     * @return [Boolean]
     * */
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

    /**
     * <p>Use this method to clear the list of pinned messages in a chat. If the chat is not a private chat, the bot must be an administrator in the chat for this to work and must have the 'can_pin_messages' administrator right in a supergroup or 'can_edit_messages' administrator right in a channel. Returns <em>True</em> on success.</p>
     *
     * @property chatId Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>)
     *
     * @return [Boolean]
     * */
    suspend fun unpinAllChatMessages(
        chatId: String,
    ) = telegramPost(
        "$basePath/unpinAllChatMessages",
        UnpinAllChatMessagesRequest(
            chatId,
        ).toJsonForRequest(),
        Boolean.serializer()
    )

    /**
     * <p>Use this method for your bot to leave a group, supergroup or channel. Returns <em>True</em> on success.</p>
     *
     * @property chatId Unique identifier for the target chat or username of the target supergroup or channel (in the format <code>@channelusername</code>)
     *
     * @return [Boolean]
     * */
    suspend fun leaveChat(
        chatId: String,
    ) = telegramPost(
        "$basePath/leaveChat",
        LeaveChatRequest(
            chatId,
        ).toJsonForRequest(),
        Boolean.serializer()
    )

    /**
     * <p>Use this method to get up-to-date information about the chat. Returns a <a href="#chatfullinfo">ChatFullInfo</a> object on success.</p>
     *
     * @property chatId Unique identifier for the target chat or username of the target supergroup or channel (in the format <code>@channelusername</code>)
     *
     * @return [ChatFullInfo]
     * */
    suspend fun getChat(
        chatId: String,
    ) = telegramPost(
        "$basePath/getChat",
        GetChatRequest(
            chatId,
        ).toJsonForRequest(),
        ChatFullInfo.serializer()
    )

    /**
     * <p>Use this method to get a list of administrators in a chat, which aren't bots. Returns an Array of <a href="#chatmember">ChatMember</a> objects.</p>
     *
     * @property chatId Unique identifier for the target chat or username of the target supergroup or channel (in the format <code>@channelusername</code>)
     *
     * @return [List<ChatMember>]
     * */
    suspend fun getChatAdministrators(
        chatId: String,
    ) = telegramPost(
        "$basePath/getChatAdministrators",
        GetChatAdministratorsRequest(
            chatId,
        ).toJsonForRequest(),
        ListSerializer(ChatMember.serializer())
    )

    /**
     * <p>Use this method to get the number of members in a chat. Returns <em>Int</em> on success.</p>
     *
     * @property chatId Unique identifier for the target chat or username of the target supergroup or channel (in the format <code>@channelusername</code>)
     *
     * @return [Int]
     * */
    suspend fun getChatMemberCount(
        chatId: String,
    ) = telegramPost(
        "$basePath/getChatMemberCount",
        GetChatMemberCountRequest(
            chatId,
        ).toJsonForRequest(),
        Int.serializer()
    )

    /**
     * <p>Use this method to get information about a member of a chat. The method is only guaranteed to work for other users if the bot is an administrator in the chat. Returns a <a href="#chatmember">ChatMember</a> object on success.</p>
     *
     * @property chatId Unique identifier for the target chat or username of the target supergroup or channel (in the format <code>@channelusername</code>)
     * @property userId Unique identifier of the target user
     *
     * @return [ChatMember]
     * */
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

    /**
     * <p>Use this method to set a new group sticker set for a supergroup. The bot must be an administrator in the chat for this to work and must have the appropriate administrator rights. Use the field <em>can_set_sticker_set</em> optionally returned in <a href="#getchat">getChat</a> requests to check if the bot can use this method. Returns <em>True</em> on success.</p>
     *
     * @property chatId Unique identifier for the target chat or username of the target supergroup (in the format <code>@supergroupusername</code>)
     * @property stickerSetName Name of the sticker set to be set as the group sticker set
     *
     * @return [Boolean]
     * */
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

    /**
     * <p>Use this method to delete a group sticker set from a supergroup. The bot must be an administrator in the chat for this to work and must have the appropriate administrator rights. Use the field <em>can_set_sticker_set</em> optionally returned in <a href="#getchat">getChat</a> requests to check if the bot can use this method. Returns <em>True</em> on success.</p>
     *
     * @property chatId Unique identifier for the target chat or username of the target supergroup (in the format <code>@supergroupusername</code>)
     *
     * @return [Boolean]
     * */
    suspend fun deleteChatStickerSet(
        chatId: String,
    ) = telegramPost(
        "$basePath/deleteChatStickerSet",
        DeleteChatStickerSetRequest(
            chatId,
        ).toJsonForRequest(),
        Boolean.serializer()
    )

    /**
     * <p>Use this method to get custom emoji stickers, which can be used as a forum topic icon by any user. Requires no parameters. Returns an Array of <a href="#sticker">Sticker</a> objects.</p>
     *
     *
     * @return [List<Sticker>]
     * */
    suspend fun getForumTopicIconStickers() = telegramGet(
        "$basePath/getForumTopicIconStickers",
        ListSerializer(Sticker.serializer()),
    )

    /**
     * <p>Use this method to create a topic in a forum supergroup chat. The bot must be an administrator in the chat for this to work and must have the <em>can_manage_topics</em> administrator rights. Returns information about the created topic as a <a href="#forumtopic">ForumTopic</a> object.</p>
     *
     * @property chatId Unique identifier for the target chat or username of the target supergroup (in the format <code>@supergroupusername</code>)
     * @property name Topic name, 1-128 characters
     * @property iconColor Color of the topic icon in RGB format. Currently, must be one of 7322096 (0x6FB9F0), 16766590 (0xFFD67E), 13338331 (0xCB86DB), 9367192 (0x8EEE98), 16749490 (0xFF93B2), or 16478047 (0xFB6F5F)
     * @property iconCustomEmojiId Unique identifier of the custom emoji shown as the topic icon. Use <a href="#getforumtopiciconstickers">getForumTopicIconStickers</a> to get all allowed custom emoji identifiers.
     *
     * @return [ForumTopic]
     * */
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

    /**
     * <p>Use this method to edit name and icon of a topic in a forum supergroup chat. The bot must be an administrator in the chat for this to work and must have <em>can_manage_topics</em> administrator rights, unless it is the creator of the topic. Returns <em>True</em> on success.</p>
     *
     * @property chatId Unique identifier for the target chat or username of the target supergroup (in the format <code>@supergroupusername</code>)
     * @property messageThreadId Unique identifier for the target message thread of the forum topic
     * @property name New topic name, 0-128 characters. If not specified or empty, the current name of the topic will be kept
     * @property iconCustomEmojiId New unique identifier of the custom emoji shown as the topic icon. Use <a href="#getforumtopiciconstickers">getForumTopicIconStickers</a> to get all allowed custom emoji identifiers. Pass an empty string to remove the icon. If not specified, the current icon will be kept
     *
     * @return [Boolean]
     * */
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

    /**
     * <p>Use this method to close an open topic in a forum supergroup chat. The bot must be an administrator in the chat for this to work and must have the <em>can_manage_topics</em> administrator rights, unless it is the creator of the topic. Returns <em>True</em> on success.</p>
     *
     * @property chatId Unique identifier for the target chat or username of the target supergroup (in the format <code>@supergroupusername</code>)
     * @property messageThreadId Unique identifier for the target message thread of the forum topic
     *
     * @return [Boolean]
     * */
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

    /**
     * <p>Use this method to reopen a closed topic in a forum supergroup chat. The bot must be an administrator in the chat for this to work and must have the <em>can_manage_topics</em> administrator rights, unless it is the creator of the topic. Returns <em>True</em> on success.</p>
     *
     * @property chatId Unique identifier for the target chat or username of the target supergroup (in the format <code>@supergroupusername</code>)
     * @property messageThreadId Unique identifier for the target message thread of the forum topic
     *
     * @return [Boolean]
     * */
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

    /**
     * <p>Use this method to delete a forum topic along with all its messages in a forum supergroup chat. The bot must be an administrator in the chat for this to work and must have the <em>can_delete_messages</em> administrator rights. Returns <em>True</em> on success.</p>
     *
     * @property chatId Unique identifier for the target chat or username of the target supergroup (in the format <code>@supergroupusername</code>)
     * @property messageThreadId Unique identifier for the target message thread of the forum topic
     *
     * @return [Boolean]
     * */
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

    /**
     * <p>Use this method to clear the list of pinned messages in a forum topic. The bot must be an administrator in the chat for this to work and must have the <em>can_pin_messages</em> administrator right in the supergroup. Returns <em>True</em> on success.</p>
     *
     * @property chatId Unique identifier for the target chat or username of the target supergroup (in the format <code>@supergroupusername</code>)
     * @property messageThreadId Unique identifier for the target message thread of the forum topic
     *
     * @return [Boolean]
     * */
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

    /**
     * <p>Use this method to edit the name of the 'General' topic in a forum supergroup chat. The bot must be an administrator in the chat for this to work and must have <em>can_manage_topics</em> administrator rights. Returns <em>True</em> on success.</p>
     *
     * @property chatId Unique identifier for the target chat or username of the target supergroup (in the format <code>@supergroupusername</code>)
     * @property name New topic name, 1-128 characters
     *
     * @return [Boolean]
     * */
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

    /**
     * <p>Use this method to close an open 'General' topic in a forum supergroup chat. The bot must be an administrator in the chat for this to work and must have the <em>can_manage_topics</em> administrator rights. Returns <em>True</em> on success.</p>
     *
     * @property chatId Unique identifier for the target chat or username of the target supergroup (in the format <code>@supergroupusername</code>)
     *
     * @return [Boolean]
     * */
    suspend fun closeGeneralForumTopic(
        chatId: String,
    ) = telegramPost(
        "$basePath/closeGeneralForumTopic",
        CloseGeneralForumTopicRequest(
            chatId,
        ).toJsonForRequest(),
        Boolean.serializer()
    )

    /**
     * <p>Use this method to reopen a closed 'General' topic in a forum supergroup chat. The bot must be an administrator in the chat for this to work and must have the <em>can_manage_topics</em> administrator rights. The topic will be automatically unhidden if it was hidden. Returns <em>True</em> on success.</p>
     *
     * @property chatId Unique identifier for the target chat or username of the target supergroup (in the format <code>@supergroupusername</code>)
     *
     * @return [Boolean]
     * */
    suspend fun reopenGeneralForumTopic(
        chatId: String,
    ) = telegramPost(
        "$basePath/reopenGeneralForumTopic",
        ReopenGeneralForumTopicRequest(
            chatId,
        ).toJsonForRequest(),
        Boolean.serializer()
    )

    /**
     * <p>Use this method to hide the 'General' topic in a forum supergroup chat. The bot must be an administrator in the chat for this to work and must have the <em>can_manage_topics</em> administrator rights. The topic will be automatically closed if it was open. Returns <em>True</em> on success.</p>
     *
     * @property chatId Unique identifier for the target chat or username of the target supergroup (in the format <code>@supergroupusername</code>)
     *
     * @return [Boolean]
     * */
    suspend fun hideGeneralForumTopic(
        chatId: String,
    ) = telegramPost(
        "$basePath/hideGeneralForumTopic",
        HideGeneralForumTopicRequest(
            chatId,
        ).toJsonForRequest(),
        Boolean.serializer()
    )

    /**
     * <p>Use this method to unhide the 'General' topic in a forum supergroup chat. The bot must be an administrator in the chat for this to work and must have the <em>can_manage_topics</em> administrator rights. Returns <em>True</em> on success.</p>
     *
     * @property chatId Unique identifier for the target chat or username of the target supergroup (in the format <code>@supergroupusername</code>)
     *
     * @return [Boolean]
     * */
    suspend fun unhideGeneralForumTopic(
        chatId: String,
    ) = telegramPost(
        "$basePath/unhideGeneralForumTopic",
        UnhideGeneralForumTopicRequest(
            chatId,
        ).toJsonForRequest(),
        Boolean.serializer()
    )

    /**
     * <p>Use this method to clear the list of pinned messages in a General forum topic. The bot must be an administrator in the chat for this to work and must have the <em>can_pin_messages</em> administrator right in the supergroup. Returns <em>True</em> on success.</p>
     *
     * @property chatId Unique identifier for the target chat or username of the target supergroup (in the format <code>@supergroupusername</code>)
     *
     * @return [Boolean]
     * */
    suspend fun unpinAllGeneralForumTopicMessages(
        chatId: String,
    ) = telegramPost(
        "$basePath/unpinAllGeneralForumTopicMessages",
        UnpinAllGeneralForumTopicMessagesRequest(
            chatId,
        ).toJsonForRequest(),
        Boolean.serializer()
    )

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
     *
     * @return [Boolean]
     * */
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

    /**
     * <p>Use this method to get the list of boosts added to a chat by a user. Requires administrator rights in the chat. Returns a <a href="#userchatboosts">UserChatBoosts</a> object.</p>
     *
     * @property chatId Unique identifier for the chat or username of the channel (in the format <code>@channelusername</code>)
     * @property userId Unique identifier of the target user
     *
     * @return [UserChatBoosts]
     * */
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

    /**
     * <p>Use this method to get information about the connection of the bot with a business account. Returns a <a href="#businessconnection">BusinessConnection</a> object on success.</p>
     *
     * @property businessConnectionId Unique identifier of the business connection
     *
     * @return [BusinessConnection]
     * */
    suspend fun getBusinessConnection(
        businessConnectionId: String,
    ) = telegramPost(
        "$basePath/getBusinessConnection",
        GetBusinessConnectionRequest(
            businessConnectionId,
        ).toJsonForRequest(),
        BusinessConnection.serializer()
    )

    /**
     * <p>Use this method to change the list of the bot's commands. See <a href="/bots/features#commands">this manual</a> for more details about bot commands. Returns <em>True</em> on success.</p>
     *
     * @property commands A JSON-serialized list of bot commands to be set as the list of the bot's commands. At most 100 commands can be specified.
     * @property scope A JSON-serialized object, describing scope of users for which the commands are relevant. Defaults to <a href="#botcommandscopedefault">BotCommandScopeDefault</a>.
     * @property languageCode A two-letter ISO 639-1 language code. If empty, commands will be applied to all users from the given scope, for whose language there are no dedicated commands
     *
     * @return [Boolean]
     * */
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

    /**
     * <p>Use this method to delete the list of the bot's commands for the given scope and user language. After deletion, <a href="#determining-list-of-commands">higher level commands</a> will be shown to affected users. Returns <em>True</em> on success.</p>
     *
     * @property scope A JSON-serialized object, describing scope of users for which the commands are relevant. Defaults to <a href="#botcommandscopedefault">BotCommandScopeDefault</a>.
     * @property languageCode A two-letter ISO 639-1 language code. If empty, commands will be applied to all users from the given scope, for whose language there are no dedicated commands
     *
     * @return [Boolean]
     * */
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

    /**
     * <p>Use this method to get the current list of the bot's commands for the given scope and user language. Returns an Array of <a href="#botcommand">BotCommand</a> objects. If commands aren't set, an empty list is returned.</p>
     *
     * @property scope A JSON-serialized object, describing scope of users. Defaults to <a href="#botcommandscopedefault">BotCommandScopeDefault</a>.
     * @property languageCode A two-letter ISO 639-1 language code or an empty string
     *
     * @return [List<BotCommand>]
     * */
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

    /**
     * <p>Use this method to change the bot's name. Returns <em>True</em> on success.</p>
     *
     * @property name New bot name; 0-64 characters. Pass an empty string to remove the dedicated name for the given language.
     * @property languageCode A two-letter ISO 639-1 language code. If empty, the name will be shown to all users for whose language there is no dedicated name.
     *
     * @return [Boolean]
     * */
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

    /**
     * <p>Use this method to get the current bot name for the given user language. Returns <a href="#botname">BotName</a> on success.</p>
     *
     * @property languageCode A two-letter ISO 639-1 language code or an empty string
     *
     * @return [BotName]
     * */
    suspend fun getMyName(
        languageCode: String? = null,
    ) = telegramPost(
        "$basePath/getMyName",
        GetMyNameRequest(
            languageCode,
        ).toJsonForRequest(),
        BotName.serializer()
    )

    /**
     * <p>Use this method to change the bot's description, which is shown in the chat with the bot if the chat is empty. Returns <em>True</em> on success.</p>
     *
     * @property description New bot description; 0-512 characters. Pass an empty string to remove the dedicated description for the given language.
     * @property languageCode A two-letter ISO 639-1 language code. If empty, the description will be applied to all users for whose language there is no dedicated description.
     *
     * @return [Boolean]
     * */
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

    /**
     * <p>Use this method to get the current bot description for the given user language. Returns <a href="#botdescription">BotDescription</a> on success.</p>
     *
     * @property languageCode A two-letter ISO 639-1 language code or an empty string
     *
     * @return [BotDescription]
     * */
    suspend fun getMyDescription(
        languageCode: String? = null,
    ) = telegramPost(
        "$basePath/getMyDescription",
        GetMyDescriptionRequest(
            languageCode,
        ).toJsonForRequest(),
        BotDescription.serializer()
    )

    /**
     * <p>Use this method to change the bot's short description, which is shown on the bot's profile page and is sent together with the link when users share the bot. Returns <em>True</em> on success.</p>
     *
     * @property shortDescription New short description for the bot; 0-120 characters. Pass an empty string to remove the dedicated short description for the given language.
     * @property languageCode A two-letter ISO 639-1 language code. If empty, the short description will be applied to all users for whose language there is no dedicated short description.
     *
     * @return [Boolean]
     * */
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

    /**
     * <p>Use this method to get the current bot short description for the given user language. Returns <a href="#botshortdescription">BotShortDescription</a> on success.</p>
     *
     * @property languageCode A two-letter ISO 639-1 language code or an empty string
     *
     * @return [BotShortDescription]
     * */
    suspend fun getMyShortDescription(
        languageCode: String? = null,
    ) = telegramPost(
        "$basePath/getMyShortDescription",
        GetMyShortDescriptionRequest(
            languageCode,
        ).toJsonForRequest(),
        BotShortDescription.serializer()
    )

    /**
     * <p>Use this method to change the bot's menu button in a private chat, or the default menu button. Returns <em>True</em> on success.</p>
     *
     * @property chatId Unique identifier for the target private chat. If not specified, default bot's menu button will be changed
     * @property menuButton A JSON-serialized object for the bot's new menu button. Defaults to <a href="#menubuttondefault">MenuButtonDefault</a>
     *
     * @return [Boolean]
     * */
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

    /**
     * <p>Use this method to get the current value of the bot's menu button in a private chat, or the default menu button. Returns <a href="#menubutton">MenuButton</a> on success.</p>
     *
     * @property chatId Unique identifier for the target private chat. If not specified, default bot's menu button will be returned
     *
     * @return [MenuButton]
     * */
    suspend fun getChatMenuButton(
        chatId: Long? = null,
    ) = telegramPost(
        "$basePath/getChatMenuButton",
        GetChatMenuButtonRequest(
            chatId,
        ).toJsonForRequest(),
        MenuButton.serializer()
    )

    /**
     * <p>Use this method to change the default administrator rights requested by the bot when it's added as an administrator to groups or channels. These rights will be suggested to users, but they are free to modify the list before adding the bot. Returns <em>True</em> on success.</p>
     *
     * @property rights A JSON-serialized object describing new default administrator rights. If not specified, the default administrator rights will be cleared.
     * @property forChannels Pass <em>True</em> to change the default administrator rights of the bot in channels. Otherwise, the default administrator rights of the bot for groups and supergroups will be changed.
     *
     * @return [Boolean]
     * */
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

    /**
     * <p>Use this method to get the current default administrator rights of the bot. Returns <a href="#chatadministratorrights">ChatAdministratorRights</a> on success.</p>
     *
     * @property forChannels Pass <em>True</em> to get default administrator rights of the bot in channels. Otherwise, default administrator rights of the bot for groups and supergroups will be returned.
     *
     * @return [ChatAdministratorRights]
     * */
    suspend fun getMyDefaultAdministratorRights(
        forChannels: Boolean? = null,
    ) = telegramPost(
        "$basePath/getMyDefaultAdministratorRights",
        GetMyDefaultAdministratorRightsRequest(
            forChannels,
        ).toJsonForRequest(),
        ChatAdministratorRights.serializer()
    )

    // Updating messages

    /**
     * <p>Use this method to edit text and <a href="#games">game</a> messages. On success, if the edited message is not an inline message, the edited <a href="#message">Message</a> is returned, otherwise <em>True</em> is returned.</p>
     *
     * @property text New text of the message, 1-4096 characters after entities parsing
     * @property chatId Required if <em>inline_message_id</em> is not specified. Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>)
     * @property messageId Required if <em>inline_message_id</em> is not specified. Identifier of the message to edit
     * @property inlineMessageId Required if <em>chat_id</em> and <em>message_id</em> are not specified. Identifier of the inline message
     * @property parseMode Mode for parsing entities in the message text. See <a href="#formatting-options">formatting options</a> for more details.
     * @property entities A JSON-serialized list of special entities that appear in message text, which can be specified instead of <em>parse_mode</em>
     * @property linkPreviewOptions Link preview generation options for the message
     * @property replyMarkup A JSON-serialized object for an <a href="/bots/features#inline-keyboards">inline keyboard</a>.
     *
     * @return [Message]
     * */
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
            text,
            chatId,
            messageId,
            inlineMessageId,
            parseMode,
            entities,
            linkPreviewOptions,
            replyMarkup,
        ).toJsonForRequest(),
        Message.serializer()
    )

    /**
     * <p>Use this method to edit captions of messages. On success, if the edited message is not an inline message, the edited <a href="#message">Message</a> is returned, otherwise <em>True</em> is returned.</p>
     *
     * @property chatId Required if <em>inline_message_id</em> is not specified. Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>)
     * @property messageId Required if <em>inline_message_id</em> is not specified. Identifier of the message to edit
     * @property inlineMessageId Required if <em>chat_id</em> and <em>message_id</em> are not specified. Identifier of the inline message
     * @property caption New caption of the message, 0-1024 characters after entities parsing
     * @property parseMode Mode for parsing entities in the message caption. See <a href="#formatting-options">formatting options</a> for more details.
     * @property captionEntities A JSON-serialized list of special entities that appear in the caption, which can be specified instead of <em>parse_mode</em>
     * @property showCaptionAboveMedia Pass <em>True</em>, if the caption must be shown above the message media. Supported only for animation, photo and video messages.
     * @property replyMarkup A JSON-serialized object for an <a href="/bots/features#inline-keyboards">inline keyboard</a>.
     *
     * @return [Message]
     * */
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

    /**
     * <p>Use this method to edit animation, audio, document, photo, or video messages. If a message is part of a message album, then it can be edited only to an audio for audio albums, only to a document for document albums and to a photo or a video otherwise. When an inline message is edited, a new file can't be uploaded; use a previously uploaded file via its file_id or specify a URL. On success, if the edited message is not an inline message, the edited <a href="#message">Message</a> is returned, otherwise <em>True</em> is returned.</p>
     *
     * @property media A JSON-serialized object for a new media content of the message
     * @property chatId Required if <em>inline_message_id</em> is not specified. Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>)
     * @property messageId Required if <em>inline_message_id</em> is not specified. Identifier of the message to edit
     * @property inlineMessageId Required if <em>chat_id</em> and <em>message_id</em> are not specified. Identifier of the inline message
     * @property replyMarkup A JSON-serialized object for a new <a href="/bots/features#inline-keyboards">inline keyboard</a>.
     *
     * @return [Message]
     * */
    suspend fun editMessageMedia(
        media: InputMedia,
        chatId: String? = null,
        messageId: Long? = null,
        inlineMessageId: String? = null,
        replyMarkup: InlineKeyboardMarkup? = null,
    ) = telegramPost(
        "$basePath/editMessageMedia",
        EditMessageMediaRequest(
            media,
            chatId,
            messageId,
            inlineMessageId,
            replyMarkup,
        ).toJsonForRequest(),
        Message.serializer()
    )

    /**
     * <p>Use this method to edit live location messages. A location can be edited until its <em>live_period</em> expires or editing is explicitly disabled by a call to <a href="#stopmessagelivelocation">stopMessageLiveLocation</a>. On success, if the edited message is not an inline message, the edited <a href="#message">Message</a> is returned, otherwise <em>True</em> is returned.</p>
     *
     * @property latitude Latitude of new location
     * @property longitude Longitude of new location
     * @property chatId Required if <em>inline_message_id</em> is not specified. Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>)
     * @property messageId Required if <em>inline_message_id</em> is not specified. Identifier of the message to edit
     * @property inlineMessageId Required if <em>chat_id</em> and <em>message_id</em> are not specified. Identifier of the inline message
     * @property livePeriod New period in seconds during which the location can be updated, starting from the message send date. If 0x7FFFFFFF is specified, then the location can be updated forever. Otherwise, the new value must not exceed the current <em>live_period</em> by more than a day, and the live location expiration date must remain within the next 90 days. If not specified, then <em>live_period</em> remains unchanged
     * @property horizontalAccuracy The radius of uncertainty for the location, measured in meters; 0-1500
     * @property heading Direction in which the user is moving, in degrees. Must be between 1 and 360 if specified.
     * @property proximityAlertRadius The maximum distance for proximity alerts about approaching another chat member, in meters. Must be between 1 and 100000 if specified.
     * @property replyMarkup A JSON-serialized object for a new <a href="/bots/features#inline-keyboards">inline keyboard</a>.
     *
     * @return [Message]
     * */
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
            latitude,
            longitude,
            chatId,
            messageId,
            inlineMessageId,
            livePeriod,
            horizontalAccuracy,
            heading,
            proximityAlertRadius,
            replyMarkup,
        ).toJsonForRequest(),
        Message.serializer()
    )

    /**
     * <p>Use this method to stop updating a live location message before <em>live_period</em> expires. On success, if the message is not an inline message, the edited <a href="#message">Message</a> is returned, otherwise <em>True</em> is returned.</p>
     *
     * @property chatId Required if <em>inline_message_id</em> is not specified. Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>)
     * @property messageId Required if <em>inline_message_id</em> is not specified. Identifier of the message with live location to stop
     * @property inlineMessageId Required if <em>chat_id</em> and <em>message_id</em> are not specified. Identifier of the inline message
     * @property replyMarkup A JSON-serialized object for a new <a href="/bots/features#inline-keyboards">inline keyboard</a>.
     *
     * @return [Message]
     * */
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

    /**
     * <p>Use this method to edit only the reply markup of messages. On success, if the edited message is not an inline message, the edited <a href="#message">Message</a> is returned, otherwise <em>True</em> is returned.</p>
     *
     * @property chatId Required if <em>inline_message_id</em> is not specified. Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>)
     * @property messageId Required if <em>inline_message_id</em> is not specified. Identifier of the message to edit
     * @property inlineMessageId Required if <em>chat_id</em> and <em>message_id</em> are not specified. Identifier of the inline message
     * @property replyMarkup A JSON-serialized object for an <a href="/bots/features#inline-keyboards">inline keyboard</a>.
     *
     * @return [Message]
     * */
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

    /**
     * <p>Use this method to stop a poll which was sent by the bot. On success, the stopped <a href="#poll">Poll</a> is returned.</p>
     *
     * @property chatId Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>)
     * @property messageId Identifier of the original message with the poll
     * @property replyMarkup A JSON-serialized object for a new message <a href="/bots/features#inline-keyboards">inline keyboard</a>.
     *
     * @return [Poll]
     * */
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

    /**
     * <p>Use this method to delete a message, including service messages, with the following limitations:<br>- A message can only be deleted if it was sent less than 48 hours ago.<br>- Service messages about a supergroup, channel, or forum topic creation can't be deleted.<br>- A dice message in a private chat can only be deleted if it was sent more than 24 hours ago.<br>- Bots can delete outgoing messages in private chats, groups, and supergroups.<br>- Bots can delete incoming messages in private chats.<br>- Bots granted <em>can_post_messages</em> permissions can delete outgoing messages in channels.<br>- If the bot is an administrator of a group, it can delete any message there.<br>- If the bot has <em>can_delete_messages</em> permission in a supergroup or a channel, it can delete any message there.<br>Returns <em>True</em> on success.</p>
     *
     * @property chatId Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>)
     * @property messageId Identifier of the message to delete
     *
     * @return [Boolean]
     * */
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

    /**
     * <p>Use this method to delete multiple messages simultaneously. If some of the specified messages can't be found, they are skipped. Returns <em>True</em> on success.</p>
     *
     * @property chatId Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>)
     * @property messageIds A JSON-serialized list of 1-100 identifiers of messages to delete. See <a href="#deletemessage">deleteMessage</a> for limitations on which messages can be deleted
     *
     * @return [Boolean]
     * */
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
     * @property messageEffectId Unique identifier of the message effect to be added to the message; for private chats only
     * @property replyParameters Description of the message to reply to
     * @property replyMarkup Additional interface options. A JSON-serialized object for an <a href="/bots/features#inline-keyboards">inline keyboard</a>, <a href="/bots/features#keyboards">custom reply keyboard</a>, instructions to remove a reply keyboard or to force a reply from the user
     *
     * @return [Message]
     * */
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
            chatId,
            sticker,
            businessConnectionId,
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

    /**
     * <p>Use this method to get a sticker set. On success, a <a href="#stickerset">StickerSet</a> object is returned.</p>
     *
     * @property name Name of the sticker set
     *
     * @return [StickerSet]
     * */
    suspend fun getStickerSet(
        name: String,
    ) = telegramPost(
        "$basePath/getStickerSet",
        GetStickerSetRequest(
            name,
        ).toJsonForRequest(),
        StickerSet.serializer()
    )

    /**
     * <p>Use this method to get information about custom emoji stickers by their identifiers. Returns an Array of <a href="#sticker">Sticker</a> objects.</p>
     *
     * @property customEmojiIds A JSON-serialized list of custom emoji identifiers. At most 200 custom emoji identifiers can be specified.
     *
     * @return [List<Sticker>]
     * */
    suspend fun getCustomEmojiStickers(
        customEmojiIds: List<String>,
    ) = telegramPost(
        "$basePath/getCustomEmojiStickers",
        GetCustomEmojiStickersRequest(
            customEmojiIds,
        ).toJsonForRequest(),
        ListSerializer(Sticker.serializer())
    )

    /**
     * <p>Use this method to upload a file with a sticker for later use in the <a href="#createnewstickerset">createNewStickerSet</a>, <a href="#addstickertoset">addStickerToSet</a>, or <a href="#replacestickerinset">replaceStickerInSet</a> methods (the file can be used multiple times). Returns the uploaded <a href="#file">File</a> on success.</p>
     *
     * @property userId User identifier of sticker file owner
     * @property sticker A file with the sticker in .WEBP, .PNG, .TGS, or .WEBM format. See <a href="/stickers"></a><a href="https://core.telegram.org/stickers">https://core.telegram.org/stickers</a> for technical requirements. <a href="#sending-files">More information on Sending Files »</a>
     * @property stickerFormat Format of the sticker, must be one of “static”, “animated”, “video”
     *
     * @return [File]
     * */
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

    /**
     * <p>Use this method to create a new sticker set owned by a user. The bot will be able to edit the sticker set thus created. Returns <em>True</em> on success.</p>
     *
     * @property userId User identifier of created sticker set owner
     * @property name Short name of sticker set, to be used in <code>t.me/addstickers/</code> URLs (e.g., <em>animals</em>). Can contain only English letters, digits and underscores. Must begin with a letter, can't contain consecutive underscores and must end in <code>"_by_&lt;bot_username&gt;"</code>. <code>&lt;bot_username&gt;</code> is case insensitive. 1-64 characters.
     * @property title Sticker set title, 1-64 characters
     * @property stickers A JSON-serialized list of 1-50 initial stickers to be added to the sticker set
     * @property stickerType Type of stickers in the set, pass “regular”, “mask”, or “custom_emoji”. By default, a regular sticker set is created.
     * @property needsRepainting Pass <em>True</em> if stickers in the sticker set must be repainted to the color of text when used in messages, the accent color if used as emoji status, white on chat photos, or another appropriate color based on context; for custom emoji sticker sets only
     *
     * @return [Boolean]
     * */
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

    /**
     * <p>Use this method to add a new sticker to a set created by the bot. Emoji sticker sets can have up to 200 stickers. Other sticker sets can have up to 120 stickers. Returns <em>True</em> on success.</p>
     *
     * @property userId User identifier of sticker set owner
     * @property name Sticker set name
     * @property sticker A JSON-serialized object with information about the added sticker. If exactly the same sticker had already been added to the set, then the set isn't changed.
     *
     * @return [Boolean]
     * */
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

    /**
     * <p>Use this method to move a sticker in a set created by the bot to a specific position. Returns <em>True</em> on success.</p>
     *
     * @property sticker File identifier of the sticker
     * @property position New sticker position in the set, zero-based
     *
     * @return [Boolean]
     * */
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

    /**
     * <p>Use this method to delete a sticker from a set created by the bot. Returns <em>True</em> on success.</p>
     *
     * @property sticker File identifier of the sticker
     *
     * @return [Boolean]
     * */
    suspend fun deleteStickerFromSet(
        sticker: String,
    ) = telegramPost(
        "$basePath/deleteStickerFromSet",
        DeleteStickerFromSetRequest(
            sticker,
        ).toJsonForRequest(),
        Boolean.serializer()
    )

    /**
     * <p>Use this method to replace an existing sticker in a sticker set with a new one. The method is equivalent to calling <a href="#deletestickerfromset">deleteStickerFromSet</a>, then <a href="#addstickertoset">addStickerToSet</a>, then <a href="#setstickerpositioninset">setStickerPositionInSet</a>. Returns <em>True</em> on success.</p>
     *
     * @property userId User identifier of the sticker set owner
     * @property name Sticker set name
     * @property oldSticker File identifier of the replaced sticker
     * @property sticker A JSON-serialized object with information about the added sticker. If exactly the same sticker had already been added to the set, then the set remains unchanged.
     *
     * @return [Boolean]
     * */
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

    /**
     * <p>Use this method to change the list of emoji assigned to a regular or custom emoji sticker. The sticker must belong to a sticker set created by the bot. Returns <em>True</em> on success.</p>
     *
     * @property sticker File identifier of the sticker
     * @property emojiList A JSON-serialized list of 1-20 emoji associated with the sticker
     *
     * @return [Boolean]
     * */
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

    /**
     * <p>Use this method to change search keywords assigned to a regular or custom emoji sticker. The sticker must belong to a sticker set created by the bot. Returns <em>True</em> on success.</p>
     *
     * @property sticker File identifier of the sticker
     * @property keywords A JSON-serialized list of 0-20 search keywords for the sticker with total length of up to 64 characters
     *
     * @return [Boolean]
     * */
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

    /**
     * <p>Use this method to change the <a href="#maskposition">mask position</a> of a mask sticker. The sticker must belong to a sticker set that was created by the bot. Returns <em>True</em> on success.</p>
     *
     * @property sticker File identifier of the sticker
     * @property maskPosition A JSON-serialized object with the position where the mask should be placed on faces. Omit the parameter to remove the mask position.
     *
     * @return [Boolean]
     * */
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

    /**
     * <p>Use this method to set the title of a created sticker set. Returns <em>True</em> on success.</p>
     *
     * @property name Sticker set name
     * @property title Sticker set title, 1-64 characters
     *
     * @return [Boolean]
     * */
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

    /**
     * <p>Use this method to set the thumbnail of a regular or mask sticker set. The format of the thumbnail file must match the format of the stickers in the set. Returns <em>True</em> on success.</p>
     *
     * @property name Sticker set name
     * @property userId User identifier of the sticker set owner
     * @property format Format of the thumbnail, must be one of “static” for a <strong>.WEBP</strong> or <strong>.PNG</strong> image, “animated” for a <strong>.TGS</strong> animation, or “video” for a <strong>WEBM</strong> video
     * @property thumbnail A <strong>.WEBP</strong> or <strong>.PNG</strong> image with the thumbnail, must be up to 128 kilobytes in size and have a width and height of exactly 100px, or a <strong>.TGS</strong> animation with a thumbnail up to 32 kilobytes in size (see <a href="/stickers#animated-sticker-requirements"></a><a href="https://core.telegram.org/stickers#animated-sticker-requirements">https://core.telegram.org/stickers#animated-sticker-requirements</a> for animated sticker technical requirements), or a <strong>WEBM</strong> video with the thumbnail up to 32 kilobytes in size; see <a href="/stickers#video-sticker-requirements"></a><a href="https://core.telegram.org/stickers#video-sticker-requirements">https://core.telegram.org/stickers#video-sticker-requirements</a> for video sticker technical requirements. Pass a <em>file_id</em> as a String to send a file that already exists on the Telegram servers, pass an HTTP URL as a String for Telegram to get a file from the Internet, or upload a new one using multipart/form-data. <a href="#sending-files">More information on Sending Files »</a>. Animated and video sticker set thumbnails can't be uploaded via HTTP URL. If omitted, then the thumbnail is dropped and the first sticker is used as the thumbnail.
     *
     * @return [Boolean]
     * */
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
            format,
            thumbnail,
        ).toJsonForRequest(),
        Boolean.serializer()
    )

    /**
     * <p>Use this method to set the thumbnail of a custom emoji sticker set. Returns <em>True</em> on success.</p>
     *
     * @property name Sticker set name
     * @property customEmojiId Custom emoji identifier of a sticker from the sticker set; pass an empty string to drop the thumbnail and use the first sticker as the thumbnail.
     *
     * @return [Boolean]
     * */
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

    /**
     * <p>Use this method to delete a sticker set that was created by the bot. Returns <em>True</em> on success.</p>
     *
     * @property name Sticker set name
     *
     * @return [Boolean]
     * */
    suspend fun deleteStickerSet(
        name: String,
    ) = telegramPost(
        "$basePath/deleteStickerSet",
        DeleteStickerSetRequest(
            name,
        ).toJsonForRequest(),
        Boolean.serializer()
    )

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
     *
     * @return [Boolean]
     * */
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

    /**
     * <p>Use this method to set the result of an interaction with a <a href="/bots/webapps">Web App</a> and send a corresponding message on behalf of the user to the chat from which the query originated. On success, a <a href="#sentwebappmessage">SentWebAppMessage</a> object is returned.</p>
     *
     * @property webAppQueryId Unique identifier for the query to be answered
     * @property result A JSON-serialized object describing the message to be sent
     *
     * @return [SentWebAppMessage]
     * */
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

    // Payments

    /**
     * <p>Use this method to send invoices. On success, the sent <a href="#message">Message</a> is returned.</p>
     *
     * @property chatId Unique identifier for the target chat or username of the target channel (in the format <code>@channelusername</code>)
     * @property title Product name, 1-32 characters
     * @property description Product description, 1-255 characters
     * @property payload Bot-defined invoice payload, 1-128 bytes. This will not be displayed to the user, use for your internal processes.
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
     * @property messageEffectId Unique identifier of the message effect to be added to the message; for private chats only
     * @property replyParameters Description of the message to reply to
     * @property replyMarkup A JSON-serialized object for an <a href="/bots/features#inline-keyboards">inline keyboard</a>. If empty, one 'Pay <code>total price</code>' button will be shown. If not empty, the first button must be a Pay button.
     *
     * @return [Message]
     * */
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
            title,
            description,
            payload,
            currency,
            prices,
            messageThreadId,
            providerToken,
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

    /**
     * <p>Use this method to create a link for an invoice. Returns the created invoice link as <em>String</em> on success.</p>
     *
     * @property title Product name, 1-32 characters
     * @property description Product description, 1-255 characters
     * @property payload Bot-defined invoice payload, 1-128 bytes. This will not be displayed to the user, use for your internal processes.
     * @property currency Three-letter ISO 4217 currency code, see <a href="/bots/payments#supported-currencies">more on currencies</a>. Pass “XTR” for payments in <a href="https://t.me/BotNews/90">Telegram Stars</a>.
     * @property prices Price breakdown, a JSON-serialized list of components (e.g. product price, tax, discount, delivery cost, delivery tax, bonus, etc.). Must contain exactly one item for payments in <a href="https://t.me/BotNews/90">Telegram Stars</a>.
     * @property providerToken Payment provider token, obtained via <a href="https://t.me/botfather">@BotFather</a>. Pass an empty string for payments in <a href="https://t.me/BotNews/90">Telegram Stars</a>.
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
     *
     * @return [String]
     * */
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
            currency,
            prices,
            providerToken,
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

    /**
     * <p>If you sent an invoice requesting a shipping address and the parameter <em>is_flexible</em> was specified, the Bot API will send an <a href="#update">Update</a> with a <em>shipping_query</em> field to the bot. Use this method to reply to shipping queries. On success, <em>True</em> is returned.</p>
     *
     * @property shippingQueryId Unique identifier for the query to be answered
     * @property ok Pass <em>True</em> if delivery to the specified address is possible and <em>False</em> if there are any problems (for example, if delivery to the specified address is not possible)
     * @property shippingOptions Required if <em>ok</em> is <em>True</em>. A JSON-serialized array of available shipping options.
     * @property errorMessage Required if <em>ok</em> is <em>False</em>. Error message in human readable form that explains why it is impossible to complete the order (e.g. "Sorry, delivery to your desired address is unavailable'). Telegram will display this message to the user.
     *
     * @return [Boolean]
     * */
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

    /**
     * <p>Once the user has confirmed their payment and shipping details, the Bot API sends the final confirmation in the form of an <a href="#update">Update</a> with the field <em>pre_checkout_query</em>. Use this method to respond to such pre-checkout queries. On success, <em>True</em> is returned. <strong>Note:</strong> The Bot API must receive an answer within 10 seconds after the pre-checkout query was sent.</p>
     *
     * @property preCheckoutQueryId Unique identifier for the query to be answered
     * @property ok Specify <em>True</em> if everything is alright (goods are available, etc.) and the bot is ready to proceed with the order. Use <em>False</em> if there are any problems.
     * @property errorMessage Required if <em>ok</em> is <em>False</em>. Error message in human readable form that explains the reason for failure to proceed with the checkout (e.g. "Sorry, somebody just bought the last of our amazing black T-shirts while you were busy filling out your payment details. Please choose a different color or garment!"). Telegram will display this message to the user.
     *
     * @return [Boolean]
     * */
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

    /**
     * <p>Refunds a successful payment in <a href="https://t.me/BotNews/90">Telegram Stars</a>. Returns <em>True</em> on success.</p>
     *
     * @property userId Identifier of the user whose payment will be refunded
     * @property telegramPaymentChargeId Telegram payment identifier
     *
     * @return [Boolean]
     * */
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

    // Telegram Passport

    /**
     * <p>Informs a user that some of the Telegram Passport elements they provided contains errors. The user will not be able to re-submit their Passport to you until the errors are fixed (the contents of the field for which you returned the error must change). Returns <em>True</em> on success.</p><p>Use this if the data submitted by the user doesn't satisfy the standards your service requires for any reason. For example, if a birthday date seems invalid, a submitted document is blurry, a scan shows evidence of tampering, etc. Supply some details in the error message to make sure the user knows how to correct the issues.</p>
     *
     * @property userId User identifier
     * @property errors A JSON-serialized array describing the errors
     *
     * @return [Boolean]
     * */
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
     * @property messageEffectId Unique identifier of the message effect to be added to the message; for private chats only
     * @property replyParameters Description of the message to reply to
     * @property replyMarkup A JSON-serialized object for an <a href="/bots/features#inline-keyboards">inline keyboard</a>. If empty, one 'Play game_title' button will be shown. If not empty, the first button must launch the game.
     *
     * @return [Message]
     * */
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
            chatId,
            gameShortName,
            businessConnectionId,
            messageThreadId,
            disableNotification,
            protectContent,
            messageEffectId,
            replyParameters,
            replyMarkup,
        ).toJsonForRequest(),
        Message.serializer()
    )

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
     *
     * @return [Message]
     * */
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

    /**
     * <p>Use this method to get data for high score tables. Will return the score of the specified user and several of their neighbors in a game. Returns an Array of <a href="#gamehighscore">GameHighScore</a> objects.</p><blockquote>
     *  <p>This method will currently return scores for the target user, plus two of their closest neighbors on each side. Will also return the top three users if the user and their neighbors are not among them. Please note that this behavior is subject to change.</p>
     * </blockquote>
     *
     * @property userId Target user id
     * @property chatId Required if <em>inline_message_id</em> is not specified. Unique identifier for the target chat
     * @property messageId Required if <em>inline_message_id</em> is not specified. Identifier of the sent message
     * @property inlineMessageId Required if <em>chat_id</em> and <em>message_id</em> are not specified. Identifier of the inline message
     *
     * @return [List<GameHighScore>]
     * */
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
