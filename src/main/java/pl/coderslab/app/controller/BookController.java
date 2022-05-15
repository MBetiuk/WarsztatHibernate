package pl.coderslab.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.app.dao.AuthorDao;
import pl.coderslab.app.dao.BookDao;
import pl.coderslab.app.dao.PublisherDao;
import pl.coderslab.app.model.Author;
import pl.coderslab.app.model.Book;
import pl.coderslab.app.model.Publisher;
import pl.coderslab.repository.BookRepository;

import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class BookController {
    private final BookRepository bookRepository;

    private final AuthorDao authorDao;

    private final PublisherDao publisherDao;

    public BookController(BookRepository bookRepository, AuthorDao authorDao, PublisherDao publisherDao) {
        this.bookRepository = bookRepository;
        this.authorDao = authorDao;
        this.publisherDao = publisherDao;
    }


//    @RequestMapping(value = "/book/add/{title}/{desc}/{rating}", produces = "text/html; charset=UTF-8")
//    @ResponseBody
//    public String addBook(@PathVariable String title, @PathVariable String desc, @PathVariable int rating) {
//        BookRepository bookRepository = new BookRepository();
//        bookRepository.setTitle(title);
//        bookRepository.setDescription(desc);
//        bookRepository.setRating(rating);
//        bookRepository.save(bookRepository);
//        return "Id dodanej książki to: " + bookRepository.getId();
//    }

    @RequestMapping("/book")
    @ResponseBody
    public String add() {

        Publisher publisher = new Publisher();
        publisher.setName("Zysk i S-ka");
        Author author1 = new Author();
        author1.setFirstName("Piotr");
        author1.setLastName("Plebaniak");
        Book book = new Book();
        book.setAuthors(List.of(author1));
        book.setTitle("36 forteli");
        book.setDescription("Jeśli znasz i cenisz traktat Sztuka wojny autorstwa Sun Zi (Sun Tsu), tą książką będziesz zachwycony. Sam autor stwierdza, że książka jest podręcznikiem budowania obrazów mentalnych, a więc esencji wszelkich ludzkich interakcji.");
        book.setRating(7);
        book.setPublisher(publisher);
        bookRepository.save(book);
        return "ready" + book.toString();
    }

//    @RequestMapping("/book/update/{id}/{title}")
//    @ResponseBody
//    public String updateBook(@PathVariable BigInteger id, @PathVariable String title) {
//        BookRepository bookRepository= bookRepository.findById(id);
//        bookRepository.setTitle(title);
//        bookRepository.update(bookRepository);
//        return bookRepository.toString();
//    }

//    @RequestMapping("/book/get/{id}")
//    @ResponseBody
//    public String getBook(@PathVariable BigInteger id) {
//        BookRepository bookRepository= bookRepository.findById(id);
//        return bookRepository.toString();
//    }

//    @RequestMapping("/book/delete/{id}")
//    @ResponseBody
//    public String deleteBook(@PathVariable BigInteger id) {
//        BookRepository bookRepository= bookRepository.findById(id);
//        bookRepository.delete(bookRepository);
//        return "deleted";
//    }

    @GetMapping("/book/findAll")
    @ResponseBody
    public String findAll(@RequestParam(required = false) Integer rating) {

        List<Book> books;
        if (rating != null) {
            books = bookRepository.findAllByRating(rating);
        } else {
            books = bookRepository.findAll();
        }
        return books.stream()
                .map(Book::toString)
                .collect(Collectors.joining(","));
    }
}
