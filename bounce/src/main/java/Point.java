public class Point {
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void move(Velocity v) {
        x += v.X();
        y += v.Y();
    }

    public int X() {
        return x;
    }

    public int Y() {
        return y;
    }
}
