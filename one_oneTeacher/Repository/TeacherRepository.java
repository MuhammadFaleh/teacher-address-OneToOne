package com.JPARelation.one_oneTeacher.Repository;

import com.JPARelation.one_oneTeacher.Model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher, Integer> {
    Teacher findTeacherById(Integer id);
}
