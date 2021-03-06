package com.motelreg.motel_registration.service;

import com.motelreg.motel_registration.exceptions.InformationExistsException;
import com.motelreg.motel_registration.exceptions.InformationNotFoundException;
import com.motelreg.motel_registration.exceptions.NotReady;
import com.motelreg.motel_registration.model.Customer;
import com.motelreg.motel_registration.model.Registration;
import com.motelreg.motel_registration.model.RegistrationHistory;
import com.motelreg.motel_registration.model.Room;
import com.motelreg.motel_registration.repository.CustomerRepository;
import com.motelreg.motel_registration.repository.RegistrationHistoryRepository;
import com.motelreg.motel_registration.repository.RegistrationRepository;
import com.motelreg.motel_registration.repository.RoomRepository;
import com.motelreg.motel_registration.security.MyUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class RegistrationService {
    private RegistrationRepository registrationRepository;
    private CustomerRepository customerRepository;
    private RoomRepository roomRepository;
    private RegistrationHistoryRepository registrationHistoryRepository;

    @Autowired
    public void setRegistrationRepository(RegistrationRepository registrationRepository) {
        this.registrationRepository = registrationRepository;
    }

    @Autowired
    public void setCustomerRepository(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Autowired
    public void setRoomRepository(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    @Autowired
    public void setRegistrationHistoryRepository(RegistrationHistoryRepository registrationHistoryRepository) {
        this.registrationHistoryRepository = registrationHistoryRepository;
    }



    public List<Registration> getAllRegistrations() {
        System.out.println("Calling getAllRegistrations");
        return registrationRepository.findAll();
    }

    public Registration createRegistration(Registration registrationObject) {
        System.out.println("calling createRegistration");
        MyUserDetails userDetails = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication()
                .getPrincipal();
        Registration registration = registrationRepository.findByRoomNumber(registrationObject.getRoomNumber());
        // Finding the room number from the room repository
        Room roomId = roomRepository.findByRoomNumber(registrationObject.getRoomNumber());
        System.out.println(roomId);
        if(roomId != null) {
            if (registration != null) {
                throw new InformationExistsException("Registration with room number " + registration.getRoomNumber() + " already exists");
            } else {
                // Checks if the room is clean and empty. If either one is false then it is unrentable
                if (roomId.isClean() && roomId.isEmpty()) {
                    // Logic to save the customer to customer table if customer id doesn't already exist.
                    Customer customer = customerRepository.findByCustomerIdNumber(registrationObject.getCustomerIdNumber());
                    if (customer == null) {
                        Customer newCustomer = new Customer();
                        newCustomer.setCustomerName(registrationObject.getCustomerName());
                        newCustomer.setCustomerIdNumber(registrationObject.getCustomerIdNumber());
                        newCustomer.setDateOfBirth(registrationObject.getDateOfBirth());
                        newCustomer.setCustomerAddress(registrationObject.getCustomerAddress());
                        customerRepository.save(newCustomer);
                    }
                    Customer customerId = customerRepository.findByCustomerIdNumber(registrationObject.getCustomerIdNumber());
                    Room notEmpty = new Room();
                    // Sets the room that is being rented to not empty and not clean.
                    notEmpty.setClean(false);
                    notEmpty.setEmpty(false);
                    // Send the data to the room service method to get processed
                    RoomService.updatePartsOfRoom(roomId.getId(), notEmpty);
                    // Setting the foreign keys
                    registrationObject.setCustomer(customerId);
                    registrationObject.setManager(userDetails.getManager());
                    registrationObject.setRoom(roomId);
                    // Saving the registration data to the registration history table
                    RegistrationHistory saveHistory = new RegistrationHistory();
                    saveHistory.setCustomerName(registrationObject.getCustomerName());
                    saveHistory.setCustomerIdNumber(registrationObject.getCustomerIdNumber());
                    saveHistory.setDateOfBirth(registrationObject.getDateOfBirth());
                    saveHistory.setCustomerAddress(registrationObject.getCustomerAddress());
                    saveHistory.setPayment(registrationObject.getPayment());
                    saveHistory.setRoomNumber(registrationObject.getRoomNumber());
                    saveHistory.setCheckInDate(registrationObject.getCheckInDate());
                    saveHistory.setCheckOutDate(registrationObject.getCheckOutDate());
                    saveHistory.setCustomer(customerId);
                    saveHistory.setManager(userDetails.getManager());
                    saveHistory.setRoom(roomId);

                    registrationHistoryRepository.save(saveHistory);
                    return registrationRepository.save(registrationObject);
                } else {
                    throw new NotReady("Room " + roomId.getRoomNumber() + " is not ready to be rented");
                }
            }
        } else {
            throw new InformationNotFoundException("Room " + registrationObject.getRoomNumber() + " does not exist" );
        }
    }

    public Registration getRegistration (Long room) {
        Registration registration = registrationRepository.findByRoomNumber(room);
        if (registration != null) {
            System.out.println(registration);
            return registration;
        } else {
            throw new InformationNotFoundException("registration belonging to room " + room + " not found");
        }
    }

    public Registration updateRegistration(Long room, Registration registrationObject) {
        Registration registration = registrationRepository.findByRoomNumber(room);
        if (registration !=null) {
            //Checks whether the room number you're trying to edit matches the room number in your input matches.
            // The reason for this is we don't want to change a room to another number. For example if we're editing room 11 we don't want to be able to change it to 12
            if (Objects.equals(registrationObject.getRoomNumber(), registration.getRoomNumber())){
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
                throw new InformationNotFoundException("Room number " + registration.getRoomNumber() + " does not match your input of " + registrationObject.getRoomNumber());
            }
        }else{
            throw new InformationNotFoundException("Room number " + room + " has no registration");
        }
    }

    public Registration updatePartsOfRegistration(Long room, Registration registrationObject) {
        Registration registration = registrationRepository.findByRoomNumber(room);
        if (registration !=null) {
            System.out.println("Matching room number found");
            // If we don't update the field then it returns a null value. We check for the null to make sure it doesn't update to null
            if (registrationObject.getCustomerName() != null) {
                registration.setCustomerName(registrationObject.getCustomerName());
            }
            if (registrationObject.getCustomerIdNumber() != null) {
                registration.setCustomerIdNumber(registrationObject.getCustomerIdNumber());
            }
            if (registrationObject.getDateOfBirth() != null) {
                registration.setDateOfBirth(registrationObject.getDateOfBirth());
            }
            if (registrationObject.getCustomerAddress() != null) {
                registration.setCustomerAddress(registrationObject.getCustomerAddress());
            }
            if (registrationObject.getPayment() != null) {
                registration.setPayment(registrationObject.getPayment());
            }
            if (registrationObject.getRoomNumber() != null) {
                registration.setRoomNumber(registrationObject.getRoomNumber());
            }
            if (registrationObject.getCheckInDate() != null) {
                registration.setCheckInDate(registrationObject.getCheckInDate());
            }
            if (registrationObject.getCheckOutDate() != null) {
                registration.setCheckOutDate(registrationObject.getCheckOutDate());
            }
            return registrationRepository.save(registration);
        }else{
            throw new InformationNotFoundException("Room number " + room + " has no registration");
        }
    }

    public Registration deleteRegistration(Long room) {
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
