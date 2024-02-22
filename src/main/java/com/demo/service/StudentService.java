package com.demo.service;

import com.demo.model.Student;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface StudentService {

    List<Student> retrieveStudents();
    Student retrieveStudent(Long id);
    String deleteStudent(Long id);
    Student createStudent(Student student);
    Student updateStudent(Student student);
}
