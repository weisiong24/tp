package seedu.command;

import seedu.exception.DukeException;
import seedu.ui.Ui;
import seedu.user.User;
import seedu.user.UserList;


/**
 * Prints a list of all tasks to the user.
 */
public class ListCommand extends Command {

    public ListCommand(String input) {
        super(input);
    }

    @Override
    public void execute(UserList users, Ui ui, User nowUser) throws DukeException {
        int userIndex = -1;

        if (nowUser == null) {
            throw new DukeException("Sorry! You are not logged in to any account :-(");
        }

        for (int i = 0; i < users.getTotalUserCount(); i++) {
            if ((users.getUser(i + 1).getName() == nowUser.getName())) {
                userIndex = i + 1;
            }
        }

        String day = input.substring(1);
        if (day.equals("all")) {
            ui.printList(users, userIndex, "mon");
            System.out.println();
            ui.printList(users, userIndex, "tue");
            System.out.println();
            ui.printList(users, userIndex, "wed");
            System.out.println();
            ui.printList(users, userIndex, "thu");
            System.out.println();
            ui.printList(users, userIndex, "fri");
            System.out.println();
            ui.printList(users, userIndex, "sat");
            System.out.println();
            ui.printList(users, userIndex, "sun");
        } else {
            ui.printList(users, userIndex, day);
        }
    }
}
