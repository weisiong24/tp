package seedu.duke.command;

//import seedu.duke.storage.Storage;
import seedu.duke.task.TaskList;
import seedu.duke.ui.Ui;

/**
 * Terminates Duke program.
 */
public class ByeCommand extends Command {

    public ByeCommand() {
        super(null);
    }

    //@Override
    public void execute(TaskList tasks, Ui ui/*, Storage storage*/) {
        isExit = true;
        ui.showBye();
    }
}
