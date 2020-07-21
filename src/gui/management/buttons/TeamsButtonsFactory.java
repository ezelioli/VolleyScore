package gui.management.buttons;

import javax.swing.*;

public class TeamsButtonsFactory {

    public static final int NEW_GAME_BUTTON = 0;
    public static final int CLOSE_BUTTON = 1;
    public static final int ADD_PLAYER_BUTTON = 2;

    public static JButton getButton(int type){
        switch(type){
            case NEW_GAME_BUTTON:
                return new NewTeamButton();
            case CLOSE_BUTTON:
                return new CloseButton();
            case ADD_PLAYER_BUTTON:
                return new AddPlayerButton();
            default:
                return null;
        }
    }
}
