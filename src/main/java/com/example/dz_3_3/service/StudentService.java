package com.example.dz_3_3.service;

import com.example.dz_3_3.model.Student;
import com.example.dz_3_3.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
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
}
