package dev.joseph.practice.student_management.school;

import jakarta.validation.constraints.NotBlank;

public record SchoolDto(
    @NotBlank
    String name
) {
}