package io.nology.pokemonbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
//@Configuration("com.company")
//@EnableJpaRepositories("com.pharmacy.persistence.users.dao")
public class PokemonbackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(PokemonbackendApplication.class, args);
	}
	
//	# Pokemon API
//
//	## Additional Links
//	- [Query Parameters in Spring](https://www.baeldung.com/spring-request-param)
//	- [What are query parameters?](https://www.branch.io/glossary/query-parameters/)
//
//	## Introduction
//	Create a full CRUD API that allows consumers to CREATE, UPDATE, FIND, DELETE and LIST Pokemon. Each Pokemon should have the following fields: `id`, `name`, `type`, `hp`, `imageLink`, `evolutionId (nullable)`
//
//	types can only be the following (any other value should result in a bad request)
//
//	-   [Normal](https://pokemon.fandom.com/wiki/Normal_type "Normal type")
//	-   [Fire](https://pokemon.fandom.com/wiki/Fire_type "Fire type")
//	-   [Water](https://pokemon.fandom.com/wiki/Water_type "Water type")
//	-   [Grass](https://pokemon.fandom.com/wiki/Grass_type "Grass type")
//	-   [Electric](https://pokemon.fandom.com/wiki/Electric_type "Electric type")
//	-   [Ice](https://pokemon.fandom.com/wiki/Ice_type "Ice type")
//	-   [Fighting](https://pokemon.fandom.com/wiki/Fighting_type "Fighting type")
//	-   [Poison](https://pokemon.fandom.com/wiki/Poison_type "Poison type")
//	-   [Ground](https://pokemon.fandom.com/wiki/Ground_type "Ground type")
//	-   [Flying](https://pokemon.fandom.com/wiki/Flying_type "Flying type")
//	-   [Psychic](https://pokemon.fandom.com/wiki/Psychic_type "Psychic type")
//	-   [Bug](https://pokemon.fandom.com/wiki/Bug_type "Bug type")
//	-   [Rock](https://pokemon.fandom.com/wiki/Rock_type "Rock type")
//	-   [Ghost](https://pokemon.fandom.com/wiki/Ghost_type "Ghost type")
//	-   [Dark](https://pokemon.fandom.com/wiki/Dark_type "Dark type")
//	-   [Dragon](https://pokemon.fandom.com/wiki/Dragon_type "Dragon type")
//	-   [Steel](https://pokemon.fandom.com/wiki/Steel_type "Steel type")
//	-   [Fairy](https://pokemon.fandom.com/wiki/Fairy_type "Fairy type")
//
//	The Pokemon name field should be unique, and CREATE should return a bad request if the name already exists
//
//	The evolutionId should contain the id of the Pokemon that the current Pokemon evolves from, e.g: if Pikachu has an id of 14, then Raichu would have an evolutionId of 14
//
//	## MVP
//
//	The user should be able to do the following:
//
//	-   Create a new pokemon
//	-   Update an existing pokemon
//	-   Delete an pokemon
//	-   Retrieve all pokemon from the database
//	-   Retrieve a single pokemon from the database by id
//	-   Filter Pokemon by `type` (Query Parameter => e.g: `myurl?type=steel`) 
//	-   Filter Pokemon by `minHp` (Query Parameter =>  e.g: `myurl?minHp=100`)

}
