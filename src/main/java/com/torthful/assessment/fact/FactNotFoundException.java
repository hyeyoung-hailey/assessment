package com.torthful.assessment.fact;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class FactNotFoundException extends RuntimeException {
    public FactNotFoundException(String message) {
        super(message);
    }
}
