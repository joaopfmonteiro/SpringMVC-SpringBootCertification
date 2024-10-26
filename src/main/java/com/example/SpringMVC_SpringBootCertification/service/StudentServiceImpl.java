package com.example.SpringMVC_SpringBootCertification.service;

import com.example.SpringMVC_SpringBootCertification.core.Student;
import com.example.SpringMVC_SpringBootCertification.dao.StudentDao;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.Collection;
import java.util.stream.Collectors;

@Named
public class StudentServiceImpl implements StudentService{

    @Inject
    StudentDao studentDao;

    @Override
    public Student getOne(long id){
        return studentDao.getOne(id);
    }

    @Override
    public Collection<Student> getAllStudents(){
        return studentDao.getAll();
    }

    @Override
    public Collection<Student> getStudentsInDepartment(String department, String lastNameLike){
        return studentDao.getAll()
                .stream()
                .filter(p-> p.getDept().equals(department))
                .filter(p-> p.getSurName().contains(lastNameLike))
                .collect(Collectors.toList());
    }

    @Override
    public void add(Student student){
        if(student.getFirstName() != null && student.getSurName() != null && student.getDept() != null){
            studentDao.add(student);
        }
    }

}
