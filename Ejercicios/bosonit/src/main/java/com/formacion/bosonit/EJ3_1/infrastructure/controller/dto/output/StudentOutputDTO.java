package com.formacion.bosonit.EJ3_1.infrastructure.controller.dto.output;

import com.formacion.bosonit.EJ3_1.domain.entity.Student_EJ3;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class StudentOutputDTO {

    private String id_student;
    private String id_professor;
    private Integer id_person;
    private Integer num_hours_week;
    private String branch;

    public StudentOutputDTO(Student_EJ3 student){
        setId_student(student.getId_student());
        setId_professor(student.getId_professor());
        setNum_hours_week(student.getNum_hours_week());
        setId_person(student.getId_person());
        setBranch(student.getBranch());
    }

}
