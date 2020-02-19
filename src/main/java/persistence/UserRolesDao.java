package persistence;

import entity.User;
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
    public User getById(int id) {
        Session session = sessionFactory.openSession();
        User user = session.get( User.class, id );
        session.close();
        return user;
    }

    /**
     * update user role
     * @param user  User to be updated
     */
    public void saveOrUpdate(User user) {
        Session session = sessionFactory.openSession();
        session.saveOrUpdate(user);
        session.close();
    }

    /**
     * insert user role
     * @param user  User to be inserted
     */
    public int insert(User user) {
        int id = 0;
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        id = (int)session.save(user);
        transaction.commit();
        session.close();
        return id;
    }

    /**
     * Delete a user role
     * @param user User to be deleted
     */
    public void delete(User user) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(user);
        transaction.commit();
        session.close();
    }


}
