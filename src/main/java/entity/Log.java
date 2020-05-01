package entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.ejb.Local;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

/**
 * Log entity
 */
@Entity(name = "Log")
@Table(name = "log")
@Getter
@Setter
public class Log {

    /**
     * PK/Identity column for the log entity
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;

    /**
     * FK goal
     */
    @ManyToOne
    @JoinColumn(name = "goal_id",
            foreignKey = @ForeignKey(name = "log_goal_goal_id_fk")
    )
    private Goal goal;

    /**
     * Date of the log
     */
    @Column(name = "date")
    private LocalDate date;

    /**
     * If the goal was completed
     */
    @Column(name = "success")
    private boolean success;

    /**
     * No parameter constructor
     */
    public Log() {
    }

    /**
     * Constructor with initial values
     *
     * @param goal
     * @param date
     * @param success
     */
    public Log(Goal goal, LocalDate date, boolean success) {
        this.goal = goal;
        this.date = date;
        this.success = success;
    }

}
