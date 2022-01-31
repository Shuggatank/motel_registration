package com.motelreg.motel_registration.service;

import com.motelreg.motel_registration.model.Manager;
import com.motelreg.motel_registration.repository.ManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManagerService {
    private ManagerRepository managerRepository;

    @Autowired
    public void setManagerRepository(ManagerRepository managerRepository) {
        this.managerRepository = managerRepository;
    }

    public List<Manager> getManagers(){
        System.out.println("calling getManagers");
        return managerRepository.findAll();
    }


}
