import org.jsoup.Jsoup
import java.io.File

fun main() {
    val docSections = Jsoup.parse(File("data/telegramapi.html").readText()).toSection()
    docSections.apply {
        toReadmeExample()
        toKotlin()
        toJson()
    }
}