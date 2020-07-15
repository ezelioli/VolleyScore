package gui.menu.manageseason;

import gui.templates.OkCancelDialog;

public class SeasonsOkCancelDialog extends OkCancelDialog {

    private SeasonsDialog parent;

    public SeasonsOkCancelDialog(SeasonsDialog owner, String message) {
        super(owner, message);
        parent = owner;
    }

    @Override
    public void doOk() {
        parent.removeSelectedSeason();
        dispose();
    }
}
