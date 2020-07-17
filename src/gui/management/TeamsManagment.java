package gui.management;

import db.DBAccessManager;
import domain.Championship;
import domain.Team;
import exceptions.DatabaseException;
import gui.templates.ErrorDialog;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class TeamsManagment extends JDialog {

    private Image icon = new ImageIcon("data/images/volleyball.png").getImage();

    private ArrayList<Team> teams;

    public TeamsManagment(JFrame owner, String season){
        super(owner);

        initDialog();

        loadChampionships(season);

        TeamsPanel mainPanel = new TeamsPanel(season, teams);
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

    private void loadChampionships(String season){
        Championship championship = new Championship(season);
        try {
            DBAccessManager db = DBAccessManager.getInstance();
            teams = db.loadTeamsOfChampionship(championship);
        }catch (DatabaseException exception){
            System.out.println(exception);
            String errorMessage = "Campionship " + season + " not found.";
            ErrorDialog errorDialog = new ErrorDialog(this, errorMessage);
            errorDialog.setVisible(true);
        }
    }
}
