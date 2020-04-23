package persistence;

import entity.Goal;
import entity.Role;
import entity.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class GoalDaoTest {

    GenericDao dao;
    /**
     * Run set up tasks before each test:
     * 1. execute sql which deletes everything from the table and inserts records)
     * 2. Create any objects needed in the tests
     */
    @BeforeEach
    void setUp() {

       // util.Database database = util.Database.getInstance();
       // database.runSQL("cleandb.sql");

        dao = new GenericDao(Goal.class);
    }

    /**
     * Verify successful retrieval of a user
     */
    @Test
    void getByIdSuccess() {
        Goal retrievedGoal = (Goal)dao.getById(1);
    }

    /**
     * Verify successful retrieval of a user
     */
    @Test
    void getAll() {
        List<Goal> goals = dao.getAll();
       // assertEquals(2, goals.size());
    }

    @Test
    void getAllByUserID() {
        List<Goal> goals = dao.getAllByEntityID("user", 8);
        // assertEquals(2, goals.size());
    }

    /**
     * Verify successful insert of a user
     */
    @Test
    void insertSuccess() {
        GenericDao userDao = new GenericDao(User.class);
        User user = (User)userDao.getById(6);

        Goal goal = new Goal(user, "Goal Dao Test", LocalDate.parse("2020-05-30"));
        user.addGoal(goal);
        int id = dao.insert(goal);

        assertNotEquals(0,id);
        Goal insertedGoal = (Goal)dao.getById(id);
        assertNotNull(insertedGoal);
    }

    /**
     * Verify successful insert of a user
     */
    @Test
    void insertWithRoleSuccess() {

        String userName = "fflintstone";
        User newUser = new User("Fred", "Flintstone", userName, LocalDate.parse("1168-01-01"));

        String roleName = "admin";
        Role role = new Role(newUser,roleName, userName);

        newUser.addRole(role);

        int id = dao.insert(newUser);

        assertNotEquals(0,id);
        User insertedUser = (User)dao.getById(id);
        assertEquals(newUser, insertedUser);
        assertEquals(1, insertedUser.getRoles().size());
    }

    /**
     * Verify successful delete of user
     */
    @Test
    void deleteSuccess() {
        dao.delete(dao.getById(3));
        assertNull(dao.getById(3));
    }

}
