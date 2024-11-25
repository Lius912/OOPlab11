package apps.task3;

public class Main {
    public static void main(String[] args) {
        // RealImage image = new RealImage("src/main/resources/download.jpeg");
        // image.display();
        ProxyImage image = new ProxyImage("src/main/resources/download.jpeg");
        image.display();
    }

}
