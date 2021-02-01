package com.ktounsi.assessment.employee.restController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ktounsi.assessment.address.entity.Address;
import com.ktounsi.assessment.address.service.AddressService;
import com.ktounsi.assessment.department.entity.Department;
import com.ktounsi.assessment.department.service.DepartmentService;
import com.ktounsi.assessment.employee.entity.Employee;
import com.ktounsi.assessment.employee.service.EmployeeService;
import com.ktounsi.assessment.exceptions.ObjectNotFoundException;
import com.ktounsi.assessment.position.entity.Position;
import com.ktounsi.assessment.position.service.PositionService;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@WebMvcTest(controllers = EmployeeRestController.class)
@AutoConfigureMockMvc(addFilters = false)
class EmployeeRestControllerTest {


    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;
    @MockBean
    private EmployeeService employeeService;
    @MockBean
    private AddressService addressService;
    @MockBean
    private PositionService positionService;
    @MockBean
    private DepartmentService departmentService;

    private List<Employee> employeeList;
    private Employee employee;
    private Employee employee2;
    private Employee employee3;
    private long employeeId;

    @BeforeEach
    void init() {
        employeeId = 1;

        employee = Employee.builder()
                .id(1L)
                .firstName("Imię")
                .lastName("Nazwisko")
                .address(new Address(1L, "Ulica", "21", "11-192", "Miasto"))
                .email("email")
                .phoneNumber(Integer.parseInt("124554632"))
                .dateOfEmployment(LocalDate.of(2019, 10, 30))
                .salary(Integer.parseInt("6500"))
                .department(new Department(1L, "Dział", new Address(2L, "Ulica", "32", "12-145", "Miasto")))
                .position(new Position(1L, "Programista"))
                .build();

        employee2 = Employee.builder()
                .id(2L)
                .firstName("Imię2")
                .lastName("Nazwisko2")
                .address(new Address(3L, "Ulica2", "21", "11-192", "Miasto"))
                .email("email12")
                .phoneNumber(Integer.parseInt("124554632"))
                .dateOfEmployment(LocalDate.of(2019, 10, 30))
                .salary(Integer.parseInt("6500"))
                .department(new Department(2L, "Dział2", new Address(4L, "Ulica", "32", "12-145", "Miasto")))
                .position(new Position(2L, "Programista2"))
                .build();
        employee3 = Employee.builder()
                .id(3L)
                .firstName("Imię3")
                .lastName("Nazwisko3")
                .address(new Address(5L, "Ulica3", "21", "11-192", "Miasto"))
                .email("email")
                .phoneNumber(Integer.parseInt("124554632"))
                .dateOfEmployment(LocalDate.of(2019, 10, 30))
                .salary(Integer.parseInt("6500"))
                .department(new Department(1L, "Dział3", new Address(6L, "Ulica", "32", "12-145", "Miasto")))
                .position(new Position(1L, "Programista3"))
                .build();

        employeeList = List.of(employee2, employee3);
    }


    @Test
    void givenNoIdShouldGetEmployeeList() throws Exception {
        String employeeListJson = objectMapper.writeValueAsString(employeeList);

        when(employeeService.getAll()).thenReturn(employeeList);
        mockMvc.perform(get("/api/employee"))
                .andExpect(status().isOk())
                .andExpect(content()
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json(employeeListJson));
    }



    @Test
    void givenIdShouldGetEmployee() throws Exception {

        employee.setId(employeeId);
        when(employeeService.getById(employeeId)).thenReturn(employee);

        mockMvc.perform(get("/api/employee/{id}", employeeId))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.firstName", Matchers.is(employee.getFirstName())));
    }


    @Test
    void givenEmployeeShouldCreateNew() throws Exception {
        when(employeeService.saveEmployee(any(Employee.class)))
                .thenAnswer(invocationOnMock -> invocationOnMock.getArgument(0));

        mockMvc.perform(post("/api/employee")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(employee)))
                .andExpect(status().isCreated());
    }




    @Test
    void shouldReturn404WhenObjectGetByIdNotFound() throws Exception {
        when(employeeService.getById(employeeId)).thenThrow(ObjectNotFoundException.class);
        mockMvc.perform(get("/api/employee/{id}", employeeId))
                .andExpect(status().isNotFound());
    }




}