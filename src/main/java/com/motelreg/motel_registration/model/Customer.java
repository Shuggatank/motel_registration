package com.motelreg.motel_registration.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name ="customer")

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

    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "registration_id")
    private Registration registration;

    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "room_id")
    private Room room;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "manager_id")
    private Manager manager;

    public Customer() {
    }

    public Customer(Long id, String customerName, String customerIdNumber, String dateOfBirth, String customerAddress) {
        this.id = id;
        this.customerName = customerName;
        this.customerIdNumber = customerIdNumber;
        this.dateOfBirth = dateOfBirth;
        this.customerAddress = customerAddress;
    }
}
