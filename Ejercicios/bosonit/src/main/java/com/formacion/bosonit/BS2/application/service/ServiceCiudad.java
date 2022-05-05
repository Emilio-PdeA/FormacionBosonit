package com.formacion.bosonit.BS2.application.service;

import com.formacion.bosonit.BS2.domain.entity.Ciudad;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class ServiceCiudad {

    private List<Ciudad> ciudadList = new ArrayList<>();

    @PostConstruct
    public void initServCiudad(){
        addCiudad(new Ciudad("Madrid",180));
        addCiudad(new Ciudad("Mexico",300));
    }

    public void addCiudad(Ciudad ciudad){
        ciudadList.add(ciudad);
    }

    public List<Ciudad> getCiudades(){
        return ciudadList;
    }


}
