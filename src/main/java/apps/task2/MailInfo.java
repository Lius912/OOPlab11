package apps.task2;

import apps.task2.mailcode.MailCode;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor @Getter
public class MailInfo {
    private Client client;
    private MailCode mailCode;
    
    public String generate() {
        return mailCode.generate(client);
    }

    public String getEmail() {
        return client.getEmail();
    }

    public String getName() {
        return client.getName();
    }
}
