package com.motelreg.motel_registration.controller;

import com.motelreg.motel_registration.model.RegistrationHistory;
import com.motelreg.motel_registration.service.RegistrationHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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


    @GetMapping("/registration_history/{registrationId}")
    public Optional<RegistrationHistory> getRegistrationHistory (@PathVariable("registrationId") Long registrationId) {
        System.out.println("getting the registration with the Id of " + registrationId);
        return registrationHistoryService.getRegistrationHistory(registrationId);
    }

    @PatchMapping("/registration_history/{registrationId}")
    public RegistrationHistory updateRegistrationInHistory(@PathVariable("registrationId") Long registrationId, @RequestBody RegistrationHistory registrationHistoryObject) {
        System.out.println("Updating registration history");
        return registrationHistoryService.updateRegistrationInHistory(registrationId, registrationHistoryObject);
    }
}
