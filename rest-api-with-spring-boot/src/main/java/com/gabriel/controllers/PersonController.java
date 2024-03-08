package com.gabriel.controllers;

import com.gabriel.models.Person;
import com.gabriel.services.PersonServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //saying to spring, that class are a controller.
@RequestMapping("/person") //all routes of this controller starts with /person
public class PersonController {

    @Autowired
    private PersonServices service; //PersonService injection

    @RequestMapping(method = RequestMethod.GET, //getting all persons
            produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Person> findAll(){
        return service.findAll();
    }

    @RequestMapping(value = "/{id}", //searching by id
                    method = RequestMethod.GET,
                    produces = MediaType.APPLICATION_JSON_VALUE)
    public Person findById(@PathVariable(value = "id") String id){
        return service.findById(id);
    }

    @RequestMapping(method = RequestMethod.POST, //creating person
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Person create(@RequestBody Person person){
        return service.create(person);
    }

    @RequestMapping(method = RequestMethod.PUT, //updating by id
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Person update(@RequestBody Person person){
        return service.update(person); }

    @RequestMapping(value = "/{id}",
            method = RequestMethod.DELETE) //Deleting by id
    public void delete(@PathVariable(value = "id")String id){
         service.delete(id);
    }

}
