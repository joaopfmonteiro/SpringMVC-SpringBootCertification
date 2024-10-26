package com.example.SpringMVC_SpringBootCertification;

import com.example.SpringMVC_SpringBootCertification.controller.StudentController;
import com.example.SpringMVC_SpringBootCertification.core.Student;
import com.example.SpringMVC_SpringBootCertification.service.StudentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.springframework.http.MediaType;


import static org.mockito.Mockito.when;

@WebMvcTest(StudentController.class)
public class StudentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private StudentService studentService;

    @Test
    void getStudentWhenExists() throws Exception {
        long studentId = 1L;
        Student student = new Student(studentId,"Eric", "Colbert", "English Literature", 145.00);
        when(studentService.getOne(studentId)).thenReturn(student);
        this.mockMvc.perform(get("/student/{studentId}",studentId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(studentId))
                .andExpect(jsonPath("$.firstName").value("Eric"))
                .andExpect(jsonPath("$.surName").value("Colbert"))
                .andExpect(jsonPath("$.dept").value("English Literature"))
                .andExpect(jsonPath("$.fess").value(145.00));

        verify(studentService, times(1)).getOne(studentId);
    }


}
