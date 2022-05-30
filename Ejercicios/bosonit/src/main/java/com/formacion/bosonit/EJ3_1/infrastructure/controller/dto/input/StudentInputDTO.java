package com.formacion.bosonit.EJ3_1.infrastructure.controller.dto.input;


import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

@Getter @Setter
public class StudentInputDTO {

    private Integer id_person;
    private String id_professor;
    private Integer num_hours_week;
    private String branch;



}
