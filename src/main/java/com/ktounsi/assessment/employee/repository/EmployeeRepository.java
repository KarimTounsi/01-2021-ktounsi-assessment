package com.ktounsi.assessment.employee.repository;


import com.ktounsi.assessment.employee.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EmployeeRepository extends JpaRepository<Employee, Long> {

//
//@Query(value = "select NAZWA,  AVG(WYNAGRODZENIE) over () as AVG_SALARY, ROUND (((select  sysdate from DUAL) - DATA_ZATRUDNIENIA)/ 365.242199,0) as YEARS\n" +
//        "from PRACOWNICY join STANOWISKA S on S.ID_STANOWISKA = PRACOWNICY.POSITION_ID_STANOWISKA;" , nativeQuery = true )





}
