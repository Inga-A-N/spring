package io.nology.pokemonbackend;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

public class CreatePokemonDTO {
    
    @NotBlank
    @Getter
    @Setter
    String name;
    
    @NotBlank
    @Getter
    @Setter
    @Pattern(regexp = "normal|grass|water|fire|electric|ice|fighting|poison|ground|ground|flying|psychic|bug|rock|ghost|dark|dragon|steel|fairy", message = "Not a pokemon type")
    String type;
    
    @NotNull
    @Getter
    @Setter
    int hp;
    
    @NotBlank
    @Getter
    @Setter
    String imageLink;
    
    
    @Getter
    @Setter
    Long evolutionId;
    
    
    
    public CreatePokemonDTO(String name, String type, int hp, String imageLink, Long evolutionId) {
	this.name = name;
	this.type = type;
	this.hp = hp;
	this.imageLink = imageLink;
	this.evolutionId = evolutionId;
    }



    public String getName() {
        return name;
    }



    public void setName(String name) {
        this.name = name;
    }



    public String getType() {
        return type;
    }



    public void setType(String type) {
        this.type = type;
    }



    public int getHp() {
        return hp;
    }



    public void setHp(int hp) {
        this.hp = hp;
    }



    public String getImageLink() {
        return imageLink;
    }



    public void setImageLink(String imageLink) {
        this.imageLink = imageLink;
    }



    public Long getEvolutionId() {
        return evolutionId;
    }



    public void setEvolutionId(Long evolutionId) {
        this.evolutionId = evolutionId;
    }
    
    
    
    
}
