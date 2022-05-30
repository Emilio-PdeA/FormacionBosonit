package com.formacion.bosonit.EJ3_1.infrastructure.controller.dto.output;

import com.formacion.bosonit.EJ3_1.domain.entity.Professor_EJ3;
import com.formacion.bosonit.EJ3_1.domain.entity.Student_EJ3;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter @Setter
public class ProfessorOutputDTO {

    private String id_professor;
    private Integer id_person;
    private String comments;
    private String branch;
    private List<CourseOutputDTO> courses;
    private List<StudentOutputDTO> students;


    public ProfessorOutputDTO(Professor_EJ3 professor){
        setId_professor(professor.getId_professor());
        setId_person(professor.getId_person());
        setComments(professor.getComments());
        setBranch(professor.getBranch());
        setCourses(professor.getCourses());
        setStudents(professor.getStudents());

    }

}
