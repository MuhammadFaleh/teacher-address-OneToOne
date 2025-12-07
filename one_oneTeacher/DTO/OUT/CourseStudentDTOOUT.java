package com.JPARelation.one_oneTeacher.DTO.OUT;

import com.JPARelation.one_oneTeacher.Model.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseStudentDTOOUT {
    private Integer course_id;
    private String teacher_name;
    private String teacher_email;
    private Set<StudentDTOOUT> students;
}
