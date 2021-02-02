package com.ktounsi.assessment.employee.repository;


import com.ktounsi.assessment.employee.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EmployeeRepository extends JpaRepository<Employee, Long> {




}
