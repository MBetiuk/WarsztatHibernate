package pl.coderslab.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.coderslab.app.dao.PublisherDao;
import pl.coderslab.app.model.Publisher;

import java.math.BigInteger;

public class PublisherConverter implements Converter<String, Publisher> {

    @Autowired
    private PublisherDao publisherDao;
    @Override
    public Publisher convert(String source) {
        return publisherDao.findById(BigInteger.valueOf(Integer.parseInt(source)));
    }
}