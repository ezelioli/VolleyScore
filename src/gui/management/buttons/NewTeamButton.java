package gui.management;

import javax.swing.*;
import java.awt.*;

public class TeamsButton extends JButton {
    private static final Color BACKGROUND = new Color(72, 155, 84);
    private static final Color FOREGROUND = new Color(255, 255, 255);

    public TeamsButton(String text){
        super(text);
        setBackground(BACKGROUND);
        setForeground(FOREGROUND);
        setFocusPainted(false);
    }
}
