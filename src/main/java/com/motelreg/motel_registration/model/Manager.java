package com.motelreg.motel_registration.model;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "manager")
public class Manager {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
//    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    @OneToMany(mappedBy = "manager")
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Room> roomList;

    public Manager() {
    }

    public Manager(Long id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }


}
