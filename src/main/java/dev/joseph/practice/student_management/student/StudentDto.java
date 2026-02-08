package dev.joseph.practice.student_management.student;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record StudentDto(
    @NotBlank
    String name,

    @NotBlank
    @Email
    String email,

    @NotNull
    @Min(value = 12)
    @Max(value = 19)
    int age,

    Integer schoolId
) {
}
