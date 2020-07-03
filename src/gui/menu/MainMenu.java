package gui.menu;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu extends JFrame implements ActionListener {
    private JPanel contentPane;
    private JButton btnQuit;
    private JButton btnNewGame;
    private JButton btnManage;
    private JButton btnWiewStats;

    public MainMenu() {
        initFrame();

        contentPane = new JPanel();
        contentPane.setBackground(new Color(112, 128, 144));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JSeparator separator = new JSeparator();
        separator.setForeground(new Color(192, 192, 192));
        separator.setBounds(48, 78, 515, 5);
        contentPane.add(separator);

        JLabel lblVolleyballScoreManager = new JLabel("VolleyBall Score Manager");
        lblVolleyballScoreManager.setForeground(new Color(205, 133, 63));
        lblVolleyballScoreManager.setFont(new Font("Tw Cen MT", Font.BOLD, 27));
        lblVolleyballScoreManager.setHorizontalAlignment(SwingConstants.CENTER);
        lblVolleyballScoreManager.setBounds(133, 25, 368, 31);
        contentPane.add(lblVolleyballScoreManager);

        Font font = new Font("Times New Roman", Font.PLAIN, 18);
        Color foregroundColor = UIManager.getColor("Button.darkShadow");

        btnNewGame = makeButton("New Game", 246, 149, 121, 31,
                foregroundColor, new Color(192, 192, 192), font);
        contentPane.add(btnNewGame);

        btnManage = makeButton("Manage", 246, 229, 121, 31,
                foregroundColor, Color.LIGHT_GRAY, font);
        contentPane.add(btnManage);

        btnWiewStats = makeButton("Wiew Stats", 246, 318, 121, 31,
                foregroundColor, Color.LIGHT_GRAY, font);
        contentPane.add(btnWiewStats);

        btnQuit = makeButton("Quit", 246, 470, 121, 31,
                foregroundColor, Color.LIGHT_GRAY, font);
        contentPane.add(btnQuit);

        JLabel settingsLabel = new JLabel();
        settingsLabel.setIcon(new ImageIcon("data/images/settings.png"));
        settingsLabel.setBounds(600, 542, 32, 32);
        contentPane.add(settingsLabel);

        JLabel lblPoweredByEnrico = new JLabel("Powered by Enrico Zelioli");
        lblPoweredByEnrico.setBounds(20, 542, 142, 14);
        contentPane.add(lblPoweredByEnrico);
    }

    private void initFrame(){
        setResizable(false);
        setTitle("VolleyBall Score Manager");
        //setIconImage(Toolkit.getDefaultToolkit().getImage(MainMenu.class.getResource("../../data/images/volleyball.png")));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 635, 610);
        setSize(635, 610);
        Dimension windowSize = getSize();
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        Point centerPoint = ge.getCenterPoint();
        int dx = centerPoint.x - windowSize.width / 2;
        int dy = centerPoint.y - windowSize.height / 2;
        setLocation(dx, dy);
    }

    private JButton makeButton(String text, int x, int y, int width, int heigth, Color foreground, Color background, Font font){
        JButton button = new JButton(text);
        button.setForeground(foreground);
        button.setFont(font);
        button.setBackground(background);
        button.setBounds(x, y, width, heigth);
        button.addActionListener(this);
        return button;
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
        else if(e.getSource() == btnWiewStats) {
            System.out.println("View stats");
            // TODO: implement scores visualization functionality
        }
    }
}
