package pl.coderslab.app.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.app.model.Person;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.math.BigInteger;

@Repository
@Transactional
public class PersonDao {
    @PersistenceContext
    EntityManager entityManager;

    public void savePerson(Person person) {
        entityManager.persist(person);
    }

    public void update(Person person) {
        entityManager.merge(person);
    }

    public Person findById(BigInteger id) {
        return entityManager.find(Person.class, id);
    }

    public void delete(Person person) {
        entityManager.remove(entityManager.contains(person) ?
                person : entityManager.merge(person));
    }
}
