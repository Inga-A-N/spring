package io.nology.pokemonbackend;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
@Transactional


public class PokemonService {
    
    
     // dependency injection
     	@Autowired
     	private PokemonRepository PokemonRepository;
     	
     	@Autowired
     	private ModelMapper modelMapper;
     	
     	public Pokemon create(CreatePokemonDTO data) {
     		// Business logic - trim all string coming from data
     		// clean up data
//     	    One option:
//     		String pokemonTitle = data.getTitle().trim();
//     		String pokemonContent = data.getContent().trim();
//     		String pokemonCategory = data.getCategory().trim();
//     		Date pokemonCreatedAt = new Date();
     		
//     		Pokemon newPokemon = new Pokemon(
//     				pokemonTitle,
//     				pokemonCategory, 
//     				pokemonContent,
//     				pokemonCreatedAt
//     				);
     	    
//     	    Replacing the above with the mapper
     	    
     	   
     		
//     		Pokemon newPokemon = new Pokemon();
//     		newPokemon.setCategory(pokemonCategory);
//     		newPokemon.setTitle(pokemonTitle);
//     		newPokemon.setCreatedAt(pokemonCreatedAt);
//     		newPokemon.setContent(pokemonContent);
     	    	Pokemon newPokemon = modelMapper.map(data, Pokemon.class);
    		
    		Pokemon createdPokemon = this.PokemonRepository.save(newPokemon);
     		
     		return createdPokemon;
     	}
     	
     	public List<Pokemon> findAll (){
     	   return this.PokemonRepository.findAll(); 
     	}
     	
     	public List<Pokemon> findByType(String type){
     	    return PokemonRepository.findByType(type);
     	}
     	
     	public List<Pokemon> findByMinHp(int minHp) {
	        return PokemonRepository.findByMinHp(minHp);
     	}
     	
     	public Optional<Pokemon> findById(Long id){
     	    Optional<Pokemon> maybePokemon = this.PokemonRepository.findById(id);
     	    return maybePokemon;
     	}
     	
     	public boolean deleteById(Long id){
     	    Optional<Pokemon> maybePokemon = this.findById(id);
     	    if(maybePokemon.isEmpty()) {
     		return false;
     	    }
     	    this.PokemonRepository.delete(maybePokemon.get());
     	    return true;
     	}
     	
     	public Optional<Pokemon> updateById(Long id, UpdatePokemonDTO data) {
    		
    		// find the pokemon I want to update
    		Optional<Pokemon> maybePokemon = this.findById(id);
    		
    		if(maybePokemon.isPresent()) {
    			Pokemon existingPokemon = maybePokemon.get();
    			// I want this done in a nicer way - with model mapper
//    			if(data.title != null) {
//    				existingPokemon.setTitle(data.title.trim());
//    				Pokemon updatedPokemon = this.pokemonRepository.save(existingPokemon);
//    				return Optional.of(updatedPokemon);
//    			}
    			modelMapper.map(data, existingPokemon);
    			return Optional.of(this.PokemonRepository.save(existingPokemon));
    		}
    	
    		return maybePokemon;
    	}

     	
}
