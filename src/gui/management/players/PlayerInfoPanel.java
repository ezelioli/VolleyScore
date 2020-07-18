package gui.management.players;

import domain.PlayerInfo;

import javax.swing.*;
import java.awt.*;

public class PlayerInfoPanel extends JPanel {

    private JDialog owner;

    private final Color BACKGROUND = new Color(60, 63, 65);

    public PlayerInfoPanel(JDialog owner){

        super(new BorderLayout());

        this.owner = owner;

        setBackground(BACKGROUND);
    }
}
