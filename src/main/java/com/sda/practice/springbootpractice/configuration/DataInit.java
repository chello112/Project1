package com.sda.practice.springbootpractice.configuration;

import com.sda.practice.springbootpractice.models.*;
import com.sda.practice.springbootpractice.services.CityService;
import com.sda.practice.springbootpractice.services.StudentService;
import com.sda.practice.springbootpractice.services.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.LocalDate;

@Component
public class DataInit {
    @Autowired
    private TeacherService teacherService;

    @Autowired
    private CityService cityService;

    @Autowired
    private StudentService studentService;

    @PostConstruct
    private void init() {
        initCity();
        initTeacher();
        initStudent();
    }

    public void initCity() {
        if (cityService.findAllCities().isEmpty()) {
            City city = new City();
            city.setName("Tallinn");
            cityService.createCity(city);

            City city1 = new City();
            city1.setName("Tartu");
            cityService.createCity(city1);
        }
    }

    private void initTeacher() {
        if (teacherService.findAllTeachers().isEmpty()) {
            Teacher teacher = new Teacher();
            teacher.setFirstName("Vinod");
            teacher.setLastName("John");
            teacher.setAge(20);
            teacher.setSchool(School.TALLINN_UNIVERSITY);
            teacher.setSpecialization(Specialization.SOFTWARE);
            cityService.findCityByName("Tallinn").ifPresent(teacher::setCity);
            teacher.setJoinDate(LocalDate.of(2021, 10, 30));
            teacherService.createTeacher(teacher);
        }
    }
    private void initStudent() {
        if (studentService.findAllStudents().isEmpty()) {
            Student student = new Student();
            student.setFirstName("Egert");
            student.setLastName("Kriisa");
            student.setAge(29);
            student.setCourse(Course.SDA_ACADEMY);
            student.setSpecialization(Specialization.SOFTWARE);
            cityService.findCityByName("Tallinn").ifPresent(student::setCity);
            student.setJoinDate(LocalDate.of(2021, 3, 16));
            studentService.createStudent(student);
        }
    }
}
