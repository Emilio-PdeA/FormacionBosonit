package com.formacion.bosonit.EJ2.infrastructure.controller.dto.output;

import com.formacion.bosonit.EJ2.domain.entity.Person;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class PersonOutputDTO {

    private Integer id;
    private String user;
    private String fullname;
    private String company_email;
    private String personal_email;
    private String city;
    private Boolean active;
    private String imagen_url;
    private Date created_date;
    private Date termination_date;

    public PersonOutputDTO(){}

    public PersonOutputDTO(Person person){
        setId(person.getId_persona());
        setUser(person.getUser());
        setFullname(person.getName() + person.getSurname());
        setCompany_email(person.getCompEmail());
        setPersonal_email(person.getPersEmail());
        setCity(person.getCity());
        setActive(person.getActive());
        setImagen_url(person.getImagen_url());
        setCreated_date(person.getCreated_date());
        setTermination_date(person.getTermination_date());
    }


}
