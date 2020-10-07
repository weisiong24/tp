package seedu.duke;

import seedu.duke.exception.DukeException;
//import seedu.duke.storage.Storage;
import seedu.duke.task.TaskList;
import seedu.duke.ui.Ui;
import seedu.duke.command.Command;
import seedu.duke.parser.Parser;

public class Duke {

//    private Storage storage;
    private TaskList tasks;
    private final Ui ui;

    public Duke() {
        ui = new Ui();
//        try {
//            storage = new Storage();
//            tasks = new TaskList(storage.load());
//        } catch (DukeException e) {
//            ui.showError(e.getMessage());
//            tasks = new TaskList();
//        }
    }

    public void run() {
        ui.showWelcome();
        boolean isExit = false;
        while (!isExit) {
            try {
                String fullCommand = ui.readCommand();
                ui.showLine(); // show the divider line ("_______")
                Command c = Parser.parse(fullCommand);
                c.execute(tasks, ui/*, storage*/);
                isExit = c.isExit();
            } catch (DukeException e) {
                ui.showError(e.getMessage());
            } finally {
                ui.showLine();
            }
        }
    }

    public static void main(String[] args) {
        new Duke().run();
    }



    /**
     * Main entry-point for the java.duke.Duke application.
     */
    /*    public static void main(String[] args) {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);
        System.out.println("What is your name?");

        Scanner in = new Scanner(System.in);
        System.out.println("Hello " + in.nextLine());

    }*/
}
