package com.dailycodebuffer.spring.data.jpa.tutorial.repository;

import com.dailycodebuffer.spring.data.jpa.tutorial.entity.Course;
import com.dailycodebuffer.spring.data.jpa.tutorial.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TeacherRepositoryTest {


    @Autowired
    private TeacherRepository teacherRepository;

    @Test
    public void saveTeachers () {

        Course courseJava = Course.builder()
                .title("Java")
                .credits(3)
                .build();

        Course courseJS= Course.builder()
                .title("JS")
                .credits(3)
                .build();

        Course coursePhyton = Course.builder()
                .title("Phyton")
                .credits(3)
                .build();


        Teacher teacher = Teacher.builder()
                .firstName("Leila")
                .lastName("Keila")
                .courses(List.of(courseJava, courseJS, coursePhyton))
                .build();

        teacherRepository.save(teacher);

    }

    @Test
    public void printAllTeachers (){
        List<Teacher> teacherList = teacherRepository.findAll();
        System.out.println("teacherList = " + teacherList);

    }

}