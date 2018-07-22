import java.awt.*;

public class Ball implements Shape{
    private Point p;
    private Velocity v;
    private int radius;
    private Color color;

    public Ball(Point p, Velocity v, int radius, Color color) {
        this.p = p;
        this.v = v;
        this.radius = radius;
        this.color = color;
    }

    @Override
    public void move() {
        if (p.X() < 0 || p.X() > MainPanel.WIDTH - 2 * radius) {
            v.setX(-1 * v.X());
        }
        if (p.Y() < 0 || p.Y() > MainPanel.HEIGHT - 2 * radius) {
            v.setY(-1 * v.Y());
        }
        p.update(p.X()+v.X(), p.Y()+v.Y());
    }

    @Override
    public void paintComponent(Graphics g){
        g.setColor(this.color);
        g.fillOval(p.X(),p.Y(),2* radius, 2 * radius);
    }

    @Override
    public Point getPoint(){
        return this.p;
    }
}
