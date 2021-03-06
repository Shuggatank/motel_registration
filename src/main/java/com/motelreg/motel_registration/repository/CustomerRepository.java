package com.motelreg.motel_registration.repository;

import com.motelreg.motel_registration.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface CustomerRepository extends JpaRepository<Customer, Long> {

//    Customer findByName(String customerName);

    Customer findByCustomerIdNumber(String customerIdNumber);

    Optional<Customer> findByCustomerName(String name);
}
