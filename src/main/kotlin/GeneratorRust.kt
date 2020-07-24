fun List<DocSection>.toRustModels() = buildString {
    appendln(comment("--- Parameters & Responses ---"))
    this@toRustModels.forEach { section ->
        if (section.docTypes.isNotEmpty()) {
            appendln(comment(section.name))
            section.docTypes.forEach { type ->
                appendln(type.toRustDoc())
                appendln(type.toRustDataClass())
                appendln()
            }
        }
    }
    appendln(comment("--- Requests ---"))
    this@toRustModels.forEach { section ->
        if (section.docMethods.isNotEmpty()) {
            appendln(comment(section.name))
            section.docMethods.forEach { method ->
                if (method.docParameters.isNotEmpty()) {
                    appendln(method.toRustDoc(showReturn = false))
                    appendln(method.toRustDataClass())
                    appendln()
                }
            }
        }
    }
}

private fun comment(text: String) = buildString {
    appendln()
    appendln("/// $text")
}

private fun DocType.toRustDoc() = buildString {
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

private fun DocMethod.toRustDoc(showReturn: Boolean = true) = buildString {
    appendln("/**")
    appendln(" * ${description.replace("\n", "\n * ")}")
    appendln(" *")
    docParameters.forEach {
        appendln(" * @property ${it.name} ${it.description}")
    }
    if (showReturn) {
        appendln(" *")
        appendln(" * @return [${returns.toRustType()}]")
    }
    append(" * */")
}

private fun DocType.toRustDataClass() = buildString {
    appendln("#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]")
    appendln("pub struct $name {")
    docFields.forEachIndexed { index, field ->
        appendln("    /// ${field.description}")
        if (!field.required) appendln("    #[serde(skip_serializing_if = \"Option::is_none\")]")
        if (field.name == "type") {
            appendln("    #[serde(rename = \"type\")]")
            append("    pub type_: ${field.toRustType()}")
        } else {
            append("    pub ${field.name}: ${field.toRustType()}")
        }
        if (index == docFields.lastIndex) appendln() else appendln(",")
    }
    append("}")
}

private fun DocMethod.toRustDataClass() = buildString {
    appendln("#[derive(Serialize, Deserialize, Clone, PartialEq, PartialOrd, Debug)]")
    appendln("pub struct ${name.capitalize()}Request {")
    docParameters.forEachIndexed { index, field ->
        appendln("    /// ${field.description}")
        if (field.name == "type") {
            appendln("    #[serde(rename = \"type\")]")
            append("    pub type_: ${field.toRustType()}")
        } else {
            append("    pub ${field.name}: ${field.toRustType()}")
        }
        if (index == docParameters.lastIndex) appendln() else appendln(",")
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
    TelegramType.InputFile -> name
    TelegramType.ParseMode -> name
    is TelegramType.Super -> {
        when (this) {
            TelegramType.Super.InputMedia,
            TelegramType.Super.InputMessageContent,
            TelegramType.Super.InlineQueryResult,
            TelegramType.Super.PassportElementError -> name
        }
    }
    is TelegramType.WithAlternative -> {
        when (this) {
            // Example: TelegramType.WithAlternative.InputFileOrString -> if (validTypes.isEmpty()) "v1" else "v2"
            // Example 2: TelegramType.WithAlternative.InputFileOrString -> "${prefixPolymorphic}Any"
            TelegramType.WithAlternative.InputFileOrString -> "String"
            TelegramType.WithAlternative.IntegerOrString -> "String"
            TelegramType.WithAlternative.KeyboardOption -> name
            TelegramType.WithAlternative.InputMediaPhotoOrVideo -> name
        }
    }
}
