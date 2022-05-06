package com.formacion.bosonit.EJ2.application.services;

import com.formacion.bosonit.EJ2.domain.entity.Person;
import com.formacion.bosonit.EJ2.domain.exception.PersonNotFoundException;
import com.formacion.bosonit.EJ2.domain.exception.PersonUnprocessableException;
import com.formacion.bosonit.EJ2.infrastructure.controller.dto.input.PersonInputDTO;
import com.formacion.bosonit.EJ2.infrastructure.controller.dto.output.PersonOutputDTO;
import com.formacion.bosonit.EJ2.infrastructure.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PersonServices implements PersonServicesInter {

    @Autowired
    PersonRepository personRepository;

    @Override
    public PersonOutputDTO addUser(PersonInputDTO personInputDTO) throws PersonUnprocessableException{
            Optional<Person> person = Optional.of(new Person(personInputDTO));
            try{
                personRepository.save(person.get());
            }catch (NoSuchElementException k){
                throw new PersonUnprocessableException(personInputDTO + " could not be created.");
            }

            PersonOutputDTO personOutputDTO = new PersonOutputDTO(person.get());
            return personOutputDTO;
    }

    @Override
    public PersonOutputDTO findUserId(Integer id){
        Optional<Person> person = Optional.ofNullable(personRepository.findById(id).orElseThrow(() -> new PersonNotFoundException("Person with id: " + id + " not found.")));
        return new PersonOutputDTO(person.get());
    }

    @Override
    public List<PersonOutputDTO> listUsers(){
        List <Person> people = personRepository.findAll();
        return people.stream().map(pp->new PersonOutputDTO(pp)).collect(Collectors.toList());
    }

    @Override
    public PersonOutputDTO findByUser(String user){
    Optional<Person> person = Optional.ofNullable(personRepository.findByUser(user)
                .orElseThrow(() -> new  PersonNotFoundException("Person with username: " + user + " not found.")));
        return new PersonOutputDTO(person.get());
    }




}
