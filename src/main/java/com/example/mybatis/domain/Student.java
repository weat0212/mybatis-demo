package com.example.mybatis.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Data
@Entity(name = "STUDENTS")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer studId;
    private String name;
    private String email;
    private Date dob;
    // setters and getters
}
