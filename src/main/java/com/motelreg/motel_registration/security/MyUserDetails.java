package com.motelreg.motel_registration.security;

import com.motelreg.motel_registration.model.Manager;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;
import java.util.HashSet;

public class MyUserDetails implements UserDetails{

    private Manager manager;
    private String name;
    private String password;

    public MyUserDetails(Manager manager) {
        this.manager = manager;
    }

    @Override
    public Collection <? extends GrantedAuthority> getAuthorities() {
        return new HashSet<GrantedAuthority>();
    }
}
