package com.JPARelation.one_oneTeacher.DTO.OUT;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeacherDTOOUT {
    private Integer teacher_id;
    private String name;
    private Integer age;
    private String email;
    private Double salary;
}
