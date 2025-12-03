package com.JPARelation.one_oneTeacher.Service;

import com.JPARelation.one_oneTeacher.Api.ApiException;
import com.JPARelation.one_oneTeacher.DTO.AddressDTO;
import com.JPARelation.one_oneTeacher.DTO.TeacherDTO;
import com.JPARelation.one_oneTeacher.Model.Address;
import com.JPARelation.one_oneTeacher.Model.Teacher;
import com.JPARelation.one_oneTeacher.Repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TeacherService {
    private final TeacherRepository teacherRepository;

    public List<Teacher> getTeachers(){
        return teacherRepository.findAll();
    }

    public void addTeacher(TeacherDTO teacherDTO){
        teacherRepository.save(convertToObject(teacherDTO));
    }

    public void updateTeacher(Integer id,TeacherDTO teacherDTO){
        Teacher teacher = getTeacherById(id);

        if (teacher==null){
            throw new ApiException("teacher not found");
        }
        teacher.setAge(teacherDTO.getAge());
        teacher.setName(teacherDTO.getName());
        teacher.setSalary(teacherDTO.getSalary());
        teacher.setEmail(teacherDTO.getEmail());
        teacherRepository.save(teacher);
    }

    public void deleteProfile(Integer id){
        Teacher teacher = getTeacherById(id);

        if (teacher==null){
            throw new ApiException("teacher not found");
        }
        teacherRepository.delete(teacher);
    }

    public Teacher getTeacherById(Integer id){
        return teacherRepository.findTeacherById(id);
    }

    public Teacher convertToObject(TeacherDTO teacher){
        return new Teacher(teacher.getTeacher_id(), teacher.getName(),teacher.getAge(), teacher.getEmail(),teacher.getSalary(),
                null);
    }

}
