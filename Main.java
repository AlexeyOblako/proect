import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<DrawObject> objects = new ArrayList<>();
        DrawPanel drawPanel = new DrawPanel(objects);
        drawPanel.setVisible(true);
    }
}