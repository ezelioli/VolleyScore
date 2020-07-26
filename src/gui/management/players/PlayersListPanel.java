package gui.management.players;

import domain.PlayerInfo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class PlayersListPanel extends JPanel implements MouseListener {

    private JDialog owner;
    private PlayersEditingPanel mainPanel;
    private  PlayerInfoPanel playerInfoPanel;
    private ArrayList<PlayerInfo> players;

    private final Color BACKGROUND = new Color(60, 63, 65);
    private ArrayList<RowPanel> rowPanels;

    public PlayersListPanel(JDialog owner, PlayersEditingPanel mainPanel, ArrayList<PlayerInfo> players, PlayerInfoPanel playerInfoPanel){

        super();

        this.owner = owner;
        this.mainPanel = mainPanel;
        this.playerInfoPanel = playerInfoPanel;
        this.players = sortPlayersByName(players);

        buildPanel();
    }

    private void buildPanel(){
        int gridRows = Math.max(players.size(), 10);
        setLayout(new GridLayout(gridRows, 1));
        setBackground(BACKGROUND);
        rowPanels = new ArrayList<RowPanel>();
        for(int i = 0; i < gridRows; ++i){
            if(i < players.size()){
                RowPanel rowPanel = new RowPanel(players.get(i));
                rowPanel.addMouseListener(this);
                if(i == 0){
                    rowPanel.setSelected(true);
                    playerInfoPanel.showPlayerInfo(rowPanel.getPlayer());
                }
                rowPanels.add(rowPanel);
                add(rowPanel, i);
            }else{
                JPanel emptyPanel = new JPanel();
                emptyPanel.setBackground(BACKGROUND);

                add(emptyPanel, i);
            }
        }
    }

    public void updatePanel(){
        for(int i = 0; i < players.size(); ++i){
            rowPanels.get(i).setPlayer(players.get(i));
            if(rowPanels.get(i).isSelected()){
                playerInfoPanel.showPlayerInfo(players.get(i));
            }
        }
    }

    private ArrayList<PlayerInfo> sortPlayersByName(ArrayList<PlayerInfo> players){
        ArrayList<PlayerInfo> sortedPlayers = new ArrayList<PlayerInfo>();
        while(sortedPlayers.size() < players.size()){
            PlayerInfo next = null;
            for(PlayerInfo player : players){
                if(! sortedPlayers.contains(player) && (next == null || player.getSurname().compareToIgnoreCase(next.getSurname()) < 0)){
                    next = player;
                }
            }
            sortedPlayers.add(next);
        }
        return sortedPlayers;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getClickCount() == 2 && ! e.isConsumed()){
            e.consume();
            RowPanel source = (RowPanel) e.getSource();
            EditPlayer editPlayerDialog = new EditPlayer(owner, source.getPlayer(), this);
            editPlayerDialog.setVisible(true);
        }else if(e.getClickCount() == 1 && ! e.isConsumed()){
            e.consume();
            RowPanel source = (RowPanel) e.getSource();
            for(RowPanel panel : rowPanels){
                panel.setSelected(false);
            }
            source.setSelected(true);
            playerInfoPanel.showPlayerInfo(source.getPlayer());
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        RowPanel source = (RowPanel) e.getSource();
        if(!source.isSelected()) {
            source.setBackground(RowPanel.MOUSEOVER_BACKGROUND);
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        RowPanel source = (RowPanel) e.getSource();
        if(!source.isSelected()){
            source.setBackground(RowPanel.BACKGROUND);
        }
    }
}
