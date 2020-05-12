package entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

/**
 * Goal entity
 */
@Entity(name = "Goal")
@Table(name = "goal")
@Getter
@Setter
@EqualsAndHashCode
public class Goal {

    /**
     * Goal PK, identity column
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    @NotNull
    private int id;

    /**
     * Goal name
     */
    @Column(name = "goal_name")
    @NotNull
    private String goalName;

    /**
     * FK User associated with this goal
     */
    @ManyToOne
    @JoinColumn(name = "user_id",
            foreignKey = @ForeignKey(name = "goal_user_user_id_fk")
    )
    @EqualsAndHashCode.Exclude
    @NotNull
    private User user;

    /**
     * Pokemon associated with this goal
     */
    @OneToOne(mappedBy = "goal", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @EqualsAndHashCode.Exclude
    private Pokemon pokemon = new Pokemon();

    /**
     * Logs for this goal
     */
    @OneToMany(mappedBy = "goal", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @EqualsAndHashCode.Exclude
    private Set<Log> logs = new HashSet<>();

    @Column(name="goal_type")
    @Enumerated(EnumType.ORDINAL)
    @NotNull
    private GoalType goalType;

    /**
     * No parameter constructor
     */
    public Goal() {

    }

    /**
     * Goal constructor
     *
     * @param user
     * @param goalName
     * @param goalType
     */
    public Goal(User user, String goalName, GoalType goalType) {
        this.user = user;
        this.goalName = goalName;
        this.goalType = goalType;
    }

    /**
     * Add log
     *
     * @param log the goal to add
     */
    public void addLog(Log log) {
        logs.add(log);
        log.setGoal(this);
    }

    /**
     * Remove log.
     *
     * @param log the goal to remove
     */
    public void removeLog(Log log) {
        logs.remove(log);
        log.setGoal(null);
    }
}
