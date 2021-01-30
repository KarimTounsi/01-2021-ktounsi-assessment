package com.ktounsi.assessment.department.service;


import com.ktounsi.assessment.department.entity.Department;
import com.ktounsi.assessment.department.repository.DepartmentRepository;
import com.ktounsi.assessment.exceptions.ObjectNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@AllArgsConstructor
@Service
@Transactional
public class DepartmentServiceImpl implements DepartmentService {

    DepartmentRepository departmentRepository;


    @Override
    public Department getById(Long id) {
        Optional<Department> optionalDepartment = departmentRepository.findById(id);
        if (optionalDepartment.isEmpty()) throw new ObjectNotFoundException("not.found.address");
        return optionalDepartment.get();
    }

    @Override
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public Department update(Department department) {
        Department departmentDB = getById(department.getId());
        departmentDB.setName(department.getName());
        departmentDB.setLocation(department.getLocation());
        return departmentRepository.save(departmentDB);
    }

    @Override
    public void delete(Long id) {
        Department departmentDB = getById(id);
        departmentRepository.delete(departmentDB);
    }
}
