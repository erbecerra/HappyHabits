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

@WebServlet(
        urlPatterns = {"/details"}
)
public class Details extends HttpServlet {

    private final Logger logger = LogManager.getLogger(this.getClass());
    private GenericDao goalDao = new GenericDao(Goal.class);
    private GenericDao userDao = new GenericDao(User.class);
    private GenericDao pokeDao = new GenericDao(Pokemon.class);
    private GenericDao logDao = new GenericDao(Log.class);
    private User user;
    private Goal goal;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        try {
            String login = req.getRemoteUser();
            user = (User)userDao.getByPropertyEqual("userName", login).get(0);
            int goalId = Integer.parseInt(req.getParameter("goalid"));
            goal = (Goal)goalDao.getById(goalId);
            req.setAttribute("goal", goal);
            req.setAttribute("pokemon", pokeDao.getById(goal.getPokemon().getId()));
            req.setAttribute("logs", logDao.getAllByEntityID("goal", goalId));
            RequestDispatcher dispatcher = req.getRequestDispatcher("details.jsp");
            logger.info("got to the goals");
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
            String completed = req.getParameter("completed");
            boolean success;
            if (completed.equals("true")) {
                success = true;
            } else {
                success = false;
            }
            Log log = new Log(goal, LocalDate.now(), success);
            logDao.insert(log);

            List<Log> logs = logDao.getAllByEntityIDWithCondition("goal", goal.getId(), "success", true);
            if (goal.getGoalType() == GoalType.DAILY && logs.size() >= 5) {
                goal.setDisplayPokemon(true);
                logger.info("in daily");
                logger.debug(logs);
            } else if (goal.getGoalType() == GoalType.WEEKLY && logs.size() >= 4) {
                goal.setDisplayPokemon(true);
                logger.info("in weekly");
            } else if (goal.getGoalType() == GoalType.MONTHLY && logs.size() >= 3) {
                goal.setDisplayPokemon(true);
                logger.info("in weekly");
            }
            goalDao.saveOrUpdate(goal);
            res.sendRedirect("details?goalid=" + goal.getId());
        } catch (Exception ex) {
            logger.error(ex);
            res.setStatus(500);
            res.sendRedirect("/HappyHabits/error.jsp");
        }
    }
}
