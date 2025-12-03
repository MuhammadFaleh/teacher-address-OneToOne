package com.JPARelation.one_oneTeacher.Controller;

import com.JPARelation.one_oneTeacher.Api.ApiResponse;
import com.JPARelation.one_oneTeacher.DTO.AddressDTO;
import com.JPARelation.one_oneTeacher.DTO.TeacherDTO;
import com.JPARelation.one_oneTeacher.Service.AddressService;
import com.JPARelation.one_oneTeacher.Service.TeacherService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/teacher")
public class TeacherController {
    private final TeacherService teacherService;

    @GetMapping("/get-teachers")
    public ResponseEntity<?> getTeachers(){

        return ResponseEntity.status(200).body(teacherService.getTeachers());
    }

    @PostMapping("/create-teacher")
    public ResponseEntity<?> createTeacher(@RequestBody @Valid TeacherDTO teacherDTO){
        teacherService.addTeacher(teacherDTO);
        return ResponseEntity.status(200).body(new ApiResponse("teacher was created successfully"));

    }
    @PutMapping("/update-teacher/{id}")
    public ResponseEntity<?> updateTeacher(@PathVariable Integer id, @RequestBody @Valid TeacherDTO teacherDTO){
        teacherService.updateTeacher(id,teacherDTO);
        return ResponseEntity.status(200).body(new ApiResponse("teacher was updated successfully"));
    }
    @DeleteMapping("/delete-teacher/{id}")
    public ResponseEntity<?> deleteTeacher(@PathVariable Integer id){
        teacherService.deleteProfile(id);
        return ResponseEntity.status(200).body(new ApiResponse("teacher was deleted successfully"));
    }

    @GetMapping("/get-teacher-id/{id}")
    public ResponseEntity<?> getTeacherById(@PathVariable Integer id){
        return ResponseEntity.status(200).body(teacherService.getTeacherById(id));
    }
}
