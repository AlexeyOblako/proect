import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

public class EllipseDrawer {

    public static void main(String[] args) {
        // Создаем окно
        JFrame frame = new JFrame("Эллипс");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);

        // Создаем панель для рисования
        JPanel drawingPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;

                // Рисуем эллипс, если он был создан
                if (ellipse != null) {
                    ellipse.drawScanline(g2d);
                }
            }
        };
        frame.add(drawingPanel);

        // Создаем панель для кнопок
        JPanel buttonPanel = new JPanel();
        JButton button1 = new JButton("Создать эллипс");
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createEllipse(drawingPanel);
            }
        });
        buttonPanel.add(button1);
        frame.add(buttonPanel, BorderLayout.SOUTH);

        frame.setVisible(true);
    }

    // Метод для создания эллипса
    static Ellipse ellipse;

    private static void createEllipse(JPanel drawingPanel) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите координату x левого верхнего угла:");
        int x = scanner.nextInt();
        System.out.println("Введите координату y левого верхнего угла:");
        int y = scanner.nextInt();
        System.out.println("Введите ширину эллипса (2 * полуось a):");
        int width = scanner.nextInt();
        System.out.println("Введите высоту эллипса (2 * полуось b):");
        int height = scanner.nextInt();

        ellipse = new Ellipse(x, y, width, height);

        drawingPanel.repaint();
    }
}

class Ellipse {
    private int x;
    private int y;
    private int width;
    private int height;

    // Конструктор с левым верхним углом и размерами (ширина и высота - это 2 * полуоси)
    public Ellipse(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public void drawScanline(Graphics2D g2d) {
        int centerX = x + width / 2;
        int centerY = y + height / 2;
        int a = width / 2;
        int b = height / 2;

        // Исправленный код:
        for (int j = y; j < y + height; j++) { // Переменная j вместо y
            for (int i = x; i < x + width; i++) { // Переменная i вместо x
                if (isPointInsideEllipse(i, j, centerX, centerY, a, b)) {
                    g2d.fillRect(i, j, 1, 1);
                }
            }
        }
    }

    private boolean isPointInsideEllipse(int x, int y, int centerX, int centerY, int a, int b) {
        double dx = x - centerX;
        double dy = y - centerY;
        return (dx * dx) / (a * a) + (dy * dy) / (b * b) <= 1;
    }
}