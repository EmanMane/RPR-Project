package ba.unsa.etf.rpr.business;

import ba.unsa.etf.rpr.dao.UserDaoSQLImpl;
import ba.unsa.etf.rpr.domain.User;
import ba.unsa.etf.rpr.exceptions.AnimalException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserManagerTest {

    private UserManager userManager;
    private User user;
    private UserDaoSQLImpl userDaoSQLMock;
    private List<User> users;

    /**
     * This method will be called before each test method
     */
    @BeforeEach
    public void initializeObjectsWeNeed() {
        userManager = Mockito.mock(UserManager.class);
        user = new User();
        user.setUsername("User1");
        user.setId(50);

        userDaoSQLMock = Mockito.mock(UserDaoSQLImpl.class);
        users = new ArrayList<>();
        users.addAll(Arrays.asList(new User("User1","x"), new User("User2","y"), new User("User3","z"), new User("User4","p")));
    }

    @Test
    void test1() {
        String correctName = "User1";
        String correctPass = "x";
        try {
            Mockito.doCallRealMethod().when(userManager).validateUser(correctName,correctPass);
        } catch (AnimalException e) {
            //Test will fall if method validateUser(username,password) throws an exception for correct parameter
            e.printStackTrace();
            Assertions.assertTrue(false);
        }
    }
}