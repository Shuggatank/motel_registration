package com.motelreg.motel_registration.model;

import javax.persistence.*;

@Entity
@Table(name ="customers")
public class Customer {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String customerName;

    @Column
    private String customerIdNumber;

    @Column
    private String dateOfBirth;

    @Column
    private String customerAddress;
}
