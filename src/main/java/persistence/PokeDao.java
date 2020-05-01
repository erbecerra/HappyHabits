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
import java.util.Properties;
import utilities.PropertiesLoader;

public class PokeDao implements PropertiesLoader {

    private final Logger logger = LogManager.getLogger(this.getClass());

    public Pokemon  getPokemonByName (String name) throws Exception {
        Client client = ClientBuilder.newClient();
        Properties properties = loadProperties("/database.properties");
        WebTarget target = client.target(properties.getProperty("pokeapiurl") + name + "/");
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

    //get pokemon picture

    //get pokemon stats

   // Locally cache resources and images whenever you request them.
   // Use the correct user-agent header in API requests.

}
