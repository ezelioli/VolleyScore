package gui.management.players;

import domain.PlayerInfo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class PlayersListPanel extends JScrollPane implements MouseListener {

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
        setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
    }

    private void buildPanel(){
        JPanel gridPanel = new JPanel();
        int gridRows = Math.max(players.size(), 10);
        gridPanel.setLayout(new GridLayout(gridRows, 1));
        gridPanel.setBackground(BACKGROUND);
        for(int i = 0; i < gridRows; ++i){
            if(i < players.size()){
                JLabel numberLabel = new JLabel(Integer.toString(players.get(i).getNumber()));
                numberLabel.setForeground(FOREGROUND);
                numberLabel.setFont(FONT);
                numberLabel.setHorizontalAlignment(JLabel.CENTER);
                numberLabel.setVerticalAlignment(JLabel.CENTER);
                numberLabel.setPreferredSize(new Dimension(30, 20));
                JPanel numberPanel = new JPanel();
                numberPanel.setSize(20, 20);
                numberPanel.setBackground(BACKGROUND);
                numberPanel.add(numberLabel);

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

                JLabel roleLabel = new JLabel(players.get(i).getRole());
                roleLabel.setHorizontalAlignment(JLabel.CENTER);
                roleLabel.setVerticalAlignment(JLabel.CENTER);
                roleLabel.setFont(FONT);
                roleLabel.setForeground(FOREGROUND);
                JPanel rolePanel = new JPanel();
                rolePanel.setBackground(BACKGROUND);
                rolePanel.add(roleLabel);

                JPanel rowPanel = new JPanel(new GridLayout(1, 3));
                rowPanel.add(numberPanel, 0);
                rowPanel.add(playerPanel, 1);
                rowPanel.add(rolePanel, 2);
                gridPanel.add(rowPanel, i);
            }else{
                JPanel emptyPanel = new JPanel();
                emptyPanel.setBackground(BACKGROUND);
                gridPanel.add(emptyPanel, i);
            }
        }
        setViewportView(gridPanel);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        //TODO: implement show selected player info
        if(e.getClickCount() == 2 && ! e.isConsumed()){
            e.consume();
            EditPlayer editPlayerDialog = new EditPlayer(owner);
            editPlayerDialog.setVisible(true);
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
        JPanel source = (JPanel) e.getSource();
        source.setBackground(MOUSEOVER_BACKGROUND);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        JPanel source = (JPanel) e.getSource();
        source.setBackground(BACKGROUND);
    }
}
