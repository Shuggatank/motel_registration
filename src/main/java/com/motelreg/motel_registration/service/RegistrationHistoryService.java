package com.motelreg.motel_registration.service;

import com.motelreg.motel_registration.exceptions.InformationNotFoundException;
import com.motelreg.motel_registration.model.RegistrationHistory;
import com.motelreg.motel_registration.repository.RegistrationHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public Optional<RegistrationHistory> getRegistrationHistory(Long registrationId){
        Optional<RegistrationHistory> registrationHistory = registrationHistoryRepository.findById(registrationId);
        if(registrationHistory.isPresent()) {
            return registrationHistory;
        } else {
            throw new InformationNotFoundException("Registration with the Id of " + registrationId + " not found");
        }
    }

    public RegistrationHistory updateRegistrationInHistory(Long registrationId, RegistrationHistory registrationHistoryObject){
        Optional<RegistrationHistory> registrationHistory = registrationHistoryRepository.findById(registrationId);
        if(registrationHistory.isPresent()) {
            System.out.println("Matching registration found");
            RegistrationHistory updateRegistration = registrationHistoryRepository.findById(registrationId).get();
            // If we don't update the field then it returns a null value. We check for the null to make sure it doesn't update to null
            if (registrationHistoryObject.getCustomerName() != null) {
                updateRegistration.setCustomerName(registrationHistoryObject.getCustomerName());
            }
            if (registrationHistoryObject.getCustomerIdNumber() != null) {
                updateRegistration.setCustomerIdNumber(registrationHistoryObject.getCustomerIdNumber());
            }
            if (registrationHistoryObject.getDateOfBirth() != null) {
                updateRegistration.setDateOfBirth(registrationHistoryObject.getDateOfBirth());
            }
            if (registrationHistoryObject.getCustomerAddress() != null) {
                updateRegistration.setCustomerAddress(registrationHistoryObject.getCustomerAddress());
            }
            if (registrationHistoryObject.getPayment() != null) {
                updateRegistration.setPayment(registrationHistoryObject.getPayment());
            }
            if (registrationHistoryObject.getRoomNumber() != null) {
                updateRegistration.setRoomNumber(registrationHistoryObject.getRoomNumber());
            }
            if (registrationHistoryObject.getCheckInDate() != null) {
                updateRegistration.setCheckInDate(registrationHistoryObject.getCheckInDate());
            }
            if (registrationHistoryObject.getCheckOutDate() != null) {
                updateRegistration.setCheckOutDate(registrationHistoryObject.getCheckOutDate());
            }
            return registrationHistoryRepository.save(updateRegistration);
        } else {
            throw new InformationNotFoundException("Registration with the Id of " + registrationId + " not found");
        }
    }

    public Optional<RegistrationHistory> deleteRegistrationFromHistory(Long registrationId) {
        System.out.println("calling deleteRegistrationFromHistory");
        Optional<RegistrationHistory> registrationHistory = registrationHistoryRepository.findById(registrationId);
        if(registrationHistory.isPresent()) {
            registrationHistoryRepository.deleteById(registrationId);
            return registrationHistory;
        } else {
            throw new InformationNotFoundException("Registration with the Id of " + registrationId + " not found");
        }
    }
}
