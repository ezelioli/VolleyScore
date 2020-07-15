package gui.menu;

import gui.menu.manageseason.SeasonsDialog;
import gui.settings.Settings;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Properties;

public class MainMenu extends JFrame implements ActionListener, MouseListener {

    private JPanel contentPane;
    private JButton btnQuit;
    private JButton btnNewGame;
    private JButton btnManage;
    private JButton btnStats;
    private SeasonsBox seasonsBox;
    private ImageIcon settingsBlack = new ImageIcon("data/images/settings_black.png");
    private ImageIcon settingsWhite = new ImageIcon("data/images/settings_white.png");
    private JLabel settingsLabel;
    private Properties properties;

    private static final Color BACKGROUND = new Color(60, 63, 65, 255);

    public MainMenu() {

        initFrame();

        contentPane = new JPanel();
        contentPane.setBackground(BACKGROUND);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JSeparator separator = new JSeparator();
        separator.setForeground(new Color(192, 192, 192));
        separator.setBounds(48, 78, 515, 5);
        contentPane.add(separator);

        JLabel lblVolleyScore = new JLabel("VolleyScore");
        lblVolleyScore.setForeground(new Color(197, 83, 80));
        lblVolleyScore.setFont(new Font("Tw Cen MT", Font.BOLD, 27));
        lblVolleyScore.setHorizontalAlignment(SwingConstants.CENTER);
        lblVolleyScore.setBounds(133, 25, 368, 31);
        contentPane.add(lblVolleyScore);

        btnNewGame = new MenuButton("New Game", 246, 149);
        btnNewGame.addActionListener(this);
        contentPane.add(btnNewGame);

        btnManage = new MenuButton("Manage", 246, 229);
        btnManage.addActionListener(this);
        contentPane.add(btnManage);

        btnStats = new MenuButton("Stats", 246, 318);
        btnStats.addActionListener(this);
        contentPane.add(btnStats);

        btnQuit = new MenuButton("Quit", 246, 450);
        btnQuit.addActionListener(this);
        contentPane.add(btnQuit);

        seasonsBox = new SeasonsBox(15, 490);
        seasonsBox.addActionListener(this);
        contentPane.add(seasonsBox);

        settingsLabel = new JLabel();
        settingsLabel.setIcon(settingsBlack);
        settingsLabel.setBounds(580, 560, 32, 32);
        settingsLabel.setBackground(BACKGROUND);
        settingsLabel.addMouseListener(this);
        contentPane.add(settingsLabel);

        JLabel lblPoweredByEnrico = new JLabel("Developed by Enrico Zelioli");
        lblPoweredByEnrico.setBounds(20, 570, 160, 14);
        lblPoweredByEnrico.setForeground(new Color(174, 176, 179));
        contentPane.add(lblPoweredByEnrico);
    }

    private void initFrame(){
        setResizable(false);
        setTitle("VolleyScore");
        setIconImage(new ImageIcon("data/images/volleyball.png").getImage());
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(635, 640);
        Dimension windowSize = getSize();
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        Point centerPoint = ge.getCenterPoint();
        int dx = centerPoint.x - windowSize.width / 2;
        int dy = centerPoint.y - windowSize.height / 2;
        setLocation(dx, dy);
    }

    public void updateSeasonsBox(){
        seasonsBox.loadSeasons();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btnQuit) {
            this.dispose();
        }
        else if(e.getSource() == btnNewGame) {
            System.out.println("Start new game");
            // TODO: implement new game functionality
        }
        else if(e.getSource() == btnManage) {
            System.out.println("Manage teams dialog");
            // TODO: implement management functionality
        }
        else if(e.getSource() == btnStats) {
            System.out.println("View stats");
            // TODO: implement scores visualization functionality
        }else if(e.getSource() == seasonsBox){
            if(SeasonsBox.MANAGE_SEASON_LABEL.equals(seasonsBox.getSelectedItem())){
                seasonsBox.transferFocusUpCycle();
                SeasonsDialog seasonsDialog = new SeasonsDialog(this);
                seasonsDialog.setVisible(true);
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
        if(e.getSource() == settingsLabel){
            JDialog settingsDialog = new Settings(this);
            settingsDialog.setVisible(true);
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if(e.getSource() == settingsLabel){
            settingsLabel.setIcon(settingsWhite);
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if(e.getSource() == settingsLabel){
            settingsLabel.setIcon(settingsBlack);
        }
    }
}
