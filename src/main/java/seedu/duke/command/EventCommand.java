package seedu.duke.command;

import seedu.duke.exception.DukeException;
//import seedu.duke.storage.Storage;
import seedu.duke.task.Event;
import seedu.duke.task.TaskList;
import seedu.duke.ui.Ui;

/**
 * Adds an event to the task list.
 */
public class EventCommand extends Command {

    public EventCommand(String input) {
        super(input);
    }

    @Override
    public void execute(TaskList tasks, Ui ui/*, Storage storage*/) throws DukeException {
        String[] parsedInputs = input.split(" /at ", 2);
        Event newTask = new Event(parsedInputs[0], parsedInputs[1]); //
        tasks.addTask(newTask);
        ui.printEvent(tasks, newTask);
//        storage.write(tasks);
    }
}
