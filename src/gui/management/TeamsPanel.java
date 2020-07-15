package gui.management;

import javax.swing.*;
import java.awt.*;

public class TeamsPanel extends JPanel {

    private static final Color EXTERNAL_BACKGROUND = new Color(60, 63, 65);
    private static final Color INTERNAL_BACKGROUND = new Color(43, 43, 44);
    private final Color FOREGROUND = new Color(174, 176, 179);
    private final Font TITLE_FONT = new Font("Times New Roman", Font.BOLD, 30);

    public TeamsPanel(String season){
        super(new BorderLayout());

        JPanel titlePanel = new JPanel();
        titlePanel.setBackground(EXTERNAL_BACKGROUND);
        titlePanel.setAlignmentX(CENTER_ALIGNMENT);
        titlePanel.setAlignmentY(CENTER_ALIGNMENT);
        String title = "Teams of championship \"" + season + "\"";
        JLabel titleLabel = new JLabel(title);
        titleLabel.setForeground(FOREGROUND);
        titleLabel.setFont(TITLE_FONT);
        titlePanel.add(titleLabel);

        JPanel leftPanel = new JPanel();
        leftPanel.setBackground(EXTERNAL_BACKGROUND);
        leftPanel.setPreferredSize(new Dimension(30, 400));

        JPanel rightPanel = new JPanel();
        rightPanel.setBackground(EXTERNAL_BACKGROUND);
        rightPanel.setPreferredSize(new Dimension(30, 400));

        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setBackground(EXTERNAL_BACKGROUND);
        buttonsPanel.setAlignmentX(CENTER_ALIGNMENT);
        buttonsPanel.setAlignmentY(CENTER_ALIGNMENT);
        JButton newTeamBtn = new TeamsButton("New Team");
        buttonsPanel.add(newTeamBtn);

        JPanel centralPanel = new JPanel();
        centralPanel.setBackground(INTERNAL_BACKGROUND);

        add(titlePanel, BorderLayout.NORTH);
        add(leftPanel, BorderLayout.WEST);
        add(rightPanel, BorderLayout.EAST);
        add(buttonsPanel, BorderLayout.SOUTH);
        add(centralPanel, BorderLayout.CENTER);

    }
}
