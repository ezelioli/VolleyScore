package gui.management.players;

import db.DBAccessManager;
import domain.PlayerInfo;
import domain.Team;
import exceptions.DatabaseException;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class PlayersEditingPanel extends JPanel {

    private JDialog owner;
    private ArrayList<PlayerInfo> players;

    private PlayerInfoPanel playerInfoPanel;
    private JPanel playersPanel;

    public PlayersEditingPanel(JDialog owner, Team team){

        super(new GridLayout(1, 2));

        this.owner = owner;

        loadPlayers(team);

        playerInfoPanel = new PlayerInfoPanel(owner);

        playersPanel = new PlayersListPanel(owner, this, players, playerInfoPanel);
        JScrollPane leftPanel = new JScrollPane(playersPanel);
        leftPanel.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        leftPanel.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);

        add(leftPanel, 0);
        add(playerInfoPanel, 1);
    }

    private void loadPlayers(Team team){
        players = new ArrayList<PlayerInfo>();
        if(team == null)
            return;
        try{
            DBAccessManager db = DBAccessManager.getInstance();
            players = db.loadPlayersOfTeam(team);
        }catch (DatabaseException exception){
            System.out.println("No players found for team " + team.getName());
        }
    }
}
