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
    private ArrayList<PlayerInfo> players;

    private final Color BACKGROUND = new Color(60, 63, 65);
    private final Color MOUSEOVER_BACKGROUND = new Color(74, 78, 80);
    private final Color FOREGROUND = new Color(174, 176, 179);
    private final Font FONT = new Font("Times New Roman", Font.PLAIN, 18);

    public PlayersListPanel(JDialog owner, PlayersEditingPanel mainPanel, ArrayList<PlayerInfo> players){

        super();

        this.owner = owner;
        this.mainPanel = mainPanel;
        this.players = players;

        buildPanel();
    }

    private void buildPanel(){
        int gridRows = Math.max(players.size(), 10);
        setLayout(new GridLayout(gridRows, 1));
        setBackground(BACKGROUND);
        for(int i = 0; i < gridRows; ++i){
            if(i < players.size()){
                String fullPlayerName = players.get(i).getName() + " " + players.get(i).getSurname().toUpperCase();
                JLabel playerName = new JLabel(fullPlayerName);
                playerName.setBackground(BACKGROUND);
                playerName.setForeground(FOREGROUND);
                playerName.setFont(FONT);
                playerName.setHorizontalAlignment(JLabel.CENTER);
                playerName.setVerticalAlignment(JLabel.CENTER);
                JPanel playerPanel = new JPanel();
                playerPanel.setBackground(BACKGROUND);
                playerPanel.addMouseListener(this);
                playerPanel.add(playerName);
                add(playerPanel, i);
            }else{
                JPanel emptyPanel = new JPanel();
                emptyPanel.setBackground(BACKGROUND);
                add(emptyPanel, i);
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        //TODO: implement show selected player info
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        JPanel source = (JPanel) e.getSource();
        source.setBackground(MOUSEOVER_BACKGROUND);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        JPanel source = (JPanel) e.getSource();
        source.setBackground(BACKGROUND);
    }
}
