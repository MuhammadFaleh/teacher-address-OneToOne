package com.JPARelation.one_oneTeacher.DTO.IN;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class CourseDTOIN {
    private Integer course_id;
    @NotBlank(message = "course name should not be empty")
    @Size(max=200, min = 4, message = "course name length should be between 4 and 200")
    private String name;
    private Integer teacher_id;
}
