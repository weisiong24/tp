package s.d.user;

import java.util.ArrayList;

public class User {
    protected String name;
    protected String passWord;
    protected ArrayList<Object> monTimetable, tueTimetable, wedTimetable, thuTimetable,friTimetable,satTimetable,sunTimetable;

    public User(String name, String passWord) {
        this.name = name;
        this.passWord = passWord;
        this.monTimetable = new ArrayList<>();
        this.tueTimetable = new ArrayList<>();
        this.wedTimetable = new ArrayList<>();
        this.thuTimetable = new ArrayList<>();
        this.friTimetable = new ArrayList<>();
        this.satTimetable = new ArrayList<>();
        this.sunTimetable = new ArrayList<>();
    }
}
