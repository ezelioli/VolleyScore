package gui.settings;

import javax.swing.*;
import java.awt.Color;

public class SettingsButton extends JButton {

    private static final Color BACKGROUND = new Color(174, 176, 179);
    private static final Color FOREGROUND = new Color(60, 63, 65);

    public SettingsButton(String text){
        super(text);
        setBackground(BACKGROUND);
        setForeground(FOREGROUND);
    }
}
