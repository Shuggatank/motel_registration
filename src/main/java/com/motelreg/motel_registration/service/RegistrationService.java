package com.motelreg.motel_registration.service;

import com.motelreg.motel_registration.exceptions.InformationExistsException;
import com.motelreg.motel_registration.exceptions.InformationNotFoundException;
import com.motelreg.motel_registration.model.Registration;
import com.motelreg.motel_registration.repository.RegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RegistrationService {
    private RegistrationRepository registrationRepository;

    @Autowired
    public void setRegistrationRepository(RegistrationRepository registrationRepository) {
        this.registrationRepository = registrationRepository;
    }

    public List<Registration> getAllRegistrations() {
        System.out.println("Calling getAllRegistrations");
        return registrationRepository.findAll();
    }

    public Registration createRegistration(Registration registrationObject) {
        System.out.println("calling createRegistration");
        Registration registration = registrationRepository.findByRoomNumber(registrationObject.getRoomNumber());
        if (registration !=null) {
            throw new InformationExistsException("Registration with room number " + registration.getRoomNumber() + " already exists");
        } else {
            return registrationRepository.save(registrationObject);
        }
    }

    public Registration getRegistration (int room) {
        Registration registration = registrationRepository.findByRoomNumber(room);
        if (registration != null) {
            return registration;
        } else {
            throw new InformationNotFoundException("registration belonging to room " + room + " not found");
        }
    }
}
