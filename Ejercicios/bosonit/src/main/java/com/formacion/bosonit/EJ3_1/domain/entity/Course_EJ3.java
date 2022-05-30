package com.formacion.bosonit.EJ3_1.domain.entity;

import com.formacion.bosonit.shared.sequences.StringPrefixedSequenceIdGenerator;
import lombok.Data;
import lombok.NonNull;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.ManyToAny;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;


@Entity @Table(name="Courses_EJ3")
@Data
public class Course_EJ3 {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "course_seq")
    @GenericGenerator(
            name = "course_seq",
            strategy = "com.formacion.bosonit.shared.sequences.StringPrefixedSequenceIdGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "1"),
                    @org.hibernate.annotations.Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "CRS"),
                    @org.hibernate.annotations.Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%05d")
            })
    private String id_course;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "professor")
    private Professor_EJ3 professor;

    @ManyToOne(cascade = CascadeType.ALL)
    private Student_EJ3 id_student;

    @Column
    private String course;

    @Column
    private String comments;

    @Column @NonNull
    private LocalDate initial_date;

    @Column
    private LocalDate finish_date;




}
