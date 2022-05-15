package pl.coderslab.app.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.app.model.Book;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.math.BigInteger;
import java.util.List;

@Repository
@Transactional
public class BookDao {
    @PersistenceContext
    EntityManager entityManager;

    public void saveBook(Book book) {
        entityManager.merge(book);
    }

    public void update(Book book) {
        entityManager.merge(book);
    }

    public Book findById(BigInteger id) {
        return entityManager.find(Book.class, id);
    }

    public void delete(Book book) {
        entityManager.remove(entityManager.contains(book) ?
        book : entityManager.merge(book));
    }

    public List<Book> findAll() {
        Query query = entityManager.createQuery("SELECT b FROM Book b");
        return query.getResultList();
    }

    public List<Book> findAllByRating(int rating) {
        return entityManager
                .createQuery("SELECT b from Book b where b.rating = :rating")
                .setParameter("rating", rating)
                .getResultList();
    }

    public List<Book> findAllAnyPublisher() {
        return entityManager
                .createQuery("SELECT b from Book b where b.publisher is not null")
                .getResultList();
    }

    public List<Book> findAllPublisher(String publisher) {
        return entityManager
                .createQuery("SELECT b from Book b where b.publisher =: publisher")
                .setParameter("publisher", publisher)
                .getResultList();
    }
    public List<Book> findAllAuthor(String author) {
        return entityManager
                .createQuery("SELECT distinct b FROM Book b join FETCH b.authors WHERE :author member of b.authors")
                .setParameter("author", author)
                .getResultList();
    }
}
