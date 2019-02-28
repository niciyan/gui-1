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

    public void stop() {
        x = 0;
        y = 0;
    }

    public void speedDownHalf() {
        x /= 2;
        y /= 2;
    }

    public void speedUp() {
        if (x == 0) {
            x += 1;
        } else {
            x *= 2;
        }
        if (y == 0) {
            y += 1;
        } else {
            y *= 2;
        }
    }
}
