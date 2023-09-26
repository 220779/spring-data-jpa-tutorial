package com.dailycodebuffer.spring.data.jpa.tutorial.repository;

import com.dailycodebuffer.spring.data.jpa.tutorial.entity.Course;
import com.dailycodebuffer.spring.data.jpa.tutorial.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;


@SpringBootTest
class TeacherRepositoryTest {


    @Autowired
    private TeacherRepository teacherRepository;

    @Test
    public void saveTeacher () {

        Course courseJava = Course.builder()
                .title("Java")
                .credits(6)
                .build();

        Course courseJS = Course.builder()
                .title("JavaScript")
                .credits(6)
                .build();

        Course coursePython = Course.builder()
                .title("Python")
                .credits(6)
                .build();

        Teacher teacher = Teacher.builder()
                .firstName("Mata")
                .lastName("Teacher")
                .courses(List.of(courseJava, courseJS, coursePython))
                .build();

        teacherRepository.save(teacher);
    }

}