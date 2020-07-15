package gui.menu;

import javax.swing.*;
import java.awt.*;

public class MenuListCellRenderer extends DefaultListCellRenderer {

    private Color BACKGROUND_SELECTED = new Color(107, 132, 189);
    private static final Color FOREGROUND = new Color(174, 176, 179);
    private static final Color BACKGROUND = new Color(74, 109, 175);

    public MenuListCellRenderer(){
        super();
        setHorizontalAlignment(CENTER);
        setRequestFocusEnabled(false);
        setOpaque(true);
    }

    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus){
        Component component = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
        component.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        if(isSelected) {
            component.setBackground(BACKGROUND_SELECTED);
            component.setForeground(FOREGROUND);
        }else{
            component.setBackground(BACKGROUND);
            component.setForeground(FOREGROUND);
        }
        return component;
    }

}
