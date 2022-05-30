package com.formacion.bosonit.EJ2.domain.entity;

import lombok.Getter;

import java.util.Date;

@Getter
public class CustomError {

    private Date timestamp;
    private String message;
    private String details;
    private String httpCodeMessage;

    public CustomError(Date timestamp, String message, String details, String httpCodeMessage){
        super();
        this.timestamp=timestamp;
        this.message=message;
        this.details = details;
        this.httpCodeMessage=httpCodeMessage;
    }

}
