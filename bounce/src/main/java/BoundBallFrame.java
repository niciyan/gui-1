import javax.swing.*;
import java.awt.*;

public class BoundBallFrame extends JFrame {
    private MainPanel panel;
    private Font font;
    private JSplitPane splitPane;

    public BoundBallFrame() {
        setTitle("bounce");

        setResizable(false);

        font = new Font("", Font.PLAIN, 16);
        panel = new MainPanel();

        preparePane();

        MenuBar menuBar = new MenuBar(panel);

        setJMenuBar(menuBar);

        getContentPane().add(splitPane);

        pack();
    }

    private void preparePane() {
        splitPane = new JSplitPane();

        splitPane.setRightComponent(panel);

        JPanel leftPanel = new JPanel();
        JButton stop = new JButton("Stop");
        stop.addActionListener(e -> panel.stop());
        JButton reverse = new JButton("Reverse");
        reverse.addActionListener(e -> panel.shapes().reverse());

        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));
        leftPanel.add(stop);
        leftPanel.add(reverse);

        splitPane.setLeftComponent(leftPanel);
    }

}
