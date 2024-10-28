import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class DrawPanel extends JFrame {
    private final int BACKGROUND_WIDTH = 400;
    private final int BACKGROUND_HEIGHT = 400;
    private List<DrawObject> drawObjects;

    private JTextField xField, yField, widthField, heightField;

    public DrawPanel(List<DrawObject> drawObjects) {
        setTitle("Эллипс");
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

        JPanel inputPanel = new JPanel();
        xField = new JTextField(5);
        yField = new JTextField(5);
        widthField = new JTextField(5);
        heightField = new JTextField(5);

        inputPanel.add(new JLabel("X:"));
        inputPanel.add(xField);
        inputPanel.add(new JLabel("Y:"));
        inputPanel.add(yField);
        inputPanel.add(new JLabel("Ширина:"));
        inputPanel.add(widthField);
        inputPanel.add(new JLabel("Высота:"));
        inputPanel.add(heightField);

        JButton createButton = new JButton("Создать");
        createButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Ellipse.createEllipse(drawingPanel, drawObjects, xField, yField, widthField, heightField);
            }
        });
        inputPanel.add(createButton);
        add(inputPanel, BorderLayout.SOUTH);
        setVisible(true);
    }
}