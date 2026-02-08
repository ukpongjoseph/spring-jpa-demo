package dev.joseph.practice.student_management.student;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import dev.joseph.practice.student_management.school.School;
import dev.joseph.practice.student_management.school.SchoolRepository;


// Modifications to the code involves adding school details to the student data. We should have it in mind that that the student entity has the school entity (more precisely its reference) as one of its instances variables. The big question is how do we use the data from the student dto to fetch an instance of school? where only the school id is passed in the dto object. To fetch the school, we fetch from the db using the repository
@Component
public class StudentMapper {
    private SchoolRepository repository;

    public StudentMapper(SchoolRepository repo){
        this.repository = repo;
    }

    public Student dtoToStudent(StudentDto dto){
        Student stud = new Student();
        stud.setName(dto.name());
        stud.setEmail(dto.email());
        stud.setAge(dto.age());
        School studentSchool = repository.findById(dto.schoolId()).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND, "School Not Found"));
        stud.setSchool(studentSchool);
        return stud;
    }

    public StudentResponseDto studentToResponseDto(Student stud){
        StudentResponseDto responseDto = new StudentResponseDto(stud.getName(), stud.getEmail());
        return responseDto;
    }
}
