package gui.management.players;

import domain.PlayerInfo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditPlayer extends JDialog implements ActionListener {

    private Image icon = new ImageIcon("data/images/edit.png").getImage();
    private final Color BACKGROUND = new Color(60, 63, 65);
    private final Color EXTERNAL_BACKGROUND = new Color(43, 43, 44);
    private final Color FOREGROUND = new Color(174, 176, 179);
    private final Font TITLE_FONT = new Font("Times New Roman", Font.BOLD, 30);
    private final String[] ROLES = new String[] {"setter", "spiker", "opposite", "middle-blocker", "libero"};

    private JButton saveButton;
    private JButton cancelButton;
    private EditPlayerTextField numberTxt;
    private EditPlayerTextField nameTxt;
    private EditPlayerTextField surnameTxt;
    private EditPlayerTextField birthdayTxt;
    private EditPlayerTextField nationalityTxt;
    private JComboBox<String> rolesBox;

    private PlayerInfo player;

    public EditPlayer(JDialog owner){

        super(owner);

        initDialog();

        JLabel titleLabel = new JLabel("Edit Player");
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

        JPanel centralPanel = buildCentralPanel();

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(titlePanel, BorderLayout.NORTH);
        mainPanel.add(leftPanel, BorderLayout.WEST);
        mainPanel.add(rightPanel, BorderLayout.EAST);
        mainPanel.add(buttonsPanel, BorderLayout.SOUTH);
        mainPanel.add(centralPanel, BorderLayout.CENTER);
        setContentPane(mainPanel);
    }

    public EditPlayer(JDialog owner, PlayerInfo player){
        this(owner);
        this.player = player;
    }

    private void initDialog(){
        setResizable(false);
        setModal(true);
        setTitle("Edit Player");
        setIconImage(icon);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        Dimension windowSize = new Dimension(560, 670);
        setSize(windowSize);
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        Point centerPoint = ge.getCenterPoint();
        int dx = centerPoint.x - windowSize.width / 2;
        int dy = centerPoint.y - windowSize.height / 2;
        setLocation(dx, dy);
    }

    private JPanel buildCentralPanel(){

        JLabel pictureLabel = new JLabel();
        pictureLabel.setAlignmentX(JLabel.CENTER);
        pictureLabel.setAlignmentY(JLabel.CENTER);
        pictureLabel.setSize(128, 128);
        pictureLabel.setIcon(PlayerInfoPanel.defaultPlayerIcon);

        FlowLayout pictureLayout = new FlowLayout();
        pictureLayout.setAlignment(FlowLayout.CENTER);
        pictureLayout.setVgap(25);
        JPanel northPanel = new JPanel(pictureLayout);
        northPanel.setBackground(BACKGROUND);
        northPanel.add(pictureLabel);

        JLabel numberLabel = new PlayerInfoLabel("Number:");
        numberTxt = new EditPlayerTextField();
        JPanel numberPanel = new JPanel();
        numberPanel.setBackground(BACKGROUND);
        numberPanel.add(numberLabel);
        numberPanel.add(numberTxt);

        JLabel nameLabel = new PlayerInfoLabel("Name:");
        nameTxt = new EditPlayerTextField();
        JPanel namePanel = new JPanel();
        namePanel.setBackground(BACKGROUND);
        namePanel.add(nameLabel);
        namePanel.add(nameTxt);

        JLabel surnameLabel = new PlayerInfoLabel("Surname:");
        surnameTxt = new EditPlayerTextField();
        JPanel surnamePanel = new JPanel();
        surnamePanel.setBackground(BACKGROUND);
        surnamePanel.add(surnameLabel);
        surnamePanel.add(surnameTxt);

        JLabel birthdayLabel = new PlayerInfoLabel("Birthday:");
        birthdayTxt = new EditPlayerTextField();
        JPanel birthdayPanel = new JPanel();
        birthdayPanel.setBackground(BACKGROUND);
        birthdayPanel.add(birthdayLabel);
        birthdayPanel.add(birthdayTxt);

        JLabel nationalityLabel = new PlayerInfoLabel("Nationality:");
        nationalityTxt = new EditPlayerTextField();
        JPanel nationalityPanel = new JPanel();
        nationalityPanel.setBackground(BACKGROUND);
        nationalityPanel.add(nationalityLabel);
        nationalityPanel.add(nationalityTxt);

        JLabel roleLabel = new PlayerInfoLabel("Role:");
        rolesBox = new JComboBox<String>(ROLES);
        rolesBox.setPreferredSize(EditPlayerTextField.dimension);
        rolesBox.setFont(EditPlayerTextField.FONT);
        JPanel rolesPanel = new JPanel();
        rolesPanel.setBackground(BACKGROUND);
        rolesPanel.add(roleLabel);
        rolesPanel.add(rolesBox);

        JPanel southPanel = new JPanel(new GridLayout(6, 1));
        southPanel.setBackground(BACKGROUND);
        southPanel.add(namePanel, 0);
        southPanel.add(surnamePanel, 1);
        southPanel.add(birthdayPanel, 2);
        southPanel.add(nationalityPanel, 3);
        southPanel.add(numberPanel, 4);
        southPanel.add(rolesPanel, 5);

        JPanel centralPanel = new JPanel(new BorderLayout());
        centralPanel.add(northPanel, BorderLayout.NORTH);
        centralPanel.add(southPanel, BorderLayout.CENTER);

        return centralPanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
