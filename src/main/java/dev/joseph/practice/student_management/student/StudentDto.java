package dev.joseph.practice.student_management.student;

public record StudentDto(
    String name,
    String email,
    String profile,
    int age,
    int school_id
) {
}
