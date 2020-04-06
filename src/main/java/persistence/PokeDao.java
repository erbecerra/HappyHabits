package persistence;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.poke.Pokemon;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

public class PokeDao {

    private final Logger logger = LogManager.getLogger(this.getClass());

    public Pokemon  getPokemonByName (String name) throws Exception {
        Client client = ClientBuilder.newClient();
        WebTarget target =
                client.target("https://pokeapi.co/api/v2/pokemon/" + name + "/");
        String response = target.request(MediaType.APPLICATION_JSON).get(String.class);
        ObjectMapper mapper = new ObjectMapper();
        Pokemon pokemon = null;

        try {
           pokemon = mapper.readValue(response, Pokemon.class);
        }
        catch (JsonProcessingException e) {
            logger.error(e);
        }
        return pokemon;
    }

}
