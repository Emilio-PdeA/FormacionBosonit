package com.formacion.bosonit.BS2.infrastructure.controller;

import com.formacion.bosonit.BS2.application.service.ServiceCiudad;
import com.formacion.bosonit.BS2.application.service.ServicePersonas;
import com.formacion.bosonit.BS2.domain.entity.Ciudad;
import com.formacion.bosonit.BS2.domain.entity.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("BS2/controlador2")
@Component
//@Scope(value = "prototype")
public class Controlador2 {

    public static final String GREEN = "\033[0;32m";
    static final String urlBase = "/controlador2";

    @Autowired
    ServiceCiudad servCiudad;

    @Autowired
    ServicePersonas servPersona;

    /*
     * METHOD: GET
     * Test URL: localhost:8080/controlador2/getPersona
     * Response: Object<Persona>
     */
    @GetMapping("/getPersona")
    public Persona getPerson(){
        System.out.println(GREEN + "GET: " + urlBase + "/getPersona");
        return servPersona.getPersona();
    }

    /*
     * METHOD: GET
     * Test URL: localhost:8080/controlador2/getCiudad
     * Response: List<Ciudad>
     */
    @GetMapping(path ="/getCiudad")
    public List<Ciudad> getCiudad(){
        System.out.println(GREEN + "GET: " + urlBase + "/getCiudad");
        return servCiudad.getCiudades();
    }

    public Controlador2(){}


}
