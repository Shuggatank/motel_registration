package com.motelreg.motel_registration;

import com.motelreg.motel_registration.model.Registration;
import com.motelreg.motel_registration.model.RegistrationHistory;
import com.motelreg.motel_registration.repository.RegistrationHistoryRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
@ActiveProfiles("test")
public class RegistrationHistoryRepositoryTest {

    @Autowired
    private RegistrationHistoryRepository registrationHistoryRepository;

    @Test
    public void shouldSaveRegistrationHistoryLocal() {
        RegistrationHistory registration = new RegistrationHistory(null, "Reggie Tester", "DI2334", "8/5/1971", "234 Reg Test", 175.00, 5L, 2/1/2022, 2/8/2022);
        RegistrationHistory savedRegistration = registrationHistoryRepository.save(registration);
        assertThat(savedRegistration).usingRecursiveComparison().ignoringFields("id").isEqualTo(registration);
    }
}
