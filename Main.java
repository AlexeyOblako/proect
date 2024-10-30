import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<DrawObject> drawObjects = new ArrayList<>(Ellipse.createEllipses());
        new DrawPanel(drawObjects);
    }
}