package com.motelreg.motel_registration.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "registration")
public class Registration {
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

    @Column
    private Double payment;

    @Column
    private int roomNumber;

    @Column
    private Date checkInDate;

    @Column
    private Date checkOutDate;

    public Registration() {
    }

    public Registration(Long id, String customerName, String customerIdNumber, String dateOfBirth, String customerAddress, Double payment, int roomNumber, Date checkInDate, Date checkOutDate) {
        this.id = id;
        this.customerName = customerName;
        this.customerIdNumber = customerIdNumber;
        this.dateOfBirth = dateOfBirth;
        this.customerAddress = customerAddress;
        this.payment = payment;
        this.roomNumber = roomNumber;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
    }
}
