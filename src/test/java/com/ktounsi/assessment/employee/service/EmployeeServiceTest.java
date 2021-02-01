package com.ktounsi.assessment.employee.service;

import com.ktounsi.assessment.address.entity.Address;
import com.ktounsi.assessment.address.service.AddressService;
import com.ktounsi.assessment.department.entity.Department;
import com.ktounsi.assessment.department.service.DepartmentService;
import com.ktounsi.assessment.employee.entity.Employee;
import com.ktounsi.assessment.employee.repository.EmployeeRepository;
import com.ktounsi.assessment.position.entity.Position;
import com.ktounsi.assessment.position.service.PositionService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;

import java.time.LocalDate;


@DisplayName("employee Service Specification")
class EmployeeServiceTest {


    private EmployeeService employeeService;


    private EmployeeRepository employeeRepository;
    private AddressService addressService;
    private PositionService positionService;
    private DepartmentService departmentService;


    @BeforeEach
    void setUp() {
        employeeRepository = Mockito.mock(EmployeeRepository.class);
        addressService = Mockito.mock(AddressService.class);
        positionService = Mockito.mock(PositionService.class);
        departmentService = Mockito.mock(DepartmentService.class);
        employeeService = new EmployeeServiceImpl(employeeRepository, addressService, positionService,departmentService);
    }



    @DisplayName("Saving employee")
    @Nested
    class SavingEmployee {

        Employee employee;

        @BeforeEach
        void setUp() {

            employee = Employee.builder()
                    .firstName("Imię")
                    .lastName("Nazwisko")
                    .address(new Address(1l, "Ulica", "21", "11-192", "Miasto"))
                    .email("email")
                    .phoneNumber(Integer.parseInt("124554632"))
                    .dateOfEmployment(LocalDate.of(2019, 10, 30))
                    .salary(Integer.parseInt("6500"))
                    .department(new Department(1L, "Dział", new Address(2L, "Ulica", "32", "12-145", "Miasto")))
                    .position(new Position(1L, "Programista"))
                    .build();

        }


            @DisplayName(" - should save any employee")
            @Test
            public void test1() {
                Mockito.when(employeeRepository.save(ArgumentMatchers.notNull())).thenReturn(null);
                employeeService.saveEmployee(employee);
                Mockito.verify(employeeRepository, Mockito.atLeastOnce()).save(ArgumentMatchers.notNull());
            }




        @DisplayName(" - should save employee with all provided data")
        @Test
        public void test2() {
            ArgumentCaptor<Employee> employeeCaptor = ArgumentCaptor.forClass(Employee.class);
            Mockito.when(employeeRepository.save(employeeCaptor.capture())).thenAnswer(invocation -> {
                Employee argument = invocation.getArgument(0, Employee.class); // argument, który otrzymała metoda save
                argument.setId(999L);
                return argument;
            });
            employeeService.saveEmployee(employee);

            Employee savedEmployee = employeeCaptor.getValue();
            Assertions.assertThat(savedEmployee).isNotNull()
                    .hasFieldOrPropertyWithValue("email", employee.getEmail());
        }



        }



    }

