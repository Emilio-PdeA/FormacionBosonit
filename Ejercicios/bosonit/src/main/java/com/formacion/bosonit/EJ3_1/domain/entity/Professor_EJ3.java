package com.formacion.bosonit.EJ3_1.domain.entity;

import com.formacion.bosonit.EJ3_1.infrastructure.controller.dto.input.ProfessorInputDTO;
import com.formacion.bosonit.EJ3_1.infrastructure.controller.dto.output.CourseOutputDTO;
import com.formacion.bosonit.EJ3_1.infrastructure.controller.dto.output.StudentFullOutputDTO;
import com.formacion.bosonit.EJ3_1.infrastructure.controller.dto.output.StudentOutputDTO;
import com.formacion.bosonit.EJ3_1.infrastructure.repository.PersonRepository_EJ3;
import com.formacion.bosonit.shared.exception.CustomNotFoundException;
import com.formacion.bosonit.shared.sequences.StringPrefixedSequenceIdGenerator;
import lombok.Data;
import lombok.NonNull;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.hibernate.annotations.CascadeType.REMOVE;

@Entity @Data
@Table (name = "Professors_EJ3")
public class Professor_EJ3 {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "professors_seq")
    @GenericGenerator(
            name = "professors_seq",
            strategy = "com.formacion.bosonit.shared.sequences.StringPrefixedSequenceIdGenerator",
            parameters = {
                    @Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "1"),
                    @Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "PROF"),
                    @Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%05d")
            })
    private String id_professor;

    @OneToOne
    @JoinColumn(name = "id_persona")
    private Person_EJ3 id_person;

    @Column
    private String comments;

    @Column @NonNull
    private String branch;

    @OneToMany(mappedBy = "professor", cascade = CascadeType.REMOVE)
    private List<Student_EJ3> students = new ArrayList<>();

    @OneToMany(mappedBy = "professor", cascade = CascadeType.REMOVE)
    private List<Course_EJ3> courses = new ArrayList<>();


    public Integer getId_person() {
        return id_person.getId_person();
    }

    public List<StudentOutputDTO> getStudents() {
        return students.stream().map(st->new StudentOutputDTO(st)).collect(Collectors.toList());
    }

    public List<CourseOutputDTO> getCourses(){
        return courses.stream()
                .map(crs -> new CourseOutputDTO(crs))
                .collect(Collectors.toList());
    }

    public List<StudentFullOutputDTO> getFullStudents(){
        return students.stream().map(st->new StudentFullOutputDTO(st,id_person)).collect(Collectors.toList());
    }

    public Person_EJ3 getPerson(){
        return id_person;
    }

    public Professor_EJ3(){}
    public Professor_EJ3(ProfessorInputDTO professorInputDTO, Person_EJ3 person){
        setId_person(person);
        setComments(professorInputDTO.getComments());
        setBranch(professorInputDTO.getBranch());
    }

}
