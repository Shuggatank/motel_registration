package com.motelreg.motel_registration;

import com.motelreg.motel_registration.model.Customer;
import com.motelreg.motel_registration.repository.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;


import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
@ActiveProfiles("test")
public class CustomerRepositoryTest {

    @Autowired
    private CustomerRepository customerRepository;

    @Test
    public void shouldSaveCustomerLocal() {
        Customer customer = new Customer(null, "Test Customer", "D35TEST", "12/12/2022", "421 Test Street");
        Customer savedCustomer = customerRepository.save(customer);
        assertThat(savedCustomer).usingRecursiveComparison().ignoringFields("customerId").isEqualTo(customer);
    }


    @Test
    @Sql("classpath:test-customer-data.sql")
    public void shouldSaveCustomerDataThroughSqlFile() {
        Optional<Customer> test = customerRepository.findByCustomerName("Test Joe");
        assertThat(test).isNotEmpty();
    }
}
