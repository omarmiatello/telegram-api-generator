
import org.jsoup.Jsoup
import java.io.File

fun main() {
    val sections = webpageToSection(Jsoup.parse(File("data/telegramapi.html").readText()))
    sections.forEach {
        println(it.name)
        it.types.forEach {
            println("type: ${it.name} ${it.fields.map { it.name }}")
        }
        it.methods.forEach {
            println("method: ${it.name}(${it.parameter.map { it.name }.joinToString()})")
        }
    }
}
