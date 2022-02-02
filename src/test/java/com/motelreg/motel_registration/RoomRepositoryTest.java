package com.motelreg.motel_registration;

import com.motelreg.motel_registration.model.Room;
import com.motelreg.motel_registration.repository.RoomRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
@ActiveProfiles("test")
public class RoomRepositoryTest {

    @Autowired
    private RoomRepository roomRepository;

    @Test
    public void shouldSaveRoomLocal() {
        Room room = new Room(null, 4L, 2L, 55.00, true, true );
        Room savedRoom = roomRepository.save(room);
        assertThat(savedRoom).usingRecursiveComparison().ignoringFields("id").isEqualTo(room);
    }
}
