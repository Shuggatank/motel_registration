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

    public Room updateRoom(Long roomId, Room roomObject) {
        Optional<Room> room = roomRepository.findById(roomId);
        if (room.isPresent()) {
            if (roomObject.getRoomNumber().equals(room.get().getRoomNumber())) {
                System.out.println("Matching room number found");
                Room updateRoom = roomRepository.findById(roomId).get();
                updateRoom.setRoomNumber(roomObject.getRoomNumber());
                updateRoom.setNumberOfBeds(roomObject.getNumberOfBeds());
                updateRoom.setRate(roomObject.getRate());
                updateRoom.setClean(roomObject.isClean());
                updateRoom.setEmpty(roomObject.isEmpty());
                return roomRepository.save(updateRoom);
            } else {
                throw new InformationNotFoundException("Room number " + room.get().getRoomNumber() + " does not exist;");
            }
        } else {
            throw new InformationNotFoundException("room with the Id of " + roomId + "not found");
        }
    }

    public Optional<Room> deleteRoom(Long roomId) {
        System.out.println("calling deleteRoom ===>");
        Optional<Room> room = roomRepository.findById(roomId);
        if (room.isPresent()) {
            roomRepository.deleteById(roomId);
            return room;
        }else{
            throw new InformationNotFoundException("room with the Id of " + roomId + " not found");
        }
    }


}
