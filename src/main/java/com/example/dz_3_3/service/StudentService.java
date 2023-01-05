package com.example.dz_3_3.service;

import com.example.dz_3_3.model.Faculty;
import com.example.dz_3_3.model.Student;
import com.example.dz_3_3.repository.FacultyRepository;
import com.example.dz_3_3.repository.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {
    private final StudentRepository studentRepository;
    private final FacultyRepository facultyRepository;

    private final Logger logger = LoggerFactory.getLogger(StudentService.class);

    public StudentService(StudentRepository studentRepository,
                          FacultyRepository facultyRepository) {
        this.studentRepository = studentRepository;
        this.facultyRepository = facultyRepository;
    }

    public Student addStudent(Student student){
        logger.info("Was invoked method for add student");
        return studentRepository.save(student);
    }
    public Student findStudent(long id){
        logger.info("Was invoked method for find student by id");
        return studentRepository.findById(id).orElse(null);
    }
    public Student editStudent(Student student){
        logger.info("Was invoked method for edit student");
        if (findStudent(student.getId()) != null) {
            return studentRepository.save(student);
        }
        return null;
    }
    public void deleteStudent(long id){
        logger.info("Was invoked method for delete student by id");
        studentRepository.deleteById(id);
    }

    public Collection<Student> findByAge(int age) {
        logger.info("Was invoked method for find students by age");
        return studentRepository.findByAge(age);
    }
    public Collection<Student> findStudentByAgeBetween(Integer min, Integer max){
        logger.info("Was invoked method for find students by age between two values");
        return studentRepository.findByAgeBetween(min, max);
    }

    public Faculty getFacultyByStudent(Long id) {
        logger.debug("Requesting find faculty by student id: {}", id);
        return findStudent(id).getFaculty();
    }
    public Long getAmountOfAllStudents() {
        logger.info("Was invoked method for get amount of all students");
        return studentRepository.getAmountOfAllStudents();
    }

    public double getAverageOfAllStudents() {
        logger.info("Was invoked method for get average age from all students");
        return studentRepository.getAverageOfAllStudents();
    }

    public List<Student> getFiveLastStudents() {
        logger.info("Was invoked method for get five last students");
        return studentRepository.getLastFiveStudents();
    }

    public Collection<String> getFilteredByName () {
        return studentRepository.findAll().stream()
                .map(student -> student.getName())
                .map(s -> s.toUpperCase())
                .filter(s -> s.startsWith("a"))
                .sorted()
                .collect(Collectors.toList());
    }
    public Double getAllStudentsAvgAge(){
        return studentRepository.findAll().stream()
                .mapToInt(student -> student.getAge())
                .average()
                .orElse(0);
    }

    public Collection<Student> getAll(){
        return studentRepository.findAll();
    }
}
