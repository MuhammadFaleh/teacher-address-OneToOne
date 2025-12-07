package com.JPARelation.one_oneTeacher.DTO.OUT;

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
public class StudentDTOOUT {
    private Integer student_id;
    private String name;
    private Integer age;
    private String major;
}
