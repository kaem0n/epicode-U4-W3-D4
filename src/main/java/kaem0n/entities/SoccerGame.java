package kaem0n.entities;

import jakarta.persistence.Column;

import jakarta.persistence.Entity;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import kaem0n.enums.EventType;

import java.time.LocalDate;

@Entity
@Table( name = "soccer_games")
@NamedQuery(name = "homeWinners", query= "SELECT sg.winner FROM SoccerGame sg WHERE winner = homeTeam")
@NamedQuery(name = "guestWinners", query= "SELECT sg.winner FROM SoccerGame sg WHERE winner = guestTeam")
public class SoccerGame extends Event {
    @Column(name = "home_team")
    private String homeTeam;
    @Column(name = "guest_team")
    private String guestTeam;
    private String winner;
    @Column(name = "home_team_score")
    private int homeTeamScore;
    @Column(name = "guest_team_score")
    private int guestTeamScore;

    public SoccerGame() {}

    public SoccerGame(String title, LocalDate date, String description, EventType type, int maxParticipantCapacity, Location location, String homeTeam, String guestTeam) {
        super(title, date, description, type, maxParticipantCapacity, location);
        this.homeTeam = homeTeam;
        this.guestTeam = guestTeam;
        this.winner = null;
        this.homeTeamScore = 0;
        this.guestTeamScore = 0;
    }

    public String getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(String homeTeam) {
        this.homeTeam = homeTeam;
    }

    public String getGuestTeam() {
        return guestTeam;
    }

    public void setGuestTeam(String guestTeam) {
        this.guestTeam = guestTeam;
    }

    public String getWinner() {
        return winner;
    }

    public void setWinner() {
        if (this.homeTeamScore > this.guestTeamScore) this.winner = homeTeam;
        else if (this.guestTeamScore > this.homeTeamScore) this.winner = guestTeam;
    }

    public int getHomeTeamScore() {
        return homeTeamScore;
    }

    public void setHomeTeamScore(int homeTeamScore) {
        this.homeTeamScore = homeTeamScore;
    }

    public int getGuestTeamScore() {
        return guestTeamScore;
    }

    public void setGuestTeamScore(int guestTeamScore) {
        this.guestTeamScore = guestTeamScore;
    }

    @Override
    public String toString() {
        return "SoccerGame{" +
                "id=" + super.id +
                ", title='" + super.title + '\'' +
                ", date=" + super.date +
                ", description='" + super.description + '\'' +
                ", type=" + super.type +
                ", maxParticipantCapacity=" + super.maxParticipantCapacity +
                ", location=" + super.location +
                ", homeTeam='" + homeTeam + '\'' +
                ", guestTeam='" + guestTeam + '\'' +
                ", homeTeamScore=" + homeTeamScore +
                ", guestTeamScore=" + guestTeamScore +
                '}';
    }
}
