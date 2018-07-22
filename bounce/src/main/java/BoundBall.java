import java.awt.*;
import javax.swing.*;

public class BoundBall extends JFrame {
    public BoundBall() {
        setTitle("bounce");

        setResizable(false);

        MainPanel panel = new MainPanel();
        Container contentPane = getContentPane();
        contentPane.add(panel);

        pack();
    }



    public static void main(String[] args) {
        BoundBall frame = new BoundBall();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
