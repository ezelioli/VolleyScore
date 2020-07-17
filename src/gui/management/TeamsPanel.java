package gui.management;

import domain.Team;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class TeamsPanel extends JPanel implements ActionListener {

    private static final Color EXTERNAL_BACKGROUND = new Color(60, 63, 65);
    private static final Color BUTTON_BACKGROUND = new Color(72, 155, 84);
    private final Color FOREGROUND = new Color(174, 176, 179);
    private final Color BUTTON_FOREGROUND = new Color(255, 255, 255);
    private final Font TITLE_FONT = new Font("Times New Roman", Font.BOLD, 30);


    private JButton addTeamBtn;

    public TeamsPanel(String season, ArrayList<Team> teams){

        super(new BorderLayout());

        String title = "Teams of championship \"" + season + "\"";
        JLabel titleLabel = new JLabel(title);
        titleLabel.setForeground(FOREGROUND);
        titleLabel.setFont(TITLE_FONT);

        FlowLayout titleLayout = new FlowLayout();
        titleLayout.setVgap(20);
        JPanel titlePanel = new JPanel(titleLayout);
        titlePanel.setBackground(EXTERNAL_BACKGROUND);
        titlePanel.setAlignmentX(CENTER_ALIGNMENT);
        titlePanel.setAlignmentY(CENTER_ALIGNMENT);
        titlePanel.add(titleLabel);

        JPanel leftPanel = new JPanel();
        leftPanel.setBackground(EXTERNAL_BACKGROUND);
        leftPanel.setPreferredSize(new Dimension(30, 400));

        JPanel rightPanel = new JPanel();
        rightPanel.setBackground(EXTERNAL_BACKGROUND);
        rightPanel.setPreferredSize(new Dimension(30, 400));

        addTeamBtn = new TeamsButton("New Team");
        addTeamBtn.setBackground(BUTTON_BACKGROUND);
        addTeamBtn.setForeground(BUTTON_FOREGROUND);
        addTeamBtn.setFocusPainted(false);
        addTeamBtn.addActionListener(this);

        FlowLayout buttonsLayout = new FlowLayout();
        buttonsLayout.setVgap(15);
        JPanel buttonsPanel = new JPanel(buttonsLayout);
        buttonsPanel.setBackground(EXTERNAL_BACKGROUND);
        buttonsPanel.setAlignmentX(CENTER_ALIGNMENT);
        buttonsPanel.setAlignmentY(CENTER_ALIGNMENT);
        buttonsPanel.add(addTeamBtn);

        TeamsGridPanel teamsGrid = new TeamsGridPanel(teams);
        JScrollPane centralPanel = new JScrollPane(teamsGrid);
        centralPanel.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        centralPanel.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);

        add(titlePanel, BorderLayout.NORTH);
        add(leftPanel, BorderLayout.WEST);
        add(rightPanel, BorderLayout.EAST);
        add(buttonsPanel, BorderLayout.SOUTH);
        add(centralPanel, BorderLayout.CENTER);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == addTeamBtn){
            //TODO: implement add team
        }
    }
}
