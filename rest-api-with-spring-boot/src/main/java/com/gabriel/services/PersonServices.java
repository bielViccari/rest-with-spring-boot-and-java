package com.gabriel.services;

import com.gabriel.models.Person;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonServices {
    private final AtomicLong counter = new AtomicLong();
    private Logger logger = Logger.getLogger(PersonServices.class.getName());

    public Person findById(String id) {
        logger.info("finding one person by id");

        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setName("Gabriel");
        person.setLastName("Viccari");
        person.setAddress("Rubiácea-SP");
        person.setGender("Male");
        return person;
    }
}
