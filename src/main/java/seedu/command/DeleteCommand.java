package seedu.command;

import seedu.exception.DukeException;
import seedu.task.Event;
import seedu.ui.Ui;
import seedu.user.User;
import seedu.user.UserList;

import java.util.ArrayList;

/**
 * Deletes a task from the task list.
 */
public class DeleteCommand extends Command {

    public DeleteCommand(String information) {
        super(information);
    }

    @Override
    public void execute(UserList users, Ui ui, User nowUser) throws DukeException {
        if (nowUser == null) {
            throw new DukeException("Sorry! You are not logged in to any account :-(");
        }
        
        try {
            String[] parsedInputs = input.split("/", 3);
            String day = parsedInputs[1].trim();
            int index;
            index = Integer.parseInt(parsedInputs[2]);
            for (int i = 0; i < users.getTotalUserCount(); i++) {
                if ((users.getUser(i + 1).getName().equals(nowUser.getName()))) {
                    ArrayList<Event> timetable = (users.getUser(i + 1).getTimetable()).getTimetable(day);;
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
        } catch (NullPointerException e) {
            throw new DukeException("Input not according UG!");
        }
    }
}
