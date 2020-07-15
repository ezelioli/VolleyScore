package gui.menu.manageseason;

import db.DBAccessManager;
import domain.Championship;
import exceptions.DatabaseException;

import javax.swing.*;
import javax.swing.border.MatteBorder;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class SeasonsTable extends JTable {

    private static final String[] columnNames = new String[] {"Season"};

    private static final Color BACKGROUND = new Color(60, 63, 65);
    private static final Color FOREGROUND = new Color(174, 176, 179);
    private static final Font FONT = new Font("Times New Roman", Font.PLAIN, 18);
    private static final Color SELECTION_BACKGROUND = new Color(173, 175, 179);
    private static final Color SELECTION_FOREGROUND = new Color(43, 43, 45);
    private static final Color BORDER_COLOR = new Color(43, 43, 45);

    private ArrayList<String> seasons;

    public SeasonsTable(Object[][] data){
        super(new DefaultTableModel(data, columnNames));
        setBackground(BACKGROUND);
        setForeground(FOREGROUND);
        setFont(FONT);
        setSelectionBackground(SELECTION_BACKGROUND);
        setSelectionForeground(SELECTION_FOREGROUND);
        setRowHeight(40);
        MatteBorder border = new MatteBorder(1, 1, 1, 1, BORDER_COLOR);
        setBorder(border);

        DefaultTableCellRenderer tableRenderer = new DefaultTableCellRenderer();
        tableRenderer.setHorizontalAlignment(JLabel.CENTER);
        tableRenderer.setBackground(BACKGROUND);
        tableRenderer.setForeground(FOREGROUND);
        getColumn("Season").setCellRenderer(tableRenderer);

        seasons = new ArrayList<String>();
        for(int i = 0; i < data.length; ++i){
            seasons.add((String)data[i][0]);
        }

        getModel().addTableModelListener(new TableModelListener() {
            @Override
            public void tableChanged(TableModelEvent e) {
                if(e.getType() == TableModelEvent.UPDATE) {
                    try {
                        DBAccessManager db = DBAccessManager.getInstance();
                        String previous = seasons.get(e.getFirstRow());
                        String next = (String) getValueAt(e.getFirstRow(), e.getColumn());
                        db.updateChampionship(previous, next);
                        seasons.set(seasons.indexOf(previous), next);
                    } catch (DatabaseException exception) {
                        System.out.println(exception.getMessage());
                    }
                }else if(e.getType() == TableModelEvent.INSERT){
                    try {
                        DBAccessManager db = DBAccessManager.getInstance();
                        Championship championship = new Championship((String)getValueAt(e.getFirstRow(), 0));
                        db.saveChampionship(championship);
                        seasons.add(championship.getName());
                    } catch (DatabaseException exception) {
                        System.out.println(exception.getMessage());
                    }
                }
            }
        });
    }

    public void addRow(String text){
        DefaultTableModel model = (DefaultTableModel) getModel();
        model.addRow(new String[]{text});
        int rows = getRowCount();
        setRowSelectionInterval(rows, rows);
    }

    public void removeSelectedRow(){
        seasons.remove(getValueAt(getSelectedRow(), getSelectedColumn()));
        DefaultTableModel model = (DefaultTableModel) getModel();
        model.removeRow(getSelectedRow());
    }
}
