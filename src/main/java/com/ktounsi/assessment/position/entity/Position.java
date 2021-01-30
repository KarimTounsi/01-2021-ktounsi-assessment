package com.ktounsi.assessment.position.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.transaction.Transactional;

import static javax.persistence.GenerationType.SEQUENCE;


@Entity
@Table(name = "Stanowiska")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
@Transactional
public class Position {

        @Id
        @GeneratedValue(strategy=GenerationType.SEQUENCE)
        @Column(name = "Id_Stanowiska")
        private Long id;

        @Column(name = "Nazwa" , length = 50)
        private String name;

}
