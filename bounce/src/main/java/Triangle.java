import java.awt.*;

public class Triangle implements Shape{
    private Point p;
    private Velocity v;
    private int side;
    private Color color;

    private int angle;
    private int angleVelocity;

    private Polygon poly;

    public static int DEFAULT_SIDE = 30;

    public Triangle(Point p, Velocity v, int side, Color color) {
        this.p = p;
        this.v = v;
        this.side = side;
        this.color = color;

        this.angle = 0;
        this.angleVelocity = 1;

        recalculate();
    }

    private void recalculate() {
        this.poly = createPolygon(p.X(), p.Y(), side, false);
    }

    protected Polygon createPolygon(int x, int y, int side, boolean inverse){
        final int num = 3;
        int xarray[] = new int[num];
        int yarray[] = new int[num];

        double theta = (double) angle / 180 * Math.PI;
        double sin = Math.sin(theta);
        double cos = Math.cos(theta);


        xarray[0] = x+(int)(side*cos);
        yarray[0] = y+(int)(side*sin);

        xarray[1] = x-(int)(2*side*sin);
        yarray[1] = y+(int)(2*side*cos);

        xarray[2] = x-(int)(side*cos);
        yarray[2] = y-(int)(side*sin);

//        angle += angleVelocity;

        return new Polygon(xarray, yarray, 3);

    }

    @Override
    public Point getPoint() {
        return p;
    }

    @Override
    public void move() {
//        if (p.X() < 0 || p.X() > MainPanel.WIDTH - 2 * radius) {
//            v.setX(-1 * v.X());
//        }
//        if (p.Y() < 0 || p.Y() > MainPanel.HEIGHT - 2 * radius) {
//            v.setY(-1 * v.Y());
//        }
//        p.update(p.X()+v.X(), p.Y()+v.Y());
        angle += angleVelocity;
        recalculate();
    }

    @Override
    public void paintComponent(Graphics g) {
        g.setColor(color);
        g.fillPolygon(poly);
    }

}
