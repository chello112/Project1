package com.sda.practice.springbootpractice.repositories;

import com.sda.practice.springbootpractice.models.City;
import com.sda.practice.springbootpractice.models.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {
    Optional<City> findCityByName(String name);
}
