package com.formacion.bosonit.EJ3_1.application.services.student;

import com.formacion.bosonit.EJ3_1.application.services.person.PersonServicesInter;
import com.formacion.bosonit.EJ3_1.application.services.professor.ProfessorServicesInter;
import com.formacion.bosonit.EJ3_1.domain.entity.Person_EJ3;
import com.formacion.bosonit.EJ3_1.domain.entity.Professor_EJ3;
import com.formacion.bosonit.EJ3_1.domain.entity.Student_EJ3;
import com.formacion.bosonit.shared.exception.CustomNotFoundException;
import com.formacion.bosonit.shared.exception.CustomUnprocessableException;
import com.formacion.bosonit.EJ3_1.infrastructure.controller.dto.input.StudentInputDTO;
import com.formacion.bosonit.EJ3_1.infrastructure.controller.dto.output.StudentFullOutputDTO;
import com.formacion.bosonit.EJ3_1.infrastructure.controller.dto.output.StudentOutputDTO;
import com.formacion.bosonit.EJ3_1.infrastructure.repository.StudentRepository_EJ3;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Service("StudentServices_EJ3")
public class StudentServices implements StudentServicesInter{

    @Autowired
    StudentRepository_EJ3 studentRepository;

    @Autowired
    ProfessorServicesInter professorServicesInter;

    @Autowired
    @Qualifier("PersonStudent")
    PersonServicesInter personServicesInter;


    @Override
    public StudentOutputDTO findUserId(String id){
        Optional<Student_EJ3> student =
                Optional.ofNullable(studentRepository.findById(id)
                        .orElseThrow(()->new CustomNotFoundException("Person with id: " + id + " not found.")));
        return new StudentOutputDTO(student.get());
    }

    @Override
    public StudentFullOutputDTO findFullUserId(String id){
        Optional<Student_EJ3> student =
                Optional.ofNullable(studentRepository.findById(id)
                        .orElseThrow(()->new CustomNotFoundException("Person with id: " + id + " not found.")));
        Integer id_person = student.get().getId_person();
        Person_EJ3 person = personServicesInter.getPerson(id_person);
        return new StudentFullOutputDTO(student.get(), person);
    }

    @Override
    public List<StudentOutputDTO> listStudents(){
        List <Student_EJ3> students = studentRepository.findAll();
        return students.stream().map(ss->new StudentOutputDTO(ss)).collect(Collectors.toList());
    }

    @Override
    public List<StudentFullOutputDTO> listFullStudents(){
        List <Student_EJ3> students = studentRepository.findAll();
        return students.stream().map(ss->new StudentFullOutputDTO(ss,ss.getPerson())).collect(Collectors.toList());
    }

    @Override
    public StudentOutputDTO addStudent(StudentInputDTO studentInputDTO)
        throws CustomUnprocessableException{
        try{
            Person_EJ3 person = personServicesInter.getPerson(studentInputDTO.getId_person());
            if (person.getActive()){throw new CustomUnprocessableException("Person with id " + studentInputDTO.getId_person() + " is already assigned.");}
            Professor_EJ3 prof = professorServicesInter.getProfessor(studentInputDTO.getId_professor());
            person.setActive(true);
            Optional<Student_EJ3> student =
                    Optional.of(new Student_EJ3(studentInputDTO,person,prof));

            studentRepository.save(student.get());
            return new StudentOutputDTO(student.get());
        }catch (NoSuchElementException k){
            throw new CustomUnprocessableException(studentInputDTO + " could not be created.");
        }

    }


}
