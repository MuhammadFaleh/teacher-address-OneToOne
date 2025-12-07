package com.JPARelation.one_oneTeacher.Service;

import com.JPARelation.one_oneTeacher.Api.ApiException;
import com.JPARelation.one_oneTeacher.DTO.IN.StudentDTOIN;
import com.JPARelation.one_oneTeacher.DTO.OUT.CourseStudentDTOOUT;
import com.JPARelation.one_oneTeacher.DTO.OUT.StudentDTOOUT;
import com.JPARelation.one_oneTeacher.Model.Course;
import com.JPARelation.one_oneTeacher.Model.Student;
import com.JPARelation.one_oneTeacher.Repository.CourseRepository;
import com.JPARelation.one_oneTeacher.Repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;

    public List<StudentDTOOUT> getStudents(){
        ArrayList<StudentDTOOUT> studentDTOOUTS = new ArrayList<>();
        for (Student student : studentRepository.findAll()){
            studentDTOOUTS.add(convertToDTO(student));
        }

        return studentDTOOUTS;
    }

    public void createStudent(StudentDTOIN studentDTOIN){
        Student student = convertToEntity(studentDTOIN);
        studentRepository.save(student);
    }

    public void updateStudent(Integer id, StudentDTOIN studentDTOIN){
        Student student = studentRepository.findStudentById(id);
        if(student == null){
            throw  new ApiException("student not found");
        }
        student.setAge(studentDTOIN.getAge());
        student.setName(student.getName());
        studentRepository.save(student);
    }

    public void deleteStudent(Integer id){
        Student student = studentRepository.findStudentById(id);
        if(student == null){
            throw  new ApiException("student not found");
        }
        removeStudentFromCourses(student.getCourses(), student);
        studentRepository.delete(student);
    }

    public void updateStudentMajor(Integer id, String major){
        Student student = studentRepository.findStudentById(id);
        if(student == null){
            throw  new ApiException("student not found");
        }
        if(major.equalsIgnoreCase(student.getMajor())){
            throw new ApiException("the major is the same");
        }
        student.setMajor(major);
        removeStudentFromCourses(student.getCourses(), student);
        student.getCourses().clear();
        studentRepository.save(student);
    }

    public void removeStudentFromCourses(Set<Course> courses, Student student){
        for(Course course : courses){
            course.getStudents().remove(student);
        }
    }

    public void addCourse(Integer id, Integer course_id){
        Student student = studentRepository.findStudentById(id);
        Course course = courseRepository.findCourseById(course_id);
        if(student == null || course == null){
            throw  new ApiException("course or student not found");
        }
        if(course.getTeacher() == null){
            throw new ApiException("the course has no teacher");
        }
        student.getCourses().add(course);
        course.getStudents().add(student);
        studentRepository.save(student);
        courseRepository.save(course);
    }

    public void removeCourse(Integer id, Integer course_id){
        Student student = studentRepository.findStudentById(id);
        Course course = courseRepository.findCourseById(course_id);
        if(student == null || course == null){
            throw  new ApiException("course or student not found");
        }
        student.getCourses().remove(course);
        course.getStudents().remove(student);
        studentRepository.save(student);
        courseRepository.save(course);
    }

    public Student convertToEntity(StudentDTOIN studentDTOIN){
        return new Student(studentDTOIN.getStudent_id(), studentDTOIN.getName(), studentDTOIN.getAge(), studentDTOIN.getMajor(), null);
    }

    public StudentDTOOUT convertToDTO(Student student){
        return new StudentDTOOUT(student.getId(), student.getName(), student.getAge(), student.getMajor());
    }


}
