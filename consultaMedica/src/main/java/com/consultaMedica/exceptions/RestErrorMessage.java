package com.consultaMedica.exceptions;

import org.springframework.http.HttpStatus;

import java.time.Instant;

public class RestErrorMessage {
    private HttpStatus status;
    private String message;
    private Instant instant;

    public RestErrorMessage(HttpStatus status, String message, Instant instant) {
        this.status = status;
        this.message = message;
        this.instant = instant;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Instant getInstant() {
        return instant;
    }

    public void setInstant(Instant instant) {
        this.instant = instant;
    }
}
