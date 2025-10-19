package org;

public class InvalidMobileNumberException extends Exception {
    public InvalidMobileNumberException() {
        super("Invalid entry");
    }
}