package com.motelreg.motel_registration.security;

import com.motelreg.motel_registration.model.Manager;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.HashSet;

public class MyUserDetails implements UserDetails {


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

    public Manager getManager() {
        return manager;
    }


    @Override
    public String getPassword() {
        return manager.getPassword();
    }

    @Override
    public String getUsername() {
        return manager.getName();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked(){
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
