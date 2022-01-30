package com.motelreg.motel_registration.service;


import com.motelreg.motel_registration.exceptions.InformationExistsException;
import com.motelreg.motel_registration.exceptions.InformationNotFoundException;
import com.motelreg.motel_registration.model.Customer;
import com.motelreg.motel_registration.model.Room;
import com.motelreg.motel_registration.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class RoomService {
    private RoomRepository roomRepository;

    @Autowired
    public void setRoomRepository(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    public List<Room> getAllRooms() {
        System.out.println("Calling getAllRooms");
        return roomRepository.findAll();
    }

    public Room createRoom(Room roomObject) {
        System.out.println("calling createRoom");
        Room room = roomRepository.findByRoomNumber(roomObject.getRoomNumber());
        if (room != null) {
            throw new InformationExistsException("room with the number " + room.getRoomNumber() + " already exists");
        } else {
            return roomRepository.save(roomObject);
        }
    }

    public Optional<Room> getRoom (Long roomId) {
        Optional<Room> room = roomRepository.findById(roomId);
        if (room.isPresent()) {
            return room;
        }else {
            throw new InformationNotFoundException("room with the Id " + roomId + " not found");
        }
    }
}
