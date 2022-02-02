package com.motelreg.motel_registration.repository;

import com.motelreg.motel_registration.model.Manager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ManagerRepository extends JpaRepository<Manager, Long> {
    //to login
    Manager findManagerByName(String name);
    //to register
    boolean existsByName(String name);
}
