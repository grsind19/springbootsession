package com.socialmedia.socialmedia.Employee;

import com.socialmedia.socialmedia.post.Post;
import com.socialmedia.socialmedia.post.PostDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping("/employee")
    public void saveEmployee(@RequestBody EmployeeDTO employeeDTO){
        Employee employee = modelMapper.map(employeeDTO, Employee.class);
        employeeService.saveEmployee(employee);
    }

    @GetMapping("/employee/{employee_id}")
    public EmployeeDTO getEmployeeById(@PathVariable("employee_id") int id){
        Employee employee = employeeService.findById(id);
        return modelMapper.map(employee, EmployeeDTO.class);
    }

    @GetMapping("/employee")
    public List<EmployeeDTO> getEmployees(){
        List<Employee> employees = employeeService.getEmployeeList();
        return employees.stream()
                .map(this::covertEntityToDto)
                .collect(Collectors.toList());
    }

    @DeleteMapping("/employee/{employee_id}")
    public void deleteById(@PathVariable("employee_id") int id){
        employeeService.deleteById(id);
    }

    private EmployeeDTO covertEntityToDto(Employee employee){
        EmployeeDTO employeeDTO = modelMapper.map(employee, EmployeeDTO.class);
        return employeeDTO;
    }


}
