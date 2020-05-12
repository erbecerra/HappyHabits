package controllers;

import entity.Goal;
import entity.GoalType;
import entity.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import persistence.GenericDao;
import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(
        urlPatterns = {"/updateGoal"}
)
public class UpdateGoal extends HttpServlet {

    private final Logger logger = LogManager.getLogger(this.getClass());
    private GenericDao goalDao = new GenericDao(Goal.class);
    private GenericDao userDao = new GenericDao(User.class);
    private User user;
    private int goalId;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        try {
            goalId = Integer.parseInt(req.getParameter("goalId"));
            RequestDispatcher dispatcher = req.getRequestDispatcher("/editGoal.jsp");
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
            Goal goal = (Goal)goalDao.getById(goalId);
            goal.setGoalName(req.getParameter("title"));
            goal.setGoalType(GoalType.valueOf(req.getParameter("frequency")));
            goalDao.saveOrUpdate(goal);
            res.sendRedirect("goals");
        } catch (Exception ex) {
            logger.error(ex);
            res.setStatus(500);
            res.sendRedirect("/HappyHabits/error.jsp");
        }
    }


}