package com.ktounsi.assessment.department.service;

import com.ktounsi.assessment.department.entity.Department;

public interface DepartmentService {

    Department getById(Long id);

    Department saveDepartment(Department department);

    Department update(Department department);

   void delete(Long id);

}
