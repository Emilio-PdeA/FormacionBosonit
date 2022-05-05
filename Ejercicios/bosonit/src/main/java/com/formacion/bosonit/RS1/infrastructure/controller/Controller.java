package com.formacion.bosonit.RS1.infrastructure.controller;

import com.formacion.bosonit.RS1.domain.model.Persona;
import com.formacion.bosonit.RS1.application.service.ControllerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("RS1/persona")
public class Controller {

    @Autowired
    ControllerService controllerService = new ControllerService();

    @GetMapping()
    List<Persona> getListaPersona(){
        return controllerService.personaList;
    }

    //GET METHOD
    @GetMapping(path="/nombre/{nombre}")
    Persona getPersonaNombre(@PathVariable String nombre){
       return controllerService.getPersona(nombre);
    }

    @GetMapping(path = "/{id}")
    Persona getPersonaId(@PathVariable Integer id){
        return controllerService.getPersona(id);
    }

    //POST METHOD
    @PostMapping()
    List<Persona> postPersona(@RequestBody Persona persona){
        controllerService.personaList.add(persona);
        return controllerService.personaList;
    }

    //DELETE METHOD
    @DeleteMapping(path = "/{id}")
    String delPersona(@PathVariable Integer id){
        if(controllerService.delPersona(id)){
            return "Persona eliminada!";
        }
        return "ID no existe";
    }

    //PUT METHOD
    @PutMapping("/{id}")
    String upPersona(@PathVariable Integer id, @RequestBody Persona updatePersona){
        controllerService.updatePersona(id,updatePersona);
        return "ok";
    }





}
