package seedu.duke.command;

import seedu.duke.exception.DukeException;
//import seedu.duke.storage.Storage;
import seedu.duke.task.Event;
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

    private static Logger logger = Logger.getLogger("LogLogInCommand");

    @Override
    public void execute(UserList users, Ui ui, User nowUser/*, Storage storage*/) throws DukeException {
        /*/Lec /day /time /location*/
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

                    ArrayList<Event> timetable = users.getUser(i + 1).getTimetable().getTimetable(day);
                    timetable.add(newEvent);
                    switch (day) {
                    case "mon":
                        ArrayList<Event> mon = users.getUser(i + 1).getTimetable().monTimetable;
                        for (int j = 0; j < mon.size() - 1; j++) {
                            if (mon.get(j).getTimeStart().equals(mon.get(j + 1).getTimeStart())
                                    || mon.get(j).getTimeEnd().equals(mon.get(j + 1).getTimeEnd())) {
                                mon.remove(j + 1);
                                throw new DukeException("Duplicate Timetable Detected! Please re-enter");
                            }
                        }
                        break;
                    case "tue":
                        ArrayList<Event> tue = users.getUser(i + 1).getTimetable().tueTimetable;
                        for (int j = 0; j < tue.size() - 1; j++) {
                            if (tue.get(j).getTimeStart().equals(tue.get(j + 1).getTimeStart())
                                    || tue.get(j).getTimeEnd().equals(tue.get(j + 1).getTimeEnd())) {
                                tue.remove(j + 1);
                                throw new DukeException("Duplicate Timetable Detected! Please re-enter");
                            }
                        }
                        break;
                    case "wed":
                        ArrayList<Event> wed = users.getUser(i + 1).getTimetable().wedTimetable;
                        for (int j = 0; j < wed.size() - 1; j++) {
                            if (wed.get(j).getTimeStart().equals(wed.get(j + 1).getTimeStart())
                                    || wed.get(j).getTimeEnd().equals(wed.get(j + 1).getTimeEnd())) {
                                wed.remove(j + 1);
                                throw new DukeException("Duplicate Timetable Detected! Please re-enter");
                            }
                        }
                        break;
                    case "thu":
                        ArrayList<Event> thu = users.getUser(i + 1).getTimetable().thuTimetable;
                        for (int j = 0; j < thu.size() - 1; j++) {
                            if (thu.get(j).getTimeStart().equals(thu.get(j + 1).getTimeStart())
                                    || thu.get(j).getTimeEnd().equals(thu.get(j + 1).getTimeEnd())) {
                                thu.remove(j + 1);
                                throw new DukeException("Duplicate Timetable Detected! Please re-enter");
                            }
                        }
                        break;
                    case "fri":
                        ArrayList<Event> fri = users.getUser(i + 1).getTimetable().friTimetable;
                        for (int j = 0; j < fri.size() - 1; j++) {
                            if (fri.get(j).getTimeStart().equals(fri.get(j + 1).getTimeStart())
                                    || fri.get(j).getTimeEnd().equals(fri.get(j + 1).getTimeEnd())) {
                                fri.remove(j + 1);
                                throw new DukeException("Duplicate Timetable Detected! Please re-enter");
                            }
                        }
                        break;
                    case "sat":
                        ArrayList<Event> sat = users.getUser(i + 1).getTimetable().satTimetable;
                        for (int j = 0; j < sat.size() - 1; j++) {
                            if (sat.get(j).getTimeStart().equals(sat.get(j + 1).getTimeStart())
                                    || sat.get(j).getTimeEnd().equals(sat.get(j + 1).getTimeEnd())) {
                                sat.remove(j + 1);
                                throw new DukeException("Duplicate Timetable Detected! Please re-enter");
                            }
                        }
                        break;
                    case "sun":
                        ArrayList<Event> sun = users.getUser(i + 1).getTimetable().sunTimetable;
                        for (int j = 0; j < sun.size() - 1; j++) {
                            if (sun.get(j).getTimeStart().equals(sun.get(j + 1).getTimeStart())
                                    || sun.get(j).getTimeEnd().equals(sun.get(j + 1).getTimeEnd())) {
                                sun.remove(j + 1);
                                throw new DukeException("Duplicate Timetable Detected! Please re-enter");
                            }
                        }
                        break;
                    default:
                        break;
                    }
                    ui.printEvent(newEvent, day);

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