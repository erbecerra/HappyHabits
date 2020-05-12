package controllers;

import entity.Goal;
import entity.Log;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import persistence.GenericDao;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(
        urlPatterns = {"/delete"}
)
public class Delete extends HttpServlet {

    private final Logger logger = LogManager.getLogger(this.getClass());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        try {
            String entityType = req.getParameter("entity");
            int id = Integer.parseInt(req.getParameter("id"));
            //check that this goal actually belongs to the logged in user
            if (entityType.equals("goal")) {
                GenericDao goalDao = new GenericDao(Goal.class);
                goalDao.delete(goalDao.getById(id));
                res.sendRedirect("goals");

            } else if (entityType.equals("log")) {
                GenericDao logDao = new GenericDao(Log.class);
                Log log = (Log)logDao.getById(id);
                int goalId = log.getGoal().getId();
                logDao.delete(log);
                res.sendRedirect("details?goalid=" + goalId);

            } else {
                logger.info("Invalid entity properties used");
                res.setStatus(404);
                res.sendRedirect("/HappyHabits/pageNotFoundError.jsp");
            }

        } catch (Exception ex) {
            logger.error(ex);
            res.setStatus(500);
            res.sendRedirect("/HappyHabits/error.jsp");
        }
    }
}