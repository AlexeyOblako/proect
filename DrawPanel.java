import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

class DrawPanel extends JFrame {
    private final int BACKGROUND_WIDTH = 400;
    private final int BACKGROUND_HEIGHT = 400;
    private List<DrawObject> drawObjects;

    public DrawPanel(List<DrawObject> drawObjects) {
        setTitle("Рисование");
        setSize(BACKGROUND_WIDTH, BACKGROUND_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.drawObjects = drawObjects;

        JPanel drawingPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                for (DrawObject obj : drawObjects) {
                    obj.draw(g2d);
                }
            }
        };
        add(drawingPanel);
        setVisible(true);
    }
}