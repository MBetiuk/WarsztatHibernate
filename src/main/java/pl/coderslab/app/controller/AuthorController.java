package pl.coderslab.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.app.dao.AuthorDao;
import pl.coderslab.app.model.Author;

import java.math.BigInteger;

@Controller
public class AuthorController {

    private final AuthorDao authorDao;
    public AuthorController(AuthorDao authorDao) {
        this.authorDao = authorDao;
    }

    @RequestMapping("/author/add/{firstName}/{lastName}")
    public String addAuthor(@PathVariable String firstName, @PathVariable String lastName) {
        Author author = new Author();
        author.setFirstName(firstName);
        author.setLastName(lastName);
        authorDao.saveAuthor(author);
        return "Id dodanego autora to: " + author.getId();
    }

    @RequestMapping("/author/{id}/{firstName}")
    @ResponseBody
    public String updateAuthor(@PathVariable BigInteger id, @PathVariable String firstName) {
        Author author = authorDao.findById(id);
        author.setFirstName(firstName);
        authorDao.update(author);
        return author.toString();
    }

    @RequestMapping("/author/get/{id}")
    @ResponseBody
    public String getAuthor(@PathVariable BigInteger id) {
        Author author = authorDao.findById(id);
        return author.toString();
    }

    @RequestMapping("/author/delete/{id}")
    @ResponseBody
    public String deleteAuthor(@PathVariable BigInteger id) {
        Author author = authorDao.findById(id);
        authorDao.delete(author);
        return "deleted";
    }

}
