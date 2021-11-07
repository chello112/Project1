package com.sda.practice.springbootpractice.services;

import com.sda.practice.springbootpractice.models.City;
import com.sda.practice.springbootpractice.models.Teacher;

import java.util.List;

public interface TeacherService {

    List<Teacher> findAllTeachers();

    List<Teacher> findAllTeachersByCity(City city);

    void createTeacher(Teacher teacher);
}
