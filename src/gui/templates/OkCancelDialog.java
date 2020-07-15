package gui;

import javax.swing.*;
import java.awt.*;

public class ConfirmDialog extends JDialog implements OkCancelDialog{

    private ImageIcon warningIcon = new ImageIcon("data/images/warning.png");
    protected JDialog owner;

    public ConfirmDialog(JDialog owner, String message){
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

        ConfirmPanel confirmPanel = new ConfirmPanel(this, message);
        setContentPane(confirmPanel);

        this.owner = owner;
    }

    @Override
    public void doCancel() {
        dispose();
    }

    @Override
    public void doOk() {
        dispose();
    }
}
