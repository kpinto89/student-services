package com.demo.controller;

import com.demo.model.Student;
import com.demo.service.impl.StudentServiceImpl;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
public class StudentController {

    private final StudentServiceImpl studentService;

    public StudentController(StudentServiceImpl studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/students")
    public List<Student> retrieveStudents() {
        return studentService.retrieveStudents();
    }

    @GetMapping("/students/{id}")
    public Student retrieveStudent(@PathVariable long id) {
        return studentService.retrieveStudent(id);
    }

    @DeleteMapping("/students/{id}")
    public String deleteStudent(@PathVariable long id) {
        return studentService.deleteStudent(id);
    }

    @PostMapping("/students")
    public Student createStudent(@RequestBody Student student) {
        return studentService.createStudent(student);
    }

    @PutMapping("/students")
    public Student updateStudent(@RequestBody Student student) {
        return studentService.updateStudent(student);
    }
}
