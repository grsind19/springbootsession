package com.socialmedia.socialmedia.student;

import javax.persistence.*;
import java.io.Serializable;

@Entity

@Table(name="student")
public class Student implements Serializable {


    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;

    private String name;
    private String className;

    public Student(){}

    public Student(int id, String name, String className) {
        this.id = id;
        this.name = name;
        this.className = className;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }




}
