package com.formacion.bosonit.EJ2.infrastructure.repository;

import com.formacion.bosonit.EJ2.domain.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository("PersonRepositoryEJ3")
public interface PersonRepository extends JpaRepository<Person,Integer> {
    List<Person> findAll();
    Optional<Person> findByUser(String user);
}
