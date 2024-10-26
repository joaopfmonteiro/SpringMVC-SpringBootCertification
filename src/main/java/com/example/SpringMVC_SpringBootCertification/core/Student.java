package com.example.SpringMVC_SpringBootCertification.core;

public class Student {

    private Long id;
    private String firstName;
    private String surName;
    private String dept;
    private Double fess;

    public Student() {
        super();
    }

    public Student(long id, String firstName, String surName, String dept, Double fess) {
        super();
        this.id = id;
        this.firstName = firstName;
        this.surName = surName;
        this.dept = dept;
        this.fess = fess;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public Double getFess() {
        return fess;
    }

    public void setFess(Double fess) {
        this.fess = fess;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", surName='" + surName + '\'' +
                ", dept='" + dept + '\'' +
                ", fess=" + fess +
                '}';
    }
}
