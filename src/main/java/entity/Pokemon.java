package entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Pokemon Entity
 */
@Entity(name = "Pokemon")
@Table(name = "pokemon")
@Getter
@Setter
public class Pokemon {

    /**
     * PK/Identity column
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;

    /**
     * Pokemon Name
     */
    @Column(name = "pokemon_name")
    private String pokemonName;

    /**
     * Pokemon Description
     */
    @Column(name = "pokemon_description")
    private String description;

    /**
     * Pokemon image link from to Poke API
     */
    @Column(name = "image_url")
    private String imageUrl;

    /**
     * FK user ID
     */
    @ManyToOne
    @JoinColumn(name = "user_id",
            foreignKey = @ForeignKey(name = "pokemon_user_user_id_fk")
    )
    private User user;

    /**
     * FK goal ID
     */
    @OneToOne
    @JoinColumn(name = "goal_id",
            foreignKey = @ForeignKey(name = "goal_pokemon_id_fk")
    )
    private Goal goal;

    /**
     * No parameter constructor
     */
    public Pokemon() {

    }

    /**
     * Constructor that initializes some values
     *
     * @param name
     * @param description
     * @param imageUrl
     * @param user
     * @param goal
     */
    public Pokemon(String name, String description,String imageUrl,  User user, Goal goal) {
        this.user = user;
        this.goal = goal;
        this.pokemonName = name;
        this.description = description;
        this.imageUrl = imageUrl;
    }
}
