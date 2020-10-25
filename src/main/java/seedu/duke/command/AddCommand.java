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
                            int timeStartInt = Integer.parseInt(mon.get(j).getTimeStart());
                            int timeStartNextInt = Integer.parseInt(mon.get(j + 1).getTimeStart());
                            int timeEndInt = Integer.parseInt(mon.get(j).getTimeEnd());
                            int timeEndNextInt = Integer.parseInt(mon.get(j + 1).getTimeEnd());
                            if (timeStartInt == timeStartNextInt
                                    || timeEndInt == timeEndNextInt
                                    || ((timeStartInt + 100 == timeStartNextInt && timeStartInt + 100 == timeEndInt))
                                    || ((timeStartInt + 200 == timeStartNextInt && timeStartInt + 200 == timeEndInt))
                                    || ((timeStartInt + 300 == timeStartNextInt && timeStartInt + 300 == timeEndInt))
                                    || ((timeStartInt + 400 == timeStartNextInt && timeStartInt + 400 == timeEndInt))
                                    || ((timeStartInt + 500 == timeStartNextInt && timeStartInt + 500 == timeEndInt))) {
                                mon.remove(j + 1);
                                throw new DukeException("Duplicate Timetable Detected! Please re-enter");
                            }
                        }
                        break;
                    case "tue":

                        ArrayList<Event> tue = users.getUser(i + 1).getTimetable().tueTimetable;
                        for (int j = 0; j < tue.size() - 1; j++) {
                            int timeStartInt = Integer.parseInt(tue.get(j).getTimeStart());
                            int timeStartNextInt = Integer.parseInt(tue.get(j + 1).getTimeStart());
                            int timeEndInt = Integer.parseInt(tue.get(j).getTimeEnd());
                            int timeEndNextInt = Integer.parseInt(tue.get(j + 1).getTimeEnd());
                            if (timeStartInt == timeStartNextInt || timeEndInt == timeEndNextInt
                                    || ((timeStartInt + 100 == timeStartNextInt && timeStartInt + 100 == timeEndInt))
                                    || ((timeStartInt + 200 == timeStartNextInt && timeStartInt + 200 == timeEndInt))
                                    || ((timeStartInt + 300 == timeStartNextInt && timeStartInt + 300 == timeEndInt))
                                    || ((timeStartInt + 400 == timeStartNextInt && timeStartInt + 400 == timeEndInt))
                                    || ((timeStartInt + 500 == timeStartNextInt && timeStartInt + 500 == timeEndInt))) {
                                tue.remove(j + 1);
                                throw new DukeException("Duplicate Timetable Detected! Please re-enter");
                            }
                        }
                        break;
                    case "wed":
                        ArrayList<Event> wed = users.getUser(i + 1).getTimetable().wedTimetable;
                        for (int j = 0; j < wed.size() - 1; j++) {
                            int timeStartInt = Integer.parseInt(wed.get(j).getTimeStart());
                            int timeStartNextInt = Integer.parseInt(wed.get(j + 1).getTimeStart());
                            int timeEndInt = Integer.parseInt(wed.get(j).getTimeEnd());
                            int timeEndNextInt = Integer.parseInt(wed.get(j + 1).getTimeEnd());
                            if (timeStartInt == timeStartNextInt || timeEndInt == timeEndNextInt
                                    || ((timeStartInt + 100 == timeStartNextInt && timeStartInt + 100 == timeEndInt))
                                    || ((timeStartInt + 200 == timeStartNextInt && timeStartInt + 200 == timeEndInt))
                                    || ((timeStartInt + 300 == timeStartNextInt && timeStartInt + 300 == timeEndInt))
                                    || ((timeStartInt + 400 == timeStartNextInt && timeStartInt + 400 == timeEndInt))
                                    || ((timeStartInt + 500 == timeStartNextInt && timeStartInt + 500 == timeEndInt))) {
                                wed.remove(j + 1);
                                throw new DukeException("Duplicate Timetable Detected! Please re-enter");
                            }
                        }
                        break;
                    case "thu":
                        ArrayList<Event> thu = users.getUser(i + 1).getTimetable().thuTimetable;
                        for (int j = 0; j < thu.size() - 1; j++) {
                            int timeStartInt = Integer.parseInt(thu.get(j).getTimeStart());
                            int timeStartNextInt = Integer.parseInt(thu.get(j + 1).getTimeStart());
                            int timeEndInt = Integer.parseInt(thu.get(j).getTimeEnd());
                            int timeEndNextInt = Integer.parseInt(thu.get(j + 1).getTimeEnd());
                            if (timeStartInt == timeStartNextInt || timeEndInt == timeEndNextInt
                                    || ((timeStartInt + 100 == timeStartNextInt && timeStartInt + 100 == timeEndInt))
                                    || ((timeStartInt + 200 == timeStartNextInt && timeStartInt + 200 == timeEndInt))
                                    || ((timeStartInt + 300 == timeStartNextInt && timeStartInt + 300 == timeEndInt))
                                    || ((timeStartInt + 400 == timeStartNextInt && timeStartInt + 400 == timeEndInt))
                                    || ((timeStartInt + 500 == timeStartNextInt && timeStartInt + 500 == timeEndInt))) {
                                thu.remove(j + 1);
                                throw new DukeException("Duplicate Timetable Detected! Please re-enter");
                            }
                        }
                        break;
                    case "fri":
                        ArrayList<Event> fri = users.getUser(i + 1).getTimetable().friTimetable;
                        for (int j = 0; j < fri.size() - 1; j++) {
                            int timeStartInt = Integer.parseInt(fri.get(j).getTimeStart());
                            int timeStartNextInt = Integer.parseInt(fri.get(j + 1).getTimeStart());
                            int timeEndInt = Integer.parseInt(fri.get(j).getTimeEnd());
                            int timeEndNextInt = Integer.parseInt(fri.get(j + 1).getTimeEnd());
                            if (timeStartInt == timeStartNextInt || timeEndInt == timeEndNextInt
                                    || ((timeStartInt + 100 == timeStartNextInt && timeStartInt + 100 == timeEndInt))
                                    || ((timeStartInt + 200 == timeStartNextInt && timeStartInt + 200 == timeEndInt))
                                    || ((timeStartInt + 300 == timeStartNextInt && timeStartInt + 300 == timeEndInt))
                                    || ((timeStartInt + 400 == timeStartNextInt && timeStartInt + 400 == timeEndInt))
                                    || ((timeStartInt + 500 == timeStartNextInt && timeStartInt + 500 == timeEndInt))) {
                                fri.remove(j + 1);
                                throw new DukeException("Duplicate Timetable Detected! Please re-enter");
                            }
                        }
                        break;
                    case "sat":
                        ArrayList<Event> sat = users.getUser(i + 1).getTimetable().satTimetable;
                        for (int j = 0; j < sat.size() - 1; j++) {
                            int timeStartInt = Integer.parseInt(sat.get(j).getTimeStart());
                            int timeStartNextInt = Integer.parseInt(sat.get(j + 1).getTimeStart());
                            int timeEndInt = Integer.parseInt(sat.get(j).getTimeEnd());
                            int timeEndNextInt = Integer.parseInt(sat.get(j + 1).getTimeEnd());
                            if (timeStartInt == timeStartNextInt || timeEndInt == timeEndNextInt
                                    || ((timeStartInt + 100 == timeStartNextInt && timeStartInt + 100 == timeEndInt))
                                    || ((timeStartInt + 200 == timeStartNextInt && timeStartInt + 200 == timeEndInt))
                                    || ((timeStartInt + 300 == timeStartNextInt && timeStartInt + 300 == timeEndInt))
                                    || ((timeStartInt + 400 == timeStartNextInt && timeStartInt + 400 == timeEndInt))
                                    || ((timeStartInt + 500 == timeStartNextInt && timeStartInt + 500 == timeEndInt))) {
                                sat.remove(j + 1);
                                throw new DukeException("Duplicate Timetable Detected! Please re-enter");
                            }
                        }
                        break;
                    case "sun":
                        ArrayList<Event> sun = users.getUser(i + 1).getTimetable().sunTimetable;
                        for (int j = 0; j < sun.size() - 1; j++) {
                            int timeStartInt = Integer.parseInt(sun.get(j).getTimeStart());
                            int timeStartNextInt = Integer.parseInt(sun.get(j + 1).getTimeStart());
                            int timeEndInt = Integer.parseInt(sun.get(j).getTimeEnd());
                            int timeEndNextInt = Integer.parseInt(sun.get(j + 1).getTimeEnd());
                            if (timeStartInt == timeStartNextInt || timeEndInt == timeEndNextInt
                                    || ((timeStartInt + 100 == timeStartNextInt && timeStartInt + 100 == timeEndInt))
                                    || ((timeStartInt + 200 == timeStartNextInt && timeStartInt + 200 == timeEndInt))
                                    || ((timeStartInt + 300 == timeStartNextInt && timeStartInt + 300 == timeEndInt))
                                    || ((timeStartInt + 400 == timeStartNextInt && timeStartInt + 400 == timeEndInt))
                                    || ((timeStartInt + 500 == timeStartNextInt && timeStartInt + 500 == timeEndInt))) {
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