package persistence;

import entity.Goal;
import entity.GoalType;
import entity.Pokemon;
import entity.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class GoalDaoTest {

    GenericDao goalDao;
    GenericDao userDao;
    /**
     * Run set up tasks before each test:
     * 1. execute sql which deletes everything from the table and inserts records)
     * 2. Create any objects needed in the tests
     */
    @BeforeEach
    void setUp() {
        util.Database database = util.Database.getInstance();
        database.runSQL("cleandb.sql");
         goalDao = new GenericDao(Goal.class);
         userDao = new GenericDao(User.class);
    }

    /**
     * Verify successful retrieval of a goal
    */
    @Test
    void getGoalByIdSuccess() {
        Goal goal = (Goal)goalDao.getById(1);
        assertNotNull(goal);
        assertEquals("Test 1", goal.getGoalName());
    }

    /**
     * Verify null goal when does not exist in database
     */
    @Test
    void getGoalByIdFail() {
        Goal goal = (Goal)goalDao.getById(10);
        assertNull(goal);
    }

    /**
     * Verify successful retrieval of all goals
     */
    @Test
    void getAllGoalsSuccess() {
        List<Goal> goals = goalDao.getAll();
        assertEquals(6, goals.size());
    }

    /**
     * Verify successful retrieval of all goals by user ID
     */
    @Test
    void getGoalsByUserID() {
        List<Goal> goals = goalDao.getAllByEntityID("user", 1);
        assertEquals(2, goals.size());
        assertEquals("Test 5", goals.get(0).getGoalName());
        assertEquals("Test 6", goals.get(1).getGoalName());
    }

    /**
     * Verify successful insert of a goal
     */
    @Test
    void insertGoalSuccess() {
        User user = (User)userDao.getById(3);

        Goal goal = new Goal(user,"Insert Unit Test", GoalType.MONTHLY);
        Pokemon pokemon = new Pokemon("pikachu", "electric", user, goal);
        goal.setPokemon(pokemon);
        int id = goalDao.insert(goal);
        List<Goal> goals = goalDao.getAllByEntityID("user", 3);

        assertNotNull(id);
        assertEquals(4, goals.size());
    }

    /**
     * Verify successful insert of a goal
     */
    @Test
    void saveOrUpdateGoalSuccess() {
        User user = (User)userDao.getById(3);
        Goal goal = new Goal(user,"Insert Unit Test", GoalType.MONTHLY);
        Pokemon pokemon = new Pokemon("pikachu", "electric", user, goal);
        goal.setPokemon(pokemon);
        goalDao.saveOrUpdate(goal);
        List<Goal> goals = goalDao.getAllByEntityID("user", 3);
        assertEquals(4, goals.size());
    }

    /**
     * Verify successful delete of goal
     */
    @Test
    void deleteGoalSuccess() {
        goalDao.delete(goalDao.getById(6));
        assertNull(goalDao.getById(6));
    }

}
