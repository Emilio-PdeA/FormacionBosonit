package com.formacion.bosonit.EJ3_1.application.services.professor;

import com.formacion.bosonit.EJ3_1.application.services.person.PersonServicesInter;
import com.formacion.bosonit.EJ3_1.domain.entity.Person_EJ3;
import com.formacion.bosonit.EJ3_1.domain.entity.Professor_EJ3;
import com.formacion.bosonit.shared.exception.CustomNotFoundException;
import com.formacion.bosonit.shared.exception.CustomUnprocessableException;
import com.formacion.bosonit.EJ3_1.infrastructure.controller.dto.input.ProfessorInputDTO;
import com.formacion.bosonit.EJ3_1.infrastructure.controller.dto.output.ProfessorFullOutputDTO;
import com.formacion.bosonit.EJ3_1.infrastructure.controller.dto.output.ProfessorOutputDTO;
import com.formacion.bosonit.EJ3_1.infrastructure.repository.ProfessorRepository_EJ3;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Service("ProfessorServices_EJ3")
public class ProfessorServices implements ProfessorServicesInter{

    @Autowired
    ProfessorRepository_EJ3 professorRepository;

    @Autowired
    @Qualifier("PersonStudent")
    PersonServicesInter personServicesInter;

    @Override
    public ProfessorOutputDTO findUserId(String id){
        Optional<Professor_EJ3> prof =
                Optional.ofNullable(professorRepository.findById(id)
                        .orElseThrow(()->new CustomNotFoundException("Person with id: " + id + " not found.")));
        return new ProfessorOutputDTO(prof.get());
    }

    @Override
    public ProfessorFullOutputDTO findFullUserId(String id){
        Optional<Professor_EJ3> prof =
                Optional.ofNullable(professorRepository.findById(id)
                        .orElseThrow(()->new CustomNotFoundException("Person with id: " + id + " not found.")));
        Integer id_person = prof.get().getId_person();
        Person_EJ3 person = personServicesInter.getPerson(id_person);
        return new ProfessorFullOutputDTO(prof.get(),person);
    }


    @Override
    public List<ProfessorOutputDTO> listProfessors(){
        List <Professor_EJ3> profs = professorRepository.findAll();
        return profs.stream().map(pp->new ProfessorOutputDTO(pp)).collect(Collectors.toList());
    }

    @Override
    public List<ProfessorFullOutputDTO> listFullProfessors(){
        List <Professor_EJ3> profs = professorRepository.findAll();
        return profs.stream().map(pp->new ProfessorFullOutputDTO(pp,pp.getPerson())).collect(Collectors.toList());
    }

    @Override
    public ProfessorOutputDTO addProfessor(ProfessorInputDTO professorInputDTO)
        throws CustomUnprocessableException{
        try{
            Person_EJ3 person = personServicesInter.getPerson(professorInputDTO.getId_person());
            if (person.getActive()){throw new CustomUnprocessableException("Person with id " + professorInputDTO.getId_person() + " is already assigned.");}
            person.setActive(true);
            Optional<Professor_EJ3> prof =
                    Optional.of(new Professor_EJ3(professorInputDTO,person));

            professorRepository.save(prof.get());
            return new ProfessorOutputDTO(prof.get());
        }catch (NoSuchElementException k){
            throw new CustomUnprocessableException(professorInputDTO + " could not be created.");
        }
    }

    @Override
    public Professor_EJ3 getProfessor(String id) {
        Optional<Professor_EJ3> prof =
                Optional.ofNullable(professorRepository.findById(id)
                        .orElseThrow(()->new CustomNotFoundException("Professor with id: " + id + " not found")));
        return prof.get();
    }

}
