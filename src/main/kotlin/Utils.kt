fun String.fixType() = when (this) {
    "Float number" -> "Float"
    "True" -> "Boolean"
    else -> this
}

fun List<Section>.findUnknownTypes(): List<String> {
    val types = flatMap { it.types }.associateBy { it.name }
    return (types.flatMap { (name, type) ->
        type.fields.mapNotNull {
            val fieldType = it.type.replace("Array of ", "")
            if (fieldType !in types) {
                fieldType
            } else null
        }
    } + flatMap {
        it.methods.flatMap {
            it.parameter.mapNotNull {
                val fieldType = it.type.replace("Array of ", "")
                if (fieldType !in types) {
                    fieldType
                } else null
            }
        }
    }).distinct()
}

