package gui.management;

import db.DBAccessManager;
import domain.PlayerInfo;
import domain.Team;
import exceptions.DatabaseException;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

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
