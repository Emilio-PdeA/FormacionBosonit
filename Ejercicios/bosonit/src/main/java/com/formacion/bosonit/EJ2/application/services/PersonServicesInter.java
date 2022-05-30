package com.formacion.bosonit.EJ2.application.services;

import com.formacion.bosonit.EJ2.domain.entity.Person;
import com.formacion.bosonit.EJ2.domain.exception.PersonUnprocessableException;
import com.formacion.bosonit.EJ2.infrastructure.controller.dto.input.PersonInputDTO;
import com.formacion.bosonit.EJ2.infrastructure.controller.dto.output.PersonOutputDTO;

import java.util.List;

public interface PersonServicesInter {

    public Person addUser(PersonInputDTO personInputDTO) throws PersonUnprocessableException;

    public Person findUserId(Integer id);

    public List<PersonOutputDTO> listUsers();

    public Person findByUser(String user);





}
