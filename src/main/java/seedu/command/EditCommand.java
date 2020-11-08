package seedu.command;

import seedu.exception.IdenticalTimingsException;
import seedu.exception.IllogicalTimingException;
import seedu.exception.IncorrectCommandFormatException;
import seedu.exception.InvalidIndexException;
import seedu.exception.InvalidTimingFormatException;
import seedu.exception.NotLoggedInException;
import seedu.exception.WhereGotTimeException;
import seedu.timetable.SortTimetable;
import seedu.ui.Ui;
import seedu.user.User;
import seedu.user.UserList;
import seedu.task.Event;

import java.util.ArrayList;
import java.util.Scanner;

public class EditCommand extends Command {
    public EditCommand(String input) {
        super(input);
    }

    @Override
    public void execute(UserList users, Ui ui, User nowUser/*, Storage storage*/) throws WhereGotTimeException {

        if (nowUser == null) {
            throw new NotLoggedInException("Sorry! You are not logged in to any account!");
        }

        String[] parsedInputs = input.split("/", 2);
        if (parsedInputs.length != 2) {
            throw new IncorrectCommandFormatException("Incorrect format for edit command! Enter 'help' for the correct "
                    + "input format!");
        }

        String date = parsedInputs[1].trim();
        ArrayList<Event> dateTimetable = nowUser.getTimetable().getTimetable(date);

        if (dateTimetable.size() == 0) {

            ui.printEditEmptyClass(nowUser, date);

        } else {
            try {
                ui.printEditLessonList(nowUser, date, dateTimetable);

                Scanner scanner = new Scanner(System.in);
                String editInput = scanner.nextLine().trim();
                String[] parsedEditInput = editInput.split("/", 3);

                if (parsedEditInput.length != 3) {
                    throw new IncorrectCommandFormatException("You have entered an invalid edit format!");
                } else if (!parsedEditInput[0].isEmpty()) {
                    throw new IncorrectCommandFormatException("You have entered an invalid edit format!");
                }

                int index = Integer.parseInt(parsedEditInput[1].trim());

                String[] newTime = parsedEditInput[2].split("-");
                if (newTime.length != 2) {
                    throw new IncorrectCommandFormatException("Invalid time format. Enter 'help' for the "
                            + "correct input format!");
                }
                checkTimeValidity(newTime);

                Event originalEvent;
                for (int i = 0; i < users.getTotalUserCount(); i++) {
                    if ((users.getUser(i + 1).getName().equals(nowUser.getName()))) {
                        originalEvent = nowUser.getTimetable().getTimetable(date).get(index - 1);
                        String originalStartTime = originalEvent.getTimeStart();
                        String originalEndTime = originalEvent.getTimeEnd();
                        if (newTime[0].equals(originalStartTime) && newTime[1].equals(originalEndTime)) {
                            throw new IdenticalTimingsException("You have entered a timing that is exactly "
                                    + "the \nsame as the original one! Hence, no changes were made!");
                        }
                        Event modifiedEvent = new Event(originalEvent.getDescription(),
                                originalEvent.getLocation(), newTime[0], newTime[1]);
                        nowUser.getTimetable().getTimetable(date).set(index - 1, modifiedEvent);
                        ui.printEdit(originalEvent, modifiedEvent);
                    }
                }
                SortTimetable.sortTimetable(users, nowUser, date);

            } catch (NumberFormatException e) {
                throw new IncorrectCommandFormatException("You've entered an invalid edit format!");
            } catch (IndexOutOfBoundsException e) {
                throw new InvalidIndexException("You've entered an invalid index!");
            }
        }
    }

    private void checkTimeValidity(String[] time) throws WhereGotTimeException {
        String startTimeHour = time[0].substring(0, 2);
        String startTimeMinute = time[0].substring(2);
        String endTimeHour = time[1].substring(0, 2);
        String endTimeMinute = time[1].substring(2);
        int startTimeHourInt = Integer.parseInt(startTimeHour);
        int startTimeMinuteInt = Integer.parseInt(startTimeMinute);
        int endTimeHourInt = Integer.parseInt((endTimeHour));
        int endTimeMinuteInt = Integer.parseInt(endTimeMinute);
        int startTime = Integer.parseInt(time[0]);
        int endTime = Integer.parseInt(time[1]);

        if (time[0].length() != 4 || time[1].length() != 4) {
            throw new InvalidTimingFormatException("Invalid hour format! It should be in "
                    + "24-hour format and in 1-hour block! e.g. 0900, 1300, 2300, etc.");
        } else if (startTimeHourInt < 0 || startTimeHourInt > 23) {
            throw new InvalidTimingFormatException("Invalid hour for start time! It should be in "
                    + "24-hour format and in 1-hour block! e.g. 0900, 1300, 2300, etc.");
        } else if (startTimeMinuteInt < 0 || startTimeMinuteInt > 59) {
            throw new InvalidTimingFormatException("Invalid minute for start time! It should be in "
                    + "24-hour format and in 1-hour block! e.g. 0900, 1300, 2300, etc.");
        } else if (endTimeHourInt < 0 || endTimeHourInt > 23) {
            throw new InvalidTimingFormatException("Invalid hour for end time! It should be in "
                    + "24-hour format and in 1-hour block! e.g. 0900, 1300, 2300, etc.");
        } else if (endTimeMinuteInt < 0 || endTimeMinuteInt > 59) {
            throw new InvalidTimingFormatException("Invalid minute for end time! It should be in "
                    + "24-hour format and in 1-hour block! e.g. 0900, 1300, 2300, etc.");
        } else if ((startTimeMinuteInt % 60) != 0 || (endTimeMinuteInt % 60) != 0) {
            throw new InvalidTimingFormatException("The timings should be in 1-hour block! e.g. 0900, 1300, 2300, etc");
        } else if (startTime == endTime) {
            throw new IllogicalTimingException("Start time cannot be the same as end time!");
        } else if (startTime > endTime) {
            throw new IllogicalTimingException("Start time cannot be later than end time!");
        }
    }

}