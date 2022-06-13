package com.practice.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.practice.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    
    // Select * FROM student WHERE email = ?
    // The following query is JPQL, not normal SQL
    // @Query("SELECT s FROM student s WHERE s.email = ?1")
    Optional<Student> findByEmail(String email);
}
