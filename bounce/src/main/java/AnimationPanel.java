import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

public class AnimationPanel extends JPanel implements Runnable {
    public static final int WIDTH = 1800;
    public static final int HEIGHT = 1000;
    private Shapes shapes;
    private Random rand;

    private boolean running;

    public static final int NUM_SHAPES = 10;

    private Thread thread;

    public AnimationPanel() {
        this.rand = new Random();
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        shapes = new Shapes();
        prepare();
    }

    private void prepare() {
        addRandomRadiusBalls();
        addTriangles();

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                shapes().reverse();
            }
        });
    }

    private void addBalls() {
        for (int i = 0; i < NUM_SHAPES; i++) {
            shapes.add(new Ball(
                    Utils.randomPoint(WIDTH - 2 * Ball.DEFAULT_RADIUS, HEIGHT - 2 * Ball.DEFAULT_RADIUS),
                    Utils.randomVelocity(2),
                    Ball.DEFAULT_RADIUS,
                    Utils.randomColor()
            ));
        }
    }

    private void addRandomRadiusBalls() {
        for (int i = 0; i < NUM_SHAPES; i++) {
            shapes.add(new Ball(
                    Utils.randomPoint(WIDTH - 2 * Ball.DEFAULT_RADIUS, HEIGHT - 2 * Ball.DEFAULT_RADIUS),
                    Utils.randomVelocity(2),
                    rand.nextInt(Ball.DEFAULT_RADIUS),
                    Utils.randomColor()
            ));
        }
    }

    private void addTriangles() {
        for (int i = 0; i < NUM_SHAPES; i++) {
            shapes.add(new Triangle(
                    Utils.randomPoint(WIDTH - 2 * Ball.DEFAULT_RADIUS, HEIGHT - 2 * Ball.DEFAULT_RADIUS),
                    Utils.randomVelocity(2),
                    Triangle.DEFAULT_SIDE,
                    Utils.randomColor()
            ));
        }
    }

    public void start() {
        thread = new Thread(this);
        thread.start();
    }

    public void stop() {
        running = false;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        shapes.paint(g);
    }

    public void run() {
        running = true;
        while (running) {
            shapes.update();
            repaint();

            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public Shapes shapes() {
        return shapes;
    }
}


