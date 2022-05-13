package com.formacion.bosonit.EJ3_1.infrastructure.controller.dto.output;

import com.formacion.bosonit.EJ3_1.domain.entity.Person_EJ3;
import com.formacion.bosonit.EJ3_1.domain.entity.Professor_EJ3;
import com.formacion.bosonit.EJ3_1.domain.entity.Student_EJ3;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter @Setter
public class ProfessorFullOutputDTO {

    private String id_professor;
    private Integer id_person;
    private String comments;
    private String branch;
    private List<StudentFullOutputDTO> students;

    //PERSON OUTPUT DTO
    private String user;
    private String password;
    private String fullname;
    private String companyEmail;
    private String personalEmail;
    private String city;
    private Boolean active;
    private LocalDate createdDate;
    private LocalDate terminationDate;
    private String image_URL;


    //CONSTRUCTOR
    public ProfessorFullOutputDTO(Professor_EJ3 prof, Person_EJ3 person){
        setId_professor(prof.getId_professor());
        setId_person(prof.getId_person());
        setComments(prof.getComments());
        setBranch(prof.getBranch());
        setStudents(prof.getFullStudents());
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
