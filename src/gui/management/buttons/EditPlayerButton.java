package gui.management.buttons;

import javax.swing.*;
import java.awt.*;

public class EditPlayerButton extends JButton {
    private static final Color BACKGROUND = new Color(43, 43, 44);
    private static final Color FOREGROUND = new Color(255, 255, 255);

    public EditPlayerButton(){
        super();
        setText("Edit");
        setBackground(BACKGROUND);
        setForeground(FOREGROUND);
    }
}
