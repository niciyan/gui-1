import java.awt.*;

public class Ball implements Shape{
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
        center.update(center.X()+v.X(), center.Y()+v.Y());
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
    public Point getPoint(){
        return this.center;
    }
}
