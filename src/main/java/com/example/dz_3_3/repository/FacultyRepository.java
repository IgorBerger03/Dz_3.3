package com.example.dz_3_3.repository;

import com.example.dz_3_3.model.Faculty;
import com.example.dz_3_3.model.Student;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface FacultyRepository extends JpaRepository<Faculty, Long> {
    Collection<Faculty> findAllByColor(String color);
    Collection<Faculty> findByNameIgnoreCaseOrColorIgnoreCase(String name, String color);
}
