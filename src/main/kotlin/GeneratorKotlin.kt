fun List<DocSection>.toKotlinModels(useKotlinXSerialization: Boolean) = buildString {
    appendln("package com.github.omarmiatello.telegram\n")
    if (useKotlinXSerialization) {
        appendln("import kotlinx.serialization.Contextual")
        appendln("import kotlinx.serialization.Serializable")
        appendln("import kotlinx.serialization.json.Json")
        appendln("import kotlinx.serialization.json.JsonObject")
        appendln("import kotlinx.serialization.json.JsonPrimitive")
        appendln("import kotlinx.serialization.json.jsonObject")
        appendln()
        appendln("private val json = Json { ignoreUnknownKeys = true; prettyPrint = true; encodeDefaults = false }")
        appendln("sealed class TelegramModel { abstract fun toJson(): String }")
    } else {
        appendln("sealed class TelegramModel")
    }
    TelegramType.allSuper.forEach { type ->
        val superType = TelegramType.from(type.name).superType ?: "TelegramModel"
        appendln("sealed class ${type.name} : $superType()")
    }
    if (useKotlinXSerialization) appendln("@Serializable")
    appendln("data class TelegramResponse<T>(val ok: Boolean, val result: T)")
    appendln(comment("--- Utility ---"))
    appendln("enum class ParseMode { MarkdownV2, Markdown, HTML }")
    if (useKotlinXSerialization) appendln("fun String.parseTelegramRequest() = Update.fromJson(this)")
    appendln(comment("--- Parameters & Responses ---"))
    this@toKotlinModels.forEach { section ->
        if (section.docTypes.isNotEmpty()) {
            appendln(comment(section.name))
            section.docTypes.forEach { type ->
                appendln(type.toKotlinDoc())
                if (useKotlinXSerialization) appendln("@Serializable")
                appendln(type.toKotlinDataClass(useKotlinXSerialization))
                appendln()
            }
        }
    }
    appendln(comment("--- Requests ---"))
    appendln("sealed class TelegramRequest {")
    if (useKotlinXSerialization) appendln("abstract fun toJsonForRequest(): String")
    if (useKotlinXSerialization) appendln("abstract fun toJsonForResponse(): String")
    this@toKotlinModels.forEach { section ->
        if (section.docMethods.isNotEmpty()) {
            appendln(comment(section.name))
            section.docMethods.forEach { method ->
                if (method.docParameters.isNotEmpty()) {
                    appendln(method.toKotlinDoc(showReturn = false))
                    if (useKotlinXSerialization) appendln("@Serializable")
                    appendln(method.toKotlinDataClass(useKotlinXSerialization))
                    appendln()
                }
            }
        }
    }
    appendln("}")
}

fun List<DocSection>.toKotlinMethods() = buildString {
    appendln("package com.github.omarmiatello.telegram\n")
    appendln("import com.github.omarmiatello.telegram.TelegramRequest.*")
    appendln("import io.ktor.client.HttpClient")
    appendln("import io.ktor.client.request.get")
    appendln("import io.ktor.client.request.post")
    appendln("import io.ktor.http.ContentType")
    appendln("import io.ktor.http.content.TextContent")
    appendln("import kotlinx.serialization.KSerializer")
    appendln("import kotlinx.serialization.builtins.ListSerializer")
    appendln("import kotlinx.serialization.builtins.serializer")
    appendln("import kotlinx.serialization.json.Json")
    appendln("import kotlinx.serialization.json.JsonConfiguration")
    appendln("class TelegramClient(apiKey: String, private val httpClient: HttpClient = HttpClient()) {")
    appendln("""    private val basePath = "https://api.telegram.org/bot${"$"}apiKey"""")
    appendln("    private val json = Json(JsonConfiguration.Stable.copy(ignoreUnknownKeys = true, prettyPrint = true, encodeDefaults = false))")
    appendln()
    appendln("    private suspend fun <T> telegramGet(path: String, response: KSerializer<T>): TelegramResponse<T> {")
    appendln("        val responseString = httpClient.get<String>(path)")
    appendln("        return json.decodeFromString(TelegramResponse.serializer(response), responseString)")
    appendln("    }")
    appendln()
    appendln("    private suspend fun <T> telegramPost(path: String, body: String, response: KSerializer<T>): TelegramResponse<T> {")
    appendln("        val responseString = httpClient.post<String>(path) {")
    appendln("            this.body = TextContent(body, ContentType.Application.Json)")
    appendln("        }")
    appendln("        return json.decodeFromString(TelegramResponse.serializer(response), responseString)")
    appendln("    }")

    this@toKotlinMethods.forEach { section ->
        if (section.docMethods.isNotEmpty()) {
            appendln(comment(section.name))
            section.docMethods.forEach { method ->
                appendln(method.toKotlinDoc())
                appendln(method.toKotlinRequestMethod())
            }
        }
    }
    appendln("}")
}

private fun comment(text: String) = buildString {
    appendln()
    appendln("// $text")
}

private fun DocType.toKotlinDoc() = buildString {
    appendln("/**")
    appendln(" * ${description.replace("\n", "\n * ")}")
    appendln(" *")
    docFields.forEach {
        appendln(" * @property ${it.name} ${it.description}")
    }
    appendln(" *")
    appendln(" * @constructor Creates a [$name].")
    append(" * */")
}

private fun DocMethod.toKotlinDoc(showReturn: Boolean = true) = buildString {
    appendln("/**")
    appendln(" * ${description.replace("\n", "\n * ")}")
    appendln(" *")
    docParameters.forEach {
        appendln(" * @property ${it.name} ${it.description}")
    }
    if (showReturn) {
        appendln(" *")
        appendln(" * @return [${returns.toKotlinType()}]")
    }
    append(" * */")
}

private fun DocType.toKotlinDataClass(useKotlinXSerialization: Boolean) = buildString {
    appendln("data class $name(")
    docFields.forEachIndexed { index, field ->
        appendLine("    val ${field.name}: ${field.toKotlinType(useKotlinXSerialization)},")
    }
    val superType = TelegramType.from(name).superType ?: "TelegramModel"
    if (useKotlinXSerialization) {
        appendln(") : $superType() {")
        appendln("    override fun toJson() = json.encodeToString(serializer(), this)")
        appendln("    companion object {")
        appendln("        fun fromJson(string: String) = json.decodeFromString(serializer(), string)")
        appendln("    }")
        append("}")
    } else {
        append(") : $superType()")
    }
}

private fun DocMethod.toKotlinDataClass(useKotlinXSerialization: Boolean) = buildString {
    appendln("data class ${name.capitalize()}Request(")
    docParameters.forEachIndexed { index, field ->
        appendln("    val ${field.name}: ${field.toKotlinType(useKotlinXSerialization)},")
    }
    if (useKotlinXSerialization) {
        appendln(") : TelegramRequest() {")
        appendln("    override fun toJsonForRequest() = json.encodeToString(serializer(), this)")
        appendln("    override fun toJsonForResponse() = JsonObject(")
        appendln("        json.encodeToJsonElement(serializer(), this).jsonObject + (\"method\" to JsonPrimitive(\"$name\"))")
        appendln("    ).toString()")
        appendln("    companion object {")
        appendln("        fun fromJson(string: String) = json.decodeFromString(serializer(), string)")
        appendln("    }")
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
        appendln("suspend fun $name(")
        docParameters.forEachIndexed { index, parameter ->
            appendLine("${parameter.name}: ${parameter.toKotlinType(useContextualSerialization = false)},")
        }
        appendln(") = telegramPost(")
        appendln("    $path,")
        appendln("    ${name.capitalize()}Request(")
        docParameters.forEachIndexed { index, parameter ->
            appendLine("        ${parameter.name},")
        }
        appendln("    ).toJsonForRequest(),")
        appendln("    ${returns.toKotlinSerializerType()}")
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
    TelegramType.Integer -> "Int"
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
            TelegramType.Super.PassportElementError -> "${prefixPolymorphic}$name"
        }
    }
    is TelegramType.WithAlternative -> {
        when (this) {
            // Example: TelegramType.WithAlternative.InputFileOrString -> if (validTypes.isEmpty()) "v1" else "v2"
            // Example 2: TelegramType.WithAlternative.InputFileOrString -> "${prefixPolymorphic}Any"
            TelegramType.WithAlternative.InputFileOrString -> "String"
            TelegramType.WithAlternative.IntegerOrString -> "String"
            TelegramType.WithAlternative.KeyboardOption -> "${prefixPolymorphic}$name"
        }
    }
}

private fun TelegramType.toKotlinSerializerType(): String = when (this) {
    is TelegramType.ListType<*> -> "ListSerializer(${elementType.toKotlinSerializerType()})"
    else -> "${toKotlinType()}.serializer()"
}