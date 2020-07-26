package gui.management.players;

import domain.PlayerInfo;

import javax.swing.*;
import java.awt.*;

public class PlayerInfoLabel extends JLabel {

    private final Font FONT = new Font("Times New Roman", Font.PLAIN, 22);
    private final Color FOREGROUND = new Color(174, 176, 179);
    private final Dimension dimension = new Dimension(130, 30);

    public PlayerInfoLabel(String text){
        super(text);
        setFont(FONT);
        setForeground(FOREGROUND);
        setPreferredSize(dimension);
    }
}
