import java.awt.*;
import javax.swing.*;
import java.io.Serializable;
import java.util.List;

public class Ellipse implements DrawObject, Serializable {
    private int x;
    private int y;
    private int width;
    private int height;

    public Ellipse(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public void drawBoundary(Graphics2D g2d) {
        int centerX = x + width / 2;
        int centerY = y + height / 2;
        double threshold = 0.0555;

        for (int j = y; j < y + height; j++) {
            for (int i = x; i < x + width; i++) {
                double a = (double) width / 2;
                double b = (double) height / 2;
                double equation = (Math.pow(i - centerX, 2) / (a * a)) + (Math.pow(j - centerY, 2) / (b * b));
                if (Math.abs(equation - 1) < threshold) {
                    g2d.fillRect(i, j, 1, 1);
                }
            }
        }
    }

    @Override
    public void draw(Graphics2D g2d) {
        drawBoundary(g2d);
    }

    public static void createEllipse(JPanel drawingPanel, List<DrawObject> drawObjects, JTextField xField, JTextField yField, JTextField widthField, JTextField heightField) {
        try {
            int x = Integer.parseInt(xField.getText());
            int y = Integer.parseInt(yField.getText());
            int width = Integer.parseInt(widthField.getText());
            int height = Integer.parseInt(heightField.getText());

            Ellipse ellipse = new Ellipse(x, y, width, height);
            drawObjects.add(ellipse);
            drawingPanel.repaint();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Пожалуйста, введите корректные числовые значения.", "Ошибка ввода", JOptionPane.ERROR_MESSAGE);
        }
    }
}