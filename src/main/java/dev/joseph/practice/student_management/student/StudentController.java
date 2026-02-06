package dev.joseph.practice.student_management.student;

import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;






@RestController
public class StudentController {
    private StudentService service;

    public StudentController(StudentService service){
        this.service = service;
    }
    
    @GetMapping("/")
    public String welcome(){
        return "Welcome to the server running test phase";
    }

    @PostMapping("/students")
    public StudentResponseDto saveStudent(@Valid  @RequestBody StudentDto dto) {
        return service.saveStudent(dto);
    }

    @GetMapping("/students")
    public List<StudentResponseDto> getAllStudents() {
        return service.getAllStudents();
    }
    

    @GetMapping("/students/{Id}")
    public StudentResponseDto getStudentById(@PathVariable Integer Id) {
        return service.getStudentById(Id);
    }
    
    @PutMapping("/students/{Id}")
    public StudentResponseDto updateAStudent(@PathVariable Integer Id, @Valid  @RequestBody StudentDto update) {
        return service.updateAStudent(Id, update);
    }

   
    @DeleteMapping("/students/{Id}")
    public ResponseEntity<String> deleteAStudent(@PathVariable Integer Id){
       return service.deleteAStudent(Id);
    }
    
}
