package com.socialmedia.socialmedia.Graduate;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String courseName;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<Graduate> graduates = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL)
    private List<Review> reviews = new ArrayList<>();


}
