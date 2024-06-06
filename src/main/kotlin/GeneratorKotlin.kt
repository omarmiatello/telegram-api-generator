import kotlinx.serialization.KSerializer
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.json.JsonElement
import java.util.*

fun List<DocSection>.toKotlinModels(useKotlinXSerialization: Boolean) = buildString {
    val allType = this@toKotlinModels.flatMap { section ->
        section.docTypes.map { TelegramType.from(it.name) }
    }
    if (useKotlinXSerialization) {
        appendLine("@file:UseSerializers(")
        TelegramType.allSuper.forEach { type ->
            appendLine("    ${type.name}Serializer::class,")
        }
        appendLine(")")
        appendLine("@file:OptIn(InternalSerializationApi::class, ExperimentalSerializationApi::class)\n")
    }
    appendLine("package com.github.omarmiatello.telegram\n")
    if (useKotlinXSerialization) {
        appendLine("import kotlinx.serialization.Contextual")
        appendLine("import kotlinx.serialization.InternalSerializationApi")
        appendLine("import kotlinx.serialization.KSerializer")
        appendLine("import kotlinx.serialization.SerialName")
        appendLine("import kotlinx.serialization.Serializable")
        appendLine("import kotlinx.serialization.UseSerializers")
        appendLine("import kotlinx.serialization.descriptors.PolymorphicKind")
        appendLine("import kotlinx.serialization.descriptors.SerialDescriptor")
        appendLine("import kotlinx.serialization.descriptors.buildSerialDescriptor")
        appendLine("import kotlinx.serialization.encoding.Decoder")
        appendLine("import kotlinx.serialization.encoding.Encoder")
        appendLine("import kotlinx.serialization.json.Json")
        appendLine("import kotlinx.serialization.json.JsonElement")
        appendLine("import kotlinx.serialization.json.JsonObject")
        appendLine("import kotlinx.serialization.json.JsonPrimitive")
        appendLine("import kotlinx.serialization.json.jsonObject")
        appendLine("import kotlinx.serialization.json.jsonPrimitive")
        appendLine("import kotlinx.serialization.json.long")
        appendLine("import kotlinx.serialization.serializer\n")
        appendLine("private val json = Json {")
        appendLine("    ignoreUnknownKeys = true")
        appendLine("    prettyPrint = true")
        appendLine("    encodeDefaults = false")
        appendLine("}\n")
        appendLine("sealed class TelegramModel {")
        appendLine("    abstract fun toJson(): String")
        appendLine("}")
        appendLine()

        appendLine("private fun <T> Decoder.tryDeserializers(vararg serializers: KSerializer<out T>): T {")
        appendLine("    val jsonElement = decodeSerializableValue(JsonElement.serializer())")
        appendLine("    return serializers.firstNotNullOf { serializer ->")
        appendLine("        try {")
        appendLine("            json.decodeFromJsonElement(serializer, jsonElement)")
        appendLine("        } catch (e: Exception) {")
        appendLine("            null")
        appendLine("        }")
        appendLine("    }")
        appendLine("}")
    } else {
        appendLine("sealed class TelegramModel")
    }
    appendLine()
    TelegramType.allSuper.forEach { type ->
        val superType = TelegramType.from(type.name).superType ?: "TelegramModel"
        if (useKotlinXSerialization) appendLine("@Serializable(with = ${type.name}Serializer::class)")
        appendLine("sealed class ${type.name} : $superType()")
        if (useKotlinXSerialization) {
            appendLine("object ${type.name}Serializer : KSerializer<${type.name}> {")
            appendLine("    override val descriptor: SerialDescriptor = buildSerialDescriptor(")
            appendLine("        \"JsonContentPolymorphicSerializer<${type.name}>\",")
            appendLine("        PolymorphicKind.SEALED,")
            appendLine("    )")
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
                    appendLine("    override fun deserialize(decoder: Decoder): ${type.name} =")
                    if (type.deserializer.isEmpty()) {
                        appendLine("        decoder.tryDeserializers(${allSubtype.joinToString { it.name + ".serializer()" }})")
                    } else {
                        appendLine("        decoder.decodeSerializableValue(JsonElement.serializer()).let { jsonElement ->")
                        appendLine("            json.decodeFromJsonElement(")
                        appendLine("                deserializer = ${type.deserializer},")
                        appendLine("                element = jsonElement,")
                        appendLine("            )")
                        appendLine("        }")
                    }
                }

                else -> {
                    appendLine("    override fun deserialize(decoder: Decoder): ${type.name} = TODO()")
                }
            }
            appendLine("}")
            appendLine()
        }
    }
    if (useKotlinXSerialization) appendLine("@Serializable")
    appendLine("data class TelegramResponse<T>(val ok: Boolean, val result: T? = null)")
    appendLine()
    appendLine(comment("--- Utility ---"))
    appendLine()
    appendLine("enum class ParseMode { MarkdownV2, Markdown, HTML }")
    appendLine()
    if (useKotlinXSerialization) appendLine("fun String.parseTelegramRequest() = Update.fromJson(this)")
    appendLine()
    this@toKotlinModels.forEach { section ->
        if (section.docTypes.isNotEmpty()) {
            appendLine(comment(section.name))
            appendLine()
            section.docTypes.forEach { type ->
                appendLine(type.toKotlinDoc())
                if (useKotlinXSerialization) appendLine("@Serializable")
                appendLine(type.toKotlinDataClass(useKotlinXSerialization))
                appendLine()
            }
        }
    }
    appendLine(comment("--- Requests ---"))
    appendLine()
    appendLine("sealed class TelegramRequest {")
    if (useKotlinXSerialization) appendLine("    abstract fun toJsonForRequest(): String")
    if (useKotlinXSerialization) appendLine("    abstract fun toJsonForResponse(): String")
    this@toKotlinModels.forEach { section ->
        if (section.docMethods.isNotEmpty()) {
            appendLine()
            appendLine("    " + comment(section.name))
            section.docMethods.forEach { method ->
                if (method.docParametersSorded.isNotEmpty()) {
                    appendLine()
                    appendLine(method.toKotlinDoc(showReturn = false))
                    if (useKotlinXSerialization) appendLine("    @Serializable")
                    appendLine(method.toKotlinDataClass(useKotlinXSerialization))
                }
            }
        }
    }
    appendLine("}")
}

fun List<DocSection>.toKotlinMethods() = buildString {
    appendLine("@file:Suppress(\"ktlint:standard:no-wildcard-imports\")")
    appendLine()
    appendLine("package com.github.omarmiatello.telegram\n")
    appendLine("import com.github.omarmiatello.telegram.TelegramRequest.*")
    appendLine("import io.ktor.client.HttpClient")
    appendLine("import io.ktor.client.call.body")
    appendLine("import io.ktor.client.request.get")
    appendLine("import io.ktor.client.request.post")
    appendLine("import io.ktor.client.request.setBody")
    appendLine("import io.ktor.http.ContentType")
    appendLine("import io.ktor.http.content.TextContent")
    appendLine("import kotlinx.serialization.KSerializer")
    appendLine("import kotlinx.serialization.builtins.ListSerializer")
    appendLine("import kotlinx.serialization.builtins.serializer")
    appendLine("import kotlinx.serialization.json.Json")
    appendLine()
    appendLine("class TelegramClient(")
    appendLine("    apiKey: String,")
    appendLine("    private val httpClient: HttpClient = HttpClient(),")
    appendLine("    private val apiUrl: String = \"https://api.telegram.org\",")
    appendLine("    private val requestConfigurer: suspend HttpRequestBuilder.() -> Unit = {},")
    appendLine(") {")
    appendLine("""    private val basePath = "${"$"}apiUrl/bot${"$"}apiKey"""")
    appendLine("    private val json = Json {")
    appendLine("        ignoreUnknownKeys = true")
    appendLine("        prettyPrint = true")
    appendLine("        encodeDefaults = false")
    appendLine("    }")
    appendLine()
    appendLine("    private suspend fun <T> telegramGet(path: String, serializer: KSerializer<T>): TelegramResponse<T> {")
    appendLine("        val responseString: String = httpClient.get(path) {")
    appendLine("            this.requestConfigurer()")
    appendLine("        }.body()")
    appendLine("        return json.decodeFromString(TelegramResponse.serializer(serializer), responseString)")
    appendLine("    }")
    appendLine()
    appendLine("    private suspend fun <T> telegramPost(path: String, body: String, serializer: KSerializer<T>): TelegramResponse<T> {")
    appendLine("        val responseString: String = httpClient")
    appendLine("            .post(path) {")
    appendLine("                setBody(TextContent(body, ContentType.Application.Json))")
    appendLine("                this.requestConfigurer()")
    appendLine("            }")
    appendLine("            .body()")
    appendLine("        return json.decodeFromString(TelegramResponse.serializer(serializer), responseString)")
    appendLine("    }")

    this@toKotlinMethods.forEach { section ->
        if (section.docMethods.isNotEmpty()) {
            appendLine()
            appendLine("    " + comment(section.name))
            section.docMethods.forEach { method ->
                appendLine(method.toKotlinRequestMethod())
            }
        }
    }
    appendLine("}")
}

private fun comment(text: String) = buildString {
    val trimmed = text.trim('\n', '\t', ' ')
    append("// $trimmed")
}

private fun DocType.toKotlinDoc() = buildString {
    appendLine("/**")
    appendLine(" * ${description.replace("\n", "\n * ")}")
    appendLine(" *")
    docFields.forEach {
        appendLine(" * @property ${it.name.snakeToCamelCase()} ${it.description}")
    }
    appendLine(" *")
    appendLine(" * @constructor Creates a [$name].")
    append(" * */")
}

private fun DocMethod.toKotlinDoc(showReturn: Boolean = true) = buildString {
    appendLine("    /**")
    appendLine("     * ${description.replace("\n", "\n     * ")}")
    appendLine("     *")
    docParametersSorded.forEach {
        appendLine("     * @property ${it.name.snakeToCamelCase()} ${it.description}")
    }
    if (showReturn) {
        appendLine("     *")
        appendLine("     * @return [${returns.toKotlinType()}]")
    }
    append("     * */")
}

private fun DocType.toKotlinDataClass(useKotlinXSerialization: Boolean) = buildString {
    appendLine("data class $name(")
    docFields.forEachIndexed { index, field ->
        if (useKotlinXSerialization) {
            appendLine("    @SerialName(\"${field.name}\")")
        }
        appendLine("    val ${field.name.snakeToCamelCase()}: ${field.toKotlinType(useKotlinXSerialization)},")
    }
    val superType = TelegramType.from(name).superType ?: "TelegramModel"
    if (useKotlinXSerialization) {
        appendLine(") : $superType() {")
        appendLine("    override fun toJson() = json.encodeToString(serializer(), this)")
        appendLine("    companion object {")
        appendLine("        fun fromJson(string: String): $name = json.decodeFromString(serializer(), string)")
        appendLine("    }")
        append("}")
    } else {
        append(") : $superType()")
    }
}

private fun DocMethod.toKotlinDataClass(useKotlinXSerialization: Boolean) = buildString {
    val nameWithReplacedFirstChar =
        name.replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() }
    appendLine("    data class ${nameWithReplacedFirstChar}Request(")
    docParametersSorded.forEachIndexed { index, field ->
        if (useKotlinXSerialization) {
            appendLine("        @SerialName(\"${field.name}\")")
        }
        appendLine("        val ${field.name.snakeToCamelCase()}: ${field.toKotlinType(useKotlinXSerialization)},")
    }
    if (useKotlinXSerialization) {
        appendLine("    ) : TelegramRequest() {")
        appendLine("        override fun toJsonForRequest() = json.encodeToString(serializer(), this)")
        appendLine("        override fun toJsonForResponse() = JsonObject(")
        appendLine("            json.encodeToJsonElement(serializer(), this).jsonObject + (\"method\" to JsonPrimitive(\"$name\"))")
        appendLine("        ).toString()")
        appendLine("        companion object {")
        appendLine("            fun fromJson(string: String): ${nameWithReplacedFirstChar}Request = json.decodeFromString(serializer(), string)")
        appendLine("        }")
        append("    }")
    } else {
        append("    ) : TelegramRequest()")
    }
}

private fun DocMethod.toKotlinRequestMethod() = buildString {
    val path = """"${"$"}basePath/$name""""
    val nameWithReplacedFirstChar =
        name.replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() }
    appendLine()
    appendLine(toKotlinDoc())
    if (docParametersSorded.isEmpty()) {
        appendLine("    suspend fun $name() = telegramGet(")
        appendLine("        $path,")
        appendLine("        ${returns.toKotlinSerializerType()},")
        append("    )")
    } else {
        appendLine("    suspend fun $name(")
        docParametersSorded.forEachIndexed { index, parameter ->
            appendLine("        ${parameter.name.snakeToCamelCase()}: ${parameter.toKotlinType(useContextualSerialization = false)},")
        }
        appendLine("    ) = telegramPost(")
        appendLine("        $path,")
        appendLine("        ${nameWithReplacedFirstChar}Request(")
        docParametersSorded.forEachIndexed { index, parameter ->
            appendLine("            ${parameter.name.snakeToCamelCase()},")
        }
        appendLine("        ).toJsonForRequest(),")
        appendLine("        ${returns.toKotlinSerializerType()}")
        append("    )")
    }
}

private fun DocField.toKotlinType(useContextualSerialization: Boolean) =
    type.toKotlinType(if (useContextualSerialization) "@Contextual " else "") + if (required) "" else "? = null"

private fun DocParameter.toKotlinType(useContextualSerialization: Boolean) =
    type.toKotlinType(if (useContextualSerialization) "@Contextual " else "") + if (required) "" else "? = null"

private fun TelegramType.toKotlinType(prefixPolymorphic: String = ""): String = when (this) {
    is TelegramType.Declared -> name
    is TelegramType.ListType<*> -> "List<${elementType.toKotlinType(prefixPolymorphic)}>"
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
    else -> "${toKotlinType()}.serializer()"
}

private fun String.snakeToCamelCase(): String {
    val pattern = "_[a-z]".toRegex()
    return replace(pattern) { it.value.last().uppercase() }
}
