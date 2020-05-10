package persistence;

import entity.Goal;
import entity.GoalType;
import entity.Pokemon;
import entity.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class PokeDaoTest {

    GenericDao goalDao;
    GenericDao userDao;
    GenericDao pokeDao;
    /**
     * Run set up tasks before each test:
     * 1. execute sql which deletes everything from the table and inserts records)
     * 2. Create any objects needed in the tests
     */
    @BeforeEach
    void setUp() {
        util.Database database = util.Database.getInstance();
        database.runSQL("cleandb.sql");
        goalDao = new GenericDao(Goal.class);
        userDao = new GenericDao(User.class);
        pokeDao = new GenericDao(Pokemon.class);
    }

    /**
     * Verify successful retrieval of a goal
     */
    @Test
    void getPokemonByIdSuccess() {
        Pokemon pokemon = (Pokemon)pokeDao.getById(1);
        assertNotNull(pokemon);
        assertEquals("Pikachu", pokemon.getPokemonName());
    }

    /**
     * Verify null goal when does not exist in database
     */
    @Test
    void getPokemonByIdFail() {
        Pokemon pokemon = (Pokemon) pokeDao.getById(10);
        assertNull(pokemon);
    }

    /**
     * Verify successful retrieval of all goals
     */
    @Test
    void getAllPokemonSuccess() {
        List<Pokemon> pokemon = pokeDao.getAll();
        assertEquals(2, pokemon.size());
    }

    /**
     * Verify successful retrieval of all goals by user ID
     */
    @Test
    void getPokemonByUserID() {
        List<Pokemon> pokemon = pokeDao.getAllByEntityID("user", 1);
        assertEquals(1, pokemon.size());
        assertEquals("Pikachu", pokemon.get(0).getPokemonName());

        List<Pokemon> pokemon2 = pokeDao.getAllByEntityID("user", 2);
        assertEquals(1, pokemon2.size());
        assertEquals("Bulbasaur", pokemon2.get(0).getPokemonName());
    }

    /**
     * Verify successful insert of a goal
     */
    @Test
    void insertPokemonSuccess() {
        User user = (User)userDao.getById(1);
        Goal goal = (Goal)goalDao.getById(1);
        Pokemon pokemon = new Pokemon("Togepi", "fairy", "something", user, goal);
        int id = pokeDao.insert(pokemon);
        List<Pokemon> allPokemon = pokeDao.getAllByEntityID("user", 1);

        assertNotNull(id);
        assertEquals(2, allPokemon.size());
    }

    /**
     * Verify successful insert of a goal
     */
    @Test
    void saveOrUpdatePokemonSuccess() {
        User user = (User)userDao.getById(1);
        Goal goal = (Goal)goalDao.getById(1);
        Pokemon pokemon = new Pokemon("Charizard", "fire", "something", user, goal);

        pokeDao.saveOrUpdate(pokemon);
        List<Pokemon> allPokemon = pokeDao.getAllByEntityID("user", 1);
        assertEquals(2, allPokemon.size());
    }

    /**
     * Verify successful delete of goal
     */
    @Test
    void deleteGoalSuccess() {
        pokeDao.delete(pokeDao.getById(2));
        assertNull(pokeDao.getById(2));
    }

}
