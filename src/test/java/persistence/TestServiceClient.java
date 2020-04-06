package persistence;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.poke.Pokemon;
import org.junit.Test;
import javax.ws.rs.client.*;
import javax.ws.rs.core.MediaType;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestServiceClient {

    @Test
    public void testPokeJSON() throws Exception {
        Client client = ClientBuilder.newClient();
        WebTarget target =
                client.target("https://pokeapi.co/api/v2/pokemon/pikachu/");
        String response = target.request(MediaType.APPLICATION_JSON).get(String.class);
        ObjectMapper mapper = new ObjectMapper();
        String expectedName = "pikachu";
        Pokemon pokemon = mapper.readValue(response, Pokemon.class);
        assertEquals(expectedName, pokemon.getName());
    }
}