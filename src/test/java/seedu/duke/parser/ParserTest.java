package seedu.duke.parser;

import org.junit.jupiter.api.Test;
import seedu.duke.command.Command;
import seedu.duke.command.AddCommand;
import seedu.duke.command.ClearCommand;
import seedu.duke.command.DeleteCommand;
import seedu.duke.command.ListCommand;
import seedu.duke.exception.DukeException;

//import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ParserTest {

    @Test
    public void parse_unknownCommand_throwDukeException() {
        final String input = "hello, testing";
        assertThrows(DukeException.class, () -> Parser.parse(input));
    }

    @Test
    public void parse_addCommand_parsedCorrectly() throws DukeException {
        final String input = "add CS2113 Lecture /fri /1600-1800 /LT15";
        parseAndAssertCommandType(input, AddCommand.class);
    }

    @Test
    public void parse_clearCommand_parsedCorrectly() throws DukeException {
        final String input = "clear /sun";
        parseAndAssertCommandType(input, ClearCommand.class);
    }

    @Test
    public void parse_deleteCommand_parsedCorrectly() throws DukeException {
        final String input = "delete /tue /2";
        parseAndAssertCommandType(input, DeleteCommand.class);
    }

    @Test
    public void parse_listCommand_parsedCorrectly() {
        final String input = "list /all";
        try {
            parseAndAssertCommandType(input, ListCommand.class);
        } catch (DukeException e) {
            e.printStackTrace();
        }
    }

    /**
     * Parses input and asserts the class/type of the returned command object.
     *
     * @param input to be parsed
     * @param expectedCommandClass expected class of returned command
     */
    private <T extends Command> void parseAndAssertCommandType(String input, Class<T> expectedCommandClass) throws DukeException {
        final Command result = Parser.parse(input);
        assertTrue(result.getClass().isAssignableFrom(expectedCommandClass));
    }
}