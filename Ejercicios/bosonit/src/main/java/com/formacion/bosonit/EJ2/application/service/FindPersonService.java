package com.formacion.bosonit.EJ2.application.service;

import com.formacion.bosonit.EJ2.infrastructure.controller.dto.output.PersonOutputDTO;

public interface FindPersonService {

    public PersonOutputDTO findUserID(Integer id);

    public PersonOutputDTO findUserName(String user);

}
