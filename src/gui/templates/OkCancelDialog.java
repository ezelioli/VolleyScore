package gui.templates;

import javax.swing.*;
import java.awt.*;

public class OkCancelDialog extends JDialog{

    private ImageIcon warningIcon = new ImageIcon("data/images/warning.png");
    protected JDialog owner;

    public OkCancelDialog(JDialog owner, String message){
        super(owner);
        setResizable(false);
        setModal(true);
        setIconImage(warningIcon.getImage());
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setBounds(100, 100, 250, 150);
        Dimension windowSize = getSize();
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        Point centerPoint = ge.getCenterPoint();
        int dx = centerPoint.x - windowSize.width / 2;
        int dy = centerPoint.y - windowSize.height / 2;
        setLocation(dx, dy);
        setTitle("Warning");

        OkCancelPanel okCancelPanel = new OkCancelPanel(this, message);
        setContentPane(okCancelPanel);

        this.owner = owner;
    }

    public void doCancel() {
        dispose();
    }

    public void doOk() {
        dispose();
    }
}
