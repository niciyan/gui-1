import java.awt.*;
import javax.swing.*;

public class BoundBallFrame extends JFrame {
    private MainPanel panel;
    public BoundBallFrame() {
        setTitle("bounce");

        setResizable(false);

        panel = new MainPanel();
        Container contentPane = getContentPane();
        contentPane.add(panel);

        pack();
    }

    public void animate() {
        panel.animate();
    }

}
