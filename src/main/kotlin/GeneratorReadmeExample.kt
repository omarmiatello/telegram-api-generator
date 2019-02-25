fun List<DocSection>.toReadmeExample() = buildString {
    appendln("NOTE: You should handle also types:")
    appendln(findUnknownTypes().joinToString("\n") { "`$it`" })
    this@toReadmeExample.forEach { section ->
        appendln("\n\n## ${section.name}")
        if (section.docTypes.isNotEmpty()) {
            appendln("\n### Data Types")
            section.docTypes.forEach { dataType ->
                appendln("    ${dataType.name}(${dataType.docFields.map { f -> "${f.name}: ${f.type}" }.joinToString()})")
            }
        }
        if (section.docMethods.isNotEmpty()) {
            appendln("\n### Methods")
            section.docMethods.forEach { method ->
                appendln("    ${method.name}(${method.docParameters.map { p -> "${p.name}: ${p.type}" }.joinToString()})")
            }
        }
    }
}

