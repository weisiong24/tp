package seedu.duke.command;

import seedu.duke.exception.DukeException;
import seedu.duke.ui.Ui;
import seedu.duke.user.User;
import seedu.duke.user.UserList;
import seedu.duke.task.Event;

public class EditCommand extends Command {
    public EditCommand(String input) {
        super(input);
    }

    @Override
    public void execute(UserList users, Ui ui, User nowUser/*, Storage storage*/) throws DukeException {
        String[] parsedInputs = input.split("/", 4);
        assert parsedInputs.length == 4 : "input format is not according to UG";
        
        String date = parsedInputs[1].trim();
        String[] newTime = parsedInputs[3].split("-");
        assert newTime.length == 2 : "date format is not according to UG";
        
        int index = Integer.parseInt(parsedInputs[2].trim());
        Event originalEvent;

        for (int i = 0; i < users.getTotalUserCount(); i++) {
            if ((users.getUser(i + 1).getName().equals(nowUser.getName()))) {
                originalEvent = nowUser.getTimetable().getTimetable(date).get(index - 1);
                Event modifiedEvent = new Event(originalEvent.getDescription(), originalEvent.getLocation(), newTime[0], newTime[1]);
                nowUser.getTimetable().getTimetable(date).set(index - 1, modifiedEvent);
                ui.printEdit(newTime, date, index);
            }
        }
    }
}