package com.formacion.bosonit.EJ3_1.application.services.person;

import com.formacion.bosonit.EJ3_1.domain.entity.Person_EJ3;
import com.formacion.bosonit.shared.exception.CustomNotFoundException;
import com.formacion.bosonit.shared.exception.CustomUnprocessableException;
import com.formacion.bosonit.EJ3_1.infrastructure.controller.dto.input.PersonInputDTO;
import com.formacion.bosonit.EJ3_1.infrastructure.controller.dto.output.PersonOutputDTO;
import com.formacion.bosonit.EJ3_1.infrastructure.repository.PersonRepository_EJ3;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Service("PersonServices_EJ3_1")
@Qualifier("Person")
public class PersonServices implements PersonServicesInter {

    @Autowired
    PersonRepository_EJ3 personRepository;

    //ESTA FUNCION ESTA PARA INICIAR UN SET DE PERSONAS
    @Override
    @Bean
    public void initPersonas(){
        for(int i = 1; i <= 10; ++i){
            PersonInputDTO personInputDTO =
                    new PersonInputDTO("person"+i,"password","Person","" + i,"user@mail.com","user@mail.com","Madrid",false,"");
            Person_EJ3 person = new Person_EJ3(personInputDTO);
            personRepository.save(person);
        }
    }

    @Override
    public PersonOutputDTO addUser(PersonInputDTO personInputDTO) throws CustomUnprocessableException {
            Optional<Person_EJ3> person = Optional.of(new Person_EJ3(personInputDTO));
            try{
                personRepository.save(person.get());
            }catch (NoSuchElementException k){
                throw new CustomUnprocessableException(personInputDTO + " could not be created.");
            }

            PersonOutputDTO personOutputDTO = new PersonOutputDTO(person.get());
            return personOutputDTO;
    }

    @Override
    public PersonOutputDTO findUserId(Integer id){
        Optional<Person_EJ3> person = Optional.ofNullable(personRepository.findById(id).orElseThrow(() -> new CustomNotFoundException("Person with id: " + id + " not found.")));
        return new PersonOutputDTO(person.get());
    }

    @Override
    public List<PersonOutputDTO> listUsers(){
        List <Person_EJ3> people = personRepository.findAll();
        return people.stream().map(pp->new PersonOutputDTO(pp)).collect(Collectors.toList());
    }

    @Override
    public PersonOutputDTO findByUser(String user){
    Optional<Person_EJ3> person = Optional.ofNullable(personRepository.findByUser(user)
                .orElseThrow(() -> new CustomNotFoundException("Person with username: " + user + " not found.")));
        return new PersonOutputDTO(person.get());
    }

    @Override
    public Person_EJ3 getPerson(Integer id) {
        return null;
    }
}
