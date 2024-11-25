package apps.task2;

import com.mailjet.client.ClientOptions;
import com.mailjet.client.MailjetClient;
import com.mailjet.client.MailjetRequest;
import com.mailjet.client.MailjetResponse;
import com.mailjet.client.resource.Emailv31;
import org.json.JSONArray;
import org.json.JSONObject;



public class MailSender {
    private MailjetClient client;

    public MailSender() {
        // Initialize the Mailjet client with API key and secret key
        this.client = new MailjetClient(ClientOptions.builder().apiKey("apiKey").apiSecretKey(secretKey).build());
    }

    public void sendMail(MailInfo mailInfo) {
        try {
            // Create the email message
            JSONObject message = new JSONObject();
            message.put(Emailv31.Message.FROM, new JSONObject()
                    .put("Email", "levlisik@gmail.com")
                    .put("Name", "noname company"));
            message.put(Emailv31.Message.TO, new JSONArray()
                    .put(new JSONObject()
                            .put("Email", mailInfo.getEmail())
                            .put("Name", mailInfo.getName())));
            message.put(Emailv31.Message.SUBJECT, mailInfo.generate());
            message.put(Emailv31.Message.TEXTPART, "Hello " + mailInfo.getName() + "!");
            message.put(Emailv31.Message.HTMLPART, "<h3>" + mailInfo.generate() + "</h3>");

            // Wrap the message in a MailjetRequest
            MailjetRequest request = new MailjetRequest(Emailv31.resource)
                    .property(Emailv31.MESSAGES, new JSONArray().put(message));

            // Send the request using MailjetClient
            MailjetResponse response = client.post(request);

            // Handle response
            if (response.getStatus() == 200) {
                System.out.println("Email sent successfully to: " + mailInfo.getName());
            } else {
                System.out.println("Failed to send email. Status: " + response.getStatus());
                System.out.println("Error: " + response.getData());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
