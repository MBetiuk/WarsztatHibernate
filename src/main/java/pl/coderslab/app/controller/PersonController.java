package pl.coderslab.app.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.app.dao.PersonDao;
import pl.coderslab.app.model.Person;

@Controller
public class PersonController {

    private static final Logger logger = LoggerFactory.getLogger((PersonController.class));

    private final PersonDao personDao;

    public PersonController(PersonDao personDao) {
        this.personDao = personDao;
    }
//
//    @RequestMapping(value = "/person/add/{login}/{password}/{email}", produces = "text/html; charset=UTF-8")
//    @ResponseBody
//    public String addBook(@PathVariable String login, @PathVariable String password, @PathVariable String email) {
//        Person person = new Person();
//        person.setLogin(login);
//        person.setPassword(password);
//        person.setEmail(email);
//        personDao.savePerson(person);
//        return "ready" + person.toString();
//    }
//
//    @RequestMapping("/person/update/{id}/{login}")
//    @ResponseBody
//    public String updateBook(@PathVariable BigInteger id, @PathVariable String login) {
//        Person person = personDao.findById(id);
//        person.setLogin(login);
//        personDao.update(person);
//        return person.toString();
//    }
//
//    @RequestMapping("/person/get/{id}")
//    @ResponseBody
//    public String getBook(@PathVariable BigInteger id) {
//        Person person = personDao.findById(id);
//        return person.toString();
//    }
//
//    @RequestMapping("/person/delete/{id}")
//    @ResponseBody
//    public String deleteBook(@PathVariable BigInteger id) {
//        Person person = personDao.findById(id);
//        personDao.delete(person);
//        return "deleted";
//    }

    @RequestMapping(value = "/form/person", method = RequestMethod.GET)
    public String getForm() {
        logger.info("returning view ");
        return "person";
    }

    @RequestMapping(value = "/person", method = RequestMethod.POST)
    public String savePerson(Person person) {
//        Person person = new Person();
//        person.setLogin(login);
//        person.setPassword(password);
//        person.setEmail(email);
        personDao.savePerson(person);
        return "success";
    }

    //Utwórz kontroler, realizujący operacje CRUD (create, read, update, delete).

}
