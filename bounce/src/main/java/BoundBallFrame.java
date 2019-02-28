import javax.swing.*;
import java.awt.*;

public class BoundBallFrame extends JFrame {
    private AnimationPanel animationPanel;
    private MoveOperationPanel moveOperationPanel;
    private Font font;
    private JSplitPane splitPane;

    public BoundBallFrame() {
        setTitle("bounce");

        setResizable(false);

        font = new Font("DejaVu Sans Mono", Font.PLAIN, 16);
        animationPanel = new AnimationPanel();
        moveOperationPanel = new MoveOperationPanel(animationPanel);

        preparePane();

        MenuBar menuBar = new MenuBar(animationPanel);

        setJMenuBar(menuBar);
        changeFont(menuBar, font);

        getContentPane().add(splitPane);
        changeFont(splitPane, font);

        pack();
    }

    private void preparePane() {
        splitPane = new JSplitPane();
        splitPane.setRightComponent(animationPanel);
        splitPane.setLeftComponent(moveOperationPanel);
    }

    // see https://stackoverflow.com/a/12731354/9814424
    private void changeFont(Component component, Font font) {
        component.setFont(font);
        if (component instanceof Container) {
            for (Component child : ((Container) component).getComponents()) {
                changeFont(child, font);
            }
        }
    }

}
