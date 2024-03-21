package kaem0n.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import kaem0n.entities.Concert;
import kaem0n.entities.Event;
import kaem0n.entities.SoccerGame;
import kaem0n.enums.MusicGenre;
import kaem0n.exceptions.NotFoundException;

import java.util.List;

public class EventDAO {
    private final EntityManager em;

    public EventDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Event event) {
        EntityTransaction tr = em.getTransaction();
        tr.begin();
        em.persist(event);
        tr.commit();
        System.out.println("Event saved successfully!");
    }

    public Event getById(long eventId) {
        Event event = em.find(Event.class, eventId);
        if (event == null) throw new NotFoundException(eventId);
        else {
            System.out.println(event);
            return event;
        }
    }

    public void delete(long eventId) {
        Event found = this.getById(eventId);
        EntityTransaction tr = em.getTransaction();
        tr.begin();
        em.remove(found);
        tr.commit();
        System.out.println("Event deleted successfully!");
    }

    public List<Concert> getStreamedConcerts(boolean streaming) {
        TypedQuery<Concert> query = em.createQuery("SELECT c FROM Concert c JOIN Event e ON c.id = e.id WHERE c.streaming = :boolean", Concert.class);
        query.setParameter("boolean", streaming);
        return query.getResultList();
    }

    public List<Concert> getConcertsByGenre(MusicGenre genre) {
        TypedQuery<Concert> query = em.createQuery("SELECT c FROM Concert c JOIN Event e ON c.id = e.id WHERE c.genre = :genre", Concert.class);
        query.setParameter("genre", genre);
        return query.getResultList();
    }

    public List<SoccerGame> getGamesWonByHomeTeam() {
        TypedQuery<SoccerGame> query = em.createQuery("homeWinners", SoccerGame.class);
        return query.getResultList();
    }

    public List<SoccerGame> getGamesWonByGuestTeam() {
        TypedQuery<SoccerGame> query = em.createQuery("guestWinners", SoccerGame.class);
        return query.getResultList();
    }
}
