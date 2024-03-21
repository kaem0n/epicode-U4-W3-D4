package kaem0n.entities;

import jakarta.persistence.*;
import kaem0n.enums.Gender;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "athletes")
public class Athlete extends Person{
    @ManyToOne
    @JoinColumn(name = "event_id")
    private AthleticsCompetition competition;

    @OneToMany(mappedBy = "winner")
    private List<AthleticsCompetition> wins;

    public Athlete() {}

    public Athlete(String name, String surname, String email, LocalDate birthday, Gender gender, AthleticsCompetition competition) {
        super(name, surname, email, birthday, gender);
        this.competition = competition;
    }

    public AthleticsCompetition getCompetition() {
        return competition;
    }

    public void setCompetition(AthleticsCompetition competition) {
        this.competition = competition;
    }

    public List<AthleticsCompetition> getWins() {
        return wins;
    }

    public void setWins(List<AthleticsCompetition> wins) {
        this.wins = wins;
    }

    @Override
    public String toString() {
        return "Athlete{" +
                "competition=" + competition +
                ", wins=" + wins +
                '}';
    }
}
