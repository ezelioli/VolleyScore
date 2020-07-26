package gui.management.players;

import gui.templates.OkCancelDialog;

import javax.swing.*;

public class EditPlayerOkCancelDialog extends OkCancelDialog {

    public EditPlayerOkCancelDialog(JDialog owner, String message) {
        super(owner, message);
    }

    @Override
    public void doOk() {
        dispose();
        owner.dispose();
    }
}
