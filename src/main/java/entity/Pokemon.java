package entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity(name = "Pokemon")
@Table(name = "pokemon")
public class Pokemon {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;

    @Column(name = "pokemon_name")
    private String pokemonName;

    @Column(name = "pokemon_description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "user_id",
            foreignKey = @ForeignKey(name = "pokemon_user_user_id_fk")
    )
    private User user;

    @OneToOne
    @JoinColumn(name = "goal_id",
            foreignKey = @ForeignKey(name = "goal_pokemon_id_fk")
    )
    private Goal goal;

    public Pokemon() {

    }

    public void setName(String pokemonName) {
        this.pokemonName = pokemonName;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setGoal(Goal goal) {
        this.goal = goal;
    }

    public String getPokemonNameName() {
        return pokemonName;
    }

    public String getDescription() {
        return description;
    }

    public User getUser() {
        return user;
    }

    public Goal getGoal() {
        return goal;
    }
}
