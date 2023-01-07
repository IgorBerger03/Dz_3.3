package com.example.dz_3_3.service;

import com.example.dz_3_3.model.Faculty;
import com.example.dz_3_3.model.Student;
import com.example.dz_3_3.repository.FacultyRepository;
import com.example.dz_3_3.repository.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Comparator;
import java.util.Optional;

@Service
public class FacultyService {

    private final FacultyRepository facultyRepository;
    private final StudentRepository studentRepository;

    private final Logger logger = LoggerFactory.getLogger(FacultyService.class);


    public FacultyService(FacultyRepository facultyRepository, StudentRepository studentRepository) {

        this.facultyRepository = facultyRepository;
        this.studentRepository = studentRepository;
    }


    public Faculty addFaculty(Faculty faculty){
        logger.info("Was invoked method for add faculty");
        return facultyRepository.save(faculty);
    }
    public Faculty findFaculty(long id){
        logger.debug("Requesting find faculty by id {}", id);
        return facultyRepository.findById(id).orElse(null);
    }
    public Faculty editFaculty(Faculty faculty){
        logger.info("Was invoked method for edit faculty");
        if (findFaculty(faculty.getId()) != null) {
            return facultyRepository.save(faculty);
        }
        return null;
    }
    public void deleteFaculty(long id){
        logger.info("Was invoked method for delete faculty");
        facultyRepository.deleteById(id);
    }

    public Collection<Faculty> findByColor(String color) {
        logger.info("Was invoked method for find faculty by color");
        return facultyRepository.findAllByColor(color);
    }
    public Collection<Faculty> findFacultiesByNameOrColor(String nameOrColor){
        logger.info("Was invoked method for find faculties by name or color");
        return facultyRepository.findByNameIgnoreCaseOrColorIgnoreCase(nameOrColor, nameOrColor);
    }

    public Collection<Student> getStudentsByFacultyId(Long id) {
        logger.info("Was invoked method for find students by faculty id");
        return studentRepository.findStudentByFacultyId(id);
    }

    public ResponseEntity<String> getFacultyNameWithMaxLength(){
        logger.info("Was invoked method for find faculty name with max length");
        Optional<String> maxFacultyName = facultyRepository.findAll().stream()
                .map(Faculty :: getName)
                .max(Comparator.comparing(String::length));
        if (maxFacultyName.isEmpty()) {
            logger.error("There is no faculties at all");
            return ResponseEntity.notFound().build();
        } else {
            logger.debug("Faculty name with max length:{}", maxFacultyName.get());
            return ResponseEntity.ok(maxFacultyName.get());
        }
    }
}
