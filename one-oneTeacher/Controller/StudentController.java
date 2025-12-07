package com.JPARelation.one_oneTeacher.Controller;

import com.JPARelation.one_oneTeacher.Api.ApiResponse;
import com.JPARelation.one_oneTeacher.DTO.IN.StudentDTOIN;
import com.JPARelation.one_oneTeacher.Service.StudentService;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/student")
public class StudentController {
    private final StudentService studentService;

    @GetMapping("/get-students")
    public ResponseEntity<?> getStudents(){
        return ResponseEntity.status(200).body(studentService.getStudents());
    }

    @PostMapping("/create-student")
    public ResponseEntity<?> createStudents(@RequestBody @Valid StudentDTOIN studentDTOIN){
        studentService.createStudent(studentDTOIN);
        return ResponseEntity.status(200).body(new ApiResponse("student created successfully"));
    }

    @PutMapping("/update-student/{id}")
    public ResponseEntity<?> updateStudents(@PathVariable Integer id, @RequestBody @Valid StudentDTOIN studentDTOIN){
        studentService.updateStudent(id, studentDTOIN);
        return ResponseEntity.status(200).body(new ApiResponse("student updated successfully"));
    }

    @DeleteMapping("/delete-student/{id}")
    public ResponseEntity<?> deleteStudents(@PathVariable Integer id){
        studentService.deleteStudent(id);
        return ResponseEntity.status(200).body(new ApiResponse("student deleted successfully"));
    }

    @PutMapping("/add-course/{student_id}/{course_id}")
    public ResponseEntity<?> addCourse(@PathVariable Integer student_id, @PathVariable Integer course_id){
        studentService.addCourse(student_id, course_id);
        return ResponseEntity.status(200).body(new ApiResponse("student added to course successfully"));
    }

    @PutMapping("/remove-course/{student_id}/{course_id}")
    public ResponseEntity<?> removeCourse(@PathVariable Integer student_id, @PathVariable Integer course_id){
        studentService.removeCourse(student_id,course_id);
        return ResponseEntity.status(200).body(new ApiResponse("student removed from course successfully"));
    }

    @PutMapping("/change-major/{student_id}/{major}")
    public ResponseEntity<?> changeMajor(@PathVariable Integer student_id, @PathVariable String major){
        studentService.updateStudentMajor(student_id, major);
        return ResponseEntity.status(200).body(new ApiResponse("student major changed successfully and courses dropped"));
    }


}
