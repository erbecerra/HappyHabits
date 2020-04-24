package entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Pokemon Entity
 */
@Entity(name = "Pokemon")
@Table(name = "pokemon")
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
     * @param name
     * @param description
     * @param user
     * @param goal
     */
    public Pokemon(String name, String description, User user, Goal goal) {
        this.pokemonName = name;
        this.description = description;
        this.user = user;
        this.goal = goal;
    }

    /**
     * set Pokemon name
     * @param pokemonName
     */
    public void setName(String pokemonName) {
        this.pokemonName = pokemonName;
    }

    /**
     * set pokemon description
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * set the user
     * @param user
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     *
     * @param goal
     */
    public void setGoal(Goal goal) {
        this.goal = goal;
    }

    /**
     *
     * @return
     */
    public String getPokemonNameName() {
        return pokemonName;
    }

    /**
     *
     * @return
     */
    public String getDescription() {
        return description;
    }

    /**
     *
     * @return
     */
    public User getUser() {
        return user;
    }

    /**
     *
     * @return
     */
    public Goal getGoal() {
        return goal;
    }
}
