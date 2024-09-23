import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

public class EllipseDrawer {

    public static void main(String[] args) {
        // Создаем графический контекст для рисования
        Graphics2D g2d = (Graphics2D) new BufferedImage(400, 400, BufferedImage.TYPE_INT_ARGB).getGraphics();

        // Создаем объекты Ellipse
        Ellipse ellipse1 = new Ellipse(50, 50, 100, 50);
        Ellipse ellipse2 = new Ellipse(200, 200, 75, 30);
        Ellipse ellipse3 = new Ellipse(300, 100, 50, 150);
        Ellipse ellipse4 = new Ellipse(150, 150, 50, 50);

        // Рисуем эллипсы
        ellipse1.draw(g2d);
        ellipse2.draw(g2d);
        ellipse3.draw(g2d);

        // Поворачиваем эллипс4
        ellipse4.rotate(45, 150, 150);
        ellipse4.draw(g2d);

        // Отрисовка результата (необязательно, если используется GUI)
        // ...
    }
}

class Ellipse {
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

    public Ellipse(int centerX, int centerY, int a, int b) {
        this.x = centerX - a;
        this.y = centerY - b;
        this.width = 2 * a;
        this.height = 2 * b;
    }

    public void draw(Graphics2D g2d) {
        Ellipse2D.Double ellipse = new Ellipse2D.Double(x, y, width, height);
        g2d.draw(ellipse);
    }

    public void rotate(double angle, int centerX, int centerY) {
        AffineTransform rotate = AffineTransform.getRotateInstance(Math.toRadians(angle), centerX, centerY);
        this.x = (int) rotate.transform(new Point(x, y), null).getX();
        this.y = (int) rotate.transform(new Point(x, y), null).getY();
    }
}