package com.gabriel.services;

import com.gabriel.data.vo.v1.PersonVO;
import com.gabriel.data.vo.v2.PersonVO2;
import com.gabriel.mapper.DozerMapper;
import com.gabriel.mapper.custom.PersonMapper;
import com.gabriel.repositories.PersonRepository;
import com.gabriel.exceptions.ResourceNotFoundException;
import com.gabriel.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServices {

    @Autowired
    PersonRepository repository;
    @Autowired
    PersonMapper mapper;

    public List<PersonVO> findAll() {
        return DozerMapper.parseListObjects(repository.findAll(), PersonVO.class);
    }

    public PersonVO findById(Long id) {
        var entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
        return DozerMapper.parseObject(entity, PersonVO.class);
    }

    public PersonVO create(PersonVO person) {

        var entity = DozerMapper.parseObject(person, Person.class);

        return DozerMapper.parseObject(repository.save(entity), PersonVO.class);
    }

    /* Utilizando a V2 da Api, versionamento de Api's*/
    public PersonVO2 createV2(PersonVO2 person) {

        var entity = mapper.convertVoToEntity(person);
        var vo = mapper.convertEntityToVo(repository.save(entity));
        return vo;
    }

    public PersonVO update(PersonVO person) {

        var entity = repository.findById(person.getId())
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));

        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());

        return DozerMapper.parseObject(repository.save(entity), PersonVO.class);
    }

    public void delete(Long id) {

        var entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
        repository.delete(entity);
    }
}
