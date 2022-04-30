package com.socialmedia.socialmedia.Employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeDAOImp employeeDAOImp;

    public List<Employee> getEmployeeList(){
        return employeeDAOImp.findAll();
    }

    public void saveEmployee(Employee employee){
        employeeDAOImp.save(employee);
    }

    public Employee findById(int id){
        return employeeDAOImp.findById(id);
    }

    public void deleteById(int id){
        employeeDAOImp.deleteById(id);
    }
}
