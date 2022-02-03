package com.motelreg.motel_registration.containertests;

import com.motelreg.motel_registration.model.Manager;
import com.motelreg.motel_registration.repository.ManagerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ManagerRepositoryContainerTest extends BaseContainerTest {

        @Autowired
        private ManagerRepository managerRepository;


        //Checks whether the manager saves and loads correctly with PostgreSQL in a Dock container
        @Test
        public void shouldSaveManager() {
                Manager expectedManagerObject = new Manager(null, "ManagerTest", "TestPass");
                Manager actualManagerObject = managerRepository.save(expectedManagerObject);
                assertThat(actualManagerObject).usingRecursiveComparison().ignoringFields("id").isEqualTo(expectedManagerObject);
        }
}