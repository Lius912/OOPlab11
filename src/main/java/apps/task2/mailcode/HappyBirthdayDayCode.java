package apps.task2.mailcode;

import apps.task2.Client;

public class HappyBirthdayDayCode implements MailCode {
    @Override
    public String generate(Client client) {
        return String.format("Dear, %s", client.getName());
    }
}
