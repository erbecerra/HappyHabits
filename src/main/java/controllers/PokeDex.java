package controllers;

import com.poke.TypesItem;
import entity.Goal;
import entity.GoalType;
import entity.Pokemon;
import entity.User;
import lombok.SneakyThrows;
import persistence.GenericDao;
import persistence.PokeDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Random;


@WebServlet(
        urlPatterns = {"/pokeDex"}
)
public class PokeDex extends HttpServlet {

    GenericDao pokeDao = new GenericDao(Pokemon.class);
    GenericDao userDao = new GenericDao(User.class);
    User user;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String login = req.getRemoteUser();
        user = (User)userDao.getByPropertyEqual("userName", login).get(0);
        req.setAttribute("pokemon", pokeDao.getAllByEntityID("user", user.getId()));
        RequestDispatcher dispatcher = req.getRequestDispatcher("/pokeDex.jsp");
        dispatcher.forward(req, res);
    }

}
