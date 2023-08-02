package io.nology.pokemonbackend;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PokemonRepository extends JpaRepository<Pokemon, Long>{
    
    List<Pokemon> findByType(String type);
    
    @Query("SELECT p FROM Pokemon p WHERE p.hp >= :minHp")
	List<Pokemon> findByMinHp(int minHp);
}
