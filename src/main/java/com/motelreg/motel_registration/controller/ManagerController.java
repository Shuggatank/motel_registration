package com.motelreg.motel_registration.controller;

import com.motelreg.motel_registration.model.Manager;
import com.motelreg.motel_registration.model.Request.LoginRequest;
import com.motelreg.motel_registration.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/auth/managers")
public class ManagerController {

    private ManagerService managerService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    public void setManagerService(ManagerService managerService) {
        this.managerService = managerService;
    }

    @PostMapping("/register")
    public Manager createManager(@RequestBody Manager managerObject) {
        System.out.println("calling createManager ==>");
        return managerService.createManager(managerObject);
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginManager(@RequestBody LoginRequest loginRequest) {
        System.out.println("calling loginManager ==>");
        return managerService.loginManager(loginRequest);
    }

}
