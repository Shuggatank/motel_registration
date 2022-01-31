package com.motelreg.motel_registration.repository;

import com.motelreg.motel_registration.model.Registration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistrationRepository extends JpaRepository<Registration, Long> {

    Registration findByCustomerIdNumber(String customerIdNumber);

    Registration findByRoomNumber(int roomNumber);

}
