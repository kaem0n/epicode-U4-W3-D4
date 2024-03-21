package kaem0n.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "participations")
public class Participation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "participation_id")
    private long id;
    @Enumerated(EnumType.STRING)
    private ParticipationState state;
    @ManyToOne
    @JoinColumn(name = "event_id")
    private Event event;
    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person person;

    public Participation(){}

    public Participation(ParticipationState state, Person person, Event event) {
        this.state = state;
        this.person = person;
        this.event = event;
    }

    public long getId() {
        return id;
    }

    public ParticipationState getState() {
        return state;
    }

    public void setState(ParticipationState state) {
        this.state = state;
    }

    public Event getEvent() {
        return event;
    }

    public Person getPerson() {
        return person;
    }

    @Override
    public String toString() {
        return "Participation{" +
                "id=" + id +
                ", state=" + state +
                ", event=" + event +
                ", person=" + person +
                '}';
    }
}
