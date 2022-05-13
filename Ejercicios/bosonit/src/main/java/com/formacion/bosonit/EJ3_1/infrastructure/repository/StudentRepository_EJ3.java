package com.formacion.bosonit.EJ3_1.infrastructure.repository;

import com.formacion.bosonit.EJ3_1.domain.entity.Student_EJ3;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository_EJ3 extends JpaRepository<Student_EJ3, String> {
    List<Student_EJ3> findAll();

}
