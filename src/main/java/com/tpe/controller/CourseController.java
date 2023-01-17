package com.tpe.controller;


import com.tpe.domain.Course;
import com.tpe.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping("/form")
    public String showCoursesForm(@ModelAttribute("course") Course course) {
        return "courseForm";

    }

    @PostMapping("/saveCourse")
    public String createCourse(@Valid @ModelAttribute Course course){
        courseService.saveCourse(course);
        return "redirect:/courses";
    }

    @GetMapping
    public ModelAndView getCourses(){
        List<Course>  courseList=courseService.getAllCourse();
        ModelAndView mav=new ModelAndView();
        mav.addObject("courses",courseList);
        mav.setViewName("courses");
        return mav;
    }


    @GetMapping("/update")
    public String showUpdateForm(@RequestParam("id") Long id, Model model){
        Course course=courseService.findCourseById(id);
        model.addAttribute("course",course);
        return "courseForm";
    }


    @GetMapping("/delete/{id}")
    public String deleteCourse(@PathVariable("id") Long id){
        courseService.deleteCourse(id);
        return "redirect:/courses";
    }









}
