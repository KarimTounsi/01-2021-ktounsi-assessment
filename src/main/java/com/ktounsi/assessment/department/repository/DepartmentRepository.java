package com.ktounsi.assessment.department.repository;


import com.ktounsi.assessment.department.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;


public interface DepartmentRepository extends JpaRepository<Department, Long> {


}
