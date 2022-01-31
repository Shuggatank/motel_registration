package com.motelreg.motel_registration.controller;

import com.motelreg.motel_registration.model.Manager;
import com.motelreg.motel_registration.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ManagerController {

    private ManagerService managerService;

    @Autowired
    public void setManagerService(ManagerService managerService) {
        this.managerService = managerService;
    }

    @GetMapping("/managers")
    public List<Manager> getManagers() {
        System.out.println("getting all managers");
        return managerService.getManagers();
    }
}
