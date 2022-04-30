package com.socialmedia.socialmedia.Graduate;

import java.util.List;

public interface CourseDAO {
    public Course save(Course course);
    public Course findById(int id);
    public List<Course> find();
    Course addStudent(AddGraduateDTO addGraduateDTO);

    Review saveReview(Review review, int courseId);
}
