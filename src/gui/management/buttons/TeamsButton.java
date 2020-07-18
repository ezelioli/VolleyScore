package gui.management.buttons;

import javax.swing.*;
import java.awt.*;

public abstract class TeamsButton extends JButton {
    public TeamsButton(){
        setFocusPainted(false);
        setPreferredSize(new Dimension(100, 26));
    }
}
