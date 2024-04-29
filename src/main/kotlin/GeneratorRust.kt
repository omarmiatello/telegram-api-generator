fun List<DocSection>.toRustModels() = buildString {
    appendLine(comment("--- Parameters & Responses ---"))
    this@toRustModels.forEach { section ->
        if (section.docTypes.isNotEmpty()) {
            appendLine(comment(section.name))
            section.docTypes.forEach { type ->
                appendLine(type.toRustDoc())
                appendLine(type.toRustDataClass())
                appendLine()
            }
        }
    }
    appendLine(comment("--- Requests ---"))
    this@toRustModels.forEach { section ->
        if (section.docMethods.isNotEmpty()) {
            appendLine(comment(section.name))
            section.docMethods.forEach { method ->
                if (method.docParameters.isNotEmpty()) {
                    appendLine(method.toRustDoc(showReturn = false))
                    appendLine(method.toRustDataClass())
                    appendLine()
                }
            }
        }
    }
}

private fun comment(text: String) = buildString {
    appendLine()
    appendLine("/// $text")
}

private fun DocType.toRustDoc() = buildString {
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

private fun DocMethod.toRustDoc(showReturn: Boolean = true) = buildString {
    appendLine("/**")
    appendLine(" * ${description.replace("\n", "\n * ")}")
    appendLine(" *")
    docParameters.forEach {
        appendLine(" * @property ${it.name} ${it.description}")
    }
    if (showReturn) {
        appendLine(" *")
        appendLine(" * @return [${returns.toRustType()}]")
    }
    append(" * */")
}

private fun DocType.toRustDataClass() = buildString {
    appendLine("#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]")
    appendLine("pub struct $name {")
    docFields.forEachIndexed { index, field ->
        appendLine("    /// ${field.description}")
        if (!field.required) appendLine("    #[serde(skip_serializing_if = \"Option::is_none\")]")
        if (field.name == "type") {
            appendLine("    #[serde(rename = \"type\")]")
            append("    pub type_: ${field.toRustType()}")
        } else {
            append("    pub ${field.name}: ${field.toRustType()}")
        }
        if (index == docFields.lastIndex) appendLine() else appendLine(",")
    }
    append("}")
}

private fun DocMethod.toRustDataClass() = buildString {
    appendLine("#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]")
    appendLine("pub struct ${name.capitalize()}Request {")
    docParameters.forEachIndexed { index, field ->
        appendLine("    /// ${field.description}")
        if (field.name == "type") {
            appendLine("    #[serde(rename = \"type\")]")
            append("    pub type_: ${field.toRustType()}")
        } else {
            append("    pub ${field.name}: ${field.toRustType()}")
        }
        if (index == docParameters.lastIndex) appendLine() else appendLine(",")
    }
    append("}")
}

private fun DocField.toRustType() =
    if (required) type.toRustType() else "Option<${type.toRustType()}>"

private fun DocParameter.toRustType() =
    if (required) type.toRustType() else "Option<${type.toRustType()}>"

private fun TelegramType.toRustType(): String = when (this) {
    is TelegramType.Declared -> name
    is TelegramType.ListType<*> -> "Vec<${elementType.toRustType()}>"
    TelegramType.Integer -> name
    TelegramType.StringType -> name
    TelegramType.Boolean -> "bool"
    TelegramType.Float -> name
    TelegramType.CallbackGame,
    TelegramType.InputFile,
    TelegramType.ForumTopicClosed,
    TelegramType.ForumTopicReopened,
    TelegramType.GeneralForumTopicHidden,
    TelegramType.GeneralForumTopicUnhidden,
    TelegramType.GiveawayCreated -> name

    TelegramType.ParseMode -> name
    TelegramType.VoiceChatStarted,
    TelegramType.MenuButton,
    TelegramType.VideoChatStarted -> name

    is TelegramType.Super -> {
        when (this) {
            TelegramType.Super.InputMedia,
            TelegramType.Super.InputMessageContent,
            TelegramType.Super.InlineQueryResult,
            TelegramType.Super.PassportElementError,
            TelegramType.Super.ChatMember,
            TelegramType.Super.BotCommandScope,
            TelegramType.Super.ReactionType,
            TelegramType.Super.MessageOrigin,
            TelegramType.Super.ChatBoostSource -> name
        }
    }

    is TelegramType.WithAlternative -> {
        when (this) {
            // Example: TelegramType.WithAlternative.InputFileOrString -> if (validTypes.isEmpty()) "v1" else "v2"
            // Example 2: TelegramType.WithAlternative.InputFileOrString -> "${prefixPolymorphic}Any"
            TelegramType.WithAlternative.InputFileOrString -> "String"
            TelegramType.WithAlternative.IntegerOrString -> "String"
            TelegramType.WithAlternative.KeyboardOption,
            TelegramType.WithAlternative.MaybeInaccessibleMessage -> name
        }
    }
}
