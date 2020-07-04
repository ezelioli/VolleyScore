package gui.menu;

import javax.swing.*;
import java.awt.*;

public class MenuListCellRenderer extends DefaultListCellRenderer {

    private Color BACKGROUND_SELECTED = new Color(146, 147, 149);

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
            setBackground(BACKGROUND_SELECTED);
        }
        return component;
    }
}
