package seedu.command;

import seedu.exception.WhereGotTimeException;
import seedu.timetable.SortTimetable;
import seedu.ui.Ui;
import seedu.user.User;
import seedu.user.UserList;
import seedu.task.Event;

public class EditCommand extends Command {
    public EditCommand(String input) {
        super(input);
    }

    @Override
    public void execute(UserList users, Ui ui, User nowUser/*, Storage storage*/) throws WhereGotTimeException {

        if (nowUser == null) {
            throw new WhereGotTimeException("Sorry! You are not logged in to any account!");
        }

        String[] parsedInputs = input.split("/", 4);
        if (parsedInputs.length < 4) {
            throw new WhereGotTimeException("Incorrect format for edit command! Enter 'help' for the correct  "
                    + "input format!");
        }

        assert parsedInputs.length == 4 : "input format is not according to UG";

        try {
            String date = parsedInputs[1].trim();
            String[] newTime = parsedInputs[3].split("-");
            
            if (newTime.length != 2) {
                throw new WhereGotTimeException("Invalid time format. Enter 'help' for the correct input format!");
            }
            
            checkTimeValidity(newTime);
            int index = Integer.parseInt(parsedInputs[2].trim());
            
            Event originalEvent;

            for (int i = 0; i < users.getTotalUserCount(); i++) {
                if ((users.getUser(i + 1).getName().equals(nowUser.getName()))) {
                    originalEvent = nowUser.getTimetable().getTimetable(date).get(index - 1);
                    String originalStartTime = originalEvent.getTimeStart();
                    String originalEndTime = originalEvent.getTimeEnd();
                    if (newTime[0].equals(originalStartTime) && newTime[1].equals(originalEndTime)) {
                        throw new WhereGotTimeException("You have entered a timing that is exactly the \nsame as "
                                + "the original one! Hence, no changes were made!");
                    }
                    Event modifiedEvent = new Event(originalEvent.getDescription(),
                            originalEvent.getLocation(), newTime[0], newTime[1]);
                    nowUser.getTimetable().getTimetable(date).set(index - 1, modifiedEvent);
                    ui.printEdit(newTime, date, index);
                }
            }
            SortTimetable.sortTimetable(users, nowUser, date);

        } catch (IndexOutOfBoundsException e) {
            throw new WhereGotTimeException("You've entered an invalid index!");
        } catch (NumberFormatException e) {
            throw new WhereGotTimeException("You've entered an invalid number format!");
        } catch (NullPointerException e) {
            throw new WhereGotTimeException("Empty timing values!");
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
        
        if (startTimeHourInt < 0 || startTimeHourInt > 23) {
            throw new WhereGotTimeException("Invalid hour for start time! It should be in "
                    + "24-hour format. e.g. 0000-2359");
        } else if (startTimeMinuteInt < 0 || startTimeMinuteInt > 59) {
            throw new WhereGotTimeException("Invalid minute for start time! It should be in "
                    + "24-hour format. e.g. 0000-2359");
        }

        if (endTimeHourInt < 0 || endTimeHourInt > 23) {
            throw new WhereGotTimeException("Invalid hour for end time! It should be in "
                    + "24-hour format. e.g. 0000-2359");
        } else if (endTimeMinuteInt < 0 || endTimeMinuteInt > 59) {
            throw new WhereGotTimeException("Invalid minute for end time! It should be in "
                    + "24-hour format. e.g. 0000-2359");
        }
        
        try {
            if (startTime == endTime) {
                throw new WhereGotTimeException("Start time cannot be the same as end time!");
            }
            if (startTime > endTime) {
                throw new WhereGotTimeException("Start time cannot be later than end time!");
            }
        } catch (NullPointerException e) {
            throw new WhereGotTimeException("Empty timing values!");
        }
    }

}