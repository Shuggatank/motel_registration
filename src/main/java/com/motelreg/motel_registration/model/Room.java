package com.motelreg.motel_registration.model;

import javax.persistence.*;

@Entity
@Table(name="rooms")
public class Room {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Long room_number;

    @Column
    private Long number_of_beds;

    @Column
    private Long rate;

    @Column
    private boolean clean;

    @Column
    private boolean empty;

    public Room() {
    }

    public Room(Long id, Long room_number, Long number_of_beds, Long rate, boolean clean, boolean empty) {
        this.id = id;
        this.room_number = room_number;
        this.number_of_beds = number_of_beds;
        this.rate = rate;
        this.clean = clean;
        this.empty = empty;
    }
}
