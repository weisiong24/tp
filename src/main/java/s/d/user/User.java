package s.d.user;

import s.d.Timetable.Timetable;

import java.util.ArrayList;

public class User {
    protected String name;
    protected String passWord;
    protected Timetable timetable;

    public User(String name, String passWord) {
        this.name = name;
        this.passWord = passWord;
        this.timetable = new Timetable();
    }
}
