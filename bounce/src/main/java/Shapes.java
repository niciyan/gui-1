import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Shapes{
    private List<Shape> shapes;

    public Shapes() {
        shapes = new ArrayList<>();
    }

    public void add(Shape s) {
        shapes.add(s);
    }

    public void reverse() {
        for (Shape s : shapes) {
            s.v().reverse();
        }
    }

    public void update() {
        for (Shape s : shapes) {
            s.update();
        }
    }

    public void paint(Graphics g) {
        for (Shape s : shapes) {
            s.paintComponent(g);
        }
    }

    public void stop() {
        for (Shape s : shapes) {
            s.v().stop();
        }
    }

    public void speedDownHalf() {
        for (Shape s : shapes) {
            s.v().speedDownHalf();
        }
    }

    public void speedUp() {
        for (Shape s : shapes) {
            s.v().speedUp();
        }
    }

    public void changeColor() {
        for (Shape s : shapes) {
            s.changeColor(Utils.randomColor());
        }
    }
}
