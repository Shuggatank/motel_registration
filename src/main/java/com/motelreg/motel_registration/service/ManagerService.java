package com.motelreg.motel_registration.service;

import com.motelreg.motel_registration.exceptions.InformationExistsException;
import com.motelreg.motel_registration.model.Manager;
import com.motelreg.motel_registration.repository.ManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;


@Service
public class ManagerService {
    private ManagerRepository managerRepository;

    @Autowired
    public void setManagerRepository(ManagerRepository managerRepository) {
        this.managerRepository = managerRepository;
    }

    public Manager createManager(Manager managerObject) {
        System.out.println("service calling createManager ===>");
        if (!managerRepository.existsByName(managerObject.getName())) {
            managerObject.setPassword(passwordEncoder.encode(managerObject.getPassword()));
            return managerRepository.save(managerObject);
        } else {
            throw new InformationExistsException("manager with that name " + managerObject.getName() + "already exists");
        }
    }


    public Manager findManagerByName(String name) {
        return managerRepository.findManagerByName(name);
    }

    public ResponseEntity<?> loginManager(LoginRequest loginRequest) {
        System.out.println("service calling loginManager ==>");
        authenticationManager.authenticate(new
                UsernamePasswordAuthenticationToken(loginRequest.getName(), loginRequest.getPassword()));
        final UserDetails userDetails = userDetailsService.loadUserByUsername(loginRequest.getName());
        final String JWT = jwtUtils.generateToken(userDetails);
        return ResponseEntity.ok(new LoginResponse(JWT));
}
