package com.sda.practice.springbootpractice.repositories;

import com.sda.practice.springbootpractice.models.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {
}
