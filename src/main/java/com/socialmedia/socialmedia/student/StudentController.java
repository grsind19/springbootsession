package com.socialmedia.socialmedia.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @RequestMapping(method = RequestMethod.POST, value = "/student")
    public void addStudent(@RequestBody Student student){
        studentService.addStudent(student);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/student" )
    public List<Student> getStudents(){
        return studentService.getStudents();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/student/{student_id}" )
    public Optional<Student> getStudent(@PathVariable("student_id") Integer student_id){
        return studentService.getStudent(student_id);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/student/{student_id}" )
    public Student updateStudent(@RequestBody Student student, @PathVariable("student_id") Integer student_id){
        return studentService.updateStudent(student, student_id);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/student/{student_id}")
    public void deleteStudent(@PathVariable("student_id") Integer student_id){
        studentService.deleteStudent(student_id);
    }





}

