package com.example.mybatis.services;

import com.example.mybatis.domain.PhoneNumber;
import com.example.mybatis.domain.Student;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
class StudentServiceTest {

    @Mock
    StudentService studentService;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
        this.studentService = null;
    }

    @Test
    void findAllStudents() {
        List<Student> students = studentService.findAllStudents();
        assertNotNull(students);
        for (Student student : students) {
            System.out.println(student);
        }
    }

    @Test
    void findStudentById() {
        Student student = studentService.findStudentById(1);
        assertNotNull(student);
        System.out.println(student);
    }

    @Test
    void createStudent() {
        Student student = new Student();
        int id = 3;
        student.setStudId(id);
        student.setName("student_" + id);
        student.setEmail("student_" + id + "gmail.com");
        student.setPhoneNumber(new PhoneNumber("09123123"));
        studentService.createStudent(student);
        Student newStudent = studentService.findStudentById(id);
        assertNotNull(newStudent);
    }
}