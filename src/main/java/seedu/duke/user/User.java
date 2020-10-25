package seedu.duke.user;

import seedu.duke.timetable.Timetable;
import seedu.duke.task.Event;

import java.util.ArrayList;

public class User {
    protected String name;
    protected String passWord;
    protected Timetable timetable;
    protected String encipheredPassword;

    public User(String name, String passWord) {
        this.name = name;
        this.passWord = passWord;
        this.timetable = new Timetable();
        this.encipheredPassword = Cryptography.encipherPassword(passWord);
    }

    public String getName() {
        return name;
    }

    public String getPassWord() {
        return passWord;
    }

    public String getEncipheredPassword() {
        return encipheredPassword;
    }

    public Timetable getTimetable() {
        return timetable;
    }
    
    public ArrayList<ArrayList<Event>> combineAllTimetable() {
        ArrayList<ArrayList<Event>> combinedTimeTable = new ArrayList<>();
        combinedTimeTable.add(getTimetable().monTimetable);
        combinedTimeTable.add(getTimetable().tueTimetable);
        combinedTimeTable.add(getTimetable().wedTimetable);
        combinedTimeTable.add(getTimetable().thuTimetable);
        combinedTimeTable.add(getTimetable().friTimetable);
        combinedTimeTable.add(getTimetable().satTimetable);
        combinedTimeTable.add(getTimetable().sunTimetable);
        return combinedTimeTable;
    }
}
