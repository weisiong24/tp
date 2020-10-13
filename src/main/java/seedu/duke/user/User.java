package seedu.duke.user;

import seedu.duke.timetable.Timetable;

public class User {
    protected String name;
    protected String passWord;
    protected Timetable timetable;

    public User(String name, String passWord) {
        this.name = name;
        this.passWord = passWord;
        this.timetable = new Timetable();
    }

    public String getName() {
        return name;
    }

    public String getPassWord() {
        return passWord;
    }

    public Timetable getTimetable() {
        return timetable;
    }
}
