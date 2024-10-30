import java.awt.*;
import javax.swing.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

class Ellipse implements DrawObject {
    int x;//private
    int y;//private
    int width;//private
    int height;//private

    public Ellipse(int x, int y, int width, int height) {
        // Проверка на корректность входных данных
        if (width <= 0 || height <= 0) {
            throw new IllegalArgumentException("Ширина и высота должны быть положительными числами.");
        }
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

    public static Ellipse createEllipse(int x, int y, int width, int height) {
        try {
            return new Ellipse(x, y, width, height);
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка создания эллипса", JOptionPane.ERROR_MESSAGE);
            return null; // Или выбросить исключение дальше, зависит от архитектуры
        }
    }


    public static List<Ellipse> createEllipses(){
        List<Ellipse> ellipses = new ArrayList<>();
        try {
            ellipses.add(createEllipse(100, 100, 150, 150));
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка", JOptionPane.ERROR_MESSAGE);
        }
        return ellipses;
    }
}