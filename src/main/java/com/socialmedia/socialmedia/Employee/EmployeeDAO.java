package com.socialmedia.socialmedia.Employee;

import java.util.List;

public interface EmployeeDAO {
    public List findAll();
    public void save(Employee employee);
    public Employee findById(int id);
    public void deleteById(int id);
}
