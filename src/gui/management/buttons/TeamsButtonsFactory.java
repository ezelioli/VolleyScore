package gui.management.buttons;

import javax.swing.*;

public class TeamsButtonsFactory {

    public static final int NEW_GAME_BUTTON = 0;
    public static final int CLOSE_BUTTON = 1;

    public static JButton getButton(int type){
        switch(type){
            case NEW_GAME_BUTTON:
                return new NewTeamButton();
            case CLOSE_BUTTON:
                return new CloseButton();
            default:
                return null;
        }
    }
}
