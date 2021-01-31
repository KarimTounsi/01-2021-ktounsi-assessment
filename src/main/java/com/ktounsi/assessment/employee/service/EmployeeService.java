package com.ktounsi.assessment.employee.service;

import com.ktounsi.assessment.employee.entity.Employee;

import java.util.List;

public interface EmployeeService {

    Employee getById(Long id);

    Employee saveEmployee(Employee employee);

    Employee update(Long id ,Employee employee);

   void delete(Long id);

   List <Employee> getAll();

}
