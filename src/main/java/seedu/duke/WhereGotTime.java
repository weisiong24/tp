package seedu.duke;

import seedu.duke.command.Command;
import seedu.duke.exception.DukeException;
import seedu.duke.parser.Parser;
import seedu.duke.ui.Ui;
import seedu.duke.user.User;
import seedu.duke.user.UserList;

import seedu.duke.storage.Storage;

public class WhereGotTime {

    private Storage storage;
    private UserList users;
    private final Ui ui;

    public WhereGotTime() {
        ui = new Ui();
        try {
            users = new UserList();
            storage = new Storage();
            storage.load(users);
        } catch (DukeException e) {
            users = new UserList();
            ui.showError(e.getMessage());
        }
    }

    public void run() {
        ui.showWelcome();
        boolean isExit = false;
        User nowUser = null;
        while (!isExit) {
            try {
                String fullCommand = ui.readCommand();
                ui.showLine(); // show the divider line ("_______")
                Command c = Parser.parse(fullCommand);
                c.execute(users, ui, nowUser/*, storage*/);
                storage.write(users);

                if (c.isLogIn()) {
                    nowUser = c.getCurrentUser();
                    //System.out.println(nowUser.getName() + users.getTotalUserCount());
                }
                //System.out.println(nowUser.getName());
                isExit = c.isExit();
            } catch (DukeException e) {
                ui.showError(e.getMessage());
            } finally {
                ui.showLine();
            }
        }
    }

    public static void main(String[] args) {
        new WhereGotTime().run();
    }
}
