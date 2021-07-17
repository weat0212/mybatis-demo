package com.example.mybatis.domain;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer studId;
    private String name;
    private String email;
    private PhoneNumber phoneNumber;
    // setters and getters
}
