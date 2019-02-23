
import org.jsoup.Jsoup
import java.io.File

fun main() {
    val sections = webpageToSection(Jsoup.parse(File("data/telegramapi.html").readText()))
    sections.forEach {
        println("\n\n## ${it.name}")
        if (it.types.isNotEmpty()) {
            println("\n### Data Types")
            it.types.forEach {
                println("    ${it.name}(${it.fields.map { "${it.name}: ${it.type}" }.joinToString()})")
            }
        }
        if (it.methods.isNotEmpty()) {
            println("\n### Methods")
            it.methods.forEach {
                println("    ${it.name}(${it.parameter.map { "${it.name}: ${it.type}" }.joinToString()})")
            }
        }
    }
}
