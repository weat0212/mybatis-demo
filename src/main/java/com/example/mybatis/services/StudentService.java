package com.example.mybatis.services;

import com.example.mybatis.domain.Student;
import com.example.mybatis.mappers.StudentMapper;
import com.example.mybatis.util.MyBatisSqlSessionFactory;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.List;

public class StudentService {

    private Logger logger = LoggerFactory.getLogger(getClass());

    public List<Student> findAllStudents() {
        try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession()) {
            StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
            return studentMapper.findAllStudents();
        }
        // If sqlSession is not closed
        // then database Connection associated this sqlSession will not be returned to pool
        // and application may run out of connections.
    }

    public Student findStudentById(int studId) {

        logger.debug("Select Student By ID :{}", studId);

        try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession()) {
            StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
            return studentMapper.findStudentById(studId);
        }
    }

    public void createStudent(Student student) {
        try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession()) {
            StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
            studentMapper.insertStudent(student);
            sqlSession.commit();
        }
    }

    // Could be useless
    protected Connection getDatabaseConnection() throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/mybatis", "root", "password");
        } catch (SQLException e) {
            throw e;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
