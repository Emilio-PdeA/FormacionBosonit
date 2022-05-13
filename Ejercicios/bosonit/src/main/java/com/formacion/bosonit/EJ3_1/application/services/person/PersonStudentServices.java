package com.formacion.bosonit.EJ3_1.application.services.person;

import com.formacion.bosonit.EJ3_1.domain.entity.Person_EJ3;
import com.formacion.bosonit.shared.exception.CustomNotFoundException;
import com.formacion.bosonit.shared.exception.CustomUnprocessableException;
import com.formacion.bosonit.EJ3_1.infrastructure.controller.dto.input.PersonInputDTO;
import com.formacion.bosonit.EJ3_1.infrastructure.controller.dto.output.PersonOutputDTO;
import com.formacion.bosonit.EJ3_1.infrastructure.repository.PersonStudentRepository_EJ3;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Qualifier("PersonStudent")
public class PersonStudentServices implements PersonServicesInter{

    @Autowired
    PersonStudentRepository_EJ3 personRepository;

    @Override
    public void initPersonas() {

    }

    @Override
    public PersonOutputDTO addUser(PersonInputDTO personInputDTO) throws CustomUnprocessableException {
        return null;
    }

    @Override
    public PersonOutputDTO findUserId(Integer id) {
        return null;
    }

    @Override
    public List<PersonOutputDTO> listUsers() {
        return null;
    }

    @Override
    public PersonOutputDTO findByUser(String user) {
        return null;
    }

    @Override
    public Person_EJ3 getPerson(Integer id) {
        Optional<Person_EJ3> person = Optional.ofNullable(personRepository.findById(id)
                .orElseThrow(() -> new CustomNotFoundException("Person with id: " + id + " not found.")));
        return person.get();
    }
}
