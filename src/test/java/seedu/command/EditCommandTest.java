package seedu.command;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import seedu.exception.IdenticalTimingsException;
import seedu.exception.IllogicalTimingException;
import seedu.exception.IncorrectCommandFormatException;
import seedu.exception.InvalidIndexException;
import seedu.exception.InvalidTimingFormatException;
import seedu.exception.NotLoggedInException;
import seedu.exception.WhereGotTimeException;
import seedu.ui.Ui;
import seedu.user.User;
import seedu.user.UserList;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class EditCommandTest {
    /*    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }*/

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @Test
    void execute_userNotLoggedIn_expectNotLoggedInException() {
        UserList users = new UserList();
        Ui ui = new Ui();
        User nowUser = null;
        String editDay = "/mon";

        assertThrows(NotLoggedInException.class, () -> {
            EditCommand editCommand = new EditCommand(editDay);
            editCommand.execute(users, ui, nowUser);
        });

    }

    @Test
    void execute_newAndOldTimingsAreSame_expectIdenticalTimingsException() throws WhereGotTimeException {
        UserList users = new UserList();
        Ui ui = new Ui();
        User nowUser = new User("devtest", "123123");
        users.addUser(nowUser);

        String addInput = "/CS2113 /Mon /0900-1200 /NUS";
        Command addCommand = new AddCommand(addInput);
        addCommand.execute(users, ui, nowUser);

        String editDay = "/mon";
        String editTime = "/1 /0900-1200";

        assertThrows(IdenticalTimingsException.class, () -> {
            EditCommand editCommand = new EditCommand(editDay);
            InputStream in = new ByteArrayInputStream(editTime.getBytes());
            System.setIn(in);
            editCommand.execute(users, ui, nowUser);
        });
    }

    @Test
    void execute_dayWithoutSlash_expectIncorrectCommandFormatException() throws WhereGotTimeException {
        UserList users = new UserList();
        Ui ui = new Ui();
        User nowUser = new User("devtest", "123123");
        users.addUser(nowUser);

        String addInput = "/CS2113 /Mon /0900-1200 /NUS";
        Command addCommand = new AddCommand(addInput);
        addCommand.execute(users, ui, nowUser);

        String editDay = "mon";
        String editTime = "/1 /0900-1100";

        assertThrows(WhereGotTimeException.class, () -> {
            EditCommand editCommand = new EditCommand(editDay);
            InputStream in = new ByteArrayInputStream(editTime.getBytes());
            System.setIn(in);
            editCommand.execute(users, ui, nowUser);
        });
    }

    @Test
    void execute_invalidEditFormat_expectIncorrectCommandFormatException() throws WhereGotTimeException {
        UserList users = new UserList();
        Ui ui = new Ui();
        User nowUser = new User("devtest", "123123");
        users.addUser(nowUser);

        String addInput = "/CS2113 /Mon /0900-1200 /NUS";
        Command addCommand = new AddCommand(addInput);
        addCommand.execute(users, ui, nowUser);

        String editDay = "/mon /1 /0900-1100";
        String editTime = "/1 /0900-1100";

        assertThrows(WhereGotTimeException.class, () -> {
            EditCommand editCommand = new EditCommand(editDay);
            InputStream in = new ByteArrayInputStream(editTime.getBytes());
            System.setIn(in);
            editCommand.execute(users, ui, nowUser);
        });
    }
    
    @Test
    void execute_timingsAreSeparated_expectIncorrectCommandFormatException() throws WhereGotTimeException {
        UserList users = new UserList();
        Ui ui = new Ui();
        User nowUser = new User("devtest", "123123");
        users.addUser(nowUser);

        String addInput = "/CS2113 /Mon /0900-1200 /NUS";
        Command addCommand = new AddCommand(addInput);
        addCommand.execute(users, ui, nowUser);

        String editDay = "/mon";
        String editTime = "/1 /0900 /1100";

        assertThrows(IncorrectCommandFormatException.class, () -> {
            EditCommand editCommand = new EditCommand(editDay);
            InputStream in = new ByteArrayInputStream(editTime.getBytes());
            System.setIn(in);
            editCommand.execute(users, ui, nowUser);
        });
    }

    @Test
    void execute_timingsWithoutSlash_expectIncorrectCommandFormatException() throws WhereGotTimeException {
        UserList users = new UserList();
        Ui ui = new Ui();
        User nowUser = new User("devtest", "123123");
        users.addUser(nowUser);

        String addInput = "/CS2113 /Mon /0900-1200 /NUS";
        Command addCommand = new AddCommand(addInput);
        addCommand.execute(users, ui, nowUser);

        String editDay = "/mon";
        String editTime = "/1 0900-1100";

        assertThrows(IncorrectCommandFormatException.class, () -> {
            EditCommand editCommand = new EditCommand(editDay);
            InputStream in = new ByteArrayInputStream(editTime.getBytes());
            System.setIn(in);
            editCommand.execute(users, ui, nowUser);
        });
    }

    @Test
    void execute_indexSlashInWrongPos_expectIncorrectCommandFormatException() throws WhereGotTimeException {
        UserList users = new UserList();
        Ui ui = new Ui();
        User nowUser = new User("devtest", "123123");
        users.addUser(nowUser);

        String addInput = "/CS2113 /Mon /0900-1200 /NUS";
        Command addCommand = new AddCommand(addInput);
        addCommand.execute(users, ui, nowUser);

        String editDay = "/mon";
        String editTime = "1/ /0900-1100";

        assertThrows(IncorrectCommandFormatException.class, () -> {
            EditCommand editCommand = new EditCommand(editDay);
            InputStream in = new ByteArrayInputStream(editTime.getBytes());
            System.setIn(in);
            editCommand.execute(users, ui, nowUser);
        });
    }

    @Test
    void execute_indexWithoutSlash_expectIncorrectCommandFormatException() throws WhereGotTimeException {
        UserList users = new UserList();
        Ui ui = new Ui();
        User nowUser = new User("devtest", "123123");
        users.addUser(nowUser);

        String addInput = "/CS2113 /Mon /0900-1200 /NUS";
        Command addCommand = new AddCommand(addInput);
        addCommand.execute(users, ui, nowUser);

        String editDay = "/mon";
        String editTime = "1 /0900-1100";

        assertThrows(IncorrectCommandFormatException.class, () -> {
            EditCommand editCommand = new EditCommand(editDay);
            InputStream in = new ByteArrayInputStream(editTime.getBytes());
            System.setIn(in);
            editCommand.execute(users, ui, nowUser);
        });
    }

    @Test
    void execute_indexWithMultipleSlashes_expectIncorrectCommandFormatException() throws WhereGotTimeException {
        UserList users = new UserList();
        Ui ui = new Ui();
        User nowUser = new User("devtest", "123123");
        users.addUser(nowUser);

        String addInput = "/CS2113 /Mon /0900-1200 /NUS";
        Command addCommand = new AddCommand(addInput);
        addCommand.execute(users, ui, nowUser);

        String editDay = "/mon";
        String editTime = "//1 /0900-1100";

        assertThrows(IncorrectCommandFormatException.class, () -> {
            EditCommand editCommand = new EditCommand(editDay);
            InputStream in = new ByteArrayInputStream(editTime.getBytes());
            System.setIn(in);
            editCommand.execute(users, ui, nowUser);
        });
    }

    @Test
    void execute_indexOutOfBound_expectInvalidIndexException() throws WhereGotTimeException {
        UserList users = new UserList();
        Ui ui = new Ui();
        User nowUser = new User("devtest", "123123");
        users.addUser(nowUser);

        String addInput = "/CS2113 /Mon /0900-1200 /NUS";
        Command addCommand = new AddCommand(addInput);
        addCommand.execute(users, ui, nowUser);

        String editDay = "/mon";
        String editTime = "/2 /0900-1100";

        assertThrows(InvalidIndexException.class, () -> {
            EditCommand editCommand = new EditCommand(editDay);
            InputStream in = new ByteArrayInputStream(editTime.getBytes());
            System.setIn(in);
            editCommand.execute(users, ui, nowUser);
        });
    }

    @Test
    void execute_timingIsBeyondFourDigits_expectInvalidTimingFormatException() throws WhereGotTimeException {
        UserList users = new UserList();
        Ui ui = new Ui();
        User nowUser = new User("devtest", "123123");
        users.addUser(nowUser);

        String addInput = "/CS2113 /Mon /0900-1200 /NUS";
        Command addCommand = new AddCommand(addInput);
        addCommand.execute(users, ui, nowUser);

        String editDay = "/mon";
        String editTime = "/2 /090000-110000";

        assertThrows(InvalidTimingFormatException.class, () -> {
            EditCommand editCommand = new EditCommand(editDay);
            InputStream in = new ByteArrayInputStream(editTime.getBytes());
            System.setIn(in);
            editCommand.execute(users, ui, nowUser);
        });
    }

    @Test
    void execute_startHourIsGreaterThan23_expectInvalidTimingFormatException() throws WhereGotTimeException {
        UserList users = new UserList();
        Ui ui = new Ui();
        User nowUser = new User("devtest", "123123");
        users.addUser(nowUser);

        String addInput = "/CS2113 /Mon /0900-1200 /NUS";
        Command addCommand = new AddCommand(addInput);
        addCommand.execute(users, ui, nowUser);

        String editDay = "/mon";
        String editTime = "/1 /2600-1300";

        assertThrows(InvalidTimingFormatException.class, () -> {
            EditCommand editCommand = new EditCommand(editDay);
            InputStream in = new ByteArrayInputStream(editTime.getBytes());
            System.setIn(in);
            editCommand.execute(users, ui, nowUser);
        });
    }

    @Test
    void execute_startMinuteIsGreaterThan59_expectInvalidTimingFormatException() throws WhereGotTimeException {
        UserList users = new UserList();
        Ui ui = new Ui();
        User nowUser = new User("devtest", "123123");
        users.addUser(nowUser);

        String addInput = "/CS2113 /Mon /0900-1200 /NUS";
        Command addCommand = new AddCommand(addInput);
        addCommand.execute(users, ui, nowUser);

        String editDay = "/mon";
        String editTime = "/1 /0899-1300";

        assertThrows(InvalidTimingFormatException.class, () -> {
            EditCommand editCommand = new EditCommand(editDay);
            InputStream in = new ByteArrayInputStream(editTime.getBytes());
            System.setIn(in);
            editCommand.execute(users, ui, nowUser);
        });
    }

    @Test
    void execute_endHourIsGreaterThan23_expectInvalidTimingFormatException() throws WhereGotTimeException {
        UserList users = new UserList();
        Ui ui = new Ui();
        User nowUser = new User("devtest", "123123");
        users.addUser(nowUser);

        String addInput = "/CS2113 /Mon /0900-1200 /NUS";
        Command addCommand = new AddCommand(addInput);
        addCommand.execute(users, ui, nowUser);

        String editDay = "/mon";
        String editTime = "/1 /0800-7800";

        assertThrows(InvalidTimingFormatException.class, () -> {
            EditCommand editCommand = new EditCommand(editDay);
            InputStream in = new ByteArrayInputStream(editTime.getBytes());
            System.setIn(in);
            editCommand.execute(users, ui, nowUser);
        });
    }

    @Test
    void execute_endMinuteIsGreaterThan59_expectInvalidTimingFormatException() throws WhereGotTimeException {
        UserList users = new UserList();
        Ui ui = new Ui();
        User nowUser = new User("devtest", "123123");
        users.addUser(nowUser);

        String addInput = "/CS2113 /Mon /0900-1200 /NUS";
        Command addCommand = new AddCommand(addInput);
        addCommand.execute(users, ui, nowUser);

        String editDay = "/mon";
        String editTime = "/1 /0800-1261";

        assertThrows(InvalidTimingFormatException.class, () -> {
            EditCommand editCommand = new EditCommand(editDay);
            InputStream in = new ByteArrayInputStream(editTime.getBytes());
            System.setIn(in);
            editCommand.execute(users, ui, nowUser);
        });
    }

    @Test
    void execute_timingIsNotInOneHourBlock_expectInvalidTimingFormatException() throws WhereGotTimeException {
        UserList users = new UserList();
        Ui ui = new Ui();
        User nowUser = new User("devtest", "123123");
        users.addUser(nowUser);

        String addInput = "/CS2113 /Mon /0900-1200 /NUS";
        Command addCommand = new AddCommand(addInput);
        addCommand.execute(users, ui, nowUser);

        String editDay = "/mon";
        String editTime = "/1 /0830-1223";

        assertThrows(InvalidTimingFormatException.class, () -> {
            EditCommand editCommand = new EditCommand(editDay);
            InputStream in = new ByteArrayInputStream(editTime.getBytes());
            System.setIn(in);
            editCommand.execute(users, ui, nowUser);
        });
    }

    @Test
    void execute_identicalStartAndEndTimings_expectIllogicalTimingException() throws WhereGotTimeException {
        UserList users = new UserList();
        Ui ui = new Ui();
        User nowUser = new User("devtest", "123123");
        users.addUser(nowUser);

        String addInput = "/CS2113 /Mon /0900-1200 /NUS";
        Command addCommand = new AddCommand(addInput);
        addCommand.execute(users, ui, nowUser);

        String editDay = "/mon";
        String editTime = "/1 /0800-0800";

        assertThrows(IllogicalTimingException.class, () -> {
            EditCommand editCommand = new EditCommand(editDay);
            InputStream in = new ByteArrayInputStream(editTime.getBytes());
            System.setIn(in);
            editCommand.execute(users, ui, nowUser);
        });
    }

    @Test
    void execute_startTimeIsLaterThanEndTime_expectIllogicalTimingException() throws WhereGotTimeException {
        UserList users = new UserList();
        Ui ui = new Ui();
        User nowUser = new User("devtest", "123123");
        users.addUser(nowUser);

        String addInput = "/CS2113 /Mon /0900-1200 /NUS";
        Command addCommand = new AddCommand(addInput);
        addCommand.execute(users, ui, nowUser);

        String editDay = "/mon";
        String editTime = "/1 /1000-0800";

        assertThrows(IllogicalTimingException.class, () -> {
            EditCommand editCommand = new EditCommand(editDay);
            InputStream in = new ByteArrayInputStream(editTime.getBytes());
            System.setIn(in);
            editCommand.execute(users, ui, nowUser);
        });
    }
    
    @Test
    void execute_normalEdit() throws WhereGotTimeException {

        UserList users = new UserList();
        Ui ui = new Ui();
        User nowUser = new User("devtest", "123123");
        users.addUser(nowUser);

        String addInput = "/CS2113 /Mon /0900-1200 /NUS";
        Command addCommand = new AddCommand(addInput);
        addCommand.execute(users, ui, nowUser);

        String editDay = "/mon";
        String editTime = "/1 /0900-1300";

        EditCommand editCommand = new EditCommand(editDay);
        InputStream in = new ByteArrayInputStream(editTime.getBytes());
        System.setIn(in);

        editCommand.execute(users, ui, nowUser);

        System.setOut(new PrintStream(outContent));

        StringWriter expectedStringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(expectedStringWriter);
        
        printWriter.println("Got it! I've added the following event on mon");
        printWriter.println("CS2113 NUS 0900-1200");
        printWriter.println("Hey devtest, here are the lessons in your mon timetable, sorted from the earliest class.");
        printWriter.println("    1. CS2113 NUS 0900-1200");
        printWriter.println();
        printWriter.println("To edit, enter:");
        printWriter.println("/(index) /(newStartTime-newEndTime)");
        printWriter.println("____________________________________________________________");
        printWriter.println("Got it! I have edited the lesson as follows:");
        printWriter.println("ORIGINAL    : CS2113 NUS 0900-1200");
        printWriter.println("EDITED      : CS2113 NUS 0900-1300");
        printWriter.close();
        String expected = expectedStringWriter.toString();
        
        assertEquals(expected, outContent.toString());
    }

    /*@Test
    void execute_advancedEdit() throws WhereGotTimeException {

        UserList users = new UserList();
        Ui ui = new Ui();
        User nowUser = new User("devtest", "123123");
        users.addUser(nowUser);

        String addLessonOne = "/CS2113 /Mon /0900-1200 /NUS";
        String addLessonTwo = "/CS2040C /Mon /1300-1500 /LT34";
        String addLessonThree = "/CS3230 /Mon /1600-1800 /COM1";
        Command addCommandOne = new AddCommand(addLessonOne);
        Command addCommandTwo = new AddCommand(addLessonTwo);
        Command addCommandThree = new AddCommand(addLessonThree);
        addCommandOne.execute(users, ui, nowUser);
        addCommandTwo.execute(users, ui, nowUser);
        addCommandThree.execute(users, ui, nowUser);
        
        String editDay = "/mon";
        String editTime = "/2 /1300-1600";

        EditCommand editCommand = new EditCommand(editDay);
        InputStream in = new ByteArrayInputStream(editTime.getBytes());
        System.setIn(in);

        editCommand.execute(users, ui, nowUser);

        System.setOut(new PrintStream(outContent));

        assertEquals("Got it! I've added the following event on mon\n"
                        + "CS2113 NUS 0900-1200\n"
                        + "Got it! I've added the following event on mon\n"
                        + "CS2040C LT34 1300-1500\n"
                        + "Got it! I've added the following event on mon\n"
                        + "CS3230 COM1 1600-1800\n"
                        + "Hey devtest, here are the lessons in your mon timetable, sorted from the "
                        + "earliest class.\n"
                        + "    1. CS2113 NUS 0900-1200\n"
                        + "    2. CS2040C LT34 1300-1500\n"
                        + "    3. CS3230 COM1 1600-1800\n\n"
                        + "To edit, enter:\n"
                        + "/(index) /(newStartTime-newEndTime)\n"
                        + "____________________________________________________________\n"
                        + "Got it! I have edited the lesson as follows:\n"
                        + "ORIGINAL    : CS2040C LT34 1300-1500\n"
                        + "EDITED      : CS2040C LT34 1300-1600\n",

                outContent.toString());
    }

    @Test
    void execute_noClassToEdit() throws WhereGotTimeException {

        UserList users = new UserList();
        Ui ui = new Ui();
        User nowUser = new User("devtest", "123123");
        users.addUser(nowUser);

        String addInput = "/CS2113 /Mon /0900-1200 /NUS";
        Command addCommand = new AddCommand(addInput);
        addCommand.execute(users, ui, nowUser);

        String editDay = "/fri";
        String editTime = "/1 /0900-1300";

        EditCommand editCommand = new EditCommand(editDay);
        InputStream in = new ByteArrayInputStream(editTime.getBytes());
        System.setIn(in);

        editCommand.execute(users, ui, nowUser);

        System.setOut(new PrintStream(outContent));

        assertEquals("Got it! I've added the following event on mon\n"
                        + "CS2113 NUS 0900-1200\n"
                        + "Hey devtest, there is no class in your fri timetable!\n",

                outContent.toString());
    }*/
    
    /*    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }*/

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }
    

}
