package com.motelreg.motel_registration;

import com.motelreg.motel_registration.model.Customer;
import com.motelreg.motel_registration.model.Room;
import com.motelreg.motel_registration.repository.RoomRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
//@Testcontainers
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class RoomRepositoryContainerTest extends BaseContainerTest {

//        @Container
//        PostgreSQLContainer postgresContainer = new PostgreSQLContainer("postgres:latest")
//                .withDatabaseName("spring-project-test-db")
//                .withUsername("postgres")
//                .withPassword("postgres");
        @Autowired
        private RoomRepository roomRepository;

        @Test
        public void shouldSaveRoom() {
                Room expectedRoomObject = new Room( null, 1L, 100.00, true, true);
                Room actualRoomObject = roomRepository.save(expectedRoomObject);
                assertThat(actualRoomObject).usingRecursiveComparison().ignoringFields("id").isEqualTo(expectedRoomObject);
        }
}