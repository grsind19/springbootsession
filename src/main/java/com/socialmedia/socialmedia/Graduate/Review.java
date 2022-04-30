package com.socialmedia.socialmedia.Graduate;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private int rating;

    private String comment;

    @ManyToOne(fetch = FetchType.EAGER)
    private Course course;

    public Review(int rating, String comment) {
        this.rating = rating;
        this.comment = comment;
    }
}
