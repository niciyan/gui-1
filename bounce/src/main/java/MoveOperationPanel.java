import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class MoveOperationPanel extends JPanel {
    private AnimationPanel animationPanel;
    private List<JButton> buttons;

    public MoveOperationPanel(AnimationPanel animationPanel) {
        this.animationPanel = animationPanel;
        this.buttons = new ArrayList<>();
        prepare();
    }

    public void prepare() {

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
        changeColor.addActionListener(e -> animationPanel.changeColor());

        buttons.add(start);
        buttons.add(stop);
        buttons.add(reverse);
        buttons.add(speedUp);
        buttons.add(speedDown);
        buttons.add(changeColor);

        layoutButtons(this, buttons);
    }

    private static void layoutButtons(JPanel panel, List<JButton> buttons) {
        panel.setLayout(new GridLayout(0, 1, 0, 0));

        for (JButton b : buttons) {
            panel.add(b, BorderLayout.PAGE_START);
        }
    }
}
