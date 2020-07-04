package gui.menu;

import db.DBAccessManager;
import domain.Championship;
import exceptions.DatabaseException;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class SeasonsBox extends JComboBox<String> {

    private static final Color FOREGROUND = new Color(43, 43, 44);
    private static final Color BACKGROUND = new Color(174, 176, 179, 255);
    private static final Font FONT = new Font(Font.SANS_SERIF, Font.PLAIN, 18);
    private static final int WIDTH = 150;
    private static final int HEIGHT = 50;

    public static final String NEW_SEASON_LABEL = "--New Season--";

    public SeasonsBox(int x, int y){
        super();
        setForeground(FOREGROUND);
        setFont(FONT);
        setBackground(BACKGROUND);
        setBounds(x, y, WIDTH, HEIGHT);
        setRenderer(new MenuListCellRenderer());
        loadSeasons();
        addItem(NEW_SEASON_LABEL);
    }

    private void loadSeasons(){
        ArrayList<Championship> championships = new ArrayList<Championship>();
        try {
            DBAccessManager db = DBAccessManager.getInstance();
            championships = db.loadChampionships();
        }catch(DatabaseException exception){
            System.out.println(exception.getMessage());
        }
        for(Championship championship : championships){
            this.addItem(championship.getName());
        }
    }
}
