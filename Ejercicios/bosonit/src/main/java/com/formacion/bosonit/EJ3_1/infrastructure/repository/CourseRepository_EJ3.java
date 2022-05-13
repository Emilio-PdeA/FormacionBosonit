package com.formacion.bosonit.EJ3_1.infrastructure.repository;

import com.formacion.bosonit.EJ3_1.domain.entity.Course_EJ3;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository_EJ3 extends JpaRepository<Course_EJ3, String> {
}
