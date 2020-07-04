package gui.settings;

import javax.swing.*;
import java.awt.*;

public class ConfirmDialog extends JDialog {

    private ImageIcon warningIcon = new ImageIcon("data/images/warning.png");
    private JDialog owner;

    public ConfirmDialog(JDialog owner){
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

        JPanel confirmPanel = new ConfirmPanel(this);
        setContentPane(confirmPanel);

        this.owner = owner;
    }

    protected void close(){
        this.dispose();
        owner.dispose();
    }
}
