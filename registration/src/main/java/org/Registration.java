package org;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Registration {
    private String validationResult;

    // Use Case 1: Validate First Name
    public void validateFirstName(String firstName) throws InvalidFirstnameException {
        String nameRegex = "[A-Z][a-zA-Z]{2,}";
        Pattern pattern = Pattern.compile(nameRegex);
        Matcher matcher = pattern.matcher(firstName);

        if (matcher.matches()) {
            System.out.println("Valid first name");
            validationResult = "Valid first name";
        } else {
            System.out.println("Invalid first name");
            validationResult = "Invalid first name";
            throw new InvalidFirstnameException();
        }
    }

    // Use Case 2 : Validate Last name
    public void validateLastName(String lastName) throws InvalidLastnameException {
        String nameRegex = "[A-Z][a-zA-Z]{2,}";
        Pattern pattern = Pattern.compile(nameRegex);
        Matcher matcher = pattern.matcher(lastName);

        if (matcher.matches()) {
            System.out.println("Valid last name");
            validationResult = "Valid last name";
        } else {
            System.out.println("Invalid last name");
            validationResult = "Invalid last name";
            throw new InvalidLastnameException();
        }
    }

    // Use Case 3 : Validate email
    public void validateEmail(String email) throws InvalidEmailException {
        String emailRegex = "([a-zA-Z0-9_\\-]+)(\\.[a-zA-Z0-9_\\-]+)*@([a-zA-Z]+)(\\.[a-zA-Z]{2,})";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);

        if (matcher.matches()) {
            System.out.println("Valid email");
            validationResult = "Valid email";
        } else {
            System.out.println("Invalid email");
            validationResult = "Invalid email";
            throw new InvalidEmailException();
        }
    }

    // Use Case 4: Validate Mobile Format
    public void validateMobileNumber(String mobileNumber) throws InvalidMobileNumberException {

        String mobileRegex = "[0-9]{2}\\s[0-9]{10}";
        Pattern pattern = Pattern.compile(mobileRegex);
        Matcher matcher = pattern.matcher(mobileNumber);

        if (matcher.matches()) {
            System.out.println("Valid mobile number");
            validationResult = "Valid mobile number";
        } else {
            System.out.println("Invalid mobile number");
            validationResult = "Invalid mobile number";
            throw new InvalidMobileNumberException();
        }
    }

    // Use Case 5.-8: Validate password format
    public void validatePassword(String password) throws InvalidPasswordException {
        String passwordRegex = "(?=.*[A-Z])(?=.*\\d)(?=.*[!@#$%^&*()-_+=])[A-Za-z\\d]*[!@#$%^&*()-_+=][A-Za-z\\d!@#$%^&*()-_+=]{8,}";
        Pattern pattern = Pattern.compile(passwordRegex);
        Matcher matcher = pattern.matcher(password);

        if (matcher.matches()) {
            System.out.println("Valid password");
            validationResult = "Valid password";
        } else {
            System.out.println("Invalid password");
            validationResult = "Invalid password";
            throw new InvalidPasswordException();
        }
    }

    public String getValidationResult() {
        return validationResult;
    }
}

