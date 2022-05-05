package com.formacion.bosonit.BS2.infrastructure.controller;

import com.formacion.bosonit.BS2.application.service.ServiceCiudad;
import com.formacion.bosonit.BS2.application.service.ServicePersonas;
import com.formacion.bosonit.BS2.domain.entity.Ciudad;
import com.formacion.bosonit.BS2.domain.entity.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "BS2/controlador1")
@Component
//@Scope(value = "prototype")
public class Controlador1 {

    public static final String CYAN = "\033[0;36m";    // CYAN
    static final String urlBase = "/controlador1";
    @Autowired
    Controlador2 contr2;

    @Autowired
    ServicePersonas servPersonas;

    @Autowired
    ServiceCiudad servCiudad;

    /*
     * METHOD: POST
     * Test URL: localhost:8080/controlador1/addPersona
     * BODY (JSON): {"nombre":$nombre, "ciudad":$ciudad, "edad":$edad}
     * RESPONSE: {"msg":"Persona agregada"}
     * */
    @PostMapping(path = "/addPersona", consumes = "application/json")
    public ResponseEntity<Persona> addPersona(@RequestBody Persona persona){
        servPersonas.setPersona(persona);
        System.out.println(CYAN +"POST: " + urlBase + "/addPersona");
        return new ResponseEntity<>(servPersonas.getPersona(), HttpStatus.OK);
    }

    /*
     * METHOD: POST
     * Test URL: localhost:8080/controlador1/addCiudad
     * BODY (JSON): {"nombre":$nombre, "numeroHabitantes":#numHabitantes}
     * RESPONSE: {"msg":"Ciudad Agregada"}
     * */
    @PostMapping(path = "/addCiudad", consumes = "application/json")
    public ResponseEntity<List<Ciudad>> addCiudad(@RequestBody Ciudad ciudad){
        System.out.println(CYAN + "POST: " + urlBase + "/addCiudad");
        servCiudad.addCiudad(ciudad);
    return new ResponseEntity<>(servCiudad.getCiudades(), HttpStatus.OK);
    }

    public Controlador1(){}


}
