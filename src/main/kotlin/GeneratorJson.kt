import com.google.gson.Gson
import java.io.File

fun List<DocSection>.toJson() {
    File("out/example.json").writer().apply {
        write(Gson().newBuilder().setPrettyPrinting().create().toJson(this@toJson))
        close()
    }
}

