package com.prathish.studentapi.repository;

import com.prathish.studentapi.models.Students;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Students, Long> {
}
