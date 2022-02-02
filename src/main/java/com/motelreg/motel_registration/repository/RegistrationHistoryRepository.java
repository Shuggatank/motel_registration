package com.motelreg.motel_registration.repository;

import com.motelreg.motel_registration.model.RegistrationHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistrationHistoryRepository extends JpaRepository <RegistrationHistory, Long>{

}
