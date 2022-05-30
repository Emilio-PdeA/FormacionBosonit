package com.formacion.bosonit.EJ3_1.domain.entity;

import com.formacion.bosonit.shared.exception.CustomUnprocessableException;
import com.formacion.bosonit.EJ3_1.infrastructure.controller.dto.input.StudentInputDTO;
import com.formacion.bosonit.shared.sequences.StringPrefixedSequenceIdGenerator;
import org.hibernate.annotations.Parameter;
import lombok.Data;
import lombok.NonNull;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Entity @Data
@Table(name = "Students_EJ3")
public class Student_EJ3 {


    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "students_seq")
    @GenericGenerator(
            name = "students_seq",
            strategy = "com.formacion.bosonit.shared.sequences.StringPrefixedSequenceIdGenerator",
            parameters = {
                    @Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "1"),
                    @Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "STD"),
                    @Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%05d")
            })
    private String id_student;


    @OneToOne @JoinColumn(name = "id_person")
    private Person_EJ3 id_person;

    @Column(name = "hours_per_Week")
    @NonNull
    private Integer num_hours_week;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "professor")
    private Professor_EJ3 professor;


    @Column @NonNull
    private String branch;

    @OneToMany
    List<Course_EJ3> courses;


    public void setBranch(String branch) throws CustomUnprocessableException{
        if (branch==null){throw new CustomUnprocessableException("Key \'branch\' cannot be null");}
        this.branch=branch;
    }

    public void setNum_hours_week(Integer num_hours)
        throws CustomUnprocessableException{
        if(num_hours==null){
            throw new CustomUnprocessableException("Key \'branch\' cannot be null");
        }
        this.num_hours_week=num_hours;
    }

    public Integer getId_person(){
        return id_person.getId_person();
    }
    public String getId_professor(){return professor.getId_professor();}
    public Person_EJ3 getPerson(){return id_person;}

    public Student_EJ3(){}
    public Student_EJ3(StudentInputDTO studentInputDTO, Person_EJ3 person,Professor_EJ3 prof){
        setId_person(person);
        setProfessor(prof);
        setNum_hours_week(studentInputDTO.getNum_hours_week());
        setBranch(studentInputDTO.getBranch());
    }
}
