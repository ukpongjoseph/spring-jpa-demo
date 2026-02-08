package dev.joseph.practice.student_management.student;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import dev.joseph.practice.student_management.school.School;
import dev.joseph.practice.student_management.school.SchoolRepository;

@Service
public class StudentService {
    private StudentRepository repository;
    private SchoolRepository repository2;
    private StudentMapper mapper;

    public StudentService(StudentRepository repository, StudentMapper mapper, SchoolRepository repo){
        this.repository = repository;
        this.mapper = mapper;
        this.repository2 = repo;
    }

    // After creating a student with the necessary details one of which is the school details. We would add the student to the school list of students. Question is how? In the dto, we have the the schoolId..we can use the schoolId to fetch the the school and then add the student to the list of students under the school
    public StudentResponseDto saveStudent(StudentDto dto){
        Student student = mapper.dtoToStudent(dto);
        Student savedStudent = repository.save(student);
        School school = repository2.findById(dto.schoolId()).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND, "School Not Found"));
        school.addStudentToList(savedStudent);
        return mapper.studentToResponseDto(savedStudent);
    }

    public List<StudentResponseDto> getAllStudents(){
        return repository
            .findAll()
            .stream()
            .map((item)->mapper.studentToResponseDto(item))
            .collect(Collectors.toList());
    }

    public StudentResponseDto getStudentById(Integer Id){
        return mapper.studentToResponseDto(repository.findById(Id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND, "Not Found")));
    }

    public StudentResponseDto updateAStudent(Integer Id, StudentDto update){
        Student studentUpdate = mapper.dtoToStudent(update);
        Student foundStudent = repository.findById(Id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND, "Student not found"));
        foundStudent.setAge(studentUpdate.getAge());
        foundStudent.setName(studentUpdate.getName());
        foundStudent.setEmail(studentUpdate.getEmail());
        foundStudent.setId(Id);
        StudentResponseDto foundStudentResponseDto = mapper.studentToResponseDto(repository.save(foundStudent));
        return foundStudentResponseDto;
    }

     // Here we return a status code of 204 (No content)..and as such the response body message would not show because when spring sees a 204, no conetnt status code...it ignores any response body
    public ResponseEntity<String> deleteAStudent(Integer Id) {
        repository.deleteById(Id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Student deleted successfully");
    }
}
