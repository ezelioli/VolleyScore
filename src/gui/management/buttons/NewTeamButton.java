package gui.management.buttons;

import javax.swing.*;
import java.awt.*;

public class NewTeamButton extends TeamsButton {
    private static final Color BACKGROUND = new Color(72, 155, 84);
    private static final Color FOREGROUND = new Color(255, 255, 255);

    public NewTeamButton(){
        super();
        setText("Add Team");
        setBackground(BACKGROUND);
        setForeground(FOREGROUND);
    }
}
