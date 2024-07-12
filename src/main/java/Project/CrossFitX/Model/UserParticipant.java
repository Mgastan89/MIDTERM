package Project.CrossFitX.Model;


import jakarta.persistence.*;

@Entity
public class UserParticipant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String password;
    private String email;

    @ManyToOne

    private Team team;
    public UserParticipant() {}


    @Override
    public String toString() {
        return "UserParticipant{" +
                "id=" + id +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", team=" + team +
                '}';
    }
}
