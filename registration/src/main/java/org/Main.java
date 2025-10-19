package org;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
     
        Registration userRegistration = new Registration();
        UserEntries entry = new UserEntries();
        Scanner scanner = new Scanner(System.in);
        try {
            // UC-1
            System.out.print("Enter first name: ");
            String firstName = scanner.next();
    
            entry.setFirstName(firstName);
            userRegistration.validateFirstName(entry.getFirstName());
        } catch (InvalidFirstnameException e) {
            System.out.println(e.getMessage());
        }
    
        
       //UC-2
       System.out.print("Enter last name : ");
       String lastName = scanner.next();

       entry.setLastName(lastName);
       try {
        userRegistration.validateLastName(entry.getLastName());
    } catch (InvalidLastnameException e) {
     System.out.println(e.getMessage());

    }

       //UC-3
       System.out.print("Enter email : ");
       String email = scanner.next();

        entry.setEmail(email);
        try {
            userRegistration.validateEmail(entry.getEmail());
        } catch (InvalidEmailException e) {
        System.out.println(e.getMessage());
        }
     
       //UC-4
       System.out.print("Enter mobile number : ");
       String mobileNumber = scanner.next();

        entry.setMobileNumber(mobileNumber);;
        try {
            userRegistration.validateMobileNumber(entry.getMobileNumber());
        } catch (InvalidMobileNumberException e) {
        System.out.println(e.getMessage());

        }

        //UC-5-8
       System.out.print("Enter password: ");
       String password = scanner.next();

        entry.setPassword(password);;
        try {
            userRegistration.validatePassword(password);
        } catch (InvalidPasswordException e) {
        System.out.println(e.getMessage());

        }

        //UC-9
        for (String em : getEmailSamples()) {
            UserEntries registrationFields = new UserEntries();
            registrationFields.setEmail(em);

            System.out.println("Validating email: " + em);
            try {
                userRegistration.validateEmail(registrationFields.getEmail());
            } catch (InvalidEmailException e) {
            System.out.println(e.getMessage());

            }
            System.out.println("-----------------------------");
        }
        scanner.close();
    }

    private static String[] getEmailSamples() {
        return new String[]{
                "abc@yahoo.com",
                "abc-100@yahoo.com",
                "abc.100@yahoo.com",
                "abc111@abc.com",
                "abc-100@abc.net",
                "abc.100@abc.com.au",
                "abc@1.com",
                "abc+100@gmail.com",
                "abc",
                "abc@.com.my",
                "abc123@gmail.a",
                "abc123@.com",
                "abc123@.com.com",
                ".abc@abc.com",
                "abc()*@gmail.com",
                "abc@%*.com",
                "abc..2002@gmail.com",
                "abc.@gmail.com",
                "abc@abc@gmail.com",
                "abc@gmail.com.1a",
                "abc@gmail.com.aa.au"
        };
}
}