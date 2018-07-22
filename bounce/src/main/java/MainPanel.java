import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JPanel;

public class MainPanel extends JPanel implements Runnable {
    public static final int WIDTH = 1000;
    public static final int HEIGHT = 600;
    private static final int SIZE = 10;
    private List<Shape> shapes;
    private Random rand;

    public static final int NUM_SHAPES = 10;
    public static final int DEFAULT_RADIUS = 30;

    private Thread thread;

    public Point randomPoint(){
        int x = rand.nextInt(WIDTH - 2 * DEFAULT_RADIUS);
        int y = rand.nextInt(HEIGHT- 2 * DEFAULT_RADIUS);
        return new Point(x, y);
    }

    public Color randomColor() {
        int r = rand.nextInt(256);
        int g = rand.nextInt(256);
        int b = rand.nextInt(256);
        return new Color(r, g, b);
    }

    public Velocity randomVelocity() {
        int vx = rand.nextInt(1)+1;
        int vy = rand.nextInt(1)+1;
        if (rand.nextBoolean()) {
            return new Velocity(-vx, -vy);
        }
        return new Velocity(vx, vy);
    }

    public MainPanel() {
        this.rand = new Random();
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        List<Shape> s = new ArrayList<>();


        for (int i = 0; i < NUM_SHAPES; i++) {
            s.add(new Ball(randomPoint(), randomVelocity(), DEFAULT_RADIUS, randomColor()));
            s.add(new Triangle(randomPoint(), randomVelocity(), Triangle.DEFAULT_SIDE, randomColor()));
        }

        shapes = s;

        thread = new Thread(this);
        thread.start();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Shape s : shapes) {
            s.paintComponent(g);
        }
    }

    public void run() {
        while (true) {
            for (Shape s : shapes) {
                s.move();
            }

            repaint();

            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}


