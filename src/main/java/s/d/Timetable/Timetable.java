package s.d.Timetable;

import java.util.ArrayList;

public class Timetable {
    protected ArrayList<Object> monTimetable;
    protected ArrayList<Object> tueTimetable;
    protected ArrayList<Object> wedTimetable;
    protected ArrayList<Object> thuTimetable;
    protected ArrayList<Object> friTimetable;
    protected ArrayList<Object> satTimetable;
    protected ArrayList<Object> sunTimetable;

    public Timetable() {
        this.monTimetable = new ArrayList<>();
        this.tueTimetable = new ArrayList<>();
        this.wedTimetable = new ArrayList<>();
        this.thuTimetable = new ArrayList<>();
        this.friTimetable = new ArrayList<>();
        this.satTimetable = new ArrayList<>();
        this.sunTimetable = new ArrayList<>();
    }
}
