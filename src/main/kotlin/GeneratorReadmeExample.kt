import java.io.File

fun List<Section>.toReadmeExample() {
    File("out/example.md").writer().apply {
        write("NOTE: You should handle also types:\n")
        write(findUnknownTypes().joinToString("\n") { "`$it`" })
        forEach { section ->
            write("\n\n## ${section.name}\n")
            if (section.types.isNotEmpty()) {
                write("\n### Data Types\n")
                section.types.forEach { dataType ->
                    write("    ${dataType.name}(${dataType.fields.map { f -> "${f.name}: ${f.type}" }.joinToString()})\n")
                }
            }
            if (section.methods.isNotEmpty()) {
                write("\n### Methods\n")
                section.methods.forEach { method ->
                    write("    ${method.name}(${method.parameters.map { p -> "${p.name}: ${p.type}" }.joinToString()})\n")
                }
            }
        }
        close()
    }
}

