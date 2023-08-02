package io.nology.pokemonbackend;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="pokemons")

public class Pokemon {
    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(unique = true)
    @Getter
    @Setter
    private String name;
    
    @Column
    @Getter
    @Setter
    private String type;
    
    @Column
    @Getter
    @Setter
    private int hp;
    
    @Column
    @Getter
    @Setter
    private String imageLink;
    
    @Column(nullable = true)
    @Getter
    @Setter
    private Long evolutionId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
    
    
    
    public Pokemon() {}

    public Pokemon(String name, String type, int hp, String imageLink, Long evolutionId) {
	     this.name = name;
	     this.type = type;
	     this.hp = hp;
	     this.imageLink = imageLink;
	     this.evolutionId = evolutionId;
	     
	    }
    
}
