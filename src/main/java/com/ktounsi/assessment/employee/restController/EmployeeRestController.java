package com.ktounsi.assessment.employee.restController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ktounsi.assessment.address.service.AddressService;
import com.ktounsi.assessment.department.service.DepartmentService;
import com.ktounsi.assessment.employee.entity.Employee;
import com.ktounsi.assessment.employee.service.EmployeeService;
import com.ktounsi.assessment.position.service.PositionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/employee")
@RequiredArgsConstructor
@Slf4j
public class EmployeeRestController {

    private final EmployeeService employeeService;
    private final AddressService addressService;
    private final PositionService positionService;
    private final DepartmentService departmentService;




    @PostMapping
    public ResponseEntity createOne(@RequestBody
                                            Employee employee, BindingResult errors) {
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





}
