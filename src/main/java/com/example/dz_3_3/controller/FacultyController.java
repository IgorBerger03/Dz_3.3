package com.example.dz_3_3.controller;

import com.example.dz_3_3.model.Faculty;
import com.example.dz_3_3.model.Student;
import com.example.dz_3_3.service.FacultyService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Collections;

@RestController
@RequestMapping("/faculty")
public class FacultyController {
    private final FacultyService facultyService;

    public FacultyController(FacultyService facultyService) {
        this.facultyService = facultyService;
    }

    @GetMapping("{id}")
    public ResponseEntity<Faculty> getFaculty(@PathVariable long id) {
        Faculty faculty = facultyService.findFaculty(id);
        if (faculty == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(faculty);
    }

    @PostMapping
    public Faculty createFaculty(@RequestBody Faculty faculty) {
        return facultyService.addFaculty(faculty);
    }

    @PutMapping
    public ResponseEntity<Faculty> editFaculty(@RequestBody Faculty faculty) {
        Faculty foundStudent = facultyService.editFaculty(faculty);
        if (foundStudent == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(foundStudent);
    }

    @DeleteMapping("{id}")
    public ResponseEntity deleteFaculty(@PathVariable long id) {
        facultyService.deleteFaculty(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<Collection<Faculty>> findFaculties(@RequestParam(required = false) String color) {
        if (color != null && !color.isBlank()) {
            return ResponseEntity.ok(facultyService.findByColor(color));
        }
        return ResponseEntity.ok(Collections.emptyList());
    }

    public ResponseEntity<Collection<Faculty>> getFacultyByNameOrColor(@RequestParam String nameOrColor) {
        Collection<Faculty> findFaculty = facultyService.findFacultiesByNameOrColor(nameOrColor);
        return ResponseEntity.ok(findFaculty);
    }
    @GetMapping("{id}/students")
    public ResponseEntity<Collection<Student>> getStudentsByFacultyId(@PathVariable Long id) {
        Collection<Student> foundStudents = facultyService.getStudentsByFacultyId(id);
        return ResponseEntity.ok(foundStudents);
    }
}
