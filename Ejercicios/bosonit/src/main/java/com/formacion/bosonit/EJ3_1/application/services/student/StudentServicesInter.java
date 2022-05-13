package com.formacion.bosonit.EJ3_1.application.services.student;

import com.formacion.bosonit.shared.exception.CustomUnprocessableException;
import com.formacion.bosonit.EJ3_1.infrastructure.controller.dto.input.StudentInputDTO;
import com.formacion.bosonit.EJ3_1.infrastructure.controller.dto.output.StudentFullOutputDTO;
import com.formacion.bosonit.EJ3_1.infrastructure.controller.dto.output.StudentOutputDTO;

import java.util.List;

public interface StudentServicesInter {
    StudentOutputDTO findUserId(String id);

    StudentFullOutputDTO findFullUserId(String id);

    List<StudentFullOutputDTO> listFullStudents();

    StudentOutputDTO addStudent(StudentInputDTO studentInputDTO)
        throws CustomUnprocessableException;

    List<StudentOutputDTO> listStudents();
}
