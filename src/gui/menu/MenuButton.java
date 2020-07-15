package gui.menu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MenuButton extends JButton implements MouseListener {

    private static final Color FOREGROUND = new Color(174, 176, 179);
    private static final Color BACKGROUND = new Color(74, 109, 175);
    private static final Color SELECTED_BACKGROUND = new Color(107, 132, 189);
    private static final Font FONT = new Font("Times New Roman", Font.PLAIN, 20);
    private static final int WIDTH = 140;
    private static final int HEIGHT = 35;

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
