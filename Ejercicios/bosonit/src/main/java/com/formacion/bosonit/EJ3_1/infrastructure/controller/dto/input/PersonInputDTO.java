package com.formacion.bosonit.EJ3_1.infrastructure.controller.dto.input;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PersonInputDTO {

    @NotNull(message = "\"user\" not null")
    private String user;

    @NotNull(message = "\"password\" not null")
    private String password;

    @NotNull(message = "\"name\" not null")
    private String name;

    private String surname = null;

    @NotNull(message = "\"company_email\" not null")
    @Email(message = "\"company_email\" not valid.")
    private String company_email;

    @NotNull(message = "\"personal_email\" not null")
    @Email(message = "\"personal_email\" not valid.")
    private String personal_email;

    @NotNull(message = "\"city\" not null")
    private String city;

    private Boolean active = false;
    private String imagen_url = null;



}
