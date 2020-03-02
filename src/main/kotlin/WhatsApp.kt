import com.twilio.Twilio
import com.twilio.rest.api.v2010.account.Message
import com.twilio.type.PhoneNumber
import kotlinx.serialization.Serializable

@Serializable
data class Contact(val name: String, val number: String)

fun main() {
    val ACCOUNT_SID = System.getenv("ACCOUNT_SID")
    val AUTH_TOKEN = System.getenv("AUTH_TOKEN")
    Twilio.init(ACCOUNT_SID, AUTH_TOKEN)

    val contacts = JsonReader.readContacts()

    contacts.forEach {
        val message = Message.creator(
            PhoneNumber("whatsapp:${it.number}"),
            PhoneNumber("whatsapp:${System.getenv("FROM_NO")}"),
            "Hello, there ${it.name}! Whatcha doing???"
        )
            .create()

        println(message)
    }

}

