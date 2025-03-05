package com.example.demo.exception;

public class UsuarioNotFoundException extends RuntimeException {
    public UsuarioNotFoundException(Long message) {
        super(message);
    }
}
