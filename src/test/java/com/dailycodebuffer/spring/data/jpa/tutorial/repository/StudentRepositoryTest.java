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

    @Test
    public void printStudentByFirstName () {
        List<Student> students = studentRepository.findByFirstName("Krakov");

        System.out.println("students = " + students);
    }

    @Test
    public void findByFirstNameContaining () {
        List<Student> studentList = studentRepository.findByFirstNameContaining("r");

        System.out.println("studentList = " + studentList);

    }

    @Test
    public void findByLastNameNotNull (){

        List<Student> list = studentRepository.findByLastNameNotNull();
    }

    @Test
    public void printStudentBasedOnGuardianName () {

        List<Student> students = studentRepository.findByGuardianName("Alibaba");

        System.out.println("Students = " + students);
    }

    @Test
    public void printGetStudentByEmailAddress(){

        Student student = studentRepository.getStudentByEmailAddress("aloha@gmail.com");

        System.out.println("student = " + student);

    }

    @Test
    public void printGetStudentFirstNameByEmailAddress () {
        String student = studentRepository.getStudentFirstNameByEmailAddress("aloha@gmail.com");
        System.out.println("student = " + student);
    }



    @Test
    public void printGetStudentByEmailAddressNative () {
        Student student = studentRepository.getStudentByEmailAddressNative ("geoklo@gmail.com");

        System.out.println("student = " + student);
    }

    @Test
    public void printGetStudentByEmailAddressNativeNamedParam () {
        Student student = studentRepository.getStudentByEmailAddressNativeNamedParam("geoklo@gmail.com");

        System.out.println("student = " + student);
     }
}