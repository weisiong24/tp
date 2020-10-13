package seedu.duke.command;

import seedu.duke.exception.DukeException;
//import seedu.duke.storage.Storage;
//import seedu.duke.task.Event;
//import seedu.duke.task.TaskList;
import seedu.duke.ui.Ui;
import seedu.duke.user.User;
import seedu.duke.user.UserList;

/**
 * Adds an event to the task list.
 */
public class LogInCommand extends Command {

    public LogInCommand(String input) {
        super(input);
    }

    @Override
    public void execute(UserList users, Ui ui, User nowUser/*, Storage storage*/) throws DukeException {
        boolean doesExist = false;
        
        String[] parsedInputs = input.split(" /", 2);
        for (int i = 1; i<users.getTotalUserCount(); i++) {
            if (parsedInputs[0].equals((users.getUser(i)).getName())) {
                if (parsedInputs[1].equals((users.getUser(i)).getPassWord())) {
                    currentUser = users.getUser(i);
                    //System.out.println(parsedInputs[0] + " == " + (users.getUser(i)).getName());
                    doesExist = true;
                } else {
                    throw new DukeException("Wrong Password");
                }
            }
        } 
        
        if (doesExist == false){
            //System.out.println("User: " + parsedInputs[0] + " does not exist!");
            User newUser = new User(parsedInputs[0], parsedInputs[1]);
            currentUser = newUser;
            users.addUser(newUser);
        }
        ui.greetUser(currentUser);
        isLogIn = true;


        //storage.write(tasks);
    }
}
