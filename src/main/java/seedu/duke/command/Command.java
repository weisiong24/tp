package seedu.duke.command;

import seedu.duke.exception.DukeException;
//import seedu.duke.storage.Storage;
import seedu.duke.task.TaskList;
import seedu.duke.ui.Ui;

public abstract class Command {
    protected String input;
    protected boolean isExit = false;

    /**
     * Creates a new command.
     *
     * @param input the command given by the user in string.
     */
    public Command(String input) {
        this.input = input;
    }

    /**
     * Executes the Command based on the TaskList, Ui and Storage.
     *
     * @param tasks the TaskList given to execute command on.
     * @param ui the corresponding messages based on the task.
     * @throws DukeException if execution encounters error.
     */
    public abstract void execute(TaskList tasks, Ui ui/*, Storage storage*/) throws DukeException;

    public boolean isExit() {
        return isExit;
    }
}
