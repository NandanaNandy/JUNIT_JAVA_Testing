package org;

public class InvalidPasswordException extends Exception {
    public InvalidPasswordException() {
        super("Invalid entry");
    }
}

