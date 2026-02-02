package dev.joseph.practice.student_management.student;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
public class StudentController {
    
    @GetMapping("/")
    public String welcome(){
        return "Welcome to the server running test phase";
    }
}
