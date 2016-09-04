package com.podkutin.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by apodkutin on 8/7/16.
 */
@ResponseStatus(value= HttpStatus.NOT_FOUND)
public class ClientNotFoundException extends RuntimeException {

    public ClientNotFoundException(String message) {
        super(message);
    }
}
