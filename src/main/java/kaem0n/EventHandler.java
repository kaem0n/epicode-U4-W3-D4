package kaem0n;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import kaem0n.dao.EventDAO;
import kaem0n.dao.LocationDAO;
import kaem0n.dao.ParticipationDAO;
import kaem0n.dao.PersonDAO;
import kaem0n.entities.*;

import java.time.LocalDate;

public class EventHandler {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("eventhandler");
    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();
        EventDAO ed = new EventDAO(em);
        PersonDAO pd1 = new PersonDAO(em);
        ParticipationDAO pd2 = new ParticipationDAO(em);
        LocationDAO ld = new LocationDAO(em);

//        ld.save(new Location("Teatro Ariston", "Sanremo"));
//        ld.save(new Location("Arena di Verona", "Verona"));
//        Location ariston = ld.getById(1);
//        Location arenaDiVerona = ld.getById(2);

//        ed.save(new Event("Metallica concert", LocalDate.now(), "World tour 2024", EventType.PUBLIC, 20000, arenaDiVerona));
//        ed.save(new Event("Festivalbar", LocalDate.now(), "Estate 2024", EventType.PUBLIC, 20000, arenaDiVerona));
//        ed.save(new Event("Festival di Sanremo", LocalDate.parse("2024-02-10"), "Edizione 2024 del Festival di Sanremo", EventType.PRIVATE, 1800, ariston));
//        ed.delete(1);
//        ed.delete(2);
//        Event sanremo = ed.getById(3);
//        Event metallica = ed.getById(4);

//        pd1.save(new Person("Mario", "Rossi", "mario@rossi.it", LocalDate.parse("1980-01-01"), Gender.MALE));
//        pd1.save(new Person("Maria", "Bianchi", "maria@bianchi.it", LocalDate.parse("1990-01-01"), Gender.FEMALE));
//        Person mario = pd1.getById(1);
//        Person maria = pd1.getById(2);

//        pd2.save(new Participation(ParticipationState.TO_CONFIRM, maria, sanremo));
//        pd2.save(new Participation(ParticipationState.CONFIRMED, maria, metallica));
//        pd2.save(new Participation(ParticipationState.CONFIRMED, mario, metallica));
//        Participation p1 = pd2.getById(1);
//        Participation p2 = pd2.getById(2);
//        Participation p3 = pd2.getById(3);

//        System.out.println(p2.getPerson());

//        Event festivalbar = ed.getById(5);
//        System.out.println(festivalbar);

        em.close();
        emf.close();
    }
}
