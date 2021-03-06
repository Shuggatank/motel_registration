package com.motelreg.motel_registration.containertests;

import com.motelreg.motel_registration.model.Registration;
import com.motelreg.motel_registration.repository.RegistrationRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class RegistrationRepositoryContainerTest extends BaseContainerTest {

        @Autowired
        private RegistrationRepository registrationRepository;


        //Checks whether the registration saves and loads correctly with PostgreSQL in a Dock container
        @Test
        public void shouldSaveRegistration() {
                Registration expectedRegistrationObject = new Registration(null, "Joe Tester", "D124KIE", "5/6/1989", "154 Reg Test, Docker", 150.00, 12L, 2/1/2022, 2/5/2022);
                Registration actualRegistrationObject = registrationRepository.save(expectedRegistrationObject);
                assertThat(actualRegistrationObject).usingRecursiveComparison().ignoringFields("id").isEqualTo(expectedRegistrationObject);
        }
}