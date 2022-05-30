package com.formacion.bosonit.EJ3_1.application.services.person;

import com.formacion.bosonit.EJ3_1.domain.entity.Person_EJ3;
import com.formacion.bosonit.shared.exception.CustomUnprocessableException;
import com.formacion.bosonit.EJ3_1.infrastructure.controller.dto.input.PersonInputDTO;
import com.formacion.bosonit.EJ3_1.infrastructure.controller.dto.output.PersonOutputDTO;
import com.formacion.bosonit.EJ3_1.infrastructure.repository.PersonRepository_EJ3;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.Valid;
import java.util.List;

public interface PersonServicesInter {

    @Autowired
    PersonRepository_EJ3 personRepository = null;

    //ESTA FUNCION ESTA PARA INICIAR UN SET DE PERSONAS
    void initPersonas();

    PersonOutputDTO addUser(@Valid PersonInputDTO personInputDTO) throws CustomUnprocessableException;

    PersonOutputDTO findUserId(Integer id);

    List<PersonOutputDTO> listUsers();

    PersonOutputDTO findByUser(String user);

    void deleteById(Integer id);

    void deleteByUser(String user);

    Person_EJ3 getPerson(Integer id);
}
