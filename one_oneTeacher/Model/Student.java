package com.JPARelation.one_oneTeacher.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(columnDefinition = "varchar(200) not null")
    private String name;
    @Column(columnDefinition = "int not null check(age>=15)")
    private Integer age;
    @Column(columnDefinition = "varchar(200) not null")
    private String major;
    @ManyToMany(mappedBy = "students")
    private Set<Course> courses;
}
