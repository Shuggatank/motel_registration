package com.motelreg.motel_registration.service;

import com.motelreg.motel_registration.exceptions.InformationExistsException;
import com.motelreg.motel_registration.model.Manager;
import com.motelreg.motel_registration.model.Request.LoginRequest;
import com.motelreg.motel_registration.model.Response.LoginResponse;
import com.motelreg.motel_registration.repository.ManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class ManagerService {
    private ManagerRepository managerRepository;



    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private JWTUtils jwtUtils;

    @Autowired
    public void setManagerRepository(ManagerRepository managerRepository) {
        this.managerRepository = managerRepository;
    }

    public Manager createManager(Manager managerObject) {
        System.out.println("service calling createManager ===>");
        if (!managerRepository.existsByName(managerObject.getName())) {
            // Encodes the password that the manager sets
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
        // Authenticates the username and password
        authenticationManager.authenticate(new
                UsernamePasswordAuthenticationToken(loginRequest.getName(), loginRequest.getPassword()));
        final UserDetails userDetails = userDetailsService.loadUserByUsername(loginRequest.getName());
        // Generates a token for the manager login
        final String JWT = jwtUtils.generateToken(userDetails);
        return ResponseEntity.ok(new LoginResponse(JWT));
    }
}
