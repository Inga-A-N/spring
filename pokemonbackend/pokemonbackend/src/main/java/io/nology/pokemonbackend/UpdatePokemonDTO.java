package io.nology.pokemonbackend;

import jakarta.validation.constraints.Pattern;

public class UpdatePokemonDTO {

  @Pattern(regexp = "(?=\\S).*$", message = "Title cannot be an empty string")
  String name;
  

  @Pattern(regexp = "normal|grass|water|fire|electric|ice|fighting|poison|ground|ground|flying|psychic|bug|rock|ghost|dark|dragon|steel|fairy", message = "Not a pokemon type")
  String type;
  

  
  int hp;
  
  String imageLink;
  
  Long evolutionId;

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
