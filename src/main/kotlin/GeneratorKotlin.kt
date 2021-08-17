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
        appendLine("import kotlinx.serialization.json.Json")
        appendLine("import kotlinx.serialization.json.JsonObject")
        appendLine("import kotlinx.serialization.json.JsonPrimitive")
        appendLine("import kotlinx.serialization.json.jsonObject")
        appendLine("import kotlinx.serialization.serializer\n")
        appendLine("private val json = Json {")
        appendLine("    ignoreUnknownKeys = true")
        appendLine("    prettyPrint = true")
        appendLine("    encodeDefaults = false")
        appendLine("}\n")
        appendLine("sealed class TelegramModel { abstract fun toJson(): String }")
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
            appendLine("    override fun deserialize(decoder: Decoder): ${type.name} = TODO()")
            appendLine("}")
        }
    }
    if (useKotlinXSerialization) appendLine("@Serializable")
    appendLine("data class TelegramResponse<T>(val ok: Boolean, val result: T)")
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
    appendLine("import io.ktor.client.HttpClient")
    appendLine("import io.ktor.client.request.get")
    appendLine("import io.ktor.client.request.post")
    appendLine("import io.ktor.http.ContentType")
    appendLine("import io.ktor.http.content.TextContent")
    appendLine("import kotlinx.serialization.KSerializer")
    appendLine("import kotlinx.serialization.builtins.ListSerializer")
    appendLine("import kotlinx.serialization.builtins.serializer")
    appendLine("import kotlinx.serialization.json.Json")
    appendLine("class TelegramClient(apiKey: String, private val httpClient: HttpClient = HttpClient()) {")
    appendLine("""    private val basePath = "https://api.telegram.org/bot${"$"}apiKey"""")
    appendLine("    private val json = Json { ignoreUnknownKeys = true; prettyPrint = true; encodeDefaults = false }")
    appendLine()
    appendLine("    private suspend fun <T> telegramGet(path: String, response: KSerializer<T>): TelegramResponse<T> {")
    appendLine("        val responseString = httpClient.get<String>(path)")
    appendLine("        return json.decodeFromString(TelegramResponse.serializer(response), responseString)")
    appendLine("    }")
    appendLine()
    appendLine("    private suspend fun <T> telegramPost(path: String, body: String, response: KSerializer<T>): TelegramResponse<T> {")
    appendLine("        val responseString = httpClient.post<String>(path) {")
    appendLine("            this.body = TextContent(body, ContentType.Application.Json)")
    appendLine("        }")
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
        appendLine(" * @return [${returns.toKotlinType()}]")
    }
    append(" * */")
}

private fun DocType.toKotlinDataClass(useKotlinXSerialization: Boolean) = buildString {
    appendLine("data class $name(")
    docFields.forEachIndexed { index, field ->
        appendLine("    val ${field.name}: ${field.toKotlinType(useKotlinXSerialization)},")
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
        appendLine("    val ${field.name}: ${field.toKotlinType(useKotlinXSerialization)},")
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
    val parameters = docParameters.map { f -> f.name }.joinToString(",\n")
    if (docParameters.isEmpty()) {
        append("suspend fun $name() = telegramGet($path, ${returns.toKotlinSerializerType()})")
    } else {
        appendLine("suspend fun $name(")
        docParameters.forEachIndexed { index, parameter ->
            appendLine("${parameter.name}: ${parameter.toKotlinType(useContextualSerialization = false)},")
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
    TelegramType.InputFile -> "${prefixPolymorphic}Any"
    TelegramType.ParseMode -> name
    TelegramType.VoiceChatStarted -> "${prefixPolymorphic}$name"
    is TelegramType.Super -> {
        when (this) {
            TelegramType.Super.InputMedia,
            TelegramType.Super.InputMessageContent,
            TelegramType.Super.InlineQueryResult,
            TelegramType.Super.PassportElementError,
            TelegramType.Super.BotCommandScope,
            TelegramType.Super.ChatMember -> "${prefixPolymorphic}$name"
        }
    }
    is TelegramType.WithAlternative -> {
        when (this) {
            // Example: TelegramType.WithAlternative.InputFileOrString -> if (validTypes.isEmpty()) "v1" else "v2"
            // Example 2: TelegramType.WithAlternative.InputFileOrString -> "${prefixPolymorphic}Any"
            TelegramType.WithAlternative.InputFileOrString -> "String"
            TelegramType.WithAlternative.IntegerOrString -> "String"
            TelegramType.WithAlternative.KeyboardOption,
            TelegramType.WithAlternative.InputMessageContent -> "${prefixPolymorphic}$name"
        }
    }
}

private fun TelegramType.toKotlinSerializerType(): String = when (this) {
    is TelegramType.ListType<*> -> "ListSerializer(${elementType.toKotlinSerializerType()})"
    else -> "${toKotlinType()}.serializer()"
}