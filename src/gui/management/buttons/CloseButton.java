package gui.management.buttons;

import javax.swing.*;
import java.awt.*;

public class CloseButton extends TeamsButton {

    private static final Color BACKGROUND = new Color(174, 176, 179);
    private static final Color FOREGROUND = new Color(60, 63, 65);

    public CloseButton(){
        super();
        setText("Close");
        setBackground(BACKGROUND);
        setForeground(FOREGROUND);
    }
}
