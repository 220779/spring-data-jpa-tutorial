package com.dailycodebuffer.spring.data.jpa.tutorial.repository;


import com.dailycodebuffer.spring.data.jpa.tutorial.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository < Student, Long>{

    List<Student> findByFirstName (String firstName);

    List<Student> findByFirstNameContaining (String name);

    List<Student> findByLastNameNotNull ();

    List<Student> findByGuardianName (String alibaba);

    Student findByFirstNameAndLastName(String firstName, String lastname);

    //JPQL
    @Query("select s from Student s where s.emailId = ?1")
    Student getStudentByEmailAddress  (String emailId);


    //JPQL
    @Query("select s.firstName from Student s where s.emailId = ?1")
    //String, because we want one value
    String getStudentFirstNameByEmailAddress  (String firstName);


    //Native
    @Query (
            value = "select * from tbl_student s where s.email_address = ?1",
            nativeQuery = true
    )
    Student getStudentByEmailAddressNative (String emailId);
}
