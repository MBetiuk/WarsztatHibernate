package pl.coderslab.app.dao;


import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.app.model.Publisher;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.math.BigInteger;
import java.util.List;

@Repository
@Transactional
public class PublisherDao {

    @PersistenceContext
    EntityManager entityManager;

    public void savePublishers(Publisher publisher) {
        entityManager.persist(publisher);
    }

    public void update(Publisher publisher) {
        entityManager.merge(publisher);
    }

    public Publisher findById(BigInteger id) {
        return entityManager.find(Publisher.class, id);
    }

    public void delete(Publisher publisher) {
        entityManager.remove(!entityManager.contains(publisher) ?
                entityManager.merge(publisher) : publisher);
    }

    public List<Publisher> findAll() {
        Query query = entityManager.createQuery("SELECT p FROM Publisher p");
        return query.getResultList();
    }

}
