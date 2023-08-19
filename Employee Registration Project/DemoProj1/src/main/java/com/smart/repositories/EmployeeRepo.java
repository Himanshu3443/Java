package com.smart.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smart.entities.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Integer>{

}
