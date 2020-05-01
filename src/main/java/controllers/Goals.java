package controllers;

import entity.Goal;
import entity.GoalType;
import entity.Pokemon;
import entity.User;
import persistence.GenericDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(
        urlPatterns = {"/goals"}
)
public class Goals extends HttpServlet {

    GenericDao goalDao = new GenericDao(Goal.class);
    GenericDao userDao = new GenericDao(User.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String login = req.getRemoteUser();
        User user = (User)userDao.getByPropertyEqual("userName", login).get(0);
        req.setAttribute("goals", goalDao.getAllByEntityID("user", user.getId()));
        RequestDispatcher dispatcher = req.getRequestDispatcher("/goals.jsp");
        dispatcher.forward(req, res);
    }

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        String login = req.getRemoteUser();
        String goalTitle = req.getParameter("title");
        GoalType goalType = GoalType.valueOf(req.getParameter("frequency"));
        User user = (User)userDao.getByPropertyEqual("userName", login).get(0);
        Goal goal = new Goal(user, goalTitle, goalType);
        Pokemon pokemon = new Pokemon("pikachu", "electric", user, goal);
        goal.setPokemon(pokemon);
        goalDao.insert(goal);
        res.sendRedirect("goals");
    }
}
