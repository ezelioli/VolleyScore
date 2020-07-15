package gui.settings;

import gui.templates.OkCancelDialog;

import javax.swing.*;

public class SettingsOkCancelDialog extends OkCancelDialog {
    public SettingsOkCancelDialog(JDialog owner, String message) {
        super(owner, message);
    }

    @Override
    public void doOk() {
        dispose();
        owner.dispose();
    }
}
