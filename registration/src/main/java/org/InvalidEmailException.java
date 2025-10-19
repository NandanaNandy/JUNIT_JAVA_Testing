package org;

public class InvalidEmailException extends Exception {
    public InvalidEmailException() {
        super("Invalid entry");
    }
}
