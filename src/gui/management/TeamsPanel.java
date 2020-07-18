package gui.management;

import domain.Team;
import gui.management.buttons.TeamsButtonsFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class TeamsPanel extends JPanel implements ActionListener {

    private static final Color EXTERNAL_BACKGROUND = new Color(60, 63, 65);
    private final Color FOREGROUND = new Color(197, 83, 80);
    private final Font TITLE_FONT = new Font("Times New Roman", Font.BOLD, 30);

    private TeamsManagment dialog;
    private JButton addTeamBtn;
    private JButton closeBtn;
    private ArrayList<Team> teams;

    public TeamsPanel(TeamsManagment dialog, String season, ArrayList<Team> teams){

        super(new BorderLayout());

        this.dialog = dialog;
        this.teams = teams;

        String title = season;
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

        addTeamBtn = TeamsButtonsFactory.getButton(TeamsButtonsFactory.NEW_GAME_BUTTON);
        addTeamBtn.setAlignmentX(CENTER_ALIGNMENT);
        addTeamBtn.addActionListener(this);

        closeBtn = TeamsButtonsFactory.getButton(TeamsButtonsFactory.CLOSE_BUTTON);
        closeBtn.setAlignmentX(LEFT_ALIGNMENT);
        closeBtn.addActionListener(this);

        FlowLayout buttonsLayout = new FlowLayout();
        buttonsLayout.setVgap(15);
        buttonsLayout.setHgap(30);
        buttonsLayout.setAlignment(FlowLayout.CENTER);
        JPanel buttonsPanel = new JPanel(buttonsLayout);
        buttonsPanel.setBackground(EXTERNAL_BACKGROUND);
        buttonsPanel.add(closeBtn);
        buttonsPanel.add(addTeamBtn);

        TeamsGridPanel teamsGrid = new TeamsGridPanel(dialog, teams);
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
            Team emptyTeam = new Team("New Team", null , null);
            TeamEditing teamEditingDialog = new TeamEditing(dialog, emptyTeam);
            teamEditingDialog.setVisible(true);
        }else if(e.getSource() == closeBtn){
            dialog.dispose();
        }
    }
}
