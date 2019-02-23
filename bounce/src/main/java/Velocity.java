public class Velocity {
    private int x;
    private int y;

    public Velocity(int x, int y) {
        this.setX(x);
        this.setY(y);
    }

    public int X() {
        return x;
    }

    public int Y() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
}
