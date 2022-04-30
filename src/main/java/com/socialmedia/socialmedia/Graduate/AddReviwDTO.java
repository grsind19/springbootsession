package com.socialmedia.socialmedia.Graduate;

import lombok.Data;

import javax.persistence.Entity;

@Data
public class AddReviwDTO {
    private int courseId;
    private int rating;
    private String comment;
}
