package gui.management.players;

import javax.swing.*;
import java.awt.*;

public class EditPlayer extends JDialog {

    private Image icon = new ImageIcon("data/images/edit.png").getImage();
    private final Color BACKGROUND = new Color(60, 63, 65);

    public EditPlayer(JDialog owner){
        super(owner);

        initDialog();

        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(BACKGROUND);
        setContentPane(mainPanel);
    }

    private void initDialog(){
        setResizable(false);
        setModal(true);
        setTitle("Edit Player");
        setIconImage(icon);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        Dimension windowSize = new Dimension(700, 500);
        setSize(windowSize);
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        Point centerPoint = ge.getCenterPoint();
        int dx = centerPoint.x - windowSize.width / 2;
        int dy = centerPoint.y - windowSize.height / 2;
        setLocation(dx, dy);
    }
}
