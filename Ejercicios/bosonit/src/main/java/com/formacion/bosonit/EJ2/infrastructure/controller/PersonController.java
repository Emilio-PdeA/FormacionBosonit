package com.formacion.bosonit.EJ2.infrastructure.controller;


import com.formacion.bosonit.EJ2.infrastructure.controller.dto.input.PersonInputDTO;
import com.formacion.bosonit.EJ2.infrastructure.controller.dto.output.PersonOutputDTO;
import com.formacion.bosonit.EJ2.application.service.PersonServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



import javax.persistence.EntityNotFoundException;
import java.util.List;

@RestController
@RequestMapping("EJ2")
public class PersonController {

    @Autowired
    PersonServices personServices;

    @GetMapping("listUsers")
    public List<PersonOutputDTO> getListUsers(){return personServices.listUsers();}

    @GetMapping("{id}")
    public ResponseEntity getPersonaID(@PathVariable Integer id){
        try{
            return new ResponseEntity(personServices.findUserId(id), HttpStatus.OK);
        }catch (EntityNotFoundException e){
            return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
        }

    }

    @GetMapping("user/{user}")
    public ResponseEntity getPersonaUser(@PathVariable String user){
        try{
            return new ResponseEntity(personServices.findByUser(user),HttpStatus.OK);
        }catch (EntityNotFoundException e){
            return new ResponseEntity(e.getMessage() , HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("addPerson")
    public ResponseEntity addPerson(@RequestBody PersonInputDTO personInputDTO) throws Exception{
        try{
            return new ResponseEntity(personServices.addUser(personInputDTO),HttpStatus.OK) ;
        }catch (Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }



}
