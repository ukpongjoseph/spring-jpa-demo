package dev.joseph.practice.student_management.studentProfile;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import dev.joseph.practice.student_management.student.Student;
import dev.joseph.practice.student_management.student.StudentRepository;

@Component
public class StudentProfileMapper {
    private StudentRepository repository;

    public StudentProfileMapper(StudentRepository repo){
        this.repository = repo;
    }

    // Here we want to recieve a StudentProfileDto and use it to make StudentProfile object. This StudentProfile object must have an Id(auto-generated), a profile(which is a string), a Student object....and to have all of this we need a studentId from the dto to search for the student and put the found student in the studentProfile object and secondly, a string which is the studentProfile which will in end be put in the studentProfile object
    public StudentProfile dtoToStudentProfile(StudentProfileDto dto){
        Student foundStudent = repository.findById(dto.studentId()).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND, "Student Not Found"));
        StudentProfile studentProfile = new StudentProfile();
        studentProfile.setStudent(foundStudent);
        studentProfile.setProfile(dto.studentProfile());
        return studentProfile;
    }


    // This method is used to build a StudentProfileResponseDto using a StudentProfile object. This response need to have studentName and the studentProfile. We can get the Student Profile from the StudentProfle object and the studentName from the getting the Student from the studentProfile and from the student, we get the name
    public StudentProfileResponseDto profileToStudentProfileResponseDto(StudentProfile profile){
        StudentProfileResponseDto responseDto = new StudentProfileResponseDto(profile.getStudent().getName(), profile.getProfile());
        return responseDto;
    }

}
