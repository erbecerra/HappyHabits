package entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

/**
 * Goal entity
 */
@Entity(name = "Goal")
@Table(name = "goal")
@Data
public class Goal {

    /**
     * Goal PK, identity column
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;

    /**
     * Goal name
     */
    @Column(name = "goal_name")
    private String goalName;

    /**
     * When the goal will end
     */
    @Column(name = "end_date")
    private LocalDate endDate;

    /**
     * FK User associated with this goal
     */
    @ManyToOne
    @JoinColumn(name = "user_id",
            foreignKey = @ForeignKey(name = "goal_user_user_id_fk")
    )
    private User user;

    /**
     * Pokemon associated with this goal
     */
    @OneToOne(mappedBy = "goal", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private Pokemon pokemon = new Pokemon();

    /**
     * Logs for this goal
     */
    @OneToMany(mappedBy = "goal", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<Log> logs = new HashSet<>();

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
     * @param endDate
     */
    public Goal(User user, String goalName, LocalDate endDate) {
        this.user = user;
        this.goalName = goalName;
        this.endDate = endDate;
    }

}
