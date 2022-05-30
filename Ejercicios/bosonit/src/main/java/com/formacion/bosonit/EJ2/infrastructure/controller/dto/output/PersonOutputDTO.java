package com.formacion.bosonit.EJ2.infrastructure.controller.dto.output;

import java.util.Date;


public record PersonOutputDTO (Integer id, String user, String fullname, String company_email, String personal_email, String city, Boolean active, String imagen_url, Date created_date, Date termination_date ) {

    public PersonOutputDTO(Integer id, String user, String fullname, String company_email, String personal_email, String city, Boolean active, String imagen_url, Date created_date, Date termination_date){
        this.id = id;
        this.user = user;
        this.fullname = (fullname);
        this.company_email = company_email;
        this.personal_email = personal_email;
        this.city = city;
        this.active=active;
        this.imagen_url=imagen_url;
        this.created_date=created_date;
        this.termination_date=termination_date;
    }


}
