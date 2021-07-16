package com.example.mybatis.mappers;

import com.example.mybatis.domain.Student;

import java.util.List;

public interface StudentMapper {

    List<Student> findAllStudents();

    Student findStudentById(Integer id);

    void insertStudent(Student student);
}
