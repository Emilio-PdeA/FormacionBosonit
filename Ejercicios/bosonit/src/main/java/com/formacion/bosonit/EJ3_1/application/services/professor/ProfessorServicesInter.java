package com.formacion.bosonit.EJ3_1.application.services.professor;

import com.formacion.bosonit.EJ3_1.domain.entity.Professor_EJ3;
import com.formacion.bosonit.EJ3_1.domain.entity.Student_EJ3;
import com.formacion.bosonit.shared.exception.CustomUnprocessableException;
import com.formacion.bosonit.EJ3_1.infrastructure.controller.dto.input.ProfessorInputDTO;
import com.formacion.bosonit.EJ3_1.infrastructure.controller.dto.output.ProfessorFullOutputDTO;
import com.formacion.bosonit.EJ3_1.infrastructure.controller.dto.output.ProfessorOutputDTO;

import java.util.List;

public interface ProfessorServicesInter {
    ProfessorOutputDTO findUserId(String id);

    ProfessorFullOutputDTO findFullUserId(String id);

    List<ProfessorOutputDTO> listProfessors();

    List<ProfessorFullOutputDTO> listFullProfessors();

    ProfessorOutputDTO addProfessor(ProfessorInputDTO professorInputDTO)
        throws CustomUnprocessableException;

    Professor_EJ3 getProfessor(String id);
}
