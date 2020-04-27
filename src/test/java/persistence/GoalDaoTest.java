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
        util.Database database = util.Database.getInstance();
        database.runSQL("cleandb.sql");
        dao = new GenericDao(Goal.class);
    }

    /**
     * Verify successful retrieval of a user

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
        assertEquals(6, goals.size());
    }

    @Test
    void getAllByUserID() {
        List<Goal> goals = dao.getAllByEntityID("user", 1);
        assertEquals(2, goals.size());
    }


    /**
     * Verify successful delete of goal
     */
    @Test
    void deleteSuccess() {
        dao.delete(dao.getById(6));
        assertNull(dao.getById(6));
    }

}
