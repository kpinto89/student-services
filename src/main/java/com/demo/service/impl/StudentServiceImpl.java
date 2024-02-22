package com.demo.service.impl;

import java.util.List;
import java.util.Optional;

import com.demo.exception.StudentNotFoundException;
import com.demo.model.Student;
import com.demo.repository.StudentRepository;
import com.demo.service.StudentService;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> retrieveStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student retrieveStudent(Long id) {
        Optional<Student> student = studentRepository.findById(id);
        if (student.isEmpty())
            throw new StudentNotFoundException("id-" + id);
        return student.get();
    }

    @Override
    public String deleteStudent(Long id) {
        studentRepository.deleteById(id);
        return "Student Id "+ id + " has been removed";
    }

    @Override
    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student updateStudent(Student student) {
        Optional<Student> updatedStudent = studentRepository.findById(student.getId());
        if (updatedStudent.isEmpty())
            throw new StudentNotFoundException("id-" + student.getId());
        return studentRepository.save(student);
    }
}