package com.JPARelation.one_oneTeacher.DTO.OUT;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class CourseTeacherDTOOUT {
    private Integer course_id;
    private String course_name;
    private String teacher_name;
    private Integer teacher_age;
    private String teacher_email;
}
