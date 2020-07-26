package gui.management.players;

import javax.swing.*;
import java.awt.*;

public class PlayerInfoTextField extends JTextField {

    public static final Dimension dimension = new Dimension(130, 30);
    public static final Font FONT = new Font("Times New Roman", Font.PLAIN, 22);

    public PlayerInfoTextField(){
        super("");
        setPreferredSize(dimension);
        setFont(FONT);
        setEditable(false);
    }
}
