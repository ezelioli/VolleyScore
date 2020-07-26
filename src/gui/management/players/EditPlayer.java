package gui.management.players;

import domain.PlayerInfo;
import gui.templates.ErrorDialog;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.time.LocalDate;

public class EditPlayer extends AddPlayer{

    private PlayerInfo player;
    private PlayersListPanel playersListPanel;

    public EditPlayer(JDialog owner, PlayerInfo player, PlayersListPanel playersListPanel){
        super(owner);
        this.player = player;
        this.playersListPanel = playersListPanel;
        nameTxt.setText(player.getName());
        surnameTxt.setText(player.getSurname());
        numberTxt.setText(Integer.toString(player.getNumber()));
        nationalityTxt.setText(player.getNationality());
        birthdayTxt.setText(player.getBirthday().toString());
        rolesBox.setSelectedItem(player.getRole());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == saveButton){
            String name = nameTxt.getText();
            String surname = surnameTxt.getText();
            String nationality = nationalityTxt.getText();
            String role = (String) rolesBox.getSelectedItem();
            LocalDate birthday = null;
            int number = 0;
            if("".equals(name)){
                ErrorDialog errorDialog = new ErrorDialog(this, "Player's name can't be void!");
                errorDialog.setVisible(true);
                return;
            }else if("".equals(surname)){
                ErrorDialog errorDialog = new ErrorDialog(this, "Player's surname can't be void!");
                errorDialog.setVisible(true);
                return;
            }else if("".equals(nationality)){
                ErrorDialog errorDialog = new ErrorDialog(this, "Player's nationality can't be void!");
                errorDialog.setVisible(true);
                return;
            }
            try{
                birthday = LocalDate.parse(birthdayTxt.getText());
            }catch (Exception exception){
                ErrorDialog errorDialog = new ErrorDialog(this, "Player's birthday not valid!");
                errorDialog.setVisible(true);
                return;
            }
            try{
                number = Integer.parseInt(numberTxt.getText());
            }catch (Exception exception){
                ErrorDialog errorDialog = new ErrorDialog(this, "Player's number not valid!");
                errorDialog.setVisible(true);
                return;
            }
            player.setName(name);
            player.setSurname(surname);
            player.setBirthday(birthday);
            player.setNationality(nationality);
            player.setRole(role);
            player.setNumber(number);
            playersListPanel.updatePanel();
            dispose();
        }else if(e.getSource() == cancelButton){
            String message = "Exit without saving?";
            EditPlayerOkCancelDialog confirmDialog = new EditPlayerOkCancelDialog(this, message);
            confirmDialog.setVisible(true);
        }
    }
}
