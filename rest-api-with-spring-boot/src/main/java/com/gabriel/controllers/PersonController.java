package com.gabriel.controllers;

import com.gabriel.data.vo.v1.PersonVO;
import com.gabriel.data.vo.v2.PersonVO2;
import com.gabriel.models.Person;
import com.gabriel.services.PersonServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //saying to spring, that class are a controller.
@RequestMapping("/person") //all routes of this controller starts with /person
public class PersonController {

    @Autowired
    private PersonServices service; //PersonService injection

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)  //getting all persons
    public List<PersonVO> findAll(){
        return service.findAll();
    }

    @GetMapping(value = "/{id}", //searching by id
                produces = MediaType.APPLICATION_JSON_VALUE)
    public PersonVO findById(@PathVariable(value = "id") Long id){
        return service.findById(id);
    }

    @PostMapping(
                consumes = MediaType.APPLICATION_JSON_VALUE,
                produces = MediaType.APPLICATION_JSON_VALUE) //creating person
    public PersonVO create(@RequestBody PersonVO person){
        return service.create(person);
    }

    /*Endpoint na versão 2 ( versionamento de API ) */
    @PostMapping(value = "/v2",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE) //creating person
    public PersonVO2 createV2(@RequestBody PersonVO2 person){
        return service.createV2(person);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
                produces = MediaType.APPLICATION_JSON_VALUE) //updating by id
    public PersonVO update(@RequestBody PersonVO person){
        return service.update(person); }

    @DeleteMapping(value = "/{id}") //Deleting by id
    public ResponseEntity<?> delete(@PathVariable(value = "id")Long id){
         service.delete(id);

         return ResponseEntity.noContent().build();
    }

}
