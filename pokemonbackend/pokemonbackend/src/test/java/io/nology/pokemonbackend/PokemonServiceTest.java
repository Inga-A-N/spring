package io.nology.pokemonbackend;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;



@ExtendWith(MockitoExtension.class)

public class PokemonServiceTest {
    
    @Mock
    private PokemonRepository PokemonRepository;
    
    private PokemonService underTest;
    
    @BeforeEach
    void setUp() {
	this.underTest = new PokemonService(PokemonRepository);
    }
    
    @Test
    void findAllShouldCallFindAll() {
	underTest.findAll();
	Mockito.verify(PokemonRepository).findAll();
    }

}
