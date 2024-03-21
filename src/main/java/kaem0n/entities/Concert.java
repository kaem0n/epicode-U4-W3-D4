package kaem0n.entities;

import jakarta.persistence.*;
import kaem0n.enums.EventType;
import kaem0n.enums.MusicGenre;

import java.time.LocalDate;

@Entity
@Table(name = "concerts")
public class Concert extends Event {
    @Enumerated(EnumType.STRING)
    private MusicGenre genre;
    private boolean streaming;

    public Concert() {
    }

    public Concert(String title, LocalDate date, String description, EventType type, int maxParticipantCapacity, Location location, MusicGenre genre, boolean streaming) {
        super(title, date, description, type, maxParticipantCapacity, location);
        this.genre = genre;
        this.streaming = streaming;
    }

    public MusicGenre getGenre() {
        return genre;
    }

    public void setGenre(MusicGenre genre) {
        this.genre = genre;
    }

    public boolean isStreaming() {
        return streaming;
    }

    public void setStreaming(boolean streaming) {
        this.streaming = streaming;
    }

    @Override
    public String toString() {
        return "Concert{" +
                "id=" + super.id +
                ", title='" + super.title + '\'' +
                ", date=" + super.date +
                ", description='" + super.description + '\'' +
                ", type=" + super.type +
                ", maxParticipantCapacity=" + super.maxParticipantCapacity +
                ", location=" + super.location +
                ", genre=" + genre +
                ", streaming=" + streaming +
                '}';
    }
}
