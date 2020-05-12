package entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * A class to represent a user.
 *
 * @author ebecerra
 */
@Entity(name = "User")
@Table(name = "user")
@Getter
@Setter
@EqualsAndHashCode
public class User {

    /**
     * Identity column/PK
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;

    /**
     * First name
     */
    @Column(name = "first_name")
    private String firstName;

    /**
     * Last name
     */
    @Column(name = "last_name")
    private String lastName;

    /**
     * user name
     */
    @Column(name = "user_name")
    private String userName;

    /**
     * date of birth
     */
    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;

    /**
     * password
     */
    @Column(name = "password")
    private String password;

    /**
     * roles
     */
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @EqualsAndHashCode.Exclude
    private Set<Role> roles = new HashSet<>();

    /**
     * goals
     */
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @EqualsAndHashCode.Exclude
    private Set<Goal> goals = new HashSet<>();

    /**
     * all pokemon
     */
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @EqualsAndHashCode.Exclude
    private Set<Pokemon> allPokemon = new HashSet<>();

    /**
     * Instantiates a new User.
     */
    public User() {
    }

    /**
     * Instantiates a new User.
     *
     * @param firstName   the first name
     * @param lastName    the last name
     * @param userName    the user name
     * @param dateOfBirth the date of birth
     * @param password the password
     */
    public User(String firstName, String lastName, String userName, LocalDate dateOfBirth, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.dateOfBirth = dateOfBirth;
        this.password = password;
    }

    /**
     * Add role
     *
     * @param role the roles
     */
    public void addRole(Role role) {
        roles.add(role);
        role.setUser(this);
    }

    /**
     * Remove role.
     *
     * @param role the role
     */
    public void removeRole(Role role) {
        roles.remove(role);
        role.setUser(null);
    }

    /**
     * Add goal
     *
     * @param goal the goal to add
     */
    public void addGoal(Goal goal) {
        goals.add(goal);
        goal.setUser(this);
    }

    /**
     * Remove goal.
     *
     * @param goal the goal to remove
     */
    public void removeGoal(Goal goal) {
        goals.remove(goal);
        goal.setUser(null);
    }

    /**
     * Add Pokemon
     *
     * @param pokemon the goal to add
     */
    public void addPokemon(Pokemon pokemon) {
        allPokemon.add(pokemon);
        pokemon.setUser(this);
    }

    /**
     * Remove pokemon.
     *
     * @param pokemon the goal to remove
     */
    public void removePokemon(Pokemon pokemon) {
        allPokemon.remove(pokemon);
        pokemon.setUser(null);
    }

}