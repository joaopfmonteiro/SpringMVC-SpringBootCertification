package com.example.SpringMVC_SpringBootCertification.service;

import com.example.SpringMVC_SpringBootCertification.core.Student;

import java.util.Collection;

public interface StudentService {

    Student getOne(long id);
    Collection<Student> getAllStudents();
    Collection<Student> getStudentsInDepartment(String department, String lastNameLike);
    void add(Student student);
}
