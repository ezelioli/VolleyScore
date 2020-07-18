package gui.management;

import domain.Coach;

import javax.swing.*;
import java.awt.*;

public class EditCoach extends JDialog {

    private final Color BACKGROUND = new Color(60, 63, 65);

    public EditCoach(JDialog owner, Coach coach){

        super(owner);

        initDialog();

        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(BACKGROUND);
        setContentPane(mainPanel);
    }

    private void initDialog(){
        setResizable(false);
        setModal(true);
        setTitle("Edit Coach");
        ImageIcon editIcon = new ImageIcon("data/images/edit.png");
        setIconImage(editIcon.getImage());
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        Dimension windowSize = new Dimension(500, 500);
        setSize(windowSize);
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        Point centerPoint = ge.getCenterPoint();
        int dx = centerPoint.x - windowSize.width / 2;
        int dy = centerPoint.y - windowSize.height / 2;
        setLocation(dx, dy);
    }

}
