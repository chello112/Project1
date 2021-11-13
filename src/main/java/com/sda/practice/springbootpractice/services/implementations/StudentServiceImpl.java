package com.sda.practice.springbootpractice.services.implementations;

import com.sda.practice.springbootpractice.models.City;
import com.sda.practice.springbootpractice.models.Student;
import com.sda.practice.springbootpractice.repositories.StudentRepository;
import com.sda.practice.springbootpractice.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<Student> findAllStudents() { return studentRepository.findAll(); }

    @Override
    public List<Student> findAllStudentsByCity(City city) {
        return null;
    }

    @Override
    public void createStudent(Student student) {
        studentRepository.save(student);
    }
}
