import org.jsoup.Jsoup
import java.io.File

fun main() {
    val docs = Jsoup.parse(File("data/telegramapi.html").readText()).toSection()

    File("example/telegram.md").writeText(docs.toReadmeSmallExample())
    File("example/telegram_tiny.md").writeText(docs.toReadmeTinyExample())
    File("example/telegram_full.md").writeText(docs.toReadmeFullExample())
    File("example/telegram.json").writeText(docs.toJson())
    File("example/TelegramModelsOnly.kt").writeText(docs.toKotlinModels(useKotlinXSerialization = false))
    File("example/TelegramModels.kt").writeText(docs.toKotlinModels(useKotlinXSerialization = true))
    File("example/TelegramClient.kt").writeText(docs.toKotlinMethods())
    File("example/TelegramModels.rs").writeText(docs.toRustModels())
}