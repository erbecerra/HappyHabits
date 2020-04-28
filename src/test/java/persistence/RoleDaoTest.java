package persistence;

import entity.Role;
import entity.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class RoleDaoTest {

    GenericDao roleDao;
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

        roleDao = new GenericDao(Role.class);
        userDao = new GenericDao(User.class);
    }

    /**
     * Verify successful retrieval of a role
     */
    @Test
    void getRoleIdSuccess() {
        Role role = (Role)roleDao.getById(2);
        assertEquals("registered", role.getRoleName());
    }

    /**
     * Verify successful retrieval of a role by user id
     */
    @Test
    void getRoleByUserIdSuccess() {
        List<Role> roles = roleDao.getAllByEntityID("user", 2);
        assertEquals(1, roles.size());
        assertEquals("registered", roles.get(0).getRoleName());
    }

    /**
     * Verify successful insert of a role
     */
    @Test
    void insertRoleSuccess() {
        User user = (User)userDao.getById(3);
        Role role = new Role(user,"admin", user.getUserName());
        int id = roleDao.insert(role);
        List<Role> roles = roleDao.getAllByEntityID("user", 3);

        assertNotNull(id);
        assertEquals(1, roles.size());
    }

    /**
     * Verify successful deletion of a role
     */
    @Test
    void DeleteRoleSuccess() {
        roleDao.delete(roleDao.getById(1));
        assertNull(roleDao.getById(1));
    }
}
