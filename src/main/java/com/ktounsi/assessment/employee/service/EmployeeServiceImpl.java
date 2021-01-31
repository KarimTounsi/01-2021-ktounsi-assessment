package com.ktounsi.assessment.employee.service;

import com.ktounsi.assessment.address.entity.Address;
import com.ktounsi.assessment.address.service.AddressService;
import com.ktounsi.assessment.department.entity.Department;
import com.ktounsi.assessment.department.service.DepartmentService;
import com.ktounsi.assessment.employee.entity.Employee;
import com.ktounsi.assessment.employee.repository.EmployeeRepository;
import com.ktounsi.assessment.exceptions.ObjectNotFoundException;
import com.ktounsi.assessment.position.entity.Position;
import com.ktounsi.assessment.position.service.PositionService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

    private final  EmployeeRepository employeeRepository;
    private final AddressService addressService;
    private final PositionService positionService;
    private final DepartmentService departmentService;

    @Override
    public Employee getById(Long id) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
        if (optionalEmployee.isEmpty()) throw new ObjectNotFoundException("not.found.employee");
        return optionalEmployee.get();
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee update(Long id, Employee employee) {
        Employee EmployeeDB = getById(id);
        EmployeeDB.setFirstName(employee.getFirstName());
        EmployeeDB.setLastName(employee.getLastName());

        Address address = addressService.getById(EmployeeDB.getAddress().getId());
        address.setStreet(employee.getAddress().getStreet());
        address.setHomeNumber(employee.getAddress().getHomeNumber());
        address.setPostCode(employee.getAddress().getPostCode());
        address.setCity(employee.getAddress().getCity());
       Address addressUpdated = addressService.saveAddress(address);

        EmployeeDB.setAddress(addressUpdated);
        EmployeeDB.setEmail(employee.getEmail());
        EmployeeDB.setPhoneNumber(employee.getPhoneNumber());
        EmployeeDB.setDateOfEmployment(employee.getDateOfEmployment());
        EmployeeDB.setSalary(employee.getSalary());

        Department department = departmentService.getById(EmployeeDB.getDepartment().getId());

      department.setName(employee.getDepartment().getName());

      Address addressLocation = addressService.getById(EmployeeDB.getDepartment().getLocation().getId());

        addressLocation.setStreet(employee.getDepartment().getLocation().getStreet());
        addressLocation.setHomeNumber(employee.getDepartment().getLocation().getHomeNumber());
        addressLocation.setPostCode(employee.getDepartment().getLocation().getPostCode());
        addressLocation.setCity(employee.getDepartment().getLocation().getPostCode());
       Address addressLocationUpdated = addressService.saveAddress(addressLocation);

      department.setLocation(addressLocationUpdated);

    Department departmentUpdated = departmentService.saveDepartment(department);

        EmployeeDB.setDepartment(departmentUpdated);

       Position position = positionService.getById(EmployeeDB.getPosition().getId());
       position.setName(employee.getPosition().getName());
      Position positionUpdated = positionService.savePosition(position);
        EmployeeDB.setPosition(positionUpdated);

        return employeeRepository.save(EmployeeDB);
    }

    @Override
    public void delete(Long id) {
        Employee EmployeeDB = getById(id);
        employeeRepository.delete(EmployeeDB);
    }

    @Override
    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }
}
