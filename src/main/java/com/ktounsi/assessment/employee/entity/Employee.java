package com.ktounsi.assessment.employee.entity;


import com.ktounsi.assessment.address.entity.Address;
import com.ktounsi.assessment.department.entity.Department;
import com.ktounsi.assessment.position.entity.Position;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.Date;

import static javax.persistence.GenerationType.SEQUENCE;


@Entity
@Table(name = "Pracownicy")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
@Transactional
public class Employee {

        @Id
        @GeneratedValue(strategy=GenerationType.SEQUENCE,generator="employee_SEQ")
        @Column(name = "Id_Pracownika")
        private Long id;

        @Column(name = "Imię" , length = 30)
        private String firstName;

        @Column(name = "Nazwisko", length = 30)
        private String lastName;

        @OneToOne
        private Address address;

        @Column(name = "Email", length = 80)
        private String email;

        @Column(name = "Telefon")
        private Integer phoneNumber;

        @Column(name = "Data_Zatrudnienia")
        private LocalDate dateOfEmployment;

        @Column(name = "Wynagrodzenie")
        private Integer salary;

        @OneToOne
        private Department department;

        @OneToOne
        private Position position;


}
