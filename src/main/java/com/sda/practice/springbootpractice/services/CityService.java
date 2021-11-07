package com.sda.practice.springbootpractice.services;

import com.sda.practice.springbootpractice.models.City;
import com.sda.practice.springbootpractice.models.Teacher;

import java.util.List;
import java.util.Optional;

public interface CityService {

    List<City> findAllCities();

    void createCity(City city);

    Optional<City> findCityByName(String name);
}
