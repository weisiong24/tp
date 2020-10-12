package seedu.duke.command;

import seedu.duke.exception.DukeException;
//import seedu.duke.storage.Storage;
import seedu.duke.ui.Ui;
import seedu.duke.user.User;
import seedu.duke.user.UserList;

import java.util.ArrayList;

/**
 * Deletes a task from the task list.
 */
public class DeleteCommand extends Command {

    public DeleteCommand(String information) {
        super(information);
    }

    @Override
    public void execute(UserList users, Ui ui, User nowUser/*, Storage storage*/) throws DukeException {
        if (nowUser == null) {
            throw new DukeException("Sorry! You are not logged in to any account :-(");
        }

        String[] parsedInputs = input.split("/", 3);
        String day = parsedInputs[1].trim();
        int index;

        try {
            index = Integer.parseInt(parsedInputs[2]);
            for (int i = 0; i < users.getTotalUserCount(); i++) {
                if ((users.getUser(i + 1).getName() == nowUser.getName())) {
                    ArrayList<Object> timetable = null;
                    switch (day) {
                    case "mon":
                        timetable = (users.getUser(i + 1).getTimetable()).getMonTimetable();
                        break;
                    case "tue":
                        timetable = (users.getUser(i + 1).getTimetable()).getTueTimetable();
                        break;
                    case "wed":
                        timetable = (users.getUser(i + 1).getTimetable()).getWedTimetable();
                        break;
                    case "thu":
                        timetable = (users.getUser(i + 1).getTimetable()).getThuTimetable();
                        break;
                    case "fri":
                        timetable = (users.getUser(i + 1).getTimetable()).getFriTimetable();
                        break;
                    case "sat":
                        timetable = (users.getUser(i + 1).getTimetable()).getSatTimetable();
                        break;
                    case "sun":
                        timetable = (users.getUser(i + 1).getTimetable()).getSunTimetable();
                        break;
                    default:
                        throw new DukeException("Sorry! I don't know what day you mean :-(");
                    }
                    String removedClass = timetable.get(index - 1).toString();
                    timetable.remove(index - 1);
                    ui.printDelete(removedClass, day, timetable.size());
                    break;
                }
            }
        } catch (NumberFormatException e) {
            throw new DukeException("You've entered an invalid index!");
        } catch (IndexOutOfBoundsException e) {
            throw new DukeException("You've entered an invalid index!");
        }
    }
}
