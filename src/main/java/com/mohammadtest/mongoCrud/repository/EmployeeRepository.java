package com.mohammadtest.mongoCrud.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.mohammadtest.mongoCrud.model.Employee;

public interface EmployeeRepository extends MongoRepository<Employee, String> {

}
