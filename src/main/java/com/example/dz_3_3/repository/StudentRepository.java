package com.example.dz_3_3.repository;

import com.example.dz_3_3.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;
import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {
    Collection<Student> findByAge(int age);
    Collection<Student> findByAgeBetween(int max, int min);
    Collection<Student> findStudentByFacultyId(Long id);

    @Query(value = "SELECT count(*) from student", nativeQuery = true)
    Long getAmountOfAllStudents();

    @Query(value = "SELECT avg(age) from student", nativeQuery = true)
    Double getAverageOfAllStudents();

    @Query(value = "SELECT * from student order by id desc limit 5", nativeQuery = true)
    List<Student> getLastFiveStudents();

}
