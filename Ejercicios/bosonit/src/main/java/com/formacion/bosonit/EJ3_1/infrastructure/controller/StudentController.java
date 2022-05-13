package com.formacion.bosonit.EJ3_1.infrastructure.controller;

import com.formacion.bosonit.EJ3_1.application.services.student.StudentServicesInter;
import com.formacion.bosonit.shared.ConsoleColors;
import com.formacion.bosonit.shared.exception.CustomNotFoundException;
import com.formacion.bosonit.shared.exception.CustomUnprocessableException;
import com.formacion.bosonit.EJ3_1.infrastructure.controller.dto.input.StudentInputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

@RestController
@RequestMapping("EJ3/student")
public class StudentController {

    @Autowired
    StudentServicesInter studentServicesInter;

    @GetMapping
    public ResponseEntity getStudentList(@RequestParam (defaultValue = "simple")String outputType, WebRequest req){
        switch (outputType){
            case "simple":{
                System.out.println(ConsoleColors.TEXT_GREEN + "\tGET " + req.getDescription(false) +"?outputType="+ outputType + ConsoleColors.TEXT_WHITE);
                return new ResponseEntity(studentServicesInter.listStudents(), HttpStatus.OK);
            }
            case "full":{
                System.out.println(ConsoleColors.TEXT_GREEN + "\tGET " + req.getDescription(false) + "?outputType="+ outputType + ConsoleColors.TEXT_WHITE);
                return new ResponseEntity(studentServicesInter.listFullStudents(),HttpStatus.OK);
            }
            default:
                System.out.println(ConsoleColors.TEXT_GREEN + "\tGET " + req.getDescription(false) + "?outputType="+ outputType + ConsoleColors.TEXT_WHITE);
                throw new CustomNotFoundException("Parameter outputType=" + outputType + " not recognized.");
        }
    }


    @GetMapping("{id}")
    public ResponseEntity getStudentId(@PathVariable String id, @RequestParam (defaultValue = "simple")String outputType, WebRequest req){

        switch (outputType){
            case "simple":{
                System.out.println(ConsoleColors.TEXT_GREEN + "\tGET " + req.getDescription(false) +"?outputType="+ outputType + ConsoleColors.TEXT_WHITE);
                return new ResponseEntity(studentServicesInter.findUserId(id), HttpStatus.OK);
            }
            case "full":{
                System.out.println(ConsoleColors.TEXT_GREEN + "\tGET " + req.getDescription(false) + "?outputType="+ outputType + ConsoleColors.TEXT_WHITE);
                return new ResponseEntity(studentServicesInter.findFullUserId(id),HttpStatus.OK);
            }
            default:
                System.out.println(ConsoleColors.TEXT_GREEN + "\tGET " + req.getDescription(false) + "?outputType="+ outputType + ConsoleColors.TEXT_WHITE);
                throw new CustomNotFoundException("Parameter outputType=" + outputType + " not recognized.");
        }
    }

    @PostMapping
    public ResponseEntity addStudent(@RequestBody StudentInputDTO studentInputDTO, WebRequest req)
        throws CustomUnprocessableException{
        System.out.println(ConsoleColors.TEXT_CYAN + "\tPOST " + req.getDescription(false) + ConsoleColors.TEXT_WHITE);
        return new ResponseEntity(studentServicesInter.addStudent(studentInputDTO),HttpStatus.OK);
    }



}
