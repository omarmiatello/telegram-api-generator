import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.request.*
import kotlinx.coroutines.runBlocking
import org.jsoup.Jsoup
import java.io.File

fun main() = runBlocking {
    println("🏁 Start")

    val docs = Jsoup.parse(
        HttpClient(CIO).get<String>("https://core.telegram.org/bots/api")
            .also { File("data/telegramapi.html").writeText(it) }
    ).toSection()
    val version = "Bot API ([\\d.]+)".toRegex().find(File("data/telegramapi.html").readText())?.value

    println("👓 $version - Parse completed")

    if (version != null) {
        File("README.md").also { readme ->
            readme.writeText(
                readme.readText().replace(
                    "Last update: Telegram Bot API \\S+".toRegex(),
                    "Last update: Telegram $version"
                )
            )
        }
    }
    File("example/telegram.md").writeText(docs.toReadmeSmallExample())
    File("example/telegram_tiny.md").writeText(docs.toReadmeTinyExample())
    File("example/telegram_full.md").writeText(docs.toReadmeFullExample())
    File("example/telegram.json").writeText(docs.toJson())
    File("example/TelegramModelsOnly.kt").writeText(docs.toKotlinModels(useKotlinXSerialization = false))
    File("example/TelegramModels.kt").writeText(docs.toKotlinModels(useKotlinXSerialization = true))
    File("example/TelegramClient.kt").writeText(docs.toKotlinMethods())
    File("example/TelegramModels.rs").writeText(docs.toRustModels())

    println("🎉 $version - Examples generated!")
}