import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JPanel;

public class MainPanel extends JPanel implements Runnable {
    public static final int WIDTH = 1000;
    public static final int HEIGHT = 600;
//    private static final int SIZE = 10;
    private List<Shape> shapes;
    private Random rand;

    public static final int NUM_SHAPES = 10;
    public static final int DEFAULT_RADIUS = 30;

    private Thread thread;

    public MainPanel() {
        this.rand = new Random();
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        List<Shape> s = new ArrayList<>();

        for (int i = 0; i < NUM_SHAPES; i++) {
            s.add(new Ball(
                    Utils.randomPoint(WIDTH - 2 * DEFAULT_RADIUS, HEIGHT - 2 * DEFAULT_RADIUS),
                    Utils.randomVelocity(4),
                    DEFAULT_RADIUS,
                    Utils.randomColor()
            ));
            s.add(new Triangle(
                    Utils.randomPoint(WIDTH - 2 * DEFAULT_RADIUS, HEIGHT - 2 * DEFAULT_RADIUS),
                    Utils.randomVelocity(4),
                    Triangle.DEFAULT_SIDE,
                    Utils.randomColor()
            ));
        }

        shapes = s;
    }

    public void animate() {
        thread = new Thread(this);
        thread.start();
    }

    public void paintShapes(Graphics g) {
        for (Shape s : shapes) {
            s.paintComponent(g);
        }
    }

    public void updateShapes() {
        for (Shape s : shapes) {
            s.update();
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        paintShapes(g);
    }

    public void run() {
        while (true) {
            updateShapes();
            repaint();

            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}


