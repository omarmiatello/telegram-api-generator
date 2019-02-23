import org.jsoup.Jsoup
import java.io.File

fun main() {
    val sections = Jsoup.parse(File("data/telegramapi.html").readText()).toSection()
    println("NOTE: You should handle also types:")
    println(sections.findUnknownTypes().joinToString("\n") { "`$it`" })
    sections.toReadmeExample()
    sections.toKotlinFile()
}

private fun List<Section>.toReadmeExample() = forEach { section ->
    println("\n\n## ${section.name}")
    if (section.types.isNotEmpty()) {
        println("\n### Data Types")
        section.types.forEach { dataType ->
            println("    ${dataType.name}(${dataType.fields.map { f -> "${f.name}: ${f.type}" }.joinToString()})")
        }
    }
    if (section.methods.isNotEmpty()) {
        println("\n### Methods")
        section.methods.forEach { method ->
            println("    ${method.name}(${method.parameter.map { p -> "${p.name}: ${p.type}" }.joinToString()})")
        }
    }
}

