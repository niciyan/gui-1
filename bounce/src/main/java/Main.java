import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        BoundBallFrame frame = new BoundBallFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.animate();
    }
}
