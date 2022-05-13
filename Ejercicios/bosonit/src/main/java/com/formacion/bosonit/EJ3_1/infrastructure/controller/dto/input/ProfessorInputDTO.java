package com.formacion.bosonit.EJ3_1.infrastructure.controller.dto.input;

import com.formacion.bosonit.EJ3_1.domain.entity.Professor_EJ3;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.GetMapping;

@Getter @Setter
public class ProfessorInputDTO {

    private  Integer id_person;
    private String comments;
    private String branch;

}
