import org.jsoup.nodes.Document
import org.jsoup.nodes.Element

sealed class ValidData
data class Section(val name: String, val description: String, val types: List<Type>, val methods: List<Method>)
data class Type(val name: String, val description: String, val fields: List<Field>) : ValidData()
data class Field(val name: String, val description: String, val type: String, val required: Boolean)
data class Method(val name: String, val description: String, val parameter: List<Parameter>) : ValidData()
data class Parameter(val name: String, val description: String, val type: String, val required: Boolean)

fun webpageToSection(document: Document): List<Section> {
    val content = document.select("#dev_page_content").first()
    var splitBy = ""
    return content.children()
        .groupBy {
            if (it.tag().name == "h3") splitBy = it.text()
            splitBy
        }
        .mapValues<String, List<Element>, Map<String, List<Element>>> {
            splitBy = ""
            it.value.groupBy {
                if (it.tag().name == "h4") splitBy = it.text()
                splitBy
            }
        }
        .map { (h3, h3content) ->
            val validData = h3content.mapNotNull { (h4, h4content) ->
                var h4Desc = ""
                var fields: List<Field>? = null
                var parameters: List<Parameter>? = null
                h4content.forEach {
                    when (it.tag().name) {
                        "p" -> {
                            h4Desc += it.toString()
                            val text = it.text()
                            if ("Use this method" in text) parameters = emptyList()
                        }
                        "table" -> {
                            val tableHead = it.child(0).text()
                            val tableData = it.child(1)
                            when {
                                "Field" in tableHead -> {
                                    // Field Type Description
                                    fields = tableData.children().map {
                                        it.getElementsByTag("td").let {
                                            val fieldDesc = it[2].html()
                                            Field(it[0].text(), fieldDesc, it[1].text(), "Optional" !in fieldDesc)
                                        }
                                    }
                                }
                                "Parameter" in tableHead -> {
                                    // Parameter Type Required Description
                                    parameters = tableData.children().map {
                                        it.getElementsByTag("td").let {
                                            val fieldDesc = it[3].html()
                                            Parameter(it[0].text(), fieldDesc, it[1].text(), "Yes" == it[2].text())
                                        }
                                    }
                                }
                            }
                        }
                        "blockquote" -> h4Desc += it.toString()
                        "ul" -> h4Desc += it.toString()
                    }
                }

                val p = parameters
                val f = fields
                when {
                    p != null && f != null -> error("isMethod and isType: $h4")
                    p != null -> Method(h4, h4Desc, p)
                    f != null -> Type(h4, h4Desc, f)
                    else -> null
                }
            }
            Section(
                name = h3,
                description = h3content.getValue("").drop<Element?>(1).joinToString("\n"),
                types = validData.filterIsInstance(Type::class.java),
                methods = validData.filterIsInstance(Method::class.java)
            )
        }
        .filterNot {
            it.types.isEmpty() && it.methods.isEmpty()
        }
}
