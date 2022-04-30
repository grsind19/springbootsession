package com.socialmedia.socialmedia.Graduate;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class CourseDAOImpl implements CourseDAO {
    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public Course save(Course course) {
        entityManager.persist(course);
        return course;
    }

    @Override
    public Course findById(int id) {
        return entityManager.find(Course.class, id);
    }

    @Override
    public List<Course> find(){
        return  entityManager.createQuery("from Course").getResultList();
    }

    @Override
    public Course addStudent(AddGraduateDTO addGraduateDTO) {
        //get the course from the database
        Course course = entityManager.find(Course.class, addGraduateDTO.getCourseId());
        //create a graduate object
        Graduate graduate = new Graduate();
        // set the graduate id to graduate object
        graduate.setId(addGraduateDTO.getGraduateId());
        //get the course graduate list and add a graduate
        course.getGraduates().add(graduate);
        //save the updated course
        entityManager.persist(course);
        // return the course
        return course;
    }

    @Override
    public Review saveReview(Review review, int courseId) {
        Course course = entityManager.find(Course.class, courseId);
        course.getReviews().add(review);
        entityManager.persist(course);
        return review;
    }
}
