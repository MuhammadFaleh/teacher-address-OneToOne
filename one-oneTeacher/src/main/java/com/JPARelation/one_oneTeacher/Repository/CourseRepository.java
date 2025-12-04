package com.JPARelation.one_oneTeacher.Repository;


import com.JPARelation.one_oneTeacher.Model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Integer> {
    Course findCourseById(Integer id);

}
