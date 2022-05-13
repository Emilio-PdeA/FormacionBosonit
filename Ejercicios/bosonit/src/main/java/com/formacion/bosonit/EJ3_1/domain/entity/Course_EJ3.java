package com.formacion.bosonit.EJ3_1.domain.entity;

import lombok.NonNull;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;


@Entity @Table(name="Courses_EJ3")
public class Course_EJ3 {

    @Id
    private String id_course;

    @Column
    private String id_student;

    @Column
    private String course;

    @Column
    private String comments;

    @Column @NonNull
    private Date initial_date;

    @Column
    private Date finish_date;




}
