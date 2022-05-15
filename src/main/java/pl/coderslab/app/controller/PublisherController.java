package pl.coderslab.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.app.dao.PublisherDao;
import pl.coderslab.app.model.Publisher;

import java.math.BigInteger;

@Controller
public class PublisherController {

    private final PublisherDao publisherDao;
    public PublisherController(PublisherDao publisherDao) {
        this.publisherDao = publisherDao;
    }

    @RequestMapping("/publisher/add/{name}")
    @ResponseBody
    public String addBook(@PathVariable String name) {
        Publisher publisher = new Publisher();
        publisher.setName(name);
        publisherDao.savePublishers(publisher);
        return "Id dodanej ksiazki to: " + publisher.getId();
    }

    @RequestMapping("/publisher/update/{id}/{name}")
    @ResponseBody
    public String updatePublisher(@PathVariable BigInteger id, @PathVariable String name) {
        Publisher publisher = publisherDao.findById(id);
        publisher.setName(name);
        publisherDao.update(publisher);
        return publisher.toString();
    }

    @RequestMapping("/publisher/get/{id}")
    @ResponseBody
    public String getPublisher(@PathVariable BigInteger id) {
        Publisher publisher = publisherDao.findById(id);
        return publisher.toString();
    }

    @RequestMapping("/publisher/delete/{id}")
    @ResponseBody
    public String deletePublisher(@PathVariable BigInteger id) {
        Publisher publisher = publisherDao.findById(id);
        publisherDao.delete(publisher);
        return "deleted";
    }
}
