package com.formacion.bosonit.EJ2.infrastructure.controller;

import com.formacion.bosonit.EJ2.application.services.PersonServicesInter;
import com.formacion.bosonit.EJ2.domain.entity.ConsoleColors;
import com.formacion.bosonit.EJ2.domain.exception.PersonUnprocessableException;
import com.formacion.bosonit.EJ2.infrastructure.controller.dto.input.PersonInputDTO;
import com.formacion.bosonit.EJ2.infrastructure.controller.dto.output.PersonOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import java.util.List;

@RestController
@RequestMapping("EJ2")
public class PersonController {

    @Autowired
    PersonServicesInter personServicesInter;

    @GetMapping("listUsers")
    public List<PersonOutputDTO> getListUsers(WebRequest request){
        System.out.println(ConsoleColors.TEXT_GREEN + "\tGET " + request.getDescription(false) + ConsoleColors.TEXT_WHITE);
        return personServicesInter.listUsers();
    }

    @GetMapping("{id}")
    public PersonOutputDTO getPersonaID(@PathVariable Integer id, WebRequest request){
        System.out.println(ConsoleColors.TEXT_GREEN + "\tGET " + request.getDescription(false) + ConsoleColors.TEXT_WHITE);
        PersonOutputDTO person = personServicesInter.findUserId(id);
        return person;

    }

    @GetMapping("user/{user}")
    public PersonOutputDTO getPersonaUser(@PathVariable String user, WebRequest request){
        System.out.println(ConsoleColors.TEXT_GREEN + "\tGET " + request.getDescription(false) + ConsoleColors.TEXT_WHITE);
        PersonOutputDTO person = personServicesInter.findByUser(user);
        return person;
    }

    @PostMapping("addPerson")
    public PersonOutputDTO addPerson(@RequestBody PersonInputDTO personInputDTO, WebRequest request) throws PersonUnprocessableException {
        System.out.println(ConsoleColors.TEXT_CYAN + "\tPOST " + request.getDescription(false) + ConsoleColors.TEXT_WHITE);
        PersonOutputDTO person = personServicesInter.addUser(personInputDTO);
        return person;
    }



}
