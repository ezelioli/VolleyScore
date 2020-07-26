package gui.management;

import domain.Team;

import javax.swing.*;
import java.awt.*;

public class TeamEditing extends JDialog {

    private Image icon = new ImageIcon("data/images/edit.png").getImage();

    public TeamEditing(JDialog owner, Team team){

        super(owner);

        initDialog();

        TeamEditingPanel mainPanel = new TeamEditingPanel(this, team);
        setContentPane(mainPanel);

    }

    private void initDialog(){
        setResizable(false);
        setModal(true);
        setTitle("Teams Managment");
        setIconImage(icon);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        Dimension windowSize = new Dimension(1000, 800);
        setSize(windowSize);
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        Point centerPoint = ge.getCenterPoint();
        int dx = centerPoint.x - windowSize.width / 2;
        int dy = centerPoint.y - windowSize.height / 2;
        setLocation(dx, dy);
    }
}
