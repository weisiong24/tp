package seedu.user;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UserListTest {
    
    @Test
    void addUser_addsProperly() {
        UserList users = new UserList();
        User user = new User("man","123123");
        
        users.addUser(user);
        
        assertEquals(1, users.getTotalUserCount());
    }

    @Test
    void getUserByName_getsProperly() {
        UserList users = new UserList();
        User user = new User("man","123123");

        users.addUser(user);
        
        assertEquals("123123", (users.getUserByName("man").password));
    }
}