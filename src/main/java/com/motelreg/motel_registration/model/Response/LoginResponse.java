package com.motelreg.motel_registration.model.Response;

public class LoginResponse {
    private String JWT;
    // Gets Json Web Token for the user
    public LoginResponse(String JWT) {
        this.JWT = JWT;
    }

    public String getJWT() {
        return JWT;
    }

    public void setJWT(String JWT) {
        this.JWT = JWT;
    }
}
