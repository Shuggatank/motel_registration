package com.motelreg.motel_registration;

import com.motelreg.motel_registration.model.Customer;
import com.motelreg.motel_registration.repository.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
@Testcontainers
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class CustomerRepositoryContainerTest {

        @Container
        PostgreSQLContainer postgresContainer = new PostgreSQLContainer("postgres:latest")
                .withDatabaseName("spring-project-test-db")
                .withUsername("postgres")
                .withPassword("postgres");
        @Autowired
        private CustomerRepository customerRepository;

        @Test
        public void shouldSaveCustomer() {
                Customer expectedCustomerObject = new Customer(null, "Joe Test", "DPGRES213", "5/4/1962", "124 postgre ave., Fl, 5464");
                Customer actualCustomerObject = customerRepository.save(expectedCustomerObject);
                assertThat(actualCustomerObject).usingRecursiveComparison().ignoringFields("id").isEqualTo(expectedCustomerObject);
        }
}