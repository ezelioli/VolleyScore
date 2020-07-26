package gui.management;

import domain.Team;
import gui.management.buttons.TeamsButtonsFactory;
import gui.management.players.AddPlayer;
import gui.management.players.PlayersEditingPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class TeamInfoPanel extends JPanel implements MouseListener, ActionListener {

    private final Color BACKGROUND = new Color(43, 43, 44);
    private final Color MOUSEOVER_BACKGROUND = new Color(60, 63, 65);
    private final Color MOUSEPRESSED_BACKGROUND = new Color(174, 176, 179);
    private final Color FOREGROUND = new Color(174, 176, 179);
    private final Font FONT = new Font("Times New Roman", Font.BOLD, 22);
    private final ImageIcon defaultBadge = new ImageIcon("data/images/badge.png");
    private final ImageIcon editIcon = new ImageIcon("data/images/edit.png");

    private JPanel assistantLabelBackground;
    private JPanel coachLabelBackground;
    private JButton addPlayerButton;
    private JButton editPlayerButton;

    private Team team;
    private JDialog owner;

    public TeamInfoPanel(JDialog owner, Team team){

        super(new BorderLayout());

        this.owner = owner;
        this.team = team;

        JLabel teamIconLabel = new JLabel();
        teamIconLabel.setSize(64, 64);
        teamIconLabel.setIcon(defaultBadge);

        FlowLayout teamIconLayout = new FlowLayout();
        teamIconLayout.setHgap(10);
        teamIconLayout.setAlignment(FlowLayout.CENTER);
        JPanel teamIconPanel = new JPanel(teamIconLayout);
        teamIconPanel.setBackground(BACKGROUND);
        teamIconPanel.add(teamIconLabel);

        JLabel teamNameLabel = new JLabel("Team name:");
        teamNameLabel.setForeground(FOREGROUND);
        JTextField teamNameTxt = new JTextField(team.getName());
        teamNameTxt.setPreferredSize(new Dimension(340, 30));
        teamNameTxt.setFont(FONT);
        teamNameTxt.setHorizontalAlignment(JLabel.CENTER);

        FlowLayout teamNameLayout = new FlowLayout();
        teamNameLayout.setVgap(10);
        JPanel teamNamePanel = new JPanel(teamNameLayout);
        teamNamePanel.setBackground(BACKGROUND);
        teamNamePanel.add(teamNameLabel);
        teamNamePanel.add(teamNameTxt);

        JLabel headCoachLabel = new JLabel("Coach:");
        headCoachLabel.setForeground(FOREGROUND);

        String headCoachName = "";
        if(team.getHeadCoach() != null){
            headCoachName = team.getHeadCoach().getName() + " " + team.getHeadCoach().getSurname();
        }
        JTextField headCoachTxt = new JTextField(headCoachName);
        Dimension coachTxtDimension = new Dimension(110, 20);
        headCoachTxt.setPreferredSize(coachTxtDimension);
        headCoachTxt.setEditable(false);
        headCoachTxt.setBackground(FOREGROUND);
        headCoachTxt.setForeground(MOUSEOVER_BACKGROUND);

        JLabel editHeadCoachLabel = new JLabel();
        editHeadCoachLabel.setSize(24, 24);
        editHeadCoachLabel.setIcon(editIcon);

        coachLabelBackground = new JPanel(new BorderLayout());
        coachLabelBackground.setSize(32, 32);
        coachLabelBackground.setBackground(BACKGROUND);
        coachLabelBackground.add(editHeadCoachLabel, BorderLayout.CENTER);
        coachLabelBackground.addMouseListener(this);

        JLabel assistantCoachLabel = new JLabel("Assistant:");
        assistantCoachLabel.setForeground(FOREGROUND);

        String assistantCoachName = "";
        if(team.getAssistantCoach() != null){
            assistantCoachName = team.getAssistantCoach().getName() + " " + team.getAssistantCoach().getSurname();
        }
        JTextField assistantCoachTxt = new JTextField(assistantCoachName);
        assistantCoachTxt.setPreferredSize(coachTxtDimension);
        assistantCoachTxt.setEditable(false);
        assistantCoachTxt.setBackground(FOREGROUND);
        assistantCoachTxt.setForeground(MOUSEOVER_BACKGROUND);

        JLabel editAssistantCoachLabel = new JLabel();
        editAssistantCoachLabel.setSize(24, 24);
        editAssistantCoachLabel.setIcon(editIcon);

        assistantLabelBackground = new JPanel(new BorderLayout());
        assistantLabelBackground.setSize(32, 32);
        assistantLabelBackground.setBackground(BACKGROUND);
        assistantLabelBackground.add(editAssistantCoachLabel, BorderLayout.CENTER);
        assistantLabelBackground.addMouseListener(this);

        FlowLayout coachPanelLayout = new FlowLayout();
        coachPanelLayout.setHgap(10);
        coachPanelLayout.setVgap(5);

        JPanel coachPanel = new JPanel(coachPanelLayout);
        coachPanel.setBackground(BACKGROUND);
        coachPanel.add(headCoachLabel);
        coachPanel.add(headCoachTxt);
        coachPanel.add(coachLabelBackground);
        coachPanel.add(assistantCoachLabel);
        coachPanel.add(assistantCoachTxt);
        coachPanel.add(assistantLabelBackground);

        JPanel textPanel = new JPanel(new GridLayout(2, 1));
        textPanel.setBackground(BACKGROUND);
        textPanel.add(teamNamePanel, 0);
        textPanel.add(coachPanel, 1);

        JPanel northPanel = new JPanel(new BorderLayout());
        northPanel.setBackground(BACKGROUND);
        northPanel.add(teamIconPanel, BorderLayout.WEST);
        northPanel.add(textPanel, BorderLayout.CENTER);

        JPanel leftPanel = new JPanel();
        leftPanel.setBackground(BACKGROUND);
        leftPanel.setPreferredSize(new Dimension(15, 300));

        JPanel rightPanel = new JPanel();
        rightPanel.setBackground(BACKGROUND);
        rightPanel.setPreferredSize(new Dimension(15, 300));

        addPlayerButton = TeamsButtonsFactory.getButton(TeamsButtonsFactory.ADD_PLAYER_BUTTON);
        addPlayerButton.addActionListener(this);
        editPlayerButton = TeamsButtonsFactory.getButton(TeamsButtonsFactory.EDIT_PLAYER_BUTTON);
        editPlayerButton.addActionListener(this);

        FlowLayout southPanelLayout = new FlowLayout();
        southPanelLayout.setAlignment(FlowLayout.LEFT);
        southPanelLayout.setHgap(15);
        JPanel southPanel = new JPanel(southPanelLayout);
        southPanel.setBackground(BACKGROUND);
        southPanel.add(addPlayerButton);
        southPanel.add(editPlayerButton);

        JPanel centralPanel = new PlayersEditingPanel(owner, team);

        add(northPanel, BorderLayout.NORTH);
        add(leftPanel, BorderLayout.WEST);
        add(rightPanel, BorderLayout.EAST);
        add(southPanel, BorderLayout.SOUTH);
        add(centralPanel, BorderLayout.CENTER);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource() == coachLabelBackground){
            EditCoach editCoachDialog = new EditCoach(owner, team.getHeadCoach());
            editCoachDialog.setVisible(true);
        }else if(e.getSource() == assistantLabelBackground){
            EditCoach editCoachDialog = new EditCoach(owner, team.getAssistantCoach());
            editCoachDialog.setVisible(true);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        JPanel panel = (JPanel) e.getSource();
        panel.setBackground(MOUSEPRESSED_BACKGROUND);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        JPanel panel = (JPanel) e.getSource();
        panel.setBackground(MOUSEOVER_BACKGROUND);
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        JPanel panel = (JPanel) e.getSource();
        panel.setBackground(MOUSEOVER_BACKGROUND);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        JPanel panel = (JPanel) e.getSource();
        panel.setBackground(BACKGROUND);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == addPlayerButton){
            AddPlayer addPlayerDialog = new AddPlayer(owner);
            addPlayerDialog.setVisible(true);
        }
    }
}
