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
        urlPatterns = {"/goals"}
)
public class Goals extends HttpServlet {

    GenericDao goalDao = new GenericDao(Goal.class);
    GenericDao userDao = new GenericDao(User.class);
    User user;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String login = req.getRemoteUser();
        user = (User)userDao.getByPropertyEqual("userName", login).get(0);
        req.setAttribute("goals", goalDao.getAllByEntityID("user", user.getId()));
        RequestDispatcher dispatcher = req.getRequestDispatcher("/goals.jsp");
        dispatcher.forward(req, res);
    }

    @SneakyThrows
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
        PokeDao pokeDao = new PokeDao();
        String goalTitle = req.getParameter("title");
        GoalType goalType = GoalType.valueOf(req.getParameter("frequency"));
        Goal goal = new Goal(user, goalTitle, goalType);

        Random rand = new Random();
        int randomID = rand.nextInt(413);

        com.poke.Pokemon pokemon = pokeDao.getPokemonByID(randomID);

        String description = null;
        for (TypesItem type : pokemon.getTypes())
        {
            description += type.getType().getName() + ",";
        }

        String imageUrl = pokemon.getSprites().getFrontDefault();

        entity.Pokemon poke = new Pokemon(pokemon.getName(), description , imageUrl, user, goal);
        goal.setPokemon(poke);
        goalDao.insert(goal);
        res.sendRedirect("goals");
    }
}
