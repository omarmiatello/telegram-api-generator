fun List<DocSection>.toReadmeFullExample() = buildString {
    this@toReadmeFullExample.forEach { section ->
        appendLine("\n\n## ${section.name}")
        if (section.docTypes.isNotEmpty()) {
            appendLine("\n### Data Types")
            section.docTypes.forEach { dataType ->
                appendLine("#### ${dataType.name}")
                appendLine()
                appendLine("    ${dataType.name}(${dataType.docFields.map { f -> "${f.name}: ${f.type}" }
                    .joinToString()})")
                appendLine()
                appendLine(dataType.description)
                if (dataType.docFields.isNotEmpty()) {
                    appendLine()
                    appendLine("| name | type | required | description |")
                    appendLine("|---|---|---|---|")
                    dataType.docFields.forEach { field ->
                        appendLine("| ${field.name} | ${field.type} | ${field.required} | ${field.description} |")
                    }
                }
                appendLine()
            }
        }
        if (section.docMethods.isNotEmpty()) {
            appendLine("\n### Methods")
            section.docMethods.forEach { method ->
                appendLine("#### ${method.name}")
                appendLine()
                appendLine("    ${method.name}(${method.docParameters.map { p -> "${p.name}: ${p.type}" }
                    .joinToString()})")
                appendLine()
                appendLine(method.description)
                if (method.docParameters.isNotEmpty()) {
                    appendLine()
                    appendLine("| name | type | required | description |")
                    appendLine("|---|---|---|---|")
                    method.docParameters.forEach { parameter ->
                        appendLine("| ${parameter.name} | ${parameter.type} | ${parameter.required} | ${parameter.description} |")
                    }
                }
                appendLine()
            }
        }
    }
}

fun List<DocSection>.toReadmeSmallExample() = buildString {
    this@toReadmeSmallExample.forEach { section ->
        appendLine("\n\n## ${section.name}")
        if (section.docTypes.isNotEmpty()) {
            appendLine("\n### Data Types")
            section.docTypes.forEach { dataType ->
                appendLine(dataType.description)
                appendLine()
                appendLine("    ${dataType.name}(${dataType.docFields.map { f -> "${f.name}: ${f.type}" }
                    .joinToString()})")
                appendLine()
            }
        }
        if (section.docMethods.isNotEmpty()) {
            appendLine("\n### Methods")
            section.docMethods.forEach { method ->
                appendLine(method.description)
                appendLine()
                appendLine("    ${method.name}(${method.docParameters.map { p -> "${p.name}: ${p.type}" }
                    .joinToString()})")
                appendLine()
            }
        }
    }
}

fun List<DocSection>.toReadmeTinyExample() = buildString {
    appendLine("### Data Types")
    this@toReadmeTinyExample.forEach { section ->
            section.docTypes.forEach { dataType ->
                val parameters = dataType.docFields.map { f -> "${f.name}: ${f.type}" }.joinToString()
                appendLine("    ${dataType.name}($parameters)")
            }
    }
    appendLine("\n### Methods")
    this@toReadmeTinyExample.forEach { section ->
            section.docMethods.forEach { method ->
                val parameters = method.docParameters.map { p -> "${p.name}: ${p.type}" }.joinToString()
                appendLine("    ${method.name}($parameters)")
            }
    }
}