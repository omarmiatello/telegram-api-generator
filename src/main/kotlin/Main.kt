import org.jsoup.Jsoup
import java.io.File

fun main() {
    val docs = Jsoup.parse(File("data/telegramapi.html").readText()).toSection()

    File("example/telegram.md").writeText(docs.toReadmeExample())
    File("example/telegram.json").writeText(docs.toJson())
    File("out/models.kt").writeText(docs.toKotlinModels())
    File("out/api.kt").writeText(docs.toKotlinApi())
}