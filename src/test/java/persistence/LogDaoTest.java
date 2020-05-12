package persistence;

import entity.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class LogDaoTest {
    GenericDao logDao;
    GenericDao goalDao;
    /**
     * Run set up tasks before each test:
     * 1. execute sql which deletes everything from the table and inserts records)
     * 2. Create any objects needed in the tests
     */
    @BeforeEach
    void setUp() {
        util.Database database = util.Database.getInstance();
        database.runSQL("cleandb.sql");
        logDao = new GenericDao(Log.class);
        goalDao = new GenericDao(Goal.class);
    }

    /**
     * Verify successful retrieval of a goal
     */
    @Test
    void getLogByIdSuccess() {
        Log log = (Log)logDao.getById(1);
        assertNotNull(log);
        assertFalse(log.isSuccess());
    }

    /**
     * Verify null goal when does not exist in database
     */
    @Test
    void getLogByIdFail() {
        Log log = (Log)logDao.getById(10);
        assertNull(log);
    }

    /**
     * Verify successful retrieval of all goals
     */
    @Test
    void getAllLogsSuccess() {
        List<Log> logs = logDao.getAll();
        assertEquals(3, logs.size());
    }

    /**
     * Verify successful retrieval of all goals by user ID
     */
    @Test
    void getLogsByUserID() {
        List<Log> logs = logDao.getAllByEntityID("goal", 1);
        assertEquals(2, logs.size());
        assertFalse(logs.get(0).isSuccess());
        assertFalse(logs.get(1).isSuccess());
    }

    /**
     * Verify successful retrieval of all goals by user ID
     */
    @Test
    void getLogsByGoalID() {
        List<Log> logs = logDao.getAllByEntityID("goal", 1);
        assertEquals(2, logs.size());
        assertFalse(logs.get(0).isSuccess());
        assertFalse(logs.get(1).isSuccess());
    }

    /**
     * Verify successful retrieval of all goals by user ID
     */
    @Test
    void getLogsByGoalIDWithCondition() {

        List<Log> logs = logDao.getAllByEntityIDWithCondition("goal", 1, "success", false);
        assertEquals(2, logs.size());
    }




    /**
     * Verify successful insert of a goal
    */
    @Test
    void insertLogSuccess() {
        Goal goal = (Goal)goalDao.getById(1);
        Log log = new Log(goal, LocalDate.parse("2020-05-20"), true);
        int id = logDao.insert(log);
        List<Log> logs = logDao.getAllByEntityID("goal", 1);

        assertNotNull(id);
        assertEquals(3, logs.size());
    }

    /**
     * Verify successful insert of a goal
     */
    @Test
    void saveOrUpdateLogSuccess() {
        Log log = (Log) logDao.getById(3);
        log.setSuccess(true);
        logDao.saveOrUpdate(log);
        Log updatedLog = (Log) logDao.getById(3);
        assertTrue(updatedLog.isSuccess());
    }

    /**
     * Verify successful delete of goal
     */
    @Test
    void deleteLogSuccess() {
        logDao.delete(logDao.getById(3));
        assertNull(logDao.getById(3));
    }

}
