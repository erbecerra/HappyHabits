package entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

public class Pokemon {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;

    @Column(name = "pokemon_name")
    private String name;

    @Column(name = "pokemon_description")
    private String description;

    @Column(name = "user_name")
    private String userName;

    @ManyToOne
    @JoinColumn(name = "user_id",
            foreignKey = @ForeignKey(name = "role_user_user_id_fk")
    )
    private User user;

    @ManyToOne
    @JoinColumn(name = "goal_id",
            foreignKey = @ForeignKey(name = "goal_pokemon_id_fk")
    )
    private Goal goal;

    public Pokemon() {

    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setGoal(Goal goal) {
        this.goal = goal;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getUserName() {
        return userName;
    }

    public User getUser() {
        return user;
    }

    public Goal getGoal() {
        return goal;
    }
}
