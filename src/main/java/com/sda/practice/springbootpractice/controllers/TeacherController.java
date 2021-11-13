package com.sda.practice.springbootpractice.controllers;

import com.sda.practice.springbootpractice.models.City;
import com.sda.practice.springbootpractice.models.School;
import com.sda.practice.springbootpractice.models.Specialization;
import com.sda.practice.springbootpractice.models.Teacher;
import com.sda.practice.springbootpractice.services.CityService;
import com.sda.practice.springbootpractice.services.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/teacher")
public class TeacherController {
    @Autowired
    private TeacherService teacherService;

    @Autowired
    private CityService cityService;

    @GetMapping("")

    public String showAllTeachers(Model model, @ModelAttribute("messageType") String messageType,
                                  @ModelAttribute("message") String message) {
        List<Teacher> teachers = teacherService.findAllTeachers();
        model.addAttribute("teachers", teachers);
        return "teacher/list-teachers";

    }

    @GetMapping("/add")
    public String addTeacherForm(@ModelAttribute("teacher") Teacher teacher, Model model) {
        List<City> cities = cityService.findAllCities();
        model.addAttribute("cities", cities);
        model.addAttribute("school", School.values());
        model.addAttribute("specialization", Specialization.values());
        return "teacher/add-teacher";
    }

    @PostMapping("/add")
    public String addTeacher(Teacher teacher, RedirectAttributes redirectAttributes) {
        try {
            teacherService.createTeacher(teacher);
            redirectAttributes.addFlashAttribute("messageType", "success");
            redirectAttributes.addFlashAttribute("message", "A teacher has been created successfully");
            return "redirect:/teacher";
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
            redirectAttributes.addFlashAttribute("teacher", teacher);
            redirectAttributes.addFlashAttribute("messageType", "error");
            redirectAttributes.addFlashAttribute("message", "Error in adding a teacher");
            return "redirect:/teacher/add";
        }
    }

    @GetMapping("/update/{id}")
    public String updateTeacherForm(@PathVariable("id") Long id, @RequestParam(value = "teacher", required = false) Teacher teacher,
                                    @ModelAttribute("messageType") String messageType,
                                    @ModelAttribute("message") String message, Model model, RedirectAttributes redirectAttributes) {

        if (teacher == null) {
            Optional<Teacher> teacherOptional = teacherService.findTeacherById(id);
            if (teacherOptional.isPresent()) {
                model.addAttribute("teacher", teacherOptional.get());

            } else {
                redirectAttributes.addFlashAttribute("messageType", "error");
                redirectAttributes.addFlashAttribute("message", "The teacher (id=" + id + ") is not found");
                return "redirect:/teacher";
            }
        }

        List<City> cities = cityService.findAllCities();
        model.addAttribute("cities", cities);
        model.addAttribute("school", School.values());
        model.addAttribute("specialization", Specialization.values());
        return "teacher/update-teacher";
    }

    @PostMapping("/update/{id}")
    public String updateTeacher(@PathVariable Teacher teacher, RedirectAttributes redirectAttributes) {
        try {
            teacherService.updateTeacher(teacher);
            redirectAttributes.addFlashAttribute("messageType", "success");
            redirectAttributes.addFlashAttribute("message", "A teacher has been created successfully");
            return "redirect:/teacher";
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
            redirectAttributes.addFlashAttribute("teacher", teacher);
            redirectAttributes.addFlashAttribute("messageType", "error");
            redirectAttributes.addFlashAttribute("message", "Error in updating a teacher");
            return "redirect:/teacher/update";
        }
    }
}



