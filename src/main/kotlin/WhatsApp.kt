import com.twilio.Twilio
import com.twilio.rest.api.v2010.account.Message
import com.twilio.type.PhoneNumber


fun main() {
    val ACCOUNT_SID = System.getenv("ACCOUNT_SID")
    val AUTH_TOKEN = System.getenv("AUTH_TOKEN")

    Twilio.init(ACCOUNT_SID, AUTH_TOKEN)
    val message = Message.creator(
        PhoneNumber("whatsapp:${System.getenv("MY_NO")}"),
        PhoneNumber("whatsapp:${System.getenv("FROM_NO")}"),
        "Hello, there! Whatcha doing???"
    )
        .create()

    println(message)
}

