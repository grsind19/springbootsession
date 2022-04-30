package com.socialmedia.socialmedia.Graduate;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Passport {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String passportNo;

    @OneToOne
    @JsonBackReference
    private Graduate graduate;
}
