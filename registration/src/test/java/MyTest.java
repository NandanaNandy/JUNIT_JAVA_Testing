import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

import org.InvalidEmailException;
import org.InvalidFirstnameException;
import org.InvalidLastnameException;
import org.InvalidMobileNumberException;
import org.InvalidPasswordException;
import org.Registration;
import org.UserEntries;

public class MyTest {

    @BeforeAll
    public static void beforeAll() {
        System.out.println("Before Class Execution once before all tests");
    }

    @AfterAll
    public static void afterAll() {
        System.out.println("After class Execution");
    }

    @BeforeEach
    public void setUp() {
        System.out.println("Before Test Execution");
    }

    @AfterEach
    public void after() {
        System.out.println("After executed after each test");
    }

    @Test
    public void testValidateFirstName() {
        Registration userRegistration = new Registration();
        UserEntries registrationFields = new UserEntries();

        try {
            registrationFields.setFirstName("Kriti");
            userRegistration.validateFirstName(registrationFields.getFirstName());
            assertEquals("Valid first name", userRegistration.getValidationResult());
        } catch (InvalidFirstnameException e) {
            fail("Unexpected exception: " + e.getMessage());
        }
    }

    @Test
    public void testFailValidateFirstName() {
        Registration userRegistration = new Registration();
        UserEntries registrationFields = new UserEntries();

        try {
            registrationFields.setFirstName("kriti");
            userRegistration.validateFirstName(registrationFields.getFirstName());
            assertNotEquals("Valid first name", userRegistration.getValidationResult());
        } catch (InvalidFirstnameException e) {
            assertEquals("Invalid first name", userRegistration.getValidationResult());
        }
    }

    @Test
    public void testValidateLastName() {
        Registration userRegistration = new Registration();
        UserEntries registrationFields = new UserEntries();

        try {
            registrationFields.setLastName("Jaiswal");
            userRegistration.validateLastName(registrationFields.getLastName());
            assertEquals("Valid last name", userRegistration.getValidationResult());
        } catch (InvalidLastnameException e) {
            fail("Unexpected exception: " + e.getMessage());
        }
    }

    @Test
    public void testFailValidateLastName() {
        Registration userRegistration = new Registration();
        UserEntries registrationFields = new UserEntries();

        try {
            registrationFields.setLastName("jaiswal");
            userRegistration.validateLastName(registrationFields.getLastName());
            assertNotEquals("Valid last name", userRegistration.getValidationResult());
        } catch (InvalidLastnameException e) {
            assertEquals("Invalid last name", userRegistration.getValidationResult());
        }
    }

    @Test
    public void testValidateEmail() {
        Registration userRegistration = new Registration();
        UserEntries registrationFields = new UserEntries();

        try {
            registrationFields.setEmail("kriti@yahoo.com");
            userRegistration.validateEmail(registrationFields.getEmail());
            assertEquals("Valid email", userRegistration.getValidationResult());
        } catch (InvalidEmailException e) {
            fail("Unexpected exception: " + e.getMessage());
        }
    }

    @Test
    public void testFailValidateEmail() {
        Registration userRegistration = new Registration();
        UserEntries registrationFields = new UserEntries();

        try {
            registrationFields.setEmail("kriti,com");
            userRegistration.validateEmail(registrationFields.getEmail());
            assertNotEquals("Valid email", userRegistration.getValidationResult());
        } catch (InvalidEmailException e) {
            assertEquals("Invalid email", userRegistration.getValidationResult());
        }
    }

    @Test
    public void testValidateMobileNumber() {
        Registration userRegistration = new Registration();
        UserEntries registrationFields = new UserEntries();

        try {
            registrationFields.setMobileNumber("91 9919819801");
            userRegistration.validateMobileNumber(registrationFields.getMobileNumber());
            assertEquals("Valid mobile number", userRegistration.getValidationResult());
        } catch (InvalidMobileNumberException e) {
            fail("Unexpected exception: " + e.getMessage());
        }
    }

    @Test
    public void testFailValidateMobileNumber() {
        Registration userRegistration = new Registration();
        UserEntries registrationFields = new UserEntries();

        try {
            registrationFields.setMobileNumber("95647");
            userRegistration.validateMobileNumber(registrationFields.getMobileNumber());
            assertNotEquals("Valid mobile number", userRegistration.getValidationResult());
        } catch (InvalidMobileNumberException e) {
            assertEquals("Invalid mobile number", userRegistration.getValidationResult());
        }
    }

    @Test
    public void testValidatePassword() {
        Registration userRegistration = new Registration();
        UserEntries registrationFields = new UserEntries();

        try {
            registrationFields.setPassword("Kri@123ihj");
            userRegistration.validatePassword(registrationFields.getPassword());
            assertEquals("Valid password", userRegistration.getValidationResult());
        } catch (InvalidPasswordException e) {
            fail("Unexpected exception: " + e.getMessage());
        }
    }

    @Test
    public void testFailValidatePassword() {
        Registration userRegistration = new Registration();
        UserEntries registrationFields = new UserEntries();

        try {
            registrationFields.setPassword("jhghfjfn");
            userRegistration.validatePassword(registrationFields.getPassword());
            assertNotEquals("Valid password", userRegistration.getValidationResult());
        } catch (InvalidPasswordException e) {
            assertEquals("Invalid password", userRegistration.getValidationResult());
        }
    }

    @ParameterizedTest
    @ValueSource(strings = {"kriti@yahoo.com", "abc-100@yahoo.com", "abc.100@yahoo.com", "abc111@abc.com", "abc-100@abc.net"})
    void testValidateEmail(String userEmail) {
        Registration userRegistration = new Registration();
        UserEntries registrationFields = new UserEntries();

        try {
            registrationFields.setEmail(userEmail);
            userRegistration.validateEmail(registrationFields.getEmail());
            assertEquals("Valid email", userRegistration.getValidationResult());
        } catch (InvalidEmailException e) {
            fail("Unexpected exception: " + e.getMessage());
        }
    }

    @ParameterizedTest
    @ValueSource(strings = {"abc", "abc@.com.my", "abc123@gmail.a", "abc123@.com", "abc123@.com.com", ".abc@abc.com", ".abc()*@gmail.com", "abc@%*.com", "abc..2002@gmail.com"})
    void testFailValidateEmail(String userEmail) {
        Registration userRegistration = new Registration();
        UserEntries registrationFields = new UserEntries();

        try {
            registrationFields.setEmail(userEmail);
            userRegistration.validateEmail(registrationFields.getEmail());
            assertNotEquals("Valid email", userRegistration.getValidationResult());
        } catch (InvalidEmailException e) {
            assertEquals("Invalid email", userRegistration.getValidationResult());
        }
    }
}
