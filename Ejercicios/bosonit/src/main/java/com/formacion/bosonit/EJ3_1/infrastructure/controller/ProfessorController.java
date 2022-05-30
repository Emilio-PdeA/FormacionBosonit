package com.formacion.bosonit.EJ3_1.infrastructure.controller;

import com.formacion.bosonit.EJ3_1.application.services.professor.ProfessorServicesInter;
import com.formacion.bosonit.EJ3_1.infrastructure.controller.dto.output.PersonOutputDTO;
import com.formacion.bosonit.EJ3_1.infrastructure.controller.dto.output.ProfessorOutputDTO;
import com.formacion.bosonit.shared.ConsoleColors;
import com.formacion.bosonit.shared.exception.CustomNotFoundException;
import com.formacion.bosonit.EJ3_1.infrastructure.controller.dto.input.ProfessorInputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.request.WebRequest;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("EJ3/professor")
public class ProfessorController {

    @Autowired
    ProfessorServicesInter professorServicesInter;

    @GetMapping("fiveProfessors")
    public ResponseEntity createFiveProfessors(){
            professorServicesInter.createFiveProfessor();
        return new  ResponseEntity("{}", HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getProfessorList(@RequestParam(defaultValue = "simple") String outputType, WebRequest req){
        switch (outputType){
            case "simple":{
                System.out.println(ConsoleColors.TEXT_GREEN + "\tGET " + req.getDescription(false) +"?outputType="+ outputType + ConsoleColors.TEXT_WHITE);
                return new ResponseEntity(professorServicesInter.listProfessors(), HttpStatus.OK);
            }
            case "full":{
                System.out.println(ConsoleColors.TEXT_GREEN + "\tGET " + req.getDescription(false) + "?outputType="+ outputType + ConsoleColors.TEXT_WHITE);
                return new ResponseEntity(professorServicesInter.listFullProfessors(),HttpStatus.OK);
            }
            default:
                System.out.println(ConsoleColors.TEXT_GREEN + "\tGET " + req.getDescription(false) + "?outputType="+ outputType + ConsoleColors.TEXT_WHITE);
                throw new CustomNotFoundException("Parameter outputType=" + outputType + " not recognized.");
        }
    }

    @GetMapping("{id}")
    public ResponseEntity getProfessorId(@PathVariable String id, @RequestParam(defaultValue = "simple") String outputType, WebRequest req){
        switch (outputType){
            case "simple":{
                System.out.println(ConsoleColors.TEXT_GREEN + "\tGET " + req.getDescription(false) +"?outputType="+ outputType + ConsoleColors.TEXT_WHITE);
                return new ResponseEntity(professorServicesInter.findUserId(id), HttpStatus.OK);
            }
            case "full":{
                System.out.println(ConsoleColors.TEXT_GREEN + "\tGET " + req.getDescription(false) + "?outputType="+ outputType + ConsoleColors.TEXT_WHITE);
                return new ResponseEntity(professorServicesInter.findFullUserId(id),HttpStatus.OK);
            }
            default:
                System.out.println(ConsoleColors.TEXT_GREEN + "\tGET " + req.getDescription(false) + "?outputType="+ outputType + ConsoleColors.TEXT_WHITE);
                throw new CustomNotFoundException("Parameter outputType=" + outputType + " not recognized.");
        }
    }

    @GetMapping("template/{id}")
    public ProfessorOutputDTO getFeignProfessorId(@PathVariable String id, @RequestParam(defaultValue = "simple") String outputType, WebRequest req){
        Map<String, String> uriVariables = new HashMap<>();
        ResponseEntity<ProfessorOutputDTO> response =
                    new RestTemplate().getForEntity("http://localhost:8081/EJ3//professor/{id}",
                    ProfessorOutputDTO.class,uriVariables);
        return response.getBody();

    }

    @PostMapping
    public ResponseEntity addProfessor(@RequestBody ProfessorInputDTO professorInputDTO, WebRequest req){
        System.out.println(ConsoleColors.TEXT_CYAN + "\tPOST " + req.getDescription(false) + ConsoleColors.TEXT_WHITE);
        return new ResponseEntity(professorServicesInter.addProfessor(professorInputDTO),HttpStatus.OK);
    }

}
