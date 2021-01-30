package com.ktounsi.assessment.employee.service;

import com.ktounsi.assessment.employee.entity.Employee;

public interface EmployeeService {

    Employee getById(Long id);

    Employee saveEmployee(Employee employee);

    Employee update(Employee employee);

   void delete(Long id);

}
