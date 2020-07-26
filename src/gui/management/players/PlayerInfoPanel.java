package gui.management.players;

import domain.PlayerInfo;

import javax.swing.*;
import java.awt.*;

public class PlayerInfoPanel extends JPanel {

    private JDialog owner;

    private final Color BACKGROUND = new Color(60, 63, 65);
    private final Color FOREGROUND = new Color(174, 176, 179);
    private final Font FONT = new Font("Times New Roman", Font.PLAIN, 22);
    public static final ImageIcon defaultPlayerIcon = new ImageIcon("data/images/player.png");

    private PlayerInfo player;

    private JTextField numberTxt;
    private JTextField nameTxt;
    private JTextField surnameTxt;
    private JTextField birthdayTxt;
    private JTextField nationalityTxt;
    private JTextField roleTxt;

    public PlayerInfoPanel(JDialog owner){

        super(new BorderLayout());

        this.owner = owner;

        JLabel pictureLabel = new JLabel();
        pictureLabel.setAlignmentX(JLabel.CENTER);
        pictureLabel.setAlignmentY(JLabel.CENTER);
        pictureLabel.setSize(128, 128);
        pictureLabel.setIcon(defaultPlayerIcon);

        FlowLayout pictureLayout = new FlowLayout();
        pictureLayout.setAlignment(FlowLayout.CENTER);
        pictureLayout.setVgap(25);
        JPanel northPanel = new JPanel(pictureLayout);
        northPanel.setBackground(BACKGROUND);
        northPanel.add(pictureLabel);

        JLabel numberLabel = new PlayerInfoLabel("Number:");
        numberTxt = new PlayerInfoTextField();
        JPanel numberPanel = new JPanel();
        numberPanel.setBackground(BACKGROUND);
        numberPanel.add(numberLabel);
        numberPanel.add(numberTxt);

        JLabel nameLabel = new PlayerInfoLabel("Name:");
        nameTxt = new PlayerInfoTextField();
        JPanel namePanel = new JPanel();
        namePanel.setBackground(BACKGROUND);
        namePanel.add(nameLabel);
        namePanel.add(nameTxt);

        JLabel surnameLabel = new PlayerInfoLabel("Surname:");
        surnameTxt = new PlayerInfoTextField();
        JPanel surnamePanel = new JPanel();
        surnamePanel.setBackground(BACKGROUND);
        surnamePanel.add(surnameLabel);
        surnamePanel.add(surnameTxt);

        JLabel birthdayLabel = new PlayerInfoLabel("Birthday:");
        birthdayTxt = new PlayerInfoTextField();
        JPanel birthdayPanel = new JPanel();
        birthdayPanel.setBackground(BACKGROUND);
        birthdayPanel.add(birthdayLabel);
        birthdayPanel.add(birthdayTxt);

        JLabel nationalityLabel = new PlayerInfoLabel("Nationality:");
        nationalityTxt = new PlayerInfoTextField();
        JPanel nationalityPanel = new JPanel();
        nationalityPanel.setBackground(BACKGROUND);
        nationalityPanel.add(nationalityLabel);
        nationalityPanel.add(nationalityTxt);

        JLabel roleLabel = new PlayerInfoLabel("Role:");
        roleTxt = new PlayerInfoTextField();
        JPanel rolesPanel = new JPanel();
        rolesPanel.setBackground(BACKGROUND);
        rolesPanel.add(roleLabel);
        rolesPanel.add(roleTxt);

        JPanel centralPanel = new JPanel(new GridLayout(6, 1));
        centralPanel.setBackground(BACKGROUND);
        centralPanel.add(namePanel, 0);
        centralPanel.add(surnamePanel, 1);
        centralPanel.add(birthdayPanel, 2);
        centralPanel.add(nationalityPanel, 3);
        centralPanel.add(numberPanel, 4);
        centralPanel.add(rolesPanel, 5);

        add(northPanel, BorderLayout.NORTH);
        add(centralPanel, BorderLayout.CENTER);

    }

    public void showPlayerInfo(PlayerInfo player){
        this.player = player;
        nameTxt.setText(player.getName());
        surnameTxt.setText(player.getSurname());
        roleTxt.setText(player.getRole());
        numberTxt.setText(Integer.toString(player.getNumber()));
        nationalityTxt.setText(player.getNationality());
        birthdayTxt.setText(player.getBirthday().toString());
    }
}
