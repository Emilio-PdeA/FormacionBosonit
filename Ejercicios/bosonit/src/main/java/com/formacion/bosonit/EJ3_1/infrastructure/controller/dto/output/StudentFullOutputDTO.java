package com.formacion.bosonit.EJ3_1.infrastructure.controller.dto.output;

import com.formacion.bosonit.EJ3_1.domain.entity.Person_EJ3;
import com.formacion.bosonit.EJ3_1.domain.entity.Student_EJ3;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

@Getter @Setter
public class StudentFullOutputDTO {

    // STUDENT OUTPUT DTO
    private String id_student;
    private String id_professor;
    private Integer id_person;
    private Integer num_hours_week;
    private String branch;


    // PERSON OUTPUT DTO
    private String user;
    private String password;
    private String fullname; //persona.name + persona.surname;
    private String companyEmail;
    private String personalEmail;
    private String city;
    private Boolean active;
    private LocalDate createdDate;
    private LocalDate terminationDate;
    private String image_URL;

    public StudentFullOutputDTO(Student_EJ3 student, Person_EJ3 person){
        setId_student(student.getId_student());
        setId_person(student.getId_person());
        setId_professor(student.getId_professor());
        setNum_hours_week(student.getNum_hours_week());
        setBranch(student.getBranch());
        setUser(person.getUser());
        setPassword(person.getPassword());
        setFullname(person.getName() +  person.getSurname());
        setCompanyEmail(person.getCompEmail());
        setPersonalEmail(person.getPersEmail());
        setCity(person.getCity());
        setActive(person.getActive());
        setCreatedDate(person.getCreated_date());
        setTerminationDate(person.getTermination_date());
        setImage_URL(person.getImagen_url());
    }



}
