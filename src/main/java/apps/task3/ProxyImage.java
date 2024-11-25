package apps.task3;

public class ProxyImage {
    private String filename;

    public ProxyImage(String filename) {
        this.filename = filename;
    }

    public void display() {
        RealImage image = new RealImage(filename);
        image.display();
    }
}
