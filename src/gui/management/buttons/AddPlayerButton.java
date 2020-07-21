package gui.management.buttons;

import javax.swing.*;
import java.awt.*;

public class AddPlayerButton extends JButton {
    private static final Color BACKGROUND = new Color(72, 155, 84);
    private static final Color FOREGROUND = new Color(255, 255, 255);

    public AddPlayerButton(){
        super();
        setText("Add Player");
        setBackground(BACKGROUND);
        setForeground(FOREGROUND);
    }
}
