import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

public class EllipseDrawer {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Эллипс");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);

        JPanel drawingPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;

                if (ellipse != null) {
                    ellipse.drawBoundary(g2d);
                }
            }
        };
        frame.add(drawingPanel);

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

    public void drawBoundary(Graphics2D g2d) {
        int centerX = x + width / 2;
        int centerY = y + height / 2;
        int a = width / 2;
        int b = height / 2;

        double threshold = 0.05; // Погрешность для проверки границы

        for (int j = y; j < y + height; j++) {
            for (int i = x; i < x + width; i++) {
                double equation = (Math.pow(i - centerX, 2) / Math.pow(a, 2)) + (Math.pow(j - centerY, 2) / Math.pow(b, 2));
                if (Math.abs(equation - 1) < threshold) {
                    g2d.fillRect(i, j, 1, 1);
                }
            }
        }
    }
}