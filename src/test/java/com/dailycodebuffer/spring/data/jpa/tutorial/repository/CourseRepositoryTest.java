package com.dailycodebuffer.spring.data.jpa.tutorial.repository;

import com.dailycodebuffer.spring.data.jpa.tutorial.entity.Course;
import com.dailycodebuffer.spring.data.jpa.tutorial.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import javax.print.attribute.standard.PageRanges;
import java.awt.*;
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


    //Paging
    @Test
    public void findAllPagination () {

        Pageable firstPageWithThreeRecords =
                PageRequest.of(0,3);

        Pageable  secondPageWithTwoRecords =
                PageRequest.of(1,2);

        List<Course> courses =
                courseRepository.findAll(secondPageWithTwoRecords).getContent();

        long getTotalElements =
                courseRepository.findAll(secondPageWithTwoRecords).getTotalElements();

        long getTotalPages = courseRepository.findAll(secondPageWithTwoRecords).getTotalPages();

        System.out.println("getTotalpages = " + getTotalPages);

        System.out.println("getTotalElements = " + getTotalElements);

        System.out.println("courses = " + courses);
    }

    //Paging with sorting

    @Test
    public void findAllSorting () {     //sort the data based on title
        Pageable sortByTitle = PageRequest.of(0,2,Sort.by("title"));

        Pageable sortByCreditDesc = PageRequest.of(0,2, Sort.by("credit").descending());

        Pageable sortByTitleAndCreditDesc = PageRequest.of(0,2, Sort.by("title")
                .and(Sort.by("credit")));

        List<Course> courses = courseRepository.findAll(sortByTitle).getContent();

        System.out.println("courses = " + courses);

    }


    @Test
    public void printFindByTitleContaining(){
        Pageable firstPageTenRecords = PageRequest.of(0,10);

        List<Course> courses =
                courseRepository.findByTitleContaining("J", firstPageTenRecords).getContent();
        System.out.println("courses = " + courses);
    }
    }