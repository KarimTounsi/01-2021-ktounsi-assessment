package com.ktounsi.assessment.address.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.transaction.Transactional;


@Entity
@Table(name = "Adresy")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
@Transactional
public class Address {

        @Id
        @GeneratedValue(strategy=GenerationType.SEQUENCE , generator="address_SEQ" )
        @Column(name = "Id_Adresu")
        private Long id;

        @Column(name = "Ulica" , length = 30)
        private String street;


        @Column(name = "Nr_Domu" , length = 10)
        private String homeNumber;


        @Column(name = "Kod_Pocztowy" , length = 6)
        private String postCode;

        @Column(name = "Miasto" , length = 30)
        private String city;
}
