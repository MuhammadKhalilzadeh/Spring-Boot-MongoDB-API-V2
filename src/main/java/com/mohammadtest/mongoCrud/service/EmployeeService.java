package com.mohammadtest.mongoCrud.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.mohammadtest.mongoCrud.model.Employee;
import com.mohammadtest.mongoCrud.repository.EmployeeRepository;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee saveOrUpdate(Employee emp) {
        return employeeRepository.save(emp);
    }

    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    public Optional<Employee> findById(String id) {
        return employeeRepository.findById(id);
    }

    public void delete(Employee emp) {
        employeeRepository.delete(emp);
    }

    public void deleteAll() {
        employeeRepository.deleteAll();
    }

    @DeleteMapping("/employees/{id}")
    public void deleteById(@PathVariable("id") String id) {
        employeeRepository.deleteById(id);
    }
}
