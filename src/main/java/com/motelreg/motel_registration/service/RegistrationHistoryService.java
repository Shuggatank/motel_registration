package com.motelreg.motel_registration.service;

import com.motelreg.motel_registration.model.RegistrationHistory;
import com.motelreg.motel_registration.repository.RegistrationHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegistrationHistoryService {
    private RegistrationHistoryRepository registrationHistoryRepository;

    @Autowired
    public void setRegistrationHistoryRepository(RegistrationHistoryRepository registrationHistoryRepository){
        this.registrationHistoryRepository = registrationHistoryRepository;
    }

    public List<RegistrationHistory> getAllRegistrationHistory() {
        System.out.println("Calling getAllRegistrations");
        return registrationHistoryRepository.findAll();
    }

    public RegistrationHistory createRegistration(RegistrationHistory registrationHistoryObject) {
        return registrationHistoryRepository.save(registrationHistoryObject);
    }
}
