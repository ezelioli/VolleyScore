package gui.management.players;

import domain.PlayerInfo;

import javax.swing.*;
import java.awt.*;

public class RowPanel extends JPanel {

    public static final Color BACKGROUND = new Color(60, 63, 65);
    public static final Color MOUSEOVER_BACKGROUND = new Color(74, 78, 80);
    public static final Color SELECTED_BACKGROUND = new Color(111, 113, 114);
    private final Color FOREGROUND = new Color(174, 176, 179);
    private final Font FONT = new Font("Times New Roman", Font.PLAIN, 16);

    private JPanel numberPanel;
    private JPanel namePanel;
    private JPanel rolePanel;

    private JLabel numberLabel;
    private JLabel playerName;
    private JLabel roleLabel;

    private boolean selected = false;
    private PlayerInfo player;

    public RowPanel(PlayerInfo player){

        this.player = player;

        setLayout(new BorderLayout());

        FlowLayout rowElementLayout = new FlowLayout();
        rowElementLayout.setHgap(5);
        rowElementLayout.setVgap(15);
        rowElementLayout.setAlignment(FlowLayout.CENTER);

        numberLabel = new JLabel(Integer.toString(player.getNumber()));
        numberLabel.setForeground(FOREGROUND);
        numberLabel.setFont(FONT);
        numberLabel.setHorizontalAlignment(JLabel.CENTER);
        numberLabel.setVerticalAlignment(JLabel.CENTER);
        numberLabel.setPreferredSize(new Dimension(30, 20));

        numberPanel = new JPanel(rowElementLayout);
        numberPanel.setSize(20, 20);
        numberPanel.setBackground(BACKGROUND);
        numberPanel.add(numberLabel);

        String fullPlayerName = player.getName() + " " + player.getSurname().toUpperCase();
        playerName = new JLabel(fullPlayerName);
        playerName.setBackground(BACKGROUND);
        playerName.setForeground(FOREGROUND);
        playerName.setFont(FONT);
        playerName.setHorizontalAlignment(JLabel.CENTER);
        playerName.setVerticalAlignment(JLabel.CENTER);

        namePanel = new JPanel(rowElementLayout);
        namePanel.setBackground(BACKGROUND);
        namePanel.add(playerName);

        roleLabel = new JLabel(player.getRole());
        roleLabel.setHorizontalAlignment(JLabel.CENTER);
        roleLabel.setVerticalAlignment(JLabel.CENTER);
        roleLabel.setFont(FONT);
        roleLabel.setForeground(FOREGROUND);

        rolePanel = new JPanel(rowElementLayout);
        rolePanel.setBackground(BACKGROUND);
        rolePanel.add(roleLabel);

        add(numberPanel, BorderLayout.WEST);
        add(namePanel, BorderLayout.CENTER);
        add(rolePanel, BorderLayout.EAST);
    }

    public boolean isSelected(){
        return selected;
    }

    public void setSelected(boolean selection){
        this.selected = selection;
        if(selected){
            setBackground(SELECTED_BACKGROUND);
        }else{
            setBackground(BACKGROUND);
        }
    }

    @Override
    public void setBackground(Color bg) {
        super.setBackground(bg);
        if(numberPanel != null && namePanel != null && rolePanel != null) {
            numberPanel.setBackground(bg);
            namePanel.setBackground(bg);
            rolePanel.setBackground(bg);
        }
    }

    public PlayerInfo getPlayer(){
        return player;
    }

    public void setPlayer(PlayerInfo player){
        this.player = player;
        numberLabel.setText(Integer.toString(player.getNumber()));
        String fullPlayerName = player.getName() + " " + player.getSurname().toUpperCase();
        playerName.setText(fullPlayerName);
        roleLabel.setText(player.getRole());
    }
}
