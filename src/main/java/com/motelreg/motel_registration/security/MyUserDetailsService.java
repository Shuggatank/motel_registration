package com.motelreg.motel_registration.security;

import com.motelreg.motel_registration.model.Manager;
import com.motelreg.motel_registration.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

//@Service
//public class MyUserDetailsService implements UserDetailsService {
//    private ManagerService managerService;
//
//    @Autowired
//    public void setManagerService(ManagerService managerService) {
//        this.managerService = managerService;
//    }
//
//    @Override
//    public UserDetails loadManagerByName(String name) throws UsernameNotFoundException {
//        Manager manager = managerService.findManagerByName(name);
//        return new MyUserDetails(manager);
//    }
//}

@Service
public class MyUserDetailsService implements UserDetailsService {
    private ManagerService managerService;

    @Autowired
    public void setManagerService(ManagerService managerService) {
        this.managerService = managerService;
    }


    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        Manager manager = managerService.findManagerByName(name);
        return new MyUserDetails(manager);
    }
}
