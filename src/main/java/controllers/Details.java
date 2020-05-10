package controllers;

import entity.Goal;
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
        urlPatterns = {"/details"}
)
public class Details extends HttpServlet {

    GenericDao goalDao = new GenericDao(Goal.class);
    GenericDao userDao = new GenericDao(User.class);
    GenericDao pokeDao = new GenericDao(Pokemon.class);
    User user;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String login = req.getRemoteUser();
        user = (User)userDao.getByPropertyEqual("userName", login).get(0);

        //add something to the url parameters so that we can
        req.setAttribute("goal", goalDao.getById(1));
        req.setAttribute("pokemon", pokeDao.getById(1));
        RequestDispatcher dispatcher = req.getRequestDispatcher("/details.jsp");
        dispatcher.forward(req, res);
    }

}
