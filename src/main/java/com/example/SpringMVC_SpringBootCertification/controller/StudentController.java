package com.example.SpringMVC_SpringBootCertification.controller;

import com.example.SpringMVC_SpringBootCertification.core.Student;
import com.example.SpringMVC_SpringBootCertification.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.net.URI;
import java.util.Collection;
import java.util.Optional;

@RequestMapping("/student")
@RestController
public class StudentController {

    @Inject
    private StudentService studentService;

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable("id") long id){
        Student student = studentService.getOne(id);
        if(student != null){
            return ResponseEntity.ok(student);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping()
    public ResponseEntity<Collection<Student>> getAll(){
        Collection<Student> students = studentService.getAllStudents();
        if(students != null){
            return ResponseEntity.ok(students);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/search/{department}")
    public ResponseEntity<Collection<Student>> getStudentPerDepartment(@PathVariable("department") String department, @RequestParam("name") Optional<String> optional){
        Collection<Student> students = studentService.getStudentsInDepartment(department,optional.orElse(""));
        if(students != null){
            return ResponseEntity.ok(students);
        }else {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping
    public ResponseEntity<String> addStudent(@RequestBody Student student){
        studentService.add(student);
        if(student.getId() >0){
            URI uri = URI.create("/college/student" + student.getId());
            return ResponseEntity.accepted().location(uri).build();
        }else {
            return ResponseEntity.badRequest().build();
        }
    }
}
