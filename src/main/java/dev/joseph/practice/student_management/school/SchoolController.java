package dev.joseph.practice.student_management.school;

import org.springframework.web.bind.annotation.RestController;

import dev.joseph.practice.student_management.student.StudentResponseDto;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;






@RestController
public class SchoolController {

    private SchoolService service;

    public SchoolController(SchoolService service){
        this.service = service;
    }
    
    @PostMapping("/schools")
    public SchoolResponseDto createSchool(
        
      @Valid  @RequestBody SchoolDto dto) {
        return service.createSchool(dto);
    }

    @GetMapping("/schools")
    public List<SchoolResponseDto> getAllSchools() {
        return service.getAllSchools();
    }
    
    @PutMapping("schools/{id}")
    public SchoolResponseDto updateASchool(@PathVariable Integer id, @Valid @RequestBody SchoolDto dto) {
        return service.updateASchool(dto, id);
    }
    
    @GetMapping("/schools/{Id}")
    public SchoolResponseDto getASchool(@PathVariable Integer Id) {
        return service.getASchool(Id);
    }

    @DeleteMapping("/schools/{Id}")
    public ResponseEntity<String> deleteAchool(@PathVariable Integer Id){
        return service.deleteAchool(Id);
    }

    // The whole idea of this controller is to fetch the list of all students in a school. We would be needing a schoolId. The flow is to fetch a school in its School form, then call the class method to get list of all students. Pass this list through a stream and then return a List of studentResponseDto
    @GetMapping("schools/{schoolId}/all_students")
    public List<StudentResponseDto> getListOfAllStudents(@PathVariable Integer schoolId) {
        return service.fetAllStudentsInASchool(schoolId);
    }
    
    
}
