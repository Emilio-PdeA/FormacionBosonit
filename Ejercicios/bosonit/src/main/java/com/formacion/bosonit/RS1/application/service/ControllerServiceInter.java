package com.formacion.bosonit.RS1.application.service;

import com.formacion.bosonit.RS1.domain.model.Persona;

import java.util.ArrayList;
import java.util.List;

public interface ControllerServiceInter {

    List<Persona> personaList = new ArrayList<>();

    //POST
    List<Persona> addPersona(Persona persona);

    //PUT
    Persona updatePersona(Integer id, Persona updatePersona);

    //DELETE
    Boolean delPersona(Integer id);

    //GET

    Persona getPersona(String nombre);
    Persona getPersona(Integer id);
    void printLista();


}
