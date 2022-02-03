package com.motelreg.motel_registration.service;

import com.motelreg.motel_registration.exceptions.InformationExistsException;
import com.motelreg.motel_registration.exceptions.InformationNotFoundException;
import com.motelreg.motel_registration.model.Room;
import com.motelreg.motel_registration.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoomService {
    private static RoomRepository roomRepository;

    @Autowired
    public void setRoomRepository(RoomRepository roomRepository) {
        RoomService.roomRepository = roomRepository;
    }

    public List<Room> getAllRooms() {
        System.out.println("Calling getAllRooms");
        return roomRepository.findAll();
    }

    public Room createRoom(Room roomObject) {
        System.out.println("calling createRoom");
        Room room = roomRepository.findByRoomNumber(roomObject.getRoomNumber());
        // Checking if the room exists, if not then throws an error
        if (room != null) {
            throw new InformationExistsException("room with the number " + room.getRoomNumber() + " already exists");
        } else {
            return roomRepository.save(roomObject);
        }
    }

    public Optional<Room> getRoom (Long roomId) {
        Optional<Room> room = roomRepository.findById(roomId);
        // Checking if the room exists, if not then throws an error
        if (room.isPresent()) {
            return room;
        }else {
            throw new InformationNotFoundException("room number " + roomId + " not found");
        }
    }

    public Room updateRoom(Long roomId, Room roomObject) {
        Optional<Room> room = roomRepository.findById(roomId);
        // Checking if the room exists, if not then throws an error
        if (room.isPresent()) {
            //Checks whether the room number you're trying to edit matches the room number in your input matches.
            // The reason for this is we don't want to change a room to another number. For example if we're editing room 11 we don't want to be able to change it to 12
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
                throw new InformationNotFoundException("Room number " + room.get().getRoomNumber() + " does not match your input of " + roomObject.getRoomNumber());
            }
        } else {
            throw new InformationNotFoundException("room number " + roomId + "not found");
        }
    }

    public static Room updatePartsOfRoom(Long roomId, Room roomObject) {
        Optional<Room> room = roomRepository.findById(roomId);
        if (room.isPresent()) {
                System.out.println("Matching room number found");
                System.out.println(roomId);
                Room updateRoom = room.get();
                // If we don't update the field then it returns a null value. We check for the null to make sure it doesn't update to null
                if (roomObject.getNumberOfBeds() != null) {
                    updateRoom.setNumberOfBeds(roomObject.getNumberOfBeds());
                }
                // If we don't update the field then it returns a null value. We check for the null to make sure it doesn't update to null
                if (roomObject.getRate() != null) {
                    updateRoom.setRate(roomObject.getRate());
                }
                // Can not really check boolean values as the default value that is always given is false.
                // If you try to check for a true condition, then when you want to change from true to false it will be blocked.
                // Default value if field is empty is false
                updateRoom.setClean(roomObject.isClean());
                updateRoom.setEmpty(roomObject.isEmpty());
                System.out.println(updateRoom);
                return roomRepository.save(updateRoom);
        } else {
            throw new InformationNotFoundException("room number " + roomId + " not found");
        }
    }

    public Optional<Room> deleteRoom(Long roomId) {
        System.out.println("calling deleteRoom ===>");
        Optional<Room> room = roomRepository.findById(roomId);
        if (room.isPresent()) {
            roomRepository.deleteById(roomId);
            return room;
        }else{
            throw new InformationNotFoundException("room number " + roomId + " not found");
        }
    }
}
