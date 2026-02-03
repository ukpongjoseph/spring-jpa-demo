package dev.joseph.practice.student_management.student;

import dev.joseph.practice.student_management.school.School;
import dev.joseph.practice.student_management.studentProfile.StudentProfile;

public class StudentMapper {
    public Student dtoToStudent(StudentDto dto){
        Student stud = new Student();
        stud.setName(dto.name());
        stud.setEmail(dto.email());
        stud.setAge(dto.age());
        School studenSchool = new School();
        studenSchool.setId(dto.school_id());
        stud.setSchool(studenSchool);
        
        return stud;
    }

    public StudentResponseDto studentToResponseDto(Student stud){
        StudentResponseDto responseDto = new StudentResponseDto(stud.getName(), stud.getEmail(), stud.getStudentProfile().getProfile());
        return responseDto;
    }
}
