package com.motelreg.motel_registration.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrationHistoryService {
    private RegistrationHistoryRepository registrationHistoryRepository;

    @Autowired
    public void setRegistrationHistoryRepository(RegistrationHistoryRepository registrationHistoryRepository){
        this.registrationHistoryRepository = registrationHistoryRepository;
    }

}
