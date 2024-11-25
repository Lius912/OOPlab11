package apps.task2;

import java.util.ArrayList;

public class MailBox {
    private ArrayList<MailInfo> infos;
    private String email;
    private String name;

    public MailBox(String email, String name) {
        this.infos = new ArrayList<>();
        this.email = email;
        this.name = name;
    }

    public void addInfo(MailInfo info) {
        infos.add(info);
    }

    public void sendAll() {
        for (MailInfo info: infos) {
            MailSender sender = new MailSender();
            sender.sendMail(email, name, info);
        }
    }
}
