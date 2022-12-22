package com.example.dz_3_3.controller;

import com.example.dz_3_3.model.Faculty;
import com.example.dz_3_3.model.Student;
import com.example.dz_3_3.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Collections;

@RestController
@RequestMapping("/student")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("{id}")
    public Student getStudentInfo(@PathVariable long id) {
        return studentService.findStudent(id);
    }

    @PostMapping
    public Student createStudent(@RequestBody Student student) {
        return studentService.addStudent(student);
    }

    @PutMapping
    public Student editStudent(@RequestBody Student student) {
        return studentService.editStudent(student);
    }

    @DeleteMapping("{id}")
    public ResponseEntity deleteStudent(@PathVariable long id) {
        studentService.deleteStudent(id);
        return ResponseEntity.ok().build();
    }
    @GetMapping
    public ResponseEntity<Collection<Student>> findStudents(@RequestParam int age) {
        if (age > 0) {
            return ResponseEntity.ok(studentService.findByAge(age));
        }
        return ResponseEntity.ok(Collections.emptyList());
    }

    @GetMapping("ages")
    public ResponseEntity<Collection<Student>> getStudentByAgeBetween(@RequestParam Integer min, @RequestParam Integer max){
        Collection<Student> findStudents = studentService.findStudentByAgeBetween(min, max);
        return ResponseEntity.ok(findStudents);
    }

    @GetMapping("{id}/faculty")
    public ResponseEntity<Faculty> getFacultyByStudent(@PathVariable Long id) {
        Faculty foundFaculty = studentService.getFacultyByStudent(id);
        return ResponseEntity.ok(foundFaculty);
    }


}
