package com.everst.api.exceptions;

public class BadRequestExeption extends RuntimeException {

    public BadRequestExeption(String message) {
        super(message);
    }

    private static final long serialVersionUID = -5934285525213017689L;

}
