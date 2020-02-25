package persistence;

import entity.UserRoles;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class UserRolesDao {

    private final Logger logger = LogManager.getLogger(this.getClass());
    SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();

    /**
     * Get all Users
     * @return all users
     */
    public List<UserRoles> getAll() {
        Session session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<UserRoles> query = builder.createQuery(UserRoles.class);
        Root<UserRoles> root = query.from(UserRoles.class);
        List<UserRoles> roles = session.createQuery(query).getResultList();
        session.close();
        return roles;
    }

    /**
     * Get user role by id
     */
    public UserRoles getById(int id) {
        Session session = sessionFactory.openSession();
        UserRoles userRoles = session.get( UserRoles.class, id );
        session.close();
        return userRoles;
    }

    /**
     * update user role
     * @param userRoles  UserRoles to be updated
     */
    public void saveOrUpdate(UserRoles userRoles) {
        Session session = sessionFactory.openSession();
        session.saveOrUpdate(userRoles);
        session.close();
    }

    /**
     * insert user role
     * @param userRoles  UserRoles to be inserted
     */
    public int insert(UserRoles userRoles) {
        int id = 0;
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        id = (int)session.save(userRoles);
        transaction.commit();
        session.close();
        return id;
    }

    /**
     * Delete a user role
     * @param userRoles UserRoles to be deleted
     */
    public void delete(UserRoles userRoles) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(userRoles);
        transaction.commit();
        session.close();
    }


}
