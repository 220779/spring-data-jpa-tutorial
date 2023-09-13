package com.dailycodebuffer.spring.data.jpa.tutorial.repository;

import com.dailycodebuffer.spring.data.jpa.tutorial.entity.Guardian;
import com.dailycodebuffer.spring.data.jpa.tutorial.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest ;

import java.security.Guard;
import java.util.List;


@SpringBootTest
class StudentRepositoryTest  {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudent(){
        Student student = Student.builder()
                .emailId("aloha@gmail.com")
                .firstName("Krakov")
                .lastName("Hellmans")
                //.guardianName("AliBaba")
                //.guardianEmail("alibaba@gmail.com")
               // .guardianMobile("777-331")
                .build();

        studentRepository.save(student);

    }

    @Test
    public void printAllStudent () {
        List<Student> studentList =  studentRepository.findAll();

        System.out.println("studentList = " + studentList);
    }

    @Test
    public void saveStudentWithGuardian() {

        Guardian guardian = Guardian.builder()
                .email("alibaba@gmail.com")
                .mobile("777-331")
                .name("AliBaba")
                .build();

        Student student = Student.builder()
                .firstName("Georg")
                .lastName("Klooni")
                .emailId("geoklo@gmail.com")
                .guardian(guardian)
                .build();

        studentRepository.save(student);
    }

}