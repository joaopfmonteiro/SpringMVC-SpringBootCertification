package com.example.SpringMVC_SpringBootCertification.dao;

import com.example.SpringMVC_SpringBootCertification.core.Student;

import java.util.Collection;

public interface StudentDao {

    Student getOne(long id);
    Collection<Student> getAll();
    void add(Student student);
}
