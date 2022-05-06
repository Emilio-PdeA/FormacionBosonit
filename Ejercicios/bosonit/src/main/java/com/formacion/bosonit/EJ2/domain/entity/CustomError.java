package com.formacion.bosonit.EJ2.domain.entity;

import lombok.Getter;

import java.util.Date;

@Getter
public class CustomError {

    private final Date timestamp;
    private final String message;
    private final String details;
    private final String httpCodeMessage;

    public CustomError(Date timestamp, String message, String details, String httpCodeMessage){
        super();
        this.timestamp=timestamp;
        this.message=message;
        this.details = details;
        this.httpCodeMessage=httpCodeMessage;
    }

}
