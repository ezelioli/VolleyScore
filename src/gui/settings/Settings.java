package gui.settings;

import exceptions.PropertiesFileNotFoundException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Settings extends JDialog implements ActionListener {

    private static final String title = "Settings";
    private static final Color BACKGROUND = new Color(60, 63, 65);
    private static final Color FOREGROUND = new Color(174, 176, 179);

    private AppProperties properties;
    private JCheckBox darkThemeCheckBox;
    private JCheckBox liberoAllowedCheckBox;

    private JPanel mainPanel;
    private JButton cancelBtn;
    private JButton saveBtn;

    private boolean darkThemeSelected;
    private boolean liberoSelected;

    public Settings(JFrame frame){
        super(frame, title);
        initDialog();
        loadProperties();

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

        darkThemeCheckBox = new JCheckBox("dark theme");
        if(darkThemeSelected)
            darkThemeCheckBox.setSelected(true);
        darkThemeCheckBox.setBackground(BACKGROUND);
        darkThemeCheckBox.setForeground(FOREGROUND);
        centerPanel.add(darkThemeCheckBox, 0);

        liberoAllowedCheckBox = new JCheckBox("use libero");
        if(liberoSelected)
            liberoAllowedCheckBox.setSelected(true);
        liberoAllowedCheckBox.setBackground(BACKGROUND);
        liberoAllowedCheckBox.setForeground(FOREGROUND);
        centerPanel.add(liberoAllowedCheckBox, 1);

        cancelBtn = new SettingsButton("Cancel");
        cancelBtn.addActionListener(this);
        saveBtn = new SettingsButton("Save");
        saveBtn.addActionListener(this);
        southPanel.add(cancelBtn);
        southPanel.add(saveBtn);
    }

    private void initDialog(){
        setResizable(false);
        setModal(true);
        setIconImage(new ImageIcon("data/images/settings_black.png").getImage());
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setBounds(100, 100, 800, 400);
        setSize(800, 400);
        Dimension windowSize = getSize();
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        Point centerPoint = ge.getCenterPoint();
        int dx = centerPoint.x - windowSize.width / 2;
        int dy = centerPoint.y - windowSize.height / 2;
        setLocation(dx, dy);
    }

    private void loadProperties(){
        try {
            properties = AppProperties.getInstance();
            darkThemeSelected = "dark".equals(properties.getProperty("theme"));
            liberoSelected = "true".equals(properties.getProperty("libero"));
        }catch(Exception exception){
            System.out.println(exception.getMessage());
            darkThemeSelected = false;
            liberoSelected = false;
        }
    }

    private void saveProperties(){
        if(properties == null){
            return;
        }

        if(darkThemeCheckBox.isSelected()){
            properties.setProperty("theme", "dark");
        }else{
            properties.setProperty("theme", "ligth");
        }
        if(liberoAllowedCheckBox.isSelected()){
            properties.setProperty("libero", "true");
        }else{
            properties.setProperty("libero", "false");
        }

        try {
            properties.store();
        }catch(PropertiesFileNotFoundException exception){
            exception.getMessage();
            //TODO: notify exception
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == cancelBtn){
            ConfirmDialog confirmDialog = new ConfirmDialog(this);
            confirmDialog.setVisible(true);
        }else if(e.getSource() == saveBtn){
            saveProperties();
            dispose();
        }
    }
}
