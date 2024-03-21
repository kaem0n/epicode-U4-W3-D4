package kaem0n.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import kaem0n.entities.Location;
import kaem0n.exceptions.NotFoundException;

public class LocationDAO {
    private final EntityManager em;

    public LocationDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Location location) {
        EntityTransaction tr = em.getTransaction();
        tr.begin();
        em.persist(location);
        tr.commit();
        System.out.println("Location saved successfully!");
    }

    public Location getById(long locationId) {
        Location location = em.find(Location.class, locationId);
        if (location == null) throw new NotFoundException(locationId);
        else {
            System.out.println(location);
            return location;
        }
    }

    public void delete(long locationId) {
        Location found = this.getById(locationId);
        EntityTransaction tr = em.getTransaction();
        tr.begin();
        em.remove(found);
        tr.commit();
        System.out.println("Location deleted successfully!");
    }
}
