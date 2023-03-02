package com.example.springboot.repository;
import com.example.springboot.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRep extends JpaRepository<Employee, Integer> {
    List<Employee> getEmployeesByName(String name);
}
