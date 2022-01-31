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

    public Registration updateRegistration(int room, Registration registrationObject) {
        Registration registration = registrationRepository.findByRoomNumber(room);
        if (registration !=null) {
            if (registrationObject.getRoomNumber() == (registration.getRoomNumber())){
                System.out.println("Matching room number found");
                registration.setCustomerName(registrationObject.getCustomerName());
                registration.setCustomerIdNumber(registrationObject.getCustomerIdNumber());
                registration.setDateOfBirth(registrationObject.getDateOfBirth());
                registration.setCustomerAddress(registrationObject.getCustomerAddress());
                registration.setPayment(registrationObject.getPayment());
                registration.setRoomNumber(registrationObject.getRoomNumber());
                registration.setCheckInDate(registrationObject.getCheckInDate());
                registration.setCheckOutDate(registrationObject.getCheckOutDate());
                return registrationRepository.save(registration);
            } else {
                throw new InformationNotFoundException("Room number " + registration.getRoomNumber() + " has no registration");
            }
        }else{
            throw new InformationNotFoundException("Room number " + room + " has no registration");
        }
    }

    public Registration deleteRegistration(int room) {
        System.out.println("calling deleteRegistration ===>");
        Registration registration = registrationRepository.findByRoomNumber(room);
        if (registration != null) {
            registrationRepository.deleteById(registration.getId());
            return registration;
        } else {
            throw new InformationNotFoundException("Room number " + room + " has no registration");
        }
    }

}
