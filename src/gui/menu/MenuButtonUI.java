package gui.menu;

import javax.swing.*;
import javax.swing.plaf.basic.BasicButtonUI;
import java.awt.*;

public class MenuButtonUI extends BasicButtonUI {

    private static final Color PRESSED_BACKGROUND = new Color(174, 176, 179);
    private static final Color PRESSED_FOREGROUND = new Color(60, 63, 65);

    public void paintButtonPressed(Graphics g, AbstractButton b){
        b.setBackground(PRESSED_BACKGROUND);
        b.setForeground(PRESSED_FOREGROUND);
        super.paintButtonPressed(g, b);
    }
}
