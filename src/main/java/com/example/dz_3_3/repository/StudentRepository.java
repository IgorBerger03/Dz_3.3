package com.example.dz_3_3.repository;

import com.example.dz_3_3.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface StudentRepository extends JpaRepository<Student, Long> {
    Collection<Student> findByAge(int age);
    Collection<Student> findByAgeBetween(int max, int min);

    Collection<Student> findStudentByFacultyId(Long id);
}
