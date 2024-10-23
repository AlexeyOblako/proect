import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<DrawObject> objects = new ArrayList<>();
        objects.add(new Ellipse(100, 100, 150, 150));


        DrawPanel drawPanel = new DrawPanel(objects);
        drawPanel.setVisible(true);
    }
}