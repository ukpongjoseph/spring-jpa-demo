package dev.joseph.practice.student_management.studentProfile;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
public class StudentProfileController {
    private StudentProfileService service;

    public StudentProfileController(StudentProfileService service){
        this.service = service;
    }

    @PostMapping("/profiles")
    public StudentProfileResponseDto createStudentProfile( @RequestBody StudentProfileDto dto){
        return service.createStudentProfile(dto);
    }

    @PutMapping("profiles/{id}")
    public StudentProfileResponseDto updateProfile(@PathVariable Integer id, @RequestBody StudentProfileDto dto) {
        return service.updateProfile(id, dto);
    }
}
