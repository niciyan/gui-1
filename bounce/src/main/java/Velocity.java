public class Velocity {
    private int x;
    private int y;

    public Velocity(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int X() {
        return x;
    }

    public int Y() {
        return y;
    }

    public void add(Velocity v) {
        x += v.X();
        y += v.Y();
    }

    public void reverseX() {
        x *= -1;
    }

    public void reverseY() {
        y *= -1;
    }

    public void reverse() {
        reverseX();
        reverseY();
    }
}
