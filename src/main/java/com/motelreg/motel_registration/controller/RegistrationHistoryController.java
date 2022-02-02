package com.motelreg.motel_registration.controller;

import com.motelreg.motel_registration.model.RegistrationHistory;
import com.motelreg.motel_registration.service.RegistrationHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api")
public class RegistrationHistoryController {

    private RegistrationHistoryService registrationHistoryService;

    @Autowired
    public void setRegistrationHistoryService(RegistrationHistoryService registrationHistoryService) {
        this.registrationHistoryService = registrationHistoryService;
    }

    @GetMapping("/registration_history")
    public List<RegistrationHistory> getAllRegistrationHistory() {
        System.out.println("calling getAllRegistrationHistory");
        return registrationHistoryService.getAllRegistrationHistory();
    }

    @PostMapping("/registrations")
    public RegistrationHistory createRegistrationHistory(@RequestBody RegistrationHistory registrationHistoryObject) {
        System.out.println("creating new registration history");
        return registrationHistoryService.createRegistration(registrationHistoryObject);
    }
}
