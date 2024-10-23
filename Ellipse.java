import java.awt.Color;
import java.awt.Graphics2D;
import java.io.Serializable;

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

    }
}