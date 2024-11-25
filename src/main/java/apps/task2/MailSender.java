package apps.task2;

import com.mailjet.client.errors.MailjetException;
import com.mailjet.client.MailjetClient;
import com.mailjet.client.MailjetRequest;
import com.mailjet.client.MailjetResponse;
import com.mailjet.client.ClientOptions;
import com.mailjet.client.resource.Emailv31;

import io.github.cdimascio.dotenv.Dotenv;

import org.json.JSONArray;
import org.json.JSONObject;

public class MailSender {

    private final MailjetClient client;

    public MailSender() {
        Dotenv dotenv = Dotenv.load();
        ClientOptions options = ClientOptions.builder()
                .apiKey(dotenv.get("API_KEY"))
                .apiSecretKey(dotenv.get("SECRET_API_KEY"))
                .build();
        this.client = new MailjetClient(options);
    }

    public void sendMail(String senderEmail, String senderName, MailInfo mailInfo) {

        MailjetRequest request = new MailjetRequest(Emailv31.resource)
                .property(Emailv31.MESSAGES, new JSONArray()
                        .put(new JSONObject()
                                .put(Emailv31.Message.FROM, new JSONObject()
                                        .put("Email", senderEmail)
                                        .put("Name", senderName))
                                .put(Emailv31.Message.TO, new JSONArray()
                                        .put(new JSONObject()
                                                .put("Email", mailInfo.getEmail())
                                                .put("Name", mailInfo.getName())))
                                .put(Emailv31.Message.SUBJECT, "message to " + mailInfo.getName())
                                .put(Emailv31.Message.HTMLPART, mailInfo.generate())));

        try {
                MailjetResponse response = client.post(request);
        }
        catch (MailjetException e) {
                System.out.println(e);
        }
    }
}
