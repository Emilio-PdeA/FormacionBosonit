package com.formacion.bosonit.EJ2.infrastructure.controller.dto.input;

public record PersonInputDTO(String user, String password, String name, String surname, String company_email, String personal_email, String city, Boolean active, String image_url) {

}
