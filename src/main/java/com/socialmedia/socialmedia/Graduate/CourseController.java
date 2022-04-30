package com.socialmedia.socialmedia.Graduate;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseController {

    @Autowired
    private CourseDAOImpl courseDAO;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping("/course")
    public CourseDTO createCourse(@RequestBody CourseDTO courseDtO){
        Course course = modelMapper.map(courseDtO, Course.class);
        course = courseDAO.save(course);
        return modelMapper.map(course, CourseDTO.class);
    }

    @GetMapping("/course/{courseId}")
    public Course createCourse(@PathVariable("courseId") int courseId){
        return courseDAO.findById(courseId);
    }

    @GetMapping("/course")
    public List<Course> findAll(){
        return courseDAO.find();
    }

    @PostMapping("/course/add/graduate")
    public Course addGraduate(@RequestBody AddGraduateDTO addGraduateDTO){
        return courseDAO.addStudent(addGraduateDTO);
    }

    @PostMapping("/course/add/review")
    public Review addGraduate(@RequestBody AddReviwDTO addReviwDTO){
        Review review = new Review(addReviwDTO.getRating(), addReviwDTO.getComment());
        return courseDAO.saveReview(review, addReviwDTO.getCourseId());
    }
}
