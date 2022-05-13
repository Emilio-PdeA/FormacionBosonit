package com.formacion.bosonit.shared.exception;

import com.formacion.bosonit.EJ3_1.domain.entity.CustomError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@RestControllerAdvice
public class CustomizedResponseEntityExceptionHandler_EJ3 extends ResponseEntityExceptionHandler {

    @ExceptionHandler(CustomUnprocessableException.class)
    public final ResponseEntity<CustomError> handleUnprocessableException(CustomUnprocessableException ex, WebRequest request){
        CustomError customError = new CustomError(new Date(),ex.getMessage(),
                request.getDescription(false),HttpStatus.UNPROCESSABLE_ENTITY.getReasonPhrase());
        return new ResponseEntity<>(customError,HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @ExceptionHandler(CustomNotFoundException.class)
    public final ResponseEntity<CustomError> handleNotFoundException(CustomNotFoundException ex, WebRequest request){
        CustomError customError = new CustomError(new Date(), ex.getMessage(),
                request.getDescription(false), HttpStatus.NOT_FOUND.getReasonPhrase());
        return new ResponseEntity<>(customError,HttpStatus.NOT_FOUND);
    }


}
