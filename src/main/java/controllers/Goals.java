package controllers;

import com.poke.TypesItem;
import entity.Goal;
import entity.GoalType;
import entity.Pokemon;
import entity.User;
import lombok.SneakyThrows;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import persistence.GenericDao;
import persistence.PokeDao;

import javax.servlet.RequestDispatcher;
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

    private final Logger logger = LogManager.getLogger(this.getClass());
    private GenericDao goalDao = new GenericDao(Goal.class);
    private GenericDao userDao = new GenericDao(User.class);
    private User user;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        try {
            String login = req.getRemoteUser();
            user = (User)userDao.getByPropertyEqual("userName", login).get(0);
            if (user == null)
            {
                logger.error("No user");
                res.setStatus(500);
                res.sendRedirect("/HappyHabits/error.jsp");
                return;
            }
            req.setAttribute("goals", goalDao.getAllByEntityID("user", user.getId()));
            RequestDispatcher dispatcher = req.getRequestDispatcher("/goals.jsp");
            dispatcher.forward(req, res);
        }
        catch (Exception ex) {
            logger.error(ex);
            res.setStatus(500);
            res.sendRedirect("/HappyHabits/error.jsp");
        }
    }

    @SneakyThrows
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {

        try {
            PokeDao pokeDao = new PokeDao();
            String goalTitle = req.getParameter("title");
            GoalType goalType = GoalType.valueOf(req.getParameter("frequency"));
            Goal goal = new Goal(user, goalTitle, goalType, false);

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
            goalDao.insert(goal);res.sendRedirect("goals");

        } catch (Exception ex) {
            logger.error(ex);
            res.setStatus(500);
            res.sendRedirect("/HappyHabits/error.jsp");
        }
    }
}
