package com.motelreg.motel_registration.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "registration_history")
public class RegistrationHistory {
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
    private Long roomNumber;

    @Column
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM/dd/yyyy") // Formatting the Date data type for input
    private Date checkInDate;

    @Column
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM/dd/yyyy") // Formatting the Date data type for input
    private Date checkOutDate;

    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "room_id")
    private Room room;

    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "manager_id")
    private Manager manager;

    public RegistrationHistory() {
    }

    public RegistrationHistory(Long id, String customerName, String customerIdNumber, String dateOfBirth, String customerAddress, Double payment, Long roomNumber, Date checkInDate, Date checkOutDate, Room room, Customer customer, Manager manager) {
        this.id = id;
        this.customerName = customerName;
        this.customerIdNumber = customerIdNumber;
        this.dateOfBirth = dateOfBirth;
        this.customerAddress = customerAddress;
        this.payment = payment;
        this.roomNumber = roomNumber;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.room = room;
        this.customer = customer;
        this.manager = manager;
    }

    // Constructor for testing
    public RegistrationHistory(Object id, String customerName, String customerIdNumber, String dateOfBirth, String customerAddress, double payment, long roomNumber, int checkInDate, int checkOutDate) {
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

    public Double getPayment() {
        return payment;
    }

    public void setPayment(Double payment) {
        this.payment = payment;
    }

    public Long getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Long roomNumber) {
        this.roomNumber = roomNumber;
    }

    public Date getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(Date checkInDate) {
        this.checkInDate = checkInDate;
    }

    public Date getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(Date checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    @Override
    public String toString() {
        return "RegistrationHistory{" +
                "id=" + id +
                ", customerName='" + customerName + '\'' +
                ", customerIdNumber='" + customerIdNumber + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", customerAddress='" + customerAddress + '\'' +
                ", payment=" + payment +
                ", roomNumber=" + roomNumber +
                ", checkInDate=" + checkInDate +
                ", checkOutDate=" + checkOutDate +
                ", room=" + room +
                ", customer=" + customer +
                ", manager=" + manager +
                '}';
    }
}
