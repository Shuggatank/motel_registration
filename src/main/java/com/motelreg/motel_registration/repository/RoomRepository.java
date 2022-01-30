package com.motelreg.motel_registration.repository;

import com.motelreg.motel_registration.model.Customer;
import com.motelreg.motel_registration.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {
    Room findByRoomNumber(Long roomNumber);

}
