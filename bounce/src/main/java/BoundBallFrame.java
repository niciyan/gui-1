import java.awt.*;
import javax.swing.*;

public class BoundBallFrame extends JFrame {
    public BoundBallFrame() {
        setTitle("bounce");

        setResizable(false);

        MainPanel panel = new MainPanel();
        Container contentPane = getContentPane();
        contentPane.add(panel);

        pack();
    }

}
