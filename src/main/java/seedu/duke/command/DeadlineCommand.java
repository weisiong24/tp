//package seedu.duke.command;
//
//import seedu.duke.exception.DukeException;
//import seedu.duke.storage.Storage;
//import seedu.duke.task.Deadline;
//import seedu.duke.task.TaskList;
//import seedu.duke.ui.Ui;
//
///**
// * Adds a deadline to the task list.
// */
//public class DeadlineCommand extends Command {
//
//    public DeadlineCommand(String input) {
//        super(input);
//    }
//
//    @Override
//    public void execute(TaskList tasks, Ui ui, Storage storage) throws DukeException {
//        String[] parsedInputs = input.split(" /by ", 2);
//        Deadline newTask = new Deadline(parsedInputs[0], parsedInputs[1]);
//        tasks.addTask(newTask);
//        ui.printDeadline(tasks, newTask);
//        storage.write(tasks);
//    }
//}
