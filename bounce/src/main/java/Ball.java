import java.awt.*;

public class Ball implements Shape{
    public static final int DEFAULT_RADIUS = 30;
    private Point center;
    private Velocity v;
    private int radius;
    private Color color;

    public Ball(Point center, Velocity v, int radius, Color color) {
        this.center = center;
        this.v = v;
        this.radius = radius;
        this.color = color;
    }

    public void move() {
        if (center.X() < 0 || center.X() > MainPanel.WIDTH - 2 * radius) {
            v.reverseX();
        }
        if (center.Y() < 0 || center.Y() > MainPanel.HEIGHT - 2 * radius) {
            v.reverseY();
        }
        center.move(v);
    }

    @Override
    public void update() {
        move();
    }

    @Override
    public void paintComponent(Graphics g){
        g.setColor(this.color);
        g.fillOval(center.X(), center.Y(),2* radius, 2 * radius);
    }

    @Override
    public Velocity v() {
        return v;
    }

    @Override
    public void changeColor(Color color) {
        this.color = color;
    }

}
