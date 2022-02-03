package com.motelreg.motel_registration.model;


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


    public Customer() {
    }

    public Customer(Long id, String customerName, String customerIdNumber, String dateOfBirth, String customerAddress) {
        this.id = id;
        this.customerName = customerName;
        this.customerIdNumber = customerIdNumber;
        this.dateOfBirth = dateOfBirth;
        this.customerAddress = customerAddress;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerIdNumber() {
        return customerIdNumber;
    }

    public void setCustomerIdNumber(String customerIdNumber) {
        this.customerIdNumber = customerIdNumber;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }


    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", customerName='" + customerName + '\'' +
                ", customerIdNumber='" + customerIdNumber + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", customerAddress='" + customerAddress + '\'' +
                '}';
    }

}
