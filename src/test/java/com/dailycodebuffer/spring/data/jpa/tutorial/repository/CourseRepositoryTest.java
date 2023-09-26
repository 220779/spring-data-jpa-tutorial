package com.dailycodebuffer.spring.data.jpa.tutorial.repository;

import com.dailycodebuffer.spring.data.jpa.tutorial.entity.Course;
import com.dailycodebuffer.spring.data.jpa.tutorial.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class    CourseRepositoryTest {

    @Autowired
    private CourseRepository courseRepository;


    @Test
    public void printCourses () {
        List<Course> courses = courseRepository.findAll();
        System.out.println("courses = " + courses);
    }


    @Test
    public void saveCourseWithTeacher () {

        Teacher teacher = Teacher.builder()
                .firstName("Paula")
                .lastName("Abdul")
                .build();

        Course course = Course.builder()
                .teacher(teacher)
                .title("Advanced Java")
                .credits(4)
                .build();

        courseRepository.save(course);
    }


}