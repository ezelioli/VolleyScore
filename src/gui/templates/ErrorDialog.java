package gui.templates;

import javax.swing.*;
import java.awt.*;

public class ErrorDialog extends JDialog {

    private ImageIcon errorIcon = new ImageIcon("data/images/error.png");

    public ErrorDialog(JDialog owner, String message){
        super(owner);
        setResizable(false);
        setModal(true);
        setIconImage(errorIcon.getImage());
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setBounds(100, 100, 250, 150);
        Dimension windowSize = getSize();
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        Point centerPoint = ge.getCenterPoint();
        int dx = centerPoint.x - windowSize.width / 2;
        int dy = centerPoint.y - windowSize.height / 2;
        setLocation(dx, dy);
        setTitle("Warning");
    }
}
