package gui.menu.manageseason;

import db.DBAccessManager;
import domain.Championship;
import exceptions.DatabaseException;
import gui.menu.MainMenu;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class SeasonsDialog extends JDialog implements ActionListener {

    private static final String title = "Manage Seasons";
    private static final Color BACKGROUND = new Color(60, 63, 65);
    private static final Color FOREGROUND = new Color(174, 176, 179);
    private static final Font TITLE_FONT = new Font("Times New Roman", Font.BOLD, 30);

    private static final Color ADD_BACKGROUND = new Color(72, 155, 84);
    private static final Color ADD_FOREGROUND = new Color(255, 255, 255);

    private static final Color REMOVE_BACKGROUND = new Color(197, 83, 80);
    private static final Color REMOVE_FOREGROUND = new Color(255, 255, 255);

    private static final Color CLOSE_BACKGROUND = new Color(174, 176, 179);
    private static final Color CLOSE_FOREGROUND = new Color(43, 43, 44);

    private JButton closeButton;
    private JButton removeButton;
    private JButton addButton;

    private String[][] seasons;
    private SeasonsTable seasonsTable;

    private MainMenu menu;

    public SeasonsDialog(MainMenu frame){

        super(frame, title);

        initDialog();

        loadSeasons();

        this.menu = frame;

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(BACKGROUND);
        setContentPane(mainPanel);

        JLabel titleLabel = new JLabel("Manage Seasons");
        titleLabel.setBackground(BACKGROUND);
        titleLabel.setForeground(FOREGROUND);
        titleLabel.setFont(TITLE_FONT);
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titleLabel.setVerticalAlignment(JLabel.CENTER);
        titleLabel.setBorder(new EmptyBorder(20, 0, 20, 0));
        mainPanel.add(titleLabel, BorderLayout.NORTH);

        seasonsTable = new SeasonsTable(seasons);
        mainPanel.add(seasonsTable, BorderLayout.CENTER);

        JPanel buttonsPanel = new JPanel(new GridLayout(1, 3));
        mainPanel.add(buttonsPanel, BorderLayout.SOUTH);

        JPanel[] buttonsPanels = new JPanel[3];
        for(int i = 0; i < 3; ++i){
            buttonsPanels[i] = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
            buttonsPanels[i].setBackground(BACKGROUND);
            buttonsPanel.add(buttonsPanels[i]);
        }

        closeButton = new JButton("Close");
        closeButton.setBackground(CLOSE_BACKGROUND);
        closeButton.setForeground(CLOSE_FOREGROUND);
        closeButton.addActionListener(this);
        buttonsPanels[0].add(closeButton);

        removeButton = new JButton("Remove");
        removeButton.setBackground(REMOVE_BACKGROUND);
        removeButton.setForeground(REMOVE_FOREGROUND);
        removeButton.addActionListener(this);
        buttonsPanels[1].add(removeButton);

        addButton = new JButton("Add");
        addButton.setBackground(ADD_BACKGROUND);
        addButton.setForeground(ADD_FOREGROUND);
        addButton.addActionListener(this);
        buttonsPanels[2].add(addButton);


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

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == addButton){
            seasonsTable.addRow("New Season");
        }else if(e.getSource() == removeButton){
            SeasonsOkCancelDialog confirmDialog = new SeasonsOkCancelDialog(this,
                    "Remove selected season?");
            confirmDialog.setVisible(true);
        }else if(e.getSource() == closeButton){
            menu.updateSeasonsBox();
            menu.validate();
            dispose();
        }
    }

    public void removeSelectedSeason(){
        try {
            DBAccessManager db = DBAccessManager.getInstance();
            String name = (String)seasonsTable.getValueAt(seasonsTable.getSelectedRow(), seasonsTable.getSelectedColumn());
            db.removeChampionship(name);
        } catch (DatabaseException exception) {
            System.out.println(exception.getMessage());
        }
        seasonsTable.removeSelectedRow();
    }

    private void loadSeasons(){
        ArrayList<Championship> championships = new ArrayList<Championship>();
        try {
            DBAccessManager db = DBAccessManager.getInstance();
            championships = db.loadChampionships();
        }catch(DatabaseException exception){
            System.out.println(exception.getMessage());
        }
        seasons = new String[championships.size()][1];
        for(Championship championship : championships){
            int index = championships.indexOf(championship);
            seasons[index][0] = championship.getName();
        }
    }
}
