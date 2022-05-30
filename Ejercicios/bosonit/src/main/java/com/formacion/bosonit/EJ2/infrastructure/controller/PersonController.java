package com.formacion.bosonit.EJ2.infrastructure.controller;

import com.formacion.bosonit.EJ2.application.services.PersonServicesInter;
import com.formacion.bosonit.EJ2.domain.entity.Person;
import com.formacion.bosonit.EJ2.domain.exception.PersonUnprocessableException;
import com.formacion.bosonit.EJ2.infrastructure.controller.dto.input.PersonInputDTO;
import com.formacion.bosonit.EJ2.infrastructure.controller.dto.output.PersonOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("EJ2")
public class PersonController {

    @Autowired
    PersonServicesInter personServicesInter;

    @GetMapping("listUsers")
    public List<PersonOutputDTO> getListUsers(){

        return personServicesInter.listUsers();
    }

    @GetMapping("{id}")
    public PersonOutputDTO getPersonaID(@PathVariable Integer id){

        Person person=personServicesInter.findUserId(id);
        return person.toOutputDto();

    }

    @GetMapping("user/{user}")
    public PersonOutputDTO getPersonaUser(@PathVariable String user){
        Person person=personServicesInter.findByUser(user);
        return person.toOutputDto();
    }




    @PostMapping("addPerson")
    public PersonOutputDTO addPerson(@RequestBody PersonInputDTO personInputDTO) throws PersonUnprocessableException {

        Person person=personServicesInter.addUser(personInputDTO);
        return person.toOutputDto();
    }



}
