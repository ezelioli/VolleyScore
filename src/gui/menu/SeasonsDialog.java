package gui.menu;

import javax.swing.*;
import java.awt.*;

public class SeasonsDialog extends JDialog {

    private static final String title = "Manage Seasons";
    private static final Color BACKGROUND = new Color(60, 63, 65);
    private static final Color FOREGROUND = new Color(174, 176, 179);
    private static final Font FONT = new Font("Times New Roman", Font.BOLD, 18);

    public SeasonsDialog(JFrame frame){

        super(frame, title);

        initDialog();

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(BACKGROUND);
        setContentPane(mainPanel);

        JLabel titleLabel = new JLabel("Manage Seasons");
        titleLabel.setBackground(BACKGROUND);
        titleLabel.setForeground(FOREGROUND);
        titleLabel.setFont(FONT);
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titleLabel.setVerticalAlignment(JLabel.CENTER);
        mainPanel.add(titleLabel, BorderLayout.NORTH);

        JPanel centralPanel = new JPanel(null);
        centralPanel.setBackground(BACKGROUND);
        mainPanel.add(centralPanel, BorderLayout.CENTER);

    }

    private void initDialog(){
        setResizable(false);
        setModal(true);
        setIconImage(new ImageIcon("data/images/settings_black.png").getImage());
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 400, 400);
        setSize(400, 400);
        Dimension windowSize = getSize();
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        Point centerPoint = ge.getCenterPoint();
        int dx = centerPoint.x - windowSize.width / 2;
        int dy = centerPoint.y - windowSize.height / 2;
        setLocation(dx, dy);
    }
}
