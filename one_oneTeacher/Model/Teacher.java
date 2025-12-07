package com.JPARelation.one_oneTeacher.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(columnDefinition = "varchar(200) not null check(length(name)>4)")
    private String name;
    @Column(columnDefinition = "int not null check(age>20)")
    private Integer age;
    @Column(columnDefinition = "Varchar(200) not null unique")
    private String email;
    @Column(columnDefinition = "double not null check(salary>5000)")
    private Double salary;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "teacher")
    @PrimaryKeyJoinColumn
    private Address address;
    @OneToMany(mappedBy = "teacher")
    private Set<Course> course;
}
