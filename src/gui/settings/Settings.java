package gui.settings;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Settings extends JDialog implements ActionListener {

    private static final String title = "Settings";
    private static final Color BACKGROUND = new Color(60, 63, 65);
    private static final Color FOREGROUND = new Color(174, 176, 179);

    private JPanel mainPanel;
    private JButton cancelBtn;
    private JButton saveBtn;

    public Settings(JFrame frame){
        super(frame, title);
        initFrame();

        mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(BACKGROUND);
        setContentPane(mainPanel);

        JPanel southPanel = new JPanel(new FlowLayout());
        southPanel.setAlignmentX(RIGHT_ALIGNMENT);
        southPanel.setBackground(BACKGROUND);
        mainPanel.add(southPanel, BorderLayout.SOUTH);

        JPanel centerPanel = new JPanel(new GridLayout(8,8));
        centerPanel.setBackground(BACKGROUND);
        mainPanel.add(centerPanel, BorderLayout.CENTER);

        JCheckBox darkThemeCheckBox = new JCheckBox("dark theme");
        darkThemeCheckBox.setSelected(true);
        darkThemeCheckBox.setBackground(BACKGROUND);
        darkThemeCheckBox.setForeground(FOREGROUND);
        centerPanel.add(darkThemeCheckBox, 0);

        JCheckBox liberoAllowedCheckBox = new JCheckBox("use libero");
        liberoAllowedCheckBox.setSelected(true);
        liberoAllowedCheckBox.setBackground(BACKGROUND);
        liberoAllowedCheckBox.setForeground(FOREGROUND);
        centerPanel.add(liberoAllowedCheckBox, 1);

        cancelBtn = new SettingsButton("Cancel");
        saveBtn = new SettingsButton("Save");
        southPanel.add(cancelBtn);
        southPanel.add(saveBtn);
    }

    private void initFrame(){
        setResizable(false);
        setIconImage(new ImageIcon("data/images/settings_black.png").getImage());
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 800, 400);
        setSize(800, 400);
        Dimension windowSize = getSize();
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        Point centerPoint = ge.getCenterPoint();
        int dx = centerPoint.x - windowSize.width / 2;
        int dy = centerPoint.y - windowSize.height / 2;
        setLocation(dx, dy);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == cancelBtn){
            this.dispose();
        }else if(e.getSource() == saveBtn){
            //TODO: implement saving settings
            this.dispose();
        }
    }
}
