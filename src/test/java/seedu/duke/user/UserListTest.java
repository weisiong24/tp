package seedu.duke.user;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UserListTest {
    
    @Test
    void testAddUser() {
        UserList users = new UserList();
        User user = new User("man","123");
        
        users.addUser(user);
        assertEquals(1, users.getTotalUserCount());
    }
}