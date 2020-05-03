fun List<DocSection>.toReadmeFullExample() = buildString {
    this@toReadmeFullExample.forEach { section ->
        appendln("\n\n## ${section.name}")
        if (section.docTypes.isNotEmpty()) {
            appendln("\n### Data Types")
            section.docTypes.forEach { dataType ->
                appendln("#### ${dataType.name}")
                appendln()
                appendln("    ${dataType.name}(${dataType.docFields.map { f -> "${f.name}: ${f.type}" }
                    .joinToString()})")
                appendln()
                appendln(dataType.description)
                if (dataType.docFields.isNotEmpty()) {
                    appendln()
                    appendln("| name | type | required | description |")
                    appendln("|---|---|---|---|")
                    dataType.docFields.forEach { field ->
                        appendln("| ${field.name} | ${field.type} | ${field.required} | ${field.description} |")
                    }
                }
                appendln()
            }
        }
        if (section.docMethods.isNotEmpty()) {
            appendln("\n### Methods")
            section.docMethods.forEach { method ->
                appendln("#### ${method.name}")
                appendln()
                appendln("    ${method.name}(${method.docParameters.map { p -> "${p.name}: ${p.type}" }
                    .joinToString()})")
                appendln()
                appendln(method.description)
                if (method.docParameters.isNotEmpty()) {
                    appendln()
                    appendln("| name | type | required | description |")
                    appendln("|---|---|---|---|")
                    method.docParameters.forEach { parameter ->
                        appendln("| ${parameter.name} | ${parameter.type} | ${parameter.required} | ${parameter.description} |")
                    }
                }
                appendln()
            }
        }
    }
}

fun List<DocSection>.toReadmeSmallExample() = buildString {
    this@toReadmeSmallExample.forEach { section ->
        appendln("\n\n## ${section.name}")
        if (section.docTypes.isNotEmpty()) {
            appendln("\n### Data Types")
            section.docTypes.forEach { dataType ->
                appendln(dataType.description)
                appendln()
                appendln("    ${dataType.name}(${dataType.docFields.map { f -> "${f.name}: ${f.type}" }
                    .joinToString()})")
                appendln()
            }
        }
        if (section.docMethods.isNotEmpty()) {
            appendln("\n### Methods")
            section.docMethods.forEach { method ->
                appendln(method.description)
                appendln()
                appendln("    ${method.name}(${method.docParameters.map { p -> "${p.name}: ${p.type}" }
                    .joinToString()})")
                appendln()
            }
        }
    }
}