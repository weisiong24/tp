package seedu.command;

import org.junit.jupiter.api.Test;
import seedu.task.Event;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class EditCommandTest {
    
    String module = "CS2113 Lec";
    String location = "LT21";
    String timeStart = "1200";
    String timeEnd = "1300";

    @Test
    void testEditCommand() {
        Event e = new Event(module, location,timeStart,timeEnd);

        assertEquals("CS2113 Lec LT21 1200-1300",e.toString());
    }

} 