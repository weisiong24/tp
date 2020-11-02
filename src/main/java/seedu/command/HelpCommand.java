package seedu.command;

import seedu.exception.WhereGotTimeException;
import seedu.ui.Ui;
import seedu.user.User;
import seedu.user.UserList;


public class HelpCommand extends Command {
    public HelpCommand() {
        super(null);
    }

    @Override
    public void execute(UserList users, Ui ui, User nowUser) {
        
        boolean isLoggedIn = true;

        if (nowUser == null) {
            isLoggedIn = false;
        }
        ui.printHelp(isLoggedIn, nowUser);
    }
}