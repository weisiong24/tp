package seedu.user;

import seedu.exception.DukeException;

import java.util.ArrayList;

public class UserList {

    public static final int MAX_SIZE = 100;
    private final ArrayList<User> users;

    public UserList() {
        this.users = new ArrayList<>(MAX_SIZE);
    }

    public UserList(ArrayList<User> users) {
        this.users = new ArrayList<>(users);
    }

    public void addUser(User user) {
        users.add(user);
    }
    
    public ArrayList<User> getUserList() {
        return users;
    }

    public User getUser(int index) throws DukeException {
        try {
            return users.get(index - 1);
        } catch (IndexOutOfBoundsException e) {
            throw new DukeException("Invalid user number!");
        }
    }

    public int getTotalUserCount() {
        return users.size();
    }

    public User getUserByName(String userName) {
        for (User user : this.users) {
            if (user.getName().equals(userName)) {
                return user;
            }
        }
        return null;
    }
    
}
