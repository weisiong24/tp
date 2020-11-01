package seedu.command;

import org.junit.jupiter.api.Test;
import seedu.task.Event;
import static org.junit.jupiter.api.Assertions.assertEquals;

class AddCommandTest {

    String name = "CS2040C";
    String location = "LT23";
    String timeStart = "1600";
    String timeEnd = "1900";
    
    @Test
    void testAddCommand() {
        Event e = new Event(name, location,timeStart,timeEnd);

        assertEquals("CS2040C LT23 1600-1900",e.toString());
    }

}