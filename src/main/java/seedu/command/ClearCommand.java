package seedu.command;

import seedu.exception.WhereGotTimeException;
import seedu.task.Event;
import seedu.ui.Ui;
import seedu.user.User;
import seedu.user.UserList;

import java.util.ArrayList;

/**
 * Clear timetable of user on a particular day.
 */
public class ClearCommand extends Command {

    public ClearCommand(String information) {
        super(information);
    }

    @Override
    public void execute(UserList users, Ui ui, User nowUser) throws WhereGotTimeException {
        if (nowUser == null) {
            throw new WhereGotTimeException("Sorry! You are not logged in to any account :-(");
        }

        int userIndex = -1;
        for (int i = 0; i < users.getTotalUserCount(); i++) {
            if ((users.getUser(i + 1).getName().equals(nowUser.getName()))) {
                userIndex = i + 1;
                break;
            }
        }

        String[] parsedInputs = input.split("/", 2);
        String day = parsedInputs[1].toLowerCase();
        int counter[] = {0};
        if (day.equals("all")) {
            deleteTimetable(users, ui, userIndex, counter, day,"mon");
            deleteTimetable(users, ui, userIndex, counter, day,"tue");
            deleteTimetable(users, ui, userIndex, counter, day,"wed");
            deleteTimetable(users, ui, userIndex, counter, day,"thu");
            deleteTimetable(users, ui, userIndex, counter, day,"fri");
            deleteTimetable(users, ui, userIndex, counter, day,"sat");
            deleteTimetable(users, ui, userIndex, counter, day,"sun");
        } else {
            deleteTimetable(users, ui, userIndex, counter, day, day);
        }
    }

    public void deleteTimetable(UserList users, Ui ui, int userIndex, int counter[], String input, String day)
            throws WhereGotTimeException {
        ArrayList<Event> timetable = (users.getUser(userIndex).getTimetable()).getTimetable(day);
        ArrayList<Object> deletedTimetable = new ArrayList<>(timetable);
        if (!timetable.isEmpty()) {
            timetable.clear();
        } else if (input.equals(day)) {
            throw new WhereGotTimeException("There is no class in your timetable for " + day + "!");
        } else {
            counter[0]++;
        }
        ui.printClear(deletedTimetable, counter[0], input, day);
    }
}
