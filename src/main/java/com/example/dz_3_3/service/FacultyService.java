package com.example.dz_3_3.service;

import com.example.dz_3_3.model.Faculty;
import com.example.dz_3_3.repository.FacultyRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;
@Service
public class FacultyService {

    private final FacultyRepository facultyRepository;

    public FacultyService(FacultyRepository facultyRepository) {
        this.facultyRepository = facultyRepository;
    }


    public Faculty addFaculty(Faculty faculty){
        return facultyRepository.save(faculty);
    }
    public Faculty findFaculty(long id){
        return facultyRepository.findById(id).orElse(null);
    }
    public Faculty editFaculty(Faculty faculty){
        if (findFaculty(faculty.getId()) != null) {
            return facultyRepository.save(faculty);
        }
        return null;
    }
    public void deleteFaculty(long id){
        facultyRepository.deleteById(id);
    }

    public Collection<Faculty> findByColor(String color) {
        return facultyRepository.findAllByColor(color);
    }
    public Collection<Faculty> findFacultiesByNameOrColor(String name, String color){
        return facultyRepository.findByNameIgnoreCaseOrColorIgnoreCase(name, color);
    }
}
