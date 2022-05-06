package com.formacion.bosonit.EJ2.application.services;

import com.formacion.bosonit.EJ2.domain.exception.PersonUnprocessableException;
import com.formacion.bosonit.EJ2.infrastructure.controller.dto.input.PersonInputDTO;
import com.formacion.bosonit.EJ2.infrastructure.controller.dto.output.PersonOutputDTO;

import java.util.List;

public interface PersonServicesInter {

    PersonOutputDTO addUser(PersonInputDTO personInputDTO) throws PersonUnprocessableException;

    PersonOutputDTO findUserId(Integer id);

    List<PersonOutputDTO> listUsers();

    PersonOutputDTO findByUser(String user);





}
