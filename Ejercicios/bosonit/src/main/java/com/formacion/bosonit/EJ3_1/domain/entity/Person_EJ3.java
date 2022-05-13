package com.formacion.bosonit.EJ3_1.domain.entity;

import com.formacion.bosonit.shared.exception.CustomUnprocessableException;
import com.formacion.bosonit.EJ3_1.infrastructure.controller.dto.input.PersonInputDTO;
import lombok.Data;
import lombok.NonNull;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "Persons_EJ3")
public class Person_EJ3 {

    @Id @GeneratedValue
    @Column(name = "ID")
    private Integer id_person;

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
    LocalDate created_date;

    String imagen_url;

    LocalDate termination_date;

    public void setUser(String usr) throws CustomUnprocessableException {
        if (usr == null){throw new CustomUnprocessableException("Key \'user\' cannot be null");}
        if (usr.length()>10){throw new CustomUnprocessableException("Length of user must not exceed 10 characters.");}
        if(usr.length()<6){throw new CustomUnprocessableException("Length of user must be greater than 6.");}
        this.user=usr;
    }

    public void setPassword(String pwd) throws CustomUnprocessableException {
        if (pwd==null){
      throw new CustomUnprocessableException("\"password\" cannot be null");
    }
        this.password=pwd;
    }

    public void setCompEmail(String compEmail) throws CustomUnprocessableException {
        if(compEmail==null){
      throw new CustomUnprocessableException("Key \'company_email\' cannot be null");
    }
        this.compEmail = compEmail;
    }

    public void setPersEmail(String persEmail) throws CustomUnprocessableException {
        if (persEmail==null){
      throw new CustomUnprocessableException("Key \'personal_email\' cannot be null");
    }
        this.persEmail=persEmail;
    }

    public void setCity(String city) throws CustomUnprocessableException {
        if(city==null){
      throw new CustomUnprocessableException("Key \'city\' cannot be null");
    }
        this.city=city;
    }

    public void setCreated_date() throws CustomUnprocessableException {
        this.created_date = LocalDate.now();
    }

    public String getSurname() {
        if (this.surname == null) return "";
        return " " + surname;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id_persona=" + id_person +
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

    public Person_EJ3(){}
    public Person_EJ3(PersonInputDTO personInputDTO) throws CustomUnprocessableException {
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
