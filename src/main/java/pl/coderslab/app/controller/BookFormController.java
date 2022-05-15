package pl.coderslab.app.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.coderslab.app.dao.BookDao;
import pl.coderslab.app.dao.PublisherDao;
import pl.coderslab.app.model.Book;
import pl.coderslab.app.model.Publisher;
import pl.coderslab.repository.BookRepository;

import javax.validation.Valid;
import java.util.Collection;

@Controller
@RequestMapping("/form")
public class BookFormController {

    private static final Logger logger = LoggerFactory.getLogger((BookFormController.class));

    private final BookRepository bookRepository;

    private final PublisherDao publisherDao;

    public BookFormController(BookRepository bookRepository, PublisherDao publisherDao) {
        this.bookRepository = bookRepository;
        this.publisherDao = publisherDao;
    }

    @RequestMapping(value = "/book", method = RequestMethod.GET)
    public String getForm(Model model) {
        model.addAttribute("book", new Book());
        return "book";
    }

    @RequestMapping(value = "/book", method = RequestMethod.POST)
    public String handle(@Valid Book book, BindingResult bindingResult) {
        ///sprawdzamy, czy są błędy po walidacji

        if(bindingResult.hasErrors()){
            logger.error("książka ma nieprawidłowe dane");
            return "redirect:/form/book";
        }


        logger.info(book.toString());
        bookRepository.save(book);
        return "success";
    }

    @ModelAttribute("publishers")
    public Collection<Publisher> publishers() {
        return this.publisherDao.findAll();
    }
}