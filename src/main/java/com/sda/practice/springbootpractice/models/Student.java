package com.sda.practice.springbootpractice.models;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String firstName;
    private String lastName;
    private int age;

    @OneToOne
    private City city;

    @Enumerated(EnumType.STRING)
    private School school;

    @Enumerated(EnumType.STRING)
    private Specialization specialization;

    @Enumerated(EnumType.STRING)
    private Course course;

    private LocalDate joinDate;
}
