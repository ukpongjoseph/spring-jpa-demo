package dev.joseph.practice.student_management.school;

import org.springframework.web.bind.annotation.RestController;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;





@RestController
public class SchoolController {

    private SchoolService service;

    public SchoolController(SchoolService service){
        this.service = service;
    }
    
    @PostMapping("/schools")
    public SchoolResponseDto createSchool(@RequestBody SchoolDto dto) {
        return service.createSchool(dto);
    }

    @GetMapping("/schools")
    public List<SchoolResponseDto> getAllSchools() {
        return service.getAllSchools();
    }
    
    @PutMapping("schools/{id}")
    public SchoolResponseDto updateASchool(@PathVariable Integer id, @RequestBody SchoolDto dto) {
        return service.updateASchool(dto, id);
    }
    
    @GetMapping("/schools/{Id}")
    public SchoolResponseDto getASchool(@PathVariable Integer Id) {
        return service.getASchool(Id);
    }

    @DeleteMapping("/schools/{Id}")
    public void deleteAchool(@PathVariable Integer Id){
        service.deleteAchool(Id);
    }
    
}
