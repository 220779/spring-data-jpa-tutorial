package com.dailycodebuffer.spring.data.jpa.tutorial.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Course {

    @Id
    private Long courseId;
    private Long title;
    private Integer credits;
}
