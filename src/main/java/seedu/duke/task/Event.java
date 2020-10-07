package seedu.duke.task;

public class Event extends Task {

//    protected String at;

    public Event(String description, String location, String timeStart, String timeEnd) {
        super(description, location, timeStart, timeEnd);

//        this.at = at;
//        setTaskType("E");
    }

    /**
     * Returns the event detail of the task.
     * @return the event detail of the task.
     */
//    public String getAt() {
//        return at;
//    }

    @Override
    public String toString() {
        return super.toString() ;
    }
}
