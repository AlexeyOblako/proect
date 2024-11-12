import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        DrawPanel drawPanel = new DrawPanel();
        drawPanel.add(Ellipse.createEllipse(100, 100, 300, 300)); // Добавляем эллипс
    }
}