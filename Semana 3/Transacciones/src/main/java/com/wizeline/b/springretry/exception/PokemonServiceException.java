package com.wizeline.b.springretry.exception;

public class PokemonServiceException extends RuntimeException {

    public PokemonServiceException(String message) {
        super(message);
    }
}
