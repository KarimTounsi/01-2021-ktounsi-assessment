package com.ktounsi.assessment.department.entity;


import com.ktounsi.assessment.address.entity.Address;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.transaction.Transactional;


@Entity
@Table(name = "Działy")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
@Transactional
public class Department {

        @Id
        @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="department_SEQ")
        @Column(name = "Id_Działu")
        private Long id;

        @Column(name = "Nazwa", length = 30)
        private String name;

        @OneToOne
        private Address location;

}