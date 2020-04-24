package entity;

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
    public Log() {}

    /**
     * Constructor with initial values
     * @param goal
     * @param date
     * @param success
     */
    public Log(Goal goal, LocalDate date, boolean success) {
        this.goal = goal;
        this.date = date;
        this.success = success;
    }

    /**
     * get the log ID
     * @return
     */
    public int getId() {
        return id;
    }

    /**
     * set the log ID
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * get the date of the log
     * @return date
     */
    public LocalDate getDate() {
        return date;
    }

    /**
     * set the date of the log
     * @param date
     */
    public void setDate(LocalDate date) {
        this.date = date;
    }

    /**
     * If the log was a success
     * @return succcess
     */
    public boolean isSuccess() {
        return success;
    }

    /**
     * set the success
     * @param success
     */
    public void setSuccess(boolean success) {
        this.success = success;
    }

    /**
     * set the goal for this log
     * @return goal
     */
    public Goal getGoal() {
        return goal;
    }

    /**
     * sets the goal associated with this log
     * @param goal
     */
    public void setGoal(Goal goal) {
        this.goal = goal;
    }

}
