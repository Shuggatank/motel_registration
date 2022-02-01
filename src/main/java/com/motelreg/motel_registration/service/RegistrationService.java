package com.motelreg.motel_registration.service;

import com.motelreg.motel_registration.exceptions.InformationExistsException;
import com.motelreg.motel_registration.exceptions.InformationNotFoundException;
import com.motelreg.motel_registration.exceptions.NotReady;
import com.motelreg.motel_registration.model.Customer;
import com.motelreg.motel_registration.model.Registration;
import com.motelreg.motel_registration.model.Room;
import com.motelreg.motel_registration.repository.CustomerRepository;
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


    public List<Registration> getAllRegistrations() {
        System.out.println("Calling getAllRegistrations");
        return registrationRepository.findAll();
    }

    public Registration createRegistration(Registration registrationObject) {
        System.out.println("calling createRegistration");
        MyUserDetails userDetails = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication()
                .getPrincipal();
        Registration registration = registrationRepository.findByRoomNumber(registrationObject.getRoomNumber());
        Room roomId = roomRepository.findByRoomNumber(registrationObject.getRoomNumber());
        System.out.println(roomId);
        if (registration !=null) {
            throw new InformationExistsException("Registration with room number " + registration.getRoomNumber() + " already exists");
        } else {
            if (roomId.isClean() && roomId.isEmpty()) {
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
                notEmpty.setClean(false);
                notEmpty.setEmpty(false);
                RoomService.updatePartsOfRoom(roomId.getId(), notEmpty);
                registrationObject.setCustomer(customerId);
                registrationObject.setManager(userDetails.getManager());
                registrationObject.setRoom(roomId);
                return registrationRepository.save(registrationObject);
            } else {
                throw new NotReady("Room " + roomId.getRoomNumber() + " is not ready to be rented");
            }
        }
    }

    public Registration getRegistration (Long room) {
        Registration registration = registrationRepository.findByRoomNumber(room);
        if (registration != null) {
            return registration;
        } else {
            throw new InformationNotFoundException("registration belonging to room " + room + " not found");
        }
    }

    public Registration updateRegistration(Long room, Registration registrationObject) {
        Registration registration = registrationRepository.findByRoomNumber(room);
        if (registration !=null) {
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
                throw new InformationNotFoundException("Room number " + registration.getRoomNumber() + " has no registration");
            }
        }else{
            throw new InformationNotFoundException("Room number " + room + " has no registration");
        }
    }

    public Registration updatePartsOfRegistration(Long room, Registration registrationObject) {
        Registration registration = registrationRepository.findByRoomNumber(room);
        if (registration !=null) {
            System.out.println("Matching room number found");
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
