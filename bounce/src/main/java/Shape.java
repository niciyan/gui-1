import java.awt.*;

public interface Shape {

    void update();

    void paintComponent(Graphics g);

    Velocity v();

    void changeColor(Color color);
}
