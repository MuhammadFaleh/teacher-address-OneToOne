package com.JPARelation.one_oneTeacher.DTO.OUT;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class CourseDTOOUT {
    private Integer course_id;
    private String name;
    private Integer teacher_id;
}
