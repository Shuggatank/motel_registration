package com.motelreg.motel_registration.controller;

import com.motelreg.motel_registration.model.Customer;
import com.motelreg.motel_registration.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api")
public class CustomerController {

    private CustomerService customerService;

    @Autowired
    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/customers")
    public List<Customer> getAllCustomers() {
        System.out.println("calling getAllCustomers");
        return customerService.getAllCustomers();
    }

    @PostMapping("/customers")
    public Customer createCustomer(@RequestBody Customer customerObject) {
        System.out.println("creating new customer");
        return customerService.createCustomer(customerObject);
    }

    @GetMapping("/customers/{customerId}")
    public Optional getCustomerById (@PathVariable (value = "customerId") Long customerId) {
        System.out.println("getting the customer with the id of " + customerId);
        return customerService.getCustomer(customerId);
    }
}
