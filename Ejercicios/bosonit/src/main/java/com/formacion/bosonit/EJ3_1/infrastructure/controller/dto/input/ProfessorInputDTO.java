package com.formacion.bosonit.EJ3_1.infrastructure.controller.dto.input;

import com.formacion.bosonit.EJ2.domain.entity.Person;
import com.formacion.bosonit.EJ2.infrastructure.repository.PersonRepository;
import com.formacion.bosonit.EJ3_1.domain.entity.Person_EJ3;
import com.formacion.bosonit.EJ3_1.infrastructure.repository.PersonRepository_EJ3;
import com.formacion.bosonit.shared.exception.CustomNotFoundException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import javax.sound.midi.MidiMessage;
import java.util.Optional;

@Getter @Setter
public class ProfessorInputDTO {

    private Integer id_person;
    private String comments;
    private String branch;

    public ProfessorInputDTO(Integer id, String cm, String br){
        this.id_person = id;
        this.comments = cm;
        this.branch = br;
    }
}
