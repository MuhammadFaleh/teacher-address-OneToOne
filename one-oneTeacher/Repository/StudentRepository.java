package com.JPARelation.one_oneTeacher.Repository;

import com.JPARelation.one_oneTeacher.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {
    Student findStudentById(Integer id);
}
