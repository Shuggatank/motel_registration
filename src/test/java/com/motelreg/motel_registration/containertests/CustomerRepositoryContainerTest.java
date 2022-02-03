package com.motelreg.motel_registration.containertests;

import com.motelreg.motel_registration.model.Customer;
import com.motelreg.motel_registration.repository.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class CustomerRepositoryContainerTest extends BaseContainerTest {

        @Autowired
        private CustomerRepository customerRepository;


        //Checks whether the customer saves and loads correctly with PostgreSQL in a Dock container
        @Test
        public void shouldSaveCustomer() {
                Customer expectedCustomerObject = new Customer(null, "Joe Test", "DPGRES213", "5/4/1962", "124 postgre ave., Fl, 5464");
                Customer actualCustomerObject = customerRepository.save(expectedCustomerObject);
                assertThat(actualCustomerObject).usingRecursiveComparison().ignoringFields("id").isEqualTo(expectedCustomerObject);
        }
}