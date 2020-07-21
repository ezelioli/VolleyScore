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

    public PlayersEditingPanel(JDialog owner, Team team){

        super(new GridLayout(1, 2));

        this.owner = owner;

        loadPlayers(team);

        JScrollPane playersPanel = new PlayersListPanel(owner, this, players);

        JPanel editPlayerPanel = new PlayerInfoPanel(owner);

        add(playersPanel, 0);
        add(editPlayerPanel, 1);
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
