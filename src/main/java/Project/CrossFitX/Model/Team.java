package Project.CrossFitX.Model;


import jakarta.persistence.*;

@Entity
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String CountryName;

    @ManyToOne

    private Coach teamLead;

    public Team() {
    }

    public Team(Integer id, String countryName, Coach teamLead) {
        this.id = id;
        CountryName = countryName;
        this.teamLead = teamLead;
    }

    @Override
    public String toString() {
        return "Team{" +
                "id=" + id +
                ", CountryName='" + CountryName + '\'' +
                ", teamLead=" + teamLead +
                '}';
    }
}
