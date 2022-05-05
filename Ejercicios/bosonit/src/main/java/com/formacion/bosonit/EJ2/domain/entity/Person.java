package com.formacion.bosonit.EJ2.domain.entity;


import com.formacion.bosonit.EJ2.infrastructure.controller.dto.input.PersonInputDTO;
import lombok.Data;
import lombok.NonNull;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@Entity
@Table(name = "Persons")
public class Person {

    @Id @GeneratedValue
    @Column(name = "ID")
    private int id_persona;

    @NonNull
    @Column(name = "usuario")
    String user;

    @NonNull
    String password;

    @NonNull
    String name;

    String surname;

    @NonNull
    @Column(name = "company_email")
    String compEmail;

    @Column(name = "personal_email")
    @NonNull
    String persEmail;

    @NonNull
    String city;

    @NonNull
    Boolean active;

    @NonNull
    Date created_date;

    String imagen_url;

    Date termination_date;

    public void setUser(String usr) throws Exception{
        if (usr == null){throw new Exception("User cannot be null");}
        if (usr.length()>10){throw new Exception("Length of user must not exceed 10 characters.");}
        if(usr.length()<6){throw new Exception("Length of user must be greater than 6.");}
        this.user=usr;
    }

    public void setPassword(String pwd) throws Exception{
        if (pwd==null){throw new Exception("Password cannot be null");}
        this.password=pwd;
    }

    public void setCompEmail(String compEmail) throws Exception{
        if(compEmail==null){throw new Exception("Company Email cannot be null");}
        this.compEmail = compEmail;
    }

    public void setPersEmail(String persEmail) throws Exception{
        if (persEmail==null){throw new Exception("Personal Email cannto be null");}
        this.persEmail=persEmail;
    }

    public void setCity(String city) throws Exception{
        if(city==null){throw new Exception("City cannot be null");}
        this.city=city;
    }

    public void setCreated_date() throws Exception{
        LocalDateTime now = LocalDateTime.now();
        this.created_date = new Date();
    }

    public String getSurname() {
        if (this.surname == null) return "";
        return " " + surname;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id_persona=" + id_persona +
                ", user='" + user + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", compEmail='" + compEmail + '\'' +
                ", persEmail='" + persEmail + '\'' +
                ", city='" + city + '\'' +
                ", active=" + active +
                ", created_date=" + created_date +
                ", imagen_url='" + imagen_url + '\'' +
                ", termination_date=" + termination_date +
                '}';
    }

    public Person(){}
    public Person(PersonInputDTO personInputDTO) throws Exception{
        setUser(personInputDTO.getUser());
        setPassword(personInputDTO.getPassword());
        setName(personInputDTO.getName());
        setSurname(personInputDTO.getSurname());
        setCompEmail(personInputDTO.getCompany_email());
        setPersEmail(personInputDTO.getPersonal_email());
        setCity(personInputDTO.getCity());
        setActive(personInputDTO.getActive());
        setCreated_date();
        setImagen_url(personInputDTO.getImagen_url());

    }


}
