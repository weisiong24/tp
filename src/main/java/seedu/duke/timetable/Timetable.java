package seedu.duke.timetable;

import seedu.duke.task.Event;

import java.util.ArrayList;
import java.util.List;

public class Timetable {
    protected ArrayList<Event> monTimetable;
    protected ArrayList<Event> tueTimetable;
    protected ArrayList<Event> wedTimetable;
    protected ArrayList<Event> thuTimetable;
    protected ArrayList<Event> friTimetable;
    protected ArrayList<Event> satTimetable;
    protected ArrayList<Event> sunTimetable;

    public Timetable() {
        this.monTimetable = new ArrayList<>();
        this.tueTimetable = new ArrayList<>();
        this.wedTimetable = new ArrayList<>();
        this.thuTimetable = new ArrayList<>();
        this.friTimetable = new ArrayList<>();
        this.satTimetable = new ArrayList<>();
        this.sunTimetable = new ArrayList<>();
    }

    public ArrayList<Event> getMonTimetable() {
        return monTimetable;
    }

    public ArrayList<Event> getTueTimetable() {
        return tueTimetable;
    }

    public ArrayList<Event> getWedTimetable() {
        return wedTimetable;
    }

    public ArrayList<Event> getThuTimetable() {
        return thuTimetable;
    }

    public ArrayList<Event> getFriTimetable() {
        return friTimetable;
    }

    public ArrayList<Event> getSatTimetable() {
        return satTimetable;
    }

    public ArrayList<Event> getSunTimetable() {
        return sunTimetable;
    }


}