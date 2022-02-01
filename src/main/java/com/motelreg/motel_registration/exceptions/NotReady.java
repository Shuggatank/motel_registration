package com.motelreg.motel_registration.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNAVAILABLE_FOR_LEGAL_REASONS)
public class NotReady extends RuntimeException{
    public NotReady(String message) {
        super(message);
    }
}
