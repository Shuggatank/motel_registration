package com.motelreg.motel_registration.controller;



import com.motelreg.motel_registration.model.Room;
import com.motelreg.motel_registration.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path="/api")
public class RoomController {

    private RoomService roomService;

    @Autowired
    public void setRoomService(RoomService roomService) {
        this.roomService = roomService;
    }

    @GetMapping("/rooms")
    public List<Room> getAllRooms() {
        System.out.println("calling getAllRooms");
        return roomService.getAllRooms();
    }

    @PostMapping("/rooms")
    public Room createRoom(@RequestBody Room roomObject) {
        System.out.println("creating new room");
        return roomService.createRoom(roomObject);
    }

    @GetMapping("/rooms/{roomId}")
    public Optional<Room> getRoom(@PathVariable (value = "roomId") Long roomId) {
        System.out.println("getting the room with the id of " + roomId);
        return roomService.getRoom(roomId);
    }

    @PutMapping("/rooms/{roomId}")
    public Room updateRoom(@PathVariable(value = "roomId") Long roomId, @RequestBody Room roomObject) {
        System.out.println("updating room record");
        return roomService.updateRoom(roomId, roomObject);
    }

    @PatchMapping("/rooms/{roomId}")
    public Room updatePartsOfRoom(@PathVariable(value = "roomId") Long roomId, @RequestBody Room roomObject) {
        System.out.println("updating room parts record");
        return roomService.updatePartsOfRoom(roomId, roomObject);
    }

    @DeleteMapping("/rooms/{roomId}")
    public Optional<Room> deleteRoom (@PathVariable (value = "roomId") Long roomId) {
        return roomService.deleteRoom(roomId);
    }
}
