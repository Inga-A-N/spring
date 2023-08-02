package io.nology.pokemonbackend;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.nology.pokemonbackend.exceptions.NotFoundException;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/pokemons")
public class PokemonController {
    
    @Autowired
    private PokemonService pokemonService;
    
  //CREATE
    
    @PostMapping
    // I am returning ResponseEntity because I want to have control over what status code 
    // gets returned as part of HTTP response
    public  ResponseEntity<Pokemon> createPokemon(@Valid @RequestBody CreatePokemonDTO data) {
	 System.out.println(data.name);
	 System.out.println(data.type);
	 System.out.println(data.hp);
	 Pokemon createdPokemon = this.pokemonService.create(data);
	 return new ResponseEntity<>(createdPokemon, HttpStatus.CREATED);
    }

    
//    READ
    @GetMapping
    public ResponseEntity<List<Pokemon>> getAll(){
	 List<Pokemon> allPokemons = this.pokemonService.findAll();
	 return new ResponseEntity<>(allPokemons,HttpStatus.OK);
    }
   

//    
    @GetMapping("/{id}")
	public ResponseEntity<Pokemon> getById(@PathVariable Long id) {
		Optional<Pokemon> foundPokemon = this.pokemonService.findById(id);
		
		if(foundPokemon.isEmpty()) {
			throw new NotFoundException(String.format("Pokemon with id: %s not found", id));
		}
		return new ResponseEntity<>(foundPokemon.get(), HttpStatus.OK);
	}
    
//    FILTER
    
//    @GetMapping(params = "type")
//    public ResponseEntity<List<Pokemon>> getPokemonsByType(@RequestParam(name = "type") String type) {
//        List<Pokemon> filteredByTypePokemons = pokemonService.filterByType(type);
//        return ResponseEntity.ok(filteredByTypePokemons);
//    }
    
//    @GetMapping(params = "type")
//    public ResponseEntity<List<Pokemon>> getPokemonsByType(@RequestParam(name = "type", required = false) String type) {
//        List<Pokemon> filteredPokemons;
//        if (type != null) {
//        //	PokemonType pokemonType = convertStringToPokemonType(type);
//        	PokemonType pokemonType = fromStringIgnoreCase(type);
//            filteredPokemons = pokemonService.findByType(pokemonType);
//        } else {
//            filteredPokemons = pokemonService.findAll();
//        }
//
//        return ResponseEntity.ok(filteredPokemons);
//    }
//    
    
    @GetMapping(params = "type")
    public ResponseEntity<List<Pokemon>> getPokemonsByType(@RequestParam(name = "type", required = false) String type) {
        List<Pokemon> filteredPokemons;
        if (type != null) {
        //	PokemonType pokemonType = convertStringToPokemonType(type);
        	String pokemonType = type;
            filteredPokemons = pokemonService.findByType(pokemonType);
        } else {
            filteredPokemons = pokemonService.findAll();
        }

        return ResponseEntity.ok(filteredPokemons);
    }
    
    @GetMapping(params = "minHp")
    public ResponseEntity<List<Pokemon>> getPokemonsByMinHp(@RequestParam(name = "minHp") int minHp) {
        List<Pokemon> filteredPokemons = pokemonService.findByMinHp(minHp);
        return ResponseEntity.ok(filteredPokemons);
    }
//    @GetMapping
//    @ResponseBody
//    public String getType(@RequestParam String type) {
//	    return "Type: " + type;
//	}
//    public ResponseEntity<List<Pokemon>> getByType(@RequestParam String type){
//	 List<Pokemon> allByTypePokemons = this.pokemonService.findAll();
//	 return new ResponseEntity<>(allByTypePokemons,HttpStatus.OK);
//   }
    
//  UPDATE
    
   @PatchMapping("/{id}")
	public ResponseEntity<Pokemon> updateById(@PathVariable Long id,
			@Valid @RequestBody UpdatePokemonDTO data) {
		Optional<Pokemon> maybeUpdated = this.pokemonService.updateById(id, data);
		if(maybeUpdated.isEmpty()) {
			throw new NotFoundException(String.format(
					"Pokemon with id: %s not found, could not update", 
					id));
		}
		
		return new ResponseEntity<Pokemon>(maybeUpdated.get(), HttpStatus.OK);
	}
   
//   DELETE
//   return 204 - success, no content
   @DeleteMapping("/{id}")
   public ResponseEntity<Pokemon> deleteById(@PathVariable Long id){
	 boolean deleted = this.pokemonService.deleteById(id);
	 if(!deleted) {
	     throw new NotFoundException(String.format("Pokemon with id: %s not found, could not delete", id));
	 }
	 return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
   }
}
