package com.formacion.bosonit.EJ3_1.infrastructure.repository;

import com.formacion.bosonit.EJ3_1.domain.entity.Person_EJ3;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface PersonStudentRepository_EJ3 extends JpaRepository<Person_EJ3,Integer> {
    List<Person_EJ3> findAll();

}
