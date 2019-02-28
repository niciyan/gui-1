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

        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("change motion");
        menu.setFont(font);
        JMenuItem startAnimation = new JMenuItem("Start animation");
        startAnimation.setFont(font);
        JMenuItem stop = new JMenuItem("Stop");
        stop.setFont(font);
        JMenuItem reverse = new JMenuItem("Reverse");
        JMenuItem speedDown = new JMenuItem("Speed Down");
        JMenuItem speedUp = new JMenuItem("Speed Up");
        JMenuItem changeColor = new JMenuItem("Change color");

        stop.addActionListener(e -> panel.stop());
        startAnimation.addActionListener(e -> panel.start());
        reverse.addActionListener(e -> panel.shapes().reverse());
        speedDown.addActionListener(e -> panel.shapes().speedDownHalf());
        speedUp.addActionListener(e -> panel.shapes().speedUp());
        changeColor.addActionListener(e -> panel.shapes().changeColor());

        menu.add(stop);
        menu.add(startAnimation);
        menu.add(reverse);
        menu.add(speedDown);
        menu.add(speedUp);
        menu.add(changeColor);

        menuBar.add(menu);

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
