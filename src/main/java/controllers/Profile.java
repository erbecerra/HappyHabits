package controllers;

import entity.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import persistence.GenericDao;
import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

/**
 * A servlet that will pull up user profile
 * @author ebecerra
 */

@WebServlet(
        urlPatterns = {"/profile"}
)
public class Profile extends HttpServlet {

    private final Logger logger = LogManager.getLogger(this.getClass());
    private GenericDao userDao = new GenericDao(User.class);
    private GenericDao roleDao = new GenericDao(Role.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        try {
            String login = req.getRemoteUser();
            req.setAttribute("user", userDao.getByPropertyEqual("userName", login));
            RequestDispatcher dispatcher = req.getRequestDispatcher("/profile.jsp");
            dispatcher.forward(req, res);
        } catch (Exception ex) {
            logger.error(ex);
            res.setStatus(500);
            res.sendRedirect("/HappyHabits/error.jsp");
        }
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
        try {
            String login = req.getRemoteUser();
            List<User> users = userDao.getByPropertyEqual("userName", login);
            User user = users.get(0);
            user.setFirstName(req.getParameter("first_name"));
            user.setLastName(req.getParameter("last_name"));
            user.setDateOfBirth(LocalDate.parse(req.getParameter("date_of_birth")));
            userDao.saveOrUpdate(user);
            res.sendRedirect("profile");
        } catch (Exception ex) {
            logger.error(ex);
            res.setStatus(500);
            res.sendRedirect("/HappyHabits/error.jsp");
        }
    }
}
