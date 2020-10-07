package seedu.duke.command;

import seedu.duke.exception.DukeException;
//import seedu.duke.storage.Storage;
import seedu.duke.task.Task;
import seedu.duke.task.TaskList;
import seedu.duke.ui.Ui;

/**
 * Deletes a task from the task list.
 */
public class DeleteCommand extends Command {

    public DeleteCommand(String information) {
        super(information);
    }

    @Override
    public void execute(TaskList tasks, Ui ui/*, Storage storage*/) throws DukeException {
        int index = Integer.parseInt(input);
        Task removedTask = tasks.getTask(index);
        tasks.deleteTask(index);
        ui.printDelete(tasks, removedTask);
//        storage.write(tasks);
    }
}
