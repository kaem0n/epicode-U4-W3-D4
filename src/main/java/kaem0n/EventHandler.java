package kaem0n;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import kaem0n.dao.EventDAO;
import kaem0n.dao.LocationDAO;
import kaem0n.dao.ParticipationDAO;
import kaem0n.dao.PersonDAO;
import kaem0n.entities.*;
import kaem0n.enums.EventType;
import kaem0n.enums.Gender;
import kaem0n.enums.MusicGenre;
import kaem0n.enums.ParticipationState;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EventHandler {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("eventhandler");
    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();
        EventDAO ed = new EventDAO(em);
        PersonDAO pd1 = new PersonDAO(em);
        ParticipationDAO pd2 = new ParticipationDAO(em);
        LocationDAO ld = new LocationDAO(em);

//        ld.save(new Location("Camp Nou", "Barcelona"));
//        ld.save(new Location("Arena di Verona", "Verona"));
//        ld.save(new Location("Teatro Ariston", "Sanremo"));
//        ld.save(new Location("Stadio Olimpico", "Roma"));
//        Location campNou = ld.getById(1);
//        Location arenaDiVerona = ld.getById(2);
//        Location ariston = ld.getById(3);
//        Location stadioOlimpico = ld.getById(4);
//
//        ed.save(new Concert("Metallica concert", LocalDate.parse("2024-04-28"), "World tour 2024", EventType.PUBLIC, 20000, arenaDiVerona, MusicGenre.ROCK, true));
//        ed.save(new Concert("Festivalbar", LocalDate.parse("2024-08-08"), "Estate 2024", EventType.PUBLIC, 20000, arenaDiVerona, MusicGenre.POP, true));
//        ed.save(new Concert("Festival di Sanremo", LocalDate.parse("2024-02-10"), "Edizione 2024 del Festival di Sanremo", EventType.PRIVATE, 1800, ariston, MusicGenre.CLASSIC, false));
//        ed.save(new SoccerGame("Barcelona - Real Madrid", LocalDate.parse("2024-04-20"), "El Clásico", EventType.PUBLIC, 99354, campNou, "Barcelona", "Real Madrid"));
//        ed.save(new SoccerGame("Roma - Lazio", LocalDate.parse("2024-04-06"), "Derby laziale", EventType.PUBLIC, 70634, stadioOlimpico, "Roma", "Lazio"));
//        ed.save(new AthleticsCompetition("Gara di atletica", LocalDate.now(), "Olympics qualifications", EventType.PRIVATE, 500, stadioOlimpico));
//        Event metallica = ed.getById(1);
//        Event festivalbar = ed.getById(2);
//        Event sanremo = ed.getById(3);
//        Event clasico = ed.getById(4);
//        Event derby = ed.getById(5);
//        Event athletics = ed.getById(6);
//
//        pd1.save(new Athlete("Mario", "Rossi", "mario@rossi.it", LocalDate.parse("1980-01-01"), Gender.MALE, (AthleticsCompetition) athletics));
//        pd1.save(new Athlete("Giovanni", "Neri", "giovanni@neri.it", LocalDate.parse("1973-10-04"), Gender.MALE, (AthleticsCompetition) athletics));
//        pd1.save(new Athlete("Marco", "Bruni", "marco@bruni.it", LocalDate.parse("1991-04-15"), Gender.MALE, (AthleticsCompetition) athletics));
//        pd1.save(new Person("Maria", "Bianchi", "maria@bianchi.it", LocalDate.parse("1990-01-01"), Gender.FEMALE));
//        pd1.save(new Person("Marta", "Rossi", "marta@rossi.it", LocalDate.parse("2001-03-27"), Gender.FEMALE));
//        pd1.save(new Person("Stefania", "Verdi", "stefania@verdi.it", LocalDate.parse("1989-11-06"), Gender.FEMALE));
//        Person mario = pd1.getById(1);
//        Person giovanni = pd1.getById(2);
//        Person marco = pd1.getById(3);
//        Person maria = pd1.getById(4);
//        Person marta = pd1.getById(5);
//        Person stefania = pd1.getById(6);
//
//
//        pd2.save(new Participation(ParticipationState.TO_CONFIRM, maria, sanremo));
//        pd2.save(new Participation(ParticipationState.TO_CONFIRM, stefania, sanremo));
//        pd2.save(new Participation(ParticipationState.CONFIRMED, maria, metallica));
//        pd2.save(new Participation(ParticipationState.CONFIRMED, mario, metallica));
//        pd2.save(new Participation(ParticipationState.CONFIRMED, giovanni, metallica));
//        pd2.save(new Participation(ParticipationState.CONFIRMED, marta, metallica));
//        pd2.save(new Participation(ParticipationState.CONFIRMED, marta, festivalbar));
//        pd2.save(new Participation(ParticipationState.CONFIRMED, stefania, festivalbar));
//        pd2.save(new Participation(ParticipationState.CONFIRMED, giovanni, clasico));
//        pd2.save(new Participation(ParticipationState.CONFIRMED, giovanni, derby));
//        pd2.save(new Participation(ParticipationState.CONFIRMED, marco, derby));
//        pd2.save(new Participation(ParticipationState.CONFIRMED, marco, clasico));
//        pd2.save(new Participation(ParticipationState.CONFIRMED, maria, athletics));
//        pd2.save(new Participation(ParticipationState.CONFIRMED, marta, athletics));
//        pd2.save(new Participation(ParticipationState.CONFIRMED, stefania, athletics));

        List<Concert> streamed = ed.getStreamedConcerts(true);
        streamed.forEach(System.out::println);

        List<Concert> rock = ed.getConcertsByGenre(MusicGenre.ROCK);
        rock.forEach(System.out::println);

//        List<SoccerGame> homeWins = ed.getGamesWonByHomeTeam();
//        List<SoccerGame> guestWins = ed.getGamesWonByGuestTeam();
//        homeWins.forEach(System.out::println);
//        guestWins.forEach(System.out::println);

        em.close();
        emf.close();
    }
}
