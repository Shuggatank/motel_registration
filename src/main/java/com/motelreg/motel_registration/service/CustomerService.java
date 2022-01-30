package com.motelreg.motel_registration.service;

import com.motelreg.motel_registration.exceptions.InformationExistsException;
import com.motelreg.motel_registration.exceptions.InformationNotFoundException;
import com.motelreg.motel_registration.model.Customer;
import com.motelreg.motel_registration.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    private CustomerRepository customerRepository;

    @Autowired
    public void serCustomerRepository(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> getAllCustomers() {
        System.out.println("Calling getAllCustomers");
        return customerRepository.findAll();
    }

    public Customer createCustomer(Customer customerObject) {
        System.out.println("calling createCustomer");
        Customer customer = customerRepository.findByCustomerIdNumber(customerObject.getCustomerIdNumber());
        if (customer != null) {
            throw new InformationExistsException("customer with the id " + customer.getCustomerIdNumber() + " already exists");
        } else {
            return customerRepository.save(customerObject);
        }
    }

    public Optional getCustomer (Long customerId) {
        Optional<Customer> customer = customerRepository.findById(customerId);
        if (customer.isPresent()) {
            return customer;
        }else {
            throw new InformationNotFoundException("customer with the Id " + customerId + " not found");
        }
    }
}
