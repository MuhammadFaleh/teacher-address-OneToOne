package com.JPARelation.one_oneTeacher.Service;

import com.JPARelation.one_oneTeacher.Api.ApiException;
import com.JPARelation.one_oneTeacher.DTO.IN.AddressDTOIN;
import com.JPARelation.one_oneTeacher.DTO.IN.CourseDTOIN;
import com.JPARelation.one_oneTeacher.DTO.OUT.CourseDTOOUT;
import com.JPARelation.one_oneTeacher.DTO.OUT.CourseTeacherDTOOUT;
import com.JPARelation.one_oneTeacher.DTO.OUT.TeacherDTOOUT;
import com.JPARelation.one_oneTeacher.Model.Address;
import com.JPARelation.one_oneTeacher.Model.Course;
import com.JPARelation.one_oneTeacher.Model.Teacher;
import com.JPARelation.one_oneTeacher.Repository.CourseRepository;
import com.JPARelation.one_oneTeacher.Repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseService{
    private final CourseRepository courseRepository;
    private final TeacherRepository teacherRepository;

    public List<CourseDTOOUT> getCourses(){
        ArrayList<CourseDTOOUT> courseDTOOUTS = new ArrayList<>();
        for(Course course : courseRepository.findAll()){
            courseDTOOUTS.add(convertToDTO(course));
        }
        return courseDTOOUTS;
    }

    public void createCourse(CourseDTOIN courseDTOIN){
        Course course= convertDtoToCourse(courseDTOIN);
        courseRepository.save(course);
    }

    public void updateCourse(Integer id, CourseDTOIN courseDTOIN){
        Course course = courseRepository.findCourseById(id);
        if(course == null){
            throw new ApiException("course not found");
        }
        course.setName(courseDTOIN.getName());
        courseRepository.save(course);
    }

    public void deleteCourse(Integer id){
        Course course = courseRepository.findCourseById(id);
        if(course == null){
            throw new ApiException("course not found");
        }
        courseRepository.delete(course);
    }

    public CourseTeacherDTOOUT getCourseById(Integer id){
        Course course = courseRepository.findCourseById(id);
        if(course == null){
            throw new ApiException("no course matches");
        }
        if(course.getTeacher() == null){
            return new CourseTeacherDTOOUT(course.getId(), course.getName(),
                    null , null ,null);
        }
        return new CourseTeacherDTOOUT(course.getId(), course.getName(),course.getTeacher().getName(),
                course.getTeacher().getAge(), course.getTeacher().getEmail());
    }

    public void assignCourse(Integer teacher_id, Integer course_id){
        Teacher teacher = teacherRepository.findTeacherById(teacher_id);
        Course course = courseRepository.findCourseById(course_id);
        if(teacher == null || course == null){
            throw new ApiException("the teacher or the course don't exist");
        }
        if(course.getTeacher() != null){
            throw new ApiException("course already assigned please un assign it first");
        }
        course.setTeacher(teacher);
        courseRepository.save(course);
    }

    public void unassignCourse(Integer teacher_id, Integer course_id){
        Teacher teacher = teacherRepository.findTeacherById(teacher_id);
        Course course = courseRepository.findCourseById(course_id);
        if(teacher == null || course == null){
            throw new ApiException("the teacher or the course don't exist");
        }
        if(course.getTeacher() == null){
            throw new ApiException("course already unassigned");
        }
        if(!course.getTeacher().getId().equals(teacher_id)){
            throw new ApiException("not the same teacher");
        }
        course.setTeacher(null);
        courseRepository.save(course);
    }

    public Course convertDtoToCourse(CourseDTOIN courseDTOIN){
        Teacher teacher = teacherRepository.findTeacherById(courseDTOIN.getTeacher_id());
        if(teacher == null){
            return new Course(courseDTOIN.getCourse_id(), courseDTOIN.getName(), null);
        }
        return new Course(courseDTOIN.getCourse_id(),courseDTOIN.getName(), teacher);
    }

    public CourseDTOOUT convertToDTO(Course course){
        if(course.getTeacher() == null){
            return new CourseDTOOUT(course.getId(), course.getName(), null);
        }
        return new CourseDTOOUT(course.getId(),course.getName(), course.getTeacher().getId());
    }


}
