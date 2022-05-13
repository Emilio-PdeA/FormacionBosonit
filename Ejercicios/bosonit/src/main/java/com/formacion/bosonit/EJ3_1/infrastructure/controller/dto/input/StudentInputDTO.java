package com.formacion.bosonit.EJ3_1.infrastructure.controller.dto.input;

import com.formacion.bosonit.EJ2.domain.exception.PersonNotFoundException;
import com.formacion.bosonit.EJ3_1.application.services.person.PersonServicesInter;
import com.formacion.bosonit.EJ3_1.domain.entity.Person_EJ3;
import com.formacion.bosonit.EJ3_1.infrastructure.controller.PersonController;
import com.formacion.bosonit.EJ3_1.infrastructure.repository.PersonRepository_EJ3;
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
