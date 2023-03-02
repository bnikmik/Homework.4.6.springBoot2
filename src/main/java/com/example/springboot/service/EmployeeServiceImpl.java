package com.example.springboot.service;

import com.example.springboot.exceptions.EmpException;
import com.example.springboot.model.Employee;
import com.example.springboot.repository.EmployeeRep;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRep employeeRep;

    public EmployeeServiceImpl(EmployeeRep employeeRep) {
        this.employeeRep = employeeRep;
    }

    @Override
    @Transactional
    public void add(Employee employee) {
        employee.setId(null);
        employeeRep.save(employee);
    }

    @Override
    @Transactional
    public Employee getEmployeeById(int id) {
        return employeeRep.findById(id).orElseThrow(() -> new EmpException("Employee with id = " + id + " doesn't exist"));
    }

    @Override
    @Transactional
    public List<Employee> getEmployees() {
        return employeeRep.findAll();
    }

    @Override
    @Transactional
    public void updateEmployee(Employee employee) {
        employeeRep.save(employee);
    }

    @Override
    @Transactional
    public void deleteEmployeeById(int id) {
        employeeRep.findById(id).orElseThrow(() -> new EmpException("Employee with id = " + id + " doesn't exist"));
        employeeRep.deleteById(id);
    }

    @Override
    public List<Employee> getEmployeesByName(String name) {
        return employeeRep.getEmployeesByName(name);
    }
}
