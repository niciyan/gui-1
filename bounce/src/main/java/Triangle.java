import java.awt.*;

public class Triangle implements Shape{
    private Point center;
    private Velocity v;
    private int side;
    private Color color;

    private int angle;
    private int angleVelocity;

    public static int DEFAULT_SIDE = 30;

    public Triangle(Point center, Velocity v, int side, Color color) {
        this.center = center;
        this.v = v;
        this.side = side;
        this.color = color;
        this.angle = 0;
        this.angleVelocity = 1;
    }

    protected Polygon createPolygon(){
        final int num = 3;
        int x = center.X();
        int y = center.Y();
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

        return new Polygon(xarray, yarray, 3);

    }

    public void move() {
        if (center.X() < 0 || center.X() > MainPanel.WIDTH) {
            v.reverseX();
        }
        if (center.Y() < 0 || center.Y() > MainPanel.HEIGHT) {
            v.reverseY();
        }
        center.update(center.X() + v.X(), center.Y() + v.Y());
    }

    @Override
    public Point getPoint() {
        return center;
    }

    @Override
    public void update() {
        move();
        angle += angleVelocity;
    }

    @Override
    public void paintComponent(Graphics g) {
        g.setColor(color);
        g.fillPolygon(createPolygon());
    }

}
