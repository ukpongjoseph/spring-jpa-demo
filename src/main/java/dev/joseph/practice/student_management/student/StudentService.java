package dev.joseph.practice.student_management.student;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class StudentService {
    private StudentRepository repository;
    private StudentMapper mapper;

    public StudentService(StudentRepository repository, StudentMapper mapper){
        this.repository = repository;
        this.mapper = mapper;
    }

    public StudentResponseDto saveStudent(StudentDto dto){
        Student student = mapper.dtoToStudent(dto);
        Student savedStudent = repository.save(student);
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

    public void deleteAStudent(Integer Id) {
        repository.deleteById(Id);
    }
}
