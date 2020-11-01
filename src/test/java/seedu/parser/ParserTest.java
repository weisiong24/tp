package seedu.parser;

import org.junit.jupiter.api.Test;
import seedu.command.Command;
import seedu.command.AddCommand;
import seedu.command.ByeCommand;
import seedu.command.CompareCommand;
import seedu.command.ClearCommand;
import seedu.command.DeleteCommand;
import seedu.command.EditCommand;
import seedu.command.FindCommand;
import seedu.command.ListCommand;
import seedu.command.LogInCommand;
import seedu.exception.DukeException;

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
        final String input = "add /CS2113 Lecture /fri /1600-1800 /LT15";
        parseAndAssertCommandType(input, AddCommand.class);
    }

    @Test
    public void parse_byeCommand_parsedCorrectly() throws DukeException {
        final String input = "bye";
        parseAndAssertCommandType(input, ByeCommand.class);
    }

    @Test
    public void parse_clearCommand_parsedCorrectly() throws DukeException {
        final String input = "clear /sun";
        parseAndAssertCommandType(input, ClearCommand.class);
    }

    @Test
    public void parse_compareCommand_parsedCorrectly() throws DukeException {
        final String input = "compare /Alex /mon";
        parseAndAssertCommandType(input, CompareCommand.class);
    }

    @Test
    public void parse_deleteCommand_parsedCorrectly() throws DukeException {
        final String input = "delete /tue /2";
        parseAndAssertCommandType(input, DeleteCommand.class);
    }

    @Test
    public void parse_editCommand_parsedCorrectly() throws DukeException {
        final String input = "edit /mon /2 /1000-1200";
        parseAndAssertCommandType(input, EditCommand.class);
    }

    @Test
    public void parse_findCommand_parsedCorrectly() throws DukeException {
        final String input = "find /CS2113";
        parseAndAssertCommandType(input, FindCommand.class);
    }

    @Test
    public void parse_listCommand_parsedCorrectly() throws DukeException {
        final String input = "list /all";
        parseAndAssertCommandType(input, ListCommand.class);
    }

    @Test
    public void parse_loginCommand_parsedCorrectly() throws DukeException {
        final String input = "login John /132456";
        parseAndAssertCommandType(input, LogInCommand.class);
    }

    /**
     * Parses input and asserts the class/type of the returned command object.
     *
     * @param input to be parsed
     * @param expectedCommandClass expected class of returned command
     */
    private <T extends Command> void parseAndAssertCommandType(String input, Class<T> expectedCommandClass)
            throws DukeException {
        final Command result = Parser.parse(input);
        assertTrue(result.getClass().isAssignableFrom(expectedCommandClass));
    }
}