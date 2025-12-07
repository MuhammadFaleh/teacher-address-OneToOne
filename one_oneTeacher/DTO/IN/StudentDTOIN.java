package com.JPARelation.one_oneTeacher.DTO.IN;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDTOIN {
    private Integer student_id;
    @NotBlank(message = "student name should not be empty")
    @Size(max = 200, message = "student name should not be longer than 200")
    private String name;
    @NotNull(message = "student age should not be empty")
    @Min(value = 15, message = "student should be 15 or older")
    private Integer age;
    @NotBlank(message = "student major should not be empty")
    @Size(max = 200, message = "student major should not be longer than 200")
    private String major;
}
