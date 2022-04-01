package com.multitenant.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.multitenant.model.Employee;

@Repository
@Transactional
public interface EmployeeRepository extends CrudRepository<Employee,Integer> {
    List<Employee> findAll();                           // fetch all Employee
}
