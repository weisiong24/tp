package seedu.duke.command;

import seedu.duke.exception.DukeException;
//import seedu.duke.storage.Storage;
import seedu.duke.task.Event;
import seedu.duke.task.TaskList;
import seedu.duke.timetable.Timetable;
import seedu.duke.ui.Ui;
import seedu.duke.user.User;
import seedu.duke.user.UserList;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 * Adds an event to the task list.
 */
public class AddCommand extends Command {

    public AddCommand(String input) {
        super(input);
    }

    private static Logger logger = Logger.getLogger("LogAddCommand");

    @Override
    public void execute(UserList users, Ui ui, User nowUser/*, Storage storage*/) throws DukeException {
        //Lec /day /time /location
        setupInputLogger();
        if (nowUser != null) {
            String[] parsedInputs = input.split("/", 5);
            String[] timeInputs = parsedInputs[3].split("-", 2);

            String day = parsedInputs[2].toLowerCase().trim();
          
            assert timeInputs[0].length() == 4 : "Wrong Start time format specified";
            assert day.length() == 3 : "Wrong format of day entered";

            logger.log(Level.INFO,"Timetable name successfully added:  " + parsedInputs[1]);
            logger.log(Level.INFO,"Day successfully add:  " + parsedInputs[2]);
            logger.log(Level.INFO,"Time successfully add:  " + parsedInputs[3]);
            logger.log(Level.INFO,"Location successfully add:  " + parsedInputs[4] + "\n");

            for (int i = 0; i < users.getTotalUserCount(); i++) {
                if ((users.getUser(i + 1).getName().equals(nowUser.getName()))) {
                    Event newEvent = new Event(parsedInputs[1].trim(), parsedInputs[4].trim(), 
                            timeInputs[0].trim(), timeInputs[1].trim());
                    ui.printEvent(newEvent, day);
                    users.getUser(i + 1).getTimetable().getTimetable(day).add(newEvent);
                    ArrayList<Event> timetable = users.getUser(i + 1).getTimetable().getTimetable(day);
                    logger.log(Level.INFO, day + " timetable successfully add:  " + timetable  + "\n");
                }
            }
            //((Timetable) currentUser.getTimetable())
            //tasks.addTask(newTask);
            //ui.printEvent(newEvent, date);
            //storage.write(tasks);
        } else {
            logger.log(Level.WARNING,"Not logged in" + "\n");
            throw new DukeException("Sorry! You are not Logged in to any account :-(");
        }
    }

    private void setupInputLogger() {
        LogManager.getLogManager().reset();
        logger.setLevel(Level.ALL);
        try {
            FileHandler fh = new FileHandler("AddCommand.log",true);
            fh.setLevel(Level.INFO);
            fh.setFormatter(new SimpleFormatter());
            logger.addHandler(fh);

        } catch (IOException e) {
            logger.log(Level.SEVERE,"File logging not working");
        }
    }
}