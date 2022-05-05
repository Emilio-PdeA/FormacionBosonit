package com.formacion.bosonit.RS1.application.service;

import com.formacion.bosonit.RS1.domain.model.Persona;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class ControllerService implements ControllerServiceInter {

    public List<Persona> personaList = new ArrayList<>();

    @PostConstruct
    public void createMemoryDb(){
        addPersona(new Persona("Emilio","San Sebastian",24));
        addPersona(new Persona("Alicia","Pamplona",21));
    }

    @Override
    public List<Persona> addPersona(Persona persona) {
        personaList.add(persona);
        return personaList;
    }

    @Override
    public Persona updatePersona(Integer id, Persona updatePersona) {
        if (personaList.size()>id) {
            Persona pp =  personaList.get(id);
            pp.setPersona(updatePersona);
            return pp;
        }
        return null;
    }

    @Override
    public Boolean delPersona(Integer id) {
        if (personaList.size()>id){
            Persona pp = personaList.get(id);
            personaList.remove(pp);
            return true;
        }
        return false;
    }

    @Override
    public Persona getPersona(String nombre) {
        for (Persona pp: personaList){
            if (nombre.equals(pp.getNombre())) return pp;
        }
        return new Persona("null","null",null);
    }
    @Override
    public Persona getPersona(Integer id){
        if (personaList.size()>id) {
            return personaList.get(id);
        }
        return new Persona("null","null",null);
    }

    @Override
    public void printLista(){
        for(Persona pp : personaList){
            System.out.println(pp.toString());
        }
    }
}
