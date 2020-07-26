package gui.management;

import domain.PlayerInfo;
import domain.Team;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TeamEditingPanel extends JPanel implements ActionListener {

    private static final Color EXTERNAL_BACKGROUND = new Color(60, 63, 65);
    private final Color FOREGROUND = new Color(174, 176, 179);
    private final Font TITLE_FONT = new Font("Times New Roman", Font.BOLD, 30);

    private JButton saveButton;
    private JButton cancelButton;
    private JDialog owner;

    public TeamEditingPanel(JDialog owner, Team team){

        super(new BorderLayout());

        this.owner = owner;

        String title = team.getName();
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

        saveButton = new JButton("Save");
        saveButton.setBackground(FOREGROUND);
        saveButton.setForeground(EXTERNAL_BACKGROUND);
        saveButton.setFocusPainted(false);
        saveButton.addActionListener(this);

        cancelButton = new JButton("Cancel");
        cancelButton.setBackground(FOREGROUND);
        cancelButton.setForeground(EXTERNAL_BACKGROUND);
        cancelButton.setFocusPainted(false);
        cancelButton.addActionListener(this);

        JLabel emptyLabel = new JLabel(" ");

        FlowLayout buttonsPanelLayout = new FlowLayout();
        buttonsPanelLayout.setAlignment(FlowLayout.RIGHT);
        buttonsPanelLayout.setHgap(15);
        buttonsPanelLayout.setVgap(10);
        JPanel buttonsPanel = new JPanel(buttonsPanelLayout);
        buttonsPanel.setBackground(EXTERNAL_BACKGROUND);
        buttonsPanel.add(cancelButton);
        buttonsPanel.add(saveButton);
        buttonsPanel.add(emptyLabel);

        JPanel centralPanel = new TeamInfoPanel(owner, team);

        add(titlePanel, BorderLayout.NORTH);
        add(leftPanel, BorderLayout.WEST);
        add(rightPanel, BorderLayout.EAST);
        add(buttonsPanel, BorderLayout.SOUTH);
        add(centralPanel, BorderLayout.CENTER);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == saveButton){
            //TODO: implement save team and exit
        }else if(e.getSource() == cancelButton){
            String message = "Exit without saving?";
            TeamManagementOkCancelDialog confirmDialog = new TeamManagementOkCancelDialog(owner, message);
            confirmDialog.setVisible(true);
        }
    }
}
