package gui.menu;

import db.DBAccessManager;
import domain.Championship;
import exceptions.DatabaseException;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class SeasonsBox extends JComboBox<String> {

    private static final Font FONT = new Font(Font.SANS_SERIF, Font.PLAIN, 18);
    private static final int WIDTH = 170;
    private static final int HEIGHT = 50;
    private static final Color FOREGROUND = new Color(60, 63, 65);
    private static final Color BACKGROUND = new Color(174, 176, 179);

    public static final String MANAGE_SEASON_LABEL = "--Manage Seasons--";

    public SeasonsBox(int x, int y){
        super();
        setFont(FONT);
        setBounds(x, y, WIDTH, HEIGHT);
        setBackground(BACKGROUND);
        setForeground(FOREGROUND);
        setRenderer(new MenuListCellRenderer());
        loadSeasons();
    }

    public void loadSeasons(){
        ArrayList<Championship> championships = new ArrayList<Championship>();
        removeAllItems();
        try {
            DBAccessManager db = DBAccessManager.getInstance();
            championships = db.loadChampionships();
        }catch(DatabaseException exception){
            System.out.println(exception.getMessage());
        }
        for(Championship championship : championships){
            addItem(championship.getName());
        }
        addItem(MANAGE_SEASON_LABEL);
    }
}
