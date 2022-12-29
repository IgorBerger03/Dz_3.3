package com.example.dz_3_3.service;

import com.example.dz_3_3.model.Faculty;
import com.example.dz_3_3.model.Student;
import com.example.dz_3_3.repository.FacultyRepository;
import com.example.dz_3_3.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class StudentService {
    private final StudentRepository studentRepository;
    private final FacultyRepository facultyRepository;

    public StudentService(StudentRepository studentRepository,
                          FacultyRepository facultyRepository) {
        this.studentRepository = studentRepository;
        this.facultyRepository = facultyRepository;
    }

    public Student addStudent(Student student){
        return studentRepository.save(student);
    }
    public Student findStudent(long id){
        return studentRepository.findById(id).orElse(null);
    }
    public Student editStudent(Student student){
        if (findStudent(student.getId()) != null) {
            return studentRepository.save(student);
        }
        return null;
    }
    public void deleteStudent(long id){
        studentRepository.deleteById(id);
    }

    public Collection<Student> findByAge(int age) {
        return studentRepository.findByAge(age);
    }
    public Collection<Student> findStudentByAgeBetween(Integer min, Integer max){
        return studentRepository.findByAgeBetween(min, max);
    }

    public Faculty getFacultyByStudent(Long id) {
        return findStudent(id).getFaculty();
    }
    public Long getAmountOfAllStudents() {
        return studentRepository.getAmountOfAllStudents();
    }

    public double getAverageOfAllStudents() {
        return studentRepository.getAverageOfAllStudents();
    }

    public List<Student> getFiveLastStudents() {
        return studentRepository.getLastFiveStudents();
    }
}
