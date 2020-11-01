package seedu.command;

import seedu.exception.DukeException;
import seedu.ui.Ui;
import seedu.user.User;
import seedu.user.UserList;
import seedu.task.Event;
import seedu.storage.Storage;

import java.util.ArrayList;

public class TestCommand extends Command {

    public TestCommand() {
        super(null);
    }

    String[] days = {"mon", "tue", "wed", "thu", "fri", "sat", "sun"};

    @Override
    public void execute(UserList users, Ui ui, User nowUser/*, Storage storage*/) throws DukeException {
        System.out.println(System.lineSeparator() + "Starting developer test:\n");
       
        String currentUserName = nowUser.getName();
        System.out.println("currentUserName: " + currentUserName);
        String currentUserPW = nowUser.getPassword();
        System.out.println("currentUserPW: " + currentUserPW + "\n");
        
        
        System.out.println("All user names:");
        
        for (int i = 0; i < users.getTotalUserCount(); i++) {
            System.out.println(users.getUser(i + 1).getName());
        }
        
        System.out.println("\nAdded the following devtest dummy account (ID,PW): "
                + "devtest, devpassword");

        User newUser = new User("devtest", "devpassword");
        users.addUser(newUser);
        
        System.out.println("\nPrint each user's timetable information:");
        for (User k : users.getUserList()) {
            ArrayList<ArrayList<Event>> allTimeTable = k.combineAllTimetable();
            System.out.println((k.getName() + " | " + k.getPassword()));
            printAllTimeTable(allTimeTable);
            System.out.println("###");
        }
        
        Storage s = new Storage();
        s.write(users);
        
    }

    public void printAllTimeTable(ArrayList<ArrayList<Event>> allTimeTable) {
        for (int i = 0; i < 7; i++) {
            System.out.println(days[i]);
            System.out.println(allTimeTable.get(i));
        }
    }
}
