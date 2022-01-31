package com.motelreg.motel_registration.controller;

import com.motelreg.motel_registration.model.Customer;
import com.motelreg.motel_registration.model.Registration;
import com.motelreg.motel_registration.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api")
public class RegistrationController {

    private RegistrationService registrationService;

    @Autowired
    public void setRegistrationService(RegistrationService registrationService){
        this.registrationService = registrationService;
    }

    @GetMapping("/registrations")
    public List<Registration> getAllRegistrations() {
        System.out.println("calling getAllRegistrations");
        return registrationService.getAllRegistrations();
    }

    @PostMapping("/registrations")
    public Registration createRegistration(@RequestBody Registration registrationObject) {
        System.out.println("creating new registration");
        return registrationService.createRegistration(registrationObject);
    }

}
