package com.ktounsi.assessment.employee.restController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ktounsi.assessment.address.service.AddressService;
import com.ktounsi.assessment.department.service.DepartmentService;
import com.ktounsi.assessment.employee.entity.Employee;
import com.ktounsi.assessment.employee.service.EmployeeService;
import com.ktounsi.assessment.exceptions.ObjectNotFoundException;
import com.ktounsi.assessment.position.service.PositionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/employee")
@RequiredArgsConstructor
public class EmployeeRestController {

    private final EmployeeService employeeService;
    private final AddressService addressService;
    private final PositionService positionService;
    private final DepartmentService departmentService;

    @PostMapping
    public ResponseEntity createOne(@RequestBody Employee employee, BindingResult errors) {
        if (errors.hasErrors()) {
            try {
                return ResponseEntity.badRequest().body(
                        new ObjectMapper().writeValueAsString
                                (errors.getAllErrors()
                                        .stream()
                                        .collect(Collectors.toMap(
                                                (ObjectError oE) -> oE.getCode(),
                                                oE -> oE.getDefaultMessage()))));
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        }
        positionService.savePosition(employee.getPosition());
        addressService.saveAddress(employee.getAddress());
        addressService.saveAddress(employee.getDepartment().getLocation());
        departmentService.saveDepartment(employee.getDepartment());
        Employee saved = employeeService.saveEmployee(employee);
        return ResponseEntity.created(URI.create("/api/employee/" + saved.getId()))
                .build();
    }


    @GetMapping
    public ResponseEntity<List<Employee>> getAll() {

        List<Employee> employeeList = employeeService.getAll();

        return ResponseEntity.ok(employeeList);
    }



    @GetMapping("/{id}")
    public ResponseEntity getOne(@PathVariable Long id){

        try {
            Employee employee = employeeService.getById(id);
            if (employee != null) {
                return ResponseEntity.ok(employee);
            }
        }catch (ObjectNotFoundException o){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.notFound().build();

    }


    @DeleteMapping("/{id}")
    public ResponseEntity deleteOne(@PathVariable Long id) {


        if (employeeService.getById(id) != null) {
            employeeService.delete(id);
            return ResponseEntity.ok(id);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity updateOne(@PathVariable Long id,@RequestBody Employee employee) {

        if (employeeService.getById(id) != null) {
            Employee employeeUpdated = employeeService.update(id, employee);
            return ResponseEntity.ok(employeeUpdated);
        } else {
            return ResponseEntity.notFound().build();
        }

    }





}
