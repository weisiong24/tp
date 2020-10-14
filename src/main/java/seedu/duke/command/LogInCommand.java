package seedu.duke.command;

import seedu.duke.exception.DukeException;
//import seedu.duke.storage.Storage;
//import seedu.duke.task.Event;
//import seedu.duke.task.TaskList;
import seedu.duke.ui.Ui;
import seedu.duke.user.User;
import seedu.duke.user.UserList;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 * Adds an event to the task list.
 */
public class LogInCommand extends Command {

    public LogInCommand(String input) {
        super(input);
    }

    private static Logger logger = Logger.getLogger("LogAddCommand");

    @Override
    public void execute(UserList users, Ui ui, User nowUser/*, Storage storage*/) throws DukeException {
        boolean doesExist = false;
        setupInputLogger();
        
        String[] parsedInputs = input.split(" /", 2);
        for (int i = 1; i <= users.getTotalUserCount(); i++) {
            if (parsedInputs[0].equals((users.getUser(i)).getName())) {
                if (parsedInputs[1].equals((users.getUser(i)).getPassWord())) {
                    currentUser = users.getUser(i);
                    //System.out.println(parsedInputs[0] + " == " + (users.getUser(i)).getName());
                    doesExist = true;
                } else {
                    logger.log(Level.WARNING,"Wrong Password" + "\n");
                    throw new DukeException("Wrong Password");
                }
            }
        } 
        
        if (doesExist == false) {
            //System.out.println("User: " + parsedInputs[0] + " does not exist!");
            User newUser = new User(parsedInputs[0], parsedInputs[1]);
            currentUser = newUser;
            users.addUser(newUser);

            logger.log(Level.INFO,"User Name successfully added:  " + parsedInputs[0]);
            logger.log(Level.INFO,"Password successfully added:  " + parsedInputs[1]  + "\n");
        }
        ui.greetUser(currentUser);
        isLogIn = true;

        logger.log(Level.INFO, "end of processing");
        
        //storage.write(tasks);
    }

    private void setupInputLogger() {
        LogManager.getLogManager().reset();
        logger.setLevel(Level.ALL);
        try {
            FileHandler fh = new FileHandler("LogInCommand.log",true);
            fh.setLevel(Level.INFO);
            fh.setFormatter(new SimpleFormatter());
            logger.addHandler(fh);

        } catch (IOException e) {
            logger.log(Level.SEVERE,"File logging not working");
        }
    }
}
