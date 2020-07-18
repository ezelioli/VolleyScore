package gui.management;

import gui.templates.OkCancelDialog;

import javax.swing.*;

public class TeamManagementOkCancelDialog extends OkCancelDialog {

    public TeamManagementOkCancelDialog(JDialog owner, String message) {
        super(owner, message);
    }

    @Override
    public void doOk() {
        dispose();
        owner.dispose();
    }
}
