package com.motelreg.motel_registration.security;

import com.motelreg.motel_registration.model.Manager;

public class MyUserDetails implements UserDetails{

    private Manager manager;
    private String name;
    private String password;

    public MyUserDetails(Manager manager) {
        this.manager = manager;
    }


}
