package com.demo;

import com.demo.controller.StudentController;
import com.demo.service.StudentService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class StudentApplicationTests {

    @Autowired
    private StudentController studentController;

    @Autowired
    private StudentService studentService;

    @Test
    void contextLoads() {
        assertThat(studentController).isNotNull();
        assertThat(studentService).isNotNull();
    }

}