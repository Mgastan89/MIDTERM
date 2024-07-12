package Project.CrossFitX.Model;
import jakarta.persistence.*;

@Entity
public class Coach extends UserParticipant{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    @Column(nullable = false, unique = true)
    private Integer employeeNumber;

    @ManyToOne
    private Activity activity;

    @Column(nullable = false)
    private boolean isTeamLead;
    public Coach() {}


    @Override
    public String toString() {
        return "Coach{" +
                "id=" + id +
                ", employeeNumber=" + employeeNumber +
                ", activity=" + activity +
                ", isTeamLead=" + isTeamLead +
                '}';
    }
}
