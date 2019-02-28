import javax.swing.*;
import java.awt.*;

public class BoundBallFrame extends JFrame {
    private AnimationPanel animationPanel;
    private Font font;
    private JSplitPane splitPane;

    public BoundBallFrame() {
        setTitle("bounce");

        setResizable(false);

        font = new Font("", Font.PLAIN, 16);
        animationPanel = new AnimationPanel();

        preparePane();

        MenuBar menuBar = new MenuBar(animationPanel);

        setJMenuBar(menuBar);

        getContentPane().add(splitPane);

        pack();
    }

    private void preparePane() {
        splitPane = new JSplitPane();

        splitPane.setRightComponent(animationPanel);

        JPanel leftPanel = new JPanel();
        JButton stop = new JButton("Stop");
        stop.addActionListener(e -> animationPanel.stop());
        JButton reverse = new JButton("Reverse");
        reverse.addActionListener(e -> animationPanel.shapes().reverse());

        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));
        leftPanel.add(stop);
        leftPanel.add(reverse);

        splitPane.setLeftComponent(leftPanel);
    }

}
