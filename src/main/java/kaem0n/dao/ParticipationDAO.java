package kaem0n.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import kaem0n.entities.Participation;
import kaem0n.exceptions.NotFoundException;

public class ParticipationDAO {
    private final EntityManager em;

    public ParticipationDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Participation participation) {
        EntityTransaction tr = em.getTransaction();
        tr.begin();
        em.persist(participation);
        tr.commit();
        System.out.println("Participation saved successfully!");
    }

    public Participation getById(long participationId) {
        Participation participation = em.find(Participation.class, participationId);
        if (participation == null) throw new NotFoundException(participationId);
        else {
            System.out.println(participation);
            return participation;
        }
    }

    public void delete(long participationId) {
        Participation found = this.getById(participationId);
        EntityTransaction tr = em.getTransaction();
        tr.begin();
        em.remove(found);
        tr.commit();
        System.out.println("Participation deleted successfully!");
    }
}
