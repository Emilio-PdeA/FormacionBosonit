package com.formacion.bosonit.EJ2.application.service;

import com.formacion.bosonit.EJ2.domain.entity.Person;
import com.formacion.bosonit.EJ2.infrastructure.repository.PersonRepository;
import com.formacion.bosonit.EJ2.infrastructure.controller.dto.output.PersonOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

public class FindPersonUseCase implements FindPersonService{

    @Autowired
    PersonRepository personRepository;

    @Override
    public PersonOutputDTO findUserID(Integer id) {
        Optional<Person> person = Optional.ofNullable(personRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("{\"message_Error\":\"User " + id + " not found.\"}")));
        return new PersonOutputDTO(person.get());
    }

    @Override
    public PersonOutputDTO findUserName(String user) {
        Optional<Person> person = Optional.ofNullable(personRepository.findByUser(user)
                                .orElseThrow(() -> new EntityNotFoundException("{\"message_Error\":\"User " + user + " does not exist.\"}")));
        return new PersonOutputDTO(person.get());
    }
}
