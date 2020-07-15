package gui;

import gui.ConfirmDialog;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConfirmPanel extends JPanel implements ActionListener {

    private static final Color BACKGROUND = new Color(60, 63, 65);
    private static final Color BUTTON_BACKGROUND = new Color(174, 176, 179);
    private ImageIcon warningIcon = new ImageIcon("data/images/warning.png");
    private static int labelsY = 30;
    private static int labelsX = 20;
    private static int labelsWidth = 170;
    private static int labelsHeight = 32;
    private static int buttonsY = 80;
    private static int buttonsX = 20;
    private static int buttonsWidth = 80;
    private static int buttonsHeight = 20;

    private ConfirmDialog owner;
    private JButton okBtn;
    private JButton cancelBtn;

    public ConfirmPanel(ConfirmDialog owner, String message){

        super(null);

        setBackground(BACKGROUND);

        JLabel warningLabel = new JLabel();
        warningLabel.setIcon(warningIcon);
        warningLabel.setBounds(labelsX, labelsY, 32, 32);
        warningLabel.setBackground(BACKGROUND);
        add(warningLabel);

        JLabel textLabel = new JLabel(message);
        int textLabelX = labelsX + warningLabel.getX() + 20;
        textLabel.setBounds(textLabelX, labelsY, labelsWidth, labelsHeight);
        textLabel.setForeground(BUTTON_BACKGROUND);
        add(textLabel);

        cancelBtn = new JButton("Cancel");
        cancelBtn.setBounds(buttonsX, buttonsY, buttonsWidth, buttonsHeight);
        cancelBtn.setBackground(BUTTON_BACKGROUND);
        cancelBtn.setForeground(BACKGROUND);
        cancelBtn.addActionListener(this);
        add(cancelBtn);

        okBtn = new JButton("Ok");
        int okButtonX = buttonsX + buttonsWidth + 20;
        okBtn.setBounds(okButtonX, buttonsY, buttonsWidth, buttonsHeight);
        okBtn.setBackground(BUTTON_BACKGROUND);
        okBtn.setForeground(BACKGROUND);
        okBtn.addActionListener(this);
        add(okBtn);

        this.owner = owner;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == cancelBtn){
            owner.doCancel();
        }else if(e.getSource() == okBtn){
            owner.doOk();
        }
    }
}
