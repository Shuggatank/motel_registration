package com.motelreg.motel_registration;

import com.motelreg.motel_registration.model.Manager;
import com.motelreg.motel_registration.repository.ManagerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;


import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
@ActiveProfiles("test")
public class ManagerRepositoryTest {

    @Autowired
    private ManagerRepository managerRepository;

    //Checks whether the manager saves and loads correctly with h2 in-memory database
    @Test
    public void shouldSaveManagerLocal() {
        Manager manager = new Manager(null, "Test Joe", "D35TEST");
        Manager savedManager = managerRepository.save(manager);
        assertThat(savedManager).usingRecursiveComparison().ignoringFields("id").isEqualTo(manager);
    }
}
