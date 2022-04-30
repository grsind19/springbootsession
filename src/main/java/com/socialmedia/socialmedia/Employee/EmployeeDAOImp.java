package com.socialmedia.socialmedia.Employee;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class EmployeeDAOImp implements EmployeeDAO {

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Employee> findAll() {
        //create query
        Query query = entityManager.createQuery("from Employee", Employee.class);
        //get the query result
        List<Employee> employees = query.getResultList();
        //return the queryy
        return employees;
    }

    @Override
    public void save(Employee employee) {
        //create a hibernate session
        entityManager.persist(employee);
    }

    @Override
    public Employee findById(int id) {
        //create a hibernate session
        Employee employee = entityManager.find(Employee.class, id);
        return employee;
    }

    @Override
    public void deleteById(int id) {
        Query query = entityManager.createQuery("delete from Employee where id=:employee_id");
        query.setParameter("employee_id", id);
        query.executeUpdate();
    }
}
