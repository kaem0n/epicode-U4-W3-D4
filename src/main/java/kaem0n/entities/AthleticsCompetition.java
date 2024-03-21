package kaem0n.entities;

import jakarta.persistence.*;
import kaem0n.enums.EventType;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "athletics_competitions")
public class AthleticsCompetition extends Event{
    @OneToMany(mappedBy = "competition")
    private List<Athlete> athletes;
    @ManyToOne
    @JoinColumn(name = "person_id")
    private Athlete winner;

    public AthleticsCompetition() {}

    public AthleticsCompetition(String title, LocalDate date, String description, EventType type, int maxParticipantCapacity, Location location) {
        super(title, date, description, type, maxParticipantCapacity, location);
        this.winner = null;
    }

    public List<Athlete> getAthletes() {
        return athletes;
    }

    public void setAthletes(List<Athlete> athletes) {
        this.athletes = athletes;
    }

    public Athlete getWinner() {
        return winner;
    }

    public void setWinner(Athlete winner) {
        this.winner = winner;
    }

    @Override
    public String toString() {
        return "AthleticsCompetition{" +
                "id=" + super.id +
                ", title='" + super.title + '\'' +
                ", date=" + super.date +
                ", description='" + super.description + '\'' +
                ", type=" + super.type +
                ", maxParticipantCapacity=" + super.maxParticipantCapacity +
                ", location=" + super.location +
                ", athletes=" + athletes +
                ", winner=" + winner +
                '}';
    }
}
