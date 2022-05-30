package com.formacion.bosonit.EJ2.domain.exception;

import com.formacion.bosonit.EJ2.domain.entity.CustomError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@RestControllerAdvice
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(PersonNotFoundException.class)
    public final ResponseEntity<CustomError> handleNotFoundException(PersonNotFoundException ex, WebRequest request){
        CustomError customError = new CustomError(new Date(), ex.getMessage(),
                request.getDescription(false), HttpStatus.NOT_FOUND.getReasonPhrase());
        return new ResponseEntity<CustomError>(customError,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(PersonUnprocessableException.class)
    public final ResponseEntity<CustomError> handleUnprocessableException(PersonUnprocessableException ex, WebRequest request){
        CustomError customError = new CustomError(new Date(),ex.getMessage(),
                request.getDescription(false),HttpStatus.UNPROCESSABLE_ENTITY.getReasonPhrase());
        return new ResponseEntity<CustomError>(customError,HttpStatus.UNPROCESSABLE_ENTITY);
    }

}
