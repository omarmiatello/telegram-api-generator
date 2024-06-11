import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import kotlinx.coroutines.runBlocking
import org.jsoup.Jsoup
import java.io.File

fun main() = runBlocking {
    println("🏁 Start")

    val docs = Jsoup.parse(
        HttpClient(CIO).get("https://core.telegram.org/bots/api").bodyAsText()
            .also { File("data/telegramapi.html").writeText(it) }
    ).toSection()

    val docsRequiredFirst = docs.map { doc ->
        doc.copy(
            docTypes = doc.docTypes.map { type ->
                type.copy(
                    docFields = type.docFields.sortedByDescending { it.required }
                )
            },
            docMethods = doc.docMethods.map { method ->
                method.copy(
                    docParameters = method.docParameters.sortedByDescending { it.required }
                )
            }
        )
    }

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
    File("example/TelegramModelsOnly.kt").writeText(docsRequiredFirst.toKotlinModels(useKotlinXSerialization = false))
    File("example/TelegramModels.kt").writeText(docsRequiredFirst.toKotlinModels(useKotlinXSerialization = true))
    File("example/TelegramClient.kt").writeText(docsRequiredFirst.toKotlinMethods())
    File("example/TelegramModels.rs").writeText(docs.toRustModels())

    println("🎉 $version - Examples generated!")
}