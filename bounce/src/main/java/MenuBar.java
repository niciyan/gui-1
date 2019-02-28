import javax.swing.*;

public class MenuBar extends JMenuBar {
    private MainPanel panel;

    public MenuBar(MainPanel panel) {
        prepare(panel);
    }

    public void prepare(MainPanel panel) {

        JMenu menu = new JMenu("change motion");
        JMenuItem startAnimation = new JMenuItem("Start animation");
        JMenuItem stop = new JMenuItem("Stop");
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

        add(menu);
    }
}
