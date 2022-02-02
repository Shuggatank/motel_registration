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
    private Double rate;

    @Column
    private boolean clean;

    @Column
    private boolean empty;


    public Room() {
    }

    public Room(Long id, Long numberOfBeds, Double rate, boolean clean, boolean empty) {
        this.id = id;
        this.numberOfBeds = numberOfBeds;
        this.rate = rate;
        this.clean = clean;
        this.empty = empty;
    }

    public Room(Long id, Long roomNumber, Long numberOfBeds, Double rate, boolean clean, boolean empty) {
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

    public void setNumberOfBeds(Long numberOfBeds) {
        this.numberOfBeds = numberOfBeds;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
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
