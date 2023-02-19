package com.example.ibooks.exception;

public class PasswordsDoesntMatchException extends Exception {
    public PasswordsDoesntMatchException(String message) {
        super(message);
    }
}
