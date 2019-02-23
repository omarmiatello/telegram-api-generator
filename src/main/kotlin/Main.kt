import org.jsoup.Jsoup
import java.io.File

fun main() {
    val sections = Jsoup.parse(File("data/telegramapi.html").readText()).toSection()
    sections.toReadmeExample()
    sections.toKotlin()
    sections.toJson()
}