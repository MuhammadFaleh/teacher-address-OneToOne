package com.JPARelation.one_oneTeacher.DTO.IN;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeacherDTOIN {
    private Integer teacher_id;
    @NotBlank(message = "name must not be empty")
    @Size(max = 200,min = 4, message = "email size should not be shorter than 4 or longer than 200 characters")
    @Pattern(message = "name must be in english and only contain letters", regexp = "^[a-zA-Z]+$")
    private String name;
    @NotNull(message = "age must not be empty")
    @Min(value = 20, message = "age must be 20 or older")
    private Integer age;
    @NotBlank(message = "email must not be empty")
    @Size(max = 200, message = "email size should not be longer than 200 characters")
    @Email(message = "enter a valid email")
    private String email;
    @NotNull(message = "salary must not be empty")
    @Min(value = 5000, message = "salary must be at least 5000")
    private Double salary;
}
