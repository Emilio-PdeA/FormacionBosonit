package com.formacion.bosonit.EJ3_1.infrastructure.repository;

import com.formacion.bosonit.EJ3_1.domain.entity.Professor_EJ3;
import com.formacion.bosonit.EJ3_1.domain.entity.Student_EJ3;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProfessorRepository_EJ3 extends JpaRepository<Professor_EJ3, String> {
    List<Professor_EJ3> findAll();
}
