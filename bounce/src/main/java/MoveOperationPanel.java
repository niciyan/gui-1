import javax.swing.*;

public class MoveOperationPanel extends JPanel {
    private AnimationPanel animationPanel;

    public MoveOperationPanel(AnimationPanel animationPanel) {
        this.animationPanel = animationPanel;
        prepare();
    }

    public void prepare() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JButton start = new JButton("Start");
        JButton stop = new JButton("Stop");
        JButton reverse = new JButton("Reverse");
        JButton speedUp = new JButton("Speed Up");
        JButton speedDown = new JButton("Speed Down");
        JButton changeColor = new JButton("Change Color");

        start.addActionListener(e -> animationPanel.start());
        stop.addActionListener(e -> animationPanel.stop());
        reverse.addActionListener(e -> animationPanel.shapes().reverse());
        speedUp.addActionListener(e -> animationPanel.shapes().speedUp());
        speedDown.addActionListener(e -> animationPanel.shapes().speedDownHalf());
        changeColor.addActionListener(e -> animationPanel.shapes().changeColor());

        add(start);
        add(stop);
        add(reverse);
        add(speedUp);
        add(speedDown);
        add(changeColor);
    }
}
