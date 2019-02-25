import com.google.gson.GsonBuilder

private val gson = GsonBuilder().setPrettyPrinting().create()

fun List<DocSection>.toJson(): String = gson.toJson(this@toJson)

