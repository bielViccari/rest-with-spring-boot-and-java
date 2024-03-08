package com.gabriel.services;

import com.gabriel.models.Person;
import org.apache.juli.logging.Log;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonServices {
    private final AtomicLong counter = new AtomicLong();
    private Logger logger = Logger.getLogger(PersonServices.class.getName());

    public List<Person> findAll() {
        List<Person> persons = new ArrayList<>();
        logger.info("Getting all persons");
        for (int i = 0; i < 8; i++) {
            Person person = mockPerson(i);
            persons.add(person);
        }
        return persons;
    }

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

    public Person create(Person person) {
        logger.info("Deleting one person");
        return person;
    }

    public Person update(Person person) {
        logger.info("Updating one person");
        return person;
    }

    public void delete(String id) {
        logger.info("Deleting one person");
    }

    private Person mockPerson(int i) {
        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setName("person name " + i);
        person.setLastName("person lastName " + i);
        person.setAddress("person address " + i);
        person.setGender("person gender " + i);
        return person;
    }

}
