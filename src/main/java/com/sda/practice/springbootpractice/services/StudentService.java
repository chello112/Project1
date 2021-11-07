package com.sda.practice.springbootpractice.services;

import com.sda.practice.springbootpractice.models.City;
import com.sda.practice.springbootpractice.models.Student;

import java.util.List;

public interface StudentService {

    List<Student> findAllStudents();

    List<Student> findAllStudentsByCity(City city);

    void createStudent(Student student);
}
