package com.formacion.bosonit.EJ3_1.infrastructure.controller.dto.output;

import com.formacion.bosonit.EJ3_1.domain.entity.Course_EJ3;
import lombok.Getter;
import lombok.Setter;
import org.apache.tomcat.jni.Local;

import java.time.LocalDate;

@Getter @Setter
public class CourseOutputDTO {

    private String id_course;
    private String id_professor;
    private String course;
    private String comments;
    private LocalDate initial_date;
    private LocalDate finish_date;

    public CourseOutputDTO(Course_EJ3 course){
        setId_course(course.getId_course());
        setId_professor(course.getProfessor().getId_professor());
        setCourse(course.getCourse());
        setComments(course.getComments());
        setInitial_date(course.getInitial_date());
        setFinish_date(course.getFinish_date());
    }

}
