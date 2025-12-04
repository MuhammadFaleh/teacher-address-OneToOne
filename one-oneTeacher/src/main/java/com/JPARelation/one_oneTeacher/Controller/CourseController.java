package com.JPARelation.one_oneTeacher.Controller;

import com.JPARelation.one_oneTeacher.Api.ApiResponse;
import com.JPARelation.one_oneTeacher.DTO.IN.CourseDTOIN;
import com.JPARelation.one_oneTeacher.DTO.IN.TeacherDTOIN;
import com.JPARelation.one_oneTeacher.Service.CourseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/course")
public class CourseController {
    private final CourseService courseService;

    @GetMapping("/get-courses")
    public ResponseEntity<?> getCourses(){

        return ResponseEntity.status(200).body(courseService.getCourses());
    }

    @PostMapping("/create-course")
    public ResponseEntity<?> createCourse(@RequestBody @Valid CourseDTOIN courseDTOIN){
        courseService.createCourse(courseDTOIN);
        return ResponseEntity.status(200).body(new ApiResponse("course was created successfully"));
    }

    @PutMapping("/update-course/{id}")
    public ResponseEntity<?> updateCourse(@PathVariable Integer id, @RequestBody @Valid CourseDTOIN courseDTOIN){
        courseService.updateCourse(id, courseDTOIN);
        return ResponseEntity.status(200).body(new ApiResponse("course was updated successfully"));
    }
    @DeleteMapping("/delete-course/{id}")
    public ResponseEntity<?> deleteCourse(@PathVariable Integer id){
        courseService.deleteCourse(id);
        return ResponseEntity.status(200).body(new ApiResponse("course was deleted successfully"));
    }

    @GetMapping("/get-course-id/{id}")
    public ResponseEntity<?> getTeacherById(@PathVariable Integer id){
        return ResponseEntity.status(200).body(courseService.getCourseById(id));
    }

    @PutMapping("/assign-course/{teacher_id}/{course_id}")
    public ResponseEntity<?> assignCourse(@PathVariable Integer teacher_id, @PathVariable Integer course_id){
        courseService.assignCourse(teacher_id,course_id);
        return ResponseEntity.status(200).body(new ApiResponse("course assigned successfully"));
    }

    @PutMapping("/unassign-course/{teacher_id}/{course_id}")
    public ResponseEntity<?> unassignCourse(@PathVariable Integer teacher_id, @PathVariable Integer course_id){
        courseService.unassignCourse(teacher_id, course_id);
        return ResponseEntity.status(200).body(new ApiResponse("course unassigned successfully"));
    }
}
