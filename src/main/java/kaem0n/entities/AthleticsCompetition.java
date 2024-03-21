package kaem0n.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import kaem0n.enums.EventType;

import java.time.LocalDate;
import java.util.List;

@Entity
@DiscriminatorValue("athletics_competitions")
public class AthleticsCompetition extends Event{
    private List<Person> athletes;
    private Person winner;

    public AthleticsCompetition() {}

    public AthleticsCompetition(String title, LocalDate date, String description, EventType type, int maxParticipantCapacity, Location location, List<Person> athletes, Person winner) {
        super(title, date, description, type, maxParticipantCapacity, location);
        this.athletes = athletes;
        this.winner = null;
    }

    public List<Person> getAthletes() {
        return athletes;
    }

    public void setAthletes(List<Person> athletes) {
        this.athletes = athletes;
    }

    public Person getWinner() {
        return winner;
    }

    public void setWinner(Person winner) {
        this.winner = winner;
    }

    @Override
    public String toString() {
        return "AthleticsCompetition{" +
                "athletes=" + athletes +
                ", winner=" + winner +
                '}';
    }
}
