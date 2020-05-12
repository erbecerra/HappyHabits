package entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;

/**
 * Entity for user roles, to be used for authentication
 */
@Entity(name = "Role")
@Table(name = "role")
@Getter
@Setter
public class Role {

    /**
     * Identity column PK
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;

    /**
     * User name
     */
    @Column(name = "user_name")
    private String userName;

    /**
     * role name
     */
    @Column(name = "role_name")
    private String roleName;

    /**
     * user id
     */
    @ManyToOne
    @JoinColumn(name = "user_id",
            foreignKey = @ForeignKey(name = "role_user_user_id_fk")
    )
    @EqualsAndHashCode.Exclude
    private User user;

    /**
     * No parameter constructor
     */
    public Role() {

    }

    /**
     * Constructor that sets initial values
     * @param user
     * @param roleName
     * @param userName
     */
    public Role(User user, String roleName, String userName) {
        this.user = user;
        this.roleName = roleName;
        this.userName = userName;
    }
}
