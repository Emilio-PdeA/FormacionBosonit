package com.formacion.bosonit.EJ3_1.infrastructure.controller;

import com.formacion.bosonit.EJ3_1.application.services.person.PersonServicesInter;
import com.formacion.bosonit.shared.ConsoleColors;
import com.formacion.bosonit.EJ3_1.domain.entity.Person_EJ3;
import com.formacion.bosonit.shared.exception.CustomUnprocessableException;
import com.formacion.bosonit.EJ3_1.infrastructure.controller.dto.input.PersonInputDTO;
import com.formacion.bosonit.EJ3_1.infrastructure.controller.dto.output.PersonOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import java.util.List;

@RestController("PersonControllerEJ3")
@RequestMapping("EJ3")
public class PersonController {

    @Autowired
    @Qualifier("Person")
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
    public PersonOutputDTO addPerson( @RequestBody PersonInputDTO personInputDTO, WebRequest request) throws CustomUnprocessableException {
        System.out.println(ConsoleColors.TEXT_CYAN + "\tPOST " + request.getDescription(false) + ConsoleColors.TEXT_WHITE);
        PersonOutputDTO person = personServicesInter.addUser( personInputDTO);
        return person;
    }

    public Person_EJ3 getPerson(Integer id){
        return personServicesInter.getPerson(id);
    }



}
