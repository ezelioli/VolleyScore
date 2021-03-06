package gui.menu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MenuButton extends JButton implements MouseListener {

    private final Color FOREGROUND = new Color(60, 63, 65);
    private final Color BACKGROUND = new Color(197, 83, 80);
    private final Color SELECTED_BACKGROUND = new Color(215, 111, 120);
    private final Font FONT = new Font("Comic Sans MS", Font.PLAIN, 20);
    private final int WIDTH = 140;
    private final int HEIGHT = 35;

    private final Color BLUE = new Color(74, 109, 175);
    private final Color LIGTH_BLUE = new Color(107, 132, 189);

    public MenuButton(String title, int x, int y){
        super(title);
        setForeground(FOREGROUND);
        setFont(FONT);
        setBackground(BACKGROUND);
        setBounds(x, y, WIDTH, HEIGHT);
        setBorderPainted(false);
        addMouseListener(this);
        setFocusPainted(false);
        setUI(new MenuButtonUI());
    }


    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        setBackground(SELECTED_BACKGROUND);
        setForeground(FOREGROUND);
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        setBackground(SELECTED_BACKGROUND);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        setBackground(BACKGROUND);
    }
}
