package io.nology.pokemonbackend;

import org.hibernate.mapping.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class PokemonRepositoryTest {
    
    @Autowired
    private PokemonRepository underTest;
    
    @AfterEach
    void tearDown() {
	underTest.deleteAll();
    }
    
    @Test
    void itShouldGetPokemonsOfType() {
	String type = "bug";
	Pokemon pokemon1 = new Pokemon("Pokemon1", type, 45, "ImageLink", 1L);
	Pokemon pokemon2 = new Pokemon("Pokemon2", "grass", 50, "ImageLink", 2L);
	    
    }
    

}
