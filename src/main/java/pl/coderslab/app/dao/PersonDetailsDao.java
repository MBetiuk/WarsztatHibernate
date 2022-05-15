package pl.coderslab.app.dao;

import pl.coderslab.app.model.PersonDetails;

import javax.persistence.EntityManager;
import java.math.BigInteger;

public class PersonDetailsDao {

    EntityManager entityManager;

    public void savePerson(PersonDetails personDetails) {
        entityManager.persist(personDetails);
    }

    public void update(PersonDetails personDetails) {
        entityManager.merge(personDetails);
    }

    public PersonDetails findById(BigInteger id) {
        return entityManager.find(PersonDetails.class, id);
    }

    public void delete(PersonDetails personDetails) {
        entityManager.remove(entityManager.contains(personDetails) ?
                personDetails : entityManager.merge(personDetails));
    }
}
