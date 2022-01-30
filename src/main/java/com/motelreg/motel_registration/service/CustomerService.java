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
    public void setCustomerRepository(CustomerRepository customerRepository) {
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

    public Optional<Customer> getCustomer (Long customerId) {
        Optional<Customer> customer = customerRepository.findById(customerId);
        if (customer.isPresent()) {
            return customer;
        }else {
            throw new InformationNotFoundException("customer with the Id " + customerId + " not found");
        }
    }

    public Customer updateCustomer(Long customerId, Customer customerObject) {
        Optional<Customer> customer = customerRepository.findById(customerId);
        if (customer.isPresent()) {
            if (customerObject.getCustomerIdNumber().equals(customer.get().getCustomerIdNumber())) {
                System.out.println("Matching Id found");
                throw new InformationExistsException("customer " + customer.get().getCustomerName() + " is already in the system");
            }else {
                Customer updateCustomer = customerRepository.findById(customerId).get();
                updateCustomer.setCustomerName(customerObject.getCustomerName());
                updateCustomer.setCustomerIdNumber(customerObject.getCustomerIdNumber());
                updateCustomer.setDateOfBirth(customerObject.getDateOfBirth());
                updateCustomer.setCustomerAddress(customerObject.getCustomerAddress());
                return customerRepository.save(updateCustomer);
            }
        } else {
            throw new InformationNotFoundException("customer with the Id of " + customerId + "not found");
        }
    }

    public Optional<Customer> deleteCustomer(Long customerId) {
        System.out.println("calling deleteCustomer ===>");
        Optional<Customer> customer = customerRepository.findById(customerId);
        if (customer.isPresent()) {
            customerRepository.deleteById(customerId);
            return customer;
        }else{
            throw new InformationNotFoundException("customer with the Id of " + customerId + " not found");
        }
    }

}
