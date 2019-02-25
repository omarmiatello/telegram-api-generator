import java.io.File

fun List<DocSection>.toReadmeExample() {
    File("out/example.md").writer().apply {
        write("NOTE: You should handle also types:\n")
        write(findUnknownTypes().joinToString("\n") { "`$it`" })
        forEach { section ->
            write("\n\n## ${section.name}\n")
            if (section.docTypes.isNotEmpty()) {
                write("\n### Data Types\n")
                section.docTypes.forEach { dataType ->
                    write("    ${dataType.name}(${dataType.docFields.map { f -> "${f.name}: ${f.type}" }.joinToString()})\n")
                }
            }
            if (section.docMethods.isNotEmpty()) {
                write("\n### Methods\n")
                section.docMethods.forEach { method ->
                    write("    ${method.name}(${method.docParameters.map { p -> "${p.name}: ${p.type}" }.joinToString()})\n")
                }
            }
        }
        close()
    }
}

