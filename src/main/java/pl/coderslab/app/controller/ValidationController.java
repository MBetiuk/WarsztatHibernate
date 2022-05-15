package pl.coderslab.app.controller;


import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.app.model.Book;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



@Controller
public class ValidationController {


    //tutaj wstrzykujemy nasz walidator, ale żeby to było możliwe, to musimy stworzyc jeszcze jednego beana, który
    // nam stworzy fabrykę, która pomoże potem stworzyć później walidator


    private static final Logger logger = LoggerFactory.getLogger((BookFormController.class));

    private final Validator validator;


    public ValidationController(Validator validator) {
        this.validator = validator;
    }


    @RequestMapping("/validate")
    public String validateBook(){
        Book book = new Book();

        Set<ConstraintViolation<Book>> violations = validator.validate(book);
        if (!violations.isEmpty()) {
            for (ConstraintViolation<Book> constraintViolation : violations) {
                logger.debug(constraintViolation.getPropertyPath() + " "
                        + constraintViolation.getMessage()); }
        } else {
            // save object
        }
        return "validateResult";
    }

    @RequestMapping("/validate2")
    public String validateBook2(List<Book>lista){

        lista = new ArrayList<>();

        Set<ConstraintViolation<List<Book>>> violations = validator.validate(lista);
        if (!violations.isEmpty()) {
            for (ConstraintViolation<List<Book>> constraintViolation : violations) {
                logger.debug(constraintViolation.getPropertyPath() + " "
                        + constraintViolation.getMessage()); }
        } else {
            // save object
        }
        return "moje";
    }
}
