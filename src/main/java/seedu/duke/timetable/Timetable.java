package seedu.duke.timetable;

import seedu.duke.exception.DukeException;
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

    public ArrayList<Event> getTimetable(String day) throws DukeException {
        switch (day) {
        case "mon":
            return monTimetable;
        case "tue":
            return tueTimetable;
        case "wed":
            return wedTimetable;
        case "thu":
            return thuTimetable;
        case "fri":
            return friTimetable;
        case "sat":
            return satTimetable;
        case "sun":
            return sunTimetable;
        default:
            throw new DukeException("Sorry! I don't know what day you mean :-(");
        }
    }


}