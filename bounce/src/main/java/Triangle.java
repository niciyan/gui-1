import java.awt.*;

public class Triangle implements Shape{
    private Point center;
    private Velocity v;
    private int side;
    private Color color;

    private int angle;
    private int angleVelocity;

    private Polygon poly;

    public static int DEFAULT_SIDE = 30;

    public Triangle(Point center, Velocity v, int side, Color color) {
        this.center = center;
        this.v = v;
        this.side = side;
        this.color = color;

        this.angle = 0;
        this.angleVelocity = 1;

        recalculate();
    }

    private void recalculate() {
        this.poly = createPolygon(center.X(), center.Y(), side, false);
    }

    protected Polygon createPolygon(int x, int y, int side, boolean inverse){
        final int num = 3;
        int xarray[] = new int[num];
        int yarray[] = new int[num];

        double theta = (double) angle / 180 * Math.PI;
        double sin0 = Math.sin(theta);
        double cos0 = Math.cos(theta);
        double sin1 = Math.sin(theta + Math.PI * 2 / 3);
        double cos1 = Math.cos(theta + Math.PI * 2 / 3);
        double sin2 = Math.sin(theta + Math.PI * 4 / 3);
        double cos2 = Math.cos(theta + Math.PI * 4 / 3);

        xarray[0] = x+(int)(side*cos0);
        yarray[0] = y+(int)(side*sin0);

        xarray[1] = x+(int)(side*cos1);
        yarray[1] = y+(int)(side*sin1);

        xarray[2] = x+(int)(side*cos2);
        yarray[2] = y+(int)(side*sin2);

//        angle += angleVelocity;

        return new Polygon(xarray, yarray, 3);

    }

    public void move() {
        if (center.X() < 0 || center.X() > MainPanel.WIDTH) {
            v.setX(-1 * v.X());
        }
        if (center.Y() < 0 || center.Y() > MainPanel.HEIGHT) {
            v.setY(-1 * v.Y());
        }
        center.update(center.X() + v.X(), center.Y() + v.Y());
    }

    @Override
    public Point getPoint() {
        return center;
    }

    @Override
    public void update() {
//        move();
        angle += angleVelocity;
        recalculate();
    }

    @Override
    public void paintComponent(Graphics g) {
        g.setColor(color);
        g.fillPolygon(poly);
    }

}
