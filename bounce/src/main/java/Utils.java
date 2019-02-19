import java.awt.*;
import java.util.Random;


public class Utils {
    private static Random rand = new Random();

    public static Point randomPoint(int rangeX, int rangeY){
        int x = rand.nextInt(rangeX);
        int y = rand.nextInt(rangeY);
        return new Point(x, y);
    }

    public static Color randomColor() {
        int r = rand.nextInt(256);
        int g = rand.nextInt(256);
        int b = rand.nextInt(256);
        return new Color(r, g, b);
    }

    public static Velocity randomVelocity() {
        int vx = rand.nextInt(1) + 1;
        int vy = rand.nextInt(1) + 1;
        if (rand.nextBoolean()) {
            return new Velocity(-vx, -vy);
        }
        return new Velocity(vx, vy);
    }
}
