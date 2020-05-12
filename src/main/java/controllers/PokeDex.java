package controllers;

import entity.Pokemon;
import entity.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import persistence.GenericDao;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(
        urlPatterns = {"/pokeDex"}
)
public class PokeDex extends HttpServlet {
    private final Logger logger = LogManager.getLogger(this.getClass());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        try {

            GenericDao pokeDao = new GenericDao(Pokemon.class);
            GenericDao userDao = new GenericDao(User.class);
            String login = req.getRemoteUser();

            User user = (User)userDao.getByPropertyEqual("userName", login).get(0);
            req.setAttribute("pokemon", pokeDao.getAllByEntityID("user", user.getId()));
            RequestDispatcher dispatcher = req.getRequestDispatcher("/pokeDex.jsp");
            dispatcher.forward(req, res);

        } catch (Exception ex) {
            logger.error(ex);
            res.setStatus(500);
            res.sendRedirect("/HappyHabits/error.jsp");
        }
    }

}
