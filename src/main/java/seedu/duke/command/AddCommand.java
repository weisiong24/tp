package seedu.duke.command;

import seedu.duke.exception.DukeException;
//import seedu.duke.storage.Storage;
import seedu.duke.task.Event;
import seedu.duke.task.TaskList;
import seedu.duke.timetable.Timetable;
import seedu.duke.ui.Ui;
import seedu.duke.user.User;
import seedu.duke.user.UserList;

/**
 * Adds an event to the task list.
 */
public class AddCommand extends Command {

    public AddCommand(String input) {
        super(input);
    }

    @Override
    public void execute(UserList users, Ui ui, User nowUser/*, Storage storage*/) throws DukeException {
        //Lec /day /time /location
        if (nowUser != null) {
            String[] parsedInputs = input.split(" /", 4);
            String[] timeInputs = parsedInputs[2].split("-", 2);

            String day = parsedInputs[1].toLowerCase();

            for (int i = 0; i < users.getTotalUserCount(); i++) {
                if ((users.getUser(i + 1).getName().equals(nowUser.getName()))) {
                    Event newEvent = new Event(parsedInputs[0], parsedInputs[3], timeInputs[0], timeInputs[1]);
                    ui.printEvent(newEvent, day);
                    (users.getUser(i + 1).getTimetable()).getTimetable(day).add(newEvent);
                }
            }
            //((Timetable) currentUser.getTimetable())
            //tasks.addTask(newTask);
            //ui.printEvent(newEvent, date);
            //storage.write(tasks);
        } else {
            throw new DukeException("Sorry! You are not Logged in to any account :-(");
        }
    }
}