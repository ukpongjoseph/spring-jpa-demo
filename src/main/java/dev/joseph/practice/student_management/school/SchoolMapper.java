package dev.joseph.practice.student_management.school;

import org.springframework.stereotype.Component;

@Component
public class SchoolMapper {

    public School dtoToSchool(SchoolDto dto) {
        return new School(
                dto.name());
    }

    public SchoolResponseDto schoolToSchoolResponseDto(School school) {
        return new SchoolResponseDto(school.getId(), school.getName());
    }

}
