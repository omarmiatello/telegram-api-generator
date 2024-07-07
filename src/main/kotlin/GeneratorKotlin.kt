fun List<DocSection>.toKotlinModels(useKotlinXSerialization: Boolean) = buildString {
    val allType = this@toKotlinModels.flatMap { section ->
        section.docTypes.map { TelegramType.from(it.name) }
    }
    if (useKotlinXSerialization) {
        appendLine("@file:UseSerializers(")
        TelegramType.allSuper.forEach { type ->
            appendLine("    ${type.name}Serializer::class,")
        }
        appendLine(")\n")
    }
    appendLine("package com.github.omarmiatello.telegram\n")
    if (useKotlinXSerialization) {
        appendLine("import kotlinx.serialization.Contextual")
        appendLine("import kotlinx.serialization.KSerializer")
        appendLine("import kotlinx.serialization.Serializable")
        appendLine("import kotlinx.serialization.UseSerializers")
        appendLine("import kotlinx.serialization.descriptors.SerialDescriptor")
        appendLine("import kotlinx.serialization.encoding.Decoder")
        appendLine("import kotlinx.serialization.encoding.Encoder")
        appendLine("import kotlinx.serialization.json.*")
        appendLine("import kotlinx.serialization.serializer")
        appendLine("import kotlin.jvm.JvmInline\n")
        appendLine("private val json = Json {")
        appendLine("    ignoreUnknownKeys = true")
        appendLine("    prettyPrint = true")
        appendLine("    encodeDefaults = false")
        appendLine("}\n")
        appendLine("sealed class TelegramModel { abstract fun toJson(): String }")
        appendLine("private fun <T> Decoder.tryDeserializers(vararg serializers: KSerializer<out T>): T {")
        appendLine("    error(buildString {")
        appendLine("        appendLine(\"Tried \${serializers.size} deserializers, but all failed!\")")
        appendLine("        val jsonEl = decodeSerializableValue(JsonElement.serializer())")
        appendLine("        serializers.firstNotNullOfOrNull {")
        appendLine("            try {")
        appendLine("                json.decodeFromJsonElement(it, jsonEl)")
        appendLine("            } catch (e: Exception) {")
        appendLine("                appendLine(\"\$it: \$e\")")
        appendLine("                null")
        appendLine("            }")
        appendLine("        }?.also { return it }")
        appendLine("    })")
        appendLine("}")
        appendLine("@Serializable @JvmInline value class UserId(val longValue: Long) {") // user_id
        appendLine("    fun toChatId(): ChatId = ChatId(longValue.toString())")
        appendLine("}")
        appendLine("@Serializable @JvmInline value class ChatId(val stringValue: String) {") // chat_id
        appendLine("    val longValue: Long get() = stringValue.toLong()")
        appendLine("}")
        appendLine("@Serializable @JvmInline value class MessageId(val longValue: Long)") // message_id
        appendLine("@Serializable @JvmInline value class BusinessConnectionId(val stringValue: String)") // business_connection_id
        appendLine("@Serializable @JvmInline value class MessageThreadId(val longValue: Long)") // message_thread_id
        appendLine("@Serializable @JvmInline value class MessageEffectId(val stringValue: String)") // message_effect_id
    } else {
        appendLine("sealed class TelegramModel")
    }
    TelegramType.allSuper.forEach { type ->
        val superType = TelegramType.from(type.name).superType ?: "TelegramModel"
        if (useKotlinXSerialization) appendLine("@Serializable")
        appendLine("sealed class ${type.name} : $superType()")
        if (useKotlinXSerialization) {
            appendLine("object ${type.name}Serializer : KSerializer<${type.name}> {")
            appendLine("    override val descriptor: SerialDescriptor = ${type.name}.serializer().descriptor")
            val allSubtype = allType.filter { it.superType?.name == type.name }
            if (allSubtype.isEmpty()) {
                appendLine("    override fun serialize(encoder: Encoder, value: ${type.name}) = TODO()")
            } else {
                appendLine("    override fun serialize(encoder: Encoder, value: ${type.name}) = when (value) {")
                allSubtype.forEach { subtype ->
                    appendLine("        is ${subtype.name} -> encoder.encodeSerializableValue(serializer(), value)")
                }
                appendLine("    }\n")
            }
            when (type) {
                is TelegramType.Super -> {
                    appendLine("    override fun deserialize(decoder: Decoder): ${type.name} = ")
                    if (type.deserializer.isEmpty()) {
                        appendLine("        decoder.tryDeserializers(${allSubtype.joinToString { it.name + ".serializer()" }})")
                    } else {
                        appendLine("        decoder.decodeSerializableValue(JsonElement.serializer()).let { jsonElement ->")
                        appendLine("json.decodeFromJsonElement(")
                        appendLine("    deserializer = ${type.deserializer},")
                        appendLine("    element = jsonElement,")
                        appendLine(")")
                        appendLine("        }")
                    }
                }

                else -> {
                    appendLine("    override fun deserialize(decoder: Decoder): ${type.name} = TODO()")
                }
            }
            appendLine("}")
        }
    }
    if (useKotlinXSerialization) appendLine("@Serializable")
    appendLine("data class TelegramResponse<T>(val ok: Boolean, val result: T? = null)")
    appendLine(comment("--- Utility ---"))
    appendLine("enum class ParseMode { MarkdownV2, Markdown, HTML }")
    if (useKotlinXSerialization) appendLine("fun String.parseTelegramRequest() = Update.fromJson(this)")
    appendLine(comment("--- Parameters & Responses ---"))
    this@toKotlinModels.forEach { section ->
        if (section.docTypes.isNotEmpty()) {
            appendLine(comment(section.name))
            section.docTypes.forEach { type ->
                appendLine(type.toKotlinDoc())
                if (useKotlinXSerialization) appendLine("@Serializable")
                appendLine(type.toKotlinDataClass(useKotlinXSerialization))
                appendLine()
            }
        }
    }
    appendLine(comment("--- Requests ---"))
    appendLine("sealed class TelegramRequest {")
    if (useKotlinXSerialization) appendLine("abstract fun toJsonForRequest(): String")
    if (useKotlinXSerialization) appendLine("abstract fun toJsonForResponse(): String")
    this@toKotlinModels.forEach { section ->
        if (section.docMethods.isNotEmpty()) {
            appendLine(comment(section.name))
            section.docMethods.forEach { method ->
                if (method.docParameters.isNotEmpty()) {
                    appendLine(method.toKotlinDoc(showReturn = false))
                    if (useKotlinXSerialization) appendLine("@Serializable")
                    appendLine(method.toKotlinDataClass(useKotlinXSerialization))
                    appendLine()
                }
            }
        }
    }
    appendLine("}")
}

fun List<DocSection>.toKotlinMethods() = buildString {
    appendLine("package com.github.omarmiatello.telegram\n")
    appendLine("import com.github.omarmiatello.telegram.TelegramRequest.*")
    appendLine("import io.ktor.client.*")
    appendLine("import io.ktor.client.call.*")
    appendLine("import io.ktor.client.request.*")
    appendLine("import io.ktor.http.*")
    appendLine("import io.ktor.http.content.*")
    appendLine("import kotlinx.serialization.KSerializer")
    appendLine("import kotlinx.serialization.builtins.ListSerializer")
    appendLine("import kotlinx.serialization.builtins.serializer")
    appendLine("import kotlinx.serialization.json.Json")
    appendLine("class TelegramClient(apiKey: String, private val httpClient: HttpClient = HttpClient()) {")
    appendLine("""    private val basePath = "https://api.telegram.org/bot${"$"}apiKey"""")
    appendLine("    private val json = Json { ignoreUnknownKeys = true; prettyPrint = true; encodeDefaults = false }")
    appendLine()
    appendLine("    private suspend fun <T> telegramGet(path: String, response: KSerializer<T>): TelegramResponse<T> {")
    appendLine("        val responseString: String = httpClient.get(path).body()")
    appendLine("        return json.decodeFromString(TelegramResponse.serializer(response), responseString)")
    appendLine("    }")
    appendLine()
    appendLine("    private suspend fun <T> telegramPost(path: String, body: String, response: KSerializer<T>): TelegramResponse<T> {")
    appendLine("        val responseString: String = httpClient")
    appendLine("            .post(path) { setBody(TextContent(body, ContentType.Application.Json)) }")
    appendLine("            .body()")
    appendLine("        return json.decodeFromString(TelegramResponse.serializer(response), responseString)")
    appendLine("    }")

    this@toKotlinMethods.forEach { section ->
        if (section.docMethods.isNotEmpty()) {
            appendLine(comment(section.name))
            section.docMethods.forEach { method ->
                appendLine(method.toKotlinDoc())
                appendLine(method.toKotlinRequestMethod())
            }
        }
    }
    appendLine("}")
}

private fun comment(text: String) = buildString {
    appendLine()
    appendLine("// $text")
}

private fun DocType.toKotlinDoc() = buildString {
    appendLine("/**")
    appendLine(" * ${description.replace("\n", "\n * ")}")
    appendLine(" *")
    docFields.forEach {
        appendLine(" * @property ${it.name} ${it.description}")
    }
    appendLine(" *")
    appendLine(" * @constructor Creates a [$name].")
    append(" * */")
}

private fun DocMethod.toKotlinDoc(showReturn: Boolean = true) = buildString {
    appendLine("/**")
    appendLine(" * ${description.replace("\n", "\n * ")}")
    appendLine(" *")
    docParameters.forEach {
        appendLine(" * @property ${it.name} ${it.description}")
    }
    if (showReturn) {
        appendLine(" *")
        appendLine(" * @return [${returns.toKotlinTypeNoValueClasses()}]")
    }
    append(" * */")
}

private fun DocType.toKotlinDataClass(useKotlinXSerialization: Boolean) = buildString {
    appendLine("data class $name(")
    docFields.forEachIndexed { index, field ->
        appendLine(
            "    val ${field.name}: ${
                field.toKotlinType(
                    className = name,
                    useInlineClasses = useKotlinXSerialization,
                    useContextualSerialization = useKotlinXSerialization,
                )
            },"
        )
    }
    val superType = TelegramType.from(name).superType ?: "TelegramModel"
    if (useKotlinXSerialization) {
        appendLine(") : $superType() {")
        appendLine("    override fun toJson() = json.encodeToString(serializer(), this)")
        appendLine("    companion object {")
        appendLine("        fun fromJson(string: String) = json.decodeFromString(serializer(), string)")
        appendLine("    }")
        append("}")
    } else {
        append(") : $superType()")
    }
}

private fun DocMethod.toKotlinDataClass(useKotlinXSerialization: Boolean) = buildString {
    appendLine("data class ${name.capitalize()}Request(")
    docParameters.forEachIndexed { index, field ->
        appendLine(
            "    val ${field.name}: ${
                field.toKotlinType(
                    className = name,
                    useInlineClasses = useKotlinXSerialization,
                    useContextualSerialization = useKotlinXSerialization,
                )
            },"
        )
    }
    if (useKotlinXSerialization) {
        appendLine(") : TelegramRequest() {")
        appendLine("    override fun toJsonForRequest() = json.encodeToString(serializer(), this)")
        appendLine("    override fun toJsonForResponse() = JsonObject(")
        appendLine("        json.encodeToJsonElement(serializer(), this).jsonObject + (\"method\" to JsonPrimitive(\"$name\"))")
        appendLine("    ).toString()")
        appendLine("    companion object {")
        appendLine("        fun fromJson(string: String) = json.decodeFromString(serializer(), string)")
        appendLine("    }")
        append("}")
    } else {
        append(") : TelegramRequest()")
    }
}

private fun DocMethod.toKotlinRequestMethod() = buildString {
    val path = """"${"$"}basePath/$name""""
    if (docParameters.isEmpty()) {
        append("suspend fun $name() = telegramGet($path, ${returns.toKotlinSerializerType()})")
    } else {
        appendLine("suspend fun $name(")
        docParameters.forEachIndexed { index, parameter ->
            appendLine(
                "${parameter.name}: ${
                    parameter.toKotlinType(
                        className = name,
                        useInlineClasses = true,
                        useContextualSerialization = false,
                    )
                },"
            )
        }
        appendLine(") = telegramPost(")
        appendLine("    $path,")
        appendLine("    ${name.capitalize()}Request(")
        docParameters.forEachIndexed { index, parameter ->
            appendLine("        ${parameter.name},")
        }
        appendLine("    ).toJsonForRequest(),")
        appendLine("    ${returns.toKotlinSerializerType()}")
        append(")")
    }
}

private fun DocField.toKotlinType(
    className: String,
    useInlineClasses: Boolean,
    useContextualSerialization: Boolean
) = type.toKotlinTypeWithValueClasses(
    className = className,
    propertyName = name.takeIf { useInlineClasses },
    prefixPolymorphic = if (useContextualSerialization) "@Contextual " else "",
) + if (required) "" else "? = null"

private fun DocParameter.toKotlinType(
    className: String,
    useInlineClasses: Boolean,
    useContextualSerialization: Boolean,
) = type.toKotlinTypeWithValueClasses(
    className = className,
    propertyName = name.takeIf { useInlineClasses },
    prefixPolymorphic = if (useContextualSerialization) "@Contextual " else "",
) + if (required) "" else "? = null"

private fun TelegramType.toKotlinTypeWithValueClasses(
    className: String?,
    propertyName: String?,
    prefixPolymorphic: String = "",
): String {
    return when (this) {
        is TelegramType.ListType<*> -> "List<${
            elementType.toKotlinTypeWithValueClasses(
                className = className,
                propertyName = propertyName,
                prefixPolymorphic = prefixPolymorphic
            )
        }>"

        else -> when {
            propertyName == null -> toKotlinTypeNoValueClasses(prefixPolymorphic)
            className == "User" && propertyName == "id" -> "UserId"
            propertyName == "user_id" -> "UserId"
            className == "Chat" && propertyName == "id" -> "ChatId"
            className == "ChatFullInfo" && propertyName == "id" -> "ChatId"
            propertyName == "chat_id" -> "ChatId"
            propertyName.endsWith("_chat_id") -> "ChatId"
            propertyName == "message_id" -> "MessageId"
            propertyName == "message_ids" -> "MessageId"
            className == "BusinessConnection" && propertyName == "id" -> "BusinessConnectionId"
            propertyName == "business_connection_id" -> "BusinessConnectionId"
            propertyName == "message_thread_id" -> "MessageThreadId"
            propertyName == "message_effect_id" -> "MessageEffectId"
            else -> toKotlinTypeNoValueClasses(prefixPolymorphic)
        }
    }
}

private fun TelegramType.toKotlinTypeNoValueClasses(
    prefixPolymorphic: String = "",
): String = when (this) {
    is TelegramType.Declared -> name
    is TelegramType.ListType<*> -> "List<${
        elementType.toKotlinTypeNoValueClasses(
            prefixPolymorphic = prefixPolymorphic
        )
    }>"

    TelegramType.Integer -> "Long"
    TelegramType.StringType -> name
    TelegramType.Boolean -> name
    TelegramType.Float -> name
    TelegramType.CallbackGame,
    TelegramType.InputFile,
    TelegramType.ForumTopicClosed,
    TelegramType.ForumTopicReopened,
    TelegramType.GeneralForumTopicHidden,
    TelegramType.GeneralForumTopicUnhidden,
    TelegramType.VoiceChatStarted,
    TelegramType.VideoChatStarted,
    TelegramType.GiveawayCreated -> "${prefixPolymorphic}Any"

    TelegramType.ParseMode -> name

    is TelegramType.Super -> "${prefixPolymorphic}$name"

    is TelegramType.WithAlternative -> {
        when (this) {
            // Example: TelegramType.WithAlternative.InputFileOrString -> if (validTypes.isEmpty()) "v1" else "v2"
            // Example 2: TelegramType.WithAlternative.InputFileOrString -> "${prefixPolymorphic}Any"
            TelegramType.WithAlternative.InputFileOrString -> "String"
            TelegramType.WithAlternative.IntegerOrString -> "String"
        }
    }
}

private fun TelegramType.toKotlinSerializerType(): String = when (this) {
    is TelegramType.ListType<*> -> "ListSerializer(${elementType.toKotlinSerializerType()})"
    else -> "${toKotlinTypeNoValueClasses()}.serializer()"
}