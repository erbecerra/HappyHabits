package persistence;

import entity.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;


class UserDaoTest {

    GenericDao dao;
    /**
     * Run set up tasks before each test:
     * 1. execute sql which deletes everything from the table and inserts records)
     * 2. Create any objects needed in the tests
     */
    @BeforeEach
    void setUp() {

        util.Database database = util.Database.getInstance();
        database.runSQL("cleandb.sql");

        dao = new GenericDao(User.class);
    }

    /**
     * Verify successful retrieval of a user
     */
    @Test
    void getByIdSuccess() {
        User retrievedUser = (User)dao.getById(3);
        assertEquals("Barney", retrievedUser.getFirstName());
        assertEquals("Curry", retrievedUser.getLastName());
        assertEquals("bcurry", retrievedUser.getUserName());
        assertEquals(LocalDate.parse("1947-11-11"), retrievedUser.getDateOfBirth());
    }

    /**
     * Verify successful insert of a user
     */
    @Test
    void insertSuccess() {
        User newUser = new User("Fred", "Flintstone", "fflintstone", LocalDate.parse("1968-01-01"));
        int id = dao.insert(newUser);
        assertNotEquals(0,id);
        User insertedUser = (User)dao.getById(id);
        assertEquals(newUser, insertedUser);
    }

    /**
     * Verify successful insert of a user
     */
    @Test
    void insertUserWithRoleSuccess() {
        User newUser = new User("Fred", "Flintstone", "fflintstone", LocalDate.parse("1168-01-01"));
        Role role = new Role(newUser,"admin", newUser.getUserName());
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

    /**
     * Verify successful retrieval of all users
    */
    @Test
    void getAllSuccess() {
        List<User> users = dao.getAll();
        assertEquals(6, users.size());
    }

    /**
     * Verify successful retrieval of all users
    */
    @Test
    void insertUserWithGoalSuccess() {
        User newUser = new User("John", "Doe", "jdoe", LocalDate.parse("1168-01-01"));
        Goal goal = new Goal(newUser, "Unit Test Goal", GoalType.DAILY);
        Pokemon pokemon = new Pokemon("pikachu", "electric", newUser, goal);
        goal.setPokemon(pokemon);
        newUser.addGoal(goal);
        int id = dao.insert(newUser);
        User insertedUser = (User)dao.getById(id);
        assertNotNull(insertedUser);
        assertEquals(newUser, insertedUser);
        assertEquals(1, insertedUser.getGoals().size());
    }
}
