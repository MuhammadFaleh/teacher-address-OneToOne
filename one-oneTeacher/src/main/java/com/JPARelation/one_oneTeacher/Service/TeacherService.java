package com.JPARelation.one_oneTeacher.Service;

import com.JPARelation.one_oneTeacher.Api.ApiException;
import com.JPARelation.one_oneTeacher.DTO.IN.TeacherDTOIN;
import com.JPARelation.one_oneTeacher.DTO.OUT.TeacherDTOOUT;
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
public class TeacherService {
    private final TeacherRepository teacherRepository;
    private final CourseRepository courseRepository;

    public List<TeacherDTOOUT> getTeachers(){
        ArrayList<TeacherDTOOUT> teacherDTOOUTS = new ArrayList<>();
        for(Teacher teacher : teacherRepository.findAll()){
            teacherDTOOUTS.add(convertToDTO(teacher));
        }
        return teacherDTOOUTS;
    }

    public void addTeacher(TeacherDTOIN teacherDTOIN){
        teacherRepository.save(convertToObject(teacherDTOIN));
    }

    public void updateTeacher(Integer id, TeacherDTOIN teacherDTOIN){
        Teacher teacher = teacherRepository.findTeacherById(id);

        if (teacher==null){
            throw new ApiException("teacher not found");
        }
        teacher.setAge(teacherDTOIN.getAge());
        teacher.setName(teacherDTOIN.getName());
        teacher.setSalary(teacherDTOIN.getSalary());
        teacher.setEmail(teacherDTOIN.getEmail());
        teacherRepository.save(teacher);
    }

    public void deleteProfile(Integer id){
        Teacher teacher = teacherRepository.findTeacherById(id);

        if (teacher==null){
            throw new ApiException("teacher not found");
        }
        teacherRepository.delete(teacher);
    }

    public Teacher getTeacherById(Integer id){
        return teacherRepository.findTeacherById(id);
    }



    public Teacher convertToObject(TeacherDTOIN teacher){
        return new Teacher(teacher.getTeacher_id(), teacher.getName(),teacher.getAge(), teacher.getEmail(),teacher.getSalary(),
                null, null);
    }

    public TeacherDTOOUT convertToDTO(Teacher teacher){
        return new TeacherDTOOUT(teacher.getId(),teacher.getName(),teacher.getAge(),teacher.getEmail(),teacher.getSalary());
    }

}
