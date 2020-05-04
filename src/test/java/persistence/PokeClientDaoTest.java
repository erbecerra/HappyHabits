package persistence;

import com.poke.Pokemon;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PokeClientDaoTest {

    @Test
    public void getPokemonByNameSuccess() throws Exception {
        PokeDao dao = new PokeDao();
        Pokemon pokemon = dao.getPokemonByName("pikachu");
        assertEquals("pikachu", pokemon.getName());
    }

    @Test
    public void getPokemonByIDSuccess() throws Exception {
        PokeDao dao = new PokeDao();
        Pokemon pokemon = dao.getPokemonByID(25);
        assertEquals("pikachu", pokemon.getName());
    }
}