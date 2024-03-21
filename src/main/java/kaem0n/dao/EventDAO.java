package kaem0n.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import kaem0n.entities.Event;
import kaem0n.exceptions.NotFoundException;

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
}
