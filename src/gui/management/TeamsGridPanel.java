package gui.management;

import domain.Team;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class TeamsGridPanel extends JPanel implements MouseListener {

    private ArrayList<Team> teams;

    private final Font TEAMS_FONT = new Font("Times New Roman", Font.PLAIN, 18);
    private final Color BACKGROUND = new Color(43, 43, 44);
    private final Color MOUSEOVER_BACKGROUND = new Color(60, 63, 65);
    private final Color FOREGROUND = new Color(174, 176, 179);

    public TeamsGridPanel(ArrayList<Team> teams){
        super();

        this.teams = teams;

        buildPanel();
    }

    private void buildPanel(){
        int gridRows = Math.max(teams.size(), 10);
        setLayout(new GridLayout(gridRows, 1));
        setBackground(BACKGROUND);
        for(int i = 0; i < gridRows; ++i){
            if(i < teams.size()){
                JLabel teamName = new JLabel(teams.get(i).getName());
                teamName.setBackground(BACKGROUND);
                teamName.setForeground(FOREGROUND);
                teamName.setFont(TEAMS_FONT);
                teamName.setHorizontalAlignment(JLabel.CENTER);
                teamName.setVerticalAlignment(JLabel.CENTER);
                JPanel teamPanel = new JPanel();
                teamPanel.setBackground(BACKGROUND);
                teamPanel.addMouseListener(this);
                teamPanel.add(teamName);
                add(teamPanel, i);
            }else{
                JPanel emptyPanel = new JPanel();
                emptyPanel.setBackground(BACKGROUND);
                add(emptyPanel, i);
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {

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
