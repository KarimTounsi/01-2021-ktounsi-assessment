package com.ktounsi.assessment.employee.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.Date;


@Entity
@Table(name = "Pracownicy")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
@Transactional
public class employee {

        @Id
        @Column(name = "id_pracownika")
        private Long id;

        @Column(name = "imię" , length = 30)
        private String firstName;

        @Column(name = "nazwisko", length = 30)
        private String lastName;


        @Column(name = "Email", length = 80)
        private String email;

        @Column(name = "Telefon")
        private Integer phoneNumber;

        @Column(name = "Data_Zatrudnienia")
        private Date dateOfEmployment;

        @Column(name = "Wynagrodzenie")
        private Double salary;


}
