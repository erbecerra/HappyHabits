package controllers;

import entity.Goal;
import entity.GoalType;
import entity.Role;
import entity.User;
import persistence.GenericDao;
import persistence.PokeDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;

@WebServlet(
        urlPatterns = {"/signUp"}
)
public class SignUp extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("/signUp.jsp");
        dispatcher.forward(req, resp);
    }


    /**
     * Creates a user
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        GenericDao userDao = new GenericDao(User.class);

        String firstName = req.getParameter("first_name");
        String lastName = req.getParameter("last_name");
        String username = req.getParameter("username");
        String dob = req.getParameter("date_of_birth");
        String password = req.getParameter("password");
        String confirmPassword = req.getParameter("password");

        if (password == confirmPassword) {
            User user = new User(firstName, lastName, username, LocalDate.parse(dob), password);
            Role role = new Role(user, "registered", username);
            user.addRole(role);
            userDao.insert(user);
        }
        RequestDispatcher dispatcher = req.getRequestDispatcher("/profile");
        dispatcher.forward(req, resp);
    }
}
