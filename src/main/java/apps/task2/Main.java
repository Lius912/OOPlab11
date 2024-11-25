package apps.task2;

import java.time.LocalDate;

import apps.task2.mailcode.HappyBirthdayDayCode;

public class Main {
    public static void main(String[] args) {
        Client client = Client.builder().name("lev").email("levlisik@gmail.com").build();
        MailInfo mailinfo = new MailInfo(client, new HappyBirthdayDayCode());
        System.out.println(mailinfo.generate());
        MailSender sender = new MailSender(mailinfo);
        // sender.sendEmail("dobosevych@ucu.edu.ua", mailinfo);
    }
}
