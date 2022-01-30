package com.motelreg.motel_registration.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name="rooms")
public class Room {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Long roomNumber;

    @Column
    private Long numberOfBeds;

    @Column
    private Long rate;

    @Column
    private boolean clean;

    @Column
    private boolean empty;


    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "registration_id")
    private Registration registration;

    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "manager_id")
    private Manager manager;

    public Room() {
    }

    public Room(Long id, Long roomNumber, Long numberOfBeds, Long rate, boolean clean, boolean empty) {
        this.id = id;
        this.roomNumber = roomNumber;
        this.numberOfBeds = numberOfBeds;
        this.rate = rate;
        this.clean = clean;
        this.empty = empty;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Long roomNumber) {
        this.roomNumber = roomNumber;
    }

    public Long getNumberOfBeds() {
        return numberOfBeds;
    }

    public void setNumberOfBed(Long numberOfBeds) {
        this.numberOfBeds = numberOfBeds;
    }

    public Long getRate() {
        return rate;
    }

    public void setRate(Long rate) {
        this.rate = rate;
    }

    public boolean isClean() {
        return clean;
    }

    public void setClean(boolean clean) {
        this.clean = clean;
    }

    public boolean isEmpty() {
        return empty;
    }

    public void setEmpty(boolean empty) {
        this.empty = empty;
    }

    public Registration getRegistration() {
        return registration;
    }

    public void setRegistration(Registration registration) {
        this.registration = registration;
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
        return "Room{" +
                "id=" + id +
                ", room_number=" + roomNumber +
                ", number_of_beds=" + numberOfBeds +
                ", rate=" + rate +
                ", clean=" + clean +
                ", empty=" + empty +
                '}';
    }
}
