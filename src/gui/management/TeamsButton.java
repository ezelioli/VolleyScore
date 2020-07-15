package gui.management;

import javax.swing.*;
import java.awt.*;

public class TeamsButton extends JButton {
    private static final Color BACKGROUND = new Color(174, 176, 179);
    private static final Color FOREGROUND = new Color(60, 63, 65);

    public TeamsButton(String text){
        super(text);
        setBackground(BACKGROUND);
        setForeground(FOREGROUND);
    }
}
