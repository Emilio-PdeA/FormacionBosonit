package com.formacion.bosonit.BS2.application.service;

import com.formacion.bosonit.BS2.domain.entity.Persona;
import org.springframework.stereotype.Service;

@Service
public class ServicePersonas {

    private Persona persona = new Persona();

    public void setPersona(Persona pers){
        this.persona = pers;
        persona.setEdad(2 * persona.getEdad());
    }

    public Persona getPersona(){
        return persona;
    }

}
