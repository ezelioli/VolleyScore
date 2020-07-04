package gui.menu;

import javax.swing.*;
import java.awt.*;

public class MenuButton extends JButton {

    private static final Color FOREGROUND = new Color(60, 63, 65);
    private static final Color BACKGROUND = new Color(174, 176, 179);
    private static final Font FONT = new Font("Times New Roman", Font.PLAIN, 18);
    private static final int WIDTH = 121;
    private static final int HEIGHT = 31;

    public MenuButton(String title, int x, int y){
        super(title);
        setForeground(FOREGROUND);
        setFont(FONT);
        setBackground(BACKGROUND);
        setBounds(x, y, WIDTH, HEIGHT);
    }
}
