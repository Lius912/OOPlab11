package apps.task2;


import apps.task2.mailcode.HappyBirthdayDayCode;

public class Main {
    public static void main(String[] args) {
        Client client = Client.builder().name("lev").email("levlisik@gmail.com").build();
        Client client2 = Client.builder().name("danylo").email("levlisik@gmail.com").build();
        MailInfo mailinfo = new MailInfo(client, new HappyBirthdayDayCode());
        System.out.println(mailinfo.generate());
        MailSender sender = new MailSender();
        sender.sendMail("lysyk.pn@ucu.edu.ua", "my company", mailinfo);
        MailInfo info2 = new MailInfo(client2, new HappyBirthdayDayCode());
        MailBox box = new MailBox("lysyk.pn@ucu.edu.ua", "my company");
        box.sendAll();
    }
}
