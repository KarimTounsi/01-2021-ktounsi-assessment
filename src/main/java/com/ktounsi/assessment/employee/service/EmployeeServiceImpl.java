package com.ktounsi.assessment.employee.service;

import com.ktounsi.assessment.employee.entity.Employee;
import com.ktounsi.assessment.employee.repository.EmployeeRepository;
import com.ktounsi.assessment.exceptions.ObjectNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@AllArgsConstructor
@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

    EmployeeRepository employeeRepository;


    @Override
    public Employee getById(Long id) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
        if (optionalEmployee.isEmpty()) throw new ObjectNotFoundException("not.found.address");
        return optionalEmployee.get();
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee update(Employee employee) {
        Employee EmployeeDB = getById(employee.getId());
        EmployeeDB.setFirstName(employee.getFirstName());
        EmployeeDB.setLastName(employee.getLastName());
        EmployeeDB.setAddress(employee.getAddress());
        EmployeeDB.setEmail(employee.getEmail());
        EmployeeDB.setPhoneNumber(employee.getPhoneNumber());
        EmployeeDB.setDateOfEmployment(employee.getDateOfEmployment());
        EmployeeDB.setSalary(employee.getSalary());
        EmployeeDB.setDepartment(employee.getDepartment());
        EmployeeDB.setPosition(employee.getPosition());
        return employeeRepository.save(EmployeeDB);
    }

    @Override
    public void delete(Long id) {
        Employee EmployeeDB = getById(id);
        employeeRepository.delete(EmployeeDB);
    }
}
