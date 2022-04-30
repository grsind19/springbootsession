package com.socialmedia.socialmedia.Employee;

import lombok.Data;

@Data
public class EmployeeDTO {
    private Integer id;
    private String first_name;
    private String last_name;
    private String designation;
    private String email;
    private String mobile;
}
