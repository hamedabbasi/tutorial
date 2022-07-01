package com.tutorial.repository;

import com.tutorial.data.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    boolean existsByEmail(String email);
}
