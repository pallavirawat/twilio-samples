import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonConfiguration
import kotlinx.serialization.list

class JsonReader {
    companion object {
        fun readContacts(): List<Contact> {
            val filePath = "contacts.json"
            val fileContent = this::class.java.classLoader.getResource(filePath)?.readText()
            fileContent?.let { content ->
                return try {
                    val json = Json(JsonConfiguration.Stable)
                    json.parse(Contact.serializer().list, content)
                } catch (exception: Exception) {
                    listOf()
                }
            }
            return listOf()
        }
    }
}
