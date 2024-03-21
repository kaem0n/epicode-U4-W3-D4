package kaem0n.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import kaem0n.entities.Person;
import kaem0n.exceptions.NotFoundException;

public class PersonDAO {
    private final EntityManager em;

    public PersonDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Person person) {
        EntityTransaction tr = em.getTransaction();
        tr.begin();
        em.persist(person);
        tr.commit();
        System.out.println("Person saved successfully!");
    }

    public Person getById(long personId) {
        Person person = em.find(Person.class, personId);
        if (person == null) throw new NotFoundException(personId);
        else {
            System.out.println(person);
            return person;
        }
    }

    public void delete(long personId) {
        Person found = this.getById(personId);
        EntityTransaction tr = em.getTransaction();
        tr.begin();
        em.remove(found);
        tr.commit();
        System.out.println("Person deleted successfully!");
    }
}
