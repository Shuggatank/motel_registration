package com.motelreg.motel_registration.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class InformationNotFoundException extends RuntimeException{
    public InformationNotFoundException(String message) {
        super(message);
    }
}
