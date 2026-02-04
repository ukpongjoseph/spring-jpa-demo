package dev.joseph.practice.student_management.student;

import org.springframework.stereotype.Component;

// import dev.joseph.practice.student_management.school.School;


@Component
public class StudentMapper {
    public Student dtoToStudent(StudentDto dto){
        Student stud = new Student();
        stud.setName(dto.name());
        stud.setEmail(dto.email());
        stud.setAge(dto.age());
        return stud;
    }

    public StudentResponseDto studentToResponseDto(Student stud){
        StudentResponseDto responseDto = new StudentResponseDto(stud.getName(), stud.getEmail());
        return responseDto;
    }
}
