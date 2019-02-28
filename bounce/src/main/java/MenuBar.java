import javax.swing.*;

public class MenuBar extends JMenuBar {
    private AnimationPanel animationPanel;

    public MenuBar(AnimationPanel animationPanel) {
        this.animationPanel = animationPanel;
        prepare();
    }

    public void prepare() {

        JMenu menu = new JMenu("change motion");
        JMenuItem startAnimation = new JMenuItem("Start animation");
        JMenuItem stop = new JMenuItem("Stop");
        JMenuItem reverse = new JMenuItem("Reverse");
        JMenuItem speedDown = new JMenuItem("Speed Down");
        JMenuItem speedUp = new JMenuItem("Speed Up");
        JMenuItem changeColor = new JMenuItem("Change color");

        stop.addActionListener(e -> animationPanel.stop());
        startAnimation.addActionListener(e -> animationPanel.start());
        reverse.addActionListener(e -> animationPanel.shapes().reverse());
        speedDown.addActionListener(e -> animationPanel.shapes().speedDownHalf());
        speedUp.addActionListener(e -> animationPanel.shapes().speedUp());
        changeColor.addActionListener(e -> animationPanel.shapes().changeColor());

        menu.add(stop);
        menu.add(startAnimation);
        menu.add(reverse);
        menu.add(speedDown);
        menu.add(speedUp);
        menu.add(changeColor);

        add(menu);
    }
}
